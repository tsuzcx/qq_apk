package com.tencent.gathererga.core.internal.component.cloudconf;

import com.tencent.gathererga.core.internal.GathererConfigInternal;
import java.util.HashMap;
import java.util.Map;

public class IDConfigManagerImpl
  implements IDConfigManager
{
  public static final IDConfigManager a = new IDConfigManagerImpl();
  private Map<Integer, Boolean> b = new HashMap();
  private GathererConfigInternal c;
  
  public static IDConfigManager a()
  {
    return a;
  }
  
  public void a(GathererConfigInternal paramGathererConfigInternal)
  {
    this.c = paramGathererConfigInternal;
    this.b.putAll(this.c.c());
  }
  
  public void a(Map<Integer, Boolean> paramMap)
  {
    this.c.a(paramMap);
    this.b.putAll(paramMap);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = this.b;
    if (localObject == null) {
      return true;
    }
    localObject = (Boolean)((Map)localObject).get(Integer.valueOf(paramInt));
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.component.cloudconf.IDConfigManagerImpl
 * JD-Core Version:    0.7.0.1
 */