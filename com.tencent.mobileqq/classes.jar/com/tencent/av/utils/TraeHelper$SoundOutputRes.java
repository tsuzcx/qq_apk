package com.tencent.av.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.HashMap;
import java.util.Map;

class TraeHelper$SoundOutputRes
{
  private Map<String, TraeHelper.SoundOutputRes.IconAndName> jdField_a_of_type_JavaUtilMap = new HashMap();
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public TraeHelper$SoundOutputRes(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if ("DEVICE_BLUETOOTH_HEADSET".equals(str)) {
          this.jdField_a_of_type_JavaUtilMap.put(str, new TraeHelper.SoundOutputRes.IconAndName(this, 2130842342, HardCodeUtil.a(2131714838), str));
        } else if ("DEVICE_EARPHONE".equals(str)) {
          this.jdField_a_of_type_JavaUtilMap.put(str, new TraeHelper.SoundOutputRes.IconAndName(this, 2130842344, HardCodeUtil.a(2131714839), str));
        } else if ("DEVICE_SPEAKERPHONE".equals(str)) {
          this.jdField_a_of_type_JavaUtilMap.put(str, new TraeHelper.SoundOutputRes.IconAndName(this, 2130842347, HardCodeUtil.a(2131714842), str));
        } else if ("DEVICE_WIRED_HEADSET".equals(str)) {
          this.jdField_a_of_type_JavaUtilMap.put(str, new TraeHelper.SoundOutputRes.IconAndName(this, 2130842349, HardCodeUtil.a(2131714840), str));
        }
        i += 1;
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
      TraeHelper.SoundOutputRes.IconAndName localIconAndName = (TraeHelper.SoundOutputRes.IconAndName)this.jdField_a_of_type_JavaUtilMap.get("DEVICE_BLUETOOTH_HEADSET");
      if (localIconAndName != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131714841));
        localStringBuilder.append(paramString);
        localStringBuilder.append("）");
        localIconAndName.b = localStringBuilder.toString();
      }
    }
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.SoundOutputRes
 * JD-Core Version:    0.7.0.1
 */