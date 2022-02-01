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
    boolean bool = QavDoubleVideoSharpnessMangaer.c(this.a).b();
    if (paramMotionEvent.getAction() != 0) {
      return false;
    }
    int i = Calendar.getInstance().get(11) * 60 + Calendar.getInstance().get(12);
    if (paramView.getId() == 2131441264)
    {
      QavDoubleVideoSharpnessMangaer.a(this.a, 0);
    }
    else if (paramView.getId() == 2131441267)
    {
      QavDoubleVideoSharpnessMangaer.a(this.a, 1);
    }
    else
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("hdModeFreeUse. curMinute = ");
      paramMotionEvent.append(i);
      paramMotionEvent.append(", startTime = ");
      paramMotionEvent.append(QavDoubleVideoSharpnessMangaer.a(this.a).k().aj);
      paramMotionEvent.append(", endTime = ");
      paramMotionEvent.append(QavDoubleVideoSharpnessMangaer.a(this.a).k().ak);
      paramMotionEvent.append(", tips = ");
      paramMotionEvent.append(QavDoubleVideoSharpnessMangaer.a(this.a).k().al);
      QLog.i("QavDoubleVideoSharpnessMangaer", 1, paramMotionEvent.toString());
      if ((!bool) && ((QavDoubleVideoSharpnessMangaer.a(this.a).k().aj > i) || (i >= QavDoubleVideoSharpnessMangaer.a(this.a).k().ak)))
      {
        QavDoubleVideoSharpnessMangaer.a(this.a, true);
        if (paramView.getId() == 2131441274) {
          QavDoubleVideoSharpnessMangaer.b(this.a, 2);
        } else {
          QavDoubleVideoSharpnessMangaer.b(this.a, 3);
        }
        paramView = new QavDoubleVideoSharpnessMangaer.2.1(this);
        if ((QavDoubleVideoSharpnessMangaer.a(this.a).k().aj > i) || (i >= QavDoubleVideoSharpnessMangaer.a(this.a).k().ak))
        {
          paramView = DialogUtil.a(QavDoubleVideoSharpnessMangaer.d(this.a), 0, HardCodeUtil.a(2131906665), null, HardCodeUtil.a(2131898212), HardCodeUtil.a(2131906666), paramView, paramView);
          if (paramView != null) {
            paramView.show();
          }
        }
        ReportController.b(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
        return false;
      }
      if (paramView.getId() == 2131441274) {
        QavDoubleVideoSharpnessMangaer.a(this.a, 2);
      } else {
        QavDoubleVideoSharpnessMangaer.a(this.a, 3);
      }
    }
    if (((QavDoubleVideoSharpnessMangaer.a(this.a).k().ai == 2) || (QavDoubleVideoSharpnessMangaer.a(this.a).k().ai == 3)) && (QavDoubleVideoSharpnessMangaer.e(this.a) != 2) && (QavDoubleVideoSharpnessMangaer.e(this.a) != 3) && (!bool) && (UITools.b()))
    {
      QavDoubleVideoSharpnessMangaer.a(this.a, true);
      paramView = new QavDoubleVideoSharpnessMangaer.2.2(this);
      if ((QavDoubleVideoSharpnessMangaer.a(this.a).k().aj <= i) && (i < QavDoubleVideoSharpnessMangaer.a(this.a).k().ak))
      {
        this.a.c();
        QavDoubleVideoSharpnessMangaer.a(this.a, false);
        QavDoubleVideoSharpnessMangaer.f(this.a);
      }
      else
      {
        paramView = DialogUtil.a(QavDoubleVideoSharpnessMangaer.d(this.a), 0, null, HardCodeUtil.a(2131906669), HardCodeUtil.a(2131898212), HardCodeUtil.a(2131906667), paramView, paramView);
        if (paramView != null)
        {
          paramView.show();
          UITools.c();
        }
      }
      ReportController.b(null, "CliOper", "", "", "0X800A564", "0X800A564", 0, 0, "", "", "", "");
      return false;
    }
    QavDoubleVideoSharpnessMangaer.f(this.a);
    ReportController.b(null, "CliOper", "", "", "0X800A344", "0X800A344", QavDoubleVideoSharpnessMangaer.e(this.a) + 1, 0, "", "", "", "");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavDoubleVideoSharpnessMangaer.2
 * JD-Core Version:    0.7.0.1
 */