package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.business.sougou.WordMatchManager.MatcherCallback;
import com.tencent.mobileqq.business.sougou.WordMatchManager.WordMatcher;

class TextPreviewActivity$5
  implements WordMatchManager.MatcherCallback
{
  TextPreviewActivity$5(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a(WordMatchManager.WordMatcher paramWordMatcher)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = paramWordMatcher;
    if (this.a.i != 0) {
      paramWordMatcher.a(this.a.i);
    }
    this.a.i = paramWordMatcher.a(1, this.a.e, 3, this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity.5
 * JD-Core Version:    0.7.0.1
 */