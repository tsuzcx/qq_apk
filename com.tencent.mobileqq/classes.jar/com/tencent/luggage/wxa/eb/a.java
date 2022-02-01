package com.tencent.luggage.wxa.eb;

import android.os.Parcelable;
import com.tencent.luggage.wxa.ed.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "RUNTIME", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "Landroid/os/Parcelable;", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "runInLuggageProcess", "", "runtime", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public abstract class a<RUNTIME extends d>
  implements Parcelable
{
  @NotNull
  private final String a;
  
  public a(@NotNull String paramString)
  {
    this.a = paramString;
  }
  
  @NotNull
  public String a()
  {
    return this.a;
  }
  
  public abstract void a(@NotNull RUNTIME paramRUNTIME);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eb.a
 * JD-Core Version:    0.7.0.1
 */