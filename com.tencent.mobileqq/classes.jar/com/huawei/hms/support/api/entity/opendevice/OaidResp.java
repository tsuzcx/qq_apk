package com.huawei.hms.support.api.entity.opendevice;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class OaidResp
  extends AbstractMessageEntity
{
  @Packed
  public String id;
  @Packed
  public boolean isTrackLimited;
  @Packed
  public PendingIntent settingIntent;
  
  public String getId()
  {
    return this.id;
  }
  
  public PendingIntent getSettingIntent()
  {
    return this.settingIntent;
  }
  
  public boolean isTrackLimited()
  {
    return this.isTrackLimited;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setSettingIntent(PendingIntent paramPendingIntent)
  {
    this.settingIntent = paramPendingIntent;
  }
  
  public void setTrackLimited(boolean paramBoolean)
  {
    this.isTrackLimited = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.opendevice.OaidResp
 * JD-Core Version:    0.7.0.1
 */