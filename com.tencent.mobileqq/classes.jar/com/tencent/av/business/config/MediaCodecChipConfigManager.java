package com.tencent.av.business.config;

import com.tencent.av.HardWareCodecSSO.ConfigRsp;
import com.tencent.av.config.MediaCodecChipConfigInfo;
import com.tencent.av.config.MediaCodecFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MediaCodecChipConfigManager
{
  private static MediaCodecChipConfigManager a;
  private MediaCodecChipConfigInfo b;
  
  private MediaCodecChipConfigManager()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecChipConfigManager", 2, "MediaCodecChipConfigManager constructor ");
    }
  }
  
  public static MediaCodecChipConfigManager a()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          a = new MediaCodecChipConfigManager();
          a.c();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void c() {}
  
  public void a(HardWareCodecSSO.ConfigRsp paramConfigRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecChipConfigManager", 2, "saveMediaCodecChipConfigContent");
    }
    paramConfigRsp = MediaCodecChipConfigInfo.a(paramConfigRsp);
    try
    {
      String str = paramConfigRsp.b();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveMediaCodecChipConfigContent jsonContent:=");
        localStringBuilder.append(str);
        QLog.d("MediaCodecChipConfigManager", 2, localStringBuilder.toString());
      }
      MediaCodecFileUtils.a(str, BaseApplication.getContext().getFilesDir().getAbsolutePath(), "av_mediacodec_file_config");
      this.b = paramConfigRsp;
      return;
    }
    finally {}
  }
  
  public MediaCodecChipConfigInfo b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecChipConfigManager", 2, "getMediaCodecChipConfigInfo");
    }
    for (;;)
    {
      try
      {
        if (this.b == null) {
          this.b = MediaCodecChipConfigInfo.a(MediaCodecFileUtils.a(BaseApplication.getContext().getFilesDir().getAbsolutePath(), "av_mediacodec_file_config"));
        }
        Object localObject1;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getMediaCodecChipConfigInfo content:=");
          if (this.b != null)
          {
            localObject1 = this.b.toString();
            localStringBuilder.append((String)localObject1);
            QLog.d("MediaCodecChipConfigManager", 2, localStringBuilder.toString());
          }
        }
        else
        {
          localObject1 = this.b;
          return localObject1;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.config.MediaCodecChipConfigManager
 * JD-Core Version:    0.7.0.1
 */