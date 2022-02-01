package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class PageLoadManager<T>
{
  private int jdField_a_of_type_Int = 0;
  private PageLoadManager.QueryProvider<T> jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPageLoadManager$QueryProvider = null;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 100;
  private boolean jdField_b_of_type_Boolean = false;
  
  public void a()
  {
    PageLoadManager.QueryProvider localQueryProvider = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPageLoadManager$QueryProvider;
    if (localQueryProvider == null) {
      if (QLog.isColorLevel()) {
        QLog.e("PageLoadManager", 2, "mQueryProvider is not registered, can't query data...");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("PageLoadManager", 2, "requestNextPage cancel for mHasMore is false");
    return;
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("PageLoadManager", 2, "requestNextPage mOffset:" + this.jdField_a_of_type_Int + " mPageSize:$mPageSize");
    }
    ThreadManager.executeOnSubThread(new PageLoadManager.1(this, localQueryProvider));
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.w("PageLoadManager", 2, "onPositionShow return for mHasMore is false");
      }
    }
    do
    {
      do
      {
        return;
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("PageLoadManager", 2, "query is doing...");
      return;
    } while (paramInt < (this.jdField_a_of_type_Int + (this.jdField_a_of_type_Int - this.jdField_b_of_type_Int)) / 2);
    a();
  }
  
  public void a(PageLoadManager.QueryProvider<T> paramQueryProvider)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPageLoadManager$QueryProvider = paramQueryProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.PageLoadManager
 * JD-Core Version:    0.7.0.1
 */