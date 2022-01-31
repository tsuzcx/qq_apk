package com.tencent.mobileqq.activity.aio.stickerrecommended;

import agyv;
import awgf;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class StickerRecManager$8
  implements Runnable
{
  public StickerRecManager$8(agyv paramagyv, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      StickerRecCacheEntity localStickerRecCacheEntity1 = (StickerRecCacheEntity)localIterator.next();
      StickerRecCacheEntity localStickerRecCacheEntity2 = (StickerRecCacheEntity)agyv.a(this.this$0).a(StickerRecCacheEntity.class, "md5=?", new String[] { localStickerRecCacheEntity1.md5 });
      if (localStickerRecCacheEntity2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "old exist: fileName=" + localStickerRecCacheEntity2.md5 + " lastTime=" + localStickerRecCacheEntity2.lastTime);
        }
        localStickerRecCacheEntity2.lastTime = localStickerRecCacheEntity1.lastTime;
        agyv.a(this.this$0).a(localStickerRecCacheEntity2);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "old not exist: fileName=" + localStickerRecCacheEntity1.md5 + " lastTime=" + localStickerRecCacheEntity1.lastTime);
        }
        agyv.a(this.this$0).b(localStickerRecCacheEntity1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.8
 * JD-Core Version:    0.7.0.1
 */