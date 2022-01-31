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
        Cursor localCursor = this.cr.query(c.b.CONTENT_URI, this.columns, "key = ?", new String[] { paramString }, null);
        if (localCursor == null) {
          return null;
        }
        int i = localCursor.getColumnIndex("type");
        int j = localCursor.getColumnIndex("value");
        if (localCursor.moveToFirst())
        {
          paramString = c.a.a(localCursor.getInt(i), localCursor.getString(j));
          localCursor.close();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.SDK.SharedPreferences", "getValue exception:" + paramString.getMessage());
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
      Cursor localCursor = this.cr.query(c.b.CONTENT_URI, this.columns, null, null, null);
      if (localCursor == null) {
        return null;
      }
      int i = localCursor.getColumnIndex("key");
      int j = localCursor.getColumnIndex("type");
      int k = localCursor.getColumnIndex("value");
      while (localCursor.moveToNext())
      {
        Object localObject = c.a.a(localCursor.getInt(j), localCursor.getString(k));
        this.values.put(localCursor.getString(i), localObject);
      }
      localException.close();
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SDK.SharedPreferences", "getAll exception:" + localException.getMessage());
      return this.values;
    }
    HashMap localHashMap = this.values;
    return localHashMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    paramString = getValue(paramString);
    boolean bool = paramBoolean;
    if (paramString != null)
    {
      bool = paramBoolean;
      if ((paramString instanceof Boolean)) {
        bool = ((Boolean)paramString).booleanValue();
      }
    }
    return bool;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    paramString = getValue(paramString);
    float f = paramFloat;
    if (paramString != null)
    {
      f = paramFloat;
      if ((paramString instanceof Float)) {
        f = ((Float)paramString).floatValue();
      }
    }
    return f;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    paramString = getValue(paramString);
    int i = paramInt;
    if (paramString != null)
    {
      i = paramInt;
      if ((paramString instanceof Integer)) {
        i = ((Integer)paramString).intValue();
      }
    }
    return i;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    paramString = getValue(paramString);
    long l = paramLong;
    if (paramString != null)
    {
      l = paramLong;
      if ((paramString instanceof Long)) {
        l = ((Long)paramString).longValue();
      }
    }
    return l;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.MMSharedPreferences
 * JD-Core Version:    0.7.0.1
 */