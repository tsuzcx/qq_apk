package com.tencent.biz.pubaccount.readinjoy.ark;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import mqq.util.WeakReference;

public class ReadInJoyArkView
{
  public static final String[] a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected View a;
  protected ViewGroup a;
  private ReadInJoyListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup;
  protected WeakReference a;
  private boolean jdField_a_of_type_Boolean;
  protected View b;
  protected WeakReference b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      ((ArkAppContainer)this.jdField_a_of_type_MqqUtilWeakReference.get()).doOnEvent(2);
      this.jdField_a_of_type_MqqUtilWeakReference.clear();
    }
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.jdField_b_of_type_MqqUtilWeakReference = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup = null;
  }
  
  public void a(ReadInJoyListViewGroup paramReadInJoyListViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup = paramReadInJoyListViewGroup;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkView
 * JD-Core Version:    0.7.0.1
 */