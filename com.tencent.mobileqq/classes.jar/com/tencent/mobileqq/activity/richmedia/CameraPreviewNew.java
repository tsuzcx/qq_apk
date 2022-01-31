package com.tencent.mobileqq.activity.richmedia;

import ajoi;
import ajpx;
import alud;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import azfy;
import azhe;
import azhg;
import azhj;
import azib;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CameraPreviewNew
  extends SurfaceView
  implements Camera.PreviewCallback, SurfaceHolder.Callback
{
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
  private azfy jdField_a_of_type_Azfy = new ajoi(this);
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
      azhg.a().b();
    }
    if (!azhg.a().e())
    {
      this.jdField_a_of_type_Azfy.a(2, new Object[] { "set preview format failed" });
      a(2002, alud.a(2131701707), false);
    }
    do
    {
      return;
      paramSurfaceHolder = azhg.a().c(azib.j, azib.k, paramInt2, paramInt3, false);
      if ((paramSurfaceHolder == null) || (!azhg.a().a(paramSurfaceHolder)))
      {
        this.jdField_a_of_type_Azfy.a(2, new Object[] { "set preview size failed" });
        a(2002, alud.a(2131701710), false);
        return;
      }
      if (!azhg.a().a(azib.g))
      {
        this.jdField_a_of_type_Azfy.a(2, new Object[] { "set preview fps failed" });
        a(2002, alud.a(2131701717), false);
        return;
      }
      if (!azhg.a().c())
      {
        this.jdField_a_of_type_Azfy.a(2, new Object[] { "set display orientation failed" });
        a(2002, alud.a(2131701716), false);
        return;
      }
      paramSurfaceHolder = azhg.a().a();
      paramInt1 = azhg.a().a();
      azhj localazhj = azhg.a().a();
      this.jdField_a_of_type_Azfy.a(2, new Object[] { localazhj, Integer.valueOf(paramInt1), paramSurfaceHolder });
    } while (azhg.a().a(this, this.jdField_a_of_type_AndroidViewSurfaceHolder));
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceChanged");
    }
    a(2002, alud.a(2131701711), false);
    this.jdField_a_of_type_Azfy.a(3, new Object[] { "start preview failed" });
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", ajpx.a);
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    }
    int j = i;
    if (!azhe.c())
    {
      j = i;
      if (i == 1) {
        j = 2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceCreated sCurrentCamera=" + j);
    }
    if (azhg.a().a(j) != 0)
    {
      this.jdField_a_of_type_Azfy.a(1, new Object[] { "open camera failed" });
      a(2002, alud.a(2131701709), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceCreated");
    }
    this.jdField_a_of_type_Azfy.a(1, new Object[] { Boolean.valueOf(true) });
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder.removeCallback(this);
    azhg.a().b();
    azhg.a().b();
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceDestroyed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.CameraPreviewNew
 * JD-Core Version:    0.7.0.1
 */