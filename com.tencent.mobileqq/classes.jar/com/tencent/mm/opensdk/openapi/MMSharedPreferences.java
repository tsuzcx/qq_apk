package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.c.a;
import com.tencent.mm.opensdk.utils.c.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class MMSharedPreferences
  implements SharedPreferences
{
  private static final String TAG = "MicroMsg.SDK.SharedPreferences";
  private final String[] columns = { "_id", "key", "type", "value" };
  private final ContentResolver cr;
  private MMSharedPreferences.REditor editor = null;
  private final HashMap<String, Object> values = new HashMap();
  
  public MMSharedPreferences(Context paramContext)
  {
    this.cr = paramContext.getContentResolver();
  }
  
  private Object getValue(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = this.cr.query(c.b.CONTENT_URI, this.columns, "key = ?", new String[] { paramString }, null);
        if (localObject == null) {
          return null;
        }
        int i = ((Cursor)localObject).getColumnIndex("type");
        int j = ((Cursor)localObject).getColumnIndex("value");
        if (((Cursor)localObject).moveToFirst())
        {
          paramString = c.a.a(((Cursor)localObject).getInt(i), ((Cursor)localObject).getString(j));
          ((Cursor)localObject).close();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder("getValue exception:");
        ((StringBuilder)localObject).append(paramString.getMessage());
        Log.e("MicroMsg.SDK.SharedPreferences", ((StringBuilder)localObject).toString());
        return null;
      }
      paramString = null;
    }
  }
  
  public boolean contains(String paramString)
  {
    return getValue(paramString) != null;
  }
  
  public SharedPreferences.Editor edit()
  {
    if (this.editor == null) {
      this.editor = new MMSharedPreferences.REditor(this.cr);
    }
    return this.editor;
  }
  
  public Map<String, ?> getAll()
  {
    try
    {
      Object localObject1 = this.cr.query(c.b.CONTENT_URI, this.columns, null, null, null);
      if (localObject1 == null) {
        return null;
      }
      int i = ((Cursor)localObject1).getColumnIndex("key");
      int j = ((Cursor)localObject1).getColumnIndex("type");
      int k = ((Cursor)localObject1).getColumnIndex("value");
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = c.a.a(((Cursor)localObject1).getInt(j), ((Cursor)localObject1).getString(k));
        this.values.put(((Cursor)localObject1).getString(i), localObject2);
      }
      ((Cursor)localObject1).close();
      localObject1 = this.values;
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder("getAll exception:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      Log.e("MicroMsg.SDK.SharedPreferences", ((StringBuilder)localObject2).toString());
    }
    return this.values;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Boolean))) {
      return ((Boolean)paramString).booleanValue();
    }
    return paramBoolean;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Float))) {
      return ((Float)paramString).floatValue();
    }
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Integer))) {
      return ((Integer)paramString).intValue();
    }
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Long))) {
      return ((Long)paramString).longValue();
    }
    return paramLong;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    paramString1 = getValue(paramString1);
    if ((paramString1 != null) && ((paramString1 instanceof String))) {
      return (String)paramString1;
    }
    return paramString2;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return null;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.MMSharedPreferences
 * JD-Core Version:    0.7.0.1
 */