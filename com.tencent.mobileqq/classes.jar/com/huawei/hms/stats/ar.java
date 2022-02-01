package com.huawei.hms.stats;

import java.util.List;
import java.util.Map;

public class ar
  implements av
{
  private byte[] a;
  private String b;
  private String c;
  private String d;
  private String e;
  private List<w> f;
  
  public ar(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, String paramString4, List<w> paramList)
  {
    this.a = ((byte[])paramArrayOfByte.clone());
    this.b = paramString1;
    this.c = paramString2;
    this.e = paramString3;
    this.d = paramString4;
    this.f = paramList;
  }
  
  private aj a(Map<String, String> paramMap)
  {
    return ai.a(this.b, this.a, paramMap);
  }
  
  private Map<String, String> a()
  {
    return bk.c(this.c, this.e, this.d);
  }
  
  private void b()
  {
    au localau = new au(this.f, this.c, this.d, this.e);
    aw.a().a(localau);
  }
  
  public void run()
  {
    af.b("DataSendTask", "send data running");
    int i = a(a()).a();
    if (i != 200)
    {
      b();
      return;
    }
    af.a("DataSendTask", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.d, new Object[] { this.e, this.c, Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.ar
 * JD-Core Version:    0.7.0.1
 */