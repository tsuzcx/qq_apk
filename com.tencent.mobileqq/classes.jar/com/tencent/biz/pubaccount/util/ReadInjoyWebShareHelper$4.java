package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.util.Map;

class ReadInjoyWebShareHelper$4
  implements Runnable
{
  ReadInjoyWebShareHelper$4(ReadInjoyWebShareHelper paramReadInjoyWebShareHelper, boolean paramBoolean1, Map paramMap, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    Object localObject = ReadInjoyWebShareHelper.a(this.this$0).a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return;
    }
    ReadInjoyWebShareHelper.c(this.this$0);
    if (this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener == null)
    {
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener = new ReadInjoyWebShareHelper.4.1(this);
      WxShareHelperFromReadInjoy.a().a(this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener);
    }
    this.this$0.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      WxShareHelperFromReadInjoy.a().c(this.this$0.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, this.jdField_b_of_type_JavaLangString, this.c, this.d);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.d(new ReadInjoyWebShareHelper.4.2(this, (Bitmap)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.4
 * JD-Core Version:    0.7.0.1
 */