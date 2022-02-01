package com.tencent.luggage.wxa.dj;

import android.os.Looper;
import android.os.Parcelable;
import com.tencent.luggage.wxa.hj.b;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.qz.v.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/reporter/SmcKVReportServiceSlaveIMPL;", "Lcom/tencent/luggage/reporter/ISmcKVReportService;", "MASTER_PROCESS_NAME", "", "(Ljava/lang/String;)V", "MAX_SIZE", "", "periodTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "stashedLogs", "Ljava/util/LinkedList;", "Lcom/tencent/luggage/reporter/ReportLogData;", "flushSync", "", "ipcReport", "toReportList", "Lcom/tencent/luggage/reporter/ReportLogDataList;", "reportAll", "writeKvData", "logId", "reportContent", "", "reportNow", "", "type", "ignoreFreqCheck", "reportUinType", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class f
  implements a
{
  private final int a;
  private final LinkedList<c> c;
  private final v d;
  private final String e;
  
  public f(@NotNull String paramString)
  {
    this.e = paramString;
    this.a = 1000;
    this.c = new LinkedList();
    this.d = new v(Looper.getMainLooper(), (v.a)new f.1(this), true);
    long l = TimeUnit.SECONDS.toMillis(30L);
    this.d.a(l, l);
  }
  
  private final void a(d paramd)
  {
    if (paramd != null)
    {
      ArrayList localArrayList = paramd.a();
      if (localArrayList != null)
      {
        i = localArrayList.size();
        break label23;
      }
    }
    int i = 0;
    label23:
    if (i > 0) {
      b.a(this.e, (Parcelable)paramd, (com.tencent.luggage.wxa.hj.c)f.a.a, null);
    }
  }
  
  private final void b()
  {
    synchronized (this.c)
    {
      d locald = new d(new ArrayList((Collection)this.c));
      this.c.clear();
      Unit localUnit = Unit.INSTANCE;
      a(locald);
      return;
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt1, @NotNull byte[] paramArrayOfByte, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "reportContent");
    synchronized (this.c)
    {
      this.c.addLast(new c(paramInt1, paramArrayOfByte, paramBoolean1, paramInt2, paramBoolean2, 0, 32, null));
      if (this.c.size() >= this.a)
      {
        paramArrayOfByte = new d(new ArrayList((Collection)this.c));
        this.c.clear();
      }
      else
      {
        paramArrayOfByte = (d)null;
      }
      Unit localUnit = Unit.INSTANCE;
      a(paramArrayOfByte);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dj.f
 * JD-Core Version:    0.7.0.1
 */