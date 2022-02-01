package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;

class QavDoubleVideoSharpnessMangaer$2$1
  implements DialogInterface.OnClickListener
{
  QavDoubleVideoSharpnessMangaer$2$1(QavDoubleVideoSharpnessMangaer.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    QavDoubleVideoSharpnessMangaer.a(this.a.a, false);
    if (paramInt == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X800A563", "0X800A563", 0, 0, "", "", "", "");
      this.a.a.c();
      if (!UITools.e(QavDoubleVideoSharpnessMangaer.d(this.a.a)))
      {
        QavDoubleVideoSharpnessMangaer.c(this.a.a).a(QavDoubleVideoSharpnessMangaer.d(this.a.a));
        return;
      }
      QavDoubleVideoSharpnessMangaer.c(this.a.a).b(QavDoubleVideoSharpnessMangaer.d(this.a.a));
      return;
    }
    if (paramInt == 0) {
      QavDoubleVideoSharpnessMangaer.a(this.a.a, QavDoubleVideoSharpnessMangaer.a(this.a.a).k().ai);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavDoubleVideoSharpnessMangaer.2.1
 * JD-Core Version:    0.7.0.1
 */