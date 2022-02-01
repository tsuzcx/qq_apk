import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class bczl
{
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	android/os/Build$VERSION:SDK_INT	I
    //   6: istore_0
    //   7: iload_0
    //   8: bipush 23
    //   10: if_icmpge +7 -> 17
    //   13: ldc 2
    //   15: monitorexit
    //   16: return
    //   17: invokestatic 19	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()I
    //   20: istore_0
    //   21: new 21	java/util/HashMap
    //   24: dup
    //   25: invokespecial 24	java/util/HashMap:<init>	()V
    //   28: astore_1
    //   29: aload_1
    //   30: ldc 26
    //   32: iload_0
    //   33: invokestatic 32	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   36: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   39: pop
    //   40: aload_1
    //   41: ldc 38
    //   43: new 40	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   50: getstatic 14	android/os/Build$VERSION:SDK_INT	I
    //   53: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: ldc 47
    //   58: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: aload_1
    //   69: ldc 56
    //   71: new 40	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   78: getstatic 62	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   81: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 64
    //   86: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: getstatic 67	android/os/Build:MODEL	Ljava/lang/String;
    //   92: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokevirtual 36	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   101: pop
    //   102: invokestatic 73	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   105: invokestatic 79	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   108: ldc 47
    //   110: ldc 81
    //   112: iconst_1
    //   113: lconst_0
    //   114: lconst_0
    //   115: aload_1
    //   116: ldc 47
    //   118: invokevirtual 85	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   121: goto -108 -> 13
    //   124: astore_1
    //   125: ldc 2
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: bipush 252
    //   133: istore_0
    //   134: ldc 81
    //   136: iconst_1
    //   137: ldc 87
    //   139: aload_1
    //   140: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   143: goto -122 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	128	0	i	int
    //   28	88	1	localHashMap	HashMap
    //   124	5	1	localObject	Object
    //   130	10	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   3	7	124	finally
    //   17	21	124	finally
    //   21	121	124	finally
    //   134	143	124	finally
    //   17	21	130	java/lang/Throwable
  }
  
  public static void a(int paramInt1, int paramInt2, long paramLong)
  {
    String str = "actCapturePhotoCamera";
    if (paramInt1 == 2) {
      str = "actCapturePhotoCamera2";
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_type", paramInt1 + "");
    localHashMap.put("param_cost", paramLong + "");
    localHashMap.put("param_size", paramInt2 + "");
    localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
    localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", str, true, paramLong, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczl
 * JD-Core Version:    0.7.0.1
 */