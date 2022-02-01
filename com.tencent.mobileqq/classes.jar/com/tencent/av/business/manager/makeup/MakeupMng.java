package com.tencent.av.business.manager.makeup;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectMutexManager;
import com.tencent.av.business.manager.pendant.EffectPendantBase;
import com.tencent.av.business.manager.pendant.EffectPendantBase.Pendant;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MakeupMng
  extends EffectPendantBase
{
  public static final String[] k = { "params.dat" };
  public final ConcurrentHashMap<String, Integer> l = new ConcurrentHashMap();
  public String m = null;
  public int n = 0;
  private int s = 0;
  
  public MakeupMng(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.p = k;
  }
  
  private void a(EffectPendantBase.Pendant paramPendant)
  {
    if ((paramPendant.a != null) && (!paramPendant.a.needFaceInfo()))
    {
      PendantItem localPendantItem = (PendantItem)c();
      String str = c(localPendantItem);
      paramPendant.a = VideoMaterial.loadLightAsset(str);
      paramPendant.c = localPendantItem;
      paramPendant.b = str;
    }
  }
  
  public EffectPendantBase.Pendant a(int paramInt1, int paramInt2)
  {
    if (this.s == 3002) {
      b(0L, "getVideoPendant");
    }
    EffectPendantBase.Pendant localPendant = super.a(paramInt1, paramInt2);
    if ((localPendant != null) && (localPendant.c != null))
    {
      a(localPendant);
      localPendant.c.extraParam = Integer.valueOf(this.n);
    }
    return localPendant;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (j()) {
      return;
    }
    if ((!TextUtils.equals(paramString, this.m)) || (paramInt != this.n))
    {
      this.m = paramString;
      this.n = paramInt;
      if (!TextUtils.isEmpty(this.m)) {
        this.l.put(this.m, Integer.valueOf(paramInt));
      }
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    Object localObject = (PendantItem)c();
    if (localObject == null)
    {
      this.m = null;
      this.n = 50;
    }
    else
    {
      this.m = ((PendantItem)localObject).getId();
    }
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyUI, peerUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], quit[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], item[");
      localStringBuilder.append(c());
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    if ((!j()) && (bool) && (paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())) && (!TextUtils.equals("0", paramPendantItem.getId())))
    {
      EffectMutexManager localEffectMutexManager = (EffectMutexManager)this.c.c(12);
      if (localEffectMutexManager != null) {
        localEffectMutexManager.a(3004, paramPendantItem.getId());
      }
    }
    return bool;
  }
  
  public int b()
  {
    return 591;
  }
  
  public void b(int paramInt, String paramString)
  {
    long l1 = AudioHelper.c();
    if (QLog.isDevelopLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MuteByOthers, fromMuteKey[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], data[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w(str, 4, localStringBuilder.toString());
    }
    if (paramInt == 3004) {
      return;
    }
    if (paramInt == 3002)
    {
      a(l1, null);
      this.s = 3002;
      return;
    }
    if (paramInt == 3003) {
      return;
    }
    if (paramInt == 3005)
    {
      this.s = 3005;
      a(l1, null);
      return;
    }
    if (paramInt == 3006)
    {
      this.s = 3006;
      a(l1, null);
    }
  }
  
  public void b(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearMuteFlag, muteFlag[");
      localStringBuilder.append(this.s);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], cur[");
      localStringBuilder.append(this.m);
      localStringBuilder.append("], value[");
      localStringBuilder.append(this.n);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
    int i = this.s;
    if ((i == 3003) || (i == 3005)) {
      a(paramLong, this.m);
    }
    this.s = 0;
  }
  
  protected List<PendantItem> c(int paramInt, String paramString)
  {
    Object localObject1 = super.c(paramInt, paramString);
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PendantItem)((Iterator)localObject1).next();
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parse, cid[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], config[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("], size[");
      ((StringBuilder)localObject2).append(localArrayList.size());
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return localArrayList;
  }
  
  public int d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramString = (Integer)this.l.get(paramString);
    } else {
      paramString = null;
    }
    if (paramString == null) {
      return 50;
    }
    return paramString.intValue();
  }
  
  public boolean j()
  {
    int i = this.s;
    return (i == 3002) || (i == 3003);
  }
  
  public int k()
  {
    return 3004;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.makeup.MakeupMng
 * JD-Core Version:    0.7.0.1
 */