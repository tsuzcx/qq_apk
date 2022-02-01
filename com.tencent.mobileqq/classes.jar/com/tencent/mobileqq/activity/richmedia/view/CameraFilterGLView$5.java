package com.tencent.mobileqq.activity.richmedia.view;

import alps;
import alup;
import aluq;
import alut;
import alvi;
import android.os.SystemClock;
import anvx;
import bdcg;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class CameraFilterGLView$5
  implements Runnable
{
  CameraFilterGLView$5(CameraFilterGLView paramCameraFilterGLView, AESticker paramAESticker, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, VideoMaterial paramVideoMaterial, boolean paramBoolean4, int paramInt, boolean paramBoolean5) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    this.this$0.a.a(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker, this.jdField_a_of_type_Boolean);
    this.this$0.a.c = this.b;
    label92:
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker != null) && (this.c))
    {
      this.this$0.a.a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.mEnableFaceDetect);
      if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker == null) || (!this.d)) {
        break label441;
      }
      this.this$0.a.b(true);
      l = (SystemClock.elapsedRealtime() - l) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_changeFilter=" + l / 1000.0D + "ms]");
      }
      if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker == null) {
        break label540;
      }
      if (!CameraFilterGLView.a(this.this$0).jdField_a_of_type_Boolean)
      {
        CameraFilterGLView.a(this.this$0).jdField_a_of_type_Boolean = true;
        if ((CameraFilterGLView.a(this.this$0) != null) && (this.c))
        {
          CameraFilterGLView.a(this.this$0).a(this.this$0.a.b, 0);
          localObject = this.this$0;
          if (this.this$0.a.b) {
            break label455;
          }
          bool = true;
          label236:
          CameraFilterGLView.a((CameraFilterGLView)localObject, bool);
        }
      }
      if (!CameraFilterGLView.a(this.this$0).jdField_a_of_type_Boolean)
      {
        CameraFilterGLView.a(this.this$0).jdField_a_of_type_Boolean = true;
        if ((CameraFilterGLView.a(this.this$0) != null) && (!CameraFilterGLView.a(this.this$0)) && (this.d))
        {
          CameraFilterGLView.a(this.this$0).a(this.this$0.a.f, 1);
          if (this.this$0.a.f == true) {
            CameraFilterGLView.a(this.this$0, false);
          }
        }
      }
      localObject = CameraFilterGLView.a(this.this$0, this.jdField_a_of_type_Int);
      if (localObject != null) {
        break label671;
      }
    }
    label397:
    label540:
    label671:
    for (boolean bool = false;; bool = true)
    {
      int i;
      if (CameraFilterGLView.a(this.this$0) != null)
      {
        String str = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.mGuideTips;
        if ((!this.b) || (alps.jdField_a_of_type_Int == 2)) {
          break label461;
        }
        i = 1;
        if ((str == null) || (str.length() == 0)) {
          break label466;
        }
        CameraFilterGLView.a(this.this$0).a(true, str, 2);
      }
      for (;;)
      {
        return;
        this.this$0.a.a(false);
        break;
        label441:
        this.this$0.a.b(false);
        break label92;
        label455:
        bool = false;
        break label236;
        label461:
        i = 0;
        break label397;
        label466:
        if ((i != 0) && (!this.e))
        {
          CameraFilterGLView.a(this.this$0).a(true, anvx.a(2131700815), 0);
          return;
        }
        if (this.e)
        {
          CameraFilterGLView.a(this.this$0).a(true, alvi.a(), 3);
          return;
        }
        CameraFilterGLView.a(this.this$0).a(bool, (String)localObject, 1);
        return;
        CameraFilterGLView.a(this.this$0).jdField_a_of_type_Boolean = false;
        CameraFilterGLView.a(this.this$0).jdField_a_of_type_Boolean = false;
        if ((CameraFilterGLView.a(this.this$0) != null) && (this.c))
        {
          CameraFilterGLView.a(this.this$0).a(true, 0);
          CameraFilterGLView.a(this.this$0, false);
        }
        while (CameraFilterGLView.a(this.this$0) != null)
        {
          CameraFilterGLView.a(this.this$0).a(false, null, -1);
          return;
          if ((CameraFilterGLView.a(this.this$0) != null) && (this.d))
          {
            CameraFilterGLView.a(this.this$0).a(true, 1);
            CameraFilterGLView.a(this.this$0, false);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.5
 * JD-Core Version:    0.7.0.1
 */