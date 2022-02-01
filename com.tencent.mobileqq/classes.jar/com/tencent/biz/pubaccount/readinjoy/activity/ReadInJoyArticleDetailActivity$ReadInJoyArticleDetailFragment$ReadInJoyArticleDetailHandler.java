package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

class ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$ReadInJoyArticleDetailHandler
  extends SwiftBrowserUIStyleHandler
{
  ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$ReadInJoyArticleDetailHandler(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment paramReadInJoyArticleDetailFragment) {}
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment.webView != null) && (this.c != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment.jdField_a_of_type_AndroidWidgetImageView = new ImageView(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841836);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      this.c.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment.jdField_a_of_type_AndroidWidgetImageView);
      if (IPluginAdapterProxy.getProxy().isNightMode())
      {
        this.c.setBackgroundColor(-6710887);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841837);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.ReadInJoyArticleDetailHandler
 * JD-Core Version:    0.7.0.1
 */