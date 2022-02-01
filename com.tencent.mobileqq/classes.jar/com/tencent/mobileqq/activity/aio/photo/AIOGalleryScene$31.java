package com.tencent.mobileqq.activity.aio.photo;

import agye;
import agyh;
import agzn;
import aham;
import ahap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.util.Iterator;
import java.util.List;

public class AIOGalleryScene$31
  implements Runnable
{
  public AIOGalleryScene$31(agyh paramagyh, long paramLong, aham paramaham, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    int i;
    boolean bool;
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_Aham.a.jdField_f_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      i = this.this$0.jdField_a_of_type_Ahap.a(this.jdField_a_of_type_Aham.a.jdField_f_of_type_Long, this.jdField_a_of_type_Aham.a.jdField_f_of_type_Int);
      if ((i >= 0) && (i < 100))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "onRevokeMsg isSaving:" + bool);
        }
        agyh.a(this.this$0, this.jdField_a_of_type_Aham, bool);
        agye.a(agyh.O(this.this$0), agyh.b(this.this$0));
      }
    }
    label208:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        if (this.this$0.jdField_a_of_type_Agzn.a(this.jdField_a_of_type_Long) != null) {
          break label208;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AIOGalleryScene", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_Aham.a.jdField_f_of_type_Long);
      return;
      List localList = this.this$0.jdField_a_of_type_Agzn.a();
      Iterator localIterator = localList.iterator();
      aham localaham;
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localaham = (aham)localIterator.next();
      } while (localaham.a.jdField_f_of_type_Long != this.jdField_a_of_type_Aham.a.jdField_f_of_type_Long);
      i = localList.indexOf(localaham);
    } while (i < 0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
    agyh.e(this.this$0).setSelection(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.31
 * JD-Core Version:    0.7.0.1
 */