package com.tencent.av.business.handler.receiver;

import android.os.Bundle;
import android.text.TextUtils;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.google.gson.Gson;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.EffectMaterialHandler;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.business.processor.FaceConfigFileProcessor;
import com.tencent.av.business.processor.PendantConfigFileProcessor;
import com.tencent.av.utils.EffectMaterialUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class EffectMaterialReceiver
  extends BaseProtocolReceiver<EffectMaterialHandler>
{
  public EffectMaterialReceiver(AppInterface paramAppInterface, EffectMaterialHandler paramEffectMaterialHandler)
  {
    super(paramAppInterface, paramEffectMaterialHandler);
  }
  
  public String a()
  {
    return "ShadowBackendSvc.GetCatMatTree";
  }
  
  void a(GetCatMatTreeRsp paramGetCatMatTreeRsp)
  {
    if (QLog.isColorLevel())
    {
      if (paramGetCatMatTreeRsp == null)
      {
        QLog.i("EffectMaterialReceiver", 2, "[handleMaterial] response data is null");
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleMaterial] response.code = ");
      ((StringBuilder)localObject).append(paramGetCatMatTreeRsp.Code);
      QLog.i("EffectMaterialReceiver", 2, ((StringBuilder)localObject).toString());
      if ((paramGetCatMatTreeRsp.Categories != null) && (!paramGetCatMatTreeRsp.Categories.isEmpty()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[handleMaterial] response.Categories.size = ");
        ((StringBuilder)localObject).append(paramGetCatMatTreeRsp.Categories.size());
        QLog.i("EffectMaterialReceiver", 2, ((StringBuilder)localObject).toString());
        paramGetCatMatTreeRsp = paramGetCatMatTreeRsp.Categories.iterator();
        while (paramGetCatMatTreeRsp.hasNext())
        {
          localObject = (MetaCategory)paramGetCatMatTreeRsp.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[handleMaterial] categories.name = ");
          localStringBuilder.append(((MetaCategory)localObject).name);
          QLog.i("EffectMaterialReceiver", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[handleMaterial] categories.subCategories = ");
          localStringBuilder.append(((MetaCategory)localObject).subCategories.size());
          QLog.i("EffectMaterialReceiver", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[handleMaterial] categories.materials = ");
          localStringBuilder.append(((MetaCategory)localObject).materials.size());
          QLog.i("EffectMaterialReceiver", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  void a(FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("[handleMaterial] serviceId = ");
      paramFromServiceMsg.append(paramString);
      QLog.i("EffectMaterialReceiver", 2, paramFromServiceMsg.toString());
    }
    paramFromServiceMsg = (GetCatMatTreeRsp)paramObject;
    a(paramFromServiceMsg);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.Code == 0) && (paramFromServiceMsg.Categories != null) && (!paramFromServiceMsg.Categories.isEmpty()))
    {
      paramObject = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShadowBackendSvc.GetCatMatTree");
      localStringBuilder.append(paramString);
      EffectMaterialUtil.a(paramObject, localStringBuilder.toString(), paramFromServiceMsg.ETag);
      paramFromServiceMsg = new Gson().toJson(paramFromServiceMsg);
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("[handleMaterial] dataStr = ");
        paramObject.append(paramFromServiceMsg);
        QLog.i("EffectMaterialReceiver", 2, paramObject.toString());
      }
      if (TextUtils.equals(paramString, "QQAVSinglePendant"))
      {
        a(paramFromServiceMsg);
        return;
      }
      if (TextUtils.equals(paramString, "QQAVDoublePendant")) {
        b(paramFromServiceMsg);
      }
    }
    else
    {
      QLog.i("EffectMaterialReceiver", 2, "[handleMaterial] no data return");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EffectMaterialReceiver", 2, "EffectMaterialReceiver receive called");
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getString("ServiceId");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EffectMaterialReceiver serviceId: ");
      localStringBuilder.append(paramToServiceMsg);
      QLog.i("EffectMaterialReceiver", 2, localStringBuilder.toString());
    }
    a(paramFromServiceMsg, paramObject, paramToServiceMsg);
  }
  
  void a(String paramString)
  {
    ((PendantConfigFileProcessor)((EffectMaterialManager)((VideoAppInterface)this.a).a(15)).a(1)).a(paramString);
  }
  
  void b(String paramString)
  {
    ((FaceConfigFileProcessor)((EffectMaterialManager)((VideoAppInterface)this.a).a(15)).a(2)).a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.receiver.EffectMaterialReceiver
 * JD-Core Version:    0.7.0.1
 */