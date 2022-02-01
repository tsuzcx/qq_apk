package com.tencent.mobileqq.activity;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TextPreviewTranslateActivity$1
  implements TextView.OnEditorActionListener
{
  TextPreviewTranslateActivity$1(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((paramInt == 6) && (TextPreviewTranslateActivity.a(this.a) != null))
    {
      TextPreviewTranslateActivity localTextPreviewTranslateActivity = this.a;
      TextPreviewTranslateActivity.a(localTextPreviewTranslateActivity, TextPreviewTranslateActivity.a(localTextPreviewTranslateActivity).getText().toString());
      TextPreviewTranslateActivity.b(this.a);
      localTextPreviewTranslateActivity = this.a;
      TextPreviewTranslateActivity.b(localTextPreviewTranslateActivity, TextPreviewTranslateActivity.c(localTextPreviewTranslateActivity));
      localTextPreviewTranslateActivity = this.a;
      TextPreviewTranslateActivity.c(localTextPreviewTranslateActivity, TextPreviewTranslateActivity.d(localTextPreviewTranslateActivity));
      localTextPreviewTranslateActivity = this.a;
      TextPreviewTranslateActivity.a(localTextPreviewTranslateActivity, TextPreviewTranslateActivity.d(localTextPreviewTranslateActivity, TextPreviewTranslateActivity.e(localTextPreviewTranslateActivity)), TextPreviewTranslateActivity.c(this.a), TextPreviewTranslateActivity.d(this.a));
      bool = true;
    }
    else
    {
      bool = false;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity.1
 * JD-Core Version:    0.7.0.1
 */