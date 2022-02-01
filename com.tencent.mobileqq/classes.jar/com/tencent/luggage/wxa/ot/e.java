package com.tencent.luggage.wxa.ot;

import android.util.SparseIntArray;
import com.tencent.luggage.wxa.cx.u;
import com.tencent.luggage.wxa.qw.dq;
import com.tencent.luggage.wxa.qw.fg;
import com.tencent.luggage.wxa.qy.a;
import com.tencent.luggage.wxa.qy.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/profile/KVReportLogIdRemapping;", "", "()V", "TAG", "", "UNDEFINED", "", "mapping", "Landroid/util/SparseIntArray;", "getRemappedLogId", "wxLogId", "onGetUpdatedRemappingInfo", "", "info", "Lcom/tencent/mm/protocal/protobuf/GlobalAttrInfo;", "component1", "Lcom/tencent/mm/protocal/protobuf/LogIdItem;", "component2", "set", "key", "value", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class e
{
  public static final e a;
  private static final SparseIntArray b;
  
  static
  {
    e locale = new e();
    a = locale;
    b = new SparseIntArray();
    locale.a(u.b.c());
    a.a.a((c)new e.1());
  }
  
  private final int a(@NotNull fg paramfg)
  {
    Intrinsics.checkParameterIsNotNull(paramfg, "$this$component1");
    return paramfg.a;
  }
  
  private final void a(@NotNull SparseIntArray paramSparseIntArray, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseIntArray, "$this$set");
    paramSparseIntArray.put(paramInt1, paramInt2);
  }
  
  private final void a(dq paramdq)
  {
    if (paramdq != null)
    {
      ??? = paramdq.a;
      int i;
      if (??? != null) {
        i = ((LinkedList)???).size();
      } else {
        i = 0;
      }
      if (i > 0) {
        synchronized (b)
        {
          b.clear();
          Object localObject2 = paramdq.a;
          int j;
          if (localObject2 != null)
          {
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              fg localfg = (fg)((Iterator)localObject2).next();
              i = a.a(localfg);
              j = a.b(localfg);
              a.a(b, i, j);
            }
            localObject2 = Unit.INSTANCE;
          }
          o.d("Luggage.KVReportLogIdRemapping", ">>>>>> onGetUpdatedRemappingInfo <<<<<<");
          paramdq = paramdq.a;
          Intrinsics.checkExpressionValueIsNotNull(paramdq, "info.log_id_list");
          paramdq = ((Iterable)paramdq).iterator();
          while (paramdq.hasNext())
          {
            ??? = (fg)paramdq.next();
            i = a.a((fg)???);
            j = a.b((fg)???);
            ??? = new StringBuilder();
            ((StringBuilder)???).append(">> wx_log_id:");
            ((StringBuilder)???).append(i);
            ((StringBuilder)???).append(" -> ilink_log_id:");
            ((StringBuilder)???).append(j);
            o.d("Luggage.KVReportLogIdRemapping", ((StringBuilder)???).toString());
          }
          o.d("Luggage.KVReportLogIdRemapping", ">>>>>> onGetUpdatedRemappingInfo <<<<<<");
          return;
        }
      }
    }
  }
  
  private final int b(@NotNull fg paramfg)
  {
    Intrinsics.checkParameterIsNotNull(paramfg, "$this$component2");
    return paramfg.b;
  }
  
  public final int a(int paramInt)
  {
    synchronized (b)
    {
      paramInt = b.get(paramInt, 0);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ot.e
 * JD-Core Version:    0.7.0.1
 */