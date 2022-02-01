package com.tencent.mobileqq.activity.aio.item;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FlashPicItemBuilder$1
  implements View.OnClickListener
{
  FlashPicItemBuilder$1(FlashPicItemBuilder paramFlashPicItemBuilder) {}
  
  public void onClick(View paramView)
  {
    long l = SystemClock.uptimeMillis();
    if (l - FlashPicItemBuilder.a(this.a) >= 800L)
    {
      FlashPicItemBuilder.a(this.a, l);
      FlashPicItemBuilder.FlashPicHolder localFlashPicHolder = (FlashPicItemBuilder.FlashPicHolder)AIOUtils.b(paramView);
      if (localFlashPicHolder != null)
      {
        Object localObject3 = localFlashPicHolder.q;
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = this.a.d.getMessageFacade().a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq);
          localObject1 = localObject2;
          if ((localObject3 instanceof MessageForPic)) {
            localObject1 = (MessageForPic)localObject3;
          }
        }
        if (localObject1 != null)
        {
          boolean bool;
          if (HotChatHelper.a((MessageRecord)localObject1)) {
            bool = HotChatHelper.b((MessageRecord)localObject1);
          } else {
            bool = ((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsgReaded((MessageRecord)localObject1);
          }
          if (!bool) {
            if (localFlashPicHolder.e.getStatus() == 0)
            {
              if (!localFlashPicHolder.e.isDownloadStarted()) {
                localFlashPicHolder.e.startDownload();
              }
            }
            else if (localFlashPicHolder.e.getStatus() == 2) {
              localFlashPicHolder.e.startDownload();
            } else {
              FlashPicItemBuilder.a(this.a, (MessageForPic)localObject1, localFlashPicHolder.a);
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */