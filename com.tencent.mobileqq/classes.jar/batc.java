import android.content.Context;
import android.os.SystemClock;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ShortVideoUploadABTest.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class batc
{
  public static long a;
  public static batd a;
  public static Object a;
  public static HashMap<Long, batd> a;
  public static boolean a;
  public static long b;
  public static batd b;
  public static long c;
  public static long d;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Boolean = true;
  }
  
  public static batd a(long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      batd localbatd2 = (batd)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      batd localbatd1 = localbatd2;
      if (localbatd2 == null) {
        localbatd1 = new batd();
      }
      jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localbatd1);
      return localbatd1;
    }
  }
  
  public static String a(batd parambatd)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("(Andr)老方案\n");
    String str;
    if (parambatd.jdField_c_of_type_Int == 0)
    {
      str = "成功";
      localStringBuilder2 = localStringBuilder2.append(str);
      if (parambatd.jdField_c_of_type_Int != 0) {
        break label317;
      }
      str = "";
      label44:
      localStringBuilder2.append(str).append("\n");
      localStringBuilder1.append("等待:").append(parambatd.jdField_b_of_type_Long).append("ms\n");
      localStringBuilder1.append("时长:").append(parambatd.jdField_d_of_type_Int).append("s\n");
      localStringBuilder1.append("Size:").append(parambatd.jdField_a_of_type_Long / 1024L).append("KB").append("\n");
      localStringBuilder1.append("AIO跳转:").append("400ms\n");
      localStringBuilder1.append("合成:").append(parambatd.jdField_e_of_type_Long).append("ms\n");
      localStringBuilder1.append("缩略图:").append(parambatd.h).append("ms\n");
      localStringBuilder1.append("Processor:").append(parambatd.g + "ms\n");
      localStringBuilder1.append("落地:").append(parambatd.jdField_d_of_type_JavaLangString).append("ms\n");
      localStringBuilder1.append("MD5:").append(parambatd.jdField_b_of_type_JavaLangString).append("\n");
      int i = baqx.a().a();
      if (i == -1) {
        break label346;
      }
      localStringBuilder1.append("Net:").append(aljq.c[i]).append("\n");
    }
    for (;;)
    {
      localStringBuilder1.append("StepInfo:").append(parambatd.jdField_c_of_type_JavaLangString).append("\n");
      localStringBuilder1.append("版本:").append(AppSetting.b());
      return localStringBuilder1.toString();
      str = "失败(";
      break;
      label317:
      str = String.valueOf(parambatd.jdField_c_of_type_Int) + ")";
      break label44;
      label346:
      localStringBuilder1.append("Net:").append("None").append("\n");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      if ((jdField_a_of_type_Batd != null) && (b != null))
      {
        jdField_a_of_type_Batd.jdField_a_of_type_Float = ((float)jdField_a_of_type_Batd.jdField_b_of_type_Long);
        b.jdField_a_of_type_Float = ((float)b.jdField_b_of_type_Long);
        QLog.d("ShortVideoUploadABTest", 2, "VideoABTest :  performABTest : New :" + jdField_a_of_type_Batd.jdField_a_of_type_Float + " Old:" + b.jdField_a_of_type_Float);
        localStringBuilder1 = new StringBuilder("(Andr)新老对比结果:\n");
        localStringBuilder2 = localStringBuilder1.append("新方案:").append("用户等待:");
        if (jdField_a_of_type_Batd.jdField_b_of_type_Long >= 0L) {
          break label290;
        }
      }
      label290:
      for (Object localObject1 = "0";; localObject1 = String.valueOf(jdField_a_of_type_Batd.jdField_b_of_type_Long))
      {
        localStringBuilder2.append((String)localObject1).append("ms,时长:").append(jdField_a_of_type_Batd.jdField_d_of_type_Int).append("s").append("\n");
        localStringBuilder1.append("老方案:").append("用户等待:").append(b.jdField_b_of_type_Long).append("ms,时长:").append(b.jdField_d_of_type_Int).append("s").append("\n");
        localStringBuilder1.append("----------\n结论:");
        if (jdField_a_of_type_Batd.jdField_a_of_type_Float > b.jdField_a_of_type_Float) {
          break;
        }
        localStringBuilder1.append("新方案更优");
        localObject1 = new SessionInfo();
        ((SessionInfo)localObject1).jdField_a_of_type_Int = jdField_a_of_type_Batd.jdField_a_of_type_Int;
        ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = jdField_a_of_type_Batd.jdField_a_of_type_JavaLangString;
        ThreadManager.getUIHandler().postDelayed(new ShortVideoUploadABTest.1(paramQQAppInterface, (SessionInfo)localObject1, localStringBuilder1), 200L);
        jdField_a_of_type_Batd = null;
        b = null;
        return;
      }
      localStringBuilder1.append("老方案更优");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String arg2, long paramLong, int paramInt2)
  {
    if (!b(paramInt1, ???)) {
      return;
    }
    for (;;)
    {
      batd localbatd;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localbatd = a(paramLong);
        if (localbatd.jdField_d_of_type_Long == 0L)
        {
          QLog.d("ShortVideoUploadABTest", 2, "VideoABTest :  uinSeq" + paramLong + " FinishAt " + SystemClock.uptimeMillis());
          localbatd.jdField_d_of_type_Long = SystemClock.uptimeMillis();
          if (paramInt2 != 3) {
            break label178;
          }
          localbatd.jdField_b_of_type_Int = 1;
          if ((localbatd.jdField_c_of_type_Long != 0L) && (localbatd.l != 0L)) {
            a(paramQQAppInterface, localbatd);
          }
        }
        else
        {
          return;
        }
      }
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : uinSeq" + paramLong + " Wait for : Merge_" + localbatd.l + " Click_" + localbatd.jdField_c_of_type_Long);
      continue;
      label178:
      localbatd.jdField_b_of_type_Int = 0;
      if (localbatd.jdField_c_of_type_Long != 0L) {
        a(paramQQAppInterface, localbatd);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if ((!b(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)) || (paramString == null)) {
      return;
    }
    acex.b(paramQQAppInterface, paramContext, paramSessionInfo, paramString);
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  public static void a(QQAppInterface paramQQAppInterface, batd parambatd)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 208	batd:jdField_a_of_type_Int	I
    //   4: aload_1
    //   5: getfield 211	batd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokestatic 240	batc:b	(ILjava/lang/String;)Z
    //   11: ifne +4 -> 15
    //   14: return
    //   15: aload_1
    //   16: getfield 283	batd:f	Ljava/lang/String;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnull +208 -> 231
    //   26: aload 4
    //   28: invokevirtual 286	java/lang/String:length	()I
    //   31: ifle +200 -> 231
    //   34: aload_1
    //   35: new 288	java/io/File
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 289	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: invokevirtual 291	java/io/File:length	()J
    //   47: putfield 294	batd:n	J
    //   50: getstatic 299	android/os/Build$VERSION:SDK_INT	I
    //   53: bipush 10
    //   55: if_icmplt +227 -> 282
    //   58: new 301	android/media/MediaMetadataRetriever
    //   61: dup
    //   62: invokespecial 302	android/media/MediaMetadataRetriever:<init>	()V
    //   65: astore_3
    //   66: aload_3
    //   67: astore_2
    //   68: aload_3
    //   69: aload 4
    //   71: invokevirtual 305	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   74: aload_3
    //   75: astore_2
    //   76: aload_1
    //   77: aload_3
    //   78: bipush 9
    //   80: invokevirtual 308	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   83: invokestatic 311	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   86: invokevirtual 314	java/lang/Long:longValue	()J
    //   89: putfield 317	batd:p	J
    //   92: aload_3
    //   93: astore_2
    //   94: aload_3
    //   95: invokevirtual 320	android/media/MediaMetadataRetriever:release	()V
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 320	android/media/MediaMetadataRetriever:release	()V
    //   106: aload_1
    //   107: aload_1
    //   108: getfield 244	batd:jdField_d_of_type_Long	J
    //   111: aload_1
    //   112: getfield 258	batd:jdField_c_of_type_Long	J
    //   115: lsub
    //   116: ldc2_w 321
    //   119: lsub
    //   120: putfield 70	batd:jdField_b_of_type_Long	J
    //   123: aload_1
    //   124: aload_1
    //   125: getfield 70	batd:jdField_b_of_type_Long	J
    //   128: l2f
    //   129: aload_1
    //   130: getfield 79	batd:jdField_d_of_type_Int	I
    //   133: i2f
    //   134: fdiv
    //   135: putfield 168	batd:jdField_a_of_type_Float	F
    //   138: aload_1
    //   139: getfield 256	batd:jdField_b_of_type_Int	I
    //   142: iconst_1
    //   143: if_icmpne +118 -> 261
    //   146: aload_1
    //   147: invokestatic 324	batc:b	(Lbatd;)Ljava/lang/String;
    //   150: astore_2
    //   151: aload_1
    //   152: putstatic 163	batc:jdField_a_of_type_Batd	Lbatd;
    //   155: new 205	com/tencent/mobileqq/activity/aio/SessionInfo
    //   158: dup
    //   159: invokespecial 206	com/tencent/mobileqq/activity/aio/SessionInfo:<init>	()V
    //   162: astore_3
    //   163: aload_3
    //   164: aload_1
    //   165: getfield 208	batd:jdField_a_of_type_Int	I
    //   168: putfield 209	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   171: aload_3
    //   172: aload_1
    //   173: getfield 211	batd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   176: putfield 212	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   179: aload_0
    //   180: invokestatic 326	batc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   183: aload_0
    //   184: invokestatic 332	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   187: invokevirtual 336	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   190: aload_3
    //   191: aload_2
    //   192: invokestatic 338	batc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;)V
    //   195: return
    //   196: astore 4
    //   198: aconst_null
    //   199: astore_3
    //   200: aload_3
    //   201: astore_2
    //   202: aload 4
    //   204: invokevirtual 341	java/lang/Exception:printStackTrace	()V
    //   207: aload_3
    //   208: ifnull -102 -> 106
    //   211: aload_3
    //   212: invokevirtual 320	android/media/MediaMetadataRetriever:release	()V
    //   215: goto -109 -> 106
    //   218: astore_0
    //   219: aconst_null
    //   220: astore_2
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 320	android/media/MediaMetadataRetriever:release	()V
    //   229: aload_0
    //   230: athrow
    //   231: ldc 170
    //   233: iconst_2
    //   234: new 50	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 343
    //   244: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload 4
    //   249: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: goto -152 -> 106
    //   261: aload_1
    //   262: invokestatic 345	batc:a	(Lbatd;)Ljava/lang/String;
    //   265: astore_2
    //   266: aload_1
    //   267: putstatic 165	batc:b	Lbatd;
    //   270: goto -115 -> 155
    //   273: astore_0
    //   274: goto -53 -> 221
    //   277: astore 4
    //   279: goto -79 -> 200
    //   282: aconst_null
    //   283: astore_3
    //   284: goto -186 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramQQAppInterface	QQAppInterface
    //   0	287	1	parambatd	batd
    //   67	199	2	localObject1	Object
    //   65	219	3	localObject2	Object
    //   19	51	4	str	String
    //   196	52	4	localException1	java.lang.Exception
    //   277	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   50	66	196	java/lang/Exception
    //   50	66	218	finally
    //   68	74	273	finally
    //   76	92	273	finally
    //   94	98	273	finally
    //   202	207	273	finally
    //   68	74	277	java/lang/Exception
    //   76	92	277	java/lang/Exception
    //   94	98	277	java/lang/Exception
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = jdField_a_of_type_Boolean;
    if (b(paramInt, paramString)) {
      if (jdField_a_of_type_Boolean) {
        break label62;
      }
    }
    label62:
    for (bool1 = bool3;; bool1 = false)
    {
      jdField_a_of_type_Boolean = bool1;
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : sEnablePreUpload" + jdField_a_of_type_Boolean);
      bool1 = bool2;
      return bool1;
    }
  }
  
  public static String b(batd parambatd)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("(Andr)新方案\n结果:");
    String str;
    if (parambatd.jdField_c_of_type_Int == 0)
    {
      str = "成功";
      localStringBuilder2 = localStringBuilder2.append(str);
      if (parambatd.jdField_c_of_type_Int != 0) {
        break label452;
      }
      str = "";
      label45:
      localStringBuilder2.append(str).append("\n");
      localStringBuilder2 = localStringBuilder1.append("等待:");
      if (parambatd.jdField_b_of_type_Long >= 0L) {
        break label463;
      }
      str = "0";
      label77:
      localStringBuilder2.append(str).append("ms");
      if (parambatd.jdField_b_of_type_Long >= 0L) {
        break label474;
      }
      localStringBuilder1.append("(").append(parambatd.jdField_b_of_type_Long).append(")\n");
      label120:
      localStringBuilder1.append("Rollback:").append(parambatd.jdField_e_of_type_Int).append("\n");
      localStringBuilder1.append("录制时长:").append(parambatd.i).append("ms\n");
      localStringBuilder1.append("合成指令:").append(parambatd.j).append("ms\n");
      localStringBuilder1.append("合成:").append("mqq_").append(parambatd.l).append("ms,  svr_").append(parambatd.m).append("ms\n");
      localStringBuilder1.append("时长:").append("mqq_").append(parambatd.p).append("ms,  svr_").append(parambatd.q).append("s\n");
      localStringBuilder1.append("Size:").append("mqq_").append(parambatd.n / 1024L).append("KB,  svr_").append(parambatd.o / 1024L).append("KB\n");
      localStringBuilder1.append("落地:").append(parambatd.jdField_d_of_type_JavaLangString).append("ms\n");
      localStringBuilder1.append("upload:").append(parambatd.g + "ms\n");
      int i = baqx.a().a();
      if (i == -1) {
        break label484;
      }
      localStringBuilder1.append("Net:").append(aljq.c[i]).append("\n");
    }
    for (;;)
    {
      localStringBuilder1.append("分片耗时:").append(parambatd.jdField_e_of_type_JavaLangString).append("\n");
      localStringBuilder1.append("uniSeq:").append(parambatd.k).append("\n");
      localStringBuilder1.append("版本:").append(AppSetting.b());
      return localStringBuilder1.toString();
      str = "失败-";
      break;
      label452:
      str = String.valueOf(parambatd.jdField_c_of_type_Int);
      break label45;
      label463:
      str = String.valueOf(parambatd.jdField_b_of_type_Long);
      break label77;
      label474:
      localStringBuilder1.append("\n");
      break label120;
      label484:
      localStringBuilder1.append("Net:").append("None").append("\n");
    }
  }
  
  public static boolean b(int paramInt, String paramString)
  {
    if (!a()) {}
    do
    {
      return false;
      if ((paramInt == 0) && ("51640996".equalsIgnoreCase(paramString))) {
        return true;
      }
    } while ((paramInt != 1) || (!"498450958".equalsIgnoreCase(paramString)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batc
 * JD-Core Version:    0.7.0.1
 */