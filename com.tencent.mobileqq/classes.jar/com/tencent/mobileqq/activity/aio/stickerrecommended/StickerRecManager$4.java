package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aexb;
import ajxl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class StickerRecManager$4
  implements Runnable
{
  public StickerRecManager$4(aexb paramaexb) {}
  
  public void run()
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "start pull words");
    }
    int m = 255;
    Object localObject = (ajxl)aexb.a(this.this$0).getManager(51);
    int j = k;
    int i = m;
    if (localObject != null)
    {
      localObject = ((ajxl)localObject).b(aexb.a(this.this$0).getCurrentAccountUin());
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
      this.this$0.a(aexb.a(this.this$0).c(), 3, i, j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.4
 * JD-Core Version:    0.7.0.1
 */