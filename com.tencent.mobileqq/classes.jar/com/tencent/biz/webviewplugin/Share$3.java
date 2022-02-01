package com.tencent.biz.webviewplugin;

import com.tencent.biz.pubaccount.AccountDetail.activity.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class Share$3
  implements WXShareHelper.WXShareListener
{
  Share$3(Share paramShare, String paramString) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare.o == null) || (!this.jdField_a_of_type_ComTencentBizWebviewpluginShare.o.equals(paramBaseResp.transaction))) {}
    int i;
    String str1;
    String str2;
    String str3;
    for (;;)
    {
      return;
      BaseApplicationImpl.getContext();
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        QRUtils.a(1, 2131719291);
        return;
      }
      QRUtils.a(2, 2131719309);
      if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a instanceof SwiftWebViewFragmentSupporter))
      {
        paramBaseResp = ((SwiftWebViewFragmentSupporter)this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a).getCurrentWebViewFragment();
        if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.e == 1) {}
        for (i = 1009; paramBaseResp != null; i = 1004)
        {
          str1 = paramBaseResp.msgid;
          str2 = paramBaseResp.publicUin;
          str3 = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(paramBaseResp.mUrl);
          String str4 = paramBaseResp.sourcePuin;
          if ((str4 == null) || ("".equals(str4))) {
            break label220;
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, str1, paramBaseResp.mUrl, str3, false);
          return;
        }
      }
    }
    label220:
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.e == 1) {
      i = 1003;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str2, str1, this.jdField_a_of_type_JavaLangString, str3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.3
 * JD-Core Version:    0.7.0.1
 */