package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLivePlayerObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class f$9
  implements Runnable
{
  f$9(f paramf, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(f.c(this.c).values());
    ((List)localObject).addAll(f.d(this.c).values());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      f.b localb = (f.b)((Iterator)localObject).next();
      if ((localb != null) && (localb.g != null) && (localb.f != null)) {
        localb.f.onWarning(localb.g, 2105, this.a, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.9
 * JD-Core Version:    0.7.0.1
 */