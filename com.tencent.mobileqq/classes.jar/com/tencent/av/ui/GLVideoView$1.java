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
    if (QLog.isColorLevel())
    {
      localObject = GLVideoView.a(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRenderInfoNotify, width[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiGLVideoView.y);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], height[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiGLVideoView.z);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], angle[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiGLVideoView.x);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], rotation[");
      localStringBuilder.append(GLVideoView.a(this.jdField_a_of_type_ComTencentAvUiGLVideoView));
      localStringBuilder.append("->");
      localStringBuilder.append(i);
      localStringBuilder.append("], srcR[");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("], isLocalView[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiGLVideoView.c());
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_ComTencentAvUiGLVideoView.c())
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      if (localObject != null) {
        ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(10004), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUiGLVideoView;
    ((GLVideoView)localObject).y = paramInt1;
    ((GLVideoView)localObject).z = paramInt2;
    ((GLVideoView)localObject).x = paramInt3;
    ((GLVideoView)localObject).k = i;
    if (paramInt4 != -1) {
      GLVideoView.a((GLVideoView)localObject, i);
    }
    GLVideoView.d(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
  }
  
  public void onRenderReset()
  {
    GLVideoView.b(this.jdField_a_of_type_ComTencentAvUiGLVideoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GLVideoView.1
 * JD-Core Version:    0.7.0.1
 */