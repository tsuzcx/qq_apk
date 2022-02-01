package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

public class AudioPanelProvider
  implements PanelProvider<AudioPanel>
{
  protected AudioPanel a;
  public boolean b = false;
  boolean c = false;
  public boolean d = false;
  public boolean e = false;
  private BaseChatPie f;
  private final QQAppInterface g;
  private boolean h = true;
  
  public AudioPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.f = paramBaseChatPie;
    this.g = paramBaseChatPie.d;
  }
  
  private void a(FriendsManager paramFriendsManager)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "setNoC2CLastAudioPanelType chatPie is null");
      }
      return;
    }
    localObject = paramFriendsManager.b(((BaseChatPie)localObject).ah.b, this.f.ah.a, false);
    if ((localObject == null) && (!paramFriendsManager.m())) {
      ThreadManager.getSubThreadHandler().post(new AudioPanelProvider.1(this, paramFriendsManager));
    }
    if ((localObject != null) && (((NoC2CExtensionInfo)localObject).audioPanelType != -1)) {
      this.a.setCurrentPannel(((NoC2CExtensionInfo)localObject).audioPanelType, false);
    }
  }
  
  private void a(FriendsManager paramFriendsManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "showAudioPanelIfNeedForC2C chatPie is null");
      }
      return;
    }
    localObject = paramFriendsManager.d(((BaseChatPie)localObject).ah.b, false);
    paramFriendsManager = (FriendsManager)localObject;
    if (localObject == null) {
      if (this.f.aH() != null)
      {
        paramFriendsManager = this.f.aH();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioPanelProvider", 2, "showAudioPanelIfNeed | ExtensionInfo = null");
        }
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showAudioPanelIfNeedForC2C extInfo.chatInputType = ");
      ((StringBuilder)localObject).append(paramFriendsManager.chatInputType);
      ((StringBuilder)localObject).append(" extInfo.showC2CPanel = ");
      ((StringBuilder)localObject).append(paramFriendsManager.showC2CPanel);
      QLog.d("AudioPanelProvider", 2, ((StringBuilder)localObject).toString());
    }
    if (paramFriendsManager.chatInputType != 2) {
      return;
    }
    if (paramFriendsManager.showC2CPanel == 1) {
      b(paramBoolean1, paramBoolean2);
    }
  }
  
  public static int b(int paramInt)
  {
    int i = 3;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3)
      {
        if (paramInt != 4) {
          return 0;
        }
      }
      else {
        return 2;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  private void b(FriendsManager paramFriendsManager)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "setC2CLastAudioPanelType chatPie is null");
      }
      return;
    }
    localObject = paramFriendsManager.d(((BaseChatPie)localObject).ah.b, false);
    if ((localObject == null) && (!paramFriendsManager.m())) {
      ThreadManager.getSubThreadHandler().post(new AudioPanelProvider.2(this, paramFriendsManager));
    }
    if ((localObject != null) && (((ExtensionInfo)localObject).audioPanelType != -1)) {
      this.a.setCurrentPannel(((ExtensionInfo)localObject).audioPanelType, false);
    }
  }
  
  private void b(FriendsManager paramFriendsManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "showAudioPanelIfNeedForNoC2C chatPie is null");
      }
      return;
    }
    localObject = paramFriendsManager.b(((BaseChatPie)localObject).ah.b, this.f.ah.a, false);
    paramFriendsManager = (FriendsManager)localObject;
    if (localObject == null) {
      if (this.f.aI() != null)
      {
        paramFriendsManager = this.f.aI();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioPanelProvider", 2, "showAudioPanelIfNeed | NoC2CExtensionInfo = null");
        }
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showAudioPanelIfNeedForNoC2C noC2CExtInfo.chatInputType = ");
      ((StringBuilder)localObject).append(paramFriendsManager.chatInputType);
      ((StringBuilder)localObject).append(" noC2CExtInfo.showC2CPanel = ");
      ((StringBuilder)localObject).append(paramFriendsManager.showC2CPanel);
      QLog.d("AudioPanelProvider", 2, ((StringBuilder)localObject).toString());
    }
    if (paramFriendsManager.chatInputType != 2) {
      return;
    }
    if (paramFriendsManager.showC2CPanel == 1) {
      b(paramBoolean1, paramBoolean2);
    }
  }
  
  private boolean j()
  {
    BaseChatPie localBaseChatPie = this.f;
    if (localBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "shouldShowAudioPanel chatPie is null");
      }
      return false;
    }
    return (localBaseChatPie.ah.a != 1008) && (!this.f.aL());
  }
  
  public AudioPanel a()
  {
    return this.a;
  }
  
  public AudioPanel a(Context paramContext)
  {
    if (this.f == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OpenPanel", 1, "createPanel chatPie is null");
      }
      return null;
    }
    long l = System.currentTimeMillis();
    this.a = ((AudioPanel)View.inflate(this.f.e, 2131627262, null));
    paramContext = this.a;
    QQAppInterface localQQAppInterface = this.g;
    BaseChatPie localBaseChatPie = this.f;
    paramContext.a(localQQAppInterface, localBaseChatPie, localBaseChatPie.ah, this.f.X, this.f.W);
    a(-1);
    if (((ReceiptHelper)this.f.q(118)).a) {
      this.a.setReceiptMode(true);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("OpenAudioPanel:");
      paramContext.append(System.currentTimeMillis() - l);
      QLog.d("AudioPanelProvider", 2, paramContext.toString());
    }
    return this.a;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "setLastAudioPanelType chatPie is null");
      }
      return;
    }
    if (((localObject instanceof TroopChatPie)) && (((TroopChatPie)localObject).bG()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPanelProvider", 2, "setLastAudioPanelType isAnonymousChat return");
      }
      return;
    }
    localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (this.b) {
      return;
    }
    if (paramInt != -1)
    {
      ((AudioPanel)localObject).setCurrentPannel(paramInt, false);
      return;
    }
    localObject = (FriendsManager)this.g.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((this.f.ah.a != 3000) && (this.f.ah.a != 1))
    {
      if (this.f.aK()) {
        b((FriendsManager)localObject);
      }
    }
    else {
      a((FriendsManager)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.h = (this.b ^ true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "showAudioPanelIfNeed chatPie is null");
      }
      return;
    }
    if (BaseChatItemLayout.ad) {
      return;
    }
    if (this.f.bs()) {
      return;
    }
    Object localObject = (FriendsManager)this.g.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (!((FriendsManager)localObject).m())
    {
      ThreadManager.executeOnSubThread(new AudioPanelProvider.4(this));
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.f.ah.a != 3000) && (this.f.ah.a != 1)) {
      a((FriendsManager)localObject, paramBoolean1, paramBoolean2);
    } else {
      b((FriendsManager)localObject, paramBoolean1, paramBoolean2);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showAudioPanelIfNeed cost :");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject).append(" isCallFromOnShow = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" guide = ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("AudioPanelProvider", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b()
  {
    if (this.a != null)
    {
      this.c = true;
      this.a = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    BaseChatPie localBaseChatPie = this.f;
    if (localBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "showAudioPanel chatPie is null");
      }
      return;
    }
    localBaseChatPie.bm().a(2, paramBoolean);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      if ((paramBoolean2) && (j()))
      {
        b(false);
        this.e = false;
      }
      if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.aio_input.name()))
      {
        if (((this.a == null) || (this.e)) && (j()))
        {
          b(false);
          this.e = false;
        }
      }
      else {
        this.e = true;
      }
    }
    else if ((this.e) && (j()))
    {
      b(true);
      this.e = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initAudioPanelFlag needShowAudioWhenResume  = ");
      localStringBuilder.append(this.e);
      QLog.d("AudioPanelProvider", 2, localStringBuilder.toString());
    }
  }
  
  public void c()
  {
    if (this.f == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "doOnAIOShowonUpdateUI chatPie is null");
      }
      return;
    }
    if ((this.e) && (!this.d))
    {
      if (!this.h)
      {
        b(true, false);
        this.a.setCurrentPannel(0, true);
        this.h = true;
      }
      else
      {
        a(true, false);
      }
      this.e = false;
    }
  }
  
  public boolean d()
  {
    if (this.d) {
      return false;
    }
    if (this.b)
    {
      b(false, false);
      if (!this.e)
      {
        this.a.setCurrentPannel(0, true);
        this.h = true;
      }
      return false;
    }
    return true;
  }
  
  public final boolean e()
  {
    AudioPanel localAudioPanel = this.a;
    return (localAudioPanel != null) && (localAudioPanel.getCurrentItem() == 0);
  }
  
  public boolean f()
  {
    AudioPanel localAudioPanel = this.a;
    return (localAudioPanel != null) && (localAudioPanel.getVisibility() == 0);
  }
  
  public boolean g()
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "checkAudioPanelConsumeBackEvent chatPie is null");
      }
      return false;
    }
    if (((BaseChatPie)localObject).bm().getCurrentPanel() == 2)
    {
      localObject = this.a;
      if ((localObject != null) && (((AudioPanel)localObject).a())) {
        return true;
      }
    }
    return false;
  }
  
  public int getPanelId()
  {
    return 2;
  }
  
  public void h()
  {
    AudioPanel localAudioPanel = this.a;
    if (localAudioPanel != null)
    {
      localAudioPanel.c();
      this.a.d();
    }
  }
  
  public void i()
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "doOnPause chatPie is null");
      }
      return;
    }
    if (((BaseChatPie)localObject).bm().getCurrentPanel() == 2)
    {
      localObject = this.a;
      if (localObject != null) {
        ((AudioPanel)localObject).b();
      }
    }
  }
  
  public boolean isNeedRecreatePanel()
  {
    if (this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPanelProvider", 2, "recreate audio panel due to receipt message");
      }
      this.c = false;
      return true;
    }
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 2) && (paramInt2 != 2)) {
      AudioPanelAioHelper.a = false;
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "onPanelIconClick chatPie is null");
      }
      return;
    }
    if ((localObject instanceof TroopChatPie))
    {
      localObject = (TroopChatPie)localObject;
      if (((TroopChatPie)localObject).bG()) {
        ReportController.b(this.g, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_PTT", 0, 0, ((TroopChatPie)localObject).ah.b, "", "", "");
      }
      AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)((TroopChatPie)localObject).q(52);
      AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(25);
      AudioPanelAioHelper localAudioPanelAioHelper = (AudioPanelAioHelper)this.f.q(128);
      if ((localAIOShortcutBarHelper != null) && (localAudioPanelAioHelper != null) && (localAudioPanelAioHelper.j != null)) {
        localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
      }
      if (localAIOShortcutBarEvent.a().getBoolean("mIsShowRobotIcon", false)) {
        new ReportTask(this.g).a("dc00899").b("Grp_robot").c("send_msg").d("voice_icon_clk").a(0).a(new String[] { ((TroopChatPie)localObject).ah.b, localAIOShortcutBarEvent.a().getString("mCurrentRobotUin") }).a();
      }
    }
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (this.f.aX().checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      this.f.aX().requestPermissions(new AudioPanelProvider.3(this, paramXPanelContainer), 2, new String[] { "android.permission.RECORD_AUDIO" });
      return;
    }
    AudioTransitionAnimManager.a().a(this.f.e);
    paramXPanelContainer.a(2);
    AIOPanelUtiles.a(this.g, "0X8005CAC", this.f.ah.a);
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    if (this.f == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "postOnPanelChanged chatPie is null");
      }
      return;
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((AudioPanel)localObject).a(paramInt1, paramInt2);
    }
    if ((paramInt1 == 2) && (paramInt2 != 2))
    {
      localObject = this.a;
      if (localObject != null) {
        ((AudioPanel)localObject).c();
      }
    }
    if ((paramInt1 != 2) && (paramInt2 == 2)) {
      ((AudioPanelAioHelper)this.f.q(128)).e = 0;
    }
    localObject = this.f;
    if (((localObject instanceof TroopChatPie)) && (paramInt2 == 2) && (((TroopChatPie)localObject).bG())) {
      this.a.a(0);
    }
    if (((this.f instanceof PublicAccountChatPie)) && (paramInt2 == 2) && (this.a != null) && (paramInt1 != 2) && (AIOInputTypeHelper.b(this.g))) {
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider
 * JD-Core Version:    0.7.0.1
 */