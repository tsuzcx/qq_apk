package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.business.sougou.WordMatchManager.MatcherCallback;
import com.tencent.mobileqq.business.sougou.WordMatchManager.WordMatcher;

class TextPreviewActivity$4
  implements WordMatchManager.MatcherCallback
{
  TextPreviewActivity$4(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a(WordMatchManager.WordMatcher paramWordMatcher)
  {
    TextPreviewActivity localTextPreviewActivity = this.a;
    localTextPreviewActivity.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = paramWordMatcher;
    if (localTextPreviewActivity.i != 0) {
      paramWordMatcher.a(this.a.i);
    }
    localTextPreviewActivity = this.a;
    localTextPreviewActivity.i = paramWordMatcher.a(1, localTextPreviewActivity.e, 3, this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */