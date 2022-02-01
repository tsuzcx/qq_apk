package com.tencent.biz.qcircleshadow.lib;

import android.content.Context;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.api.IVideoEnvironment;
import com.tencent.mobileqq.shortvideo.api.IVideoTrimmer;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QZoneVideoCommonUtils.VideoSupport;

public class QCircleHostVideoHelper
{
  public static int MSG_BEGIN()
  {
    return 1;
  }
  
  public static int MSG_END()
  {
    return 3;
  }
  
  public static int MSG_PROGRESS()
  {
    return 2;
  }
  
  public static boolean checkAndLoadAVCodec()
  {
    return ((IVideoEnvironment)QRoute.api(IVideoEnvironment.class)).checkAndLoadAVCodec();
  }
  
  public static int getAVCodecVersion()
  {
    return ((IVideoEnvironment)QRoute.api(IVideoEnvironment.class)).getAVCodecVersion();
  }
  
  public static VideoConverterConfig getCompressConfig(String paramString)
  {
    return ((IVideoTrimmer)QRoute.api(IVideoTrimmer.class)).getCompressConfig(paramString);
  }
  
  public static String getRealProperties(String paramString, int paramInt1, int paramInt2)
  {
    return TrimNative.getRealProperties(paramString, paramInt1, paramInt2);
  }
  
  public static String getShortVideoSoLibName()
  {
    return ((IVideoEnvironment)QRoute.api(IVideoEnvironment.class)).getShortVideoSoLibName();
  }
  
  public static String getShortVideoSoPath(Context paramContext)
  {
    return ((IVideoEnvironment)QRoute.api(IVideoEnvironment.class)).getShortVideoSoPath(paramContext);
  }
  
  public static boolean getTrimSupportIsAvailable()
  {
    return QZoneVideoCommonUtils.getTrimSupport().isAvailable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostVideoHelper
 * JD-Core Version:    0.7.0.1
 */