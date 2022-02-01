package com.tencent.mobileqq.banner;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.theme.SkinnableBitmapDrawable;

public class TipsBar
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  protected ImageView b;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public TipsBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Resources localResources = getResources();
    this.jdField_a_of_type_Float = localResources.getDisplayMetrics().density;
    this.jdField_b_of_type_Int = localResources.getDimensionPixelSize(2131298534);
    this.e = localResources.getDimensionPixelSize(2131298536);
    this.f = localResources.getDimensionPixelSize(2131298538);
    this.jdField_c_of_type_Int = localResources.getDimensionPixelSize(2131298537);
    this.d = localResources.getDimensionPixelSize(2131298537);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bM);
    this.jdField_a_of_type_JavaLangString = paramContext.getString(R.styleable.j);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(R.styleable.i);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(R.styleable.e);
    this.jdField_a_of_type_Int = paramContext.getInt(R.styleable.d, 2);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(R.styleable.h, false);
    this.g = paramContext.getDimensionPixelSize(R.styleable.g, this.jdField_c_of_type_Int);
    this.h = paramContext.getDimensionPixelSize(R.styleable.f, this.d);
    paramContext.recycle();
    d();
  }
  
  protected static ColorStateList a(Resources paramResources, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 6)) {
      return paramResources.getColorStateList(2131167091);
    }
    return paramResources.getColorStateList(2131167091);
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    return paramResources.getDrawable(2130839314);
  }
  
  protected static ColorStateList b(Resources paramResources, int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 5) {
        return paramResources.getColorStateList(2131167063);
      }
      return paramResources.getColorStateList(2131167063);
    }
    return paramResources.getColorStateList(2131167214);
  }
  
  private Button b()
  {
    Resources localResources = getResources();
    Button localButton = new Button(getContext());
    localButton.setText(this.jdField_b_of_type_JavaLangString);
    localButton.setContentDescription(this.jdField_b_of_type_JavaLangString);
    localButton.setTextSize(2, 14.0F);
    localButton.setTextColor(a(localResources, this.jdField_a_of_type_Int));
    double d1 = this.jdField_a_of_type_Float * 48.0F;
    Double.isNaN(d1);
    localButton.setMinWidth((int)(d1 + 0.5D));
    d1 = this.jdField_a_of_type_Float * 24.0F;
    Double.isNaN(d1);
    localButton.setMinHeight((int)(d1 + 0.5D));
    localButton.setSingleLine(true);
    localButton.setEllipsize(TextUtils.TruncateAt.END);
    localButton.setGravity(17);
    localButton.setBackgroundDrawable(a(localResources, this.jdField_a_of_type_Int));
    d1 = this.jdField_a_of_type_Float * 10.0F;
    Double.isNaN(d1);
    int i = (int)(d1 + 0.5D);
    int j = i / 2;
    localButton.setPadding(i, j, i, j);
    localButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return localButton;
  }
  
  private ImageView c()
  {
    Resources localResources = getResources();
    ImageView localImageView = new ImageView(getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localImageView.setImageDrawable(c(localResources, this.jdField_a_of_type_Int));
    return localImageView;
  }
  
  private Drawable d(Resources paramResources, int paramInt)
  {
    if (paramInt != 5) {
      paramResources = paramResources.getDrawable(2130839470);
    } else {
      paramResources = paramResources.getDrawable(2130839470);
    }
    return a(paramResources);
  }
  
  private void d()
  {
    setFocusable(true);
    setClickable(true);
    Resources localResources = getResources();
    this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_c_of_type_AndroidWidgetImageView.setId(2131378774);
    this.jdField_c_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = new RelativeLayout.LayoutParams(this.g, this.h);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = this.e;
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131378775);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(b(localResources, this.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangString);
    }
    localObject = new RelativeLayout.LayoutParams(-2, -1);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.f;
    } else {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.e;
    }
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131378774);
    ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131378776);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null) {
      setTipsIcon((Drawable)localObject, this.g, this.h);
    }
    this.jdField_a_of_type_AndroidWidgetButton = b();
    this.jdField_b_of_type_AndroidWidgetImageView = a();
    this.jdField_a_of_type_AndroidWidgetImageView = c();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      c();
    } else if (this.jdField_a_of_type_Boolean) {
      b();
    } else {
      e();
    }
    setBackgroundDrawable(b(localResources, this.jdField_a_of_type_Int));
    a();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131378776);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    int i = this.e;
    localLayoutParams.rightMargin = i;
    localLayoutParams.leftMargin = i;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  Drawable a(Drawable paramDrawable)
  {
    boolean bool = paramDrawable instanceof SkinnableBitmapDrawable;
    if ((!bool) && (!(paramDrawable instanceof BitmapDrawable))) {
      return paramDrawable;
    }
    Object localObject1 = null;
    if (bool) {
      localObject1 = ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
    } else if ((paramDrawable instanceof BitmapDrawable)) {
      localObject1 = ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap((Bitmap)localObject1);
    Resources localResources = getResources();
    if (localResources != null)
    {
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
      localObject1 = new BitmapDrawable(localResources, (Bitmap)localObject2);
      ((BitmapDrawable)localObject1).setAlpha(127);
      Object localObject2 = new StateListDrawable();
      ((StateListDrawable)localObject2).addState(new int[] { 16842919, 16842910 }, (Drawable)localObject1);
      ((StateListDrawable)localObject2).addState(new int[] { 16842908 }, paramDrawable);
      ((StateListDrawable)localObject2).addState(new int[0], paramDrawable);
      return localObject2;
    }
    return paramDrawable;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public Button a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  protected ImageView a()
  {
    Object localObject = getResources();
    ImageView localImageView = new ImageView(getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localObject = d((Resources)localObject, this.jdField_a_of_type_Int);
    localImageView.setPadding(15, 15, 15, 15);
    localImageView.setImageDrawable((Drawable)localObject);
    localImageView.setOnClickListener(new TipsBar.1(this));
    if (AppSetting.d) {
      localImageView.setContentDescription(HardCodeUtil.a(2131714790));
    }
    return localImageView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a()
  {
    Object localObject;
    if (QQTheme.a())
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidViewView = new View(getContext());
        this.jdField_a_of_type_AndroidViewView.setId(2131378773);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#7f000000"));
        addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null)
      {
        removeView((View)localObject);
        this.jdField_a_of_type_AndroidViewView = null;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = c();
    }
    removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    removeView(this.jdField_a_of_type_AndroidWidgetButton);
    removeView(this.jdField_b_of_type_AndroidWidgetImageView);
    if (paramBoolean) {
      e();
    }
  }
  
  protected Drawable b(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramResources = paramResources.getDrawable(2130839393);
      break;
    case 6: 
      paramResources = paramResources.getDrawable(2130839394);
      break;
    case 5: 
      paramResources = paramResources.getDrawable(2130839462);
      break;
    case 2: 
    case 3: 
      paramResources = paramResources.getDrawable(2130839393);
      break;
    case 1: 
    case 4: 
      paramResources = paramResources.getDrawable(2130839466);
    }
    return a(paramResources);
  }
  
  public ImageView b()
  {
    return this.jdField_c_of_type_AndroidWidgetImageView;
  }
  
  protected void b()
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      ((ImageView)localObject).setId(2131378776);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      int i = this.e;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      this.jdField_b_of_type_AndroidWidgetImageView = a();
    }
    removeView(this.jdField_b_of_type_AndroidWidgetImageView);
    removeView(this.jdField_a_of_type_AndroidWidgetButton);
    removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    if (paramBoolean) {
      b();
    }
  }
  
  protected Drawable c(Resources paramResources, int paramInt)
  {
    if (paramInt != 5) {
      paramResources = paramResources.getDrawable(2130850483);
    } else {
      paramResources = paramResources.getDrawable(2130839461);
    }
    return a(paramResources);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      int i = this.e;
      localLayoutParams.rightMargin = i;
      localLayoutParams.leftMargin = i;
      this.jdField_a_of_type_AndroidWidgetButton.setId(2131378776);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetButton, localLayoutParams);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_Int, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.jdField_b_of_type_Int);
  }
  
  public void setBarType(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    Resources localResources = getResources();
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(b(localResources, this.jdField_a_of_type_Int));
    }
    setBackgroundDrawable(b(localResources, this.jdField_a_of_type_Int));
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = c(localResources, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      localObject = d(localResources, this.jdField_a_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetButton;
    if (localObject != null)
    {
      ((Button)localObject).setTextColor(a(localResources, this.jdField_a_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(a(localResources, this.jdField_a_of_type_Int));
    }
  }
  
  public void setButtonText(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.jdField_a_of_type_AndroidWidgetButton == null) {
        this.jdField_a_of_type_AndroidWidgetButton = b();
      }
      removeView(this.jdField_a_of_type_AndroidWidgetButton);
      removeView(this.jdField_a_of_type_AndroidWidgetImageView);
      removeView(this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_b_of_type_JavaLangString = paramCharSequence.toString();
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_b_of_type_JavaLangString);
      c();
    }
  }
  
  public void setCloseListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setOnClickListener(paramOnClickListener);
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      paramOnClickListener = this.jdField_a_of_type_AndroidWidgetButton;
      if (paramOnClickListener != null)
      {
        paramOnClickListener.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        return;
      }
    }
    super.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = this.f;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramDrawable);
    int i = paramDrawable.getIntrinsicHeight();
    paramDrawable.setBounds(0, 0, this.jdField_c_of_type_Int, this.d);
    if (i > this.jdField_b_of_type_Int)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setTipsIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramInt1 >= 0))
    {
      if (paramInt2 < 0) {
        return;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramDrawable);
        this.g = paramInt1;
        this.h = Math.min(this.jdField_b_of_type_Int, paramInt2);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.g, this.h);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        setTipsIcon(paramDrawable);
      }
    }
  }
  
  public void setTipsText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.banner.TipsBar
 * JD-Core Version:    0.7.0.1
 */