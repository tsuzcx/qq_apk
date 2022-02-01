package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.ocr.OCRObserver;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.widget.QQToast;

class TextPreviewTranslateActivity$2
  extends OCRObserver
{
  TextPreviewTranslateActivity$2(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, TranslateResult paramTranslateResult)
  {
    TextPreviewTranslateActivity.b(this.a);
    if ((paramBoolean) && (paramTranslateResult != null) && (paramTranslateResult.b()) && (!paramTranslateResult.a()))
    {
      TextPreviewTranslateActivity.a(this.a, paramTranslateResult);
      return;
    }
    String str2 = this.a.getResources().getString(2131699088);
    String str1 = str2;
    if (paramTranslateResult != null) {
      if (!TextUtils.isEmpty(paramTranslateResult.e))
      {
        str1 = paramTranslateResult.e;
      }
      else
      {
        str1 = str2;
        if (paramTranslateResult.a()) {
          str1 = this.a.getResources().getString(2131699075);
        }
      }
    }
    QQToast.a(this.a, 1, str1, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity.2
 * JD-Core Version:    0.7.0.1
 */