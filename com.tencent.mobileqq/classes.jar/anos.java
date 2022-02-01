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
import appoint.define.appoint_define.LBSInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyRecommendTroop;
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
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
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
import tencent.im.oidb.cmd0x9c0.cmd0x9c0.ReqBody;
import tencent.im.oidb.cmd0x9c0.cmd0x9c0.RspBody;
import tencent.im.oidb.cmd0x9c1.cmd0x9c1.ReqBody;
import tencent.im.oidb.cmd0x9c1.cmd0x9c1.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUser;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUserNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.GroupInfo;

public class anos
  extends anii
{
  public static String a;
  
  public anos(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static Dialog a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = bglp.a(paramContext, 230, null, paramString, 2131690582, 2131717756, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131365453)).setVisibility(8);
      paramOnClickListener1 = (TextView)paramString.findViewById(2131365475);
      paramOnClickListener2 = new LinearLayout.LayoutParams(-2, -2);
      paramOnClickListener2.gravity = 17;
      paramOnClickListener1.setLayoutParams(paramOnClickListener2);
      paramOnClickListener1.setMinHeight(bggq.a(paramContext, 35.0F));
      paramOnClickListener1.setGravity(17);
    }
    return paramString;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("k_be_share", false);
    if ((paramObject == null) || (((RespSetStateSwitch)paramObject).stHeader.eReplyCode != 0))
    {
      bool2 = this.app.t();
      bool1 = false;
    }
    for (;;)
    {
      notifyUI(9, bool1, Boolean.valueOf(bool2));
      return;
      this.app.b(bool2, true);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool1;
    if (paramQQAppInterface == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = paramQQAppInterface.a().a(paramString, 1001);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("LBSHandlerQ.nearby.follow", 2, "hasReply:" + bool2);
    return bool2;
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "handleGetNearbyRecommender");
    }
    int j;
    if ((paramObject instanceof Object[]))
    {
      paramFromServiceMsg = (Object[])paramObject;
      Object localObject = (NeighborComm.RespHeader)paramFromServiceMsg[0];
      paramObject = (RespGetRecommender)paramFromServiceMsg[1];
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("handleGetNearbyRecommender---->respHeader=").append(localObject).append("|error code=");
        if (localObject == null)
        {
          paramFromServiceMsg = "null";
          QLog.d("LBSHandler", 2, paramFromServiceMsg);
        }
      }
      else
      {
        if ((localObject == null) || (((NeighborComm.RespHeader)localObject).eReplyCode != 0)) {
          break label569;
        }
        j = paramToServiceMsg.extraData.getInt("timingType", -1);
        if ((paramObject == null) || (paramObject.vEncounterInfos == null) || (paramObject.vEncounterInfos.size() <= 0)) {
          break label536;
        }
        localObject = paramObject.vEncounterInfos;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder().append("handleGetNearbyRecommender---->RespGetRecommender.vEncounterInfos size=");
          if (localObject != null) {
            break label365;
          }
        }
      }
      label365:
      for (paramFromServiceMsg = "null";; paramFromServiceMsg = Integer.valueOf(((List)localObject).size()))
      {
        QLog.d("LBSHandler", 2, paramFromServiceMsg + ",resasonType=" + paramObject.eReasonType);
        paramFromServiceMsg = new ArrayList();
        paramFromServiceMsg.addAll((Collection)localObject);
        if (j == 0) {
          aybt.a(this.app, paramObject.strBrief, paramObject.uRecommendTime);
        }
        aybt.a(this.app.getApplication(), getCurrentAccountUin(), paramFromServiceMsg);
        notifyUI(27, true, new Object[] { localObject, Integer.valueOf(j) });
        if (localObject == null) {
          break label379;
        }
        paramFromServiceMsg = "";
        int i = 0;
        for (;;)
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (i >= ((List)localObject).size()) {
            break;
          }
          paramFromServiceMsg = paramFromServiceMsg + Long.toString(((RespEncounterInfo)((List)localObject).get(i)).lEctID) + ";";
          i += 1;
        }
        paramFromServiceMsg = Integer.valueOf(((NeighborComm.RespHeader)localObject).eReplyCode);
        break;
      }
      label379:
      paramToServiceMsg = "";
      if ("".equals(paramToServiceMsg)) {
        break label587;
      }
    }
    label536:
    label569:
    label587:
    for (paramFromServiceMsg = paramToServiceMsg.substring(0, paramToServiceMsg.length() - 1);; paramFromServiceMsg = paramToServiceMsg)
    {
      bcst.b(this.app, "CliOper", "", "", "0X80055FA", "0X80055FA", 0, 0, Integer.toString(paramObject.eReasonType), "", paramFromServiceMsg, "");
      paramToServiceMsg = new Bundle();
      if (paramObject != null)
      {
        paramToServiceMsg.putInt("key_login_pull_interval", paramObject.iOuterInterval);
        paramToServiceMsg.putInt("key_msgbox_pull_interval", paramObject.iInnerInterval);
        paramToServiceMsg.putInt("key_expiretime", paramObject.iExpiretime);
        paramToServiceMsg.putString("key_nearbyrecommender_title", paramObject.strTitle);
        paramToServiceMsg.putInt("key_nearbyrecommender_reasontype", paramObject.eReasonType);
      }
      paramToServiceMsg.putString("key_nearbyrecommender_uins", paramFromServiceMsg);
      if (j == 0) {
        paramToServiceMsg.putLong("key_login_pull_time", System.currentTimeMillis());
      }
      for (;;)
      {
        aybt.a(this.app, paramToServiceMsg);
        return;
        notifyUI(27, false, null);
        paramFromServiceMsg = "";
        break;
        if (j == 1) {
          paramToServiceMsg.putLong("key_msgbox_pull_time", System.currentTimeMillis());
        }
      }
      notifyUI(27, false, null);
      return;
      notifyUI(27, false, null);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject != null) && (((RespGetSwitches)paramObject).stHeader.eReplyCode == 0))
    {
      paramToServiceMsg = ((RespGetSwitches)paramObject).switches.iterator();
      if (paramToServiceMsg.hasNext())
      {
        paramFromServiceMsg = (Switch)paramToServiceMsg.next();
        label72:
        label79:
        int i;
        if (paramFromServiceMsg.type == 64)
        {
          paramObject = this.app;
          if (paramFromServiceMsg.is_open == 1)
          {
            bool = true;
            paramObject.b(bool, true);
            i = paramFromServiceMsg.type;
            if (paramFromServiceMsg.is_open != 1) {
              break label175;
            }
          }
        }
        label175:
        for (boolean bool = true;; bool = false)
        {
          notifyUI(10, true, new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
          break;
          bool = false;
          break label72;
          if (paramFromServiceMsg.type != 1) {
            break label79;
          }
          paramObject = this.app.getAccount();
          if (paramFromServiceMsg.is_open == 1) {}
          for (bool = true;; bool = false)
          {
            axdz.b(paramObject, bool);
            break;
          }
        }
      }
    }
    else
    {
      notifyUI(10, false, null);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    label58:
    int i;
    label105:
    int j;
    label124:
    int k;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      paramToServiceMsg = null;
      if (bool1)
      {
        try
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (paramFromServiceMsg.uint32_result.get() != 0) {
            break label708;
          }
          bool1 = true;
          if (bool1)
          {
            paramObject = new cmd0x9c0.RspBody();
            paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
            if (!paramObject.uint32_req_interval.has()) {
              break label714;
            }
            i = paramObject.uint32_req_interval.get();
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            List localList;
            label160:
            j = -1;
            paramToServiceMsg = null;
            i = -1;
            bool1 = false;
            QLog.d("LBSHandler", 1, "rspFacetoFaceAddFriendReg Exception " + paramFromServiceMsg.getMessage());
          }
        }
        try
        {
          if (!paramObject.uint32_heartbeat_interval.has()) {
            break label720;
          }
          j = paramObject.uint32_heartbeat_interval.get();
        }
        catch (Exception paramFromServiceMsg)
        {
          paramToServiceMsg = null;
          k = -1;
          j = i;
          i = k;
          break label587;
        }
        try
        {
          localList = paramObject.rpt_nearby_user_list.get();
          if ((localList != null) && (localList.size() > 0)) {
            break label679;
          }
          bool1 = false;
          QLog.d("LBSHandler", 1, "rcv nearbyUserList is null!");
        }
        catch (Exception paramFromServiceMsg)
        {
          paramToServiceMsg = null;
          k = i;
          i = j;
          j = k;
          break label587;
          break label490;
          break label160;
        }
        if (bool1)
        {
          paramToServiceMsg = new ArrayList();
          k = 0;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (k < localList.size())
        {
          if (!((cmd0x9c0.NearbyUser)localList.get(k)).uint64_nearby_uin.has()) {
            break label726;
          }
          paramFromServiceMsg = String.valueOf(((cmd0x9c0.NearbyUser)localList.get(k)).uint64_nearby_uin.get());
          if ((!((cmd0x9c0.NearbyUser)localList.get(k)).uint32_is_frd.has()) || (((cmd0x9c0.NearbyUser)localList.get(k)).uint32_is_frd.get() != 1)) {
            break label732;
          }
          bool2 = true;
          if (!((cmd0x9c0.NearbyUser)localList.get(k)).bytes_remark.has()) {
            break label738;
          }
          paramObject = ((cmd0x9c0.NearbyUser)localList.get(k)).bytes_remark.get().toStringUtf8();
          if (!((cmd0x9c0.NearbyUser)localList.get(k)).bytes_nick.has()) {
            break label744;
          }
          str = ((cmd0x9c0.NearbyUser)localList.get(k)).bytes_nick.get().toStringUtf8();
          if (QLog.isColorLevel()) {
            QLog.d("LBSHandler", 2, "faceTofaceNearbyUser: i: " + k + ", nearbyUin: " + paramFromServiceMsg + ", isFriend: " + bool2 + ", remark: " + paramObject + ", nick: " + str);
          }
          if (TextUtils.isEmpty(paramFromServiceMsg)) {
            break label693;
          }
          paramToServiceMsg.add(new asqy(paramFromServiceMsg, bool2, paramObject, str));
          break label693;
        }
        if (paramToServiceMsg.size() > 0) {
          continue;
        }
        QLog.d("LBSHandler", 1, "faceTofaceNearbyUserList is empty!");
        bool1 = false;
      }
      catch (Exception paramFromServiceMsg)
      {
        label490:
        k = i;
        label587:
        i = j;
        j = k;
        continue;
        continue;
      }
      k = j;
      j = i;
      i = k;
      notifyUI(25, bool1, new Object[] { paramToServiceMsg, Integer.valueOf(j), Integer.valueOf(i) });
      return;
      QLog.d("LBSHandler", 1, "rspFacetoFaceAddFriendReg: resultCode:" + paramFromServiceMsg.uint32_result.get());
      paramToServiceMsg = null;
      i = -1;
      j = -1;
      continue;
      label679:
      j = -1;
      paramToServiceMsg = null;
      i = -1;
      continue;
      label693:
      k += 1;
      continue;
      bool1 = false;
      break;
      label708:
      bool1 = false;
      break label58;
      label714:
      i = -1;
      break label105;
      label720:
      j = -1;
      break label124;
      label726:
      paramFromServiceMsg = "";
      continue;
      label732:
      boolean bool2 = false;
      continue;
      label738:
      paramObject = "";
      continue;
      label744:
      String str = "";
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("currentAccountUin");
      if (!bool1) {
        break label343;
      }
    }
    label343:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          continue;
        }
        bool1 = true;
        if (!bool1) {
          continue;
        }
        paramObject = new cmd0x9c1.RspBody();
        paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (!paramObject.uint64_uin.has()) {
          continue;
        }
        paramToServiceMsg = String.valueOf(paramObject.uint64_uin.get());
        if (QLog.isColorLevel()) {
          QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg RspUin " + paramToServiceMsg + " ReqUin " + paramFromServiceMsg);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg Exception " + paramToServiceMsg.getMessage());
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg ssoPkg is null");
        bool1 = bool2;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg  isSuccess " + bool1);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      paramToServiceMsg = "";
      continue;
      if (paramToServiceMsg != null)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg  fail resultCode : " + paramToServiceMsg.uint32_result.get());
        bool1 = bool2;
      }
    }
  }
  
  public void a()
  {
    send(new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NeighborSvc.ReqGetSwitches"));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LBSHandler", 2, "getNearbyRecommender| timingType = " + paramInt);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NeighborRecommender.ReqGetRecommender");
    localToServiceMsg.extraData.putInt("timingType", paramInt);
    send(localToServiceMsg);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "getNewNearbyTroops lat = " + paramInt1 + " lon = " + paramInt2);
    }
    Object localObject2 = new cmd0x7f5.ReqBody();
    ((cmd0x7f5.ReqBody)localObject2).uint32_max_count.set(1);
    ((cmd0x7f5.ReqBody)localObject2).uint32_max_distance.set(1000);
    ((cmd0x7f5.ReqBody)localObject2).uint32_loc_type.set(0);
    Object localObject1 = BaseApplicationImpl.getContext();
    try
    {
      Object localObject3;
      if (bgnt.h((Context)localObject1))
      {
        localObject1 = (WifiManager)((Context)localObject1).getSystemService("wifi");
        localObject3 = ((WifiManager)localObject1).getConnectionInfo().getBSSID();
        ((cmd0x7f5.ReqBody)localObject2).bytes_route_mac.set(ByteStringMicro.copyFromUtf8((String)localObject3));
        ((cmd0x7f5.ReqBody)localObject2).uint32_ipv4.set(((WifiManager)localObject1).getConnectionInfo().getIpAddress());
      }
      for (;;)
      {
        localObject1 = new cmd0x7f5.GPS();
        ((cmd0x7f5.GPS)localObject1).uint32_latitude.set(paramInt1);
        ((cmd0x7f5.GPS)localObject1).uint32_longitude.set(paramInt2);
        ((cmd0x7f5.GPS)localObject1).bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.4.1"));
        ((cmd0x7f5.GPS)localObject1).uint32_client.set(2);
        ((cmd0x7f5.ReqBody)localObject2).msg_gps.set((MessageMicro)localObject1);
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2037);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
        ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7f5.ReqBody)localObject2).toByteArray()));
        localObject2 = createToServiceMsg("OidbSvc.0x7f5_1");
        ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
        sendPbReq((ToServiceMsg)localObject2);
        return;
        if (bgnt.c((Context)localObject1))
        {
          localObject1 = a;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label412;
          }
          localObject1 = adaz.k();
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          localObject3 = ((String)localObject1).split(Pattern.quote("."));
          int k = localObject3.length;
          int j = 0;
          int m;
          for (i = 0; j < k; i = m | i << 8)
          {
            m = Integer.parseInt(localObject3[j]);
            j += 1;
          }
          a = (String)localObject1;
          if (i != 0) {
            ((cmd0x7f5.ReqBody)localObject2).uint32_ipv4.set(i);
          }
        }
      }
    }
    catch (Exception localException)
    {
      label412:
      for (;;)
      {
        localException.printStackTrace();
        continue;
        int i = 0;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 < 0) || (paramInt3 > 1)) {
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
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 < 0) || (paramInt3 > 1) || (paramInt4 < 0) || (paramInt5 < 0) || (paramInt5 > 100)) {
      return;
    }
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
    Object localObject = bgln.a();
    paramString2 = (String)localObject;
    if (localObject == null) {
      paramString2 = "";
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
    boolean bool3 = true;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("LBSHandler", 2, "handleGetNewNearbyTroops");
    }
    boolean bool1;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      if (!bool1) {
        break label318;
      }
    }
    label318:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_result.get() != 0)) {
          continue;
        }
        bool1 = bool3;
        if (!bool1) {
          continue;
        }
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
      catch (Exception paramFromServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSHandler", 2, "handleGetNewNearbyTroops Exception " + paramFromServiceMsg.getMessage());
        bool1 = bool2;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "handleGetNewNearbyTroops  isSuccess " + bool1);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "handleGetNewNearbyTroops  fail resultCode : " + paramFromServiceMsg.uint32_result.get());
      }
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
  
  public void a(List<submsgtype0x67.GroupInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      notifyUI(19, false, Integer.valueOf(0));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearbyTroopPush", 2, "handleNearbyRecommendTroopPush:" + paramList.size());
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory(getCurrentAccountUin()).createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    localEntityTransaction.begin();
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        submsgtype0x67.GroupInfo localGroupInfo = (submsgtype0x67.GroupInfo)paramList.get(i);
        NearbyRecommendTroop localNearbyRecommendTroop = new NearbyRecommendTroop();
        localNearbyRecommendTroop.uin = (localGroupInfo.uint64_group_code.get() + "");
        localNearbyRecommendTroop.name = localGroupInfo.str_group_name.get();
        localNearbyRecommendTroop.intro = localGroupInfo.str_group_memo.get();
        localNearbyRecommendTroop.memberNum = localGroupInfo.uint32_member_num.get();
        localNearbyRecommendTroop.troopType = localGroupInfo.uint32_group_type.get();
        localEntityManager.persistOrReplace(localNearbyRecommendTroop);
        i += 1;
      }
      localEntityTransaction.commit();
      notifyUI(19, true, Integer.valueOf(paramList.size()));
      return;
    }
    catch (Exception paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("recommendTroopPush", 2, "handleNearbyRecommendTroopPush exception" + paramList.toString());
      }
      return;
    }
    finally
    {
      localEntityTransaction.end();
    }
  }
  
  public void a(SubMsgType0x27.NewComeinUserNotify paramNewComeinUserNotify)
  {
    String str1 = null;
    if (paramNewComeinUserNotify == null) {
      return;
    }
    Object localObject;
    label59:
    boolean bool;
    label84:
    String str2;
    if (paramNewComeinUserNotify.msg_new_comein_user.has())
    {
      localObject = (SubMsgType0x27.NewComeinUser)paramNewComeinUserNotify.msg_new_comein_user.get();
      if (localObject == null) {
        break label343;
      }
      if (!((SubMsgType0x27.NewComeinUser)localObject).uint64_uin.has()) {
        break label312;
      }
      str1 = String.valueOf(((SubMsgType0x27.NewComeinUser)localObject).uint64_uin.get());
      if (!((SubMsgType0x27.NewComeinUser)localObject).uint32_is_frd.has()) {
        break label324;
      }
      if (((SubMsgType0x27.NewComeinUser)localObject).uint32_is_frd.get() != 1) {
        break label319;
      }
      bool = true;
      if (!((SubMsgType0x27.NewComeinUser)localObject).bytes_remark.has()) {
        break label329;
      }
      str2 = ((SubMsgType0x27.NewComeinUser)localObject).bytes_remark.get().toStringUtf8();
      label108:
      if (!((SubMsgType0x27.NewComeinUser)localObject).bytes_nick.has()) {
        break label336;
      }
      localObject = ((SubMsgType0x27.NewComeinUser)localObject).bytes_nick.get().toStringUtf8();
      label132:
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "faceTofaceNearbyUser: push nearbyUin: " + str1 + ", isFriend: " + bool + ", remark: " + str2 + ", nick: " + (String)localObject);
      }
      if (TextUtils.isEmpty(str1)) {
        break label379;
      }
      localObject = new asqy(str1, bool, str2, (String)localObject);
    }
    for (;;)
    {
      label221:
      if (paramNewComeinUserNotify.uint32_msg_type.has()) {
        paramNewComeinUserNotify.uint32_msg_type.get();
      }
      if (paramNewComeinUserNotify.bool_strong_notify.has())
      {
        bool = paramNewComeinUserNotify.bool_strong_notify.get();
        label257:
        if (!paramNewComeinUserNotify.uint32_push_time.has()) {
          break label374;
        }
      }
      label312:
      label319:
      label324:
      label329:
      label336:
      label343:
      label374:
      for (int i = paramNewComeinUserNotify.uint32_push_time.get();; i = -1)
      {
        notifyUI(26, true, new Object[] { localObject, Boolean.valueOf(bool), Integer.valueOf(i) });
        return;
        localObject = null;
        break;
        str1 = "";
        break label59;
        bool = false;
        break label84;
        bool = false;
        break label84;
        str2 = "";
        break label108;
        localObject = "";
        break label132;
        localObject = str1;
        if (!QLog.isColorLevel()) {
          break label221;
        }
        QLog.d("LBSHandler", 2, "faceTofaceNearbyUser  push NewComeinUser is null ");
        localObject = str1;
        break label221;
        bool = false;
        break label257;
      }
      label379:
      localObject = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NeighborSvc.ReqSetStateSwitch");
    localToServiceMsg.extraData.putBoolean("k_be_share", paramBoolean);
    send(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    short s2 = 0;
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
    short s1 = s2;
    switch (paramInt3)
    {
    default: 
      s1 = s2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "shSortType:" + s1 + ",iFilterId:" + paramInt4);
      }
      localToServiceMsg.extraData.putShort("shSortType", s1);
      send(localToServiceMsg);
      return;
      s1 = 1;
      continue;
      s1 = 2;
      continue;
      s1 = 3;
      localToServiceMsg.extraData.putInt("iFilterId", paramInt4);
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject = new cmd0x9c0.ReqBody();
    ((cmd0x9c0.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    paramString = ((cmd0x9c0.ReqBody)localObject).uint32_heartbeat;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString.set(i);
      if (paramBoolean) {
        break label91;
      }
      paramString = axbr.a(getClass().getSimpleName());
      if (paramString != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSHandler", 2, "lbsInfo is null");
      }
      return false;
    }
    ((cmd0x9c0.ReqBody)localObject).msg_lbs_info.set(paramString);
    label91:
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2496);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(0);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x9c0.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x9c0_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  public void b()
  {
    anqr.a(this, false, true, 0, 0);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    anqr.a(this, true, false, paramInt1, paramInt2);
  }
  
  protected boolean msgCmdFilter(String paramString)
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
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends anil> observerClass()
  {
    return anot.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("msgCmdFilter", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    do
    {
      return;
      checkReportErrorToMM(paramFromServiceMsg);
      boolean bool2;
      int i;
      boolean bool1;
      if ("NearbyGroup.GetGroupList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        bool2 = paramToServiceMsg.extraData.getBoolean("first");
        i = paramToServiceMsg.extraData.getInt("iFilterId");
        if (paramObject != null) {}
        for (bool1 = true;; bool1 = false)
        {
          notifyUI(8, bool1, new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), paramObject });
          return;
        }
      }
      if ("NearbyGroup.ReqGetAreaList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        bool2 = paramToServiceMsg.extraData.getBoolean("clickable");
        if (paramObject != null) {}
        for (bool1 = true;; bool1 = false)
        {
          notifyUI(12, bool1, new Object[] { Boolean.valueOf(bool2), paramObject });
          return;
        }
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
        if (paramToServiceMsg.extraData.getBoolean("req_street_view")) {}
        for (i = 11;; i = 18)
        {
          anqr.a(this, i, paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
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
    } while (!"OidbSvc.0x7f5_1".equals(paramFromServiceMsg.getServiceCmd()));
    a(paramFromServiceMsg, paramToServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anos
 * JD-Core Version:    0.7.0.1
 */