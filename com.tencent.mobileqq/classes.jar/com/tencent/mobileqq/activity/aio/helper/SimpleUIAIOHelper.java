package com.tencent.mobileqq.activity.aio.helper;

import android.content.res.Resources;
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
import androidx.fragment.app.FragmentManager;
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
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
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
  
  private void a(RedTouch paramRedTouch, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(4, String.valueOf(paramInt));
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
    this.n = AIOUtils.b(4.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
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
    new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton).b(8388661).a();
    f();
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reAdjustAnonymousStatusBar is called! isAnony = ");
        localStringBuilder.append(bool);
        QLog.d("SimpleUIAIOHelper", 2, localStringBuilder.toString());
      }
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor())) {
        ImmersiveUtils.setStatusTextColor(false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow());
      }
    }
  }
  
  public int a()
  {
    return 2130838215;
  }
  
  protected void a()
  {
    boolean bool = false;
    this.jdField_f_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, new Object[] { "[initUi] ", Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean) });
    }
    Object localObject1;
    Object localObject2;
    int i1;
    Object localObject3;
    ViewGroup.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (localObject1 != null)
      {
        ((ImageButton)localObject1).setVisibility(0);
      }
      else
      {
        localObject1 = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131362485);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)((ViewStub)localObject1).inflate());
          this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838141);
          this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (localObject1 != null)
      {
        ((ImageButton)localObject1).setSelected(false);
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131714044));
        }
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageButton;
      if (localObject1 != null)
      {
        ((ImageButton)localObject1).setVisibility(0);
      }
      else
      {
        localObject1 = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131362486);
        if (localObject1 != null)
        {
          this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)((ViewStub)localObject1).inflate());
          this.jdField_b_of_type_AndroidWidgetImageButton.setBackgroundResource(2130838079);
          this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
        }
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageButton;
      if (localObject1 != null)
      {
        ((ImageButton)localObject1).setSelected(false);
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131714041));
        }
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367419));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
        if (this.jdField_c_of_type_Int == -1) {
          this.jdField_c_of_type_Int = ((FrameLayout.LayoutParams)localObject1).leftMargin;
        }
        ((FrameLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c != null)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367418));
        localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).gravity = 80;
        if (this.o == -1) {
          this.o = ((LinearLayout.LayoutParams)localObject1).bottomMargin;
        }
        localObject2 = this.jdField_a_of_type_AndroidWidgetImageButton;
        if ((localObject2 != null) && (this.p == -1)) {
          this.p = ((LinearLayout.LayoutParams)((ImageButton)localObject2).getLayoutParams()).bottomMargin;
        }
        i1 = this.p;
        if (i1 != -1) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = i1;
        } else {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131298185));
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("initui() simple mode  bottomMargin 1 = ");
          ((StringBuilder)localObject2).append(((LinearLayout.LayoutParams)localObject1).bottomMargin);
          QLog.d("SimpleUIAIOHelper", 2, ((StringBuilder)localObject2).toString());
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
        localObject3 = ((View)localObject1).getLayoutParams();
        localObject2 = localObject3;
        if ((localObject3 instanceof FrameLayout.LayoutParams))
        {
          localObject3 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
          localLayoutParams = ((View)localObject3).getLayoutParams();
          localObject1 = localObject3;
          localObject2 = localLayoutParams;
          if ((localObject3 instanceof RedTouch))
          {
            f();
            localObject2 = localLayoutParams;
            localObject1 = localObject3;
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
          ((LinearLayout.LayoutParams)localObject2).width = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131298186));
          ((LinearLayout.LayoutParams)localObject2).height = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131298186));
          ((LinearLayout.LayoutParams)localObject2).gravity = 16;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
          if (this.jdField_e_of_type_Boolean) {
            i1 = 2130838131;
          } else {
            i1 = 2130838132;
          }
          ((PatchedButton)localObject2).setBackgroundResource(i1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText("");
          if (AppSetting.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131714051));
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
        }
        if (!(localObject1 instanceof RedTouch)) {
          m();
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (localObject1 != null) {
        if (a((View)localObject1))
        {
          localObject1 = (View)this.jdField_a_of_type_AndroidWidgetImageButton.getParent();
          ((View)localObject1).setVisibility(0);
          a((RedTouch)localObject1, 130101);
        }
        else
        {
          o();
        }
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageButton;
      if (localObject1 != null)
      {
        if (a((View)localObject1))
        {
          localObject1 = (View)this.jdField_b_of_type_AndroidWidgetImageButton.getParent();
          ((View)localObject1).setVisibility(0);
          a((RedTouch)localObject1, 130105);
          return;
        }
        n();
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof RobotChatPie)) {
        return;
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (localObject1 != null)
      {
        if (a((View)localObject1)) {
          ((RedTouch)this.jdField_a_of_type_AndroidWidgetImageButton.getParent()).setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageButton;
      if (localObject1 != null)
      {
        if (a((View)localObject1)) {
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
        localObject3 = ((View)localObject1).getLayoutParams();
        localObject2 = localObject3;
        if ((localObject3 instanceof FrameLayout.LayoutParams))
        {
          localObject3 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
          localLayoutParams = ((View)localObject3).getLayoutParams();
          localObject1 = localObject3;
          localObject2 = localLayoutParams;
          if ((localObject3 instanceof RedTouch))
          {
            ((RedTouch)localObject3).d();
            localObject2 = localLayoutParams;
            localObject1 = localObject3;
          }
        }
        if ((localObject2 instanceof LinearLayout.LayoutParams))
        {
          localObject2 = (LinearLayout.LayoutParams)localObject2;
          i1 = this.jdField_d_of_type_Int;
          if (i1 != -1)
          {
            int i2 = this.jdField_e_of_type_Int;
            if (i2 != -1)
            {
              ((LinearLayout.LayoutParams)localObject2).width = i1;
              ((LinearLayout.LayoutParams)localObject2).height = i2;
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
              ((LinearLayout.LayoutParams)localObject2).gravity = 8388693;
              ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundResource(a());
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(2131690820);
              if (AppSetting.jdField_d_of_type_Boolean) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131714054));
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {
                  bool = true;
                }
                ((PatchedButton)localObject1).setEnabled(bool);
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c != null)
      {
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367418));
        }
        localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).gravity = 80;
        i1 = this.o;
        if (i1 != -1) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = i1;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("initui() simple mode  bottomMargin  2 = ");
          ((StringBuilder)localObject2).append(((LinearLayout.LayoutParams)localObject1).bottomMargin);
          QLog.d("SimpleUIAIOHelper", 2, ((StringBuilder)localObject2).toString());
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (paramInt == 2))
    {
      ImageButton localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (localImageButton != null) {
        localImageButton.setSelected(false);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
      boolean bool2 = true;
      boolean bool1;
      if (paramInt2 == 8) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((PatchedButton)localObject).setSelected(bool1);
      localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
      if (paramInt2 == 3) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((ImageButton)localObject).setSelected(bool1);
      if (paramInt2 == 2) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(bool1);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        if (bool1)
        {
          this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131714049));
          return;
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131714056));
      }
    }
  }
  
  public void a(TextView paramTextView)
  {
    if (paramTextView != null)
    {
      Object localObject = paramTextView.getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        if (this.jdField_a_of_type_Boolean)
        {
          if (this.q == -1) {
            this.q = ((RelativeLayout.LayoutParams)localObject).leftMargin;
          }
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
          paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          return;
        }
        int i1 = this.q;
        if (i1 != -1) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = i1;
        }
        paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {
      localObject = ((ChatFragment)localObject).a;
    } else {
      localObject = null;
    }
    SimpleUIUtil.a((SystemBarCompact)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow(), paramBoolean);
    p();
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
    int i1;
    if ((((AIOShortcutBarHelper)localObject1).c() == 0) && (((AIOShortcutBarHelper)localObject1).d() == 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool = paramBoolean;
    if (localObject1 != null)
    {
      bool = paramBoolean;
      if (i1 != 0)
      {
        bool = paramBoolean;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof BaseTroopChatPie)) {
          bool = true;
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      Object localObject3;
      Object localObject2;
      ViewGroup.LayoutParams localLayoutParams;
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundResource(a());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(2131690820);
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131714052));
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
          ((LinearLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(2.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
          ((LinearLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(6.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
        localObject3 = ((View)localObject1).getLayoutParams();
        localObject2 = localObject3;
        if ((localObject3 instanceof FrameLayout.LayoutParams))
        {
          localObject3 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
          localLayoutParams = ((View)localObject3).getLayoutParams();
          localObject2 = localLayoutParams;
          localObject1 = localObject3;
          if ((localObject3 instanceof RedTouch))
          {
            ((RedTouch)localObject3).d();
            localObject1 = localObject3;
            localObject2 = localLayoutParams;
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
            ((LinearLayout.LayoutParams)localObject2).width = (((LinearLayout.LayoutParams)localObject2).width + this.jdField_f_of_type_Int + this.g + this.j + this.k - AIOUtils.b(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()));
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
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
          i1 = this.n;
          ((PatchedButton)localObject3).setPadding(0, i1, 0, i1);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
        if (this.jdField_e_of_type_Boolean) {
          i1 = 2130838131;
        } else {
          i1 = 2130838132;
        }
        ((PatchedButton)localObject1).setBackgroundResource(i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText("");
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131714047));
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        if ((localObject1 instanceof LinearLayout.LayoutParams))
        {
          localObject1 = (LinearLayout.LayoutParams)localObject1;
          i1 = this.j;
          if (i1 != -1) {
            ((LinearLayout.LayoutParams)localObject1).leftMargin = i1;
          }
          i1 = this.k;
          if (i1 != -1) {
            ((LinearLayout.LayoutParams)localObject1).rightMargin = i1;
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
        localObject3 = ((View)localObject2).getLayoutParams();
        localObject1 = localObject3;
        if ((localObject3 instanceof FrameLayout.LayoutParams))
        {
          localObject3 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
          localLayoutParams = ((View)localObject3).getLayoutParams();
          localObject1 = localLayoutParams;
          localObject2 = localObject3;
          if ((localObject3 instanceof RedTouch))
          {
            f();
            localObject2 = localObject3;
            localObject1 = localLayoutParams;
          }
        }
        if ((localObject1 instanceof LinearLayout.LayoutParams))
        {
          localObject1 = (LinearLayout.LayoutParams)localObject1;
          i1 = this.jdField_f_of_type_Int;
          if (i1 != -1) {
            ((LinearLayout.LayoutParams)localObject1).rightMargin = i1;
          }
          i1 = this.g;
          if (i1 != -1) {
            ((LinearLayout.LayoutParams)localObject1).leftMargin = i1;
          }
          if ((this.g != -1) && (this.jdField_f_of_type_Int != -1) && (this.jdField_c_of_type_Boolean))
          {
            ((LinearLayout.LayoutParams)localObject1).width = (((LinearLayout.LayoutParams)localObject1).width - this.jdField_f_of_type_Int - this.g - (this.j + this.k - AIOUtils.b(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources())));
            this.jdField_c_of_type_Boolean = false;
          }
          if ((this.h != -1) && (this.i != -1) && (this.m != -1) && (this.l != -1)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.h, this.l, this.i, this.m);
          }
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      }
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
    Object localObject = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
    int i1;
    if ((((AIOShortcutBarHelper)localObject).c() == 0) && (((AIOShortcutBarHelper)localObject).d() == 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((localObject != null) && ((i1 != 0) || (this.jdField_f_of_type_Boolean))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((a()) && (this.jdField_b_of_type_Boolean))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClickFunBtn() simple mode fun_btn isSend = ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("SimpleUIAIOHelper", 2, ((StringBuilder)localObject).toString());
      }
      int i2 = 2130838131;
      if (paramBoolean)
      {
        if (i1 == 0)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
          if (localObject != null) {
            ((ImageButton)localObject).setSelected(false);
          }
          localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
          if (localObject != null) {
            ((ImageButton)localObject).setSelected(false);
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
          if (!this.jdField_e_of_type_Boolean) {
            i2 = 2130838132;
          }
          ((PatchedButton)localObject).setBackgroundResource(i2);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText("");
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setSelected(false);
        }
      }
      else
      {
        this.jdField_d_of_type_Boolean ^= true;
        localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
        if (localObject != null) {
          ((ImageButton)localObject).setSelected(false);
        }
        localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
        if (localObject != null) {
          ((ImageButton)localObject).setSelected(false);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
        if (!this.jdField_e_of_type_Boolean) {
          i2 = 2130838132;
        }
        ((PatchedButton)localObject).setBackgroundResource(i2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText("");
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setSelected(this.jdField_d_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(8);
      }
    }
  }
  
  public void c()
  {
    int i1;
    Object localObject1;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (a()) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
      i1 = AIOUtils.b(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
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
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367418));
        }
        localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).gravity = 80;
        if (this.o == -1) {
          this.o = ((LinearLayout.LayoutParams)localObject1).bottomMargin;
        }
        localObject2 = this.jdField_a_of_type_AndroidWidgetImageButton;
        if ((localObject2 != null) && (this.p == -1)) {
          this.p = ((LinearLayout.LayoutParams)((ImageButton)localObject2).getLayoutParams()).bottomMargin;
        }
        i1 = this.p;
        if (i1 != -1) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = i1;
        } else {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131298185));
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("setSimpleUIMode() simple mode  bottomMargin 1 = ");
          ((StringBuilder)localObject2).append(((LinearLayout.LayoutParams)localObject1).bottomMargin);
          QLog.d("SimpleUIAIOHelper", 2, ((StringBuilder)localObject2).toString());
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.jdField_a_of_type_Int != -1) && (this.jdField_b_of_type_Int != -1))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), this.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.x)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
          ((BaseChatPie)localObject1).b(AIOUtils.b(1.0F, ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()));
        }
        else
        {
          ThreadManager.executeOnSubThread(new DecodeAIOInputBitmapHeightTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie), true);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c != null)
      {
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367418));
        }
        localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).gravity = 80;
        i1 = this.o;
        if (i1 != -1) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = i1;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("setSimpleUIMode() simple mode  bottomMargin 2 = ");
          ((StringBuilder)localObject2).append(((LinearLayout.LayoutParams)localObject1).bottomMargin);
          QLog.d("SimpleUIAIOHelper", 2, ((StringBuilder)localObject2).toString());
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("switchAnonymousChat is called! isAnonymousChat = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("SimpleUIAIOHelper", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
      int i1;
      if (localObject != null)
      {
        if (paramBoolean) {
          i1 = 2130838140;
        } else {
          i1 = 2130838141;
        }
        ((ImageButton)localObject).setBackgroundResource(i1);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
      if (localObject != null)
      {
        if (paramBoolean) {
          i1 = 2130838077;
        } else {
          i1 = 2130838079;
        }
        ((ImageButton)localObject).setBackgroundResource(i1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
        if (paramBoolean) {
          i1 = 2130838131;
        } else {
          i1 = 2130838132;
        }
        ((PatchedButton)localObject).setBackgroundResource(i1);
      }
    }
  }
  
  boolean c()
  {
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
    int i1 = localAIOShortcutBarHelper.c();
    boolean bool2 = false;
    if ((i1 == 0) && (localAIOShortcutBarHelper.d() == 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool1 = bool2;
    if (localAIOShortcutBarHelper != null) {
      if (i1 == 0)
      {
        bool1 = bool2;
        if (!this.jdField_f_of_type_Boolean) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367418));
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjustInputLayout  bottomMargin  = ");
      localStringBuilder.append(localLayoutParams.bottomMargin);
      QLog.d("SimpleUIAIOHelper", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (a()) && (this.jdField_b_of_type_Boolean))
    {
      i1 = this.p;
      if (i1 != -1) {
        localLayoutParams.bottomMargin = i1;
      } else {
        localLayoutParams.bottomMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131298185));
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("adjustInputLayout() simple mode  bottomMargin 1 = ");
        localStringBuilder.append(localLayoutParams.bottomMargin);
        QLog.d("SimpleUIAIOHelper", 2, localStringBuilder.toString());
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      return;
    }
    localLayoutParams.gravity = 80;
    int i1 = this.o;
    if (i1 != -1) {
      localLayoutParams.bottomMargin = i1;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjustInputLayout() simple mode  bottomMargin 2 = ");
      localStringBuilder.append(localLayoutParams.bottomMargin);
      QLog.d("SimpleUIAIOHelper", 2, localStringBuilder.toString());
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
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
    if (localObject != null) {
      ((ImageButton)localObject).setEnabled(paramBoolean);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
    if (localObject != null) {
      ((ImageButton)localObject).setEnabled(paramBoolean);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentWidgetPatchedButton != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent() instanceof RedTouch))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(paramBoolean);
    }
  }
  
  public void f()
  {
    View localView = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
    if (((localView instanceof RedTouch)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getText())))
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
      Object localObject1 = null;
      int i2 = 10;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      int i1 = i2;
      if (localObject2 != null)
      {
        localObject2 = ((SessionInfo)localObject2).b;
        localObject1 = localObject2;
        i1 = i2;
        if (localObject2 != null)
        {
          i1 = 11;
          localObject1 = localObject2;
        }
      }
      localObject1 = localIRedTouchManager.getRedTouchInfoByAppSet(i1, (String)localObject1, ((PlusRedPointHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(89)).a());
      ((RedTouch)localView).a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
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
    return new int[] { 2, 3, 4, 7, 9, 10, 11, 15 };
  }
  
  public void onClick(View paramView)
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "onClick() not in simple mode");
      }
    }
    else
    {
      int i1 = paramView.getId();
      if (i1 != 2131363032)
      {
        if (i1 == 2131366114)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SimpleUIAIOHelper", 2, "onClick() emo_btn");
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(3);
          this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
          this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(true);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "onClick() audio_btn");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(2);
        this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
        this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if ((paramInt != 4) && (paramInt != 5))
        {
          if (paramInt != 7) {
            if (paramInt == 15) {}
          }
          switch (paramInt)
          {
          default: 
            return;
          case 11: 
            i();
            return;
          case 10: 
            k();
            return;
            j();
            return;
            g();
          }
          l();
        }
      }
      else {
        e();
      }
    }
    else {
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SimpleUIAIOHelper
 * JD-Core Version:    0.7.0.1
 */