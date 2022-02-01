package com.tencent.luggage.wxa.ql;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;

class a$a
  implements c
{
  private HashMap<String, Boolean> a = new HashMap();
  
  public boolean a(String paramString)
  {
    return this.a.containsKey(paramString);
  }
  
  public String b(String paramString)
  {
    o.d("MicroMsg.Audio.AudioPlayerUtils", "findLibPath %s", new Object[] { paramString });
    Object localObject = paramString;
    if (!paramString.startsWith("lib"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lib");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = (String)localObject;
    if (!((String)localObject).endsWith(".so"))
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append(".so");
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  public boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      o.b("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name is null");
      return false;
    }
    if ((this.a.containsKey(paramString)) && (((Boolean)this.a.get(paramString)).booleanValue()))
    {
      o.b("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name %s is loaded", new Object[] { paramString });
      return true;
    }
    this.a.put(paramString, Boolean.valueOf(true));
    System.loadLibrary(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ql.a.a
 * JD-Core Version:    0.7.0.1
 */