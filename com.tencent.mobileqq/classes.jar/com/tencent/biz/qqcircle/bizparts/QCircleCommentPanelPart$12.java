package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;

class QCircleCommentPanelPart$12
  implements Runnable
{
  QCircleCommentPanelPart$12(QCircleCommentPanelPart paramQCircleCommentPanelPart, View paramView, int[] paramArrayOfInt, int paramInt) {}
  
  public void run()
  {
    this.a.getLocationOnScreen(this.b);
    Object localObject = this.b;
    localObject[1] += this.a.getHeight();
    if (this.b[1] > this.c)
    {
      QCircleCommentPanelPart.i(this.this$0).getRecyclerView().scrollBy(0, this.b[1] - this.c);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scrollItemToVisble  postDelayed scrollBy: ");
      ((StringBuilder)localObject).append(this.b[1] - this.c);
      QLog.i("QCircleCommentPanelPart", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart.12
 * JD-Core Version:    0.7.0.1
 */