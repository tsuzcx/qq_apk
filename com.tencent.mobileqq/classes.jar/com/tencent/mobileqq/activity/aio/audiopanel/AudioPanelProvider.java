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
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public boolean a;
  boolean b = false;
  public boolean c = false;
  public boolean d = false;
  private boolean e = true;
  
  public AudioPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public static int a(int paramInt)
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
  
  private void a(FriendsManager paramFriendsManager)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "setNoC2CLastAudioPanelType chatPie is null");
      }
      return;
    }
    localObject = paramFriendsManager.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    if ((localObject == null) && (!paramFriendsManager.d())) {
      ThreadManager.getSubThreadHandler().post(new AudioPanelProvider.1(this, paramFriendsManager));
    }
    if ((localObject != null) && (((NoC2CExtensionInfo)localObject).audioPanelType != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(((NoC2CExtensionInfo)localObject).audioPanelType, false);
    }
  }
  
  private void a(FriendsManager paramFriendsManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "showAudioPanelIfNeedForC2C chatPie is null");
      }
      return;
    }
    localObject = paramFriendsManager.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    paramFriendsManager = (FriendsManager)localObject;
    if (localObject == null) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null)
      {
        paramFriendsManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
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
  
  private void b(FriendsManager paramFriendsManager)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "setC2CLastAudioPanelType chatPie is null");
      }
      return;
    }
    localObject = paramFriendsManager.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    if ((localObject == null) && (!paramFriendsManager.d())) {
      ThreadManager.getSubThreadHandler().post(new AudioPanelProvider.2(this, paramFriendsManager));
    }
    if ((localObject != null) && (((ExtensionInfo)localObject).audioPanelType != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(((ExtensionInfo)localObject).audioPanelType, false);
    }
  }
  
  private void b(FriendsManager paramFriendsManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "showAudioPanelIfNeedForNoC2C chatPie is null");
      }
      return;
    }
    localObject = paramFriendsManager.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    paramFriendsManager = (FriendsManager)localObject;
    if (localObject == null) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null)
      {
        paramFriendsManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
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
  
  private boolean e()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "shouldShowAudioPanel chatPie is null");
      }
      return false;
    }
    return (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.j());
  }
  
  public AudioPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  }
  
  public AudioPanel a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OpenPanel", 1, "createPanel chatPie is null");
      }
      return null;
    }
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = ((AudioPanel)View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131560921, null));
    paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    paramContext.a(localQQAppInterface, localBaseChatPie, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
    a(-1);
    if (((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(118)).jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setReceiptMode(true);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("OpenAudioPanel:");
      paramContext.append(System.currentTimeMillis() - l);
      QLog.d("AudioPanelProvider", 2, paramContext.toString());
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
    {
      this.b = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = null;
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "setLastAudioPanelType chatPie is null");
      }
      return;
    }
    if (((localObject instanceof TroopChatPie)) && (((TroopChatPie)localObject).v()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPanelProvider", 2, "setLastAudioPanelType isAnonymousChat return");
      }
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
    if (localObject == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt != -1)
    {
      ((AudioPanel)localObject).setCurrentPannel(paramInt, false);
      return;
    }
    localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.i()) {
        b((FriendsManager)localObject);
      }
    }
    else {
      a((FriendsManager)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.e = (this.jdField_a_of_type_Boolean ^ true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "showAudioPanelIfNeed chatPie is null");
      }
      return;
    }
    if (BaseChatItemLayout.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.r()) {
      return;
    }
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (!((FriendsManager)localObject).d())
    {
      ThreadManager.executeOnSubThread(new AudioPanelProvider.4(this));
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
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
  
  public boolean a()
  {
    if (this.c) {
      return false;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      b(false, false);
      if (!this.d)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(0, true);
        this.e = true;
      }
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "doOnAIOShowonUpdateUI chatPie is null");
      }
      return;
    }
    if ((this.d) && (!this.c))
    {
      if (!this.e)
      {
        b(true, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(0, true);
        this.e = true;
      }
      else
      {
        a(true, false);
      }
      this.d = false;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "showAudioPanel chatPie is null");
      }
      return;
    }
    localBaseChatPie.a().a(2, paramBoolean);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      if ((paramBoolean2) && (e()))
      {
        b(false);
        this.d = false;
      }
      if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.aio_input.name()))
      {
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) || (this.d)) && (e()))
        {
          b(false);
          this.d = false;
        }
      }
      else {
        this.d = true;
      }
    }
    else if ((this.d) && (e()))
    {
      b(true);
      this.d = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initAudioPanelFlag needShowAudioWhenResume  = ");
      localStringBuilder.append(this.d);
      QLog.d("AudioPanelProvider", 2, localStringBuilder.toString());
    }
  }
  
  public final boolean b()
  {
    AudioPanel localAudioPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
    return (localAudioPanel != null) && (localAudioPanel.a() == 0);
  }
  
  public void c()
  {
    AudioPanel localAudioPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
    if (localAudioPanel != null)
    {
      localAudioPanel.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.c();
    }
  }
  
  public boolean c()
  {
    AudioPanel localAudioPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
    return (localAudioPanel != null) && (localAudioPanel.getVisibility() == 0);
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "doOnPause chatPie is null");
      }
      return;
    }
    if (((BaseChatPie)localObject).a().a() == 2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
      if (localObject != null) {
        ((AudioPanel)localObject).a();
      }
    }
  }
  
  public boolean d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "checkAudioPanelConsumeBackEvent chatPie is null");
      }
      return false;
    }
    if (((BaseChatPie)localObject).a().a() == 2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
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
  
  public boolean isNeedRecreatePanel()
  {
    if (this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPanelProvider", 2, "recreate audio panel due to receipt message");
      }
      this.b = false;
      return true;
    }
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 2) && (paramInt2 != 2)) {
      AudioPanelAioHelper.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
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
      if (((TroopChatPie)localObject).v()) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_PTT", 0, 0, ((TroopChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
      AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)((TroopChatPie)localObject).a(52);
      AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(25);
      AudioPanelAioHelper localAudioPanelAioHelper = (AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128);
      if ((localAIOShortcutBarHelper != null) && (localAudioPanelAioHelper != null) && (localAudioPanelAioHelper.jdField_a_of_type_AndroidViewView != null)) {
        localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
      }
      if (localAIOShortcutBarEvent.a().getBoolean("mIsShowRobotIcon", false)) {
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_icon_clk").a(0).a(new String[] { ((TroopChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localAIOShortcutBarEvent.a().getString("mCurrentRobotUin") }).a();
      }
    }
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().requestPermissions(new AudioPanelProvider.3(this, paramXPanelContainer), 2, new String[] { "android.permission.RECORD_AUDIO" });
      return;
    }
    AudioTransitionAnimManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext);
    paramXPanelContainer.a(2);
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CAC", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioPanelProvider", 1, "postOnPanelChanged chatPie is null");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
    if (localObject != null) {
      ((AudioPanel)localObject).a(paramInt1, paramInt2);
    }
    if ((paramInt1 == 2) && (paramInt2 != 2))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
      if (localObject != null) {
        ((AudioPanel)localObject).b();
      }
    }
    if ((paramInt1 != 2) && (paramInt2 == 2)) {
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (((localObject instanceof TroopChatPie)) && (paramInt2 == 2) && (((TroopChatPie)localObject).v())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(0);
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof PublicAccountChatPie)) && (paramInt2 == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (paramInt1 != 2) && (AIOInputTypeHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider
 * JD-Core Version:    0.7.0.1
 */