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
import java.io.IOException;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class bdaz
{
  private static int jdField_a_of_type_Int;
  public static MediaPlayer a;
  private static atxr jdField_a_of_type_Atxr = new bdba();
  
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
    //   24: invokestatic 57	bdaz:a	(Landroid/media/MediaPlayer;)V
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
    try
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      label12:
      jdField_a_of_type_AndroidMediaMediaPlayer = null;
      return;
    }
    catch (Exception localException)
    {
      break label12;
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
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        boolean bool = jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
        if (!bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (paramOnCompletionListener == null) {
          continue;
        }
        if ((paramHandler != null) && (paramHandler.getLooper() != Looper.myLooper())) {
          break label154;
        }
        paramOnCompletionListener.onCompletion(jdField_a_of_type_AndroidMediaMediaPlayer);
        continue;
      }
      finally {}
      return;
      a();
      if (paramInt1 != AppSetting.d)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.sApplication, paramInt1);
        if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          jdField_a_of_type_Int = paramInt2;
          if (jdField_a_of_type_Int != 0) {
            jdField_a_of_type_Int -= 1;
          }
          jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new bdbe(paramOnCompletionListener, paramHandler));
          jdField_a_of_type_AndroidMediaMediaPlayer.start();
          jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
        }
      }
      else
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.sApplication, Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      continue;
      label154:
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
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new bdbc());
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
    //   5: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore 4
    //   10: aload 4
    //   12: ifnull +13 -> 25
    //   15: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   18: invokevirtual 97	android/media/MediaPlayer:release	()V
    //   21: aconst_null
    //   22: putstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   25: aload_0
    //   26: invokevirtual 249	android/net/Uri:getScheme	()Ljava/lang/String;
    //   29: ldc 251
    //   31: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +195 -> 229
    //   37: new 53	android/media/MediaPlayer
    //   40: dup
    //   41: invokespecial 54	android/media/MediaPlayer:<init>	()V
    //   44: putstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   47: iload_2
    //   48: ifeq +25 -> 73
    //   51: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +13 -> 67
    //   57: ldc_w 259
    //   60: iconst_2
    //   61: ldc_w 261
    //   64: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   70: invokestatic 57	bdaz:a	(Landroid/media/MediaPlayer;)V
    //   73: new 263	java/io/FileInputStream
    //   76: dup
    //   77: new 265	java/io/File
    //   80: dup
    //   81: aload_0
    //   82: invokevirtual 268	android/net/Uri:getPath	()Ljava/lang/String;
    //   85: invokespecial 271	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: astore_0
    //   92: aload_0
    //   93: astore_3
    //   94: aload_0
    //   95: astore 4
    //   97: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   100: aload_0
    //   101: invokevirtual 277	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   104: invokevirtual 280	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   107: aload_0
    //   108: astore_3
    //   109: aload_0
    //   110: astore 4
    //   112: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   115: invokevirtual 80	android/media/MediaPlayer:prepare	()V
    //   118: aload_0
    //   119: astore_3
    //   120: aload_0
    //   121: astore 4
    //   123: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   126: new 282	bdbf
    //   129: dup
    //   130: invokespecial 283	bdbf:<init>	()V
    //   133: invokevirtual 133	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   136: aload_0
    //   137: astore_3
    //   138: aload_0
    //   139: astore 4
    //   141: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   144: invokevirtual 136	android/media/MediaPlayer:start	()V
    //   147: aload_0
    //   148: astore_3
    //   149: aload_0
    //   150: astore 4
    //   152: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   155: iload_1
    //   156: invokevirtual 140	android/media/MediaPlayer:setLooping	(Z)V
    //   159: aload_0
    //   160: ifnull +7 -> 167
    //   163: aload_0
    //   164: invokevirtual 284	java/io/FileInputStream:close	()V
    //   167: ldc 2
    //   169: monitorexit
    //   170: return
    //   171: astore 4
    //   173: aconst_null
    //   174: putstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   177: goto -152 -> 25
    //   180: astore_0
    //   181: aconst_null
    //   182: astore 4
    //   184: aload 4
    //   186: ifnull -19 -> 167
    //   189: aload 4
    //   191: invokevirtual 284	java/io/FileInputStream:close	()V
    //   194: goto -27 -> 167
    //   197: astore_0
    //   198: aload_0
    //   199: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   202: goto -35 -> 167
    //   205: astore_0
    //   206: ldc 2
    //   208: monitorexit
    //   209: aload_0
    //   210: athrow
    //   211: astore_0
    //   212: aconst_null
    //   213: putstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   216: aload_0
    //   217: athrow
    //   218: astore_0
    //   219: aload_3
    //   220: ifnull +7 -> 227
    //   223: aload_3
    //   224: invokevirtual 284	java/io/FileInputStream:close	()V
    //   227: aload_0
    //   228: athrow
    //   229: getstatic 25	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   232: aload_0
    //   233: invokestatic 164	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   236: putstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   239: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   242: astore_0
    //   243: aload_0
    //   244: ifnonnull +23 -> 267
    //   247: iconst_0
    //   248: ifeq -81 -> 167
    //   251: new 289	java/lang/NullPointerException
    //   254: dup
    //   255: invokespecial 290	java/lang/NullPointerException:<init>	()V
    //   258: athrow
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   264: goto -97 -> 167
    //   267: iload_2
    //   268: ifeq +25 -> 293
    //   271: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +13 -> 287
    //   277: ldc_w 259
    //   280: iconst_2
    //   281: ldc_w 261
    //   284: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   290: invokestatic 57	bdaz:a	(Landroid/media/MediaPlayer;)V
    //   293: aconst_null
    //   294: astore_0
    //   295: goto -177 -> 118
    //   298: astore_0
    //   299: aload_0
    //   300: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   303: goto -136 -> 167
    //   306: astore_3
    //   307: aload_3
    //   308: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   311: goto -84 -> 227
    //   314: astore_0
    //   315: goto -96 -> 219
    //   318: astore_0
    //   319: goto -135 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	paramUri	Uri
    //   0	322	1	paramBoolean1	boolean
    //   0	322	2	paramBoolean2	boolean
    //   1	223	3	localUri	Uri
    //   306	2	3	localIOException	IOException
    //   8	143	4	localObject1	Object
    //   171	1	4	localException	Exception
    //   182	8	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	21	171	java/lang/Exception
    //   5	10	180	java/lang/Exception
    //   21	25	180	java/lang/Exception
    //   25	47	180	java/lang/Exception
    //   51	67	180	java/lang/Exception
    //   67	73	180	java/lang/Exception
    //   73	92	180	java/lang/Exception
    //   173	177	180	java/lang/Exception
    //   212	218	180	java/lang/Exception
    //   229	243	180	java/lang/Exception
    //   271	287	180	java/lang/Exception
    //   287	293	180	java/lang/Exception
    //   189	194	197	java/io/IOException
    //   163	167	205	finally
    //   189	194	205	finally
    //   198	202	205	finally
    //   223	227	205	finally
    //   227	229	205	finally
    //   251	259	205	finally
    //   260	264	205	finally
    //   299	303	205	finally
    //   307	311	205	finally
    //   15	21	211	finally
    //   5	10	218	finally
    //   21	25	218	finally
    //   25	47	218	finally
    //   51	67	218	finally
    //   67	73	218	finally
    //   73	92	218	finally
    //   173	177	218	finally
    //   212	218	218	finally
    //   229	243	218	finally
    //   271	287	218	finally
    //   287	293	218	finally
    //   251	259	259	java/io/IOException
    //   163	167	298	java/io/IOException
    //   223	227	306	java/io/IOException
    //   97	107	314	finally
    //   112	118	314	finally
    //   123	136	314	finally
    //   141	147	314	finally
    //   152	159	314	finally
    //   97	107	318	java/lang/Exception
    //   112	118	318	java/lang/Exception
    //   123	136	318	java/lang/Exception
    //   141	147	318	java/lang/Exception
    //   152	159	318	java/lang/Exception
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
    //   12: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   15: ifnull +60 -> 75
    //   18: aload 5
    //   20: astore_3
    //   21: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   24: invokevirtual 113	android/media/MediaPlayer:isPlaying	()Z
    //   27: istore_2
    //   28: iload_2
    //   29: ifeq +33 -> 62
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 289	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 290	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: ldc 2
    //   46: monitorexit
    //   47: return
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   53: goto -9 -> 44
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    //   62: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   65: invokevirtual 97	android/media/MediaPlayer:release	()V
    //   68: aload 5
    //   70: astore_3
    //   71: aconst_null
    //   72: putstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   75: aload 5
    //   77: astore_3
    //   78: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   81: ifnonnull +16 -> 97
    //   84: aload 5
    //   86: astore_3
    //   87: new 53	android/media/MediaPlayer
    //   90: dup
    //   91: invokespecial 54	android/media/MediaPlayer:<init>	()V
    //   94: putstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   97: aload 5
    //   99: astore_3
    //   100: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   103: invokevirtual 294	android/media/MediaPlayer:reset	()V
    //   106: aload 5
    //   108: astore_3
    //   109: new 263	java/io/FileInputStream
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 295	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   117: astore_0
    //   118: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   121: aload_0
    //   122: invokevirtual 277	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   125: invokevirtual 280	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   128: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   131: invokestatic 57	bdaz:a	(Landroid/media/MediaPlayer;)V
    //   134: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   137: invokevirtual 80	android/media/MediaPlayer:prepare	()V
    //   140: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   143: new 297	bdbb
    //   146: dup
    //   147: invokespecial 298	bdbb:<init>	()V
    //   150: invokevirtual 133	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   153: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   156: invokevirtual 136	android/media/MediaPlayer:start	()V
    //   159: getstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   162: iload_1
    //   163: invokevirtual 140	android/media/MediaPlayer:setLooping	(Z)V
    //   166: aload_0
    //   167: ifnull -123 -> 44
    //   170: aload_0
    //   171: invokevirtual 284	java/io/FileInputStream:close	()V
    //   174: goto -130 -> 44
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   182: goto -138 -> 44
    //   185: astore_3
    //   186: aload 5
    //   188: astore_3
    //   189: aconst_null
    //   190: putstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   193: goto -118 -> 75
    //   196: astore_3
    //   197: aload 4
    //   199: astore_0
    //   200: aload_3
    //   201: astore 4
    //   203: aload_0
    //   204: astore_3
    //   205: aload 4
    //   207: invokevirtual 299	java/lang/Exception:printStackTrace	()V
    //   210: aload_0
    //   211: astore_3
    //   212: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +17 -> 232
    //   218: aload_0
    //   219: astore_3
    //   220: ldc_w 301
    //   223: iconst_2
    //   224: ldc_w 303
    //   227: aload 4
    //   229: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   232: aload_0
    //   233: ifnull -189 -> 44
    //   236: aload_0
    //   237: invokevirtual 284	java/io/FileInputStream:close	()V
    //   240: goto -196 -> 44
    //   243: astore_0
    //   244: aload_0
    //   245: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   248: goto -204 -> 44
    //   251: astore_0
    //   252: aload 5
    //   254: astore_3
    //   255: aconst_null
    //   256: putstatic 106	bdaz:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   259: aload 5
    //   261: astore_3
    //   262: aload_0
    //   263: athrow
    //   264: astore_0
    //   265: aload_3
    //   266: ifnull +7 -> 273
    //   269: aload_3
    //   270: invokevirtual 284	java/io/FileInputStream:close	()V
    //   273: aload_0
    //   274: athrow
    //   275: astore_3
    //   276: aload_3
    //   277: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   280: goto -7 -> 273
    //   283: astore 4
    //   285: aload_0
    //   286: astore_3
    //   287: aload 4
    //   289: astore_0
    //   290: goto -25 -> 265
    //   293: astore 4
    //   295: goto -92 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramString	java.lang.String
    //   0	298	1	paramBoolean	boolean
    //   27	2	2	bool	boolean
    //   11	98	3	localObject1	Object
    //   185	1	3	localException1	Exception
    //   188	1	3	localObject2	Object
    //   196	5	3	localException2	Exception
    //   204	66	3	localObject3	Object
    //   275	2	3	localIOException	IOException
    //   286	1	3	str	java.lang.String
    //   4	224	4	localObject4	Object
    //   283	5	4	localObject5	Object
    //   293	1	4	localException3	Exception
    //   1	259	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	48	java/io/IOException
    //   36	44	56	finally
    //   49	53	56	finally
    //   170	174	56	finally
    //   178	182	56	finally
    //   236	240	56	finally
    //   244	248	56	finally
    //   269	273	56	finally
    //   273	275	56	finally
    //   276	280	56	finally
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
    //   255	259	196	java/lang/Exception
    //   262	264	196	java/lang/Exception
    //   236	240	243	java/io/IOException
    //   62	68	251	finally
    //   12	18	264	finally
    //   21	28	264	finally
    //   71	75	264	finally
    //   78	84	264	finally
    //   87	97	264	finally
    //   100	106	264	finally
    //   109	118	264	finally
    //   189	193	264	finally
    //   205	210	264	finally
    //   212	218	264	finally
    //   220	232	264	finally
    //   255	259	264	finally
    //   262	264	264	finally
    //   269	273	275	java/io/IOException
    //   118	166	283	finally
    //   118	166	293	java/lang/Exception
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
      if (bhou.b()) {
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
        atxn.a().a(1, jdField_a_of_type_Atxr);
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
            break label182;
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
        label182:
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
          break label167;
        }
        QLog.e("MediaPlayerStart", 2, "media palyer release exception", localException2);
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
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new bdbd());
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdaz
 * JD-Core Version:    0.7.0.1
 */