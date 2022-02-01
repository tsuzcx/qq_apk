package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "filename", "", "accept"}, k=3, mv={1, 1, 16})
final class t$a
  implements n
{
  t$a(String paramString, List paramList) {}
  
  public final boolean a(i parami, String paramString)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramString, "filename");
    parami = (CharSequence)paramString;
    CharSequence localCharSequence = (CharSequence)"_";
    boolean bool2 = false;
    if (!StringsKt.contains$default(parami, localCharSequence, false, 2, null)) {
      return false;
    }
    parami = paramString.substring(StringsKt.lastIndexOf$default(parami, "_", 0, false, 6, null));
    Intrinsics.checkExpressionValueIsNotNull(parami, "(this as java.lang.String).substring(startIndex)");
    parami = StringsKt.replace$default(StringsKt.replace$default(parami, "_", "", false, 4, null), this.a, "", false, 4, null);
    boolean bool1 = bool2;
    if (StringsKt.endsWith$default(paramString, this.a, false, 2, null))
    {
      bool1 = bool2;
      if (this.b.contains(parami)) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.t.a
 * JD-Core Version:    0.7.0.1
 */