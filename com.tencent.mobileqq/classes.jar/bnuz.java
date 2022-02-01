import android.content.Context;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.microrapid.opencv.ImageStatisticsData;
import com.tencent.common.app.AppInterface;
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

public class bnuz
{
  private static final String jdField_a_of_type_JavaLangString = bnuz.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private ConcurrentHashMap<Integer, bnvy> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private long b;
  
  private bnuz()
  {
    if (PhotoAIFilter.getTemperatureStatisticsPath().equals("")) {
      PhotoAIFilter.setTemperatureStatisticsPath(boaf.a().b() + File.separator);
    }
    com.tencent.ttpic.openapi.filter.TTBeautyV5SmoothFilter.enableFacecolor = false;
  }
  
  public static bnuz a()
  {
    return bnve.a;
  }
  
  public static HashMap<String, String> a(ImageStatisticsData paramImageStatisticsData)
  {
    HashMap localHashMap = new HashMap();
    if (paramImageStatisticsData == null) {
      bnrh.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
    }
    while (paramImageStatisticsData == null) {
      return localHashMap;
    }
    localHashMap.put("brightValue", String.valueOf(paramImageStatisticsData.lightness));
    localHashMap.put("contrastValue", String.valueOf(paramImageStatisticsData.contrast));
    localHashMap.put("saturationValue", String.valueOf(paramImageStatisticsData.saturation));
    localHashMap.put("scaleCValue", String.valueOf(paramImageStatisticsData.temperature));
    localHashMap.put("sharpenValue", String.valueOf(paramImageStatisticsData.sharpness));
    localHashMap.put("highlightValue", String.valueOf(paramImageStatisticsData.overexposure));
    localHashMap.put("shadowValue", String.valueOf(paramImageStatisticsData.underexposure));
    localHashMap.put("fadeValue", String.valueOf(paramImageStatisticsData.colorfulness));
    return localHashMap;
  }
  
  private void a(AppInterface paramAppInterface, ArrayList<SmartFilterReqItem> paramArrayList, bnvd parambnvd)
  {
    if (paramAppInterface == null)
    {
      bnrh.d(jdField_a_of_type_JavaLangString, "AppInterface is null");
      return;
    }
    bnrh.b(jdField_a_of_type_JavaLangString, "sendRequest");
    ((bnjs)paramAppInterface.getBusinessHandler(3)).a(paramArrayList, parambnvd);
  }
  
  public static float[] a(ImageStatisticsData paramImageStatisticsData)
  {
    float[] arrayOfFloat = new float[8];
    if (paramImageStatisticsData == null) {
      bnrh.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
    }
    while (paramImageStatisticsData == null) {
      return arrayOfFloat;
    }
    arrayOfFloat[0] = ((float)paramImageStatisticsData.lightness);
    arrayOfFloat[1] = ((float)paramImageStatisticsData.temperature);
    arrayOfFloat[2] = ((float)paramImageStatisticsData.overexposure);
    arrayOfFloat[3] = ((float)paramImageStatisticsData.underexposure);
    arrayOfFloat[4] = ((float)paramImageStatisticsData.contrast);
    arrayOfFloat[5] = ((float)paramImageStatisticsData.saturation);
    arrayOfFloat[6] = ((float)paramImageStatisticsData.sharpness);
    arrayOfFloat[7] = ((float)paramImageStatisticsData.colorfulness);
    return arrayOfFloat;
  }
  
  public void a()
  {
    bnrh.b(jdField_a_of_type_JavaLangString, "cancelProcess");
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry != null) && (localEntry.getValue() != null)) {
          ((bnvy)localEntry.getValue()).a();
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bnrh.d(jdField_a_of_type_JavaLangString, "onResponseFailed: errorCode=" + paramInt1);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)) {}
    bnvy localbnvy;
    do
    {
      return;
      localbnvy = (bnvy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2));
    } while (localbnvy == null);
    localbnvy.b();
    bnvc localbnvc = localbnvy.a();
    if (localbnvc != null)
    {
      localbnvc.a(paramInt1, localbnvy.a());
      return;
    }
    bnrh.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, bnvy parambnvy)
  {
    if (parambnvy == null) {
      throw new IllegalArgumentException("proxy should not be null");
    }
    bnrh.b(jdField_a_of_type_JavaLangString, "processAIFilter: " + parambnvy.getClass().getSimpleName());
    bnvc localbnvc = parambnvy.a();
    boolean bool;
    if (parambnvy.a())
    {
      bool = boaf.a().b();
      if (bool) {
        break label103;
      }
      bnrh.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: lut res not ready");
      if (localbnvc != null) {
        localbnvc.aF_();
      }
    }
    label103:
    do
    {
      do
      {
        return;
        bool = boaf.a().a();
        break;
        if (FeatureManager.Features.IMAGE_ALGO.init()) {
          break label134;
        }
        bnrh.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: image_aglo not ready");
      } while (localbnvc == null);
      localbnvc.aF_();
      return;
      if (NetworkUtil.isNetworkAvailable()) {
        break label159;
      }
    } while (localbnvc == null);
    label134:
    localbnvc.a(-4, parambnvy.a());
    return;
    label159:
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    parambnvy.a(paramContext, new bnva(this, paramAppInterface, parambnvy, localbnvc));
  }
  
  public void a(List<bnwc> paramList, int paramInt)
  {
    bnrh.b(jdField_a_of_type_JavaLangString, "onResponseSuccess");
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)) {}
    bnvy localbnvy;
    do
    {
      return;
      localbnvy = (bnvy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    } while (localbnvy == null);
    bnrh.b(jdField_a_of_type_JavaLangString, "proxy handleResponse");
    paramList = localbnvy.a(paramList);
    localbnvy.b();
    this.b = System.currentTimeMillis();
    bnrh.b(jdField_a_of_type_JavaLangString, "AIFilterPref: cost = " + (this.b - this.jdField_a_of_type_Long) + "ms");
    bnvc localbnvc = localbnvy.a();
    if (localbnvc != null)
    {
      bnrh.b(jdField_a_of_type_JavaLangString, "has observer");
      if (paramList != null)
      {
        bnrh.b(jdField_a_of_type_JavaLangString, "observer onAIFilterApplySuccess");
        localbnvc.a(0, paramList);
      }
      for (;;)
      {
        localbnvy.a();
        return;
        bnrh.b(jdField_a_of_type_JavaLangString, "observer onAIFilterAppliedFailed, errorCode=-5");
        localbnvc.a(-5, localbnvy.a());
      }
    }
    bnrh.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnuz
 * JD-Core Version:    0.7.0.1
 */