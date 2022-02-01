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
  private static final String a = "AEMaterialConfigParser";
  
  public static ArrayList<AEMaterialCategory> a(String paramString)
  {
    localObject1 = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localObject1;
    }
    localObject2 = new Gson();
    try
    {
      paramString = (GetCategoryMaterialRsp)((Gson)localObject2).fromJson(paramString, GetCategoryMaterialRsp.class);
      if (paramString == null) {
        break label766;
      }
      if (paramString.Categories == null) {
        return localObject1;
      }
      localObject2 = new HashMap();
      localIterator = paramString.Categories.iterator();
    }
    catch (Exception paramString)
    {
      try
      {
        Iterator localIterator;
        localAEMaterialCategory.jdField_a_of_type_Int = Integer.parseInt(paramString.id);
        break label159;
        Object localObject3 = jdField_a_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("categoryid is not integer ");
        ((StringBuilder)localObject4).append(paramString.id);
        AEQLog.d((String)localObject3, ((StringBuilder)localObject4).toString());
        localAEMaterialCategory.jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject3 = paramString.materials.iterator();
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label756;
          }
          localObject5 = (MetaMaterial)((Iterator)localObject3).next();
          if (((!((MetaMaterial)localObject5).id.contains("_3DFaceFila")) || (AEMaterialManager.b())) && ((!((MetaMaterial)localObject5).id.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor)))))
          {
            if ((!((Map)localObject2).containsKey(((MetaMaterial)localObject5).id)) || (((Map)localObject2).get(((MetaMaterial)localObject5).id) == null)) {
              break;
            }
            paramString = (AEMaterialMetaData)((Map)localObject2).get(((MetaMaterial)localObject5).id);
            localAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(paramString);
          }
        }
        localObject4 = new AEMaterialMetaData();
        ((AEMaterialMetaData)localObject4).m = ((MetaMaterial)localObject5).thumbUrl;
        localMap = ((MetaMaterial)localObject5).additionalFields;
        if (localMap == null) {
          break label602;
        }
      }
      catch (Exception paramString)
      {
        try
        {
          ((AEMaterialMetaData)localObject4).jdField_d_of_type_Int = Integer.parseInt((String)localMap.get("kind"));
        }
        catch (Throwable paramString)
        {
          try
          {
            for (;;)
            {
              AEMaterialCategory localAEMaterialCategory;
              Object localObject4;
              Object localObject5;
              Map localMap;
              ((AEMaterialMetaData)localObject4).e = Integer.parseInt((String)localMap.get("displayType"));
              ((AEMaterialMetaData)localObject4).q = ((String)localMap.get("qq_camera_top_title"));
              ((AEMaterialMetaData)localObject4).r = ((String)localMap.get("qq_camera_scheme"));
              ((AEMaterialMetaData)localObject4).y = ((String)localMap.get("playshow_cover_img"));
              ((AEMaterialMetaData)localObject4).z = ((String)localMap.get("playshow_display_text"));
              ((AEMaterialMetaData)localObject4).s = ((String)localMap.get("takeSameName"));
              ((AEMaterialMetaData)localObject4).t = ((String)localMap.get("minimum_device_level"));
              ((AEMaterialMetaData)localObject4).u = ((String)localMap.get("shield_devices"));
              ((AEMaterialMetaData)localObject4).D = ((String)localMap.get("recommend_reason"));
              try
              {
                if (!TextUtils.isEmpty((String)localMap.get("showCircleTakeSame"))) {
                  ((AEMaterialMetaData)localObject4).jdField_g_of_type_Int = Integer.valueOf((String)localMap.get("showCircleTakeSame")).intValue();
                } else {
                  ((AEMaterialMetaData)localObject4).jdField_g_of_type_Int = 0;
                }
              }
              catch (Throwable paramString)
              {
                break label585;
              }
              ((AEMaterialMetaData)localObject4).w = ((String)localMap.get("showEntry"));
              paramString = null;
              if (localMap != null) {
                paramString = (String)localMap.get("topic");
              }
              if (!TextUtils.isEmpty(paramString)) {
                ((AEMaterialMetaData)localObject4).v = paramString;
              }
              ((AEMaterialMetaData)localObject4).k = ((MetaMaterial)localObject5).id;
              ((AEMaterialMetaData)localObject4).jdField_g_of_type_Boolean = a((AEMaterialMetaData)localObject4);
              if (!((AEMaterialMetaData)localObject4).jdField_g_of_type_Boolean)
              {
                paramString = jdField_a_of_type_JavaLangString;
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("can not show material id :");
                ((StringBuilder)localObject5).append(((AEMaterialMetaData)localObject4).k);
                QLog.d(paramString, 4, ((StringBuilder)localObject5).toString());
              }
              else
              {
                a((AEMaterialMetaData)localObject4, (MetaMaterial)localObject5);
                ((AEMaterialMetaData)localObject4).p = ((MetaMaterial)localObject5).id;
                localAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(localObject4);
                ((Map)localObject2).put(((MetaMaterial)localObject5).id, localObject4);
                continue;
                ((ArrayList)localObject1).add(localAEMaterialCategory);
                continue;
                return localObject1;
                paramString = paramString;
                localObject1 = jdField_a_of_type_JavaLangString;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("###  parseMaterialListFromConfig exception = ");
                ((StringBuilder)localObject2).append(paramString.getMessage());
                QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
                paramString = new AEMaterialConfigParser.AEMaterialConfigParseException("parseMaterialListFromConfig error");
                for (;;)
                {
                  throw paramString;
                }
                localException = localException;
                continue;
                paramString = paramString;
              }
            }
          }
          catch (Throwable paramString)
          {
            break label399;
          }
        }
      }
    }
    if (localIterator.hasNext())
    {
      paramString = (MetaCategory)localIterator.next();
      localAEMaterialCategory = new AEMaterialCategory();
      localAEMaterialCategory.b = paramString.name;
    }
  }
  
  private static void a(AEMaterialMetaData paramAEMaterialMetaData, MetaMaterial paramMetaMaterial)
  {
    Object localObject;
    if (paramMetaMaterial.additionalPackage == null)
    {
      paramAEMaterialMetaData.n = paramMetaMaterial.packageUrl;
      paramAEMaterialMetaData.o = paramMetaMaterial.packageMd5;
    }
    else if ((TextUtils.isEmpty(paramMetaMaterial.additionalPackage.superLowPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.lowPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.midPackageUrl)) && (TextUtils.isEmpty(paramMetaMaterial.additionalPackage.highPackageUrl)))
    {
      paramAEMaterialMetaData.n = paramMetaMaterial.packageUrl;
      paramAEMaterialMetaData.o = paramMetaMaterial.packageMd5;
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
      int j = jdField_a_of_type_Int - 1;
      int i = j;
      if (!TextUtils.isEmpty(localObject[j]))
      {
        paramAEMaterialMetaData.n = localObject[j];
        paramAEMaterialMetaData.o = arrayOfString[j];
      }
      else
      {
        while (i < 5)
        {
          if (!TextUtils.isEmpty(localObject[i]))
          {
            paramAEMaterialMetaData.n = localObject[i];
            paramAEMaterialMetaData.o = arrayOfString[i];
            break;
          }
          i += 1;
        }
      }
    }
    if ((paramMetaMaterial.packageUrl != null) && (!paramMetaMaterial.packageUrl.equals(paramAEMaterialMetaData.n)))
    {
      paramAEMaterialMetaData.jdField_d_of_type_Boolean = true;
      paramMetaMaterial = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[parseDowngradeInfo][material_downgrade] 降级完成 : ");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.n);
      AEQLog.a(paramMetaMaterial, ((StringBuilder)localObject).toString());
    }
  }
  
  private static boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      return true;
    }
    String str;
    Object localObject;
    if (ParamsUtil.a(paramAEMaterialMetaData.t) > ParamsUtil.a())
    {
      str = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("can not show level :");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.t);
      AEQLog.a(str, ((StringBuilder)localObject).toString());
      return false;
    }
    if (paramAEMaterialMetaData.u != null)
    {
      str = ParamsUtil.b();
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("can not show curModel :");
      localStringBuilder.append(str);
      AEQLog.a((String)localObject, localStringBuilder.toString());
      if (paramAEMaterialMetaData.u.contains(str)) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEMaterialConfigParser
 * JD-Core Version:    0.7.0.1
 */