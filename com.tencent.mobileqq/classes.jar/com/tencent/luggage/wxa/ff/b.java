package com.tencent.luggage.wxa.ff;

import android.util.SparseIntArray;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/report/AppBrandServiceTypeCache;", "", "()V", "TAG", "", "serviceTypeMap", "Landroid/util/SparseIntArray;", "addServiceTypeMap", "", "appId", "serviceType", "", "getServiceTypeMap", "default", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b a = new b();
  private static final SparseIntArray b = new SparseIntArray();
  
  @JvmStatic
  public static final void a(@Nullable String paramString, int paramInt)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addServiceTypeMap appId: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", serviceType: ");
      localStringBuilder.append(paramInt);
      o.e("MicroMsg.AppBrandServiceTypeCache", localStringBuilder.toString());
      b.put(paramString.hashCode(), paramInt);
    }
  }
  
  @JvmStatic
  @JvmOverloads
  public static final int b(@Nullable String paramString, int paramInt)
  {
    if (paramString != null)
    {
      paramInt = b.get(paramString.hashCode(), -1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getServiceTypeMap appId: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", ret ");
      localStringBuilder.append(paramInt);
      o.e("MicroMsg.AppBrandServiceTypeCache", localStringBuilder.toString());
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ff.b
 * JD-Core Version:    0.7.0.1
 */