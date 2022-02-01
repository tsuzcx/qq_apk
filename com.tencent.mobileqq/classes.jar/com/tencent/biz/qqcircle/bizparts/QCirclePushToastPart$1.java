package com.tencent.biz.qqcircle.bizparts;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.widgets.QCirclePushToastView;
import feedcloud.FeedCloudToastshowsvr.StToast;

class QCirclePushToastPart$1
  implements Runnable
{
  QCirclePushToastPart$1(QCirclePushToastPart paramQCirclePushToastPart, FeedCloudToastshowsvr.StToast paramStToast) {}
  
  public void run()
  {
    if (QCirclePushToastPart.a(this.this$0) == null)
    {
      Object localObject = this.this$0;
      QCirclePushToastPart.a((QCirclePushToastPart)localObject, new QCirclePushToastView(((QCirclePushToastPart)localObject).g()));
      localObject = new FrameLayout.LayoutParams(-1, -2);
      QCirclePushToastPart.b(this.this$0).addView(QCirclePushToastPart.a(this.this$0), (ViewGroup.LayoutParams)localObject);
      QCirclePushToastPart.a(this.this$0).setVisibility(8);
    }
    QCirclePushToastPart.a(this.this$0).setData(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePushToastPart.1
 * JD-Core Version:    0.7.0.1
 */