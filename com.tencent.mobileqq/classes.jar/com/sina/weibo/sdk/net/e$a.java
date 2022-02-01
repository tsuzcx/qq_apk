package com.sina.weibo.sdk.net;

import android.os.Bundle;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class e$a
{
  Bundle k = new Bundle();
  Bundle l = new Bundle();
  Map<String, Object<File>> m = new HashMap();
  Map<String, byte[]> n = new HashMap();
  int o = 30000;
  int p = 60000;
  public String url;
  
  private void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof String)) {
        paramBundle.putString(paramString, String.valueOf(paramObject));
      }
    }
    else {
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Short))
    {
      paramBundle.putShort(paramString, ((Short)paramObject).shortValue());
      return;
    }
    if ((paramObject instanceof Character))
    {
      paramBundle.putChar(paramString, ((Character)paramObject).charValue());
      return;
    }
    if ((paramObject instanceof Byte))
    {
      paramBundle.putByte(paramString, ((Byte)paramObject).byteValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramBundle.putFloat(paramString, ((Float)paramObject).floatValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramBundle.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      this.n.put(paramString, (byte[])paramObject);
      return;
    }
    if ((paramObject instanceof Serializable))
    {
      paramBundle.putSerializable(paramString, (Serializable)paramObject);
      return;
    }
    throw new IllegalArgumentException("Unsupported params type!");
  }
  
  public final a a(String paramString, Object paramObject)
  {
    a(this.k, paramString, paramObject);
    return this;
  }
  
  public final a b(String paramString, Object paramObject)
  {
    a(this.l, paramString, paramObject);
    return this;
  }
  
  public final e i()
  {
    return new e(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.net.e.a
 * JD-Core Version:    0.7.0.1
 */