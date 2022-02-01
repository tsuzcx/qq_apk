package com.tencent.mm.ui.widget.dialog;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MMHalfBottomDialog
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final int BUTTON_COLOR_BLUE = 4;
  public static final int BUTTON_COLOR_GRAY = 1;
  public static final int BUTTON_COLOR_GREEN = 0;
  public static final int BUTTON_COLOR_ORANGE = 5;
  public static final int BUTTON_COLOR_RED = 2;
  public static final int BUTTON_COLOR_YELLOW = 3;
  public static final int BUTTON_STYLE_DOUBLE = 1;
  public static final int BUTTON_STYLE_HIDE = 0;
  public static final int BUTTON_STYLE_SINGLE = 2;
  public static final int HEADER_STYLE_CUSTOM = 3;
  public static final int HEADER_STYLE_DOWN_ARROW = 1;
  public static final int HEADER_STYLE_HIDE = 0;
  public static final int HEADER_STYLE_LRFT_TITLE = 2;
  private Dialog a;
  private Context b;
  private boolean c = false;
  private int d;
  private View e;
  private ViewTreeObserver f;
  private boolean g;
  private boolean h = false;
  private boolean i = false;
  private BottomSheetBehavior j;
  private int k = 0;
  private int l = 0;
  private LinearLayout m;
  private Button n;
  private Button o;
  private Button p;
  private LinearLayout q;
  private LinearLayout r;
  public View rootView;
  private LinearLayout s;
  private TextView t;
  private MMHalfBottomDialog.IBtnCallBack u;
  private MMHalfBottomDialog.IBtnCallBack v;
  private MMHalfBottomDialog.IBtnCallBack w;
  private boolean x = true;
  private int y;
  
  public MMHalfBottomDialog(Context paramContext)
  {
    this.b = paramContext;
    this.k = 0;
    this.l = 0;
    a(this.b);
  }
  
  public MMHalfBottomDialog(Context paramContext, int paramInt1, int paramInt2)
  {
    this.b = paramContext;
    this.k = paramInt1;
    this.l = paramInt2;
    a(this.b);
  }
  
  public MMHalfBottomDialog(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.b = paramContext;
    this.k = paramInt1;
    this.l = paramInt2;
    this.x = paramBoolean;
    a(this.b);
  }
  
  private int a()
  {
    Context localContext = this.b;
    if ((localContext instanceof Activity)) {
      return ((Activity)localContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    return 0;
  }
  
  private void a(Context paramContext)
  {
    Context localContext = this.b;
    if ((localContext instanceof Activity)) {
      this.e = ((ViewGroup)((Activity)localContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.a = new BottomSheetDialog(paramContext, 2131951926);
    this.rootView = View.inflate(paramContext, 2131625442, null);
    this.q = ((LinearLayout)this.rootView.findViewById(2131429694));
    this.r = ((LinearLayout)this.rootView.findViewById(2131429690));
    this.s = ((LinearLayout)this.rootView.findViewById(2131429689));
    b();
    c();
    this.c = f();
    this.a.setContentView(this.rootView);
    this.a.setCancelable(this.x);
    this.j = BottomSheetBehavior.b((View)this.rootView.getParent());
    this.j.d(3);
    this.j.a(new MMHalfBottomDialog.1(this));
    this.a.setOnDismissListener(new MMHalfBottomDialog.2(this));
  }
  
  private void b()
  {
    this.m = ((LinearLayout)this.rootView.findViewById(2131429925));
    this.n = ((Button)this.rootView.findViewById(2131429864));
    this.o = ((Button)this.rootView.findViewById(2131429865));
    this.p = ((Button)this.rootView.findViewById(2131430032));
    int i1 = this.k;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        this.m.setVisibility(0);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.p.setOnClickListener(new MMHalfBottomDialog.5(this));
        return;
      }
      this.m.setVisibility(0);
      this.p.setVisibility(8);
      this.n.setOnClickListener(new MMHalfBottomDialog.3(this));
      this.o.setOnClickListener(new MMHalfBottomDialog.4(this));
      return;
    }
    this.m.setVisibility(8);
  }
  
  private void c()
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      ((LinearLayout)localObject).setVisibility(0);
      int i1 = this.l;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2) {
            return;
          }
          localObject = LayoutInflater.from(this.b).inflate(2131625135, null);
          this.t = ((TextView)((View)localObject).findViewById(2131447576));
          this.q.removeAllViews();
          this.q.setGravity(17);
          this.q.addView((View)localObject, -1, -2);
          return;
        }
        localObject = LayoutInflater.from(this.b).inflate(2131625134, null);
        ((View)localObject).findViewById(2131430828).setOnClickListener(new MMHalfBottomDialog.6(this));
        this.q.removeAllViews();
        this.q.setGravity(17);
        this.q.addView((View)localObject, -1, -2);
        return;
      }
      this.q.setVisibility(8);
    }
  }
  
  @TargetApi(23)
  private void d()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Dialog localDialog = this.a;
      if (localDialog != null)
      {
        localDialog.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.a.getWindow().setStatusBarColor(0);
      }
    }
  }
  
  private void e()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.rootView.getLayoutParams();
    if ((this.c) && (this.e != null))
    {
      Rect localRect = new Rect();
      this.e.getWindowVisibleDisplayFrame(localRect);
      localLayoutParams.width = localRect.right;
    }
    this.rootView.setLayoutParams(localLayoutParams);
  }
  
  private boolean f()
  {
    return this.b.getResources().getConfiguration().orientation == 2;
  }
  
  public void dismissDestroy(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean isShowing()
  {
    Dialog localDialog = this.a;
    return (localDialog != null) && (localDialog.isShowing());
  }
  
  public void onGlobalLayout()
  {
    if (isShowing())
    {
      View localView = this.e;
      if ((localView != null) && ((localView.isShown()) || (localView.getVisibility() == 0)))
      {
        if ((isShowing()) && ((this.c != f()) || (this.d != a()))) {
          tryHide();
        }
      }
      else {
        tryHide();
      }
    }
  }
  
  public MMHalfBottomDialog setCustomView(int paramInt)
  {
    LinearLayout localLinearLayout = this.s;
    if (localLinearLayout != null)
    {
      localLinearLayout.setVisibility(0);
      LayoutInflater.from(this.rootView.getContext()).inflate(paramInt, this.s, true);
    }
    return this;
  }
  
  public void setCustomView(View paramView)
  {
    LinearLayout localLinearLayout = this.s;
    if (localLinearLayout != null)
    {
      localLinearLayout.setVisibility(0);
      this.s.removeAllViews();
      this.s.setGravity(17);
      this.s.addView(paramView, -1, -2);
    }
  }
  
  public void setDoubleBtnClickListener(MMHalfBottomDialog.IBtnCallBack paramIBtnCallBack1, MMHalfBottomDialog.IBtnCallBack paramIBtnCallBack2)
  {
    this.u = paramIBtnCallBack1;
    this.v = paramIBtnCallBack2;
  }
  
  public void setDoubleBtnText(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    Button localButton = this.n;
    if ((localButton != null) && (this.o != null))
    {
      localButton.setText(paramCharSequence1);
      this.o.setText(paramCharSequence2);
    }
  }
  
  public void setDoubleRightBtnColorStyle(int paramInt)
  {
    Button localButton = this.o;
    if (localButton != null)
    {
      if (paramInt != 0)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return;
              }
              localButton.setBackgroundResource(2130839036);
              return;
            }
            localButton.setBackgroundResource(2130839030);
            return;
          }
          localButton.setBackgroundResource(2130839041);
          return;
        }
        localButton.setBackgroundResource(2130839037);
        return;
      }
      localButton.setBackgroundResource(2130839033);
    }
  }
  
  public void setFooterView(View paramView)
  {
    LinearLayout localLinearLayout = this.r;
    if (localLinearLayout != null)
    {
      if (paramView == null)
      {
        localLinearLayout.setVisibility(8);
        return;
      }
      localLinearLayout.setVisibility(0);
      this.r.removeAllViews();
      this.r.setGravity(17);
      this.r.addView(paramView, -1, -2);
    }
  }
  
  public void setHeaderText(CharSequence paramCharSequence)
  {
    TextView localTextView = this.t;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  public void setHeaderView(View paramView)
  {
    LinearLayout localLinearLayout = this.q;
    if (localLinearLayout != null)
    {
      localLinearLayout.setVisibility(0);
      this.q.removeAllViews();
      this.q.setGravity(17);
      this.q.addView(paramView, -1, -2);
    }
  }
  
  public void setHeaderViewWrapContent(View paramView)
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      ((LinearLayout)localObject).setVisibility(0);
      localObject = (LinearLayout.LayoutParams)this.q.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = -1;
      ((LinearLayout.LayoutParams)localObject).height = -2;
      this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.q.removeAllViews();
      this.q.setGravity(17);
      this.q.addView(paramView, -1, -2);
    }
  }
  
  public void setHeight(int paramInt)
  {
    if (paramInt != 0)
    {
      this.y = paramInt;
      int i1 = this.y;
      if (i1 != 0) {
        this.j.a(i1);
      }
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.rootView.getLayoutParams();
      localLayoutParams.height = paramInt;
      this.rootView.setLayoutParams(localLayoutParams);
      this.rootView.invalidate();
    }
  }
  
  public void setLeftBtnTextColor(int paramInt)
  {
    Button localButton = this.n;
    if (localButton != null) {
      localButton.setTextColor(paramInt);
    }
  }
  
  @TargetApi(23)
  public void setLightStatusBar(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setSingleBtnClickListener(MMHalfBottomDialog.IBtnCallBack paramIBtnCallBack)
  {
    this.w = paramIBtnCallBack;
  }
  
  public void setSingleBtnColorStyle(int paramInt)
  {
    Button localButton = this.p;
    if (localButton != null)
    {
      localButton.setTextColor(this.b.getResources().getColor(2131165761));
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4)
              {
                if (paramInt != 5) {
                  return;
                }
                this.p.setBackgroundResource(2130839036);
                return;
              }
              this.p.setBackgroundResource(2130839030);
              return;
            }
            this.p.setBackgroundResource(2130839041);
            return;
          }
          this.p.setBackgroundResource(2130839037);
          return;
        }
        this.p.setBackgroundResource(2130839035);
        this.p.setTextColor(this.b.getResources().getColor(2131168468));
        return;
      }
      this.p.setBackgroundResource(2130839033);
    }
  }
  
  public void setSingleBtnText(CharSequence paramCharSequence)
  {
    Button localButton = this.p;
    if (localButton != null) {
      localButton.setText(paramCharSequence);
    }
  }
  
  public void setSingleBtnTextColor(int paramInt)
  {
    Button localButton = this.p;
    if (localButton != null) {
      localButton.setTextColor(paramInt);
    }
  }
  
  public void tryHide()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      Context localContext = this.b;
      if ((localContext instanceof Activity))
      {
        if ((localContext != null) && (!((Activity)localContext).isFinishing()) && (!((Activity)this.b).isDestroyed())) {
          this.a.dismiss();
        }
      }
      else {
        ((Dialog)localObject).dismiss();
      }
      localObject = this.j;
      if (localObject != null) {
        ((BottomSheetBehavior)localObject).b(true);
      }
    }
  }
  
  public void tryShow()
  {
    this.c = f();
    this.d = a();
    if (this.a != null)
    {
      ((ViewGroup)this.rootView.getParent()).setVisibility(0);
      e();
      if (Build.VERSION.SDK_INT >= 21) {
        this.a.getWindow().addFlags(-2147483648);
      }
      if (this.g) {
        d();
      }
      if (this.i)
      {
        this.a.getWindow().setFlags(8, 8);
        this.a.getWindow().addFlags(131200);
        this.a.getWindow().getDecorView().setSystemUiVisibility(6);
      }
      else
      {
        this.a.getWindow().clearFlags(8);
        this.a.getWindow().clearFlags(131072);
        this.a.getWindow().clearFlags(128);
        this.a.getWindow().getDecorView().setSystemUiVisibility(0);
      }
      if (this.e != null)
      {
        int i1;
        if (this.f == null) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        this.f = this.e.getViewTreeObserver();
        if (i1 != 0) {
          this.f.addOnGlobalLayoutListener(this);
        }
      }
      Object localObject = this.b;
      if (((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
        this.a.show();
      }
      localObject = this.j;
      if (localObject != null) {
        ((BottomSheetBehavior)localObject).b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog
 * JD-Core Version:    0.7.0.1
 */