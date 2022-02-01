package com.tencent.luggage.wxa.ot;

import com.tencent.luggage.wxa.dj.a;
import com.tencent.luggage.wxa.dj.a.a;
import com.tencent.luggage.wxa.dj.h.c;
import com.tencent.luggage.wxa.qz.o;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/profile/KVReporter;", "Lcom/tencent/mm/plugin/appbrand/profile/IKeyValueProfiler;", "()V", "TAG", "", "doKvReport", "", "logID", "", "reportVal", "isReportNow", "", "isImportant", "flushSync", "kvStat", "vals", "", "", "(I[Ljava/lang/Object;)V", "val", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class g
  implements d
{
  public static final g a = new g();
  
  private final void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = e.a.a(paramInt);
    if (i == 0)
    {
      paramString = new StringBuilder();
      paramString.append("doKvReport wx_log_id:");
      paramString.append(paramInt);
      paramString.append(" ignore undefined ilink_log_id");
      o.c("Luggage.KVReporter", paramString.toString());
      return;
    }
    a locala = a.a.b.a();
    if (paramString == null) {
      paramString = "";
    }
    Charset localCharset = Charsets.UTF_8;
    if (paramString != null)
    {
      paramString = paramString.getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
      h.c.a(locala, i, paramString, paramBoolean1, 0, false, 0, 32, null);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public void a()
  {
    a.a.b.a().a();
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kvStat id:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" value:");
    localStringBuilder.append(paramString);
    o.e("Luggage.KVReporter", localStringBuilder.toString());
    a(this, paramInt, paramString, false, false, 12, null);
  }
  
  public void a(int paramInt, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "vals");
    paramVarArgs = f.a(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kvStat id:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" value:");
    localStringBuilder.append(paramVarArgs);
    o.e("Luggage.KVReporter", localStringBuilder.toString());
    a(this, paramInt, paramVarArgs, false, false, 12, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ot.g
 * JD-Core Version:    0.7.0.1
 */