import android.content.Context;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.microrapid.opencv.ImageStatisticsData;
import com.tencent.common.app.AppInterface;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bocc
{
  private static final String jdField_a_of_type_JavaLangString = bocc.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private ConcurrentLinkedQueue<bocz> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private long b;
  
  private bocc()
  {
    if (PhotoAIFilter.getTemperatureStatisticsPath().equals("")) {
      PhotoAIFilter.setTemperatureStatisticsPath(bofw.a().b() + File.separator);
    }
    com.tencent.ttpic.openapi.filter.TTBeautyV5SmoothFilter.enableFacecolor = false;
  }
  
  public static bocc a()
  {
    return bocf.a;
  }
  
  public static HashMap<String, String> a(ImageStatisticsData paramImageStatisticsData)
  {
    HashMap localHashMap = new HashMap();
    if (paramImageStatisticsData == null) {
      bnzb.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
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
  
  private void a(AppInterface paramAppInterface, ArrayList<SmartFilterReqItem> paramArrayList)
  {
    if (paramAppInterface == null)
    {
      bnzb.d(jdField_a_of_type_JavaLangString, "AppInterface is null");
      return;
    }
    bnzb.b(jdField_a_of_type_JavaLangString, "sendRequest");
    ((bnox)paramAppInterface.getBusinessHandler(3)).a(paramArrayList);
  }
  
  public static float[] a(ImageStatisticsData paramImageStatisticsData)
  {
    float[] arrayOfFloat = new float[8];
    if (paramImageStatisticsData == null) {
      bnzb.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
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
    bnzb.b(jdField_a_of_type_JavaLangString, "cancelProcess");
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext()) {
        ((bocz)localIterator.next()).a();
      }
    }
  }
  
  public void a(int paramInt)
  {
    bnzb.d(jdField_a_of_type_JavaLangString, "onResponseFailed: errorCode=" + paramInt);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() == 0)) {}
    bocz localbocz;
    do
    {
      return;
      localbocz = (bocz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    } while (localbocz == null);
    localbocz.b();
    boce localboce = localbocz.a();
    if (localboce != null)
    {
      localboce.a(paramInt, localbocz.a());
      return;
    }
    bnzb.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, bocz parambocz)
  {
    bnzb.b(jdField_a_of_type_JavaLangString, "processAIFilter: " + parambocz.getClass().getSimpleName());
    if (parambocz == null) {
      throw new IllegalArgumentException("proxy should not be null");
    }
    boce localboce = parambocz.a();
    boolean bool;
    if (parambocz.a())
    {
      bool = bofw.a().b();
      if (bool) {
        break label103;
      }
      bnzb.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: lut res not ready");
      if (localboce != null) {
        localboce.aS_();
      }
    }
    label103:
    do
    {
      do
      {
        return;
        bool = bofw.a().a();
        break;
        if (FeatureManager.Features.IMAGE_ALGO.init()) {
          break label133;
        }
        bnzb.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: image_aglo not ready");
      } while (localboce == null);
      localboce.aS_();
      return;
      if (bgnt.a()) {
        break label158;
      }
    } while (localboce == null);
    label133:
    localboce.a(-4, parambocz.a());
    return;
    label158:
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(parambocz);
    parambocz.a(paramContext, new bocd(this, paramAppInterface, localboce, parambocz));
  }
  
  public void a(List<bodd> paramList)
  {
    bnzb.b(jdField_a_of_type_JavaLangString, "onResponseSuccess");
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() == 0)) {}
    bocz localbocz;
    do
    {
      return;
      localbocz = (bocz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    } while (localbocz == null);
    bnzb.b(jdField_a_of_type_JavaLangString, "proxy handleResponse");
    paramList = localbocz.a(paramList);
    localbocz.b();
    this.b = System.currentTimeMillis();
    bnzb.b(jdField_a_of_type_JavaLangString, "AIFilterPref: cost = " + (this.b - this.jdField_a_of_type_Long) + "ms");
    boce localboce = localbocz.a();
    if (localboce != null)
    {
      bnzb.b(jdField_a_of_type_JavaLangString, "has observer");
      if (paramList != null)
      {
        bnzb.b(jdField_a_of_type_JavaLangString, "observer onAIFilterApplySuccess");
        localboce.a(0, paramList);
      }
      for (;;)
      {
        localbocz.a();
        return;
        bnzb.b(jdField_a_of_type_JavaLangString, "observer onAIFilterAppliedFailed, errorCode=-5");
        localboce.a(-5, localbocz.a());
      }
    }
    bnzb.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bocc
 * JD-Core Version:    0.7.0.1
 */