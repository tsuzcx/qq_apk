package com.tencent.biz.qqcircle.publish.uploader;

import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.QZoneAppConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.upload.QCircleImageSizeStrategy;
import com.tencent.biz.qqcircle.publish.util.ExifUtil;
import com.tencent.biz.qqcircle.publish.util.ImageUtil.Size;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.data.PhotoWallUploadTask;
import com.tencent.upload.uinterface.data.UppUploadTask;
import com.tencent.upload.uinterface.data.UpsImageUploadTask;
import java.io.File;

public class QcircleUploadConfig
  implements IUploadConfig
{
  private int a(String paramString, int paramInt)
  {
    return QCircleConfigHelper.a("PhotoUpload", paramString, Integer.valueOf(paramInt)).intValue();
  }
  
  private String a(String paramString1, String paramString2)
  {
    return QCircleConfigHelper.a("PhotoUpload", paramString1, paramString2);
  }
  
  public boolean a(int paramInt)
  {
    int i = getCompressToWebpFlag();
    if ((paramInt == 2) && ((i & 0x10) == 16)) {
      return true;
    }
    return (paramInt != 2) && (paramInt != 3) && ((i & 0x1) == 1);
  }
  
  public boolean canHoldSystemLock()
  {
    boolean bool = false;
    if (QCircleConfigHelper.a("PhotoUpload", "canHoldSystemLock", Integer.valueOf(0)).intValue() == 1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean enableBitmapNativeAlloc()
  {
    return false;
  }
  
  public boolean enableV6Route()
  {
    return QcircleUploadEnv.a(0);
  }
  
  public int getAppId()
  {
    return QCircleHostConstants.QZoneAppConstants.QZONE_BUSSINESS_ID();
  }
  
  public String getChangeRouteRetCodes()
  {
    return QCircleConfigHelper.a("QzoneUploadSetting", "UploadChangeRouteRetCode", "104,115,11,2");
  }
  
  public int getCompressToWebpFlag()
  {
    return QCircleConfigHelper.a("PhotoUpload", "CompressToWebp", Integer.valueOf(0)).intValue();
  }
  
  public int getConnectTimeout()
  {
    return a("ConnectTimeout", 20);
  }
  
  public long getCurrentUin()
  {
    return LoginData.a().b();
  }
  
  public int getDataTimeout()
  {
    return a("DataTimeout", 60);
  }
  
  public String getDeviceInfo()
  {
    return HostDataTransUtils.getDeviceInfo();
  }
  
  public int getDoNotFragment()
  {
    return QCircleConfigHelper.a("WNSSettting", "ip_no_pmtu_disc", Integer.valueOf(1)).intValue();
  }
  
  public String getExifTagCode(String paramString)
  {
    return ExifUtil.a(paramString);
  }
  
  public int getGifUploadLimit(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 6) {
            return 0;
          }
          return QCircleConfigHelper.a("PhotoUpload", "GifUploadLimt4G", Integer.valueOf(5242880)).intValue();
        }
        return QCircleConfigHelper.a("PhotoUpload", "GifUploadLimt2G", Integer.valueOf(819200)).intValue();
      }
      return QCircleConfigHelper.a("PhotoUpload", "GifUploadLimt3G", Integer.valueOf(2097152)).intValue();
    }
    return QCircleConfigHelper.a("PhotoUpload", "GifUploadLimtWifi", Integer.valueOf(5242880)).intValue();
  }
  
  public String getMaxSegmentSizeArray()
  {
    return null;
  }
  
  public String getMobileLogUrl()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "PhotoURL4", "mobilelog.upqzfile.com");
  }
  
  public String getMobileLogUrlV6()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "OptimumIP_MobileLogV6");
  }
  
  public String getNetworkUnavailableRetCodes()
  {
    return QCircleConfigHelper.a("QzoneUploadSetting", "UploadNetworkUnavailableRetCode", "113,101,100");
  }
  
  public String getOtherBakUrl()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "BackupIP_OTHERUP");
  }
  
  public String getOtherHostUrl()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "OtherURL_UP");
  }
  
  public String getOtherOptUrl()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "OptimumIP_OTHERUP");
  }
  
  public String getOtherOptUrlV6()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "OptimumIP_OTHERUP_V6");
  }
  
  public String getPhotoBakUrl()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "BackupIP_PICUP");
  }
  
  public String getPhotoHostUrl()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "PhotoURL_UP");
  }
  
  public String getPhotoOptUrl()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "OptimumIP_PICUP");
  }
  
  public String getPhotoOptUrlV6()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "OptimumIP_PICUPV6");
  }
  
  public float getPictureQuality(String paramString)
  {
    return 0.0F;
  }
  
  public String getQUA3()
  {
    return HostDataTransUtils.getQUA3();
  }
  
  public long getRecentRouteExpire()
  {
    return 604800000L;
  }
  
  public int getTimeoutRetryCount()
  {
    return a("TimeoutRetryCount", 3);
  }
  
  public IUploadConfig.UploadImageSize getUploadImageSize(IUploadConfig.UploadImageSize paramUploadImageSize, int paramInt, AbstractUploadTask paramAbstractUploadTask)
  {
    if (((paramAbstractUploadTask instanceof UpsImageUploadTask)) && (((UpsImageUploadTask)paramAbstractUploadTask).dataType == 2)) {
      return QCircleImageSizeStrategy.a();
    }
    if ((paramAbstractUploadTask instanceof PhotoWallUploadTask)) {
      return QCircleImageSizeStrategy.a(new ImageUtil.Size(paramUploadImageSize.width, paramUploadImageSize.height), 80);
    }
    if ((paramAbstractUploadTask instanceof UppUploadTask))
    {
      paramInt = QCircleImageSizeStrategy.a(2, false);
      return new IUploadConfig.UploadImageSize(paramUploadImageSize.width, paramUploadImageSize.height, paramInt);
    }
    paramAbstractUploadTask = paramAbstractUploadTask.getUploadTaskType();
    int i;
    if ((paramAbstractUploadTask != null) && (paramAbstractUploadTask.uploadType == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool;
    if (i != 0) {
      bool = a(paramInt);
    } else {
      bool = false;
    }
    paramAbstractUploadTask = QCircleImageSizeStrategy.a(new ImageUtil.Size(paramUploadImageSize.width, paramUploadImageSize.height), paramInt, bool);
    if (paramAbstractUploadTask == null) {
      return new IUploadConfig.UploadImageSize(0, 0, 0);
    }
    if (paramInt == 3) {
      return new IUploadConfig.UploadImageSize(paramUploadImageSize.width, paramUploadImageSize.height, 100);
    }
    return paramAbstractUploadTask;
  }
  
  public String getUploadPort()
  {
    return a("UploadPort", "80,443,8080,14000");
  }
  
  public String getVideoBakUrl()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "BackupIP_VIDEOUP");
  }
  
  public String getVideoHostUrl()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "VideoURL_UP");
  }
  
  public String getVideoOptUrl()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "OptimumIP_VIDEOUP");
  }
  
  public String getVideoOptUrlV6()
  {
    return QCircleConfigHelper.a("PhotoSvrList", "OptimumIP_VIDEOUPV6");
  }
  
  public int getWifiOperator()
  {
    return QCircleConfigHelper.a("ExtraConfig", "WifiCarrierType", Integer.valueOf(0)).intValue();
  }
  
  public long getWtAppId()
  {
    return 0L;
  }
  
  public boolean isPictureNeedToCompress(String paramString)
  {
    if (!HostFileUtils.fileExistsAndNotEmpty(paramString)) {
      return true;
    }
    int i = 200;
    int j = 300;
    String[] arrayOfString = QCircleConfigHelper.a("PhotoUpload", "CompressSizeLimit", "100,200").split(",");
    if (arrayOfString.length == 2)
    {
      i = Integer.parseInt(arrayOfString[0]);
      j = Integer.parseInt(arrayOfString[1]);
    }
    QCircleConfigHelper.a("PhotoUpload", "CompressQualityLimit", Integer.valueOf(70)).intValue();
    long l = new File(paramString).length();
    if (l <= i * 1024L) {
      return false;
    }
    if (l <= j * 1024L) {
      try
      {
        boolean bool = HostFileUtils.isFileJPEG(paramString);
        if (bool) {
          return false;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    return true;
  }
  
  public boolean isReleaseMode()
  {
    return QCircleHostConstants._AppSetting.isPublicVersion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.uploader.QcircleUploadConfig
 * JD-Core Version:    0.7.0.1
 */