package com.tencent.mobileqq.activity.richmedia.p2veffect.main;

import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IControllerFilterProvider;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IControllerPrepareListener;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IFastRenderCallback;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IOnStopCompleteListener;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IP2VEnginePlayerCallback;
import com.tencent.mobileqq.activity.richmedia.p2veffect.model.MediaItem;
import cooperation.qzone.util.JarReflectUtil;
import java.util.ArrayList;

public class P2VEffectConvertor
  implements IP2VEffectControll
{
  private Object p2vEffectController;
  
  public P2VEffectConvertor(GLSurfaceView paramGLSurfaceView, IControllerPrepareListener paramIControllerPrepareListener)
  {
    this.p2vEffectController = JarReflectUtil.creatSpecifiedObject("com.tencent.mobileqq.activity.richmedia.p2veffect.P2VEffectsController", getParamsClass(new Class[] { GLSurfaceView.class, IControllerPrepareListener.class }), new Object[] { paramGLSurfaceView, paramIControllerPrepareListener });
  }
  
  private Class[] getParamsClass(Class... paramVarArgs)
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfClass[i] = paramVarArgs[i];
      i += 1;
    }
    return arrayOfClass;
  }
  
  public void addPlayerCallback(IP2VEnginePlayerCallback paramIP2VEnginePlayerCallback)
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "addPlayerCallback", false, getParamsClass(new Class[] { IP2VEnginePlayerCallback.class }), new Object[] { paramIP2VEnginePlayerCallback });
  }
  
  public void cancelSave(IOnStopCompleteListener paramIOnStopCompleteListener)
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "cancelSave", false, getParamsClass(new Class[] { IOnStopCompleteListener.class }), new Object[] { paramIOnStopCompleteListener });
  }
  
  public void onDestroy()
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "onDestroy", false, null, null);
  }
  
  public void pausePlay()
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "pausePlay", false, null, null);
  }
  
  public void prepare()
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "prepare", false, null, null);
  }
  
  public void requestDraw()
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "requestDraw", false, null, null);
  }
  
  public void resetVideoIndex()
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "resetVideoIndex", false, null, null);
  }
  
  public void save(String paramString, IFastRenderCallback paramIFastRenderCallback)
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "save", false, getParamsClass(new Class[] { String.class, IFastRenderCallback.class }), new Object[] { paramString, paramIFastRenderCallback });
  }
  
  public void setFilterProvider(IControllerFilterProvider paramIControllerFilterProvider)
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "setFilterProvider", false, getParamsClass(new Class[] { IControllerFilterProvider.class }), new Object[] { paramIControllerFilterProvider });
  }
  
  public void setMediaItems(ArrayList<MediaItem> paramArrayList)
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "setMediaItems", false, getParamsClass(new Class[] { ArrayList.class }), new Object[] { paramArrayList });
  }
  
  public void setSquareTypeAndColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "setSquareTypeAndColor", false, getParamsClass(new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
  }
  
  public void setWaterMarkerBitmap(Bitmap paramBitmap)
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "setWaterMarkerBitmap", false, getParamsClass(new Class[] { Bitmap.class }), new Object[] { paramBitmap });
  }
  
  public void setWaterMarkerEnable(boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "setWaterMarkerEnable", false, getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void startPlay(boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "startPlay", false, getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void stopPlay()
  {
    JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "stopPlay", false, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.main.P2VEffectConvertor
 * JD-Core Version:    0.7.0.1
 */