package com.tencent.mobileqq.bubble;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class BubbleNewAIOAnim$7
  implements Runnable
{
  BubbleNewAIOAnim$7(BubbleNewAIOAnim paramBubbleNewAIOAnim) {}
  
  public void run()
  {
    if ((this.this$0.j != null) && (this.this$0.j.size() > 0))
    {
      Iterator localIterator = this.this$0.j.iterator();
      while (localIterator.hasNext())
      {
        BubbleNewAnimConf localBubbleNewAnimConf = (BubbleNewAnimConf)localIterator.next();
        File localFile = new File(this.this$0.i.d(this.this$0.f, false), this.this$0.h.a);
        int i = 0;
        while (i < localBubbleNewAnimConf.d)
        {
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(localFile.getAbsolutePath());
          ((StringBuilder)localObject1).append(File.separatorChar);
          ((StringBuilder)localObject1).append(localBubbleNewAnimConf.e);
          int j = i + 1;
          ((StringBuilder)localObject1).append(String.format("%04d.png", new Object[] { Integer.valueOf(j) }));
          localObject1 = ((StringBuilder)localObject1).toString();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localBubbleNewAnimConf.a);
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject2 = ((StringBuilder)localObject2).toString();
          if (!this.this$0.x.containsKey(localObject2))
          {
            Object localObject3 = GlobalImageCache.a.get(localObject2);
            if ((localObject3 != null) && ((localObject3 instanceof Bitmap))) {
              localObject1 = (Bitmap)localObject3;
            } else {
              localObject1 = BubbleNewAIOAnim.a(this.this$0, (String)localObject1, null);
            }
          }
          else
          {
            localObject1 = (Bitmap)this.this$0.x.get(localObject2);
          }
          i = j;
          if (localObject1 != null)
          {
            GlobalImageCache.a.put(localObject2, localObject1);
            this.this$0.x.put(localObject2, localObject1);
            i = j;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAIOAnim.7
 * JD-Core Version:    0.7.0.1
 */