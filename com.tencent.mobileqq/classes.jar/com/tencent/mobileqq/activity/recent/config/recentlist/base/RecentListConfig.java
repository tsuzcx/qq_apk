package com.tencent.mobileqq.activity.recent.config.recentlist.base;

import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentCheckFilterProcessor;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentConvertFilterProcessor;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentDataConvertProcessor;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentSortTopProcessor;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentSortValueProcessor;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentCheckFilterDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentConvertFilterDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentDataConvertDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentSortTopDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentSortValueDispatcher;
import com.tencent.mobileqq.imcore.config.extension.RecentCustomizedProcessorRegister;
import java.util.Iterator;
import java.util.List;

public class RecentListConfig
{
  protected static volatile RecentCheckFilterDispatcher a;
  protected static volatile RecentConvertFilterDispatcher a;
  protected static volatile RecentDataConvertDispatcher a;
  protected static volatile RecentSortTopDispatcher a;
  protected static volatile RecentSortValueDispatcher a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static List<Class<? extends IRecentListBaseProcessor>> jdField_a_of_type_JavaUtilList;
  private static final Object b = new Object();
  private static final Object c = new Object();
  private static final Object d = new Object();
  private static final Object e = new Object();
  private static final Object f = new Object();
  
  public static RecentCheckFilterDispatcher a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentCheckFilterDispatcher == null)
    {
      synchronized (b)
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentCheckFilterDispatcher != null) {
          break label86;
        }
        jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentCheckFilterDispatcher = new RecentCheckFilterDispatcher();
        Iterator localIterator = a().iterator();
        while (localIterator.hasNext())
        {
          Class localClass = (Class)localIterator.next();
          if (IRecentCheckFilterProcessor.class.isAssignableFrom(localClass)) {
            jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentCheckFilterDispatcher.a(localClass);
          }
        }
      }
      jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentCheckFilterDispatcher.a();
    }
    label86:
    return jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentCheckFilterDispatcher;
  }
  
  public static RecentConvertFilterDispatcher a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentConvertFilterDispatcher == null)
    {
      synchronized (f)
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentConvertFilterDispatcher != null) {
          break label86;
        }
        jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentConvertFilterDispatcher = new RecentConvertFilterDispatcher();
        Iterator localIterator = a().iterator();
        while (localIterator.hasNext())
        {
          Class localClass = (Class)localIterator.next();
          if (IRecentConvertFilterProcessor.class.isAssignableFrom(localClass)) {
            jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentConvertFilterDispatcher.a(localClass);
          }
        }
      }
      jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentConvertFilterDispatcher.a();
    }
    label86:
    return jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentConvertFilterDispatcher;
  }
  
  public static RecentDataConvertDispatcher a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentDataConvertDispatcher == null)
    {
      synchronized (c)
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentDataConvertDispatcher != null) {
          break label86;
        }
        jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentDataConvertDispatcher = new RecentDataConvertDispatcher();
        Iterator localIterator = a().iterator();
        while (localIterator.hasNext())
        {
          Class localClass = (Class)localIterator.next();
          if (IRecentDataConvertProcessor.class.isAssignableFrom(localClass)) {
            jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentDataConvertDispatcher.a(localClass);
          }
        }
      }
      jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentDataConvertDispatcher.a();
    }
    label86:
    return jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentDataConvertDispatcher;
  }
  
  public static RecentSortTopDispatcher a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentSortTopDispatcher == null)
    {
      synchronized (d)
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentSortTopDispatcher != null) {
          break label86;
        }
        jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentSortTopDispatcher = new RecentSortTopDispatcher();
        Iterator localIterator = a().iterator();
        while (localIterator.hasNext())
        {
          Class localClass = (Class)localIterator.next();
          if (IRecentSortTopProcessor.class.isAssignableFrom(localClass)) {
            jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentSortTopDispatcher.a(localClass);
          }
        }
      }
      jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentSortTopDispatcher.a();
    }
    label86:
    return jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentSortTopDispatcher;
  }
  
  public static RecentSortValueDispatcher a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentSortValueDispatcher == null)
    {
      synchronized (e)
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentSortValueDispatcher != null) {
          break label86;
        }
        jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentSortValueDispatcher = new RecentSortValueDispatcher();
        Iterator localIterator = a().iterator();
        while (localIterator.hasNext())
        {
          Class localClass = (Class)localIterator.next();
          if (IRecentSortValueProcessor.class.isAssignableFrom(localClass)) {
            jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentSortValueDispatcher.a(localClass);
          }
        }
      }
      jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentSortValueDispatcher.a();
    }
    label86:
    return jdField_a_of_type_ComTencentMobileqqActivityRecentConfigRecentlistRecentSortValueDispatcher;
  }
  
  private static List<Class<? extends IRecentListBaseProcessor>> a()
  {
    if (jdField_a_of_type_JavaUtilList == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilList == null) {
        jdField_a_of_type_JavaUtilList = RecentCustomizedProcessorRegister.c;
      }
      return jdField_a_of_type_JavaUtilList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.base.RecentListConfig
 * JD-Core Version:    0.7.0.1
 */