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
    if (this.b.J != null)
    {
      if (!this.b.J.equals(paramBaseResp.transaction)) {
        return;
      }
      BaseApplicationImpl.getContext();
      int i = paramBaseResp.errCode;
      if (i != -2)
      {
        if (i != 0)
        {
          QRUtils.a(1, 2131916544);
          return;
        }
        QRUtils.a(2, 2131916563);
        if ((this.b.y instanceof SwiftWebViewFragmentSupporter))
        {
          paramBaseResp = ((SwiftWebViewFragmentSupporter)this.b.y).getCurrentWebViewFragment();
          if (this.b.ag == 1) {
            i = 1009;
          } else {
            i = 1004;
          }
          if (paramBaseResp == null) {
            return;
          }
          Object localObject = (SwiftBrowserShareMenuHandler)paramBaseResp.getComponentProvider().a(4);
          String str1 = ((SwiftBrowserShareMenuHandler)localObject).o;
          String str2 = ((SwiftBrowserShareMenuHandler)localObject).n;
          String str3 = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(paramBaseResp.getUrl());
          localObject = ((SwiftBrowserShareMenuHandler)localObject).p;
          if ((localObject != null) && (!"".equals(localObject)))
          {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, (String)localObject, str1, paramBaseResp.getUrl(), str3, false);
            return;
          }
          if (this.b.ag == 1) {
            i = 1003;
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str2, str1, this.a, str3, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.3
 * JD-Core Version:    0.7.0.1
 */