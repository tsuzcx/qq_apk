package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.qcircle.QCircleChatUtil;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.QCircleMsgLoader;
import com.tencent.mobileqq.activity.aio.rebuild.tips.QCircleTipsController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQCircleIceBreak;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.inputstatus.InputStatusHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcircle.api.requests.QCircleChatGetPMBeginShowMsgRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import java.util.Observable;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp;

public class QCircleChatPie
  extends BaseChatPie
  implements Handler.Callback
{
  private volatile int bi;
  private MessageRecord bj;
  private MessageRecord bk;
  private String bl = null;
  private MessageForUniteGrayTip bm;
  private MessageForQCircleIceBreak bn;
  private byte[] bo = null;
  private final MessageObserver bp = new QCircleChatPie.1(this);
  private FriendListObserver bq = new QCircleChatPie.2(this);
  
  public QCircleChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoFriendAio : ");
      localStringBuilder.append(this.ah.b);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = AIOUtils.a(new Intent(aX(), SplashActivity.class), null);
    ((Intent)localObject).putExtra("uin", this.ah.b);
    ((Intent)localObject).putExtra("uintype", 0);
    aX().startActivity((Intent)localObject);
  }
  
  private void a(QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp paramStGetPMBeginShowMsgRsp)
  {
    paramStGetPMBeginShowMsgRsp = paramStGetPMBeginShowMsgRsp.pmBeginShow.get();
    if (!TextUtils.isEmpty(this.bl))
    {
      g(paramStGetPMBeginShowMsgRsp);
      return;
    }
    f(paramStGetPMBeginShowMsgRsp);
  }
  
  private void b(List<MessageRecord> paramList)
  {
    if ((QCircleChatUtil.a(this.d, this.ah.b, this.ah.a, paramList)) && (!TextUtils.isEmpty(this.bl)))
    {
      this.bm = QCircleChatUtil.a(this.d, this.ah.b, this.ah.a, this.bl, this.bk);
      paramList = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showFuelTips:");
      localStringBuilder.append(this.bl);
      QLog.d(paramList, 2, localStringBuilder.toString());
    }
    e(this.ah.b);
  }
  
  private void bA()
  {
    if (!QCircleChatUtil.b(this.d, this.ah.b))
    {
      QLog.d(this.c, 2, "showIceBreakMessage");
      this.bn = QCircleChatUtil.a(this.d, this.ah.b, this.ah.a, this.bo, this.bj);
      if (this.bn != null) {
        QCircleChatUtil.a(this.d, this.ah.b);
      }
    }
  }
  
  @Nullable
  private List<MessageRecord> bB()
  {
    List localList = this.d.getMessageFacade().a(this.ah.b, this.ah.a, null, 500);
    if (localList != null) {
      this.bi = localList.size();
    }
    if ((localList != null) && (localList.size() > 0))
    {
      this.bj = ((MessageRecord)localList.get(0));
      this.bk = ((MessageRecord)localList.get(localList.size() - 1));
    }
    return localList;
  }
  
  private void bC()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.ah.b).setActionType(45).setSubActionType(3).setThrActionType(1));
  }
  
  private boolean bD()
  {
    int i = this.n.getCurrentPanel();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0)
    {
      bool1 = bool2;
      if (!((AudioPanelProvider)this.ae.f(2)).g())
      {
        this.n.a(true);
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkConsumeBackEvent, comsumed:");
      localStringBuilder.append(bool1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  private void bE()
  {
    if (this.V != null) {
      this.V.g = Boolean.valueOf(false);
    }
  }
  
  private void bF()
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)q(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.b();
    }
  }
  
  private void bz()
  {
    ThreadManager.getSubThreadHandler().post(new -..Lambda.QCircleChatPie.8bJOmosFnMqvFTQAzOpNfg8QtQE(this));
  }
  
  private void e(String paramString)
  {
    paramString = new QCircleChatGetPMBeginShowMsgRequest(paramString);
    VSNetworkHelper.getInstance().sendRequest(this.e, paramString, new -..Lambda.QCircleChatPie.IOr591nhg_pl9oa6NuwkzzHl-xw(this));
  }
  
  private void f(String paramString)
  {
    this.bl = paramString;
    if (!TextUtils.isEmpty(this.bl))
    {
      this.bm = QCircleChatUtil.a(this.d, this.ah.b, this.ah.a, this.bl, this.bk);
      bC();
    }
  }
  
  private void g(String paramString)
  {
    if (this.bl.equals(paramString))
    {
      bC();
      return;
    }
    this.bl = paramString;
    if (!TextUtils.isEmpty(this.bl))
    {
      if (QCircleChatUtil.a(this.d, this.bl, this.bm))
      {
        a(this.bm, 0);
        bC();
      }
    }
    else
    {
      this.d.getMessageFacade().a(this.ah.b, this.ah.a, this.bm.msgtype, this.bm.uniseq);
      j(131072);
    }
  }
  
  public void K()
  {
    super.K();
  }
  
  public void S()
  {
    super.S();
    if (((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(this.ah.b)) {
      a();
    }
  }
  
  public boolean V()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onBackEvent begin");
    }
    if (bD()) {
      return true;
    }
    return super.V();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPanelChanged, old:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" new:");
      localStringBuilder.append(paramInt2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt2 == 1)
    {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.ah.b).setActionType(45).setSubActionType(5).setThrActionType(2));
      QLog.d(this.c, 2, "report input click");
    }
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    if (this.V != null) {
      this.V.g = Boolean.valueOf(false);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    bE();
    bz();
    return paramBoolean;
  }
  
  public void ah()
  {
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPreThemeChanged");
      localStringBuilder.append(this.aL);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void ai()
  {
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPostThemeChanged");
      localStringBuilder.append(this.aL);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    bg();
  }
  
  protected void au()
  {
    super.au();
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "addBusinessObservers");
    }
    this.d.addObserver(this.bp);
    this.d.addObserver(this.bq);
  }
  
  protected void av()
  {
    super.av();
    this.d.removeObserver(this.bq);
    this.d.removeObserver(this.bp);
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    if ((paramIntent.getBooleanExtra("qcircle_chat_hide_menu_key", false)) && (this.p != null)) {
      this.p.setRightRootVisibility(4);
    }
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    this.bl = paramIntent.getStringExtra("qcircle_chat_show_fuel_tips_key");
    this.bo = paramIntent.getByteArrayExtra("qcirlce_chat_gift_info_bytes_key");
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new Scroller()).a(new ListUI(this.i)).a(new QCircleMsgLoader()).a(new UnreadTask(this.i)).a();
  }
  
  protected TipsController f()
  {
    return new QCircleTipsController(this.i);
  }
  
  protected void h()
  {
    this.c = "QCircleChatPie";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return super.handleMessage(paramMessage);
  }
  
  public void k(boolean paramBoolean) {}
  
  protected void l()
  {
    super.l();
    this.U.setChoiceMode(0);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.ah.b).setActionType(45).setSubActionType(1).setThrActionType(1));
  }
  
  public void l(int paramInt)
  {
    super.l(paramInt);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131433920) {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.ah.b).setActionType(45).setSubActionType(6).setThrActionType(3));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected boolean p()
  {
    return (this.aL) || (super.p());
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = (InputStatusHelper)q(16);
      if (paramObject != null)
      {
        if (paramObservable.isSend())
        {
          paramObject.d();
          return;
        }
        if (paramObservable.time > paramObject.b) {
          bF();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie
 * JD-Core Version:    0.7.0.1
 */