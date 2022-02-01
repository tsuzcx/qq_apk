import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioUtil.1;
import com.tencent.mobileqq.utils.AudioUtil.7;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.IOException;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class bhcl
{
  private static int jdField_a_of_type_Int;
  public static MediaPlayer a;
  private static awvo jdField_a_of_type_Awvo = new bhcm();
  
  public static int a()
  {
    return ((AudioManager)BaseApplicationImpl.sApplication.getSystemService("audio")).getRingerMode();
  }
  
  /* Error */
  private static MediaPlayer a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 45	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6: iload_1
    //   7: invokevirtual 51	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnull +151 -> 163
    //   15: new 53	android/media/MediaPlayer
    //   18: dup
    //   19: invokespecial 54	android/media/MediaPlayer:<init>	()V
    //   22: astore_2
    //   23: aload_2
    //   24: invokestatic 57	bhcl:a	(Landroid/media/MediaPlayer;)V
    //   27: aload_2
    //   28: aload_0
    //   29: invokevirtual 63	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   32: aload_0
    //   33: invokevirtual 67	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   36: aload_0
    //   37: invokevirtual 70	android/content/res/AssetFileDescriptor:getLength	()J
    //   40: invokevirtual 74	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   43: aload_0
    //   44: invokevirtual 77	android/content/res/AssetFileDescriptor:close	()V
    //   47: aload_2
    //   48: invokevirtual 80	android/media/MediaPlayer:prepare	()V
    //   51: aload_3
    //   52: astore_0
    //   53: aload_2
    //   54: astore_3
    //   55: aload_0
    //   56: ifnull +9 -> 65
    //   59: aload_0
    //   60: invokevirtual 77	android/content/res/AssetFileDescriptor:close	()V
    //   63: aload_2
    //   64: astore_3
    //   65: aload_3
    //   66: areturn
    //   67: astore_3
    //   68: aconst_null
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_0
    //   72: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +12 -> 87
    //   78: ldc 88
    //   80: iconst_2
    //   81: ldc 90
    //   83: aload_3
    //   84: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: aload_2
    //   88: ifnull +72 -> 160
    //   91: aload_2
    //   92: invokevirtual 97	android/media/MediaPlayer:release	()V
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_3
    //   99: aload_0
    //   100: ifnull -35 -> 65
    //   103: aload_0
    //   104: invokevirtual 77	android/content/res/AssetFileDescriptor:close	()V
    //   107: aload_2
    //   108: areturn
    //   109: astore_0
    //   110: aload_2
    //   111: areturn
    //   112: astore_2
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 77	android/content/res/AssetFileDescriptor:close	()V
    //   123: aload_2
    //   124: athrow
    //   125: astore_0
    //   126: aload_2
    //   127: areturn
    //   128: astore_2
    //   129: goto -34 -> 95
    //   132: astore_0
    //   133: goto -10 -> 123
    //   136: astore_2
    //   137: goto -22 -> 115
    //   140: astore_2
    //   141: goto -26 -> 115
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_2
    //   147: goto -75 -> 72
    //   150: astore_3
    //   151: goto -79 -> 72
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_0
    //   157: goto -85 -> 72
    //   160: goto -63 -> 97
    //   163: aconst_null
    //   164: astore_2
    //   165: goto -112 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramContext	Context
    //   0	168	1	paramInt	int
    //   22	89	2	localMediaPlayer1	MediaPlayer
    //   112	15	2	localMediaPlayer2	MediaPlayer
    //   128	1	2	localException1	Exception
    //   136	1	2	localObject1	Object
    //   140	1	2	localObject2	Object
    //   146	19	2	localObject3	Object
    //   1	65	3	localObject4	Object
    //   67	17	3	localException2	Exception
    //   98	1	3	localObject5	Object
    //   144	1	3	localException3	Exception
    //   150	1	3	localException4	Exception
    //   154	1	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   2	11	67	java/lang/Exception
    //   103	107	109	java/lang/Exception
    //   2	11	112	finally
    //   47	51	112	finally
    //   59	63	125	java/lang/Exception
    //   91	95	128	java/lang/Exception
    //   119	123	132	java/lang/Exception
    //   15	23	136	finally
    //   23	47	136	finally
    //   72	87	140	finally
    //   91	95	140	finally
    //   15	23	144	java/lang/Exception
    //   23	47	150	java/lang/Exception
    //   47	51	154	java/lang/Exception
  }
  
  private static MediaPlayer a(Context paramContext, Uri paramUri)
  {
    label42:
    do
    {
      try
      {
        localObject = new MediaPlayer();
        if (!QLog.isColorLevel()) {
          break label42;
        }
      }
      catch (IOException paramUri)
      {
        try
        {
          a((MediaPlayer)localObject);
          ((MediaPlayer)localObject).setDataSource(paramContext, paramUri);
          ((MediaPlayer)localObject).prepare();
          return localObject;
        }
        catch (IOException paramUri)
        {
          for (;;)
          {
            Object localObject;
            paramContext = (Context)localObject;
          }
        }
        paramUri = paramUri;
        paramContext = null;
      }
      QLog.d("createAndSetAudioStreamType", 2, "create failed:", paramUri);
      localObject = paramContext;
    } while (paramContext == null);
    try
    {
      paramContext.release();
      label52:
      return null;
    }
    catch (Exception paramContext)
    {
      break label52;
    }
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioUtil", 2, "[silkPlayer]mediaPlayerStop");
    }
    try
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
        if (QLog.isColorLevel()) {
          QLog.d("AudioUtil", 2, "[silkPlayer]mediaPlayerStop,mediaPalyer.release()");
        }
      }
      label40:
      jdField_a_of_type_AndroidMediaMediaPlayer = null;
      return;
    }
    catch (Exception localException)
    {
      break label40;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    try
    {
      a(paramInt1, paramInt2, paramOnCompletionListener, null);
      return;
    }
    finally
    {
      paramOnCompletionListener = finally;
      throw paramOnCompletionListener;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener, Handler paramHandler)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        boolean bool2 = jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
        if (!bool2) {
          continue;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("[SilkPlayer]mediaPlayerStart, exception, mediaPalyer == null ?  ");
        if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
          break label245;
        }
        QLog.e("AudioUtil", 1, bool1, localException);
        if (paramOnCompletionListener == null) {
          continue;
        }
        if ((paramHandler != null) && (paramHandler.getLooper() != Looper.myLooper())) {
          break label251;
        }
        QLog.e("AudioUtil", 1, "MediaPlayerStart, exception, branch 1");
        paramOnCompletionListener.onCompletion(jdField_a_of_type_AndroidMediaMediaPlayer);
        continue;
      }
      finally {}
      return;
      a();
      if (paramInt1 != AppSetting.d)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioUtil", 2, "[SilkPlayer] MediaPlayerStart, resId != AppSetting.TypeSystemSoundId");
        }
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.sApplication, paramInt1);
        if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          jdField_a_of_type_Int = paramInt2;
          if (jdField_a_of_type_Int != 0) {
            jdField_a_of_type_Int -= 1;
          }
          jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new bhcq(paramOnCompletionListener, paramHandler));
          jdField_a_of_type_AndroidMediaMediaPlayer.start();
          if (QLog.isColorLevel()) {
            QLog.d("AudioUtil", 2, "[SilkPlayer]mediaPlayerStart, 播放提示音，mediaPalyer.start().");
          }
          jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioUtil", 2, "[SilkPlayer] MediaPlayerStart, resId == AppSetting.TypeSystemSoundId");
        }
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.sApplication, Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      continue;
      label245:
      bool1 = false;
      continue;
      label251:
      QLog.e("AudioUtil", 1, "MediaPlayerStart, exception, branch 2");
      paramHandler.post(new AudioUtil.7(paramOnCompletionListener));
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("mediaPlayerStartForMsg", 2, "resourceId=" + paramInt + ",looping=" + paramBoolean);
        }
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        if (!jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("mediaPlayerStartForMsg", 2, "media palyer is playing");
        }
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("mediaPlayerStartForMsg", 2, "media palyer exception", localException1);
        continue;
      }
      finally {}
      return;
      try
      {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.e("mediaPlayerStartForMsg", 2, "media palyer release exception", localException2);
        label167:
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
        continue;
      }
      finally
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      if (paramInt != AppSetting.d)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = a(BaseApplicationImpl.sApplication, paramInt);
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("mediaPlayerStartForMsg", 2, "media palyer is null");
        }
      }
      else
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = a(BaseApplicationImpl.sApplication, Settings.System.DEFAULT_NOTIFICATION_URI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("mediaPlayerStartForMsg", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new bhco());
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
  
  private static void a(MediaPlayer paramMediaPlayer)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      paramMediaPlayer.setAudioStreamType(3);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MediaPlayerStart", 2, "get QQAppInterface error");
  }
  
  /* Error */
  public static void a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore 4
    //   10: aload 4
    //   12: ifnull +13 -> 25
    //   15: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   18: invokevirtual 97	android/media/MediaPlayer:release	()V
    //   21: aconst_null
    //   22: putstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   25: aload_0
    //   26: invokevirtual 269	android/net/Uri:getScheme	()Ljava/lang/String;
    //   29: ldc_w 271
    //   32: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifeq +195 -> 230
    //   38: new 53	android/media/MediaPlayer
    //   41: dup
    //   42: invokespecial 54	android/media/MediaPlayer:<init>	()V
    //   45: putstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   48: iload_2
    //   49: ifeq +25 -> 74
    //   52: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +13 -> 68
    //   58: ldc_w 279
    //   61: iconst_2
    //   62: ldc_w 281
    //   65: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   71: invokestatic 57	bhcl:a	(Landroid/media/MediaPlayer;)V
    //   74: new 283	java/io/FileInputStream
    //   77: dup
    //   78: new 285	java/io/File
    //   81: dup
    //   82: aload_0
    //   83: invokevirtual 288	android/net/Uri:getPath	()Ljava/lang/String;
    //   86: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: invokespecial 294	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   92: astore_0
    //   93: aload_0
    //   94: astore_3
    //   95: aload_0
    //   96: astore 4
    //   98: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   101: aload_0
    //   102: invokevirtual 297	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   105: invokevirtual 300	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   108: aload_0
    //   109: astore_3
    //   110: aload_0
    //   111: astore 4
    //   113: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   116: invokevirtual 80	android/media/MediaPlayer:prepare	()V
    //   119: aload_0
    //   120: astore_3
    //   121: aload_0
    //   122: astore 4
    //   124: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   127: new 302	bhcr
    //   130: dup
    //   131: invokespecial 303	bhcr:<init>	()V
    //   134: invokevirtual 144	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   137: aload_0
    //   138: astore_3
    //   139: aload_0
    //   140: astore 4
    //   142: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   145: invokevirtual 147	android/media/MediaPlayer:start	()V
    //   148: aload_0
    //   149: astore_3
    //   150: aload_0
    //   151: astore 4
    //   153: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   156: iload_1
    //   157: invokevirtual 153	android/media/MediaPlayer:setLooping	(Z)V
    //   160: aload_0
    //   161: ifnull +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 304	java/io/FileInputStream:close	()V
    //   168: ldc 2
    //   170: monitorexit
    //   171: return
    //   172: astore 4
    //   174: aconst_null
    //   175: putstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   178: goto -153 -> 25
    //   181: astore_0
    //   182: aconst_null
    //   183: astore 4
    //   185: aload 4
    //   187: ifnull -19 -> 168
    //   190: aload 4
    //   192: invokevirtual 304	java/io/FileInputStream:close	()V
    //   195: goto -27 -> 168
    //   198: astore_0
    //   199: aload_0
    //   200: invokevirtual 307	java/io/IOException:printStackTrace	()V
    //   203: goto -35 -> 168
    //   206: astore_0
    //   207: ldc 2
    //   209: monitorexit
    //   210: aload_0
    //   211: athrow
    //   212: astore_0
    //   213: aconst_null
    //   214: putstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   217: aload_0
    //   218: athrow
    //   219: astore_0
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 304	java/io/FileInputStream:close	()V
    //   228: aload_0
    //   229: athrow
    //   230: getstatic 25	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   233: aload_0
    //   234: invokestatic 202	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   237: putstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   240: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   243: astore_0
    //   244: aload_0
    //   245: ifnonnull +23 -> 268
    //   248: iconst_0
    //   249: ifeq -81 -> 168
    //   252: new 309	java/lang/NullPointerException
    //   255: dup
    //   256: invokespecial 310	java/lang/NullPointerException:<init>	()V
    //   259: athrow
    //   260: astore_0
    //   261: aload_0
    //   262: invokevirtual 307	java/io/IOException:printStackTrace	()V
    //   265: goto -97 -> 168
    //   268: iload_2
    //   269: ifeq +25 -> 294
    //   272: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +13 -> 288
    //   278: ldc_w 279
    //   281: iconst_2
    //   282: ldc_w 281
    //   285: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   291: invokestatic 57	bhcl:a	(Landroid/media/MediaPlayer;)V
    //   294: aconst_null
    //   295: astore_0
    //   296: goto -177 -> 119
    //   299: astore_0
    //   300: aload_0
    //   301: invokevirtual 307	java/io/IOException:printStackTrace	()V
    //   304: goto -136 -> 168
    //   307: astore_3
    //   308: aload_3
    //   309: invokevirtual 307	java/io/IOException:printStackTrace	()V
    //   312: goto -84 -> 228
    //   315: astore_0
    //   316: goto -96 -> 220
    //   319: astore_0
    //   320: goto -135 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramUri	Uri
    //   0	323	1	paramBoolean1	boolean
    //   0	323	2	paramBoolean2	boolean
    //   1	224	3	localUri	Uri
    //   307	2	3	localIOException	IOException
    //   8	144	4	localObject1	Object
    //   172	1	4	localException	Exception
    //   183	8	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	21	172	java/lang/Exception
    //   5	10	181	java/lang/Exception
    //   21	25	181	java/lang/Exception
    //   25	48	181	java/lang/Exception
    //   52	68	181	java/lang/Exception
    //   68	74	181	java/lang/Exception
    //   74	93	181	java/lang/Exception
    //   174	178	181	java/lang/Exception
    //   213	219	181	java/lang/Exception
    //   230	244	181	java/lang/Exception
    //   272	288	181	java/lang/Exception
    //   288	294	181	java/lang/Exception
    //   190	195	198	java/io/IOException
    //   164	168	206	finally
    //   190	195	206	finally
    //   199	203	206	finally
    //   224	228	206	finally
    //   228	230	206	finally
    //   252	260	206	finally
    //   261	265	206	finally
    //   300	304	206	finally
    //   308	312	206	finally
    //   15	21	212	finally
    //   5	10	219	finally
    //   21	25	219	finally
    //   25	48	219	finally
    //   52	68	219	finally
    //   68	74	219	finally
    //   74	93	219	finally
    //   174	178	219	finally
    //   213	219	219	finally
    //   230	244	219	finally
    //   272	288	219	finally
    //   288	294	219	finally
    //   252	260	260	java/io/IOException
    //   164	168	299	java/io/IOException
    //   224	228	307	java/io/IOException
    //   98	108	315	finally
    //   113	119	315	finally
    //   124	137	315	finally
    //   142	148	315	finally
    //   153	160	315	finally
    //   98	108	319	java/lang/Exception
    //   113	119	319	java/lang/Exception
    //   124	137	319	java/lang/Exception
    //   142	148	319	java/lang/Exception
    //   153	160	319	java/lang/Exception
  }
  
  /* Error */
  public static void a(java.lang.String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload 5
    //   11: astore_3
    //   12: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   15: ifnull +60 -> 75
    //   18: aload 5
    //   20: astore_3
    //   21: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   24: invokevirtual 122	android/media/MediaPlayer:isPlaying	()Z
    //   27: istore_2
    //   28: iload_2
    //   29: ifeq +33 -> 62
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 309	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 310	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: ldc 2
    //   46: monitorexit
    //   47: return
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 307	java/io/IOException:printStackTrace	()V
    //   53: goto -9 -> 44
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    //   62: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   65: invokevirtual 97	android/media/MediaPlayer:release	()V
    //   68: aload 5
    //   70: astore_3
    //   71: aconst_null
    //   72: putstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   75: aload 5
    //   77: astore_3
    //   78: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   81: ifnonnull +16 -> 97
    //   84: aload 5
    //   86: astore_3
    //   87: new 53	android/media/MediaPlayer
    //   90: dup
    //   91: invokespecial 54	android/media/MediaPlayer:<init>	()V
    //   94: putstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   97: aload 5
    //   99: astore_3
    //   100: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   103: invokevirtual 314	android/media/MediaPlayer:reset	()V
    //   106: aload 5
    //   108: astore_3
    //   109: new 283	java/io/FileInputStream
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 315	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   117: astore_0
    //   118: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   121: aload_0
    //   122: invokevirtual 297	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   125: invokevirtual 300	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   128: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   131: invokestatic 57	bhcl:a	(Landroid/media/MediaPlayer;)V
    //   134: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   137: invokevirtual 80	android/media/MediaPlayer:prepare	()V
    //   140: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   143: new 317	bhcn
    //   146: dup
    //   147: invokespecial 318	bhcn:<init>	()V
    //   150: invokevirtual 144	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   153: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   156: invokevirtual 147	android/media/MediaPlayer:start	()V
    //   159: getstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   162: iload_1
    //   163: invokevirtual 153	android/media/MediaPlayer:setLooping	(Z)V
    //   166: aload_0
    //   167: ifnull -123 -> 44
    //   170: aload_0
    //   171: invokevirtual 304	java/io/FileInputStream:close	()V
    //   174: goto -130 -> 44
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 307	java/io/IOException:printStackTrace	()V
    //   182: goto -138 -> 44
    //   185: astore_3
    //   186: aload 5
    //   188: astore_3
    //   189: aconst_null
    //   190: putstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   193: goto -118 -> 75
    //   196: astore_3
    //   197: aload 4
    //   199: astore_0
    //   200: aload_3
    //   201: astore 4
    //   203: aload_0
    //   204: astore_3
    //   205: aload 4
    //   207: invokevirtual 319	java/lang/Exception:printStackTrace	()V
    //   210: aload_0
    //   211: astore_3
    //   212: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +16 -> 231
    //   218: aload_0
    //   219: astore_3
    //   220: ldc 106
    //   222: iconst_2
    //   223: ldc_w 321
    //   226: aload 4
    //   228: invokestatic 172	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_0
    //   232: ifnull -188 -> 44
    //   235: aload_0
    //   236: invokevirtual 304	java/io/FileInputStream:close	()V
    //   239: goto -195 -> 44
    //   242: astore_0
    //   243: aload_0
    //   244: invokevirtual 307	java/io/IOException:printStackTrace	()V
    //   247: goto -203 -> 44
    //   250: astore_0
    //   251: aload 5
    //   253: astore_3
    //   254: aconst_null
    //   255: putstatic 113	bhcl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   258: aload 5
    //   260: astore_3
    //   261: aload_0
    //   262: athrow
    //   263: astore_0
    //   264: aload_3
    //   265: ifnull +7 -> 272
    //   268: aload_3
    //   269: invokevirtual 304	java/io/FileInputStream:close	()V
    //   272: aload_0
    //   273: athrow
    //   274: astore_3
    //   275: aload_3
    //   276: invokevirtual 307	java/io/IOException:printStackTrace	()V
    //   279: goto -7 -> 272
    //   282: astore 4
    //   284: aload_0
    //   285: astore_3
    //   286: aload 4
    //   288: astore_0
    //   289: goto -25 -> 264
    //   292: astore 4
    //   294: goto -91 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramString	java.lang.String
    //   0	297	1	paramBoolean	boolean
    //   27	2	2	bool	boolean
    //   11	98	3	localObject1	Object
    //   185	1	3	localException1	Exception
    //   188	1	3	localObject2	Object
    //   196	5	3	localException2	Exception
    //   204	65	3	localObject3	Object
    //   274	2	3	localIOException	IOException
    //   285	1	3	str	java.lang.String
    //   4	223	4	localObject4	Object
    //   282	5	4	localObject5	Object
    //   292	1	4	localException3	Exception
    //   1	258	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	48	java/io/IOException
    //   36	44	56	finally
    //   49	53	56	finally
    //   170	174	56	finally
    //   178	182	56	finally
    //   235	239	56	finally
    //   243	247	56	finally
    //   268	272	56	finally
    //   272	274	56	finally
    //   275	279	56	finally
    //   170	174	177	java/io/IOException
    //   62	68	185	java/lang/Exception
    //   12	18	196	java/lang/Exception
    //   21	28	196	java/lang/Exception
    //   71	75	196	java/lang/Exception
    //   78	84	196	java/lang/Exception
    //   87	97	196	java/lang/Exception
    //   100	106	196	java/lang/Exception
    //   109	118	196	java/lang/Exception
    //   189	193	196	java/lang/Exception
    //   254	258	196	java/lang/Exception
    //   261	263	196	java/lang/Exception
    //   235	239	242	java/io/IOException
    //   62	68	250	finally
    //   12	18	263	finally
    //   21	28	263	finally
    //   71	75	263	finally
    //   78	84	263	finally
    //   87	97	263	finally
    //   100	106	263	finally
    //   109	118	263	finally
    //   189	193	263	finally
    //   205	210	263	finally
    //   212	218	263	finally
    //   220	231	263	finally
    //   254	258	263	finally
    //   261	263	263	finally
    //   268	272	274	java/io/IOException
    //   118	166	282	finally
    //   118	166	292	java/lang/Exception
  }
  
  @TargetApi(8)
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioUtil", 2, "context is null.");
      }
    }
    do
    {
      return false;
      if (VersionUtils.isrFroyo()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AudioUtil", 2, "Android 2.1 and below can not stop music");
    return false;
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramBoolean)
    {
      if (paramContext.requestAudioFocus(null, 3, 2) == 1) {}
      for (bool = true;; bool = false)
      {
        awvk.a().a(1, jdField_a_of_type_Awvo);
        if (QLog.isColorLevel()) {
          QLog.d("AudioUtil", 2, "pauseMusic bMute=" + paramBoolean + " result=" + bool);
        }
        return bool;
      }
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          int i = paramContext.abandonAudioFocus(null);
          if (i != 1) {
            break label178;
          }
          bool = true;
          try
          {
            ThreadManager.getSubThreadHandler().postDelayed(new AudioUtil.1(), 1000L);
          }
          catch (NullPointerException paramContext) {}
        }
      }
      catch (NullPointerException paramContext)
      {
        label178:
        bool = false;
        continue;
      }
      QLog.e("AudioUtil", 1, "caught npe", paramContext);
      break;
      bool = false;
    }
  }
  
  public static void b(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerStart", 2, "resourceId=" + paramInt + ",looping=" + paramBoolean);
        }
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        if (!jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("MediaPlayerStart", 2, "media palyer is playing");
        }
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MediaPlayerStart", 2, "media palyer exception", localException1);
        continue;
      }
      finally {}
      return;
      try
      {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label172;
        }
        QLog.e("MediaPlayerStart", 2, "media palyer release exception", localException2);
        label172:
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
        continue;
      }
      finally
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      if (paramInt != AppSetting.d)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.sApplication, paramInt);
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("MediaPlayerStart", 2, "media palyer is null");
        }
      }
      else
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.sApplication, Settings.System.DEFAULT_NOTIFICATION_URI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MediaPlayerStart", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new bhcp());
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhcl
 * JD-Core Version:    0.7.0.1
 */