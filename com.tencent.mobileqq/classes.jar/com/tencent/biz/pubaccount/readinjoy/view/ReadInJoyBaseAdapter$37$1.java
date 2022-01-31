package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import bcql;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.plugin.PluginBaseActivity;
import ram;
import rbg;

public class ReadInJoyBaseAdapter$37$1
  implements Runnable
{
  public ReadInJoyBaseAdapter$37$1(rbg paramrbg) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Ram.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if ((this.a.jdField_a_of_type_Ram.a instanceof BaseActivity)) {
      bcql.a(this.a.jdField_a_of_type_Ram.a, -1, this.a.jdField_a_of_type_Ram.a.getString(2131699674), 0).b(((BaseActivity)this.a.jdField_a_of_type_Ram.a).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Ram.a(this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
      return;
      if ((this.a.jdField_a_of_type_Ram.a instanceof PluginBaseActivity)) {
        bcql.a(this.a.jdField_a_of_type_Ram.a, -1, this.a.jdField_a_of_type_Ram.a.getString(2131699674), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_Ram.a).g());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.37.1
 * JD-Core Version:    0.7.0.1
 */