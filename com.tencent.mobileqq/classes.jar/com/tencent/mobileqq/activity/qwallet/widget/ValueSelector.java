package com.tencent.mobileqq.activity.qwallet.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.PriceSettingDialog.OnPriceSelectedListener;
import com.tencent.mobileqq.activity.qwallet.PriceSettingDialog.PriceTextWater;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class ValueSelector
  extends HorizontalLabelLayout
  implements View.OnClickListener, View.OnFocusChangeListener, ViewTreeObserver.OnPreDrawListener
{
  private View.OnFocusChangeListener mFocusChanged;
  private float mHSpacing = 10.5F;
  private long mMaxValue;
  private String mMaxWarn;
  private long mMinValue;
  private String mMinWarn;
  private int mRecommendWidth;
  private View mSelectedView;
  private int mTabCount = 3;
  private float mVSpacing = 10.0F;
  private EditText mValueEt;
  PriceSettingDialog.OnPriceSelectedListener mValueListener;
  private ArrayList mValues;
  private TextWatcher mWatcher;
  
  public ValueSelector(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ValueSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ValueSelector(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    getViewTreeObserver().addOnPreDrawListener(this);
    setFocusableInTouchMode(true);
  }
  
  private void selectView(View paramView)
  {
    if ((paramView != this.mValueEt) && (this.mValueEt.hasFocus()))
    {
      this.mValueEt.clearFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mValueEt.getWindowToken(), 0);
    }
    if (this.mSelectedView != null) {
      this.mSelectedView.setSelected(false);
    }
    if (paramView != null) {
      paramView.setSelected(true);
    }
    this.mSelectedView = paramView;
  }
  
  public Long checkAndQueryInputValue()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2;
    if (this.mSelectedView != null) {
      if (this.mSelectedView == this.mValueEt)
      {
        localObject1 = this.mValueEt.getText().toString();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          try
          {
            long l = Math.round(Double.valueOf((String)localObject1).doubleValue() * 100.0D);
            if (l < this.mMinValue)
            {
              QQToast.a(getContext(), this.mMinWarn, 0).a();
              localObject1 = null;
            }
            else if (l > this.mMaxValue)
            {
              QQToast.a(getContext(), this.mMaxWarn, 0).a();
              localObject1 = null;
            }
            else
            {
              localObject1 = Long.valueOf(l);
            }
          }
          catch (Exception localException)
          {
            QQToast.a(getContext(), 2131432271, 0).a();
            return null;
          }
        }
        else
        {
          QQToast.a(getContext(), 2131432271, 0).a();
          return null;
        }
      }
      else
      {
        Object localObject4 = this.mSelectedView.getTag();
        localObject2 = localObject3;
        if ((localObject4 instanceof Long)) {
          return (Long)localObject4;
        }
      }
    }
    return localObject2;
  }
  
  public boolean checkIsInputEmpty()
  {
    return this.mSelectedView == null;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof Long))
    {
      long l = ((Long)localObject).longValue();
      selectView(paramView);
      if (this.mValueListener != null) {
        this.mValueListener.a(l);
      }
      return;
    }
    selectView(null);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      selectView(paramView);
      this.mValueEt.setText("");
    }
    for (;;)
    {
      if (this.mFocusChanged != null) {
        this.mFocusChanged.onFocusChange(paramView, paramBoolean);
      }
      return;
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
  }
  
  public boolean onPreDraw()
  {
    this.mRecommendWidth = getMeasuredWidth();
    getViewTreeObserver().removeOnPreDrawListener(this);
    refreshRecommendView();
    return true;
  }
  
  void refreshRecommendView()
  {
    int i = 1;
    removeAllViews();
    if ((this.mRecommendWidth > 0) && (this.mValues != null))
    {
      int j = this.mValues.size();
      Object localObject1 = getContext();
      Object localObject2 = ((Context)localObject1).getResources();
      int k = AIOUtils.a(this.mHSpacing, (Resources)localObject2);
      setHorizontalSpacing(k);
      setVerticalSpacing(AIOUtils.a(this.mVSpacing, (Resources)localObject2));
      if (this.mTabCount >= 1) {
        i = this.mTabCount;
      }
      localObject2 = new LinearLayout.LayoutParams((this.mRecommendWidth - k * (i - 1) - getPaddingLeft() - getPaddingRight()) / i, -2);
      i = 0;
      while (i < j)
      {
        View localView = LayoutInflater.from((Context)localObject1).inflate(2130969017, null);
        Button localButton = (Button)localView.findViewById(2131364712);
        Long localLong = (Long)this.mValues.get(i);
        localButton.setText(NumAnim.formatNumber(localLong.longValue() / 100.0D, false) + "元");
        localButton.setTag(localLong);
        localButton.setOnClickListener(this);
        if ((localLong.longValue() < this.mMinValue) || (localLong.longValue() > this.mMaxValue)) {
          localButton.setEnabled(false);
        }
        addView(localView, (ViewGroup.LayoutParams)localObject2);
        i += 1;
      }
      localObject1 = LayoutInflater.from((Context)localObject1).inflate(2130969016, null);
      this.mValueEt = ((EditText)((View)localObject1).findViewById(2131364711));
      this.mValueEt.setOnFocusChangeListener(this);
      this.mValueEt.addTextChangedListener(this.mWatcher);
      this.mValueEt.setInputType(8194);
      addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      setOnClickListener(this);
    }
  }
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mFocusChanged = paramOnFocusChangeListener;
  }
  
  public void setRange(long paramLong1, long paramLong2)
  {
    this.mMinValue = paramLong1;
    this.mMaxValue = paramLong2;
    Resources localResources = getContext().getResources();
    this.mMinWarn = String.format(localResources.getString(2131432283), new Object[] { NumAnim.formatNumber(paramLong1 / 100.0D, false) });
    this.mMaxWarn = String.format(localResources.getString(2131432284), new Object[] { NumAnim.formatNumber(paramLong2 / 100.0D, false) });
    this.mWatcher = new PriceSettingDialog.PriceTextWater(getContext(), paramLong1, paramLong2, this.mMinWarn, this.mMaxWarn);
    if (this.mValueEt != null) {
      this.mValueEt.addTextChangedListener(this.mWatcher);
    }
  }
  
  public void setValueAndDisplay(ArrayList paramArrayList)
  {
    this.mValues = paramArrayList;
    if (paramArrayList == null)
    {
      this.mValues = new ArrayList();
      this.mValues.add(Long.valueOf(1L));
      this.mValues.add(Long.valueOf(66L));
      this.mValues.add(Long.valueOf(88L));
      this.mValues.add(Long.valueOf(100L));
      this.mValues.add(Long.valueOf(520L));
    }
    refreshRecommendView();
  }
  
  public void setValueSelectListener(PriceSettingDialog.OnPriceSelectedListener paramOnPriceSelectedListener)
  {
    this.mValueListener = paramOnPriceSelectedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.ValueSelector
 * JD-Core Version:    0.7.0.1
 */