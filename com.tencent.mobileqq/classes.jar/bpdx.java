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

public class bpdx
{
  private static final String jdField_a_of_type_JavaLangString = bpdx.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private ConcurrentLinkedQueue<bpeu> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private long b;
  
  private bpdx()
  {
    if (PhotoAIFilter.getTemperatureStatisticsPath().equals("")) {
      PhotoAIFilter.setTemperatureStatisticsPath(bphr.a().b() + File.separator);
    }
    com.tencent.ttpic.openapi.filter.TTBeautyV5SmoothFilter.enableFacecolor = false;
  }
  
  public static bpdx a()
  {
    return bpea.a;
  }
  
  public static HashMap<String, String> a(ImageStatisticsData paramImageStatisticsData)
  {
    HashMap localHashMap = new HashMap();
    if (paramImageStatisticsData == null) {
      bpam.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
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
      bpam.d(jdField_a_of_type_JavaLangString, "AppInterface is null");
      return;
    }
    bpam.b(jdField_a_of_type_JavaLangString, "sendRequest");
    ((boqi)paramAppInterface.getBusinessHandler(3)).a(paramArrayList);
  }
  
  public static float[] a(ImageStatisticsData paramImageStatisticsData)
  {
    float[] arrayOfFloat = new float[8];
    if (paramImageStatisticsData == null) {
      bpam.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
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
    bpam.b(jdField_a_of_type_JavaLangString, "cancelProcess");
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext()) {
        ((bpeu)localIterator.next()).a();
      }
    }
  }
  
  public void a(int paramInt)
  {
    bpam.d(jdField_a_of_type_JavaLangString, "onResponseFailed: errorCode=" + paramInt);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() == 0)) {}
    bpeu localbpeu;
    do
    {
      return;
      localbpeu = (bpeu)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    } while (localbpeu == null);
    localbpeu.b();
    bpdz localbpdz = localbpeu.a();
    if (localbpdz != null)
    {
      localbpdz.a(paramInt, localbpeu.a());
      return;
    }
    bpam.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, bpeu parambpeu)
  {
    bpam.b(jdField_a_of_type_JavaLangString, "processAIFilter: " + parambpeu.getClass().getSimpleName());
    if (parambpeu == null) {
      throw new IllegalArgumentException("proxy should not be null");
    }
    bpdz localbpdz = parambpeu.a();
    boolean bool;
    if (parambpeu.a())
    {
      bool = bphr.a().b();
      if (bool) {
        break label103;
      }
      bpam.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: lut res not ready");
      if (localbpdz != null) {
        localbpdz.aS_();
      }
    }
    label103:
    do
    {
      do
      {
        return;
        bool = bphr.a().a();
        break;
        if (FeatureManager.Features.IMAGE_ALGO.init()) {
          break label133;
        }
        bpam.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: image_aglo not ready");
      } while (localbpdz == null);
      localbpdz.aS_();
      return;
      if (bhnv.a()) {
        break label158;
      }
    } while (localbpdz == null);
    label133:
    localbpdz.a(-4, parambpeu.a());
    return;
    label158:
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(parambpeu);
    parambpeu.a(paramContext, new bpdy(this, paramAppInterface, localbpdz, parambpeu));
  }
  
  public void a(List<bpey> paramList)
  {
    bpam.b(jdField_a_of_type_JavaLangString, "onResponseSuccess");
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() == 0)) {}
    bpeu localbpeu;
    do
    {
      return;
      localbpeu = (bpeu)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    } while (localbpeu == null);
    bpam.b(jdField_a_of_type_JavaLangString, "proxy handleResponse");
    paramList = localbpeu.a(paramList);
    localbpeu.b();
    this.b = System.currentTimeMillis();
    bpam.b(jdField_a_of_type_JavaLangString, "AIFilterPref: cost = " + (this.b - this.jdField_a_of_type_Long) + "ms");
    bpdz localbpdz = localbpeu.a();
    if (localbpdz != null)
    {
      bpam.b(jdField_a_of_type_JavaLangString, "has observer");
      if (paramList != null)
      {
        bpam.b(jdField_a_of_type_JavaLangString, "observer onAIFilterApplySuccess");
        localbpdz.a(0, paramList);
      }
      for (;;)
      {
        localbpeu.a();
        return;
        bpam.b(jdField_a_of_type_JavaLangString, "observer onAIFilterAppliedFailed, errorCode=-5");
        localbpdz.a(-5, localbpeu.a());
      }
    }
    bpam.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdx
 * JD-Core Version:    0.7.0.1
 */