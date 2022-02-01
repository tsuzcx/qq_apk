package com.tencent.biz.qqcircle.fragments.person;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.adapter.QCirclePersonalDetailHeaderBlock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.Arrays;

class QCirclePersonalDetailFragment$1
  implements Observer<UIStateData<FeedCloudRead.StGetMainPageRsp>>
{
  QCirclePersonalDetailFragment$1(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment) {}
  
  public void a(@Nullable UIStateData<FeedCloudRead.StGetMainPageRsp> paramUIStateData)
  {
    if (paramUIStateData == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Observe StGetMainPageRsp state:");
    localStringBuilder.append(paramUIStateData.c());
    QLog.d("QCirclePersonalDetailFragment", 1, localStringBuilder.toString());
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("personDetail uiStateData is");
      localStringBuilder.append(paramUIStateData.c());
      QLog.d("QCirclePersonalDetailFragment", 1, localStringBuilder.toString());
      if ((paramUIStateData.c() != 2) && (paramUIStateData.c() != 3))
      {
        if (paramUIStateData.c() == 4) {
          this.a.e.notifyLoadingComplete(false);
        }
      }
      else
      {
        if (this.a.e != null)
        {
          QLog.e("QCirclePersonalDetailFragment", 1, "personDetail mPersonalDetailHeaderAdapter is not null");
          this.a.e.setDatas(new ArrayList(Arrays.asList(new FeedCloudRead.StGetMainPageRsp[] { (FeedCloudRead.StGetMainPageRsp)paramUIStateData.e() })));
          this.a.e.notifyLoadingComplete(true);
          return;
        }
        QLog.e("QCirclePersonalDetailFragment", 1, "personDetail mPersonalDetailHeaderAdapter is null");
        return;
      }
    }
    catch (Exception paramUIStateData)
    {
      paramUIStateData.printStackTrace();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("personDetail setData error");
      localStringBuilder.append(paramUIStateData.getMessage());
      QLog.e("QCirclePersonalDetailFragment", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment.1
 * JD-Core Version:    0.7.0.1
 */