package com.tencent.component.media.image;

import android.os.StatFs;
import com.tencent.component.media.ImageManagerEnv;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

final class ImageManager$10
  implements Runnable
{
  public void run()
  {
    synchronized ()
    {
      ImageManager.access$1300().clear();
      ImageManager.access$1402("");
      ImageManager.access$1502(0L);
      ImageManager.access$1600("/etc/vold.fstab");
      ImageManager.access$1600("/etc/internal_sd.fstab");
      ImageManager.access$1600("/etc/external_sd.fstab");
      Iterator localIterator = ImageManager.access$1300().values().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            Object localObject2 = new File(str);
            if ((((File)localObject2).exists()) && (((File)localObject2).canWrite()) && (ImageManager.access$1700(str)))
            {
              localObject2 = new StatFs(str);
              long l = ((StatFs)localObject2).getAvailableBlocks() * ((StatFs)localObject2).getBlockSize();
              if ((l > 0L) && (ImageManager.access$1500() < l))
              {
                ImageManager.access$1502(l);
                ImageManager.access$1402(str);
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
      }
    }
    ImageManager.access$1802(null);
    ImageManager.getCachePath(ImageManagerEnv.getAppContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.10
 * JD-Core Version:    0.7.0.1
 */