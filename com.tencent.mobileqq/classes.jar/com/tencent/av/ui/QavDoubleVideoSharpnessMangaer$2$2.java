package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;

class QavDoubleVideoSharpnessMangaer$2$2
  implements DialogInterface.OnClickListener
{
  QavDoubleVideoSharpnessMangaer$2$2(QavDoubleVideoSharpnessMangaer.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.a.a.c();
    QavDoubleVideoSharpnessMangaer.a(this.a.a, false);
    if (paramInt == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X800A565", "0X800A565", 0, 0, "", "", "", "");
      QavDoubleVideoSharpnessMangaer.a(this.a.a);
    }
    while (paramInt != 0) {
      return;
    }
    QavDoubleVideoSharpnessMangaer.a(this.a.a, QavDoubleVideoSharpnessMangaer.a(this.a.a).a().w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavDoubleVideoSharpnessMangaer.2.2
 * JD-Core Version:    0.7.0.1
 */