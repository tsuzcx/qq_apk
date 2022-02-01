package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OnOptionSelectedListener;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OptionItem;

class TextPreviewTranslateActivity$3
  implements TranslateLanguageOptionsView.OnOptionSelectedListener
{
  TextPreviewTranslateActivity$3(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public void a(int paramInt, TranslateLanguageOptionsView.OptionItem paramOptionItem)
  {
    if ((!TextUtils.isEmpty(TextPreviewTranslateActivity.a(this.a))) && (!TextPreviewTranslateActivity.a(this.a).equals(paramOptionItem.b)))
    {
      TextPreviewTranslateActivity.a(this.a, paramOptionItem.b);
      paramOptionItem = this.a;
      TextPreviewTranslateActivity.a(paramOptionItem, TextPreviewTranslateActivity.b(paramOptionItem, TextPreviewTranslateActivity.c(paramOptionItem)), TextPreviewTranslateActivity.a(this.a), TextPreviewTranslateActivity.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity.3
 * JD-Core Version:    0.7.0.1
 */