package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.hg.f;
import com.tencent.luggage.wxa.ql.c;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/WxaDynamicPkgMgr$initLoadLibrary$7", "Lcom/tencent/mm/plugin/music/player/base/IMusicLoadLibrary;", "checkLoaded", "", "lib_name", "", "findLibPath", "load", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class l$f
  implements c
{
  public boolean a(@Nullable String paramString)
  {
    return f.a(paramString);
  }
  
  @NotNull
  public String b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "lib_name");
    o.d(l.c(l.a), "findLibPath %s", new Object[] { paramString });
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1714602760: 
      if (paramString.equals("qm_native_decoder_flac")) {
        l.c(l.a, "qm_native_decoder_flac");
      }
      break;
    case -221778096: 
      if (paramString.equals("qm_native_decoder_mp3")) {
        l.c(l.a, "qm_native_decoder_mp3");
      }
      break;
    case -221789578: 
      if (paramString.equals("qm_native_decoder_ape")) {
        l.c(l.a, "qm_native_decoder_ape");
      }
      break;
    case -1539357211: 
      if (paramString.equals("qm_native_decoder_ffmpeg")) {
        l.c(l.a, "qm_native_decoder_ffmpeg");
      }
      break;
    }
    Object localObject = paramString;
    if (!StringsKt.startsWith$default(paramString, "lib", false, 2, null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lib");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = (String)localObject;
    if (!StringsKt.endsWith$default((String)localObject, ".so", false, 2, null))
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append(".so");
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  public boolean c(@Nullable String paramString)
  {
    f.a(paramString, l.a.getClass().getClassLoader());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.l.f
 * JD-Core Version:    0.7.0.1
 */