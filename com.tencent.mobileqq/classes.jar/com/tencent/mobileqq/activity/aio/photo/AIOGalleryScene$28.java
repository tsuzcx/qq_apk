package com.tencent.mobileqq.activity.aio.photo;

import aegr;
import aegu;
import aeie;
import aeja;
import aejd;
import agqx;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.util.Iterator;
import java.util.List;

public class AIOGalleryScene$28
  implements Runnable
{
  public AIOGalleryScene$28(aegu paramaegu, long paramLong, aeja paramaeja, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    boolean bool2 = false;
    int i;
    boolean bool1;
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_Aeja.a.jdField_f_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      i = this.this$0.jdField_a_of_type_Aejd.a(this.jdField_a_of_type_Aeja.a.jdField_f_of_type_Long, this.jdField_a_of_type_Aeja.a.jdField_f_of_type_Int);
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
      if ((this.jdField_a_of_type_Aeja.a instanceof AIOFileVideoData))
      {
        if ((this.this$0.jdField_a_of_type_Agqx != null) && (this.this$0.jdField_a_of_type_Agqx.c())) {
          this.this$0.jdField_a_of_type_Agqx.h();
        }
        aegr.a(aegu.an(this.this$0), aegu.b(this.this$0));
      }
    }
    label498:
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_Aeja.a instanceof AIOShortVideoData))
        {
          localObject1 = (AIOShortVideoData)this.jdField_a_of_type_Aeja.a;
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
              this.this$0.jdField_a_of_type_Aejd.b(((AIOShortVideoData)localObject1).jdField_f_of_type_Long, ((AIOShortVideoData)localObject1).jdField_f_of_type_Int, 256);
            }
            if ((this.this$0.jdField_a_of_type_Agqx == null) || (!this.this$0.jdField_a_of_type_Agqx.c())) {
              break;
            }
            this.this$0.jdField_a_of_type_Agqx.h();
            break;
          }
          if (((AIOShortVideoData)localObject1).b != 1) {
            break;
          }
          localObject1 = aegu.a(this.this$0);
          if (localObject1 == null) {
            break;
          }
          localObject2 = ((AIOGalleryAdapter.GalleryImageStruct)localObject1).a();
          if (!(localObject2 instanceof URLDrawable)) {
            break;
          }
          i = ((URLDrawable)localObject2).getPlayState();
          j = this.this$0.jdField_a_of_type_Aeie.b();
          if (i != 2) {
            break;
          }
          ((AIOGalleryAdapter.GalleryImageStruct)localObject1).b(j);
          break;
        }
        if ((!(this.jdField_a_of_type_Aeja.a instanceof AIOImageData)) || (!bool1)) {
          break;
        }
        this.this$0.jdField_a_of_type_Aejd.b(this.jdField_a_of_type_Aeja.a.jdField_f_of_type_Long, this.jdField_a_of_type_Aeja.a.jdField_f_of_type_Int, 24);
        break;
        if (this.this$0.jdField_a_of_type_Aeie.a(this.jdField_a_of_type_Long) != null) {
          break label498;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AIOGalleryScene", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_Aeja.a.jdField_f_of_type_Long);
      return;
      Object localObject1 = this.this$0.jdField_a_of_type_Aeie.a();
      Object localObject2 = ((List)localObject1).iterator();
      aeja localaeja;
      do
      {
        i = j;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localaeja = (aeja)((Iterator)localObject2).next();
      } while (localaeja.a.jdField_f_of_type_Long != this.jdField_a_of_type_Aeja.a.jdField_f_of_type_Long);
      i = ((List)localObject1).indexOf(localaeja);
    } while (i < 0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
    aegu.e(this.this$0).setSelection(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.28
 * JD-Core Version:    0.7.0.1
 */