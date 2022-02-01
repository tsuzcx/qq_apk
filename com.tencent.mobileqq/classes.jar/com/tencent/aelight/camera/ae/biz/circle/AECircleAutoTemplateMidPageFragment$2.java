package com.tencent.aelight.camera.ae.biz.circle;

import android.view.View;
import com.tencent.aelight.camera.ae.biz.circle.adapter.PicPreviewMoveAdapter;
import com.tencent.aelight.camera.ae.biz.circle.helper.PicDragHelperCallback.DragListener;
import com.tencent.qphone.base.util.QLog;

class AECircleAutoTemplateMidPageFragment$2
  implements PicDragHelperCallback.DragListener
{
  AECircleAutoTemplateMidPageFragment$2(AECircleAutoTemplateMidPageFragment paramAECircleAutoTemplateMidPageFragment, PicPreviewMoveAdapter paramPicPreviewMoveAdapter, View paramView) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDragFinish  isInside = ");
    localStringBuilder.append(paramBoolean);
    QLog.d("AECircleAutoTemplateMidPageFragment", 1, localStringBuilder.toString());
    this.a.notifyDataSetChanged();
    AECircleAutoTemplateMidPageFragment.a(this.c, this.b);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleAutoTemplateMidPageFragment.2
 * JD-Core Version:    0.7.0.1
 */