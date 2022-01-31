package com.tencent.beacon.core.protocol.strategy;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class CommonStrategy
  extends JceStruct
{
  static Map<String, String> cache_cloudParas;
  static ArrayList<ModuleStrategy> cache_moduleList;
  public Map<String, String> cloudParas = null;
  public ArrayList<ModuleStrategy> moduleList = null;
  public int queryInterval = 0;
  public String url = "";
  
  public CommonStrategy() {}
  
  public CommonStrategy(ArrayList<ModuleStrategy> paramArrayList, int paramInt, String paramString, Map<String, String> paramMap)
  {
    this.moduleList = paramArrayList;
    this.queryInterval = paramInt;
    this.url = paramString;
    this.cloudParas = paramMap;
  }
  
  public final void readFrom(a parama)
  {
    if (cache_moduleList == null)
    {
      cache_moduleList = new ArrayList();
      ModuleStrategy localModuleStrategy = new ModuleStrategy();
      cache_moduleList.add(localModuleStrategy);
    }
    this.moduleList = ((ArrayList)parama.a(cache_moduleList, 0, true));
    this.queryInterval = parama.a(this.queryInterval, 1, true);
    this.url = parama.b(2, true);
    if (cache_cloudParas == null)
    {
      cache_cloudParas = new HashMap();
      cache_cloudParas.put("", "");
    }
    this.cloudParas = ((Map)parama.a(cache_cloudParas, 3, false));
  }
  
  public final void writeTo(b paramb)
  {
    paramb.a(this.moduleList, 0);
    paramb.a(this.queryInterval, 1);
    paramb.a(this.url, 2);
    if (this.cloudParas != null) {
      paramb.a(this.cloudParas, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.protocol.strategy.CommonStrategy
 * JD-Core Version:    0.7.0.1
 */