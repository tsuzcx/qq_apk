package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoCameraListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager.Avatar2d;
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
  static final int[] h = { 2, 13, 14 };
  private static boolean j = false;
  private EffectPendantTipsImpl k;
  private BitSet l;
  private VideoAppInterface m;
  private String n;
  private int o;
  
  public EffectsRenderController(VideoAppInterface paramVideoAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EffectsRenderController, constructor, app[");
    localStringBuilder.append(paramVideoAppInterface);
    localStringBuilder.append("], mContext[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w("EffectsRenderController", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
    this.m = paramVideoAppInterface;
    this.a = paramVideoAppInterface.getApplication();
    this.k = new EffectPendantTipsImpl(this.a);
    this.k.a(paramVideoAppInterface);
    this.b = new FilterProcessRender(this.a, this.m.x());
    this.l = new BitSet();
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    EffectBeautyTools.a(this.a);
  }
  
  public static boolean m()
  {
    Object localObject;
    if (!j)
    {
      localObject = VideoController.f().aj();
      j = PtuResChecker.a().a((VideoAppInterface)localObject);
      if (!j)
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
        localObject = VideoController.f().m(true);
        if (localObject != null) {
          ((EffectsRenderController)localObject).j();
        }
        VideoController.f().n(GraphicRenderMgr.soloadedPTV);
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
    this.o = paramInt;
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.m = paramVideoAppInterface;
    this.n = this.m.getCurrentAccountUin();
    this.k.a(paramVideoAppInterface);
  }
  
  public void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams)
  {
    paramRenderParams.a();
    boolean bool = paramRenderParams.g;
    int i = 0;
    if (!bool)
    {
      if ((c()) && (PtuResChecker.a().b())) {
        bool = true;
      } else {
        bool = false;
      }
      paramRenderParams.g = bool;
    }
    if ((!this.l.get(0)) && (!this.l.get(1))) {
      bool = false;
    } else {
      bool = true;
    }
    paramRenderParams.e = bool;
    Object localObject;
    for (;;)
    {
      localObject = h;
      if (i >= localObject.length) {
        break;
      }
      if (this.m.d(localObject[i]))
      {
        localObject = (EffectPendantBase)this.m.c(h[i]);
        if (localObject != null)
        {
          EffectPendantBase.Pendant localPendant = ((EffectPendantBase)localObject).a(paramCameraFrame.c, paramCameraFrame.b);
          if (localPendant != null)
          {
            paramRenderParams.b = localPendant.a;
            paramRenderParams.c = localPendant.c;
            paramRenderParams.d = null;
          }
          if (paramRenderParams.c != null) {
            ((EffectPendantBase)localObject).a(this.k);
          }
          if ((paramRenderParams.c != null) && (paramRenderParams.b != null)) {
            break;
          }
        }
      }
      i += 1;
    }
    if (this.m.d(16))
    {
      localObject = (EffectAvatar2dManager)this.m.c(16);
      if (localObject != null)
      {
        paramCameraFrame = ((EffectAvatar2dManager)localObject).a(paramCameraFrame.c, paramCameraFrame.b);
        if (paramCameraFrame != null)
        {
          paramRenderParams.b = paramCameraFrame.a;
          paramRenderParams.d = paramCameraFrame.c;
          paramRenderParams.c = null;
        }
      }
    }
    if (this.m.d(1)) {
      paramRenderParams.a = ((EffectFilterTools)this.m.c(1)).j();
    }
  }
  
  protected void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.m != null) {
      this.m.a(new Object[] { Integer.valueOf(130), paramString, paramArrayOfByte });
    }
  }
  
  protected byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.l;
    short s = 0;
    if ((!((BitSet)localObject).get(0)) && (!this.l.get(1)) && (!this.l.get(2)) && (!this.l.get(3)))
    {
      paramShort1 = 0;
    }
    else
    {
      if ((this.l.get(2)) || (this.l.get(3)))
      {
        paramShort1 = VideoController.f().j(false);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("buildExtInfo volume :");
        ((StringBuilder)localObject).append(paramShort1);
        ((StringBuilder)localObject).append(this.l.get(1));
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(this.l.get(0));
        AVLog.printColorLog("EffectsRenderController", ((StringBuilder)localObject).toString());
        if (paramShort1 < 100)
        {
          localObject = new byte[2];
          ByteUtils.Word2Byte((byte[])localObject, 0, (short)paramShort1);
          localObject = new Tlv((short)2, (short)2, (byte[])localObject);
          if (this.l.get(3))
          {
            localArrayList.add(localObject);
            paramShort1 = ((Tlv)localObject).d() + 0;
            break label269;
          }
          if (this.l.get(2))
          {
            localObject = TlvUtils.a((Tlv)localObject);
            a(this.n, (byte[])localObject);
          }
        }
      }
      paramShort1 = 0;
      label269:
      if ((this.l.get(0)) || (this.l.get(1)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("buildExtInfo face :");
        ((StringBuilder)localObject).append(paramArrayOfByte1);
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(this.l.get(1));
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(this.l.get(0));
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
          if (this.l.get(1))
          {
            if (i != 0)
            {
              paramArrayOfByte1 = new Tlv((short)6, (short)paramArrayOfByte3.length, paramArrayOfByte3);
              localArrayList.add(paramArrayOfByte1);
            }
            for (paramShort2 = paramArrayOfByte1.d();; paramShort2 = paramArrayOfByte1.d())
            {
              break;
              localArrayList.add(paramArrayOfByte1);
            }
            paramArrayOfByte1 = new byte[8];
            int i1;
            if (i != 0) {
              i1 = paramShort4;
            } else {
              i1 = 320;
            }
            if (i != 0) {
              i = paramShort3;
            } else {
              i = 240;
            }
            paramArrayOfByte1[0] = ((byte)(i1 >> 8));
            paramArrayOfByte1[1] = ((byte)(i1 >> 0));
            paramArrayOfByte1[2] = ((byte)(i >> 8));
            paramArrayOfByte1[3] = ((byte)(i >> 0));
            paramArrayOfByte1[4] = ((byte)(paramShort3 >> 8));
            paramArrayOfByte1[5] = ((byte)(paramShort3 >> 0));
            paramArrayOfByte1[6] = ((byte)(paramShort4 >> 8));
            paramArrayOfByte1[7] = ((byte)(paramShort4 >> 0));
            paramArrayOfByte1 = new Tlv((short)3, (short)paramArrayOfByte1.length, paramArrayOfByte1);
            localArrayList.add(paramArrayOfByte1);
            paramShort1 = paramArrayOfByte1.d() + (paramShort1 + paramShort2);
          }
          else if (this.l.get(0))
          {
            paramArrayOfByte1 = TlvUtils.a(paramArrayOfByte1);
            a(this.n, paramArrayOfByte1);
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
  
  public void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5))
    {
      if (!this.l.get(paramInt))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setExtInfo, flag[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.w("EffectsRenderController", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      }
      this.l.set(paramInt);
      return;
    }
    if (paramInt < 5) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setExtInfo fail, EXP_BIT_MAX[5");
    localStringBuilder.append(HardCodeUtil.a(2131902028));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean b()
  {
    if (!c()) {
      return false;
    }
    SessionInfo localSessionInfo = SessionMgr.a().b();
    int i;
    if ((localSessionInfo.g != 2) && (localSessionInfo.g != 4)) {
      i = 0;
    } else {
      i = 1;
    }
    return (i != 0) && ((!localSessionInfo.bG.isEmpty()) || (this.m.z()) || (localSessionInfo.bL));
  }
  
  public void c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5))
    {
      if (this.l.get(paramInt))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearExtInfo, flag[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.w("EffectsRenderController", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      }
      this.l.clear(paramInt);
    }
  }
  
  protected void d(long paramLong)
  {
    if (this.m.d(2)) {
      ((EffectPendantTools)this.m.c(2)).l();
    }
    super.d(paramLong);
  }
  
  public void g()
  {
    super.g();
    TipsInfo.a().a(this.k);
  }
  
  public void h()
  {
    TipsInfo.a().a(null);
    super.h();
  }
  
  public float[] i()
  {
    return VideoController.f().t.a();
  }
  
  protected void k()
  {
    if (this.m.d(2)) {
      ((EffectPendantTools)this.m.c(2)).l();
    }
    super.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectsRenderController
 * JD-Core Version:    0.7.0.1
 */