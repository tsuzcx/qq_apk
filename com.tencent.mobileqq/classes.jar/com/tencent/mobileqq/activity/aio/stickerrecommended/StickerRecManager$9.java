package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aemb;
import aemi;
import android.text.TextUtils;
import atmp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class StickerRecManager$9
  implements Runnable
{
  public StickerRecManager$9(aemi paramaemi) {}
  
  public void run()
  {
    int i = 0;
    Object localObject = new File(aemb.a);
    long l1 = 0L;
    localObject = ((File)localObject).listFiles();
    long l2 = l1;
    if (localObject != null)
    {
      l2 = l1;
      if (localObject.length > 0)
      {
        int j = localObject.length;
        for (;;)
        {
          l2 = l1;
          if (i >= j) {
            break;
          }
          l2 = localObject[i].length();
          i += 1;
          l1 = l2 + l1;
        }
      }
    }
    if (l2 < 104857600L) {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "current cache length:" + l2 + ", not need delete cache");
      }
    }
    for (;;)
    {
      return;
      l1 = System.currentTimeMillis();
      try
      {
        localObject = new String[1];
        localObject[0] = String.valueOf(l1 - 86400000L);
        Iterator localIterator = aemi.a(this.this$0).a(StickerRecCacheEntity.class, StickerRecCacheEntity.class.getSimpleName(), false, "lastTime<?", (String[])localObject, "", "", "", "").iterator();
        while (localIterator.hasNext())
        {
          StickerRecCacheEntity localStickerRecCacheEntity = (StickerRecCacheEntity)localIterator.next();
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, new Object[] { "Overdue cache:", "fileName=" + localStickerRecCacheEntity.filePath + " md5=" + localStickerRecCacheEntity.md5 });
          }
          if (!TextUtils.isEmpty(localStickerRecCacheEntity.filePath)) {
            new File(localStickerRecCacheEntity.filePath).delete();
          }
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception localException) {}
    }
    QLog.d("StickerRecManager", 2, "clearOverdueStickerCache error", localException);
    return;
    aemi.a(this.this$0).a(StickerRecCacheEntity.class.getSimpleName(), "lastTime<?", localException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.9
 * JD-Core Version:    0.7.0.1
 */