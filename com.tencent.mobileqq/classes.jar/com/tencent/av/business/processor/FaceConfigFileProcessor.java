package com.tencent.av.business.processor;

import android.text.TextUtils;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.av.AVPathUtil;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.utils.EffectMaterialUtil;
import com.tencent.common.app.AppInterface;
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
  private String b;
  
  public FaceConfigFileProcessor(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
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
    String str = "";
    Object localObject;
    if (bool) {
      localObject = "";
    } else {
      localObject = (String)paramMetaMaterial.additionalFields.get("text");
    }
    localFaceItem.setText((String)localObject);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("type"))) {
      localObject = "pendant";
    } else {
      localObject = (String)paramMetaMaterial.additionalFields.get("type");
    }
    localFaceItem.setType((String)localObject);
    localFaceItem.setIsshow(TextUtils.equals("false", (CharSequence)paramMetaMaterial.additionalFields.get("isshow")) ^ true);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("version"))) {
      localObject = "";
    } else {
      localObject = (String)paramMetaMaterial.additionalFields.get("version");
    }
    localFaceItem.setVersion((String)localObject);
    localFaceItem.setVipLevel(b(paramMetaMaterial));
    localFaceItem.setIsInteract(TextUtils.equals("false", (CharSequence)paramMetaMaterial.additionalFields.get("is_interact")) ^ true);
    localFaceItem.setPredownload(TextUtils.equals("true", (CharSequence)paramMetaMaterial.additionalFields.get("predownload")));
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("peerdeconame1"))) {
      localObject = "";
    } else {
      localObject = (String)paramMetaMaterial.additionalFields.get("peerdeconame1");
    }
    localFaceItem.setPeerdeconame1((String)localObject);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("selfdeconame1"))) {
      localObject = "";
    } else {
      localObject = (String)paramMetaMaterial.additionalFields.get("selfdeconame1");
    }
    localFaceItem.setSelfdeconame1((String)localObject);
    if (TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("attr"))) {
      localObject = str;
    } else {
      localObject = (String)paramMetaMaterial.additionalFields.get("attr");
    }
    localFaceItem.setAttr((String)localObject);
    paramMetaMaterial = (String)paramMetaMaterial.additionalFields.get("originName");
    if (!TextUtils.isEmpty(paramMetaMaterial))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("convertFromMetaMaterial originName: ");
        ((StringBuilder)localObject).append(paramMetaMaterial);
        QLog.i("FaceConfigFileProcessor", 2, ((StringBuilder)localObject).toString());
      }
      localFaceItem.setId(paramMetaMaterial);
    }
    return localFaceItem;
  }
  
  public String a()
  {
    return AVPathUtil.l();
  }
  
  public List<FaceItem> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = b(paramFile);
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
      this.b = ((String)paramFile.dynamicFields.get("black_list"));
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
  
  public int b(MetaMaterial paramMetaMaterial)
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
  
  public void b()
  {
    EffectMaterialUtil.b(BaseApplication.getContext(), "ShadowBackendSvc.GetCatMatTreeQQAVDoublePendantV2");
  }
  
  public String c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.processor.FaceConfigFileProcessor
 * JD-Core Version:    0.7.0.1
 */