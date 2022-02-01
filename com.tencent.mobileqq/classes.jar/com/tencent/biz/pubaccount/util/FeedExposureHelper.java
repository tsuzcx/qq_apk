package com.tencent.biz.pubaccount.util;

import android.view.View;
import com.tencent.mobileqq.kandian.repo.common.api.IRIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public abstract class FeedExposureHelper
{
  private final String a = "FeedExposureHelper";
  private FeedExposureHelper.Range b;
  
  private float b(int paramInt)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = a(paramInt);
    float f;
    if (((IRIJItemViewTypeUtils)QRoute.api(IRIJItemViewTypeUtils.class)).isHotSearchCard(localAbsBaseArticleInfo)) {
      f = 1.0F;
    } else {
      f = 0.5F;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getMinShowPercentage] viewPosition = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", minShowPercentage = ");
      localStringBuilder.append(f);
      localStringBuilder.append(", articleInfo = ");
      localStringBuilder.append(localAbsBaseArticleInfo);
      QLog.i("FeedExposureHelper", 2, localStringBuilder.toString());
    }
    return f;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + paramInt2;
  }
  
  public FeedExposureHelper.Range a(FeedExposureHelper.Range paramRange1, FeedExposureHelper.Range paramRange2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramRange1 != null)
    {
      if (paramRange2 == null) {
        return null;
      }
      localObject1 = localObject2;
      if (paramRange1.c >= paramRange2.b)
      {
        if (paramRange1.b > paramRange2.c) {
          return null;
        }
        localObject1 = new FeedExposureHelper.Range();
        int i;
        if (paramRange1.b > paramRange2.b) {
          i = paramRange1.b;
        } else {
          i = paramRange2.b;
        }
        ((FeedExposureHelper.Range)localObject1).b = i;
        if (paramRange1.c < paramRange2.c) {
          i = paramRange1.c;
        } else {
          i = paramRange2.c;
        }
        ((FeedExposureHelper.Range)localObject1).c = i;
        ((FeedExposureHelper.Range)localObject1).a = Math.abs(paramRange1.a - paramRange2.a);
      }
    }
    return localObject1;
  }
  
  public FeedExposureHelper.Range a(AbsListView paramAbsListView)
  {
    FeedExposureHelper.Range localRange = new FeedExposureHelper.Range();
    localRange.a = System.currentTimeMillis();
    int k = paramAbsListView.getHeight();
    int m = paramAbsListView.getFirstVisiblePosition();
    int n = paramAbsListView.getChildCount();
    int j = 0;
    int i = j;
    if (n == 0)
    {
      localRange.b = 0;
      localRange.c = 10;
      i = j;
    }
    View localView;
    while (i < n)
    {
      localView = paramAbsListView.getChildAt(i);
      j = a(m, i);
      if (a(localView, j, k))
      {
        localRange.b = j;
        break;
      }
      i += 1;
    }
    i = paramAbsListView.getLastVisiblePosition() - m;
    while (i >= 0)
    {
      localView = paramAbsListView.getChildAt(i);
      j = a(m, i);
      if (a(localView, j, k))
      {
        localRange.c = j;
        return localRange;
      }
      i -= 1;
    }
    return localRange;
  }
  
  public abstract AbsBaseArticleInfo a(int paramInt);
  
  public abstract void a(FeedExposureHelper.Range paramRange);
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 4) && (paramInt != 5)) {
      return;
    }
    paramAbsListView = a(paramAbsListView);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("thisRange: ");
    ((StringBuilder)localObject).append(paramAbsListView);
    QLog.d("FeedExposureHelper", 2, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null)
    {
      localObject = a((FeedExposureHelper.Range)localObject, paramAbsListView);
      if ((localObject != null) && (((FeedExposureHelper.Range)localObject).a > 1000L))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sameRange: ");
        localStringBuilder.append(localObject);
        QLog.d("FeedExposureHelper", 2, localStringBuilder.toString());
        a((FeedExposureHelper.Range)localObject);
      }
    }
    this.b = paramAbsListView;
    if (paramInt == 5) {
      this.b = null;
    }
  }
  
  public boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return false;
    }
    if (paramView.getBottom() <= paramInt2) {
      paramInt2 = paramView.getBottom();
    }
    int i = paramInt2;
    if (paramView.getTop() > 0) {
      i = paramInt2 - paramView.getTop();
    }
    return i >= paramView.getHeight() * b(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.FeedExposureHelper
 * JD-Core Version:    0.7.0.1
 */