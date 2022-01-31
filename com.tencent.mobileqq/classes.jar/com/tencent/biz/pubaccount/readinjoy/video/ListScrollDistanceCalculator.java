package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class ListScrollDistanceCalculator
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  private ListScrollDistanceCalculator.ScrollDistanceListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoListScrollDistanceCalculator$ScrollDistanceListener;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView.getCount() == 0) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    View localView = paramAbsListView.getChildAt(0);
    this.jdField_a_of_type_Int = paramAbsListView.getFirstVisiblePosition();
    this.c = localView.getTop();
    this.d = localView.getBottom();
    this.b = localView.getHeight();
    this.jdField_a_of_type_Boolean = true;
    this.e = 0;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 0) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    paramAbsListView = paramAbsListView.getChildAt(0);
    paramInt3 = paramAbsListView.getTop();
    int i = paramAbsListView.getBottom();
    int j = paramAbsListView.getHeight();
    if (paramInt1 > this.jdField_a_of_type_Int)
    {
      this.c += this.b;
      paramInt2 = paramInt3 - this.c;
    }
    for (;;)
    {
      this.f = paramInt2;
      this.e += paramInt2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoListScrollDistanceCalculator$ScrollDistanceListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoListScrollDistanceCalculator$ScrollDistanceListener.a(paramInt2, this.e);
      }
      this.c = paramInt3;
      this.d = i;
      this.b = j;
      this.jdField_a_of_type_Int = paramInt1;
      return;
      if (paramInt1 < this.jdField_a_of_type_Int)
      {
        this.d -= this.b;
        paramInt2 = i - this.d;
      }
      else
      {
        paramInt2 = i - this.d;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ListScrollDistanceCalculator
 * JD-Core Version:    0.7.0.1
 */