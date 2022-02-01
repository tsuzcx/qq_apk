package com.tencent.mobileqq.activity.miniaio;

import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class MiniPie$EnterForSend
  implements View.OnKeyListener, TextView.OnEditorActionListener
{
  private MiniPie$EnterForSend(MiniPie paramMiniPie) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return false;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 0))
    {
      if (QLog.isColorLevel())
      {
        paramKeyEvent = this.a.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("on delete, start: ");
        localStringBuilder.append(this.a.t.getSelectionStart());
        localStringBuilder.append(", end: ");
        localStringBuilder.append(this.a.t.getSelectionEnd());
        localStringBuilder.append(", span: ");
        localStringBuilder.append(this.a.t.getTag(2131441550));
        QLog.i(paramKeyEvent, 2, localStringBuilder.toString());
      }
      if ((this.a.t.getSelectionStart() == 0) && (this.a.t.getSelectionEnd() == 0))
      {
        if (this.a.t.getTag(2131441550) != null)
        {
          paramKeyEvent = this.a.t.getCompoundDrawables();
          this.a.t.setCompoundDrawables(paramKeyEvent[0], null, paramKeyEvent[2], paramKeyEvent[3]);
          this.a.t.setTag(2131441550, null);
          this.a.t.setSelection(0);
          this.a.t.setMinHeight(AIOUtils.b(36.0F, paramView.getResources()));
          this.a.U = null;
          return true;
        }
      }
      else if ((this.a.t.getTag(2131441550) != null) && (Build.VERSION.SDK_INT >= 21) && (AIOUtils.b(36.0F, paramView.getResources()) == this.a.t.getMinHeight()))
      {
        paramInt = this.a.t.getMeasuredHeight();
        this.a.t.setMinHeight(paramInt);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie.EnterForSend
 * JD-Core Version:    0.7.0.1
 */