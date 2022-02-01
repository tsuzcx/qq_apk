package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.luggage.wxa.rt.k;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgIntegrityChecker;", "", "()V", "TAG", "", "checkPkg", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgIntegrityChecker$ErrCode;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "appId", "versionType", "", "appVersion", "getFileMD5", "path", "ErrCode", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class z
{
  public static final z a = new z();
  
  @NotNull
  public final Pair<z.a, af> a(@Nullable String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = new String[4];
    localObject1[0] = "pkgPath";
    int i = 1;
    localObject1[1] = "versionMd5";
    localObject1[2] = "NewMd5";
    localObject1[3] = "version";
    if ((d.a.a(paramInt1)) && (paramInt2 > 0)) {
      paramString = ac.a().a(paramString, paramInt2, paramInt1, (String[])Arrays.copyOf((Object[])localObject1, localObject1.length));
    } else {
      paramString = ac.a().a(paramString, paramInt1, (String[])Arrays.copyOf((Object[])localObject1, localObject1.length));
    }
    if (paramString == null)
    {
      paramString = Pair.create(z.a.b, null);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "Pair.create(ErrCode.APP_MANIFEST_NULL, null)");
      return paramString;
    }
    localObject1 = (CharSequence)paramString.f;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    if ((paramInt1 == 0) && (k.h(paramString.f)))
    {
      localObject1 = a(paramString.f);
      Object localObject2 = new String[2];
      localObject2[0] = paramString.d;
      localObject2[1] = paramString.e;
      int j = localObject2.length;
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        Object localObject3 = localObject2[paramInt1];
        CharSequence localCharSequence = (CharSequence)localObject3;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          paramInt2 = 0;
        } else {
          paramInt2 = 1;
        }
        if ((paramInt2 == 0) && (Intrinsics.areEqual(localObject3, localObject1)))
        {
          paramInt1 = i;
          break label271;
        }
        paramInt1 += 1;
      }
      paramInt1 = 0;
      label271:
      if (paramInt1 != 0)
      {
        localObject2 = new af();
        ((af)localObject2).pkgVersion = paramString.c;
        ((af)localObject2).c = paramString.g;
        ((af)localObject2).pkgPath = paramString.f;
        ((af)localObject2).d = false;
        ((af)localObject2).b = paramString.h;
        ((af)localObject2).md5 = ((String)localObject1);
        paramString = Pair.create(z.a.a, localObject2);
      }
      else
      {
        paramString = Pair.create(z.a.e, (af)null);
      }
      Intrinsics.checkExpressionValueIsNotNull(paramString, "if (checksumOK) {\n      …gInfo?)\n                }");
      return paramString;
    }
    paramString = Pair.create(z.a.e, null);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "Pair.create(ErrCode.APP_BROKEN, null)");
    return paramString;
  }
  
  @Nullable
  public final String a(@Nullable String paramString)
  {
    return af.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.z
 * JD-Core Version:    0.7.0.1
 */