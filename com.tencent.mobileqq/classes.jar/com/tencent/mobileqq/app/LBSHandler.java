package com.tencent.mobileqq.app;

import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RespGetRecommender;
import NeighborSvc.RespGetSwitches;
import NeighborSvc.RespSetStateSwitch;
import NeighborSvc.Switch;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.kingkong.DataReport;
import com.tencent.mobileqq.facetoface.NearbyUser;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearpeople.api.INearbyRecommenderUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsReq;
import com.tencent.proto.lbsshare.LBSShare.LocationReq;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.GPS;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.GroupInfo;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.ReqBody;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.RspBody;
import tencent.im.oidb.cmd0x9c0.cmd0x9c0.NearbyUser;
import tencent.im.oidb.cmd0x9c0.cmd0x9c0.RspBody;
import tencent.im.oidb.cmd0x9c1.cmd0x9c1.ReqBody;
import tencent.im.oidb.cmd0x9c1.cmd0x9c1.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUser;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUserNotify;

public class LBSHandler
  extends BusinessHandler
{
  public static String a;
  public QQAppInterface a;
  
  public LBSHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static Dialog a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = DialogUtil.a(paramContext, 230, null, paramString, 2131690728, 2131718751, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131365621)).setVisibility(8);
      paramOnClickListener1 = (TextView)paramString.findViewById(2131365644);
      paramOnClickListener2 = new LinearLayout.LayoutParams(-2, -2);
      paramOnClickListener2.gravity = 17;
      paramOnClickListener1.setLayoutParams(paramOnClickListener2);
      paramOnClickListener1.setMinHeight(DisplayUtil.a(paramContext, 35.0F));
      paramOnClickListener1.setGravity(17);
    }
    return paramString;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    boolean bool2 = false;
    boolean bool1 = paramToServiceMsg.getBoolean("k_be_share", false);
    if ((paramObject != null) && (((RespSetStateSwitch)paramObject).stHeader.eReplyCode == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setVisibilityForStatus(bool1, true);
      bool2 = true;
    }
    else
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLocVisibilityForStatus();
    }
    notifyUI(9, bool2, Boolean.valueOf(bool1));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    boolean bool = paramQQAppInterface.getMessageFacade().a(paramString, 1001);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("hasReply:");
      paramQQAppInterface.append(bool);
      QLog.d("LBSHandlerQ.nearby.follow", 2, paramQQAppInterface.toString());
    }
    return bool;
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "handleGetNearbyRecommender");
    }
    if ((paramObject instanceof Object[]))
    {
      paramFromServiceMsg = (Object[])paramObject;
      Object localObject = (NeighborComm.RespHeader)paramFromServiceMsg[0];
      RespGetRecommender localRespGetRecommender = (RespGetRecommender)paramFromServiceMsg[1];
      boolean bool = QLog.isColorLevel();
      paramObject = "null";
      if (bool)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleGetNearbyRecommender---->respHeader=");
        localStringBuilder.append(localObject);
        localStringBuilder.append("|error code=");
        if (localObject == null) {
          paramFromServiceMsg = "null";
        } else {
          paramFromServiceMsg = Integer.valueOf(((NeighborComm.RespHeader)localObject).eReplyCode);
        }
        localStringBuilder.append(paramFromServiceMsg);
        QLog.d("LBSHandler", 2, localStringBuilder.toString());
      }
      if ((localObject != null) && (((NeighborComm.RespHeader)localObject).eReplyCode == 0))
      {
        int j = paramToServiceMsg.extraData.getInt("timingType", -1);
        if ((localRespGetRecommender != null) && (localRespGetRecommender.vEncounterInfos != null) && (localRespGetRecommender.vEncounterInfos.size() > 0))
        {
          localObject = localRespGetRecommender.vEncounterInfos;
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleGetNearbyRecommender---->RespGetRecommender.vEncounterInfos size=");
            if (localObject == null) {
              paramFromServiceMsg = paramObject;
            } else {
              paramFromServiceMsg = Integer.valueOf(((List)localObject).size());
            }
            paramToServiceMsg.append(paramFromServiceMsg);
            paramToServiceMsg.append(",resasonType=");
            paramToServiceMsg.append(localRespGetRecommender.eReasonType);
            QLog.d("LBSHandler", 2, paramToServiceMsg.toString());
          }
          paramFromServiceMsg = new ArrayList();
          paramFromServiceMsg.addAll((Collection)localObject);
          if (j == 0) {
            ((INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class)).addNearbyRecommenderMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRespGetRecommender.strBrief, localRespGetRecommender.uRecommendTime);
          }
          ((INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class)).storeNearbyRecommenderList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), getCurrentAccountUin(), paramFromServiceMsg);
          notifyUI(27, true, new Object[] { localObject, Integer.valueOf(j) });
          if (localObject != null)
          {
            paramFromServiceMsg = "";
            int i = 0;
            for (;;)
            {
              paramToServiceMsg = paramFromServiceMsg;
              if (i >= ((List)localObject).size()) {
                break;
              }
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append(paramFromServiceMsg);
              paramToServiceMsg.append(Long.toString(((RespEncounterInfo)((List)localObject).get(i)).lEctID));
              paramToServiceMsg.append(";");
              paramFromServiceMsg = paramToServiceMsg.toString();
              i += 1;
            }
          }
          paramToServiceMsg = "";
          if (!"".equals(paramToServiceMsg)) {
            paramFromServiceMsg = paramToServiceMsg.substring(0, paramToServiceMsg.length() - 1);
          } else {
            paramFromServiceMsg = paramToServiceMsg;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055FA", "0X80055FA", 0, 0, Integer.toString(localRespGetRecommender.eReasonType), "", paramFromServiceMsg, "");
        }
        else
        {
          notifyUI(27, false, null);
          paramFromServiceMsg = "";
        }
        paramToServiceMsg = new Bundle();
        if (localRespGetRecommender != null)
        {
          paramObject = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
          paramToServiceMsg.putInt("key_login_pull_interval", localRespGetRecommender.iOuterInterval);
          paramObject = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
          paramToServiceMsg.putInt("key_msgbox_pull_interval", localRespGetRecommender.iInnerInterval);
          paramObject = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
          paramToServiceMsg.putInt("key_expiretime", localRespGetRecommender.iExpiretime);
          paramObject = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
          paramToServiceMsg.putString("key_nearbyrecommender_title", localRespGetRecommender.strTitle);
          paramObject = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
          paramToServiceMsg.putInt("key_nearbyrecommender_reasontype", localRespGetRecommender.eReasonType);
        }
        paramObject = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
        paramToServiceMsg.putString("key_nearbyrecommender_uins", paramFromServiceMsg);
        if (j == 0)
        {
          paramFromServiceMsg = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
          paramToServiceMsg.putLong("key_login_pull_time", System.currentTimeMillis());
        }
        else if (j == 1)
        {
          paramFromServiceMsg = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
          paramToServiceMsg.putLong("key_msgbox_pull_time", System.currentTimeMillis());
        }
        ((INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class)).updateConfigs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg);
        return;
      }
      notifyUI(27, false, null);
      return;
    }
    notifyUI(27, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject != null)
    {
      paramToServiceMsg = (RespGetSwitches)paramObject;
      if (paramToServiceMsg.stHeader.eReplyCode == 0)
      {
        paramToServiceMsg = paramToServiceMsg.switches.iterator();
        while (paramToServiceMsg.hasNext())
        {
          paramFromServiceMsg = (Switch)paramToServiceMsg.next();
          boolean bool;
          if (paramFromServiceMsg.type == 64)
          {
            paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (paramFromServiceMsg.is_open == 1) {
              bool = true;
            } else {
              bool = false;
            }
            paramObject.setVisibilityForStatus(bool, true);
          }
          else if (paramFromServiceMsg.type == 1)
          {
            paramObject = (INearbySPUtil)QRoute.api(INearbySPUtil.class);
            String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
            if (paramFromServiceMsg.is_open == 1) {
              bool = true;
            } else {
              bool = false;
            }
            paramObject.setVisibilityForPeople(str, bool);
          }
          int i = paramFromServiceMsg.type;
          if (paramFromServiceMsg.is_open == 1) {
            bool = true;
          } else {
            bool = false;
          }
          notifyUI(10, true, new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
        }
      }
    }
    notifyUI(10, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramFromServiceMsg = null;
    paramToServiceMsg = null;
    Object localObject = null;
    String str = null;
    int j = -1;
    if (bool1) {}
    for (;;)
    {
      int k;
      try
      {
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        if (((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get() != 0) {
          break label761;
        }
        bool1 = true;
        if (bool1)
        {
          paramFromServiceMsg = new cmd0x9c0.RspBody();
          paramFromServiceMsg.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
          if (paramFromServiceMsg.uint32_req_interval.has()) {
            i = paramFromServiceMsg.uint32_req_interval.get();
          } else {
            i = -1;
          }
          try
          {
            if (paramFromServiceMsg.uint32_heartbeat_interval.has()) {
              j = paramFromServiceMsg.uint32_heartbeat_interval.get();
            }
            try
            {
              localObject = paramFromServiceMsg.rpt_nearby_user_list.get();
              if ((localObject == null) || (((List)localObject).size() <= 0))
              {
                QLog.d("LBSHandler", 1, "rcv nearbyUserList is null!");
                bool1 = false;
              }
              if (bool1)
              {
                paramFromServiceMsg = new ArrayList();
                k = 0;
                try
                {
                  if (k < ((List)localObject).size())
                  {
                    bool2 = ((cmd0x9c0.NearbyUser)((List)localObject).get(k)).uint64_nearby_uin.has();
                    str = "";
                    if (!bool2) {
                      break label767;
                    }
                    paramToServiceMsg = String.valueOf(((cmd0x9c0.NearbyUser)((List)localObject).get(k)).uint64_nearby_uin.get());
                    if ((!((cmd0x9c0.NearbyUser)((List)localObject).get(k)).uint32_is_frd.has()) || (((cmd0x9c0.NearbyUser)((List)localObject).get(k)).uint32_is_frd.get() != 1)) {
                      break label773;
                    }
                    bool2 = true;
                    if (!((cmd0x9c0.NearbyUser)((List)localObject).get(k)).bytes_remark.has()) {
                      break label779;
                    }
                    paramObject = ((cmd0x9c0.NearbyUser)((List)localObject).get(k)).bytes_remark.get().toStringUtf8();
                    if (((cmd0x9c0.NearbyUser)((List)localObject).get(k)).bytes_nick.has()) {
                      str = ((cmd0x9c0.NearbyUser)((List)localObject).get(k)).bytes_nick.get().toStringUtf8();
                    }
                    if (QLog.isColorLevel())
                    {
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append("faceTofaceNearbyUser: i: ");
                      localStringBuilder.append(k);
                      localStringBuilder.append(", nearbyUin: ");
                      localStringBuilder.append(paramToServiceMsg);
                      localStringBuilder.append(", isFriend: ");
                      localStringBuilder.append(bool2);
                      localStringBuilder.append(", remark: ");
                      localStringBuilder.append(paramObject);
                      localStringBuilder.append(", nick: ");
                      localStringBuilder.append(str);
                      QLog.d("LBSHandler", 2, localStringBuilder.toString());
                    }
                    if (TextUtils.isEmpty(paramToServiceMsg)) {
                      break label785;
                    }
                    paramFromServiceMsg.add(new NearbyUser(paramToServiceMsg, bool2, paramObject, str));
                    break label785;
                  }
                  paramToServiceMsg = paramFromServiceMsg;
                  if (paramFromServiceMsg.size() > 0) {
                    continue;
                  }
                  QLog.d("LBSHandler", 1, "faceTofaceNearbyUserList is empty!");
                  bool1 = false;
                  paramToServiceMsg = paramFromServiceMsg;
                }
                catch (Exception paramObject)
                {
                  paramToServiceMsg = paramFromServiceMsg;
                  paramFromServiceMsg = paramObject;
                  continue;
                }
              }
              else
              {
                paramToServiceMsg = null;
              }
              k = i;
              i = j;
              j = k;
            }
            catch (Exception paramFromServiceMsg)
            {
              paramToServiceMsg = str;
              k = j;
              j = i;
              i = k;
              continue;
            }
            paramObject = new StringBuilder();
          }
          catch (Exception paramFromServiceMsg)
          {
            j = i;
          }
        }
        else
        {
          paramObject.append("rspFacetoFaceAddFriendReg: resultCode:");
          paramObject.append(((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get());
          QLog.d("LBSHandler", 1, paramObject.toString());
          i = -1;
          paramToServiceMsg = paramFromServiceMsg;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        i = -1;
        paramObject = new StringBuilder();
        paramObject.append("rspFacetoFaceAddFriendReg Exception ");
        paramObject.append(paramFromServiceMsg.getMessage());
        QLog.d("LBSHandler", 1, paramObject.toString());
        bool1 = false;
      }
      int i = -1;
      paramToServiceMsg = (ToServiceMsg)localObject;
      notifyUI(25, bool1, new Object[] { paramToServiceMsg, Integer.valueOf(j), Integer.valueOf(i) });
      return;
      label761:
      bool1 = false;
      continue;
      label767:
      paramToServiceMsg = "";
      continue;
      label773:
      boolean bool2 = false;
      continue;
      label779:
      paramObject = "";
      continue;
      label785:
      k += 1;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("currentAccountUin");
    if (bool1) {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() == 0)
        {
          bool1 = bool3;
          if (bool1)
          {
            paramObject = new cmd0x9c1.RspBody();
            paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            if (!paramObject.uint64_uin.has()) {
              break label344;
            }
            paramToServiceMsg = String.valueOf(paramObject.uint64_uin.get());
            label135:
            if (!QLog.isColorLevel()) {
              break label350;
            }
            paramObject = new StringBuilder();
            paramObject.append("rspFacetoFaceAddFriendUnreg RspUin ");
            paramObject.append(paramToServiceMsg);
            paramObject.append(" ReqUin ");
            paramObject.append(paramFromServiceMsg);
            QLog.d("LBSHandler", 2, paramObject.toString());
            break label350;
          }
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("rspFacetoFaceAddFriendUnreg  fail resultCode : ");
            paramFromServiceMsg.append(paramToServiceMsg.uint32_result.get());
            QLog.d("LBSHandler", 2, paramFromServiceMsg.toString());
            bool1 = bool2;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("rspFacetoFaceAddFriendUnreg Exception ");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.d("LBSHandler", 2, paramFromServiceMsg.toString());
          bool1 = bool2;
        }
      }
    }
    label344:
    label350:
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("rspFacetoFaceAddFriendUnreg  isSuccess ");
        paramToServiceMsg.append(bool1);
        QLog.d("LBSHandler", 2, paramToServiceMsg.toString());
      }
      return;
      bool1 = false;
      break;
      paramToServiceMsg = "";
      break label135;
    }
  }
  
  public void a()
  {
    send(new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NeighborSvc.ReqGetSwitches"));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNearbyRecommender| timingType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("LBSHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NeighborRecommender.ReqGetRecommender");
    ((ToServiceMsg)localObject).extraData.putInt("timingType", paramInt);
    send((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getNewNearbyTroops lat = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" lon = ");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("LBSHandler", 2, ((StringBuilder)localObject1).toString());
    }
    cmd0x7f5.ReqBody localReqBody = new cmd0x7f5.ReqBody();
    localReqBody.uint32_max_count.set(1);
    localReqBody.uint32_max_distance.set(1000);
    localReqBody.uint32_loc_type.set(0);
    Object localObject1 = BaseApplicationImpl.getContext();
    for (;;)
    {
      try
      {
        if (NetworkUtil.isWifiConnected((Context)localObject1))
        {
          localObject1 = (WifiManager)((Context)localObject1).getSystemService("wifi");
          localObject3 = ((WifiManager)localObject1).getConnectionInfo().getBSSID();
          localReqBody.bytes_route_mac.set(ByteStringMicro.copyFromUtf8((String)localObject3));
          localReqBody.uint32_ipv4.set(((WifiManager)localObject1).getConnectionInfo().getIpAddress());
        }
        else if (NetworkUtil.is3Gor4G((Context)localObject1))
        {
          localObject3 = jdField_a_of_type_JavaLangString;
          localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject1 = DataReport.k();
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label426;
          }
          localObject3 = ((String)localObject1).split(Pattern.quote("."));
          int k = localObject3.length;
          int j = 0;
          i = 0;
          if (j < k)
          {
            i = i << 8 | Integer.parseInt(localObject3[j]);
            j += 1;
            continue;
          }
          jdField_a_of_type_JavaLangString = (String)localObject1;
          if (i != 0) {
            localReqBody.uint32_ipv4.set(i);
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject2 = new cmd0x7f5.GPS();
      ((cmd0x7f5.GPS)localObject2).uint32_latitude.set(paramInt1);
      ((cmd0x7f5.GPS)localObject2).uint32_longitude.set(paramInt2);
      ((cmd0x7f5.GPS)localObject2).bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
      ((cmd0x7f5.GPS)localObject2).uint32_client.set(2);
      localReqBody.msg_gps.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2037);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      Object localObject3 = createToServiceMsg("OidbSvc.0x7f5_1");
      ((ToServiceMsg)localObject3).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      sendPbReq((ToServiceMsg)localObject3);
      return;
      label426:
      int i = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0) && (paramInt3 >= 0))
    {
      if (paramInt3 > 1) {
        return;
      }
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "LbsShareSvr.nearby_shops");
      LBSShare.NearByShopsReq localNearByShopsReq = new LBSShare.NearByShopsReq();
      localNearByShopsReq.lat.set(paramInt1);
      localNearByShopsReq.lng.set(paramInt2);
      localNearByShopsReq.coordinate.set(paramInt3);
      localNearByShopsReq.begin.set(paramInt4);
      localNearByShopsReq.limit.set(paramInt5);
      localNearByShopsReq.version.set(1);
      Bundle localBundle = new Bundle();
      localBundle.putInt("latitude", paramInt1);
      localBundle.putInt("longitude", paramInt2);
      localBundle.putInt("coordinate", paramInt3);
      localBundle.putInt("begin", paramInt4);
      localBundle.putInt("count", paramInt5);
      localToServiceMsg.extraData.putBundle("req", localBundle);
      localToServiceMsg.putWupBuffer(localNearByShopsReq.toByteArray());
      sendPbReq(localToServiceMsg);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0) && (paramInt3 >= 0) && (paramInt3 <= 1) && (paramInt4 >= 0) && (paramInt5 >= 0))
    {
      if (paramInt5 > 100) {
        return;
      }
      Object localObject = "";
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "LbsShareSvr.location");
      LBSShare.LocationReq localLocationReq = new LBSShare.LocationReq();
      localLocationReq.lat.set(paramInt1);
      localLocationReq.lng.set(paramInt2);
      localLocationReq.coordinate.set(paramInt3);
      localLocationReq.keyword.set(str);
      localLocationReq.category.set(paramString1);
      localLocationReq.page.set(paramInt4);
      localLocationReq.count.set(paramInt5);
      localLocationReq.requireMyLbs.set(paramInt6);
      paramString2 = DeviceInfoUtil.a();
      if (paramString2 == null) {
        paramString2 = (String)localObject;
      }
      localLocationReq.imei.set(paramString2);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("latitude", paramInt1);
      ((Bundle)localObject).putInt("longitude", paramInt2);
      ((Bundle)localObject).putInt("coordinate", paramInt3);
      ((Bundle)localObject).putString("keyword", str);
      ((Bundle)localObject).putString("category", paramString1);
      ((Bundle)localObject).putInt("page", paramInt4);
      ((Bundle)localObject).putInt("count", paramInt5);
      ((Bundle)localObject).putInt("requireMyLbs", paramInt6);
      ((Bundle)localObject).putString("imei", paramString2);
      localToServiceMsg.extraData.putBundle("req", (Bundle)localObject);
      localToServiceMsg.putWupBuffer(localLocationReq.toByteArray());
      sendPbReq(localToServiceMsg);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NearbyGroup.ReqGetAreaList");
    localToServiceMsg.extraData.putInt("lat", paramInt1);
    localToServiceMsg.extraData.putInt("lon", paramInt2);
    localToServiceMsg.extraData.putInt("radius", paramInt3);
    localToServiceMsg.extraData.putBoolean("clickable", paramBoolean);
    send(localToServiceMsg);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "handleGetNewNearbyTroops");
    }
    boolean bool2 = false;
    boolean bool1;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          break label333;
        }
        bool1 = true;
        if (bool1)
        {
          paramObject = new cmd0x7f5.RspBody();
          paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          int i = paramObject.uint32_recruit_number.get();
          paramToServiceMsg = null;
          paramObject = paramObject.rpt_group_info.get();
          paramFromServiceMsg = paramToServiceMsg;
          if (paramObject != null)
          {
            paramFromServiceMsg = paramToServiceMsg;
            if (paramObject.size() > 0) {
              paramFromServiceMsg = (cmd0x7f5.GroupInfo)paramObject.get(0);
            }
          }
          notifyUI(28, bool1, new Object[] { Integer.valueOf(i), paramFromServiceMsg });
        }
        else
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleGetNewNearbyTroops  fail resultCode : ");
            paramToServiceMsg.append(paramFromServiceMsg.uint32_result.get());
            QLog.d("LBSHandler", 2, paramToServiceMsg.toString());
            bool1 = bool2;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleGetNewNearbyTroops Exception ");
          paramToServiceMsg.append(paramFromServiceMsg.getMessage());
          QLog.d("LBSHandler", 2, paramToServiceMsg.toString());
          bool1 = bool2;
        }
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetNewNearbyTroops  isSuccess ");
        paramFromServiceMsg.append(bool1);
        QLog.d("LBSHandler", 2, paramFromServiceMsg.toString());
      }
      return;
      label333:
      bool1 = false;
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = new cmd0x9c1.ReqBody();
    ((cmd0x9c1.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2497);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x9c1.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x9c1_0");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("currentAccountUin", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "Face2FaceAddFriendActivity reqFacetoFaceAddFriendUnreg");
    }
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "LbsShareSvr.get_shops_by_ids");
    LBSShare.GetShopsByIdsReq localGetShopsByIdsReq = new LBSShare.GetShopsByIdsReq();
    localGetShopsByIdsReq.ids.set(paramArrayList);
    localToServiceMsg.putWupBuffer(localGetShopsByIdsReq.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  /* Error */
  public void a(List<tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.GroupInfo> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: ifnull +308 -> 311
    //   6: aload_1
    //   7: invokeinterface 196 1 0
    //   12: ifne +6 -> 18
    //   15: goto +296 -> 311
    //   18: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +41 -> 62
    //   24: new 127	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   31: astore_3
    //   32: aload_3
    //   33: ldc_w 840
    //   36: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: aload_1
    //   42: invokeinterface 196 1 0
    //   47: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: ldc_w 842
    //   54: iconst_2
    //   55: aload_3
    //   56: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 17	com/tencent/mobileqq/app/LBSHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   66: aload_0
    //   67: invokevirtual 235	com/tencent/mobileqq/app/LBSHandler:getCurrentAccountUin	()Ljava/lang/String;
    //   70: invokevirtual 846	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	(Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   73: invokevirtual 852	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   76: astore 4
    //   78: aload 4
    //   80: invokevirtual 858	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   83: astore_3
    //   84: aload_3
    //   85: invokevirtual 862	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   88: iload_2
    //   89: aload_1
    //   90: invokeinterface 196 1 0
    //   95: if_icmpge +131 -> 226
    //   98: aload_1
    //   99: iload_2
    //   100: invokeinterface 247 2 0
    //   105: checkcast 864	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$GroupInfo
    //   108: astore 5
    //   110: new 866	com/tencent/mobileqq/data/NearbyRecommendTroop
    //   113: dup
    //   114: invokespecial 867	com/tencent/mobileqq/data/NearbyRecommendTroop:<init>	()V
    //   117: astore 6
    //   119: new 127	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   126: astore 7
    //   128: aload 7
    //   130: aload 5
    //   132: getfield 870	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$GroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   135: invokevirtual 446	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   138: invokevirtual 873	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 7
    //   144: ldc 243
    //   146: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 6
    //   152: aload 7
    //   154: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: putfield 876	com/tencent/mobileqq/data/NearbyRecommendTroop:uin	Ljava/lang/String;
    //   160: aload 6
    //   162: aload 5
    //   164: getfield 879	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$GroupInfo:str_group_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   167: invokevirtual 881	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   170: putfield 884	com/tencent/mobileqq/data/NearbyRecommendTroop:name	Ljava/lang/String;
    //   173: aload 6
    //   175: aload 5
    //   177: getfield 887	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$GroupInfo:str_group_memo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   180: invokevirtual 881	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   183: putfield 890	com/tencent/mobileqq/data/NearbyRecommendTroop:intro	Ljava/lang/String;
    //   186: aload 6
    //   188: aload 5
    //   190: getfield 893	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$GroupInfo:uint32_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   193: invokevirtual 396	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   196: putfield 896	com/tencent/mobileqq/data/NearbyRecommendTroop:memberNum	I
    //   199: aload 6
    //   201: aload 5
    //   203: getfield 899	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$GroupInfo:uint32_group_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   206: invokevirtual 396	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   209: putfield 902	com/tencent/mobileqq/data/NearbyRecommendTroop:troopType	I
    //   212: aload 4
    //   214: aload 6
    //   216: invokevirtual 906	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   219: iload_2
    //   220: iconst_1
    //   221: iadd
    //   222: istore_2
    //   223: goto -135 -> 88
    //   226: aload_3
    //   227: invokevirtual 909	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   230: aload_0
    //   231: bipush 19
    //   233: iconst_1
    //   234: aload_1
    //   235: invokeinterface 196 1 0
    //   240: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: invokevirtual 110	com/tencent/mobileqq/app/LBSHandler:notifyUI	(IZLjava/lang/Object;)V
    //   246: goto +54 -> 300
    //   249: astore_1
    //   250: goto +55 -> 305
    //   253: astore_1
    //   254: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +43 -> 300
    //   260: new 127	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   267: astore 4
    //   269: aload 4
    //   271: ldc_w 911
    //   274: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 4
    //   280: aload_1
    //   281: invokevirtual 912	java/lang/Exception:toString	()Ljava/lang/String;
    //   284: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: ldc_w 914
    //   291: iconst_2
    //   292: aload 4
    //   294: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload_3
    //   301: invokevirtual 917	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   304: return
    //   305: aload_3
    //   306: invokevirtual 917	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   309: aload_1
    //   310: athrow
    //   311: aload_0
    //   312: bipush 19
    //   314: iconst_0
    //   315: iconst_0
    //   316: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   319: invokevirtual 110	com/tencent/mobileqq/app/LBSHandler:notifyUI	(IZLjava/lang/Object;)V
    //   322: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	LBSHandler
    //   0	323	1	paramList	List<tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.GroupInfo>
    //   1	222	2	i	int
    //   31	275	3	localObject1	Object
    //   76	217	4	localObject2	Object
    //   108	94	5	localGroupInfo	tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.GroupInfo
    //   117	98	6	localNearbyRecommendTroop	com.tencent.mobileqq.data.NearbyRecommendTroop
    //   126	27	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   88	219	249	finally
    //   226	246	249	finally
    //   254	300	249	finally
    //   88	219	253	java/lang/Exception
    //   226	246	253	java/lang/Exception
  }
  
  public void a(SubMsgType0x27.NewComeinUserNotify paramNewComeinUserNotify)
  {
    if (paramNewComeinUserNotify == null) {
      return;
    }
    boolean bool = paramNewComeinUserNotify.msg_new_comein_user.has();
    Object localObject2 = null;
    Object localObject1;
    if (bool) {
      localObject1 = (SubMsgType0x27.NewComeinUser)paramNewComeinUserNotify.msg_new_comein_user.get();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      bool = ((SubMsgType0x27.NewComeinUser)localObject1).uint64_uin.has();
      String str3 = "";
      String str1;
      if (bool) {
        str1 = String.valueOf(((SubMsgType0x27.NewComeinUser)localObject1).uint64_uin.get());
      } else {
        str1 = "";
      }
      if ((((SubMsgType0x27.NewComeinUser)localObject1).uint32_is_frd.has()) && (((SubMsgType0x27.NewComeinUser)localObject1).uint32_is_frd.get() == 1)) {
        bool = true;
      } else {
        bool = false;
      }
      String str2;
      if (((SubMsgType0x27.NewComeinUser)localObject1).bytes_remark.has()) {
        str2 = ((SubMsgType0x27.NewComeinUser)localObject1).bytes_remark.get().toStringUtf8();
      } else {
        str2 = "";
      }
      if (((SubMsgType0x27.NewComeinUser)localObject1).bytes_nick.has()) {
        str3 = ((SubMsgType0x27.NewComeinUser)localObject1).bytes_nick.get().toStringUtf8();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("faceTofaceNearbyUser: push nearbyUin: ");
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(", isFriend: ");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(", remark: ");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(", nick: ");
        ((StringBuilder)localObject1).append(str3);
        QLog.d("LBSHandler", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str1)) {
        localObject1 = new NearbyUser(str1, bool, str2, str3);
      }
    }
    else
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("LBSHandler", 2, "faceTofaceNearbyUser  push NewComeinUser is null ");
        localObject1 = localObject2;
      }
    }
    if (paramNewComeinUserNotify.uint32_msg_type.has()) {
      paramNewComeinUserNotify.uint32_msg_type.get();
    }
    if (paramNewComeinUserNotify.bool_strong_notify.has()) {
      bool = paramNewComeinUserNotify.bool_strong_notify.get();
    } else {
      bool = false;
    }
    int i;
    if (paramNewComeinUserNotify.uint32_push_time.has()) {
      i = paramNewComeinUserNotify.uint32_push_time.get();
    } else {
      i = -1;
    }
    notifyUI(26, true, new Object[] { localObject1, Boolean.valueOf(bool), Integer.valueOf(i) });
  }
  
  public void a(boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NeighborSvc.ReqSetStateSwitch");
    localToServiceMsg.extraData.putBoolean("k_be_share", paramBoolean);
    send(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NearbyGroup.GetGroupList");
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putBoolean("first", paramBoolean);
    if (!TextUtils.isEmpty(paramString)) {
      localToServiceMsg.extraData.putString("strGroupArea", paramString);
    }
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      localToServiceMsg.extraData.putInt("lat", paramInt1);
      localToServiceMsg.extraData.putInt("lon", paramInt2);
    }
    short s2 = 0;
    short s1;
    if (paramInt3 != 1)
    {
      if (paramInt3 != 2)
      {
        s1 = s2;
        if (paramInt3 != 3) {
          if (paramInt3 != 4)
          {
            s1 = s2;
          }
          else
          {
            localToServiceMsg.extraData.putInt("iFilterId", paramInt4);
            s1 = 3;
          }
        }
      }
      else
      {
        s1 = 1;
      }
    }
    else {
      s1 = 2;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("shSortType:");
      paramString.append(s1);
      paramString.append(",iFilterId:");
      paramString.append(paramInt4);
      QLog.d("LBSHandler", 2, paramString.toString());
    }
    localToServiceMsg.extraData.putShort("shSortType", s1);
    send(localToServiceMsg);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    NearbyCmdHelper.a(this, false, true, 0, 0);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    NearbyCmdHelper.a(this, true, false, paramInt1, paramInt2);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("NeighborRecommender.ReqGetRecommender");
      this.allowCmdSet.add("NearbyGroup.GetGroupList");
      this.allowCmdSet.add("NeighborSvc.ReqSetStateSwitch");
      this.allowCmdSet.add("NeighborSvc.ReqGetSwitches");
      this.allowCmdSet.add("NeighborSvc.ReqGetPoint");
      this.allowCmdSet.add("NearbyGroup.ReqGetAreaList");
      this.allowCmdSet.add("LbsShareSvr.location");
      this.allowCmdSet.add("LbsShareSvr.nearby_shops");
      this.allowCmdSet.add("LbsShareSvr.get_shops_by_ids");
      this.allowCmdSet.add("OidbSvc.0x9c0_0");
      this.allowCmdSet.add("OidbSvc.0x9c1_0");
      this.allowCmdSet.add("OidbSvc.0x7f5_1");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return LBSObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
        QLog.d("msgCmdFilter", 2, paramToServiceMsg.toString());
      }
      return;
    }
    BusinessHandlerUtil.checkReportErrorToMM(paramFromServiceMsg, getCurrentAccountUin());
    boolean bool2;
    int i;
    boolean bool1;
    if ("NearbyGroup.GetGroupList".equals(paramFromServiceMsg.getServiceCmd()))
    {
      bool2 = paramToServiceMsg.extraData.getBoolean("first");
      i = paramToServiceMsg.extraData.getInt("iFilterId");
      if (paramObject != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      notifyUI(8, bool1, new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), paramObject });
      return;
    }
    if ("NearbyGroup.ReqGetAreaList".equals(paramFromServiceMsg.getServiceCmd()))
    {
      bool2 = paramToServiceMsg.extraData.getBoolean("clickable");
      if (paramObject != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      notifyUI(12, bool1, new Object[] { Boolean.valueOf(bool2), paramObject });
      return;
    }
    if ("NeighborSvc.ReqSetStateSwitch".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("NeighborSvc.ReqGetSwitches".equals(paramFromServiceMsg.getServiceCmd()))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("NeighborSvc.ReqGetPoint".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramToServiceMsg.extraData.getBoolean("req_street_view")) {
        i = 11;
      } else {
        i = 18;
      }
      NearbyCmdHelper.a(this, i, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("LbsShareSvr.location".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject != null)
      {
        notifyUI(15, true, new Object[] { paramToServiceMsg, paramObject });
        return;
      }
      notifyUI(15, false, null);
      return;
    }
    if ("LbsShareSvr.nearby_shops".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject != null)
      {
        notifyUI(16, true, new Object[] { paramToServiceMsg, paramObject });
        return;
      }
      notifyUI(16, false, null);
      return;
    }
    if ("LbsShareSvr.get_shops_by_ids".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject != null)
      {
        notifyUI(17, true, new Object[] { paramToServiceMsg, paramObject });
        return;
      }
      notifyUI(17, false, null);
      return;
    }
    if ("OidbSvc.0x9c0_0".equals(paramFromServiceMsg.getServiceCmd()))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x9c1_0".equals(paramFromServiceMsg.getServiceCmd()))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("NeighborRecommender.ReqGetRecommender".equals(paramFromServiceMsg.getServiceCmd()))
    {
      b(paramFromServiceMsg, paramToServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x7f5_1".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramFromServiceMsg, paramToServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.LBSHandler
 * JD-Core Version:    0.7.0.1
 */