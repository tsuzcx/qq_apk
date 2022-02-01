package com.tencent.biz.qqstory.album.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.FormItemConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class StoryFormSwitchItem
  extends RelativeLayout
  implements FormItemConstants
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private Drawable b;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public StoryFormSwitchItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryFormSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int m = getResources().getDimensionPixelSize(2131298275);
    int n = getResources().getDimensionPixelSize(2131296766);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem);
    this.h = paramContext.getDimensionPixelSize(2, m);
    this.g = paramContext.getDimensionPixelSize(1, n);
    this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(22);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(6);
    this.i = paramContext.getDimensionPixelSize(8, 0);
    this.j = paramContext.getDimensionPixelSize(7, 0);
    this.j = Math.min(this.g, this.j);
    this.b = paramContext.getDrawable(13);
    this.k = paramContext.getDimensionPixelSize(15, 0);
    this.l = paramContext.getDimensionPixelSize(14, 0);
    this.l = Math.min(this.g, this.l);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(20, false);
    this.jdField_a_of_type_Int = paramContext.getInt(0, 0);
    paramContext.recycle();
    a();
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    return new ColorDrawable(-1);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367177);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    int m = getContext().getResources().getDimensionPixelSize(2131296764);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, m);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167056));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.i, this.j);
    setRightIcon(this.b, this.k, this.l);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.h;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetSwitch = new Switch(getContext());
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_a_of_type_Boolean);
    if ((AppSetting.d) && (Build.VERSION.SDK_INT >= 16))
    {
      AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, false);
      AccessibilityUtil.a(this.jdField_a_of_type_ComTencentWidgetSwitch, false);
      if (TextUtils.isEmpty(getContentDescription())) {
        setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setId(2131367176);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.h;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_ComTencentWidgetSwitch, localLayoutParams);
    setBackgroundDrawable(a(getResources(), this.jdField_a_of_type_Int));
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Switch localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
    if ((localSwitch != null) && (localSwitch.getVisibility() != 8))
    {
      paramAccessibilityNodeInfo.setCheckable(true);
      paramAccessibilityNodeInfo.setChecked(this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked());
      paramAccessibilityNodeInfo.setClassName(Switch.class.getName());
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.g, 1073741824));
      setMeasuredDimension(getMeasuredWidth(), this.g);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FormSwitchItem", 2, localException.toString());
      }
      setMinimumHeight(this.g);
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (AppSetting.d)
    {
      Switch localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
      if ((localSwitch != null) && (localSwitch.getVisibility() == 0))
      {
        if (paramMotionEvent.getAction() == 0)
        {
          super.onTouchEvent(paramMotionEvent);
          return true;
        }
        if (paramMotionEvent.getAction() == 1)
        {
          paramMotionEvent = this.jdField_a_of_type_ComTencentWidgetSwitch;
          paramMotionEvent.setChecked(paramMotionEvent.isChecked() ^ true);
        }
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.jdField_a_of_type_Int = paramInt;
    setBackgroundDrawable(a(getResources(), this.jdField_a_of_type_Int));
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Switch localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
    if (localSwitch != null)
    {
      localSwitch.setChecked(paramBoolean);
      sendAccessibilityEvent(1);
    }
  }
  
  public void setCustomHeight(int paramInt)
  {
    if (paramInt > 0)
    {
      this.g = paramInt;
      requestLayout();
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(false);
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setEnabled(paramBoolean);
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
    if (localObject != null) {
      ((Switch)localObject).setEnabled(paramBoolean);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      if (paramDrawable.getIntrinsicHeight() > this.g)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.g);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.h);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramInt1 >= 0))
    {
      if (paramInt2 < 0) {
        return;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.i = paramInt1;
        this.j = Math.min(this.g, paramInt2);
        paramDrawable.setBounds(0, 0, this.i, this.j);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.h);
        return;
      }
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        setRightIcon(paramDrawable);
      }
    }
  }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    Switch localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
    if (localSwitch != null) {
      localSwitch.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      this.b = paramDrawable;
      if (paramDrawable == null)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      if (paramDrawable.getIntrinsicHeight() > this.g)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.g);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramDrawable, null);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.h);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramInt1 >= 0))
    {
      if (paramInt2 < 0) {
        return;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.b = paramDrawable;
        this.k = paramInt1;
        this.l = Math.min(this.g, paramInt2);
        paramDrawable.setBounds(0, 0, this.k, this.l);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.h);
        return;
      }
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        setRightIcon(paramDrawable);
      }
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167056));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.StoryFormSwitchItem
 * JD-Core Version:    0.7.0.1
 */