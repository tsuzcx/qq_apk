package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AVC2CDataHandler;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.pendant.EffectPendantTips;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.Tlv;
import com.tencent.av.opengl.TlvUtils;
import com.tencent.av.opengl.config.EffectFaceDeviceConfig;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.mobileqq.shortvideo.ptvfilter.VideoFilterList;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.ByteUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;
import jkd;
import jke;

@TargetApi(18)
public class EffectsRenderController
  extends GLContextThread
  implements EffectController
{
  public static String a;
  static boolean jdField_b_of_type_Boolean;
  static boolean c;
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private EffectPendantTips jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips;
  CameraObserver jdField_a_of_type_ComTencentAvCameraCameraObserver = new jkd(this);
  EffectsRenderController.TempTime jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController$TempTime = new EffectsRenderController.TempTime(this);
  public FilterProcessRender a;
  private BitSet jdField_a_of_type_JavaUtilBitSet;
  jke jdField_a_of_type_Jke = new jke();
  boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EffectsRenderController";
  }
  
  public EffectsRenderController(VideoAppInterface paramVideoAppInterface, GLRootView paramGLRootView)
  {
    AVLog.c(jdField_a_of_type_JavaLangString, "EffectsRenderController constructor: " + paramVideoAppInterface + "|" + this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramVideoAppInterface.getApplication();
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips = new EffectPendantTips(this.jdField_a_of_type_AndroidContentContext, null);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender = new FilterProcessRender(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet();
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    EffectBeautyTools.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(EffectsRenderController.CameraFrame paramCameraFrame)
  {
    int i = 0;
    Object localObject4 = null;
    int j = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a();
    int k = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.b();
    boolean bool2;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    boolean bool1;
    if ((this.jdField_a_of_type_JavaUtilBitSet.get(0)) || (this.jdField_a_of_type_JavaUtilBitSet.get(1)))
    {
      bool2 = true;
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)) {
        break label293;
      }
      localObject3 = (EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
      localObject2 = ((EffectPendantTools)localObject3).a(j, k);
      localObject1 = (PendantItem)((EffectPendantTools)localObject3).a();
      if (localObject1 == null) {
        break label287;
      }
      ((EffectPendantTools)localObject3).a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips);
      bool1 = ((PendantItem)localObject1).getRenderFirst();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)) {}
      for (localObject3 = ((EffectFilterTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a();; localObject3 = null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController$TempTime.a();
        localObject1 = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a(this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController$TempTime, paramCameraFrame, (FilterRender)localObject3, (VideoFilterList)localObject2, bool1, bool2, (PendantItem)localObject1, this.jdField_a_of_type_Int);
        if ((localObject2 == null) && (!bool2))
        {
          label186:
          GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(i, 1);
          if (localObject1 == null) {
            break label271;
          }
          localObject3 = ((FilterProcessRender.RenderResult)localObject1).b;
          localObject2 = ((FilterProcessRender.RenderResult)localObject1).c;
          if (localObject2 != null) {
            float f = ByteBuffer.wrap((byte[])localObject2).getInt(652) / 1000000;
          }
          paramCameraFrame = (EffectsRenderController.CameraFrame)localObject1;
          localObject1 = localObject3;
        }
        for (;;)
        {
          a(paramCameraFrame, (byte[])localObject1, (byte[])localObject2);
          this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController$TempTime.a(paramCameraFrame, i);
          return;
          bool2 = false;
          break;
          i = 1;
          break label186;
          label271:
          localObject1 = null;
          localObject2 = localObject4;
        }
      }
      label287:
      bool1 = true;
      continue;
      label293:
      bool1 = true;
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  private void a(EffectsRenderController.CameraFrame paramCameraFrame, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramCameraFrame != null)
    {
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2, (short)paramCameraFrame.jdField_a_of_type_Int, (short)paramCameraFrame.jdField_b_of_type_Int);
      GraphicRenderMgr.getInstance().sendCameraFrame2Native(paramCameraFrame.jdField_a_of_type_ArrayOfByte, paramCameraFrame.jdField_c_of_type_Int, paramCameraFrame.jdField_a_of_type_Int, paramCameraFrame.jdField_b_of_type_Int, paramCameraFrame.jdField_d_of_type_Int, paramCameraFrame.jdField_b_of_type_Long, paramCameraFrame.jdField_a_of_type_Boolean, VideoController.a().a, paramArrayOfByte1);
    }
  }
  
  public static boolean a()
  {
    if (c) {
      return true;
    }
    if (!b()) {
      return false;
    }
    if (!a(4, 1400000L)) {
      return false;
    }
    EffectFaceDeviceConfig localEffectFaceDeviceConfig = EffectFaceDeviceConfig.a();
    if ((localEffectFaceDeviceConfig != null) && (!localEffectFaceDeviceConfig.e()))
    {
      AVLog.e(jdField_a_of_type_JavaLangString, "isUserEffectFace| model in black list.modle=" + Build.MANUFACTURER + ":" + Build.MODEL);
      return false;
    }
    c = true;
    return c;
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    if (c()) {}
    do
    {
      return true;
      int i = DeviceInfoUtil.a();
      if (i < 17)
      {
        AVLog.c(jdField_a_of_type_JavaLangString, "isUserEffectFace error  OSversion:" + i);
        return false;
      }
      i = VcSystemInfo.e();
      if (i < paramInt)
      {
        AVLog.c(jdField_a_of_type_JavaLangString, "isUserEffectFace error cpucount:" + i);
        return false;
      }
      long l = VcSystemInfo.c();
      if ((l != 0L) && (l < paramLong))
      {
        AVLog.c(jdField_a_of_type_JavaLangString, "isUserEffectFace error cpuFrequency:" + l);
        return false;
      }
      paramLong = DeviceInfoUtil.e();
    } while (paramLong >= 1073741824L);
    AVLog.c(jdField_a_of_type_JavaLangString, "isUserEffectFace error  memory:" + paramLong);
    return false;
  }
  
  public static boolean b()
  {
    if (!jdField_b_of_type_Boolean)
    {
      jdField_b_of_type_Boolean = VideoController.a().a().g();
      if (!jdField_b_of_type_Boolean)
      {
        AVLog.e(jdField_a_of_type_JavaLangString, "getEffectsSoLoadIsOk  false");
        return false;
      }
    }
    if (!GraphicRenderMgr.soloadedPTV)
    {
      GraphicRenderMgr.loadPtuSO();
      AVLog.e(jdField_a_of_type_JavaLangString, String.format("isLoadedSO, soloadedPTV[%s]", new Object[] { Boolean.valueOf(GraphicRenderMgr.soloadedPTV) }));
      return GraphicRenderMgr.soloadedPTV;
    }
    return true;
  }
  
  public static boolean c()
  {
    String str = Build.MODEL;
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.equals("MI 5");
  }
  
  private void e()
  {
    AVLog.c(jdField_a_of_type_JavaLangString, String.format("initial, isInitial[%s], soloadedPTV[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(GraphicRenderMgr.soloadedPTV) }));
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      super.a();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a();
    } while (!AndroidCamera.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a(AndroidCamera.l, AndroidCamera.k);
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    AVLog.c(jdField_a_of_type_JavaLangString, " unfreeze()");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)) {
      ((EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).c();
    }
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.c();
    super.c();
  }
  
  public void a()
  {
    AVLog.c(jdField_a_of_type_JavaLangString, "init: ");
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1).sendToTarget();
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.b(paramInt);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    AVLog.c(jdField_a_of_type_JavaLangString, "updatePreviewSize: " + paramInt1 + "|" + paramInt2 + "|");
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a();
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a(paramInt1, paramInt2);
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      e();
      return;
    case 2: 
      f();
      return;
    case 3: 
      a((EffectsRenderController.CameraFrame)paramMessage.obj);
      return;
    }
    a(AndroidCamera.l, AndroidCamera.k);
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.a(paramVideoAppInterface);
  }
  
  void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), paramString, paramArrayOfByte });
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean1, int[] paramArrayOfInt, int paramInt5, boolean paramBoolean2)
  {
    if ((paramArrayOfByte == null) || (paramInt1 == 0) || (paramInt2 == 0))
    {
      paramArrayOfInt = jdField_a_of_type_JavaLangString;
      if (paramArrayOfByte == null) {}
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        AVLog.c(paramArrayOfInt, String.format("processFrame, error, data[%s], width[%s], height[%s], format[%s], angle[%s], FPS[%s], isFront[%s]", new Object[] { Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1) }));
        return;
      }
    }
    EffectsRenderController.CameraFrame localCameraFrame = new EffectsRenderController.CameraFrame(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramLong, System.currentTimeMillis());
    localCameraFrame.jdField_d_of_type_Long = AudioHelper.b();
    this.jdField_a_of_type_Jke.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramLong, paramBoolean1, localCameraFrame.jdField_c_of_type_Long);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_ArrayOfInt[0] = paramArrayOfInt[0];
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_ArrayOfInt[1] = paramArrayOfInt[1];
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_ArrayOfInt[3] = paramArrayOfInt[3];
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_ArrayOfInt[4] = paramArrayOfInt[4];
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_ArrayOfInt[6] = paramArrayOfInt[6];
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_ArrayOfInt[7] = ((int)paramLong);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, localCameraFrame).sendToTarget();
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, short paramShort1, short paramShort2)
  {
    short s3 = 0;
    ArrayList localArrayList = new ArrayList();
    short s1;
    Object localObject;
    short s2;
    if ((this.jdField_a_of_type_JavaUtilBitSet.get(0)) || (this.jdField_a_of_type_JavaUtilBitSet.get(1)) || (this.jdField_a_of_type_JavaUtilBitSet.get(2)) || (this.jdField_a_of_type_JavaUtilBitSet.get(3))) {
      if ((this.jdField_a_of_type_JavaUtilBitSet.get(2)) || (this.jdField_a_of_type_JavaUtilBitSet.get(3)))
      {
        s1 = VideoController.a().c(false);
        AVLog.c(jdField_a_of_type_JavaLangString, "buildExtInfo volume :" + s1 + this.jdField_a_of_type_JavaUtilBitSet.get(1) + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(0));
        if (s1 < 100)
        {
          localObject = new byte[2];
          ByteUtils.Word2Byte((byte[])localObject, 0, (short)s1);
          localObject = new Tlv((short)2, (short)2, (byte[])localObject);
          if (this.jdField_a_of_type_JavaUtilBitSet.get(3))
          {
            localArrayList.add(localObject);
            s2 = ((Tlv)localObject).a() + 0;
            if (!this.jdField_a_of_type_JavaUtilBitSet.get(0))
            {
              s1 = s2;
              if (!this.jdField_a_of_type_JavaUtilBitSet.get(1)) {}
            }
            else
            {
              AVLog.c(jdField_a_of_type_JavaLangString, "buildExtInfo face :" + paramArrayOfByte1 + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(1) + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(0));
              s1 = s2;
              if (paramArrayOfByte1 != null)
              {
                s1 = s2;
                if (paramArrayOfByte2 != null)
                {
                  paramArrayOfByte1 = new Tlv((short)1, (short)paramArrayOfByte1.length, paramArrayOfByte1);
                  paramArrayOfByte2 = new Tlv((short)4, (short)paramArrayOfByte2.length, paramArrayOfByte2);
                  if (!this.jdField_a_of_type_JavaUtilBitSet.get(1)) {
                    break label625;
                  }
                  if (((EffectSupportManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(3, "SUPPORT_SWITCH_FACE") != 1) {
                    break label600;
                  }
                  s1 = 1;
                  label365:
                  if (s1 != 0) {
                    break label606;
                  }
                  localArrayList.add(paramArrayOfByte1);
                  s1 = paramArrayOfByte1.a() + s2;
                  label386:
                  paramArrayOfByte1 = new byte[8];
                  paramArrayOfByte1[0] = ((byte)1);
                  paramArrayOfByte1[1] = ((byte)320);
                  paramArrayOfByte1[2] = ((byte)0);
                  paramArrayOfByte1[3] = ((byte)'ð');
                  paramArrayOfByte1[4] = ((byte)(paramShort1 >> 8));
                  paramArrayOfByte1[5] = ((byte)(paramShort1 >> 0));
                  paramArrayOfByte1[6] = ((byte)(paramShort2 >> 8));
                  paramArrayOfByte1[7] = ((byte)(paramShort2 >> 0));
                  paramArrayOfByte1 = new Tlv((short)3, (short)paramArrayOfByte1.length, paramArrayOfByte1);
                  localArrayList.add(paramArrayOfByte1);
                  s1 = paramArrayOfByte1.a() + s1;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label478:
      paramShort1 = s1;
      if (this.jdField_a_of_type_JavaUtilBitSet.get(4))
      {
        paramArrayOfByte1 = AVC2CDataHandler.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        paramShort1 = s1;
        if (paramArrayOfByte1 != null) {
          paramShort1 = s1 + paramArrayOfByte1.a(localArrayList);
        }
      }
      if (paramShort1 > 0)
      {
        paramArrayOfByte1 = ByteBuffer.allocate(paramShort1);
        paramShort2 = localArrayList.size();
        paramShort1 = s3;
        for (;;)
        {
          if (paramShort1 < paramShort2)
          {
            paramArrayOfByte1.put(TlvUtils.a((Tlv)localArrayList.get(paramShort1)));
            paramShort1 += 1;
            continue;
            if (this.jdField_a_of_type_JavaUtilBitSet.get(2))
            {
              localObject = TlvUtils.a((Tlv)localObject);
              a(this.jdField_b_of_type_JavaLangString, (byte[])localObject);
            }
            s2 = 0;
            break;
            label600:
            s1 = 0;
            break label365;
            label606:
            localArrayList.add(paramArrayOfByte2);
            s1 = paramArrayOfByte2.a() + s2;
            break label386;
            label625:
            s1 = s2;
            if (!this.jdField_a_of_type_JavaUtilBitSet.get(0)) {
              break label478;
            }
            paramArrayOfByte1 = TlvUtils.a(paramArrayOfByte1);
            a(this.jdField_b_of_type_JavaLangString, paramArrayOfByte1);
            s1 = s2;
            break label478;
          }
        }
        return paramArrayOfByte1.array();
      }
      return null;
      s1 = 0;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.b();
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5)) {
      this.jdField_a_of_type_JavaUtilBitSet.set(paramInt);
    }
    while (paramInt < 5) {
      return;
    }
    throw new IllegalArgumentException("setExtInfo fail, EXP_BIT_MAX[5]需修改");
  }
  
  public void c()
  {
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2).sendToTarget();
  }
  
  public void c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5)) {
      this.jdField_a_of_type_JavaUtilBitSet.clear(paramInt);
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectsRenderController
 * JD-Core Version:    0.7.0.1
 */