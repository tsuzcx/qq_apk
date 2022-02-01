package com.tencent.mm.plugin.appbrand.jsruntime;

import com.eclipsesource.mmv8.ScriptPartObject;
import com.tencent.mm.appbrand.v8.n.b;
import java.net.URL;
import java.util.ArrayList;

public abstract interface u
  extends j
{
  public static final int[] a = { 4, 0, 2, 1, 3 };
  
  public abstract void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, n.b paramb);
  
  public abstract void a(ArrayList<ScriptPartObject> paramArrayList, URL paramURL, String paramString1, String paramString2, n.b paramb);
  
  public abstract long i();
  
  public abstract long j();
  
  public abstract long k();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.u
 * JD-Core Version:    0.7.0.1
 */