package com.tencent.mobileqq.activity.aio.helper;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.widget.LargeAreaPatchedButton;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;

public class SimpleFullScreenHelper
{
  private static final int[] a = { 2130851875, 2130851873, 2130851874 };
  private int A;
  private int B;
  private int C;
  private int D;
  private View E;
  private ValueAnimator F;
  private final FullScreenInputHelper b;
  private final BaseChatPie c;
  private Context d;
  private PatchedButton e;
  private View f;
  private ImageButton g;
  private ImageButton h;
  private LinearLayout i;
  private FrameLayout j;
  private FrameLayout k;
  private XEditTextEx l;
  private ImageView m;
  private LargeAreaPatchedButton n;
  private LinearLayout o;
  private FrameLayout.LayoutParams p;
  private LinearLayout.LayoutParams q;
  private FrameLayout.LayoutParams r;
  private FrameLayout.LayoutParams s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public SimpleFullScreenHelper(FullScreenInputHelper paramFullScreenInputHelper)
  {
    this.b = paramFullScreenInputHelper;
    this.c = paramFullScreenInputHelper.a;
    if (this.c == null) {
      return;
    }
    this.d = paramFullScreenInputHelper.a.f;
    this.e = this.b.e;
    this.f = this.b.b;
    this.g = this.b.d;
    this.h = this.b.c;
  }
  
  private float a(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return 0.0F;
    }
    if (paramFloat > 1.0F) {
      return 1.0F;
    }
    return paramFloat;
  }
  
  private ValueAnimator a(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 100 }).setDuration(300L);
    localValueAnimator.setRepeatCount(0);
    int i3 = this.c.bl().getHeight();
    int i4 = this.c.bl().getWidth();
    if (paramBoolean)
    {
      this.w = this.c.Y.getHeight();
      int[] arrayOfInt = new int[2];
      this.c.Y.getLocationOnScreen(arrayOfInt);
      this.x = arrayOfInt[0];
      this.y = this.c.Y.getWidth();
      this.z = this.h.getHeight();
      this.A = this.c.Y.getPaddingLeft();
      this.B = this.c.Y.getPaddingRight();
      this.C = this.c.Y.getPaddingTop();
      this.D = this.c.Y.getPaddingBottom();
    }
    int i5 = AIOUtils.b(14.0F, this.c.f.getResources());
    int i2 = AIOUtils.b(8.0F, this.c.f.getResources());
    int i1 = i2;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i1 = i2 + ImmersiveUtils.getStatusBarHeight(this.c.f);
    }
    i2 = AIOUtils.b(12.0F, this.c.f.getResources());
    int i6 = this.z;
    localValueAnimator.addUpdateListener(new SimpleFullScreenHelper.4(this, i3 - this.w, i4 - this.y, i5, i2 + i6 + i1));
    return localValueAnimator;
  }
  
  private LinearLayout a(int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.d);
    Object localObject = new FrameLayout.LayoutParams(-2, paramInt);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramInt = 0;
    localLinearLayout.setOrientation(0);
    localLinearLayout.setVerticalGravity(16);
    int i1 = AIOUtils.b(28.0F, this.d.getResources());
    int i2 = AIOUtils.b(16.0F, this.d.getResources());
    while (paramInt < a.length)
    {
      localObject = new ImageView(this.d);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i1, i1);
      localLayoutParams.rightMargin = i2;
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      ((ImageView)localObject).setImageResource(a[paramInt]);
      localLinearLayout.addView((View)localObject);
      ((ImageView)localObject).setOnClickListener(new SimpleFullScreenHelper.1(this, paramInt));
      if (AppSetting.e) {
        ((ImageView)localObject).setContentDescription(HardCodeUtil.a(b(paramInt)));
      }
      paramInt += 1;
    }
    return localLinearLayout;
  }
  
  private int b(int paramInt)
  {
    if (paramInt == 0) {
      return 2131917037;
    }
    if (paramInt == 1) {
      return 2131917017;
    }
    return 2131917022;
  }
  
  private void c(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          i1 = 0;
          break label62;
        }
        this.c.Y.clearFocus();
        this.c.a(3);
      }
      else
      {
        this.c.a(6);
      }
    }
    else {
      this.c.a(4);
    }
    int i1 = 1;
    label62:
    if (i1 != 0) {
      SimpleFullInputReporter.a(this.c.d, "0X800BDCE", 0, String.valueOf(paramInt + 1));
    }
  }
  
  private void e()
  {
    this.j = new FrameLayout(this.c.f);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.j.setLayoutParams(localLayoutParams);
    this.k = h();
    this.l = k();
    this.k.addView(this.l);
    this.m = g();
    this.n = j();
    this.o = i();
    this.c.ba.addView(this.j);
    this.E = f();
    this.j.addView(this.E);
    this.j.addView(this.k);
    this.j.addView(this.o);
    this.j.addView(this.m);
    this.j.addView(this.n);
    this.j.bringToFront();
  }
  
  private View f()
  {
    View localView = new View(this.d);
    localView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localView.setBackgroundColor(this.d.getResources().getColor(2131167723));
    return localView;
  }
  
  private ImageButton g()
  {
    ImageButton localImageButton = new ImageButton(this.c.f);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.g.getLayoutParams());
    localLayoutParams.width = AIOUtils.b(25.0F, this.c.f.getResources());
    localLayoutParams.height = AIOUtils.b(25.0F, this.c.f.getResources());
    localImageButton.setImageResource(2130851952);
    localLayoutParams.rightMargin = AIOUtils.b(14.0F, this.c.f.getResources());
    int i2 = AIOUtils.b(8.0F, this.c.f.getResources());
    int i1 = i2;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i1 = i2 + ImmersiveUtils.getStatusBarHeight(this.c.f);
    }
    localLayoutParams.topMargin = i1;
    localLayoutParams.gravity = 5;
    localImageButton.setBackgroundColor(0);
    localImageButton.setLayoutParams(localLayoutParams);
    return localImageButton;
  }
  
  private FrameLayout h()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.c.f);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.f.getWidth(), this.f.getHeight());
    localLayoutParams.leftMargin = this.f.getLeft();
    localLayoutParams.bottomMargin = AIOUtils.b(10.0F, this.c.f.getResources());
    localLayoutParams.gravity = 80;
    localFrameLayout.setBackgroundColor(this.d.getResources().getColor(2131167723));
    localFrameLayout.setLayoutParams(localLayoutParams);
    return localFrameLayout;
  }
  
  private LinearLayout i()
  {
    int i1 = AIOUtils.b(15.0F, this.c.f.getResources());
    return a(AIOUtils.b(28.0F, this.c.f.getResources()) + i1 * 2);
  }
  
  private LargeAreaPatchedButton j()
  {
    LargeAreaPatchedButton localLargeAreaPatchedButton = new LargeAreaPatchedButton(this.c.f);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.e.getLayoutParams());
    localLayoutParams.width = -2;
    localLayoutParams.rightMargin = AIOUtils.b(14.0F, this.c.f.getResources());
    localLayoutParams.height = AIOUtils.b(28.0F, this.c.f.getResources());
    localLayoutParams.gravity = 85;
    int i1 = AIOUtils.b(15.0F, this.c.f.getResources());
    localLayoutParams.topMargin = i1;
    localLayoutParams.bottomMargin = i1;
    localLargeAreaPatchedButton.setTextSize(0, this.e.getTextSize());
    localLargeAreaPatchedButton.setLayoutParams(localLayoutParams);
    localLargeAreaPatchedButton.setGravity(17);
    localLargeAreaPatchedButton.setBackground(this.e.getBackground());
    localLargeAreaPatchedButton.setText(this.e.getText());
    localLargeAreaPatchedButton.setTextColor(this.e.getTextColors());
    i1 = AIOUtils.b(9.0F, this.c.f.getResources());
    localLargeAreaPatchedButton.setPadding(i1, 0, i1, 0);
    localLargeAreaPatchedButton.setSingleLine();
    return localLargeAreaPatchedButton;
  }
  
  private XEditTextEx k()
  {
    XEditTextEx localXEditTextEx = new XEditTextEx(this.c.f);
    localXEditTextEx.setBackgroundColor(0);
    localXEditTextEx.setGravity(19);
    localXEditTextEx.setIncludeFontPadding(this.c.Y.getIncludeFontPadding());
    localXEditTextEx.setInputType(this.c.Y.getInputType());
    localXEditTextEx.setMaxLines(this.c.Y.getInputType());
    localXEditTextEx.setFilters(this.c.Y.getFilters());
    localXEditTextEx.setTextColor(this.c.Y.getTextColors());
    localXEditTextEx.setTextSize(0, this.c.Y.getTextSize());
    localXEditTextEx.setHintTextColor(this.c.Y.getHintTextColors());
    localXEditTextEx.setHighlightColor(this.c.Y.getHighlightColor());
    localXEditTextEx.setFocusable(false);
    localXEditTextEx.setText(this.c.Y.getText());
    localXEditTextEx.setLayoutParams(new FrameLayout.LayoutParams(this.c.Y.getLayoutParams()));
    localXEditTextEx.setPadding(this.c.Y.getPaddingLeft(), this.c.Y.getPaddingTop(), this.c.Y.getPaddingRight(), this.c.Y.getPaddingBottom());
    return localXEditTextEx;
  }
  
  public void a()
  {
    if ((QQTheme.isNowSimpleUI()) && (this.b != null))
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        if (this.d == null) {
          return;
        }
        this.t = ((BaseChatPie)localObject).bd.getVisibility();
        this.u = this.c.bb.getVisibility();
        this.c.bd.setVisibility(8);
        this.c.bb.setVisibility(8);
        ((SimpleUIAIOHelper)this.c.q(29)).q();
        localObject = (FrameLayout.LayoutParams)this.e.getLayoutParams();
        this.p = new FrameLayout.LayoutParams((FrameLayout.LayoutParams)localObject);
        int i1 = AIOUtils.b(15.0F, this.c.f.getResources());
        ((FrameLayout.LayoutParams)localObject).width = -2;
        ((FrameLayout.LayoutParams)localObject).height = AIOUtils.b(28.0F, this.c.f.getResources());
        ((FrameLayout.LayoutParams)localObject).bottomMargin = i1;
        ((FrameLayout.LayoutParams)localObject).topMargin = i1;
        ((FrameLayout.LayoutParams)localObject).rightMargin = 0;
        int i2 = AIOUtils.b(9.0F, this.c.f.getResources());
        this.e.setPadding(i2, 0, i2, 0);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.f.getLayoutParams();
        this.q = new LinearLayout.LayoutParams(localLayoutParams);
        localLayoutParams.leftMargin = AIOUtils.b(14.0F, this.c.f.getResources());
        localLayoutParams.rightMargin = AIOUtils.b(14.0F, this.c.f.getResources());
        int i3 = ((FrameLayout.LayoutParams)localObject).height + i1 * 2;
        if (this.i == null)
        {
          this.i = a(i3);
          ((FrameLayout)this.f).addView(this.i);
        }
        this.i.setVisibility(0);
        localObject = (FrameLayout.LayoutParams)this.g.getLayoutParams();
        this.r = new FrameLayout.LayoutParams((FrameLayout.LayoutParams)localObject);
        ((FrameLayout.LayoutParams)localObject).rightMargin = 0;
        i2 = AIOUtils.b(8.0F, this.c.f.getResources());
        i1 = i2;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          i1 = i2 + ImmersiveUtils.getStatusBarHeight(this.d);
        }
        ((FrameLayout.LayoutParams)localObject).topMargin = i1;
        ((FrameLayout.LayoutParams)localObject).gravity = 5;
        this.b.c(false);
        this.b.d(false);
        localObject = (FrameLayout.LayoutParams)this.c.Y.getLayoutParams();
        this.s = new FrameLayout.LayoutParams((FrameLayout.LayoutParams)localObject);
        this.c.Y.setPadding(0, 0, 0, 0);
        ((FrameLayout.LayoutParams)localObject).bottomMargin = i3;
        this.c.Y.setBackgroundColor(0);
        this.v = this.c.W.getVisibility();
        this.c.W.setVisibility(8);
        localObject = this.e;
        boolean bool;
        if (this.c.Y.getText().length() != 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((PatchedButton)localObject).setEnabled(bool);
        this.e.setSingleLine();
        SimpleFullInputReporter.a(this.c.d, "0X800BDA2", 0, "");
        if (!ImmersiveUtils.couldSetStatusTextColor()) {
          return;
        }
        if (!QQTheme.isNowThemeSimpleNight()) {
          ImmersiveUtils.setStatusTextColor(true, this.c.f.getWindow());
        }
      }
    }
  }
  
  public void b()
  {
    if ((QQTheme.isNowSimpleUI()) && (this.b != null))
    {
      Object localObject1 = this.c;
      if (localObject1 != null)
      {
        if (this.d == null) {
          return;
        }
        ((BaseChatPie)localObject1).bd.setVisibility(this.t);
        this.c.bb.setVisibility(this.u);
        this.c.W.setVisibility(this.v);
        if (this.t == 0) {
          this.c.bd.d();
        }
        if (this.u == 0) {
          this.c.bb.d();
        }
        localObject1 = (SimpleUIAIOHelper)this.c.q(29);
        ((SimpleUIAIOHelper)localObject1).p();
        this.e.setLayoutParams(this.p);
        Object localObject2 = this.e;
        boolean bool = false;
        ((PatchedButton)localObject2).setPadding(0, 0, 0, 0);
        localObject2 = (LinearLayout.LayoutParams)this.f.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).rightMargin = this.q.rightMargin;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = this.q.leftMargin;
        this.i.setVisibility(8);
        this.g.setLayoutParams(this.r);
        this.c.Y.setLayoutParams(this.s);
        this.c.Y.setBackgroundResource(2130851969);
        if (this.c.Y.getText().length() != 0) {
          bool = true;
        }
        ((SimpleUIAIOHelper)localObject1).g_(bool);
        if (!ImmersiveUtils.couldSetStatusTextColor()) {
          return;
        }
        ImmersiveUtils.setStatusTextColor(QQTheme.isSimpleColrThemeStateBarUseWhite(QQTheme.getCurrentThemeId()), this.c.f.getWindow());
      }
    }
  }
  
  public void c()
  {
    try
    {
      if ((QQTheme.isNowSimpleUI()) && (this.b != null) && (this.c != null) && (this.d != null))
      {
        if (this.j == null) {
          e();
        }
        this.l.setText(this.c.Y.getText());
        this.j.setVisibility(0);
        this.c.Y.setAlpha(0.0F);
        this.F = a(true);
        this.F.addListener(new SimpleFullScreenHelper.2(this));
        this.F.start();
        return;
      }
      return;
    }
    finally {}
  }
  
  public void d()
  {
    try
    {
      if ((QQTheme.isNowSimpleUI()) && (this.b != null) && (this.c != null) && (this.d != null))
      {
        ValueAnimator localValueAnimator = this.F;
        if (localValueAnimator == null) {
          return;
        }
        this.j.setVisibility(0);
        this.c.Y.setAlpha(0.0F);
        this.b.b(false);
        this.F = a(false);
        this.F.setIntValues(new int[] { 100, 0 });
        this.F.addListener(new SimpleFullScreenHelper.3(this));
        this.F.start();
        return;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SimpleFullScreenHelper
 * JD-Core Version:    0.7.0.1
 */