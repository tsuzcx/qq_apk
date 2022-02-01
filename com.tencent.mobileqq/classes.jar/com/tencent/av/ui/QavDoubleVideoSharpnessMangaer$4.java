package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;

class QavDoubleVideoSharpnessMangaer$4
  implements DialogInterface.OnClickListener
{
  QavDoubleVideoSharpnessMangaer$4(QavDoubleVideoSharpnessMangaer paramQavDoubleVideoSharpnessMangaer) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    QavDoubleVideoSharpnessMangaer.a(this.a, false);
    if (paramInt == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X800A563", "0X800A563", 0, 0, "", "", "", "");
      this.a.c();
      if (!UITools.a(QavDoubleVideoSharpnessMangaer.a(this.a))) {
        QavDoubleVideoSharpnessMangaer.a(this.a).a(QavDoubleVideoSharpnessMangaer.a(this.a));
      }
    }
    while (paramInt != 0)
    {
      return;
      QavDoubleVideoSharpnessMangaer.a(this.a).b(QavDoubleVideoSharpnessMangaer.a(this.a));
      return;
    }
    QavDoubleVideoSharpnessMangaer.a(this.a, QavDoubleVideoSharpnessMangaer.a(this.a).a().w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavDoubleVideoSharpnessMangaer.4
 * JD-Core Version:    0.7.0.1
 */