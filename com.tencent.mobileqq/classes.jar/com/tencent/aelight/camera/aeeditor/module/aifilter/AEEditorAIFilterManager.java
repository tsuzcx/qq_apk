package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.content.Context;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.microrapid.opencv.ImageStatisticsData;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
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
  private static final String c = "AEEditorAIFilterManager";
  public SilentVideoAIFilterProxy a;
  public SilentBatchImageAIFilterProxy b;
  private long d;
  private long e;
  private ConcurrentHashMap<Integer, AIFilterProxyBase> f = new ConcurrentHashMap();
  
  private AEEditorAIFilterManager()
  {
    if (PhotoAIFilter.getTemperatureStatisticsPath().equals(""))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AEEditorResourceManager.a().n());
      localStringBuilder.append(File.separator);
      PhotoAIFilter.setTemperatureStatisticsPath(localStringBuilder.toString());
    }
    com.tencent.ttpic.openapi.filter.TTBeautyV5SmoothFilter.enableFacecolor = false;
  }
  
  public static AEEditorAIFilterManager a()
  {
    return AEEditorAIFilterManager.InstanceHolder.a;
  }
  
  private void a(AppInterface paramAppInterface, Context paramContext, AIFilterProxyBase paramAIFilterProxyBase)
  {
    if (paramAIFilterProxyBase != null)
    {
      Object localObject = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processAIFilter: ");
      localStringBuilder.append(paramAIFilterProxyBase.getClass().getSimpleName());
      AEQLog.b((String)localObject, localStringBuilder.toString());
      localObject = paramAIFilterProxyBase.c();
      boolean bool;
      if (paramAIFilterProxyBase.a()) {
        bool = AEEditorResourceManager.a().m();
      } else {
        bool = AEEditorResourceManager.a().k();
      }
      if (!bool)
      {
        AEQLog.d(c, "processAIFilter: AIFilter request failed: lut res not ready");
        if (localObject != null) {
          ((AEEditorAIFilterManager.AIFilterObserver)localObject).ar_();
        }
        return;
      }
      if (!FeatureManager.Features.IMAGE_ALGO.init())
      {
        AEQLog.d(c, "processAIFilter: AIFilter request failed: image_aglo not ready");
        if (localObject != null) {
          ((AEEditorAIFilterManager.AIFilterObserver)localObject).ar_();
        }
        return;
      }
      if (!NetworkUtil.isNetworkAvailable())
      {
        if (localObject != null) {
          ((AEEditorAIFilterManager.AIFilterObserver)localObject).a(-4, paramAIFilterProxyBase.d());
        }
        return;
      }
      this.d = System.currentTimeMillis();
      paramAIFilterProxyBase.a(paramContext, new AEEditorAIFilterManager.1(this, paramAppInterface, paramAIFilterProxyBase, (AEEditorAIFilterManager.AIFilterObserver)localObject));
      return;
    }
    throw new IllegalArgumentException("proxy should not be null");
  }
  
  private void a(AppInterface paramAppInterface, ArrayList<SmartFilterReqItem> paramArrayList, AEEditorAIFilterManager.AIRequestCallback paramAIRequestCallback)
  {
    if (paramAppInterface == null)
    {
      AEQLog.d(c, "AppInterface is null");
      return;
    }
    AEQLog.b(c, "sendRequest");
    ((CameraPeakServiceHandler)paramAppInterface.getBusinessHandler(PeakAppInterface.e)).a(paramArrayList, paramAIRequestCallback);
  }
  
  public static float[] a(ImageStatisticsData paramImageStatisticsData)
  {
    float[] arrayOfFloat = new float[8];
    if (paramImageStatisticsData == null)
    {
      AEQLog.d(c, "smartFilterData is null");
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
  
  public static HashMap<String, String> b(ImageStatisticsData paramImageStatisticsData)
  {
    HashMap localHashMap = new HashMap();
    if (paramImageStatisticsData == null)
    {
      AEQLog.d(c, "smartFilterData is null");
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
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onResponseFailed: errorCode=");
    ((StringBuilder)localObject2).append(paramInt1);
    AEQLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = this.f;
    if (localObject1 != null)
    {
      if (((ConcurrentHashMap)localObject1).size() == 0) {
        return;
      }
      localObject1 = (AIFilterProxyBase)this.f.get(Integer.valueOf(paramInt2));
      if (localObject1 == null) {
        return;
      }
      ((AIFilterProxyBase)localObject1).e();
      localObject2 = ((AIFilterProxyBase)localObject1).c();
      if (localObject2 != null)
      {
        ((AEEditorAIFilterManager.AIFilterObserver)localObject2).a(paramInt1, ((AIFilterProxyBase)localObject1).d());
        return;
      }
      AEQLog.b(c, "no observer, abandon response");
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
    AEQLog.d(c, "appInterface is null.");
  }
  
  public void a(Context paramContext, TAVCutVideoSession paramTAVCutVideoSession, AEEditorAIFilterManager.SilentResultCallBack paramSilentResultCallBack)
  {
    AppInterface localAppInterface = CaptureContext.a();
    this.a = new SilentVideoAIFilterProxy(paramTAVCutVideoSession, paramSilentResultCallBack);
    if (localAppInterface != null)
    {
      a(localAppInterface, paramContext, this.a);
      return;
    }
    AEQLog.d(c, "appInterface is null.");
  }
  
  public void a(Context paramContext, ArrayList<String> paramArrayList, List<AEEditorImageInfo> paramList, AEEditorAIFilterManager.SilentResultCallBack paramSilentResultCallBack)
  {
    this.b = new SilentBatchImageAIFilterProxy(paramArrayList, paramList, paramSilentResultCallBack);
    paramArrayList = CaptureContext.a();
    if (paramArrayList != null)
    {
      a(paramArrayList, paramContext, this.b);
      return;
    }
    AEQLog.d(c, "appInterface is null.");
  }
  
  public void a(List<AIFilterResponse> paramList, int paramInt)
  {
    AEQLog.b(c, "onResponseSuccess");
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      if (((ConcurrentHashMap)localObject1).size() == 0) {
        return;
      }
      localObject1 = (AIFilterProxyBase)this.f.get(Integer.valueOf(paramInt));
      if (localObject1 == null) {
        return;
      }
      AEQLog.b(c, "proxy handleResponse");
      paramList = ((AIFilterProxyBase)localObject1).a(paramList);
      ((AIFilterProxyBase)localObject1).e();
      this.e = System.currentTimeMillis();
      Object localObject2 = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIFilterPref: cost = ");
      localStringBuilder.append(this.e - this.d);
      localStringBuilder.append("ms");
      AEQLog.b((String)localObject2, localStringBuilder.toString());
      localObject2 = ((AIFilterProxyBase)localObject1).c();
      if (localObject2 != null)
      {
        AEQLog.b(c, "has observer");
        if (paramList != null)
        {
          AEQLog.b(c, "observer onAIFilterApplySuccess");
          ((AEEditorAIFilterManager.AIFilterObserver)localObject2).a(0, paramList);
        }
        else
        {
          AEQLog.b(c, "observer onAIFilterAppliedFailed, errorCode=-5");
          ((AEEditorAIFilterManager.AIFilterObserver)localObject2).a(-5, ((AIFilterProxyBase)localObject1).d());
        }
        ((AIFilterProxyBase)localObject1).b();
        return;
      }
      AEQLog.b(c, "no observer, abandon response");
    }
  }
  
  public void b()
  {
    AEQLog.b(c, "cancelProcess");
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if ((localEntry != null) && (localEntry.getValue() != null)) {
          ((AIFilterProxyBase)localEntry.getValue()).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager
 * JD-Core Version:    0.7.0.1
 */