package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jo.c;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "", "mrDevice", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "isConnectSuccess", "", "()Z", "setConnectSuccess", "(Z)V", "isConnecting", "setConnecting", "isSelected", "setSelected", "getMrDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "equals", "other", "hashCode", "", "toString", "", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class e
{
  private boolean a;
  private boolean b;
  private boolean c;
  @NotNull
  private final c d;
  
  public e(@NotNull c paramc)
  {
    this.d = paramc;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.a;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final boolean b()
  {
    return this.b;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final boolean c()
  {
    return this.c;
  }
  
  @NotNull
  public final c d()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((e)this == paramObject) {
      return true;
    }
    Class localClass2 = getClass();
    Class localClass1;
    if (paramObject != null) {
      localClass1 = paramObject.getClass();
    } else {
      localClass1 = null;
    }
    if ((Intrinsics.areEqual(localClass2, localClass1) ^ true)) {
      return false;
    }
    if (paramObject != null)
    {
      paramObject = (e)paramObject;
      return !(Intrinsics.areEqual(this.d, paramObject.d) ^ true);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.xwebplugin.video.cast.MRDeviceWithStatus");
  }
  
  public int hashCode()
  {
    return this.d.hashCode();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MRDeviceWithStatus(mrDevice=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", isSelected=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", isConnectSuccess=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isConnecting=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.e
 * JD-Core Version:    0.7.0.1
 */