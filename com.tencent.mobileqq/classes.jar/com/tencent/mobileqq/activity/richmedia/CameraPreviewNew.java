package com.tencent.mobileqq.activity.richmedia;

import ahfu;
import ahhj;
import ajjy;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import awhb;
import awih;
import awij;
import awim;
import awje;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CameraPreviewNew
  extends SurfaceView
  implements Camera.PreviewCallback, SurfaceHolder.Callback
{
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
  private awhb jdField_a_of_type_Awhb = new ahfu(this);
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
      awij.a().b();
    }
    if (!awij.a().e())
    {
      this.jdField_a_of_type_Awhb.a(2, new Object[] { "set preview format failed" });
      a(2002, ajjy.a(2131635527), false);
    }
    do
    {
      return;
      paramSurfaceHolder = awij.a().c(awje.j, awje.k, paramInt2, paramInt3, false);
      if ((paramSurfaceHolder == null) || (!awij.a().a(paramSurfaceHolder)))
      {
        this.jdField_a_of_type_Awhb.a(2, new Object[] { "set preview size failed" });
        a(2002, ajjy.a(2131635530), false);
        return;
      }
      if (!awij.a().a(awje.g))
      {
        this.jdField_a_of_type_Awhb.a(2, new Object[] { "set preview fps failed" });
        a(2002, ajjy.a(2131635537), false);
        return;
      }
      if (!awij.a().c())
      {
        this.jdField_a_of_type_Awhb.a(2, new Object[] { "set display orientation failed" });
        a(2002, ajjy.a(2131635536), false);
        return;
      }
      paramSurfaceHolder = awij.a().a();
      paramInt1 = awij.a().a();
      awim localawim = awij.a().a();
      this.jdField_a_of_type_Awhb.a(2, new Object[] { localawim, Integer.valueOf(paramInt1), paramSurfaceHolder });
    } while (awij.a().a(this, this.jdField_a_of_type_AndroidViewSurfaceHolder));
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceChanged");
    }
    a(2002, ajjy.a(2131635531), false);
    this.jdField_a_of_type_Awhb.a(3, new Object[] { "start preview failed" });
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", ahhj.a);
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    }
    int j = i;
    if (!awih.c())
    {
      j = i;
      if (i == 1) {
        j = 2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceCreated sCurrentCamera=" + j);
    }
    if (awij.a().a(j) != 0)
    {
      this.jdField_a_of_type_Awhb.a(1, new Object[] { "open camera failed" });
      a(2002, ajjy.a(2131635529), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceCreated");
    }
    this.jdField_a_of_type_Awhb.a(1, new Object[] { Boolean.valueOf(true) });
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder.removeCallback(this);
    awij.a().b();
    awij.a().b();
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceDestroyed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.CameraPreviewNew
 * JD-Core Version:    0.7.0.1
 */