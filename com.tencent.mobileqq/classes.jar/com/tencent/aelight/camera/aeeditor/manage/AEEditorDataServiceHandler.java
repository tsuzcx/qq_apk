package com.tencent.aelight.camera.aeeditor.manage;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import camera.RECOMMEND_GENERAL_DATASTRUCT.BigShowRecommendInfo;
import camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendRsp;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.google.gson.Gson;
import com.tencent.aelight.camera.ae.AEPath.Editor.FILES;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.NetInfo;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AEEditorDataServiceHandler
  extends BusinessHandler
{
  private static final String b;
  protected Map<String, Long> a = new HashMap();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[AEEditor2]");
    localStringBuilder.append(AEEditorDataServiceHandler.class.getSimpleName());
    b = localStringBuilder.toString();
  }
  
  public AEEditorDataServiceHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    LogUtils.setEnable(false);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = (GetCatMatTreeRsp)paramObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.Code == 0) && (paramFromServiceMsg.Categories != null) && (!paramFromServiceMsg.Categories.isEmpty()))
    {
      if (AEDashboardUtil.f()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCircleCatMatTree.MqCircleEditor", "response", "succeeded with content"));
      }
      AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCircleCatMatTreeMqCircleEditor", paramFromServiceMsg.ETag, 4);
      paramFromServiceMsg = paramFromServiceMsg.Categories.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramObject = (MetaCategory)paramFromServiceMsg.next();
        boolean bool = false;
        if (paramObject.id.equals("10001"))
        {
          str = new Gson().toJson(paramObject.subCategories);
          bool = FileUtils.writeFile(AEditorMaterialManager.a().a(AEPath.Editor.FILES.d, "editor_filter_update_template.json"), str);
          AEEditorResourceManager.a().q();
        }
        else if (paramObject.id.equals("10002"))
        {
          str = new Gson().toJson(paramObject.subCategories);
          bool = FileUtils.writeFile(AEditorMaterialManager.a().a(AEPath.Editor.FILES.b, "editor_text_sticker_update_template.json"), str);
          AEEditorResourceManager.a().u();
        }
        else if (paramObject.id.equals("10003"))
        {
          str = new Gson().toJson(paramObject.subCategories);
          bool = FileUtils.writeFile(AEditorMaterialManager.a().a(AEPath.Editor.FILES.c, "editor_auto_template_update_template.json"), str);
          AEEditorResourceManager.a().t();
        }
        else if (paramObject.id.equals("10004"))
        {
          str = new Gson().toJson(paramObject.subCategories);
          bool = FileUtils.writeFile(AEditorMaterialManager.a().a(AEPath.Editor.FILES.g, "editor_text_update_template.json"), str);
          AEEditorResourceManager.a().v();
        }
        else if (paramObject.id.equals("10005"))
        {
          str = new Gson().toJson(paramObject.subCategories);
          bool = FileUtils.writeFile(AEditorMaterialManager.a().a(AEPath.Editor.FILES.e, "editor_frame_update_template.json"), str);
          AEEditorResourceManager.a().r();
        }
        else if (paramObject.id.equals("10006"))
        {
          str = new Gson().toJson(paramObject.subCategories);
          bool = FileUtils.writeFile(AEditorMaterialManager.a().a(AEPath.Editor.FILES.f, "editor_pic_template_update_template.json"), str);
          AEEditorResourceManager.a().s();
        }
        String str = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.id);
        localStringBuilder.append(" isWriteFile:");
        localStringBuilder.append(bool);
        AEQLog.a(str, localStringBuilder.toString());
      }
    }
    notifyUI(1, true, null);
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (GetBigShowRecommendRsp)paramObject;
    if ((localObject != null) && (((GetBigShowRecommendRsp)localObject).Code == 0) && (((GetBigShowRecommendRsp)localObject).Materials != null) && (!((GetBigShowRecommendRsp)localObject).Materials.isEmpty()))
    {
      if (AEDashboardUtil.f()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetBigShowRecommend.MqCircleEditor", "response", "succeeded with content"));
      }
      paramFromServiceMsg = new ArrayList();
      paramObject = new ArrayList();
      localObject = ((GetBigShowRecommendRsp)localObject).Materials.iterator();
      while (((Iterator)localObject).hasNext())
      {
        BigShowRecommendInfo localBigShowRecommendInfo = (BigShowRecommendInfo)((Iterator)localObject).next();
        paramFromServiceMsg.add(localBigShowRecommendInfo.MaterialInfo);
        paramObject.add(localBigShowRecommendInfo.Reason);
      }
      AEditorMaterialManager.a().a(paramFromServiceMsg, paramObject);
      return;
    }
    AEditorMaterialManager.a().c();
  }
  
  public void a(String paramString)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      LogUtils.w(b, "[requestEditorMaterials] no network....");
      return;
    }
    Object localObject = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【REQUEST】requestEditorMaterials");
    localStringBuilder.append(paramString);
    AEQLog.b((String)localObject, localStringBuilder.toString());
    if (AEDashboardUtil.f())
    {
      localObject = AEDashboardUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShadowBackendSvc.GetCircleCatMatTree.");
      localStringBuilder.append(paramString);
      ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo(localStringBuilder.toString(), "request", "null"));
    }
    localObject = this.a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShadowBackendSvc.GetCircleCatMatTree.");
    localStringBuilder.append(paramString);
    ((Map)localObject).put(localStringBuilder.toString(), Long.valueOf(System.currentTimeMillis()));
    localObject = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetCircleCatMatTree");
    ((ToServiceMsg)localObject).extraData.putString("ServiceId", paramString);
    send((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, ArrayList<byte[]> paramArrayList, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      AEditorMaterialManager.a().c();
      return;
    }
    if (AEDashboardUtil.f())
    {
      localObject1 = AEDashboardUtil.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ShadowBackendSvc.GetBigShowRecommend.");
      ((StringBuilder)localObject2).append(paramString);
      ((MutableLiveData)localObject1).postValue(new AEDashboardUtil.NetInfo(((StringBuilder)localObject2).toString(), "request", "null"));
    }
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ShadowBackendSvc.GetBigShowRecommend.");
    ((StringBuilder)localObject2).append(paramString);
    ((Map)localObject1).put(((StringBuilder)localObject2).toString(), Long.valueOf(System.currentTimeMillis()));
    localObject1 = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetBigShowRecommend");
    localObject2 = ((ToServiceMsg)localObject1).extraData;
    ((Bundle)localObject2).putString("ServiceId", paramString);
    ((Bundle)localObject2).putSerializable("framebytes", paramArrayList);
    ((Bundle)localObject2).putInt("media_type", paramInt);
    send((ToServiceMsg)localObject1);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return AEEditorCommonEditFragment.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetCircleCatMatTree")) {
      a(paramFromServiceMsg, paramObject);
    }
    if (paramToServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetBigShowRecommend")) {
      b(paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorDataServiceHandler
 * JD-Core Version:    0.7.0.1
 */