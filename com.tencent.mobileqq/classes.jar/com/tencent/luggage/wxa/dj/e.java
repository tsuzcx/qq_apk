package com.tencent.luggage.wxa.dj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/reporter/SmcKVReportServiceMasterIMPL;", "Lcom/tencent/luggage/reporter/ISmcKVReportServiceEx;", "sessionHolder", "Lcom/tencent/luggage/reporter/SmcKVReportSessionHolder;", "(Lcom/tencent/luggage/reporter/SmcKVReportSessionHolder;)V", "MAX_SIZE", "", "isStrategyReady", "", "()Z", "stashedLogs", "Ljava/util/LinkedList;", "Lcom/tencent/luggage/reporter/ReportLogData;", "batchWriteKvData", "", "dataList", "Lcom/tencent/luggage/reporter/ReportLogDataList;", "flushSync", "writeKvData", "logId", "reportContent", "", "reportNow", "type", "ignoreFreqCheck", "reportUinType", "Companion", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class e
  implements b
{
  @Deprecated
  public static final e.a a = new e.a(null);
  private final int c;
  private final LinkedList<c> d;
  private final g e;
  
  public e(@NotNull g paramg)
  {
    this.e = paramg;
    this.c = 1000;
    this.d = new LinkedList();
  }
  
  private final boolean b()
  {
    return true;
  }
  
  public void a()
  {
    Object localObject1 = this.e.a();
    if (localObject1 != null) {
      synchronized (this.d)
      {
        Iterator localIterator = ((Iterable)this.d).iterator();
        while (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          ((h)localObject1).a(localc.a(), localc.b(), localc.c(), localc.d(), localc.e(), localc.f());
        }
        localObject1 = Unit.INSTANCE;
        return;
      }
    }
  }
  
  public void a(int paramInt1, @NotNull byte[] paramArrayOfByte, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "reportContent");
    h localh = this.e.a();
    if (localh != null)
    {
      if (b()) {
        synchronized (this.d)
        {
          Object localObject = ((Iterable)this.d).iterator();
          while (((Iterator)localObject).hasNext())
          {
            c localc = (c)((Iterator)localObject).next();
            localh.a(localc.a(), localc.b(), localc.c(), localc.d(), localc.e(), localc.f());
          }
          localObject = Unit.INSTANCE;
          localh.a(paramInt1, paramArrayOfByte, paramBoolean1, paramInt2, paramBoolean2, paramInt3);
          return;
        }
      }
      synchronized (this.d)
      {
        this.d.addLast(new c(paramInt1, paramArrayOfByte, paramBoolean1, paramInt2, paramBoolean2, 0, 32, null));
        if (this.d.size() > this.c) {
          this.d.pollFirst();
        }
        paramArrayOfByte = Unit.INSTANCE;
        return;
      }
    }
  }
  
  public void a(@Nullable d paramd)
  {
    if (paramd != null)
    {
      if (paramd.a().isEmpty()) {
        return;
      }
      ??? = this.e.a();
      if (??? != null)
      {
        if (b()) {
          synchronized (this.d)
          {
            Object localObject3 = ((Iterable)this.d).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              c localc = (c)((Iterator)localObject3).next();
              ((h)???).a(localc.a(), localc.b(), localc.c(), localc.d(), localc.e(), localc.f());
            }
            this.d.clear();
            localObject3 = Unit.INSTANCE;
            paramd = ((Iterable)paramd.a()).iterator();
            if (paramd.hasNext())
            {
              ??? = (c)paramd.next();
              ((h)???).a(((c)???).a(), ((c)???).b(), ((c)???).c(), ((c)???).d(), ((c)???).e(), ((c)???).f());
            }
          }
        }
        synchronized (this.d)
        {
          this.d.addAll((Collection)paramd.a());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dj.e
 * JD-Core Version:    0.7.0.1
 */