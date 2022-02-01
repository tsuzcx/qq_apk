package com.tencent.live2.b;

import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.a.b;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class f$17
  implements Runnable
{
  f$17(f paramf, TRTCCloudDef.TRTCQuality paramTRTCQuality, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject1 = f.b(this.c);
    Object localObject2 = this.a;
    if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof b))) {
      ((b)localObject1).onNetworkQuality(((TRTCCloudDef.TRTCQuality)localObject2).quality);
    }
    localObject1 = this.b.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((TRTCCloudDef.TRTCQuality)((Iterator)localObject1).next()).userId;
      int i = this.a.quality;
      localObject2 = (f.b)f.a(this.c, 0).get(localObject2);
      if ((localObject2 != null) && (((f.b)localObject2).f != null) && ((((f.b)localObject2).f instanceof a))) {
        ((a)((f.b)localObject2).f).onNetworkQuality(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.17
 * JD-Core Version:    0.7.0.1
 */