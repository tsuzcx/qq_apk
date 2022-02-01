package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

public class i0
  implements m0
{
  public byte[] a;
  public String b;
  public String c;
  public String d;
  public String e;
  public List<q> f;
  
  public i0(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, String paramString4, List<q> paramList)
  {
    this.a = ((byte[])paramArrayOfByte.clone());
    this.b = paramString1;
    this.c = paramString2;
    this.e = paramString3;
    this.d = paramString4;
    this.f = paramList;
  }
  
  public final b0 a(Map<String, String> paramMap)
  {
    return a0.a(this.b, this.a, paramMap);
  }
  
  public final Map<String, String> a()
  {
    return b1.b(this.c, this.e, this.d);
  }
  
  public final void b()
  {
    l0 locall0 = new l0(this.f, this.c, this.d, this.e);
    n0.b().a(locall0);
  }
  
  public void run()
  {
    y.c("hmsSdk", "send data running");
    int i = a(a()).a();
    if (i != 200)
    {
      b();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:");
    localStringBuilder.append(this.d);
    y.b("hmsSdk", localStringBuilder.toString(), new Object[] { this.e, this.c, Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.i0
 * JD-Core Version:    0.7.0.1
 */