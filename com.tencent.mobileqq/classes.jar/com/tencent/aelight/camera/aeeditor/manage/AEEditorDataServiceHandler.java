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
  private static final String a;
  protected Map<String, Long> a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[AEEditor2]");
    localStringBuilder.append(AEEditorDataServiceHandler.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public AEEditorDataServiceHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    LogUtils.setEnable(false);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = (GetCatMatTreeRsp)paramObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.Code == 0) && (paramFromServiceMsg.Categories != null) && (!paramFromServiceMsg.Categories.isEmpty()))
    {
      if (AEDashboardUtil.a()) {
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
          AEEditorResourceManager.a().e();
        }
        else if (paramObject.id.equals("10002"))
        {
          str = new Gson().toJson(paramObject.subCategories);
          bool = FileUtils.writeFile(AEditorMaterialManager.a().a(AEPath.Editor.FILES.b, "editor_text_sticker_update_template.json"), str);
          AEEditorResourceManager.a().i();
        }
        else if (paramObject.id.equals("10003"))
        {
          str = new Gson().toJson(paramObject.subCategories);
          bool = FileUtils.writeFile(AEditorMaterialManager.a().a(AEPath.Editor.FILES.c, "editor_auto_template_update_template.json"), str);
        }
        else if (paramObject.id.equals("10004"))
        {
          str = new Gson().toJson(paramObject.subCategories);
          bool = FileUtils.writeFile(AEditorMaterialManager.a().a(AEPath.Editor.FILES.g, "editor_text_update_template.json"), str);
          AEEditorResourceManager.a().j();
        }
        else if (paramObject.id.equals("10005"))
        {
          str = new Gson().toJson(paramObject.subCategories);
          bool = FileUtils.writeFile(AEditorMaterialManager.a().a(AEPath.Editor.FILES.e, "editor_frame_update_template.json"), str);
          AEEditorResourceManager.a().f();
        }
        else if (paramObject.id.equals("10006"))
        {
          str = new Gson().toJson(paramObject.subCategories);
          bool = FileUtils.writeFile(AEditorMaterialManager.a().a(AEPath.Editor.FILES.f, "editor_pic_template_update_template.json"), str);
          AEEditorResourceManager.a().g();
        }
        String str = jdField_a_of_type_JavaLangString;
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
      if (AEDashboardUtil.a()) {
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
    AEditorMaterialManager.a().a();
  }
  
  public void a(String paramString)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[requestEditorMaterials] no network....");
      return;
    }
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【REQUEST】requestEditorMaterials");
    localStringBuilder.append(paramString);
    AEQLog.b((String)localObject, localStringBuilder.toString());
    if (AEDashboardUtil.a())
    {
      localObject = AEDashboardUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShadowBackendSvc.GetCircleCatMatTree.");
      localStringBuilder.append(paramString);
      ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo(localStringBuilder.toString(), "request", "null"));
    }
    localObject = this.jdField_a_of_type_JavaUtilMap;
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
      AEditorMaterialManager.a().a();
      return;
    }
    if (AEDashboardUtil.a())
    {
      localObject1 = AEDashboardUtil.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ShadowBackendSvc.GetBigShowRecommend.");
      ((StringBuilder)localObject2).append(paramString);
      ((MutableLiveData)localObject1).postValue(new AEDashboardUtil.NetInfo(((StringBuilder)localObject2).toString(), "request", "null"));
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorDataServiceHandler
 * JD-Core Version:    0.7.0.1
 */