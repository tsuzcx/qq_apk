package com.tencent.av.opengl;

import com.tencent.av.AVLog;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class GlStringParser
{
  private char jdField_a_of_type_Char = '\r';
  private Map jdField_a_of_type_JavaUtilMap;
  private char b = '\t';
  
  public GlStringParser()
  {
    this.jdField_a_of_type_Char = '\r';
    this.b = '\t';
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public GlStringParser(char paramChar1, char paramChar2)
  {
    this.jdField_a_of_type_Char = paramChar1;
    this.b = paramChar2;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public int a(String paramString)
  {
    paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (Exception paramString)
      {
        AVLog.e("GlStringParser", paramString.getMessage());
        return 0;
      }
    }
    return 0;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilMap.clear();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      paramString = new StringTokenizer(paramString, ((StringBuilder)localObject).toString());
      while (paramString.hasMoreElements())
      {
        String str = paramString.nextToken();
        int i = str.indexOf(this.jdField_a_of_type_Char);
        if (i != -1)
        {
          localObject = str.substring(0, i);
          str = str.substring(i + 1);
          this.jdField_a_of_type_JavaUtilMap.put(localObject, str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.opengl.GlStringParser
 * JD-Core Version:    0.7.0.1
 */