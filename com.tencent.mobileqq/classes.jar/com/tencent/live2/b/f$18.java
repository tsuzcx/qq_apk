package com.tencent.live2.b;

import com.tencent.live2.V2TXLiveDef.V2TXLivePlayerStatistics;
import com.tencent.live2.V2TXLiveDef.V2TXLivePusherStatistics;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCLocalStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCRemoteStatistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class f$18
  implements Runnable
{
  f$18(f paramf, TRTCStatistics paramTRTCStatistics) {}
  
  public void run()
  {
    Object localObject1 = f.b(this.b);
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject3 = this.a.localArray.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (TRTCStatistics.TRTCLocalStatistics)((Iterator)localObject3).next();
        if (((TRTCStatistics.TRTCLocalStatistics)localObject2).streamType == 0)
        {
          localObject3 = new V2TXLiveDef.V2TXLivePusherStatistics();
          ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).appCpu = this.a.appCpu;
          ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).systemCpu = this.a.systemCpu;
          ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).audioBitrate = ((TRTCStatistics.TRTCLocalStatistics)localObject2).audioBitrate;
          ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).videoBitrate = ((TRTCStatistics.TRTCLocalStatistics)localObject2).videoBitrate;
          ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).width = ((TRTCStatistics.TRTCLocalStatistics)localObject2).width;
          ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).height = ((TRTCStatistics.TRTCLocalStatistics)localObject2).height;
          ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).fps = ((TRTCStatistics.TRTCLocalStatistics)localObject2).frameRate;
          ((V2TXLivePusherObserver)localObject1).onStatisticsUpdate((V2TXLiveDef.V2TXLivePusherStatistics)localObject3);
        }
      }
    }
    localObject1 = this.a.remoteArray.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TRTCStatistics.TRTCRemoteStatistics)((Iterator)localObject1).next();
      localObject3 = (f.b)f.a(this.b, ((TRTCStatistics.TRTCRemoteStatistics)localObject2).streamType).get(((TRTCStatistics.TRTCRemoteStatistics)localObject2).userId);
      if ((localObject3 != null) && (((f.b)localObject3).g != null) && (((f.b)localObject3).f != null))
      {
        V2TXLiveDef.V2TXLivePlayerStatistics localV2TXLivePlayerStatistics = new V2TXLiveDef.V2TXLivePlayerStatistics();
        localV2TXLivePlayerStatistics.appCpu = this.a.appCpu;
        localV2TXLivePlayerStatistics.systemCpu = this.a.systemCpu;
        localV2TXLivePlayerStatistics.audioBitrate = ((TRTCStatistics.TRTCRemoteStatistics)localObject2).audioBitrate;
        localV2TXLivePlayerStatistics.videoBitrate = ((TRTCStatistics.TRTCRemoteStatistics)localObject2).videoBitrate;
        localV2TXLivePlayerStatistics.width = ((TRTCStatistics.TRTCRemoteStatistics)localObject2).width;
        localV2TXLivePlayerStatistics.height = ((TRTCStatistics.TRTCRemoteStatistics)localObject2).height;
        localV2TXLivePlayerStatistics.fps = ((TRTCStatistics.TRTCRemoteStatistics)localObject2).frameRate;
        ((f.b)localObject3).f.onStatisticsUpdate(((f.b)localObject3).g, localV2TXLivePlayerStatistics);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.18
 * JD-Core Version:    0.7.0.1
 */