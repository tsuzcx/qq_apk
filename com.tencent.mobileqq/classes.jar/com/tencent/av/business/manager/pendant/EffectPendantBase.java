package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.AVPathUtil;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.EffectMutexManager;
import com.tencent.av.business.manager.EffectMutexManager.IMutexItem;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public abstract class EffectPendantBase
  extends EffectConfigBase<PendantItem>
  implements EffectMutexManager.IMutexItem
{
  protected boolean o = false;
  protected String[] p = null;
  protected EffectPendantTipsImpl q = null;
  protected final EffectPendantBase.Pendant r = new EffectPendantBase.Pendant();
  
  public EffectPendantBase(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public EffectPendantBase.Pendant a(int paramInt1, int paramInt2)
  {
    if (!EffectsRenderController.m()) {
      return null;
    }
    VideoMemoryManager.getInstance().setForceLoadFromSdCard(true);
    PendantItem localPendantItem = (PendantItem)c();
    if (this.o)
    {
      this.o = false;
      l();
    }
    if ((paramInt1 != 0) && (paramInt2 != 0) && (localPendantItem != null) && (!TextUtils.isEmpty(localPendantItem.getId())))
    {
      String str1 = c(localPendantItem);
      String str2 = localPendantItem.getId();
      if ((str1.equals(this.r.b)) && (this.r.c != null) && (str2.equals(this.r.c.getId()))) {
        return this.r;
      }
      long l = System.currentTimeMillis();
      VideoMaterial localVideoMaterial = VideoMaterial.loadLightAsset(str1);
      EffectPendantBase.Pendant localPendant = this.r;
      localPendant.a = localVideoMaterial;
      localPendant.c = localPendantItem;
      localPendant.b = str1;
      AVLog.printColorLog(this.a, String.format("getVideoPendant, patternPath[%s], id[%s], material[%s], cost[%s]", new Object[] { str1, str2, localVideoMaterial, Long.valueOf(System.currentTimeMillis() - l) }));
      return this.r;
    }
    if (!TextUtils.isEmpty(this.r.b)) {
      this.r.b = null;
    }
    return null;
  }
  
  public String a(PendantItem paramPendantItem)
  {
    if (paramPendantItem != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AVPathUtil.c());
      localStringBuilder.append(paramPendantItem.getMd5());
      return localStringBuilder.toString();
    }
    return null;
  }
  
  protected void a()
  {
    super.a();
    EffectMutexManager localEffectMutexManager = (EffectMutexManager)this.c.c(12);
    if (localEffectMutexManager != null) {
      localEffectMutexManager.a(k(), this);
    }
  }
  
  public void a(EffectPendantTipsImpl paramEffectPendantTipsImpl)
  {
    this.q = paramEffectPendantTipsImpl;
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    SessionInfo localSessionInfo = VideoController.f().k();
    b(paramLong, paramPendantItem);
    if ((paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())))
    {
      localSessionInfo.bG.set(1);
      return bool;
    }
    localSessionInfo.bG.clear(1);
    return bool;
  }
  
  protected boolean a(String paramString)
  {
    return PtuResChecker.a().a(this.c);
  }
  
  public String b(PendantItem paramPendantItem)
  {
    if (paramPendantItem != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AVPathUtil.d());
      localStringBuilder.append(paramPendantItem.getMd5());
      localStringBuilder.append(File.separator);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  protected void b(long paramLong, PendantItem paramPendantItem)
  {
    if (this.c != null) {
      ((EffectFilterTools)this.c.c(1)).a(paramLong, paramPendantItem);
    }
  }
  
  protected String c(PendantItem paramPendantItem)
  {
    Object localObject1 = "";
    Object localObject3 = localObject1;
    if (paramPendantItem != null)
    {
      Object localObject2 = null;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(b(paramPendantItem));
      ((StringBuilder)localObject3).append(paramPendantItem.getName());
      ((StringBuilder)localObject3).append(File.separator);
      String str = ((StringBuilder)localObject3).toString();
      if (new File(str).exists())
      {
        localObject1 = str;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(AVPathUtil.b());
        ((StringBuilder)localObject2).append(paramPendantItem.getName());
        ((StringBuilder)localObject2).append(File.separator);
        localObject3 = ((StringBuilder)localObject2).toString();
        localObject2 = localObject3;
        if (new File((String)localObject3).exists())
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
        }
      }
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = localObject1;
        if (QLog.isDevelopLevel())
        {
          localObject3 = this.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFilterPathForRead, new[");
          localStringBuilder.append(str);
          localStringBuilder.append("], old[");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("], item[");
          localStringBuilder.append(paramPendantItem);
          localStringBuilder.append("]");
          QLog.i((String)localObject3, 4, localStringBuilder.toString());
          localObject3 = localObject1;
        }
      }
    }
    return localObject3;
  }
  
  public List<PendantItem> c(String paramString)
  {
    paramString = super.c(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString != null) {
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  protected boolean d(PendantItem paramPendantItem)
  {
    boolean bool = super.d(paramPendantItem);
    if (bool)
    {
      String str1 = c(paramPendantItem);
      Object localObject1 = this.p;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int m = localObject1.length;
        int k = 0;
        int i = 0;
        for (;;)
        {
          j = i;
          if (k >= m) {
            break;
          }
          String str2 = localObject1[k];
          Object localObject2 = new File(str1, str2);
          long l = ((File)localObject2).length();
          if (((((File)localObject2).exists()) && (l < 1L)) || (!((File)localObject2).exists())) {
            j = 1;
          } else {
            j = 0;
          }
          if ((j == 0) && (i == 0)) {
            i = 0;
          } else {
            i = 1;
          }
          if ((j != 0) && (QLog.isColorLevel()))
          {
            localObject2 = this.a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isTemplateUsable, fileName[");
            localStringBuilder.append(str2);
            localStringBuilder.append("], item[");
            localStringBuilder.append(paramPendantItem);
            localStringBuilder.append("]");
            QLog.i((String)localObject2, 2, localStringBuilder.toString());
          }
          if (i != 0)
          {
            j = i;
            break;
          }
          k += 1;
        }
      }
      int j = 0;
      if (j != 0)
      {
        str1 = a(paramPendantItem);
        localObject1 = b(paramPendantItem);
        ThreadManager.excute(new EffectPendantBase.1(this, new File(str1), (String)localObject1), 16, null, false);
        if (QLog.isDevelopLevel())
        {
          str1 = this.a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("isTemplateUsable, need unzip item[");
          ((StringBuilder)localObject1).append(paramPendantItem);
          ((StringBuilder)localObject1).append("]");
          QLog.i(str1, 4, ((StringBuilder)localObject1).toString());
        }
      }
    }
    return bool;
  }
  
  protected Class<?> i()
  {
    return PendantItem.class;
  }
  
  public abstract int k();
  
  public void l()
  {
    EffectPendantBase.Pendant localPendant = this.r;
    localPendant.a = null;
    localPendant.c = null;
    localPendant.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantBase
 * JD-Core Version:    0.7.0.1
 */