package com.tencent.biz.qqcircle.fragments.person;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

class QCirclePersonalWorksFragment$1
  implements Observer<UIStateData<List<FeedBlockData>>>
{
  QCirclePersonalWorksFragment$1(QCirclePersonalWorksFragment paramQCirclePersonalWorksFragment) {}
  
  public void a(@Nullable UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    QLog.d("QCirclePersonalWorksFragment", 4, "initViewData:getFeedListRequestRsp");
    this.a.a(paramUIStateData);
    this.a.b(paramUIStateData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalWorksFragment.1
 * JD-Core Version:    0.7.0.1
 */