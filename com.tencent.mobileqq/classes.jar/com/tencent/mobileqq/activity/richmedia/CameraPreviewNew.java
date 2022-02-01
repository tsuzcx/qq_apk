package com.tencent.mobileqq.activity.richmedia;

import alod;
import alps;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import anvx;
import bczq;
import bdav;
import bdax;
import bdba;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.qphone.base.util.QLog;

public class CameraPreviewNew
  extends SurfaceView
  implements Camera.PreviewCallback, SurfaceHolder.Callback
{
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
  private bczq jdField_a_of_type_Bczq = new alod(this);
  private boolean jdField_a_of_type_Boolean;
  
  public CameraPreviewNew(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraPreviewNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setType(3);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    post(new CameraPreviewNew.1(this, paramString, paramInt, getContext()));
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera) {}
  
  public void setCamera(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "setCamera isFromGuide" + this.jdField_a_of_type_Boolean);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (Build.VERSION.SDK_INT <= 10) {
      bdax.a().b();
    }
    if (!bdax.a().e())
    {
      this.jdField_a_of_type_Bczq.a(2, new Object[] { "set preview format failed" });
      a(2002, anvx.a(2131700820), false);
    }
    do
    {
      return;
      paramSurfaceHolder = bdax.a().c(CodecParam.DST_VIDEO_WIDTH, CodecParam.DST_VIDEO_HEIGHT, paramInt2, paramInt3, false);
      if ((paramSurfaceHolder == null) || (!bdax.a().a(paramSurfaceHolder)))
      {
        this.jdField_a_of_type_Bczq.a(2, new Object[] { "set preview size failed" });
        a(2002, anvx.a(2131700823), false);
        return;
      }
      if (!bdax.a().a(CodecParam.VIDEO_FPS))
      {
        this.jdField_a_of_type_Bczq.a(2, new Object[] { "set preview fps failed" });
        a(2002, anvx.a(2131700830), false);
        return;
      }
      if (!bdax.a().c())
      {
        this.jdField_a_of_type_Bczq.a(2, new Object[] { "set display orientation failed" });
        a(2002, anvx.a(2131700829), false);
        return;
      }
      paramSurfaceHolder = bdax.a().a();
      paramInt1 = bdax.a().a();
      bdba localbdba = bdax.a().a();
      this.jdField_a_of_type_Bczq.a(2, new Object[] { localbdba, Integer.valueOf(paramInt1), paramSurfaceHolder });
    } while (bdax.a().a(this, this.jdField_a_of_type_AndroidViewSurfaceHolder));
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceChanged");
    }
    a(2002, anvx.a(2131700824), false);
    this.jdField_a_of_type_Bczq.a(3, new Object[] { "start preview failed" });
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", alps.a);
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    }
    int j = i;
    if (!bdav.c())
    {
      j = i;
      if (i == 1) {
        j = 2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceCreated sCurrentCamera=" + j);
    }
    if (bdax.a().a(j) != 0)
    {
      this.jdField_a_of_type_Bczq.a(1, new Object[] { "open camera failed" });
      a(2002, anvx.a(2131700822), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceCreated");
    }
    this.jdField_a_of_type_Bczq.a(1, new Object[] { Boolean.valueOf(true) });
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder.removeCallback(this);
    bdax.a().b();
    bdax.a().b();
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceDestroyed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.CameraPreviewNew
 * JD-Core Version:    0.7.0.1
 */