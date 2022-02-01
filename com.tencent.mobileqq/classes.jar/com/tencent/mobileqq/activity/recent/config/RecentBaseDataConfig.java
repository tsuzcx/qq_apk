package com.tencent.mobileqq.activity.recent.config;

import com.tencent.mobileqq.activity.recent.config.menu.AbsMenuFlag;
import com.tencent.mobileqq.activity.recent.config.menu.RecentMenuFlagDispatch;
import com.tencent.mobileqq.activity.recent.config.statusIcon.AbsRecentStatus;
import com.tencent.mobileqq.activity.recent.config.statusIcon.RecentStatusIconDispatch;
import com.tencent.mobileqq.imcore.config.extension.RecentCustomizedProcessorRegister;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentBaseDataConfig
{
  protected static RecentMenuFlagDispatch a;
  protected static RecentStatusIconDispatch a;
  private static final Object a;
  private static final Object b = new Object();
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static RecentMenuFlagDispatch a()
  {
    synchronized (b)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRecentConfigMenuRecentMenuFlagDispatch == null)
      {
        jdField_a_of_type_ComTencentMobileqqActivityRecentConfigMenuRecentMenuFlagDispatch = new RecentMenuFlagDispatch();
        Iterator localIterator = RecentCustomizedProcessorRegister.b.iterator();
        while (localIterator.hasNext())
        {
          Class localClass = (Class)localIterator.next();
          if ((localClass != null) && (AbsMenuFlag.class.isAssignableFrom(localClass))) {
            jdField_a_of_type_ComTencentMobileqqActivityRecentConfigMenuRecentMenuFlagDispatch.a(localClass);
          }
        }
        jdField_a_of_type_ComTencentMobileqqActivityRecentConfigMenuRecentMenuFlagDispatch.b();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityRecentConfigMenuRecentMenuFlagDispatch;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static RecentStatusIconDispatch a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRecentConfigStatusIconRecentStatusIconDispatch == null)
      {
        jdField_a_of_type_ComTencentMobileqqActivityRecentConfigStatusIconRecentStatusIconDispatch = new RecentStatusIconDispatch();
        Iterator localIterator = RecentCustomizedProcessorRegister.b.iterator();
        while (localIterator.hasNext())
        {
          Class localClass = (Class)localIterator.next();
          if ((localClass != null) && (AbsRecentStatus.class.isAssignableFrom(localClass))) {
            jdField_a_of_type_ComTencentMobileqqActivityRecentConfigStatusIconRecentStatusIconDispatch.a(localClass);
          }
        }
        jdField_a_of_type_ComTencentMobileqqActivityRecentConfigStatusIconRecentStatusIconDispatch.b();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityRecentConfigStatusIconRecentStatusIconDispatch;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.RecentBaseDataConfig
 * JD-Core Version:    0.7.0.1
 */