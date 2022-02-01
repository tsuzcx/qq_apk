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
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      int j = 0;
      Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
      LocalMediaInfo localLocalMediaInfo;
      do
      {
        i = j;
        if (!localIterator2.hasNext()) {
          break;
        }
        localLocalMediaInfo = (LocalMediaInfo)localIterator2.next();
      } while (!str.equals(localLocalMediaInfo.path));
      localLocalMediaInfo.mChecked = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$QueryMediaTask.this$0.jdField_a_of_type_JavaUtilArrayList.add(localLocalMediaInfo.position);
      int i = 1;
      if (i == 0) {
        localIterator1.remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.QueryMediaTask.2
 * JD-Core Version:    0.7.0.1
 */