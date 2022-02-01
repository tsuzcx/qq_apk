package com.tencent.biz.qqcircle.fragments.content;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

class QCircleContentPart$6
  implements Observer<UIStateData<List<FeedBlockData>>>
{
  QCircleContentPart$6(QCircleContentPart paramQCircleContentPart) {}
  
  public void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    QCircleContentPart.j(this.a);
    if (paramUIStateData.e() != null)
    {
      paramUIStateData = this.a.a((List)paramUIStateData.e());
      QCircleContentPart.a(this.a).setDatas(paramUIStateData);
      QCircleContentPart.a(this.a).notifyDataSetChanged();
      QCircleContentPart.a(this.a, paramUIStateData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.6
 * JD-Core Version:    0.7.0.1
 */