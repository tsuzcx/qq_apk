package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class PhotoListPanel$QueryMediaTask$2
  implements Runnable
{
  PhotoListPanel$QueryMediaTask$2(PhotoListPanel.QueryMediaTask paramQueryMediaTask, List paramList) {}
  
  public void run()
  {
    Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$QueryMediaTask.this$0.jdField_a_of_type_JavaUtilLinkedList.iterator();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$QueryMediaTask.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
    label135:
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)localIterator2.next();
          if (str.equals(localLocalMediaInfo.path))
          {
            localLocalMediaInfo.mChecked = true;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$QueryMediaTask.this$0.jdField_a_of_type_JavaUtilArrayList.add(localLocalMediaInfo.position);
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label135;
        }
        localIterator1.remove();
        break;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.QueryMediaTask.2
 * JD-Core Version:    0.7.0.1
 */