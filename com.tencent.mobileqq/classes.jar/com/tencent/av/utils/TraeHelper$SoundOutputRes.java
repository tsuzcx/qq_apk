package com.tencent.av.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class TraeHelper$SoundOutputRes
{
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public TraeHelper$SoundOutputRes(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str = paramArrayOfString[i];
        if ("DEVICE_BLUETOOTHHEADSET".equals(str)) {
          this.jdField_a_of_type_JavaUtilMap.put(str, new TraeHelper.SoundOutputRes.IconAndName(this, 2130840344, "蓝牙设备", str));
        }
        for (;;)
        {
          i += 1;
          break;
          if ("DEVICE_EARPHONE".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new TraeHelper.SoundOutputRes.IconAndName(this, 2130840346, "听筒", str));
          } else if ("DEVICE_SPEAKERPHONE".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new TraeHelper.SoundOutputRes.IconAndName(this, 2130840349, "扬声器", str));
          } else if ("DEVICE_WIREDHEADSET".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new TraeHelper.SoundOutputRes.IconAndName(this, 2130840351, "耳机", str));
          }
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilMap.size();
  }
  
  public TraeHelper.SoundOutputRes.IconAndName a(String paramString)
  {
    return (TraeHelper.SoundOutputRes.IconAndName)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      TraeHelper.SoundOutputRes.IconAndName localIconAndName = (TraeHelper.SoundOutputRes.IconAndName)this.jdField_a_of_type_JavaUtilMap.get("DEVICE_BLUETOOTHHEADSET");
      if (localIconAndName != null) {
        localIconAndName.b = ("蓝牙设备（" + paramString + "）");
      }
    }
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.SoundOutputRes
 * JD-Core Version:    0.7.0.1
 */