import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import appoint.define.appoint_define.PublisherInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
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
import com.tencent.mobileqq.statistics.StatisticCollector;
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
import tencent.im.oidb.cmd0x77f.cmd0x77f.ReqBody;
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

public class amxd
  extends BusinessHandler
{
  NearbyAppInterface a;
  
  public amxd(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    if ((paramAppInterface instanceof NearbyAppInterface)) {
      this.a = ((NearbyAppInterface)paramAppInterface);
    }
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2;
    case 1: 
      return 0;
    }
    return 1;
  }
  
  @Nullable
  private ArrayList<StrangerInfo> a(cmd0x4f0.RspBody paramRspBody)
  {
    StrangerInfo localStrangerInfo = null;
    if (paramRspBody.rpt_msg_vistor_info.has()) {}
    Object localObject;
    for (paramRspBody = paramRspBody.rpt_msg_vistor_info.get();; paramRspBody = null)
    {
      localObject = localStrangerInfo;
      if (paramRspBody == null) {
        break;
      }
      localObject = localStrangerInfo;
      if (paramRspBody.isEmpty()) {
        break;
      }
      localObject = new ArrayList();
      paramRspBody = paramRspBody.iterator();
      while (paramRspBody.hasNext())
      {
        localStrangerInfo = StrangerInfo.convertFrom((appoint_define.PublisherInfo)paramRspBody.next());
        if (localStrangerInfo != null) {
          ((ArrayList)localObject).add(localStrangerInfo);
        }
      }
    }
    return localObject;
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt)
  {
    paramAppInterface.reportClickEvent("CliOper", "", "", "Neiggbor", "ReqGetEncounter", 0, paramInt, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, mqq.observer.BusinessObserver paramBusinessObserver)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("client_ver", "8.4.8");
      localJSONObject.put("from", paramString2);
      if ("1".equals(paramString2))
      {
        byte[] arrayOfByte = paramQQAppInterface.getMsgCache().k(paramString1);
        if (arrayOfByte != null) {
          localJSONObject.put("chat_sig", new String(bfuc.encode(arrayOfByte, 0)));
        }
      }
      localJSONObject.put("targetuin", paramString1);
      localJSONObject.put("operation", paramString3);
      int i;
      if ("1".equals(paramString2)) {
        i = 3077;
      }
      for (;;)
      {
        localJSONObject.put("sourceid", i);
        localJSONObject.put("sub_sourceid", paramInt);
        paramString1 = new NewIntent(paramQQAppInterface.getApplication().getApplicationContext(), nma.class);
        paramString1.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.follow_user");
        paramString2 = new WebSsoBody.WebSsoRequestBody();
        paramString2.type.set(0);
        paramString2.data.set(localJSONObject.toString());
        paramString1.putExtra("data", paramString2.toByteArray());
        paramString1.setObserver(paramBusinessObserver);
        paramQQAppInterface.startServlet(paramString1);
        return;
        boolean bool = "6".equals(paramString2);
        if (bool) {
          i = 3089;
        } else {
          i = 3076;
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public static void a(NearbyAppInterface paramNearbyAppInterface, long[] paramArrayOfLong, mqq.observer.BusinessObserver paramBusinessObserver)
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
      paramArrayOfLong = new NewIntent(paramNearbyAppInterface.getApplication().getApplicationContext(), nma.class);
      paramArrayOfLong.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.encrypt_uins");
      localObject = new WebSsoBody.WebSsoRequestBody();
      ((WebSsoBody.WebSsoRequestBody)localObject).type.set(0);
      ((WebSsoBody.WebSsoRequestBody)localObject).data.set(localJSONObject.toString());
      paramArrayOfLong.putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject).toByteArray());
      paramArrayOfLong.setObserver(paramBusinessObserver);
      paramNearbyAppInterface.startServlet(paramArrayOfLong);
      return;
    }
    catch (Exception paramNearbyAppInterface) {}
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
      if (QLog.isColorLevel()) {
        QLog.i("NearbyHandler", 2, "handleGetNearbyMyTab visitor info is: " + paramNearbyMyTabCard.visitors.toString());
      }
    }
    for (;;)
    {
      axhw.a(this.a, paramNearbyMyTabCard);
      this.a.a(paramNearbyMyTabCard);
      notifyUI(3, true, new Object[] { paramNearbyMyTabCard });
      return;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyHandler", 2, "handleGetNearbyMyTay has no visitor info.");
      }
    }
  }
  
  private void a(Oidb_0x66b.RspBody paramRspBody, oidb_0x5eb.RspBody paramRspBody1, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (paramRspBody.bytes_rspbody_5eb.has()) {
      paramRspBody = paramRspBody.bytes_rspbody_5eb.get().toByteArray();
    }
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
        if ((paramNearbyMyTabCard.gender == 1) || (paramNearbyMyTabCard.gender == 2)) {
          awka.a(paramNearbyMyTabCard.uin + "", "self_gender", Integer.valueOf(paramNearbyMyTabCard.gender));
        }
        paramNearbyMyTabCard.age = paramRspBody.uint32_age.get();
        paramNearbyMyTabCard.godFlag = paramRspBody.uint32_god_flag.get();
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramRspBody)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NewNearbyMyTab", 2, "fail to decode 5eb_rspBody", paramRspBody);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt, long paramLong1, long paramLong2, long paramLong3, ArrayList<StrangerInfo> paramArrayList)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby.visitor", 2, "handleGetRecentVisitors|c");
    }
    StringBuilder localStringBuilder;
    int i;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleGetRecentVisitors|cookie lenght: ");
      if (paramArrayOfByte != null) {
        break label148;
      }
      i = 0;
      paramArrayOfByte = localStringBuilder.append(i).append(",compleFlag: ").append(paramInt).append(",totalVisitor: ").append(paramLong1).append(",newVisitor:").append(paramLong2).append(",hisVisitor:").append(paramLong3).append(",visitorCount: ");
      if (paramArrayList != null) {
        break label155;
      }
      paramInt = j;
      label111:
      localStringBuilder = paramArrayOfByte.append(paramInt).append(",visitor info is: ");
      if (paramArrayList != null) {
        break label164;
      }
    }
    label148:
    label155:
    label164:
    for (paramArrayOfByte = null;; paramArrayOfByte = paramArrayList.toString())
    {
      QLog.i("Q.nearby.visitor", 2, paramArrayOfByte);
      return;
      i = paramArrayOfByte.length;
      break;
      paramInt = paramArrayList.size();
      break label111;
    }
  }
  
  private boolean a(oidb_0xada.ReqBody paramReqBody)
  {
    paramReqBody.uid.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
    paramReqBody.tinyid.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
    Object localObject = (TicketManager)this.mApp.getManager(2);
    String str = ((TicketManager)localObject).getA2(this.mApp.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(this.mApp.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramReqBody.a2.set(str);
      paramReqBody.platform.set(1);
      paramReqBody.version.set("8.4.8");
      paramReqBody.version_code.set(aqmy.a(BaseApplicationImpl.sApplication));
      paramReqBody.original_id.set(this.mApp.getCurrentAccountUin());
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
      String str = "";
      int i = 0;
      while (i < paramNearbyMyTabCard.configList.size())
      {
        str = str + ((NearbyMyTabCard.NearbyMyTabConfig)paramNearbyMyTabCard.configList.get(i)).configId + ((NearbyMyTabCard.NearbyMyTabConfig)paramNearbyMyTabCard.configList.get(i)).strName + ((NearbyMyTabCard.NearbyMyTabConfig)paramNearbyMyTabCard.configList.get(i)).strUrl + "\n";
        i += 1;
      }
      QLog.d("NewNearbyMyTab", 2, "handleGetNearbyMyTab---->uin =" + paramNearbyMyTabCard.uin + "nickName = " + paramNearbyMyTabCard.nickName + " profression = " + paramNearbyMyTabCard.carrier + " gender = " + paramNearbyMyTabCard.gender + "age =" + paramNearbyMyTabCard.age + " likeTotalNum = " + paramNearbyMyTabCard.likeTotalNum + "likeNewNum = " + paramNearbyMyTabCard.newLikeNum + "charmVale =" + paramNearbyMyTabCard.charmValue + "charmLevel =" + paramNearbyMyTabCard.charmLevel + "charmCurrent =" + paramNearbyMyTabCard.currentCharm + "charmNext" + paramNearbyMyTabCard.nextCharm + " giftNum = " + paramNearbyMyTabCard.giftNum + "config = " + str);
    }
  }
  
  private void b(Oidb_0x66b.RspBody paramRspBody, NearbyMyTabCard paramNearbyMyTabCard)
  {
    boolean bool = false;
    if (paramRspBody.stConfigList.has())
    {
      Object localObject = paramRspBody.stConfigList.get();
      paramRspBody = new boolean[2];
      Oidb_0x66b.RspBody tmp27_26 = paramRspBody;
      tmp27_26[0] = 0;
      Oidb_0x66b.RspBody tmp33_27 = tmp27_26;
      tmp33_27[1] = 0;
      tmp33_27;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
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
          localNearbyMyTabConfig.extraVal = ((NearbyMyTabCard.NearbyMyTabConfigExtraVal)axhw.a.get(Integer.valueOf(localNearbyMyTabConfig.configId)));
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
      int i = 0;
      while (i < paramRspBody.length)
      {
        bool |= this.a.a().a(i, paramRspBody[i]);
        i += 1;
      }
      if (bool) {
        notifyUI(12, true, null);
      }
    }
  }
  
  private void c(Oidb_0x66b.RspBody paramRspBody, NearbyMyTabCard paramNearbyMyTabCard)
  {
    byte[] arrayOfByte;
    if (paramRspBody.bytes_rspbody_gift.has())
    {
      arrayOfByte = paramRspBody.bytes_rspbody_gift.get().toByteArray();
      paramRspBody = new flower_info.SFlowerInfoRsp();
    }
    try
    {
      paramRspBody.mergeFrom(arrayOfByte);
      paramNearbyMyTabCard.giftNum = paramRspBody.num.get();
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        paramNearbyMyTabCard.giftNum = 0;
        if (QLog.isColorLevel()) {
          QLog.e("NewNearbyMyTab", 2, "fail to decode SFlowerInfoRsp", localInvalidProtocolBufferMicroException);
        }
      }
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
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    Object localObject = new cmd0x4f0.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    boolean bool = paramToServiceMsg.extraData.getBoolean("is_first_page");
    if (i == 0)
    {
      label88:
      long l1;
      if (((cmd0x4f0.RspBody)localObject).bytes_cookie.has())
      {
        paramToServiceMsg = ((cmd0x4f0.RspBody)localObject).bytes_cookie.get().toByteArray();
        if (!((cmd0x4f0.RspBody)localObject).uint32_completed.has()) {
          break label273;
        }
        i = ((cmd0x4f0.RspBody)localObject).uint32_completed.get();
        if (!((cmd0x4f0.RspBody)localObject).uint32_total_visitor.has()) {
          break label279;
        }
        l1 = ((cmd0x4f0.RspBody)localObject).uint32_total_visitor.get();
        label110:
        if (!((cmd0x4f0.RspBody)localObject).uint32_unread_visitor.has()) {
          break label285;
        }
      }
      long l3;
      label273:
      label279:
      label285:
      for (long l2 = ((cmd0x4f0.RspBody)localObject).uint32_unread_visitor.get();; l2 = 0L)
      {
        l3 = l1 - l2;
        paramFromServiceMsg = a((cmd0x4f0.RspBody)localObject);
        a(paramToServiceMsg, i, l1, l2, l3, paramFromServiceMsg);
        if ((!bool) || (paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
          break label375;
        }
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
        paramToServiceMsg = null;
        break;
        i = 0;
        break label88;
        l1 = 0L;
        break label110;
      }
      paramObject = awka.a("nearby_visitor_file", this.a.getAccount(), 0).edit();
      if (l1 > 0L)
      {
        paramObject.putLong("sp_nearby_total_visitor", l1);
        if (l2 > 0L) {
          paramObject.putLong("sp_nearby_new_visitor", l2);
        }
        if (l3 > 0L) {
          paramObject.putLong("sp_nearby_his_visitor", l3);
        }
        paramObject.commit();
      }
      label375:
      notifyUI(11, true, new Object[] { paramFromServiceMsg, paramToServiceMsg, Integer.valueOf(i), Long.valueOf(l1), "", Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(l3) });
      return;
    }
    if (((cmd0x4f0.RspBody)localObject).str_error_tips.has()) {}
    for (paramToServiceMsg = ((cmd0x4f0.RspBody)localObject).str_error_tips.get();; paramToServiceMsg = "")
    {
      notifyUI(11, false, new Object[] { null, null, Integer.valueOf(-1), Long.valueOf(-1L), paramToServiceMsg, Boolean.valueOf(bool), Long.valueOf(-1L), Long.valueOf(-1L) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("NearbyHandler", 2, "handleGetRecentVisitors: result is: " + i + " errorTips: " + paramToServiceMsg);
      return;
    }
  }
  
  private void e(Oidb_0x66b.RspBody paramRspBody, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (paramRspBody.stLikeInfo.has())
    {
      paramRspBody = (Oidb_0x66b.RspLikeInfo)paramRspBody.stLikeInfo.get();
      int i = paramRspBody.uint32_total.get();
      int j = paramRspBody.uint32_new.get();
      paramRspBody = this.a.b();
      if ((paramRspBody == null) || (i > paramRspBody.likeTotalNum))
      {
        paramNearbyMyTabCard.likeTotalNum = i;
        paramNearbyMyTabCard.newLikeNum = j;
        this.a.a(0);
      }
    }
    else
    {
      return;
    }
    paramNearbyMyTabCard.likeTotalNum = paramRspBody.likeTotalNum;
    paramNearbyMyTabCard.newLikeNum = paramRspBody.newLikeNum;
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      if (QLog.isColorLevel()) {
        QLog.w("NearbyRecommend", 2, "handleNearbyRecommendUser req == null || res == null");
      }
    }
    for (;;)
    {
      return;
      paramToServiceMsg = new nearbyPeopleRecommend.QueryRecommendRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.ret_code.get() != 0) && (QLog.isColorLevel())) {
          QLog.e("NearbyRecommend", 2, "get failed,code =  " + paramToServiceMsg.ret_code.get());
        }
        if (!paramToServiceMsg.query_list.has())
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("NearbyRecommend", 2, "handleNearbyRecommendUser,not has query_list");
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyRecommend", 2, "InvalidProtocolBufferMicroException e = " + paramFromServiceMsg.getMessage());
          }
        }
        paramToServiceMsg = paramToServiceMsg.query_list.get();
        if (paramToServiceMsg.size() <= 0)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyRecommend", 2, "handleNearbyRecommendUser,rpt_recomm_people size == 0 ");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("NearbyRecommend", 2, "get success size= " + paramToServiceMsg.size());
          }
          notifyUI(22, true, new Object[] { paramToServiceMsg });
        }
      }
    }
  }
  
  cmd0x77f.VisitProfRec a(awjz paramawjz)
  {
    cmd0x77f.VisitProfRec localVisitProfRec = new cmd0x77f.VisitProfRec();
    localVisitProfRec.uint64_tinyid.set(paramawjz.jdField_a_of_type_Long);
    localVisitProfRec.uint32_seq.set(paramawjz.jdField_a_of_type_Int);
    if (paramawjz.c > 0) {
      localVisitProfRec.uint32_enter_count.set(paramawjz.c);
    }
    if (paramawjz.d > 0) {
      localVisitProfRec.uint32_visit_duration.set(paramawjz.d);
    }
    if (paramawjz.e > 0) {
      localVisitProfRec.uint32_visit_pic_count.set(paramawjz.e);
    }
    if (paramawjz.f > 0) {
      localVisitProfRec.uint32_opflag.set(paramawjz.f);
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyHandler", 2, "convert2VisitRec ,record =" + paramawjz);
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
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    cmd0xafc.ReqBody localReqBody = new cmd0xafc.ReqBody();
    cmd0xafc.Location localLocation;
    Object localObject;
    if (paramInt == 1)
    {
      String str = "OidbSvc.0xafc_1";
      localLocation = new cmd0xafc.Location();
      if (paramSosoLbsInfo == null)
      {
        localObject = null;
        if ((paramSosoLbsInfo == null) || (localObject == null)) {
          break label314;
        }
        if ((((SosoInterface.SosoLocation)localObject).mLat02 == 0.0D) || (((SosoInterface.SosoLocation)localObject).mLon02 == 0.0D)) {
          break label234;
        }
        localLocation.int32_lat.set((int)(((SosoInterface.SosoLocation)localObject).mLat02 * 1000000.0D));
        localLocation.int32_lon.set((int)(((SosoInterface.SosoLocation)localObject).mLon02 * 1000000.0D));
        localLocation.int32_coo.set(1);
        if (QLog.isColorLevel()) {
          QLog.d("nearby.heart_beat", 2, "send_oidb_0xafc: gpsType=GPS_GCJ02");
        }
        label119:
        paramSosoLbsInfo = new cmd0xafc.NearbyEnter();
        paramSosoLbsInfo.msg_location.set(localLocation);
        localReqBody.msg_nearby_enter.set(paramSosoLbsInfo);
        paramSosoLbsInfo = str;
      }
    }
    for (;;)
    {
      label148:
      if (QLog.isColorLevel()) {
        QLog.d("nearby.heart_beat", 2, "send_oidb_0xafc: cmd=" + paramSosoLbsInfo);
      }
      paramSosoLbsInfo = makeOIDBPkg(paramSosoLbsInfo, 2812, paramInt, localReqBody.toByteArray());
      paramSosoLbsInfo.extraData.putBoolean("req_pb_protocol_flag", true);
      paramSosoLbsInfo.extraData.putLong("request_start_time", SystemClock.uptimeMillis());
      send(paramSosoLbsInfo);
      label234:
      do
      {
        do
        {
          return;
          localObject = paramSosoLbsInfo.mLocation;
          break;
          if ((((SosoInterface.SosoLocation)localObject).mLat84 == 0.0D) || (((SosoInterface.SosoLocation)localObject).mLon84 == 0.0D)) {
            break label119;
          }
          localLocation.int32_lat.set((int)(((SosoInterface.SosoLocation)localObject).mLat84 * 1000000.0D));
          localLocation.int32_lon.set((int)(((SosoInterface.SosoLocation)localObject).mLon84 * 1000000.0D));
          localLocation.int32_coo.set(0);
          if (!QLog.isColorLevel()) {
            break label119;
          }
          QLog.d("nearby.heart_beat", 2, "send_oidb_0xafc: gpsType=GPS_WGS84");
          break label119;
        } while (!QLog.isColorLevel());
        QLog.d("nearby.heart_beat", 2, "send_oidb_0xafc: lbsInfo=" + paramSosoLbsInfo + ", location=" + localObject);
        return;
        if (paramInt == 2)
        {
          paramSosoLbsInfo = "OidbSvc.0xafc_2";
          localObject = new cmd0xafc.NearbyExit();
          localReqBody.msg_nearby_exit.set((MessageMicro)localObject);
          break label148;
        }
      } while (paramInt != 3);
      label314:
      paramSosoLbsInfo = "OidbSvc.0xafc_3";
      localObject = new cmd0xafc.HeartBeat();
      localReqBody.msg_heart_beat.set((MessageMicro)localObject);
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("nearby.heart_beat", 2, "handle_oidb_0xafc: cmd=" + paramFromServiceMsg + ", result=" + i);
    }
    boolean bool;
    if (i == 0)
    {
      bool = true;
      if (!bool) {
        break label376;
      }
      if (!paramToServiceMsg.uint32_heart_beat_interval.has()) {
        break label368;
      }
      i = paramToServiceMsg.uint32_heart_beat_interval.get() * 1000;
      if (QLog.isColorLevel()) {
        QLog.d("nearby.heart_beat", 2, "handle_oidb_0xafc: interval=" + i);
      }
      if (i >= 60000) {
        break label365;
      }
      i = 60000;
      label148:
      if (paramToServiceMsg.msg_self_info.has())
      {
        paramObject = (oidb_0x8dd.SelfInfo)paramToServiceMsg.msg_self_info.get();
        paramObject.str_third_line_info.set(paramObject.str_third_line_info.get().trim());
        j = paramObject.uint32_gender.get();
        int k = a(j);
        paramObject.uint32_gender.set(k);
        this.a.a(paramObject);
        ((aptt)this.a.getManager(210)).a(this.a, paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("nearby.heart_beat", 2, "handle_oidb_0xafc: gender=" + j + ", newGender=" + k);
        }
      }
      j = i;
      if (paramToServiceMsg.msg_config.has())
      {
        paramToServiceMsg = (oidb_0x8dd.NearbyConfig)paramToServiceMsg.msg_config.get();
        j = i;
        if (QLog.isColorLevel()) {
          QLog.d("nearby.heart_beat", 2, "handle_oidb_0xafc: NearbyConfig has");
        }
      }
    }
    label365:
    label368:
    label376:
    for (int j = i;; j = 60000)
    {
      notifyUI(17, bool, new Object[] { paramFromServiceMsg, Integer.valueOf(j) });
      return;
      bool = false;
      break;
      break label148;
      i = 60000;
      break label148;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "handleClearRedTouch| isSuccess = " + paramFromServiceMsg.isSuccess());
    }
  }
  
  public void a(String paramString)
  {
    nearbyPeopleRecommend.QueryRecommendReq localQueryRecommendReq = new nearbyPeopleRecommend.QueryRecommendReq();
    localQueryRecommendReq.source.set(0);
    localQueryRecommendReq.uint32_client_type.set(406);
    localQueryRecommendReq.uint32_client_version.set(aqmy.a(BaseApplicationImpl.sApplication));
    SosoInterface.SosoLbsInfo localSosoLbsInfo = LbsManagerService.getCachedLbsInfo("LBSService.Point");
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
    if (QLog.isColorLevel()) {
      QLog.i("NearbyRecommend", 2, "fetchNearbyRecommendUserInfo lbs = " + localSosoLbsInfo + "msg_id = " + paramString);
    }
    paramString = createToServiceMsg("MQ_nearby_sso_proxy.0x667_1");
    paramString.putWupBuffer(localQueryRecommendReq.toByteArray());
    sendPbReq(paramString);
  }
  
  public void a(List<awjz> paramList, boolean paramBoolean)
  {
    int j = 0;
    int k = paramList.size();
    if (QLog.isColorLevel()) {
      QLog.d("NearbyHandler", 2, "reportNearbyListBehavior,dataSize = " + k + ",isCache = " + paramBoolean);
    }
    if (k < 1) {
      return;
    }
    if (k <= 200)
    {
      localObject1 = new cmd0x77f.ReqBody();
      Object localObject2 = ((cmd0x77f.ReqBody)localObject1).uint32_listtype;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((PBUInt32Field)localObject2).set(i);
        ((cmd0x77f.ReqBody)localObject1).uint32_list_ruleid.set(((awjz)paramList.get(0)).b);
        i = j;
        while (i < k)
        {
          localObject2 = a((awjz)paramList.get(i));
          ((cmd0x77f.ReqBody)localObject1).rpt_msg_visit_prof_rec.add((MessageMicro)localObject2);
          i += 1;
        }
      }
      paramList = makeOIDBPkg("OidbSvc.0x77f_1", 1919, 1, ((cmd0x77f.ReqBody)localObject1).toByteArray());
      paramList.extraData.putBoolean("req_pb_protocol_flag", true);
      send(paramList);
      return;
    }
    Object localObject1 = paramList.subList(0, 200);
    paramList = paramList.subList(200, k);
    a((List)localObject1, paramBoolean);
    a(paramList, paramBoolean);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotChatDistance", 2, "NearbyHandler.checkIn,  lat=" + paramInt1 + ", lon=" + paramInt2);
    }
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "EncounterSvc.ReqGetEncounter");
      localToServiceMsg.extraData.putInt("localLat", paramInt1);
      localToServiceMsg.extraData.putInt("localLon", paramInt2);
      localToServiceMsg.extraData.putBoolean("isCheckInReq", true);
      send(localToServiceMsg);
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
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("NewNearbyMyTab", 2, "handleGetNearbyMyTab");
    }
    Oidb_0x66b.RspBody localRspBody = new Oidb_0x66b.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
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
      if (i == 0) {
        bool = true;
      }
      paramObject = new HashMap();
      if (!bool) {
        break label270;
      }
    }
    label270:
    for (paramFromServiceMsg = "0";; paramFromServiceMsg = "-1")
    {
      paramObject.put("param_FailCode", paramFromServiceMsg);
      paramObject.put("param_NetType", String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext())));
      paramObject.put("param_DeviceType", String.valueOf(ajpv.a()));
      long l = paramToServiceMsg.extraData.getLong("request_start_time");
      l = SystemClock.uptimeMillis() - l;
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "actGetNearbyMyTab", bool, l, 0L, paramObject, "");
      if (QLog.isColorLevel()) {
        QLog.i("NearbyHandler", 2, "handleGetNearbyMyTab, isSuccess=" + bool + ",duration=" + l);
      }
      return;
      notifyUI(3, false, null);
      break;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "getNearbyMyTabCard| uin = " + paramString);
    }
    Oidb_0x66b.ReqBody localReqBody = new Oidb_0x66b.ReqBody();
    oidb_0x5eb.ReqBody localReqBody1 = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
    localReqBody1.rpt_uint64_uins.set(localArrayList);
    localReqBody1.uint32_req_nick.set(1);
    localReqBody1.uint32_req_stranger_nick.set(1);
    localReqBody1.uint32_req_gender.set(1);
    localReqBody1.uint32_req_god_flag.set(1);
    localReqBody1.uint32_req_age.set(1);
    localReqBody.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(localReqBody1.toByteArray()));
    localReqBody.uint32_req_likeinfo.set(1);
    localReqBody.uint32_req_pansocialinfo.set(1);
    localReqBody.uint32_req_giftinfo.set(1);
    localReqBody.uint32_req_configinfo.set(1);
    localReqBody.uint32_req_visitor.set(3);
    paramString = makeOIDBPkg("OidbSvc.0x66b", 1643, 0, localReqBody.toByteArray());
    paramString.extraData.putBoolean("req_pb_protocol_flag", true);
    paramString.extraData.putLong("request_start_time", SystemClock.uptimeMillis());
    send(paramString);
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(19, false, new Object[] { null });
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby.now", 2, "handleLiveFeedNearbyAnchor req == null || res == null");
      }
      return;
    }
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
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      QLog.e("NearbyHandler", 1, "handleLiveFeedNearbyAnchor InvalidProtocolBufferMicroException", paramToServiceMsg);
      notifyUI(19, false, new Object[] { null });
      return;
    }
    notifyUI(19, false, new Object[] { null });
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(21, false, new Object[] { Integer.valueOf(-1), "" });
      if (QLog.isColorLevel()) {
        QLog.w("nearby.check.auth", 2, "handlNearbyUserCheckAuth req == null || res == null");
      }
      return;
    }
    paramToServiceMsg = new oidb_0xada.RspBody();
    try
    {
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      QLog.d("nearby.check.auth", 1, "handlNearbyUserCheckAuth oidbRet=" + i);
      if (i != 0)
      {
        notifyUI(21, false, new Object[] { Integer.valueOf(-2), "" });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("nearby.check.auth", 1, "handlNearbyUserCheckAuth exp=" + paramToServiceMsg.toString());
      notifyUI(21, false, new Object[] { Integer.valueOf(-4), "" });
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
    int i = paramFromServiceMsg.check_ret.get();
    paramToServiceMsg = paramFromServiceMsg.check_msg.get();
    notifyUI(21, true, new Object[] { Integer.valueOf(i), paramToServiceMsg });
    QLog.d("nearby.check.auth", 1, "handlNearbyUserCheckAuth checkRet=" + i + ", checkMsg=" + paramToServiceMsg);
  }
  
  public boolean msgCmdFilter(String paramString)
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
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public Class<? extends com.tencent.mobileqq.app.BusinessObserver> observerClass()
  {
    return amxe.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("msgCmdFilter", 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          checkReportErrorToMM(paramFromServiceMsg);
        } while ("EncounterSvc.ReqGetEncounter".equals(str));
        if ("OidbSvc.0x66b".equals(str))
        {
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("NeighborSvc.ReqGetPoint".equals(str))
        {
          if (paramToServiceMsg.extraData.getBoolean("req_street_view")) {}
          for (int i = 5;; i = 6)
          {
            amwz.a(this, i, paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
        }
        if ("OidbSvc.0x9c7_0".equals(str))
        {
          amwz.c(this, 10, paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x686".equals(str))
        {
          amwz.b(this, 8, paramToServiceMsg, paramFromServiceMsg, paramObject);
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
        if (("OidbSvc.0xafc_1".equals(str)) || ("OidbSvc.0xafc_2".equals(str)) || ("OidbSvc.0xafc_3".equals(str)))
        {
          a(paramFromServiceMsg, paramToServiceMsg, paramObject);
          return;
        }
        if (!"OidbSvc.0xada_0".equals(str)) {
          break;
        }
        str = (String)paramToServiceMsg.getAttribute("innerReq", "");
        if (QLog.isColorLevel()) {
          QLog.d("NearbyHandler", 2, "NearbyHandler onReceive oxada, innerReq=" + str);
        }
        if ("ilive_feeds_near_anchor".equals(str))
        {
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while (!"ilive_nearby_user_control".equals(str));
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    } while (!"MQ_nearby_sso_proxy.0x667_1".equals(str));
    f(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxd
 * JD-Core Version:    0.7.0.1
 */