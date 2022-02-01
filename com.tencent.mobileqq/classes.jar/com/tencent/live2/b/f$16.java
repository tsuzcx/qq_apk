package com.tencent.live2.b;

import android.text.TextUtils;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.a.d;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class f$16
  implements Runnable
{
  f$16(f paramf, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (f.f(this.b) == null) {
      f.a(this.b, new HashMap());
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = this.a;
    Object localObject3;
    Object localObject4;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
    {
      localObject1 = new HashMap();
      if (f.g(this.b) == a.d.a)
      {
        localObject3 = this.a;
        Collections.sort((List)localObject3, new f.16.1(this));
        localObject3 = ((ArrayList)localObject3).iterator();
        int i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)localObject3).next();
          if (i >= 10) {
            break;
          }
          if (((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume > 10)
          {
            i += 1;
            ((Map)localObject1).put(((TRTCCloudDef.TRTCVolumeInfo)localObject4).userId, Integer.valueOf(((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume));
            ((ArrayList)localObject2).add(localObject4);
          }
        }
      }
      ((ArrayList)localObject2).addAll(this.a);
      localObject3 = this.a.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)localObject3).next();
        ((Map)localObject1).put(((TRTCCloudDef.TRTCVolumeInfo)localObject4).userId, Integer.valueOf(((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume));
      }
      localObject3 = f.f(this.b).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        if (!((Map)localObject1).containsKey(localObject4))
        {
          TRTCCloudDef.TRTCVolumeInfo localTRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
          localTRTCVolumeInfo.userId = ((String)localObject4);
          localTRTCVolumeInfo.volume = 0;
          ((ArrayList)localObject2).add(localTRTCVolumeInfo);
        }
      }
      f.f(this.b).clear();
      f.f(this.b).putAll((Map)localObject1);
    }
    else
    {
      localObject1 = f.f(this.b).keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        localObject4 = new TRTCCloudDef.TRTCVolumeInfo();
        ((TRTCCloudDef.TRTCVolumeInfo)localObject4).userId = ((String)localObject3);
        ((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume = 0;
        ((ArrayList)localObject2).add(localObject4);
      }
    }
    if (f.h(this.b) != null) {
      localObject1 = f.h(this.b).g();
    } else {
      localObject1 = null;
    }
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)localObject2).next();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(((TRTCCloudDef.TRTCVolumeInfo)localObject3).userId)))
      {
        localObject4 = f.b(this.b);
        if (localObject4 != null) {
          ((V2TXLivePusherObserver)localObject4).onMicrophoneVolumeUpdate(((TRTCCloudDef.TRTCVolumeInfo)localObject3).volume);
        }
      }
      else
      {
        localObject4 = (f.b)f.c(this.b).get(((TRTCCloudDef.TRTCVolumeInfo)localObject3).userId);
        if ((localObject4 != null) && (((f.b)localObject4).g != null) && (((f.b)localObject4).f != null)) {
          ((f.b)localObject4).f.onPlayoutVolumeUpdate(((f.b)localObject4).g, ((TRTCCloudDef.TRTCVolumeInfo)localObject3).volume);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.16
 * JD-Core Version:    0.7.0.1
 */