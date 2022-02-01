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
  public static Set<String> a = new HashSet();
  private static Handler g;
  private static QQGameMakeTeamInfo.Config k;
  private static final List<MessageForArkApp> l = new ArrayList();
  private static final Object m = new byte[0];
  private static int n = 5;
  private QQAppInterface b;
  private BaseChatPie c;
  private SessionInfo d;
  private boolean e;
  private GameMakeTeamTipBar f;
  private boolean h;
  private long i;
  private boolean j;
  private WadlTrpcListener o = new QQGamePubAIOHelper.10(this);
  
  public QQGamePubAIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.b = paramBaseChatPie.d;
    this.d = paramBaseChatPie.ah;
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
  
  @NotNull
  private QQGameMakeTeamInfo.Config a(QQGameMakeTeamInfo.QueryGameTeamInfoRsp paramQueryGameTeamInfoRsp)
  {
    paramQueryGameTeamInfoRsp = paramQueryGameTeamInfoRsp.conf;
    if (paramQueryGameTeamInfoRsp.req_interval.get() >= 5) {
      n = paramQueryGameTeamInfoRsp.req_interval.get();
    }
    return paramQueryGameTeamInfoRsp;
  }
  
  private void a(int paramInt, List<MessageForArkApp> paramList)
  {
    if (QLog.isColorLevel())
    {
      this.i = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deReqTeamInfo...:,loopType:");
      ((StringBuilder)localObject).append(e(paramInt));
      ((StringBuilder)localObject).append(",reqListSize:");
      ((StringBuilder)localObject).append(paramList);
      QLog.i("QQGamePub_QQGamePubAIOHelper", 2, ((StringBuilder)localObject).toString());
    }
    this.h = true;
    paramList = b(paramList);
    paramList = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/10", false, paramList.toByteArray());
    Object localObject = new TrpcProxy.TrpcListReq();
    ((TrpcProxy.TrpcListReq)localObject).list.add(paramList);
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.o);
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
      paramBaseChatPie = (QQGamePubAIOHelper)paramBaseChatPie.q(90);
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
  
  private void a(boolean paramBoolean)
  {
    Object localObject2 = this.c.f.getIntent().getStringExtra("qqgame_msg_page_appid_key");
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
  
  public static String b(QQGameMakeTeamInfo.TeamInfo paramTeamInfo)
  {
    if (paramTeamInfo != null) {
      return paramTeamInfo.msg_seq.get();
    }
    return "";
  }
  
  @NotNull
  private QQGameMakeTeamInfo.QueryGameTeamInfoReq b(List<MessageForArkApp> paramList)
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
  
  private void b(int paramInt)
  {
    if (paramInt == 7)
    {
      this.e = true;
      return;
    }
    if ((paramInt == 11) || (paramInt == 15)) {
      this.e = false;
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 10)
    {
      if (!this.j)
      {
        m();
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
  
  private void c(List<MessageRecord> paramList)
  {
    if (j()) {
      g.post(new QQGamePubAIOHelper.8(this, paramList));
    }
  }
  
  private void c(QQGameMakeTeamInfo.TeamInfo paramTeamInfo)
  {
    if (j()) {
      g.post(new QQGamePubAIOHelper.5(this, paramTeamInfo));
    }
  }
  
  private void d(int paramInt)
  {
    if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isNewPubStyle(this.c.f, this.d.b)) {
      if (paramInt == 4)
      {
        if (((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isInNightMode()) {
          ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAIOHelper.1(this));
        }
      }
      else if (paramInt == 9)
      {
        SimpleEventBus.getInstance().registerReceiver(this);
        String str = this.c.aX().getIntent().getStringExtra("qqgame_msg_page_appid_key");
        Object localObject;
        if ((o()) && (this.c.aZ != null))
        {
          localObject = (ViewGroup)this.c.aZ.findViewById(2131427887);
          ((IQQGameSubscribeService)this.b.getRuntimeService(IQQGameSubscribeService.class, "all")).preHandleGameInfoUi((ViewGroup)localObject, str);
          ((IQQGameSubscribeService)this.b.getRuntimeService(IQQGameSubscribeService.class, "all")).getSubscribeInfo(str);
        }
        a(o());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onMoveToState...SHOW_FIRST,appId:");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(",isSingleGamePage:");
          ((StringBuilder)localObject).append(o());
          QLog.i("QQGamePub_QQGamePubAIOHelper", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (paramInt == 10)
      {
        if (!o()) {
          ((IQQGameSubscribeService)this.b.getRuntimeService(IQQGameSubscribeService.class, "all")).reqSubscribeList(1);
        }
      }
      else
      {
        if (paramInt == 7)
        {
          p();
          return;
        }
        if (paramInt == 15) {
          SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
      }
    }
  }
  
  private void d(List<QQGameMakeTeamInfo.TeamInfo> paramList)
  {
    for (;;)
    {
      int i1;
      try
      {
        if (!g()) {
          break label118;
        }
        GameMakeTeamTipBar.TeamInfoWrapper localTeamInfoWrapper = this.f.g();
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
        i1 = localTeamInfo.status.get();
        if (i1 != 3) {
          break label119;
        }
        this.f.a(3);
        return;
      }
      catch (Throwable paramList)
      {
        QLog.e("QQGamePub_QQGamePubAIOHelper", 2, paramList, new Object[0]);
      }
      this.f.a(4);
      return;
      label118:
      label119:
      do
      {
        return;
        if ((i1 == 1) || (i1 == 2)) {
          break;
        }
      } while (i1 != 4);
    }
  }
  
  private static boolean d(MessageRecord paramMessageRecord)
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
        return QQGameTeamConfProcessor.a().a.contains(paramMessageRecord);
      }
    }
    return false;
  }
  
  private boolean d(QQGameMakeTeamInfo.TeamInfo paramTeamInfo)
  {
    return (paramTeamInfo != null) && (!StringUtil.isEmpty(paramTeamInfo.main_text.get())) && (!StringUtil.isEmpty(paramTeamInfo.sub_text.get())) && (!StringUtil.isEmpty(paramTeamInfo.jump_url.get())) && (paramTeamInfo.icons.get().size() > 0);
  }
  
  private static String e(int paramInt)
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
  
  private boolean g()
  {
    if (this.f != null)
    {
      BaseChatPie localBaseChatPie = this.c;
      if ((localBaseChatPie != null) && (localBaseChatPie.J() != null) && (this.c.J().a() == this.f)) {
        return true;
      }
    }
    return false;
  }
  
  private GameMakeTeamTipBar h()
  {
    if (this.f == null)
    {
      this.f = new GameMakeTeamTipBar(this.c);
      if (this.c.J() != null) {
        this.c.J().b(this.f);
      }
    }
    return this.f;
  }
  
  @NotNull
  private List<MessageForArkApp> i()
  {
    Object localObject1 = k;
    int i5 = 10;
    int i3 = 1800;
    int i4 = i5;
    int i2 = i3;
    if (localObject1 != null)
    {
      int i1 = i3;
      if (((QQGameMakeTeamInfo.Config)localObject1).expire.get() >= 10)
      {
        i1 = i3;
        if (k.expire.get() <= 3600) {
          i1 = k.expire.get();
        }
      }
      i4 = i5;
      i2 = i1;
      if (k.max_req_teams.get() >= 1)
      {
        i4 = i5;
        i2 = i1;
        if (k.max_req_teams.get() <= 50)
        {
          i4 = k.max_req_teams.get();
          i2 = i1;
        }
      }
    }
    Collections.sort(l, new QQGamePubAIOHelper.4(this));
    localObject1 = new ArrayList();
    long l1 = NetConnInfoCenter.getServerTime();
    Object localObject2 = l.iterator();
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
      } while ((a.contains(str)) || (l1 - localMessageForArkApp.time >= i2));
      ((List)localObject1).add(localMessageForArkApp);
    } while (((List)localObject1).size() < i4);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("filterListByConfig,expireTime:");
      ((StringBuilder)localObject2).append(i2);
      ((StringBuilder)localObject2).append(",maxReqTeams:");
      ((StringBuilder)localObject2).append(i4);
      ((StringBuilder)localObject2).append(",mTeamInfoLoopInterval:");
      ((StringBuilder)localObject2).append(n);
      ((StringBuilder)localObject2).append(",reqListSize:");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      ((StringBuilder)localObject2).append(",sTeamMsgList:");
      ((StringBuilder)localObject2).append(l.size());
      QLog.i("QQGamePub_QQGamePubAIOHelper", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  private boolean j()
  {
    if ((g == null) && (l())) {
      g = new Handler(ThreadManagerV2.getSubThreadLooper());
    }
    return g != null;
  }
  
  private boolean k()
  {
    boolean bool1;
    try
    {
      QQGameTeamConfBean localQQGameTeamConfBean = QQGameTeamConfProcessor.a();
      int i1 = localQQGameTeamConfBean.a.size();
      if (i1 > 0) {
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
        localStringBuilder.append(localQQGameTeamConfBean.a.size());
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
  
  private boolean l()
  {
    BaseChatPie localBaseChatPie = this.c;
    return (localBaseChatPie != null) && (localBaseChatPie.bb() < 5);
  }
  
  private void m()
  {
    if (this.b == null) {
      return;
    }
    ThreadManagerV2.excute(new QQGamePubAIOHelper.7(this), 32, null, true);
  }
  
  private void n()
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAIOHelper.13(this));
  }
  
  private boolean o()
  {
    return ((IQQGameSubscribeService)this.b.getRuntimeService(IQQGameSubscribeService.class, "all")).isGameSinglePage(this.c.aX().getIntent());
  }
  
  private void p()
  {
    if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isNewPubStyle(this.c.f, this.d.b))
    {
      this.c.b(-1, true);
      if (this.c.p != null)
      {
        this.c.p.setBackgroundResource(2131168464);
        View localView = this.c.p.findViewById(2131436666);
        if (localView != null) {
          localView.setBackgroundDrawable(this.c.f.getResources().getDrawable(2130851109));
        }
        localView = this.c.p.findViewById(2131436180);
        if (localView != null) {
          localView.setBackgroundDrawable(this.c.f.getResources().getDrawable(2130851109));
        }
        localView = this.c.p.findViewById(2131436194);
        if (localView != null) {
          if (((IQQGameSubscribeService)this.b.getRuntimeService(IQQGameSubscribeService.class, "all")).isGameSinglePage(this.c.f.getIntent()))
          {
            localView.setVisibility(8);
            localView.setOnClickListener(null);
          }
          else
          {
            this.c.p.setRight1Icon(2130840522);
            localView.setBackgroundDrawable(null);
            localView.setContentDescription(this.c.f.getText(2131892997));
          }
        }
      }
      if (this.c.C != null) {
        this.c.C.setTextColor(this.c.f.getResources().getColor(2131165564));
      }
    }
  }
  
  public void a()
  {
    Handler localHandler = g;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(m);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (this.h)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("deReqTeamInfo...mIsGettingData is true just return,loopType:");
        ((StringBuilder)localObject).append(e(paramInt));
        QLog.i("QQGamePub_QQGamePubAIOHelper", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    try
    {
      localObject = i();
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
    if (!l())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startLoopTeamInfo...isAIOStateValid:false,mChatPie.getCurrentAIOState():");
        localStringBuilder.append(this.c.bb());
        localStringBuilder.append(",loopType:");
        localStringBuilder.append(e(paramInt));
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
      localStringBuilder.append(e(paramInt));
      QLog.i("QQGamePub_QQGamePubAIOHelper", 2, localStringBuilder.toString());
    }
    if (j())
    {
      g.removeCallbacksAndMessages(m);
      HandlerCompat.postDelayed(g, new QQGamePubAIOHelper.6(this, paramInt), m, paramLong);
    }
  }
  
  public void a(TipsBarTask paramTipsBarTask)
  {
    if (paramTipsBarTask != null)
    {
      GameMakeTeamTipBar localGameMakeTeamTipBar = this.f;
      if (localGameMakeTeamTipBar == paramTipsBarTask)
      {
        localGameMakeTeamTipBar.e();
        return;
      }
      a(500L, 3);
    }
  }
  
  public void a(TipsBarTask paramTipsBarTask1, TipsBarTask paramTipsBarTask2)
  {
    if (!(paramTipsBarTask2 instanceof GameMakeTeamTipBar))
    {
      paramTipsBarTask2 = this.f;
      if ((paramTipsBarTask2 != null) && (paramTipsBarTask2 == paramTipsBarTask1)) {
        paramTipsBarTask2.a(1);
      }
    }
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if (j()) {
      g.post(new QQGamePubAIOHelper.3(this, paramList));
    }
  }
  
  public boolean a(String paramString)
  {
    if (g())
    {
      this.c.J().c();
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
    h();
    Object localObject = this.c.J();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null) {
      try
      {
        if (g()) {
          bool1 = true;
        } else {
          bool1 = this.c.J().a(this.f, new Object[0]);
        }
        if (bool1) {
          this.f.a(paramTeamInfo, this.d);
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
      if (this.c.J() == null) {
        paramTeamInfo = null;
      } else {
        paramTeamInfo = this.c.J().a();
      }
      ((StringBuilder)localObject).append(paramTeamInfo);
      QLog.d("QQGamePub_QQGamePubAIOHelper", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public void b()
  {
    this.j = false;
    Handler localHandler = g;
    if (localHandler != null) {
      localHandler.post(new QQGamePubAIOHelper.9(this));
    }
    a("from stopLoopTeamInfo...");
    this.f = null;
    this.h = false;
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).removeListener(this.o);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    try
    {
      if (!paramMessageRecord.frienduin.equals(this.d.b)) {
        return;
      }
      if (j())
      {
        g.post(new QQGamePubAIOHelper.2(this, paramMessageRecord));
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
      if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(this.d.b)) {
        d(paramInt);
      } else if (this.d.a == 1) {
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
      boolean bool = o();
      Object localObject;
      if (((paramSimpleBaseEvent instanceof QQGameSubscribeBusEvent)) && (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(this.d.b)))
      {
        localObject = (QQGameSubscribeBusEvent)paramSimpleBaseEvent;
        int i1 = ((QQGameSubscribeBusEvent)localObject).eventType;
        if ((i1 == 1) && (!bool)) {
          n();
        } else if ((i1 == 2) && (bool)) {
          a(((QQGameSubscribeBusEvent)localObject).subscribeInfo, false);
        } else if ((i1 == 3) && (bool)) {
          a(((QQGameSubscribeBusEvent)localObject).subscribeInfo, true);
        } else if (i1 == 6) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper
 * JD-Core Version:    0.7.0.1
 */