package com.tencent.biz.pubaccount.readinjoy.magic.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Locale;
import oog;

public final class Status
  extends PFile
{
  public static final Parcelable.Creator<Status> CREATOR = new oog();
  
  private Status(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  private Status(String paramString)
  {
    super(paramString);
  }
  
  public static Status get(int paramInt)
  {
    return new Status(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public int getGid()
  {
    try
    {
      int i = Integer.parseInt(getValue("Gid").split("\\s+")[0]);
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public int getUid()
  {
    try
    {
      int i = Integer.parseInt(getValue("Uid").split("\\s+")[0]);
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public String getValue(String paramString)
  {
    String[] arrayOfString = this.content.split("\n");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (str.startsWith(paramString + ":")) {
        return str.split(paramString + ":")[1].trim();
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.models.Status
 * JD-Core Version:    0.7.0.1
 */