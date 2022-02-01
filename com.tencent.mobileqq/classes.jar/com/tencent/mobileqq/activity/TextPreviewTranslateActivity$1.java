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
      TextPreviewTranslateActivity.a(this.a, TextPreviewTranslateActivity.a(this.a).getText().toString());
      TextPreviewTranslateActivity.a(this.a);
      TextPreviewTranslateActivity.a(this.a, TextPreviewTranslateActivity.a(this.a));
      TextPreviewTranslateActivity.b(this.a, TextPreviewTranslateActivity.b(this.a));
      TextPreviewTranslateActivity.a(this.a, TextPreviewTranslateActivity.b(this.a, TextPreviewTranslateActivity.c(this.a)), TextPreviewTranslateActivity.a(this.a), TextPreviewTranslateActivity.b(this.a));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity.1
 * JD-Core Version:    0.7.0.1
 */