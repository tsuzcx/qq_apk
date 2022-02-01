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
    TextPreviewTranslateActivity.f(this.a);
    if ((paramBoolean) && (paramTranslateResult != null) && (paramTranslateResult.g()) && (!paramTranslateResult.f()))
    {
      TextPreviewTranslateActivity.a(this.a, paramTranslateResult);
      return;
    }
    String str2 = this.a.getResources().getString(2131897097);
    String str1 = str2;
    if (paramTranslateResult != null) {
      if (!TextUtils.isEmpty(paramTranslateResult.i))
      {
        str1 = paramTranslateResult.i;
      }
      else
      {
        str1 = str2;
        if (paramTranslateResult.f()) {
          str1 = this.a.getResources().getString(2131897084);
        }
      }
    }
    QQToast.makeText(this.a, 1, str1, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity.2
 * JD-Core Version:    0.7.0.1
 */