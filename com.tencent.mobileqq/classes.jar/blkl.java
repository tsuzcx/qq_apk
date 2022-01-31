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

public class blkl
{
  private static final String jdField_a_of_type_JavaLangString = blkl.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private ConcurrentLinkedQueue<blle> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private long b;
  
  private blkl()
  {
    if (PhotoAIFilter.getTemperatureStatisticsPath().equals("")) {
      PhotoAIFilter.setTemperatureStatisticsPath(blnt.a().b() + File.separator);
    }
    com.tencent.ttpic.openapi.filter.TTBeautyV5SmoothFilter.enableFacecolor = false;
  }
  
  public static blkl a()
  {
    return blko.a;
  }
  
  public static HashMap<String, String> a(ImageStatisticsData paramImageStatisticsData)
  {
    HashMap localHashMap = new HashMap();
    if (paramImageStatisticsData == null) {
      bljn.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
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
      bljn.d(jdField_a_of_type_JavaLangString, "AppInterface is null");
      return;
    }
    bljn.b(jdField_a_of_type_JavaLangString, "sendRequest");
    ((bkzt)paramAppInterface.getBusinessHandler(3)).a(paramArrayList);
  }
  
  public static float[] a(ImageStatisticsData paramImageStatisticsData)
  {
    float[] arrayOfFloat = new float[8];
    if (paramImageStatisticsData == null) {
      bljn.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
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
    bljn.b(jdField_a_of_type_JavaLangString, "cancelProcess");
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext()) {
        ((blle)localIterator.next()).a();
      }
    }
  }
  
  public void a(int paramInt)
  {
    bljn.d(jdField_a_of_type_JavaLangString, "onResponseFailed: errorCode=" + paramInt);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() == 0)) {}
    blle localblle;
    do
    {
      return;
      localblle = (blle)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    } while (localblle == null);
    localblle.b();
    blkn localblkn = localblle.a();
    if (localblkn != null)
    {
      localblkn.a(paramInt, localblle.a());
      return;
    }
    bljn.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, blle paramblle)
  {
    bljn.b(jdField_a_of_type_JavaLangString, "processAIFilter: " + paramblle.getClass().getSimpleName());
    if (paramblle == null) {
      throw new IllegalArgumentException("proxy should not be null");
    }
    blkn localblkn = paramblle.a();
    boolean bool;
    if (paramblle.a())
    {
      bool = blnt.a().b();
      if (bool) {
        break label103;
      }
      bljn.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: lut res not ready");
      if (localblkn != null) {
        localblkn.aU_();
      }
    }
    label103:
    do
    {
      do
      {
        return;
        bool = blnt.a().a();
        break;
        if (FeatureManager.Features.IMAGE_ALGO.init()) {
          break label133;
        }
        bljn.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: image_aglo not ready");
      } while (localblkn == null);
      localblkn.aU_();
      return;
      if (bdin.a()) {
        break label158;
      }
    } while (localblkn == null);
    label133:
    localblkn.a(-4, paramblle.a());
    return;
    label158:
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramblle);
    paramblle.a(paramContext, new blkm(this, paramAppInterface, localblkn, paramblle));
  }
  
  public void a(List<blli> paramList)
  {
    bljn.b(jdField_a_of_type_JavaLangString, "onResponseSuccess");
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() == 0)) {}
    blle localblle;
    do
    {
      return;
      localblle = (blle)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    } while (localblle == null);
    bljn.b(jdField_a_of_type_JavaLangString, "proxy handleResponse");
    paramList = localblle.a(paramList);
    localblle.b();
    this.b = System.currentTimeMillis();
    bljn.b(jdField_a_of_type_JavaLangString, "AIFilterPref: cost = " + (this.b - this.jdField_a_of_type_Long) + "ms");
    blkn localblkn = localblle.a();
    if (localblkn != null)
    {
      bljn.b(jdField_a_of_type_JavaLangString, "has observer");
      if (paramList != null)
      {
        bljn.b(jdField_a_of_type_JavaLangString, "observer onAIFilterApplySuccess");
        localblkn.a(0, paramList);
      }
      for (;;)
      {
        localblle.a();
        return;
        bljn.b(jdField_a_of_type_JavaLangString, "observer onAIFilterAppliedFailed, errorCode=-5");
        localblkn.a(-5, localblle.a());
      }
    }
    bljn.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkl
 * JD-Core Version:    0.7.0.1
 */