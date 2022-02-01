package com.tencent.mobileqq.bubble;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class BubbleConfig
{
  public double a;
  public int a;
  public AnimationConfig a;
  @Deprecated
  public DiyBubbleConfig.DiyBubblePasterConfig a;
  public String a;
  public ArrayList<AnimationConfig> a;
  public HashMap<String, DiyBubbleConfig> a;
  public HashSet<String> a;
  public boolean a;
  public int[] a;
  public int b;
  public AnimationConfig b;
  public ArrayList<Integer> b;
  public HashMap<String, BubbleNewAnimConf> b;
  public boolean b;
  public int c;
  public AnimationConfig c;
  public ArrayList<String> c = null;
  public int d;
  public AnimationConfig d;
  public int e = 0;
  public AnimationConfig e;
  public int f = -1;
  public AnimationConfig f;
  public int g = 2;
  
  public BubbleConfig(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private boolean a(File paramFile, String paramString)
  {
    paramFile = new File(paramFile, paramString);
    boolean bool3 = paramFile.exists();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.list();
        bool1 = bool2;
        if (paramFile != null)
        {
          bool1 = bool2;
          if (paramFile.length > 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int a()
  {
    if (a()) {
      return ((Integer)this.jdField_b_of_type_JavaUtilArrayList.get(this.e)).intValue();
    }
    return -1;
  }
  
  public void a()
  {
    if (a())
    {
      this.e = ((this.e + 1) % this.jdField_b_of_type_JavaUtilArrayList.size());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("now change bubble sub id: ");
        localStringBuilder.append(this.jdField_b_of_type_JavaUtilArrayList.get(this.e));
        QLog.i("BubbleConfig", 2, localStringBuilder.toString());
      }
    }
    else
    {
      this.e = 0;
    }
  }
  
  public boolean a()
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public boolean a(int paramInt)
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    return (localArrayList != null) && (localArrayList.contains(Integer.valueOf(paramInt)));
  }
  
  public boolean a(File paramFile)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      if (a(paramFile, (String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if ((this.c != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        if (paramString.indexOf(((String)localIterator.next()).toLowerCase()) != -1) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ bubbleId=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuffer.append(",");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuffer.append(" ]");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleConfig
 * JD-Core Version:    0.7.0.1
 */