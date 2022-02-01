package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aiti;
import anyw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class StickerRecManager$5
  implements Runnable
{
  public StickerRecManager$5(aiti paramaiti) {}
  
  public void run()
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "start pull words");
    }
    int m = 255;
    Object localObject = (anyw)aiti.a(this.this$0).getManager(51);
    int j = k;
    int i = m;
    if (localObject != null)
    {
      localObject = ((anyw)localObject).b(aiti.a(this.this$0).getCurrentAccountUin());
      j = k;
      i = m;
      if (localObject != null)
      {
        if (((Card)localObject).shGender != 1) {
          break label113;
        }
        i = 1;
      }
    }
    for (;;)
    {
      j = ((Card)localObject).age;
      this.this$0.a(aiti.a(this.this$0).c(), 3, i, j);
      return;
      label113:
      if (((Card)localObject).shGender == 0) {
        i = 0;
      } else {
        i = 255;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.5
 * JD-Core Version:    0.7.0.1
 */