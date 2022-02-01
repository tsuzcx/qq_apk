package com.tencent.biz.webviewplugin;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class Share$3
  implements WXShareHelper.WXShareListener
{
  Share$3(Share paramShare, String paramString) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.o != null)
    {
      if (!this.jdField_a_of_type_ComTencentBizWebviewpluginShare.o.equals(paramBaseResp.transaction)) {
        return;
      }
      BaseApplicationImpl.getContext();
      int i = paramBaseResp.errCode;
      if (i != -2)
      {
        if (i != 0)
        {
          QRUtils.a(1, 2131719009);
          return;
        }
        QRUtils.a(2, 2131719027);
        if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a instanceof SwiftWebViewFragmentSupporter))
        {
          paramBaseResp = ((SwiftWebViewFragmentSupporter)this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a).getCurrentWebViewFragment();
          if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.e == 1) {
            i = 1009;
          } else {
            i = 1004;
          }
          if (paramBaseResp == null) {
            return;
          }
          Object localObject = (SwiftBrowserShareMenuHandler)paramBaseResp.getComponentProvider().a(4);
          String str1 = ((SwiftBrowserShareMenuHandler)localObject).b;
          String str2 = ((SwiftBrowserShareMenuHandler)localObject).jdField_a_of_type_JavaLangString;
          String str3 = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(paramBaseResp.getUrl());
          localObject = ((SwiftBrowserShareMenuHandler)localObject).c;
          if ((localObject != null) && (!"".equals(localObject)))
          {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, (String)localObject, str1, paramBaseResp.getUrl(), str3, false);
            return;
          }
          if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.e == 1) {
            i = 1003;
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str2, str1, this.jdField_a_of_type_JavaLangString, str3, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.3
 * JD-Core Version:    0.7.0.1
 */