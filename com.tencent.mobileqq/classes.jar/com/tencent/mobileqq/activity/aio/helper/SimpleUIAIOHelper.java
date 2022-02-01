package com.tencent.mobileqq.activity.aio.helper;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;

public class SimpleUIAIOHelper
  implements View.OnClickListener, ILifeCycleHelper
{
  private final int A = 150;
  private final int B = 0;
  private final int C = 45;
  private boolean D = false;
  private boolean E = false;
  private long F = 0L;
  private boolean G = false;
  private boolean H = false;
  private int I = -1;
  private int J;
  private int K;
  private int L;
  private int M;
  private int a = -1;
  private int b = -1;
  protected BaseChatPie c;
  boolean d;
  protected ImageButton e;
  protected ImageButton f;
  boolean g = false;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  private LinearLayout o;
  private int p = -1;
  private int q = -1;
  private int r = -1;
  private int s = -1;
  private int t;
  private int u = -1;
  private int v = -1;
  private LinearLayout w;
  private Animation x;
  private Animation y;
  private final Interpolator z = new LinearInterpolator();
  
  public SimpleUIAIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
  }
  
  private void a(RedTouch paramRedTouch, int paramInt)
  {
    if (this.c.ah.a == 0)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.c.d.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(4, String.valueOf(paramInt));
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
  
  private void e()
  {
    this.t = AIOUtils.b(4.0F, this.c.f.getResources());
    this.d = c();
    b();
    this.D = false;
  }
  
  private void f(boolean paramBoolean)
  {
    if (QQTheme.isNowSimpleUI()) {
      this.E = paramBoolean;
    }
  }
  
  private void h() {}
  
  private void i() {}
  
  private void j() {}
  
  private void k() {}
  
  private void r()
  {
    if (this.x == null) {
      t();
    }
    if (this.y == null) {
      s();
    }
  }
  
  private void s()
  {
    this.y = new RotateAnimation(45.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.y.setInterpolator(this.z);
    this.y.setDuration(150L);
    this.y.setRepeatCount(0);
    this.y.setFillAfter(true);
  }
  
  private void t()
  {
    this.x = new RotateAnimation(0.0F, 45.0F, 1, 0.5F, 1, 0.5F);
    this.x.setInterpolator(this.z);
    this.x.setDuration(150L);
    this.x.setRepeatCount(0);
    this.x.setFillAfter(true);
  }
  
  private void u()
  {
    new RedTouch(this.c.e, this.c.Z).c(8388661).a();
    m();
  }
  
  private void v()
  {
    if (this.c.ah.a == 0) {
      a(new RedTouch(this.c.e, this.f).c(8388661).a(), 130105);
    }
  }
  
  private void w()
  {
    if (this.c.ah.a == 0) {
      a(new RedTouch(this.c.e, this.e).c(8388661).a(), 130101);
    }
  }
  
  private void x()
  {
    if (QQTheme.isNowSimpleUI())
    {
      r();
      if (this.E)
      {
        if (this.c.Z.getAnimation() != this.x) {
          this.c.Z.startAnimation(this.x);
        }
      }
      else if (this.c.Z.getAnimation() == this.x) {
        this.c.Z.startAnimation(this.y);
      }
    }
  }
  
  private void y()
  {
    if (QQTheme.isNowSimpleUI())
    {
      r();
      if (this.c.Z.getAnimation() == this.x)
      {
        this.c.Z.startAnimation(this.y);
        return;
      }
      this.c.Z.clearAnimation();
    }
  }
  
  private void z()
  {
    XEditTextEx localXEditTextEx = this.c.Y;
    if (this.c.X != null)
    {
      if (localXEditTextEx == null) {
        return;
      }
      Resources localResources = this.c.f.getResources();
      boolean bool = QQTheme.isNowSimpleUI();
      int i1;
      if (bool) {
        i1 = 2131298880;
      } else {
        i1 = 2131298877;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localXEditTextEx.getLayoutParams();
      localMarginLayoutParams.leftMargin = localResources.getDimensionPixelSize(i1);
      localXEditTextEx.setLayoutParams(localMarginLayoutParams);
      if (bool) {
        i1 = 2131298881;
      } else {
        i1 = 2131298878;
      }
      localXEditTextEx.setPadding(localResources.getDimensionPixelSize(i1), localXEditTextEx.getPaddingTop(), localXEditTextEx.getPaddingRight(), localXEditTextEx.getPaddingBottom());
      if (bool) {
        i1 = 2131298882;
      } else {
        i1 = 2131298879;
      }
      localXEditTextEx.setMinHeight(localResources.getDimensionPixelSize(i1));
    }
  }
  
  protected void a()
  {
    boolean bool = false;
    this.H = false;
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, new Object[] { "[initUi] ", Boolean.valueOf(this.d), Boolean.valueOf(this.g) });
    }
    if (QQTheme.isNowSimpleUI())
    {
      t();
      s();
    }
    Object localObject1;
    Object localObject2;
    int i1;
    Object localObject3;
    ViewGroup.LayoutParams localLayoutParams;
    if ((this.c.X != null) && (this.d) && (this.g))
    {
      localObject1 = this.e;
      if (localObject1 != null)
      {
        ((ImageButton)localObject1).setVisibility(0);
      }
      else
      {
        localObject1 = (ViewStub)this.c.X.findViewById(2131428094);
        if (localObject1 != null)
        {
          this.e = ((ImageButton)((ViewStub)localObject1).inflate());
          this.e.setBackgroundResource(2130838184);
          this.e.setOnClickListener(this);
        }
      }
      localObject1 = this.e;
      if (localObject1 != null)
      {
        ((ImageButton)localObject1).setSelected(false);
        if (AppSetting.e) {
          this.e.setContentDescription(HardCodeUtil.a(2131911575));
        }
      }
      localObject1 = this.f;
      if (localObject1 != null)
      {
        ((ImageButton)localObject1).setVisibility(0);
      }
      else
      {
        localObject1 = (ViewStub)this.c.X.findViewById(2131428095);
        if (localObject1 != null)
        {
          this.f = ((ImageButton)((ViewStub)localObject1).inflate());
          this.f.setBackgroundResource(2130838122);
          this.f.setOnClickListener(this);
        }
      }
      localObject1 = this.f;
      if (localObject1 != null)
      {
        ((ImageButton)localObject1).setSelected(false);
        if (AppSetting.e) {
          this.f.setContentDescription(HardCodeUtil.a(2131911572));
        }
      }
      this.o = ((LinearLayout)this.c.aZ.findViewById(2131433922));
      if (this.c.Y != null)
      {
        localObject1 = (FrameLayout.LayoutParams)this.c.Y.getLayoutParams();
        if (this.h == -1) {
          this.h = ((FrameLayout.LayoutParams)localObject1).leftMargin;
        }
        ((FrameLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(8.0F, this.c.f.getResources());
        this.c.Y.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (this.c.aZ != null)
      {
        this.w = ((LinearLayout)this.c.aZ.findViewById(2131433921));
        localObject1 = (LinearLayout.LayoutParams)this.w.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).gravity = 80;
        if (this.u == -1) {
          this.u = ((LinearLayout.LayoutParams)localObject1).bottomMargin;
        }
        localObject2 = this.e;
        if ((localObject2 != null) && (this.v == -1)) {
          this.v = ((LinearLayout.LayoutParams)((ImageButton)localObject2).getLayoutParams()).bottomMargin;
        }
        i1 = this.v;
        if (i1 != -1) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = i1;
        } else {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)this.c.f.getResources().getDimension(2131298884));
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("initui() simple mode  bottomMargin 1 = ");
          ((StringBuilder)localObject2).append(((LinearLayout.LayoutParams)localObject1).bottomMargin);
          QLog.d("SimpleUIAIOHelper", 2, ((StringBuilder)localObject2).toString());
        }
        this.w.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (this.c.Z != null)
      {
        localObject1 = this.c.Z;
        localObject3 = ((View)localObject1).getLayoutParams();
        localObject2 = localObject3;
        if ((localObject3 instanceof FrameLayout.LayoutParams))
        {
          localObject3 = (View)this.c.Z.getParent();
          localLayoutParams = ((View)localObject3).getLayoutParams();
          localObject1 = localObject3;
          localObject2 = localLayoutParams;
          if ((localObject3 instanceof RedTouch))
          {
            m();
            localObject2 = localLayoutParams;
            localObject1 = localObject3;
          }
        }
        if ((localObject2 instanceof LinearLayout.LayoutParams))
        {
          localObject2 = (LinearLayout.LayoutParams)localObject2;
          if (this.i == -1) {
            this.i = ((LinearLayout.LayoutParams)localObject2).width;
          }
          if (this.j == -1) {
            this.j = ((LinearLayout.LayoutParams)localObject2).height;
          }
          ((LinearLayout.LayoutParams)localObject2).width = ((int)this.c.f.getResources().getDimension(2131298885));
          ((LinearLayout.LayoutParams)localObject2).height = ((int)this.c.f.getResources().getDimension(2131298885));
          ((LinearLayout.LayoutParams)localObject2).gravity = 16;
          this.c.Z.setVisibility(0);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = this.c.Z;
          if (this.G) {
            i1 = 2130838174;
          } else {
            i1 = 2130838175;
          }
          ((PatchedButton)localObject2).setBackgroundResource(i1);
          this.c.Z.setText("");
          if (AppSetting.e) {
            this.c.Z.setContentDescription(HardCodeUtil.a(2131911582));
          }
          this.c.Z.setEnabled(true);
        }
        if (!(localObject1 instanceof RedTouch)) {
          u();
        }
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        if (a((View)localObject1))
        {
          localObject1 = (View)this.e.getParent();
          ((View)localObject1).setVisibility(0);
          a((RedTouch)localObject1, 130101);
        }
        else
        {
          w();
        }
      }
      localObject1 = this.f;
      if (localObject1 != null)
      {
        if (a((View)localObject1))
        {
          localObject1 = (View)this.f.getParent();
          ((View)localObject1).setVisibility(0);
          a((RedTouch)localObject1, 130105);
          return;
        }
        v();
      }
    }
    else
    {
      if ((this.c instanceof RobotChatPie)) {
        return;
      }
      localObject1 = this.e;
      if (localObject1 != null)
      {
        if (a((View)localObject1)) {
          ((RedTouch)this.e.getParent()).setVisibility(8);
        }
        this.e.setVisibility(8);
      }
      localObject1 = this.f;
      if (localObject1 != null)
      {
        if (a((View)localObject1)) {
          ((RedTouch)this.f.getParent()).setVisibility(8);
        }
        this.f.setVisibility(8);
      }
      if (this.c.Z != null) {
        this.c.Z.setVisibility(0);
      }
      if ((this.c.Y != null) && (this.h != -1))
      {
        localObject1 = (FrameLayout.LayoutParams)this.c.Y.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).leftMargin = this.h;
        this.c.Y.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (this.c.Z != null)
      {
        localObject1 = this.c.Z;
        localObject3 = ((View)localObject1).getLayoutParams();
        localObject2 = localObject3;
        if ((localObject3 instanceof FrameLayout.LayoutParams))
        {
          localObject3 = (View)this.c.Z.getParent();
          localLayoutParams = ((View)localObject3).getLayoutParams();
          localObject1 = localObject3;
          localObject2 = localLayoutParams;
          if ((localObject3 instanceof RedTouch))
          {
            ((RedTouch)localObject3).g();
            localObject2 = localLayoutParams;
            localObject1 = localObject3;
          }
        }
        if ((localObject2 instanceof LinearLayout.LayoutParams))
        {
          localObject2 = (LinearLayout.LayoutParams)localObject2;
          i1 = this.i;
          if (i1 != -1)
          {
            int i2 = this.j;
            if (i2 != -1)
            {
              ((LinearLayout.LayoutParams)localObject2).width = i1;
              ((LinearLayout.LayoutParams)localObject2).height = i2;
              this.c.Z.setVisibility(0);
              ((LinearLayout.LayoutParams)localObject2).gravity = 8388693;
              ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              this.c.Z.setBackgroundResource(g());
              this.c.Z.setText(2131887750);
              if (AppSetting.e) {
                this.c.Z.setContentDescription(HardCodeUtil.a(2131911585));
              }
              if (this.c.Y != null)
              {
                localObject1 = this.c.Z;
                if (this.c.Y.getText().length() > 0) {
                  bool = true;
                }
                ((PatchedButton)localObject1).setEnabled(bool);
              }
            }
          }
        }
      }
      if (this.c.aZ != null)
      {
        if (this.w == null) {
          this.w = ((LinearLayout)this.c.aZ.findViewById(2131433921));
        }
        localObject1 = (LinearLayout.LayoutParams)this.w.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).gravity = 80;
        i1 = this.u;
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
        this.w.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.g) && (this.d))
    {
      boolean bool2 = true;
      boolean bool1;
      if (paramInt2 == 8) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.c.Z.setSelected(bool1);
      f(bool1);
      if (!bool1) {
        y();
      } else {
        x();
      }
      ImageButton localImageButton = this.f;
      if (paramInt2 == 3) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localImageButton.setSelected(bool1);
      if (paramInt2 == 2) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.e.setSelected(bool1);
      if (AppSetting.e)
      {
        if (bool1)
        {
          this.e.setContentDescription(HardCodeUtil.a(2131911580));
          return;
        }
        this.e.setContentDescription(HardCodeUtil.a(2131911587));
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
        if (this.d)
        {
          if (this.I == -1) {
            this.I = ((RelativeLayout.LayoutParams)localObject).leftMargin;
          }
          float f1;
          if (QQTheme.isNowSimpleUI()) {
            f1 = 16.0F;
          } else {
            f1 = 14.0F;
          }
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(f1, this.c.f.getResources());
          paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          return;
        }
        int i1 = this.I;
        if (i1 != -1) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = i1;
        }
        paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    this.c.f.getChatFragment();
  }
  
  protected void b()
  {
    if ((this.c.ah.a == 0) || (this.c.ah.a == 1) || (this.c.ah.a == 3000)) {
      this.g = true;
    }
  }
  
  public void b(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    Object localObject = paramTextView.getLayoutParams();
    if (!(localObject instanceof RelativeLayout.LayoutParams)) {
      return;
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    float f1;
    if (QQTheme.isNowSimpleUI()) {
      f1 = 33.0F;
    } else {
      f1 = 28.0F;
    }
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(f1, this.c.f.getResources());
    paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = (AIOShortcutBarHelper)this.c.q(52);
    int i1;
    if ((((AIOShortcutBarHelper)localObject).v() == 0) && (((AIOShortcutBarHelper)localObject).x() == 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((localObject != null) && ((i1 != 0) || (this.H))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((c()) && (this.g))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClickFunBtn() simple mode fun_btn isSend = ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("SimpleUIAIOHelper", 2, ((StringBuilder)localObject).toString());
      }
      int i2 = 2130838174;
      if (paramBoolean)
      {
        if (i1 == 0)
        {
          localObject = this.e;
          if (localObject != null) {
            ((ImageButton)localObject).setSelected(false);
          }
          localObject = this.f;
          if (localObject != null) {
            ((ImageButton)localObject).setSelected(false);
          }
          localObject = this.c.Z;
          if (!this.G) {
            i2 = 2130838175;
          }
          ((PatchedButton)localObject).setBackgroundResource(i2);
          this.c.Z.setText("");
          this.c.Z.setSelected(false);
        }
      }
      else
      {
        this.E ^= true;
        localObject = this.e;
        if (localObject != null) {
          ((ImageButton)localObject).setSelected(false);
        }
        localObject = this.f;
        if (localObject != null) {
          ((ImageButton)localObject).setSelected(false);
        }
        localObject = this.c.Z;
        if (!this.G) {
          i2 = 2130838175;
        }
        ((PatchedButton)localObject).setBackgroundResource(i2);
        this.c.Z.setText("");
        this.c.Z.setSelected(this.E);
        x();
        if (this.E)
        {
          this.c.a(8);
          this.c.Y.clearFocus();
          return;
        }
        BaseAIOUtils.c(this.c.Y);
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
    this.G = paramBoolean;
    if ((this.c.X != null) && (this.d) && (this.g))
    {
      localObject = this.e;
      int i1;
      if (localObject != null)
      {
        if (paramBoolean) {
          i1 = 2130838183;
        } else {
          i1 = 2130838184;
        }
        ((ImageButton)localObject).setBackgroundResource(i1);
      }
      localObject = this.f;
      if (localObject != null)
      {
        if (paramBoolean) {
          i1 = 2130838120;
        } else {
          i1 = 2130838122;
        }
        ((ImageButton)localObject).setBackgroundResource(i1);
      }
      if (this.c.Z != null)
      {
        localObject = this.c.Z;
        if (paramBoolean) {
          i1 = 2130838174;
        } else {
          i1 = 2130838175;
        }
        ((PatchedButton)localObject).setBackgroundResource(i1);
      }
    }
  }
  
  protected boolean c()
  {
    return SimpleUIUtil.e();
  }
  
  public void d()
  {
    Object localObject1 = (FullScreenInputHelper)this.c.q(24);
    if ((localObject1 != null) && (((FullScreenInputHelper)localObject1).e())) {
      return;
    }
    int i1;
    Object localObject2;
    if ((this.c.W != null) && (this.c.X != null) && (c()) && (this.g))
    {
      this.c.W.setCustomHeight(0);
      i1 = AIOUtils.b(10.0F, this.c.f.getResources());
      if ((this.a == -1) || (this.b == -1))
      {
        this.a = this.c.X.getPaddingTop();
        this.b = this.c.X.getPaddingBottom();
      }
      if (this.c.Z != null) {
        this.c.Z.setEnabled(true);
      }
      this.c.X.setPadding(this.c.X.getPaddingLeft(), i1, this.c.X.getPaddingRight(), i1);
      if (this.c.aZ != null)
      {
        if (this.w == null) {
          this.w = ((LinearLayout)this.c.aZ.findViewById(2131433921));
        }
        localObject1 = (LinearLayout.LayoutParams)this.w.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).gravity = 80;
        if (this.u == -1) {
          this.u = ((LinearLayout.LayoutParams)localObject1).bottomMargin;
        }
        localObject2 = this.e;
        if ((localObject2 != null) && (this.v == -1)) {
          this.v = ((LinearLayout.LayoutParams)((ImageButton)localObject2).getLayoutParams()).bottomMargin;
        }
        i1 = this.v;
        if (i1 != -1) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = i1;
        } else {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)this.c.f.getResources().getDimension(2131298884));
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("setSimpleUIMode() simple mode  bottomMargin 1 = ");
          ((StringBuilder)localObject2).append(((LinearLayout.LayoutParams)localObject1).bottomMargin);
          QLog.d("SimpleUIAIOHelper", 2, ((StringBuilder)localObject2).toString());
        }
        this.w.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    else
    {
      if ((this.c.X != null) && (this.a != -1) && (this.b != -1))
      {
        this.c.X.setPadding(this.c.X.getPaddingLeft(), this.a, this.c.X.getPaddingRight(), this.b);
        if (this.c.aL)
        {
          localObject1 = this.c;
          ((BaseChatPie)localObject1).d(AIOUtils.b(1.0F, ((BaseChatPie)localObject1).f.getResources()));
        }
        else
        {
          ThreadManager.executeOnSubThread(new DecodeAIOInputBitmapHeightTask(this.c), true);
        }
      }
      if (this.c.aZ != null)
      {
        if (this.w == null) {
          this.w = ((LinearLayout)this.c.aZ.findViewById(2131433921));
        }
        localObject1 = (LinearLayout.LayoutParams)this.w.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).gravity = 80;
        i1 = this.u;
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
        this.w.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    z();
  }
  
  public void d(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((ImageButton)localObject).setEnabled(paramBoolean);
    }
    localObject = this.f;
    if (localObject != null) {
      ((ImageButton)localObject).setEnabled(paramBoolean);
    }
    localObject = this.c;
    if ((localObject != null) && (((BaseChatPie)localObject).Z != null) && ((this.c.Z.getParent() instanceof RedTouch))) {
      this.c.Z.setEnabled(paramBoolean);
    }
  }
  
  public void f()
  {
    if (this.w == null) {
      this.w = ((LinearLayout)this.c.aZ.findViewById(2131433921));
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.w.getLayoutParams();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjustInputLayout  bottomMargin  = ");
      localStringBuilder.append(localLayoutParams.bottomMargin);
      QLog.d("SimpleUIAIOHelper", 2, localStringBuilder.toString());
    }
    if ((this.c.W != null) && (this.c.X != null) && (c()) && (this.g))
    {
      i1 = this.v;
      if (i1 != -1) {
        localLayoutParams.bottomMargin = i1;
      } else {
        localLayoutParams.bottomMargin = ((int)this.c.f.getResources().getDimension(2131298884));
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("adjustInputLayout() simple mode  bottomMargin 1 = ");
        localStringBuilder.append(localLayoutParams.bottomMargin);
        QLog.d("SimpleUIAIOHelper", 2, localStringBuilder.toString());
      }
      this.w.setLayoutParams(localLayoutParams);
      return;
    }
    localLayoutParams.gravity = 80;
    int i1 = this.u;
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
    this.w.setLayoutParams(localLayoutParams);
  }
  
  public void f(int paramInt)
  {
    if ((this.g) && (this.d) && (paramInt == 2))
    {
      ImageButton localImageButton = this.e;
      if (localImageButton != null) {
        localImageButton.setSelected(false);
      }
    }
  }
  
  public int g()
  {
    return 2130838269;
  }
  
  public void g_(boolean paramBoolean)
  {
    Object localObject1 = (AIOShortcutBarHelper)this.c.q(52);
    int i1;
    if ((((AIOShortcutBarHelper)localObject1).v() == 0) && (((AIOShortcutBarHelper)localObject1).x() == 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool = paramBoolean;
    if (i1 != 0)
    {
      bool = paramBoolean;
      if ((this.c instanceof BaseTroopChatPie)) {
        bool = true;
      }
    }
    if ((this.c.Z != null) && (this.g) && (this.d))
    {
      int i2 = AIOUtils.b(8.0F, this.c.f.getResources());
      Object localObject3;
      Object localObject2;
      ViewGroup.LayoutParams localLayoutParams;
      if (bool)
      {
        y();
        AIOUtils.a(this.c.Z, g());
        this.c.Z.setText(2131887750);
        if (AppSetting.e) {
          this.c.Z.setContentDescription(HardCodeUtil.a(2131911583));
        }
        this.c.Z.setVisibility(0);
        this.c.Z.setEnabled(true);
        localObject1 = this.o.getLayoutParams();
        if ((localObject1 instanceof LinearLayout.LayoutParams))
        {
          localObject1 = (LinearLayout.LayoutParams)localObject1;
          if (this.p == -1) {
            this.p = ((LinearLayout.LayoutParams)localObject1).leftMargin;
          }
          if (this.q == -1) {
            this.q = ((LinearLayout.LayoutParams)localObject1).rightMargin;
          }
          ((LinearLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(4.0F, this.c.f.getResources());
          ((LinearLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(14.0F, this.c.f.getResources());
          this.o.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        localObject1 = this.c.Z;
        localObject3 = ((View)localObject1).getLayoutParams();
        localObject2 = localObject3;
        if ((localObject3 instanceof FrameLayout.LayoutParams))
        {
          localObject3 = (View)this.c.Z.getParent();
          localLayoutParams = ((View)localObject3).getLayoutParams();
          localObject2 = localLayoutParams;
          localObject1 = localObject3;
          if ((localObject3 instanceof RedTouch))
          {
            ((RedTouch)localObject3).g();
            localObject1 = localObject3;
            localObject2 = localLayoutParams;
          }
        }
        if ((localObject2 instanceof LinearLayout.LayoutParams))
        {
          localObject2 = (LinearLayout.LayoutParams)localObject2;
          if (this.k == -1) {
            this.k = ((LinearLayout.LayoutParams)localObject2).rightMargin;
          }
          if (this.l == -1) {
            this.l = ((LinearLayout.LayoutParams)localObject2).leftMargin;
          }
          ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
          ((LinearLayout.LayoutParams)localObject2).rightMargin = 0;
          if (this.m == -1) {
            this.m = this.c.Z.getPaddingLeft();
          }
          if (this.n == -1) {
            this.n = this.c.Z.getPaddingRight();
          }
          if (this.r == -1) {
            this.r = this.c.Z.getPaddingTop();
          }
          if (this.s == -1) {
            this.s = this.c.Z.getPaddingBottom();
          }
          ((LinearLayout.LayoutParams)localObject2).gravity = 16;
          if ((this.k != -1) && (this.l != -1) && (!this.D))
          {
            ((LinearLayout.LayoutParams)localObject2).width = (((LinearLayout.LayoutParams)localObject2).width + this.k + this.l + this.p + this.q - i2);
            if ((this.m != -1) && (this.n != -1)) {
              ((LinearLayout.LayoutParams)localObject2).width = (((LinearLayout.LayoutParams)localObject2).width - this.m - this.n + i2);
            }
            this.D = true;
          }
          localObject3 = this.c.Z;
          i1 = this.t;
          ((PatchedButton)localObject3).setPadding(i2, i1, i2, i1);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      else
      {
        localObject1 = this.c.Z;
        if (this.G) {
          i1 = 2130838174;
        } else {
          i1 = 2130838175;
        }
        ((PatchedButton)localObject1).setBackgroundResource(i1);
        this.c.Z.setText("");
        if (AppSetting.e) {
          this.c.Z.setContentDescription(HardCodeUtil.a(2131911578));
        }
        localObject1 = this.o.getLayoutParams();
        if ((localObject1 instanceof LinearLayout.LayoutParams))
        {
          localObject1 = (LinearLayout.LayoutParams)localObject1;
          i1 = this.p;
          if (i1 != -1) {
            ((LinearLayout.LayoutParams)localObject1).leftMargin = i1;
          }
          i1 = this.q;
          if (i1 != -1) {
            ((LinearLayout.LayoutParams)localObject1).rightMargin = i1;
          }
          this.o.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        localObject2 = this.c.Z;
        localObject3 = ((View)localObject2).getLayoutParams();
        localObject1 = localObject3;
        if ((localObject3 instanceof FrameLayout.LayoutParams))
        {
          localObject3 = (View)this.c.Z.getParent();
          localLayoutParams = ((View)localObject3).getLayoutParams();
          localObject1 = localLayoutParams;
          localObject2 = localObject3;
          if ((localObject3 instanceof RedTouch))
          {
            m();
            localObject2 = localObject3;
            localObject1 = localLayoutParams;
          }
        }
        if ((localObject1 instanceof LinearLayout.LayoutParams))
        {
          localObject1 = (LinearLayout.LayoutParams)localObject1;
          i1 = this.k;
          if (i1 != -1) {
            ((LinearLayout.LayoutParams)localObject1).rightMargin = i1;
          }
          i1 = this.l;
          if (i1 != -1) {
            ((LinearLayout.LayoutParams)localObject1).leftMargin = i1;
          }
          if ((this.l != -1) && (this.k != -1) && (this.D))
          {
            ((LinearLayout.LayoutParams)localObject1).width = (((LinearLayout.LayoutParams)localObject1).width - this.k - this.l - (this.p + this.q - i2));
            if ((this.m != -1) && (this.n != -1)) {
              ((LinearLayout.LayoutParams)localObject1).width = (((LinearLayout.LayoutParams)localObject1).width + this.m + this.n - i2);
            }
            this.D = false;
          }
          if ((this.m != -1) && (this.n != -1) && (this.s != -1) && (this.r != -1)) {
            this.c.Z.setPadding(this.m, this.r, this.n, this.s);
          }
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.c.Z.setEnabled(true);
      }
    }
  }
  
  public String getTag()
  {
    return "SimpleUIAIOHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 2, 3, 4, 7, 9, 10, 11, 15 };
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "onCreate() called");
    }
    a();
  }
  
  public void m()
  {
    View localView = (View)this.c.Z.getParent();
    if (((localView instanceof RedTouch)) && (TextUtils.isEmpty(this.c.Z.getText())))
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.c.d.getRuntimeService(IRedTouchManager.class, "");
      Object localObject1 = null;
      int i2 = 10;
      Object localObject2 = this.c.ah;
      int i1 = i2;
      if (localObject2 != null)
      {
        localObject2 = ((SessionInfo)localObject2).c;
        localObject1 = localObject2;
        i1 = i2;
        if (localObject2 != null)
        {
          i1 = 11;
          localObject1 = localObject2;
        }
      }
      localObject1 = localIRedTouchManager.getRedTouchInfoByAppSet(i1, (String)localObject1, ((PlusRedPointHelper)this.c.q(89)).a());
      ((RedTouch)localView).a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIAIOHelper", 2, "onResume() called");
    }
    d();
  }
  
  boolean o()
  {
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)this.c.q(52);
    int i1 = localAIOShortcutBarHelper.v();
    boolean bool2 = false;
    if ((i1 == 0) && (localAIOShortcutBarHelper.x() == 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool1 = bool2;
    if (localAIOShortcutBarHelper != null) {
      if (i1 == 0)
      {
        bool1 = bool2;
        if (!this.H) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    if (!c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUIAIOHelper", 2, "onClick() not in simple mode");
      }
    }
    else
    {
      int i1 = paramView.getId();
      if (i1 != 2131428843)
      {
        if (i1 == 2131432400)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SimpleUIAIOHelper", 2, "onClick() emo_btn");
          }
          if (System.currentTimeMillis() - this.F >= 500L)
          {
            this.F = System.currentTimeMillis();
            if (this.f.isSelected())
            {
              this.f.setSelected(false);
              BaseAIOUtils.c(this.c.Y);
            }
            else
            {
              this.f.setSelected(true);
              this.c.Y.clearFocus();
              this.c.a(3);
            }
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("SimpleUIAIOHelper", 2, "onClick() audio_btn");
        }
        if (System.currentTimeMillis() - this.F >= 500L)
        {
          this.F = System.currentTimeMillis();
          if (this.e.isSelected())
          {
            this.e.setSelected(false);
            BaseAIOUtils.c(this.c.Y);
          }
          else
          {
            this.e.setSelected(true);
            this.c.Y.clearFocus();
            this.c.a(2);
          }
        }
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
            h();
            return;
          case 10: 
            j();
            return;
            i();
            return;
            n();
          }
          k();
        }
      }
      else {
        l();
      }
    }
    else {
      e();
    }
  }
  
  public void p()
  {
    ImageButton localImageButton = this.e;
    if (localImageButton != null)
    {
      localImageButton.setVisibility(this.L);
      if ((this.e.getParent() != null) && ((this.e.getParent() instanceof RedTouch))) {
        ((RedTouch)this.e.getParent()).setVisibility(this.J);
      }
    }
    localImageButton = this.f;
    if (localImageButton != null)
    {
      localImageButton.setVisibility(this.M);
      if ((this.f.getParent() != null) && ((this.f.getParent() instanceof RedTouch))) {
        ((RedTouch)this.f.getParent()).setVisibility(this.K);
      }
    }
  }
  
  public void q()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      this.L = ((ImageButton)localObject).getVisibility();
      this.e.setVisibility(8);
      if ((this.e.getParent() != null) && ((this.e.getParent() instanceof RedTouch)))
      {
        localObject = (RedTouch)this.e.getParent();
        this.J = ((RedTouch)localObject).getVisibility();
        ((RedTouch)localObject).setVisibility(8);
      }
    }
    localObject = this.f;
    if (localObject != null)
    {
      this.M = ((ImageButton)localObject).getVisibility();
      this.f.setVisibility(8);
      if ((this.f.getParent() != null) && ((this.f.getParent() instanceof RedTouch)))
      {
        localObject = (RedTouch)this.f.getParent();
        this.K = ((RedTouch)localObject).getVisibility();
        ((RedTouch)localObject).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SimpleUIAIOHelper
 * JD-Core Version:    0.7.0.1
 */