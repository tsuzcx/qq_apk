package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;

public class VafContext
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsViewFactory = new ViewFactory();
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public ViewFactory a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsViewFactory;
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsViewFactory.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext
 * JD-Core Version:    0.7.0.1
 */