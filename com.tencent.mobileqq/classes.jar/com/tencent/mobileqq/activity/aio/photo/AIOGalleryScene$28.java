package com.tencent.mobileqq.activity.aio.photo;

import agdf;
import agdi;
import ages;
import agfq;
import agft;
import ailt;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.util.Iterator;
import java.util.List;

public class AIOGalleryScene$28
  implements Runnable
{
  public AIOGalleryScene$28(agdi paramagdi, long paramLong, agfq paramagfq, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    boolean bool2 = false;
    int i;
    boolean bool1;
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_Agfq.a.jdField_f_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      i = this.this$0.jdField_a_of_type_Agft.a(this.jdField_a_of_type_Agfq.a.jdField_f_of_type_Long, this.jdField_a_of_type_Agfq.a.jdField_f_of_type_Int);
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
      if ((this.jdField_a_of_type_Agfq.a instanceof AIOFileVideoData))
      {
        if ((this.this$0.jdField_a_of_type_Ailt != null) && (this.this$0.jdField_a_of_type_Ailt.c())) {
          this.this$0.jdField_a_of_type_Ailt.h();
        }
        agdf.a(agdi.an(this.this$0), agdi.b(this.this$0));
      }
    }
    label498:
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_Agfq.a instanceof AIOShortVideoData))
        {
          localObject1 = (AIOShortVideoData)this.jdField_a_of_type_Agfq.a;
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
              this.this$0.jdField_a_of_type_Agft.b(((AIOShortVideoData)localObject1).jdField_f_of_type_Long, ((AIOShortVideoData)localObject1).jdField_f_of_type_Int, 256);
            }
            if ((this.this$0.jdField_a_of_type_Ailt == null) || (!this.this$0.jdField_a_of_type_Ailt.c())) {
              break;
            }
            this.this$0.jdField_a_of_type_Ailt.h();
            break;
          }
          if (((AIOShortVideoData)localObject1).b != 1) {
            break;
          }
          localObject1 = agdi.a(this.this$0);
          if (localObject1 == null) {
            break;
          }
          localObject2 = ((AIOGalleryAdapter.GalleryImageStruct)localObject1).a();
          if (!(localObject2 instanceof URLDrawable)) {
            break;
          }
          i = ((URLDrawable)localObject2).getPlayState();
          j = this.this$0.jdField_a_of_type_Ages.b();
          if (i != 2) {
            break;
          }
          ((AIOGalleryAdapter.GalleryImageStruct)localObject1).b(j);
          break;
        }
        if ((!(this.jdField_a_of_type_Agfq.a instanceof AIOImageData)) || (!bool1)) {
          break;
        }
        this.this$0.jdField_a_of_type_Agft.b(this.jdField_a_of_type_Agfq.a.jdField_f_of_type_Long, this.jdField_a_of_type_Agfq.a.jdField_f_of_type_Int, 24);
        break;
        if (this.this$0.jdField_a_of_type_Ages.a(this.jdField_a_of_type_Long) != null) {
          break label498;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AIOGalleryScene", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_Agfq.a.jdField_f_of_type_Long);
      return;
      Object localObject1 = this.this$0.jdField_a_of_type_Ages.a();
      Object localObject2 = ((List)localObject1).iterator();
      agfq localagfq;
      do
      {
        i = j;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localagfq = (agfq)((Iterator)localObject2).next();
      } while (localagfq.a.jdField_f_of_type_Long != this.jdField_a_of_type_Agfq.a.jdField_f_of_type_Long);
      i = ((List)localObject1).indexOf(localagfq);
    } while (i < 0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
    agdi.e(this.this$0).setSelection(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.28
 * JD-Core Version:    0.7.0.1
 */