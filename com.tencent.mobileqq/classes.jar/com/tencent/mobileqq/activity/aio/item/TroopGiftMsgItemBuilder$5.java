package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

class TroopGiftMsgItemBuilder$5
  implements URLDrawable.DownloadListener
{
  TroopGiftMsgItemBuilder$5(TroopGiftMsgItemBuilder paramTroopGiftMsgItemBuilder, URLDrawable paramURLDrawable, MessageForTroopGift paramMessageForTroopGift, TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isFromNearby)
    {
      NearbyFlowerManager.a("gift_aio", "fail_obj", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
      return;
    }
    if (AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift)) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopMemberUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
    ReportController.b(localQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "objicon_fail", paramInt, 0, str, "", "0", localStringBuilder.toString());
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable))
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.objColor;
      int i = j;
      if (j == 0) {
        i = -2138570752;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.interactId))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder;
        Bitmap localBitmap = ((RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap();
        BubbleImageView localBubbleImageView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgHolder.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.giftPicId);
        localStringBuilder.append("");
        ((TroopGiftMsgItemBuilder)localObject).a(localBitmap, i, localBubbleImageView, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("drawable.getCurrDrawable() instanceof  RegionDrawable = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable);
      QLog.e("TroopGiftMsgItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */