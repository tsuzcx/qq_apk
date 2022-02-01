package com.tencent.biz.pubaccount.weishi_new.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.OnDownloadOpenWeishiGoH5Listener;

class WSHomeFragmentPresenter$3
  implements WeishiUtils.OnDownloadOpenWeishiGoH5Listener
{
  WSHomeFragmentPresenter$3(WSHomeFragmentPresenter paramWSHomeFragmentPresenter, Context paramContext, int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    WeishiScehmeUtil.a(this.jdField_a_of_type_AndroidContentContext, "biz_src_jc_gzh_weishi", paramString, 1, WSHomeFragmentPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSHomeFragmentPresenter), this.jdField_a_of_type_Int);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      WeishiActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, paramString);
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = WSHomeFragmentPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSHomeFragmentPresenter);
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = WSReportDc00898.b();
    localWSDownloadParams.mScheme = paramString;
    WeishiDownloadUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, localWSDownloadParams, false);
  }
  
  public void d(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      WSHomeFragmentPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSHomeFragmentPresenter, this.jdField_a_of_type_AndroidContentContext, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter.3
 * JD-Core Version:    0.7.0.1
 */