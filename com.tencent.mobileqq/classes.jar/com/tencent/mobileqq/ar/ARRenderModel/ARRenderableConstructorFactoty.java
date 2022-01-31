package com.tencent.mobileqq.ar.ARRenderModel;

import aahd;
import aaif;
import aaii;
import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;

public class ARRenderableConstructorFactoty
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
      paramARRenderMangerInnerCallback = new aahd(paramARRenderMangerInnerCallback, (GeneralARResourceInfo)paramARRenderResourceInfo);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_3D here " + paramARRenderResourceInfo.toString());
      return paramARRenderMangerInnerCallback;
    case 2: 
    case 3: 
      paramARRenderMangerInnerCallback = new aaif(paramARRenderMangerInnerCallback, (NormalVideoARResourceInfo)paramARRenderResourceInfo);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_NORAML_2D_VIDEO here" + paramARRenderResourceInfo.toString());
      return paramARRenderMangerInnerCallback;
    case 4: 
      paramARRenderMangerInnerCallback = new aaii(paramARRenderMangerInnerCallback, (OnlineVideoARRenderableInfo)paramARRenderResourceInfo);
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
    case 7: 
      return new GreetingCardRender(paramARRenderMangerInnerCallback, (GreetingCardResourceInfo)paramARRenderResourceInfo);
    }
    return new ARWorldCupGlobalSceneRenderable(paramARRenderMangerInnerCallback, (ARWorldCupResourceInfo)paramARRenderResourceInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARRenderableConstructorFactoty
 * JD-Core Version:    0.7.0.1
 */