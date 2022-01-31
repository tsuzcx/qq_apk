package com.tencent.beacon.core.event;

import android.util.Base64;
import com.tencent.beacon.event.UserAction;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class l
  implements Runnable
{
  private Map<String, List<Float>> a = new HashMap();
  
  private static String a(List<Float> paramList)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramList.size() << 2);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localByteBuffer.putFloat(((Float)paramList.next()).floatValue());
    }
    return Base64.encodeToString(localByteBuffer.array(), 0);
  }
  
  public final void a(String paramString, float[] paramArrayOfFloat)
  {
    List localList = (List)this.a.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.a.put(paramString, localObject);
    }
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      ((List)localObject).add(Float.valueOf(paramArrayOfFloat[i]));
      i += 1;
    }
  }
  
  public final void run()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = a((List)localEntry.getValue()).replace("=", "%3D").replace("/", "%2F").replace("+", "%2B").replace("\n", "");
      localHashMap.put(localEntry.getKey(), str + ";");
    }
    UserAction.onUserAction("rqd_sensor", true, -1L, -1L, localHashMap, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.event.l
 * JD-Core Version:    0.7.0.1
 */