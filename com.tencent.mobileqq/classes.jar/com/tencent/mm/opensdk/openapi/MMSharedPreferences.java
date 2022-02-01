package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.opensdk.utils.Log;
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
        localObject = this.cr;
        Uri localUri = com.tencent.mm.opensdk.utils.a.a;
        String[] arrayOfString = this.columns;
        localObject = ((ContentResolver)localObject).query(localUri, arrayOfString, "key = ?", new String[] { paramString }, null);
        if (localObject == null) {
          return null;
        }
        int i = ((Cursor)localObject).getColumnIndex("type");
        int j = ((Cursor)localObject).getColumnIndex("value");
        if (((Cursor)localObject).moveToFirst())
        {
          paramString = com.tencent.mm.opensdk.channel.a.a.a(((Cursor)localObject).getInt(i), ((Cursor)localObject).getString(j));
          ((Cursor)localObject).close();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getValue exception:");
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
      Object localObject1 = this.cr.query(com.tencent.mm.opensdk.utils.a.a, this.columns, null, null, null);
      if (localObject1 == null) {
        return null;
      }
      int i = ((Cursor)localObject1).getColumnIndex("key");
      int j = ((Cursor)localObject1).getColumnIndex("type");
      int k = ((Cursor)localObject1).getColumnIndex("value");
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = com.tencent.mm.opensdk.channel.a.a.a(((Cursor)localObject1).getInt(j), ((Cursor)localObject1).getString(k));
        this.values.put(((Cursor)localObject1).getString(i), localObject2);
      }
      ((Cursor)localObject1).close();
      localObject1 = this.values;
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAll exception:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      Log.e("MicroMsg.SDK.SharedPreferences", ((StringBuilder)localObject2).toString());
    }
    return this.values;
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
    Object localObject = getValue(paramString1);
    paramString1 = paramString2;
    if (localObject != null)
    {
      paramString1 = paramString2;
      if ((localObject instanceof String)) {
        paramString1 = (String)localObject;
      }
    }
    return paramString1;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return null;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.MMSharedPreferences
 * JD-Core Version:    0.7.0.1
 */