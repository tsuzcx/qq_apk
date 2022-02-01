package com.tencent.mobileqq.activity.aio;

import afbx;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;

public class IntimateTitleSwitchView
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  afbx jdField_a_of_type_Afbx;
  Context jdField_a_of_type_AndroidContentContext;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TickerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  Runnable jdField_a_of_type_JavaLangRunnable = new IntimateTitleSwitchView.1(this);
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  TextView c;
  
  public IntimateTitleSwitchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateTitleSwitchView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateTitleSwitchView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2131559286, this, true);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramContext.findViewById(2131368819));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView = ((TickerView)paramContext.findViewById(2131368807));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131368806));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131368804));
    this.c = ((TextView)paramContext.findViewById(2131362174));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setCharacterLists(new String[] { "9876543210" });
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setAnimationDuration(2000L);
    this.jdField_a_of_type_AndroidViewViewGroup.setTranslationX(0.0F);
  }
  
  private boolean a()
  {
    boolean bool = true;
    if (this.jdField_b_of_type_Int == 4) {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IntimateTitleSwitchView", 0, "canUpdateAnim res: " + bool + "  mCurrentShowType:" + this.jdField_b_of_type_Int);
    }
    return bool;
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "checkAndStartUpdateAnim mIsResumed:" + this.jdField_a_of_type_Boolean + " mCurrentShowType:" + this.jdField_b_of_type_Int + " mIntimateInfo:" + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null))
    {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays != this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays > 0)) {
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
      }
    }
  }
  
  private void g()
  {
    int k = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays);
    int j = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays);
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "smoothUpdateDays fromDays:" + k + " toDays:" + j);
    }
    if (k <= 0)
    {
      int m = String.valueOf(j).length();
      localObject = "";
      i = 0;
      while ((i < m) && (i < 5))
      {
        localObject = (String)localObject + "0";
        i += 1;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText((String)localObject, false);
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView;
    if (j > k) {}
    for (int i = 1;; i = 2)
    {
      ((TickerView)localObject).setPreferredScrollingDirection(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setDigitalAnimWidthSpeedIncrement(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setIgnoreWidthAnim(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(String.valueOf(j));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_Afbx != null) {
        this.jdField_a_of_type_Afbx.m();
      }
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "onDrawerOpened mIsResumed:" + this.jdField_a_of_type_Boolean);
    }
    f();
  }
  
  public void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.jdField_a_of_type_Int = paramInt;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays;
    int i = j;
    if (a())
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays > 0) {
        i = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("IntimateTitleSwitchView", 0, "updateIntimateInfo beFriendDays: " + i);
    }
    if (i >= -1) {
      if (i == 0)
      {
        str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693127);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(str, false);
        if (paramInt == 3)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693129);
          this.c.setBackgroundResource(2130840474);
          j = 2131165727;
          i = 2131165726;
          paramInt = 2130840474;
          label160:
          if (TextUtils.isEmpty(paramIntimateInfo.addFriendWording)) {
            break label458;
          }
          this.c.setText(paramIntimateInfo.addFriendWording);
          this.c.setVisibility(0);
          label189:
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
          this.c.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(i));
          this.c.setBackgroundResource(paramInt);
          label272:
          f();
        }
      }
      else
      {
        if (i != -1) {
          break label508;
        }
      }
    }
    label458:
    label508:
    for (String str = "999+";; str = String.valueOf(i))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      if (paramInt == 2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693128);
        this.c.setBackgroundResource(2130840472);
        j = 2131165725;
        i = 2131165724;
        paramInt = 2130840472;
        break label160;
      }
      if (paramInt == 26)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693131);
        this.c.setBackgroundResource(2130840489);
        j = 2131165731;
        i = 2131165730;
        paramInt = 2130840489;
        break label160;
      }
      if (paramInt == 1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693130);
        this.c.setBackgroundResource(2130840476);
        j = 2131165729;
        i = 2131165728;
        paramInt = 2130840476;
        break label160;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693125);
      this.c.setBackgroundResource(2130840470);
      j = 2131165732;
      i = 2131165733;
      paramInt = 2130840470;
      break label160;
      this.c.setVisibility(8);
      break label189;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.c.setVisibility(4);
      break label272;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "onDrawerClosed mIsResumed:" + this.jdField_a_of_type_Boolean);
    }
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IntimateTitleSwitchView", 0, "onResumed mIsOpened:" + this.jdField_b_of_type_Boolean);
      }
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "onResumed mIsResumed:" + this.jdField_a_of_type_Boolean);
    }
    f();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "onPaused mIsResumed:" + this.jdField_a_of_type_Boolean);
    }
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Afbx = null;
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void setCallBack(afbx paramafbx)
  {
    this.jdField_a_of_type_Afbx = paramafbx;
  }
  
  public void setCurrentShowType(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateTitleSwitchView", 0, "setCurrentShowType showType: " + paramInt + "  old:" + this.jdField_b_of_type_Int + "  this:" + this);
    }
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView
 * JD-Core Version:    0.7.0.1
 */