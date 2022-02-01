package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class QavDoubleVideoSharpnessMangaer$1
  extends BroadcastReceiver
{
  QavDoubleVideoSharpnessMangaer$1(QavDoubleVideoSharpnessMangaer paramQavDoubleVideoSharpnessMangaer) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QavDoubleVideoSharpnessMangaer", 2, "onReceive SVIPPayResultReceiver");
    }
    if (("tencent.video.q2v.SVIP.PAY".equals(paramContext)) && (QavDoubleVideoSharpnessMangaer.a(this.a) != null))
    {
      paramContext = QavDoubleVideoSharpnessMangaer.a(this.a).a();
      if ((paramContext != null) && (paramContext.d == 2)) {
        QavDoubleVideoSharpnessMangaer.a(this.a).a(Long.valueOf(paramContext.c).longValue(), QavDoubleVideoSharpnessMangaer.a(this.a));
      }
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavDoubleVideoSharpnessMangaer.1
 * JD-Core Version:    0.7.0.1
 */