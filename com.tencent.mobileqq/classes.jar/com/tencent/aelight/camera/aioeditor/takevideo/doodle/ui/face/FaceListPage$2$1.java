package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face;

import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter;

class FaceListPage$2$1
  implements Runnable
{
  FaceListPage$2$1(FaceListPage.2 param2) {}
  
  public void run()
  {
    FaceListPage.b(this.a.this$0).setVisibility(4);
    FaceListPage.c(this.a.this$0).setVisibility(4);
    FaceListPage.d(this.a.this$0).setVisibility(0);
    FaceListPage.e(this.a.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.2.1
 * JD-Core Version:    0.7.0.1
 */