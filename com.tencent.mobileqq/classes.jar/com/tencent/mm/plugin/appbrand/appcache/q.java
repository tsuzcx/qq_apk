package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.rt.i;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibFileReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/AbsReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "pkgFilePath", "", "pkgAppVersion", "", "pkgFileMd5", "(Ljava/lang/String;ILjava/lang/String;)V", "vfsFile", "Lcom/tencent/mm/vfs/VFSFile;", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "checksumMd5", "close", "", "describeContents", "finalize", "info", "init", "lastModified", "", "openRead", "Ljava/io/InputStream;", "fileName", "pkgPath", "pkgVersion", "toString", "writeToParcel", "dest", "flags", "Companion", "luggage-wechat-nano-sdk_release"}, k=1, mv={1, 1, 16})
public final class q
  extends a
  implements Parcelable, e
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<q> CREATOR = (Parcelable.Creator)new q.b();
  public static final q.a a = new q.a(null);
  private i b;
  private v c;
  private final String d;
  private final int e;
  private final String f;
  
  public q(@NotNull Parcel paramParcel)
  {
    this(str, paramParcel.readInt(), paramParcel.readString());
  }
  
  public q(@NotNull String paramString1, int paramInt, @Nullable String paramString2)
  {
    this.d = paramString1;
    this.e = paramInt;
    this.f = paramString2;
  }
  
  @Nullable
  public InputStream c(@Nullable String paramString)
  {
    v localv = this.c;
    if (localv == null) {
      Intrinsics.throwUninitializedPropertyAccessException("wxaPkg");
    }
    localv.e();
    localv = this.c;
    if (localv == null) {
      Intrinsics.throwUninitializedPropertyAccessException("wxaPkg");
    }
    return localv.c(paramString);
  }
  
  public void close()
  {
    try
    {
      if (((q)this).c != null)
      {
        v localv = this.c;
        if (localv == null) {
          Intrinsics.throwUninitializedPropertyAccessException("wxaPkg");
        }
        localv.close();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void d()
  {
    this.b = new i(this.d);
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("vfsFile");
    }
    this.c = new v((i)localObject);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("wxaPkg");
    }
    ((v)localObject).e();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public e f()
  {
    return (e)this;
  }
  
  protected final void finalize()
  {
    close();
  }
  
  public long lastModified()
  {
    i locali = this.b;
    if (locali == null) {
      Intrinsics.throwUninitializedPropertyAccessException("vfsFile");
    }
    return locali.p();
  }
  
  @NotNull
  public String pkgPath()
  {
    return this.d;
  }
  
  public int pkgVersion()
  {
    return this.e;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WxaCommLibFileReader(path:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", version:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "dest");
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.q
 * JD-Core Version:    0.7.0.1
 */