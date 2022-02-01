package com.tencent.map.sdk.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class jj
{
  public static int a = 1000;
  public volatile List<ji> b;
  public gc c;
  public int d = -1;
  
  public jj(Context paramContext, String paramString)
  {
    if (paramString == null) {
      this.c = gf.a(paramContext);
    } else {
      this.c = ge.a(paramContext, paramString);
    }
    this.b = new CopyOnWriteArrayList();
    paramString = this.c.a("mapStyleList");
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "[{\"id\":0,\"index\":0,\"order\":1},{\"id\":-1,\"index\":1,\"order\":-1},{\"id\":-1,\"index\":2,\"order\":-1},{\"id\":-1,\"index\":3,\"order\":-1},{\"id\":-1,\"index\":4,\"order\":-1},{\"id\":-1,\"index\":5,\"order\":-1},{\"id\":-1,\"index\":6,\"order\":-1},{\"id\":-1,\"index\":7,\"order\":-1},{\"id\":-1,\"index\":8,\"order\":-1},{\"id\":9,\"index\":9,\"order\":-1},{\"id\":10,\"index\":10,\"order\":-1},{\"id\":5,\"index\":11,\"order\":-1},{\"id\":4,\"index\":12,\"order\":-1},{\"id\":6,\"index\":13,\"order\":-1},{\"id\":7,\"index\":14,\"order\":-1},{\"id\":8,\"index\":15,\"order\":-1}]";
    }
    try
    {
      paramContext = new JSONArray(paramContext);
      this.b.addAll(a(paramContext));
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static List<ji> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    int j = paramJSONArray.length();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        localArrayList.add(new ji(localJSONObject.getInt("index"), localJSONObject.getInt("id"), localJSONObject.getInt("order")));
        i += 1;
      }
      catch (Exception paramJSONArray) {}
    }
    Collections.sort(localArrayList);
    return localArrayList;
    return null;
  }
  
  public final int a(int paramInt)
  {
    int i = paramInt;
    if (this.b != null)
    {
      i = paramInt;
      if (this.b.size() != 0)
      {
        if (paramInt < 0) {
          return paramInt;
        }
        this.d = paramInt;
        i = a;
        if (paramInt >= i) {
          return paramInt - i;
        }
        Iterator localIterator = this.b.iterator();
        ji localji;
        do
        {
          i = paramInt;
          if (!localIterator.hasNext()) {
            break;
          }
          localji = (ji)localIterator.next();
        } while (localji.c != paramInt);
        i = localji.a;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.jj
 * JD-Core Version:    0.7.0.1
 */