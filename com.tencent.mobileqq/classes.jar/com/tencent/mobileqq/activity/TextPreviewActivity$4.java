package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.business.sougou.HightlightHotWordText;
import com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordItem;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatchCallback;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.widget.ContainerView;

class TextPreviewActivity$4
  implements WordMatchManager.MatchCallback
{
  TextPreviewActivity$4(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a(int paramInt, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
  {
    HightlightHotWordText.a(this.a.app, this.a.e, paramArrayOfHotWordItem);
    paramArrayOfHotWordItem = ColorNickManager.a(this.a.e, this.a.f, 30, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 13);
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this.a))
    {
      this.a.jdField_a_of_type_JavaLangCharSequence = paramArrayOfHotWordItem;
      return;
    }
    this.a.jdField_a_of_type_JavaLangCharSequence = null;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(paramArrayOfHotWordItem);
    this.a.i = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */