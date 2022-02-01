package com.tencent.gathererga.tangram;

import com.tencent.gathererga.core.IExecutor;
import com.tencent.gathererga.core.ILog;
import com.tencent.gathererga.core.internal.component.GathererHTTP;
import java.util.HashMap;

public final class TangramGlobalSetting$Builder
{
  private String a;
  private String b;
  private HashMap<Integer, TangramIDSetting> c;
  private IExecutor d;
  private String e = "Gatherer";
  private ILog f;
  private GathererHTTP g;
  private boolean h = true;
  private boolean i = true;
  
  public final Builder a(IExecutor paramIExecutor)
  {
    this.d = paramIExecutor;
    return this;
  }
  
  public final Builder a(ILog paramILog)
  {
    this.f = paramILog;
    return this;
  }
  
  public final Builder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public final Builder a(HashMap<Integer, TangramIDSetting> paramHashMap)
  {
    this.c = paramHashMap;
    return this;
  }
  
  public final Builder a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public final TangramGlobalSetting a()
  {
    return new TangramGlobalSetting(this, null);
  }
  
  public final Builder b(String paramString)
  {
    this.b = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.tangram.TangramGlobalSetting.Builder
 * JD-Core Version:    0.7.0.1
 */