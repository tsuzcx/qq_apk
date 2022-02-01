package com.tencent.biz.qqcircle.folder;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.adapter.QCircleBaseFeedBlock;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleWaterfallFeedsBlock;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;

public class QCircleFeedBlockStrategyHelper
  implements ReportBean<QCircleReportBean>
{
  private final String a;
  private final int b;
  private final int c;
  private final String d;
  private QCircleReportBean e;
  private QCircleInteractor f;
  private QCircleTabInfo g;
  private QCircleFeedBlockStrategyHelper.OnLoadDataListener h;
  
  public QCircleFeedBlockStrategyHelper(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramString2;
    paramString1 = new StringBuilder();
    paramString1.append("QCircleFeedBlockStrategyHelper  mTabType = ");
    paramString1.append(this.a);
    paramString1.append(" , mPageIndex = ");
    paramString1.append(this.b);
    paramString1.append(" , mPageLayoutType = ");
    paramString1.append(this.c);
    paramString1.append(" , mUniqueTabKey = ");
    paramString1.append(this.d);
    QLog.i("QCircleFeedBlockStrategyHelper", 1, paramString1.toString());
  }
  
  private QCircleBaseFeedBlock c()
  {
    QCircleInsFeedAdapter localQCircleInsFeedAdapter = new QCircleInsFeedAdapter(new Bundle());
    localQCircleInsFeedAdapter.b(true);
    localQCircleInsFeedAdapter.a(QCircleBaseTabFragment.d.equals(this.a));
    localQCircleInsFeedAdapter.setOnLoadDataDelegate(new QCircleFeedBlockStrategyHelper.1(this));
    QLog.i("QCircleFeedBlockStrategyHelper", 1, "initFeedFlowBlock");
    return localQCircleInsFeedAdapter;
  }
  
  private QCircleBaseFeedBlock d()
  {
    boolean bool = TextUtils.equals(this.a, QCircleBaseTabFragment.f);
    int i = 2;
    if (bool) {
      i = 1;
    } else {
      TextUtils.equals(this.a, QCircleBaseTabFragment.e);
    }
    QCircleWaterfallFeedsBlock localQCircleWaterfallFeedsBlock = new QCircleWaterfallFeedsBlock(new Bundle()).c(i);
    localQCircleWaterfallFeedsBlock.setOnLoadDataDelegate(new QCircleFeedBlockStrategyHelper.2(this));
    QLog.i("QCircleFeedBlockStrategyHelper", 1, "initWaterFallBlock");
    return localQCircleWaterfallFeedsBlock;
  }
  
  public QCircleBaseFeedBlock a()
  {
    QCircleBaseFeedBlock localQCircleBaseFeedBlock;
    if (this.c != 2) {
      localQCircleBaseFeedBlock = c();
    } else {
      localQCircleBaseFeedBlock = d();
    }
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
    QCircleTabInfo localQCircleTabInfo = this.g;
    if (localQCircleTabInfo != null)
    {
      localQCircleExtraTypeInfo.pageType = localQCircleTabInfo.c();
      localQCircleExtraTypeInfo.mGlobalViewModelKey = this.d;
      localQCircleBaseFeedBlock.a(localQCircleExtraTypeInfo);
      localQCircleBaseFeedBlock.a(this.b);
    }
    localQCircleBaseFeedBlock.setReportBean(b());
    localQCircleBaseFeedBlock.setInteractor(this.f);
    return localQCircleBaseFeedBlock;
  }
  
  public void a(QCircleInteractor paramQCircleInteractor)
  {
    this.f = paramQCircleInteractor;
  }
  
  public void a(QCircleTabInfo paramQCircleTabInfo)
  {
    this.g = paramQCircleTabInfo;
  }
  
  public void a(QCircleFeedBlockStrategyHelper.OnLoadDataListener paramOnLoadDataListener)
  {
    this.h = paramOnLoadDataListener;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.e = paramQCircleReportBean;
  }
  
  public QCircleReportBean b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.folder.QCircleFeedBlockStrategyHelper
 * JD-Core Version:    0.7.0.1
 */