package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ShortVideoPTVItemBuilder$1
  implements ActionSheet.OnButtonClickListener
{
  ShortVideoPTVItemBuilder$1(ShortVideoPTVItemBuilder paramShortVideoPTVItemBuilder, MessageForShortVideo paramMessageForShortVideo, ShortVideoPTVItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag == 2) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$Holder);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder$Holder);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */