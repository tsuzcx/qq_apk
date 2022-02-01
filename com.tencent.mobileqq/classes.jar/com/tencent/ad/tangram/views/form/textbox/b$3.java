package com.tencent.ad.tangram.views.form.textbox;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.ad.tangram.log.AdLog;

class b$3
  implements TextView.OnEditorActionListener
{
  b$3(b paramb) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      paramKeyEvent = new StringBuilder();
      paramKeyEvent.append("onEditorActionDone ");
      paramKeyEvent.append(b.access$300(this.this$0));
      AdLog.i("AdFormItemTextBoxView", paramKeyEvent.toString());
      b.access$400(this.this$0).clearFocus();
      b.access$500(paramTextView);
    }
    else
    {
      paramTextView = new StringBuilder();
      paramTextView.append("onEditorAction ");
      paramTextView.append(paramInt);
      paramTextView.append(" ");
      paramTextView.append(b.access$600(this.this$0));
      AdLog.i("AdFormItemTextBoxView", paramTextView.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.textbox.b.3
 * JD-Core Version:    0.7.0.1
 */