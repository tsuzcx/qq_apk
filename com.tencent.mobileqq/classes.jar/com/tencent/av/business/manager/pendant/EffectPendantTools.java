package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.AVPathUtil;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectMutexManager;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.business.manager.panorama.PanoramaSensorManager;
import com.tencent.av.business.processor.PendantConfigFileProcessor;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.FabbyMvPart;
import com.tencent.ttpic.openapi.filter.FabbyParts;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class EffectPendantTools
  extends EffectPendantBase
{
  public String b = null;
  
  public EffectPendantTools(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static int a(PendantItem paramPendantItem, boolean paramBoolean)
  {
    int i = 4;
    if ((paramPendantItem != null) || (paramBoolean))
    {
      int j = AEFilterSupport.a();
      if (j == 3) {
        break label34;
      }
      if (j == 4) {
        return i;
      }
      if (j == 7) {}
    }
    else
    {
      return 0;
    }
    return 5;
    label34:
    i = 3;
    return i;
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getFabbyParts() != null))
    {
      paramVideoMaterial = paramVideoMaterial.getFabbyParts().getParts().iterator();
      while (paramVideoMaterial.hasNext())
      {
        FabbyMvPart localFabbyMvPart = (FabbyMvPart)paramVideoMaterial.next();
        if ((localFabbyMvPart.bgItem != null) && (localFabbyMvPart.bgItem.name != null) && (localFabbyMvPart.bgItem.name.endsWith("_360"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int a()
  {
    return 106;
  }
  
  public EffectPendantBase.Pendant a(int paramInt1, int paramInt2)
  {
    EffectPendantBase.Pendant localPendant = super.a(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl != null) && (localPendant != null) && (localPendant.a != null))
    {
      boolean bool = PanoramaSensorManager.a().b();
      if ((!a(localPendant.a)) || (bool)) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTipsImpl.c(0);
      }
    }
    return localPendant;
  }
  
  public void a(int paramInt, String paramString)
  {
    long l = AudioHelper.b();
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MuteByOthers, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("], fromMuteKey[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], data[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w(str, 4, localStringBuilder.toString());
    }
    if (paramInt == b()) {
      return;
    }
    if (paramInt == 3003) {
      return;
    }
    if ((paramInt == 3001) || (paramInt == 3004) || (paramInt == 3005)) {
      a(l, "0");
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt != 2) && (paramInt != 3)) {
      return;
    }
    paramString1 = (PendantItem)a();
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.getId()))) {
      a(paramLong, null);
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    Object localObject1;
    if ((bool) && (paramPendantItem != null) && (!TextUtils.equals("0", paramPendantItem.getId())))
    {
      localObject1 = (EffectMutexManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
      if (localObject1 != null) {
        ((EffectMutexManager)localObject1).a(3002, paramPendantItem.getId());
      }
    }
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    if (paramPendantItem == null) {
      localObject1 = null;
    } else {
      localObject1 = paramPendantItem.getId();
    }
    EffectPendantTools.DataReport.a((String)localObject2, (String)localObject1);
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setCurrentItem, item[");
      ((StringBuilder)localObject2).append(paramPendantItem);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return bool;
  }
  
  protected boolean a(PendantItem paramPendantItem)
  {
    if ((a() > 0) && (paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())))
    {
      if (TextUtils.isEmpty(paramPendantItem.getResUrl())) {
        return true;
      }
      localObject1 = new File(a(paramPendantItem));
      boolean bool = ((File)localObject1).exists();
      Object localObject3;
      Object localObject2;
      long l1;
      if (!bool)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(AVPathUtil.b());
        ((StringBuilder)localObject1).append(paramPendantItem.getName());
        localObject3 = ((StringBuilder)localObject1).toString();
        localObject2 = new File((String)localObject3);
        localObject1 = localObject2;
        if (((File)localObject2).exists())
        {
          l1 = System.currentTimeMillis();
          localObject1 = SecUtil.getFileMd5((String)localObject3);
          long l2 = System.currentTimeMillis();
          localObject3 = paramPendantItem.getMd5();
          String str = this.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isTemplateUsable :");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("|");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append("|");
          localStringBuilder.append(l2 - l1);
          AVLog.printColorLog(str, localStringBuilder.toString());
          bool = ((String)localObject3).equalsIgnoreCase((String)localObject1);
          localObject1 = localObject2;
        }
      }
      if (bool)
      {
        localObject2 = c(paramPendantItem);
        localObject3 = new File((String)localObject2, "params.json");
        l1 = ((File)localObject3).length();
        int i;
        if (((((File)localObject3).exists()) && (l1 < 1L)) || (!((File)localObject3).exists())) {
          i = 1;
        } else {
          i = 0;
        }
        int j = i;
        if (i != 0)
        {
          localObject2 = new File((String)localObject2, "params.dat");
          l1 = ((File)localObject2).length();
          if (((((File)localObject2).exists()) && (l1 < 1L)) || (!((File)localObject2).exists())) {
            j = 1;
          } else {
            j = 0;
          }
        }
        if (j != 0)
        {
          ThreadManager.post(new EffectPendantTools.1(this, (File)localObject1, paramPendantItem), 5, null, false);
          return false;
        }
      }
      return bool;
    }
    paramPendantItem = this.jdField_a_of_type_JavaLangString;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isTemplateUsable:");
    ((StringBuilder)localObject1).append(a());
    ((StringBuilder)localObject1).append("|");
    AVLog.printErrorLog(paramPendantItem, ((StringBuilder)localObject1).toString());
    return false;
  }
  
  public int b()
  {
    return 3002;
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.jdField_a_of_type_JavaUtilList = ((PendantConfigFileProcessor)((EffectMaterialManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(1)).a(AVPathUtil.g(), "pendant_update_template.json", "pendant_default_template.json");
      a(this.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTools
 * JD-Core Version:    0.7.0.1
 */