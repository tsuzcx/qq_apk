package com.tencent.biz.pubaccount.weishi_new.download;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;

final class WSDownloadAppDialog$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (WeishiGuideUtils.a(this.a))
    {
      WeishiScehmeUtil.a(this.a, "biz_src_jc_gzh_weishi", this.b, this.c.mScene, this.c.mLinkStrategyType, this.c.mEventId);
      UserActionReportPresenter.a(114, this.d, this.e, null);
    }
    else
    {
      if (this.c.mStReportItem == null) {
        this.c.mStReportItem = UserActionReportPresenter.a();
      }
      this.c.mStReportItem.downloadscene = WeishiDownloadUtil.a(this.c.mScene, this.c.mLinkStrategyType, this.c.mEventId);
      this.c.mStReportItem.comment_loctaion = this.e;
      WeishiDownloadUtil.b(this.a, this.c);
    }
    paramDialogInterface.dismiss();
    WSReportDc00898.b(112, 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WSDownloadAppDialog.2
 * JD-Core Version:    0.7.0.1
 */