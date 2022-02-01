package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.richframework.widget.menu.style.BubblePopupWindowStyle;
import com.tencent.biz.qqcircle.richframework.widget.menu.style.QQDefaultPopupWindowStyle;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class BubblePopupWindow
  implements View.OnClickListener
{
  private static final int[] S = { 16842922 };
  private int A;
  private int B;
  private int C;
  private int D = 0;
  private int[] E = new int[2];
  private int[] F = new int[2];
  private Rect G = new Rect();
  private Drawable H;
  private boolean I;
  private int J = 1000;
  private BubblePopupWindow.OnDismissListener K;
  private BubblePopupWindow.OnKeyBackListener L;
  private boolean M = false;
  private BubblePopupWindow.MyClipDrawable N;
  private BubblePopupWindow.MyClipDrawable O;
  private BubblePopupWindow.MyClipDrawable P;
  private int Q = -1;
  private BubblePopupWindowStyle R;
  private WeakReference<View> T;
  private ViewTreeObserver.OnScrollChangedListener U = new BubblePopupWindow.1(this);
  private int V;
  private int W;
  private ImageView X;
  private ImageView Y;
  private FrameLayout Z;
  private Context a;
  private BubblePopupWindow.QQMenuNoIconEmptyInterface aa;
  private WindowManager b;
  private boolean c;
  private boolean d;
  private View e;
  private View f;
  private boolean g;
  private int h = 0;
  private int i = 1;
  private boolean j = true;
  private boolean k = false;
  private boolean l = true;
  private int m = -1;
  private boolean n;
  private boolean o = true;
  private boolean p = true;
  private boolean q = false;
  private boolean r = false;
  private boolean s;
  private View.OnTouchListener t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public BubblePopupWindow()
  {
    this(null, 0, 0);
  }
  
  public BubblePopupWindow(int paramInt1, int paramInt2)
  {
    this(null, paramInt1, paramInt2);
  }
  
  public BubblePopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842870);
  }
  
  public BubblePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public BubblePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.b = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public BubblePopupWindow(View paramView, int paramInt1, int paramInt2)
  {
    this(paramView, paramInt1, paramInt2, false);
  }
  
  public BubblePopupWindow(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramView != null)
    {
      this.a = paramView.getContext();
      this.b = ((WindowManager)this.a.getSystemService("window"));
    }
    this.R = new QQDefaultPopupWindowStyle();
    a(paramView);
    b(paramInt1);
    a(paramInt2);
    a(paramBoolean);
  }
  
  private WindowManager.LayoutParams a(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.gravity = 51;
    int i1 = this.v;
    this.w = i1;
    localLayoutParams.width = i1;
    i1 = this.y;
    this.z = i1;
    localLayoutParams.height = i1;
    Drawable localDrawable = this.H;
    if (localDrawable != null) {
      localLayoutParams.format = localDrawable.getOpacity();
    } else {
      localLayoutParams.format = -3;
    }
    localLayoutParams.flags = c(localLayoutParams.flags);
    localLayoutParams.type = this.J;
    localLayoutParams.token = paramIBinder;
    localLayoutParams.softInputMode = this.i;
    localLayoutParams.setTitle("PopupWindow");
    return localLayoutParams;
  }
  
  private void a(WindowManager.LayoutParams paramLayoutParams)
  {
    a(paramLayoutParams, false);
  }
  
  private void a(WindowManager.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (this.e != null)
    {
      Object localObject1 = this.a;
      if ((localObject1 != null) && (this.b != null))
      {
        localObject1 = new BubblePopupWindow.PopupViewContainer(this, (Context)localObject1);
        Object localObject2 = new FrameLayout(this.a);
        if (paramBoolean) {
          ((FrameLayout)localObject2).setOnClickListener(this);
        }
        if ((this.e instanceof QQCustomMenuLayout))
        {
          this.Z = new FrameLayout(this.a);
          this.N = new BubblePopupWindow.MyClipDrawable(this, this.a.getResources().getDrawable(2130851597));
          this.Z.addView(this.e, new FrameLayout.LayoutParams(-2, -2, 17));
          localObject2 = new FrameLayout.LayoutParams(-2, -2, 17);
          ((FrameLayout.LayoutParams)localObject2).setMargins(0, ViewUtils.a(9.0F), 0, ViewUtils.a(9.0F));
          ((BubblePopupWindow.PopupViewContainer)localObject1).addView(this.Z, (ViewGroup.LayoutParams)localObject2);
        }
        else
        {
          int i2;
          int i1;
          if (paramBoolean)
          {
            i2 = Math.round(TypedValue.applyDimension(1, 5.0F, this.a.getResources().getDisplayMetrics()));
            i1 = Math.round(TypedValue.applyDimension(1, 5.0F, this.a.getResources().getDisplayMetrics()));
          }
          else
          {
            i2 = 0;
            i1 = 0;
          }
          ((FrameLayout)localObject2).setPadding(i2, Math.round(TypedValue.applyDimension(1, 8.0F, this.a.getResources().getDisplayMetrics())), i1, Math.round(TypedValue.applyDimension(1, 8.0F, this.a.getResources().getDisplayMetrics())));
          ((BubblePopupWindow.PopupViewContainer)localObject1).addView((View)localObject2, -1, -1);
          this.Z = new FrameLayout(this.a);
          ((FrameLayout)localObject2).addView(this.Z, -1, -1);
          localObject2 = this.a.getResources().getDrawable(2130851596);
          this.N = new BubblePopupWindow.MyClipDrawable(this, this.a.getResources().getDrawable(2130851597));
          localObject2 = new LayerDrawable(new Drawable[] { localObject2, this.N });
          this.Z.setBackgroundDrawable((Drawable)localObject2);
          localObject2 = new FrameLayout.LayoutParams(-1, -1, 17);
          this.Z.addView(this.e, (ViewGroup.LayoutParams)localObject2);
        }
        this.Y = new ImageView(this.a);
        localObject2 = new FrameLayout.LayoutParams(-2, -2, 51);
        this.O = new BubblePopupWindow.MyClipDrawable(this, this.R.a(this.a));
        LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[] { this.R.a(this.a), this.O });
        this.Y.setBackgroundDrawable(localLayerDrawable);
        ((BubblePopupWindow.PopupViewContainer)localObject1).addView(this.Y, (ViewGroup.LayoutParams)localObject2);
        this.X = new ImageView(this.a);
        localObject2 = new FrameLayout.LayoutParams(-2, -2, 83);
        this.P = new BubblePopupWindow.MyClipDrawable(this, this.R.b(this.a));
        localLayerDrawable = new LayerDrawable(new Drawable[] { this.R.b(this.a), this.P });
        this.X.setBackgroundDrawable(localLayerDrawable);
        ((BubblePopupWindow.PopupViewContainer)localObject1).addView(this.X, (ViewGroup.LayoutParams)localObject2);
        this.f = ((View)localObject1);
        this.A = paramLayoutParams.width;
        this.B = paramLayoutParams.height;
        return;
      }
    }
    throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    this.I = paramBoolean;
    if (!paramBoolean) {
      localObject = this.Y;
    } else {
      localObject = this.X;
    }
    ImageView localImageView;
    if (!paramBoolean) {
      localImageView = this.X;
    } else {
      localImageView = this.Y;
    }
    int i1 = ((View)localObject).getMeasuredWidth();
    ((View)localObject).setVisibility(0);
    Object localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = (paramInt - i1 / 2);
    if (this.I) {
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = 1;
    } else {
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = 1;
    }
    localImageView.setVisibility(4);
  }
  
  private boolean a(View paramView, WindowManager.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    paramView.getLocationInWindow(this.E);
    View localView = paramView.getRootView();
    Object localObject = this.E;
    paramLayoutParams.x = (localObject[0] + paramInt1);
    paramLayoutParams.y = (localObject[1] + paramInt2);
    paramLayoutParams.gravity = 83;
    paramView.getLocationOnScreen(this.F);
    localObject = new Rect();
    paramView.getWindowVisibleDisplayFrame((Rect)localObject);
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    int i1 = this.A;
    int i4 = this.B;
    int i3;
    if (i1 != -2)
    {
      i2 = i1;
      i3 = i4;
      if (i4 != -2) {}
    }
    else
    {
      this.f.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.A == -2) {
        i1 = this.f.getMeasuredWidth();
      }
      i2 = i1;
      i3 = i4;
      if (this.B == -2)
      {
        i3 = this.f.getMeasuredHeight();
        i2 = i1;
      }
    }
    if (i2 > 0) {
      paramLayoutParams.x = (this.F[0] + paramView.getWidth() / 2 - i2 / 2 + paramInt1);
    }
    boolean bool;
    if ((this.F[1] + paramInt2 - i3 < ((Rect)localObject).top) || (paramLayoutParams.x + i2 - localView.getWidth() > 0))
    {
      if (this.p)
      {
        i1 = paramView.getScrollX();
        i4 = paramView.getScrollY();
        paramView.requestRectangleOnScreen(new Rect(i1, i4, i1 + i2 + paramInt1, i4 + i3 + paramView.getHeight() + paramInt2), true);
        paramView.getLocationInWindow(this.E);
        if (i2 > 0) {
          paramLayoutParams.x = (this.E[0] + paramView.getWidth() / 2 - i2 / 2 + paramInt1);
        } else {
          paramLayoutParams.x = (this.E[0] + paramInt1);
        }
        paramLayoutParams.y = (this.E[1] + paramInt2);
        paramView.getLocationOnScreen(this.F);
      }
      if (this.F[1] + paramInt2 - i3 < ((Rect)localObject).top)
      {
        if (i3 + localRect.bottom + paramInt2 > ((Rect)localObject).bottom)
        {
          paramLayoutParams.y = (localRect.top + localRect.height() / 2 + paramInt2);
          bool = true;
          paramInt1 = 1;
          break label494;
        }
        paramLayoutParams.y = (this.E[1] + paramView.getHeight() + paramInt2);
        paramLayoutParams.gravity = 51;
        bool = false;
      }
      else
      {
        paramLayoutParams.y = (this.E[1] + paramInt2);
      }
    }
    else
    {
      bool = true;
    }
    paramInt1 = 0;
    label494:
    if (this.o)
    {
      i1 = ((Rect)localObject).right - ((Rect)localObject).left;
      i2 = paramLayoutParams.x + i2;
      if (i2 > i1) {
        paramLayoutParams.x -= i2 - i1;
      }
      if (paramLayoutParams.x < ((Rect)localObject).left)
      {
        paramLayoutParams.x = ((Rect)localObject).left;
        paramLayoutParams.width = Math.min(paramLayoutParams.width, i1);
      }
      if ((bool) && (paramInt1 == 0))
      {
        paramInt2 = this.F[1] + paramInt2 - this.B;
        if (paramInt2 < 0) {
          paramLayoutParams.y += paramInt2;
        }
      }
      else
      {
        paramLayoutParams.y = Math.max(paramLayoutParams.y, ((Rect)localObject).top);
      }
      paramLayoutParams.gravity |= 0x10000000;
    }
    if ((bool) && (paramInt1 == 0)) {
      paramLayoutParams.y = (localView.getHeight() - paramLayoutParams.y);
    }
    paramInt2 = this.F[0];
    i1 = paramView.getWidth() / 2;
    int i2 = paramLayoutParams.x;
    if (bool) {
      paramInt1 = Math.round(TypedValue.applyDimension(1, 5.0F, this.a.getResources().getDisplayMetrics()));
    } else {
      paramInt1 = Math.round(TypedValue.applyDimension(1, 3.0F, this.a.getResources().getDisplayMetrics()));
    }
    paramLayoutParams.y -= paramInt1;
    a(bool, paramInt2 + i1 - i2);
    return bool;
  }
  
  private void b(View paramView, int paramInt1, int paramInt2)
  {
    f();
    this.T = new WeakReference(paramView);
    paramView = paramView.getViewTreeObserver();
    if (paramView != null) {
      paramView.addOnScrollChangedListener(this.U);
    }
    this.V = paramInt1;
    this.W = paramInt2;
  }
  
  @TargetApi(14)
  private void b(WindowManager.LayoutParams paramLayoutParams)
  {
    Context localContext = this.a;
    if (localContext != null) {
      paramLayoutParams.packageName = localContext.getPackageName();
    }
    if (Build.VERSION.SDK_INT >= 14) {
      this.f.setFitsSystemWindows(this.q);
    }
    if (this.f.getParent() == null) {
      this.b.addView(this.f, paramLayoutParams);
    }
  }
  
  private int c(int paramInt)
  {
    paramInt &= 0xFF797DE7;
    int i1 = paramInt;
    if (this.M) {
      i1 = paramInt | 0x8000;
    }
    if (!this.g)
    {
      i1 |= 0x8;
      paramInt = i1;
      if (this.h != 1) {
        break label62;
      }
    }
    else
    {
      paramInt = i1;
      if (this.h != 2) {
        break label62;
      }
    }
    paramInt = i1 | 0x20000;
    label62:
    i1 = paramInt;
    if (!this.j) {
      i1 = paramInt | 0x10;
    }
    paramInt = i1;
    if (this.k) {
      paramInt = i1 | 0x40000;
    }
    i1 = paramInt;
    if (!this.l) {
      i1 = paramInt | 0x200;
    }
    paramInt = i1;
    if (a()) {
      paramInt = i1 | 0x800000;
    }
    i1 = paramInt;
    if (this.n) {
      i1 = paramInt | 0x100;
    }
    paramInt = i1;
    if (this.q) {
      paramInt = i1 | 0x10000;
    }
    i1 = paramInt;
    if (this.s) {
      i1 = paramInt | 0x20;
    }
    return i1;
  }
  
  private int e()
  {
    int i2 = this.Q;
    int i1 = i2;
    if (i2 == -1)
    {
      if (this.d)
      {
        if (this.I) {
          return 2131952289;
        }
        return 2131952288;
      }
      i1 = 0;
    }
    return i1;
  }
  
  private void f()
  {
    Object localObject = this.T;
    if (localObject != null) {
      localObject = (View)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((View)localObject).getViewTreeObserver().removeOnScrollChangedListener(this.U);
    }
    this.T = null;
  }
  
  public void a(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (paramInt3 != -1)
    {
      this.w = paramInt3;
      b(paramInt3);
    }
    if (paramInt4 != -1)
    {
      this.z = paramInt4;
      a(paramInt4);
    }
    if (b())
    {
      if (this.e == null) {
        return;
      }
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.f.getLayoutParams();
      int i1 = this.u;
      if (i1 >= 0) {
        i1 = this.w;
      }
      boolean bool = paramBoolean;
      if (paramInt3 != -1)
      {
        bool = paramBoolean;
        if (localLayoutParams.width != i1)
        {
          this.w = i1;
          localLayoutParams.width = i1;
          bool = true;
        }
      }
      paramInt3 = this.x;
      if (paramInt3 >= 0) {
        paramInt3 = this.z;
      }
      paramBoolean = bool;
      if (paramInt4 != -1)
      {
        paramBoolean = bool;
        if (localLayoutParams.height != paramInt3)
        {
          this.z = paramInt3;
          localLayoutParams.height = paramInt3;
          paramBoolean = true;
        }
      }
      if (localLayoutParams.x != paramInt1)
      {
        localLayoutParams.x = paramInt1;
        paramBoolean = true;
      }
      if (localLayoutParams.y != paramInt2)
      {
        localLayoutParams.y = paramInt2;
        paramBoolean = true;
      }
      paramInt1 = e();
      if (paramInt1 != localLayoutParams.windowAnimations)
      {
        localLayoutParams.windowAnimations = paramInt1;
        paramBoolean = true;
      }
      paramInt1 = c(localLayoutParams.flags);
      if (paramInt1 != localLayoutParams.flags)
      {
        localLayoutParams.flags = paramInt1;
        paramBoolean = true;
      }
      if (paramBoolean) {
        this.b.updateViewLayout(this.f, localLayoutParams);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    paramInt1 = (int)(paramInt1 + this.e.getX() * 2.0F);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.f.getLayoutParams();
    if (this.C > DisplayUtil.d() / 2) {
      localLayoutParams.x = (localLayoutParams.x + paramInt2 - paramInt1);
    }
    a(this.I, this.C - localLayoutParams.x);
    if (Build.VERSION.SDK_INT < 19)
    {
      this.b.updateViewLayout(this.f, localLayoutParams);
    }
    else
    {
      this.b.removeView(this.f);
      this.b.addView(this.f, localLayoutParams);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[menu] updateLocationX ParamX: ");
      localStringBuilder.append(localLayoutParams.x);
      localStringBuilder.append(" menuContainerWidth: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" centerX: ");
      localStringBuilder.append(this.C);
      localStringBuilder.append(" isMenusLineFull: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("BubblePopupWindow", 2, localStringBuilder.toString());
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    this.H = paramDrawable;
  }
  
  public void a(View paramView)
  {
    if (b()) {
      return;
    }
    this.e = paramView;
    if (this.a == null)
    {
      paramView = this.e;
      if (paramView != null) {
        this.a = paramView.getContext();
      }
    }
    if ((this.b == null) && (this.e != null)) {
      this.b = ((WindowManager)this.a.getSystemService("window"));
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (!b())
    {
      if (this.e == null) {
        return;
      }
      b(paramView, paramInt1, paramInt2);
      this.c = true;
      this.d = true;
      WindowManager.LayoutParams localLayoutParams = a(paramView.getWindowToken());
      a(localLayoutParams);
      a(paramView, localLayoutParams, paramInt1, paramInt2);
      paramInt1 = this.x;
      if (paramInt1 < 0)
      {
        this.z = paramInt1;
        localLayoutParams.height = paramInt1;
      }
      paramInt1 = this.u;
      if (paramInt1 < 0)
      {
        this.w = paramInt1;
        localLayoutParams.width = paramInt1;
      }
      localLayoutParams.windowAnimations = e();
      b(localLayoutParams);
    }
  }
  
  public void a(BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.K = paramOnDismissListener;
  }
  
  public void a(BubblePopupWindow.QQMenuNoIconEmptyInterface paramQQMenuNoIconEmptyInterface)
  {
    this.aa = paramQQMenuNoIconEmptyInterface;
  }
  
  public void a(BubblePopupWindowStyle paramBubblePopupWindowStyle)
  {
    this.R = paramBubblePopupWindowStyle;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean a()
  {
    int i1 = this.m;
    boolean bool2 = false;
    boolean bool1 = false;
    if (i1 < 0)
    {
      Context localContext = this.a;
      if (localContext != null)
      {
        if (localContext.getApplicationInfo().targetSdkVersion >= 11) {
          bool1 = true;
        }
        return bool1;
      }
    }
    bool1 = bool2;
    if (this.m == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void b(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void b(View paramView)
  {
    a(paramView, 0, 0);
  }
  
  public void b(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubblePopupWindow", 2, "dismiss() called \n");
    }
    if ((b()) && (this.f != null))
    {
      this.c = false;
      f();
      try
      {
        if (this.f.getParent() != null) {
          this.b.removeViewImmediate(this.f);
        }
        Object localObject1 = this.f;
        localObject3 = this.e;
        if ((localObject1 != localObject3) && ((localObject1 instanceof ViewGroup))) {
          ((ViewGroup)localObject1).removeView((View)localObject3);
        }
        this.f = null;
        localObject1 = this.K;
        if (localObject1 != null)
        {
          ((BubblePopupWindow.OnDismissListener)localObject1).a();
          return;
        }
      }
      finally
      {
        Object localObject3 = this.f;
        View localView = this.e;
        if ((localObject3 != localView) && ((localObject3 instanceof ViewGroup))) {
          ((ViewGroup)localObject3).removeView(localView);
        }
        this.f = null;
        localObject3 = this.K;
        if (localObject3 != null) {
          ((BubblePopupWindow.OnDismissListener)localObject3).a();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    c();
    BubblePopupWindow.QQMenuNoIconEmptyInterface localQQMenuNoIconEmptyInterface = this.aa;
    if (localQQMenuNoIconEmptyInterface != null) {
      localQQMenuNoIconEmptyInterface.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow
 * JD-Core Version:    0.7.0.1
 */