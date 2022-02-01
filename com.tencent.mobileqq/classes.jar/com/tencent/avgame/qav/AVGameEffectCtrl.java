package com.tencent.avgame.qav;

import com.tencent.av.CameraDataProcess;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.BeautyConfig;
import com.tencent.av.opengl.effects.CameraFrame;
import com.tencent.av.opengl.effects.EffectCtrlBase;
import com.tencent.av.opengl.effects.FilterProcessRender;
import com.tencent.av.opengl.effects.RenderParams;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.util.AvGameMachineLevelUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class AVGameEffectCtrl
  extends EffectCtrlBase
{
  private final int jdField_a_of_type_Int;
  private final BeautyConfig jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig = new BeautyConfig();
  private final WeakReference<CameraDataProcess> jdField_a_of_type_MqqUtilWeakReference;
  private boolean b = false;
  private boolean c = true;
  
  public AVGameEffectCtrl(CameraDataProcess paramCameraDataProcess)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramCameraDataProcess);
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.a("BEAUTY_SKIN", 60);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender = new FilterProcessRender(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig);
    int i = AvGameMachineLevelUtils.a();
    if (i == 3) {}
    for (this.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Int = 1)
    {
      this.b = GraphicRenderMgr.soloadedPTV;
      if (QLog.isColorLevel()) {
        QLog.i("AVGameEffectCtrl", 2, "AVGameEffectCtrl, line[" + i + "], mode[" + this.jdField_a_of_type_Int + "], PtvSoReady[" + this.b + "]");
      }
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt) {}
  
  public void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams)
  {
    paramRenderParams.a();
    if (!paramRenderParams.c) {
      paramRenderParams.c = this.b;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameEffectCtrl", 2, "destroy, exit[" + paramBoolean + "]");
    }
    c();
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean a(AVGameAppInterface paramAVGameAppInterface)
  {
    if (paramAVGameAppInterface == null) {
      return this.b;
    }
    if (!this.b)
    {
      paramAVGameAppInterface = paramAVGameAppInterface.a();
      if (paramAVGameAppInterface != null) {
        this.b = paramAVGameAppInterface.a();
      }
      while (!this.b)
      {
        QLog.w("AVGameEffectCtrl", 1, "isLoadedSO, load ptv so fail, proxy[" + paramAVGameAppInterface + "]");
        return this.b;
        g();
      }
    }
    return g();
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    return null;
  }
  
  public float[] a()
  {
    CameraDataProcess localCameraDataProcess = (CameraDataProcess)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localCameraDataProcess != null) {
      return localCameraDataProcess.a();
    }
    return null;
  }
  
  public void b(int paramInt) {}
  
  public boolean f()
  {
    return this.b;
  }
  
  public boolean g()
  {
    boolean bool2;
    if (!GraphicRenderMgr.soloadedPTV)
    {
      GraphicRenderMgr.loadPtuSO();
      QLog.w("AVGameEffectCtrl", 1, "isLoadedSO, loadPtvSoRet[" + GraphicRenderMgr.soloadedPTV + "]");
      bool2 = GraphicRenderMgr.soloadedPTV;
      bool1 = bool2;
      if (bool2)
      {
        this.b = true;
        d();
      }
    }
    for (boolean bool1 = bool2;; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVGameEffectCtrl", 2, "loadPtvSo, ret[" + bool1 + "]");
      }
      return bool1;
      this.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameEffectCtrl
 * JD-Core Version:    0.7.0.1
 */