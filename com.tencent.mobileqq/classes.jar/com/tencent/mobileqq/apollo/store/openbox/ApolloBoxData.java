package com.tencent.mobileqq.apollo.store.openbox;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ApolloBoxData
{
  public int a;
  public long a;
  public String a;
  public final HashMap<Integer, ApolloBoxData.BoxCardListSummary> a;
  public final List<ApolloBoxData.BoxCardListSummary> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public List<ApolloBoxData.ApolloBoxDataItem> b;
  public long c;
  public String c;
  public List<ApolloBoxData.ApolloBoxDataItem> c;
  public String d;
  public String e;
  
  public ApolloBoxData()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static String a(int paramInt)
  {
    if (paramInt > 999999) {
      return String.valueOf(999999) + "+";
    }
    return String.valueOf(paramInt);
  }
  
  public static String b(int paramInt)
  {
    if (paramInt > 99999) {
      return String.valueOf(99999) + "+";
    }
    return String.valueOf(paramInt);
  }
  
  public static String c(int paramInt)
  {
    if (paramInt > 9999) {
      return String.valueOf(9999) + "+";
    }
    return String.valueOf(paramInt);
  }
  
  public void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    label40:
    ApolloBoxData.ApolloBoxDataItem localApolloBoxDataItem;
    ApolloBoxData.BoxCardListSummary localBoxCardListSummary;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localApolloBoxDataItem = (ApolloBoxData.ApolloBoxDataItem)localIterator.next();
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(String.valueOf(localApolloBoxDataItem.jdField_a_of_type_Long))))
        {
          if (localApolloBoxDataItem.jdField_a_of_type_Short > 4) {
            break label165;
          }
          localBoxCardListSummary = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3));
          if (localBoxCardListSummary != null)
          {
            localBoxCardListSummary.c += 1;
            this.jdField_b_of_type_Int += 1;
          }
        }
      }
    }
    for (;;)
    {
      if (this.c == null) {
        this.c = new ArrayList();
      }
      this.c.add(localApolloBoxDataItem);
      break label40;
      break;
      label165:
      localBoxCardListSummary = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_JavaUtilHashMap.get(Short.valueOf(localApolloBoxDataItem.jdField_a_of_type_Short));
      if (localBoxCardListSummary != null)
      {
        localBoxCardListSummary.c += localApolloBoxDataItem.f;
        this.jdField_b_of_type_Int += localApolloBoxDataItem.f;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloBoxData
 * JD-Core Version:    0.7.0.1
 */