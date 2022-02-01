package com.tencent.biz.qqcircle.fragments.content;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

class QCircleContentHorizontalAdapter$4
  implements ViewTreeObserver.OnPreDrawListener
{
  QCircleContentHorizontalAdapter$4(QCircleContentHorizontalAdapter paramQCircleContentHorizontalAdapter, int paramInt) {}
  
  public boolean onPreDraw()
  {
    QCircleContentHorizontalAdapter.c(this.b).getViewTreeObserver().removeOnPreDrawListener(this);
    QCircleContentHorizontalAdapter.c(this.b).scrollToPosition(this.a);
    if ((QCircleContentHorizontalAdapter.d(this.b) != null) && (QCircleContentHorizontalAdapter.a(this.b) != null))
    {
      QCircleContentHorizontalAdapter.d(this.b).setAllPicCount(QCircleContentHorizontalAdapter.a(this.b).b().images.get().size());
      QCircleContentHorizontalAdapter.d(this.b).setCurPicPos(this.a);
    }
    QCircleContentHorizontalAdapter.c(this.b).post(new QCircleContentHorizontalAdapter.4.1(this));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adjustEnterImageShowPos:");
    localStringBuilder.append(this.a);
    QLog.d("QCircleContentHorizontalAdapter", 1, localStringBuilder.toString());
    QCircleContentHorizontalAdapter.a(this.b, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentHorizontalAdapter.4
 * JD-Core Version:    0.7.0.1
 */