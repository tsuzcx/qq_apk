package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoCameraListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.pendant.EffectPendantBase;
import com.tencent.av.business.manager.pendant.EffectPendantBase.Pendant;
import com.tencent.av.business.manager.pendant.EffectPendantTipsImpl;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.Tlv;
import com.tencent.av.opengl.TlvUtils;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.ByteUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;

@TargetApi(18)
public class EffectsRenderController
  extends EffectCtrlBase
  implements EffectController
{
  static final int[] jdField_a_of_type_ArrayOfInt = { 2, 13, 14 };
  private static boolean b = false;
  private int jdField_a_of_type_Int;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private EffectPendantTipsImpl jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl;
  private String jdField_a_of_type_JavaLangString;
  private BitSet jdField_a_of_type_JavaUtilBitSet;
  
  public EffectsRenderController(VideoAppInterface paramVideoAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EffectsRenderController, constructor, app[");
    localStringBuilder.append(paramVideoAppInterface);
    localStringBuilder.append("], mContext[");
    localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext);
    localStringBuilder.append("]");
    QLog.w("EffectsRenderController", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramVideoAppInterface.getApplication();
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl = new EffectPendantTipsImpl(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl.a(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender = new FilterProcessRender(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet();
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    EffectBeautyTools.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static boolean f()
  {
    Object localObject;
    if (!b)
    {
      localObject = VideoController.a().a();
      b = PtuResChecker.a().a((VideoAppInterface)localObject);
      if (!b)
      {
        QLog.w("EffectsRenderController", 1, "isLoadedSO, 加载so失败");
        return false;
      }
    }
    boolean bool1;
    if (!GraphicRenderMgr.soloadedPTV)
    {
      GraphicRenderMgr.loadPtuSO();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isLoadedSO, soloadedPTV[");
      ((StringBuilder)localObject).append(GraphicRenderMgr.soloadedPTV);
      ((StringBuilder)localObject).append("]");
      QLog.w("EffectsRenderController", 1, ((StringBuilder)localObject).toString());
      boolean bool2 = GraphicRenderMgr.soloadedPTV;
      bool1 = bool2;
      if (GraphicRenderMgr.soloadedPTV)
      {
        localObject = VideoController.a().a(true);
        if (localObject != null) {
          ((EffectsRenderController)localObject).d();
        }
        VideoController.a().g(GraphicRenderMgr.soloadedPTV);
        return bool2;
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl.a(paramVideoAppInterface);
  }
  
  public void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams)
  {
    paramRenderParams.a();
    boolean bool = paramRenderParams.c;
    int i = 0;
    if (!bool)
    {
      if ((b()) && (PtuResChecker.a().a())) {
        bool = true;
      } else {
        bool = false;
      }
      paramRenderParams.c = bool;
    }
    if ((!this.jdField_a_of_type_JavaUtilBitSet.get(0)) && (!this.jdField_a_of_type_JavaUtilBitSet.get(1))) {
      bool = false;
    } else {
      bool = true;
    }
    paramRenderParams.jdField_a_of_type_Boolean = bool;
    for (;;)
    {
      Object localObject = jdField_a_of_type_ArrayOfInt;
      if (i >= localObject.length) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(localObject[i]))
      {
        localObject = (EffectPendantBase)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(jdField_a_of_type_ArrayOfInt[i]);
        if (localObject != null)
        {
          EffectPendantBase.Pendant localPendant = ((EffectPendantBase)localObject).a(paramCameraFrame.b, paramCameraFrame.jdField_a_of_type_Int);
          if (localPendant != null)
          {
            paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = localPendant.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
            paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = localPendant.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
          }
          if (paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) {
            ((EffectPendantBase)localObject).a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl);
          }
          if ((paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) && (paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null)) {
            break;
          }
        }
      }
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)) {
      paramRenderParams.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = ((EffectFilterTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a();
    }
  }
  
  protected void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), paramString, paramArrayOfByte });
    }
  }
  
  public boolean a()
  {
    if (!b()) {
      return false;
    }
    SessionInfo localSessionInfo = SessionMgr.a().a();
    int i;
    if ((localSessionInfo.d != 2) && (localSessionInfo.d != 4)) {
      i = 0;
    } else {
      i = 1;
    }
    return (i != 0) && ((!localSessionInfo.jdField_a_of_type_JavaUtilBitSet.isEmpty()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.k()) || (localSessionInfo.an));
  }
  
  protected byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_JavaUtilBitSet;
    short s = 0;
    if ((!((BitSet)localObject).get(0)) && (!this.jdField_a_of_type_JavaUtilBitSet.get(1)) && (!this.jdField_a_of_type_JavaUtilBitSet.get(2)) && (!this.jdField_a_of_type_JavaUtilBitSet.get(3)))
    {
      paramShort1 = 0;
    }
    else
    {
      if ((this.jdField_a_of_type_JavaUtilBitSet.get(2)) || (this.jdField_a_of_type_JavaUtilBitSet.get(3)))
      {
        paramShort1 = VideoController.a().b(false);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("buildExtInfo volume :");
        ((StringBuilder)localObject).append(paramShort1);
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilBitSet.get(1));
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilBitSet.get(0));
        AVLog.printColorLog("EffectsRenderController", ((StringBuilder)localObject).toString());
        if (paramShort1 < 100)
        {
          localObject = new byte[2];
          ByteUtils.Word2Byte((byte[])localObject, 0, (short)paramShort1);
          localObject = new Tlv((short)2, (short)2, (byte[])localObject);
          if (this.jdField_a_of_type_JavaUtilBitSet.get(3))
          {
            localArrayList.add(localObject);
            paramShort1 = ((Tlv)localObject).a() + 0;
            break label269;
          }
          if (this.jdField_a_of_type_JavaUtilBitSet.get(2))
          {
            localObject = TlvUtils.a((Tlv)localObject);
            a(this.jdField_a_of_type_JavaLangString, (byte[])localObject);
          }
        }
      }
      paramShort1 = 0;
      label269:
      if ((this.jdField_a_of_type_JavaUtilBitSet.get(0)) || (this.jdField_a_of_type_JavaUtilBitSet.get(1)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("buildExtInfo face :");
        ((StringBuilder)localObject).append(paramArrayOfByte1);
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilBitSet.get(1));
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilBitSet.get(0));
        AVLog.printColorLog("EffectsRenderController", ((StringBuilder)localObject).toString());
        if (((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null)) || (paramArrayOfByte3 != null))
        {
          if (paramArrayOfByte1 != null) {
            paramArrayOfByte1 = new Tlv((short)1, (short)paramArrayOfByte1.length, paramArrayOfByte1);
          } else {
            paramArrayOfByte1 = null;
          }
          if (paramArrayOfByte2 != null) {
            new Tlv((short)4, (short)paramArrayOfByte2.length, paramArrayOfByte2);
          }
          int i;
          if (paramArrayOfByte3 != null) {
            i = 1;
          } else {
            i = 0;
          }
          if (this.jdField_a_of_type_JavaUtilBitSet.get(1))
          {
            if (i != 0)
            {
              paramArrayOfByte1 = new Tlv((short)6, (short)paramArrayOfByte3.length, paramArrayOfByte3);
              localArrayList.add(paramArrayOfByte1);
            }
            for (paramShort2 = paramArrayOfByte1.a();; paramShort2 = paramArrayOfByte1.a())
            {
              break;
              localArrayList.add(paramArrayOfByte1);
            }
            paramArrayOfByte1 = new byte[8];
            int j;
            if (i != 0) {
              j = paramShort4;
            } else {
              j = 320;
            }
            if (i != 0) {
              i = paramShort3;
            } else {
              i = 240;
            }
            paramArrayOfByte1[0] = ((byte)(j >> 8));
            paramArrayOfByte1[1] = ((byte)(j >> 0));
            paramArrayOfByte1[2] = ((byte)(i >> 8));
            paramArrayOfByte1[3] = ((byte)(i >> 0));
            paramArrayOfByte1[4] = ((byte)(paramShort3 >> 8));
            paramArrayOfByte1[5] = ((byte)(paramShort3 >> 0));
            paramArrayOfByte1[6] = ((byte)(paramShort4 >> 8));
            paramArrayOfByte1[7] = ((byte)(paramShort4 >> 0));
            paramArrayOfByte1 = new Tlv((short)3, (short)paramArrayOfByte1.length, paramArrayOfByte1);
            localArrayList.add(paramArrayOfByte1);
            paramShort1 = paramArrayOfByte1.a() + (paramShort1 + paramShort2);
          }
          else if (this.jdField_a_of_type_JavaUtilBitSet.get(0))
          {
            paramArrayOfByte1 = TlvUtils.a(paramArrayOfByte1);
            a(this.jdField_a_of_type_JavaLangString, paramArrayOfByte1);
          }
        }
      }
    }
    if (paramShort1 > 0)
    {
      paramArrayOfByte1 = ByteBuffer.allocate(paramShort1);
      paramShort2 = localArrayList.size();
      paramShort1 = s;
      while (paramShort1 < paramShort2)
      {
        paramArrayOfByte1.put(TlvUtils.a((Tlv)localArrayList.get(paramShort1)));
        paramShort1 += 1;
      }
      return paramArrayOfByte1.array();
    }
    return null;
  }
  
  public float[] a()
  {
    return VideoController.a().a.a();
  }
  
  public void b()
  {
    super.b();
    TipsInfo.a().a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl);
  }
  
  public void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5))
    {
      if (!this.jdField_a_of_type_JavaUtilBitSet.get(paramInt))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setExtInfo, flag[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.w("EffectsRenderController", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      }
      this.jdField_a_of_type_JavaUtilBitSet.set(paramInt);
      return;
    }
    if (paramInt < 5) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setExtInfo fail, EXP_BIT_MAX[5");
    localStringBuilder.append(HardCodeUtil.a(2131704105));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void c()
  {
    TipsInfo.a().a(null);
    super.c();
  }
  
  public void c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5))
    {
      if (this.jdField_a_of_type_JavaUtilBitSet.get(paramInt))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearExtInfo, flag[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.w("EffectsRenderController", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      }
      this.jdField_a_of_type_JavaUtilBitSet.clear(paramInt);
    }
  }
  
  protected void d(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)) {
      ((EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).d();
    }
    super.d(paramLong);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)) {
      ((EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).d();
    }
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectsRenderController
 * JD-Core Version:    0.7.0.1
 */