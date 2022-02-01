package com.tencent.luggage.wxa.ra;

import android.os.Message;
import android.text.TextUtils;
import java.util.Calendar;

public class c$a
{
  private c a;
  private long b;
  private int c;
  private String d;
  private a e;
  private a f;
  private a g;
  
  c$a(c paramc, Message paramMessage, String paramString, a parama1, a parama2, a parama3)
  {
    a(paramc, paramMessage, paramString, parama1, parama2, parama3);
  }
  
  public void a(c paramc, Message paramMessage, String paramString, a parama1, a parama2, a parama3)
  {
    this.a = paramc;
    this.b = System.currentTimeMillis();
    int i;
    if (paramMessage != null) {
      i = paramMessage.what;
    } else {
      i = 0;
    }
    this.c = i;
    this.d = paramString;
    this.e = parama1;
    this.f = parama2;
    this.g = parama3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time=");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.b);
    localStringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[] { localObject, localObject, localObject, localObject, localObject, localObject }));
    localStringBuilder.append(" processed=");
    localObject = this.e;
    String str = "<null>";
    if (localObject == null) {
      localObject = "<null>";
    } else {
      localObject = ((a)localObject).c();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" org=");
    localObject = this.f;
    if (localObject == null) {
      localObject = "<null>";
    } else {
      localObject = ((a)localObject).c();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" dest=");
    localObject = this.g;
    if (localObject == null) {
      localObject = str;
    } else {
      localObject = ((a)localObject).c();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" what=");
    localObject = this.a;
    if (localObject != null) {
      localObject = ((c)localObject).a(this.c);
    } else {
      localObject = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder.append(this.c);
      localStringBuilder.append("(0x");
      localStringBuilder.append(Integer.toHexString(this.c));
      localStringBuilder.append(")");
    }
    else
    {
      localStringBuilder.append((String)localObject);
    }
    if (!TextUtils.isEmpty(this.d))
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.d);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ra.c.a
 * JD-Core Version:    0.7.0.1
 */