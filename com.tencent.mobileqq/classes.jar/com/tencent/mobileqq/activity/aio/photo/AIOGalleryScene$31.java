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
    long l1 = this.jdField_a_of_type_Long;
    long l2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Long;
    boolean bool = true;
    int j = 0;
    Object localObject;
    int i;
    if ((l1 != l2) && (!this.jdField_a_of_type_Boolean))
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(this.jdField_a_of_type_Long) == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onRevokeMsg seq:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
          ((StringBuilder)localObject).append(", selectItem seq:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Long);
          QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      Iterator localIterator = ((List)localObject).iterator();
      AIORichMediaInfo localAIORichMediaInfo;
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
      } while (localAIORichMediaInfo.a.jdField_f_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Long);
      i = ((List)localObject).indexOf(localAIORichMediaInfo);
      if (i >= 0)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
        AIOGalleryScene.e(this.this$0).setSelection(i);
      }
    }
    else
    {
      i = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.a.jdField_f_of_type_Int);
      if ((i < 0) || (i >= 100)) {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRevokeMsg isSaving:");
        ((StringBuilder)localObject).append(bool);
        QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
      }
      AIOGalleryScene.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo, bool);
      AIOGalleryMsgRevokeMgr.a(AIOGalleryScene.I(this.this$0), AIOGalleryScene.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.31
 * JD-Core Version:    0.7.0.1
 */