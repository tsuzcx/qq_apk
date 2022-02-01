package com.tencent.av.ManageConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class AVTestforEncDecConfig$TestInfo
{
  public int a;
  public long a;
  public String a;
  public ArrayList<Integer> a;
  public HashMap<String, AVTestforEncDecConfig.Sample> a;
  public boolean a;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  
  public AVTestforEncDecConfig$TestInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("TestInfo{");
    localStringBuffer.append("taskId='");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append('\'');
    localStringBuffer.append(", codec=");
    localStringBuffer.append(this.b);
    localStringBuffer.append(", min_sdk=");
    localStringBuffer.append(this.c);
    localStringBuffer.append(", async_min_sdk=");
    localStringBuffer.append(this.d);
    localStringBuffer.append(", min_version=");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append(", test_ver=");
    localStringBuffer.append(this.e);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localStringBuffer.append(", disable_sdks=");
      localStringBuffer.append(Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray()));
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (AVTestforEncDecConfig.Sample)((Map.Entry)localObject2).getValue();
        localStringBuffer.append(", codecKey=");
        localStringBuffer.append(str);
        localStringBuffer.append(", codecValue=");
        localStringBuffer.append(localObject2);
      }
    }
    localStringBuffer.append(", upload = ");
    localStringBuffer.append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", expdate = ");
    localStringBuffer.append(this.jdField_a_of_type_Long);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ManageConfig.AVTestforEncDecConfig.TestInfo
 * JD-Core Version:    0.7.0.1
 */