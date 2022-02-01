package com.tencent.biz.qqstory.base.preload.cachecleaner;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

@TargetApi(14)
public class CacheCleaner
{
  protected static CacheCleaner a;
  public static final String a;
  protected static final String[] a;
  public static final String b;
  protected static final String[] b;
  protected static final String[] c = { QQStoryConstant.i };
  protected static final String[] d = { QQStoryConstant.e };
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.SDCARD_FILE_SAVE_TMP_PATH + "qqstory/";
    jdField_b_of_type_JavaLangString = AppConstants.SDCARD_FILE_SAVE_TMP_PATH + "qqstory_watermark/";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { QQStoryConstant.h, QQStoryConstant.k, QQStoryConstant.u };
  }
  
  public static CacheCleaner a()
  {
    if (jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerCacheCleaner == null) {
      jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerCacheCleaner = new CacheCleaner();
    }
    return jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerCacheCleaner;
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.post(new CacheCleaner.2(this, paramBoolean), 2, null, false);
  }
  
  public void a()
  {
    Bosses.get().postJob(new CacheCleaner.1(this, "Q.qqstory.cleaner:CacheCleaner"));
  }
  
  protected boolean a(boolean paramBoolean)
  {
    long l1 = 3600L;
    label185:
    for (;;)
    {
      try
      {
        StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
        long l2 = System.currentTimeMillis();
        long l3 = ((Long)localStoryConfigManager.b("cache_clean_latest_time", Long.valueOf(0L))).longValue();
        String str1;
        if (paramBoolean)
        {
          l3 = Math.abs(l2 - l3);
          if (l3 < l1 * 1000L)
          {
            l1 = l3 / 1000L / 60L / 60L;
            if (!paramBoolean) {
              break label185;
            }
            str1 = "low";
            SLog.a("Q.qqstory.cleaner:CacheCleaner", "clean before %d h , no need to clean again , capacity state :%s", Long.valueOf(l1), str1);
            paramBoolean = false;
            return paramBoolean;
          }
        }
        else
        {
          l1 = ((Long)localStoryConfigManager.b("StoryClearRate", Long.valueOf(3600L))).longValue();
          continue;
        }
        if (paramBoolean)
        {
          str1 = "low";
          SLog.d("Q.qqstory.cleaner:CacheCleaner", "clean cache , capacity state :%s", new Object[] { str1 });
          localStoryConfigManager.b("cache_clean_latest_time", Long.valueOf(l2));
          paramBoolean = true;
        }
        else
        {
          str1 = "healthy";
          continue;
          String str2 = "healthy";
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner
 * JD-Core Version:    0.7.0.1
 */