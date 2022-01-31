package com.tencent.mobileqq.activity.aio.photo;

import aegp;
import aegs;
import aeic;
import aeiy;
import aejb;
import agqv;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.util.Iterator;
import java.util.List;

public class AIOGalleryScene$28
  implements Runnable
{
  public AIOGalleryScene$28(aegs paramaegs, long paramLong, aeiy paramaeiy, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    boolean bool2 = false;
    int i;
    boolean bool1;
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_Aeiy.a.jdField_f_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      i = this.this$0.jdField_a_of_type_Aejb.a(this.jdField_a_of_type_Aeiy.a.jdField_f_of_type_Long, this.jdField_a_of_type_Aeiy.a.jdField_f_of_type_Int);
      bool1 = bool2;
      if (i >= 0)
      {
        bool1 = bool2;
        if (i < 100) {
          bool1 = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "onRevokeMsg isSaving:" + bool1);
      }
      if ((this.jdField_a_of_type_Aeiy.a instanceof AIOFileVideoData))
      {
        if ((this.this$0.jdField_a_of_type_Agqv != null) && (this.this$0.jdField_a_of_type_Agqv.c())) {
          this.this$0.jdField_a_of_type_Agqv.h();
        }
        aegp.a(aegs.an(this.this$0), aegs.b(this.this$0));
      }
    }
    label498:
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_Aeiy.a instanceof AIOShortVideoData))
        {
          localObject1 = (AIOShortVideoData)this.jdField_a_of_type_Aeiy.a;
          if (((AIOShortVideoData)localObject1).b == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AIOGalleryScene", 2, "onRevokeMsg BUSI_TYPE_VIDEO");
            }
            if (bool1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AIOGalleryScene", 2, "onRevokeMsg cancelDownloadMedia");
              }
              this.this$0.jdField_a_of_type_Aejb.b(((AIOShortVideoData)localObject1).jdField_f_of_type_Long, ((AIOShortVideoData)localObject1).jdField_f_of_type_Int, 256);
            }
            if ((this.this$0.jdField_a_of_type_Agqv == null) || (!this.this$0.jdField_a_of_type_Agqv.c())) {
              break;
            }
            this.this$0.jdField_a_of_type_Agqv.h();
            break;
          }
          if (((AIOShortVideoData)localObject1).b != 1) {
            break;
          }
          localObject1 = aegs.a(this.this$0);
          if (localObject1 == null) {
            break;
          }
          localObject2 = ((AIOGalleryAdapter.GalleryImageStruct)localObject1).a();
          if (!(localObject2 instanceof URLDrawable)) {
            break;
          }
          i = ((URLDrawable)localObject2).getPlayState();
          j = this.this$0.jdField_a_of_type_Aeic.b();
          if (i != 2) {
            break;
          }
          ((AIOGalleryAdapter.GalleryImageStruct)localObject1).b(j);
          break;
        }
        if ((!(this.jdField_a_of_type_Aeiy.a instanceof AIOImageData)) || (!bool1)) {
          break;
        }
        this.this$0.jdField_a_of_type_Aejb.b(this.jdField_a_of_type_Aeiy.a.jdField_f_of_type_Long, this.jdField_a_of_type_Aeiy.a.jdField_f_of_type_Int, 24);
        break;
        if (this.this$0.jdField_a_of_type_Aeic.a(this.jdField_a_of_type_Long) != null) {
          break label498;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AIOGalleryScene", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_Aeiy.a.jdField_f_of_type_Long);
      return;
      Object localObject1 = this.this$0.jdField_a_of_type_Aeic.a();
      Object localObject2 = ((List)localObject1).iterator();
      aeiy localaeiy;
      do
      {
        i = j;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localaeiy = (aeiy)((Iterator)localObject2).next();
      } while (localaeiy.a.jdField_f_of_type_Long != this.jdField_a_of_type_Aeiy.a.jdField_f_of_type_Long);
      i = ((List)localObject1).indexOf(localaeiy);
    } while (i < 0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
    aegs.e(this.this$0).setSelection(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.28
 * JD-Core Version:    0.7.0.1
 */