package com.tencent.biz.qqcircle.viewmodels;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.datacenter.impl.QCircleFeedDetailWrapperProvider;
import com.tencent.biz.qqcircle.datacenter.impl.QCircleLoadInfoCall;
import com.tencent.biz.qqcircle.datacenter.impl.QCircleSealFeedProvider;
import com.tencent.biz.qqcircle.folder.QCirclePageLayoutTypeHelper;
import com.tencent.biz.qqcircle.rank.QCircleRankEventCollector;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.call.BaseCall;
import feedcloud.FeedCloudRead.StBatchGetFeedDetailRsp;

public class QCircleSealRankFeedViewModel
  extends QCircleAbsTabFeedViewModel
{
  private boolean n()
  {
    if (!l())
    {
      c(true);
      return false;
    }
    return true;
  }
  
  public String a()
  {
    return "QCircleSealRankFeedView";
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("extra_key_is_load_more");
    if ((paramBoolean) && (paramLong == 0L))
    {
      if ((paramObject2 instanceof FeedCloudRead.StBatchGetFeedDetailRsp)) {
        b(true, paramLong, paramString, paramObject1, paramObject2, paramBundle);
      }
      return;
    }
    a(UIStateData.a(paramString).a(paramLong).b(bool));
  }
  
  protected void b(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt, QCircleFolderBean paramQCircleFolderBean)
  {
    for (;;)
    {
      try
      {
        paramString2 = QCircleFeedDataCenter.a().b().a(a(paramInt, paramBoolean1));
        paramBoolean1 = n();
        if (paramQCircleFolderBean != null)
        {
          paramString1 = paramQCircleFolderBean.getRedDotTransInfo();
          paramString2.a(new QCircleSealFeedProvider(paramBoolean1, paramString1)).a(QCircleRankEventCollector.getInstance()).a(new QCircleFeedDetailWrapperProvider(this.c.c(), m())).a(new LoadInfo()).a(this).a();
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("QCircleSealRankFeedView", 1, paramString1, new Object[] { paramString1.getMessage() });
        return;
      }
      paramString1 = null;
    }
  }
  
  void b(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, Bundle paramBundle)
  {
    RFThreadManager.getSerialThreadHandler().post(new QCircleSealRankFeedViewModel.1(this, paramBundle, paramString, paramObject2));
  }
  
  public int m()
  {
    if (QCirclePageLayoutTypeHelper.a().b() == 2) {
      return 10;
    }
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleSealRankFeedViewModel
 * JD-Core Version:    0.7.0.1
 */