package com.tencent.live2.b;

import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import java.util.Comparator;

class f$16$1
  implements Comparator<TRTCCloudDef.TRTCVolumeInfo>
{
  f$16$1(f.16 param16) {}
  
  public int a(TRTCCloudDef.TRTCVolumeInfo paramTRTCVolumeInfo1, TRTCCloudDef.TRTCVolumeInfo paramTRTCVolumeInfo2)
  {
    return paramTRTCVolumeInfo2.volume - paramTRTCVolumeInfo1.volume;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.16.1
 * JD-Core Version:    0.7.0.1
 */