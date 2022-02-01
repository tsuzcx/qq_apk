package com.tencent.aelight.camera.aeeditor.view.classifier;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class MaterialContentAdapter$4
  implements Runnable
{
  MaterialContentAdapter$4(MaterialContentAdapter paramMaterialContentAdapter, int paramInt) {}
  
  public void run()
  {
    if (MaterialContentAdapter.a(this.this$0) != null) {
      QQToast.a(BaseApplicationImpl.getContext(), 2064515209, 1).a(MaterialContentAdapter.a(this.this$0));
    } else {
      QQToast.a(BaseApplicationImpl.getContext(), 2064515209, 1).a();
    }
    this.this$0.notifyItemChanged(this.a, Integer.valueOf(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.4
 * JD-Core Version:    0.7.0.1
 */