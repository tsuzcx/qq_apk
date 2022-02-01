package com.tencent.biz.qqstory.boundaries;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.qqstory.boundaries.delegates.ActivityDelegate;
import com.tencent.biz.qqstory.boundaries.implement.ExtensionFactoryImplement;
import com.tencent.biz.qqstory.boundaries.implement.SegmentViewFactoryImplement;
import com.tencent.biz.qqstory.boundaries.implement.StoryApiInjector;
import com.tencent.biz.qqstory.boundaries.implement.StoryConfigImplement;
import com.tencent.biz.qqstory.boundaries.implement.StoryProfileImplement;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.common.app.BaseApplicationImpl;

public class StoryApi
{
  public static <T extends Activity> ActivityDelegate<T> a(Class<? extends ActivityDelegate<T>> paramClass, Class<ActivityDelegate<T>> paramClass1, Object... paramVarArgs)
  {
    return (ActivityDelegate)ExtensionFactoryImplement.a(paramClass, paramClass1, paramVarArgs);
  }
  
  public static SegmentView a(Context paramContext, int paramInt)
  {
    return SegmentViewFactoryImplement.a(paramContext, paramInt);
  }
  
  public static Boolean a(int paramInt)
  {
    return Boolean.valueOf(BaseApplicationImpl.getApplication().getResources().getBoolean(paramInt));
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    return ExtensionFactoryImplement.a(paramClass, paramVarArgs);
  }
  
  public static String a(int paramInt, Object... paramVarArgs)
  {
    return BaseApplicationImpl.getApplication().getResources().getString(paramInt, paramVarArgs);
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  public static void a(Context paramContext, int paramInt, long paramLong)
  {
    StoryProfileImplement.a(paramContext, paramInt, paramLong);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    StoryProfileImplement.a(paramContext, paramInt, paramString);
  }
  
  public static void a(Object paramObject)
  {
    StoryApiInjector.a(paramObject);
  }
  
  public static boolean a()
  {
    return StoryConfigImplement.a();
  }
  
  public static String b(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getString(paramInt);
  }
  
  public static String[] c(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getStringArray(paramInt);
  }
  
  public static int d(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getInteger(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.StoryApi
 * JD-Core Version:    0.7.0.1
 */