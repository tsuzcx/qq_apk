package com.tencent.mobileqq.apollo.api.aio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CmShowAioMatcher
{
  private static volatile CmShowAioMatcher jdField_a_of_type_ComTencentMobileqqApolloApiAioCmShowAioMatcher;
  private final Map<Integer, CmShowAioMatcher.AioSupported> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final Map<Integer, CmShowAioMatcher.AioSupported> b = new HashMap();
  private final Map<Integer, CmShowAioMatcher.AioSupported> c = new HashMap();
  
  private CmShowAioMatcher()
  {
    a();
  }
  
  public static CmShowAioMatcher.AioSupported a(int paramInt)
  {
    return a(paramInt, 0);
  }
  
  public static CmShowAioMatcher.AioSupported a(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return null;
    case 0: 
      return (CmShowAioMatcher.AioSupported)a().c.get(Integer.valueOf(paramInt1));
    case 1: 
      return (CmShowAioMatcher.AioSupported)a().b.get(Integer.valueOf(paramInt1));
    }
    return (CmShowAioMatcher.AioSupported)a().jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
  }
  
  public static CmShowAioMatcher a()
  {
    if (jdField_a_of_type_ComTencentMobileqqApolloApiAioCmShowAioMatcher == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloApiAioCmShowAioMatcher == null) {
        jdField_a_of_type_ComTencentMobileqqApolloApiAioCmShowAioMatcher = new CmShowAioMatcher();
      }
      return jdField_a_of_type_ComTencentMobileqqApolloApiAioCmShowAioMatcher;
    }
    finally {}
  }
  
  private void a()
  {
    b();
    c();
    Iterator localIterator = this.b.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      this.c.put(localEntry.getKey(), localEntry.getValue());
    }
    localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      this.c.put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public static boolean a(int paramInt)
  {
    return a(paramInt, 0);
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return false;
    case 0: 
      return a().c.containsKey(Integer.valueOf(paramInt1));
    case 1: 
      return a().b.containsKey(Integer.valueOf(paramInt1));
    }
    return a().jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt1));
  }
  
  private void b()
  {
    this.b.put(Integer.valueOf(0), new CmShowAioMatcher.1(this));
    this.b.put(Integer.valueOf(1000), new CmShowAioMatcher.2(this));
    this.b.put(Integer.valueOf(1045), new CmShowAioMatcher.3(this));
    this.b.put(Integer.valueOf(1044), new CmShowAioMatcher.4(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), new CmShowAioMatcher.5(this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3000), new CmShowAioMatcher.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher
 * JD-Core Version:    0.7.0.1
 */