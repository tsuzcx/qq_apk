package com.tencent.biz.addContactTroopView;

import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.troop_search_popclassifc.popclassifc.BannerCard;

class TroopCardBanner$1
  implements ViewPager.OnPageChangeListener
{
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if ((this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard != null) && (this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size() > 1))
    {
      if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837973);
      }
      paramInt %= this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size();
      ((ImageView)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).setImageResource(2130837972);
      TroopCardBanner localTroopCardBanner = this.a;
      localTroopCardBanner.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localTroopCardBanner.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardBanner.1
 * JD-Core Version:    0.7.0.1
 */