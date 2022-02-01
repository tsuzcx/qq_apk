package com.tencent.gathererga.tangram;

import com.tencent.gathererga.core.IExecutor;
import com.tencent.gathererga.core.ILog;
import com.tencent.gathererga.core.internal.component.GathererHTTP;
import java.util.HashMap;

public class TangramGlobalSetting
{
  private String a;
  private String b;
  private HashMap<Integer, TangramIDSetting> c;
  private IExecutor d;
  private String e;
  private boolean f;
  private ILog g;
  private GathererHTTP h;
  private boolean i;
  
  private TangramGlobalSetting(TangramGlobalSetting.Builder paramBuilder)
  {
    this.a = TangramGlobalSetting.Builder.a(paramBuilder);
    this.b = TangramGlobalSetting.Builder.b(paramBuilder);
    this.c = TangramGlobalSetting.Builder.c(paramBuilder);
    this.d = TangramGlobalSetting.Builder.d(paramBuilder);
    this.e = TangramGlobalSetting.Builder.e(paramBuilder);
    this.f = TangramGlobalSetting.Builder.f(paramBuilder);
    this.g = TangramGlobalSetting.Builder.g(paramBuilder);
    this.h = TangramGlobalSetting.Builder.h(paramBuilder);
    this.i = TangramGlobalSetting.Builder.i(paramBuilder);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public IExecutor c()
  {
    return this.d;
  }
  
  public HashMap<Integer, TangramIDSetting> d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public ILog g()
  {
    return this.g;
  }
  
  public GathererHTTP h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.tangram.TangramGlobalSetting
 * JD-Core Version:    0.7.0.1
 */