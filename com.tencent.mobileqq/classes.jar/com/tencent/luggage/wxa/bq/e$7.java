package com.tencent.luggage.wxa.bq;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class e$7
  implements TextView.OnEditorActionListener
{
  e$7(e parame, WAGamePanelInputEditText paramWAGamePanelInputEditText, h paramh, boolean paramBoolean) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    e.b(this.d).a(this.a.getEditableText().toString(), this.b);
    boolean bool = this.c;
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bq.e.7
 * JD-Core Version:    0.7.0.1
 */