package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView.IPullRefreshAnim;
import com.tencent.biz.ui.IPullRefreshHeader;
import com.tencent.qphone.base.util.QLog;

public abstract class ReadInJoyAnimBaseManager
  implements ReadInJoyXListView.IPullRefreshAnim
{
  private static final String a;
  protected Context a;
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
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDebugVersion()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onPullRefreshing percent:" + paramInt + " isTopRefreshing:" + paramBoolean);
    }
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
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimBaseManager
 * JD-Core Version:    0.7.0.1
 */