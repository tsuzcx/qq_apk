package com.tencent.ad.tangram.device;

import android.text.TextUtils;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForUUID;

public final class r$a
{
  private gdt_settings.Settings.SettingsForUUID settings;
  
  public r$a(gdt_settings.Settings.SettingsForUUID paramSettingsForUUID)
  {
    this.settings = paramSettingsForUUID;
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
    return (this.settings != null) && (this.settings.version > 0) && (!TextUtils.isEmpty(this.settings.salt)) && (this.settings.maxLength > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.r.a
 * JD-Core Version:    0.7.0.1
 */