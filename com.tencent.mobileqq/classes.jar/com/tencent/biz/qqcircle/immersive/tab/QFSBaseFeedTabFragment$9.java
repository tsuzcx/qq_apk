package com.tencent.biz.qqcircle.immersive.tab;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

class QFSBaseFeedTabFragment$9
  implements Observer<UIStateData<List<FeedBlockData>>>
{
  QFSBaseFeedTabFragment$9(QFSBaseFeedTabFragment paramQFSBaseFeedTabFragment) {}
  
  public void a(@Nullable UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (paramUIStateData != null)
    {
      String str = this.a.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initViewData:getFeedListRequestRsp_");
      localStringBuilder.append(this.a.J());
      localStringBuilder.append(",state:");
      localStringBuilder.append(paramUIStateData.c());
      QLog.d(str, 1, localStringBuilder.toString());
    }
    this.a.a(paramUIStateData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSBaseFeedTabFragment.9
 * JD-Core Version:    0.7.0.1
 */