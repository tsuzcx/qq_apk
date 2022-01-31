package com.tencent.mobileqq.armap;

import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.qphone.base.util.QLog;

class SupercellActivity$13$1$1
  implements Runnable
{
  SupercellActivity$13$1$1(SupercellActivity.13.1 param1) {}
  
  public void run()
  {
    JniCommon.nativeSuperCellSwitchMode(12);
    this.this$2.this$1.this$0.isFindSupercell = true;
    SupercellActivity.access$200(this.this$2.this$1.this$0).nativeSetCameraYUVTexture(SupercellActivity.access$200(this.this$2.this$1.this$0).mEngineHandler, -1, -1, SupercellActivity.access$2000(this.this$2.this$1.this$0).c);
    if (SupercellActivity.access$2300(this.this$2.this$1.this$0) == -1)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      SupercellActivity.access$2302(this.this$2.this$1.this$0, arrayOfInt[0]);
      if (SupercellActivity.access$2300(this.this$2.this$1.this$0) < 1) {
        SupercellActivity.access$2302(this.this$2.this$1.this$0, 10003);
      }
      GLES20.glBindTexture(3553, SupercellActivity.access$2300(this.this$2.this$1.this$0));
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
    }
    try
    {
      GLUtils.texImage2D(3553, 0, BitmapFactory.decodeFile(SupercellActivity.access$2400(this.this$2.this$1.this$0) + "/no_permission_bg@2x.jpg"), 0);
      SupercellActivity.access$200(this.this$2.this$1.this$0).nativeSetCameraBgTexture(SupercellActivity.access$600(this.this$2.this$1.this$0), SupercellActivity.access$2300(this.this$2.this$1.this$0));
      if (QLog.isColorLevel()) {
        QLog.i("SupercellActivity", 2, "onStartPreview no  :  mCameraBgTextureId bindtexture " + SupercellActivity.access$2300(this.this$2.this$1.this$0));
      }
      if (QLog.isColorLevel()) {
        QLog.i("SupercellActivity", 2, "onStartPreview no  :  mCameraBgTextureId  " + SupercellActivity.access$2300(this.this$2.this$1.this$0));
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localOutOfMemoryError.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.13.1.1
 * JD-Core Version:    0.7.0.1
 */