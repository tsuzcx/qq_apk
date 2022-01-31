package com.tencent.mobileqq.activity.richmedia.view;

import ajwj;
import android.os.SystemClock;
import azgy;
import azic;
import azkx;
import azky;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicReference;

public class CameraFilterGLView$SharedMemWriteFile
  implements Runnable
{
  public int a;
  public ajwj a;
  public azic a;
  public azkx a;
  public azky a;
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
    int i = PtvFilterUtils.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 4, true, false, this.c, this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, this.jdField_a_of_type_Azky.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.d);
    SVHwEncoder localSVHwEncoder = (SVHwEncoder)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
    if (localSVHwEncoder != null)
    {
      azgy localazgy = localSVHwEncoder.a();
      if (localazgy == null) {
        break label235;
      }
      localazgy.jdField_a_of_type_Int = 0;
      localazgy.jdField_a_of_type_Boolean = false;
      localazgy.jdField_b_of_type_Boolean = true;
      localazgy.jdField_b_of_type_Int = localazgy.jdField_a_of_type_ArrayOfByte.length;
      localazgy.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime;
      if (PtvFilterUtils.a(localazgy.jdField_a_of_type_ArrayOfByte) == 0) {
        localSVHwEncoder.a(localazgy, true);
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
      this.jdField_a_of_type_Azky.a();
      this.jdField_a_of_type_Azic.b();
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Azkx.a()) && (this.jdField_a_of_type_Ajwj != null)) {}
      return;
      label235:
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(null);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.SharedMemWriteFile
 * JD-Core Version:    0.7.0.1
 */