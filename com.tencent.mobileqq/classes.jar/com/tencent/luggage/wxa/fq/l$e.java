package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.hg.f;
import com.tencent.xweb.skia_canvas.IXWebLibraryLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/WxaDynamicPkgMgr$initLoadLibrary$6", "Lcom/tencent/xweb/skia_canvas/IXWebLibraryLoader;", "afterLoad", "", "beforeLoad", "load", "libName", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class l$e
  implements IXWebLibraryLoader
{
  public boolean afterLoad()
  {
    return true;
  }
  
  public boolean beforeLoad()
  {
    return true;
  }
  
  public boolean load(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "libName");
    f.a(paramString, l.a.getClass().getClassLoader());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.l.e
 * JD-Core Version:    0.7.0.1
 */