package com.tencent.mobileqq.apollo.task;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public class ApolloActionManager
{
  private static volatile ApolloActionManager jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager;
  public String a;
  public AtomicInteger a;
  private volatile ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  
  public ApolloActionManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public static ApolloActionManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager == null) {
        jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager = new ApolloActionManager();
      }
      ApolloActionManager localApolloActionManager = jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionManager;
      return localApolloActionManager;
    }
    finally {}
  }
  
  @NonNull
  public ReentrantLock a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloActionManager", 2, "[getLock].");
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloActionManager", 2, "create lock.");
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
      }
      ReentrantLock localReentrantLock = this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
      return localReentrantLock;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloActionManager
 * JD-Core Version:    0.7.0.1
 */