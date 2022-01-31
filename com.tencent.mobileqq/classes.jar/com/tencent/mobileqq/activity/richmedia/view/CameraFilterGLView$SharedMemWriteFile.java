package com.tencent.mobileqq.activity.richmedia.view;

import aiak;
import android.os.SystemClock;
import axhj;
import axin;
import axli;
import axlj;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicReference;

public class CameraFilterGLView$SharedMemWriteFile
  implements Runnable
{
  public int a;
  public aiak a;
  public axin a;
  public axli a;
  public axlj a;
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
    int i = PtvFilterUtils.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 4, true, false, this.c, this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, this.jdField_a_of_type_Axlj.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.d);
    SVHwEncoder localSVHwEncoder = (SVHwEncoder)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
    if (localSVHwEncoder != null)
    {
      axhj localaxhj = localSVHwEncoder.a();
      if (localaxhj == null) {
        break label235;
      }
      localaxhj.jdField_a_of_type_Int = 0;
      localaxhj.jdField_a_of_type_Boolean = false;
      localaxhj.jdField_b_of_type_Boolean = true;
      localaxhj.jdField_b_of_type_Int = localaxhj.jdField_a_of_type_ArrayOfByte.length;
      localaxhj.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime;
      if (PtvFilterUtils.a(localaxhj.jdField_a_of_type_ArrayOfByte) == 0) {
        localSVHwEncoder.a(localaxhj, true);
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
      this.jdField_a_of_type_Axlj.a();
      this.jdField_a_of_type_Axin.b();
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Axli.a()) && (this.jdField_a_of_type_Aiak != null)) {}
      return;
      label235:
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(null);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.SharedMemWriteFile
 * JD-Core Version:    0.7.0.1
 */