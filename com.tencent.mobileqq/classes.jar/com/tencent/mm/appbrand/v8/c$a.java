package com.tencent.mm.appbrand.v8;

import com.tencent.luggage.wxa.jx.d;
import com.tencent.luggage.wxa.qz.af;
import java.lang.ref.WeakReference;

public class c$a
{
  public String a = null;
  public byte[] b = null;
  public String c = "0";
  public boolean d;
  public boolean e;
  public boolean f = false;
  public boolean g = false;
  public String h = null;
  public WeakReference<d> i = null;
  
  public c$a() {}
  
  public c$a(String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return "1".equalsIgnoreCase(this.c);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Config{codeCache='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", snapShot=");
    if (af.a(this.b)) {
      localObject = "null";
    } else {
      localObject = "not null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", nativeBuffer='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", supportDirectEvaluation=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", enableNativeTrans=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", hasGlobalTimer=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ignoreRemainingTaskWhenLoopEnd=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", globalAlias=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", hasComponent=");
    Object localObject = this.i;
    boolean bool;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.c.a
 * JD-Core Version:    0.7.0.1
 */