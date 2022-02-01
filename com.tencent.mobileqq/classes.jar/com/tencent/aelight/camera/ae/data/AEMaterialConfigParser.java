package com.tencent.aelight.camera.ae.data;

import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaAdditionalPackage;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.aelight.camera.aeeditor.module.params.ParamsUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs.GpuBean.DeviceModel;
import com.tencent.ttpic.device.DeviceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AEMaterialConfigParser
{
  public static int a = 5;
  private static final String b = "AEMaterialConfigParser";
  
  public static ArrayList<AEMaterialCategory> a(String paramString)
  {
    Object localObject1 = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localObject1;
    }
    Object localObject2 = new Gson();
    try
    {
      paramString = (GetCategoryMaterialRsp)((Gson)localObject2).fromJson(paramString, GetCategoryMaterialRsp.class);
      if (paramString != null)
      {
        if (paramString.Categories == null) {
          return localObject1;
        }
        a(paramString.Categories, (List)localObject1);
      }
      return localObject1;
    }
    catch (Exception paramString)
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("###  parseMaterialListFromConfig exception = ");
      ((StringBuilder)localObject2).append(paramString.getMessage());
      QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      throw new AEMaterialConfigParser.AEMaterialConfigParseException("parseMaterialListFromConfig error");
    }
  }
  
  private static void a(AEMaterialMetaData paramAEMaterialMetaData, MetaMaterial paramMetaMaterial)
  {
    Object localObject;
    if (paramMetaMaterial.additionalPackage == null)
    {
      paramAEMaterialMetaData.r = paramMetaMaterial.packageUrl;
      paramAEMaterialMetaData.s = paramMetaMaterial.packageMd5;
    }
    else if ((TextUtils.isEmpty(paramMetaMaterial.additionalPackage.superLowPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.lowPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.midPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.highPackageUrl)))
    {
      paramAEMaterialMetaData.r = paramMetaMaterial.packageUrl;
      paramAEMaterialMetaData.s = paramMetaMaterial.packageMd5;
    }
    else
    {
      localObject = new String[5];
      localObject[0] = paramMetaMaterial.additionalPackage.superLowPackageUrl;
      localObject[1] = paramMetaMaterial.additionalPackage.lowPackageUrl;
      localObject[2] = paramMetaMaterial.additionalPackage.midPackageUrl;
      localObject[3] = paramMetaMaterial.additionalPackage.highPackageUrl;
      localObject[4] = paramMetaMaterial.packageUrl;
      String[] arrayOfString = new String[5];
      arrayOfString[0] = paramMetaMaterial.additionalPackage.superLowPackageMd5;
      arrayOfString[1] = paramMetaMaterial.additionalPackage.lowPackageMd5;
      arrayOfString[2] = paramMetaMaterial.additionalPackage.midPackageMd5;
      arrayOfString[3] = paramMetaMaterial.additionalPackage.highPackageMd5;
      arrayOfString[4] = paramMetaMaterial.packageMd5;
      int j = a - 1;
      int i = j;
      if (!TextUtils.isEmpty(localObject[j]))
      {
        paramAEMaterialMetaData.r = localObject[j];
        paramAEMaterialMetaData.s = arrayOfString[j];
      }
      else
      {
        while (i < 5)
        {
          if (!TextUtils.isEmpty(localObject[i]))
          {
            paramAEMaterialMetaData.r = localObject[i];
            paramAEMaterialMetaData.s = arrayOfString[i];
            break;
          }
          i += 1;
        }
      }
    }
    if ((paramMetaMaterial.packageUrl != null) && (!paramMetaMaterial.packageUrl.equals(paramAEMaterialMetaData.r)))
    {
      paramAEMaterialMetaData.x = true;
      paramMetaMaterial = b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[parseDowngradeInfo][material_downgrade] 降级完成 : ");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.r);
      AEQLog.a(paramMetaMaterial, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(List<MetaCategory> paramList, List<AEMaterialCategory> paramList1)
  {
    if (paramList == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      AEMaterialCategory localAEMaterialCategory;
      if (localIterator.hasNext())
      {
        paramList = (MetaCategory)localIterator.next();
        localAEMaterialCategory = new AEMaterialCategory();
        localAEMaterialCategory.d = paramList.name;
      }
      try
      {
        localAEMaterialCategory.b = Integer.parseInt(paramList.id);
        break label114;
        Object localObject1 = b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("categoryid is not integer ");
        ((StringBuilder)localObject2).append(paramList.id);
        AEQLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
        label114:
        if ((paramList.subCategories != null) && (paramList.subCategories.size() > 0)) {
          localAEMaterialCategory.h = paramList.subCategories;
        }
        if ((paramList.dynamicFields != null) && (paramList.dynamicFields.containsKey("isShowMaterial"))) {
          localAEMaterialCategory.g = "true".equalsIgnoreCase((String)paramList.dynamicFields.get("isShowMaterial"));
        }
        localAEMaterialCategory.a = new ArrayList();
        localObject1 = paramList.materials.iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label911;
          }
          localObject3 = (MetaMaterial)((Iterator)localObject1).next();
          if (((!((MetaMaterial)localObject3).id.contains("_3DFaceFila")) || (AEMaterialManager.m())) && ((!((MetaMaterial)localObject3).id.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor)))))
          {
            if ((!localHashMap.containsKey(((MetaMaterial)localObject3).id)) || (localHashMap.get(((MetaMaterial)localObject3).id) == null)) {
              break;
            }
            paramList = (AEMaterialMetaData)localHashMap.get(((MetaMaterial)localObject3).id);
            localAEMaterialCategory.a.add(paramList);
          }
        }
        localObject2 = new AEMaterialMetaData();
        ((AEMaterialMetaData)localObject2).q = ((MetaMaterial)localObject3).thumbUrl;
        localMap = ((MetaMaterial)localObject3).additionalFields;
        if (localMap == null) {}
      }
      catch (Exception paramList)
      {
        try
        {
          ((AEMaterialMetaData)localObject2).y = Integer.parseInt((String)localMap.get("kind"));
        }
        catch (Throwable paramList)
        {
          try
          {
            for (;;)
            {
              Object localObject2;
              Object localObject3;
              Map localMap;
              ((AEMaterialMetaData)localObject2).z = Integer.parseInt((String)localMap.get("displayType"));
              label427:
              ((AEMaterialMetaData)localObject2).F = ((String)localMap.get("qq_camera_top_title"));
              ((AEMaterialMetaData)localObject2).G = ((String)localMap.get("qq_camera_scheme"));
              ((AEMaterialMetaData)localObject2).R = ((String)localMap.get("playshow_cover_img"));
              ((AEMaterialMetaData)localObject2).S = ((String)localMap.get("playshow_display_text"));
              ((AEMaterialMetaData)localObject2).H = ((String)localMap.get("takeSameName"));
              ((AEMaterialMetaData)localObject2).I = ((String)localMap.get("minimum_device_level"));
              ((AEMaterialMetaData)localObject2).K = ((String)localMap.get("orderForFemale"));
              ((AEMaterialMetaData)localObject2).J = ((String)localMap.get("shield_devices"));
              ((AEMaterialMetaData)localObject2).W = ((String)localMap.get("recommend_reason"));
              ((AEMaterialMetaData)localObject2).X = ((String)localMap.get("cosmetic_name"));
              ((AEMaterialMetaData)localObject2).aa = ((String)localMap.get("sys_race_id"));
              ((AEMaterialMetaData)localObject2).ab = ((String)localMap.get("sys_race_level"));
              paramList = (String)localMap.get("cosmetic_sliding_value");
              try
              {
                if (TextUtils.isEmpty(paramList)) {
                  ((AEMaterialMetaData)localObject2).Y = 100;
                } else {
                  ((AEMaterialMetaData)localObject2).Y = Integer.valueOf(paramList).intValue();
                }
                if (!TextUtils.isEmpty((String)localMap.get("showCircleTakeSame"))) {
                  ((AEMaterialMetaData)localObject2).M = Integer.valueOf((String)localMap.get("showCircleTakeSame")).intValue();
                } else {
                  ((AEMaterialMetaData)localObject2).M = 0;
                }
              }
              catch (Throwable paramList)
              {
                label738:
                break label738;
              }
              ((AEMaterialMetaData)localObject2).O = ((String)localMap.get("showEntry"));
              paramList = null;
              if (localMap != null) {
                paramList = (String)localMap.get("topic");
              }
              if (!TextUtils.isEmpty(paramList)) {
                ((AEMaterialMetaData)localObject2).N = paramList;
              }
              ((AEMaterialMetaData)localObject2).m = ((MetaMaterial)localObject3).id;
              ((AEMaterialMetaData)localObject2).L = a((AEMaterialMetaData)localObject2);
              if (!((AEMaterialMetaData)localObject2).L)
              {
                paramList = b;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("can not show material id :");
                ((StringBuilder)localObject3).append(((AEMaterialMetaData)localObject2).m);
                QLog.d(paramList, 4, ((StringBuilder)localObject3).toString());
              }
              else
              {
                a((AEMaterialMetaData)localObject2, (MetaMaterial)localObject3);
                ((AEMaterialMetaData)localObject2).t = ((MetaMaterial)localObject3).id;
                localAEMaterialCategory.a.add(localObject2);
                localHashMap.put(((MetaMaterial)localObject3).id, localObject2);
                continue;
                label911:
                paramList1.add(localAEMaterialCategory);
                break;
                return;
                localException = localException;
                continue;
                paramList = paramList;
              }
            }
          }
          catch (Throwable paramList)
          {
            break label427;
          }
        }
      }
    }
  }
  
  private static boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      return true;
    }
    String str;
    Object localObject;
    if (ParamsUtil.a(paramAEMaterialMetaData.I) > ParamsUtil.b())
    {
      str = b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("can not show level :");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.I);
      AEQLog.a(str, ((StringBuilder)localObject).toString());
      return false;
    }
    if (paramAEMaterialMetaData.J != null)
    {
      str = ParamsUtil.c();
      localObject = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("can not show curModel :");
      localStringBuilder.append(str);
      AEQLog.a((String)localObject, localStringBuilder.toString());
      if (paramAEMaterialMetaData.J.contains(str)) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEMaterialConfigParser
 * JD-Core Version:    0.7.0.1
 */