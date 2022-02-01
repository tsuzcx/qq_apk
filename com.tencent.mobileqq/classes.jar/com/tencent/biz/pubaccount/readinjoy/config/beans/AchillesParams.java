package com.tencent.biz.pubaccount.readinjoy.config.beans;

import com.tencent.aladdin.config.parse.AladdinConfigBean;

public class AchillesParams
  implements AladdinConfigBean
{
  private String appId = "";
  private int baseDelayMs = 10000;
  private int debounceIntervalMinutes = 60;
  private int downloadDelayMs;
  private String downloadUrl = "";
  private boolean enable = false;
  private boolean installIfJump;
  private int maxDownloadCount = 1;
  private String md5 = "";
  private boolean mustWifiDownload;
  private String packageName = "";
  private String pushTitle = "";
  private String sceneId;
  private boolean useFragmentDownload;
  private int versionCode = 0;
  private String versionName = "";
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return bool1;
                                    bool1 = bool2;
                                  } while (paramObject == null);
                                  bool1 = bool2;
                                } while (getClass() != paramObject.getClass());
                                paramObject = (AchillesParams)paramObject;
                                bool1 = bool2;
                              } while (this.enable != paramObject.enable);
                              bool1 = bool2;
                            } while (this.versionCode != paramObject.versionCode);
                            bool1 = bool2;
                          } while (this.baseDelayMs != paramObject.baseDelayMs);
                          bool1 = bool2;
                        } while (this.maxDownloadCount != paramObject.maxDownloadCount);
                        bool1 = bool2;
                      } while (this.debounceIntervalMinutes != paramObject.debounceIntervalMinutes);
                      bool1 = bool2;
                    } while (this.downloadDelayMs != paramObject.downloadDelayMs);
                    bool1 = bool2;
                  } while (this.useFragmentDownload != paramObject.useFragmentDownload);
                  bool1 = bool2;
                } while (this.mustWifiDownload != paramObject.mustWifiDownload);
                bool1 = bool2;
              } while (this.installIfJump != paramObject.installIfJump);
              bool1 = bool2;
            } while (!this.appId.equals(paramObject.appId));
            bool1 = bool2;
          } while (!this.versionName.equals(paramObject.versionName));
          bool1 = bool2;
        } while (!this.packageName.equals(paramObject.packageName));
        bool1 = bool2;
      } while (!this.pushTitle.equals(paramObject.pushTitle));
      bool1 = bool2;
    } while (!this.md5.equals(paramObject.md5));
    return this.downloadUrl.equals(paramObject.downloadUrl);
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public int getBaseDelayMs()
  {
    return this.baseDelayMs;
  }
  
  public int getDebounceIntervalMinutes()
  {
    return this.debounceIntervalMinutes;
  }
  
  public int getDownloadDelayMs()
  {
    return this.downloadDelayMs;
  }
  
  public String getDownloadUrl()
  {
    return this.downloadUrl;
  }
  
  public int getMaxDownloadCount()
  {
    return this.maxDownloadCount;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public String getPushTitle()
  {
    return this.pushTitle;
  }
  
  public String getSceneId()
  {
    return this.sceneId;
  }
  
  public int getVersionCode()
  {
    return this.versionCode;
  }
  
  public String getVersionName()
  {
    return this.versionName;
  }
  
  public int hashCode()
  {
    int m = 1;
    int i;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int j;
    label105:
    int k;
    if (this.enable)
    {
      i = 1;
      n = this.appId.hashCode();
      i1 = this.versionName.hashCode();
      i2 = this.versionCode;
      i3 = this.packageName.hashCode();
      i4 = this.pushTitle.hashCode();
      i5 = this.baseDelayMs;
      i6 = this.maxDownloadCount;
      i7 = this.debounceIntervalMinutes;
      i8 = this.md5.hashCode();
      i9 = this.downloadUrl.hashCode();
      i10 = this.downloadDelayMs;
      if (!this.useFragmentDownload) {
        break label210;
      }
      j = 1;
      if (!this.mustWifiDownload) {
        break label215;
      }
      k = 1;
      label114:
      if (!this.installIfJump) {
        break label220;
      }
    }
    for (;;)
    {
      return (k + (j + (((((((((((i * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31) * 31) * 31 + m;
      i = 0;
      break;
      label210:
      j = 0;
      break label105;
      label215:
      k = 0;
      break label114;
      label220:
      m = 0;
    }
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public boolean isInstallIfJump()
  {
    return this.installIfJump;
  }
  
  public boolean isMustWifiDownload()
  {
    return this.mustWifiDownload;
  }
  
  public boolean isUseFragmentDownload()
  {
    return this.useFragmentDownload;
  }
  
  public String toString()
  {
    return "AchillesParams{enable=" + this.enable + ", appId='" + this.appId + '\'' + ", versionName='" + this.versionName + '\'' + ", versionCode=" + this.versionCode + ", packageName='" + this.packageName + '\'' + ", pushTitle='" + this.pushTitle + '\'' + ", baseDelayMs=" + this.baseDelayMs + ", maxDownloadCount=" + this.maxDownloadCount + ", debounceIntervalMinutes=" + this.debounceIntervalMinutes + ", md5='" + this.md5 + '\'' + ", downloadUrl='" + this.downloadUrl + '\'' + ", downloadDelayMs=" + this.downloadDelayMs + ", useFragmentDownload=" + this.useFragmentDownload + ", mustWifiDownload=" + this.mustWifiDownload + ", installIfJump=" + this.installIfJump + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams
 * JD-Core Version:    0.7.0.1
 */