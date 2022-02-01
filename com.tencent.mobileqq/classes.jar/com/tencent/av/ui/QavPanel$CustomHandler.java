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
      if (QavPanel.b(this.a) != null)
      {
        QavPanel.b(this.a).c();
        QavPanel.e(this.a).sendEmptyMessageDelayed(261, 4000L);
        return;
      }
      break;
    case 260: 
      this.a.a("MSG_TRY_CLEAN_TIPS", 1);
      return;
    case 259: 
      if ((!UITools.a(true)) && (this.a.J != null) && (this.a.J.isShown()))
      {
        if (!QavPanel.b(this.a).a()) {
          return;
        }
        paramMessage = this.a;
        paramMessage.a(paramMessage.getResources().getString(2131889942));
        QavPanel.b(this.a).c();
        QavPanel.e(this.a).sendEmptyMessageDelayed(260, 5000L);
        UITools.b(true);
        return;
      }
      return;
    case 258: 
      if ((!UITools.a(false)) && (this.a.J != null))
      {
        if (!this.a.J.isShown()) {
          return;
        }
        paramMessage = this.a;
        paramMessage.a(paramMessage.getResources().getString(2131889941));
        UITools.b(false);
        QavPanel.b(this.a).c();
        QavPanel.e(this.a).sendEmptyMessageDelayed(260, 5000L);
        return;
      }
      return;
    case 257: 
      QavPanel.j(this.a);
      return;
    case 256: 
      QavPanel.i(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.CustomHandler
 * JD-Core Version:    0.7.0.1
 */