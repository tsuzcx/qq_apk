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

public class bmfh
{
  private static final String jdField_a_of_type_JavaLangString = bmfh.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private ConcurrentHashMap<Integer, bmgg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private long b;
  
  private bmfh()
  {
    if (PhotoAIFilter.getTemperatureStatisticsPath().equals("")) {
      PhotoAIFilter.setTemperatureStatisticsPath(bmkn.a().b() + File.separator);
    }
    com.tencent.ttpic.openapi.filter.TTBeautyV5SmoothFilter.enableFacecolor = false;
  }
  
  public static bmfh a()
  {
    return bmfm.a;
  }
  
  public static HashMap<String, String> a(ImageStatisticsData paramImageStatisticsData)
  {
    HashMap localHashMap = new HashMap();
    if (paramImageStatisticsData == null) {
      bmbx.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
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
  
  private void a(AppInterface paramAppInterface, ArrayList<SmartFilterReqItem> paramArrayList, bmfl parambmfl)
  {
    if (paramAppInterface == null)
    {
      bmbx.d(jdField_a_of_type_JavaLangString, "AppInterface is null");
      return;
    }
    bmbx.b(jdField_a_of_type_JavaLangString, "sendRequest");
    ((blup)paramAppInterface.getBusinessHandler(3)).a(paramArrayList, parambmfl);
  }
  
  public static float[] a(ImageStatisticsData paramImageStatisticsData)
  {
    float[] arrayOfFloat = new float[8];
    if (paramImageStatisticsData == null) {
      bmbx.d(jdField_a_of_type_JavaLangString, "smartFilterData is null");
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
    bmbx.b(jdField_a_of_type_JavaLangString, "cancelProcess");
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry != null) && (localEntry.getValue() != null)) {
          ((bmgg)localEntry.getValue()).a();
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bmbx.d(jdField_a_of_type_JavaLangString, "onResponseFailed: errorCode=" + paramInt1);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)) {}
    bmgg localbmgg;
    do
    {
      return;
      localbmgg = (bmgg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2));
    } while (localbmgg == null);
    localbmgg.b();
    bmfk localbmfk = localbmgg.a();
    if (localbmfk != null)
    {
      localbmfk.a(paramInt1, localbmgg.a());
      return;
    }
    bmbx.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, bmgg parambmgg)
  {
    if (parambmgg == null) {
      throw new IllegalArgumentException("proxy should not be null");
    }
    bmbx.b(jdField_a_of_type_JavaLangString, "processAIFilter: " + parambmgg.getClass().getSimpleName());
    bmfk localbmfk = parambmgg.a();
    boolean bool;
    if (parambmgg.a())
    {
      bool = bmkn.a().b();
      if (bool) {
        break label103;
      }
      bmbx.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: lut res not ready");
      if (localbmfk != null) {
        localbmfk.aD_();
      }
    }
    label103:
    do
    {
      do
      {
        return;
        bool = bmkn.a().a();
        break;
        if (FeatureManager.Features.IMAGE_ALGO.init()) {
          break label134;
        }
        bmbx.d(jdField_a_of_type_JavaLangString, "processAIFilter: AIFilter request failed: image_aglo not ready");
      } while (localbmfk == null);
      localbmfk.aD_();
      return;
      if (NetworkUtil.isNetworkAvailable()) {
        break label159;
      }
    } while (localbmfk == null);
    label134:
    localbmfk.a(-4, parambmgg.a());
    return;
    label159:
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    parambmgg.a(paramContext, new bmfi(this, paramAppInterface, parambmgg, localbmfk));
  }
  
  public void a(List<bmgk> paramList, int paramInt)
  {
    bmbx.b(jdField_a_of_type_JavaLangString, "onResponseSuccess");
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)) {}
    bmgg localbmgg;
    do
    {
      return;
      localbmgg = (bmgg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    } while (localbmgg == null);
    bmbx.b(jdField_a_of_type_JavaLangString, "proxy handleResponse");
    paramList = localbmgg.a(paramList);
    localbmgg.b();
    this.b = System.currentTimeMillis();
    bmbx.b(jdField_a_of_type_JavaLangString, "AIFilterPref: cost = " + (this.b - this.jdField_a_of_type_Long) + "ms");
    bmfk localbmfk = localbmgg.a();
    if (localbmfk != null)
    {
      bmbx.b(jdField_a_of_type_JavaLangString, "has observer");
      if (paramList != null)
      {
        bmbx.b(jdField_a_of_type_JavaLangString, "observer onAIFilterApplySuccess");
        localbmfk.a(0, paramList);
      }
      for (;;)
      {
        localbmgg.a();
        return;
        bmbx.b(jdField_a_of_type_JavaLangString, "observer onAIFilterAppliedFailed, errorCode=-5");
        localbmfk.a(-5, localbmgg.a());
      }
    }
    bmbx.b(jdField_a_of_type_JavaLangString, "no observer, abandon response");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfh
 * JD-Core Version:    0.7.0.1
 */