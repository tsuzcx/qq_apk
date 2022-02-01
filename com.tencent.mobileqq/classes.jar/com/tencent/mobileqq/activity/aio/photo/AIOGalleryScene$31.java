package com.tencent.mobileqq.activity.aio.photo;

import aibo;
import aibr;
import aicx;
import aidw;
import aidz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.util.Iterator;
import java.util.List;

public class AIOGalleryScene$31
  implements Runnable
{
  public AIOGalleryScene$31(aibr paramaibr, long paramLong, aidw paramaidw, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    int i;
    boolean bool;
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_Aidw.a.jdField_f_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      i = this.this$0.jdField_a_of_type_Aidz.a(this.jdField_a_of_type_Aidw.a.jdField_f_of_type_Long, this.jdField_a_of_type_Aidw.a.jdField_f_of_type_Int);
      if ((i >= 0) && (i < 100))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "onRevokeMsg isSaving:" + bool);
        }
        aibr.a(this.this$0, this.jdField_a_of_type_Aidw, bool);
        aibo.a(aibr.O(this.this$0), aibr.b(this.this$0));
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
        if (this.this$0.jdField_a_of_type_Aicx.a(this.jdField_a_of_type_Long) != null) {
          break label208;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AIOGalleryScene", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_Aidw.a.jdField_f_of_type_Long);
      return;
      List localList = this.this$0.jdField_a_of_type_Aicx.a();
      Iterator localIterator = localList.iterator();
      aidw localaidw;
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localaidw = (aidw)localIterator.next();
      } while (localaidw.a.jdField_f_of_type_Long != this.jdField_a_of_type_Aidw.a.jdField_f_of_type_Long);
      i = localList.indexOf(localaidw);
    } while (i < 0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
    aibr.e(this.this$0).setSelection(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.31
 * JD-Core Version:    0.7.0.1
 */