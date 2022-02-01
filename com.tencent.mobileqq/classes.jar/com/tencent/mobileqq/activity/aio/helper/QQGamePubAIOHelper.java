package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.os.HandlerCompat;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.tips.GameMakeTeamTipBar;
import com.tencent.mobileqq.activity.aio.tips.GameMakeTeamTipBar.TeamInfoWrapper;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
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
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.AppSubscribeInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGameSubscribeBusEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import tencent.im.qqgame.QQGameMakeTeamInfo.Config;
import tencent.im.qqgame.QQGameMakeTeamInfo.QueryGameTeamInfoReq;
import tencent.im.qqgame.QQGameMakeTeamInfo.QueryGameTeamInfoRsp;
import tencent.im.qqgame.QQGameMakeTeamInfo.TeamBase;
import tencent.im.qqgame.QQGameMakeTeamInfo.TeamInfo;

public class QQGamePubAIOHelper
  implements SimpleEventReceiver, ILifeCycleHelper
{
  private static int jdField_a_of_type_Int = 5;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static final List<MessageForArkApp> jdField_a_of_type_JavaUtilList;
  public static Set<String> a;
  private static QQGameMakeTeamInfo.Config jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config;
  private long jdField_a_of_type_Long;
  private WadlTrpcListener jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener = new QQGamePubAIOHelper.10(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private GameMakeTeamTipBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "unKnow";
          }
          return "OTHER_TIPS_HIDE";
        }
        return "MSG_ADD";
      }
      return "MSG_LOOP";
    }
    return "AIO_SHOW";
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    Object localObject = "";
    if (paramMessageRecord != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramMessageRecord.uniseq);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
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
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramList.next();
      if ((localMessageForArkApp != null) && (localMessageForArkApp.ark_app_message != null) && (localMessageForArkApp.ark_app_message.metaList != null))
      {
        try
        {
          QQGameMakeTeamInfo.TeamBase localTeamBase = new QQGameMakeTeamInfo.TeamBase();
          localTeamBase.ark_meta.set(localMessageForArkApp.ark_app_message.metaList);
          PBStringField localPBStringField = localTeamBase.msg_seq;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localMessageForArkApp.uniseq);
          localStringBuilder.append("");
          localPBStringField.set(localStringBuilder.toString());
          localTeamBase.tm.set(localMessageForArkApp.time);
          localArrayList.add(localTeamBase);
        }
        catch (Throwable localThrowable) {}
        if (QLog.isColorLevel()) {
          QLog.e("QQGamePub_QQGamePubAIOHelper", 2, localThrowable, new Object[0]);
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deReqTeamInfo...:,loopType:");
      ((StringBuilder)localObject).append(a(paramInt));
      ((StringBuilder)localObject).append(",reqListSize:");
      ((StringBuilder)localObject).append(paramList);
      QLog.i("QQGamePub_QQGamePubAIOHelper", 2, ((StringBuilder)localObject).toString());
    }
    this.b = true;
    paramList = a(paramList);
    paramList = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/10", false, paramList.toByteArray());
    Object localObject = new TrpcProxy.TrpcListReq();
    ((TrpcProxy.TrpcListReq)localObject).list.add(paramList);
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject, null);
  }
  
  public static void a(BaseChatPie paramBaseChatPie, List<ChatMessage> paramList, ChatMessage... paramVarArgs)
  {
    if (paramBaseChatPie == null) {
      return;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0)) {
        localArrayList.addAll(paramList);
      } else if (paramVarArgs.length > 0) {
        localArrayList.add(paramVarArgs[0]);
      }
      paramBaseChatPie = (QQGamePubAIOHelper)paramBaseChatPie.a(90);
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie.a(localArrayList);
        return;
      }
    }
    catch (Throwable paramBaseChatPie)
    {
      QLog.e("QQGamePub_QQGamePubAIOHelper", 2, paramBaseChatPie, new Object[0]);
    }
  }
  
  private void a(QQGamePubSubscribe.AppSubscribeInfo paramAppSubscribeInfo, boolean paramBoolean)
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAIOHelper.12(this, paramAppSubscribeInfo, paramBoolean));
  }
  
  private void a(QQGameMakeTeamInfo.TeamInfo paramTeamInfo)
  {
    if (b()) {
      jdField_a_of_type_AndroidOsHandler.post(new QQGamePubAIOHelper.5(this, paramTeamInfo));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("qqgame_msg_page_appid_key");
    WadlReportBuilder localWadlReportBuilder1 = new WadlReportBuilder();
    WadlReportBuilder localWadlReportBuilder2 = localWadlReportBuilder1.a("dc00087").h("769");
    Object localObject1;
    if (paramBoolean) {
      localObject1 = "208621";
    } else {
      localObject1 = "208620";
    }
    localWadlReportBuilder2 = localWadlReportBuilder2.c((String)localObject1);
    if (localObject2 != null) {
      localObject1 = localObject2;
    } else {
      localObject1 = "";
    }
    localObject2 = localWadlReportBuilder2.b((String)localObject1);
    if (paramBoolean) {
      localObject1 = "76932";
    } else {
      localObject1 = "76931";
    }
    ((WadlReportBuilder)localObject2).d((String)localObject1).g("7").e("1").f("160");
    localWadlReportBuilder1.a();
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar != null)
    {
      BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((localBaseChatPie != null) && (localBaseChatPie.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a() == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar)) {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  private List<MessageForArkApp> b()
  {
    Object localObject1 = jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config;
    int n = 10;
    int k = 1800;
    int m = n;
    int j = k;
    if (localObject1 != null)
    {
      int i = k;
      if (((QQGameMakeTeamInfo.Config)localObject1).expire.get() >= 10)
      {
        i = k;
        if (jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config.expire.get() <= 3600) {
          i = jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config.expire.get();
        }
      }
      m = n;
      j = i;
      if (jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config.max_req_teams.get() >= 1)
      {
        m = n;
        j = i;
        if (jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config.max_req_teams.get() <= 50)
        {
          m = jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$Config.max_req_teams.get();
          j = i;
        }
      }
    }
    Collections.sort(jdField_a_of_type_JavaUtilList, new QQGamePubAIOHelper.4(this));
    localObject1 = new ArrayList();
    long l = NetConnInfoCenter.getServerTime();
    Object localObject2 = jdField_a_of_type_JavaUtilList.iterator();
    do
    {
      MessageForArkApp localMessageForArkApp;
      String str;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localMessageForArkApp = (MessageForArkApp)((Iterator)localObject2).next();
        str = a(localMessageForArkApp);
      } while ((jdField_a_of_type_JavaUtilSet.contains(str)) || (l - localMessageForArkApp.time >= j));
      ((List)localObject1).add(localMessageForArkApp);
    } while (((List)localObject1).size() < m);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("filterListByConfig,expireTime:");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(",maxReqTeams:");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append(",mTeamInfoLoopInterval:");
      ((StringBuilder)localObject2).append(jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append(",reqListSize:");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      ((StringBuilder)localObject2).append(",sTeamMsgList:");
      ((StringBuilder)localObject2).append(jdField_a_of_type_JavaUtilList.size());
      QLog.i("QQGamePub_QQGamePubAIOHelper", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 7)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if ((paramInt == 11) || (paramInt == 15)) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void b(List<MessageRecord> paramList)
  {
    if (b()) {
      jdField_a_of_type_AndroidOsHandler.post(new QQGamePubAIOHelper.8(this, paramList));
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageRecord.appName);
        localStringBuilder.append(".");
        localStringBuilder.append(paramMessageRecord.appView);
        paramMessageRecord = localStringBuilder.toString();
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
    ThreadManagerV2.excute(new QQGamePubAIOHelper.7(this), 32, null, true);
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 10)
    {
      if (!this.c)
      {
        c();
        return;
      }
      a(50L, 0);
      return;
    }
    if (paramInt == 11)
    {
      a();
      return;
    }
    if (paramInt == 15) {
      b();
    }
  }
  
  private void c(List<QQGameMakeTeamInfo.TeamInfo> paramList)
  {
    for (;;)
    {
      int i;
      try
      {
        if (!a()) {
          break label118;
        }
        GameMakeTeamTipBar.TeamInfoWrapper localTeamInfoWrapper = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar.a();
        if ((paramList == null) || (localTeamInfoWrapper == null)) {
          break label118;
        }
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label118;
        }
        QQGameMakeTeamInfo.TeamInfo localTeamInfo = (QQGameMakeTeamInfo.TeamInfo)paramList.next();
        if (!localTeamInfo.msg_seq.get().equals(localTeamInfoWrapper.a.msg_seq.get())) {
          continue;
        }
        i = localTeamInfo.status.get();
        if (i != 3) {
          break label119;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar.a(3);
        return;
      }
      catch (Throwable paramList)
      {
        QLog.e("QQGamePub_QQGamePubAIOHelper", 2, paramList, new Object[0]);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar.a(4);
      return;
      label118:
      label119:
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
    boolean bool1;
    try
    {
      QQGameTeamConfBean localQQGameTeamConfBean = QQGameTeamConfProcessor.a();
      int i = localQQGameTeamConfBean.jdField_a_of_type_JavaUtilList.size();
      if (i > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      try
      {
        if (!QLog.isColorLevel()) {
          return bool2;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNeedTipsShow:");
        localStringBuilder.append(bool1);
        localStringBuilder.append(",appKeyListSize:");
        localStringBuilder.append(localQQGameTeamConfBean.jdField_a_of_type_JavaUtilList.size());
        QLog.d("QQGamePub_QQGamePubAIOHelper", 2, localStringBuilder.toString());
        return bool1;
      }
      catch (Throwable localThrowable1) {}
      QLog.e("QQGamePub_QQGamePubAIOHelper", 1, localThrowable2, new Object[0]);
    }
    catch (Throwable localThrowable2)
    {
      bool1 = false;
    }
    boolean bool2 = bool1;
    return bool2;
  }
  
  private void d()
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAIOHelper.13(this));
  }
  
  private void d(int paramInt)
  {
    if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isNewPubStyle(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (paramInt == 4)
      {
        if (((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isInNightMode()) {
          ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAIOHelper.1(this));
        }
      }
      else if (paramInt == 9)
      {
        SimpleEventBus.getInstance().registerReceiver(this);
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getIntent().getStringExtra("qqgame_msg_page_appid_key");
        Object localObject;
        if ((e()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c != null))
        {
          localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131362288);
          ((IQQGameSubscribeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQGameSubscribeService.class, "all")).preHandleGameInfoUi((ViewGroup)localObject, str);
          ((IQQGameSubscribeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQGameSubscribeService.class, "all")).getSubscribeInfo(str);
        }
        a(e());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onMoveToState...SHOW_FIRST,appId:");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(",isSingleGamePage:");
          ((StringBuilder)localObject).append(e());
          QLog.i("QQGamePub_QQGamePubAIOHelper", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (paramInt == 10)
      {
        if (!e()) {
          ((IQQGameSubscribeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQGameSubscribeService.class, "all")).reqSubscribeList(1);
        }
      }
      else
      {
        if (paramInt == 7)
        {
          e();
          return;
        }
        if (paramInt == 15) {
          SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
      }
    }
  }
  
  private boolean d()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    return (localBaseChatPie != null) && (localBaseChatPie.d() < 5);
  }
  
  private void e()
  {
    if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isNewPubStyle(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(-1, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2131167394);
        View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369563);
        if (localView != null) {
          localView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130849425));
        }
        localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369202);
        if (localView != null) {
          localView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130849425));
        }
        localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369216);
        if (localView != null) {
          if (((IQQGameSubscribeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQGameSubscribeService.class, "all")).isGameSinglePage(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent()))
          {
            localView.setVisibility(8);
            localView.setOnClickListener(null);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130840210);
            localView.setBackgroundDrawable(null);
            localView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getText(2131695262));
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131165327));
      }
    }
  }
  
  private boolean e()
  {
    return ((IQQGameSubscribeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQGameSubscribeService.class, "all")).isGameSinglePage(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getIntent());
  }
  
  public void a()
  {
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(jdField_a_of_type_JavaLangObject);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (this.b)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deReqTeamInfo...mIsGettingData is true just return,loopType:");
        ((StringBuilder)localObject).append(a(paramInt));
        QLog.i("QQGamePub_QQGamePubAIOHelper", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    try
    {
      localObject = b();
      if (((List)localObject).size() == 0)
      {
        a("from deReqTeamInfo");
        return;
      }
      a(paramInt, (List)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGamePub_QQGamePubAIOHelper", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (!d())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startLoopTeamInfo...isAIOStateValid:false,mChatPie.getCurrentAIOState():");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d());
        localStringBuilder.append(",loopType:");
        localStringBuilder.append(a(paramInt));
        QLog.i("QQGamePub_QQGamePubAIOHelper", 2, localStringBuilder.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startLoopTeamInfo...delay:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",loopType:");
      localStringBuilder.append(a(paramInt));
      QLog.i("QQGamePub_QQGamePubAIOHelper", 2, localStringBuilder.toString());
    }
    if (b())
    {
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(jdField_a_of_type_JavaLangObject);
      HandlerCompat.postDelayed(jdField_a_of_type_AndroidOsHandler, new QQGamePubAIOHelper.6(this, paramInt), jdField_a_of_type_JavaLangObject, paramLong);
    }
  }
  
  public void a(TipsBarTask paramTipsBarTask)
  {
    if (paramTipsBarTask != null)
    {
      GameMakeTeamTipBar localGameMakeTeamTipBar = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar;
      if (localGameMakeTeamTipBar == paramTipsBarTask)
      {
        localGameMakeTeamTipBar.b();
        return;
      }
      a(500L, 3);
    }
  }
  
  public void a(TipsBarTask paramTipsBarTask1, TipsBarTask paramTipsBarTask2)
  {
    if (!(paramTipsBarTask2 instanceof GameMakeTeamTipBar))
    {
      paramTipsBarTask2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar;
      if ((paramTipsBarTask2 != null) && (paramTipsBarTask2 == paramTipsBarTask1)) {
        paramTipsBarTask2.a(1);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    try
    {
      if (!paramMessageRecord.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (b())
      {
        jdField_a_of_type_AndroidOsHandler.post(new QQGamePubAIOHelper.2(this, paramMessageRecord));
        a(500L, 2);
        return;
      }
    }
    catch (Throwable paramMessageRecord)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGamePub_QQGamePubAIOHelper", 2, paramMessageRecord, new Object[0]);
      }
    }
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if (b()) {
      jdField_a_of_type_AndroidOsHandler.post(new QQGamePubAIOHelper.3(this, paramList));
    }
  }
  
  public boolean a(String paramString)
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dismissMakeTeamTip...msg:");
        localStringBuilder.append(paramString);
        QLog.d("QQGamePub_QQGamePubAIOHelper", 2, localStringBuilder.toString());
      }
      return true;
    }
    return false;
  }
  
  public boolean a(QQGameMakeTeamInfo.TeamInfo paramTeamInfo)
  {
    a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null) {
      try
      {
        if (a()) {
          bool1 = true;
        } else {
          bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar, new Object[0]);
        }
        if (bool1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar.a(paramTeamInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
      }
      catch (Exception paramTeamInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQGamePub_QQGamePubAIOHelper", 2, paramTeamInfo, new Object[0]);
        }
        a("from show tips Exception");
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTip,showed:");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(",curTips:");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() == null) {
        paramTeamInfo = null;
      } else {
        paramTeamInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
      }
      ((StringBuilder)localObject).append(paramTeamInfo);
      QLog.d("QQGamePub_QQGamePubAIOHelper", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public void b()
  {
    this.c = false;
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.post(new QQGamePubAIOHelper.9(this));
    }
    a("from stopLoopTeamInfo...");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar = null;
    this.b = false;
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).removeListener(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QQGameSubscribeBusEvent.class);
    return localArrayList;
  }
  
  public String getTag()
  {
    return "QQGamePub_QQGamePubAIOHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 9, 10, 11, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    try
    {
      b(paramInt);
      if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        d(paramInt);
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        c(paramInt);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onMoveToState...state:");
        localStringBuilder.append(paramInt);
        QLog.i("QQGamePub_QQGamePubAIOHelper", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_QQGamePubAIOHelper", 1, localThrowable, new Object[0]);
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    try
    {
      boolean bool = e();
      Object localObject;
      if (((paramSimpleBaseEvent instanceof QQGameSubscribeBusEvent)) && (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        localObject = (QQGameSubscribeBusEvent)paramSimpleBaseEvent;
        int i = ((QQGameSubscribeBusEvent)localObject).eventType;
        if ((i == 1) && (!bool)) {
          d();
        } else if ((i == 2) && (bool)) {
          a(((QQGameSubscribeBusEvent)localObject).subscribeInfo, false);
        } else if ((i == 3) && (bool)) {
          a(((QQGameSubscribeBusEvent)localObject).subscribeInfo, true);
        } else if (i == 6) {
          ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAIOHelper.11(this));
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceiveEvent...");
        ((StringBuilder)localObject).append(paramSimpleBaseEvent);
        ((StringBuilder)localObject).append(",isSingleGamePage:");
        ((StringBuilder)localObject).append(bool);
        QLog.i("QQGamePub_QQGamePubAIOHelper", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable paramSimpleBaseEvent)
    {
      QLog.e("QQGamePub_QQGamePubAIOHelper", 1, paramSimpleBaseEvent, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper
 * JD-Core Version:    0.7.0.1
 */