package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import appoint.define.appoint_define.PublisherInfo;
import com.dataline.util.DBNetworkUtil;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.dating.NearbyAIODataReportUtil;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.ReportRecord;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.nearpeople.api.INearbyMineHelper;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard.NearbyMyTabConfig;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard.NearbyMyTabConfigExtraVal;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.now.ilive_feeds_near_anchor.GetNearAnchorReq;
import com.tencent.pb.now.ilive_feeds_near_anchor.GetNearAnchorRsp;
import com.tencent.pb.now.ilive_nearby_user_control.EnterNearbyUserContrlReq;
import com.tencent.pb.now.ilive_nearby_user_control.EnterNearbyUserContrlRsp;
import com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.LBSInfo;
import com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.Location;
import com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.QueryRecommendReq;
import com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.QueryRecommendRsp;
import com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.QueryReqItem;
import com.tencent.protobuf.nearbyReportSvr.NearbyReportSvr.CommonData;
import com.tencent.protobuf.nearbyReportSvr.NearbyReportSvr.Location;
import com.tencent.protobuf.nearbyReportSvr.NearbyReportSvr.TempChatReq;
import com.tencent.protobuf.nearbyReportSvr.NearbyReportSvr.TempChatRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x4f0.cmd0x4f0.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspConfigItem;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspLikeInfo;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspPansocialInfo;
import tencent.im.oidb.cmd0x77f.cmd0x77f.VisitProfRec;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.NearbyConfig;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;
import tencent.im.oidb.cmd0xada.oidb_0xada.ReqBody;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;
import tencent.im.oidb.cmd0xafc.cmd0xafc.HeartBeat;
import tencent.im.oidb.cmd0xafc.cmd0xafc.Location;
import tencent.im.oidb.cmd0xafc.cmd0xafc.NearbyEnter;
import tencent.im.oidb.cmd0xafc.cmd0xafc.NearbyExit;
import tencent.im.oidb.cmd0xafc.cmd0xafc.ReqBody;
import tencent.im.oidb.cmd0xafc.cmd0xafc.RspBody;
import tencent.sso.accretion.flower_info.SFlowerInfoRsp;

public class NearbyHandler
  extends BusinessHandler
{
  INearbyAppInterface a;
  
  public NearbyHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    if ((paramAppInterface instanceof INearbyAppInterface)) {
      this.a = ((INearbyAppInterface)paramAppInterface);
    }
  }
  
  public static int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  @Nullable
  private ArrayList<StrangerInfo> a(cmd0x4f0.RspBody paramRspBody)
  {
    boolean bool = paramRspBody.rpt_msg_vistor_info.has();
    ArrayList localArrayList = null;
    Object localObject;
    if (bool) {
      localObject = paramRspBody.rpt_msg_vistor_info.get();
    } else {
      localObject = null;
    }
    paramRspBody = localArrayList;
    if (localObject != null)
    {
      paramRspBody = localArrayList;
      if (!((List)localObject).isEmpty())
      {
        localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        for (;;)
        {
          paramRspBody = localArrayList;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramRspBody = StrangerInfo.convertFrom((appoint_define.PublisherInfo)((Iterator)localObject).next());
          if (paramRspBody != null) {
            localArrayList.add(paramRspBody);
          }
        }
      }
    }
    return paramRspBody;
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt)
  {
    AppIntefaceReportWrap.a(paramAppInterface, "CliOper", "", "", "Neiggbor", "ReqGetEncounter", 0, paramInt, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, mqq.observer.BusinessObserver paramBusinessObserver)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("client_ver", "8.7.0");
        localJSONObject.put("from", paramString2);
        if ("1".equals(paramString2))
        {
          byte[] arrayOfByte = paramQQAppInterface.getMsgCache().j(paramString1);
          if (arrayOfByte != null) {
            localJSONObject.put("chat_sig", new String(Base64Util.encode(arrayOfByte, 0)));
          }
        }
        localJSONObject.put("targetuin", paramString1);
        localJSONObject.put("operation", paramString3);
        if ("1".equals(paramString2))
        {
          i = 3077;
        }
        else
        {
          if (!"6".equals(paramString2)) {
            break label224;
          }
          i = 3089;
        }
        localJSONObject.put("sourceid", i);
        localJSONObject.put("sub_sourceid", paramInt);
        paramString1 = new NewIntent(paramQQAppInterface.getApplication().getApplicationContext(), ProtoServlet.class);
        paramString1.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.follow_user");
        paramString2 = new WebSsoBody.WebSsoRequestBody();
        paramString2.type.set(0);
        paramString2.data.set(localJSONObject.toString());
        paramString1.putExtra("data", paramString2.toByteArray());
        paramString1.setObserver(paramBusinessObserver);
        paramQQAppInterface.startServlet(paramString1);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      label224:
      int i = 3076;
    }
  }
  
  public static void a(INearbyAppInterface paramINearbyAppInterface, long[] paramArrayOfLong, mqq.observer.BusinessObserver paramBusinessObserver)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = new JSONArray();
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        ((JSONArray)localObject).put(paramArrayOfLong[i]);
        i += 1;
      }
    }
    try
    {
      localJSONObject.put("uins", localObject);
      paramArrayOfLong = new NewIntent(paramINearbyAppInterface.getApplication().getApplicationContext(), ProtoServlet.class);
      paramArrayOfLong.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.encrypt_uins");
      localObject = new WebSsoBody.WebSsoRequestBody();
      ((WebSsoBody.WebSsoRequestBody)localObject).type.set(0);
      ((WebSsoBody.WebSsoRequestBody)localObject).data.set(localJSONObject.toString());
      paramArrayOfLong.putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject).toByteArray());
      paramArrayOfLong.setObserver(paramBusinessObserver);
      paramINearbyAppInterface.startServlet(paramArrayOfLong);
      return;
    }
    catch (Exception paramINearbyAppInterface) {}
  }
  
  private void a(Oidb_0x66b.RspBody paramRspBody, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (paramRspBody.rpt_msg_vistor_info.has())
    {
      paramNearbyMyTabCard.visitors.clear();
      paramRspBody = paramRspBody.rpt_msg_vistor_info.get().iterator();
      while (paramRspBody.hasNext())
      {
        Object localObject = (appoint_define.PublisherInfo)paramRspBody.next();
        if (localObject != null)
        {
          localObject = StrangerInfo.convertFrom((appoint_define.PublisherInfo)localObject);
          if (localObject != null) {
            paramNearbyMyTabCard.visitors.add(localObject);
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramRspBody = new StringBuilder();
        paramRspBody.append("handleGetNearbyMyTab visitor info is: ");
        paramRspBody.append(paramNearbyMyTabCard.visitors.toString());
        QLog.i("NearbyHandler", 2, paramRspBody.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("NearbyHandler", 2, "handleGetNearbyMyTay has no visitor info.");
    }
    ((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).storeNearbyMyTabCard((AppInterface)this.a, paramNearbyMyTabCard);
    this.a.updateMyTabCard(paramNearbyMyTabCard);
    notifyUI(3, true, new Object[] { paramNearbyMyTabCard });
  }
  
  private void a(Oidb_0x66b.RspBody paramRspBody, oidb_0x5eb.RspBody paramRspBody1, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (paramRspBody.bytes_rspbody_5eb.has())
    {
      paramRspBody = paramRspBody.bytes_rspbody_5eb.get().toByteArray();
      try
      {
        paramRspBody1.mergeFrom(paramRspBody);
        if ((paramRspBody1.rpt_msg_uin_data.has()) && (paramRspBody1.rpt_msg_uin_data.size() > 0))
        {
          paramRspBody = (oidb_0x5eb.UdcUinData)paramRspBody1.rpt_msg_uin_data.get().get(0);
          paramNearbyMyTabCard.uin = Long.valueOf(paramRspBody.uint64_uin.get());
          paramNearbyMyTabCard.nickName = paramRspBody.bytes_stranger_nick.get().toStringUtf8();
          paramNearbyMyTabCard.carrier = paramRspBody.uint32_profession.get();
          paramNearbyMyTabCard.gender = paramRspBody.uint32_gender.get();
          if ((paramNearbyMyTabCard.gender == 1) || (paramNearbyMyTabCard.gender == 2))
          {
            paramRspBody1 = (INearbySPUtil)QRoute.api(INearbySPUtil.class);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramNearbyMyTabCard.uin);
            localStringBuilder.append("");
            paramRspBody1.setValue(localStringBuilder.toString(), "self_gender", Integer.valueOf(paramNearbyMyTabCard.gender));
          }
          paramNearbyMyTabCard.age = paramRspBody.uint32_age.get();
          paramNearbyMyTabCard.godFlag = paramRspBody.uint32_god_flag.get();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramRspBody)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NewNearbyMyTab", 2, "fail to decode 5eb_rspBody", paramRspBody);
        }
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt, long paramLong1, long paramLong2, long paramLong3, ArrayList<StrangerInfo> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby.visitor", 2, "handleGetRecentVisitors|c");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetRecentVisitors|cookie lenght: ");
      int j = 0;
      int i;
      if (paramArrayOfByte == null) {
        i = 0;
      } else {
        i = paramArrayOfByte.length;
      }
      localStringBuilder.append(i);
      localStringBuilder.append(",compleFlag: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",totalVisitor: ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",newVisitor:");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(",hisVisitor:");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append(",visitorCount: ");
      if (paramArrayList == null) {
        paramInt = j;
      } else {
        paramInt = paramArrayList.size();
      }
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",visitor info is: ");
      if (paramArrayList == null) {
        paramArrayOfByte = null;
      } else {
        paramArrayOfByte = paramArrayList.toString();
      }
      localStringBuilder.append(paramArrayOfByte);
      QLog.i("Q.nearby.visitor", 2, localStringBuilder.toString());
    }
  }
  
  private boolean a(oidb_0xada.ReqBody paramReqBody)
  {
    paramReqBody.uid.set(Long.parseLong(this.a.getCurrentAccountUin()));
    paramReqBody.tinyid.set(Long.parseLong(this.a.getCurrentAccountUin()));
    Object localObject = (TicketManager)this.a.getManager(2);
    String str = ((TicketManager)localObject).getA2(this.a.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(this.a.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramReqBody.a2.set(str);
      paramReqBody.platform.set(1);
      paramReqBody.version.set("8.7.0");
      paramReqBody.version_code.set(ApkUtils.a(BaseApplicationImpl.sApplication));
      paramReqBody.original_id.set(this.a.getCurrentAccountUin());
      paramReqBody.original_key.set((String)localObject);
      paramReqBody.original_id_type.set(1);
      return true;
    }
    return false;
  }
  
  private void b(NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (QLog.isDevelopLevel())
    {
      int i = 0;
      String str = "";
      while (i < paramNearbyMyTabCard.configList.size())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(((NearbyMyTabCard.NearbyMyTabConfig)paramNearbyMyTabCard.configList.get(i)).configId);
        localStringBuilder.append(((NearbyMyTabCard.NearbyMyTabConfig)paramNearbyMyTabCard.configList.get(i)).strName);
        localStringBuilder.append(((NearbyMyTabCard.NearbyMyTabConfig)paramNearbyMyTabCard.configList.get(i)).strUrl);
        localStringBuilder.append("\n");
        str = localStringBuilder.toString();
        i += 1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetNearbyMyTab---->uin =");
      localStringBuilder.append(paramNearbyMyTabCard.uin);
      localStringBuilder.append("nickName = ");
      localStringBuilder.append(paramNearbyMyTabCard.nickName);
      localStringBuilder.append(" profression = ");
      localStringBuilder.append(paramNearbyMyTabCard.carrier);
      localStringBuilder.append(" gender = ");
      localStringBuilder.append(paramNearbyMyTabCard.gender);
      localStringBuilder.append("age =");
      localStringBuilder.append(paramNearbyMyTabCard.age);
      localStringBuilder.append(" likeTotalNum = ");
      localStringBuilder.append(paramNearbyMyTabCard.likeTotalNum);
      localStringBuilder.append("likeNewNum = ");
      localStringBuilder.append(paramNearbyMyTabCard.newLikeNum);
      localStringBuilder.append("charmVale =");
      localStringBuilder.append(paramNearbyMyTabCard.charmValue);
      localStringBuilder.append("charmLevel =");
      localStringBuilder.append(paramNearbyMyTabCard.charmLevel);
      localStringBuilder.append("charmCurrent =");
      localStringBuilder.append(paramNearbyMyTabCard.currentCharm);
      localStringBuilder.append("charmNext");
      localStringBuilder.append(paramNearbyMyTabCard.nextCharm);
      localStringBuilder.append(" giftNum = ");
      localStringBuilder.append(paramNearbyMyTabCard.giftNum);
      localStringBuilder.append("config = ");
      localStringBuilder.append(str);
      QLog.d("NewNearbyMyTab", 2, localStringBuilder.toString());
    }
  }
  
  private void b(Oidb_0x66b.RspBody paramRspBody, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (paramRspBody.stConfigList.has())
    {
      Object localObject = paramRspBody.stConfigList.get();
      paramRspBody = new boolean[2];
      Oidb_0x66b.RspBody tmp24_23 = paramRspBody;
      tmp24_23[0] = 0;
      Oidb_0x66b.RspBody tmp30_24 = tmp24_23;
      tmp30_24[1] = 0;
      tmp30_24;
      localObject = ((List)localObject).iterator();
      int i;
      for (;;)
      {
        boolean bool2 = ((Iterator)localObject).hasNext();
        i = 0;
        if (!bool2) {
          break;
        }
        Oidb_0x66b.RspConfigItem localRspConfigItem = (Oidb_0x66b.RspConfigItem)((Iterator)localObject).next();
        if ((localRspConfigItem.uint32_id.has()) && (localRspConfigItem.uint32_id.get() == 10001))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby", 2, "handleGetNearbyMyTab|shield date entrance");
          }
        }
        else
        {
          NearbyMyTabCard.NearbyMyTabConfig localNearbyMyTabConfig = new NearbyMyTabCard.NearbyMyTabConfig();
          localNearbyMyTabConfig.configId = localRspConfigItem.uint32_id.get();
          localNearbyMyTabConfig.strName = localRspConfigItem.str_name.get();
          localNearbyMyTabConfig.strUrl = localRspConfigItem.str_url.get();
          localNearbyMyTabConfig.iconUrl = localRspConfigItem.str_picurl.get();
          localNearbyMyTabConfig.tips = localRspConfigItem.str_tips.get();
          localNearbyMyTabConfig.extraVal = ((NearbyMyTabCard.NearbyMyTabConfigExtraVal)((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).NEARBYMYTAB_CONFIG_EXTRAVALS().get(Integer.valueOf(localNearbyMyTabConfig.configId)));
          paramNearbyMyTabCard.configList.add(localNearbyMyTabConfig);
          if ((localNearbyMyTabConfig.extraVal != null) && (localNearbyMyTabConfig.extraVal.pathId != 0)) {
            if (localNearbyMyTabConfig.extraVal.pathId == 100511) {
              paramRspBody[0] = 1;
            } else if (localNearbyMyTabConfig.extraVal.pathId == 100517) {
              paramRspBody[1] = 1;
            }
          }
        }
      }
      boolean bool1 = false;
      while (i < paramRspBody.length)
      {
        bool1 |= this.a.getNearbyProcManager().a(i, paramRspBody[i]);
        i += 1;
      }
      if (bool1) {
        notifyUI(12, true, null);
      }
    }
  }
  
  private void c(Oidb_0x66b.RspBody paramRspBody, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (paramRspBody.bytes_rspbody_gift.has())
    {
      byte[] arrayOfByte = paramRspBody.bytes_rspbody_gift.get().toByteArray();
      paramRspBody = new flower_info.SFlowerInfoRsp();
      try
      {
        paramRspBody.mergeFrom(arrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        paramNearbyMyTabCard.giftNum = 0;
        if (QLog.isColorLevel()) {
          QLog.e("NewNearbyMyTab", 2, "fail to decode SFlowerInfoRsp", localInvalidProtocolBufferMicroException);
        }
      }
      paramNearbyMyTabCard.giftNum = paramRspBody.num.get();
    }
  }
  
  private void d(Oidb_0x66b.RspBody paramRspBody, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (paramRspBody.stPansocialInfo.has())
    {
      paramRspBody = (Oidb_0x66b.RspPansocialInfo)paramRspBody.stPansocialInfo.get();
      paramNearbyMyTabCard.charmValue = paramRspBody.uint32_charm.get();
      paramNearbyMyTabCard.charmLevel = paramRspBody.uint32_charmlevel.get();
      paramNearbyMyTabCard.currentCharm = paramRspBody.uint32_charmlevelvalue.get();
      paramNearbyMyTabCard.nextCharm = paramRspBody.uint32_nextcharmlevelvalue.get();
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      Object localObject = new cmd0x4f0.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      boolean bool = paramToServiceMsg.extraData.getBoolean("is_first_page");
      paramToServiceMsg = "";
      paramFromServiceMsg = null;
      if (i == 0)
      {
        paramToServiceMsg = paramFromServiceMsg;
        if (((cmd0x4f0.RspBody)localObject).bytes_cookie.has()) {
          paramToServiceMsg = ((cmd0x4f0.RspBody)localObject).bytes_cookie.get().toByteArray();
        }
        if (((cmd0x4f0.RspBody)localObject).uint32_completed.has()) {
          i = ((cmd0x4f0.RspBody)localObject).uint32_completed.get();
        } else {
          i = 0;
        }
        long l1;
        if (((cmd0x4f0.RspBody)localObject).uint32_total_visitor.has()) {
          l1 = ((cmd0x4f0.RspBody)localObject).uint32_total_visitor.get();
        } else {
          l1 = 0L;
        }
        long l2;
        if (((cmd0x4f0.RspBody)localObject).uint32_unread_visitor.has()) {
          l2 = ((cmd0x4f0.RspBody)localObject).uint32_unread_visitor.get();
        } else {
          l2 = 0L;
        }
        long l4 = l1 - l2;
        paramFromServiceMsg = a((cmd0x4f0.RspBody)localObject);
        a(paramToServiceMsg, i, l1, l2, l4, paramFromServiceMsg);
        if ((bool) && (paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty()))
        {
          paramObject = this.a.getEntityManagerFactory().createEntityManager();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("DELETE FROM ");
          ((StringBuilder)localObject).append(StrangerInfo.class.getSimpleName());
          ((StringBuilder)localObject).append(";");
          paramObject.execSQL(((StringBuilder)localObject).toString());
          localObject = paramFromServiceMsg.iterator();
          while (((Iterator)localObject).hasNext()) {
            paramObject.persist((StrangerInfo)((Iterator)localObject).next());
          }
          paramObject = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getSharedPreferences("nearby_visitor_file", this.a.getAccount(), 0).edit();
          long l3 = l1;
          if (l3 > 0L)
          {
            paramObject.putLong("sp_nearby_total_visitor", l3);
            l3 = l2;
            if (l3 > 0L) {
              paramObject.putLong("sp_nearby_new_visitor", l3);
            }
            if (l4 > 0L) {
              paramObject.putLong("sp_nearby_his_visitor", l4);
            }
            paramObject.commit();
          }
          else {}
        }
        notifyUI(11, true, new Object[] { paramFromServiceMsg, paramToServiceMsg, Integer.valueOf(i), Long.valueOf(l1), "", Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(l4) });
        return;
      }
      if (((cmd0x4f0.RspBody)localObject).str_error_tips.has()) {
        paramToServiceMsg = ((cmd0x4f0.RspBody)localObject).str_error_tips.get();
      }
      notifyUI(11, false, new Object[] { null, null, Integer.valueOf(-1), Long.valueOf(-1L), paramToServiceMsg, Boolean.valueOf(bool), Long.valueOf(-1L), Long.valueOf(-1L) });
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetRecentVisitors: result is: ");
        paramFromServiceMsg.append(i);
        paramFromServiceMsg.append(" errorTips: ");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.i("NearbyHandler", 2, paramFromServiceMsg.toString());
      }
    }
  }
  
  private void e(Oidb_0x66b.RspBody paramRspBody, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (paramRspBody.stLikeInfo.has())
    {
      paramRspBody = (Oidb_0x66b.RspLikeInfo)paramRspBody.stLikeInfo.get();
      int i = paramRspBody.uint32_total.get();
      int j = paramRspBody.uint32_new.get();
      paramRspBody = this.a.getMyTabCard();
      if ((paramRspBody != null) && (i <= paramRspBody.likeTotalNum))
      {
        paramNearbyMyTabCard.likeTotalNum = paramRspBody.likeTotalNum;
        paramNearbyMyTabCard.newLikeNum = paramRspBody.newLikeNum;
        return;
      }
      paramNearbyMyTabCard.likeTotalNum = i;
      paramNearbyMyTabCard.newLikeNum = j;
      this.a.writeVoteRedDotState(0);
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      paramToServiceMsg = new nearbyPeopleRecommend.QueryRecommendRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("InvalidProtocolBufferMicroException e = ");
          paramObject.append(paramFromServiceMsg.getMessage());
          QLog.e("NearbyRecommend", 2, paramObject.toString());
        }
      }
      if ((paramToServiceMsg.ret_code.get() != 0) && (QLog.isColorLevel()))
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("get failed,code =  ");
        paramFromServiceMsg.append(paramToServiceMsg.ret_code.get());
        QLog.e("NearbyRecommend", 2, paramFromServiceMsg.toString());
      }
      if (!paramToServiceMsg.query_list.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("NearbyRecommend", 2, "handleNearbyRecommendUser,not has query_list");
        }
        return;
      }
      paramToServiceMsg = paramToServiceMsg.query_list.get();
      if (paramToServiceMsg.size() <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NearbyRecommend", 2, "handleNearbyRecommendUser,rpt_recomm_people size == 0 ");
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("get success size= ");
        paramFromServiceMsg.append(paramToServiceMsg.size());
        QLog.i("NearbyRecommend", 2, paramFromServiceMsg.toString());
      }
      notifyUI(22, true, new Object[] { paramToServiceMsg });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("NearbyRecommend", 2, "handleNearbyRecommendUser req == null || res == null");
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      paramToServiceMsg = new NearbyReportSvr.TempChatRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("InvalidProtocolBufferMicroException e = ");
          paramObject.append(paramFromServiceMsg.getMessage());
          QLog.e("NearbyIMReport", 2, paramObject.toString());
        }
      }
      if ((paramToServiceMsg.ret_code.get() != 0) && (QLog.isColorLevel()))
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("get failed,code =  ");
        paramFromServiceMsg.append(paramToServiceMsg.ret_code.get());
        paramFromServiceMsg.append(" msg:");
        paramFromServiceMsg.append(paramToServiceMsg.ret_msg.get());
        QLog.e("NearbyIMReport", 2, paramFromServiceMsg.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("NearbyIMReport", 2, "handleNearbyIMReport req == null || res == null || data == null");
    }
  }
  
  cmd0x77f.VisitProfRec a(ReportRecord paramReportRecord)
  {
    cmd0x77f.VisitProfRec localVisitProfRec = new cmd0x77f.VisitProfRec();
    localVisitProfRec.uint64_tinyid.set(paramReportRecord.jdField_a_of_type_Long);
    localVisitProfRec.uint32_seq.set(paramReportRecord.jdField_a_of_type_Int);
    if (paramReportRecord.c > 0) {
      localVisitProfRec.uint32_enter_count.set(paramReportRecord.c);
    }
    if (paramReportRecord.d > 0) {
      localVisitProfRec.uint32_visit_duration.set(paramReportRecord.d);
    }
    if (paramReportRecord.e > 0) {
      localVisitProfRec.uint32_visit_pic_count.set(paramReportRecord.e);
    }
    if (paramReportRecord.f > 0) {
      localVisitProfRec.uint32_opflag.set(paramReportRecord.f);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("convert2VisitRec ,record =");
      localStringBuilder.append(paramReportRecord);
      QLog.d("NearbyHandler", 2, localStringBuilder.toString());
    }
    return localVisitProfRec;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyHandler", 2, "notifyExitNearby");
    }
    notifyUI(20, true, new Object[0]);
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    Object localObject = new oidb_0xada.ReqBody();
    if (!a((oidb_0xada.ReqBody)localObject))
    {
      QLog.e("NearbyHandler", 1, "oidb_0xada getNowLivingAvatar failed");
      return;
    }
    ilive_feeds_near_anchor.GetNearAnchorReq localGetNearAnchorReq = new ilive_feeds_near_anchor.GetNearAnchorReq();
    localGetNearAnchorReq.longitude.set(paramFloat1);
    localGetNearAnchorReq.latitude.set(paramFloat2);
    localGetNearAnchorReq.start.set(0);
    localGetNearAnchorReq.num.set(paramInt);
    localGetNearAnchorReq.source.set(1);
    localGetNearAnchorReq.gender_filter.set(0);
    ((oidb_0xada.ReqBody)localObject).cmd.set(24833);
    ((oidb_0xada.ReqBody)localObject).subcmd.set(1);
    ((oidb_0xada.ReqBody)localObject).busi_buf.set(ByteStringMicro.copyFrom(localGetNearAnchorReq.toByteArray()));
    localObject = makeOIDBPkg("OidbSvc.0xada_0", 2778, 0, ((oidb_0xada.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("innerReq", "ilive_feeds_near_anchor");
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, String paramString2, String paramString3)
  {
    notifyUI(16, true, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), paramString1, paramString2, paramString3 });
  }
  
  public void a(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject2 = new cmd0xafc.ReqBody();
    Object localObject1;
    if (paramInt == 1)
    {
      cmd0xafc.Location localLocation = new cmd0xafc.Location();
      if (paramSosoLbsInfo == null) {
        localObject1 = null;
      } else {
        localObject1 = paramSosoLbsInfo.mLocation;
      }
      if ((paramSosoLbsInfo != null) && (localObject1 != null))
      {
        if ((((SosoLocation)localObject1).mLat02 != 0.0D) && (((SosoLocation)localObject1).mLon02 != 0.0D))
        {
          localLocation.int32_lat.set((int)(((SosoLocation)localObject1).mLat02 * 1000000.0D));
          localLocation.int32_lon.set((int)(((SosoLocation)localObject1).mLon02 * 1000000.0D));
          localLocation.int32_coo.set(1);
          if (QLog.isColorLevel()) {
            QLog.d("nearby.heart_beat", 2, "send_oidb_0xafc: gpsType=GPS_GCJ02");
          }
        }
        else if ((((SosoLocation)localObject1).mLat84 != 0.0D) && (((SosoLocation)localObject1).mLon84 != 0.0D))
        {
          localLocation.int32_lat.set((int)(((SosoLocation)localObject1).mLat84 * 1000000.0D));
          localLocation.int32_lon.set((int)(((SosoLocation)localObject1).mLon84 * 1000000.0D));
          localLocation.int32_coo.set(0);
          if (QLog.isColorLevel()) {
            QLog.d("nearby.heart_beat", 2, "send_oidb_0xafc: gpsType=GPS_WGS84");
          }
        }
        paramSosoLbsInfo = new cmd0xafc.NearbyEnter();
        paramSosoLbsInfo.msg_location.set(localLocation);
        ((cmd0xafc.ReqBody)localObject2).msg_nearby_enter.set(paramSosoLbsInfo);
        paramSosoLbsInfo = "OidbSvc.0xafc_1";
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("send_oidb_0xafc: lbsInfo=");
        ((StringBuilder)localObject2).append(paramSosoLbsInfo);
        ((StringBuilder)localObject2).append(", location=");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("nearby.heart_beat", 2, ((StringBuilder)localObject2).toString());
      }
    }
    else if (paramInt == 2)
    {
      paramSosoLbsInfo = new cmd0xafc.NearbyExit();
      ((cmd0xafc.ReqBody)localObject2).msg_nearby_exit.set(paramSosoLbsInfo);
      paramSosoLbsInfo = "OidbSvc.0xafc_2";
    }
    else
    {
      if (paramInt != 3) {
        return;
      }
      paramSosoLbsInfo = new cmd0xafc.HeartBeat();
      ((cmd0xafc.ReqBody)localObject2).msg_heart_beat.set(paramSosoLbsInfo);
      paramSosoLbsInfo = "OidbSvc.0xafc_3";
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send_oidb_0xafc: cmd=");
      ((StringBuilder)localObject1).append(paramSosoLbsInfo);
      QLog.d("nearby.heart_beat", 2, ((StringBuilder)localObject1).toString());
    }
    paramSosoLbsInfo = makeOIDBPkg(paramSosoLbsInfo, 2812, paramInt, ((cmd0xafc.ReqBody)localObject2).toByteArray());
    paramSosoLbsInfo.extraData.putBoolean("req_pb_protocol_flag", true);
    paramSosoLbsInfo.extraData.putLong("request_start_time", SystemClock.uptimeMillis());
    send(paramSosoLbsInfo);
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    NearbyReportSvr.CommonData localCommonData = new NearbyReportSvr.CommonData();
    localCommonData.platform.set("android");
    localCommonData.client_ip.set(DBNetworkUtil.a(false));
    localCommonData.version.set(DeviceInfoUtil.c());
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
    NearbyReportSvr.Location localLocation = new NearbyReportSvr.Location();
    localLocation.coordinate.set(1);
    if (localSosoLbsInfo != null)
    {
      localLocation.latitude.set(String.valueOf(localSosoLbsInfo.mLocation.mLat02));
      localLocation.longitude.set(String.valueOf(localSosoLbsInfo.mLocation.mLon02));
    }
    else
    {
      localLocation.latitude.set("0");
      localLocation.longitude.set("0");
    }
    NearbyReportSvr.TempChatReq localTempChatReq = new NearbyReportSvr.TempChatReq();
    try
    {
      localTempChatReq.sender.set(Long.parseLong(paramMessageRecord.senderuin));
      localTempChatReq.receiver.set(Long.parseLong(paramMessageRecord.frienduin));
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportNearbyAIOMsg ");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("NearbyHandler", 1, ((StringBuilder)localObject).toString());
      localTempChatReq.sender.set(0L);
      localTempChatReq.receiver.set(0L);
    }
    Object localObject = localTempChatReq.msg_content;
    String str;
    if (TextUtils.isEmpty(paramMessageRecord.msg)) {
      str = "";
    } else {
      str = paramMessageRecord.msg;
    }
    ((PBStringField)localObject).set(str);
    localTempChatReq.msg_type.set(NearbyAIODataReportUtil.a(paramMessageRecord.msgtype));
    localTempChatReq.send_time.set(paramMessageRecord.time);
    localTempChatReq.src.set(paramInt);
    localTempChatReq.common_data.set(localCommonData);
    localTempChatReq.location.set(localLocation);
    paramMessageRecord = createToServiceMsg("MQ_nearby_sso_proxy.0x3e8_1");
    paramMessageRecord.putWupBuffer(localTempChatReq.toByteArray());
    sendPbReq(paramMessageRecord);
  }
  
  public void a(NearbyMyTabCard paramNearbyMyTabCard)
  {
    notifyUI(4, true, new Object[] { paramNearbyMyTabCard });
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new cmd0xafc.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("handle_oidb_0xafc: cmd=");
      paramObject.append(paramFromServiceMsg);
      paramObject.append(", result=");
      paramObject.append(i);
      QLog.d("nearby.heart_beat", 2, paramObject.toString());
    }
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    int j = 60000;
    int k = j;
    if (bool)
    {
      i = j;
      if (paramToServiceMsg.uint32_heart_beat_interval.has())
      {
        i = paramToServiceMsg.uint32_heart_beat_interval.get() * 1000;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handle_oidb_0xafc: interval=");
          paramObject.append(i);
          QLog.d("nearby.heart_beat", 2, paramObject.toString());
        }
        if (i < 60000) {
          i = j;
        }
      }
      if (paramToServiceMsg.msg_self_info.has())
      {
        paramObject = (oidb_0x8dd.SelfInfo)paramToServiceMsg.msg_self_info.get();
        paramObject.str_third_line_info.set(paramObject.str_third_line_info.get().trim());
        j = paramObject.uint32_gender.get();
        k = a(j);
        paramObject.uint32_gender.set(k);
        this.a.saveSelfRespEncounterInfo(paramObject);
        ((NearbyDataManager)this.a.getManager(NearbyConstants.b)).a(this.a, paramObject);
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handle_oidb_0xafc: gender=");
          paramObject.append(j);
          paramObject.append(", newGender=");
          paramObject.append(k);
          QLog.d("nearby.heart_beat", 2, paramObject.toString());
        }
      }
      k = i;
      if (paramToServiceMsg.msg_config.has())
      {
        paramToServiceMsg = (oidb_0x8dd.NearbyConfig)paramToServiceMsg.msg_config.get();
        k = i;
        if (QLog.isColorLevel())
        {
          QLog.d("nearby.heart_beat", 2, "handle_oidb_0xafc: NearbyConfig has");
          k = i;
        }
      }
    }
    notifyUI(17, bool, new Object[] { paramFromServiceMsg, Integer.valueOf(k) });
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleClearRedTouch| isSuccess = ");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      QLog.i("NewNearbyMyTab", 2, paramToServiceMsg.toString());
    }
  }
  
  public void a(String paramString)
  {
    nearbyPeopleRecommend.QueryRecommendReq localQueryRecommendReq = new nearbyPeopleRecommend.QueryRecommendReq();
    localQueryRecommendReq.source.set(0);
    localQueryRecommendReq.uint32_client_type.set(406);
    localQueryRecommendReq.uint32_client_version.set(ApkUtils.a(BaseApplicationImpl.sApplication));
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("LBSService.Point");
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      localObject = new nearbyPeopleRecommend.Location();
      double d1 = Double.valueOf(localSosoLbsInfo.mLocation.mLat02 * 1000000.0D).intValue();
      double d2 = Double.valueOf(localSosoLbsInfo.mLocation.mLon02 * 1000000.0D).intValue();
      ((nearbyPeopleRecommend.Location)localObject).int32_latitude.set((int)d1);
      ((nearbyPeopleRecommend.Location)localObject).int32_longitude.set((int)d2);
      ((nearbyPeopleRecommend.Location)localObject).int32_coordinate.set(0);
      nearbyPeopleRecommend.LBSInfo localLBSInfo = new nearbyPeopleRecommend.LBSInfo();
      localLBSInfo.location.set((MessageMicro)localObject);
      localQueryRecommendReq.lbs_info.set(localLBSInfo);
    }
    Object localObject = new nearbyPeopleRecommend.QueryReqItem();
    ((nearbyPeopleRecommend.QueryReqItem)localObject).msg_id.set(paramString);
    localQueryRecommendReq.query_list.add((MessageMicro)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fetchNearbyRecommendUserInfo lbs = ");
      ((StringBuilder)localObject).append(localSosoLbsInfo);
      ((StringBuilder)localObject).append("msg_id = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("NearbyRecommend", 2, ((StringBuilder)localObject).toString());
    }
    paramString = createToServiceMsg("MQ_nearby_sso_proxy.0x667_1");
    paramString.putWupBuffer(localQueryRecommendReq.toByteArray());
    sendPbReq(paramString);
  }
  
  public void a(List<ReportRecord> paramList, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NearbyHandler.checkIn,  lat=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", lon=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("Q.hotChatDistance", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      localObject = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "EncounterSvc.ReqGetEncounter");
      ((ToServiceMsg)localObject).extraData.putInt("localLat", paramInt1);
      ((ToServiceMsg)localObject).extraData.putInt("localLon", paramInt2);
      ((ToServiceMsg)localObject).extraData.putBoolean("isCheckInReq", true);
      send((ToServiceMsg)localObject);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.check.auth", 2, "checkNearbyUserAuth");
    }
    Object localObject = new oidb_0xada.ReqBody();
    if (!a((oidb_0xada.ReqBody)localObject))
    {
      QLog.e("nearby.check.auth", 1, "oidb_0xada checkNearbyAuth config0xadaFileds failed");
      return;
    }
    long l = this.a.getLongAccountUin();
    ilive_nearby_user_control.EnterNearbyUserContrlReq localEnterNearbyUserContrlReq = new ilive_nearby_user_control.EnterNearbyUserContrlReq();
    localEnterNearbyUserContrlReq.user_id.set(l);
    localEnterNearbyUserContrlReq.user_type.set(0);
    localEnterNearbyUserContrlReq.source.set("qq_android_nearby");
    ((oidb_0xada.ReqBody)localObject).cmd.set(1008);
    ((oidb_0xada.ReqBody)localObject).subcmd.set(1);
    ((oidb_0xada.ReqBody)localObject).busi_buf.set(ByteStringMicro.copyFrom(localEnterNearbyUserContrlReq.toByteArray()));
    localObject = makeOIDBPkg("OidbSvc.0xada_0", 2778, 0, ((oidb_0xada.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("innerReq", "ilive_nearby_user_control");
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewNearbyMyTab", 2, "handleGetNearbyMyTab");
    }
    Oidb_0x66b.RspBody localRspBody = new Oidb_0x66b.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool = false;
    if (i == 0)
    {
      paramFromServiceMsg = new oidb_0x5eb.RspBody();
      paramObject = new NearbyMyTabCard();
      a(localRspBody, paramFromServiceMsg, paramObject);
      e(localRspBody, paramObject);
      d(localRspBody, paramObject);
      c(localRspBody, paramObject);
      b(localRspBody, paramObject);
      a(localRspBody, paramObject);
      b(paramObject);
    }
    else
    {
      notifyUI(3, false, null);
    }
    if (i == 0) {
      bool = true;
    }
    paramObject = new HashMap();
    if (bool) {
      paramFromServiceMsg = "0";
    } else {
      paramFromServiceMsg = "-1";
    }
    paramObject.put("param_FailCode", paramFromServiceMsg);
    paramObject.put("param_NetType", String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext())));
    paramObject.put("param_DeviceType", String.valueOf(DeviceInfoUtil.f()));
    long l = paramToServiceMsg.extraData.getLong("request_start_time");
    l = SystemClock.uptimeMillis() - l;
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "actGetNearbyMyTab", bool, l, 0L, paramObject, "");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetNearbyMyTab, isSuccess=");
      paramToServiceMsg.append(bool);
      paramToServiceMsg.append(",duration=");
      paramToServiceMsg.append(l);
      QLog.i("NearbyHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNearbyMyTabCard| uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("NewNearbyMyTab", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Oidb_0x66b.ReqBody();
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
    localReqBody.rpt_uint64_uins.set(localArrayList);
    localReqBody.uint32_req_nick.set(1);
    localReqBody.uint32_req_stranger_nick.set(1);
    localReqBody.uint32_req_gender.set(1);
    localReqBody.uint32_req_god_flag.set(1);
    localReqBody.uint32_req_age.set(1);
    ((Oidb_0x66b.ReqBody)localObject).bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    ((Oidb_0x66b.ReqBody)localObject).uint32_req_likeinfo.set(1);
    ((Oidb_0x66b.ReqBody)localObject).uint32_req_pansocialinfo.set(1);
    ((Oidb_0x66b.ReqBody)localObject).uint32_req_giftinfo.set(1);
    ((Oidb_0x66b.ReqBody)localObject).uint32_req_configinfo.set(1);
    ((Oidb_0x66b.ReqBody)localObject).uint32_req_visitor.set(3);
    paramString = makeOIDBPkg("OidbSvc.0x66b", 1643, 0, ((Oidb_0x66b.ReqBody)localObject).toByteArray());
    paramString.extraData.putBoolean("req_pb_protocol_flag", true);
    paramString.extraData.putLong("request_start_time", SystemClock.uptimeMillis());
    send(paramString);
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      paramToServiceMsg = new oidb_0xada.RspBody();
      parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (!paramToServiceMsg.busi_buf.has())
      {
        QLog.i("NearbyHandler", 1, "handleLiveFeedNearbyAnchor rspBody.busi_buf is null");
        notifyUI(19, false, new Object[] { null });
        return;
      }
      paramFromServiceMsg = new ilive_feeds_near_anchor.GetNearAnchorRsp();
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.busi_buf.get().toByteArray());
        if ((paramFromServiceMsg.ret.get() == 0) && (paramFromServiceMsg.anchor_infos.size() > 0))
        {
          notifyUI(19, true, new Object[] { paramFromServiceMsg.anchor_infos.get() });
          return;
        }
        notifyUI(19, false, new Object[] { null });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e("NearbyHandler", 1, "handleLiveFeedNearbyAnchor InvalidProtocolBufferMicroException", paramToServiceMsg);
        notifyUI(19, false, new Object[] { null });
        return;
      }
    }
    notifyUI(19, false, new Object[] { null });
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby.now", 2, "handleLiveFeedNearbyAnchor req == null || res == null");
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      paramToServiceMsg = new oidb_0xada.RspBody();
      try
      {
        int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handlNearbyUserCheckAuth oidbRet=");
        paramFromServiceMsg.append(i);
        QLog.d("nearby.check.auth", 1, paramFromServiceMsg.toString());
        if (i != 0)
        {
          notifyUI(21, false, new Object[] { Integer.valueOf(-2), "" });
          return;
        }
        if (!paramToServiceMsg.busi_buf.has())
        {
          QLog.w("nearby.check.auth", 1, "handlNearbyUserCheckAuth rspBody.busi_buf is null");
          notifyUI(21, false, new Object[] { Integer.valueOf(-3), "" });
          return;
        }
        paramFromServiceMsg = new ilive_nearby_user_control.EnterNearbyUserContrlRsp();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.busi_buf.get().toByteArray());
        i = paramFromServiceMsg.check_ret.get();
        paramToServiceMsg = paramFromServiceMsg.check_msg.get();
        notifyUI(21, true, new Object[] { Integer.valueOf(i), paramToServiceMsg });
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handlNearbyUserCheckAuth checkRet=");
        paramFromServiceMsg.append(i);
        paramFromServiceMsg.append(", checkMsg=");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.d("nearby.check.auth", 1, paramFromServiceMsg.toString());
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handlNearbyUserCheckAuth exp=");
        paramFromServiceMsg.append(paramToServiceMsg.toString());
        QLog.e("nearby.check.auth", 1, paramFromServiceMsg.toString());
        notifyUI(21, false, new Object[] { Integer.valueOf(-4), "" });
        return;
      }
    }
    notifyUI(21, false, new Object[] { Integer.valueOf(-1), "" });
    if (QLog.isColorLevel()) {
      QLog.w("nearby.check.auth", 2, "handlNearbyUserCheckAuth req == null || res == null");
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x8dd");
      this.allowCmdSet.add("EncounterSvc.ReqGetEncounter");
      this.allowCmdSet.add("RoamClientSvr.GetQualify");
      this.allowCmdSet.add("OidbSvc.0x66b");
      this.allowCmdSet.add("NeighborSvc.ReqGetPoint");
      this.allowCmdSet.add("OidbSvc.0x9c7_0");
      this.allowCmdSet.add("OidbSvc.0x686");
      this.allowCmdSet.add("OidbSvc.0x4f0_0");
      this.allowCmdSet.add("OidbSvc.0x6be");
      this.allowCmdSet.add("OidbSvc.0xafc_1");
      this.allowCmdSet.add("OidbSvc.0xafc_2");
      this.allowCmdSet.add("OidbSvc.0xafc_3");
      this.allowCmdSet.add("OidbSvc.0xada_0");
      this.allowCmdSet.add("MQ_nearby_sso_proxy.0x667_1");
      this.allowCmdSet.add("MQ_nearby_sso_proxy.0x3e8_1");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return NearbyObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(str);
        QLog.d("msgCmdFilter", 2, paramToServiceMsg.toString());
      }
      return;
    }
    BusinessHandlerUtil.checkReportErrorToMM(paramFromServiceMsg, getCurrentAccountUin());
    if ("EncounterSvc.ReqGetEncounter".equals(str)) {
      return;
    }
    if ("OidbSvc.0x66b".equals(str))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("NeighborSvc.ReqGetPoint".equals(str))
    {
      int i;
      if (paramToServiceMsg.extraData.getBoolean("req_street_view")) {
        i = 5;
      } else {
        i = 6;
      }
      NearbyCmdHelper.a(this, i, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x9c7_0".equals(str))
    {
      NearbyCmdHelper.c(this, 10, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x686".equals(str))
    {
      NearbyCmdHelper.b(this, 8, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x4f0_0".equals(str))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x6be".equals(str))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ((!"OidbSvc.0xafc_1".equals(str)) && (!"OidbSvc.0xafc_2".equals(str)) && (!"OidbSvc.0xafc_3".equals(str)))
    {
      if ("OidbSvc.0xada_0".equals(str))
      {
        str = (String)paramToServiceMsg.getAttribute("innerReq", "");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("NearbyHandler onReceive oxada, innerReq=");
          localStringBuilder.append(str);
          QLog.d("NearbyHandler", 2, localStringBuilder.toString());
        }
        if ("ilive_feeds_near_anchor".equals(str))
        {
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("ilive_nearby_user_control".equals(str)) {
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      else
      {
        if ("MQ_nearby_sso_proxy.0x667_1".equals(str))
        {
          f(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("MQ_nearby_sso_proxy.0x3e8_1".equals(str)) {
          g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
    }
    else {
      a(paramFromServiceMsg, paramToServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyHandler
 * JD-Core Version:    0.7.0.1
 */