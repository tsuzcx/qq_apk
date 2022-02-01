package com.tencent.mobileqq.ar.ARRenderModel;

import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;

public final class ARRenderableConstructorFactoty
{
  public static ARBaseRender a(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, ARRenderResourceInfo paramARRenderResourceInfo, GLSurfaceView paramGLSurfaceView)
  {
    if (paramARRenderResourceInfo == null) {
      return null;
    }
    int i = paramARRenderResourceInfo.a;
    if (i != 0)
    {
      if (i != 8)
      {
        if (i != 100)
        {
          if ((i != 2) && (i != 3))
          {
            if (i != 4)
            {
              if (i != 5) {
                return null;
              }
              paramARRenderMangerInnerCallback = new MultiFragmentAnimRenderable(paramARRenderMangerInnerCallback, (MultiFragmentAnimARResourceInfo)paramARRenderResourceInfo);
              paramGLSurfaceView = new StringBuilder();
              paramGLSurfaceView.append("generate AR_MULTI_ANIM here");
              paramGLSurfaceView.append(paramARRenderResourceInfo.toString());
              QLog.d("ARRenderableConstructorFactoty", 1, paramGLSurfaceView.toString());
              return paramARRenderMangerInnerCallback;
            }
            paramARRenderMangerInnerCallback = new OnlineVideoARRenderable(paramARRenderMangerInnerCallback, (OnlineVideoARRenderableInfo)paramARRenderResourceInfo);
            paramGLSurfaceView = new StringBuilder();
            paramGLSurfaceView.append("generate AR_ONLINE_VIDEO here");
            paramGLSurfaceView.append(paramARRenderResourceInfo.toString());
            QLog.d("ARRenderableConstructorFactoty", 1, paramGLSurfaceView.toString());
            return paramARRenderMangerInnerCallback;
          }
          paramARRenderMangerInnerCallback = new NormalVideoARRenderable(paramARRenderMangerInnerCallback, (NormalVideoARResourceInfo)paramARRenderResourceInfo);
          paramGLSurfaceView = new StringBuilder();
          paramGLSurfaceView.append("generate AR_NORAML_2D_VIDEO here");
          paramGLSurfaceView.append(paramARRenderResourceInfo.toString());
          QLog.d("ARRenderableConstructorFactoty", 1, paramGLSurfaceView.toString());
          return paramARRenderMangerInnerCallback;
        }
        paramARRenderMangerInnerCallback = new Interactive3DRenderable(paramARRenderMangerInnerCallback, (Interactive3DResourceInfo)paramARRenderResourceInfo, paramGLSurfaceView);
        paramGLSurfaceView = new StringBuilder();
        paramGLSurfaceView.append("generate AR_BINHAI_3D here");
        paramGLSurfaceView.append(paramARRenderResourceInfo.toString());
        QLog.d("ARRenderableConstructorFactoty", 1, paramGLSurfaceView.toString());
        return paramARRenderMangerInnerCallback;
      }
      return new ARTransferPromotionRenderable(paramARRenderMangerInnerCallback, (ARTransferResourceInfo)paramARRenderResourceInfo);
    }
    paramARRenderMangerInnerCallback = new GeneralAR3DRenderable(paramARRenderMangerInnerCallback, (GeneralARResourceInfo)paramARRenderResourceInfo);
    paramGLSurfaceView = new StringBuilder();
    paramGLSurfaceView.append("generate AR_3D here ");
    paramGLSurfaceView.append(paramARRenderResourceInfo.toString());
    QLog.d("ARRenderableConstructorFactoty", 1, paramGLSurfaceView.toString());
    return paramARRenderMangerInnerCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARRenderableConstructorFactoty
 * JD-Core Version:    0.7.0.1
 */