package com.tencent.comic.api.plugin;

import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.concurrent.ConcurrentHashMap;

public class HitRateHelper
{
  private static final ConcurrentHashMap<Integer, HitRateHelper> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final int jdField_a_of_type_Int;
  public PreloadProcHitPluginSession a;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  private final int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 0;
  private int d = 0;
  
  public HitRateHelper(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = null;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    c();
  }
  
  public static HitRateHelper a(int paramInt)
  {
    return (HitRateHelper)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ((IQQComicPluginUtil)QRoute.api(IQQComicPluginUtil.class)).reportHitRate(this.jdField_b_of_type_Boolean ^ true, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_JavaLangString, String.valueOf(this.d));
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.d = 0;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    b();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    HitRateHelper localHitRateHelper = (HitRateHelper)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if ((localHitRateHelper != null) && (localHitRateHelper.jdField_a_of_type_Boolean)) {
      localHitRateHelper.b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.c = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.d = paramInt2;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.comic.api.plugin.HitRateHelper
 * JD-Core Version:    0.7.0.1
 */