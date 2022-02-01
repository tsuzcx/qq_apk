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
  private final BeautyConfig h = new BeautyConfig();
  private boolean j = false;
  private final int k;
  private boolean l = true;
  private final WeakReference<CameraDataProcess> m;
  
  public AVGameEffectCtrl(CameraDataProcess paramCameraDataProcess)
  {
    this.m = new WeakReference(paramCameraDataProcess);
    this.a = BaseApplicationImpl.getContext();
    this.h.a("BEAUTY_SKIN", 60);
    this.b = new FilterProcessRender(this.a, this.h);
    int i = AvGameMachineLevelUtils.a();
    if (i == 3) {
      this.k = 0;
    } else {
      this.k = 1;
    }
    this.j = GraphicRenderMgr.soloadedPTV;
    if (QLog.isColorLevel())
    {
      paramCameraDataProcess = new StringBuilder();
      paramCameraDataProcess.append("AVGameEffectCtrl, line[");
      paramCameraDataProcess.append(i);
      paramCameraDataProcess.append("], mode[");
      paramCameraDataProcess.append(this.k);
      paramCameraDataProcess.append("], PtvSoReady[");
      paramCameraDataProcess.append(this.j);
      paramCameraDataProcess.append("]");
      QLog.i("AVGameEffectCtrl", 2, paramCameraDataProcess.toString());
    }
  }
  
  public void a(int paramInt) {}
  
  protected void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams)
  {
    paramRenderParams.a();
    if (!paramRenderParams.g) {
      paramRenderParams.g = this.j;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("destroy, exit[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i("AVGameEffectCtrl", 2, localStringBuilder.toString());
    }
    h();
  }
  
  public boolean a(AVGameAppInterface paramAVGameAppInterface)
  {
    if (paramAVGameAppInterface == null) {
      return this.j;
    }
    if (!this.j)
    {
      paramAVGameAppInterface = paramAVGameAppInterface.a();
      if (paramAVGameAppInterface != null) {
        this.j = paramAVGameAppInterface.b();
      } else {
        o();
      }
      if (!this.j)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isLoadedSO, load ptv so fail, proxy[");
        localStringBuilder.append(paramAVGameAppInterface);
        localStringBuilder.append("]");
        QLog.w("AVGameEffectCtrl", 1, localStringBuilder.toString());
        return this.j;
      }
    }
    return o();
  }
  
  protected byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    return null;
  }
  
  public boolean b()
  {
    return this.l;
  }
  
  protected float[] i()
  {
    CameraDataProcess localCameraDataProcess = (CameraDataProcess)this.m.get();
    if (localCameraDataProcess != null) {
      return localCameraDataProcess.a();
    }
    return null;
  }
  
  protected int l()
  {
    return this.k;
  }
  
  public boolean m()
  {
    return this.j;
  }
  
  public boolean o()
  {
    StringBuilder localStringBuilder;
    boolean bool1;
    if (!GraphicRenderMgr.soloadedPTV)
    {
      GraphicRenderMgr.loadPtuSO();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isLoadedSO, loadPtvSoRet[");
      localStringBuilder.append(GraphicRenderMgr.soloadedPTV);
      localStringBuilder.append("]");
      QLog.w("AVGameEffectCtrl", 1, localStringBuilder.toString());
      boolean bool2 = GraphicRenderMgr.soloadedPTV;
      bool1 = bool2;
      if (bool2)
      {
        this.j = true;
        j();
        bool1 = bool2;
      }
    }
    else
    {
      this.j = true;
      bool1 = true;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadPtvSo, ret[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("]");
      QLog.i("AVGameEffectCtrl", 2, localStringBuilder.toString());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameEffectCtrl
 * JD-Core Version:    0.7.0.1
 */