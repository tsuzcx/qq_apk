package com.tencent.mobileqq.activity.aio.helper;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class EnterForSendHelper$EnterForSend
  implements View.OnKeyListener, TextView.OnEditorActionListener
{
  private EnterForSendHelper$EnterForSend(EnterForSendHelper paramEnterForSendHelper) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EnterForSendHelper", 2, "IME_ACTION_SEND");
      }
      EnterForSendHelper.a(this.a).ay();
      bool = true;
    }
    else
    {
      bool = false;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramView = EnterForSendHelper.a(this.a).Y;
    if (paramKeyEvent.getKeyCode() == 66)
    {
      if (paramKeyEvent.getAction() == 1)
      {
        paramView = paramView.getText().toString();
        if (QLog.isColorLevel())
        {
          paramKeyEvent = new StringBuilder();
          paramKeyEvent.append(" sendOnEnterEnabled = ");
          paramKeyEvent.append(this.a.a);
          QLog.d("EnterForSendHelper", 2, paramKeyEvent.toString());
        }
        if ((this.a.a) && (paramView.length() > 0)) {
          EnterForSendHelper.a(this.a).ax();
        }
      }
      if (this.a.a) {
        return true;
      }
    }
    else if ((paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 0))
    {
      if (QLog.isColorLevel())
      {
        paramKeyEvent = new StringBuilder();
        paramKeyEvent.append("on delete, start: ");
        paramKeyEvent.append(paramView.getSelectionStart());
        paramKeyEvent.append(", end: ");
        paramKeyEvent.append(paramView.getSelectionEnd());
        paramKeyEvent.append(", span: ");
        paramKeyEvent.append(paramView.getTag(2131441550));
        QLog.i("EnterForSendHelper", 2, paramKeyEvent.toString());
      }
      if ((paramView.getSelectionStart() == 0) && (paramView.getSelectionEnd() == 0) && (paramView.getTag(2131441550) != null))
      {
        paramKeyEvent = paramView.getCompoundDrawables();
        paramView.setCompoundDrawables(paramKeyEvent[0], null, paramKeyEvent[2], paramKeyEvent[3]);
        paramView.setTag(2131441550, null);
        paramView.setSelection(0);
        ((ReplyHelper)EnterForSendHelper.a(this.a).q(119)).a(null);
        ReportController.b(null, "dc00898", "", "", "0X800A9AC", "0X800A9AC", 0, 1, "", "", "", "");
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.EnterForSendHelper.EnterForSend
 * JD-Core Version:    0.7.0.1
 */