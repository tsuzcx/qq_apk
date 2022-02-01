package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.content.Context;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.microrapid.opencv.ImageStatisticsData;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AEEditorAIFilterManager
{
  private static final String jdField_a_of_type_JavaLangString = "AEEditorAIFilterManager";
  private long jdField_a_of_type_Long;
  private ConcurrentHashMap<Integer, AIFilterProxyBase> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private long b;
  
  private AEEditorAIFilterManager()
  {
    if (PhotoAIFilter.getTemperatureStatisticsPath().equals(""))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AEEditorResourceManager.a().b());
      localStringBuilder.append(File.separator);
      PhotoAIFilter.setTemperatureStatisticsPath(localStringBuilder.toString());
    }
    com.tencent.ttpic.openapi.filter.TTBeautyV5SmoothFilter.enableFacecolor = false;
  }
  
  public static AEEditorAIFilterManager a()
  {
    return AEEditorAIFilterManager.InstanceHolder.a;
  }
  
  public static HashMap<String, String> a(ImageStatisticsData paramImageStatisticsData)
  {
    HashMap localHashMap = new HashMap();
    if (paramImageStatisticsData == null)
    {
      AEQLog.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
      return localHashMap;
    }
    if (paramImageStatisticsData != null)
    {
      localHashMap.put("brightValue", String.valueOf(paramImageStatisticsData.lightness));
      localHashMap.put("contrastValue", String.valueOf(paramImageStatisticsData.contrast));
      localHashMap.put("saturationValue", String.valueOf(paramImageStatisticsData.saturation));
      localHashMap.put("scaleCValue", String.valueOf(paramImageStatisticsData.temperature));
      localHashMap.put("sharpenValue", String.valueOf(paramImageStatisticsData.sharpness));
      localHashMap.put("highlightValue", String.valueOf(paramImageStatisticsData.overexposure));
      localHashMap.put("shadowValue", String.valueOf(paramImageStatisticsData.underexposure));
      localHashMap.put("fadeValue", String.valueOf(paramImageStatisticsData.colorfulness));
    }
    return localHashMap;
  }
  
  private void a(AppInterface paramAppInterface, Context paramContext, AIFilterProxyBase paramAIFilterProxyBase)
  {
    if (paramAIFilterProxyBase != null)
    {
      Object localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processAIFilter: ");
      localStringBuilder.append(paramAIFilterProxyBase.getClass().getSimpleName());
      AEQLog.b((String)localObject, localStringBuilder.toString());
      localObject = paramAIFilterProxyBase.a();
      boolean bool;
      if (paramAIFilterProxyBase.a()) {
        bool = AEEditorResourceManager.a().b();
      } else {
        bool = AEEditorResourceManager.a().a();
      }
      if (!bool)
      {
        AEQLog.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: lut res not ready");
        if (localObject != null) {
          ((AEEditorAIFilterManager.AIFilterObserver)localObject).s_();
        }
        return;
      }
      if (!FeatureManager.Features.IMAGE_ALGO.init())
      {
        AEQLog.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: image_aglo not ready");
        if (localObject != null) {
          ((AEEditorAIFilterManager.AIFilterObserver)localObject).s_();
        }
        return;
      }
      if (!NetworkUtil.isNetworkAvailable())
      {
        if (localObject != null) {
          ((AEEditorAIFilterManager.AIFilterObserver)localObject).a(-4, paramAIFilterProxyBase.a());
        }
        return;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramAIFilterProxyBase.a(paramContext, new AEEditorAIFilterManager.1(this, paramAppInterface, paramAIFilterProxyBase, (AEEditorAIFilterManager.AIFilterObserver)localObject));
      return;
    }
    throw new IllegalArgumentException("proxy should not be null");
  }
  
  private void a(AppInterface paramAppInterface, ArrayList<SmartFilterReqItem> paramArrayList, AEEditorAIFilterManager.AIRequestCallback paramAIRequestCallback)
  {
    if (paramAppInterface == null)
    {
      AEQLog.d(jdField_a_of_type_JavaLangString, "AppInterface is null");
      return;
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "sendRequest");
    ((CameraPeakServiceHandler)paramAppInterface.getBusinessHandler(PeakAppInterface.d)).a(paramArrayList, paramAIRequestCallback);
  }
  
  public static float[] a(ImageStatisticsData paramImageStatisticsData)
  {
    float[] arrayOfFloat = new float[8];
    if (paramImageStatisticsData == null)
    {
      AEQLog.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
      return arrayOfFloat;
    }
    if (paramImageStatisticsData != null)
    {
      arrayOfFloat[0] = ((float)paramImageStatisticsData.lightness);
      arrayOfFloat[1] = ((float)paramImageStatisticsData.temperature);
      arrayOfFloat[2] = ((float)paramImageStatisticsData.overexposure);
      arrayOfFloat[3] = ((float)paramImageStatisticsData.underexposure);
      arrayOfFloat[4] = ((float)paramImageStatisticsData.contrast);
      arrayOfFloat[5] = ((float)paramImageStatisticsData.saturation);
      arrayOfFloat[6] = ((float)paramImageStatisticsData.sharpness);
      arrayOfFloat[7] = ((float)paramImageStatisticsData.colorfulness);
    }
    return arrayOfFloat;
  }
  
  public void a()
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "cancelProcess");
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if ((localEntry != null) && (localEntry.getValue() != null)) {
          ((AIFilterProxyBase)localEntry.getValue()).a();
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onResponseFailed: errorCode=");
    ((StringBuilder)localObject2).append(paramInt1);
    AEQLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject1 != null)
    {
      if (((ConcurrentHashMap)localObject1).size() == 0) {
        return;
      }
      localObject1 = (AIFilterProxyBase)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2));
      if (localObject1 == null) {
        return;
      }
      ((AIFilterProxyBase)localObject1).b();
      localObject2 = ((AIFilterProxyBase)localObject1).a();
      if (localObject2 != null)
      {
        ((AEEditorAIFilterManager.AIFilterObserver)localObject2).a(paramInt1, ((AIFilterProxyBase)localObject1).a());
        return;
      }
      AEQLog.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
    }
  }
  
  public void a(Context paramContext, AIFilterProxyBase paramAIFilterProxyBase)
  {
    AppInterface localAppInterface = CaptureContext.a();
    if (localAppInterface != null)
    {
      a(localAppInterface, paramContext, paramAIFilterProxyBase);
      return;
    }
    AEQLog.d(jdField_a_of_type_JavaLangString, "appInterface is null.");
  }
  
  public void a(List<AIFilterResponse> paramList, int paramInt)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "onResponseSuccess");
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject1 != null)
    {
      if (((ConcurrentHashMap)localObject1).size() == 0) {
        return;
      }
      localObject1 = (AIFilterProxyBase)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (localObject1 == null) {
        return;
      }
      AEQLog.b(jdField_a_of_type_JavaLangString, "proxy handleResponse");
      paramList = ((AIFilterProxyBase)localObject1).a(paramList);
      ((AIFilterProxyBase)localObject1).b();
      this.b = System.currentTimeMillis();
      Object localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIFilterPref: cost = ");
      localStringBuilder.append(this.b - this.jdField_a_of_type_Long);
      localStringBuilder.append("ms");
      AEQLog.b((String)localObject2, localStringBuilder.toString());
      localObject2 = ((AIFilterProxyBase)localObject1).a();
      if (localObject2 != null)
      {
        AEQLog.b(jdField_a_of_type_JavaLangString, "has observer");
        if (paramList != null)
        {
          AEQLog.b(jdField_a_of_type_JavaLangString, "observer onAIFilterApplySuccess");
          ((AEEditorAIFilterManager.AIFilterObserver)localObject2).a(0, paramList);
        }
        else
        {
          AEQLog.b(jdField_a_of_type_JavaLangString, "observer onAIFilterAppliedFailed, errorCode=-5");
          ((AEEditorAIFilterManager.AIFilterObserver)localObject2).a(-5, ((AIFilterProxyBase)localObject1).a());
        }
        ((AIFilterProxyBase)localObject1).a();
        return;
      }
      AEQLog.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager
 * JD-Core Version:    0.7.0.1
 */