package com.tencent.biz.qqstory.utils;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoSourceTagInfoHelper
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static List<VideoSourceTagInfoHelper.VideoSourceTagInfo> jdField_a_of_type_JavaUtilList = null;
  
  @Nullable
  private static VideoSourceTagInfoHelper.VideoSourceTagInfo a(int paramInt)
  {
    b();
    Iterator localIterator = Collections.unmodifiableList(jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      VideoSourceTagInfoHelper.VideoSourceTagInfo localVideoSourceTagInfo = (VideoSourceTagInfoHelper.VideoSourceTagInfo)localIterator.next();
      if (localVideoSourceTagInfo.jdField_a_of_type_Int == paramInt) {
        return localVideoSourceTagInfo;
      }
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    b();
    VideoSourceTagInfoHelper.VideoSourceTagInfo localVideoSourceTagInfo = a(paramInt);
    if (localVideoSourceTagInfo != null) {
      return localVideoSourceTagInfo.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilList != null)
      {
        jdField_a_of_type_JavaUtilList.clear();
        jdField_a_of_type_JavaUtilList = null;
      }
      return;
    }
  }
  
  public static String b(int paramInt)
  {
    b();
    VideoSourceTagInfoHelper.VideoSourceTagInfo localVideoSourceTagInfo = a(paramInt);
    if (localVideoSourceTagInfo != null) {
      return localVideoSourceTagInfo.b;
    }
    return "";
  }
  
  private static void b()
  {
    if (jdField_a_of_type_JavaUtilList == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        jdField_a_of_type_JavaUtilList = new ArrayList();
        String str1 = ((StoryConfigManager)SuperManager.a(10)).c();
        try
        {
          JSONObject localJSONObject = new JSONObject(str1);
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            Object localObject3 = localJSONObject.getJSONObject(str2);
            String str3 = ((JSONObject)localObject3).optString("jump_url", "");
            localObject3 = ((JSONObject)localObject3).optString("wording", "");
            jdField_a_of_type_JavaUtilList.add(new VideoSourceTagInfoHelper.VideoSourceTagInfo(Integer.valueOf(str2).intValue(), str3, (String)localObject3));
          }
          localObject2 = finally;
        }
        catch (JSONException localJSONException)
        {
          SLog.e("VideoSourceTagInfoHelper", "check read config error : %s, configStr : %s", new Object[] { localJSONException, str1 });
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            SLog.e("VideoSourceTagInfoHelper", "type format error : %s", new Object[] { str1 });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.VideoSourceTagInfoHelper
 * JD-Core Version:    0.7.0.1
 */