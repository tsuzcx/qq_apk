package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Intent;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyPageItemCache;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Map;
import java.util.Set;

public abstract class ReadInJoyBaseListViewGroup
  extends FrameLayout
{
  public int a;
  protected ReadInJoyBaseViewController a;
  protected ReadInJoyPageItemCache a;
  
  public ReadInJoyBaseListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    super(paramReadInJoyBaseViewController.a());
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController = paramReadInJoyBaseViewController;
    if (paramReadInJoyPageItemCache == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache = new ReadInJoyPageItemCache();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.a = ReadInJoyHelper.a(paramInt, (QQAppInterface)ReadInJoyUtils.a());
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache = paramReadInJoyPageItemCache;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.b = 1;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a();
  }
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Map paramMap);
  
  public abstract void a(Map paramMap, boolean paramBoolean);
  
  public abstract void a(Set paramSet, Map paramMap);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(Map paramMap);
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup
 * JD-Core Version:    0.7.0.1
 */