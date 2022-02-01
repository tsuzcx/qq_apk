package com.tencent.mobileqq.activity.aio.helper;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class SimpleUIAIOHelper
  implements View.OnClickListener, ILifeCycleHelper
{
  private int jdField_a_of_type_Int = -1;
  protected ImageButton a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected BaseChatPie a;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  protected ImageButton b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean = false;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  private int n;
  private int o = -1;
  private int p = -1;
  private int q = -1;
  
  public SimpleUIAIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private void a(RedTouch paramRedTouch)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(10);
      if (localRedTypeInfo != null) {
        paramRedTouch.a(localRedTypeInfo);
      }
    }
  }
  
  private void a(RedTouch paramRedTouch, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(4, String.valueOf(paramInt));
      if (localAppInfo != null) {
        paramRedTouch.a(localAppInfo);
      }
    }
  }
  
  private boolean a(View paramView)
  {
    if ((paramView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
      return (View)paramView.getParent() instanceof RedTouch;
    }
    return false;
  }
  
  private void h()
  {
    this.n = AIOUtils.a(4.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
    this.jdField_a_of_type_Boolean = a();
    b();
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void i() {}
  
  private void j() {}
  
  private void k() {}
  
  private void l() {}
  
  private void m()
  {
    a(new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton).b(8388661).a());
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      a(new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidWidgetImageButton).b(8388661).a(), 130105);
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      a(new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetImageButton).b(8388661).a(), 130101);
    }
  }
  
  private void p()
  {
    boolean bool = AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "reAdjustAnonymousStatusBar is called! isAnony = " + bool);
      }
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor())) {
        ImmersiveUtils.setStatusTextColor(false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow());
      }
    }
  }
  
  public int a()
  {
    return 2130838385;
  }
  
  protected void a()
  {
    this.jdField_f_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, new Object[] { "[initUi] ", Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean) });
    }
    Object localObject1;
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
          if (AppSetting.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131714115));
          }
        }
        if (this.jdField_b_of_type_AndroidWidgetImageButton == null) {
          break label826;
        }
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
        {
          this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
          if (AppSetting.jdField_d_of_type_Boolean) {
            this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131714112));
          }
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367665));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
          if (this.jdField_c_of_type_Int == -1) {
            this.jdField_c_of_type_Int = ((FrameLayout.LayoutParams)localObject1).leftMargin;
          }
          ((FrameLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c != null)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367664));
          localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).gravity = 80;
          if (this.o == -1) {
            this.o = ((LinearLayout.LayoutParams)localObject1).bottomMargin;
          }
          if ((this.jdField_a_of_type_AndroidWidgetImageButton != null) && (this.p == -1)) {
            this.p = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams()).bottomMargin;
          }
          if (this.p == -1) {
            break label879;
          }
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.p;
          if (QLog.isColorLevel()) {
            QLog.d("SimpleUIAIOHelper", 2, "initui() simple mode  bottomMargin 1 = " + ((LinearLayout.LayoutParams)localObject1).bottomMargin);
          }
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
          localLayoutParams = ((View)localObject1).getLayoutParams();
          localObject2 = localLayoutParams;
          if ((localLayoutParams instanceof FrameLayout.LayoutParams))
          {
            localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
            localObject2 = ((View)localObject1).getLayoutParams();
            if ((localObject1 instanceof RedTouch)) {
              a((RedTouch)localObject1);
            }
          }
          if ((localObject2 instanceof LinearLayout.LayoutParams))
          {
            localObject2 = (LinearLayout.LayoutParams)localObject2;
            if (this.jdField_d_of_type_Int == -1) {
              this.jdField_d_of_type_Int = ((LinearLayout.LayoutParams)localObject2).width;
            }
            if (this.jdField_e_of_type_Int == -1) {
              this.jdField_e_of_type_Int = ((LinearLayout.LayoutParams)localObject2).height;
            }
            ((LinearLayout.LayoutParams)localObject2).width = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131298191));
            ((LinearLayout.LayoutParams)localObject2).height = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131298191));
            ((LinearLayout.LayoutParams)localObject2).gravity = 16;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
            if (!this.jdField_e_of_type_Boolean) {
              break label903;
            }
            i1 = 2130838306;
            ((PatchedButton)localObject2).setBackgroundResource(i1);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText("");
            if (AppSetting.jdField_d_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131714122));
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
          }
          if (!(localObject1 instanceof RedTouch)) {
            m();
          }
        }
        if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
        {
          if (!a(this.jdField_a_of_type_AndroidWidgetImageButton)) {
            break label910;
          }
          localObject1 = (View)this.jdField_a_of_type_AndroidWidgetImageButton.getParent();
          ((View)localObject1).setVisibility(0);
          a((RedTouch)localObject1, 130101);
        }
        if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
        {
          if (!a(this.jdField_b_of_type_AndroidWidgetImageButton)) {
            break label917;
          }
          localObject1 = (View)this.jdField_b_of_type_AndroidWidgetImageButton.getParent();
          ((View)localObject1).setVisibility(0);
          a((RedTouch)localObject1, 130105);
        }
      }
    }
    label826:
    label879:
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof RobotChatPie))
    {
      for (;;)
      {
        int i1;
        return;
        localObject1 = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131362529);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)((ViewStub)localObject1).inflate());
          this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838316);
          this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          continue;
          localObject1 = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131362530);
          if (localObject1 != null)
          {
            this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)((ViewStub)localObject1).inflate());
            this.jdField_b_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838243);
            this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
            continue;
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131298190));
            continue;
            i1 = 2130838307;
            continue;
            o();
          }
        }
      }
      n();
      return;
    }
    label903:
    label910:
    label917:
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      if (a(this.jdField_a_of_type_AndroidWidgetImageButton)) {
        ((RedTouch)this.jdField_a_of_type_AndroidWidgetImageButton.getParent()).setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
    {
      if (a(this.jdField_b_of_type_AndroidWidgetImageButton)) {
        ((RedTouch)this.jdField_b_of_type_AndroidWidgetImageButton.getParent()).setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_c_of_type_Int != -1))
    {
      localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).leftMargin = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
      localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
        if ((localObject1 instanceof RedTouch)) {
          ((RedTouch)localObject1).d();
        }
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        if ((this.jdField_d_of_type_Int != -1) && (this.jdField_e_of_type_Int != -1))
        {
          ((LinearLayout.LayoutParams)localObject2).width = this.jdField_d_of_type_Int;
          ((LinearLayout.LayoutParams)localObject2).height = this.jdField_e_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
          ((LinearLayout.LayoutParams)localObject2).gravity = 8388693;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundResource(a());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(2131690891);
          if (AppSetting.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131714125));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) {
              break label1438;
            }
          }
        }
      }
    }
    label1438:
    for (boolean bool = true;; bool = false)
    {
      ((PatchedButton)localObject1).setEnabled(bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c == null) {
        break;
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367664));
      }
      localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).gravity = 80;
      if (this.o != -1) {
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.o;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "initui() simple mode  bottomMargin  2 = " + ((LinearLayout.LayoutParams)localObject1).bottomMargin);
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (paramInt == 2) && (this.jdField_a_of_type_AndroidWidgetImageButton != null)) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
      if (paramInt2 != 8) {
        break label99;
      }
      bool1 = true;
      ((PatchedButton)localObject).setSelected(bool1);
      localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
      if (paramInt2 != 3) {
        break label104;
      }
      bool1 = true;
      label53:
      ((ImageButton)localObject).setSelected(bool1);
      if (paramInt2 != 2) {
        break label109;
      }
    }
    label99:
    label104:
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(bool1);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        if (!bool1) {
          break label114;
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131714120));
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label53;
    }
    label114:
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131714127));
  }
  
  public void a(TextView paramTextView)
  {
    Object localObject;
    if (paramTextView != null)
    {
      localObject = paramTextView.getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        if (!this.jdField_a_of_type_Boolean) {
          break label70;
        }
        if (this.q == -1) {
          this.q = ((RelativeLayout.LayoutParams)localObject).leftMargin;
        }
        ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    return;
    label70:
    if (this.q != -1) {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.q;
    }
    paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void a(Boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {}
    for (localObject = ((ChatFragment)localObject).a;; localObject = null)
    {
      SimpleUIUtil.a((SystemBarCompact)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow(), paramBoolean);
      p();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(23);
    boolean bool = paramBoolean;
    if (localObject1 != null) {
      if (!((TroopRobotHelper)localObject1).b())
      {
        bool = paramBoolean;
        if (!this.jdField_f_of_type_Boolean) {}
      }
      else
      {
        bool = paramBoolean;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof BaseTroopChatPie)) {
          bool = true;
        }
      }
    }
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      if (!bool) {
        break label583;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundResource(a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(2131690891);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131714123));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        localObject1 = (LinearLayout.LayoutParams)localObject1;
        if (this.j == -1) {
          this.j = ((LinearLayout.LayoutParams)localObject1).leftMargin;
        }
        if (this.k == -1) {
          this.k = ((LinearLayout.LayoutParams)localObject1).rightMargin;
        }
        ((LinearLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(2.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        ((LinearLayout.LayoutParams)localObject1).rightMargin = AIOUtils.a(6.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
      localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
        if ((localObject1 instanceof RedTouch)) {
          ((RedTouch)localObject1).d();
        }
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        if (this.jdField_f_of_type_Int == -1) {
          this.jdField_f_of_type_Int = ((LinearLayout.LayoutParams)localObject2).rightMargin;
        }
        if (this.g == -1) {
          this.g = ((LinearLayout.LayoutParams)localObject2).leftMargin;
        }
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = 0;
        if ((this.jdField_f_of_type_Int != -1) && (this.g != -1) && (!this.jdField_c_of_type_Boolean))
        {
          ((LinearLayout.LayoutParams)localObject2).width = (((LinearLayout.LayoutParams)localObject2).width + this.jdField_f_of_type_Int + this.g + this.j + this.k - AIOUtils.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
          this.jdField_c_of_type_Boolean = true;
        }
        if (this.h == -1) {
          this.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getPaddingLeft();
        }
        if (this.i == -1) {
          this.i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getPaddingRight();
        }
        if (this.l == -1) {
          this.l = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getPaddingTop();
        }
        if (this.m == -1) {
          this.m = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getPaddingBottom();
        }
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(0, this.n, 0, this.n);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    return;
    label583:
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
    if (this.jdField_e_of_type_Boolean) {}
    for (int i1 = 2130838306;; i1 = 2130838307)
    {
      ((PatchedButton)localObject1).setBackgroundResource(i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText("");
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131714118));
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        localObject1 = (LinearLayout.LayoutParams)localObject1;
        if (this.j != -1) {
          ((LinearLayout.LayoutParams)localObject1).leftMargin = this.j;
        }
        if (this.k != -1) {
          ((LinearLayout.LayoutParams)localObject1).rightMargin = this.k;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
      localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
        if ((localObject1 instanceof RedTouch)) {
          a((RedTouch)localObject1);
        }
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        if (this.jdField_f_of_type_Int != -1) {
          ((LinearLayout.LayoutParams)localObject2).rightMargin = this.jdField_f_of_type_Int;
        }
        if (this.g != -1) {
          ((LinearLayout.LayoutParams)localObject2).leftMargin = this.g;
        }
        if ((this.g != -1) && (this.jdField_f_of_type_Int != -1) && (this.jdField_c_of_type_Boolean))
        {
          ((LinearLayout.LayoutParams)localObject2).width = (((LinearLayout.LayoutParams)localObject2).width - this.jdField_f_of_type_Int - this.g - (this.j + this.k - AIOUtils.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources())));
          this.jdField_c_of_type_Boolean = false;
        }
        if ((this.h != -1) && (this.i != -1) && (this.m != -1) && (this.l != -1)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.h, this.l, this.i, this.m);
        }
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      return;
    }
  }
  
  protected boolean a()
  {
    return SimpleUIUtil.a();
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i2 = 2130838306;
    boolean bool = true;
    Object localObject = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(23);
    if ((localObject != null) && ((((TroopRobotHelper)localObject).b()) || (this.jdField_f_of_type_Boolean))) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((a()) && (this.jdField_b_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "onClickFunBtn() simple mode fun_btn isSend = " + paramBoolean);
        }
        if (!paramBoolean) {
          break label185;
        }
        if (i1 == 0)
        {
          if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
            this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
          }
          if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
            this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
          if (!this.jdField_e_of_type_Boolean) {
            break label178;
          }
        }
      }
      label178:
      for (i1 = 2130838306;; i1 = 2130838307)
      {
        ((PatchedButton)localObject).setBackgroundResource(i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText("");
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setSelected(false);
        return;
      }
      label185:
      if (!this.jdField_d_of_type_Boolean)
      {
        paramBoolean = bool;
        this.jdField_d_of_type_Boolean = paramBoolean;
        if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
          this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
        }
        if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
          this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
        if (!this.jdField_e_of_type_Boolean) {
          break label299;
        }
      }
      label299:
      for (i1 = i2;; i1 = 2130838307)
      {
        ((PatchedButton)localObject).setBackgroundResource(i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText("");
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setSelected(this.jdField_d_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(Integer.valueOf(8));
        return;
        paramBoolean = false;
        break;
      }
    }
  }
  
  public void c()
  {
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (a()) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
      int i1 = AIOUtils.a(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
      if ((this.jdField_a_of_type_Int == -1) || (this.jdField_b_of_type_Int == -1))
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop();
        this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingBottom();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), i1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), i1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c != null)
      {
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367664));
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.gravity = 80;
        if (this.o == -1) {
          this.o = localLayoutParams.bottomMargin;
        }
        if ((this.jdField_a_of_type_AndroidWidgetImageButton != null) && (this.p == -1)) {
          this.p = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams()).bottomMargin;
        }
        if (this.p == -1) {
          break label321;
        }
        localLayoutParams.bottomMargin = this.p;
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "setSimpleUIMode() simple mode  bottomMargin 1 = " + localLayoutParams.bottomMargin);
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      return;
      label321:
      localLayoutParams.bottomMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131298190));
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.jdField_a_of_type_Int != -1) && (this.jdField_b_of_type_Int != -1))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), this.jdField_b_of_type_Int);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.D) {
          break label554;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d(AIOUtils.a(1.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c != null)
      {
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367664));
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.gravity = 80;
        if (this.o != -1) {
          localLayoutParams.bottomMargin = this.o;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "setSimpleUIMode() simple mode  bottomMargin 2 = " + localLayoutParams.bottomMargin);
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
        return;
        label554:
        ThreadManager.executeOnSubThread(new DecodeAIOInputBitmapHeightTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie), true);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "switchAnonymousChat is called! isAnonymousChat = " + paramBoolean);
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
        if (!paramBoolean) {
          break label143;
        }
        i1 = 2130838315;
        ((ImageButton)localObject).setBackgroundResource(i1);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
        if (!paramBoolean) {
          break label150;
        }
        i1 = 2130838238;
        label106:
        ((ImageButton)localObject).setBackgroundResource(i1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
        if (!paramBoolean) {
          break label157;
        }
      }
    }
    label143:
    label150:
    label157:
    for (int i1 = 2130838306;; i1 = 2130838307)
    {
      ((PatchedButton)localObject).setBackgroundResource(i1);
      return;
      i1 = 2130838316;
      break;
      i1 = 2130838243;
      break label106;
    }
  }
  
  boolean c()
  {
    TroopRobotHelper localTroopRobotHelper = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(23);
    return (localTroopRobotHelper != null) && ((localTroopRobotHelper.b()) || (this.jdField_f_of_type_Boolean));
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367664));
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "adjustInputLayout  bottomMargin  = " + localLayoutParams.bottomMargin);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (a()) && (this.jdField_b_of_type_Boolean))
    {
      if (this.p != -1) {}
      for (localLayoutParams.bottomMargin = this.p;; localLayoutParams.bottomMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131298190)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "adjustInputLayout() simple mode  bottomMargin 1 = " + localLayoutParams.bottomMargin);
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
        return;
      }
    }
    localLayoutParams.gravity = 80;
    if (this.o != -1) {
      localLayoutParams.bottomMargin = this.o;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "adjustInputLayout() simple mode  bottomMargin 2 = " + localLayoutParams.bottomMargin);
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "onCreate() called");
    }
    a();
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent() instanceof RedTouch))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(paramBoolean);
    }
  }
  
  public void f()
  {
    View localView = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
    RedTouchManager localRedTouchManager;
    Object localObject;
    int i1;
    if (((localView instanceof RedTouch)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getText())))
    {
      localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (localObject == null) {
        break label117;
      }
      localObject = ((SessionInfo)localObject).b;
      if (localObject == null) {
        break label111;
      }
      i1 = 11;
    }
    for (;;)
    {
      localObject = localRedTouchManager.a(i1, (String)localObject, ((PlusRedPointHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(89)).a());
      ((RedTouch)localView).a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
      return;
      label111:
      i1 = 10;
      continue;
      label117:
      localObject = null;
      i1 = 10;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "onResume() called");
    }
    c();
  }
  
  public String getTag()
  {
    return "SimpleUIAIOHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 2, 3, 4, 6, 8, 9, 10, 14 };
  }
  
  public void onClick(View paramView)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "onClick() not in simple mode");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      case 2131367663: 
      default: 
        break;
      case 2131363092: 
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "onClick() audio_btn");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(Integer.valueOf(2));
        this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
        this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
        break;
      case 2131366225: 
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "onClick() emo_btn");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(Integer.valueOf(3));
        this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
        this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(true);
      }
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 7: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return;
    case 2: 
      h();
      return;
    case 3: 
      e();
      return;
    case 6: 
      g();
    case 8: 
      l();
      return;
    case 9: 
      k();
      return;
    case 10: 
      i();
      return;
    }
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SimpleUIAIOHelper
 * JD-Core Version:    0.7.0.1
 */