package com.tencent.av.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.HashMap;
import java.util.Map;

class TraeHelper$SoundOutputRes
{
  private String[] a;
  private Map<String, TraeHelper.SoundOutputRes.IconAndName> b = new HashMap();
  
  public TraeHelper$SoundOutputRes(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if ("DEVICE_BLUETOOTH_HEADSET".equals(str)) {
          this.b.put(str, new TraeHelper.SoundOutputRes.IconAndName(this, 2130843286, HardCodeUtil.a(2131912339), str));
        } else if ("DEVICE_EARPHONE".equals(str)) {
          this.b.put(str, new TraeHelper.SoundOutputRes.IconAndName(this, 2130843288, HardCodeUtil.a(2131912340), str));
        } else if ("DEVICE_SPEAKERPHONE".equals(str)) {
          this.b.put(str, new TraeHelper.SoundOutputRes.IconAndName(this, 2130843291, HardCodeUtil.a(2131912343), str));
        } else if ("DEVICE_WIRED_HEADSET".equals(str)) {
          this.b.put(str, new TraeHelper.SoundOutputRes.IconAndName(this, 2130843293, HardCodeUtil.a(2131912341), str));
        }
        i += 1;
      }
    }
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  public TraeHelper.SoundOutputRes.IconAndName a(String paramString)
  {
    return (TraeHelper.SoundOutputRes.IconAndName)this.b.get(paramString);
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      TraeHelper.SoundOutputRes.IconAndName localIconAndName = (TraeHelper.SoundOutputRes.IconAndName)this.b.get("DEVICE_BLUETOOTH_HEADSET");
      if (localIconAndName != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131912342));
        localStringBuilder.append(paramString);
        localStringBuilder.append("）");
        localIconAndName.c = localStringBuilder.toString();
      }
    }
  }
  
  public String[] b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.SoundOutputRes
 * JD-Core Version:    0.7.0.1
 */