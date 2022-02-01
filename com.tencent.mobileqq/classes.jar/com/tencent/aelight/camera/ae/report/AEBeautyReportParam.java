package com.tencent.aelight.camera.ae.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyConfigModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautySecondaryConfigModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectItem;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEFilterProviderView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class AEBeautyReportParam
{
  private static AEBeautyReportParam a;
  private Map<String, String> b;
  
  public static AEBeautyReportParam a()
  {
    if (a == null) {
      a = new AEBeautyReportParam();
    }
    return a;
  }
  
  private void a(@NonNull AEBeautyProviderViewModel paramAEBeautyProviderViewModel, @NonNull Map<String, String> paramMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(AEBaseReportParam.a().k());
    paramMap.put("is_ai_btn", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(AEBaseReportParam.a().j());
    paramMap.put("face_info", ((StringBuilder)localObject).toString());
    JSONObject localJSONObject;
    Iterator localIterator;
    if (paramAEBeautyProviderViewModel != null)
    {
      localJSONObject = new JSONObject();
      localIterator = paramAEBeautyProviderViewModel.l().iterator();
    }
    for (;;)
    {
      int i;
      if (localIterator.hasNext())
      {
        AEBeautyConfigModel localAEBeautyConfigModel = (AEBeautyConfigModel)localIterator.next();
        localObject = localAEBeautyConfigModel.b();
        AEBeautySecondaryConfigModel localAEBeautySecondaryConfigModel = AEProviderViewModel.b(localAEBeautyConfigModel);
        paramAEBeautyProviderViewModel = (AEBeautyProviderViewModel)localObject;
        if (localAEBeautySecondaryConfigModel != null)
        {
          paramAEBeautyProviderViewModel = new StringBuilder();
          paramAEBeautyProviderViewModel.append((String)localObject);
          paramAEBeautyProviderViewModel.append("_");
          paramAEBeautyProviderViewModel.append(localAEBeautySecondaryConfigModel.b());
          paramAEBeautyProviderViewModel = paramAEBeautyProviderViewModel.toString();
        }
        i = AEProviderViewModel.a(localAEBeautyConfigModel);
      }
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i);
        localJSONObject.put(paramAEBeautyProviderViewModel, ((StringBuilder)localObject).toString());
      }
      catch (Exception paramAEBeautyProviderViewModel) {}
      paramMap.put("beauty_params", localJSONObject.toString());
      return;
    }
  }
  
  private void a(@NonNull AECosmeticsViewModel paramAECosmeticsViewModel, @NonNull Map<String, String> paramMap)
  {
    if (paramAECosmeticsViewModel != null)
    {
      paramAECosmeticsViewModel = (DYAEEffectItem)paramAECosmeticsViewModel.b().getValue();
      if ((paramAECosmeticsViewModel != null) && (!TextUtils.isEmpty(paramAECosmeticsViewModel.b())))
      {
        paramMap.put("makeup_name", paramAECosmeticsViewModel.b());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(AEProviderViewModel.a(paramAECosmeticsViewModel));
        paramMap.put("makeup_value", localStringBuilder.toString());
      }
    }
  }
  
  private void a(Map<String, String> paramMap)
  {
    paramMap.put("face_id", AEBaseReportParam.a().f());
    AEBaseReportParam.a().a(paramMap);
  }
  
  private void b(@NonNull Map<String, String> paramMap)
  {
    String str = DYAEFilterProviderView.getFilterId();
    if (str != null)
    {
      int i = AEProviderViewModel.a(str);
      paramMap.put("filter_id", str);
      paramMap.put("filter_value", String.valueOf(i));
    }
  }
  
  public void a(@NonNull AEPituCameraUnit paramAEPituCameraUnit)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("filter_id", "none");
    localHashMap.put("filter_value", "-1");
    localHashMap.put("makeup_name", "none");
    localHashMap.put("makeup_value", "-1");
    b(localHashMap);
    a((AECosmeticsViewModel)AEViewModelProviders.a(paramAEPituCameraUnit).get(AECosmeticsViewModel.class), localHashMap);
    a((AEBeautyProviderViewModel)AEViewModelProviders.a(paramAEPituCameraUnit).get(AEBeautyProviderViewModel.class), localHashMap);
    a(localHashMap);
    this.b = localHashMap;
  }
  
  @NonNull
  public Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    if (AEDashboardUtil.d())
    {
      Map localMap = this.b;
      if (localMap != null) {
        localHashMap.putAll(localMap);
      }
      b(localHashMap);
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.report.AEBeautyReportParam
 * JD-Core Version:    0.7.0.1
 */