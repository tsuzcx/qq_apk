package com.tencent.biz.pubaccount.ecshopassit;

import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.app.HardCodeUtil;

class BusinessBrowser$BusinessBrowserFragment$1
  extends IPublicAccountObserver.OnCallback
{
  BusinessBrowser$BusinessBrowserFragment$1(BusinessBrowser.BusinessBrowserFragment paramBusinessBrowserFragment) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    if (this.a.a != null)
    {
      if ((paramBoolean) && (this.a.f != null) && (this.a.f.equals(paramString)))
      {
        this.a.a.setText(HardCodeUtil.a(2131899509));
        this.a.a.setEnabled(false);
        this.a.a.setBackgroundResource(0);
        return;
      }
      this.a.a.setText(HardCodeUtil.a(2131899712));
      this.a.a.setEnabled(true);
      this.a.a.setBackgroundResource(2130848977);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */