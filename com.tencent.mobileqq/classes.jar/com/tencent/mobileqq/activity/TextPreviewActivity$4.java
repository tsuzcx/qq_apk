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
    localTextPreviewActivity.ab = paramWordMatcher;
    if (localTextPreviewActivity.ac != 0) {
      paramWordMatcher.a(this.a.ac);
    }
    localTextPreviewActivity = this.a;
    localTextPreviewActivity.ac = paramWordMatcher.a(1, localTextPreviewActivity.h, 3, this.a.ae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */