package com.tencent.biz.qqstory.model;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.JsonORM.Column;

public class StoryEditVideoConfig$Device
{
  public static Device a = new Device();
  public static Device b = new Device();
  @JsonORM.Column(a="manufacturer")
  public String c;
  @JsonORM.Column(a="model")
  public String d;
  
  static
  {
    b.c = Build.MANUFACTURER;
    b.d = Build.MODEL;
    Device localDevice = a;
    localDevice.c = "all";
    localDevice.d = "all";
  }
  
  public boolean a()
  {
    boolean bool2 = a.equals(this);
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (!b.equals(this))
    {
      if ((TextUtils.isEmpty(this.c)) && (TextUtils.equals(this.d, b.d))) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (Device)paramObject;
      String str = this.c;
      if (str != null)
      {
        if (!str.equals(paramObject.c)) {
          return false;
        }
      }
      else if (paramObject.c != null) {
        return false;
      }
      str = this.d;
      if (str != null) {
        return str.equals(paramObject.d);
      }
      return paramObject.d == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.c;
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.d;
    if (str != null) {
      j = str.hashCode();
    }
    return i * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryEditVideoConfig.Device
 * JD-Core Version:    0.7.0.1
 */