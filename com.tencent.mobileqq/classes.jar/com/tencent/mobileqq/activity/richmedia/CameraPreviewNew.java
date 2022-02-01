package com.tencent.mobileqq.activity.richmedia;

import akqh;
import akrw;
import amtj;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import bbsv;
import bbua;
import bbuc;
import bbuf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.qphone.base.util.QLog;

public class CameraPreviewNew
  extends SurfaceView
  implements Camera.PreviewCallback, SurfaceHolder.Callback
{
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
  private bbsv jdField_a_of_type_Bbsv = new akqh(this);
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
      bbuc.a().b();
    }
    if (!bbuc.a().e())
    {
      this.jdField_a_of_type_Bbsv.a(2, new Object[] { "set preview format failed" });
      a(2002, amtj.a(2131700469), false);
    }
    do
    {
      return;
      paramSurfaceHolder = bbuc.a().c(CodecParam.DST_VIDEO_WIDTH, CodecParam.DST_VIDEO_HEIGHT, paramInt2, paramInt3, false);
      if ((paramSurfaceHolder == null) || (!bbuc.a().a(paramSurfaceHolder)))
      {
        this.jdField_a_of_type_Bbsv.a(2, new Object[] { "set preview size failed" });
        a(2002, amtj.a(2131700472), false);
        return;
      }
      if (!bbuc.a().a(CodecParam.VIDEO_FPS))
      {
        this.jdField_a_of_type_Bbsv.a(2, new Object[] { "set preview fps failed" });
        a(2002, amtj.a(2131700479), false);
        return;
      }
      if (!bbuc.a().c())
      {
        this.jdField_a_of_type_Bbsv.a(2, new Object[] { "set display orientation failed" });
        a(2002, amtj.a(2131700478), false);
        return;
      }
      paramSurfaceHolder = bbuc.a().a();
      paramInt1 = bbuc.a().a();
      bbuf localbbuf = bbuc.a().a();
      this.jdField_a_of_type_Bbsv.a(2, new Object[] { localbbuf, Integer.valueOf(paramInt1), paramSurfaceHolder });
    } while (bbuc.a().a(this, this.jdField_a_of_type_AndroidViewSurfaceHolder));
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceChanged");
    }
    a(2002, amtj.a(2131700473), false);
    this.jdField_a_of_type_Bbsv.a(3, new Object[] { "start preview failed" });
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", akrw.a);
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    }
    int j = i;
    if (!bbua.c())
    {
      j = i;
      if (i == 1) {
        j = 2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceCreated sCurrentCamera=" + j);
    }
    if (bbuc.a().a(j) != 0)
    {
      this.jdField_a_of_type_Bbsv.a(1, new Object[] { "open camera failed" });
      a(2002, amtj.a(2131700471), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceCreated");
    }
    this.jdField_a_of_type_Bbsv.a(1, new Object[] { Boolean.valueOf(true) });
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder.removeCallback(this);
    bbuc.a().b();
    bbuc.a().b();
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceDestroyed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.CameraPreviewNew
 * JD-Core Version:    0.7.0.1
 */