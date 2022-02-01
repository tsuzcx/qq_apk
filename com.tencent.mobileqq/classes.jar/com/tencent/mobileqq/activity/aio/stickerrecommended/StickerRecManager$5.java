package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class StickerRecManager$5
  implements Runnable
{
  StickerRecManager$5(StickerRecManager paramStickerRecManager) {}
  
  public void run()
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "start pull words");
    }
    int m = 255;
    Object localObject = (FriendsManager)StickerRecManager.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
    int j = k;
    int i = m;
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).a(StickerRecManager.a(this.this$0).getCurrentAccountUin());
      j = k;
      i = m;
      if (localObject != null)
      {
        if (((Card)localObject).shGender != 1) {
          break label114;
        }
        i = 1;
      }
    }
    for (;;)
    {
      j = ((Card)localObject).age;
      this.this$0.a(StickerRecManager.a(this.this$0).getCurrentUin(), 3, i, j);
      return;
      label114:
      if (((Card)localObject).shGender == 0) {
        i = 0;
      } else {
        i = 255;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.5
 * JD-Core Version:    0.7.0.1
 */