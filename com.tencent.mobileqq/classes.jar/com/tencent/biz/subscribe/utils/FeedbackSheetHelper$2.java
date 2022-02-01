package com.tencent.biz.subscribe.utils;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.network.DoTipOffRequest;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class FeedbackSheetHelper$2
  implements ActionSheet.OnButtonClickListener
{
  FeedbackSheetHelper$2(CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, FeedbackSheetHelper.ResultListener paramResultListener, FeedbackSheetHelper.ClickItemListener paramClickItemListener, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = new DoTipOffRequest(0, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, 2);
      VSNetworkHelper.getInstance().sendRequest(paramView, new FeedbackSheetHelper.2.1(this));
      if (this.jdField_a_of_type_ComTencentBizSubscribeUtilsFeedbackSheetHelper$ClickItemListener != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeUtilsFeedbackSheetHelper$ClickItemListener.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.FeedbackSheetHelper.2
 * JD-Core Version:    0.7.0.1
 */