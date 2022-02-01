package com.tencent.luggage.wxa.fo;

import android.content.Context;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/storage/CriticalAuthorityResolver;", "", "()V", "resolveAuthority", "", "data-storage_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b a = new b();
  
  @JvmStatic
  @NotNull
  public static final String a()
  {
    Context localContext = r.a();
    if (localContext != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localContext.getPackageName());
      localStringBuilder.append(".wxa_critical_content");
      return localStringBuilder.toString();
    }
    throw ((Throwable)new IllegalStateException("invoke before application attach context"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fo.b
 * JD-Core Version:    0.7.0.1
 */