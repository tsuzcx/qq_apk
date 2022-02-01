package com.tencent.mobileqq.banner;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqcontext.R.styleable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.theme.SkinnableBitmapDrawable;

public class TipsBar
  extends RelativeLayout
{
  protected TextView a;
  protected ImageView b;
  protected ImageView c;
  protected Button d;
  private int e;
  private final int f = ScreenUtil.dip2px(44.0F);
  private final int g = ScreenUtil.dip2px(28.0F);
  private final int h = ScreenUtil.dip2px(28.0F);
  private final int i = ScreenUtil.dip2px(16.0F);
  private final int j = ScreenUtil.dip2px(8.0F);
  private final int k = ScreenUtil.dip2px(12.0F);
  private final int l = ScreenUtil.dip2px(16.0F);
  private final int m = ScreenUtil.dip2px(16.0F);
  private final int n = ScreenUtil.dip2px(16.0F);
  private String o;
  private Drawable p;
  private String q;
  private final boolean r;
  private ImageView s;
  private final float t = getResources().getDisplayMetrics().density;
  private View.OnClickListener u;
  private View v;
  private View w;
  
  public TipsBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bQ);
    this.o = paramContext.getString(R.styleable.bV);
    this.p = paramContext.getDrawable(R.styleable.bU);
    this.q = paramContext.getString(R.styleable.bS);
    this.e = paramContext.getInt(R.styleable.bR, 2);
    this.r = paramContext.getBoolean(R.styleable.bT, false);
    paramContext.recycle();
    f();
  }
  
  protected static ColorStateList a(Resources paramResources, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 6)) {
      return paramResources.getColorStateList(2131168043);
    }
    return paramResources.getColorStateList(2131168043);
  }
  
  public static Drawable a(Resources paramResources)
  {
    return paramResources.getDrawable(2130839494);
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 2)
      {
        bool1 = bool2;
        if (paramInt != 3)
        {
          bool1 = bool2;
          if (paramInt != 4)
          {
            bool1 = bool2;
            if (paramInt != 5)
            {
              if (paramInt == 6) {
                return true;
              }
              bool1 = false;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  protected static ColorStateList d(Resources paramResources, int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 5) {
        return paramResources.getColorStateList(2131168001);
      }
      return paramResources.getColorStateList(2131168001);
    }
    return paramResources.getColorStateList(2131168204);
  }
  
  private Drawable e(Resources paramResources, int paramInt)
  {
    if (paramInt == 5) {
      paramResources = paramResources.getDrawable(2130839450);
    } else {
      paramResources = paramResources.getDrawable(2130839450);
    }
    return a(paramResources);
  }
  
  private void f()
  {
    setFocusable(true);
    setClickable(true);
    Resources localResources = getResources();
    this.s = new ImageView(getContext());
    this.s.setId(2131447449);
    this.s.setScaleType(ImageView.ScaleType.FIT_XY);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.g, this.h);
    localLayoutParams.leftMargin = this.i;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.s, localLayoutParams);
    this.a = new TextView(getContext());
    this.a.setId(2131447451);
    this.a.setSingleLine(true);
    this.a.setGravity(8388627);
    this.a.setEllipsize(TextUtils.TruncateAt.END);
    this.a.setTextSize(2, 14.0F);
    this.a.setTextColor(d(localResources, this.e));
    this.a.setDuplicateParentStateEnabled(true);
    if (!TextUtils.isEmpty(this.o))
    {
      this.a.setText(this.o);
      this.a.setContentDescription(this.o);
    }
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    int i1;
    if (this.p != null) {
      i1 = this.j;
    } else {
      i1 = this.i;
    }
    localLayoutParams.leftMargin = i1;
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(1, 2131447449);
    localLayoutParams.addRule(0, 2131447453);
    addView(this.a, localLayoutParams);
    this.s.setVisibility(8);
    setTipsIcon(this.p);
    this.d = i();
    this.c = c();
    this.b = g();
    if (!TextUtils.isEmpty(this.q)) {
      e();
    } else if (this.r) {
      d();
    } else {
      h();
    }
    this.w = new View(getContext());
    if (Build.VERSION.SDK_INT >= 21) {
      this.w.setBackgroundTintList(getResources().getColorStateList(2131168106));
    }
    localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    localLayoutParams.addRule(12);
    addView(this.w, localLayoutParams);
    setBackgroundDrawable(b(localResources, this.e));
    a();
  }
  
  private ImageView g()
  {
    Resources localResources = getResources();
    ImageView localImageView = new ImageView(getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localImageView.setImageDrawable(c(localResources, this.e));
    return localImageView;
  }
  
  private void h()
  {
    this.b.setId(2131447453);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.m, this.n);
    localLayoutParams.rightMargin = this.l;
    localLayoutParams.leftMargin = this.k;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.b, localLayoutParams);
  }
  
  private Button i()
  {
    Resources localResources = getResources();
    Button localButton = new Button(getContext());
    localButton.setText(this.q);
    localButton.setContentDescription(this.q);
    localButton.setTextSize(2, 14.0F);
    localButton.setTextColor(a(localResources, this.e));
    double d1 = this.t * 48.0F;
    Double.isNaN(d1);
    localButton.setMinWidth((int)(d1 + 0.5D));
    d1 = this.t * 24.0F;
    Double.isNaN(d1);
    localButton.setMinHeight((int)(d1 + 0.5D));
    localButton.setSingleLine(true);
    localButton.setEllipsize(TextUtils.TruncateAt.END);
    localButton.setGravity(17);
    localButton.setBackgroundDrawable(a(localResources));
    d1 = this.t * 10.0F;
    Double.isNaN(d1);
    int i1 = (int)(d1 + 0.5D);
    int i2 = i1 / 2;
    localButton.setPadding(i1, i2, i1, i2);
    localButton.setOnClickListener(this.u);
    return localButton;
  }
  
  Drawable a(Drawable paramDrawable)
  {
    boolean bool = paramDrawable instanceof SkinnableBitmapDrawable;
    if ((!bool) && (!(paramDrawable instanceof BitmapDrawable))) {
      return paramDrawable;
    }
    if (bool) {
      localObject1 = ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
    } else {
      localObject1 = ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap((Bitmap)localObject1);
    Resources localResources = getResources();
    if (localResources == null) {
      return paramDrawable;
    }
    if ((localObject1 != null) && (localBitmap == null))
    {
      localObject2 = localObject1;
    }
    else
    {
      localObject2 = localBitmap;
      if (localObject1 == null)
      {
        localObject2 = localBitmap;
        if (localBitmap == null) {
          return paramDrawable;
        }
      }
    }
    paramDrawable = new BitmapDrawable(localResources, (Bitmap)localObject1);
    Object localObject1 = new BitmapDrawable(localResources, (Bitmap)localObject2);
    ((BitmapDrawable)localObject1).setAlpha(127);
    Object localObject2 = new StateListDrawable();
    ((StateListDrawable)localObject2).addState(new int[] { 16842919, 16842910 }, (Drawable)localObject1);
    ((StateListDrawable)localObject2).addState(new int[] { 16842908 }, paramDrawable);
    ((StateListDrawable)localObject2).addState(new int[0], paramDrawable);
    return localObject2;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    if (this.b == null) {
      this.b = g();
    }
    removeView(this.b);
    removeView(this.d);
    removeView(this.c);
    if (paramBoolean) {
      h();
    }
  }
  
  protected Drawable b(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramResources = paramResources.getDrawable(2130839577);
      break;
    case 6: 
      paramResources = paramResources.getDrawable(2130839578);
      break;
    case 5: 
      paramResources = paramResources.getDrawable(2130839651);
      break;
    case 2: 
    case 3: 
      paramResources = paramResources.getDrawable(2130839577);
      break;
    case 1: 
    case 4: 
      paramResources = paramResources.getDrawable(2130839655);
    }
    return a(paramResources);
  }
  
  public View b()
  {
    return this.v;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.c == null) {
      this.c = c();
    }
    removeView(this.c);
    removeView(this.d);
    removeView(this.b);
    if (paramBoolean) {
      d();
    }
  }
  
  protected Drawable c(Resources paramResources, int paramInt)
  {
    if (paramInt == 5) {
      paramResources = paramResources.getDrawable(2130839650);
    } else {
      paramResources = paramResources.getDrawable(2130839449);
    }
    return a(paramResources);
  }
  
  protected ImageView c()
  {
    Object localObject = getResources();
    ImageView localImageView = new ImageView(getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localObject = e((Resources)localObject, this.e);
    localImageView.setPadding(15, 15, 15, 15);
    localImageView.setImageDrawable((Drawable)localObject);
    localImageView.setOnClickListener(new TipsBar.1(this));
    if (AppSetting.e) {
      localImageView.setContentDescription(HardCodeUtil.a(2131912293));
    }
    return localImageView;
  }
  
  protected void d()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((ImageView)localObject).setId(2131447453);
      localObject = new RelativeLayout.LayoutParams(this.m, this.n);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = this.l;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.k;
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      addView(this.c, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  protected void e()
  {
    if (this.d != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = this.l;
      localLayoutParams.leftMargin = this.k;
      this.d.setId(2131447453);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      addView(this.d, localLayoutParams);
    }
  }
  
  public int getBarType()
  {
    return this.e;
  }
  
  public Button getButton()
  {
    return this.d;
  }
  
  public TextView getTextView()
  {
    return this.a;
  }
  
  public ImageView getTipsIconView()
  {
    return this.s;
  }
  
  public String getTipsText()
  {
    return this.o;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.f, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.f);
  }
  
  public void setBarType(int paramInt)
  {
    if (a(paramInt))
    {
      if (paramInt == this.e) {
        return;
      }
      this.e = paramInt;
      Object localObject1 = getResources();
      Object localObject2 = this.a;
      if (localObject2 != null) {
        ((TextView)localObject2).setTextColor(d((Resources)localObject1, this.e));
      }
      setBackgroundDrawable(b((Resources)localObject1, this.e));
      if (this.b != null)
      {
        localObject2 = c((Resources)localObject1, this.e);
        this.b.setImageDrawable((Drawable)localObject2);
      }
      if (this.c != null)
      {
        localObject2 = e((Resources)localObject1, this.e);
        this.c.setImageDrawable((Drawable)localObject2);
      }
      localObject2 = this.d;
      if (localObject2 != null)
      {
        ((Button)localObject2).setTextColor(a((Resources)localObject1, this.e));
        this.d.setBackgroundDrawable(a((Resources)localObject1));
      }
      localObject1 = this.w;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundTintList(getResources().getColorStateList(2131168106));
      }
      return;
    }
    throw new RuntimeException("Parameter bgType is illegal!");
  }
  
  public void setButtonText(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return;
    }
    if (this.d == null) {
      this.d = i();
    }
    removeView(this.d);
    removeView(this.b);
    removeView(this.c);
    this.q = paramCharSequence.toString();
    this.d.setText(this.q);
    e();
  }
  
  public void setCloseListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      ImageView localImageView = this.c;
      if (localImageView != null) {
        localImageView.setOnClickListener(paramOnClickListener);
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.u = paramOnClickListener;
    if (!TextUtils.isEmpty(this.q))
    {
      paramOnClickListener = this.d;
      if (paramOnClickListener != null)
      {
        paramOnClickListener.setOnClickListener(this.u);
        return;
      }
    }
    super.setOnClickListener(this.u);
  }
  
  public void setOriginalOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setTipsIcon(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.leftMargin = this.j;
    this.a.setLayoutParams(localLayoutParams);
    this.s.setVisibility(0);
    if (QQTheme.isNowThemeSimpleNight())
    {
      this.s.setImageDrawable(paramDrawable);
      return;
    }
    this.p = a(paramDrawable);
    paramDrawable.setBounds(0, 0, this.g, this.h);
    this.s.setImageDrawable(this.p);
  }
  
  public void setTipsText(CharSequence paramCharSequence)
  {
    this.o = paramCharSequence.toString();
    this.a.setText(this.o);
    this.a.setContentDescription(this.o);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.TipsBar
 * JD-Core Version:    0.7.0.1
 */