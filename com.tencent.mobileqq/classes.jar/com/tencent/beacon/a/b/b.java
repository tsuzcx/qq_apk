package com.tencent.beacon.a.b;

import com.tencent.beacon.base.net.a;
import com.tencent.beacon.base.net.e;
import com.tencent.beacon.base.util.c;

class b
  implements com.tencent.beacon.base.net.a.b<a>
{
  b(d paramd) {}
  
  public void a(a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("net ret: ");
    localStringBuilder.append(parama.toString());
    c.a("AttaReport", localStringBuilder.toString(), new Object[0]);
  }
  
  public void a(e parame) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.b.b
 * JD-Core Version:    0.7.0.1
 */