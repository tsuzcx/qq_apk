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

public class blge
{
  private static final String jdField_a_of_type_JavaLangString = blge.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private ConcurrentLinkedQueue<blgw> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private long b;
  
  private blge()
  {
    if (PhotoAIFilter.getTemperatureStatisticsPath().equals("")) {
      PhotoAIFilter.setTemperatureStatisticsPath(bljh.a().b() + File.separator);
    }
    com.tencent.ttpic.openapi.filter.TTBeautyV5SmoothFilter.enableFacecolor = false;
  }
  
  public static blge a()
  {
    return blgh.a;
  }
  
  public static HashMap<String, String> a(ImageStatisticsData paramImageStatisticsData)
  {
    HashMap localHashMap = new HashMap();
    if (paramImageStatisticsData == null) {
      blfg.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
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
      blfg.d(jdField_a_of_type_JavaLangString, "AppInterface is null");
      return;
    }
    blfg.b(jdField_a_of_type_JavaLangString, "sendRequest");
    ((bkvm)paramAppInterface.getBusinessHandler(3)).a(paramArrayList);
  }
  
  public static float[] a(ImageStatisticsData paramImageStatisticsData)
  {
    float[] arrayOfFloat = new float[8];
    if (paramImageStatisticsData == null) {
      blfg.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
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
    blfg.b(jdField_a_of_type_JavaLangString, "cancelProcess");
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext()) {
        ((blgw)localIterator.next()).a();
      }
    }
  }
  
  public void a(int paramInt)
  {
    blfg.d(jdField_a_of_type_JavaLangString, "onResponseFailed: errorCode=" + paramInt);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() == 0)) {}
    blgw localblgw;
    do
    {
      return;
      localblgw = (blgw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    } while (localblgw == null);
    localblgw.b();
    blgg localblgg = localblgw.a();
    if (localblgg != null)
    {
      localblgg.a(paramInt, localblgw.a());
      return;
    }
    blfg.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, blgw paramblgw)
  {
    blfg.b(jdField_a_of_type_JavaLangString, "processAIFilter: " + paramblgw.getClass().getSimpleName());
    if (paramblgw == null) {
      throw new IllegalArgumentException("proxy should not be null");
    }
    blgg localblgg = paramblgw.a();
    boolean bool;
    if (paramblgw.a())
    {
      bool = bljh.a().b();
      if (bool) {
        break label103;
      }
      blfg.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: lut res not ready");
      if (localblgg != null) {
        localblgg.aX_();
      }
    }
    label103:
    do
    {
      do
      {
        return;
        bool = bljh.a().a();
        break;
        if (FeatureManager.Features.IMAGE_ALGO.init()) {
          break label133;
        }
        blfg.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: image_aglo not ready");
      } while (localblgg == null);
      localblgg.aX_();
      return;
      if (bdee.a()) {
        break label158;
      }
    } while (localblgg == null);
    label133:
    localblgg.a(-4, paramblgw.a());
    return;
    label158:
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramblgw);
    paramblgw.a(paramContext, new blgf(this, paramAppInterface, localblgg, paramblgw));
  }
  
  public void a(List<blha> paramList)
  {
    blfg.b(jdField_a_of_type_JavaLangString, "onResponseSuccess");
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() == 0)) {}
    blgw localblgw;
    do
    {
      return;
      localblgw = (blgw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    } while (localblgw == null);
    blfg.b(jdField_a_of_type_JavaLangString, "proxy handleResponse");
    paramList = localblgw.a(paramList);
    localblgw.b();
    this.b = System.currentTimeMillis();
    blfg.b(jdField_a_of_type_JavaLangString, "AIFilterPref: cost = " + (this.b - this.jdField_a_of_type_Long) + "ms");
    blgg localblgg = localblgw.a();
    if (localblgg != null)
    {
      blfg.b(jdField_a_of_type_JavaLangString, "has observer");
      if (paramList != null)
      {
        blfg.b(jdField_a_of_type_JavaLangString, "observer onAIFilterApplySuccess");
        localblgg.a(0, paramList);
      }
      for (;;)
      {
        localblgw.a();
        return;
        blfg.b(jdField_a_of_type_JavaLangString, "observer onAIFilterAppliedFailed, errorCode=-5");
        localblgg.a(-5, localblgw.a());
      }
    }
    blfg.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blge
 * JD-Core Version:    0.7.0.1
 */