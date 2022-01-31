package com.tencent.biz.qqstory.base.preload.cachecleaner;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import nai;

@TargetApi(14)
public class CacheCleaner
{
  protected static CacheCleaner a;
  public static final String a;
  public static final String[] a;
  public static final String b;
  public static final String[] b;
  public static final String[] c = { QQStoryConstant.g };
  public static final String[] d = { QQStoryConstant.c };
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aZ + "qqstory/";
    jdField_b_of_type_JavaLangString = AppConstants.aZ + "qqstory_watermark/";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { QQStoryConstant.f, QQStoryConstant.i, QQStoryConstant.q };
  }
  
  public static CacheCleaner a()
  {
    if (jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerCacheCleaner == null) {
      jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerCacheCleaner = new CacheCleaner();
    }
    return jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerCacheCleaner;
  }
  
  protected void a()
  {
    ThreadManager.post(new nai(this), 2, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!a(paramBoolean)) {
      return;
    }
    a();
  }
  
  protected boolean a(boolean paramBoolean)
  {
    long l1 = 3600L;
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    long l2 = System.currentTimeMillis();
    long l3 = ((Long)localStoryConfigManager.b("cache_clean_latest_time", Long.valueOf(0L))).longValue();
    if (paramBoolean) {}
    while (Math.abs(l2 - l3) < l1 * 1000L)
    {
      return false;
      l1 = ((Long)localStoryConfigManager.b("StoryClearRate", Long.valueOf(3600L))).longValue();
    }
    localStoryConfigManager.b("cache_clean_latest_time", Long.valueOf(l2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner
 * JD-Core Version:    0.7.0.1
 */