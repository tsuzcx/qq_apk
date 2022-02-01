package com.tencent.biz.qqcircle.immersive.part;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

class QFSLayerPageListPart$2
  implements Observer<UIStateData<List<FeedBlockData>>>
{
  QFSLayerPageListPart$2(QFSLayerPageListPart paramQFSLayerPageListPart) {}
  
  public void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (!paramUIStateData.l()) {
      QFSLayerPageListPart.a(this.a, paramUIStateData);
    }
    String str = this.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("listUIStateData's selected position : ");
    localStringBuilder.append(paramUIStateData.j());
    QLog.d(str, 1, localStringBuilder.toString());
    this.a.a(paramUIStateData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerPageListPart.2
 * JD-Core Version:    0.7.0.1
 */