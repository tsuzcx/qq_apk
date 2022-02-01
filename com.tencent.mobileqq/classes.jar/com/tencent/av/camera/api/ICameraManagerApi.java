package com.tencent.av.camera.api;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.Parameters;
import com.tencent.av.camera.CameraListener;
import com.tencent.av.camera.CameraPreviewCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.Observer;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface ICameraManagerApi
  extends CameraPreviewCallback, QRouteApi
{
  public abstract void addObserver(Observer paramObserver);
  
  public abstract boolean closeCamera(long paramLong, boolean paramBoolean);
  
  public abstract void closeCamera2(long paramLong, boolean paramBoolean);
  
  public abstract void deleteObserver(Observer paramObserver);
  
  public abstract int getCameraNum();
  
  public abstract Camera.Parameters getCameraParams();
  
  public abstract SurfaceTexture getSurfaceTextureForRender();
  
  public abstract boolean isCameraOpened(long paramLong);
  
  public abstract boolean isCameraOpening(long paramLong);
  
  public abstract boolean isFrontCamera();
  
  public abstract void openCamera(long paramLong);
  
  public abstract void openCamera2(long paramLong);
  
  public abstract void reopenCamera(String paramString, long paramLong, int paramInt1, int paramInt2);
  
  public abstract void reopenCamera2(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void resetCamera();
  
  public abstract void rotateCamera();
  
  public abstract void saveCameraAngle();
  
  public abstract void setCameraListener(CameraListener paramCameraListener);
  
  public abstract void setCameraPara2(long paramLong, int paramInt);
  
  public abstract void setCameraSensorMode(boolean paramBoolean);
  
  public abstract void setCameraWithNewFps(long paramLong, int paramInt);
  
  public abstract void setRotation(int paramInt);
  
  public abstract void setSupportLandscape(boolean paramBoolean);
  
  public abstract void setUp(Context paramContext);
  
  public abstract void startNoPreviewRunnable(long paramLong, String paramString);
  
  public abstract void stopNoPreviewRunnable(String paramString);
  
  public abstract void switchCamera(long paramLong);
  
  public abstract void switchCamera2(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.api.ICameraManagerApi
 * JD-Core Version:    0.7.0.1
 */