package com.tencent.mobileqq.activity.aio.core;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo_tips;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.BaseTroopScroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.DiscussListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.DiscussHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.TroopAioAgent;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.navigatebar.AioAgent.Message;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class DiscussChatPie
  extends BaseChatPie
{
  public ActionSheet bi = null;
  TroopMngObserver bj = new DiscussChatPie.4(this);
  protected MessageObserver bk = new DiscussChatPie.7(this);
  private TextView bl;
  private Dialog bm;
  private DiscussionObserver bn = new DiscussChatPie.3(this);
  
  public DiscussChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private boolean a(boolean paramBoolean, List<MessageRecord> paramList)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMsgRevokeNotice:");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (!paramBoolean) {
      return true;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = (MessageRecord)paramList.get(0);
      if (this.au != null)
      {
        int i = this.au.i();
        if (i != -1)
        {
          paramList = (TroopAioNavigateBarManager)this.d.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.ah.b);
          localStringBuilder.append("&");
          localStringBuilder.append(3000);
          long l = paramList.c(localStringBuilder.toString());
          if (((MessageRecord)localObject).uniseq == l)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.ah.b);
            ((StringBuilder)localObject).append("&");
            ((StringBuilder)localObject).append(3000);
            paramList.c(((StringBuilder)localObject).toString(), i);
            this.au.a(i);
            this.au.d();
          }
          if (QLog.isColorLevel())
          {
            paramList = new StringBuilder("onMsgRevokeNotice==>");
            paramList.append("navigateType:");
            paramList.append(i);
            paramList.append("|navigaeSeq:");
            paramList.append(l);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.c);
            ((StringBuilder)localObject).append(".troop.special_msg");
            QLog.d(((StringBuilder)localObject).toString(), 2, paramList.toString());
          }
        }
      }
    }
    return false;
  }
  
  private void bA()
  {
    Object localObject1 = this.bm;
    if ((localObject1 != null) && (((Dialog)localObject1).isShowing())) {
      return;
    }
    DiscussionManager localDiscussionManager = (DiscussionManager)this.d.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    Object localObject2;
    if (!localDiscussionManager.a.containsKey(this.ah.b))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = this.c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("DiscussionManager's discToTroopCache doesn't contain discussionUIN :");
        ((StringBuilder)localObject2).append(this.ah.b);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    localObject1 = (String[])localDiscussionManager.a.get(this.ah.b);
    if ((localObject1 != null) && (localObject1.length >= 2))
    {
      String str1 = localObject1[0];
      String str2 = localObject1[1];
      if (!this.f.isFinishing())
      {
        localObject1 = null;
        try
        {
          localObject2 = BitmapFactory.decodeResource(this.e.getResources(), 2130843506);
          localObject1 = localObject2;
          localObject2 = ImageUtil.b((Bitmap)localObject2, 10.0F, 140, 140);
          localObject1 = localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.c, 2, QLog.getStackTraceString(localOutOfMemoryError));
          }
        }
        Context localContext = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ContactUtils.a(this.d, this.ah.b, str2));
        localStringBuilder.append(HardCodeUtil.a(2131901451));
        str2 = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131901450));
        localStringBuilder.append(str1);
        this.bm = DialogUtil.a(localContext, (Bitmap)localObject1, str2, localStringBuilder.toString(), this.e.getString(2131916601), null, new DiscussChatPie.2(this, str1), null);
        if ((this.bm != null) && (!this.f.isFinishing())) {
          this.bm.show();
        }
        localDiscussionManager.a.remove(this.ah.b);
      }
    }
  }
  
  private void bB()
  {
    Intent localIntent = new Intent(this.f, DiscussionInfoCardActivity.class);
    localIntent.putExtra("uin", this.ah.b);
    localIntent.putExtra("uinname", this.ah.e);
    localIntent.putExtra("uintype", this.ah.a);
    if ((1000 == this.ah.a) || (1004 == this.ah.a)) {
      localIntent.putExtra("troop_uin", this.ah.c);
    }
    this.f.startActivityForResult(localIntent, 2000);
  }
  
  private void bz()
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)this.d.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    DiscussionInfo localDiscussionInfo = localDiscussionManager.d(this.ah.b);
    if ((localDiscussionInfo != null) && (localDiscussionInfo.discussionName != null))
    {
      this.ah.e = localDiscussionInfo.discussionName;
      a(this.ah.e, localDiscussionInfo.uin, this.C);
    }
    if (localDiscussionManager.a.containsKey(this.ah.b)) {
      bA();
    }
  }
  
  private void e(String paramString)
  {
    Intent localIntent = AIOUtils.a(new Intent(this.f, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("input_text", this.Y.getEditableText().toString());
    localIntent.putExtra("input_panel_status", this.n.getCurrentPanel());
    this.f.startActivity(localIntent);
  }
  
  private void i(Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("result");
    } else {
      paramIntent = "";
    }
    if ((paramIntent != null) && (!paramIntent.equals("")))
    {
      if (NetworkUtil.isNetSupport(aX()))
      {
        ((DiscussionHandler)this.d.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(Long.valueOf(this.ah.b).longValue(), paramIntent);
        return;
      }
      QQToast.makeText(this.e, this.e.getString(2131892157), 0).show(A());
    }
  }
  
  private void j(Intent paramIntent)
  {
    String str2 = paramIntent.getExtras().getString("member_uin");
    Object localObject = paramIntent.getExtras().getString("member_display_name");
    if ((paramIntent.getExtras().getBoolean("isApollo")) && (this.aH != null))
    {
      String str1 = "0";
      if ("0".equals(str2)) {
        return;
      }
      paramIntent = ContactUtils.a(this.d, this.ah.b, str2);
      if (android.text.TextUtils.isEmpty(paramIntent)) {
        paramIntent = (Intent)localObject;
      }
      localObject = new StringBuilder("@");
      ((StringBuilder)localObject).append(paramIntent);
      this.aH.mAction.peerUin = str2;
      this.aH.mAction.atNickName = ((StringBuilder)localObject).toString();
      this.aH.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(this.Y.getText().toString());
      this.Y.getText().clear();
      a(this.aH);
      int i;
      if (android.text.TextUtils.isEmpty(this.aH.mAction.inputText))
      {
        if (!android.text.TextUtils.isEmpty(this.aH.mActionText))
        {
          if (this.aH.mTextType == 0)
          {
            i = 6;
            break label298;
          }
          if (this.aH.mTextType == 1)
          {
            i = 7;
            break label298;
          }
        }
        i = 2;
      }
      else if (android.text.TextUtils.isEmpty(this.aH.mActionText))
      {
        i = 3;
      }
      else if (this.aH.mTextType == 0)
      {
        i = 4;
      }
      else if (this.aH.mTextType == 1)
      {
        i = 5;
      }
      else
      {
        i = 0;
      }
      label298:
      localObject = this.d;
      str2 = this.ah.b;
      int j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.ah.a);
      paramIntent = new StringBuilder();
      paramIntent.append("");
      paramIntent.append(this.aH.mAction.actionId);
      String str3 = paramIntent.toString();
      paramIntent = new StringBuilder();
      paramIntent.append("655_");
      paramIntent.append(this.aH.mPackageId);
      String str4 = paramIntent.toString();
      if (android.text.TextUtils.isEmpty(this.aH.mActionText)) {
        paramIntent = str1;
      } else {
        paramIntent = this.aH.mActionText;
      }
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str2, i, j, new String[] { str3, str4, paramIntent, this.aH.mAction.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
    a(str2, (String)localObject, true);
  }
  
  public void B()
  {
    bB();
  }
  
  protected void D()
  {
    a(this.u, 2130852263, 2130852264);
  }
  
  public void K()
  {
    ActionSheet localActionSheet = this.bi;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      this.bi.dismiss();
    }
    this.bi = null;
    if (this.au != null) {
      this.au.v();
    }
    if (!android.text.TextUtils.isEmpty(this.ah.b)) {
      FileManagerDataCenter.b(this.d, this.ah.b, this.ah.a, -4021);
    }
    super.K();
  }
  
  public void O()
  {
    if (!this.aY)
    {
      TroopAioNavigateBarManager localTroopAioNavigateBarManager = (TroopAioNavigateBarManager)this.d.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      if (localTroopAioNavigateBarManager != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.ah.b);
        localStringBuilder.append("&");
        localStringBuilder.append(3000);
        localTroopAioNavigateBarManager.c(localStringBuilder.toString(), 0);
      }
    }
    super.O();
  }
  
  public void S()
  {
    super.S();
    bz();
  }
  
  protected void a()
  {
    this.j.d().a(this, this.o, this.V);
    this.au = ((TroopAioTips)this.j.d().e);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 6001)
      {
        if (paramInt1 != 6002) {
          return;
        }
        i(paramIntent);
        return;
      }
      j(paramIntent);
      return;
    }
    if (paramInt2 == 0)
    {
      if (paramInt1 != 6001) {
        return;
      }
      if (this.ah.z) {
        BaseChatpieHelper.a(this.ah, this.Y, this.Z, false);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.ah.e != null) {
      a(this.ah.e, this.ah.b, this.C);
    }
    super.a(paramConfiguration);
  }
  
  public void a(View paramView)
  {
    bB();
  }
  
  public void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "genDiscussTitle, name == null");
      }
      return;
    }
    int i = ((DiscussionManager)this.d.getManager(QQManagerFactory.DISCUSSION_MANAGER)).c(this.ah.b);
    paramString1 = new QQText(paramString1, 1);
    if (i <= 0)
    {
      paramTextView.setText(paramString1);
      if (AppSetting.e)
      {
        paramTextView.setContentDescription(paramTextView.getText().toString());
        aX().setTitle(paramTextView.getText());
      }
      return;
    }
    if (this.bl == null) {
      this.bl = ((TextView)this.q.findViewById(2131431971));
    }
    this.bl.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
    if (this.bl.getVisibility() != 0)
    {
      this.bl.setVisibility(0);
      if (this.p != null)
      {
        boolean bool = ((AudioPanelAioHelper)q(128)).i;
        this.p.a(bool ^ true, this.ah.a);
      }
    }
    paramTextView.setText(paramString1);
    if (AppSetting.e)
    {
      paramTextView.setContentDescription(paramTextView.getText().toString());
      aX().setTitle(paramTextView.getText());
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((!android.text.TextUtils.isEmpty(paramString1)) && (!android.text.TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("memUin:");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" displayName:");
        localStringBuilder.append(MessageRecordUtil.a(paramString2));
        localStringBuilder.append(" isRemoveOldAtFlag:");
        localStringBuilder.append(paramBoolean);
        QLog.d("_At_Me_DISC", 2, localStringBuilder.toString());
      }
      if ((this.n.getCurrentPanel() == 2) && (this.d.getApplication().getResources().getConfiguration().orientation == 2)) {
        this.n.b();
      }
      if (this.ah.z)
      {
        if ("0".equals(paramString1))
        {
          BaseChatpieHelper.a(this.ah, this.Y, this.Z, false);
          return;
        }
        this.ah.A = paramString1;
        this.j.f().b(131078);
        j(this.j.f().d());
        this.Z.setText(HardCodeUtil.a(2131901447));
        this.m.postDelayed(new DiscussChatPie.5(this), 200L);
        return;
      }
      this.m.postDelayed(new DiscussChatPie.6(this, paramBoolean, paramString1, paramString2), 300L);
      return;
    }
    if (this.ah.z) {
      BaseChatpieHelper.a(this.ah, this.Y, this.Z, false);
    }
  }
  
  public RecordParams.RecorderParam aU()
  {
    boolean bool = ((AudioPanelProvider)this.ae.f(2)).e();
    return RecordParams.b(this.d, bool);
  }
  
  protected void ap()
  {
    a();
    super.ap();
  }
  
  protected void au()
  {
    super.au();
    this.d.addDefaultObservers(this.bk);
    this.d.addObserver(this.bn);
    this.d.addObserver(this.bj);
  }
  
  protected void av()
  {
    super.av();
    this.d.removeObserver(this.bk);
    this.d.removeObserver(this.bn);
    this.d.removeObserver(this.bj);
  }
  
  protected HelperProvider b()
  {
    return new DiscussHelperProvider(this.f);
  }
  
  public void bf()
  {
    this.p.c();
  }
  
  protected void c(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      paramIntent = ContactUtils.a(this.d, this.ah.b, this.ah.c, ContactUtils.c(this.ah.a), 3);
    }
    this.ah.e = paramIntent;
    a(this.ah.e, this.ah.b, this.C);
    this.q.setOnClickListener(this);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    bf();
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new BaseTroopScroller()).a(new DiscussListUI(this.i)).a(new UnreadTask(this.i)).a();
  }
  
  protected void h()
  {
    this.c = "DiscussChatPie";
  }
  
  public void l(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("disscuss Uin : ");
      localStringBuilder.append(this.ah.b);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.d.getAVNotifyCenter().b(Long.valueOf(this.ah.b).longValue(), 2);
    if (localObject != null)
    {
      if (((AVNotifyCenter.VideoRoomInfo_tips)localObject).b) {
        ReportController.b(null, "CliOper", "", "", "0X80066C0", "0X80066C0", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X80066BD", "0X80066BD", 0, 0, "", "", "", "");
      }
      this.d.getAVNotifyCenter().c(Long.valueOf(this.ah.b).longValue(), 2);
    }
    super.l(paramInt);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.V != null)
    {
      if ((this.au != null) && (this.au.h())) {
        this.au.b(0);
      }
      super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131437281) {
      this.j.d().l();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  protected boolean p()
  {
    return (this.aL) || (super.p());
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {
      return;
    }
    if ((paramObject instanceof AioAgent.Message))
    {
      paramObservable = (AioAgent.Message)paramObject;
      if (paramObservable != null) {
        if (paramObservable.a == TroopAioAgent.a) {
          this.j.d().a(paramObservable.e, paramObservable.a(), paramObservable.f);
        } else if (paramObservable.a == TroopAioAgent.b) {
          ((AudioPanelAioHelper)q(128)).k(paramObservable.b);
        }
      }
    }
    else
    {
      boolean bool = paramObject instanceof Integer;
    }
    if ((paramObject instanceof MessageForText))
    {
      paramObservable = (MessageForText)paramObject;
      if (paramObservable.frienduin.equals(this.ah.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in DiscussChatPie.update()");
        }
        AioVipKeywordHelper.a().a(this.d, this.ah, paramObservable, paramObservable.msg, this.e, paramObservable.isSend());
      }
    }
  }
  
  protected void z()
  {
    this.A.setOnClickListener(new DiscussChatPie.1(this));
    if (AIOTopRightButtonConfig.a().b(this.d.getCurrentAccountUin()))
    {
      this.A.setVisibility(0);
      this.A.setContentDescription(this.f.getResources().getString(2131896551));
    }
    else
    {
      this.A.setVisibility(8);
    }
    bf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie
 * JD-Core Version:    0.7.0.1
 */