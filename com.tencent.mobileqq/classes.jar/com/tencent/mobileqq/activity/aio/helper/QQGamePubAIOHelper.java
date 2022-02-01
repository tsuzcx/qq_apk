package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import android.text.TextUtils;
import androidx.core.os.HandlerCompat;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.tips.GameMakeTeamTipBar;
import com.tencent.mobileqq.activity.aio.tips.GameMakeTeamTipBar.TeamInfoWrapper;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.QQGameTeamConfBean;
import com.tencent.mobileqq.config.business.QQGameTeamConfProcessor;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameMakeTeamInfo.Config;
import tencent.im.qqgame.QQGameMakeTeamInfo.PersonalInfo;
import tencent.im.qqgame.QQGameMakeTeamInfo.QueryGameTeamInfoReq;
import tencent.im.qqgame.QQGameMakeTeamInfo.QueryGameTeamInfoRsp;
import tencent.im.qqgame.QQGameMakeTeamInfo.TeamBase;
import tencent.im.qqgame.QQGameMakeTeamInfo.TeamInfo;

public class QQGamePubAIOHelper
  implements ILifeCycleHelper
{
  private static int jdField_a_of_type_Int = 5;
  private static Handler jdField_a_of_type_AndroidOsHandler = null;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static List<MessageForArkApp> jdField_a_of_type_JavaUtilList;
  public static Set<String> a;
  private static QQGameMakeTeamInfo.Config jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config;
  private long jdField_a_of_type_Long;
  private WadlTrpcListener jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener = new QQGamePubAIOHelper.9(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private GameMakeTeamTipBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaLangObject = new byte[0];
  }
  
  public QQGamePubAIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private GameMakeTeamTipBar a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar = new GameMakeTeamTipBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar;
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unKnow";
    case 0: 
      return "AIO_SHOW";
    case 1: 
      return "MSG_LOOP";
    case 2: 
      return "MSG_ADD";
    }
    return "OTHER_TIPS_HIDE";
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      return paramMessageRecord.uniseq + "";
    }
    return "";
  }
  
  public static String a(QQGameMakeTeamInfo.TeamInfo paramTeamInfo)
  {
    if (paramTeamInfo != null) {
      return paramTeamInfo.msg_seq.get();
    }
    return "";
  }
  
  @NotNull
  private QQGameMakeTeamInfo.Config a(QQGameMakeTeamInfo.QueryGameTeamInfoRsp paramQueryGameTeamInfoRsp)
  {
    paramQueryGameTeamInfoRsp = paramQueryGameTeamInfoRsp.conf;
    if (paramQueryGameTeamInfoRsp.req_interval.get() >= 5) {
      jdField_a_of_type_Int = paramQueryGameTeamInfoRsp.req_interval.get();
    }
    return paramQueryGameTeamInfoRsp;
  }
  
  @NotNull
  private QQGameMakeTeamInfo.QueryGameTeamInfoReq a(List<MessageForArkApp> paramList)
  {
    QQGameMakeTeamInfo.QueryGameTeamInfoReq localQueryGameTeamInfoReq = new QQGameMakeTeamInfo.QueryGameTeamInfoReq();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (MessageForArkApp)paramList.next();
      if ((localObject != null) && (((MessageForArkApp)localObject).ark_app_message != null) && (((MessageForArkApp)localObject).ark_app_message.metaList != null))
      {
        try
        {
          QQGameMakeTeamInfo.TeamBase localTeamBase = new QQGameMakeTeamInfo.TeamBase();
          localTeamBase.ark_meta.set(((MessageForArkApp)localObject).ark_app_message.metaList);
          localTeamBase.msg_seq.set(((MessageForArkApp)localObject).uniseq + "");
          localArrayList.add(localTeamBase);
          localObject = b((MessageForArkApp)localObject);
          if (localObject == null) {
            continue;
          }
          QQGameMakeTeamInfo.PersonalInfo localPersonalInfo = new QQGameMakeTeamInfo.PersonalInfo();
          localPersonalInfo.openid.set(((JSONObject)localObject).optString("sOpenId"));
          localPersonalInfo.plat_id.set(((JSONObject)localObject).optInt("iPlatId"));
          localPersonalInfo.area.set(((JSONObject)localObject).optInt("iArea"));
          localPersonalInfo.partition.set(((JSONObject)localObject).optInt("iPartition"));
          localTeamBase.appid.set(((JSONObject)localObject).optString("sAppid"));
          localTeamBase.team_bus_id.set(((JSONObject)localObject).optString("iTeamBusId"));
          localTeamBase.team_id.set(((JSONObject)localObject).optString("iTeamId"));
          localTeamBase.captain.set(localPersonalInfo);
          localTeamBase.tm.set(((JSONObject)localObject).optLong("time"));
        }
        catch (Throwable localThrowable) {}
        if (QLog.isColorLevel()) {
          QLog.e("QQGamePubAIOHelper", 2, localThrowable, new Object[0]);
        }
      }
    }
    localQueryGameTeamInfoReq.teams.set(localArrayList);
    return localQueryGameTeamInfoReq;
  }
  
  private void a(int paramInt, List<MessageForArkApp> paramList)
  {
    if (QLog.isColorLevel())
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      QLog.i("QQGamePubAIOHelper", 2, "deReqTeamInfo...:,loopType:" + a(paramInt) + ",reqListSize:" + paramList);
    }
    this.jdField_a_of_type_Boolean = true;
    paramList = a(paramList);
    paramList = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/10", false, paramList.toByteArray());
    TrpcProxy.TrpcListReq localTrpcListReq = new TrpcProxy.TrpcListReq();
    localTrpcListReq.list.add(paramList);
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc(localTrpcListReq, null);
  }
  
  public static void a(BaseChatPie paramBaseChatPie, List<ChatMessage> paramList, ChatMessage... paramVarArgs)
  {
    if (paramBaseChatPie == null) {
      return;
    }
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        if ((paramList != null) && (paramList.size() > 0))
        {
          localArrayList.addAll(paramList);
          paramBaseChatPie = (QQGamePubAIOHelper)paramBaseChatPie.a(90);
          if (paramBaseChatPie == null) {
            break;
          }
          paramBaseChatPie.a(localArrayList);
          return;
        }
      }
      catch (Throwable paramBaseChatPie)
      {
        QLog.e("QQGamePubAIOHelper", 2, paramBaseChatPie, new Object[0]);
        return;
      }
      if (paramVarArgs.length > 0) {
        localArrayList.add(paramVarArgs[0]);
      }
    }
  }
  
  private void a(QQGameMakeTeamInfo.TeamInfo paramTeamInfo)
  {
    if (b()) {
      jdField_a_of_type_AndroidOsHandler.post(new QQGamePubAIOHelper.4(this, paramTeamInfo));
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a() == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar);
  }
  
  @NotNull
  private List<MessageForArkApp> b()
  {
    int m = 10;
    int k = 1800;
    int j = k;
    if (jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config != null)
    {
      i = k;
      if (jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config.expire.get() >= 10)
      {
        i = k;
        if (jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config.expire.get() <= 3600) {
          i = jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config.expire.get();
        }
      }
      j = i;
      if (jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config.max_req_teams.get() >= 1)
      {
        j = i;
        if (jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config.max_req_teams.get() <= 50)
        {
          k = jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config.max_req_teams.get();
          j = i;
        }
      }
    }
    for (int i = k;; i = m)
    {
      Collections.sort(jdField_a_of_type_JavaUtilList, new QQGamePubAIOHelper.3(this));
      ArrayList localArrayList = new ArrayList();
      long l = NetConnInfoCenter.getServerTime();
      Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        MessageForArkApp localMessageForArkApp;
        JSONObject localJSONObject;
        String str;
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localMessageForArkApp = (MessageForArkApp)localIterator.next();
            localJSONObject = b(localMessageForArkApp);
          } while (localJSONObject == null);
          str = a(localMessageForArkApp);
        } while ((jdField_a_of_type_JavaUtilSet.contains(str)) || (l - localJSONObject.optLong("time") >= j));
        localArrayList.add(localMessageForArkApp);
      } while (localArrayList.size() < i);
      if (QLog.isColorLevel()) {
        QLog.i("QQGamePubAIOHelper", 2, "filterListByConfig,expireTime:" + j + ",maxReqTeams:" + i + ",mTeamInfoLoopInterval:" + jdField_a_of_type_Int + ",reqListSize:" + localArrayList.size() + ",sTeamMsgList:" + jdField_a_of_type_JavaUtilList.size());
      }
      return localArrayList;
    }
  }
  
  private static JSONObject b(MessageForArkApp paramMessageForArkApp)
  {
    Object localObject = null;
    try
    {
      paramMessageForArkApp = new JSONObject(paramMessageForArkApp.ark_app_message.metaList).optJSONObject("baseInfo");
      return paramMessageForArkApp;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        paramMessageForArkApp = localObject;
      } while (!QLog.isColorLevel());
      QLog.e("QQGamePubAIOHelper", 2, localThrowable, new Object[0]);
    }
    return null;
  }
  
  private void b(List<MessageRecord> paramList)
  {
    if (b()) {
      jdField_a_of_type_AndroidOsHandler.post(new QQGamePubAIOHelper.7(this, paramList));
    }
  }
  
  private boolean b()
  {
    if ((jdField_a_of_type_AndroidOsHandler == null) && (d())) {
      jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper());
    }
    return jdField_a_of_type_AndroidOsHandler != null;
  }
  
  private static boolean b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramMessageRecord.appName)) && (!TextUtils.isEmpty(paramMessageRecord.appView)))
      {
        paramMessageRecord = paramMessageRecord.appName + "." + paramMessageRecord.appView;
        return QQGameTeamConfProcessor.a().jdField_a_of_type_JavaUtilList.contains(paramMessageRecord);
      }
    }
    return false;
  }
  
  private boolean b(QQGameMakeTeamInfo.TeamInfo paramTeamInfo)
  {
    return (paramTeamInfo != null) && (!StringUtil.a(paramTeamInfo.main_text.get())) && (!StringUtil.a(paramTeamInfo.sub_text.get())) && (!StringUtil.a(paramTeamInfo.jump_url.get())) && (paramTeamInfo.icons.get().size() > 0);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ThreadManagerV2.excute(new QQGamePubAIOHelper.6(this), 32, null, true);
  }
  
  private void c(List<QQGameMakeTeamInfo.TeamInfo> paramList)
  {
    for (;;)
    {
      int i;
      try
      {
        if (!a()) {
          break label119;
        }
        GameMakeTeamTipBar.TeamInfoWrapper localTeamInfoWrapper = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar.a();
        if ((paramList == null) || (localTeamInfoWrapper == null)) {
          break label119;
        }
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label119;
        }
        QQGameMakeTeamInfo.TeamInfo localTeamInfo = (QQGameMakeTeamInfo.TeamInfo)paramList.next();
        if (!localTeamInfo.msg_seq.get().equals(localTeamInfoWrapper.a.msg_seq.get())) {
          continue;
        }
        i = localTeamInfo.status.get();
        if (i != 3) {
          break label120;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar.a(3);
        return;
      }
      catch (Throwable paramList)
      {
        QLog.e("QQGamePubAIOHelper", 2, paramList, new Object[0]);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar.a(4);
      return;
      label119:
      label120:
      do
      {
        return;
        if ((i == 1) || (i == 2)) {
          break;
        }
      } while (i != 4);
    }
  }
  
  private boolean c()
  {
    boolean bool;
    for (;;)
    {
      try
      {
        localQQGameTeamConfBean = QQGameTeamConfProcessor.a();
        int i = localQQGameTeamConfBean.jdField_a_of_type_JavaUtilList.size();
        if (i > 0) {
          bool = true;
        }
      }
      catch (Throwable localThrowable1)
      {
        QQGameTeamConfBean localQQGameTeamConfBean;
        bool = false;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGamePubAIOHelper", 2, "isNeedTipsShow:" + bool + ",appKeyListSize:" + localQQGameTeamConfBean.jdField_a_of_type_JavaUtilList.size());
        }
        return bool;
      }
      catch (Throwable localThrowable2)
      {
        break;
      }
      bool = false;
    }
    QLog.e("QQGamePubAIOHelper", 1, localThrowable1, new Object[0]);
    return bool;
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.h() < 5);
  }
  
  public void a()
  {
    if (jdField_a_of_type_AndroidOsHandler != null) {
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(jdField_a_of_type_JavaLangObject);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("QQGamePubAIOHelper", 2, "deReqTeamInfo...mIsGettingData is true just return,loopType:" + a(paramInt));
      }
    }
    do
    {
      return;
      try
      {
        List localList = b();
        if (localList.size() != 0) {
          break;
        }
        a("from deReqTeamInfo");
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.e("QQGamePubAIOHelper", 2, localThrowable, new Object[0]);
    return;
    a(paramInt, localThrowable);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (!d()) {
      if (QLog.isColorLevel()) {
        QLog.i("QQGamePubAIOHelper", 2, "startLoopTeamInfo...isAIOStateValid:false,mChatPie.getCurrentAIOState():" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.h() + ",loopType:" + a(paramInt));
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QQGamePubAIOHelper", 2, "startLoopTeamInfo...delay:" + paramLong + ",loopType:" + a(paramInt));
      }
    } while (!b());
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(jdField_a_of_type_JavaLangObject);
    HandlerCompat.postDelayed(jdField_a_of_type_AndroidOsHandler, new QQGamePubAIOHelper.5(this, paramInt), jdField_a_of_type_JavaLangObject, paramLong);
  }
  
  public void a(TipsBarTask paramTipsBarTask)
  {
    if (paramTipsBarTask != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar == paramTipsBarTask) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar.b();
      }
    }
    else {
      return;
    }
    a(500L, 3);
  }
  
  public void a(TipsBarTask paramTipsBarTask1, TipsBarTask paramTipsBarTask2)
  {
    if ((!(paramTipsBarTask2 instanceof GameMakeTeamTipBar)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar == paramTipsBarTask1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar.a(1);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    try
    {
      if (!paramMessageRecord.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
        return;
      }
      if (b())
      {
        jdField_a_of_type_AndroidOsHandler.post(new QQGamePubAIOHelper.1(this, paramMessageRecord));
        a(500L, 2);
        return;
      }
    }
    catch (Throwable paramMessageRecord)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGamePubAIOHelper", 2, paramMessageRecord, new Object[0]);
      }
    }
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if (b()) {
      jdField_a_of_type_AndroidOsHandler.post(new QQGamePubAIOHelper.2(this, paramList));
    }
  }
  
  public boolean a(String paramString)
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePubAIOHelper", 2, "dismissMakeTeamTip...msg:" + paramString);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(QQGameMakeTeamInfo.TeamInfo paramTeamInfo)
  {
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) {}
    for (;;)
    {
      try
      {
        if (!a()) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        if (bool1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar.a(paramTeamInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          bool2 = bool1;
        }
      }
      catch (Exception paramTeamInfo)
      {
        boolean bool1;
        StringBuilder localStringBuilder;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QQGamePubAIOHelper", 2, paramTeamInfo, new Object[0]);
        a("from show tips Exception");
        bool2 = false;
        continue;
        paramTeamInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
        continue;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("showTip,showed:").append(bool2).append(",curTips:");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() == null)
        {
          paramTeamInfo = null;
          QLog.d("QQGamePubAIOHelper", 2, paramTeamInfo);
        }
      }
      else
      {
        return bool2;
        bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar, new Object[0]);
        continue;
      }
      boolean bool2 = false;
    }
  }
  
  public void b()
  {
    this.b = false;
    if (jdField_a_of_type_AndroidOsHandler != null) {
      jdField_a_of_type_AndroidOsHandler.post(new QQGamePubAIOHelper.8(this));
    }
    a("from stopLoopTeamInfo...");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar = null;
    this.jdField_a_of_type_Boolean = false;
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).removeListener(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
  }
  
  public String getTag()
  {
    return "QQGamePubAIOHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 9, 10, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 9)
    {
      try
      {
        if (!this.b)
        {
          c();
          return;
        }
        a(50L, 0);
        return;
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e("QQGamePubAIOHelper", 2, localThrowable, new Object[0]);
    }
    else
    {
      if (paramInt == 10)
      {
        a();
        return;
      }
      if (paramInt == 14) {
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper
 * JD-Core Version:    0.7.0.1
 */