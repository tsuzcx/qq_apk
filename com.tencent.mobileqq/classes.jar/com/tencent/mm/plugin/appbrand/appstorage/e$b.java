package com.tencent.mm.plugin.appbrand.appstorage;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "", "data", "", "type", "size", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getSize", "getType", "isEmpty", "", "data-storage_release"}, k=1, mv={1, 1, 16})
public final class e$b
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  
  public e$b(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public final boolean a()
  {
    int i;
    if (((CharSequence)this.a).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (((CharSequence)this.b).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (((CharSequence)this.c).length() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  @NotNull
  public final String b()
  {
    return this.a;
  }
  
  @NotNull
  public final String c()
  {
    return this.b;
  }
  
  @NotNull
  public final String d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.e.b
 * JD-Core Version:    0.7.0.1
 */