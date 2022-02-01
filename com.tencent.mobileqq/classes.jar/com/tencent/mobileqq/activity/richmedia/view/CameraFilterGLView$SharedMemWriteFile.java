package com.tencent.mobileqq.activity.richmedia.view;

import akwt;
import android.os.SystemClock;
import bbtv;
import bbux;
import bbxm;
import bbxn;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicReference;

public class CameraFilterGLView$SharedMemWriteFile
  implements Runnable
{
  public int a;
  public akwt a;
  public bbux a;
  public bbxm a;
  public bbxn a;
  public AVIOStruct a;
  public AtomicReference<SVHwEncoder> a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public int d;
  
  public void run()
  {
    SystemClock.uptimeMillis();
    QLog.d("PtvFilterUtils", 4, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]frameIndex=" + this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.pFrameIndex);
    int i = PtvFilterUtils.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 4, true, false, this.c, this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, this.jdField_a_of_type_Bbxn.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.d);
    SVHwEncoder localSVHwEncoder = (SVHwEncoder)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
    if (localSVHwEncoder != null)
    {
      bbtv localbbtv = localSVHwEncoder.a();
      if (localbbtv == null) {
        break label235;
      }
      localbbtv.jdField_a_of_type_Int = 0;
      localbbtv.jdField_a_of_type_Boolean = false;
      localbbtv.jdField_b_of_type_Boolean = true;
      localbbtv.jdField_b_of_type_Int = localbbtv.jdField_a_of_type_ArrayOfByte.length;
      localbbtv.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime;
      if (PtvFilterUtils.a(localbbtv.jdField_a_of_type_ArrayOfByte) == 0) {
        localSVHwEncoder.a(localbbtv, true);
      }
    }
    if (i == 0) {
      i = PtvFilterUtils.a(this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct);
    }
    for (;;)
    {
      if ((i != 0) && (QLog.isColorLevel())) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]err=" + i);
      }
      this.jdField_a_of_type_Bbxn.a();
      this.jdField_a_of_type_Bbux.b();
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bbxm.a()) && (this.jdField_a_of_type_Akwt != null)) {}
      return;
      label235:
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(null);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.SharedMemWriteFile
 * JD-Core Version:    0.7.0.1
 */