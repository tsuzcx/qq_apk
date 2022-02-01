package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.rt.k;
import java.util.LinkedList;
import java.util.List;

public class WxaPluginPkgInfo
  implements Parcelable, e
{
  public static final Parcelable.Creator<WxaPluginPkgInfo> CREATOR = new WxaPluginPkgInfo.1();
  public static final String PREFIX_EXTENDED = "__extended__/";
  public static final String PREFIX_NORMAL = "__plugin__/";
  public List<Integer> contexts;
  public String md5;
  public volatile String pkgPath;
  public String prefixPath;
  public String provider;
  public String stringVersion;
  public int version;
  
  public WxaPluginPkgInfo() {}
  
  private WxaPluginPkgInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public void assignFrom(WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramWxaPluginPkgInfo.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    readFromParcel(localParcel);
    localParcel.recycle();
  }
  
  public String checksumMd5()
  {
    return this.md5;
  }
  
  public WxaPluginPkgInfo clone()
  {
    WxaPluginPkgInfo localWxaPluginPkgInfo = new WxaPluginPkgInfo();
    localWxaPluginPkgInfo.assignFrom(this);
    return localWxaPluginPkgInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isAssignable(WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    return this.provider.equals(paramWxaPluginPkgInfo.provider);
  }
  
  public long lastModified()
  {
    if (k.h(this.pkgPath)) {
      return k.d(this.pkgPath);
    }
    return 0L;
  }
  
  public String pkgPath()
  {
    return this.pkgPath;
  }
  
  public int pkgVersion()
  {
    return this.version;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.pkgPath = paramParcel.readString();
    this.provider = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.md5 = paramParcel.readString();
    this.prefixPath = paramParcel.readString();
    this.stringVersion = paramParcel.readString();
    if (this.contexts == null) {
      this.contexts = new LinkedList();
    }
    paramParcel.readList(this.contexts, Integer.class.getClassLoader());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeString(this.provider);
    paramParcel.writeInt(this.version);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.prefixPath);
    paramParcel.writeString(this.stringVersion);
    paramParcel.writeList(this.contexts);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo
 * JD-Core Version:    0.7.0.1
 */