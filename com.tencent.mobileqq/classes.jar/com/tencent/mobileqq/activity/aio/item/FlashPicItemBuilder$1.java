package com.tencent.mobileqq.activity.aio.item;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FlashPicItemBuilder$1
  implements View.OnClickListener
{
  FlashPicItemBuilder$1(FlashPicItemBuilder paramFlashPicItemBuilder) {}
  
  public void onClick(View paramView)
  {
    long l = SystemClock.uptimeMillis();
    if (l - FlashPicItemBuilder.a(this.a) < 800L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FlashPicItemBuilder.a(this.a, l);
      FlashPicItemBuilder.FlashPicHolder localFlashPicHolder = (FlashPicItemBuilder.FlashPicHolder)AIOUtils.a(paramView);
      if (localFlashPicHolder != null)
      {
        Object localObject3 = localFlashPicHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = this.a.a.getMessageFacade().a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq);
          localObject1 = localObject2;
          if ((localObject3 instanceof MessageForPic)) {
            localObject1 = (MessageForPic)localObject3;
          }
        }
        if (localObject1 != null)
        {
          if (HotChatHelper.a((MessageRecord)localObject1)) {}
          for (boolean bool = HotChatHelper.b((MessageRecord)localObject1);; bool = FlashPicHelper.b((MessageRecord)localObject1))
          {
            if (bool) {
              break label185;
            }
            if (localFlashPicHolder.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 0) {
              break label187;
            }
            if (localFlashPicHolder.jdField_a_of_type_ComTencentImageURLDrawable.isDownloadStarted()) {
              break;
            }
            localFlashPicHolder.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
            break;
          }
          label185:
          continue;
          label187:
          if (localFlashPicHolder.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2) {
            localFlashPicHolder.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
          } else {
            FlashPicItemBuilder.a(this.a, (MessageForPic)localObject1, localFlashPicHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */