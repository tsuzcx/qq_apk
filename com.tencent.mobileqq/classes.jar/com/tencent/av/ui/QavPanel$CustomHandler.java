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
    }
    do
    {
      do
      {
        do
        {
          return;
          QavPanel.a(this.a);
          return;
          QavPanel.b(this.a);
          return;
        } while ((UITools.a(false)) || (this.a.h == null) || (!this.a.h.isShown()));
        this.a.a(this.a.getResources().getString(2131692879));
        UITools.a(false);
        QavPanel.a(this.a).a();
        QavPanel.a(this.a).sendEmptyMessageDelayed(260, 5000L);
        return;
      } while ((UITools.a(true)) || (this.a.h == null) || (!this.a.h.isShown()) || (!QavPanel.a(this.a).a()));
      this.a.a(this.a.getResources().getString(2131692880));
      QavPanel.a(this.a).a();
      QavPanel.a(this.a).sendEmptyMessageDelayed(260, 5000L);
      UITools.a(true);
      return;
      this.a.a("MSG_TRY_CLEAN_TIPS", 1);
      return;
    } while (QavPanel.a(this.a) == null);
    QavPanel.a(this.a).a();
    QavPanel.a(this.a).sendEmptyMessageDelayed(261, 4000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.CustomHandler
 * JD-Core Version:    0.7.0.1
 */