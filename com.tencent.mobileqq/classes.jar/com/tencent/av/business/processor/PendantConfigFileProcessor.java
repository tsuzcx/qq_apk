package com.tencent.av.business.processor;

import android.text.TextUtils;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.av.AVPathUtil;
import com.tencent.av.abtest.QavEffectUIABTestUtils;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.utils.EffectMaterialUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PendantConfigFileProcessor
  extends BaseConfigFileProcessor<PendantItem>
{
  public PendantConfigFileProcessor(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public PendantItem a(MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial == null) {
      return null;
    }
    PendantItem localPendantItem = new PendantItem();
    localPendantItem.setId(paramMetaMaterial.id);
    localPendantItem.setName(paramMetaMaterial.id);
    localPendantItem.setIconurl(paramMetaMaterial.thumbUrl);
    localPendantItem.setResurl(paramMetaMaterial.packageUrl);
    localPendantItem.setMd5(paramMetaMaterial.packageMd5);
    localPendantItem.setPredownload(TextUtils.equals("true", (CharSequence)paramMetaMaterial.additionalFields.get("predownload")));
    localPendantItem.setIsshow(TextUtils.equals("false", (CharSequence)paramMetaMaterial.additionalFields.get("isshow")) ^ true);
    localPendantItem.setKind(b(paramMetaMaterial));
    localPendantItem.setType(c(paramMetaMaterial));
    localPendantItem.setCategory(d(paramMetaMaterial));
    boolean bool = TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("version"));
    String str = "";
    Object localObject;
    if (bool) {
      localObject = "";
    } else {
      localObject = (String)paramMetaMaterial.additionalFields.get("version");
    }
    localPendantItem.setVersion((String)localObject);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("gestureType"))) {
      localObject = "";
    } else {
      localObject = (String)paramMetaMaterial.additionalFields.get("gestureType");
    }
    localPendantItem.setGestureType((String)localObject);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("gestureWording"))) {
      localObject = "";
    } else {
      localObject = (String)paramMetaMaterial.additionalFields.get("gestureWording");
    }
    localPendantItem.setGestureWording((String)localObject);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("key_local_use_category_id"))) {
      localObject = "";
    } else {
      localObject = (String)paramMetaMaterial.additionalFields.get("key_local_use_category_id");
    }
    localPendantItem.setCategoryId((String)localObject);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("key_local_use_category_name"))) {
      localObject = str;
    } else {
      localObject = (String)paramMetaMaterial.additionalFields.get("key_local_use_category_name");
    }
    localPendantItem.setCategoryName((String)localObject);
    paramMetaMaterial = (String)paramMetaMaterial.additionalFields.get("originName");
    if (!TextUtils.isEmpty(paramMetaMaterial))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("convertFromMetaMaterial originName: ");
        ((StringBuilder)localObject).append(paramMetaMaterial);
        QLog.i("PendantConfigFileProcessor", 2, ((StringBuilder)localObject).toString());
      }
      localPendantItem.setId(paramMetaMaterial);
      localPendantItem.setName(paramMetaMaterial);
    }
    return localPendantItem;
  }
  
  public String a()
  {
    return AVPathUtil.j();
  }
  
  public List<PendantItem> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = b(paramFile);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadMaterialListFromFile -> jsonStr: ");
      ((StringBuilder)localObject1).append(paramFile);
      QLog.i("PendantConfigFileProcessor", 2, ((StringBuilder)localObject1).toString());
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
      QLog.e("PendantConfigFileProcessor", 1, ((StringBuilder)localObject2).toString());
      paramFile = null;
    }
    if ((paramFile != null) && (paramFile.Categories != null))
    {
      if (paramFile.Categories.size() > 0) {
        localObject1 = (MetaCategory)paramFile.Categories.get(0);
      }
      if (localObject1 == null)
      {
        QLog.e("PendantConfigFileProcessor", 1, "loadMaterialListFromFile total category = null");
        return localArrayList;
      }
      paramFile = new ArrayList();
      paramFile.add(localObject1);
      paramFile = a(paramFile).iterator();
      while (paramFile.hasNext())
      {
        localObject1 = (MetaMaterial)paramFile.next();
        if (localObject1 != null)
        {
          localObject1 = a((MetaMaterial)localObject1);
          if ((QavEffectUIABTestUtils.b(this.a.getCurrentAccountUin())) || (!a(localArrayList, (PendantItem)localObject1))) {
            localArrayList.add(localObject1);
          }
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.i("PendantConfigFileProcessor", 2, "loadMaterialListFromFile result: ");
        paramFile = localArrayList.iterator();
        while (paramFile.hasNext())
        {
          localObject1 = (PendantItem)paramFile.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("pendant item: ");
          ((StringBuilder)localObject2).append(((PendantItem)localObject1).toString());
          QLog.i("PendantConfigFileProcessor", 2, ((StringBuilder)localObject2).toString());
        }
      }
      return localArrayList;
    }
    QLog.e("PendantConfigFileProcessor", 2, "no materials return");
    return localArrayList;
  }
  
  public boolean a(List<PendantItem> paramList, PendantItem paramPendantItem)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return false;
      }
      if (paramPendantItem == null) {
        return true;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (((PendantItem)paramList.next()).getId().equals(paramPendantItem.getId())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int b(MetaMaterial paramMetaMaterial)
  {
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("kind"))) {
      return 0;
    }
    try
    {
      int i = Integer.parseInt((String)paramMetaMaterial.additionalFields.get("kind"));
      return i;
    }
    catch (Exception paramMetaMaterial)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getKind exception: ");
      localStringBuilder.append(paramMetaMaterial.getMessage());
      QLog.e("PendantConfigFileProcessor", 1, localStringBuilder.toString());
    }
    return 0;
  }
  
  public void b()
  {
    EffectMaterialUtil.b(BaseApplication.getContext(), "ShadowBackendSvc.GetCatMatTreeQQAVSinglePendantV2");
  }
  
  public int c(MetaMaterial paramMetaMaterial)
  {
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("type"))) {
      return 0;
    }
    try
    {
      int i = Integer.parseInt((String)paramMetaMaterial.additionalFields.get("type"));
      return i;
    }
    catch (Exception paramMetaMaterial)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getType exception: ");
      localStringBuilder.append(paramMetaMaterial.getMessage());
      QLog.e("PendantConfigFileProcessor", 1, localStringBuilder.toString());
    }
    return 0;
  }
  
  public int d(MetaMaterial paramMetaMaterial)
  {
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("category"))) {
      return 0;
    }
    try
    {
      int i = Integer.parseInt((String)paramMetaMaterial.additionalFields.get("category"));
      return i;
    }
    catch (Exception paramMetaMaterial)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCategory exception: ");
      localStringBuilder.append(paramMetaMaterial.getMessage());
      QLog.e("PendantConfigFileProcessor", 1, localStringBuilder.toString());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.processor.PendantConfigFileProcessor
 * JD-Core Version:    0.7.0.1
 */