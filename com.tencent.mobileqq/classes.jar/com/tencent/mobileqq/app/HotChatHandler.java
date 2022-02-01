package com.tencent.mobileqq.app;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoCell;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.data.SosoWifi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x62c.oidb_cmd0x62c.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0x897.cmd0x897.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ExitPublicGroupReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.KickPublicGroupVisitorReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.RspBody;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7.RspBody;
import tencent.im.oidb.cmd0x8b2.oidb_0x8b2.ReqBody;
import tencent.im.oidb.cmd0x8b2.oidb_0x8b2.RspBody;
import tencent.im.oidb.cmd0x8b3.oidb_0x8b3.ReqBody;
import tencent.im.oidb.cmd0x8b3.oidb_0x8b3.groupinfo;
import tencent.im.oidb.cmd0xa81.oidb_0xa81.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;
import tencent.im.oidb.hotchat.CreateHotChat.ReqBody;
import tencent.im.oidb.hotchat.CreateHotChat.RspBody;
import tencent.im.oidb.hotchat.GetJoinedHotChatList.ReqBody;
import tencent.im.oidb.hotchat.GetJoinedHotChatList.RspBody;
import tencent.im.oidb.hotchat.LBS.Attribute;
import tencent.im.oidb.hotchat.LBS.Cell;
import tencent.im.oidb.hotchat.LBS.GPS;
import tencent.im.oidb.hotchat.LBS.LBSInfo;
import tencent.im.oidb.hotchat.LBS.Wifi;
import tencent.im.oidb.hotchat.oidb_0x81f.GetAuthDataReq;
import tencent.im.oidb.hotchat.oidb_0x81f.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x823.KickPublicGroupVisitorReqBody;
import tencent.im.oidb.hotchat.oidb_0x823.KickPublicGroupVisitorRspBody;
import tencent.im.oidb.hotchat.oidb_0x823.PlayerDeviceInfo;
import tencent.im.oidb.hotchat.oidb_0x823.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x823.RspBody;
import tencent.im.oidb.hotchat.oidb_0x8ab.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x8ab.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class HotChatHandler
  extends BusinessHandler
{
  public static final String a;
  public static final String b = HardCodeUtil.a(2131705584);
  public static final String c = HardCodeUtil.a(2131705583);
  public QQAppInterface a;
  private volatile boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705575);
  }
  
  HotChatHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  @NotNull
  private HotChatInfo a(ToServiceMsg paramToServiceMsg, int paramInt1, int paramInt2, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt3)
  {
    HotChatInfo localHotChatInfo1 = HotChatInfo.createHotChat(paramWifiPOIInfo, false, paramInt1);
    paramInt1 = paramToServiceMsg.extraData.getInt("apolloGameId");
    if (paramInt1 > 0)
    {
      localHotChatInfo1.apolloGameId = paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d("HotChatHandler", 2, "handleQuickJoinHotChat jionHotChat, apolloGameId:" + paramInt1);
      }
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("PttShow", new Object[] { "handleQuickJoinHotChat", localHotChatInfo1 });
    }
    paramToServiceMsg = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    Object localObject = a(localHotChatInfo1, paramToServiceMsg);
    if (paramInt3 == 1) {
      paramToServiceMsg.a(localHotChatInfo1, paramInt2);
    }
    while (paramWifiPOIInfo.uint64_exit_group_code.has())
    {
      long l = paramWifiPOIInfo.uint64_exit_group_code.get();
      paramWifiPOIInfo = paramToServiceMsg.a();
      if ((localObject == null) || (paramWifiPOIInfo.size() <= 0)) {
        break;
      }
      paramWifiPOIInfo = paramWifiPOIInfo.iterator();
      while (paramWifiPOIInfo.hasNext())
      {
        localObject = (HotChatInfo)paramWifiPOIInfo.next();
        if ((((HotChatInfo)localObject).adminLevel == 0) && (String.valueOf(l).equals(((HotChatInfo)localObject).troopUin))) {
          paramToServiceMsg.a((HotChatInfo)localObject, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_LEFT_OVERCOUNT);
        }
      }
      if (paramInt3 == 2)
      {
        HotChatInfo localHotChatInfo2 = paramToServiceMsg.a(localHotChatInfo1.troopUin);
        if (localHotChatInfo2 == null)
        {
          paramToServiceMsg.a(localHotChatInfo1, 4);
        }
        else if (paramInt2 == 1)
        {
          paramToServiceMsg.a(localHotChatInfo1, paramInt2);
        }
        else
        {
          localHotChatInfo2.updateHotChatInfo(localHotChatInfo1);
          EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          localEntityManager.update(localHotChatInfo2);
          localEntityManager.close();
        }
      }
    }
    return localHotChatInfo1;
  }
  
  @Nullable
  private List<HotChatInfo> a(HotChatInfo paramHotChatInfo, HotChatManager paramHotChatManager)
  {
    List localList = paramHotChatManager.a();
    if ((localList != null) && (localList.size() > 0))
    {
      int i = localList.size() - 1;
      if (i >= 0)
      {
        HotChatInfo localHotChatInfo = (HotChatInfo)localList.get(i);
        if (localHotChatInfo == null) {}
        for (;;)
        {
          i -= 1;
          break;
          if ((localHotChatInfo.userCreate == paramHotChatInfo.userCreate) && (Utils.a(localHotChatInfo.uuid, paramHotChatInfo.uuid)) && (!Utils.a(localHotChatInfo.troopUin, paramHotChatInfo.troopUin)))
          {
            if (QLog.isColorLevel()) {
              NearbyUtils.a("HotChatHandler", new Object[] { "handleQuickJoinHotChat_check", String.format("userCreate:%d, uuid:%s, local:[%s,%s], server:[%s,%s]", new Object[] { Integer.valueOf(localHotChatInfo.userCreate), localHotChatInfo.uuid, localHotChatInfo.troopUin, localHotChatInfo.troopCode, paramHotChatInfo.troopUin, paramHotChatInfo.troopCode }) });
            }
            paramHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
          }
        }
      }
    }
    return localList;
  }
  
  public static LBS.LBSInfo a(boolean paramBoolean)
  {
    LBS.LBSInfo localLBSInfo = new LBS.LBSInfo();
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).reqRawLbsData(3600000L, HotChatHandler.class.getSimpleName());
    Object localObject1 = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getRawSosoInfo();
    if ((localObject1 == null) || (((SosoLbsInfo)localObject1).mLocation == null)) {
      return null;
    }
    Object localObject2 = new LBS.GPS();
    ((LBS.GPS)localObject2).latitude.set((int)(((SosoLbsInfo)localObject1).mLocation.mLat84 * 1000000.0D));
    ((LBS.GPS)localObject2).longitude.set((int)(((SosoLbsInfo)localObject1).mLocation.mLon84 * 1000000.0D));
    ((LBS.GPS)localObject2).altitude.set(-1);
    ((LBS.GPS)localObject2).coordinate.set(0);
    localLBSInfo.gps.set((MessageMicro)localObject2);
    Object localObject3;
    if (((SosoLbsInfo)localObject1).mWifis != null)
    {
      localObject2 = ((SosoLbsInfo)localObject1).mWifis.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SosoWifi)((Iterator)localObject2).next();
        LBS.Wifi localWifi = new LBS.Wifi();
        localWifi.mac.set(((SosoWifi)localObject3).mMac);
        localWifi.rssi.set(((SosoWifi)localObject3).mRssi);
        localLBSInfo.rpt_wifi.add(localWifi);
      }
    }
    if (((SosoLbsInfo)localObject1).mCells != null)
    {
      localObject1 = ((SosoLbsInfo)localObject1).mCells.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoCell)((Iterator)localObject1).next();
        localObject3 = new LBS.Cell();
        ((LBS.Cell)localObject3).mcc.set(((SosoCell)localObject2).mMcc);
        ((LBS.Cell)localObject3).mnc.set(((SosoCell)localObject2).mMnc);
        ((LBS.Cell)localObject3).lac.set(((SosoCell)localObject2).mLac);
        ((LBS.Cell)localObject3).cellid.set(((SosoCell)localObject2).mCellId);
        ((LBS.Cell)localObject3).rssi.set(((SosoCell)localObject2).mRss);
        localLBSInfo.rpt_cell.add((MessageMicro)localObject3);
      }
    }
    localObject1 = new LBS.Attribute();
    localObject2 = DeviceInfoUtil.a();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((LBS.Attribute)localObject1).imei.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
    }
    localObject2 = DeviceInfoUtil.b();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((LBS.Attribute)localObject1).imsi.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
    }
    localLBSInfo.attribute.set((MessageMicro)localObject1);
    return localLBSInfo;
  }
  
  public static LBS.Wifi a()
  {
    Object localObject1 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (!((WifiManager)localObject1).isWifiEnabled()) {
      return null;
    }
    Object localObject2 = ((WifiManager)localObject1).getConnectionInfo();
    localObject1 = HotChatManager.a((WifiInfo)localObject2);
    long l = SosoWifi.macToLong(((WifiInfo)localObject2).getBSSID());
    int i = ((WifiInfo)localObject2).getRssi();
    localObject2 = new LBS.Wifi();
    ((LBS.Wifi)localObject2).rssi.set(i);
    ((LBS.Wifi)localObject2).essid.set(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
    ((LBS.Wifi)localObject2).mac.set(l);
    return localObject2;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("HotChatHandler", 2, "<<---handleError serviceCmd:" + str);
    }
    if ("OidbSvc.0x8a4".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, false);
    }
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!"OidbSvc.0x89b_3".equals(str)) {
                    break;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("kick", false))
                  {
                    j(paramToServiceMsg, paramFromServiceMsg);
                    return;
                  }
                } while (paramToServiceMsg.extraData.getBoolean("isJoin"));
                c(paramToServiceMsg, paramFromServiceMsg);
                return;
              } while ("OidbSvc.0x823_0".equals(str));
              if ("OidbSvc.0x8a2".equals(str))
              {
                d(paramToServiceMsg, paramFromServiceMsg);
                return;
              }
              if ("OidbSvc.0x8ab".equals(str))
              {
                e(paramToServiceMsg, paramFromServiceMsg);
                return;
              }
              if ("OidbSvc.0x8b3".equals(str))
              {
                f(paramToServiceMsg, paramFromServiceMsg);
                return;
              }
              if (!"OidbSvc.0x8b2".equals(str)) {
                break;
              }
            } while ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null));
            i = paramToServiceMsg.extraData.getInt("serviceType");
            if (QLog.isColorLevel()) {
              QLog.d("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "handleError, cmd:" + str + "|serviceType:" + i);
            }
          } while (i != 2);
          g(paramToServiceMsg, paramFromServiceMsg);
          return;
          if ("OidbSvc.0xa81".equals(str))
          {
            k(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          if ("OidbSvc.0x88d_0".equals(str))
          {
            h(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          if ("OidbSvc.0x89a_0".equals(str))
          {
            i(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
        } while ("OidbSvc.0xa8b".equals(str));
        if ("OidbSvc.0x897_0".equals(str))
        {
          p(paramToServiceMsg, paramFromServiceMsg, null);
          return;
        }
        if ("OidbSvc.0x88d_1".equals(str))
        {
          o(paramToServiceMsg, paramFromServiceMsg, null);
          return;
        }
      } while ("OidbSvc.0x8a3_7".equals(str));
      if ("OidbSvc.0x8a7_0".equals(str))
      {
        r(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
    } while (!"OidbSvc.0x62c_4".equals(str));
    a(paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    int i = paramToServiceMsg.extraData.getInt("serviceType");
    if (QLog.isColorLevel()) {
      QLog.d("HotChatHandler", 2, "onReceive, cmd:" + paramString + "|serviceType:" + i);
    }
    if (6 == i) {
      j(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleGetMyHostChatListRespError timeOut: " + paramBoolean);
    }
    notifyUI(1031, false, null);
    if (paramBoolean) {
      ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(null, false);
    }
  }
  
  private void a(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean, int paramInt)
  {
    int i = 2;
    int j = 0;
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatHandler", new Object[] { "createHotChat", Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramWifiPOIInfo });
    }
    if (paramWifiPOIInfo == null) {
      return;
    }
    Object localObject = paramWifiPOIInfo.uint32_wifi_poi_type;
    if (paramBoolean) {
      i = 1;
    }
    ((PBUInt32Field)localObject).set(i);
    localObject = HotChatInfo.createHotChat(paramWifiPOIInfo, paramBoolean, paramInt);
    CreateHotChat.ReqBody localReqBody = new CreateHotChat.ReqBody();
    localReqBody.create_req_info.setHasFlag(true);
    localReqBody.create_req_info.set(paramWifiPOIInfo);
    paramInt = j;
    if (paramBoolean)
    {
      paramWifiPOIInfo = a(true);
      if (paramWifiPOIInfo != null) {
        localReqBody.lbs_info.set(paramWifiPOIInfo);
      }
      paramInt = 1;
    }
    paramWifiPOIInfo = makeOIDBPkg("OidbSvc.0x8a2", 2210, paramInt, localReqBody.toByteArray(), 10000L);
    paramWifiPOIInfo.extraData.putSerializable("HOT_CHAT_INFO", (Serializable)localObject);
    sendPbReq(paramWifiPOIInfo);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("HotChatHandler", 2, "<<---handleTimeOut serviceCmd:" + str);
    }
    if ("OidbSvc.0x8a4".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, true);
    }
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!"OidbSvc.0x89b_3".equals(str)) {
                  break;
                }
                if (paramToServiceMsg.extraData.getBoolean("kick", false))
                {
                  j(paramToServiceMsg, paramFromServiceMsg);
                  return;
                }
              } while (paramToServiceMsg.extraData.getBoolean("isJoin"));
              c(paramToServiceMsg, paramFromServiceMsg);
              return;
            } while ("OidbSvc.0x823_0".equals(str));
            if ("OidbSvc.0x8a2".equals(str))
            {
              d(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            if ("OidbSvc.0x8ab".equals(str))
            {
              e(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            if ("OidbSvc.0x8b3".equals(str))
            {
              f(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            if (!"OidbSvc.0x8b2".equals(str)) {
              break;
            }
          } while ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null));
          i = paramToServiceMsg.extraData.getInt("serviceType");
          if (QLog.isColorLevel()) {
            QLog.d("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "handleTimeOut, cmd:" + str + "|serviceType:" + i);
          }
        } while (i != 2);
        g(paramToServiceMsg, paramFromServiceMsg);
        return;
        if ("OidbSvc.0xa81".equals(str))
        {
          k(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("OidbSvc.0x88d_0".equals(str))
        {
          h(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("OidbSvc.0x89a_0".equals(str))
        {
          i(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
      } while ("OidbSvc.0xa8b".equals(str));
      if ("OidbSvc.0x897_0".equals(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("OidbSvc.0x88d_1".equals(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
    } while (!"OidbSvc.0x8a7_0".equals(str));
    r(paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    if ((paramToServiceMsg == null) || (paramToServiceMsg.extraData == null)) {}
    int i;
    do
    {
      return;
      i = paramToServiceMsg.extraData.getInt("serviceType");
      if (QLog.isColorLevel()) {
        QLog.d("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "onReceive, cmd:" + paramString + "|serviceType:" + i);
      }
      if (i == 2)
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while ((i != 5) && (i != 6));
    q(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleExtHotChatRespErrorOrTimeOut()");
    }
    paramFromServiceMsg = jdField_a_of_type_JavaLangString;
    notifyUI(1033, false, new Object[] { paramToServiceMsg.extraData.getString("troopUin"), paramFromServiceMsg });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("kick", false)) {
      m(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (paramToServiceMsg.extraData.getBoolean("isJoin")) {
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (HotChatInfo)paramToServiceMsg.extraData.get("HOT_CHAT_INFO");
    notifyUI(1032, false, new Object[] { paramToServiceMsg.troopUin, HardCodeUtil.a(2131705587), paramToServiceMsg.name });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleExitHotChatResp()");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str2 = jdField_a_of_type_JavaLangString;
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(1033, false, new Object[] { str1, str2 });
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null)
      {
        notifyUI(1033, false, new Object[] { str1, str2 });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg = null;
      }
      if (!paramFromServiceMsg.uint32_result.has())
      {
        notifyUI(1033, false, new Object[] { str1, str2 });
        return;
      }
      int i = paramFromServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleExitHotChatResp result " + i);
      }
      if (i == 0)
      {
        paramToServiceMsg = (HotChatManager.HotChatStateWrapper)paramToServiceMsg.extraData.getSerializable("targetHotChatState");
        paramFromServiceMsg = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        paramFromServiceMsg.a(paramFromServiceMsg.a(str1), paramToServiceMsg);
        notifyUI(1033, true, new Object[] { str1, b });
        return;
      }
      notifyUI(1033, false, new Object[] { str1, str2 });
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    System.out.println("-----> handleQuickJoinHotChatErrorOrTimeOut");
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = HardCodeUtil.a(2131705580);
    HotChatInfo localHotChatInfo = (HotChatInfo)paramToServiceMsg.extraData.getSerializable("HOT_CHAT_INFO");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isWifiHotChat", false);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg = null;
      }
      if (!paramToServiceMsg.uint32_result.has())
      {
        notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
        return;
      }
      int i = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleCreateHotChatResp result " + i);
      }
      if (i == 0)
      {
        paramFromServiceMsg = new CreateHotChat.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l1 = Utils.a(paramFromServiceMsg.uint32_group_code.get());
          long l2 = Utils.a(paramFromServiceMsg.uint32_group_uin.get());
          localHotChatInfo.troopUin = String.valueOf(l1);
          localHotChatInfo.troopCode = String.valueOf(l2);
          localHotChatInfo.state = 0;
          ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(localHotChatInfo, 4);
          notifyUI(1032, true, new Object[] { HardCodeUtil.a(2131705570), localHotChatInfo.troopCode, localHotChatInfo.troopUin, localHotChatInfo.name, Boolean.valueOf(bool) });
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
          return;
        }
      }
      switch (i)
      {
      case 1284: 
      case 1285: 
      case 1286: 
      case 1287: 
      case 1288: 
      case 1289: 
      default: 
        paramToServiceMsg = HardCodeUtil.a(2131705589);
      }
    }
    for (;;)
    {
      notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, paramToServiceMsg, localHotChatInfo.name });
      return;
      paramToServiceMsg = HardCodeUtil.a(2131705582);
      continue;
      paramToServiceMsg = HardCodeUtil.a(2131705576);
      continue;
      paramToServiceMsg = HardCodeUtil.a(2131705585);
      continue;
      paramToServiceMsg = HardCodeUtil.a(2131705586);
      continue;
      paramToServiceMsg = HardCodeUtil.a(2131705577);
      continue;
      paramToServiceMsg = HardCodeUtil.a(2131705572);
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("uid");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1035, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "" });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleSetHotChatAnnounceTimeOutOrError,result= " + i + ",uid=" + paramToServiceMsg);
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = false;
    if (paramObject == null) {
      return;
    }
    boolean bool2;
    boolean bool1;
    if (paramToServiceMsg.extraData.getInt("serviceType", 0) == 2)
    {
      bool2 = true;
      paramToServiceMsg = new GetJoinedHotChatList.RspBody();
      if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
        break label279;
      }
      bool1 = true;
      label50:
      if (!bool1) {
        break label388;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label382;
        }
        i = paramFromServiceMsg.uint32_result.get();
        if (i != 0) {}
      }
      catch (Exception paramToServiceMsg)
      {
        label279:
        i = 0;
        bool1 = false;
        paramToServiceMsg = null;
        continue;
        boolean bool3 = false;
        continue;
        bool3 = false;
        ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramToServiceMsg, bool2);
        if (bool2) {
          new Handler(Looper.getMainLooper()).post(new HotChatHandler.2(this, bool3, paramToServiceMsg));
        }
        notifyUI(1031, true, null);
        return;
      }
      try
      {
        paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, "handleGetMyHotChatListResp isSuccess: " + bool1 + ", result:" + i + ",resp=" + paramToServiceMsg);
        }
        if (paramToServiceMsg == null) {
          break label365;
        }
        paramFromServiceMsg = paramToServiceMsg.rpt_msg_wifi_poi_info.get();
        paramToServiceMsg = new ArrayList();
        if (paramFromServiceMsg == null) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        bool1 = false;
        bool3 = bool1;
        if (!paramFromServiceMsg.hasNext()) {
          continue;
        }
        paramObject = (Common.WifiPOIInfo)paramFromServiceMsg.next();
        if (paramObject.uint32_wifi_poi_type.get() != 1) {
          continue;
        }
        bool3 = true;
        paramObject = HotChatInfo.createHotChat(paramObject, bool3);
        paramToServiceMsg.add(paramObject);
        if (!bool2) {
          break label379;
        }
        paramObject.isGameRoom = true;
        bool1 = true;
        continue;
      }
      catch (Exception paramToServiceMsg)
      {
        continue;
        continue;
      }
      bool2 = false;
      break;
      bool1 = false;
      break label50;
      label365:
      notifyUI(1031, false, null);
      return;
      label379:
      label382:
      int i = 0;
      continue;
      label388:
      i = 0;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troop_uin");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1036, false, new Object[] { paramToServiceMsg, arrayOfByte, Integer.valueOf(i), "", "", null });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "handleGetHotChatAnnounceTimeOutOrError,result= " + i + ",uid=" + arrayOfByte);
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("hotnamecode");
    int j = paramToServiceMsg.extraData.getInt("HOTCHAT_EXTRA_FLAG");
    int k = paramToServiceMsg.extraData.getInt("preHotChatState");
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    oidb_0x8ab.RspBody localRspBody = new oidb_0x8ab.RspBody();
    int m = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (m == 0)
    {
      paramFromServiceMsg = localObject3;
      paramObject = localObject2;
    }
    for (;;)
    {
      try
      {
        if (localRspBody.poi_info.has())
        {
          paramObject = localObject2;
          paramFromServiceMsg = (Common.WifiPOIInfo)localRspBody.poi_info.get();
        }
        paramObject = paramFromServiceMsg;
        if (!localRspBody.join_poi_status.has()) {
          break label300;
        }
        paramObject = paramFromServiceMsg;
        i = localRspBody.join_poi_status.get();
      }
      catch (Exception paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
        i = 0;
        paramFromServiceMsg = paramObject;
        continue;
      }
      if (paramFromServiceMsg != null)
      {
        paramToServiceMsg = a(paramToServiceMsg, j, k, paramFromServiceMsg, i);
        notifyUI(1034, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i), str });
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, "handleQuickJoinHotChat, " + m + "," + paramToServiceMsg + "," + paramFromServiceMsg);
        }
        return;
        notifyUI(1034, false, new Object[] { null, null, Integer.valueOf(m), str });
        paramToServiceMsg = null;
        paramFromServiceMsg = localObject1;
        continue;
      }
      paramToServiceMsg = null;
      continue;
      label300:
      int i = 0;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1039, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "", Long.valueOf(0L) });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleGetUserCreateHotChatAnnounceTimeOutOrError,result= " + i + ",groupcode=" + paramToServiceMsg);
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        int j;
        paramObject = paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramObject = paramToServiceMsg;
          j = -1;
          i = j;
          if (paramObject != null)
          {
            i = j;
            if (paramObject.uint32_result.has()) {
              i = paramObject.uint32_result.get();
            }
          }
          if (i != 0) {
            break label172;
          }
          notifyUI(1035, true, new Object[] { arrayOfByte, Integer.valueOf(i), null });
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandler", 2, "handleSetHotChatAnnounce,result= " + i + ",strErr=" + null);
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          int i;
          break label149;
        }
        paramFromServiceMsg = paramFromServiceMsg;
        paramToServiceMsg = null;
      }
      label149:
      if (QLog.isColorLevel())
      {
        QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
        paramObject = paramToServiceMsg;
        continue;
        label172:
        notifyUI(1035, false, new Object[] { arrayOfByte, Integer.valueOf(i), null });
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1040, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "" });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleSetUserCreateHotChatAnnounce,result= " + i + ",groupcode=" + paramToServiceMsg);
    }
  }
  
  /* Error */
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 50	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 764
    //   7: invokevirtual 768	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   10: astore 8
    //   12: aload_1
    //   13: getfield 50	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   16: ldc_w 829
    //   19: invokevirtual 669	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 9
    //   24: new 689	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   27: dup
    //   28: invokespecial 690	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   31: astore_1
    //   32: aload_1
    //   33: aload_3
    //   34: checkcast 692	[B
    //   37: checkcast 692	[B
    //   40: invokevirtual 696	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   43: pop
    //   44: aload_1
    //   45: astore_2
    //   46: aload_2
    //   47: ifnull +527 -> 574
    //   50: aload_2
    //   51: getfield 699	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   54: invokevirtual 700	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   57: ifeq +517 -> 574
    //   60: aload_2
    //   61: getfield 699	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   64: invokevirtual 702	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   67: istore 4
    //   69: aconst_null
    //   70: astore 6
    //   72: aconst_null
    //   73: astore 7
    //   75: aconst_null
    //   76: astore_3
    //   77: iload 4
    //   79: ifne +417 -> 496
    //   82: new 881	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody
    //   85: dup
    //   86: invokespecial 882	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:<init>	()V
    //   89: astore 6
    //   91: aload 6
    //   93: aload_2
    //   94: getfield 737	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   97: invokevirtual 740	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   100: invokevirtual 741	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   103: invokevirtual 883	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   106: pop
    //   107: aload 6
    //   109: getfield 886	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_group_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   112: invokevirtual 887	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   115: ifeq +454 -> 569
    //   118: aload 6
    //   120: getfield 886	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_group_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   123: invokevirtual 740	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   126: invokevirtual 890	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   129: astore_1
    //   130: aload 6
    //   132: getfield 893	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_jumping_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   135: invokevirtual 887	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   138: ifeq +426 -> 564
    //   141: aload 6
    //   143: getfield 893	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_jumping_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   146: invokevirtual 740	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   149: invokevirtual 890	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   152: astore_2
    //   153: aload 6
    //   155: getfield 897	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:uint64_administrator_uin	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   158: invokevirtual 900	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   161: ifeq +12 -> 173
    //   164: aload 6
    //   166: getfield 897	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:uint64_administrator_uin	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   169: invokevirtual 901	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   172: astore_3
    //   173: aload_1
    //   174: astore 6
    //   176: aload_3
    //   177: astore_1
    //   178: aload 6
    //   180: astore_3
    //   181: aload_0
    //   182: getfield 36	com/tencent/mobileqq/app/HotChatHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   185: getstatic 109	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   188: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   191: checkcast 117	com/tencent/mobileqq/app/HotChatManager
    //   194: astore 6
    //   196: aload 6
    //   198: aload 9
    //   200: invokevirtual 188	com/tencent/mobileqq/app/HotChatManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   203: astore 7
    //   205: aload 7
    //   207: ifnull +181 -> 388
    //   210: aload_3
    //   211: ifnonnull +142 -> 353
    //   214: aload 7
    //   216: getfield 904	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   219: ifnonnull +146 -> 365
    //   222: aload 7
    //   224: aload_3
    //   225: putfield 904	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   228: aload 7
    //   230: aload_2
    //   231: putfield 907	com/tencent/mobileqq/data/HotChatInfo:memoUrl	Ljava/lang/String;
    //   234: new 331	java/util/ArrayList
    //   237: dup
    //   238: invokespecial 799	java/util/ArrayList:<init>	()V
    //   241: astore 10
    //   243: aload_1
    //   244: ifnull +130 -> 374
    //   247: aload_1
    //   248: invokeinterface 147 1 0
    //   253: ifle +121 -> 374
    //   256: iconst_0
    //   257: istore 5
    //   259: iload 5
    //   261: aload_1
    //   262: invokeinterface 147 1 0
    //   267: if_icmpge +107 -> 374
    //   270: aload 10
    //   272: aload_1
    //   273: iload 5
    //   275: invokeinterface 216 2 0
    //   280: checkcast 865	java/lang/Long
    //   283: invokestatic 910	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   286: invokevirtual 911	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   289: pop
    //   290: iload 5
    //   292: iconst_1
    //   293: iadd
    //   294: istore 5
    //   296: goto -37 -> 259
    //   299: astore_3
    //   300: aconst_null
    //   301: astore_1
    //   302: aload_1
    //   303: astore_2
    //   304: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq -261 -> 46
    //   310: ldc 69
    //   312: iconst_2
    //   313: aload_3
    //   314: invokevirtual 877	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   317: invokestatic 594	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aload_1
    //   321: astore_2
    //   322: goto -276 -> 46
    //   325: astore_3
    //   326: aconst_null
    //   327: astore_1
    //   328: aconst_null
    //   329: astore_2
    //   330: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: ifeq +13 -> 346
    //   336: ldc 69
    //   338: iconst_2
    //   339: aload_3
    //   340: invokevirtual 861	java/lang/Exception:toString	()Ljava/lang/String;
    //   343: invokestatic 594	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload_1
    //   347: astore_3
    //   348: aconst_null
    //   349: astore_1
    //   350: goto -169 -> 181
    //   353: aload_3
    //   354: aload 7
    //   356: getfield 904	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   359: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   362: ifne -140 -> 222
    //   365: aload 7
    //   367: iconst_0
    //   368: putfield 914	com/tencent/mobileqq/data/HotChatInfo:memoShowed	Z
    //   371: goto -149 -> 222
    //   374: aload 7
    //   376: aload 10
    //   378: putfield 918	com/tencent/mobileqq/data/HotChatInfo:adminUins	Ljava/util/List;
    //   381: aload 6
    //   383: aload 7
    //   385: invokevirtual 920	com/tencent/mobileqq/app/HotChatManager:a	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   388: aload_0
    //   389: sipush 1036
    //   392: iconst_1
    //   393: bipush 6
    //   395: anewarray 97	java/lang/Object
    //   398: dup
    //   399: iconst_0
    //   400: aload 9
    //   402: aastore
    //   403: dup
    //   404: iconst_1
    //   405: aload 8
    //   407: aastore
    //   408: dup
    //   409: iconst_2
    //   410: iload 4
    //   412: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   415: aastore
    //   416: dup
    //   417: iconst_3
    //   418: aload_3
    //   419: aastore
    //   420: dup
    //   421: iconst_4
    //   422: aload_2
    //   423: aastore
    //   424: dup
    //   425: iconst_5
    //   426: aload_1
    //   427: aastore
    //   428: invokevirtual 598	com/tencent/mobileqq/app/HotChatHandler:notifyUI	(IZLjava/lang/Object;)V
    //   431: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +61 -> 495
    //   437: ldc_w 536
    //   440: iconst_2
    //   441: new 71	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   448: ldc_w 922
    //   451: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: iload 4
    //   456: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   459: ldc_w 924
    //   462: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_3
    //   466: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc_w 926
    //   472: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload_2
    //   476: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: ldc_w 928
    //   482: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload_1
    //   486: invokevirtual 777	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 594	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: return
    //   496: aload_0
    //   497: sipush 1036
    //   500: iconst_0
    //   501: bipush 6
    //   503: anewarray 97	java/lang/Object
    //   506: dup
    //   507: iconst_0
    //   508: aload 9
    //   510: aastore
    //   511: dup
    //   512: iconst_1
    //   513: aload 8
    //   515: aastore
    //   516: dup
    //   517: iconst_2
    //   518: iload 4
    //   520: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   523: aastore
    //   524: dup
    //   525: iconst_3
    //   526: aconst_null
    //   527: aastore
    //   528: dup
    //   529: iconst_4
    //   530: aconst_null
    //   531: aastore
    //   532: dup
    //   533: iconst_5
    //   534: aconst_null
    //   535: aastore
    //   536: invokevirtual 598	com/tencent/mobileqq/app/HotChatHandler:notifyUI	(IZLjava/lang/Object;)V
    //   539: aconst_null
    //   540: astore_1
    //   541: aload 7
    //   543: astore_2
    //   544: aload 6
    //   546: astore_3
    //   547: goto -116 -> 431
    //   550: astore_3
    //   551: aconst_null
    //   552: astore_2
    //   553: goto -223 -> 330
    //   556: astore_3
    //   557: goto -227 -> 330
    //   560: astore_3
    //   561: goto -259 -> 302
    //   564: aconst_null
    //   565: astore_2
    //   566: goto -413 -> 153
    //   569: aconst_null
    //   570: astore_1
    //   571: goto -441 -> 130
    //   574: iconst_m1
    //   575: istore 4
    //   577: goto -508 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	580	0	this	HotChatHandler
    //   0	580	1	paramToServiceMsg	ToServiceMsg
    //   0	580	2	paramFromServiceMsg	FromServiceMsg
    //   0	580	3	paramObject	Object
    //   67	509	4	i	int
    //   257	38	5	j	int
    //   70	475	6	localObject	Object
    //   73	469	7	localHotChatInfo	HotChatInfo
    //   10	504	8	arrayOfByte	byte[]
    //   22	487	9	str	String
    //   241	136	10	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   24	32	299	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   91	130	325	java/lang/Exception
    //   130	153	550	java/lang/Exception
    //   153	173	556	java/lang/Exception
    //   32	44	560	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.extraData.getString("groupuin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("memberuin");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1037, false, new Object[] { str, Integer.valueOf(i), paramToServiceMsg, null });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleKickHotChatMemberErrorOrTimeout,result= " + i + ",groupuin=" + str + ",memberUin=" + paramToServiceMsg);
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    localObject = paramToServiceMsg.extraData.getString("groupcode");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        try
        {
          label57:
          oidb_0x88d.RspBody localRspBody;
          localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramFromServiceMsg = paramObject;
          if (localRspBody.stzrspgroupinfo.has()) {
            paramFromServiceMsg = localRspBody.stzrspgroupinfo.get();
          }
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
          {
            paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)paramFromServiceMsg.get(0);
            if (!paramFromServiceMsg.uint32_result.has()) {
              break label639;
            }
            j = paramFromServiceMsg.uint32_result.get();
            i = j;
            if (i != 0) {}
          }
        }
        catch (Exception localException2)
        {
          HotChatInfo localHotChatInfo;
          int j;
          long l;
          paramFromServiceMsg = null;
          continue;
        }
        try
        {
          if (!paramFromServiceMsg.stgroupinfo.has()) {
            break label634;
          }
          paramObject = (oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get();
          if (paramObject == null) {
            break label625;
          }
          paramFromServiceMsg = localHotChatInfo;
          if (paramObject.string_group_memo.has()) {
            paramFromServiceMsg = paramObject.string_group_memo.get().toStringUtf8();
          }
        }
        catch (Exception localException3)
        {
          paramFromServiceMsg = null;
          continue;
        }
        try
        {
          if (!paramObject.uint64_group_owner.has()) {
            break;
          }
          l = paramObject.uint64_group_owner.get();
          paramObject = Long.valueOf(l);
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = paramObject;
          try
          {
            paramObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
            localHotChatInfo = paramObject.a((String)localObject);
            if (localHotChatInfo != null)
            {
              if (paramToServiceMsg == null)
              {
                if (localHotChatInfo.memo != null) {
                  continue;
                }
                localHotChatInfo.memo = paramToServiceMsg;
                localHotChatInfo.memoUrl = null;
                localHotChatInfo.ownerUin = String.valueOf(paramFromServiceMsg);
                paramObject.a(localHotChatInfo);
              }
            }
            else
            {
              notifyUI(1039, true, new Object[] { localObject, Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg });
              j = i;
              localObject = paramToServiceMsg;
              paramObject = paramFromServiceMsg;
              if (QLog.isColorLevel()) {
                QLog.i("HotChatHandler", 2, "handleGetUserCreateHotChatAnnounce,result= " + j + ",memo=" + (String)localObject + ",troopOwner=" + paramObject);
              }
              return;
              paramFromServiceMsg = paramFromServiceMsg;
              paramToServiceMsg = null;
              if (QLog.isColorLevel()) {
                QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
              }
              paramFromServiceMsg = paramToServiceMsg;
              continue;
            }
            if (paramToServiceMsg.equals(localHotChatInfo.memo)) {
              continue;
            }
            localHotChatInfo.memoShowed = false;
            continue;
            paramObject = paramToServiceMsg;
          }
          catch (Exception localException1)
          {
            paramObject = paramFromServiceMsg;
            paramFromServiceMsg = paramToServiceMsg;
            paramToServiceMsg = paramObject;
          }
        }
        catch (Exception localException4)
        {
          continue;
        }
        localObject = paramFromServiceMsg;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.i("HotChatHandler", 2, localException1.toString());
          paramObject = paramToServiceMsg;
          localObject = paramFromServiceMsg;
          j = i;
          continue;
          notifyUI(1039, false, new Object[] { localObject, Integer.valueOf(i), null, paramToServiceMsg });
          localObject = null;
          paramObject = paramToServiceMsg;
          j = i;
          continue;
          notifyUI(1039, false, new Object[] { localObject, Integer.valueOf(i), null, paramToServiceMsg });
          localObject = null;
          paramObject = paramToServiceMsg;
          j = i;
        }
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label642;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label415;
      paramObject = paramFromServiceMsg;
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = paramObject;
      break label249;
      paramObject = null;
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = paramObject;
      break label249;
      paramObject = null;
      break label192;
      break label166;
      i = -1;
      break label57;
    }
    localHotChatInfo = null;
    paramToServiceMsg = Long.valueOf(0L);
    paramObject = null;
    if (i == 0) {
      localRspBody = new oidb_0x88d.RspBody();
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.extraData.getString("groupuin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1038, false, new Object[] { str, Integer.valueOf(i), paramToServiceMsg });
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleDismissHotChatTimeOutOrError,result= " + i + ",groupuin=" + str + ",groupcode=" + paramToServiceMsg);
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str = paramToServiceMsg.extraData.getString("groupcode");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        label55:
        paramToServiceMsg = null;
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
        }
        continue;
        paramFromServiceMsg = new oidb_0x89a.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          boolean bool = paramFromServiceMsg.str_errorinfo.has();
          if (!bool) {}
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
            }
          }
        }
        notifyUI(1040, false, new Object[] { str, Integer.valueOf(i), null });
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
        break label248;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label136;
      i = -1;
      break label55;
    }
    if (i == 0)
    {
      notifyUI(1040, true, new Object[] { str, Integer.valueOf(i), null });
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleSetUserCreateHotChatAnnounce,result= " + i + ",strErr=" + null);
      }
      return;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str1 = paramToServiceMsg.extraData.getString("groupuin");
    str2 = paramToServiceMsg.extraData.getString("groupcode");
    str3 = paramToServiceMsg.extraData.getString("memberuin");
    str4 = paramToServiceMsg.extraData.getString("nickname");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        try
        {
          label93:
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (paramToServiceMsg.msg_kick_visitor.has()) {
            paramToServiceMsg = (oidb_0x823.KickPublicGroupVisitorRspBody)paramToServiceMsg.msg_kick_visitor.get();
          }
          AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(str2), str4 + BaseApplicationImpl.getContext().getString(2131693244), 1, false, true);
          notifyUI(1052, true, new Object[] { str1, Integer.valueOf(i), str3, null });
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandlerQ.hotchat.hotchat_kick_mem_by_global_admin", 2, "handleKickHotChatMemberByGlobalAmdminResp,result= " + i + ",groupuin=" + str1 + ",memberUin=" + str3 + ",strErr=" + null);
          }
          return;
          paramObject = paramObject;
          paramToServiceMsg = null;
          paramFromServiceMsg = paramToServiceMsg;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("HotChatHandler", 2, paramObject.toString());
          paramFromServiceMsg = paramToServiceMsg;
        }
        catch (Exception paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
          continue;
        }
        notifyUI(1052, false, new Object[] { str1, Integer.valueOf(i), str3, null });
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label372;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      break label288;
      i = -1;
      break label93;
    }
    if (i == 0) {
      paramToServiceMsg = new oidb_0x823.RspBody();
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str1 = paramToServiceMsg.extraData.getString("groupuin");
    String str3 = paramToServiceMsg.extraData.getString("groupcode");
    str2 = paramToServiceMsg.extraData.getString("memberuin");
    String str4 = paramToServiceMsg.extraData.getString("nickname");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        label93:
        paramToServiceMsg = null;
        paramFromServiceMsg = paramToServiceMsg;
        if (QLog.isColorLevel())
        {
          QLog.i("HotChatHandler", 2, paramObject.toString());
          paramFromServiceMsg = paramToServiceMsg;
          continue;
          notifyUI(1037, false, new Object[] { str1, Integer.valueOf(i), str2, null });
          paramToServiceMsg = null;
        }
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label374;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      break label286;
      i = -1;
      break label93;
    }
    paramToServiceMsg = null;
    if (i == 0)
    {
      paramObject = new oidb_0x89b.RspBody();
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (paramObject.str_err_msg.has()) {
          paramToServiceMsg = paramObject.str_err_msg.get();
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
          }
          paramToServiceMsg = null;
        }
      }
      AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(str3), str4 + BaseApplicationImpl.getContext().getString(2131693244), 1, false, true);
      notifyUI(1037, true, new Object[] { str1, Integer.valueOf(i), str2, paramToServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleKickHotChatMemberResp,result= " + i + ",groupuin=" + str1 + ",memberUin=" + str2 + ",strErr=" + paramToServiceMsg);
      }
      return;
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str = paramToServiceMsg.extraData.getString("groupcode");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        label57:
        paramToServiceMsg = null;
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
        }
        continue;
        notifyUI(1038, false, new Object[] { str, Integer.valueOf(i), null });
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = null;
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
        break label295;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label218;
      i = -1;
      break label57;
    }
    if (i == 0)
    {
      paramObject = new oidb_0xa81.RspBody();
      try
      {
        paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg = paramFromServiceMsg;
        if (paramObject.str_err_msg.has()) {
          paramToServiceMsg = paramObject.str_err_msg.get().toStringUtf8();
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
          }
          paramToServiceMsg = null;
        }
      }
      paramFromServiceMsg = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      paramObject = paramFromServiceMsg.a(str);
      if (paramObject != null) {
        paramFromServiceMsg.a(paramObject, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
      }
      notifyUI(1038, true, new Object[] { str, Integer.valueOf(i), paramToServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandler", 2, "handleDismissHotChat,result= " + i + ",groupcode=" + str);
      }
      return;
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isHotChat");
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Integer.valueOf(-1);
    paramToServiceMsg[2] = Boolean.valueOf(bool);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatHandler", 2, "handleGetTroopInfo isHotChat = " + bool);
    }
    if ((paramObject == null) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      notifyUI(1047, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
      {
        notifyUI(1047, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      notifyUI(1047, false, paramToServiceMsg);
      return;
    }
    paramObject = new oidb_0x88d.RspBody();
    int i;
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = paramObject.stzrspgroupinfo.get();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
        break label364;
      }
      paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)paramFromServiceMsg.get(0);
      i = paramFromServiceMsg.uint32_result.get();
      if (i == 0)
      {
        notifyUI(1047, true, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool), (oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get() });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      notifyUI(1047, false, paramToServiceMsg);
      return;
    }
    notifyUI(1047, false, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
    return;
    label364:
    notifyUI(1047, false, paramToServiceMsg);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("uitag"));
    if ((paramFromServiceMsg == null) || (paramObject == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
    }
    for (;;)
    {
      return;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramObject == null) || (!paramObject.uint32_result.has()) || (!paramObject.bytes_bodybuffer.has()) || (paramObject.bytes_bodybuffer.get() == null))
        {
          notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
        return;
      }
      paramFromServiceMsg = new cmd0x897.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        if (paramFromServiceMsg.uint32_result.has()) {
          if (paramFromServiceMsg.uint32_result.get() == 0)
          {
            if (!paramFromServiceMsg.rpt_msg_grp_visitor_info.isEmpty()) {
              notifyUI(1046, true, new Object[] { Integer.valueOf(0), paramFromServiceMsg.rpt_msg_grp_visitor_info.get(), paramToServiceMsg });
            }
            while (QLog.isColorLevel())
            {
              int i = -1;
              if (paramFromServiceMsg.uint32_result.has()) {
                i = paramFromServiceMsg.uint32_result.get();
              }
              QLog.i("HotChatHandler", 2, "handleGetHotChatTroopMemberList.result=" + i);
              return;
              notifyUI(1046, false, new Object[] { Integer.valueOf(2), null, paramToServiceMsg });
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
          continue;
          notifyUI(1046, false, new Object[] { Integer.valueOf(3), null, paramToServiceMsg });
          continue;
          notifyUI(1046, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
        }
      }
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("uins");
    int k = paramToServiceMsg.extraData.getInt("serviceType");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      try
      {
        label93:
        label225:
        do
        {
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramToServiceMsg = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
          paramFromServiceMsg = paramToServiceMsg.a(str);
          if (paramFromServiceMsg == null) {
            break label307;
          }
          if ((localArrayList == null) || (localArrayList.size() <= 0)) {
            break label302;
          }
          j = 0;
          for (;;)
          {
            if (j >= localArrayList.size()) {
              break label302;
            }
            paramObject = (String)localArrayList.get(j);
            if ((k != 5) || (paramFromServiceMsg.adminUins.contains(paramObject))) {
              break;
            }
            paramFromServiceMsg.adminUins.add(paramObject);
            j += 1;
          }
          paramObject = paramObject;
          paramToServiceMsg = null;
          paramFromServiceMsg = paramToServiceMsg;
        } while (!QLog.isColorLevel());
        QLog.i("HotChatHandler", 2, paramObject.toString());
        paramFromServiceMsg = paramToServiceMsg;
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
            continue;
            if ((k == 6) && (paramFromServiceMsg.adminUins.contains(paramObject))) {
              paramFromServiceMsg.adminUins.remove(paramObject);
            }
          }
        }
        label302:
        paramToServiceMsg.a(paramFromServiceMsg);
        label307:
        notifyUI(1050, true, new Object[] { str, arrayOfByte, Integer.valueOf(i), Integer.valueOf(k), localArrayList });
      }
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandlerQ.hotchat.setadmin", 2, "handleSetHotChatAdminFlag==>,operaUins=" + localArrayList);
      }
      return;
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label435;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      break label225;
      i = -1;
      break label93;
    }
    if (i == 0) {
      paramToServiceMsg = new oidb_0x8b2.RspBody();
    }
    for (;;)
    {
      int j;
      notifyUI(1050, false, new Object[] { str, arrayOfByte, Integer.valueOf(i), Integer.valueOf(k), localArrayList });
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.hotchat.remainCount", 2, "req == null || res == null");
      }
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Boolean.valueOf(false);
    arrayOfObject[2] = "";
    arrayOfObject[3] = "";
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.hotchat.remainCount", 2, "time out or error");
      }
      notifyUI(1053, false, arrayOfObject);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(1053, false, arrayOfObject);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        notifyUI(1053, false, arrayOfObject);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(1053, false, arrayOfObject);
      return;
    }
    paramObject = new cmd0x8a7.RspBody();
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        boolean bool = paramObject.bool_can_at_all.get();
        if (!paramObject.bytes_prompt_msg_1.has()) {
          break label483;
        }
        paramToServiceMsg = paramObject.bytes_prompt_msg_1.get().toStringUtf8();
        if (!paramObject.bytes_prompt_msg_2.has()) {
          break label476;
        }
        paramFromServiceMsg = paramObject.bytes_prompt_msg_2.get().toStringUtf8();
        if (!paramObject.uint32_remain_at_all_count_for_group.has()) {
          break label470;
        }
        i = paramObject.uint32_remain_at_all_count_for_group.get();
        if (paramObject.uint32_remain_at_all_count_for_uin.has())
        {
          j = paramObject.uint32_remain_at_all_count_for_uin.get();
          if (QLog.isColorLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append("handleGetAtAllRemainCountInfo:").append("troopCode:").append(str).append(",groupRemainCnt:").append(i).append(",memberRemainCount:").append(j).append(", beCanAtAll:").append(bool).append(",tips1:").append(paramToServiceMsg).append(",tips2:").append(paramFromServiceMsg);
            QLog.d("Q.hotchat.remainCount", 2, paramObject.toString());
          }
          notifyUI(1053, true, new Object[] { str, Boolean.valueOf(bool), paramToServiceMsg, paramFromServiceMsg });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        notifyUI(1053, false, arrayOfObject);
        return;
      }
      int j = 0;
      continue;
      label470:
      int i = 0;
      continue;
      label476:
      paramFromServiceMsg = "";
      continue;
      label483:
      paramToServiceMsg = "";
    }
  }
  
  public void a()
  {
    a(0);
    if (SharedPreUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), getCurrentAccountUin())) {
      a(2);
    }
    if (SharedPreUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), getCurrentAccountUin())) {
      ((WerewolvesHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(new HotChatHandler.1(this));
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatHandler", new Object[] { "getMyHotChatList()", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    Object localObject = new GetJoinedHotChatList.ReqBody();
    ((GetJoinedHotChatList.ReqBody)localObject).uint64_uin.set(l);
    ((GetJoinedHotChatList.ReqBody)localObject).uint32_req_type.set(3);
    localObject = makeOIDBPkg("OidbSvc.0x8a4", 2212, paramInt, ((GetJoinedHotChatList.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).setTimeout(10000L);
    ((ToServiceMsg)localObject).extraData.putInt("serviceType", paramInt);
    sendPbReq((ToServiceMsg)localObject);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(long paramLong, String paramString)
  {
    oidb_0x81f.ReqBody localReqBody = new oidb_0x81f.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    try
    {
      localReqBody.gc.set(Long.parseLong(paramString));
      paramString = new oidb_0x81f.GetAuthDataReq();
      paramString.uint32_auth.set(1);
      localReqBody.msg_auth_data.set(paramString);
      paramString = makeOIDBPkg("OidbSvc.0x81f", 2079, 0, localReqBody.toByteArray());
      paramString.extraData.putLong("uin", paramLong);
      sendPbReq(paramString);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("HotChatHandler", 2, "getGlobalAdmin, NumberFormatException. troopUin:" + paramString);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, List<Long> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotChatHandlerQ.hotchat.setadmin", 2, "setHotChatAdminFlag:|serviceType:" + paramInt);
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.e("HotChatHandlerQ.hotchat.setadmin", 2, "memberUins is empty!");
      }
    }
    ToServiceMsg localToServiceMsg;
    for (;;)
    {
      return;
      if ((paramInt != 5) && (paramInt != 6))
      {
        if (QLog.isColorLevel()) {
          QLog.e("HotChatHandlerQ.hotchat.setadmin", 2, "serviceType is not correct!");
        }
      }
      else
      {
        oidb_0x8b2.ReqBody localReqBody = new oidb_0x8b2.ReqBody();
        try
        {
          localReqBody.uint64_group_code.set(Long.parseLong(paramString));
          HotChatInfo localHotChatInfo = ((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
          localToServiceMsg = null;
          paramQQAppInterface = localToServiceMsg;
          if (localHotChatInfo != null)
          {
            paramQQAppInterface = localToServiceMsg;
            if (localHotChatInfo.uuid != null)
            {
              paramQQAppInterface = localHotChatInfo.uuid.getBytes();
              localReqBody.string_hot_group_id.set(ByteStringMicro.copyFrom(paramQQAppInterface));
            }
          }
          localReqBody.uint64_administrator_uin.set(paramList);
          localToServiceMsg = makeOIDBPkg("OidbSvc.0x8b2", 2226, paramInt, localReqBody.toByteArray());
          localToServiceMsg.extraData.putInt("serviceType", paramInt);
          localToServiceMsg.extraData.putByteArray("uid", paramQQAppInterface);
          localToServiceMsg.extraData.putString("troop_uin", paramString);
          paramQQAppInterface = new ArrayList();
          paramInt = 0;
          while (paramInt < paramList.size())
          {
            paramQQAppInterface.add(paramList.get(paramInt) + "");
            paramInt += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (NumberFormatException paramQQAppInterface) {}
      }
    }
    QLog.e("HotChatHandlerQ.hotchat.setadmin", 2, "NumberFormatException ,troopUinis not correct," + paramString);
    return;
    localToServiceMsg.extraData.putStringArrayList("uins", paramQQAppInterface);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(HotChatInfo paramHotChatInfo, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatHandler", new Object[] { "exitHotChat", paramHotChatInfo, paramHotChatStateWrapper });
    }
    if (paramHotChatInfo == null)
    {
      notifyUI(1033, false, new Object[] { "", jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject = new oidb_0x89b.ExitPublicGroupReqBody();
    ((oidb_0x89b.ExitPublicGroupReqBody)localObject).uint64_visitor_uin.set(BizTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    oidb_0x89b.ReqBody localReqBody = new oidb_0x89b.ReqBody();
    localReqBody.uint64_group_code.set(BizTroopHandler.a(paramHotChatInfo.troopUin));
    localReqBody.uint32_req_type.set(5);
    localReqBody.msg_exit_group.set((MessageMicro)localObject);
    localObject = makeOIDBPkg("OidbSvc.0x89b_3", 2203, 3, localReqBody.toByteArray(), 10000L);
    ((ToServiceMsg)localObject).extraData.putBoolean("isJoin", false);
    ((ToServiceMsg)localObject).extraData.putString("troopUin", paramHotChatInfo.troopUin);
    ((ToServiceMsg)localObject).extraData.putSerializable("targetHotChatState", paramHotChatStateWrapper);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: new 331	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 799	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: new 331	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 799	java/util/ArrayList:<init>	()V
    //   16: astore 6
    //   18: aload_1
    //   19: ifnull +17 -> 36
    //   22: aload_3
    //   23: ifnull +13 -> 36
    //   26: aload_2
    //   27: invokevirtual 687	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   30: sipush 1000
    //   33: if_icmpeq +26 -> 59
    //   36: aload_0
    //   37: sipush 1058
    //   40: iconst_0
    //   41: iconst_2
    //   42: anewarray 97	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload 5
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload 6
    //   54: aastore
    //   55: invokevirtual 598	com/tencent/mobileqq/app/HotChatHandler:notifyUI	(IZLjava/lang/Object;)V
    //   58: return
    //   59: new 689	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   62: dup
    //   63: invokespecial 690	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   66: astore_1
    //   67: aload_1
    //   68: aload_3
    //   69: checkcast 692	[B
    //   72: checkcast 692	[B
    //   75: invokevirtual 696	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   78: pop
    //   79: aload_1
    //   80: ifnull +177 -> 257
    //   83: aload_1
    //   84: getfield 699	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   87: invokevirtual 700	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   90: ifeq +167 -> 257
    //   93: aload_1
    //   94: getfield 699	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   97: invokevirtual 702	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   100: ifne -42 -> 58
    //   103: new 1278	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$RspBody
    //   106: dup
    //   107: invokespecial 1279	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$RspBody:<init>	()V
    //   110: astore_2
    //   111: aload_2
    //   112: aload_1
    //   113: getfield 737	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   116: invokevirtual 740	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   119: invokevirtual 741	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   122: invokevirtual 1280	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   125: pop
    //   126: new 331	java/util/ArrayList
    //   129: dup
    //   130: invokespecial 799	java/util/ArrayList:<init>	()V
    //   133: pop
    //   134: aload_2
    //   135: getfield 1283	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$RspBody:msg_tinyid_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   138: invokevirtual 798	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   141: astore_1
    //   142: iconst_0
    //   143: istore 4
    //   145: iload 4
    //   147: aload_1
    //   148: invokeinterface 147 1 0
    //   153: if_icmpge +127 -> 280
    //   156: aload 6
    //   158: aload_1
    //   159: iload 4
    //   161: invokeinterface 216 2 0
    //   166: checkcast 1285	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$TinyIDInfo
    //   169: getfield 1288	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$TinyIDInfo:uint64_tinyid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   172: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   175: invokestatic 169	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   178: invokevirtual 911	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   181: pop
    //   182: aload 5
    //   184: aload_1
    //   185: iload 4
    //   187: invokeinterface 216 2 0
    //   192: checkcast 1285	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$TinyIDInfo
    //   195: getfield 1289	tencent/im/oidb/cmd0x62c/oidb_cmd0x62c$TinyIDInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   198: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   201: invokestatic 169	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   204: invokevirtual 911	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   207: pop
    //   208: iload 4
    //   210: iconst_1
    //   211: iadd
    //   212: istore 4
    //   214: goto -69 -> 145
    //   217: astore_1
    //   218: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +13 -> 234
    //   224: ldc 69
    //   226: iconst_2
    //   227: aload_1
    //   228: invokevirtual 877	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   231: invokestatic 594	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload_0
    //   235: sipush 1058
    //   238: iconst_0
    //   239: iconst_2
    //   240: anewarray 97	java/lang/Object
    //   243: dup
    //   244: iconst_0
    //   245: aload 5
    //   247: aastore
    //   248: dup
    //   249: iconst_1
    //   250: aload 6
    //   252: aastore
    //   253: invokevirtual 598	com/tencent/mobileqq/app/HotChatHandler:notifyUI	(IZLjava/lang/Object;)V
    //   256: return
    //   257: aload_0
    //   258: sipush 1058
    //   261: iconst_0
    //   262: iconst_2
    //   263: anewarray 97	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: aload 5
    //   270: aastore
    //   271: dup
    //   272: iconst_1
    //   273: aload 6
    //   275: aastore
    //   276: invokevirtual 598	com/tencent/mobileqq/app/HotChatHandler:notifyUI	(IZLjava/lang/Object;)V
    //   279: return
    //   280: aload_0
    //   281: sipush 1058
    //   284: iconst_1
    //   285: iconst_2
    //   286: anewarray 97	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: aload 5
    //   293: aastore
    //   294: dup
    //   295: iconst_1
    //   296: aload 6
    //   298: aastore
    //   299: invokevirtual 598	com/tencent/mobileqq/app/HotChatHandler:notifyUI	(IZLjava/lang/Object;)V
    //   302: return
    //   303: astore_1
    //   304: aload_0
    //   305: sipush 1058
    //   308: iconst_0
    //   309: iconst_2
    //   310: anewarray 97	java/lang/Object
    //   313: dup
    //   314: iconst_0
    //   315: aload 5
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: aload 6
    //   322: aastore
    //   323: invokevirtual 598	com/tencent/mobileqq/app/HotChatHandler:notifyUI	(IZLjava/lang/Object;)V
    //   326: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq -271 -> 58
    //   332: ldc 69
    //   334: iconst_2
    //   335: aload_1
    //   336: invokevirtual 877	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   339: invokestatic 594	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	HotChatHandler
    //   0	343	1	paramToServiceMsg	ToServiceMsg
    //   0	343	2	paramFromServiceMsg	FromServiceMsg
    //   0	343	3	paramObject	Object
    //   143	70	4	i	int
    //   7	309	5	localArrayList1	ArrayList
    //   16	305	6	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   59	79	217	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   111	142	303	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   145	208	303	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   280	302	303	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void a(String paramString)
  {
    notifyUI(1056, true, new Object[] { paramString, b });
  }
  
  public void a(String paramString1, String paramString2)
  {
    notifyUI(1055, true, new Object[] { paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    notifyUI(1054, true, new Object[] { paramString1, paramString2, paramString3 });
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    oidb_cmd0x62c.ReqBody localReqBody = new oidb_cmd0x62c.ReqBody();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localArrayList.add(Long.valueOf((String)paramArrayList.get(i)));
      i += 1;
    }
    localReqBody.uint64_tinyid.set(localArrayList);
    sendPbReq(makeOIDBPkg("OidbSvc.0x62c_4", 1580, 4, localReqBody.toByteArray(), 10000L));
  }
  
  public void a(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {}
    try
    {
      QLog.i("HotChatHandler", 2, "joinHotChat() WifiPOIInfo = " + paramWifiPOIInfo.bytes_name.get().toStringUtf8() + ", " + paramWifiPOIInfo.bytes_uid.get().toStringUtf8());
      label60:
      int i = 0;
      String str = null;
      if (paramWifiPOIInfo.uint32_group_uin.has()) {
        str = String.valueOf(Utils.a(paramWifiPOIInfo.uint32_group_uin.get()));
      }
      if ((str == null) || (str.equals("")) || (str.equals("0"))) {
        i = 1;
      }
      if (i != 0)
      {
        a(paramWifiPOIInfo, paramBoolean, paramInt2);
        return;
      }
      try
      {
        a(paramWifiPOIInfo.bytes_uid.get().toStringUtf8(), paramInt2, true, paramInt1);
        return;
      }
      catch (Exception paramWifiPOIInfo)
      {
        paramWifiPOIInfo.printStackTrace();
        return;
      }
    }
    catch (Exception localException)
    {
      break label60;
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "getUserCreateHotChatAnnounce.groupcode=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.set(1L);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_memo.set(ByteStringMicro.copyFrom("1".getBytes()));
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.valueOf(paramString).longValue());
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = makeOIDBPkg("OidbSvc.0x88d_0", 2189, 6, ((oidb_0x88d.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("groupcode", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("serviceType", 6);
    sendPbReq((ToServiceMsg)localObject1);
    return true;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramBoolean, 4);
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return a(paramString, paramInt1, paramBoolean, paramInt2, -1);
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      localObject2 = a(false);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!paramBoolean) {
          localObject1 = new LBS.LBSInfo();
        }
      }
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("HotChatHandler", 2, "quickJoinHotChat, lbs is null, needLBS = " + paramBoolean);
    return false;
    Object localObject2 = new oidb_0x8ab.ReqBody();
    ((oidb_0x8ab.ReqBody)localObject2).hotnamecode.set(ByteStringMicro.copyFromUtf8(paramString));
    ((oidb_0x8ab.ReqBody)localObject2).lbs_info.set((MessageMicro)localObject1);
    ((oidb_0x8ab.ReqBody)localObject2).version_flag.set(1);
    Object localObject1 = makeOIDBPkg("OidbSvc.0x8ab", 2219, 0, ((oidb_0x8ab.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("hotnamecode", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("HOTCHAT_EXTRA_FLAG", paramInt1);
    ((ToServiceMsg)localObject1).extraData.putInt("preHotChatState", paramInt2);
    if (paramInt3 > 0) {
      ((ToServiceMsg)localObject1).extraData.putInt("apolloGameId", paramInt3);
    }
    sendPbReq((ToServiceMsg)localObject1);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "setUserCreateHotChatAnnounce.groupcode=" + paramString1 + ",memo=" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null)) {
      return false;
    }
    oidb_0x89a.groupinfo localgroupinfo = new oidb_0x89a.groupinfo();
    localgroupinfo.string_group_memo.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    oidb_0x89a.ReqBody localReqBody = new oidb_0x89a.ReqBody();
    localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
    localReqBody.uint64_original_operator_uin.set(Long.valueOf(paramString2).longValue());
    localReqBody.st_group_info.set(localgroupinfo);
    paramString2 = makeOIDBPkg("OidbSvc.0x89a_0", 2202, 0, localReqBody.toByteArray());
    paramString2.extraData.putString("groupcode", paramString1);
    sendPbReq(paramString2);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandlerQ.hotchat.hotchat_kick_mem_by_global_admin", 2, "kickHotChatMemberByGlobalAdmin.groupcode=" + paramString1 + ",groupuin=" + paramString2 + ",memberuin=" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    Object localObject2 = new ArrayList();
    try
    {
      ((List)localObject2).add(Long.valueOf(Long.parseLong(paramString3)));
      Object localObject1 = new oidb_0x823.KickPublicGroupVisitorReqBody();
      ((oidb_0x823.KickPublicGroupVisitorReqBody)localObject1).rpt_uint64_visitor_uin.set((List)localObject2);
      localObject2 = new oidb_0x823.PlayerDeviceInfo();
      ((oidb_0x823.PlayerDeviceInfo)localObject2).int32_client_type.set(1);
      ((oidb_0x823.PlayerDeviceInfo)localObject2).uint32_portal.set(paramInt);
      oidb_0x823.ReqBody localReqBody = new oidb_0x823.ReqBody();
      localReqBody.msg_kick_visitor.set((MessageMicro)localObject1);
      localReqBody.uint64_group_uin.set(Long.valueOf(paramString2).longValue());
      localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
      localReqBody.msg_req_info.set((MessageMicro)localObject2);
      localObject1 = makeOIDBPkg("OidbSvc.0x823_0", 2083, 0, localReqBody.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("groupcode", paramString1);
      ((ToServiceMsg)localObject1).extraData.putString("groupuin", paramString2);
      ((ToServiceMsg)localObject1).extraData.putString("memberuin", paramString3);
      ((ToServiceMsg)localObject1).extraData.putBoolean("kick", true);
      ((ToServiceMsg)localObject1).extraData.putString("nickname", paramString4);
      sendPbReq((ToServiceMsg)localObject1);
      return true;
    }
    catch (NumberFormatException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatHandlerQ.hotchat.hotchat_kick_mem_by_global_admin", 2, "kickHotChatMemberByGlobalAdmin.NumberFormatException");
      }
    }
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, "getHotChatAnnounce.uid=" + new String(paramArrayOfByte) + ", troopUin=" + paramString);
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return false;
    }
    Object localObject = new oidb_0x8b2.ReqBody();
    ((oidb_0x8b2.ReqBody)localObject).string_hot_group_id.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localObject = makeOIDBPkg("OidbSvc.0x8b2", 2226, 2, ((oidb_0x8b2.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("serviceType", 2);
    ((ToServiceMsg)localObject).extraData.putByteArray("uid", paramArrayOfByte);
    ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramString);
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "setHotChatAnnounce.memo=" + paramString1 + ",url=" + paramString2 + ",uid=" + new String(paramArrayOfByte));
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return false;
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "";
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    paramString2 = new oidb_0x8b3.ReqBody();
    paramString2.string_hot_group_id.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    oidb_0x8b3.groupinfo localgroupinfo = new oidb_0x8b3.groupinfo();
    localgroupinfo.string_group_memo.set(ByteStringMicro.copyFrom(str.getBytes()));
    localgroupinfo.string_jumping_url.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramString2.st_group_info.set(localgroupinfo);
    paramString1 = makeOIDBPkg("OidbSvc.0x8b3", 2227, 0, paramString2.toByteArray());
    paramString1.extraData.putByteArray("uid", paramArrayOfByte);
    sendPbReq(paramString1);
    return true;
  }
  
  /* Error */
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: new 71	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   7: aload_1
    //   8: getfield 50	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11: ldc_w 1203
    //   14: invokevirtual 1041	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   17: invokevirtual 1462	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: ldc_w 770
    //   23: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 7
    //   31: new 689	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   34: dup
    //   35: invokespecial 690	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   38: astore_1
    //   39: aload_1
    //   40: aload_3
    //   41: checkcast 692	[B
    //   44: checkcast 692	[B
    //   47: invokevirtual 696	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   50: pop
    //   51: aload_1
    //   52: astore_2
    //   53: iconst_m1
    //   54: istore 5
    //   56: iload 5
    //   58: istore 4
    //   60: aload_2
    //   61: ifnull +26 -> 87
    //   64: iload 5
    //   66: istore 4
    //   68: aload_2
    //   69: getfield 699	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: invokevirtual 700	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   75: ifeq +12 -> 87
    //   78: aload_2
    //   79: getfield 699	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 702	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: istore 4
    //   87: iload 4
    //   89: ifne +234 -> 323
    //   92: new 1464	tencent/im/oidb/hotchat/oidb_0x81f$RspBody
    //   95: dup
    //   96: invokespecial 1465	tencent/im/oidb/hotchat/oidb_0x81f$RspBody:<init>	()V
    //   99: astore_1
    //   100: aload_1
    //   101: aload_2
    //   102: getfield 737	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   105: invokevirtual 740	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   108: invokevirtual 741	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   111: invokevirtual 1466	tencent/im/oidb/hotchat/oidb_0x81f$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   114: pop
    //   115: aload_1
    //   116: getfield 1469	tencent/im/oidb/hotchat/oidb_0x81f$RspBody:msg_auth_data	Ltencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp;
    //   119: invokevirtual 1472	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp:has	()Z
    //   122: ifeq +243 -> 365
    //   125: aload_1
    //   126: getfield 1469	tencent/im/oidb/hotchat/oidb_0x81f$RspBody:msg_auth_data	Ltencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp;
    //   129: invokevirtual 1473	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   132: checkcast 1471	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp
    //   135: astore_1
    //   136: aload_1
    //   137: getfield 1474	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp:uint32_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   140: invokevirtual 702	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   143: istore 4
    //   145: aload_0
    //   146: getfield 36	com/tencent/mobileqq/app/HotChatHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   149: getstatic 109	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   152: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   155: checkcast 117	com/tencent/mobileqq/app/HotChatManager
    //   158: astore_2
    //   159: iload 4
    //   161: ifne +125 -> 286
    //   164: iconst_1
    //   165: istore 6
    //   167: aload_2
    //   168: iload 6
    //   170: invokevirtual 1476	com/tencent/mobileqq/app/HotChatManager:a	(Z)V
    //   173: iload 4
    //   175: ifne +14 -> 189
    //   178: aload_2
    //   179: aload_1
    //   180: getfield 1479	tencent/im/oidb/hotchat/oidb_0x81f$GetAuthDataRsp:uint64_timestamp	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   183: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   186: invokevirtual 1481	com/tencent/mobileqq/app/HotChatManager:a	(J)V
    //   189: aload_0
    //   190: sipush 1051
    //   193: iconst_1
    //   194: iconst_2
    //   195: anewarray 97	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: aload 7
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: iload 4
    //   207: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: aastore
    //   211: invokevirtual 598	com/tencent/mobileqq/app/HotChatHandler:notifyUI	(IZLjava/lang/Object;)V
    //   214: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +42 -> 259
    //   220: ldc_w 1069
    //   223: iconst_2
    //   224: new 71	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 1483
    //   234: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload 7
    //   239: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc_w 1485
    //   245: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: iload 4
    //   250: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 594	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: return
    //   260: astore_3
    //   261: aconst_null
    //   262: astore_1
    //   263: aload_1
    //   264: astore_2
    //   265: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq -215 -> 53
    //   271: ldc 69
    //   273: iconst_2
    //   274: aload_3
    //   275: invokevirtual 877	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   278: invokestatic 594	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_1
    //   282: astore_2
    //   283: goto -230 -> 53
    //   286: iconst_0
    //   287: istore 6
    //   289: goto -122 -> 167
    //   292: astore_1
    //   293: iconst_0
    //   294: istore 5
    //   296: iload 5
    //   298: istore 4
    //   300: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq -114 -> 189
    //   306: ldc 69
    //   308: iconst_2
    //   309: aload_1
    //   310: invokevirtual 861	java/lang/Exception:toString	()Ljava/lang/String;
    //   313: invokestatic 594	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: iload 5
    //   318: istore 4
    //   320: goto -131 -> 189
    //   323: aload_0
    //   324: sipush 1051
    //   327: iconst_0
    //   328: iconst_2
    //   329: anewarray 97	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: aload 7
    //   336: aastore
    //   337: dup
    //   338: iconst_1
    //   339: iconst_0
    //   340: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   343: aastore
    //   344: invokevirtual 598	com/tencent/mobileqq/app/HotChatHandler:notifyUI	(IZLjava/lang/Object;)V
    //   347: iconst_0
    //   348: istore 4
    //   350: goto -136 -> 214
    //   353: astore_1
    //   354: iload 4
    //   356: istore 5
    //   358: goto -62 -> 296
    //   361: astore_3
    //   362: goto -99 -> 263
    //   365: iconst_0
    //   366: istore 4
    //   368: goto -179 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	HotChatHandler
    //   0	371	1	paramToServiceMsg	ToServiceMsg
    //   0	371	2	paramFromServiceMsg	FromServiceMsg
    //   0	371	3	paramObject	Object
    //   58	309	4	i	int
    //   54	303	5	j	int
    //   165	123	6	bool	boolean
    //   29	306	7	str	String
    // Exception table:
    //   from	to	target	type
    //   31	39	260	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   100	145	292	java/lang/Exception
    //   145	159	353	java/lang/Exception
    //   167	173	353	java/lang/Exception
    //   178	189	353	java/lang/Exception
    //   39	51	361	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void b(String paramString1, String paramString2)
  {
    notifyUI(1057, true, new Object[] { paramString1, paramString2 });
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramString1), paramString3 + BaseApplicationImpl.getContext().getString(2131693244), 1, false, true);
    notifyUI(1037, true, new Object[] { paramString1, Integer.valueOf(0), paramString2, "" });
  }
  
  public boolean b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "kickHotChatMember.groupcode=" + paramString1 + ",groupuin=" + paramString2 + ",memberuin=" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true).b()) {
      return a(paramString1, paramString2, paramString3, paramString4, paramInt);
    }
    Object localObject = new oidb_0x89b.KickPublicGroupVisitorReqBody();
    ((oidb_0x89b.KickPublicGroupVisitorReqBody)localObject).rpt_uint64_visitor_uin.add(Long.valueOf(paramString3));
    oidb_0x89b.ReqBody localReqBody = new oidb_0x89b.ReqBody();
    localReqBody.uint64_group_uin.set(Long.valueOf(paramString2).longValue());
    localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
    localReqBody.uint32_req_type.set(6);
    localReqBody.msg_kick_visitor.set((MessageMicro)localObject);
    localObject = makeOIDBPkg("OidbSvc.0x89b_3", 2203, 5, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("groupcode", paramString1);
    ((ToServiceMsg)localObject).extraData.putString("groupuin", paramString2);
    ((ToServiceMsg)localObject).extraData.putString("memberuin", paramString3);
    ((ToServiceMsg)localObject).extraData.putBoolean("kick", true);
    ((ToServiceMsg)localObject).extraData.putString("nickname", paramString4);
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x8a4");
      this.allowCmdSet.add("OidbSvc.0x89b_3");
      this.allowCmdSet.add("OidbSvc.0x823_0");
      this.allowCmdSet.add("OidbSvc.0x8a2");
      this.allowCmdSet.add("OidbSvc.0x8ab");
      this.allowCmdSet.add("OidbSvc.0x8b3");
      this.allowCmdSet.add("OidbSvc.0x8b2");
      this.allowCmdSet.add("OidbSvc.0x81f");
      this.allowCmdSet.add("OidbSvc.0xa81");
      this.allowCmdSet.add("OidbSvc.0x88d_0");
      this.allowCmdSet.add("OidbSvc.0x89a_0");
      this.allowCmdSet.add("OidbSvc.0x435");
      this.allowCmdSet.add("OidbSvc.0x897_0");
      this.allowCmdSet.add("OidbSvc.0x88d_1");
      this.allowCmdSet.add("OidbSvc.0xa8b");
      this.allowCmdSet.add("OidbSvc.0x8a3_7");
      this.allowCmdSet.add("OidbSvc.0x8a7_0");
      this.allowCmdSet.add("OidbSvc.0x62c_4");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return HotChatObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatHandler", 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramFromServiceMsg.getResultCode() == 1002)
          {
            b(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          if (paramFromServiceMsg.getResultCode() != 1000)
          {
            a(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          if ("OidbSvc.0x8a4".equals(str))
          {
            f(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x89b_3".equals(str))
          {
            c(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x823_0".equals(str))
          {
            l(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x8a2".equals(str))
          {
            e(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x8ab".equals(str))
          {
            g(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x8b3".equals(str))
          {
            h(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x8b2".equals(str))
          {
            b(paramToServiceMsg, paramFromServiceMsg, paramObject, str);
            return;
          }
          if ("OidbSvc.0x81f".equals(str))
          {
            b(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0xa81".equals(str))
          {
            n(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x88d_0".equals(str))
          {
            a(paramToServiceMsg, paramFromServiceMsg, paramObject, str);
            return;
          }
          if ("OidbSvc.0x89a_0".equals(str))
          {
            k(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
        } while ("OidbSvc.0x435".equals(str));
        if ("OidbSvc.0x897_0".equals(str))
        {
          p(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x88d_1".equals(str))
        {
          o(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while ("OidbSvc.0x8a3_7".equals(str));
      if ("OidbSvc.0x8a7_0".equals(str))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x62c_4".equals(str));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatHandler
 * JD-Core Version:    0.7.0.1
 */