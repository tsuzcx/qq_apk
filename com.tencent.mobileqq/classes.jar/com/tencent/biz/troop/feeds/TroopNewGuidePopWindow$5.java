package com.tencent.biz.troop.feeds;

import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.utils.DisplayUtils;

class TroopNewGuidePopWindow$5
  implements URLDrawable.URLDrawableListener
{
  TroopNewGuidePopWindow$5(TroopNewGuidePopWindow paramTroopNewGuidePopWindow, DisplayMetrics paramDisplayMetrics) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.c = false;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.c = false;
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
    float f1 = paramURLDrawable.getIntrinsicHeight();
    float f2 = paramURLDrawable.getIntrinsicWidth();
    paramURLDrawable = this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    int i;
    if (f2 != 0.0F)
    {
      if (f1 > DisplayUtils.a(this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F)) {
        i = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F);
      } else {
        i = (int)((this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - DisplayUtils.a(this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 60.0F)) * (f1 / f2));
      }
    }
    else {
      i = 0;
    }
    if (i > 0)
    {
      paramURLDrawable.height = i;
      this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.5
 * JD-Core Version:    0.7.0.1
 */