package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView.IPullRefreshAnim;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.qphone.base.util.QLog;

public abstract class ReadInJoyAnimBaseManager
  implements ReadInJoyXListView.IPullRefreshAnim
{
  private static final String a;
  protected int a;
  protected Context a;
  protected SlideActiveAnimController a;
  protected ReadInJoyAnimBaseManager.OnRefreshPullDistanceListener a;
  protected ReadInJoyAnimBaseManager.PullRefreshComplete a;
  protected IPullRefreshHeader a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ReadInJoyAnimBaseManager.class.getSimpleName();
  }
  
  public ReadInJoyAnimBaseManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager$OnRefreshPullDistanceListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager$OnRefreshPullDistanceListener.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDebugVersion()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onPullRefreshing percent:" + paramInt + " isTopRefreshing:" + paramBoolean);
    }
  }
  
  public void a(SlideActiveAnimController paramSlideActiveAnimController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = paramSlideActiveAnimController;
  }
  
  public void a(ReadInJoyAnimBaseManager.OnRefreshPullDistanceListener paramOnRefreshPullDistanceListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager$OnRefreshPullDistanceListener = paramOnRefreshPullDistanceListener;
  }
  
  public void a(ReadInJoyAnimBaseManager.PullRefreshComplete paramPullRefreshComplete)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager$PullRefreshComplete = paramPullRefreshComplete;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager$PullRefreshComplete != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager$PullRefreshComplete.a(paramBoolean);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimBaseManager
 * JD-Core Version:    0.7.0.1
 */