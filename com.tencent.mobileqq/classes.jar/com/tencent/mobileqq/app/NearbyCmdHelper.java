package com.tencent.mobileqq.app;

import EncounterSvc.ReqGetEncounterV2;
import EncounterSvc.RespGetEncounterV2;
import EncounterSvc.UserData;
import NearbyPubAcct.ReqGetNearbyPubAcctInfo;
import NeighborComm.LocalInfoType;
import NeighborComm.RespHeader;
import NeighborComm.SOSO_Cell;
import NeighborComm.SOSO_Wifi;
import NeighborSvc.ReqGetPoint;
import NeighborSvc.RespGetPoint;
import NeighborSvc.UserDetailLocalInfo;
import QQService.ReqFavorite;
import QQService.ReqHead;
import QQService.RespFavorite;
import QQService.RespHead;
import android.os.Bundle;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestTag;
import appoint.define.appoint_define.LocaleInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.nearby.LbsUtils;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.lbs.LBSService;
import com.tencent.mobileqq.service.lbs.NearbyProtocolCoder;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoCell;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.data.SosoWifi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x5fb.ReqInfo;
import tencent.im.oidb.cmd0x682.ChatInfo;
import tencent.im.oidb.cmd0x682.ReqBody;
import tencent.im.oidb.cmd0x682.RspBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.RspBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.ReqBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NearbyCmdHelper
{
  public static int a(ToServiceMsg paramToServiceMsg)
  {
    int j = 0;
    int i = j;
    if (paramToServiceMsg != null)
    {
      int k = paramToServiceMsg.extraData.getByte("neighbor_interest_id");
      long l = paramToServiceMsg.extraData.getLong("neighbor_sub_interest_id");
      i = j;
      if (k != 0)
      {
        i = j;
        if (l != 0L) {
          i = 1;
        }
      }
    }
    return i;
  }
  
  @NotNull
  private static ReqGetEncounterV2 a(byte paramByte1, boolean paramBoolean, EncounterSvc.ReqUserInfo paramReqUserInfo1, EncounterSvc.ReqUserInfo paramReqUserInfo2, UserData paramUserData, int paramInt1, ArrayList<Long> paramArrayList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte paramByte2, byte paramByte3, int paramInt2, byte paramByte4, byte paramByte5, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, long paramLong1, byte paramByte6, int paramInt7, long paramLong2, cmd0x5fb.ReqInfo paramReqInfo, int paramInt8)
  {
    if (paramBoolean) {
      return new ReqGetEncounterV2(paramReqUserInfo1, paramUserData, paramInt1, -1, paramArrayList, new byte[1], paramByte1, 2000, -1, 0, paramArrayOfByte1, paramArrayOfByte2, 0, (byte)1, paramByte2, paramByte4, paramByte5, paramInt2, paramInt3, paramInt5, paramInt6, (byte)1, paramInt4, paramReqUserInfo2, 15, paramReqInfo.toByteArray(), (byte)0, (byte)0, paramByte3, paramString, paramLong1, 0L, paramByte6, paramInt8, paramInt7, paramLong2);
    }
    return new ReqGetEncounterV2(paramReqUserInfo1, paramUserData, paramInt1, -1, paramArrayList, new byte[1], (byte)0, 2000, -1, 0, paramArrayOfByte1, paramArrayOfByte2, 0, (byte)1, paramByte2, paramByte4, paramByte5, paramInt2, paramInt3, paramInt5, paramInt6, (byte)1, paramInt4, null, 15, paramReqInfo.toByteArray(), (byte)0, (byte)0, paramByte3, paramString, paramLong1, 0L, paramByte6, paramInt8, paramInt7, paramLong2);
  }
  
  @NotNull
  private static UserData a(UserData paramUserData, boolean paramBoolean)
  {
    Object localObject;
    if (paramUserData != null)
    {
      localObject = paramUserData;
      if (!paramBoolean) {}
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("temp==ull:");
      if (paramUserData != null) {
        break label68;
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("NearbyCmdHelper", 2, bool + " first:" + paramBoolean);
      localObject = new UserData();
      return localObject;
    }
  }
  
  @Nullable
  private static UserData a(ToServiceMsg paramToServiceMsg, BaseProtocolCoder paramBaseProtocolCoder)
  {
    Object localObject = null;
    int i = a(paramToServiceMsg);
    if ((paramBaseProtocolCoder instanceof NearbyProtocolCoder))
    {
      paramToServiceMsg = ((NearbyProtocolCoder)paramBaseProtocolCoder).a[i];
      if (NearbyUtils.b()) {
        if (paramToServiceMsg != null) {
          break label86;
        }
      }
    }
    label86:
    for (paramBaseProtocolCoder = "user data is null";; paramBaseProtocolCoder = paramToServiceMsg.strProvince)
    {
      NearbyUtils.a("NearbyCmdHelper", new Object[] { "handleGetEncounter", Integer.valueOf(i), paramBaseProtocolCoder });
      return paramToServiceMsg;
      paramToServiceMsg = localObject;
      if (!(paramBaseProtocolCoder instanceof LBSService)) {
        break;
      }
      paramToServiceMsg = ((LBSService)paramBaseProtocolCoder).a[i];
      break;
    }
  }
  
  private static NearbyPubAcct.LBSInfo a(NearbyGroup.LBSInfo paramLBSInfo)
  {
    Object localObject1 = null;
    if (paramLBSInfo != null)
    {
      localObject1 = new NearbyPubAcct.GPS(paramLBSInfo.stGps.iLat, paramLBSInfo.stGps.iLon, paramLBSInfo.stGps.iAlt, paramLBSInfo.stGps.eType);
      NearbyPubAcct.Attr localAttr = new NearbyPubAcct.Attr(paramLBSInfo.stAttr.strImei, paramLBSInfo.stAttr.strImsi, paramLBSInfo.stAttr.strPhonenum);
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = paramLBSInfo.vWifis.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NearbyGroup.Wifi)((Iterator)localObject2).next();
        localArrayList.add(new NearbyPubAcct.Wifi(((NearbyGroup.Wifi)localObject3).lMac, ((NearbyGroup.Wifi)localObject3).shRssi));
      }
      localObject2 = new ArrayList();
      paramLBSInfo = paramLBSInfo.vCells.iterator();
      while (paramLBSInfo.hasNext())
      {
        localObject3 = (NearbyGroup.Cell)paramLBSInfo.next();
        ((ArrayList)localObject2).add(new NearbyPubAcct.Cell(((NearbyGroup.Cell)localObject3).shMcc, ((NearbyGroup.Cell)localObject3).shMnc, ((NearbyGroup.Cell)localObject3).iLac, ((NearbyGroup.Cell)localObject3).iCellId, ((NearbyGroup.Cell)localObject3).shRssi));
      }
      localObject1 = new NearbyPubAcct.LBSInfo((NearbyPubAcct.GPS)localObject1, localArrayList, (ArrayList)localObject2, localAttr);
    }
    return localObject1;
  }
  
  public static Object a(AppInterface paramAppInterface, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, BaseProtocolCoder paramBaseProtocolCoder)
  {
    RespHeader localRespHeader = (RespHeader)a(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    UserData localUserData;
    boolean bool;
    int i;
    if (localRespHeader != null)
    {
      ReportLog.a("LBS", "CMD_GET_ENCOUNTER eReplyCode:" + localRespHeader.eReplyCode);
      localUserData = null;
      bool = false;
      if (localRespHeader == null) {
        break label495;
      }
      i = localRespHeader.eReplyCode;
      if ((i != 0) && (i != 300)) {
        break label423;
      }
      paramFromServiceMsg = (RespGetEncounterV2)a(paramFromServiceMsg.getWupBuffer(), "RespGetEncounterV2", new RespGetEncounterV2());
      if (paramFromServiceMsg == null) {
        break label504;
      }
      localUserData = paramFromServiceMsg.stUserData;
      i = a(paramToServiceMsg);
      if (!(paramBaseProtocolCoder instanceof NearbyProtocolCoder)) {
        break label392;
      }
      ((NearbyProtocolCoder)paramBaseProtocolCoder).a[i] = localUserData;
      label141:
      if (NearbyUtils.b())
      {
        if (localUserData != null) {
          break label414;
        }
        paramAppInterface = "user data is null";
        label155:
        NearbyUtils.a("NearbyCmdHelper", new Object[] { "decodeGetEncounter", Integer.valueOf(i), paramAppInterface });
      }
      if (localUserData != null)
      {
        DatingManager.a(paramToServiceMsg.extraData.getString("account"), localUserData.iLon, localUserData.iLat, localUserData.lTime);
        if (QLog.isColorLevel()) {
          QLog.d("NearbyCmdHelper", 2, "respone stUserData.lTime=" + localUserData.lTime + " iLat=" + localUserData.iLat + " iLon" + localUserData.iLon + " lOriginGrid=" + localUserData.lOriginGrid + " lNextGrid=" + localUserData.lNextGrid + " strProvince=" + localUserData.strProvince + " strCookie" + localUserData.strCookie);
        }
      }
      bool = true;
      paramAppInterface = paramFromServiceMsg;
    }
    for (;;)
    {
      return new Object[] { localRespHeader, paramAppInterface, Boolean.valueOf(bool) };
      ReportLog.a("LBS", "CMD_GET_ENCOUNTER eReplyCode:" + null);
      break;
      label392:
      if (!(paramBaseProtocolCoder instanceof LBSService)) {
        break label141;
      }
      ((LBSService)paramBaseProtocolCoder).a[i] = localUserData;
      break label141;
      label414:
      paramAppInterface = localUserData.strProvince;
      break label155;
      label423:
      if (QLog.isColorLevel()) {
        QLog.d("NearbyCmdHelper", 2, "cmd = " + paramFromServiceMsg.getServiceCmd() + " ReplyCode = " + i + ",strResult=" + localRespHeader.strResult);
      }
      NearbyHandler.a(paramAppInterface, i);
      paramAppInterface = localUserData;
      continue;
      label495:
      NearbyHandler.a(paramAppInterface, -1111);
      return null;
      label504:
      bool = true;
      paramAppInterface = paramFromServiceMsg;
    }
  }
  
  public static Object a(BaseProtocolCoder paramBaseProtocolCoder, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby", 2, "LBSService --> decodeGetPointInfo(), isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramBaseProtocolCoder = (RespGetPoint)paramBaseProtocolCoder.decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetPoint", new RespGetPoint());
      if (paramBaseProtocolCoder != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby", 2, "LBSService --> decodeGetPointInfo(), url: " + new String(paramBaseProtocolCoder.stUDLinfo.SOSOUrl) + " , cityId = " + paramBaseProtocolCoder.stUDLinfo.cityId);
        }
        return paramBaseProtocolCoder;
      }
    }
    return null;
  }
  
  public static final <T> T a(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    catch (RuntimeException paramArrayOfByte) {}
    return null;
  }
  
  private static void a(int paramInt1, int paramInt2, boolean paramBoolean, SosoLbsInfo paramSosoLbsInfo, EncounterSvc.ReqUserInfo paramReqUserInfo)
  {
    if (paramBoolean)
    {
      paramReqUserInfo.vCells = new ArrayList(1);
      paramReqUserInfo.vMacs = new ArrayList(1);
      paramReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
      paramReqUserInfo.stGps = new EncounterSvc.GPS(paramInt1, paramInt2, 0, 1);
    }
    for (;;)
    {
      return;
      paramReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_SOSO.value();
      paramReqUserInfo.stGps = new EncounterSvc.GPS((int)(paramSosoLbsInfo.mLocation.mLat84 * 1000000.0D), (int)(paramSosoLbsInfo.mLocation.mLon84 * 1000000.0D), -1, 0);
      if (QLog.isColorLevel()) {
        QLog.i("NearbyCmdHelper", 2, "mLat_84=" + paramSosoLbsInfo.mLocation.mLat84 + ",mLon_84" + paramSosoLbsInfo.mLocation.mLon84);
      }
      paramReqUserInfo.vSOSOCells = new ArrayList();
      Object localObject;
      if (paramSosoLbsInfo.mCells != null)
      {
        localObject = paramSosoLbsInfo.mCells.iterator();
        while (((Iterator)localObject).hasNext())
        {
          SosoCell localSosoCell = (SosoCell)((Iterator)localObject).next();
          paramReqUserInfo.vSOSOCells.add(new SOSO_Cell((short)localSosoCell.mMcc, (short)localSosoCell.mMnc, localSosoCell.mLac, localSosoCell.mCellId, (short)localSosoCell.mRss));
        }
      }
      paramReqUserInfo.vSOSOMac = new ArrayList();
      if (paramSosoLbsInfo.mWifis != null)
      {
        paramSosoLbsInfo = paramSosoLbsInfo.mWifis.iterator();
        while (paramSosoLbsInfo.hasNext())
        {
          localObject = (SosoWifi)paramSosoLbsInfo.next();
          paramReqUserInfo.vSOSOMac.add(new SOSO_Wifi(((SosoWifi)localObject).mMac, (short)((SosoWifi)localObject).mRssi));
        }
      }
    }
  }
  
  private static void a(AppInterface paramAppInterface, int paramInt)
  {
    String str = "";
    if ((paramInt & 0x4) == 4)
    {
      str = "0X8005283";
      AppIntefaceReportWrap.a(paramAppInterface, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      DatingUtil.c("getShowLove", new Object[] { "report value ", str });
      str = "";
      if ((paramInt & 0x1) != 1) {
        break label184;
      }
      str = "0X8005288";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str))
      {
        AppIntefaceReportWrap.a(paramAppInterface, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        DatingUtil.c("getShowLove", new Object[] { "report value2 ", str });
      }
      return;
      if ((paramInt & 0x8) == 8)
      {
        str = "0X8005284";
        break;
      }
      if ((paramInt & 0x10) == 16)
      {
        str = "0X8005285";
        break;
      }
      if ((paramInt & 0x20) != 32) {
        break;
      }
      str = "0X8005281";
      break;
      label184:
      if ((paramInt & 0x2) == 2) {
        str = "0X8005289";
      }
    }
  }
  
  public static void a(BusinessHandler paramBusinessHandler, byte paramByte)
  {
    try
    {
      long l = Long.parseLong(paramBusinessHandler.getCurrentAccountUin());
      Object localObject = new byte[13];
      PkgTools.DWord2Byte((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.Word2Byte((byte[])localObject, 5, (short)1);
      PkgTools.DWordTo2Bytes((byte[])localObject, 7, 40493);
      PkgTools.Word2Byte((byte[])localObject, 9, (short)2);
      PkgTools.Word2Byte((byte[])localObject, 11, (short)paramByte);
      localObject = paramBusinessHandler.makeOIDBPkg("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putByte("session_switch_value", paramByte);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromDatingHandler", true);
      paramBusinessHandler.sendPbReq((ToServiceMsg)localObject);
      DatingUtil.a("send_oidb_0x4ff_9", new Object[] { Byte.valueOf(paramByte) });
      return;
    }
    catch (Exception paramBusinessHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.dating", 2, "send_oidb_0x4ff_9 error", paramBusinessHandler);
    }
  }
  
  public static void a(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ByteBuffer localByteBuffer = null;
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("req_street_view");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("req_current_loc");
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramFromServiceMsg = (RespGetPoint)paramObject;
      paramObject = paramFromServiceMsg.stUDLinfo;
      if (bool1) {
        if ((paramObject != null) && (paramObject.SOSOUrl.length > 0)) {
          paramBusinessHandler.notifyUI(paramInt, true, paramObject.SOSOUrl);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!bool2);
      paramToServiceMsg = localByteBuffer;
      if (paramObject.cityId != null)
      {
        paramToServiceMsg = localByteBuffer;
        if (paramObject.cityId.length == 16)
        {
          localByteBuffer = ByteBuffer.wrap(paramObject.cityId);
          paramToServiceMsg = new String[4];
          paramToServiceMsg[0] = ConditionSearchManager.a(localByteBuffer.getInt());
          paramToServiceMsg[1] = ConditionSearchManager.a(localByteBuffer.getInt());
          paramToServiceMsg[2] = ConditionSearchManager.a(localByteBuffer.getInt());
          paramToServiceMsg[3] = "0";
        }
      }
      paramBusinessHandler.notifyUI(paramInt, true, new Object[] { "", paramObject.strProvince, paramObject.strCity, paramObject.strDistrict, paramObject.strTown, "", paramObject.strRoad, "", Integer.valueOf(paramFromServiceMsg.stGps.iLat), Integer.valueOf(paramFromServiceMsg.stGps.iLon), Integer.valueOf(paramFromServiceMsg.stGps.iAlt), paramToServiceMsg });
      return;
      if (bool1)
      {
        paramBusinessHandler.notifyUI(paramInt, false, null);
        return;
      }
    } while (!bool2);
    paramBusinessHandler.notifyUI(paramInt, false, null);
  }
  
  public static void a(BusinessHandler paramBusinessHandler, int paramInt1, List<InterestTag> paramList, int paramInt2, int paramInt3)
  {
    if (paramList == null)
    {
      c(paramBusinessHandler, paramInt1, null, null, null);
      return;
    }
    cmd0x9c7.ReqBody localReqBody = new cmd0x9c7.ReqBody();
    localReqBody.uint32_set_mode.set(paramInt2);
    localReqBody.uint32_test_mode.set(paramInt3);
    paramInt1 = 0;
    while (paramInt1 < paramList.size())
    {
      InterestTag localInterestTag = (InterestTag)paramList.get(paramInt1);
      if (localInterestTag != null) {
        localReqBody.rpt_msg_tags.add(localInterestTag.a());
      }
      paramInt1 += 1;
    }
    paramList = paramBusinessHandler.makeOIDBPkg("OidbSvc.0x9c7_0", 2503, 0, localReqBody.toByteArray());
    paramList.extraData.putInt("set_mode", paramInt2);
    paramList.extraData.putInt("test_mode", paramInt3);
    paramBusinessHandler.sendPbReq(paramList);
  }
  
  public static void a(BusinessHandler paramBusinessHandler, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = new cmd0x682.ReqBody();
    ((cmd0x682.ReqBody)localObject).rpt_uint64_touinlist.add(Long.valueOf(paramLong));
    localObject = paramBusinessHandler.makeOIDBPkg("OidbSvc.0x682", 1666, 0, ((cmd0x682.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putByteArray("showlove_chat_sig", paramArrayOfByte);
    paramBusinessHandler.sendPbReq((ToServiceMsg)localObject);
    a(paramBusinessHandler.appRuntime, paramInt);
    DatingUtil.c("getShowLove", new Object[] { "from type " + paramInt });
  }
  
  public static void a(BusinessHandler paramBusinessHandler, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramBusinessHandler.getCurrentAccountUin(), "NeighborSvc.ReqGetPoint");
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      localToServiceMsg.extraData.putInt("lat", paramInt1);
      localToServiceMsg.extraData.putInt("lon", paramInt2);
    }
    if (paramBoolean1) {
      localToServiceMsg.extraData.putBoolean("req_street_view", true);
    }
    for (;;)
    {
      paramBusinessHandler.send(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putBoolean("req_current_loc", true);
    }
  }
  
  private static void a(DatingFilters paramDatingFilters, cmd0x5fb.ReqInfo paramReqInfo)
  {
    PBUInt32Field localPBUInt32Field;
    if (paramDatingFilters != null)
    {
      paramReqInfo.uint32_time.set(paramDatingFilters.jdField_b_of_type_Int);
      paramReqInfo.uint32_subject.set(paramDatingFilters.d);
      paramReqInfo.uint32_gender.set(paramDatingFilters.jdField_a_of_type_Int);
      paramReqInfo.uint32_age_low.set(DatingFilters.jdField_b_of_type_ArrayOfInt[paramDatingFilters.e]);
      paramReqInfo.uint32_age_up.set(DatingFilters.jdField_a_of_type_ArrayOfInt[paramDatingFilters.e]);
      localPBUInt32Field = paramReqInfo.uint32_profession;
      if (paramDatingFilters.f >= 0) {
        break label126;
      }
    }
    label126:
    for (int i = 0;; i = paramDatingFilters.f)
    {
      localPBUInt32Field.set(i);
      paramReqInfo.bytes_cookie.set(ByteStringMicro.copyFrom(new byte[0]));
      if ((paramDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) && (paramDatingFilters.d == 5)) {
        paramReqInfo.msg_destination.set(paramDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo);
      }
      return;
    }
  }
  
  public static void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespFavorite)a(paramFromServiceMsg.getWupBuffer(), "RespFavorite", new RespFavorite());
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
  }
  
  private static void a(ToServiceMsg paramToServiceMsg, EncounterSvc.ReqUserInfo paramReqUserInfo)
  {
    int i = paramToServiceMsg.extraData.getInt("localLat");
    int j = paramToServiceMsg.extraData.getInt("localLon");
    if ((i != 0) && (j != 0))
    {
      paramReqUserInfo.vCells = new ArrayList(1);
      paramReqUserInfo.vMacs = new ArrayList(1);
      paramReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
      paramReqUserInfo.stGps = new EncounterSvc.GPS(i, j, 0, 1);
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, BaseProtocolCoder paramBaseProtocolCoder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCmdHelper", 2, "handleGetEncounter start...");
    }
    if (paramToServiceMsg.extraData.getBoolean("isCheckInReq", false)) {
      return b(paramAppInterface, paramToServiceMsg, paramUniPacket, paramBaseProtocolCoder);
    }
    Object localObject3 = a(paramToServiceMsg, paramBaseProtocolCoder);
    int m = paramToServiceMsg.extraData.getInt("lat");
    int n = paramToServiceMsg.extraData.getInt("lon");
    int j = paramToServiceMsg.extraData.getInt("roamMode");
    boolean bool1 = false;
    if ((m != 0) && (n != 0))
    {
      bool1 = true;
      paramBaseProtocolCoder = null;
    }
    while ((paramBaseProtocolCoder != null) || (bool1))
    {
      boolean bool2 = paramToServiceMsg.extraData.getBoolean("first");
      NeighborComm.ReqHeader localReqHeader = new NeighborComm.ReqHeader();
      localReqHeader.shVersion = 3;
      localReqHeader.lMID = BaseProtocolCoder.createUserId(Long.parseLong(paramToServiceMsg.getUin()));
      localReqHeader.iAppID = AppSetting.a();
      localReqHeader.eBusiType = 0;
      localReqHeader.eMqqSysType = 2;
      EncounterSvc.ReqUserInfo localReqUserInfo1 = new EncounterSvc.ReqUserInfo();
      localReqUserInfo1.strAuthName = "B1_QQ_Neighbor_android";
      localReqUserInfo1.strAuthPassword = "NzVK_qGE";
      localReqUserInfo1.eListType = 0;
      a(m, n, bool1, paramBaseProtocolCoder, localReqUserInfo1);
      EncounterSvc.ReqUserInfo localReqUserInfo2 = new EncounterSvc.ReqUserInfo();
      a(paramToServiceMsg, localReqUserInfo2);
      UserData localUserData = a((UserData)localObject3, bool2);
      int k = paramToServiceMsg.extraData.getInt("gender");
      Object localObject4 = paramToServiceMsg.extraData.getLongArray("tags");
      Object localObject2 = null;
      Object localObject1 = localObject2;
      int i;
      if (localObject4 != null)
      {
        localObject1 = localObject2;
        if (localObject4.length > 0)
        {
          localObject2 = new ArrayList();
          i = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i >= localObject4.length) {
              break;
            }
            ((ArrayList)localObject2).add(Long.valueOf(localObject4[i]));
            i += 1;
          }
          l1 = System.currentTimeMillis();
          ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).reqRawLbsData(60000L, "NearbyProtocolCoder.Encounter");
          paramBaseProtocolCoder = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getRawSosoInfo();
          l2 = System.currentTimeMillis();
          paramToServiceMsg.extraData.putLong("lbsTime", l2 - l1);
          continue;
        }
      }
      localObject2 = a(m, n, bool2);
      byte b1 = paramToServiceMsg.extraData.getByte("constellation");
      byte b2 = paramToServiceMsg.extraData.getByte("neighbor_interest_id");
      m = paramToServiceMsg.extraData.getInt("timeInterval");
      byte b3 = paramToServiceMsg.extraData.getByte("ageLow");
      byte b4 = paramToServiceMsg.extraData.getByte("ageUp");
      n = paramToServiceMsg.extraData.getInt("careerID");
      int i1 = paramToServiceMsg.extraData.getInt("hometownCountry");
      int i2 = paramToServiceMsg.extraData.getInt("hometownProvince");
      int i3 = paramToServiceMsg.extraData.getInt("hometownCity");
      localObject4 = paramToServiceMsg.extraData.getString("adExtra");
      long l1 = paramToServiceMsg.extraData.getLong("adCtrl");
      byte b5 = paramToServiceMsg.extraData.getByte("rankListNum");
      int i4 = paramToServiceMsg.extraData.getInt("neighbor_list_source");
      long l2 = paramToServiceMsg.extraData.getLong("neighbor_sub_interest_id");
      if ((QLog.isColorLevel()) && (localObject3 != null)) {
        QLog.d("NearbyCmdHelper", 2, "request stUserData.lTime=" + ((UserData)localObject3).lTime + " iLat=" + ((UserData)localObject3).iLat + " iLon" + ((UserData)localObject3).iLon + " lOriginGrid=" + ((UserData)localObject3).lOriginGrid + " lNextGrid=" + ((UserData)localObject3).lNextGrid + " strProvince=" + ((UserData)localObject3).strProvince + " strCookie" + ((UserData)localObject3).strCookie);
      }
      if (NearbyUtils.b()) {
        NearbyUtils.a("NearbyCmdHelper", "handleGetEncounter interest", new Object[] { Byte.valueOf(b2), Long.valueOf(l2) });
      }
      paramToServiceMsg = (DatingFilters)paramToServiceMsg.extraData.getParcelable("datingFilter");
      localObject3 = new cmd0x5fb.ReqInfo();
      a(paramToServiceMsg, (cmd0x5fb.ReqInfo)localObject3);
      if (((Boolean)NearbySPUtil.a(paramAppInterface.getAccount(), "is_nearby_novice", Boolean.valueOf(false))).booleanValue())
      {
        i = 1;
        if (QLog.isColorLevel()) {
          QLog.i("NearbyCmdHelper", 2, "handleGetEncounter isNearbyNovice: " + i);
        }
        paramToServiceMsg = a((byte)j, bool1, localReqUserInfo1, localReqUserInfo2, localUserData, k, localObject1, null, (byte[])localObject2, b1, b2, m, b3, b4, n, i1, i2, i3, (String)localObject4, l1, b5, i4, l2, (cmd0x5fb.ReqInfo)localObject3, i);
        paramUniPacket.setEncodeName("utf-8");
        paramUniPacket.setServantName("EncounterObj");
        paramUniPacket.setFuncName("CMD_GET_ENCOUNTERV2");
        paramUniPacket.put("ReqHeader", localReqHeader);
        paramUniPacket.put("ReqGetEncounterV2", paramToServiceMsg);
        paramUniPacket = new HashMap();
        if (paramBaseProtocolCoder == null) {
          break label996;
        }
      }
      label996:
      for (paramToServiceMsg = "lbs is not null";; paramToServiceMsg = "isUseGps is true")
      {
        paramUniPacket.put("param_reason", paramToServiceMsg);
        paramUniPacket.put("param_NetType", NetworkUtil.a(null) + "");
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramAppInterface.getCurrentAccountUin(), "GET_ENCOUNTER_LOCATION", true, 0L, 0L, paramUniPacket, "");
        return true;
        i = 0;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCmdHelper", 2, "handleGetEncounter lbsInfo=" + paramBaseProtocolCoder + ", isUseGps=" + bool1);
    }
    if (paramBaseProtocolCoder == null) {
      paramToServiceMsg.extraData.putBoolean("isLbsInfoNull", true);
    }
    paramToServiceMsg = new HashMap();
    paramToServiceMsg.put("param_reason", "all is null");
    paramToServiceMsg.put("param_NetType", NetworkUtil.a(null) + "");
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramAppInterface.getCurrentAccountUin(), "GET_ENCOUNTER_LOCATION", false, 0L, 0L, paramToServiceMsg, "");
    return false;
  }
  
  public static boolean a(BaseProtocolCoder paramBaseProtocolCoder, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    boolean bool2 = false;
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("req_street_view");
    boolean bool4 = paramToServiceMsg.extraData.getBoolean("req_current_loc");
    int i = paramToServiceMsg.extraData.getInt("lat");
    int j = paramToServiceMsg.extraData.getInt("lon");
    boolean bool1;
    Object localObject1;
    label219:
    byte b;
    if ((!bool3) || (i == 0) || (j == 0))
    {
      bool1 = bool2;
      if (!bool4) {}
    }
    else
    {
      paramBaseProtocolCoder = new NeighborSvc.ReqHeader();
      paramBaseProtocolCoder.shVersion = 2;
      paramBaseProtocolCoder.lMID = BaseProtocolCoder.createUserId(Long.parseLong(paramToServiceMsg.getUin()));
      paramBaseProtocolCoder.iAppID = AppSetting.a();
      paramBaseProtocolCoder.eBusiType = 0;
      paramBaseProtocolCoder.eMqqSysType = 2;
      localObject1 = new NeighborSvc.ReqUserInfo();
      ((NeighborSvc.ReqUserInfo)localObject1).strAuthName = "B1_QQ_Neighbor_android";
      ((NeighborSvc.ReqUserInfo)localObject1).strAuthPassword = "NzVK_qGE";
      ((NeighborSvc.ReqUserInfo)localObject1).eListType = 0;
      if (!bool3) {
        break label297;
      }
      ((NeighborSvc.ReqUserInfo)localObject1).vCells = new ArrayList(1);
      ((NeighborSvc.ReqUserInfo)localObject1).vMacs = new ArrayList(1);
      ((NeighborSvc.ReqUserInfo)localObject1).stGps = new NeighborSvc.GPS(i, j, 0, 1);
      ((NeighborSvc.ReqUserInfo)localObject1).eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
      if (!bool3) {
        break label490;
      }
      i = 1;
      b = (byte)i;
      if (!bool4) {
        break label496;
      }
    }
    label294:
    label297:
    label490:
    label496:
    for (i = 1;; i = 0)
    {
      for (;;)
      {
        localObject1 = new ReqGetPoint((NeighborSvc.ReqUserInfo)localObject1, b, (byte)i);
        paramUniPacket.setServantName("NeighborObj");
        paramUniPacket.setFuncName("CMD_GET_POINT");
        paramUniPacket.put("ReqHeader", paramBaseProtocolCoder);
        paramUniPacket.put("ReqGetPoint", localObject1);
        paramToServiceMsg.setTimeout(30000L);
        paramToServiceMsg.setServiceCmd("NeighborSvc.ReqGetPoint");
        bool1 = true;
        return bool1;
        if ((bool4 == true) && (i != 0) && (j != 0))
        {
          ((NeighborSvc.ReqUserInfo)localObject1).vCells = new ArrayList(1);
          ((NeighborSvc.ReqUserInfo)localObject1).vMacs = new ArrayList(1);
          ((NeighborSvc.ReqUserInfo)localObject1).stGps = new NeighborSvc.GPS(i, j, 0, 1);
          break;
        }
        ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new NearbyCmdHelper.1("LBSService.Point", paramToServiceMsg));
        try
        {
          paramToServiceMsg.wait();
          Object localObject2 = LbsUtils.a(true, ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("LBSService.Point"));
          bool1 = bool2;
          if (localObject2 == null) {
            break label294;
          }
          if (((NearbyGroup.LBSInfo)localObject2).stGps == null) {
            break;
          }
          localObject2 = ((NearbyGroup.LBSInfo)localObject2).stGps;
          ((NeighborSvc.ReqUserInfo)localObject1).stGps = new NeighborSvc.GPS(((NearbyGroup.GPS)localObject2).iLat, ((NearbyGroup.GPS)localObject2).iLon, ((NearbyGroup.GPS)localObject2).iAlt, ((NearbyGroup.GPS)localObject2).eType);
          break;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
        finally {}
      }
      i = 0;
      break label219;
    }
  }
  
  public static boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin");
    long l2 = paramToServiceMsg.extraData.getLong("targetUin");
    Object localObject = paramToServiceMsg.extraData.getByteArray("vCookies");
    int i = paramToServiceMsg.extraData.getInt("favoriteSource");
    int j = paramToServiceMsg.extraData.getInt("iCount");
    localObject = new ReqFavorite(new ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, (byte[])localObject), l2, 0, i, j);
    paramUniPacket.setServantName("VisitorSvc");
    paramUniPacket.setFuncName("ReqFavorite");
    paramUniPacket.put("ReqFavorite", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("VisitorSvc.ReqFavorite");
    return true;
  }
  
  private static byte[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramBoolean)
    {
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        break label100;
      }
      localObject = new NearbyPubAcct.LBSInfo();
      ((NearbyPubAcct.LBSInfo)localObject).stGps = new NearbyPubAcct.GPS(paramInt1, paramInt2, 0, 1);
    }
    for (;;)
    {
      localObject = new ReqGetNearbyPubAcctInfo((short)2, new byte[0], 2, (NearbyPubAcct.LBSInfo)localObject);
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setRequestId(1);
      localUniPacket.setServantName("PubAccountSvc.nearby_pubacct");
      localUniPacket.setFuncName("nearby_pubacct");
      localUniPacket.put("nearby_pubacct", localObject);
      localObject = localUniPacket.encode();
      return localObject;
      label100:
      localObject = a(LbsUtils.a());
    }
  }
  
  public static void b(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    int i = -1;
    try
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      boolean bool1 = bool2;
      int j;
      if (paramFromServiceMsg != null)
      {
        j = paramFromServiceMsg.uint32_result.get();
        i = j;
        bool1 = bool2;
        if (j == 0)
        {
          bool1 = true;
          i = j;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "rspNearbyCharmEvent,result code：" + i + ",isSuccess:" + bool1);
      }
      if (bool1)
      {
        Oidb_0x686.RspBody localRspBody = new Oidb_0x686.RspBody();
        i = paramFromServiceMsg.uint32_service_type.get();
        localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (localRspBody.uint32_config_seq.has())
        {
          j = localRspBody.uint32_config_seq.get();
          NearbySPUtil.a(paramBusinessHandler.appRuntime.getAccount(), "toplist_hide_boygod_seq", Integer.valueOf(j));
        }
        if (localRspBody.uint32_config_time.has())
        {
          j = localRspBody.uint32_config_time.get();
          NearbySPUtil.a(paramBusinessHandler.appRuntime.getAccount(), "key_last_config_time", Integer.valueOf(j));
        }
        paramFromServiceMsg = null;
        paramObject = null;
        Object localObject3 = null;
        Object localObject4 = null;
        if (localRspBody.msg_rank_config.has()) {
          paramFromServiceMsg = (Oidb_0x686.NearbyRankConfig)localRspBody.msg_rank_config.get();
        }
        if (localRspBody.msg_feed_config.has()) {
          paramObject = (Oidb_0x686.NearbyFeedConfig)localRspBody.msg_feed_config.get();
        }
        Object localObject1;
        Object localObject2;
        if ((i == 2) && (localRspBody.msg_charm_event.has()))
        {
          localObject1 = (Oidb_0x686.CharmEvent)localRspBody.msg_charm_event.get();
          localObject2 = localObject4;
          if (!(paramBusinessHandler.appRuntime instanceof NearbyAppInterface)) {
            break label610;
          }
        }
        int k;
        int m;
        int n;
        int i1;
        for (;;)
        {
          if ((localObject1 == null) || (((Oidb_0x686.CharmEvent)localObject1).uint32_pop_flag.get() != 1)) {
            break label647;
          }
          i = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm.get();
          j = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm_level.get();
          k = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm.get();
          m = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm_level.get();
          n = ((Oidb_0x686.CharmEvent)localObject1).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.CharmEvent)localObject1).uint32_next_level_threshold.get();
          paramFromServiceMsg = ((Oidb_0x686.CharmEvent)localObject1).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          paramBusinessHandler.notifyUI(paramInt, true, new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), paramToServiceMsg });
          paramToServiceMsg = "0X80052B1";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052B2";
          }
          if (!(paramBusinessHandler.appRuntime instanceof AppInterface)) {
            break label903;
          }
          AppIntefaceReportWrap.a(paramBusinessHandler.appRuntime, "CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (i != 1) {
            break;
          }
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (!localRspBody.msg_notify_event.has()) {
            break;
          }
          localObject2 = (Oidb_0x686.NearbyCharmNotify)localRspBody.msg_notify_event.get();
          localObject1 = localObject3;
          break;
          label610:
          if ((paramBusinessHandler.appRuntime instanceof QQAppInterface)) {
            ((QQAppInterface)paramBusinessHandler.appRuntime).getNearbyProxy().a(paramToServiceMsg.getUin(), paramFromServiceMsg, paramObject, (Oidb_0x686.CharmEvent)localObject1, (Oidb_0x686.NearbyCharmNotify)localObject2);
          }
        }
        label647:
        if ((localObject2 != null) && (((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_pop_flag.get() == 1))
        {
          i = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm.get();
          j = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm_level.get();
          k = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm.get();
          m = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm_level.get();
          n = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_next_level_threshold.get();
          int i2 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_prof_percent.get();
          int i3 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_prof_percent.get();
          paramFromServiceMsg = ((Oidb_0x686.NearbyCharmNotify)localObject2).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          paramBusinessHandler.notifyUI(paramInt, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), paramToServiceMsg });
          paramToServiceMsg = "0X80052AE";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052AF";
          }
          if ((paramBusinessHandler.appRuntime instanceof AppInterface)) {
            AppIntefaceReportWrap.a(paramBusinessHandler.appRuntime, "CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          }
        }
      }
      label903:
      return;
    }
    catch (Exception paramBusinessHandler) {}
  }
  
  protected static boolean b(AppInterface paramAppInterface, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, BaseProtocolCoder paramBaseProtocolCoder)
  {
    int i = paramToServiceMsg.extraData.getInt("localLat");
    int j = paramToServiceMsg.extraData.getInt("localLon");
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotChatDistance", 2, "NearbyCmdHelper.handleCheckIn,  lat=" + i + ", lon=" + j);
    }
    if ((i != 0) && (j != 0))
    {
      paramAppInterface = new NeighborComm.ReqHeader();
      paramAppInterface.shVersion = 3;
      paramAppInterface.lMID = BaseProtocolCoder.createUserId(Long.parseLong(paramToServiceMsg.getUin()));
      paramAppInterface.iAppID = AppSetting.a();
      paramAppInterface.eBusiType = 0;
      paramAppInterface.eMqqSysType = 2;
      paramToServiceMsg = new EncounterSvc.ReqUserInfo();
      paramToServiceMsg.strAuthName = "B1_QQ_Neighbor_android";
      paramToServiceMsg.strAuthPassword = "NzVK_qGE";
      paramToServiceMsg.eListType = 0;
      paramToServiceMsg.vCells = new ArrayList(1);
      paramToServiceMsg.vMacs = new ArrayList(1);
      paramToServiceMsg.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
      paramToServiceMsg.stGps = new EncounterSvc.GPS(i, j, 0, 1);
      paramBaseProtocolCoder = new ReqGetEncounterV2();
      paramBaseProtocolCoder.stUserData = new UserData();
      paramBaseProtocolCoder.stUserInfo = paramToServiceMsg;
      paramBaseProtocolCoder.eNewListType = 100;
      paramBaseProtocolCoder.neighbor_list_source = 4;
      paramUniPacket.setEncodeName("utf-8");
      paramUniPacket.setServantName("EncounterObj");
      paramUniPacket.setFuncName("CMD_GET_ENCOUNTERV2");
      paramUniPacket.put("ReqHeader", paramAppInterface);
      paramUniPacket.put("ReqGetEncounterV2", paramBaseProtocolCoder);
      return true;
    }
    return false;
  }
  
  public static void c(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      paramBusinessHandler.notifyUI(paramInt, false, new Object[] { "", null, HardCodeUtil.a(2131707133), Integer.valueOf(-1), Integer.valueOf(-1) });
      return;
    }
    int i;
    int j;
    label72:
    cmd0x9c7.RspBody localRspBody;
    int m;
    if (paramToServiceMsg.extraData == null)
    {
      i = -1;
      if (paramToServiceMsg.extraData != null) {
        break label227;
      }
      j = -1;
      localRspBody = new cmd0x9c7.RspBody();
      m = BusinessHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      if (m != 0) {
        break label485;
      }
      if (!localRspBody.str_test_result_url.has()) {
        break label242;
      }
      paramToServiceMsg = localRspBody.str_test_result_url.get();
      label116:
      if (!localRspBody.rpt_msg_tags.has()) {
        break label249;
      }
    }
    label227:
    label242:
    label249:
    for (paramFromServiceMsg = localRspBody.rpt_msg_tags.get();; paramFromServiceMsg = null)
    {
      paramObject = new ArrayList();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
        break label254;
      }
      int k = 0;
      while (k < paramFromServiceMsg.size())
      {
        InterestTag localInterestTag = InterestTag.a((appoint_define.InterestTag)paramFromServiceMsg.get(k));
        if (localInterestTag != null) {
          paramObject.add(localInterestTag);
        }
        k += 1;
      }
      i = paramToServiceMsg.extraData.getInt("set_mode");
      break;
      j = paramToServiceMsg.extraData.getInt("test_mode");
      break label72;
      paramToServiceMsg = "";
      break label116;
    }
    label254:
    if (paramObject.size() <= 0)
    {
      paramBusinessHandler.notifyUI(4, false, new Object[] { "", null, HardCodeUtil.a(2131707134), Integer.valueOf(i), Integer.valueOf(j) });
      NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c7_0", new Object[] { Integer.valueOf(m), Boolean.valueOf(true), null, paramToServiceMsg });
      return;
    }
    if ((paramBusinessHandler.appRuntime instanceof NearbyAppInterface)) {
      ((NearbyAppInterface)paramBusinessHandler.appRuntime).a().a(localRspBody);
    }
    for (;;)
    {
      paramBusinessHandler.notifyUI(paramInt, true, new Object[] { paramToServiceMsg, paramObject, "", Integer.valueOf(i), Integer.valueOf(j) });
      NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c7_0", new Object[] { Integer.valueOf(m), Boolean.valueOf(true), paramObject, paramToServiceMsg });
      return;
      if ((paramBusinessHandler.appRuntime != null) && ((paramBusinessHandler.appRuntime instanceof QQAppInterface))) {
        ((QQAppInterface)paramBusinessHandler.appRuntime).getNearbyProxy().a(localRspBody);
      }
    }
    label485:
    if (localRspBody.str_error.has()) {}
    for (paramToServiceMsg = localRspBody.str_error.get();; paramToServiceMsg = "")
    {
      paramBusinessHandler.notifyUI(paramInt, false, new Object[] { "", null, paramToServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
      return;
    }
  }
  
  public static void d(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          int i = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.dating", 2, "handle_oidb_0x4ff_9 ret=" + i);
          }
          if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            if (4 <= paramFromServiceMsg.length)
            {
              paramFromServiceMsg = String.valueOf(PkgTools.getLongData(paramFromServiceMsg, 0));
              if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(paramBusinessHandler.getCurrentAccountUin())))
              {
                if (QLog.isColorLevel()) {
                  QLog.w("Q.dating", 2, "handle_oidb_0x4ff_9 uin error");
                }
                return;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = paramObject;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((paramBusinessHandler.appRuntime instanceof QQAppInterface)) {
        if (paramInt == 7)
        {
          paramInt = paramToServiceMsg.extraData.getByte("session_switch_value", (byte)0).byteValue();
          if (bool1)
          {
            paramToServiceMsg = ((QQAppInterface)paramBusinessHandler.appRuntime).getNearbyProxy();
            if (paramInt != 0) {
              break label294;
            }
            paramToServiceMsg.a(bool2);
          }
          paramBusinessHandler.notifyUI(7, bool1, null);
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label364;
        }
        QLog.d("Q.dating", 2, "handle_oidb_0x4ff_9, isSuccess:" + bool1);
        return;
        label294:
        bool2 = false;
        break;
        if ((paramBusinessHandler.appRuntime instanceof NearbyAppInterface))
        {
          paramFromServiceMsg = (NearbyAppInterface)paramBusinessHandler.appRuntime;
          if (paramInt == 10)
          {
            byte b = paramToServiceMsg.extraData.getByte("session_switch_value", (byte)0).byteValue();
            if (bool1) {
              paramFromServiceMsg.a().a(b);
            }
            paramBusinessHandler.notifyUI(10, bool1, null);
          }
        }
      }
      label364:
      break;
      bool1 = true;
      continue;
      bool1 = false;
    }
  }
  
  public static void e(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x682.RspBody localRspBody = new cmd0x682.RspBody();
    int i = BusinessHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    DatingUtil.a("getShowLove", new Object[] { "handleGetShowLoveLimit result = " + i });
    int n;
    if ((i == 0) && (localRspBody.rpt_msg_chatinfo.has()) && (localRspBody.rpt_msg_chatinfo.size() > 0))
    {
      paramObject = (cmd0x682.ChatInfo)localRspBody.rpt_msg_chatinfo.get(0);
      long l = paramObject.uint64_touin.get();
      paramInt = paramObject.uint32_chatflag.get();
      int j = paramObject.uint32_goldflag.get();
      int k = paramObject.uint32_totalexpcount.get();
      int m = paramObject.uint32_curexpcount.get();
      n = paramObject.uint32_totalFlag.get();
      int i1 = paramObject.uint32_curdayFlag.get();
      paramFromServiceMsg = paramObject.express_tips_msg.get().toStringUtf8();
      paramObject = paramObject.express_msg.get().toStringUtf8();
      boolean bool1 = false;
      boolean bool3 = false;
      paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("showlove_chat_sig");
      if (((paramInt & 0x2) == 2) || (j == 2)) {
        bool1 = true;
      }
      boolean bool2 = bool3;
      if (j == 1)
      {
        bool2 = bool3;
        if (n == 0)
        {
          bool2 = bool3;
          if (i1 == 0) {
            bool2 = true;
          }
        }
      }
      if ((paramBusinessHandler instanceof NearbyCardHandler)) {
        paramBusinessHandler.notifyUI(9, true, new Object[] { Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg, paramObject });
      }
      if (QLog.isColorLevel()) {
        QLog.d("DatingSayHello", 2, "toUin:" + l + ",chatFlag:" + paramInt + ",godFlag:" + j + ",totalCount:" + k + ",curCount" + m + ",totalFlag:" + n + ",curdayFlag:" + i1 + ",canChat:" + bool1 + ",canShowLove:" + bool2 + ",wordStr:" + paramFromServiceMsg + "showloveStr: " + paramObject);
      }
      if (i1 == 1) {
        AppIntefaceReportWrap.a(paramBusinessHandler.appRuntime, "CliOper", "", "", "0X8005290", "0X8005290", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_bank", 2, "handleGetShowLoveLimit,result：" + i);
      }
      return;
      if (n == 1)
      {
        AppIntefaceReportWrap.a(paramBusinessHandler.appRuntime, "CliOper", "", "", "0X8005291", "0X8005291", 0, 0, "", "", "", "");
        continue;
        paramBusinessHandler.notifyUI(paramInt, false, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyCmdHelper
 * JD-Core Version:    0.7.0.1
 */