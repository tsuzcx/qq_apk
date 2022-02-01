package com.tencent.biz.qqstory.utils;

import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class VideoSourceTagInfoHelper
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static List<VideoSourceTagInfoHelper.VideoSourceTagInfo> jdField_a_of_type_JavaUtilList;
  
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
  
  /* Error */
  private static void b()
  {
    // Byte code:
    //   0: getstatic 23	com/tencent/biz/qqstory/utils/VideoSourceTagInfoHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3: ifnonnull +172 -> 175
    //   6: getstatic 15	com/tencent/biz/qqstory/utils/VideoSourceTagInfoHelper:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   9: astore_0
    //   10: aload_0
    //   11: monitorenter
    //   12: new 70	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 71	java/util/ArrayList:<init>	()V
    //   19: putstatic 23	com/tencent/biz/qqstory/utils/VideoSourceTagInfoHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   22: bipush 10
    //   24: invokestatic 76	com/tencent/biz/qqstory/model/SuperManager:a	(I)Lcom/tencent/biz/qqstory/model/IManager;
    //   27: checkcast 78	com/tencent/biz/qqstory/model/StoryConfigManager
    //   30: invokevirtual 82	com/tencent/biz/qqstory/model/StoryConfigManager:c	()Ljava/lang/String;
    //   33: astore_1
    //   34: new 84	org/json/JSONObject
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 87	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   42: astore_2
    //   43: aload_2
    //   44: invokevirtual 90	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   47: astore_3
    //   48: aload_3
    //   49: invokeinterface 41 1 0
    //   54: ifeq +113 -> 167
    //   57: aload_3
    //   58: invokeinterface 45 1 0
    //   63: checkcast 92	java/lang/String
    //   66: astore 4
    //   68: aload_2
    //   69: aload 4
    //   71: invokevirtual 96	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   74: astore 6
    //   76: aload 6
    //   78: ldc 98
    //   80: ldc 59
    //   82: invokevirtual 102	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 5
    //   87: aload 6
    //   89: ldc 104
    //   91: ldc 59
    //   93: invokevirtual 102	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 6
    //   98: getstatic 23	com/tencent/biz/qqstory/utils/VideoSourceTagInfoHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   101: new 47	com/tencent/biz/qqstory/utils/VideoSourceTagInfoHelper$VideoSourceTagInfo
    //   104: dup
    //   105: aload 4
    //   107: invokestatic 110	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   110: invokevirtual 114	java/lang/Integer:intValue	()I
    //   113: aload 5
    //   115: aload 6
    //   117: invokespecial 117	com/tencent/biz/qqstory/utils/VideoSourceTagInfoHelper$VideoSourceTagInfo:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   120: invokeinterface 121 2 0
    //   125: pop
    //   126: goto -78 -> 48
    //   129: ldc 123
    //   131: ldc 125
    //   133: iconst_1
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload_1
    //   140: aastore
    //   141: invokestatic 131	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: goto +23 -> 167
    //   147: astore_2
    //   148: ldc 123
    //   150: ldc 133
    //   152: iconst_2
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload_2
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: aload_1
    //   163: aastore
    //   164: invokestatic 131	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: aload_0
    //   168: monitorexit
    //   169: return
    //   170: astore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    //   175: return
    //   176: astore_2
    //   177: goto -48 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	163	0	localObject1	Object
    //   33	130	1	str1	String
    //   170	4	1	localObject2	Object
    //   42	27	2	localJSONObject	org.json.JSONObject
    //   147	12	2	localJSONException	org.json.JSONException
    //   176	1	2	localNumberFormatException	java.lang.NumberFormatException
    //   47	11	3	localIterator	Iterator
    //   66	40	4	str2	String
    //   85	29	5	str3	String
    //   74	42	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   34	48	147	org/json/JSONException
    //   48	126	147	org/json/JSONException
    //   12	34	170	finally
    //   34	48	170	finally
    //   48	126	170	finally
    //   129	144	170	finally
    //   148	167	170	finally
    //   167	169	170	finally
    //   171	173	170	finally
    //   34	48	176	java/lang/NumberFormatException
    //   48	126	176	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.VideoSourceTagInfoHelper
 * JD-Core Version:    0.7.0.1
 */