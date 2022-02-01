package com.tencent.av.business.manager.avatar2d;

import android.text.TextUtils;
import com.tencent.av.AVPathUtil;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.EffectMutexManager;
import com.tencent.av.business.manager.EffectMutexManager.IMutexItem;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.business.processor.Avatar2dConfigFileProcessor;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.List;

public class EffectAvatar2dManager
  extends EffectConfigBase<Avatar2dItem>
  implements EffectMutexManager.IMutexItem
{
  protected final EffectAvatar2dManager.Avatar2d k = new EffectAvatar2dManager.Avatar2d();
  private boolean l = false;
  
  public EffectAvatar2dManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private void b(int paramInt)
  {
    EffectsRenderController localEffectsRenderController = this.c.b().m(true);
    if (localEffectsRenderController != null) {
      localEffectsRenderController.b(paramInt);
    }
  }
  
  public EffectAvatar2dManager.Avatar2d a(int paramInt1, int paramInt2)
  {
    if (!EffectsRenderController.m()) {
      return null;
    }
    VideoMemoryManager.getInstance().setForceLoadFromSdCard(true);
    Avatar2dItem localAvatar2dItem = (Avatar2dItem)c();
    if ((paramInt1 != 0) && (paramInt2 != 0) && (localAvatar2dItem != null) && (!TextUtils.isEmpty(localAvatar2dItem.getId())))
    {
      String str1 = c(localAvatar2dItem);
      String str2 = localAvatar2dItem.getId();
      if ((str1.equals(this.k.b)) && (this.k.c != null) && (str2.equals(this.k.c.getId()))) {
        return this.k;
      }
      long l1 = System.currentTimeMillis();
      VideoMaterial localVideoMaterial = VideoMaterial.loadLightAsset(str1);
      EffectAvatar2dManager.Avatar2d localAvatar2d = this.k;
      localAvatar2d.a = localVideoMaterial;
      localAvatar2d.c = localAvatar2dItem;
      localAvatar2d.b = str1;
      QLog.i(this.a, 2, String.format("getVideoAvatar2d, patternPath[%s], id[%s], material[%s], cost[%s]", new Object[] { str1, str2, localVideoMaterial, Long.valueOf(System.currentTimeMillis() - l1) }));
      return this.k;
    }
    if (!TextUtils.isEmpty(this.k.b)) {
      this.k.b = null;
    }
    return null;
  }
  
  public String a(Avatar2dItem paramAvatar2dItem)
  {
    if (paramAvatar2dItem != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AVPathUtil.f());
      localStringBuilder.append(paramAvatar2dItem.getMd5());
      localStringBuilder.append(File.separator);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  protected void a()
  {
    EffectMutexManager localEffectMutexManager = (EffectMutexManager)this.c.c(12);
    if (localEffectMutexManager != null) {
      localEffectMutexManager.a(3006, this);
    }
  }
  
  protected void a(int paramInt)
  {
    EffectsRenderController localEffectsRenderController = this.c.b().m(false);
    if (localEffectsRenderController != null) {
      localEffectsRenderController.c(paramInt);
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 3) {
      return;
    }
    this.l = false;
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean a(long paramLong, Avatar2dItem paramAvatar2dItem)
  {
    if (paramAvatar2dItem == null) {
      a(0);
    }
    boolean bool = super.a(paramLong, paramAvatar2dItem);
    if ((bool) && (paramAvatar2dItem != null) && (!TextUtils.isEmpty(paramAvatar2dItem.getId())) && (!TextUtils.equals("0", paramAvatar2dItem.getId())))
    {
      b(0);
      EffectMutexManager localEffectMutexManager = (EffectMutexManager)this.c.c(12);
      if (localEffectMutexManager != null) {
        localEffectMutexManager.a(3006, paramAvatar2dItem.getId());
      }
    }
    return bool;
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b(Avatar2dItem paramAvatar2dItem)
  {
    if (paramAvatar2dItem != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AVPathUtil.e());
      localStringBuilder.append(paramAvatar2dItem.getMd5());
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MuteByOthers, fromMuteKey[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], data[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
    if (paramInt == 3006) {
      return;
    }
    a(0L, null);
  }
  
  public String c(Avatar2dItem paramAvatar2dItem)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramAvatar2dItem != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a(paramAvatar2dItem));
      ((StringBuilder)localObject2).append(paramAvatar2dItem.a());
      ((StringBuilder)localObject2).append(File.separator);
      String str = ((StringBuilder)localObject2).toString();
      if (new File(str).exists()) {
        localObject1 = str;
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (QLog.isDevelopLevel())
        {
          localObject2 = this.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFilterPathForRead, new[");
          localStringBuilder.append(str);
          localStringBuilder.append("], item[");
          localStringBuilder.append(paramAvatar2dItem);
          localStringBuilder.append("]");
          QLog.i((String)localObject2, 4, localStringBuilder.toString());
          localObject2 = localObject1;
        }
      }
    }
    return localObject2;
  }
  
  protected boolean e()
  {
    return true;
  }
  
  protected void f()
  {
    if ((this.e == null) || (this.e.size() == 0))
    {
      this.e = ((Avatar2dConfigFileProcessor)((EffectMaterialManager)this.c.c(15)).a(3)).a(AVPathUtil.m(), "avatar_2d_update_template.json", "avatar_2d_default_template.json");
      a(this.e);
    }
  }
  
  protected Class<?> i()
  {
    return Avatar2dItem.class;
  }
  
  public boolean j()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager
 * JD-Core Version:    0.7.0.1
 */