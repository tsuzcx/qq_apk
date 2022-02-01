package com.tencent.beacon.event;

import com.tencent.beacon.base.net.a.b;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import java.util.HashSet;
import java.util.Set;

final class d
  implements b<byte[]>
{
  private final Set<Long> a;
  private final String b;
  private final String c;
  private e d;
  private String e;
  private com.tencent.beacon.event.a.a f;
  
  d(e parame, String paramString1, com.tencent.beacon.event.a.a parama, Set<Long> paramSet, String paramString2)
  {
    this.d = parame;
    this.e = paramString1;
    this.f = parama;
    this.a = new HashSet(paramSet);
    parame = new StringBuilder();
    parame.append("[EventReport(");
    parame.append(paramString1);
    parame.append(")]");
    this.b = parame.toString();
    this.c = paramString2;
  }
  
  public void a(com.tencent.beacon.base.net.e parame)
  {
    com.tencent.beacon.base.util.c.a(this.b, 3, "send failure reason: %s. LogID: %s.", new Object[] { parame.toString(), this.c });
    this.d.a(this.a);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    boolean bool = ((EventModule)com.tencent.beacon.a.c.c.d().a(ModuleName.EVENT)).c().a(new c(this));
    com.tencent.beacon.base.util.c.a(this.b, 3, "report success! sendingID will delete this time's IDs. offer task: %s! ", new Object[] { Boolean.valueOf(bool) });
    if (this.a.size() >= this.d.a()) {
      com.tencent.beacon.a.b.a.a().a(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.d
 * JD-Core Version:    0.7.0.1
 */