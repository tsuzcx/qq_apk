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
    Object localObject = (VipGiftManager)this.mAutomator.k.getManager(QQManagerFactory.VIP_GIF_MANAGER);
    VipGiftDownloadInfo localVipGiftDownloadInfo = ((VipGiftManager)localObject).e();
    if (localVipGiftDownloadInfo != null) {
      if ((localVipGiftDownloadInfo.f == 0L) && (localVipGiftDownloadInfo.c != 0L))
      {
        ((VipGiftManager)localObject).c(localVipGiftDownloadInfo.c);
      }
      else if (localVipGiftDownloadInfo.f == 2L)
      {
        localObject = new NewIntent(this.mAutomator.k.getApplication(), VipGifServlet.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localVipGiftDownloadInfo.c);
        this.mAutomator.k.startServlet((NewIntent)localObject);
      }
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.VipCheckGift
 * JD-Core Version:    0.7.0.1
 */