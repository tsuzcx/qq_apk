package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RMVideoThumbGenMgr
{
  RMVideoThumbGenMgr.ThumbGenItem jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<RMVideoThumbGenMgr.ThumbGenItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  int a(RMVideoThumbGenMgr.ThumbGenItem paramThumbGenItem, boolean paramBoolean)
  {
    if (paramThumbGenItem == null) {
      return 1;
    }
    paramThumbGenItem.jdField_a_of_type_Boolean = true;
    int i = paramThumbGenItem.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(7);
    if ((i == 3) && (paramThumbGenItem.c != null) && (paramBoolean))
    {
      FileUtils.deleteFile(paramThumbGenItem.c);
      paramThumbGenItem.c = null;
      return i;
    }
    if ((i == 6) && (paramThumbGenItem.jdField_b_of_type_JavaLangString != null))
    {
      FileUtils.deleteFile(paramThumbGenItem.jdField_b_of_type_JavaLangString);
      paramThumbGenItem.jdField_b_of_type_JavaLangString = null;
    }
    return i;
  }
  
  public RMVideoThumbGenMgr.ThumbGenItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr$ThumbGenItem;
  }
  
  void a()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          RMVideoThumbGenMgr.ThumbGenItem localThumbGenItem = (RMVideoThumbGenMgr.ThumbGenItem)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          this.jdField_a_of_type_JavaUtilArrayList.remove(0);
          if ((localThumbGenItem != null) && (a(localThumbGenItem, localThumbGenItem.jdField_b_of_type_Boolean) == 2)) {
            synchronized (this.jdField_a_of_type_JavaLangObject)
            {
              this.jdField_a_of_type_JavaUtilArrayList.add(localThumbGenItem);
              return;
            }
          }
          return;
        }
      }
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr
 * JD-Core Version:    0.7.0.1
 */