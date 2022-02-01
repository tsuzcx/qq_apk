package com.tencent.featuretoggle.hltxkg.common.b.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class f
{
  public int a;
  private Map<String, String> a;
  public String b;
  public int c;
  public byte[] d;
  
  public f(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramString;
    this.c = 0;
  }
  
  public final String a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(paramString.toLowerCase());
      if (!TextUtils.isEmpty(paramString)) {
        return paramString;
      }
    }
    return "";
  }
  
  public final Map<String, String> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_JavaUtilMap.put(str.toLowerCase(), paramMap.get(str));
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("errorCode:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",errorInfo:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",httpStatus:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",headers:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.b.a.f
 * JD-Core Version:    0.7.0.1
 */