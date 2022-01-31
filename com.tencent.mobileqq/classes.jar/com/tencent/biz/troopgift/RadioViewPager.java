package com.tencent.biz.troopgift;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class RadioViewPager
  extends RelativeLayout
{
  protected GridListViewPager a;
  protected RadioButtonIndicator a;
  
  public RadioViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RadioViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator = new RadioButtonIndicator(paramContext);
    this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator.setOrientation(0);
    paramAttributeSet = new RelativeLayout.LayoutParams(-2, -2);
    paramAttributeSet.addRule(12);
    paramAttributeSet.bottomMargin = 20;
    paramAttributeSet.addRule(14);
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager = new GridListViewPager(paramContext);
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager.setOnPagerSizeChangeListener(this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator);
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator);
    addView(this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager);
    addView(this.jdField_a_of_type_ComTencentBizTroopgiftRadioButtonIndicator, paramAttributeSet);
  }
  
  public absMultiViewPager a()
  {
    return this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager;
  }
  
  public void setGiftPanel(TroopGiftPanel paramTroopGiftPanel)
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftGridListViewPager.a = paramTroopGiftPanel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.RadioViewPager
 * JD-Core Version:    0.7.0.1
 */