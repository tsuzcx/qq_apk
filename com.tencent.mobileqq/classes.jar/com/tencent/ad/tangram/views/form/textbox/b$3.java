package com.tencent.ad.tangram.views.form.textbox;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class b$3
  implements TextView.OnEditorActionListener
{
  b$3(b paramb) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    StringBuilder localStringBuilder;
    if (paramInt == 6)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEditorActionDone ");
      localStringBuilder.append(b.access$300(this.this$0));
      AdLog.i("AdFormItemTextBoxView", localStringBuilder.toString());
      b.access$400(this.this$0).clearFocus();
      b.access$500(paramTextView);
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEditorAction ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(b.access$600(this.this$0));
      AdLog.i("AdFormItemTextBoxView", localStringBuilder.toString());
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.textbox.b.3
 * JD-Core Version:    0.7.0.1
 */