package com.tencent.aelight.camera.ae.data;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.light.device.OfflineConfig;
import tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c.GiftMsg;
import tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c.MapDynamicFields;
import tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c.MaterialInfo;
import tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c.RspBody;

public class AEGiftMaterialConfigParser
{
  private static String jdField_a_of_type_JavaLangString = null;
  private static List<AEGiftMaterial> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static String b = "display_name";
  
  public static ArrayList<AEGiftMaterial> a(oidb_cmd0xf8c.RspBody paramRspBody)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramRspBody == null)
    {
      AEQLog.d("AEGiftMaterialConfigParser", "arcake:content is null ,can not parse gif material ");
      return localArrayList;
    }
    paramRspBody = paramRspBody.giftmsg.get();
    if ((paramRspBody != null) && (paramRspBody.size() != 0))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("arcake:giftMsgs size :");
      ((StringBuilder)localObject1).append(paramRspBody.size());
      AEQLog.d("AEGiftMaterialConfigParser", ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cake size : ");
      ((StringBuilder)localObject1).append(paramRspBody.size());
      localObject1 = ((StringBuilder)localObject1).toString();
      ThreadManager.getUIHandler().post(new AEGiftMaterialConfigParser.2((String)localObject1));
      int i = 0;
      paramRspBody = paramRspBody.iterator();
      while (paramRspBody.hasNext())
      {
        Object localObject3 = (oidb_cmd0xf8c.GiftMsg)paramRspBody.next();
        localObject1 = new AEGiftMaterial();
        ((AEGiftMaterial)localObject1).jdField_a_of_type_Long = ((oidb_cmd0xf8c.GiftMsg)localObject3).giftuin.get();
        ((AEGiftMaterial)localObject1).jdField_a_of_type_JavaLangString = ((oidb_cmd0xf8c.GiftMsg)localObject3).gitfnickname.get();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("arcake: material ： ");
        ((StringBuilder)localObject2).append(((AEGiftMaterial)localObject1).jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("uin : ");
        ((StringBuilder)localObject2).append(((AEGiftMaterial)localObject1).jdField_a_of_type_Long);
        AEQLog.a("AEGiftMaterialConfigParser", ((StringBuilder)localObject2).toString());
        if (TextUtils.isEmpty(((AEGiftMaterial)localObject1).jdField_a_of_type_JavaLangString))
        {
          ((AEGiftMaterial)localObject1).jdField_a_of_type_JavaLangString = AECameraPrefsUtil.a().a("key_ae_arcake_nick", null, 4);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("arcake: nickName ： ");
          ((StringBuilder)localObject2).append(((AEGiftMaterial)localObject1).jdField_a_of_type_JavaLangString);
          AEQLog.a("AEGiftMaterialConfigParser", ((StringBuilder)localObject2).toString());
        }
        localObject2 = new AEARCakeMaterial();
        localObject3 = (oidb_cmd0xf8c.MaterialInfo)((oidb_cmd0xf8c.GiftMsg)localObject3).materialInfo.get();
        int j = i;
        if (localObject3 != null)
        {
          ((AEARCakeMaterial)localObject2).m = ((oidb_cmd0xf8c.MaterialInfo)localObject3).ThumbURL.get();
          ((AEARCakeMaterial)localObject2).jdField_a_of_type_Int = ((oidb_cmd0xf8c.MaterialInfo)localObject3).ID.get();
          ((AEARCakeMaterial)localObject2).p = ((oidb_cmd0xf8c.MaterialInfo)localObject3).Name.get();
          ((AEARCakeMaterial)localObject2).k = ((oidb_cmd0xf8c.MaterialInfo)localObject3).Name.get();
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(((oidb_cmd0xf8c.MaterialInfo)localObject3).Name.get());
          ((StringBuilder)localObject4).append(i);
          ((AEARCakeMaterial)localObject2).C = ((StringBuilder)localObject4).toString();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("arcake: cake id  ： ");
          ((StringBuilder)localObject4).append(((AEARCakeMaterial)localObject2).C);
          AEQLog.a("AEGiftMaterialConfigParser", ((StringBuilder)localObject4).toString());
          j = i + 1;
          new HashMap();
          localObject4 = ((oidb_cmd0xf8c.MaterialInfo)localObject3).DynamicFields.get();
          if ((localObject4 != null) && (((List)localObject4).size() > 0))
          {
            localObject4 = ((List)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              Object localObject5 = (oidb_cmd0xf8c.MapDynamicFields)((Iterator)localObject4).next();
              if (localObject5 != null)
              {
                String str = ((oidb_cmd0xf8c.MapDynamicFields)localObject5).DynamicFieldkey.get();
                localObject5 = ((oidb_cmd0xf8c.MapDynamicFields)localObject5).DynamicFieldvalue.get();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("arcake : dynamic key ");
                localStringBuilder.append(str);
                AEQLog.a("AEGiftMaterialConfigParser", localStringBuilder.toString());
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("arcake : dynamic value ");
                localStringBuilder.append((String)localObject5);
                AEQLog.a("AEGiftMaterialConfigParser", localStringBuilder.toString());
                if ((str != null) && (b.equals(str))) {
                  ((AEGiftMaterial)localObject1).b = ((String)localObject5);
                }
              }
            }
          }
          ((AEARCakeMaterial)localObject2).j = ((oidb_cmd0xf8c.MaterialInfo)localObject3).ChecksumMd5.get();
          ((AEARCakeMaterial)localObject2).jdField_d_of_type_JavaLangString = ((oidb_cmd0xf8c.MaterialInfo)localObject3).ChecksumMd5Superlow.get();
          ((AEARCakeMaterial)localObject2).b = ((oidb_cmd0xf8c.MaterialInfo)localObject3).ChecksumMd5Low.get();
          ((AEARCakeMaterial)localObject2).f = ((oidb_cmd0xf8c.MaterialInfo)localObject3).ChecksumMd5Mid.get();
          ((AEARCakeMaterial)localObject2).h = ((oidb_cmd0xf8c.MaterialInfo)localObject3).ChecksumMd5High.get();
          ((AEARCakeMaterial)localObject2).i = ((oidb_cmd0xf8c.MaterialInfo)localObject3).PackageURL.get();
          ((AEARCakeMaterial)localObject2).c = ((oidb_cmd0xf8c.MaterialInfo)localObject3).PackageUrlSuperlow.get();
          ((AEARCakeMaterial)localObject2).jdField_a_of_type_JavaLangString = ((oidb_cmd0xf8c.MaterialInfo)localObject3).PackageURLLow.get();
          ((AEARCakeMaterial)localObject2).e = ((oidb_cmd0xf8c.MaterialInfo)localObject3).PackageURLMid.get();
          ((AEARCakeMaterial)localObject2).g = ((oidb_cmd0xf8c.MaterialInfo)localObject3).PackageURLHigh.get();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("arcake packageUrl ：");
          ((StringBuilder)localObject4).append(((oidb_cmd0xf8c.MaterialInfo)localObject3).PackageURL.get());
          AEQLog.a("AEGiftMaterialConfigParser", ((StringBuilder)localObject4).toString());
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("arcake superLowPackageUrl ： ");
          ((StringBuilder)localObject4).append(((oidb_cmd0xf8c.MaterialInfo)localObject3).PackageUrlSuperlow.get());
          AEQLog.a("AEGiftMaterialConfigParser", ((StringBuilder)localObject4).toString());
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("arcake lowPackageUrl ：");
          ((StringBuilder)localObject4).append(((oidb_cmd0xf8c.MaterialInfo)localObject3).PackageURLLow.get());
          AEQLog.a("AEGiftMaterialConfigParser", ((StringBuilder)localObject4).toString());
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("arcake PackageURLMid ：");
          ((StringBuilder)localObject4).append(((oidb_cmd0xf8c.MaterialInfo)localObject3).PackageURLMid.get());
          AEQLog.a("AEGiftMaterialConfigParser", ((StringBuilder)localObject4).toString());
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("arcake PackageURLHigh ：");
          ((StringBuilder)localObject4).append(((oidb_cmd0xf8c.MaterialInfo)localObject3).PackageURLHigh.get());
          AEQLog.a("AEGiftMaterialConfigParser", ((StringBuilder)localObject4).toString());
          a((AEARCakeMaterial)localObject2);
        }
        ((AEGiftMaterial)localObject1).jdField_a_of_type_ComTencentAelightCameraAeDataAEARCakeMaterial = ((AEARCakeMaterial)localObject2);
        localArrayList.add(localObject1);
        i = j;
      }
      paramRspBody = jdField_a_of_type_JavaUtilList;
      if (paramRspBody != null)
      {
        paramRspBody.clear();
        jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        paramRspBody = new StringBuilder();
        paramRspBody.append("arcake: mGiftMaterials size");
        paramRspBody.append(jdField_a_of_type_JavaUtilList.size());
        AEQLog.a("AEGiftMaterialConfigParser", paramRspBody.toString());
      }
      return localArrayList;
    }
    ThreadManager.getUIHandler().post(new AEGiftMaterialConfigParser.1());
    AEQLog.d("AEGiftMaterialConfigParser", "arcake:giftMsgs is null ,can not parse gif material ");
    return localArrayList;
  }
  
  public static List<AEGiftMaterial> a()
  {
    return jdField_a_of_type_JavaUtilList;
  }
  
  private static void a(AEARCakeMaterial paramAEARCakeMaterial)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramAEARCakeMaterial.c)) && (TextUtils.isEmpty(paramAEARCakeMaterial.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(paramAEARCakeMaterial.e)) && (TextUtils.isEmpty(paramAEARCakeMaterial.g)))
    {
      paramAEARCakeMaterial.n = paramAEARCakeMaterial.i;
      paramAEARCakeMaterial.o = paramAEARCakeMaterial.j;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("arcake: no level : ");
      ((StringBuilder)localObject).append(paramAEARCakeMaterial.n);
      AEQLog.a("AEGiftMaterialConfigParser", ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new String[5];
      localObject[0] = paramAEARCakeMaterial.c;
      localObject[1] = paramAEARCakeMaterial.jdField_a_of_type_JavaLangString;
      localObject[2] = paramAEARCakeMaterial.e;
      localObject[3] = paramAEARCakeMaterial.g;
      localObject[4] = paramAEARCakeMaterial.i;
      String[] arrayOfString = new String[5];
      arrayOfString[0] = paramAEARCakeMaterial.jdField_d_of_type_JavaLangString;
      arrayOfString[1] = paramAEARCakeMaterial.b;
      arrayOfString[2] = paramAEARCakeMaterial.f;
      arrayOfString[3] = paramAEARCakeMaterial.h;
      arrayOfString[4] = paramAEARCakeMaterial.j;
      int j = OfflineConfig.getPhonePerfLevel(BaseApplicationImpl.getApplication()) - 1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arcake: phoneLevelIndex : ");
      localStringBuilder.append(j);
      AEQLog.b("AEGiftMaterialConfigParser", localStringBuilder.toString());
      int i = j;
      if (!TextUtils.isEmpty(localObject[j]))
      {
        paramAEARCakeMaterial.n = localObject[j];
        paramAEARCakeMaterial.o = arrayOfString[j];
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("arcake:  level ");
        ((StringBuilder)localObject).append(paramAEARCakeMaterial.n);
        AEQLog.a("AEGiftMaterialConfigParser", ((StringBuilder)localObject).toString());
      }
      else
      {
        while (i < 5)
        {
          if (!TextUtils.isEmpty(localObject[i]))
          {
            paramAEARCakeMaterial.n = localObject[i];
            paramAEARCakeMaterial.o = arrayOfString[i];
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("arcake:  level  index ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(" url ");
            ((StringBuilder)localObject).append(paramAEARCakeMaterial.n);
            AEQLog.a("AEGiftMaterialConfigParser", ((StringBuilder)localObject).toString());
            break;
          }
          i += 1;
        }
      }
    }
    if ((paramAEARCakeMaterial.i != null) && (!paramAEARCakeMaterial.i.equals(paramAEARCakeMaterial.n)))
    {
      paramAEARCakeMaterial.jdField_d_of_type_Boolean = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("arcake: [parseDowngradeInfo][material_downgrade] 降级完成 : ");
      ((StringBuilder)localObject).append(paramAEARCakeMaterial.n);
      AEQLog.a("AEGiftMaterialConfigParser", ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEGiftMaterialConfigParser
 * JD-Core Version:    0.7.0.1
 */