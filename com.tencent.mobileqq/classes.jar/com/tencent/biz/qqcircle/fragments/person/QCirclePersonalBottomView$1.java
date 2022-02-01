package com.tencent.biz.qqcircle.fragments.person;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

class QCirclePersonalBottomView$1
  implements Observer<UIStateData<List<FeedBlockData>>>
{
  QCirclePersonalBottomView$1(QCirclePersonalBottomView paramQCirclePersonalBottomView) {}
  
  public void a(@Nullable UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (QCirclePersonalBottomView.a(this.a) != null)
    {
      paramUIStateData = this.a;
      paramUIStateData.removeView(QCirclePersonalBottomView.a(paramUIStateData));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView.1
 * JD-Core Version:    0.7.0.1
 */