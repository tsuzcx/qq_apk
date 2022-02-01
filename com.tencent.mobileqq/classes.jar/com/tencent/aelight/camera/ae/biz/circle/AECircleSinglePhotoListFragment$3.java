package com.tencent.aelight.camera.ae.biz.circle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aelight.camera.aeeditor.view.AEEditorQcircleBubbleView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class AECircleSinglePhotoListFragment$3
  implements Runnable
{
  AECircleSinglePhotoListFragment$3(AECircleSinglePhotoListFragment paramAECircleSinglePhotoListFragment) {}
  
  public void run()
  {
    View localView = this.this$0.a.getChildAt(AECircleSinglePhotoListFragment.c(this.this$0).e.c);
    if (localView != null) {
      localView = localView.findViewById(2063991310);
    } else {
      localView = null;
    }
    if (localView != null)
    {
      this.this$0.c.a(AECircleSinglePhotoListFragment.c(this.this$0).e.d);
      this.this$0.c.b(AECircleSinglePhotoListFragment.c(this.this$0).e.g);
      this.this$0.c.setWidth(-2);
      this.this$0.c.setHeight(-2);
      this.this$0.c.setFocusable(false);
      this.this$0.c.a(localView, 2, AECircleSinglePhotoListFragment.c(this.this$0).e.f, AECircleSinglePhotoListFragment.c(this.this$0).e.h, AECircleSinglePhotoListFragment.c(this.this$0).e.i);
      AECircleSinglePhotoListFragment.c(this.this$0).e.e = true;
      ThreadManager.getUIHandler().postDelayed(AECircleSinglePhotoListFragment.d(this.this$0), 4000L);
      return;
    }
    QLog.d("AECircleSinglePhotoList", 2, "showPopupGuideBubbleView, photoCheckBox == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleSinglePhotoListFragment.3
 * JD-Core Version:    0.7.0.1
 */