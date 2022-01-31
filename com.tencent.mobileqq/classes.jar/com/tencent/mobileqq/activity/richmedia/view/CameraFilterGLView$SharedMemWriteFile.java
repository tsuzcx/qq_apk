package com.tencent.mobileqq.activity.richmedia.view;

import android.os.SystemClock;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwFrame;
import com.tencent.mobileqq.shortvideo.mediadevice.FilterPreviewContext;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.SVFilterEncodeDoubleCache;
import com.tencent.mobileqq.shortvideo.util.SVFilterEncodeDoubleCache.SharedMemoryCache;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicReference;

public class CameraFilterGLView$SharedMemWriteFile
  implements Runnable
{
  public int a;
  public AVIOStruct a;
  public CameraFilterGLView.CameraGlFilterListener a;
  public FilterPreviewContext a;
  public SVFilterEncodeDoubleCache.SharedMemoryCache a;
  public SVFilterEncodeDoubleCache a;
  public AtomicReference a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public int d;
  
  public void run()
  {
    SystemClock.uptimeMillis();
    QLog.d("PtvFilterUtils", 4, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]frameIndex=" + this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.pFrameIndex);
    int i = PtvFilterUtils.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 4, true, false, this.c, this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.d);
    SVHwEncoder localSVHwEncoder = (SVHwEncoder)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
    if (localSVHwEncoder != null)
    {
      SVHwEncoder.HwFrame localHwFrame = localSVHwEncoder.a();
      if (localHwFrame == null) {
        break label235;
      }
      localHwFrame.jdField_a_of_type_Int = 0;
      localHwFrame.jdField_a_of_type_Boolean = false;
      localHwFrame.jdField_b_of_type_Boolean = true;
      localHwFrame.jdField_b_of_type_Int = localHwFrame.jdField_a_of_type_ArrayOfByte.length;
      localHwFrame.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime;
      if (PtvFilterUtils.a(localHwFrame.jdField_a_of_type_ArrayOfByte) == 0) {
        localSVHwEncoder.a(localHwFrame, true);
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
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache.a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext.b();
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null)) {}
      return;
      label235:
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(null);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.SharedMemWriteFile
 * JD-Core Version:    0.7.0.1
 */