package com.tencent.av.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Button;
import com.tencent.av.utils.UITools;

class QavPanel$CustomHandler
  extends Handler
{
  public QavPanel$CustomHandler(QavPanel paramQavPanel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 261: 
      if (QavPanel.a(this.a) != null)
      {
        QavPanel.a(this.a).a();
        QavPanel.a(this.a).sendEmptyMessageDelayed(261, 4000L);
        return;
      }
      break;
    case 260: 
      this.a.a("MSG_TRY_CLEAN_TIPS", 1);
      return;
    case 259: 
      if ((!UITools.a(true)) && (this.a.h != null) && (this.a.h.isShown()))
      {
        if (!QavPanel.a(this.a).a()) {
          return;
        }
        paramMessage = this.a;
        paramMessage.a(paramMessage.getResources().getString(2131692834));
        QavPanel.a(this.a).a();
        QavPanel.a(this.a).sendEmptyMessageDelayed(260, 5000L);
        UITools.a(true);
        return;
      }
      return;
    case 258: 
      if ((!UITools.a(false)) && (this.a.h != null))
      {
        if (!this.a.h.isShown()) {
          return;
        }
        paramMessage = this.a;
        paramMessage.a(paramMessage.getResources().getString(2131692833));
        UITools.a(false);
        QavPanel.a(this.a).a();
        QavPanel.a(this.a).sendEmptyMessageDelayed(260, 5000L);
        return;
      }
      return;
    case 257: 
      QavPanel.b(this.a);
      return;
    case 256: 
      QavPanel.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.CustomHandler
 * JD-Core Version:    0.7.0.1
 */