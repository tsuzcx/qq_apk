package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopFileHandler;
import java.util.HashMap;

final class TroopFileItemBuilder$1
  implements Runnable
{
  public void run()
  {
    TroopFileItemBuilder.a(this.a, this.b, this.c);
    long l1;
    if (TroopFileItemBuilder.D.containsKey(this.d)) {
      l1 = ((Long)TroopFileItemBuilder.D.get(this.d)).longValue();
    } else {
      l1 = 0L;
    }
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 10000L)
    {
      TroopFileHandler localTroopFileHandler = (TroopFileHandler)this.e.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER);
      ((Activity)this.a).runOnUiThread(new TroopFileItemBuilder.1.1(this, localTroopFileHandler));
      TroopFileItemBuilder.D.put(this.d, Long.valueOf(l2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */