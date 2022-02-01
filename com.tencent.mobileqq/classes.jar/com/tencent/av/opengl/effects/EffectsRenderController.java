package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoCameraListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AVC2CDataHandler;
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
    QLog.w("EffectsRenderController", 1, "EffectsRenderController, constructor, app[" + paramVideoAppInterface + "], mContext[" + this.jdField_a_of_type_AndroidContentContext + "]", new Throwable("打印调用栈"));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramVideoAppInterface.getApplication();
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl = new EffectPendantTipsImpl(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl.a(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender = new FilterProcessRender(this.jdField_a_of_type_AndroidContentContext, new RedPacketWatcher(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet();
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    EffectBeautyTools.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static boolean f()
  {
    if (Build.VERSION.SDK_INT <= 15) {
      if (QLog.isColorLevel()) {
        QLog.i("EffectsRenderController", 1, "isUserAfterTreatmentPower android.os.Build.VERSION.SDK_INT <= 15");
      }
    }
    do
    {
      return false;
      if (AEKitAbilityInfo.b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("EffectsRenderController", 1, "isUserAfterTreatmentPower isMachineSupportAfterTreatment=false");
    return false;
    return true;
  }
  
  public static boolean g()
  {
    boolean bool1;
    if (!b)
    {
      localObject = VideoController.a().a();
      b = PtuResChecker.a().a((VideoAppInterface)localObject);
      if (!b)
      {
        QLog.w("EffectsRenderController", 1, "isLoadedSO, 加载so失败");
        bool1 = false;
      }
    }
    boolean bool2;
    do
    {
      return bool1;
      if (GraphicRenderMgr.soloadedPTV) {
        break;
      }
      GraphicRenderMgr.loadPtuSO();
      QLog.w("EffectsRenderController", 1, "isLoadedSO, soloadedPTV[" + GraphicRenderMgr.soloadedPTV + "]");
      bool2 = GraphicRenderMgr.soloadedPTV;
      bool1 = bool2;
    } while (!GraphicRenderMgr.soloadedPTV);
    Object localObject = VideoController.a().a(true);
    if (localObject != null) {
      ((EffectsRenderController)localObject).d();
    }
    VideoController.a().h(GraphicRenderMgr.soloadedPTV);
    return bool2;
    return true;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5))
    {
      if (!this.jdField_a_of_type_JavaUtilBitSet.get(paramInt)) {
        QLog.w("EffectsRenderController", 1, "setExtInfo, flag[" + paramInt + "]", new Throwable("打印调用栈"));
      }
      this.jdField_a_of_type_JavaUtilBitSet.set(paramInt);
    }
    while (paramInt < 5) {
      return;
    }
    throw new IllegalArgumentException("setExtInfo fail, EXP_BIT_MAX[5" + HardCodeUtil.a(2131704016));
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl.a(paramVideoAppInterface);
  }
  
  public void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams)
  {
    int i = 0;
    paramRenderParams.a();
    boolean bool;
    label62:
    label68:
    EffectPendantBase localEffectPendantBase;
    if (!paramRenderParams.c)
    {
      if ((b()) && (PtuResChecker.a().a()))
      {
        bool = true;
        paramRenderParams.c = bool;
      }
    }
    else
    {
      if ((!this.jdField_a_of_type_JavaUtilBitSet.get(0)) && (!this.jdField_a_of_type_JavaUtilBitSet.get(1))) {
        break label126;
      }
      bool = true;
      paramRenderParams.jdField_a_of_type_Boolean = bool;
      if (i >= jdField_a_of_type_ArrayOfInt.length) {
        break label200;
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(jdField_a_of_type_ArrayOfInt[i]))
      {
        localEffectPendantBase = (EffectPendantBase)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(jdField_a_of_type_ArrayOfInt[i]);
        if (localEffectPendantBase != null) {
          break label132;
        }
      }
    }
    label126:
    do
    {
      i += 1;
      break label68;
      bool = false;
      break;
      bool = false;
      break label62;
      EffectPendantBase.Pendant localPendant = localEffectPendantBase.a(paramCameraFrame.b, paramCameraFrame.jdField_a_of_type_Int);
      if (localPendant != null)
      {
        paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = localPendant.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
        paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = localPendant.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
      }
      if (paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) {
        localEffectPendantBase.a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl);
      }
    } while ((paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem == null) || (paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null));
    label132:
    label200:
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
    if (!b()) {}
    for (;;)
    {
      return false;
      if ((LowlightAndDenoiseTools.b()) || (LowlightAndDenoiseTools.c())) {
        return true;
      }
      SessionInfo localSessionInfo = SessionMgr.a().a();
      if ((localSessionInfo.d == 2) || (localSessionInfo.d == 4)) {}
      for (int i = 1; (i != 0) && ((!localSessionInfo.jdField_a_of_type_JavaUtilBitSet.isEmpty()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.l()) || (localSessionInfo.az)); i = 0) {
        return true;
      }
    }
  }
  
  protected byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    ArrayList localArrayList = new ArrayList();
    paramShort1 = 0;
    short s = 0;
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilBitSet.get(0)) || (this.jdField_a_of_type_JavaUtilBitSet.get(1)) || (this.jdField_a_of_type_JavaUtilBitSet.get(2)) || (this.jdField_a_of_type_JavaUtilBitSet.get(3)))
    {
      if (!this.jdField_a_of_type_JavaUtilBitSet.get(2))
      {
        paramShort2 = s;
        if (!this.jdField_a_of_type_JavaUtilBitSet.get(3)) {}
      }
      else
      {
        paramShort1 = VideoController.a().b(false);
        AVLog.printColorLog("EffectsRenderController", "buildExtInfo volume :" + paramShort1 + this.jdField_a_of_type_JavaUtilBitSet.get(1) + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(0));
        paramShort2 = s;
        if (paramShort1 < 100)
        {
          localObject = new byte[2];
          ByteUtils.Word2Byte((byte[])localObject, 0, (short)paramShort1);
          localObject = new Tlv((short)2, (short)2, (byte[])localObject);
          if (!this.jdField_a_of_type_JavaUtilBitSet.get(3)) {
            break label621;
          }
          localArrayList.add(localObject);
          paramShort2 = 0 + ((Tlv)localObject).a();
        }
      }
      if (!this.jdField_a_of_type_JavaUtilBitSet.get(0))
      {
        paramShort1 = paramShort2;
        if (!this.jdField_a_of_type_JavaUtilBitSet.get(1)) {}
      }
      else
      {
        AVLog.printColorLog("EffectsRenderController", "buildExtInfo face :" + paramArrayOfByte1 + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(1) + "|" + this.jdField_a_of_type_JavaUtilBitSet.get(0));
        if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
        {
          paramShort1 = paramShort2;
          if (paramArrayOfByte3 == null) {}
        }
        else
        {
          if (paramArrayOfByte1 == null) {
            break label660;
          }
          paramArrayOfByte1 = new Tlv((short)1, (short)paramArrayOfByte1.length, paramArrayOfByte1);
          label332:
          if (paramArrayOfByte2 != null) {
            new Tlv((short)4, (short)paramArrayOfByte2.length, paramArrayOfByte2);
          }
          if (paramArrayOfByte3 == null) {
            break label665;
          }
          paramShort1 = 1;
          label356:
          if (!this.jdField_a_of_type_JavaUtilBitSet.get(1)) {
            break label706;
          }
          if (paramShort1 == 0) {
            break label671;
          }
          paramArrayOfByte1 = new Tlv((short)6, (short)paramArrayOfByte3.length, paramArrayOfByte3);
          localArrayList.add(paramArrayOfByte1);
          paramShort2 += paramArrayOfByte1.a();
          label402:
          paramArrayOfByte1 = new byte[8];
          if (paramShort1 == 0) {
            break label690;
          }
          s = paramShort4;
          label416:
          if (paramShort1 == 0) {
            break label698;
          }
          paramShort1 = paramShort3;
          label425:
          paramArrayOfByte1[0] = ((byte)(s >> 8));
          paramArrayOfByte1[1] = ((byte)(s >> 0));
          paramArrayOfByte1[2] = ((byte)(paramShort1 >> 8));
          paramArrayOfByte1[3] = ((byte)(paramShort1 >> 0));
          paramArrayOfByte1[4] = ((byte)(paramShort3 >> 8));
          paramArrayOfByte1[5] = ((byte)(paramShort3 >> 0));
          paramArrayOfByte1[6] = ((byte)(paramShort4 >> 8));
          paramArrayOfByte1[7] = ((byte)(paramShort4 >> 0));
          paramArrayOfByte1 = new Tlv((short)3, (short)paramArrayOfByte1.length, paramArrayOfByte1);
          localArrayList.add(paramArrayOfByte1);
          paramShort1 = paramShort2 + paramArrayOfByte1.a();
        }
      }
    }
    for (;;)
    {
      paramShort2 = paramShort1;
      if (this.jdField_a_of_type_JavaUtilBitSet.get(4))
      {
        paramArrayOfByte1 = AVC2CDataHandler.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        paramShort2 = paramShort1;
        if (paramArrayOfByte1 != null) {
          paramShort2 = paramShort1 + paramArrayOfByte1.a(localArrayList);
        }
      }
      if (paramShort2 <= 0) {
        break label747;
      }
      paramArrayOfByte1 = ByteBuffer.allocate(paramShort2);
      paramShort2 = localArrayList.size();
      paramShort1 = 0;
      while (paramShort1 < paramShort2)
      {
        paramArrayOfByte1.put(TlvUtils.a((Tlv)localArrayList.get(paramShort1)));
        paramShort1 += 1;
      }
      label621:
      paramShort2 = s;
      if (!this.jdField_a_of_type_JavaUtilBitSet.get(2)) {
        break;
      }
      localObject = TlvUtils.a((Tlv)localObject);
      a(this.jdField_a_of_type_JavaLangString, (byte[])localObject);
      paramShort2 = s;
      break;
      label660:
      paramArrayOfByte1 = null;
      break label332;
      label665:
      paramShort1 = 0;
      break label356;
      label671:
      localArrayList.add(paramArrayOfByte1);
      paramShort2 += paramArrayOfByte1.a();
      break label402;
      label690:
      s = 320;
      break label416;
      label698:
      paramShort1 = 240;
      break label425;
      label706:
      paramShort1 = paramShort2;
      if (this.jdField_a_of_type_JavaUtilBitSet.get(0))
      {
        paramArrayOfByte1 = TlvUtils.a(paramArrayOfByte1);
        a(this.jdField_a_of_type_JavaLangString, paramArrayOfByte1);
        paramShort1 = paramShort2;
      }
    }
    return paramArrayOfByte1.array();
    label747:
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
    this.jdField_a_of_type_Int = paramInt;
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
      if (this.jdField_a_of_type_JavaUtilBitSet.get(paramInt)) {
        QLog.w("EffectsRenderController", 1, "clearExtInfo, flag[" + paramInt + "]", new Throwable("打印调用栈"));
      }
      this.jdField_a_of_type_JavaUtilBitSet.clear(paramInt);
    }
  }
  
  protected void d(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)) {
      ((EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).c();
    }
    super.d(paramLong);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)) {
      ((EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).c();
    }
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectsRenderController
 * JD-Core Version:    0.7.0.1
 */