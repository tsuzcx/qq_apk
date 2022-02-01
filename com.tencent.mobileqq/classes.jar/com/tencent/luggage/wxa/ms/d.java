package com.tencent.luggage.wxa.ms;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class d
{
  public String a = "ok";
  public List<c> b = null;
  
  public JSONArray a()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((c)localIterator.next()).a());
    }
    return localJSONArray;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mErrorMsg:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mWifiList:");
    Object localObject = this.b;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      localObject = this.b.iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      localStringBuilder.append(" WiFiItem:");
      localStringBuilder.append(localc);
      continue;
      localStringBuilder.append("null:");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ms.d
 * JD-Core Version:    0.7.0.1
 */