package c.t.m.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ao
{
  public int a;
  public String b;
  public int c;
  public byte[] d;
  private Map<String, String> e;
  
  public ao(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = 0;
  }
  
  public final String a(String paramString)
  {
    if ((this.e != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = (String)this.e.get(paramString.toLowerCase());
      if (!TextUtils.isEmpty(paramString)) {
        return paramString;
      }
    }
    return "";
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.e = new HashMap();
    if (paramMap.size() > 0)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.e.put(str.toLowerCase(), paramMap.get(str));
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("errorCode:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",errorInfo:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",httpStatus:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",headers:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",body:");
    Object localObject = this.d;
    if (localObject != null) {
      localObject = Integer.valueOf(localObject.length);
    } else {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ao
 * JD-Core Version:    0.7.0.1
 */