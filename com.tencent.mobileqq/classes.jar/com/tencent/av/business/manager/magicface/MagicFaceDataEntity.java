package com.tencent.av.business.manager.magicface;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.Tlv;
import com.tencent.av.opengl.TlvUtils;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MagicFaceDataEntity
  extends MagicfaceData
{
  protected VideoAppInterface a;
  protected Handler b;
  protected MagicFaceDataEntity.MyDataObserver c;
  VideoController d;
  int[] e;
  int f;
  boolean g;
  boolean h;
  BitSet i;
  MagicFaceDataEntity.StopSelfDecorationRunnable j;
  EffectPendantTools k;
  MagicFaceDataEntity.MyDownloadListener l;
  
  public MagicFaceDataEntity(VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramString3, paramString1, paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("MagicFaceDataEntity constructor:");
    paramString2.append(paramString1);
    paramString2.append("|");
    paramString2.append(paramBoolean);
    paramString2.append("|");
    paramString2.append(paramInt);
    AVLog.printColorLog("MagicFaceDataEntity", paramString2.toString());
    this.a = paramVideoAppInterface;
    this.h = paramBoolean;
    this.b = new MagicFaceDataEntity.MyHandler(this, Looper.getMainLooper());
    this.e = h();
    this.i = new BitSet();
    if ((paramInt & 0x1) != 0) {
      this.i.set(0);
    }
    if ((paramInt & 0x2) != 0) {
      this.i.set(1);
    }
    this.d = this.a.b();
    this.k = ((EffectPendantTools)this.a.c(2));
    this.l = new MagicFaceDataEntity.MyDownloadListener(this);
    this.c = new MagicFaceDataEntity.MyDataObserver(this);
    this.a.a(this.c);
    this.f = 0;
  }
  
  private void a(long paramLong, PendantItem paramPendantItem)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startSelfDecoration, info[");
    ((StringBuilder)localObject1).append(paramPendantItem.getName());
    ((StringBuilder)localObject1).append("], seq[");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("]");
    QLog.w("MagicFaceDataEntity", 1, ((StringBuilder)localObject1).toString());
    this.k.a(paramLong, paramPendantItem);
    if (!TextUtils.isEmpty(paramPendantItem.getName()))
    {
      Object localObject2 = b(paramPendantItem.getName());
      localObject1 = (MagicfaceDataPendantJason)this.t.get(localObject2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startSelfDecoration 2:");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("|");
      localStringBuilder.append(localObject1);
      AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
      if ((localObject1 != null) && (((MagicfaceDataPendantJason)localObject1).duration > 0))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startSelfDecoration 3:");
        ((StringBuilder)localObject2).append(((MagicfaceDataPendantJason)localObject1).duration);
        AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject2).toString());
        int m = ((MagicfaceDataPendantJason)localObject1).duration;
        this.j = new MagicFaceDataEntity.StopSelfDecorationRunnable(this, paramPendantItem);
        this.b.postDelayed(this.j, m);
      }
    }
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onReceiveFunChatExpData:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(paramArrayOfByte.length);
    AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject1).toString());
    localObject1 = TlvUtils.a(paramArrayOfByte);
    paramArrayOfByte = (Tlv)((SparseArray)localObject1).get(1);
    Object localObject2 = (Tlv)((SparseArray)localObject1).get(4);
    boolean bool;
    if (localObject2 != null)
    {
      paramArrayOfByte = ((Tlv)localObject2).c();
      bool = true;
    }
    else
    {
      if (paramArrayOfByte != null) {
        paramArrayOfByte = paramArrayOfByte.c();
      } else {
        paramArrayOfByte = null;
      }
      bool = false;
    }
    if (paramArrayOfByte != null)
    {
      localObject2 = (Tlv)((SparseArray)localObject1).get(3);
      short s3 = 240;
      short s2;
      short s4;
      short s1;
      if (localObject2 != null)
      {
        localObject2 = ((Tlv)localObject2).c();
        int m = localObject2[0];
        s2 = (short)(localObject2[1] & 0xFF | m << 8);
        m = localObject2[2];
        s3 = (short)(localObject2[3] & 0xFF | m << 8);
        s4 = (short)(localObject2[4] << 8 | localObject2[5] & 0xFF);
        s1 = (short)(localObject2[6] << 8 | localObject2[7] & 0xFF);
      }
      else
      {
        s2 = 320;
        s4 = 0;
        s1 = 0;
      }
      a(paramString, paramArrayOfByte, s3, s2, s4, s1, bool);
    }
    paramArrayOfByte = (Tlv)((SparseArray)localObject1).get(2);
    if (paramArrayOfByte != null) {
      a(paramString, ByteBuffer.wrap(paramArrayOfByte.c()).getShort());
    }
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    switch (((Integer)paramArrayOfObject[0]).intValue())
    {
    default: 
      return;
    case 132: 
      a(3, (String)paramArrayOfObject[1]);
      return;
    case 131: 
      a(1, (String)paramArrayOfObject[1]);
      return;
    }
    a((String)paramArrayOfObject[1], (byte[])paramArrayOfObject[2]);
  }
  
  private void b(MagicfaceDataPendantJason paramMagicfaceDataPendantJason)
  {
    paramMagicfaceDataPendantJason = a(paramMagicfaceDataPendantJason);
    if (paramMagicfaceDataPendantJason != null) {
      f(paramMagicfaceDataPendantJason);
    }
  }
  
  @Nullable
  private String d(String paramString)
  {
    if (this.t == null) {
      return null;
    }
    Object localObject = this.t.entrySet().iterator();
    int m = 0;
    String str;
    if (localObject != null)
    {
      str = null;
      m = 0;
      while (((Iterator)localObject).hasNext())
      {
        MagicfaceDataPendantJason localMagicfaceDataPendantJason = (MagicfaceDataPendantJason)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (!TextUtils.isEmpty(localMagicfaceDataPendantJason.belongto))
        {
          if ((localMagicfaceDataPendantJason.belongto.equals("sender")) && (this.i.get(0))) {
            str = localMagicfaceDataPendantJason.name;
          }
          for (;;)
          {
            m += 1;
            break;
            if ((localMagicfaceDataPendantJason.belongto.equals("reciever")) && (this.i.get(1)))
            {
              str = localMagicfaceDataPendantJason.name;
            }
            else
            {
              if (!localMagicfaceDataPendantJason.belongto.equals("both")) {
                break;
              }
              str = localMagicfaceDataPendantJason.name;
            }
          }
        }
      }
    }
    else
    {
      str = null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getDecorateNameById: ");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(str);
    AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject).toString());
    if (m == 1) {
      return str;
    }
    return null;
  }
  
  private void e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reloadDecrateList 1:");
    localStringBuilder.append(paramString);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    PtvTemplateManager.a(this.a).a(new MagicFaceDataEntity.1(this, paramString));
  }
  
  private void f(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startSelfPendant 1:");
    ((StringBuilder)localObject).append(paramString);
    AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject).toString());
    if (paramString != null)
    {
      localObject = PtvTemplateManager.a(this.a).d();
      if ((localObject != null) && (((ArrayList)localObject).size() != 0))
      {
        g(paramString);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startSelfPendant, infos[");
      boolean bool;
      if (localObject != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w("MagicFaceDataEntity", 1, localStringBuilder.toString());
      e(paramString);
    }
  }
  
  private boolean f(int paramInt)
  {
    if (this.e != null)
    {
      int m = 0;
      for (;;)
      {
        int[] arrayOfInt = this.e;
        if (m >= arrayOfInt.length) {
          break;
        }
        if (arrayOfInt[m] == paramInt) {
          return true;
        }
        m += 1;
      }
    }
    return false;
  }
  
  private void g(String paramString)
  {
    paramString = h(paramString);
    if (paramString != null)
    {
      long l1 = AudioHelper.c();
      if (AudioHelper.e())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doStartSelfDecoration, seq[");
        localStringBuilder.append(l1);
        localStringBuilder.append("], target[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w("MagicFaceDataEntity", 1, localStringBuilder.toString());
      }
      if (!paramString.isUsable())
      {
        this.k.b(l1, paramString);
        return;
      }
      a(l1, paramString);
    }
  }
  
  @Nullable
  private PendantItem h(String paramString)
  {
    Object localObject = this.k;
    StringBuilder localStringBuilder = null;
    Iterator localIterator = ((EffectPendantTools)localObject).c(null).iterator();
    do
    {
      localObject = localStringBuilder;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (PendantItem)localIterator.next();
    } while (!paramString.equals(((PendantItem)localObject).getName()));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPtvTemplateInfo 1:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|");
    localStringBuilder.append(localObject);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    return localObject;
  }
  
  private int[] h()
  {
    if (this.t != null)
    {
      int m = this.t.size();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getPendantStartFrames 11:");
      ((StringBuilder)localObject1).append(m);
      AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject1).toString());
      if (m > 0)
      {
        localObject1 = new int[m];
        m = 0;
        Iterator localIterator = this.t.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject1[m] = ((MagicfaceDataPendantJason)((Map.Entry)localObject2).getValue()).startframe;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getPendantStartFrames 22:");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("|");
          ((StringBuilder)localObject2).append(localObject1[m]);
          AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject2).toString());
          m += 1;
        }
        return localObject1;
      }
    }
    return null;
  }
  
  String a(int paramInt)
  {
    return "video";
  }
  
  protected String a(MagicfaceDataPendantJason paramMagicfaceDataPendantJason)
  {
    return paramMagicfaceDataPendantJason.name;
  }
  
  protected void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start:");
    localStringBuilder.append(this.p);
    localStringBuilder.append("|");
    localStringBuilder.append(this);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    this.b.obtainMessage(2).sendToTarget();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MagicFaceDataEntity run:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    this.w = paramInt1;
    if (f(paramInt1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" inPendantStartFrames:");
      localStringBuilder.append(paramInt1);
      AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
      this.b.obtainMessage(4, Integer.valueOf(paramInt1)).sendToTarget();
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveFunChatExpCMD:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveFunChatExpCMD 22:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString);
      localStringBuilder.append("|");
      localStringBuilder.append("START");
      AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
      if (paramString.equals("START"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceiveFunChatExpCMD 33:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("|");
        localStringBuilder.append(paramString);
        AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
        d(paramInt);
        return;
      }
      if (paramString.equals("STOP")) {
        c(paramInt);
      }
    }
  }
  
  protected void a(PendantItem paramPendantItem)
  {
    long l1 = AudioHelper.c();
    this.k.a(l1, null);
  }
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveVolume:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, short paramShort1, short paramShort2, short paramShort3, short paramShort4, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivePeerFaceFeature:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|");
    localStringBuilder.append(paramArrayOfByte.length);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
  }
  
  protected void a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "START";
    } else {
      str = "STOP";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestFaceFeatureExp:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("|");
    localStringBuilder.append(str);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    this.d.e(6, str);
  }
  
  protected boolean a(String paramString)
  {
    return this.a.getCurrentAccountUin().equals(paramString);
  }
  
  String b(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.endsWith("_mirror")) {
        str = paramString.substring(0, paramString.length() - 7);
      }
    }
    return str;
  }
  
  protected void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop:");
    localStringBuilder.append(this.p);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    this.b.obtainMessage(3).sendToTarget();
  }
  
  protected void b(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("processStartDecoration:");
    ((StringBuilder)localObject1).append(this.p);
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(this.i.get(0));
    ((StringBuilder)localObject1).append("|");
    ((StringBuilder)localObject1).append(this.i.get(1));
    AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject1).toString());
    localObject1 = this.t.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (MagicfaceDataPendantJason)((Map.Entry)localObject2).getValue();
      if ((paramInt == ((MagicfaceDataPendantJason)localObject2).startframe) && (!TextUtils.isEmpty(((MagicfaceDataPendantJason)localObject2).belongto))) {
        if ((((MagicfaceDataPendantJason)localObject2).belongto.equals("sender")) && (this.i.get(0))) {
          b((MagicfaceDataPendantJason)localObject2);
        } else if ((((MagicfaceDataPendantJason)localObject2).belongto.equals("reciever")) && (this.i.get(1))) {
          b((MagicfaceDataPendantJason)localObject2);
        } else if (((MagicfaceDataPendantJason)localObject2).belongto.equals("both")) {
          b((MagicfaceDataPendantJason)localObject2);
        }
      }
    }
  }
  
  protected void c(int paramInt)
  {
    SessionInfo localSessionInfo = this.d.k();
    EffectsRenderController localEffectsRenderController = this.d.m(false);
    if (localEffectsRenderController != null) {
      localEffectsRenderController.c(paramInt);
    }
    localSessionInfo.bG.clear(0);
  }
  
  protected void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      TipsUtil.b(this.a, 1016);
      return;
    }
    TipsUtil.a(this.a, 1016, paramString);
  }
  
  public boolean c()
  {
    return this.i.get(0);
  }
  
  protected int d()
  {
    return this.r.frame_count;
  }
  
  protected void d(int paramInt)
  {
    SessionInfo localSessionInfo = this.d.k();
    EffectsRenderController localEffectsRenderController = this.d.m(true);
    if (localEffectsRenderController != null) {
      localEffectsRenderController.b(paramInt);
    }
    localSessionInfo.bG.set(0);
  }
  
  protected void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processStart:");
    localStringBuilder.append(this.p);
    localStringBuilder.append("|");
    localStringBuilder.append(this);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    this.k.a(-1041L, this.l);
  }
  
  protected void f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("processStop:");
    ((StringBuilder)localObject).append(this.p);
    AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject).toString());
    if (g() != null) {
      a(null);
    }
    localObject = this.j;
    if (localObject != null)
    {
      this.b.removeCallbacks((Runnable)localObject);
      this.j.run();
      this.j = null;
    }
    this.k.b(-1042L, this.l);
    this.a.b(this.c);
  }
  
  public PendantItem g()
  {
    String str = d(this.p);
    if (str != null) {
      return h(str);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntity
 * JD-Core Version:    0.7.0.1
 */