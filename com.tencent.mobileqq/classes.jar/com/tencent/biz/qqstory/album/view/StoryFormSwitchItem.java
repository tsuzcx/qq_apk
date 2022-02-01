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
  private CharSequence a;
  private int b;
  private boolean c;
  private int d;
  private int e;
  private TextView f;
  private Drawable l;
  private int m;
  private int n;
  private Drawable o;
  private int p;
  private int q;
  private Switch r;
  
  public StoryFormSwitchItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryFormSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = getResources().getDimensionPixelSize(2131298976);
    int j = getResources().getDimensionPixelSize(2131297097);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem);
    this.e = paramContext.getDimensionPixelSize(2, i);
    this.d = paramContext.getDimensionPixelSize(1, j);
    this.a = paramContext.getString(22);
    this.l = paramContext.getDrawable(6);
    this.m = paramContext.getDimensionPixelSize(8, 0);
    this.n = paramContext.getDimensionPixelSize(7, 0);
    this.n = Math.min(this.d, this.n);
    this.o = paramContext.getDrawable(13);
    this.p = paramContext.getDimensionPixelSize(15, 0);
    this.q = paramContext.getDimensionPixelSize(14, 0);
    this.q = Math.min(this.d, this.q);
    this.c = paramContext.getBoolean(20, false);
    this.b = paramContext.getInt(0, 0);
    paramContext.recycle();
    a();
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    return new ColorDrawable(-1);
  }
  
  private void a()
  {
    this.f = new TextView(getContext());
    this.f.setId(2131433633);
    if (!TextUtils.isEmpty(this.a)) {
      this.f.setText(this.a);
    }
    this.f.setSingleLine(true);
    int i = getContext().getResources().getDimensionPixelSize(2131297095);
    this.f.setTextSize(0, i);
    this.f.setTextColor(getResources().getColorStateList(2131167993));
    this.f.setGravity(19);
    this.f.setEllipsize(TextUtils.TruncateAt.END);
    setLeftIcon(this.l, this.m, this.n);
    setRightIcon(this.o, this.p, this.q);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.e;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.f, localLayoutParams);
    this.r = new Switch(getContext());
    this.r.setChecked(this.c);
    if ((AppSetting.e) && (Build.VERSION.SDK_INT >= 16))
    {
      AccessibilityUtil.a(this.f, false);
      AccessibilityUtil.a(this.r, false);
      if (TextUtils.isEmpty(getContentDescription())) {
        setContentDescription(this.f.getText());
      }
    }
    this.r.setId(2131433632);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.e;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.r, localLayoutParams);
    setBackgroundDrawable(a(getResources(), this.b));
  }
  
  public Switch getSwitch()
  {
    return this.r;
  }
  
  public TextView getTextView()
  {
    return this.f;
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Switch localSwitch = this.r;
    if ((localSwitch != null) && (localSwitch.getVisibility() != 8))
    {
      paramAccessibilityNodeInfo.setCheckable(true);
      paramAccessibilityNodeInfo.setChecked(this.r.isChecked());
      paramAccessibilityNodeInfo.setClassName(Switch.class.getName());
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.d, 1073741824));
      setMeasuredDimension(getMeasuredWidth(), this.d);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FormSwitchItem", 2, localException.toString());
      }
      setMinimumHeight(this.d);
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (AppSetting.e)
    {
      Switch localSwitch = this.r;
      if ((localSwitch != null) && (localSwitch.getVisibility() == 0))
      {
        if (paramMotionEvent.getAction() == 0)
        {
          super.onTouchEvent(paramMotionEvent);
          return true;
        }
        if (paramMotionEvent.getAction() == 1)
        {
          paramMotionEvent = this.r;
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
    this.b = paramInt;
    setBackgroundDrawable(a(getResources(), this.b));
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Switch localSwitch = this.r;
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
      this.d = paramInt;
      requestLayout();
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(false);
    Object localObject = this.f;
    if (localObject != null) {
      ((TextView)localObject).setEnabled(paramBoolean);
    }
    localObject = this.r;
    if (localObject != null) {
      ((Switch)localObject).setEnabled(paramBoolean);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    TextView localTextView = this.f;
    if (localTextView != null)
    {
      this.l = paramDrawable;
      if (paramDrawable == null)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      if (paramDrawable.getIntrinsicHeight() > this.d)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.d);
        this.f.setCompoundDrawables(paramDrawable, null, null, null);
      }
      else
      {
        this.f.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
      }
      this.f.setCompoundDrawablePadding(this.e);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable != null) && (this.f != null) && (paramInt1 >= 0))
    {
      if (paramInt2 < 0) {
        return;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.l = paramDrawable;
        this.m = paramInt1;
        this.n = Math.min(this.d, paramInt2);
        paramDrawable.setBounds(0, 0, this.m, this.n);
        this.f.setCompoundDrawables(null, null, paramDrawable, null);
        this.f.setCompoundDrawablePadding(this.e);
        return;
      }
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        setRightIcon(paramDrawable);
      }
    }
  }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    Switch localSwitch = this.r;
    if (localSwitch != null) {
      localSwitch.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable)
  {
    TextView localTextView = this.f;
    if (localTextView != null)
    {
      this.o = paramDrawable;
      if (paramDrawable == null)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      if (paramDrawable.getIntrinsicHeight() > this.d)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.d);
        this.f.setCompoundDrawables(null, null, paramDrawable, null);
      }
      else
      {
        this.f.setCompoundDrawablesWithIntrinsicBounds(null, null, paramDrawable, null);
      }
      this.f.setCompoundDrawablePadding(this.e);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable != null) && (this.f != null) && (paramInt1 >= 0))
    {
      if (paramInt2 < 0) {
        return;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.o = paramDrawable;
        this.p = paramInt1;
        this.q = Math.min(this.d, paramInt2);
        paramDrawable.setBounds(0, 0, this.p, this.q);
        this.f.setCompoundDrawables(null, null, paramDrawable, null);
        this.f.setCompoundDrawablePadding(this.e);
        return;
      }
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        setRightIcon(paramDrawable);
      }
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (this.f != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        this.a = paramCharSequence;
        this.f.setText(this.a);
        this.f.setTextColor(getResources().getColorStateList(2131167993));
        return;
      }
      this.f.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.StoryFormSwitchItem
 * JD-Core Version:    0.7.0.1
 */