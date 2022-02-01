package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.RobotChatUIHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.robotchat.RobotChatPanelLayout;
import com.tencent.mobileqq.robotchat.RobotChatTipLayout;
import com.tencent.mobileqq.robotchat.RobotChatTipLayout.RobotChatTipLayoutListener;
import com.tencent.mobileqq.robotchat.RobotChatUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class RobotChatPie
  extends FriendChatPie
  implements Handler.Callback, RobotChatTipLayout.RobotChatTipLayoutListener
{
  public RobotChatPanelLayout a;
  private RobotChatTipLayout a;
  private View n;
  
  public RobotChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private boolean F()
  {
    boolean bool1 = false;
    int j = 0;
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
    {
      int i = j;
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a()) {
            i = 1;
          }
        }
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
      }
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a())
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
        bool2 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "checkConsumeBackEvent, comsumed:" + bool2);
    }
    return bool2;
  }
  
  private void bj()
  {
    if (SharedPreUtils.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {}
    while (!(this.jdField_a_of_type_AndroidViewView instanceof ViewGroup)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = new RobotChatTipLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.a(this);
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout, 0);
  }
  
  private void bk()
  {
    Object localObject = (ViewGroup)this.jdField_e_of_type_AndroidWidgetTextView.getParent();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a();
    localObject = (ImageView)this.c.findViewById(2131379480);
    if (localObject != null)
    {
      ((ImageView)localObject).setImageDrawable(RobotChatUtil.a(this.jdField_a_of_type_AndroidContentContext));
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(23);
    if (localObject != null) {
      ((TroopRobotHelper)localObject).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.b();
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController = null;
    }
  }
  
  public void C()
  {
    super.C();
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.setRobotName(e());
    }
  }
  
  public boolean E()
  {
    return false;
  }
  
  public void J()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "doOnDestroy:");
    }
    TroopRobotHelper localTroopRobotHelper = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(23);
    if (localTroopRobotHelper != null) {
      localTroopRobotHelper.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout);
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.a();
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = null;
    }
    if ((this.n != null) && (this.n.getParent() != null))
    {
      ((ViewGroup)this.n.getParent()).removeView(this.n);
      this.n = null;
    }
    super.J();
  }
  
  public void P()
  {
    super.P();
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)a(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.b())) {
      localRobotChatUIHelper.a(this.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public void R()
  {
    super.R();
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)a(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.b())) {
      localRobotChatUIHelper.a(a());
    }
  }
  
  public void Y()
  {
    super.Y();
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)a(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.b())) {
      localRobotChatUIHelper.a(a());
    }
  }
  
  public BaseChatDrawer a()
  {
    return null;
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    bj();
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.setRobotName(e());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, e(), this, new RobotChatPie.1(this));
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    TroopRobotHelper localTroopRobotHelper = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(23);
    if ((localTroopRobotHelper != null) && (localTroopRobotHelper.a(paramMotionEvent, this.G))) {
      return;
    }
    super.a(paramMotionEvent);
  }
  
  public void a(RobotChatTipLayout paramRobotChatTipLayout)
  {
    SharedPreUtils.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, true);
    if ((this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) && (this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ViewGroup)))
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout);
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.a();
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = null;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A486", "0X800A486", 0, 0, "", "", "", "");
  }
  
  public boolean a(boolean paramBoolean)
  {
    return super.a(paramBoolean);
  }
  
  public void aY() {}
  
  public void ad()
  {
    super.ad();
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "onShow_otherThings:");
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      super.afterTextChanged(paramEditable);
      if (this.jdField_a_of_type_Int == 0)
      {
        paramEditable = (RobotChatUIHelper)a(36);
        if ((paramEditable != null) && (paramEditable.b())) {
          paramEditable.a(bool);
        }
      }
      return;
    }
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new RobotChatPie.2(this));
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_e_of_type_AndroidViewView != null) {
      super.b(paramBoolean1, paramBoolean2);
    }
    TroopRobotHelper localTroopRobotHelper;
    do
    {
      return;
      super.b(paramBoolean1, paramBoolean2);
      localTroopRobotHelper = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(23);
    } while (localTroopRobotHelper == null);
    localTroopRobotHelper.a(this.jdField_e_of_type_AndroidViewView);
  }
  
  public void bf()
  {
    super.bf();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(this);
  }
  
  public void c()
  {
    this.b = "RobotChatPie";
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)a(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.b())) {
      localRobotChatUIHelper.a(paramInt1, paramInt2);
    }
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    paramIntent = paramIntent.getBundleExtra("key_invoke_troop_robot_function");
    TroopRobotHelper localTroopRobotHelper = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(23);
    if (localTroopRobotHelper != null) {
      localTroopRobotHelper.a(paramIntent);
    }
  }
  
  public void d(int paramInt)
  {
    super.d(paramInt);
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)a(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.b())) {
      localRobotChatUIHelper.d();
    }
  }
  
  public String e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    }
    return null;
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "leftBackEvent begin:" + paramBoolean);
    }
    if (paramBoolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "no confirm dialog");
    }
    super.e(paramBoolean);
  }
  
  public boolean f()
  {
    return false;
  }
  
  public void g()
  {
    super.g();
    bk();
  }
  
  public boolean g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "onBackEvent begin");
    }
    if (F()) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "no confirm dialog");
    }
    return super.g();
  }
  
  public void h(int paramInt)
  {
    super.h(paramInt);
    TroopRobotHelper localTroopRobotHelper = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(23);
    if (localTroopRobotHelper != null) {
      localTroopRobotHelper.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)a(36);
      if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.b())) {
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0)
        {
          localRobotChatUIHelper.b(false);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A487", "0X800A487", 0, 0, "", "", "", "");
        }
        else
        {
          localRobotChatUIHelper.b(true);
        }
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, " onTextChanged:  start=" + paramInt1 + " before=" + paramInt2 + " count=" + paramInt3);
    }
    paramCharSequence = (TroopRobotHelper)a(23);
    if (paramCharSequence != null) {
      paramCharSequence.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount());
    }
  }
  
  public void r() {}
  
  public void v()
  {
    if (this.d != null)
    {
      this.d.setVisibility(4);
      ThreadManager.post(new RobotChatPie.3(this), 5, null, false);
    }
  }
  
  public void z()
  {
    RobotUtils.a(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    ReportController.b(null, "dc00898", "", "", "0X800A48B", "0X800A48B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie
 * JD-Core Version:    0.7.0.1
 */