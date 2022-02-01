package com.tencent.biz.qqstory.utils;

import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class VideoSourceTagInfoHelper
{
  private static List<VideoSourceTagInfoHelper.VideoSourceTagInfo> a;
  private static final Object b = new Object();
  
  public static String a(int paramInt)
  {
    b();
    VideoSourceTagInfoHelper.VideoSourceTagInfo localVideoSourceTagInfo = c(paramInt);
    if (localVideoSourceTagInfo != null) {
      return localVideoSourceTagInfo.b;
    }
    return "";
  }
  
  public static void a()
  {
    synchronized (b)
    {
      if (a != null)
      {
        a.clear();
        a = null;
      }
      return;
    }
  }
  
  public static String b(int paramInt)
  {
    b();
    VideoSourceTagInfoHelper.VideoSourceTagInfo localVideoSourceTagInfo = c(paramInt);
    if (localVideoSourceTagInfo != null) {
      return localVideoSourceTagInfo.c;
    }
    return "";
  }
  
  /* Error */
  private static void b()
  {
    // Byte code:
    //   0: getstatic 33	com/tencent/biz/qqstory/utils/VideoSourceTagInfoHelper:a	Ljava/util/List;
    //   3: ifnonnull +172 -> 175
    //   6: getstatic 16	com/tencent/biz/qqstory/utils/VideoSourceTagInfoHelper:b	Ljava/lang/Object;
    //   9: astore_0
    //   10: aload_0
    //   11: monitorenter
    //   12: new 46	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 47	java/util/ArrayList:<init>	()V
    //   19: putstatic 33	com/tencent/biz/qqstory/utils/VideoSourceTagInfoHelper:a	Ljava/util/List;
    //   22: bipush 10
    //   24: invokestatic 52	com/tencent/biz/qqstory/model/SuperManager:a	(I)Lcom/tencent/biz/qqstory/model/IManager;
    //   27: checkcast 54	com/tencent/biz/qqstory/model/StoryConfigManager
    //   30: invokevirtual 58	com/tencent/biz/qqstory/model/StoryConfigManager:l	()Ljava/lang/String;
    //   33: astore_1
    //   34: new 60	org/json/JSONObject
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 63	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   42: astore_2
    //   43: aload_2
    //   44: invokevirtual 67	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   47: astore_3
    //   48: aload_3
    //   49: invokeinterface 73 1 0
    //   54: ifeq +113 -> 167
    //   57: aload_3
    //   58: invokeinterface 77 1 0
    //   63: checkcast 79	java/lang/String
    //   66: astore 4
    //   68: aload_2
    //   69: aload 4
    //   71: invokevirtual 83	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   74: astore 6
    //   76: aload 6
    //   78: ldc 85
    //   80: ldc 31
    //   82: invokevirtual 89	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 5
    //   87: aload 6
    //   89: ldc 91
    //   91: ldc 31
    //   93: invokevirtual 89	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 6
    //   98: getstatic 33	com/tencent/biz/qqstory/utils/VideoSourceTagInfoHelper:a	Ljava/util/List;
    //   101: new 26	com/tencent/biz/qqstory/utils/VideoSourceTagInfoHelper$VideoSourceTagInfo
    //   104: dup
    //   105: aload 4
    //   107: invokestatic 97	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   110: invokevirtual 101	java/lang/Integer:intValue	()I
    //   113: aload 5
    //   115: aload 6
    //   117: invokespecial 104	com/tencent/biz/qqstory/utils/VideoSourceTagInfoHelper$VideoSourceTagInfo:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   120: invokeinterface 108 2 0
    //   125: pop
    //   126: goto -78 -> 48
    //   129: ldc 110
    //   131: ldc 112
    //   133: iconst_1
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload_1
    //   140: aastore
    //   141: invokestatic 118	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: goto +23 -> 167
    //   147: astore_2
    //   148: ldc 110
    //   150: ldc 120
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
    //   164: invokestatic 118	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  @Nullable
  private static VideoSourceTagInfoHelper.VideoSourceTagInfo c(int paramInt)
  {
    b();
    Iterator localIterator = Collections.unmodifiableList(a).iterator();
    while (localIterator.hasNext())
    {
      VideoSourceTagInfoHelper.VideoSourceTagInfo localVideoSourceTagInfo = (VideoSourceTagInfoHelper.VideoSourceTagInfo)localIterator.next();
      if (localVideoSourceTagInfo.a == paramInt) {
        return localVideoSourceTagInfo;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.VideoSourceTagInfoHelper
 * JD-Core Version:    0.7.0.1
 */