package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.education.api.IAnswerSearchApi;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;

class ProblemScanEntryView$1
  implements Runnable
{
  ProblemScanEntryView$1(ProblemScanEntryView paramProblemScanEntryView) {}
  
  public void run()
  {
    String str = CameraProxy.a().m();
    if (FileUtil.d(str)) {
      ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).startAnswerSearchPicEditActivity((Activity)this.this$0.E, str, 0, true);
    }
    ProblemScanEntryView.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ProblemScanEntryView.1
 * JD-Core Version:    0.7.0.1
 */