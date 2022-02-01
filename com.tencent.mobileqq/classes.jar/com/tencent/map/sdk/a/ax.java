package com.tencent.map.sdk.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class ax
{
  private JSONObject a;
  
  public final String a()
  {
    try
    {
      if (this.a == null) {
        return "";
      }
      String str = this.a.toString();
      return str;
    }
    finally {}
  }
  
  public final String a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      if ((this.a == null) || (TextUtils.isEmpty(paramString1))) {
        break label371;
      }
      localJSONObject = this.a.optJSONObject("data");
      if (localJSONObject == null) {
        return "";
      }
      localJSONObject = localJSONObject.optJSONObject(paramString1);
      if (localJSONObject == null) {
        return "";
      }
      localArrayList = new ArrayList();
      paramString1 = localJSONObject.keys();
      while (paramString1.hasNext())
      {
        Object localObject = (String)paramString1.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (((String)localObject).equals("deviceid"))
          {
            paramString1 = localJSONObject.optString("deviceid");
            return paramString1;
          }
          localObject = new ax.a((String)localObject, paramInt, paramString2, paramString3, paramString4, paramString5);
          if (((ax.a)localObject).b) {
            localArrayList.add(localObject);
          }
        }
      }
      if (localArrayList.size() == 0) {
        return "";
      }
      if (localArrayList.size() == 1)
      {
        paramString1 = localJSONObject.optString(((ax.a)localArrayList.get(0)).a);
        return paramString1;
      }
      paramString1 = (ax.a)localArrayList.get(0);
      paramInt = 1;
    }
    finally
    {
      for (;;)
      {
        JSONObject localJSONObject;
        ArrayList localArrayList;
        for (;;)
        {
          label371:
          throw paramString1;
        }
        boolean bool = true;
        label390:
        if (bool) {
          paramString1 = paramString2;
        }
        paramInt += 1;
      }
    }
    if (paramInt < localArrayList.size())
    {
      paramString2 = (ax.a)localArrayList.get(paramInt);
      if (paramString1.b)
      {
        if (paramString2.c != paramString1.c)
        {
          bool = paramString2.c;
          break label390;
        }
        if (paramString2.d != paramString1.d)
        {
          bool = paramString2.d;
          break label390;
        }
        if (paramString2.e != paramString1.e)
        {
          bool = paramString2.e;
          break label390;
        }
        if (paramString2.f != paramString1.f)
        {
          bool = paramString2.f;
          break label390;
        }
        if (paramString2.g != paramString1.g)
        {
          bool = paramString2.g;
          break label390;
        }
      }
    }
    else
    {
      paramString1 = localJSONObject.optString(paramString1.a);
      return paramString1;
      return "";
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
    }
    finally
    {
      Object localObject;
      for (;;)
      {
        label169:
        throw paramString;
      }
    }
    try
    {
      localObject = new JSONObject(paramString);
      if (this.a == null)
      {
        this.a = ((JSONObject)localObject);
        return;
      }
      paramString = ((JSONObject)localObject).optJSONObject("data");
      localObject = ((JSONObject)localObject).optString("version");
      if ((paramString != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        JSONObject localJSONObject1 = this.a.optJSONObject("data");
        if (localJSONObject1 == null)
        {
          this.a.putOpt("data", paramString);
        }
        else
        {
          Iterator localIterator = paramString.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (!TextUtils.isEmpty(str))
            {
              JSONObject localJSONObject2 = paramString.optJSONObject(str);
              if (localJSONObject2 != null) {
                localJSONObject1.putOpt(str, localJSONObject2);
              }
            }
          }
        }
        this.a.putOpt("version", localObject);
      }
      return;
    }
    catch (Throwable paramString)
    {
      break label169;
    }
  }
  
  public final void b()
  {
    try
    {
      this.a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String c()
  {
    try
    {
      if (this.a != null)
      {
        String str = this.a.optString("version");
        return str;
      }
      return "";
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ax
 * JD-Core Version:    0.7.0.1
 */