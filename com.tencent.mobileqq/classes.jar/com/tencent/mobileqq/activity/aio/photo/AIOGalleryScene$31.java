package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.util.Iterator;
import java.util.List;

class AIOGalleryScene$31
  implements Runnable
{
  AIOGalleryScene$31(AIOGalleryScene paramAIOGalleryScene, long paramLong, AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    int i;
    boolean bool;
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      i = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Int);
      if ((i >= 0) && (i < 100))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "onRevokeMsg isSaving:" + bool);
        }
        AIOGalleryScene.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo, bool);
        AIOGalleryMsgRevokeMgr.a(AIOGalleryScene.O(this.this$0), AIOGalleryScene.b(this.this$0));
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
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(this.jdField_a_of_type_Long) != null) {
          break label208;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AIOGalleryScene", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Long);
      return;
      List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      Iterator localIterator = localList.iterator();
      AIORichMediaInfo localAIORichMediaInfo;
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
      } while (localAIORichMediaInfo.a.jdField_f_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Long);
      i = localList.indexOf(localAIORichMediaInfo);
    } while (i < 0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
    AIOGalleryScene.e(this.this$0).setSelection(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.31
 * JD-Core Version:    0.7.0.1
 */