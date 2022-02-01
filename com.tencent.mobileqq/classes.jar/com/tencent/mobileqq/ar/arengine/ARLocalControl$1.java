package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.qphone.base.util.QLog;

class ARLocalControl$1
  implements Runnable
{
  ARLocalControl$1(ARLocalControl paramARLocalControl, int paramInt1, int paramInt2, Context paramContext, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, long paramLong) {}
  
  public void run()
  {
    if ((ARLocalControl.a(this.this$0) & 0x4) != 0L)
    {
      ??? = new ARFacePreviewResample();
      ((ARFacePreviewResample)???).a(this.jdField_a_of_type_Int, this.b, 17);
      int i = ((ARFacePreviewResample)???).a();
      int j = ((ARFacePreviewResample)???).b();
      this.this$0.a = new ARLocalFaceRecog();
      this.this$0.a.a((ARFacePreviewResample)???);
      if (!this.this$0.a.a(this.jdField_a_of_type_AndroidContentContext, i, j, this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo, this.this$0)) {
        this.this$0.a = null;
      }
    }
    synchronized (ARLocalControl.a())
    {
      ARLocalControl.a(this.this$0, true);
      ARLocalControl.a().notifyAll();
      QLog.i("AREngine_ARLocalControl", 1, String.format("initFaceRecogAsync end. time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalControl.1
 * JD-Core Version:    0.7.0.1
 */