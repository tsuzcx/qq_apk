package com.tencent.mobileqq.app;

import EncounterSvc.ReqGetEncounterV2;
import EncounterSvc.ReqUserInfo;
import EncounterSvc.RespGetEncounterV2;
import EncounterSvc.UserData;
import NearbyPubAcct.ReqGetNearbyPubAcctInfo;
import NeighborComm.LocalInfoType;
import NeighborComm.ReqHeader;
import NeighborComm.RespHeader;
import NeighborComm.SOSO_Cell;
import NeighborComm.SOSO_Wifi;
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
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.ILbsUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.lbs.LBSService;
import com.tencent.mobileqq.service.lbs.NearbyProtocolCoder;
import com.tencent.mobileqq.soso.location.data.SosoCell;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.data.SosoWifi;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.ReportLog;
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
    if (paramToServiceMsg != null)
    {
      int i = paramToServiceMsg.extraData.getByte("neighbor_interest_id");
      long l = paramToServiceMsg.extraData.getLong("neighbor_sub_interest_id");
      if ((i != 0) && (l != 0L)) {
        return 1;
      }
    }
    return 0;
  }
  
  @NotNull
  private static ReqGetEncounterV2 a(byte paramByte1, boolean paramBoolean, ReqUserInfo paramReqUserInfo1, ReqUserInfo paramReqUserInfo2, UserData paramUserData, int paramInt1, ArrayList<Long> paramArrayList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte paramByte2, byte paramByte3, int paramInt2, byte paramByte4, byte paramByte5, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, long paramLong1, byte paramByte6, int paramInt7, long paramLong2, cmd0x5fb.ReqInfo paramReqInfo, int paramInt8)
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
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("temp==ull:");
        boolean bool;
        if (paramUserData == null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" first:");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.i("NearbyCmdHelper", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new UserData();
    }
    return localObject;
  }
  
  @Nullable
  private static UserData a(ToServiceMsg paramToServiceMsg, BaseProtocolCoder paramBaseProtocolCoder)
  {
    int i = a(paramToServiceMsg);
    if ((paramBaseProtocolCoder instanceof NearbyProtocolCoder)) {
      paramToServiceMsg = ((NearbyProtocolCoder)paramBaseProtocolCoder).b[i];
    } else if ((paramBaseProtocolCoder instanceof LBSService)) {
      paramToServiceMsg = ((LBSService)paramBaseProtocolCoder).a[i];
    } else {
      paramToServiceMsg = null;
    }
    if (NearbyUtils.b())
    {
      if (paramToServiceMsg == null) {
        paramBaseProtocolCoder = "user data is null";
      } else {
        paramBaseProtocolCoder = paramToServiceMsg.strProvince;
      }
      NearbyUtils.a("NearbyCmdHelper", new Object[] { "handleGetEncounter", Integer.valueOf(i), paramBaseProtocolCoder });
    }
    return paramToServiceMsg;
  }
  
  private static NearbyPubAcct.LBSInfo a(NearbyGroup.LBSInfo paramLBSInfo)
  {
    if (paramLBSInfo != null)
    {
      NearbyPubAcct.GPS localGPS = new NearbyPubAcct.GPS(paramLBSInfo.stGps.iLat, paramLBSInfo.stGps.iLon, paramLBSInfo.stGps.iAlt, paramLBSInfo.stGps.eType);
      NearbyPubAcct.Attr localAttr = new NearbyPubAcct.Attr(paramLBSInfo.stAttr.strImei, paramLBSInfo.stAttr.strImsi, paramLBSInfo.stAttr.strPhonenum);
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = paramLBSInfo.vWifis.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (NearbyGroup.Wifi)((Iterator)localObject1).next();
        localArrayList.add(new NearbyPubAcct.Wifi(((NearbyGroup.Wifi)localObject2).lMac, ((NearbyGroup.Wifi)localObject2).shRssi));
      }
      localObject1 = new ArrayList();
      paramLBSInfo = paramLBSInfo.vCells.iterator();
      while (paramLBSInfo.hasNext())
      {
        localObject2 = (NearbyGroup.Cell)paramLBSInfo.next();
        ((ArrayList)localObject1).add(new NearbyPubAcct.Cell(((NearbyGroup.Cell)localObject2).shMcc, ((NearbyGroup.Cell)localObject2).shMnc, ((NearbyGroup.Cell)localObject2).iLac, ((NearbyGroup.Cell)localObject2).iCellId, ((NearbyGroup.Cell)localObject2).shRssi));
      }
      return new NearbyPubAcct.LBSInfo(localGPS, localArrayList, (ArrayList)localObject1, localAttr);
    }
    return null;
  }
  
  public static Object a(AppInterface paramAppInterface, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, BaseProtocolCoder paramBaseProtocolCoder)
  {
    RespHeader localRespHeader = (RespHeader)a(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    UserData localUserData = null;
    StringBuilder localStringBuilder;
    if (localRespHeader != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CMD_GET_ENCOUNTER eReplyCode:");
      localStringBuilder.append(localRespHeader.eReplyCode);
      ReportLog.a("LBS", localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CMD_GET_ENCOUNTER eReplyCode:");
      localStringBuilder.append(null);
      ReportLog.a("LBS", localStringBuilder.toString());
    }
    if (localRespHeader != null)
    {
      int i = localRespHeader.eReplyCode;
      boolean bool = false;
      if ((i != 0) && (i != 300))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmd = ");
          paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
          paramToServiceMsg.append(" ReplyCode = ");
          paramToServiceMsg.append(i);
          paramToServiceMsg.append(",strResult=");
          paramToServiceMsg.append(localRespHeader.strResult);
          QLog.d("NearbyCmdHelper", 2, paramToServiceMsg.toString());
        }
        NearbyHandler.a(paramAppInterface, i);
        paramAppInterface = localUserData;
      }
      else
      {
        paramFromServiceMsg = (RespGetEncounterV2)a(paramFromServiceMsg.getWupBuffer(), "RespGetEncounterV2", new RespGetEncounterV2());
        if (paramFromServiceMsg != null)
        {
          localUserData = paramFromServiceMsg.stUserData;
          i = a(paramToServiceMsg);
          if ((paramBaseProtocolCoder instanceof NearbyProtocolCoder)) {
            ((NearbyProtocolCoder)paramBaseProtocolCoder).b[i] = localUserData;
          } else if ((paramBaseProtocolCoder instanceof LBSService)) {
            ((LBSService)paramBaseProtocolCoder).a[i] = localUserData;
          }
          if (NearbyUtils.b())
          {
            if (localUserData == null) {
              paramAppInterface = "user data is null";
            } else {
              paramAppInterface = localUserData.strProvince;
            }
            NearbyUtils.a("NearbyCmdHelper", new Object[] { "decodeGetEncounter", Integer.valueOf(i), paramAppInterface });
          }
          if (localUserData != null)
          {
            DatingManager.a(paramToServiceMsg.extraData.getString("account"), localUserData.iLon, localUserData.iLat, localUserData.lTime);
            if (QLog.isColorLevel())
            {
              paramAppInterface = new StringBuilder();
              paramAppInterface.append("respone stUserData.lTime=");
              paramAppInterface.append(localUserData.lTime);
              paramAppInterface.append(" iLat=");
              paramAppInterface.append(localUserData.iLat);
              paramAppInterface.append(" iLon");
              paramAppInterface.append(localUserData.iLon);
              paramAppInterface.append(" lOriginGrid=");
              paramAppInterface.append(localUserData.lOriginGrid);
              paramAppInterface.append(" lNextGrid=");
              paramAppInterface.append(localUserData.lNextGrid);
              paramAppInterface.append(" strProvince=");
              paramAppInterface.append(localUserData.strProvince);
              paramAppInterface.append(" strCookie");
              paramAppInterface.append(localUserData.strCookie);
              QLog.d("NearbyCmdHelper", 2, paramAppInterface.toString());
            }
          }
        }
        bool = true;
        paramAppInterface = paramFromServiceMsg;
      }
      return new Object[] { localRespHeader, paramAppInterface, Boolean.valueOf(bool) };
    }
    NearbyHandler.a(paramAppInterface, -1111);
    return null;
  }
  
  public static Object a(BaseProtocolCoder paramBaseProtocolCoder, FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("LBSService --> decodeGetPointInfo(), isSuccess: ");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      QLog.d("Q.nearby", 2, paramToServiceMsg.toString());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramBaseProtocolCoder = (RespGetPoint)paramBaseProtocolCoder.decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetPoint", new RespGetPoint());
      if (paramBaseProtocolCoder != null)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("LBSService --> decodeGetPointInfo(), url: ");
          paramFromServiceMsg.append(new String(paramBaseProtocolCoder.stUDLinfo.SOSOUrl));
          paramFromServiceMsg.append(" , cityId = ");
          paramFromServiceMsg.append(paramBaseProtocolCoder.stUDLinfo.cityId);
          QLog.d("Q.nearby", 2, paramFromServiceMsg.toString());
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
    catch (RuntimeException|Exception paramArrayOfByte) {}
    return null;
  }
  
  private static void a(int paramInt1, int paramInt2, boolean paramBoolean, SosoLbsInfo paramSosoLbsInfo, ReqUserInfo paramReqUserInfo)
  {
    if (paramBoolean)
    {
      paramReqUserInfo.vCells = new ArrayList(1);
      paramReqUserInfo.vMacs = new ArrayList(1);
      paramReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
      paramReqUserInfo.stGps = new EncounterSvc.GPS(paramInt1, paramInt2, 0, 1);
      return;
    }
    paramReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_SOSO.value();
    paramReqUserInfo.stGps = new EncounterSvc.GPS((int)(paramSosoLbsInfo.mLocation.mLat84 * 1000000.0D), (int)(paramSosoLbsInfo.mLocation.mLon84 * 1000000.0D), -1, 0);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mLat_84=");
      ((StringBuilder)localObject).append(paramSosoLbsInfo.mLocation.mLat84);
      ((StringBuilder)localObject).append(",mLon_84");
      ((StringBuilder)localObject).append(paramSosoLbsInfo.mLocation.mLon84);
      QLog.i("NearbyCmdHelper", 2, ((StringBuilder)localObject).toString());
    }
    paramReqUserInfo.vSOSOCells = new ArrayList();
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
  
  private static void a(AppInterface paramAppInterface, int paramInt)
  {
    String str2 = "";
    String str1;
    if ((paramInt & 0x4) == 4) {
      str1 = "0X8005283";
    } else if ((paramInt & 0x8) == 8) {
      str1 = "0X8005284";
    } else if ((paramInt & 0x10) == 16) {
      str1 = "0X8005285";
    } else if ((paramInt & 0x20) == 32) {
      str1 = "0X8005281";
    } else {
      str1 = "";
    }
    AppIntefaceReportWrap.a(paramAppInterface, "CliOper", "", "", str1, str1, 0, 0, "", "", "", "");
    DatingUtil.c("getShowLove", new Object[] { "report value ", str1 });
    if ((paramInt & 0x1) == 1)
    {
      str1 = "0X8005288";
    }
    else
    {
      str1 = str2;
      if ((paramInt & 0x2) == 2) {
        str1 = "0X8005289";
      }
    }
    if (!TextUtils.isEmpty(str1))
    {
      AppIntefaceReportWrap.a(paramAppInterface, "CliOper", "", "", str1, str1, 0, 0, "", "", "", "");
      DatingUtil.c("getShowLove", new Object[] { "report value2 ", str1 });
    }
  }
  
  public static void a(BusinessHandler paramBusinessHandler, byte paramByte)
  {
    try
    {
      long l = Long.parseLong(paramBusinessHandler.getCurrentAccountUin());
      Object localObject = new byte[13];
      PkgTools.dWord2Byte((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.word2Byte((byte[])localObject, 5, (short)1);
      PkgTools.dWordTo2Bytes((byte[])localObject, 7, 40493);
      PkgTools.word2Byte((byte[])localObject, 9, (short)2);
      PkgTools.word2Byte((byte[])localObject, 11, (short)paramByte);
      localObject = paramBusinessHandler.makeOIDBPkg("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putByte("session_switch_value", paramByte);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromDatingHandler", true);
      paramBusinessHandler.sendPbReq((ToServiceMsg)localObject);
      DatingUtil.a("send_oidb_0x4ff_9", new Object[] { Byte.valueOf(paramByte) });
      return;
    }
    catch (Exception paramBusinessHandler)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.dating", 2, "send_oidb_0x4ff_9 error", paramBusinessHandler);
      }
    }
  }
  
  public static void a(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("req_street_view");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("req_current_loc");
    ByteBuffer localByteBuffer = null;
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramFromServiceMsg = (RespGetPoint)paramObject;
      paramObject = paramFromServiceMsg.stUDLinfo;
      if (bool1)
      {
        if ((paramObject != null) && (paramObject.SOSOUrl.length > 0)) {
          paramBusinessHandler.notifyUI(paramInt, true, paramObject.SOSOUrl);
        }
      }
      else if (bool2)
      {
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
      }
    }
    else
    {
      if (bool1)
      {
        paramBusinessHandler.notifyUI(paramInt, false, null);
        return;
      }
      if (bool2) {
        paramBusinessHandler.notifyUI(paramInt, false, null);
      }
    }
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
        localReqBody.rpt_msg_tags.add((appoint_define.InterestTag)((IInterestTagUtils)QRoute.api(IInterestTagUtils.class)).convertTo(localInterestTag));
      }
      paramInt1 += 1;
    }
    paramList = paramBusinessHandler.makeOIDBPkg("OidbSvc.0x9c7_0", 2503, 0, localReqBody.toByteArray());
    paramList.extraData.putInt("set_mode", paramInt2);
    paramList.extraData.putInt("test_mode", paramInt3);
    paramBusinessHandler.sendPbReq(paramList);
  }
  
  private static void a(BusinessHandler paramBusinessHandler, int paramInt, Oidb_0x686.CharmEvent paramCharmEvent)
  {
    int i = paramCharmEvent.uint32_old_charm.get();
    int j = paramCharmEvent.uint32_old_charm_level.get();
    int k = paramCharmEvent.uint32_new_charm.get();
    int m = paramCharmEvent.uint32_new_charm_level.get();
    int n = paramCharmEvent.uint32_cur_level_threshold.get();
    int i1 = paramCharmEvent.uint32_next_level_threshold.get();
    String str = paramCharmEvent.str_tips_content.get();
    paramCharmEvent = str;
    if (str == null) {
      paramCharmEvent = "";
    }
    paramBusinessHandler.notifyUI(paramInt, true, new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), paramCharmEvent });
    if (k - i < 0) {
      paramCharmEvent = "0X80052B2";
    } else {
      paramCharmEvent = "0X80052B1";
    }
    if ((paramBusinessHandler.appRuntime instanceof AppInterface)) {
      AppIntefaceReportWrap.a(paramBusinessHandler.appRuntime, "CliOper", "", "", paramCharmEvent, paramCharmEvent, 0, 0, "", "", "", "");
    }
  }
  
  private static void a(BusinessHandler paramBusinessHandler, int paramInt, Oidb_0x686.NearbyCharmNotify paramNearbyCharmNotify)
  {
    int i = paramNearbyCharmNotify.uint32_old_charm.get();
    int j = paramNearbyCharmNotify.uint32_old_charm_level.get();
    int k = paramNearbyCharmNotify.uint32_new_charm.get();
    int m = paramNearbyCharmNotify.uint32_new_charm_level.get();
    int n = paramNearbyCharmNotify.uint32_cur_level_threshold.get();
    int i1 = paramNearbyCharmNotify.uint32_next_level_threshold.get();
    int i2 = paramNearbyCharmNotify.uint32_old_prof_percent.get();
    int i3 = paramNearbyCharmNotify.uint32_new_prof_percent.get();
    String str = paramNearbyCharmNotify.str_tips_content.get();
    paramNearbyCharmNotify = str;
    if (str == null) {
      paramNearbyCharmNotify = "";
    }
    paramBusinessHandler.notifyUI(paramInt, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), paramNearbyCharmNotify });
    if (k - i < 0) {
      paramNearbyCharmNotify = "0X80052AF";
    } else {
      paramNearbyCharmNotify = "0X80052AE";
    }
    if ((paramBusinessHandler.appRuntime instanceof AppInterface)) {
      AppIntefaceReportWrap.a(paramBusinessHandler.appRuntime, "CliOper", "", "", paramNearbyCharmNotify, paramNearbyCharmNotify, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(BusinessHandler paramBusinessHandler, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = new cmd0x682.ReqBody();
    ((cmd0x682.ReqBody)localObject).rpt_uint64_touinlist.add(Long.valueOf(paramLong));
    localObject = paramBusinessHandler.makeOIDBPkg("OidbSvc.0x682", 1666, 0, ((cmd0x682.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putByteArray("showlove_chat_sig", paramArrayOfByte);
    paramBusinessHandler.sendPbReq((ToServiceMsg)localObject);
    a(paramBusinessHandler.appRuntime, paramInt);
    paramBusinessHandler = new StringBuilder();
    paramBusinessHandler.append("from type ");
    paramBusinessHandler.append(paramInt);
    DatingUtil.c("getShowLove", new Object[] { paramBusinessHandler.toString() });
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
    } else {
      localToServiceMsg.extraData.putBoolean("req_current_loc", true);
    }
    paramBusinessHandler.send(localToServiceMsg);
  }
  
  private static void a(DatingFilters paramDatingFilters, cmd0x5fb.ReqInfo paramReqInfo)
  {
    if (paramDatingFilters != null)
    {
      paramReqInfo.uint32_time.set(paramDatingFilters.g);
      paramReqInfo.uint32_subject.set(paramDatingFilters.i);
      paramReqInfo.uint32_gender.set(paramDatingFilters.f);
      paramReqInfo.uint32_age_low.set(DatingFilters.c[paramDatingFilters.j]);
      paramReqInfo.uint32_age_up.set(DatingFilters.b[paramDatingFilters.j]);
      PBUInt32Field localPBUInt32Field = paramReqInfo.uint32_profession;
      int i;
      if (paramDatingFilters.k < 0) {
        i = 0;
      } else {
        i = paramDatingFilters.k;
      }
      localPBUInt32Field.set(i);
      paramReqInfo.bytes_cookie.set(ByteStringMicro.copyFrom(new byte[0]));
      if ((paramDatingFilters.l != null) && (paramDatingFilters.i == 5)) {
        paramReqInfo.msg_destination.set(paramDatingFilters.l);
      }
    }
  }
  
  public static void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespFavorite)a(paramFromServiceMsg.getWupBuffer(), "RespFavorite", new RespFavorite());
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
    if (paramToServiceMsg.stHeader.iReplyCode != 0)
    {
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
  }
  
  private static void a(ToServiceMsg paramToServiceMsg, ReqUserInfo paramReqUserInfo)
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  /* Error */
  public static boolean a(BaseProtocolCoder paramBaseProtocolCoder, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 17	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 607
    //   7: invokevirtual 611	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   10: istore 5
    //   12: aload_1
    //   13: getfield 17	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   16: ldc_w 613
    //   19: invokevirtual 611	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   22: istore 6
    //   24: aload_1
    //   25: getfield 17	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   28: ldc_w 815
    //   31: invokevirtual 925	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   34: istore_3
    //   35: aload_1
    //   36: getfield 17	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   39: ldc_w 817
    //   42: invokevirtual 925	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   45: istore 4
    //   47: iload 5
    //   49: ifeq +12 -> 61
    //   52: iload_3
    //   53: ifeq +8 -> 61
    //   56: iload 4
    //   58: ifne +8 -> 66
    //   61: iload 6
    //   63: ifeq +405 -> 468
    //   66: new 939	NeighborSvc/ReqHeader
    //   69: dup
    //   70: invokespecial 940	NeighborSvc/ReqHeader:<init>	()V
    //   73: astore_0
    //   74: aload_0
    //   75: iconst_2
    //   76: putfield 943	NeighborSvc/ReqHeader:shVersion	S
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual 946	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   84: invokestatic 551	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   87: invokestatic 950	com/tencent/common/app/BaseProtocolCoder:createUserId	(J)J
    //   90: putfield 953	NeighborSvc/ReqHeader:lMID	J
    //   93: aload_0
    //   94: invokestatic 957	com/tencent/common/config/AppSetting:d	()I
    //   97: i2l
    //   98: putfield 960	NeighborSvc/ReqHeader:iAppID	J
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 963	NeighborSvc/ReqHeader:eBusiType	I
    //   106: aload_0
    //   107: iconst_2
    //   108: putfield 966	NeighborSvc/ReqHeader:eMqqSysType	I
    //   111: new 968	NeighborSvc/ReqUserInfo
    //   114: dup
    //   115: invokespecial 969	NeighborSvc/ReqUserInfo:<init>	()V
    //   118: astore 7
    //   120: aload 7
    //   122: ldc_w 971
    //   125: putfield 974	NeighborSvc/ReqUserInfo:strAuthName	Ljava/lang/String;
    //   128: aload 7
    //   130: ldc_w 976
    //   133: putfield 979	NeighborSvc/ReqUserInfo:strAuthPassword	Ljava/lang/String;
    //   136: aload 7
    //   138: iconst_0
    //   139: putfield 982	NeighborSvc/ReqUserInfo:eListType	I
    //   142: iload 5
    //   144: ifeq +49 -> 193
    //   147: aload 7
    //   149: new 165	java/util/ArrayList
    //   152: dup
    //   153: iconst_1
    //   154: invokespecial 407	java/util/ArrayList:<init>	(I)V
    //   157: putfield 983	NeighborSvc/ReqUserInfo:vCells	Ljava/util/ArrayList;
    //   160: aload 7
    //   162: new 165	java/util/ArrayList
    //   165: dup
    //   166: iconst_1
    //   167: invokespecial 407	java/util/ArrayList:<init>	(I)V
    //   170: putfield 984	NeighborSvc/ReqUserInfo:vMacs	Ljava/util/ArrayList;
    //   173: aload 7
    //   175: new 651	NeighborSvc/GPS
    //   178: dup
    //   179: iload_3
    //   180: iload 4
    //   182: iconst_0
    //   183: iconst_1
    //   184: invokespecial 985	NeighborSvc/GPS:<init>	(IIII)V
    //   187: putfield 986	NeighborSvc/ReqUserInfo:stGps	LNeighborSvc/GPS;
    //   190: goto +199 -> 389
    //   193: iload 6
    //   195: iconst_1
    //   196: if_icmpne +58 -> 254
    //   199: iload_3
    //   200: ifeq +54 -> 254
    //   203: iload 4
    //   205: ifeq +49 -> 254
    //   208: aload 7
    //   210: new 165	java/util/ArrayList
    //   213: dup
    //   214: iconst_1
    //   215: invokespecial 407	java/util/ArrayList:<init>	(I)V
    //   218: putfield 983	NeighborSvc/ReqUserInfo:vCells	Ljava/util/ArrayList;
    //   221: aload 7
    //   223: new 165	java/util/ArrayList
    //   226: dup
    //   227: iconst_1
    //   228: invokespecial 407	java/util/ArrayList:<init>	(I)V
    //   231: putfield 984	NeighborSvc/ReqUserInfo:vMacs	Ljava/util/ArrayList;
    //   234: aload 7
    //   236: new 651	NeighborSvc/GPS
    //   239: dup
    //   240: iload_3
    //   241: iload 4
    //   243: iconst_0
    //   244: iconst_1
    //   245: invokespecial 985	NeighborSvc/GPS:<init>	(IIII)V
    //   248: putfield 986	NeighborSvc/ReqUserInfo:stGps	LNeighborSvc/GPS;
    //   251: goto +138 -> 389
    //   254: ldc_w 988
    //   257: invokestatic 695	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   260: checkcast 988	com/tencent/mobileqq/soso/location/api/ILbsManagerServiceApi
    //   263: new 990	com/tencent/mobileqq/app/NearbyCmdHelper$1
    //   266: dup
    //   267: ldc_w 992
    //   270: aload_1
    //   271: invokespecial 995	com/tencent/mobileqq/app/NearbyCmdHelper$1:<init>	(Ljava/lang/String;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   274: invokeinterface 999 2 0
    //   279: aload_1
    //   280: monitorenter
    //   281: aload_1
    //   282: invokevirtual 1002	java/lang/Object:wait	()V
    //   285: goto +14 -> 299
    //   288: astore_0
    //   289: goto +175 -> 464
    //   292: astore 8
    //   294: aload 8
    //   296: invokevirtual 1005	java/lang/InterruptedException:printStackTrace	()V
    //   299: aload_1
    //   300: monitorexit
    //   301: ldc_w 1007
    //   304: invokestatic 695	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   307: checkcast 1007	com/tencent/mobileqq/nearby/api/ILbsUtils
    //   310: iconst_1
    //   311: ldc_w 988
    //   314: invokestatic 695	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   317: checkcast 988	com/tencent/mobileqq/soso/location/api/ILbsManagerServiceApi
    //   320: ldc_w 992
    //   323: invokeinterface 1011 2 0
    //   328: invokeinterface 1015 3 0
    //   333: astore 8
    //   335: aload 8
    //   337: ifnonnull +5 -> 342
    //   340: iconst_0
    //   341: ireturn
    //   342: aload 8
    //   344: getfield 125	NearbyGroup/LBSInfo:stGps	LNearbyGroup/GPS;
    //   347: ifnull +42 -> 389
    //   350: aload 8
    //   352: getfield 125	NearbyGroup/LBSInfo:stGps	LNearbyGroup/GPS;
    //   355: astore 8
    //   357: aload 7
    //   359: new 651	NeighborSvc/GPS
    //   362: dup
    //   363: aload 8
    //   365: getfield 131	NearbyGroup/GPS:iLat	I
    //   368: aload 8
    //   370: getfield 134	NearbyGroup/GPS:iLon	I
    //   373: aload 8
    //   375: getfield 137	NearbyGroup/GPS:iAlt	I
    //   378: aload 8
    //   380: getfield 140	NearbyGroup/GPS:eType	I
    //   383: invokespecial 985	NeighborSvc/GPS:<init>	(IIII)V
    //   386: putfield 986	NeighborSvc/ReqUserInfo:stGps	LNeighborSvc/GPS;
    //   389: aload 7
    //   391: getstatic 419	NeighborComm/LocalInfoType:LocalInfoType_Decode	LNeighborComm/LocalInfoType;
    //   394: invokevirtual 423	NeighborComm/LocalInfoType:value	()I
    //   397: putfield 1016	NeighborSvc/ReqUserInfo:eLocalInfo	I
    //   400: new 1018	NeighborSvc/ReqGetPoint
    //   403: dup
    //   404: aload 7
    //   406: iload 5
    //   408: i2b
    //   409: iload 6
    //   411: i2b
    //   412: invokespecial 1021	NeighborSvc/ReqGetPoint:<init>	(LNeighborSvc/ReqUserInfo;BB)V
    //   415: astore 7
    //   417: aload_2
    //   418: ldc_w 1023
    //   421: invokevirtual 1026	com/qq/jce/wup/UniPacket:setServantName	(Ljava/lang/String;)V
    //   424: aload_2
    //   425: ldc_w 1028
    //   428: invokevirtual 1031	com/qq/jce/wup/UniPacket:setFuncName	(Ljava/lang/String;)V
    //   431: aload_2
    //   432: ldc_w 1033
    //   435: aload_0
    //   436: invokevirtual 1036	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   439: aload_2
    //   440: ldc_w 1038
    //   443: aload 7
    //   445: invokevirtual 1036	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   448: aload_1
    //   449: ldc2_w 1039
    //   452: invokevirtual 1044	com/tencent/qphone/base/remote/ToServiceMsg:setTimeout	(J)V
    //   455: aload_1
    //   456: ldc_w 812
    //   459: invokevirtual 1047	com/tencent/qphone/base/remote/ToServiceMsg:setServiceCmd	(Ljava/lang/String;)V
    //   462: iconst_1
    //   463: ireturn
    //   464: aload_1
    //   465: monitorexit
    //   466: aload_0
    //   467: athrow
    //   468: iconst_0
    //   469: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	paramBaseProtocolCoder	BaseProtocolCoder
    //   0	470	1	paramToServiceMsg	ToServiceMsg
    //   0	470	2	paramUniPacket	UniPacket
    //   34	207	3	i	int
    //   45	197	4	j	int
    //   10	397	5	bool1	boolean
    //   22	388	6	bool2	boolean
    //   118	326	7	localObject1	Object
    //   292	3	8	localInterruptedException	java.lang.InterruptedException
    //   333	46	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   281	285	288	finally
    //   294	299	288	finally
    //   299	301	288	finally
    //   464	466	288	finally
    //   281	285	292	java/lang/InterruptedException
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
    if (paramBoolean)
    {
      if ((paramInt1 != 0) && (paramInt2 != 0))
      {
        localObject = new NearbyPubAcct.LBSInfo();
        ((NearbyPubAcct.LBSInfo)localObject).stGps = new NearbyPubAcct.GPS(paramInt1, paramInt2, 0, 1);
      }
      else
      {
        localObject = a(((ILbsUtils)QRoute.api(ILbsUtils.class)).getRawLbsInfo());
      }
      Object localObject = new ReqGetNearbyPubAcctInfo((short)2, new byte[0], 2, (NearbyPubAcct.LBSInfo)localObject);
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setRequestId(1);
      localUniPacket.setServantName("PubAccountSvc.nearby_pubacct");
      localUniPacket.setFuncName("nearby_pubacct");
      localUniPacket.put("nearby_pubacct", localObject);
      return localUniPacket.encode();
    }
    return null;
  }
  
  public static void b(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (i == 0) {
          bool = true;
        }
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("rspNearbyCharmEvent,result code：");
          paramFromServiceMsg.append(i);
          paramFromServiceMsg.append(",isSuccess:");
          paramFromServiceMsg.append(bool);
          QLog.d("Q.nearby", 2, paramFromServiceMsg.toString());
        }
        if (bool)
        {
          paramFromServiceMsg = new Oidb_0x686.RspBody();
          i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get();
          paramFromServiceMsg.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
          int j;
          if (paramFromServiceMsg.uint32_config_seq.has())
          {
            j = paramFromServiceMsg.uint32_config_seq.get();
            ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramBusinessHandler.appRuntime.getAccount(), "toplist_hide_boygod_seq", Integer.valueOf(j));
          }
          if (paramFromServiceMsg.uint32_config_time.has())
          {
            j = paramFromServiceMsg.uint32_config_time.get();
            ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramBusinessHandler.appRuntime.getAccount(), "key_last_config_time", Integer.valueOf(j));
          }
          bool = paramFromServiceMsg.msg_rank_config.has();
          Oidb_0x686.CharmEvent localCharmEvent = null;
          if (!bool) {
            break label454;
          }
          paramObject = (Oidb_0x686.NearbyRankConfig)paramFromServiceMsg.msg_rank_config.get();
          if (!paramFromServiceMsg.msg_feed_config.has()) {
            break label460;
          }
          localObject = (Oidb_0x686.NearbyFeedConfig)paramFromServiceMsg.msg_feed_config.get();
          if ((i == 2) && (paramFromServiceMsg.msg_charm_event.has()))
          {
            localCharmEvent = (Oidb_0x686.CharmEvent)paramFromServiceMsg.msg_charm_event.get();
            paramFromServiceMsg = null;
          }
          else
          {
            if ((i != 1) || (!paramFromServiceMsg.msg_notify_event.has())) {
              break label466;
            }
            paramFromServiceMsg = (Oidb_0x686.NearbyCharmNotify)paramFromServiceMsg.msg_notify_event.get();
          }
          if ((!(paramBusinessHandler.appRuntime instanceof INearbyAppInterface)) && ((paramBusinessHandler.appRuntime instanceof QQAppInterface))) {
            NearbyManagerHelper.a((QQAppInterface)paramBusinessHandler.appRuntime).a(paramToServiceMsg.getUin(), paramObject, localObject, localCharmEvent, paramFromServiceMsg);
          }
          if ((localCharmEvent != null) && (localCharmEvent.uint32_pop_flag.get() == 1))
          {
            a(paramBusinessHandler, paramInt, localCharmEvent);
            return;
          }
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_pop_flag.get() == 1)) {
            a(paramBusinessHandler, paramInt, paramFromServiceMsg);
          }
        }
        return;
      }
      catch (Exception paramBusinessHandler)
      {
        return;
      }
      label454:
      paramObject = null;
      continue;
      label460:
      Object localObject = null;
      continue;
      label466:
      paramFromServiceMsg = null;
    }
  }
  
  protected static boolean b(AppInterface paramAppInterface, ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, BaseProtocolCoder paramBaseProtocolCoder)
  {
    int i = paramToServiceMsg.extraData.getInt("localLat");
    int j = paramToServiceMsg.extraData.getInt("localLon");
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("NearbyCmdHelper.handleCheckIn,  lat=");
      paramAppInterface.append(i);
      paramAppInterface.append(", lon=");
      paramAppInterface.append(j);
      QLog.d("Q.hotChatDistance", 2, paramAppInterface.toString());
    }
    if ((i != 0) && (j != 0))
    {
      paramAppInterface = new ReqHeader();
      paramAppInterface.shVersion = 3;
      paramAppInterface.lMID = BaseProtocolCoder.createUserId(Long.parseLong(paramToServiceMsg.getUin()));
      paramAppInterface.iAppID = AppSetting.d();
      paramAppInterface.eBusiType = 0;
      paramAppInterface.eMqqSysType = 2;
      paramToServiceMsg = new ReqUserInfo();
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
    int j = -1;
    Object localObject = Integer.valueOf(-1);
    Boolean localBoolean = Boolean.valueOf(true);
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      int i;
      if (paramToServiceMsg.extraData == null) {
        i = -1;
      } else {
        i = paramToServiceMsg.extraData.getInt("set_mode");
      }
      if (paramToServiceMsg.extraData != null) {
        j = paramToServiceMsg.extraData.getInt("test_mode");
      }
      localObject = new cmd0x9c7.RspBody();
      int m = BusinessHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (m == 0)
      {
        if (((cmd0x9c7.RspBody)localObject).str_test_result_url.has()) {
          paramToServiceMsg = ((cmd0x9c7.RspBody)localObject).str_test_result_url.get();
        } else {
          paramToServiceMsg = "";
        }
        if (((cmd0x9c7.RspBody)localObject).rpt_msg_tags.has()) {
          paramFromServiceMsg = ((cmd0x9c7.RspBody)localObject).rpt_msg_tags.get();
        } else {
          paramFromServiceMsg = null;
        }
        paramObject = new ArrayList();
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
        {
          int k = 0;
          while (k < paramFromServiceMsg.size())
          {
            InterestTag localInterestTag = (InterestTag)((IInterestTagUtils)QRoute.api(IInterestTagUtils.class)).convertFrom(paramFromServiceMsg.get(k));
            if (localInterestTag != null) {
              paramObject.add(localInterestTag);
            }
            k += 1;
          }
        }
        if (paramObject.size() <= 0)
        {
          paramBusinessHandler.notifyUI(4, false, new Object[] { "", null, HardCodeUtil.a(2131904992), Integer.valueOf(i), Integer.valueOf(j) });
          NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c7_0", new Object[] { Integer.valueOf(m), localBoolean, null, paramToServiceMsg });
          return;
        }
        if ((paramBusinessHandler.appRuntime instanceof INearbyAppInterface)) {
          ((INearbyAppInterface)paramBusinessHandler.appRuntime).getNearbyProcManager().b(localObject);
        } else if ((paramBusinessHandler.appRuntime != null) && ((paramBusinessHandler.appRuntime instanceof QQAppInterface))) {
          NearbyManagerHelper.a((QQAppInterface)paramBusinessHandler.appRuntime).b(localObject);
        }
        paramBusinessHandler.notifyUI(paramInt, true, new Object[] { paramToServiceMsg, paramObject, "", Integer.valueOf(i), Integer.valueOf(j) });
        NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c7_0", new Object[] { Integer.valueOf(m), localBoolean, paramObject, paramToServiceMsg });
        return;
      }
      if (((cmd0x9c7.RspBody)localObject).str_error.has()) {
        paramToServiceMsg = ((cmd0x9c7.RspBody)localObject).str_error.get();
      } else {
        paramToServiceMsg = "";
      }
      paramBusinessHandler.notifyUI(paramInt, false, new Object[] { "", null, paramToServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
      return;
    }
    paramBusinessHandler.notifyUI(paramInt, false, new Object[] { "", null, HardCodeUtil.a(2131904991), localObject, localObject });
  }
  
  public static void d(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = paramObject;
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
      {
        int i = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handle_oidb_0x4ff_9 ret=");
          paramObject.append(i);
          QLog.i("Q.dating", 2, paramObject.toString());
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
          bool1 = true;
          break label209;
        }
      }
    }
    boolean bool1 = false;
    label209:
    if ((paramBusinessHandler.appRuntime instanceof QQAppInterface))
    {
      if (paramInt == 7)
      {
        paramInt = paramToServiceMsg.extraData.getByte("session_switch_value", (byte)0).byteValue();
        if (bool1)
        {
          paramToServiceMsg = NearbyManagerHelper.a((QQAppInterface)paramBusinessHandler.appRuntime);
          if (paramInt != 0) {
            bool2 = false;
          }
          paramToServiceMsg.b(bool2);
        }
        paramBusinessHandler.notifyUI(7, bool1, null);
      }
    }
    else if ((paramBusinessHandler.appRuntime instanceof INearbyAppInterface))
    {
      paramFromServiceMsg = (INearbyAppInterface)paramBusinessHandler.appRuntime;
      if (paramInt == 10)
      {
        byte b = paramToServiceMsg.extraData.getByte("session_switch_value", (byte)0).byteValue();
        if (bool1) {
          paramFromServiceMsg.getNearbyProcManager().a(b);
        }
        paramBusinessHandler.notifyUI(10, bool1, null);
      }
    }
    if (QLog.isColorLevel())
    {
      paramBusinessHandler = new StringBuilder();
      paramBusinessHandler.append("handle_oidb_0x4ff_9, isSuccess:");
      paramBusinessHandler.append(bool1);
      QLog.d("Q.dating", 2, paramBusinessHandler.toString());
    }
  }
  
  public static void e(BusinessHandler paramBusinessHandler, int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0x682.RspBody localRspBody = new cmd0x682.RspBody();
    int i = BusinessHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleGetShowLoveLimit result = ");
    paramFromServiceMsg.append(i);
    DatingUtil.a("getShowLove", new Object[] { paramFromServiceMsg.toString() });
    if ((i == 0) && (localRspBody.rpt_msg_chatinfo.has()) && (localRspBody.rpt_msg_chatinfo.size() > 0))
    {
      paramObject = (cmd0x682.ChatInfo)localRspBody.rpt_msg_chatinfo.get(0);
      long l = paramObject.uint64_touin.get();
      paramInt = paramObject.uint32_chatflag.get();
      int j = paramObject.uint32_goldflag.get();
      int k = paramObject.uint32_totalexpcount.get();
      int m = paramObject.uint32_curexpcount.get();
      int n = paramObject.uint32_totalFlag.get();
      int i1 = paramObject.uint32_curdayFlag.get();
      paramFromServiceMsg = paramObject.express_tips_msg.get().toStringUtf8();
      paramObject = paramObject.express_msg.get().toStringUtf8();
      paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("showlove_chat_sig");
      boolean bool1;
      if (((paramInt & 0x2) != 2) && (j != 2)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      boolean bool2;
      if ((j == 1) && (n == 0) && (i1 == 0)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if ((paramBusinessHandler instanceof INearbyCardHandler)) {
        paramBusinessHandler.notifyUI(9, true, new Object[] { Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg, paramObject });
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("toUin:");
        paramToServiceMsg.append(l);
        paramToServiceMsg.append(",chatFlag:");
        paramToServiceMsg.append(paramInt);
        paramToServiceMsg.append(",godFlag:");
        paramToServiceMsg.append(j);
        paramToServiceMsg.append(",totalCount:");
        paramToServiceMsg.append(k);
        paramToServiceMsg.append(",curCount");
        paramToServiceMsg.append(m);
        paramToServiceMsg.append(",totalFlag:");
        paramToServiceMsg.append(n);
        paramToServiceMsg.append(",curdayFlag:");
        paramToServiceMsg.append(i1);
        paramToServiceMsg.append(",canChat:");
        paramToServiceMsg.append(bool1);
        paramToServiceMsg.append(",canShowLove:");
        paramToServiceMsg.append(bool2);
        paramToServiceMsg.append(",wordStr:");
        paramToServiceMsg.append(paramFromServiceMsg);
        paramToServiceMsg.append("showloveStr: ");
        paramToServiceMsg.append(paramObject);
        QLog.d("DatingSayHello", 2, paramToServiceMsg.toString());
      }
      if (i1 == 1) {
        AppIntefaceReportWrap.a(paramBusinessHandler.appRuntime, "CliOper", "", "", "0X8005290", "0X8005290", 0, 0, "", "", "", "");
      } else if (n == 1) {
        AppIntefaceReportWrap.a(paramBusinessHandler.appRuntime, "CliOper", "", "", "0X8005291", "0X8005291", 0, 0, "", "", "", "");
      }
    }
    else
    {
      paramBusinessHandler.notifyUI(paramInt, false, null);
    }
    if (QLog.isColorLevel())
    {
      paramBusinessHandler = new StringBuilder();
      paramBusinessHandler.append("handleGetShowLoveLimit,result：");
      paramBusinessHandler.append(i);
      QLog.d("Q.nearby_bank", 2, paramBusinessHandler.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyCmdHelper
 * JD-Core Version:    0.7.0.1
 */