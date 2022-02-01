package com.tencent.biz.qqcircle.publish.service.video;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.biz.qqcircle.utils.FileUtils;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QzoneVideoPluginService
  extends Service
{
  private static long a = 0L;
  private static long b = 0L;
  private static volatile int c = 0;
  private static volatile boolean d = false;
  private static Messenger e;
  private static boolean f = false;
  private static volatile boolean g;
  private static List<Message> h = new ArrayList();
  private static String i;
  private static boolean j;
  private static String k = QCircleConfigHelper.a("QZoneTextSetting", "VideoGifComposeFail", "gif合成失败");
  private static String l = QCircleConfigHelper.a("QZoneTextSetting", "VideoComposeSuccess", "合成视频成功");
  private static String m = QCircleConfigHelper.a("QZoneTextSetting", "VideoComposeFail", "合成视频失败!");
  private static String n = QCircleConfigHelper.a("QZoneTextSetting", "VideoTrimFailMessage", "裁剪错误:");
  private static String o = QCircleConfigHelper.a("QZoneTextSetting", "VideoTrimSuccessMessage", "裁剪视频成功");
  private static Handler p = new QzoneVideoPluginService.1();
  private static QzoneVideoPluginService.CPUMonitorRunnable q = new QzoneVideoPluginService.CPUMonitorRunnable();
  private static Handler r = new QzoneVideoPluginService.2();
  private static Messenger s = new Messenger(p);
  
  public static boolean a()
  {
    return f;
  }
  
  /* Error */
  public static int b()
  {
    // Byte code:
    //   0: ldc 132
    //   2: fstore_1
    //   3: new 134	java/io/BufferedReader
    //   6: dup
    //   7: new 136	java/io/InputStreamReader
    //   10: dup
    //   11: new 138	java/io/FileInputStream
    //   14: dup
    //   15: ldc 140
    //   17: invokespecial 143	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   20: invokespecial 146	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: sipush 1000
    //   26: invokespecial 149	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   29: astore 8
    //   31: fload_1
    //   32: fstore_0
    //   33: aload 8
    //   35: astore 7
    //   37: aload 8
    //   39: invokevirtual 153	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 9
    //   44: aload 9
    //   46: ifnonnull +25 -> 71
    //   49: aload 8
    //   51: invokevirtual 156	java/io/BufferedReader:close	()V
    //   54: iconst_0
    //   55: ireturn
    //   56: astore 7
    //   58: ldc 158
    //   60: iconst_1
    //   61: aload 7
    //   63: invokevirtual 161	java/lang/Exception:toString	()Ljava/lang/String;
    //   66: invokestatic 167	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: iconst_0
    //   70: ireturn
    //   71: fload_1
    //   72: fstore_0
    //   73: aload 8
    //   75: astore 7
    //   77: aload 9
    //   79: ldc 169
    //   81: invokevirtual 175	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   84: astore 9
    //   86: fload_1
    //   87: fstore_0
    //   88: aload 8
    //   90: astore 7
    //   92: aload 9
    //   94: iconst_2
    //   95: aaload
    //   96: invokestatic 181	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   99: aload 9
    //   101: iconst_3
    //   102: aaload
    //   103: invokestatic 181	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   106: ladd
    //   107: aload 9
    //   109: iconst_4
    //   110: aaload
    //   111: invokestatic 181	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   114: ladd
    //   115: lstore_3
    //   116: fload_1
    //   117: fstore_0
    //   118: aload 8
    //   120: astore 7
    //   122: aload 9
    //   124: iconst_5
    //   125: aaload
    //   126: invokestatic 181	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   129: lstore 5
    //   131: fload_1
    //   132: fstore_0
    //   133: aload 8
    //   135: astore 7
    //   137: lload_3
    //   138: getstatic 183	com/tencent/biz/qqcircle/publish/service/video/QzoneVideoPluginService:a	J
    //   141: lsub
    //   142: l2f
    //   143: fstore_2
    //   144: fload_1
    //   145: fstore_0
    //   146: aload 8
    //   148: astore 7
    //   150: lload_3
    //   151: getstatic 183	com/tencent/biz/qqcircle/publish/service/video/QzoneVideoPluginService:a	J
    //   154: lsub
    //   155: lload 5
    //   157: ladd
    //   158: getstatic 185	com/tencent/biz/qqcircle/publish/service/video/QzoneVideoPluginService:b	J
    //   161: lsub
    //   162: l2f
    //   163: fstore_1
    //   164: fload_1
    //   165: fstore_0
    //   166: aload 8
    //   168: astore 7
    //   170: fload_2
    //   171: ldc 186
    //   173: fmul
    //   174: fload_1
    //   175: fdiv
    //   176: fstore_1
    //   177: fload_1
    //   178: fstore_0
    //   179: aload 8
    //   181: astore 7
    //   183: lload_3
    //   184: putstatic 183	com/tencent/biz/qqcircle/publish/service/video/QzoneVideoPluginService:a	J
    //   187: fload_1
    //   188: fstore_0
    //   189: aload 8
    //   191: astore 7
    //   193: lload 5
    //   195: putstatic 185	com/tencent/biz/qqcircle/publish/service/video/QzoneVideoPluginService:b	J
    //   198: fload_1
    //   199: fstore_2
    //   200: aload 8
    //   202: invokevirtual 156	java/io/BufferedReader:close	()V
    //   205: goto +72 -> 277
    //   208: astore 7
    //   210: ldc 158
    //   212: iconst_1
    //   213: aload 7
    //   215: invokevirtual 161	java/lang/Exception:toString	()Ljava/lang/String;
    //   218: invokestatic 167	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: fload_2
    //   222: fstore_1
    //   223: goto +54 -> 277
    //   226: astore 9
    //   228: goto +18 -> 246
    //   231: astore 7
    //   233: aconst_null
    //   234: astore 8
    //   236: goto +56 -> 292
    //   239: astore 9
    //   241: aconst_null
    //   242: astore 8
    //   244: fload_1
    //   245: fstore_0
    //   246: aload 8
    //   248: astore 7
    //   250: ldc 158
    //   252: iconst_1
    //   253: aload 9
    //   255: invokevirtual 187	java/io/IOException:toString	()Ljava/lang/String;
    //   258: invokestatic 167	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: fload_0
    //   262: fstore_1
    //   263: aload 8
    //   265: ifnull +12 -> 277
    //   268: fload_0
    //   269: fstore_2
    //   270: aload 8
    //   272: invokevirtual 156	java/io/BufferedReader:close	()V
    //   275: fload_0
    //   276: fstore_1
    //   277: fload_1
    //   278: invokestatic 193	java/lang/Math:round	(F)I
    //   281: ireturn
    //   282: astore 9
    //   284: aload 7
    //   286: astore 8
    //   288: aload 9
    //   290: astore 7
    //   292: aload 8
    //   294: ifnull +24 -> 318
    //   297: aload 8
    //   299: invokevirtual 156	java/io/BufferedReader:close	()V
    //   302: goto +16 -> 318
    //   305: astore 8
    //   307: ldc 158
    //   309: iconst_1
    //   310: aload 8
    //   312: invokevirtual 161	java/lang/Exception:toString	()Ljava/lang/String;
    //   315: invokestatic 167	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload 7
    //   320: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	244	0	f1	float
    //   2	276	1	f2	float
    //   143	127	2	f3	float
    //   115	69	3	l1	long
    //   129	65	5	l2	long
    //   35	1	7	localObject1	Object
    //   56	6	7	localException1	Exception
    //   75	117	7	localObject2	Object
    //   208	6	7	localException2	Exception
    //   231	1	7	localObject3	Object
    //   248	71	7	localObject4	Object
    //   29	269	8	localObject5	Object
    //   305	6	8	localException3	Exception
    //   42	81	9	localObject6	Object
    //   226	1	9	localIOException1	java.io.IOException
    //   239	15	9	localIOException2	java.io.IOException
    //   282	7	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   49	54	56	java/lang/Exception
    //   200	205	208	java/lang/Exception
    //   270	275	208	java/lang/Exception
    //   37	44	226	java/io/IOException
    //   77	86	226	java/io/IOException
    //   92	116	226	java/io/IOException
    //   122	131	226	java/io/IOException
    //   137	144	226	java/io/IOException
    //   150	164	226	java/io/IOException
    //   170	177	226	java/io/IOException
    //   183	187	226	java/io/IOException
    //   193	198	226	java/io/IOException
    //   3	31	231	finally
    //   3	31	239	java/io/IOException
    //   37	44	282	finally
    //   77	86	282	finally
    //   92	116	282	finally
    //   122	131	282	finally
    //   137	144	282	finally
    //   150	164	282	finally
    //   170	177	282	finally
    //   183	187	282	finally
    //   193	198	282	finally
    //   250	261	282	finally
    //   297	302	305	java/lang/Exception
  }
  
  private static void b(Message paramMessage)
  {
    Object localObject1 = (Intent)paramMessage.obj;
    paramMessage = ((Intent)localObject1).getStringExtra("video_source_path");
    int i1 = ((Intent)localObject1).getIntExtra("video_type", -1);
    i = ((Intent)localObject1).getStringExtra("client_key");
    int i2 = ((Intent)localObject1).getIntExtra("retry_num", 0);
    boolean bool1 = ((Intent)localObject1).getBooleanExtra("noDeleteFile", false);
    j = ((Intent)localObject1).getBooleanExtra("video_is_generate_gif", false);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("START BUILD_VIDEO, sourcePath=");
    ((StringBuilder)localObject2).append(paramMessage);
    ((StringBuilder)localObject2).append(", type=");
    ((StringBuilder)localObject2).append(i1);
    ((StringBuilder)localObject2).append(", cacheKey=");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", retryNum=");
    ((StringBuilder)localObject2).append(i2);
    ((StringBuilder)localObject2).append(", isGenerateGif=");
    ((StringBuilder)localObject2).append(j);
    QLog.i("[upload2][compress]", 1, ((StringBuilder)localObject2).toString());
    if (i1 == 1)
    {
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 1;
      ((Message)localObject2).getData().putString("client_key", i);
      r.sendMessage((Message)localObject2);
      long l1 = ((Intent)localObject1).getLongExtra("start_time", -1L);
      long l2 = ((Intent)localObject1).getLongExtra("end_time", -1L);
      boolean bool2 = ((Intent)localObject1).getBooleanExtra("need_origin", false);
      long l3 = ((Intent)localObject1).getLongExtra("video_total_duration", -1L);
      QCircleHostQzoneThreadHelper.postVideoThread(new TrimVideoThread(QCircleApplication.APP, r, paramMessage, l1, l2, l3, i, bool2, i2, bool1, ((Intent)localObject1).getBooleanExtra("video_is_sync_to_weishi", false), ((Intent)localObject1).getBooleanExtra("video_is_use_qcircle_rate", false)));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("START BUILD_VIDEO FOR TRIM, sourcePath=");
      ((StringBuilder)localObject1).append(paramMessage);
      ((StringBuilder)localObject1).append(", type=");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(", cacheKey=");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", retryNum=");
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append(", isGenerateGif=");
      ((StringBuilder)localObject1).append(j);
      QLog.i("[upload2][compress]", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  private static void b(Message paramMessage, String paramString)
  {
    paramMessage = new Intent();
    paramMessage.putExtra("client_key", paramString);
    paramString = Message.obtain();
    paramString.what = 1003;
    paramString.obj = paramMessage;
    try
    {
      e.send(paramString);
      return;
    }
    catch (Exception paramMessage)
    {
      QLog.e("[QcirclePublish]QzoneVideoPluginService", 1, "MSG_WHAT_TRIM_START sendMessageToClient", paramMessage);
    }
  }
  
  private static void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMessageToClient, source path=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", clientKey=");
    ((StringBuilder)localObject).append(paramString4);
    ((StringBuilder)localObject).append(" dstPath=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" errMsg=");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(" target=");
    ((StringBuilder)localObject).append(paramString4);
    QLog.i("[upload2][compress]", 1, ((StringBuilder)localObject).toString());
    if (e == null)
    {
      QLog.e("[upload2][compress]", 1, "no connection is active");
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("video_source_path", paramString1);
    ((Intent)localObject).putExtra("video_handle_result", paramBoolean);
    ((Intent)localObject).putExtra("video_dest_path", paramString2);
    ((Intent)localObject).putExtra("video_error_msg", paramString3);
    ((Intent)localObject).putExtra("client_key", paramString4);
    long l1 = FileUtils.e(paramString1);
    long l2 = FileUtils.e(paramString2);
    paramString1 = new StringBuilder();
    paramString1.append("video file size srcLen=");
    paramString1.append(l1);
    paramString1.append(",dstLen=");
    paramString1.append(l2);
    QLog.i("[QcirclePublish]QzoneVideoPluginService", 1, paramString1.toString());
    paramString1 = Message.obtain();
    paramString1.what = 1000;
    paramString1.obj = localObject;
    try
    {
      e.send(paramString1);
      QLog.e("[upload2][compress]", 1, "send to client success");
    }
    catch (Exception paramString1)
    {
      QLog.e("[upload2][compress]", 1, "sendMessageToClient error", paramString1);
    }
    if (h.size() > 0)
    {
      b((Message)h.remove(0));
      return;
    }
    g = false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBind, uin=");
    localStringBuilder.append(paramIntent.getStringExtra("qzone_uin"));
    QLog.i("[QcirclePublish]QzoneVideoPluginService", 1, localStringBuilder.toString());
    f = true;
    return s.getBinder();
  }
  
  public void onCreate()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate, thread=");
    localStringBuilder.append(Thread.currentThread().getName());
    QLog.i("[QcirclePublish]QzoneVideoPluginService", 1, localStringBuilder.toString());
    super.onCreate();
  }
  
  public void onDestroy()
  {
    QLog.i("[QcirclePublish]QzoneVideoPluginService", 1, "onDestroy");
    super.onDestroy();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    QLog.i("[QcirclePublish]QzoneVideoPluginService", 1, "onUnbind");
    e = null;
    f = false;
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.service.video.QzoneVideoPluginService
 * JD-Core Version:    0.7.0.1
 */