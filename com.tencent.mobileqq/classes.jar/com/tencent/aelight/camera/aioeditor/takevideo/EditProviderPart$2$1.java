package com.tencent.aelight.camera.aioeditor.takevideo;

import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.aelight.camera.aioeditor.capture.adapter.TransitionProviderGridAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;

class EditProviderPart$2$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  EditProviderPart$2$1(EditProviderPart.2 param2) {}
  
  @TargetApi(16)
  public void onGlobalLayout()
  {
    if ((this.a.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi != null) && (EditProviderPart.a(this.a.this$0) != null))
    {
      Object localObject = EditProviderPart.a(this.a.this$0).getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
      }
      localObject = this.a.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a();
      if (localObject != null)
      {
        int i = ((View)localObject).getLeft();
        int j = ((View)localObject).getWidth() / 2;
        int k = EditProviderPart.a(this.a.this$0).getWidth() / 2;
        EditProviderPart.a(this.a.this$0).setX(i + j - k);
      }
      localObject = (GridView)this.a.this$0.a(2064122730);
      ((GridView)localObject).setNumColumns(3);
      ((GridView)localObject).setSelector(new ColorDrawable(0));
      ((GridView)localObject).setClipToPadding(false);
      ((GridView)localObject).setVerticalScrollBarEnabled(false);
      ((GridView)localObject).setHorizontalScrollBarEnabled(false);
      ((GridView)localObject).setOverScrollMode(2);
      TransitionProviderGridAdapter localTransitionProviderGridAdapter = new TransitionProviderGridAdapter(this.a.this$0.a(), this.a.this$0.b());
      localTransitionProviderGridAdapter.a = true;
      localTransitionProviderGridAdapter.a(this.a.a);
      ((GridView)localObject).setAdapter(localTransitionProviderGridAdapter);
      ((GridView)localObject).setOnItemClickListener(new EditProviderPart.2.1.1(this, localTransitionProviderGridAdapter));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "initTransitionRecommendView onGlobalLayout null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.2.1
 * JD-Core Version:    0.7.0.1
 */