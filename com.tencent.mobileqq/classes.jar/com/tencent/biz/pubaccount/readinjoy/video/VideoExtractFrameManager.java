package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoExtractFrameManager
{
  private static long jdField_a_of_type_Long;
  private static VideoExtractFrameTask jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask;
  private static ArrayList<VideoExtractFrameManager.VideoInfo> jdField_a_of_type_JavaUtilArrayList;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private static long jdField_b_of_type_Long;
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private static long c;
  
  private static ArrayList<VideoExtractFrameManager.VideoInfo> a()
  {
    if (jdField_a_of_type_OrgJsonJSONObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = jdField_a_of_type_OrgJsonJSONObject.getJSONArray("videoList");
      int i = 0;
      while (i < localJSONArray.length())
      {
        VideoExtractFrameManager.VideoInfo localVideoInfo = new VideoExtractFrameManager.VideoInfo();
        Object localObject = (JSONObject)localJSONArray.get(i);
        localVideoInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("vid");
        localVideoInfo.jdField_a_of_type_Long = ((JSONObject)localObject).getLong("bitrate");
        localVideoInfo.jdField_b_of_type_Long = ((JSONObject)localObject).getLong("timeout_ms");
        localVideoInfo.jdField_a_of_type_Float = Float.valueOf(((JSONObject)localObject).getString("hevc_level")).floatValue();
        localVideoInfo.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("max_hashdiff");
        localVideoInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("tag");
        localObject = ((JSONObject)localObject).getJSONArray("frameInfo");
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          VideoExtractFrameTask.FrameInfo localFrameInfo = new VideoExtractFrameTask.FrameInfo();
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(j);
          localFrameInfo.jdField_a_of_type_Int = localJSONObject.getInt("index");
          localFrameInfo.jdField_a_of_type_Long = localJSONObject.getLong("serverHash");
          localVideoInfo.jdField_a_of_type_JavaUtilArrayList.add(localFrameInfo);
          j += 1;
        }
        localArrayList.add(localVideoInfo);
        i += 1;
      }
      return localThrowable;
    }
    catch (Throwable localThrowable)
    {
      return null;
    }
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "onEnterBackground() mHasRun = " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", mHasDestory = " + jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    if (Looper.getMainLooper() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "Looper == null, 直接返回");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (TVK_SDKMgr.isInstalled(BaseApplication.getContext())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("VideoExtractFrame", 2, "视频SDK未初始化，直接返回");
          return;
          if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VideoExtractFrame", 2, "当前进程已执行过一次，直接返回");
        return;
        if (a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VideoExtractFrame", 2, "条件不满足，不进行检测逻辑");
      return;
      if (b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoExtractFrame", 2, "当前设备OPENGL版本号低于2.0，直接返回");
    return;
    c();
  }
  
  /* Error */
  private static boolean a()
  {
    // Byte code:
    //   0: ldc 220
    //   2: ldc 222
    //   4: invokestatic 227	cooperation/readinjoy/ReadInJoyHelper:a	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast 229	java/lang/String
    //   10: astore 5
    //   12: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +29 -> 44
    //   18: ldc 148
    //   20: iconst_2
    //   21: new 150	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   28: ldc 231
    //   30: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 5
    //   35: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload 5
    //   46: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifeq +5 -> 54
    //   52: iconst_0
    //   53: ireturn
    //   54: new 50	org/json/JSONObject
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 240	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   63: putstatic 43	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   66: getstatic 43	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   69: ldc 242
    //   71: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 5
    //   76: getstatic 43	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   79: ldc 244
    //   81: invokevirtual 107	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   84: istore_0
    //   85: getstatic 43	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   88: ldc 246
    //   90: invokevirtual 107	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   93: istore_1
    //   94: aload 5
    //   96: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: istore 4
    //   101: iload 4
    //   103: ifne -51 -> 52
    //   106: aconst_null
    //   107: invokestatic 251	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   110: iconst_1
    //   111: if_icmpeq +19 -> 130
    //   114: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq -65 -> 52
    //   120: ldc 148
    //   122: iconst_2
    //   123: ldc 253
    //   125: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: iconst_0
    //   129: ireturn
    //   130: ldc 255
    //   132: ldc 222
    //   134: invokestatic 227	cooperation/readinjoy/ReadInJoyHelper:a	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: checkcast 229	java/lang/String
    //   140: astore 6
    //   142: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +30 -> 175
    //   148: ldc 148
    //   150: iconst_2
    //   151: new 150	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 257
    //   161: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 6
    //   166: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload 6
    //   177: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   180: ifne +160 -> 340
    //   183: new 50	org/json/JSONObject
    //   186: dup
    //   187: aload 6
    //   189: invokespecial 240	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   192: putstatic 140	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   195: getstatic 140	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   198: ldc_w 259
    //   201: ldc 222
    //   203: invokevirtual 262	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 6
    //   208: getstatic 140	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   211: ldc_w 264
    //   214: iconst_0
    //   215: invokevirtual 268	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   218: istore_2
    //   219: getstatic 140	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   222: ldc_w 270
    //   225: iconst_0
    //   226: invokevirtual 268	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   229: istore_3
    //   230: aload 5
    //   232: aload 6
    //   234: invokevirtual 273	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   237: ifeq +30 -> 267
    //   240: iload_2
    //   241: iload_0
    //   242: if_icmpge +8 -> 250
    //   245: iload_3
    //   246: iload_1
    //   247: if_icmplt +20 -> 267
    //   250: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq -201 -> 52
    //   256: ldc 148
    //   258: iconst_2
    //   259: ldc_w 275
    //   262: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: iconst_0
    //   266: ireturn
    //   267: aload 5
    //   269: aload 6
    //   271: invokevirtual 273	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   274: ifne +48 -> 322
    //   277: getstatic 140	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   280: ldc_w 259
    //   283: aload 5
    //   285: invokevirtual 279	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   288: pop
    //   289: getstatic 140	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   292: ldc_w 264
    //   295: iconst_0
    //   296: invokevirtual 282	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   299: pop
    //   300: getstatic 140	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   303: ldc_w 270
    //   306: iconst_0
    //   307: invokevirtual 282	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   310: pop
    //   311: ldc 255
    //   313: getstatic 140	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   316: invokevirtual 283	org/json/JSONObject:toString	()Ljava/lang/String;
    //   319: invokestatic 286	cooperation/readinjoy/ReadInJoyHelper:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   322: invokestatic 288	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:a	()Ljava/util/ArrayList;
    //   325: putstatic 289	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   328: getstatic 289	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   331: ifnull +71 -> 402
    //   334: iconst_1
    //   335: istore 4
    //   337: iload 4
    //   339: ireturn
    //   340: new 50	org/json/JSONObject
    //   343: dup
    //   344: invokespecial 290	org/json/JSONObject:<init>	()V
    //   347: putstatic 140	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   350: getstatic 140	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   353: ldc_w 259
    //   356: aload 5
    //   358: invokevirtual 279	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   361: pop
    //   362: getstatic 140	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   365: ldc_w 264
    //   368: iconst_0
    //   369: invokevirtual 282	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   372: pop
    //   373: getstatic 140	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   376: ldc_w 270
    //   379: iconst_0
    //   380: invokevirtual 282	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   383: pop
    //   384: ldc 255
    //   386: getstatic 140	com/tencent/biz/pubaccount/readinjoy/video/VideoExtractFrameManager:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   389: invokevirtual 283	org/json/JSONObject:toString	()Ljava/lang/String;
    //   392: invokestatic 286	cooperation/readinjoy/ReadInJoyHelper:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   395: goto -73 -> 322
    //   398: astore 5
    //   400: iconst_0
    //   401: ireturn
    //   402: iconst_0
    //   403: istore 4
    //   405: goto -68 -> 337
    //   408: astore 5
    //   410: iconst_0
    //   411: ireturn
    //   412: astore 5
    //   414: iconst_0
    //   415: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   84	159	0	i	int
    //   93	155	1	j	int
    //   218	25	2	k	int
    //   229	19	3	m	int
    //   99	305	4	bool	boolean
    //   10	347	5	str1	String
    //   398	1	5	localException1	Exception
    //   408	1	5	localException2	Exception
    //   412	1	5	localException3	Exception
    //   140	130	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   340	395	398	java/lang/Exception
    //   54	101	408	java/lang/Exception
    //   183	240	412	java/lang/Exception
    //   250	265	412	java/lang/Exception
    //   267	322	412	java/lang/Exception
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "onEnterForeground() mHasRun = " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", mHasDestory = " + jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    if ((jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask != null))
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask.b();
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask = null;
    }
  }
  
  private static void b(Context paramContext, VideoExtractFrameManager.VideoInfo paramVideoInfo, int paramInt, String paramString, HashMap<Integer, VideoExtractFrameTask.FrameInfo> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    Object localObject;
    boolean bool1;
    label185:
    int k;
    int j;
    try
    {
      localJSONObject.put("version", "8.5.5.5105");
      localJSONObject.put("subversion", "8.5.5");
      if (jdField_a_of_type_OrgJsonJSONObject == null) {
        break label631;
      }
      localObject = jdField_a_of_type_OrgJsonJSONObject.optString("version");
      localJSONObject.put("server_version", localObject);
      localJSONObject.put("video_tag", paramVideoInfo.jdField_b_of_type_JavaLangString);
      localJSONObject.put("video_vid", paramVideoInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("video_bitrate", paramVideoInfo.jdField_a_of_type_Long);
      localJSONObject.put("video_width", paramVideoInfo.jdField_b_of_type_Int);
      localJSONObject.put("video_height", paramVideoInfo.c);
      localJSONObject.put("task_cost_time", jdField_b_of_type_Long);
      localJSONObject.put("extract_frame_cost_time", c);
      localJSONObject.put("return_code", paramInt);
      localJSONObject.put("return_code_detail", paramString);
      if (paramInt != 1) {
        break label638;
      }
      bool1 = true;
      k = 0;
      j = 2147483647;
      int i = 0;
      int m = 0;
      paramInt = 0;
      boolean bool2 = bool1;
      if (bool1)
      {
        paramString = paramHashMap.values().iterator();
        j = 2147483647;
        i = 0;
        paramInt = m;
        label232:
        if (paramString.hasNext())
        {
          localObject = (VideoExtractFrameTask.FrameInfo)paramString.next();
          if (((VideoExtractFrameTask.FrameInfo)localObject).jdField_b_of_type_Int > paramVideoInfo.jdField_a_of_type_Int) {
            bool1 = false;
          }
          i += ((VideoExtractFrameTask.FrameInfo)localObject).jdField_b_of_type_Int;
          k = j;
          if (j > ((VideoExtractFrameTask.FrameInfo)localObject).jdField_b_of_type_Int) {
            k = ((VideoExtractFrameTask.FrameInfo)localObject).jdField_b_of_type_Int;
          }
          if (paramInt >= ((VideoExtractFrameTask.FrameInfo)localObject).jdField_b_of_type_Int) {
            break label644;
          }
          paramInt = ((VideoExtractFrameTask.FrameInfo)localObject).jdField_b_of_type_Int;
          break label624;
        }
        k = i / paramHashMap.size();
        m = i;
        bool2 = bool1;
        i = paramInt;
        paramInt = m;
      }
      localJSONObject.put("is_success", String.valueOf(bool2));
      localJSONObject.put("avg_hash_diff", k);
      localJSONObject.put("min_hash_diff", j);
      localJSONObject.put("max_hash_diff", i);
      localJSONObject.put("total_hash_diff", paramInt);
      paramVideoInfo = new JSONArray();
      paramString = paramHashMap.values().iterator();
      while (paramString.hasNext())
      {
        paramHashMap = (VideoExtractFrameTask.FrameInfo)paramString.next();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("frame_index", paramHashMap.jdField_a_of_type_Int);
        ((JSONObject)localObject).put("hash_diff", paramHashMap.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("server_hash", paramHashMap.jdField_a_of_type_Long);
        ((JSONObject)localObject).put("local_hash", paramHashMap.jdField_b_of_type_Long);
        paramVideoInfo.put(localObject);
        continue;
        localHashMap.put("param_content", localJSONObject.toString());
      }
    }
    catch (Exception paramVideoInfo) {}
    for (;;)
    {
      localHashMap.put("param_device", VideoDeviceInfoHelper.a());
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "灯塔数据上报 reportMap = " + localHashMap.toString());
      }
      paramVideoInfo = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramVideoInfo != null) {
        StatisticCollector.getInstance(paramContext).collectPerformance(paramVideoInfo.getCurrentUin(), "actKandianVideoExtractFrame", true, -1L, 0L, localHashMap, null);
      }
      return;
      localJSONObject.put("detail_list", paramVideoInfo);
    }
    label644:
    for (;;)
    {
      label624:
      j = k;
      break label232;
      label631:
      localObject = "";
      break;
      label638:
      bool1 = false;
      break label185;
    }
  }
  
  private static void b(VideoExtractFrameManager.VideoInfo paramVideoInfo, String paramString, HashMap<Integer, VideoExtractFrameTask.FrameInfo> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "innerDoExtractFrame start() videoInfo.tag = " + paramVideoInfo.jdField_b_of_type_JavaLangString);
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask = new VideoExtractFrameTask(BaseApplication.getContext(), paramString, paramHashMap, paramLong);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask.a(new VideoExtractFrameManager.2(paramVideoInfo));
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask.a();
  }
  
  private static boolean b()
  {
    boolean bool2 = false;
    try
    {
      Object localObject = (ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity");
      boolean bool1 = bool2;
      if (localObject != null)
      {
        localObject = ((ActivityManager)localObject).getDeviceConfigurationInfo();
        bool1 = bool2;
        if (localObject != null)
        {
          int i = ((ConfigurationInfo)localObject).reqGlEsVersion;
          if (i < 131072) {
            break label48;
          }
        }
      }
      label48:
      for (bool1 = true;; bool1 = false) {
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void c()
  {
    try
    {
      int i = jdField_b_of_type_OrgJsonJSONObject.optInt("KEY_LOCAL_RESULT_TRY_COUNT", 0);
      jdField_b_of_type_OrgJsonJSONObject.put("KEY_LOCAL_RESULT_TRY_COUNT", i + 1);
      ReadInJoyHelper.a("kandian_video_extract_frame_local_result", jdField_b_of_type_OrgJsonJSONObject.toString());
      float f = VideoDeviceInfoHelper.a();
      Object localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((VideoExtractFrameManager.VideoInfo)((Iterator)localObject).next()).jdField_a_of_type_Float > f) {
          ((Iterator)localObject).remove();
        }
      }
      if (jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "当前设备无支持播放的视频，直接返回");
        }
        return;
      }
      i = jdField_a_of_type_JavaUtilArrayList.size();
      i = new Random().nextInt(i);
      localObject = (VideoExtractFrameManager.VideoInfo)jdField_a_of_type_JavaUtilArrayList.get(i);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((VideoExtractFrameManager.VideoInfo)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        VideoExtractFrameTask.FrameInfo localFrameInfo = (VideoExtractFrameTask.FrameInfo)localIterator.next();
        localHashMap.put(Integer.valueOf(localFrameInfo.jdField_a_of_type_Int), localFrameInfo);
      }
      ThirdVideoManager.a().a(((VideoExtractFrameManager.VideoInfo)localObject).jdField_a_of_type_JavaLangString, new VideoExtractFrameManager.1((VideoExtractFrameManager.VideoInfo)localObject, localHashMap));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoExtractFrameManager
 * JD-Core Version:    0.7.0.1
 */