package com.tencent.av.ui;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.avcore.jni.render.GLRenderListener;
import com.tencent.qphone.base.util.QLog;

class GLVideoView$1
  implements GLRenderListener
{
  GLVideoView$1(GLVideoView paramGLVideoView, VideoAppInterface paramVideoAppInterface) {}
  
  public void onFaceFeatureUpdate(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      String str = this.jdField_a_of_type_ComTencentAvUiGLVideoView.c();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), str, paramArrayOfByte });
    }
  }
  
  public void onRenderFlush()
  {
    GLVideoView.c(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
  }
  
  public void onRenderFrame()
  {
    GLVideoView.a(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
  }
  
  public void onRenderInfoNotify(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = GLVideoView.a(paramInt4);
    if (QLog.isColorLevel()) {
      QLog.w(GLVideoView.a(this.jdField_a_of_type_ComTencentAvUiGLVideoView), 1, "onRenderInfoNotify, width[" + this.jdField_a_of_type_ComTencentAvUiGLVideoView.y + "->" + paramInt1 + "], height[" + this.jdField_a_of_type_ComTencentAvUiGLVideoView.z + "->" + paramInt2 + "], angle[" + this.jdField_a_of_type_ComTencentAvUiGLVideoView.x + "->" + paramInt3 + "], rotation[" + GLVideoView.a(this.jdField_a_of_type_ComTencentAvUiGLVideoView) + "->" + i + "], srcR[" + paramInt4 + "], isLocalView[" + this.jdField_a_of_type_ComTencentAvUiGLVideoView.c() + "]");
    }
    if ((!this.jdField_a_of_type_ComTencentAvUiGLVideoView.c()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10004), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.y = paramInt1;
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.z = paramInt2;
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.x = paramInt3;
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.k = i;
    if (paramInt4 != -1) {
      GLVideoView.a(this.jdField_a_of_type_ComTencentAvUiGLVideoView, i);
    }
    GLVideoView.d(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
  }
  
  public void onRenderReset()
  {
    GLVideoView.b(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.GLVideoView.1
 * JD-Core Version:    0.7.0.1
 */