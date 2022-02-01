package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.c.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MMSharedPreferences$REditor
  implements SharedPreferences.Editor
{
  private boolean clear = false;
  private ContentResolver cr;
  private Set<String> remove = new HashSet();
  private Map<String, Object> values = new HashMap();
  
  public MMSharedPreferences$REditor(ContentResolver paramContentResolver)
  {
    this.cr = paramContentResolver;
  }
  
  public void apply() {}
  
  public SharedPreferences.Editor clear()
  {
    this.clear = true;
    return this;
  }
  
  public boolean commit()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.clear)
    {
      this.cr.delete(c.b.CONTENT_URI, null, null);
      this.clear = false;
    }
    Object localObject1 = this.remove.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      this.cr.delete(c.b.CONTENT_URI, "key = ?", new String[] { localObject2 });
    }
    Object localObject2 = this.values.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      Object localObject3 = localEntry.getValue();
      if (localObject3 == null) {}
      int i;
      for (localObject1 = "unresolve failed, null value";; localObject1 = ((StringBuilder)localObject1).toString())
      {
        Log.e("MicroMsg.SDK.PluginProvider.Resolver", (String)localObject1);
        i = 0;
        break;
        if ((localObject3 instanceof Integer))
        {
          i = 1;
          break;
        }
        if ((localObject3 instanceof Long))
        {
          i = 2;
          break;
        }
        if ((localObject3 instanceof String))
        {
          i = 3;
          break;
        }
        if ((localObject3 instanceof Boolean))
        {
          i = 4;
          break;
        }
        if ((localObject3 instanceof Float))
        {
          i = 5;
          break;
        }
        if ((localObject3 instanceof Double))
        {
          i = 6;
          break;
        }
        localObject1 = new StringBuilder("unresolve failed, unknown type=");
        ((StringBuilder)localObject1).append(localObject3.getClass().toString());
      }
      if (i == 0)
      {
        i = 0;
      }
      else
      {
        localContentValues.put("type", Integer.valueOf(i));
        localContentValues.put("value", localObject3.toString());
        i = 1;
      }
      if (i != 0) {
        this.cr.update(c.b.CONTENT_URI, localContentValues, "key = ?", new String[] { (String)localEntry.getKey() });
      }
    }
    return true;
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    this.values.put(paramString, Boolean.valueOf(paramBoolean));
    this.remove.remove(paramString);
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    this.values.put(paramString, Float.valueOf(paramFloat));
    this.remove.remove(paramString);
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    this.values.put(paramString, Integer.valueOf(paramInt));
    this.remove.remove(paramString);
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    this.values.put(paramString, Long.valueOf(paramLong));
    this.remove.remove(paramString);
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    this.values.put(paramString1, paramString2);
    this.remove.remove(paramString1);
    return this;
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    return null;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    this.remove.add(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.MMSharedPreferences.REditor
 * JD-Core Version:    0.7.0.1
 */