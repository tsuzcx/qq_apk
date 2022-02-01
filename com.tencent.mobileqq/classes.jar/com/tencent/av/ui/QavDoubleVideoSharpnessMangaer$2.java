package com.tencent.av.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class QavDoubleVideoSharpnessMangaer$2
  implements View.OnTouchListener
{
  QavDoubleVideoSharpnessMangaer$2(QavDoubleVideoSharpnessMangaer paramQavDoubleVideoSharpnessMangaer) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = QavDoubleVideoSharpnessMangaer.a(this.a).a();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      int i = Calendar.getInstance().get(11) * 60 + Calendar.getInstance().get(12);
      if (paramView.getId() == 2131374042)
      {
        QavDoubleVideoSharpnessMangaer.a(this.a, 0);
        if (((QavDoubleVideoSharpnessMangaer.a(this.a).a().w != 2) && (QavDoubleVideoSharpnessMangaer.a(this.a).a().w != 3)) || (QavDoubleVideoSharpnessMangaer.b(this.a) == 2) || (QavDoubleVideoSharpnessMangaer.b(this.a) == 3) || (bool) || (!UITools.b())) {
          break label616;
        }
        QavDoubleVideoSharpnessMangaer.a(this.a, true);
        paramView = new QavDoubleVideoSharpnessMangaer.2.2(this);
        if ((QavDoubleVideoSharpnessMangaer.a(this.a).a().x <= i) && (i < QavDoubleVideoSharpnessMangaer.a(this.a).a().y)) {
          break label590;
        }
        paramView = DialogUtil.a(QavDoubleVideoSharpnessMangaer.a(this.a), 0, null, HardCodeUtil.a(2131708894), HardCodeUtil.a(2131708892), HardCodeUtil.a(2131708891), paramView, paramView);
        if (paramView != null)
        {
          paramView.show();
          UITools.a();
        }
      }
      for (;;)
      {
        ReportController.b(null, "CliOper", "", "", "0X800A564", "0X800A564", 0, 0, "", "", "", "");
        return false;
        if (paramView.getId() == 2131374045)
        {
          QavDoubleVideoSharpnessMangaer.a(this.a, 1);
          break;
        }
        QLog.i("QavDoubleVideoSharpnessMangaer", 1, "hdModeFreeUse. curMinute = " + i + ", startTime = " + QavDoubleVideoSharpnessMangaer.a(this.a).a().x + ", endTime = " + QavDoubleVideoSharpnessMangaer.a(this.a).a().y + ", tips = " + QavDoubleVideoSharpnessMangaer.a(this.a).a().n);
        if ((bool) || ((QavDoubleVideoSharpnessMangaer.a(this.a).a().x <= i) && (i < QavDoubleVideoSharpnessMangaer.a(this.a).a().y)))
        {
          if (paramView.getId() == 2131374052)
          {
            QavDoubleVideoSharpnessMangaer.a(this.a, 2);
            break;
          }
          QavDoubleVideoSharpnessMangaer.a(this.a, 3);
          break;
        }
        QavDoubleVideoSharpnessMangaer.a(this.a, true);
        if (paramView.getId() == 2131374052) {
          QavDoubleVideoSharpnessMangaer.b(this.a, 2);
        }
        for (;;)
        {
          paramView = new QavDoubleVideoSharpnessMangaer.2.1(this);
          if ((QavDoubleVideoSharpnessMangaer.a(this.a).a().x > i) || (i >= QavDoubleVideoSharpnessMangaer.a(this.a).a().y))
          {
            paramView = DialogUtil.a(QavDoubleVideoSharpnessMangaer.a(this.a), 0, HardCodeUtil.a(2131708888), null, HardCodeUtil.a(2131708889), HardCodeUtil.a(2131708890), paramView, paramView);
            if (paramView != null) {
              paramView.show();
            }
          }
          ReportController.b(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
          return false;
          QavDoubleVideoSharpnessMangaer.b(this.a, 3);
        }
        label590:
        this.a.c();
        QavDoubleVideoSharpnessMangaer.a(this.a, false);
        QavDoubleVideoSharpnessMangaer.a(this.a);
      }
      label616:
      QavDoubleVideoSharpnessMangaer.a(this.a);
      ReportController.b(null, "CliOper", "", "", "0X800A344", "0X800A344", QavDoubleVideoSharpnessMangaer.b(this.a) + 1, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavDoubleVideoSharpnessMangaer.2
 * JD-Core Version:    0.7.0.1
 */