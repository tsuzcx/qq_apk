package com.tencent.ad.tangram.device;

import android.text.TextUtils;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForDeviceInfo.UUID;

public final class r$a
{
  private gdt_settings.Settings.SettingsForDeviceInfo.UUID settings;
  
  public r$a(gdt_settings.Settings.SettingsForDeviceInfo.UUID paramUUID)
  {
    this.settings = paramUUID;
  }
  
  public String getValue()
  {
    if (isValid()) {
      return this.settings.salt;
    }
    return null;
  }
  
  public int getVersion()
  {
    if (isValid()) {
      return this.settings.version;
    }
    return -2147483648;
  }
  
  public boolean isValid()
  {
    gdt_settings.Settings.SettingsForDeviceInfo.UUID localUUID = this.settings;
    return (localUUID != null) && (localUUID.version > 0) && (!TextUtils.isEmpty(this.settings.salt)) && (this.settings.maxLength > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.r.a
 * JD-Core Version:    0.7.0.1
 */