package com.tencent.av.business.processor;

import android.text.TextUtils;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.av.AVPathUtil;
import com.tencent.av.business.manager.avatar2d.Avatar2dItem;
import com.tencent.av.utils.EffectMaterialUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Avatar2dConfigFileProcessor
  extends BaseConfigFileProcessor<Avatar2dItem>
{
  public Avatar2dConfigFileProcessor(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public Avatar2dItem a(MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial == null) {
      return null;
    }
    Avatar2dItem localAvatar2dItem = new Avatar2dItem();
    localAvatar2dItem.a(paramMetaMaterial.id);
    localAvatar2dItem.b(paramMetaMaterial.id);
    localAvatar2dItem.c(paramMetaMaterial.thumbUrl);
    localAvatar2dItem.e(paramMetaMaterial.packageUrl);
    localAvatar2dItem.f(paramMetaMaterial.packageMd5);
    boolean bool = TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("version"));
    String str2 = "";
    String str1;
    if (bool) {
      str1 = "";
    } else {
      str1 = (String)paramMetaMaterial.additionalFields.get("version");
    }
    localAvatar2dItem.d(str1);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("displayName"))) {
      str1 = "";
    } else {
      str1 = (String)paramMetaMaterial.additionalFields.get("displayName");
    }
    localAvatar2dItem.k(str1);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("key_local_use_category_id"))) {
      str1 = "";
    } else {
      str1 = (String)paramMetaMaterial.additionalFields.get("key_local_use_category_id");
    }
    localAvatar2dItem.g(str1);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("key_local_use_category_name"))) {
      paramMetaMaterial = str2;
    } else {
      paramMetaMaterial = (String)paramMetaMaterial.additionalFields.get("key_local_use_category_name");
    }
    localAvatar2dItem.h(paramMetaMaterial);
    return localAvatar2dItem;
  }
  
  public String a()
  {
    return AVPathUtil.n();
  }
  
  public List<Avatar2dItem> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = b(paramFile);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadMaterialListFromFile -> jsonStr: ");
      ((StringBuilder)localObject1).append(paramFile);
      QLog.i("Avatar2dConfigFileProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(paramFile)) {
      return localArrayList;
    }
    Object localObject2 = new Gson();
    Object localObject1 = null;
    try
    {
      paramFile = (GetCatMatTreeRsp)((Gson)localObject2).fromJson(paramFile, GetCatMatTreeRsp.class);
    }
    catch (Exception paramFile)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadMaterialListFromFile exception = ");
      ((StringBuilder)localObject2).append(paramFile.getMessage());
      QLog.e("Avatar2dConfigFileProcessor", 1, ((StringBuilder)localObject2).toString());
      paramFile = null;
    }
    if ((paramFile != null) && (paramFile.Categories != null))
    {
      if (paramFile.Categories.size() > 0) {
        localObject1 = (MetaCategory)paramFile.Categories.get(0);
      }
      if (localObject1 == null)
      {
        QLog.e("Avatar2dConfigFileProcessor", 1, "loadMaterialListFromFile total category = null");
        return localArrayList;
      }
      paramFile = new ArrayList();
      paramFile.add(localObject1);
      paramFile = a(paramFile).iterator();
      while (paramFile.hasNext())
      {
        localObject1 = (MetaMaterial)paramFile.next();
        if (localObject1 != null) {
          localArrayList.add(a((MetaMaterial)localObject1));
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.i("Avatar2dConfigFileProcessor", 2, "loadMaterialListFromFile result: ");
        paramFile = localArrayList.iterator();
        while (paramFile.hasNext())
        {
          localObject1 = (Avatar2dItem)paramFile.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("pendant item: ");
          ((StringBuilder)localObject2).append(((Avatar2dItem)localObject1).toString());
          QLog.i("Avatar2dConfigFileProcessor", 2, ((StringBuilder)localObject2).toString());
        }
      }
      return localArrayList;
    }
    QLog.e("Avatar2dConfigFileProcessor", 2, "no materials return");
    return localArrayList;
  }
  
  public void b()
  {
    EffectMaterialUtil.b(BaseApplication.getContext(), "ShadowBackendSvc.GetCatMatTreeQQAVAvatar2d");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.processor.Avatar2dConfigFileProcessor
 * JD-Core Version:    0.7.0.1
 */