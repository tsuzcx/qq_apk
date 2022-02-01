package com.tencent.mobileqq.activity.aio.stickerrecommended.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.qphone.base.util.QLog;

class StickerRecManagerImpl$4
  implements Runnable
{
  StickerRecManagerImpl$4(StickerRecManagerImpl paramStickerRecManagerImpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "start pull words");
    }
    int i = 255;
    Object localObject = ((IProfileCardUtil)QRoute.api(IProfileCardUtil.class)).findFriendCardByUin(StickerRecManagerImpl.access$300(this.this$0));
    int k = 0;
    int j = i;
    if (localObject != null)
    {
      if (((Card)localObject).shGender == 1) {
        i = 1;
      } else if (((Card)localObject).shGender == 0) {
        i = 0;
      }
      k = ((Card)localObject).age;
      j = i;
    }
    localObject = this.this$0;
    ((StickerRecManagerImpl)localObject).sendPullWordsRequest(StickerRecManagerImpl.access$300((StickerRecManagerImpl)localObject).getCurrentUin(), 3, j, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */