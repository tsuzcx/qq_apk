package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.servlet.VipGifServlet;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import mqq.app.NewIntent;

public class VipCheckGift
  extends AsyncStep
{
  protected int doStep()
  {
    Object localObject = (VipGiftManager)this.mAutomator.a.getManager(QQManagerFactory.VIP_GIF_MANAGER);
    VipGiftDownloadInfo localVipGiftDownloadInfo = ((VipGiftManager)localObject).a();
    if (localVipGiftDownloadInfo != null) {
      if ((localVipGiftDownloadInfo.d == 0L) && (localVipGiftDownloadInfo.a != 0L))
      {
        ((VipGiftManager)localObject).a(localVipGiftDownloadInfo.a);
      }
      else if (localVipGiftDownloadInfo.d == 2L)
      {
        localObject = new NewIntent(this.mAutomator.a.getApplication(), VipGifServlet.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localVipGiftDownloadInfo.a);
        this.mAutomator.a.startServlet((NewIntent)localObject);
      }
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.VipCheckGift
 * JD-Core Version:    0.7.0.1
 */