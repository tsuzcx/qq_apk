package com.tencent.biz.qqcircle.publish.outbox;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.biz.qqcircle.publish.task.QCircleQueueTask;
import com.tencent.biz.qqcircle.publish.view.widget.ShaderAnimLayout;
import com.tencent.biz.qqcircle.publish.view.widget.SlideDetectListView;
import com.tencent.biz.qqcircle.publish.view.widget.SlideDetectListView.OnSlideListener;

class QCirclePublishQueuePart$5
  implements SlideDetectListView.OnSlideListener
{
  QCirclePublishQueuePart$5(QCirclePublishQueuePart paramQCirclePublishQueuePart) {}
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = paramView.findViewById(2131445741);
    paramView = (QCircleQueueTask)QCirclePublishQueuePart.a(this.a).a(paramInt);
    paramView = QCirclePublishQueuePart.a(this.a, paramView, paramInt);
    QCirclePublishQueuePart.a(this.a).a(paramView);
    if (paramSlideDetectListView != null)
    {
      paramView = (Button)paramSlideDetectListView.findViewById(2131431684);
      paramView.setTag(Integer.valueOf(paramInt));
      paramView.setOnClickListener(QCirclePublishQueuePart.f(this.a));
      ((ShaderAnimLayout)paramSlideDetectListView).a();
      QCirclePublishQueuePart.c(this.a).setDeleteAreaWidth(paramSlideDetectListView.getLayoutParams().width);
    }
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = paramView.findViewById(2131445741);
    QCirclePublishQueuePart.a(this.a).a("");
    if (paramSlideDetectListView != null)
    {
      ((ShaderAnimLayout)paramSlideDetectListView).d();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131431684);
      paramSlideDetectListView.setTag(null);
      paramSlideDetectListView.setOnClickListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.QCirclePublishQueuePart.5
 * JD-Core Version:    0.7.0.1
 */