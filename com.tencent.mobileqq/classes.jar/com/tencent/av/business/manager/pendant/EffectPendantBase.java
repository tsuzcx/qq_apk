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
  protected final EffectPendantBase.Pendant a;
  protected EffectPendantTipsImpl a;
  protected boolean a;
  protected String[] c = null;
  
  public EffectPendantBase(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase$Pendant = new EffectPendantBase.Pendant();
  }
  
  public EffectPendantBase.Pendant a(int paramInt1, int paramInt2)
  {
    if (!EffectsRenderController.f()) {
      return null;
    }
    VideoMemoryManager.getInstance().setForceLoadFromSdCard(true);
    PendantItem localPendantItem = (PendantItem)a();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      d();
    }
    if ((paramInt1 != 0) && (paramInt2 != 0) && (localPendantItem != null) && (!TextUtils.isEmpty(localPendantItem.getId())))
    {
      String str1 = c(localPendantItem);
      String str2 = localPendantItem.getId();
      if ((str1.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase$Pendant.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase$Pendant.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) && (str2.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase$Pendant.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getId()))) {
        return this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase$Pendant;
      }
      long l = System.currentTimeMillis();
      VideoMaterial localVideoMaterial = VideoMaterial.loadLightAsset(str1);
      EffectPendantBase.Pendant localPendant = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase$Pendant;
      localPendant.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = localVideoMaterial;
      localPendant.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = localPendantItem;
      localPendant.jdField_a_of_type_JavaLangString = str1;
      AVLog.printColorLog(this.jdField_a_of_type_JavaLangString, String.format("getVideoPendant, patternPath[%s], id[%s], material[%s], cost[%s]", new Object[] { str1, str2, localVideoMaterial, Long.valueOf(System.currentTimeMillis() - l) }));
      return this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase$Pendant;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase$Pendant.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase$Pendant.jdField_a_of_type_JavaLangString = null;
    }
    return null;
  }
  
  protected Class<?> a()
  {
    return PendantItem.class;
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
  
  public List<PendantItem> a(String paramString)
  {
    paramString = super.a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString != null) {
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  protected void a()
  {
    super.a();
    EffectMutexManager localEffectMutexManager = (EffectMutexManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
    if (localEffectMutexManager != null) {
      localEffectMutexManager.a(b(), this);
    }
  }
  
  protected void a(long paramLong, PendantItem paramPendantItem)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      ((EffectFilterTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a(paramLong, paramPendantItem);
    }
  }
  
  public void a(EffectPendantTipsImpl paramEffectPendantTipsImpl)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl = paramEffectPendantTipsImpl;
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    SessionInfo localSessionInfo = VideoController.a().a();
    a(paramLong, paramPendantItem);
    if ((paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())))
    {
      localSessionInfo.a.set(1);
      return bool;
    }
    localSessionInfo.a.clear(1);
    return bool;
  }
  
  protected boolean a(PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramPendantItem);
    if (bool)
    {
      String str1 = c(paramPendantItem);
      Object localObject1 = this.c;
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
            localObject2 = this.jdField_a_of_type_JavaLangString;
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
          str1 = this.jdField_a_of_type_JavaLangString;
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
  
  protected boolean a(String paramString)
  {
    return PtuResChecker.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  public abstract int b();
  
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
          localObject3 = this.jdField_a_of_type_JavaLangString;
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
  
  public void d()
  {
    EffectPendantBase.Pendant localPendant = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase$Pendant;
    localPendant.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    localPendant.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
    localPendant.jdField_a_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantBase
 * JD-Core Version:    0.7.0.1
 */