package com.tencent.mobileqq.activity.aio.photo;

import advs;
import advv;
import adxf;
import adyb;
import adye;
import agez;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.util.Iterator;
import java.util.List;

public class AIOGalleryScene$28
  implements Runnable
{
  public AIOGalleryScene$28(advv paramadvv, long paramLong, adyb paramadyb, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    boolean bool2 = false;
    int i;
    boolean bool1;
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_Adyb.a.jdField_f_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      i = this.this$0.jdField_a_of_type_Adye.a(this.jdField_a_of_type_Adyb.a.jdField_f_of_type_Long, this.jdField_a_of_type_Adyb.a.jdField_f_of_type_Int);
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
      if ((this.jdField_a_of_type_Adyb.a instanceof AIOFileVideoData))
      {
        if ((this.this$0.jdField_a_of_type_Agez != null) && (this.this$0.jdField_a_of_type_Agez.c())) {
          this.this$0.jdField_a_of_type_Agez.h();
        }
        advs.a(advv.an(this.this$0), advv.b(this.this$0));
      }
    }
    label498:
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_Adyb.a instanceof AIOShortVideoData))
        {
          localObject1 = (AIOShortVideoData)this.jdField_a_of_type_Adyb.a;
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
              this.this$0.jdField_a_of_type_Adye.b(((AIOShortVideoData)localObject1).jdField_f_of_type_Long, ((AIOShortVideoData)localObject1).jdField_f_of_type_Int, 256);
            }
            if ((this.this$0.jdField_a_of_type_Agez == null) || (!this.this$0.jdField_a_of_type_Agez.c())) {
              break;
            }
            this.this$0.jdField_a_of_type_Agez.h();
            break;
          }
          if (((AIOShortVideoData)localObject1).b != 1) {
            break;
          }
          localObject1 = advv.a(this.this$0);
          if (localObject1 == null) {
            break;
          }
          localObject2 = ((AIOGalleryAdapter.GalleryImageStruct)localObject1).a();
          if (!(localObject2 instanceof URLDrawable)) {
            break;
          }
          i = ((URLDrawable)localObject2).getPlayState();
          j = this.this$0.jdField_a_of_type_Adxf.b();
          if (i != 2) {
            break;
          }
          ((AIOGalleryAdapter.GalleryImageStruct)localObject1).b(j);
          break;
        }
        if ((!(this.jdField_a_of_type_Adyb.a instanceof AIOImageData)) || (!bool1)) {
          break;
        }
        this.this$0.jdField_a_of_type_Adye.b(this.jdField_a_of_type_Adyb.a.jdField_f_of_type_Long, this.jdField_a_of_type_Adyb.a.jdField_f_of_type_Int, 24);
        break;
        if (this.this$0.jdField_a_of_type_Adxf.a(this.jdField_a_of_type_Long) != null) {
          break label498;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AIOGalleryScene", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_Adyb.a.jdField_f_of_type_Long);
      return;
      Object localObject1 = this.this$0.jdField_a_of_type_Adxf.a();
      Object localObject2 = ((List)localObject1).iterator();
      adyb localadyb;
      do
      {
        i = j;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localadyb = (adyb)((Iterator)localObject2).next();
      } while (localadyb.a.jdField_f_of_type_Long != this.jdField_a_of_type_Adyb.a.jdField_f_of_type_Long);
      i = ((List)localObject1).indexOf(localadyb);
    } while (i < 0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
    advv.e(this.this$0).setSelection(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.28
 * JD-Core Version:    0.7.0.1
 */