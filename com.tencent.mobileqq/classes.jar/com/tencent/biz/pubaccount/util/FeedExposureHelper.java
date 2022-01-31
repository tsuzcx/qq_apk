package com.tencent.biz.pubaccount.util;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public abstract class FeedExposureHelper
{
  private FeedExposureHelper.Range jdField_a_of_type_ComTencentBizPubaccountUtilFeedExposureHelper$Range;
  private final String jdField_a_of_type_JavaLangString = "FeedExposureHelper";
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + paramInt2;
  }
  
  public FeedExposureHelper.Range a(FeedExposureHelper.Range paramRange1, FeedExposureHelper.Range paramRange2)
  {
    if ((paramRange1 == null) || (paramRange2 == null)) {}
    while ((paramRange1.b < paramRange2.jdField_a_of_type_Int) || (paramRange1.jdField_a_of_type_Int > paramRange2.b)) {
      return null;
    }
    FeedExposureHelper.Range localRange = new FeedExposureHelper.Range();
    if (paramRange1.jdField_a_of_type_Int > paramRange2.jdField_a_of_type_Int)
    {
      i = paramRange1.jdField_a_of_type_Int;
      localRange.jdField_a_of_type_Int = i;
      if (paramRange1.b >= paramRange2.b) {
        break label113;
      }
    }
    label113:
    for (int i = paramRange1.b;; i = paramRange2.b)
    {
      localRange.b = i;
      localRange.jdField_a_of_type_Long = Math.abs(paramRange1.jdField_a_of_type_Long - paramRange2.jdField_a_of_type_Long);
      return localRange;
      i = paramRange2.jdField_a_of_type_Int;
      break;
    }
  }
  
  public FeedExposureHelper.Range a(AbsListView paramAbsListView)
  {
    FeedExposureHelper.Range localRange = new FeedExposureHelper.Range();
    localRange.jdField_a_of_type_Long = System.currentTimeMillis();
    int j = paramAbsListView.getHeight();
    int k = paramAbsListView.getFirstVisiblePosition();
    int m = paramAbsListView.getChildCount();
    int i = 0;
    if (i < m)
    {
      if (a(paramAbsListView.getChildAt(i), j)) {
        localRange.jdField_a_of_type_Int = a(k, i);
      }
    }
    else {
      i = paramAbsListView.getLastVisiblePosition() - k;
    }
    for (;;)
    {
      if (i >= 0)
      {
        if (a(paramAbsListView.getChildAt(i), j)) {
          localRange.b = a(k, i);
        }
      }
      else
      {
        return localRange;
        i += 1;
        break;
      }
      i -= 1;
    }
  }
  
  public abstract void a(FeedExposureHelper.Range paramRange);
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      return;
    }
    paramAbsListView = a(paramAbsListView);
    QLog.d("FeedExposureHelper", 2, "thisRange: " + paramAbsListView);
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilFeedExposureHelper$Range != null)
    {
      FeedExposureHelper.Range localRange = a(this.jdField_a_of_type_ComTencentBizPubaccountUtilFeedExposureHelper$Range, paramAbsListView);
      if (localRange != null)
      {
        QLog.d("FeedExposureHelper", 2, "sameRange: " + localRange);
        a(localRange);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountUtilFeedExposureHelper$Range = paramAbsListView;
  }
  
  public boolean a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return false;
    }
    if (paramView.getBottom() > paramInt) {}
    for (;;)
    {
      int i = paramInt;
      if (paramView.getTop() > 0) {
        i = paramInt - paramView.getTop();
      }
      if (i <= paramView.getHeight() * 0.8F) {
        break;
      }
      return true;
      paramInt = paramView.getBottom();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.FeedExposureHelper
 * JD-Core Version:    0.7.0.1
 */