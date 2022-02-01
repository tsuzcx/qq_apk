package com.tencent.liteav.beauty;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class d$a
{
  WeakReference<d> a;
  private HashMap<String, String> b = new HashMap();
  
  public d$a(d paramd)
  {
    this.a = new WeakReference(paramd);
  }
  
  public String a()
  {
    Object localObject = this.b.keySet().iterator();
    StringBuilder localStringBuilder;
    for (String str1 = ""; ((Iterator)localObject).hasNext(); str1 = localStringBuilder.toString())
    {
      String str2 = (String)((Iterator)localObject).next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append(":");
      localStringBuilder.append((String)this.b.get(str2));
      localStringBuilder.append(" ");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("{");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append("}");
    return ((StringBuilder)localObject).toString();
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.put(paramString, String.valueOf(paramInt));
    paramString = (d)this.a.get();
    if (paramString != null)
    {
      String str = paramString.getID();
      if ((str != null) && (str.length() > 0)) {
        paramString.setStatusValue(3001, a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.d.a
 * JD-Core Version:    0.7.0.1
 */