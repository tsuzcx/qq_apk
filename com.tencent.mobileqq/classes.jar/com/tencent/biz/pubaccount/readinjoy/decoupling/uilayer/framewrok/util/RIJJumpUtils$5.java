package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.qphone.base.util.QLog;

final class RIJJumpUtils$5
  implements Runnable
{
  RIJJumpUtils$5(Activity paramActivity, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt) {}
  
  public void run()
  {
    try
    {
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_Int);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RIJJumpUtils", 1, "[reportDataInSubThread] e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.5
 * JD-Core Version:    0.7.0.1
 */