package com.tencent.mobileqq.activity;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class TextPreviewTranslateActivity$1
  implements TextView.OnEditorActionListener
{
  TextPreviewTranslateActivity$1(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) && (TextPreviewTranslateActivity.a(this.a) != null))
    {
      paramTextView = this.a;
      TextPreviewTranslateActivity.a(paramTextView, TextPreviewTranslateActivity.a(paramTextView).getText().toString());
      TextPreviewTranslateActivity.a(this.a);
      paramTextView = this.a;
      TextPreviewTranslateActivity.a(paramTextView, TextPreviewTranslateActivity.a(paramTextView));
      paramTextView = this.a;
      TextPreviewTranslateActivity.b(paramTextView, TextPreviewTranslateActivity.b(paramTextView));
      paramTextView = this.a;
      TextPreviewTranslateActivity.a(paramTextView, TextPreviewTranslateActivity.b(paramTextView, TextPreviewTranslateActivity.c(paramTextView)), TextPreviewTranslateActivity.a(this.a), TextPreviewTranslateActivity.b(this.a));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity.1
 * JD-Core Version:    0.7.0.1
 */