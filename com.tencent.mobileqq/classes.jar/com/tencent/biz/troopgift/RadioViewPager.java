package com.tencent.biz.troopgift;

import aaig;
import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RadioViewPager
  extends RelativeLayout
{
  protected View a;
  protected TextView a;
  protected GridListViewPager a;
  protected RadioButtonIndicator a;
  protected TextView b;
  protected TextView c;
  
  public RadioViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RadioViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(2131560681, this, false);
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager = ((GridListViewPager)paramContext.findViewById(2131372396));
    this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator = ((RadioButtonIndicator)paramContext.findViewById(2131368814));
    this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator.setOrientation(0);
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager.setOnPagerSizeChangeListener(this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator);
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131367734);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131367732));
    this.c = ((TextView)paramContext.findViewById(2131367733));
    this.b = ((TextView)paramContext.findViewById(2131367731));
    this.c.getPaint().setFlags(8);
    this.c.getPaint().setAntiAlias(true);
    addView(paramContext);
  }
  
  public absMultiViewPager a()
  {
    return this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager;
  }
  
  public void setEmptyInfo(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.c.setText(paramString2);
    }
  }
  
  public void setGiftPanel(TroopGiftPanel paramTroopGiftPanel)
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager.a = paramTroopGiftPanel;
  }
  
  public void setIsListEmpty(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setIsShowJumpInfo(boolean paramBoolean, String paramString, Context paramContext)
  {
    int j = 0;
    TextView localTextView = this.c;
    if (paramBoolean)
    {
      i = 0;
      localTextView.setVisibility(i);
      localTextView = this.b;
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (int i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
        this.c.setOnClickListener(new aaig(this, paramContext, paramString));
      }
      return;
      i = 8;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.RadioViewPager
 * JD-Core Version:    0.7.0.1
 */