package com.tencent.av.business.config;

import com.tencent.av.HardWareCodecSSO.ConfigRsp;
import com.tencent.av.config.MediaCodecChipConfigInfo;
import com.tencent.av.config.MediaCodecFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MediaCodecChipConfigManager
{
  private static MediaCodecChipConfigManager jdField_a_of_type_ComTencentAvBusinessConfigMediaCodecChipConfigManager;
  private MediaCodecChipConfigInfo jdField_a_of_type_ComTencentAvConfigMediaCodecChipConfigInfo;
  
  private MediaCodecChipConfigManager()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecChipConfigManager", 2, "MediaCodecChipConfigManager constructor ");
    }
  }
  
  public static MediaCodecChipConfigManager a()
  {
    if (jdField_a_of_type_ComTencentAvBusinessConfigMediaCodecChipConfigManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvBusinessConfigMediaCodecChipConfigManager == null)
        {
          jdField_a_of_type_ComTencentAvBusinessConfigMediaCodecChipConfigManager = new MediaCodecChipConfigManager();
          jdField_a_of_type_ComTencentAvBusinessConfigMediaCodecChipConfigManager.a();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvBusinessConfigMediaCodecChipConfigManager;
  }
  
  private void a() {}
  
  public MediaCodecChipConfigInfo a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecChipConfigManager", 2, "getMediaCodecChipConfigInfo");
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentAvConfigMediaCodecChipConfigInfo == null) {
          this.jdField_a_of_type_ComTencentAvConfigMediaCodecChipConfigInfo = MediaCodecChipConfigInfo.a(MediaCodecFileUtils.a(BaseApplication.getContext().getFilesDir().getAbsolutePath(), "av_mediacodec_file_config"));
        }
        Object localObject1;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getMediaCodecChipConfigInfo content:=");
          if (this.jdField_a_of_type_ComTencentAvConfigMediaCodecChipConfigInfo != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentAvConfigMediaCodecChipConfigInfo.toString();
            localStringBuilder.append((String)localObject1);
            QLog.d("MediaCodecChipConfigManager", 2, localStringBuilder.toString());
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ComTencentAvConfigMediaCodecChipConfigInfo;
          return localObject1;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  public void a(HardWareCodecSSO.ConfigRsp paramConfigRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecChipConfigManager", 2, "saveMediaCodecChipConfigContent");
    }
    paramConfigRsp = MediaCodecChipConfigInfo.a(paramConfigRsp);
    try
    {
      String str = paramConfigRsp.a();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveMediaCodecChipConfigContent jsonContent:=");
        localStringBuilder.append(str);
        QLog.d("MediaCodecChipConfigManager", 2, localStringBuilder.toString());
      }
      MediaCodecFileUtils.a(str, BaseApplication.getContext().getFilesDir().getAbsolutePath(), "av_mediacodec_file_config");
      this.jdField_a_of_type_ComTencentAvConfigMediaCodecChipConfigInfo = paramConfigRsp;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.config.MediaCodecChipConfigManager
 * JD-Core Version:    0.7.0.1
 */