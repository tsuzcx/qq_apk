package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.CallSuper;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class ModulePkgInfo
  implements Parcelable, e, Cloneable
{
  public static final Parcelable.Creator<ModulePkgInfo> CREATOR = new ModulePkgInfo.1();
  public static final String GAME_PLUGIN_SCRIPT = "/plugin.js";
  public static final String MAIN_MODULE_NAME = "__APP__";
  public static final String MODULE_WITHOUT_MULTI_PLUGIN_CODE = "__WITHOUT_MULTI_PLUGINCODE__";
  public static final String MODULE_WITHOUT_PLUGIN_CODE = "__WITHOUT_PLUGINCODE__";
  public static final String PLUGINCODE_ORIGIN_PREFIX = "__plugin__/";
  public static final String PLUGINCODE_PREFIX = "/__plugin__/";
  public static final String PLUGIN_CODE = "__PLUGINCODE__";
  public String[] aliases;
  public boolean independent;
  public String md5;
  public String name;
  public volatile String pkgPath;
  public int pkgVersion;
  
  public ModulePkgInfo() {}
  
  private ModulePkgInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public void assignFrom(ModulePkgInfo paramModulePkgInfo)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramModulePkgInfo.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    readFromParcel(localParcel);
    localParcel.recycle();
  }
  
  public String checksumMd5()
  {
    return this.md5;
  }
  
  public ModulePkgInfo clone()
  {
    ModulePkgInfo localModulePkgInfo = new ModulePkgInfo();
    localModulePkgInfo.assignFrom(this);
    return localModulePkgInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getPkgSize()
  {
    if (k.h(this.pkgPath))
    {
      i locali = new i(this.pkgPath);
      if ((locali.o()) && (locali.h())) {
        return locali.q();
      }
      return 0L;
    }
    throw new FileNotFoundException();
  }
  
  public boolean isAssignable(ModulePkgInfo paramModulePkgInfo)
  {
    return this.name.equals(paramModulePkgInfo.name);
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
    return this.pkgVersion;
  }
  
  @CallSuper
  public void readFromParcel(Parcel paramParcel)
  {
    this.pkgPath = paramParcel.readString();
    this.name = paramParcel.readString();
    this.md5 = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.independent = bool;
    this.aliases = paramParcel.createStringArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ModulePkgInfo{pkgPath='");
    localStringBuilder.append(this.pkgPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", independent=");
    localStringBuilder.append(this.independent);
    localStringBuilder.append(", aliases=");
    localStringBuilder.append(Arrays.toString(this.aliases));
    localStringBuilder.append(", pkgVersion=");
    localStringBuilder.append(this.pkgVersion);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  @CallSuper
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.pkgPath);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.md5);
    paramParcel.writeByte((byte)this.independent);
    paramParcel.writeStringArray(this.aliases);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo
 * JD-Core Version:    0.7.0.1
 */