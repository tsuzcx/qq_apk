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
    switch (paramARRenderResourceInfo.a)
    {
    default: 
      return null;
    case 0: 
      paramARRenderMangerInnerCallback = new GeneralAR3DRenderable(paramARRenderMangerInnerCallback, (GeneralARResourceInfo)paramARRenderResourceInfo);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_3D here " + paramARRenderResourceInfo.toString());
      return paramARRenderMangerInnerCallback;
    case 2: 
    case 3: 
      paramARRenderMangerInnerCallback = new NormalVideoARRenderable(paramARRenderMangerInnerCallback, (NormalVideoARResourceInfo)paramARRenderResourceInfo);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_NORAML_2D_VIDEO here" + paramARRenderResourceInfo.toString());
      return paramARRenderMangerInnerCallback;
    case 4: 
      paramARRenderMangerInnerCallback = new OnlineVideoARRenderable(paramARRenderMangerInnerCallback, (OnlineVideoARRenderableInfo)paramARRenderResourceInfo);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_ONLINE_VIDEO here" + paramARRenderResourceInfo.toString());
      return paramARRenderMangerInnerCallback;
    case 5: 
      paramARRenderMangerInnerCallback = new MultiFragmentAnimRenderable(paramARRenderMangerInnerCallback, (MultiFragmentAnimARResourceInfo)paramARRenderResourceInfo);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_MULTI_ANIM here" + paramARRenderResourceInfo.toString());
      return paramARRenderMangerInnerCallback;
    case 100: 
      paramARRenderMangerInnerCallback = new Interactive3DRenderable(paramARRenderMangerInnerCallback, (Interactive3DResourceInfo)paramARRenderResourceInfo, paramGLSurfaceView);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_BINHAI_3D here" + paramARRenderResourceInfo.toString());
      return paramARRenderMangerInnerCallback;
    }
    return new ARTransferPromotionRenderable(paramARRenderMangerInnerCallback, (ARTransferResourceInfo)paramARRenderResourceInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARRenderableConstructorFactoty
 * JD-Core Version:    0.7.0.1
 */