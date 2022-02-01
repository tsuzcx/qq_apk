package com.tencent.biz.pubaccount.ecshopassit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import org.json.JSONException;
import org.json.JSONObject;

class ShopWebViewFragment$2
  implements View.OnTouchListener
{
  ShopWebViewFragment$2(ShopWebViewFragment paramShopWebViewFragment, JSONObject paramJSONObject1, JSONObject paramJSONObject2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        i = (int)(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.c - paramMotionEvent.getY());
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.c = ((int)paramMotionEvent.getY());
        if ((i < 0) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.d > 0)) {
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.d = 0;
        }
        if ((i > 0) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.d < 0)) {
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.d = 0;
        }
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment;
        paramView.d += i;
        return false;
      }
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("y_offset", this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.d);
        paramView = WebViewPlugin.toJsScript("onScroll", this.jdField_a_of_type_OrgJsonJSONObject, this.b);
        if (ShopWebViewFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment) == null) {
          break label182;
        }
        ShopWebViewFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment).callJs(paramView);
        return false;
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.c = ((int)paramMotionEvent.getY());
    }
    label182:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment.2
 * JD-Core Version:    0.7.0.1
 */