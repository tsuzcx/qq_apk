package com.tencent.biz.qqcircle.adapter;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

class QCirclePersonalBottomBlock$2
  implements Observer<UIStateData<FeedCloudRead.StGetMainPageRsp>>
{
  QCirclePersonalBottomBlock$2(QCirclePersonalBottomBlock paramQCirclePersonalBottomBlock) {}
  
  public void a(@Nullable UIStateData<FeedCloudRead.StGetMainPageRsp> paramUIStateData)
  {
    if ((paramUIStateData != null) && (paramUIStateData.e() != null))
    {
      if (QCirclePersonalBottomBlock.a(this.a) == null) {
        QLog.d("QCirclePersonalBottomBlock", 1, "mWidgetView is null");
      }
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("personDetail uiStateData is ");
        ((StringBuilder)localObject).append(paramUIStateData.c());
        QLog.d("QCirclePersonalBottomBlock", 1, ((StringBuilder)localObject).toString());
        if ((paramUIStateData.c() == 2) || (paramUIStateData.c() == 3))
        {
          QCirclePersonalBottomBlock.a(this.a).a((FeedCloudRead.StGetMainPageRsp)paramUIStateData.e());
          if ((((FeedCloudRead.StGetMainPageRsp)paramUIStateData.e()).busiRspData.get() != null) && (!paramUIStateData.i())) {
            localObject = new QQCircleFeedBase.StMainPageBusiRspData();
          }
        }
      }
      catch (Exception paramUIStateData)
      {
        label152:
        paramUIStateData.printStackTrace();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("personDetail setData error");
        ((StringBuilder)localObject).append(paramUIStateData.getMessage());
        QLog.e("QCirclePersonalBottomBlock", 1, ((StringBuilder)localObject).toString());
      }
    }
    try
    {
      ((QQCircleFeedBase.StMainPageBusiRspData)localObject).mergeFrom(((FeedCloudRead.StGetMainPageRsp)paramUIStateData.e()).busiRspData.get().toByteArray());
      return;
    }
    catch (Exception paramUIStateData)
    {
      break label152;
    }
    QLog.e("QCirclePersonalBottomBlock", 1, "mergeFrom stMainPageBusiRspData error");
    return;
    return;
    QLog.d("QCirclePersonalBottomBlock", 1, "uiStateData is null or getData is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCirclePersonalBottomBlock.2
 * JD-Core Version:    0.7.0.1
 */