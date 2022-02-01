package com.tencent.av.business.processor;

import android.text.TextUtils;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.av.AVPathUtil;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.utils.EffectMaterialUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FaceConfigFileProcessor
  extends BaseConfigFileProcessor<FaceItem>
{
  private String a;
  
  public int a(MetaMaterial paramMetaMaterial)
  {
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("vip_level"))) {
      return 0;
    }
    try
    {
      int i = Integer.parseInt((String)paramMetaMaterial.additionalFields.get("vip_level"));
      return i;
    }
    catch (Exception paramMetaMaterial)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVipLevel exception: ");
      localStringBuilder.append(paramMetaMaterial.getMessage());
      QLog.e("FaceConfigFileProcessor", 1, localStringBuilder.toString());
    }
    return 0;
  }
  
  public FaceItem a(MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial == null) {
      return null;
    }
    FaceItem localFaceItem = new FaceItem();
    localFaceItem.setId(paramMetaMaterial.id);
    localFaceItem.setIconUrl(paramMetaMaterial.thumbUrl);
    localFaceItem.setResUrl(paramMetaMaterial.packageUrl);
    localFaceItem.setResMd5(paramMetaMaterial.packageMd5);
    boolean bool = TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("text"));
    String str2 = "";
    String str1;
    if (bool) {
      str1 = "";
    } else {
      str1 = (String)paramMetaMaterial.additionalFields.get("text");
    }
    localFaceItem.setText(str1);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("type"))) {
      str1 = "pendant";
    } else {
      str1 = (String)paramMetaMaterial.additionalFields.get("type");
    }
    localFaceItem.setType(str1);
    localFaceItem.setIsshow(TextUtils.equals("false", (CharSequence)paramMetaMaterial.additionalFields.get("isshow")) ^ true);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("version"))) {
      str1 = "";
    } else {
      str1 = (String)paramMetaMaterial.additionalFields.get("version");
    }
    localFaceItem.setVersion(str1);
    localFaceItem.setVipLevel(a(paramMetaMaterial));
    localFaceItem.setIsInteract(TextUtils.equals("false", (CharSequence)paramMetaMaterial.additionalFields.get("is_interact")) ^ true);
    localFaceItem.setPredownload(TextUtils.equals("true", (CharSequence)paramMetaMaterial.additionalFields.get("predownload")));
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("peerdeconame1"))) {
      str1 = "";
    } else {
      str1 = (String)paramMetaMaterial.additionalFields.get("peerdeconame1");
    }
    localFaceItem.setPeerdeconame1(str1);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("selfdeconame1"))) {
      str1 = "";
    } else {
      str1 = (String)paramMetaMaterial.additionalFields.get("selfdeconame1");
    }
    localFaceItem.setSelfdeconame1(str1);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("attr"))) {
      paramMetaMaterial = str2;
    } else {
      paramMetaMaterial = (String)paramMetaMaterial.additionalFields.get("attr");
    }
    localFaceItem.setAttr(paramMetaMaterial);
    return localFaceItem;
  }
  
  public String a()
  {
    return AVPathUtil.j();
  }
  
  public List<FaceItem> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = a(paramFile);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadMaterialListFromFile -> jsonStr: ");
      ((StringBuilder)localObject).append(paramFile);
      QLog.i("FaceConfigFileProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramFile)) {
      return localArrayList;
    }
    Object localObject = new Gson();
    try
    {
      paramFile = (GetCatMatTreeRsp)((Gson)localObject).fromJson(paramFile, GetCatMatTreeRsp.class);
    }
    catch (Exception paramFile)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadMaterialListFromFile exception = ");
      ((StringBuilder)localObject).append(paramFile.getMessage());
      QLog.e("FaceConfigFileProcessor", 1, ((StringBuilder)localObject).toString());
      paramFile = null;
    }
    if (paramFile != null)
    {
      if (paramFile.Categories == null) {
        return localArrayList;
      }
      paramFile = (MetaCategory)paramFile.Categories.get(0);
      this.a = ((String)paramFile.dynamicFields.get("black_list"));
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramFile);
      paramFile = a((ArrayList)localObject).iterator();
      while (paramFile.hasNext())
      {
        localObject = (MetaMaterial)paramFile.next();
        if (localObject != null) {
          localArrayList.add(a((MetaMaterial)localObject));
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.i("FaceConfigFileProcessor", 2, "loadMaterialListFromFile result: ");
        paramFile = localArrayList.iterator();
        while (paramFile.hasNext())
        {
          localObject = (FaceItem)paramFile.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("pendant item: ");
          localStringBuilder.append(((FaceItem)localObject).toString());
          QLog.i("FaceConfigFileProcessor", 2, localStringBuilder.toString());
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    EffectMaterialUtil.a(BaseApplication.getContext(), "ShadowBackendSvc.GetCatMatTreeQQAVDoublePendant");
  }
  
  public String b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.processor.FaceConfigFileProcessor
 * JD-Core Version:    0.7.0.1
 */