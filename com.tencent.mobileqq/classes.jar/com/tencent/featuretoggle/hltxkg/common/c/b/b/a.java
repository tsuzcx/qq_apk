package com.tencent.featuretoggle.hltxkg.common.c.b.b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class a
{
  public Map<String, Object> a = new HashMap();
  
  public final byte[] a()
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (Exception localException)
      {
        label65:
        break label65;
      }
    }
    return localJSONObject.toString().getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.b.b.a
 * JD-Core Version:    0.7.0.1
 */