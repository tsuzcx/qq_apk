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

public class bdfi
{
  private static int jdField_a_of_type_Int;
  public static MediaPlayer a;
  private static auca jdField_a_of_type_Auca = new bdfj();
  
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
    //   24: invokestatic 57	bdfi:a	(Landroid/media/MediaPlayer;)V
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
          jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new bdfn(paramOnCompletionListener, paramHandler));
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
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new bdfl());
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
    //   1: astore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +13 -> 24
    //   14: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   17: invokevirtual 97	android/media/MediaPlayer:release	()V
    //   20: aconst_null
    //   21: putstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   24: aload_0
    //   25: invokevirtual 249	android/net/Uri:getScheme	()Ljava/lang/String;
    //   28: ldc 251
    //   30: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +193 -> 226
    //   36: new 53	android/media/MediaPlayer
    //   39: dup
    //   40: invokespecial 54	android/media/MediaPlayer:<init>	()V
    //   43: putstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   46: iload_2
    //   47: ifeq +25 -> 72
    //   50: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +13 -> 66
    //   56: ldc_w 259
    //   59: iconst_2
    //   60: ldc_w 261
    //   63: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   69: invokestatic 57	bdfi:a	(Landroid/media/MediaPlayer;)V
    //   72: new 263	java/io/FileInputStream
    //   75: dup
    //   76: new 265	java/io/File
    //   79: dup
    //   80: aload_0
    //   81: invokevirtual 268	android/net/Uri:getPath	()Ljava/lang/String;
    //   84: invokespecial 271	java/io/File:<init>	(Ljava/lang/String;)V
    //   87: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   90: astore_0
    //   91: aload_0
    //   92: astore 4
    //   94: aload_0
    //   95: astore_3
    //   96: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   99: aload_0
    //   100: invokevirtual 277	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   103: invokevirtual 280	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   106: aload_0
    //   107: astore 4
    //   109: aload_0
    //   110: astore_3
    //   111: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   114: invokevirtual 80	android/media/MediaPlayer:prepare	()V
    //   117: aload_0
    //   118: astore 4
    //   120: aload_0
    //   121: astore_3
    //   122: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   125: new 282	bdfo
    //   128: dup
    //   129: invokespecial 283	bdfo:<init>	()V
    //   132: invokevirtual 133	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   135: aload_0
    //   136: astore 4
    //   138: aload_0
    //   139: astore_3
    //   140: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   143: invokevirtual 136	android/media/MediaPlayer:start	()V
    //   146: aload_0
    //   147: astore 4
    //   149: aload_0
    //   150: astore_3
    //   151: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   154: iload_1
    //   155: invokevirtual 140	android/media/MediaPlayer:setLooping	(Z)V
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 284	java/io/FileInputStream:close	()V
    //   166: ldc 2
    //   168: monitorexit
    //   169: return
    //   170: astore_3
    //   171: aconst_null
    //   172: putstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   175: goto -151 -> 24
    //   178: astore_0
    //   179: aconst_null
    //   180: astore_3
    //   181: aload_3
    //   182: ifnull -16 -> 166
    //   185: aload_3
    //   186: invokevirtual 284	java/io/FileInputStream:close	()V
    //   189: goto -23 -> 166
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   197: goto -31 -> 166
    //   200: astore_0
    //   201: ldc 2
    //   203: monitorexit
    //   204: aload_0
    //   205: athrow
    //   206: astore_0
    //   207: aconst_null
    //   208: putstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   211: aload_0
    //   212: athrow
    //   213: astore_0
    //   214: aload 4
    //   216: ifnull +8 -> 224
    //   219: aload 4
    //   221: invokevirtual 284	java/io/FileInputStream:close	()V
    //   224: aload_0
    //   225: athrow
    //   226: getstatic 25	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   229: aload_0
    //   230: invokestatic 164	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   233: putstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   236: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   239: astore_0
    //   240: aload_0
    //   241: ifnonnull +23 -> 264
    //   244: iconst_0
    //   245: ifeq -79 -> 166
    //   248: new 289	java/lang/NullPointerException
    //   251: dup
    //   252: invokespecial 290	java/lang/NullPointerException:<init>	()V
    //   255: athrow
    //   256: astore_0
    //   257: aload_0
    //   258: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   261: goto -95 -> 166
    //   264: iload_2
    //   265: ifeq +25 -> 290
    //   268: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +13 -> 284
    //   274: ldc_w 259
    //   277: iconst_2
    //   278: ldc_w 261
    //   281: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   287: invokestatic 57	bdfi:a	(Landroid/media/MediaPlayer;)V
    //   290: aconst_null
    //   291: astore_0
    //   292: goto -175 -> 117
    //   295: astore_0
    //   296: aload_0
    //   297: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   300: goto -134 -> 166
    //   303: astore_3
    //   304: aload_3
    //   305: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   308: goto -84 -> 224
    //   311: astore_0
    //   312: goto -98 -> 214
    //   315: astore_0
    //   316: goto -135 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	paramUri	Uri
    //   0	319	1	paramBoolean1	boolean
    //   0	319	2	paramBoolean2	boolean
    //   9	142	3	localObject1	Object
    //   170	1	3	localException	Exception
    //   180	6	3	localObject2	Object
    //   303	2	3	localIOException	IOException
    //   1	219	4	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   14	20	170	java/lang/Exception
    //   6	10	178	java/lang/Exception
    //   20	24	178	java/lang/Exception
    //   24	46	178	java/lang/Exception
    //   50	66	178	java/lang/Exception
    //   66	72	178	java/lang/Exception
    //   72	91	178	java/lang/Exception
    //   171	175	178	java/lang/Exception
    //   207	213	178	java/lang/Exception
    //   226	240	178	java/lang/Exception
    //   268	284	178	java/lang/Exception
    //   284	290	178	java/lang/Exception
    //   185	189	192	java/io/IOException
    //   162	166	200	finally
    //   185	189	200	finally
    //   193	197	200	finally
    //   219	224	200	finally
    //   224	226	200	finally
    //   248	256	200	finally
    //   257	261	200	finally
    //   296	300	200	finally
    //   304	308	200	finally
    //   14	20	206	finally
    //   6	10	213	finally
    //   20	24	213	finally
    //   24	46	213	finally
    //   50	66	213	finally
    //   66	72	213	finally
    //   72	91	213	finally
    //   171	175	213	finally
    //   207	213	213	finally
    //   226	240	213	finally
    //   268	284	213	finally
    //   284	290	213	finally
    //   248	256	256	java/io/IOException
    //   162	166	295	java/io/IOException
    //   219	224	303	java/io/IOException
    //   96	106	311	finally
    //   111	117	311	finally
    //   122	135	311	finally
    //   140	146	311	finally
    //   151	158	311	finally
    //   96	106	315	java/lang/Exception
    //   111	117	315	java/lang/Exception
    //   122	135	315	java/lang/Exception
    //   140	146	315	java/lang/Exception
    //   151	158	315	java/lang/Exception
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
    //   12: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   15: ifnull +60 -> 75
    //   18: aload 5
    //   20: astore_3
    //   21: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
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
    //   62: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   65: invokevirtual 97	android/media/MediaPlayer:release	()V
    //   68: aload 5
    //   70: astore_3
    //   71: aconst_null
    //   72: putstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   75: aload 5
    //   77: astore_3
    //   78: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   81: ifnonnull +16 -> 97
    //   84: aload 5
    //   86: astore_3
    //   87: new 53	android/media/MediaPlayer
    //   90: dup
    //   91: invokespecial 54	android/media/MediaPlayer:<init>	()V
    //   94: putstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   97: aload 5
    //   99: astore_3
    //   100: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   103: invokevirtual 294	android/media/MediaPlayer:reset	()V
    //   106: aload 5
    //   108: astore_3
    //   109: new 263	java/io/FileInputStream
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 295	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   117: astore_0
    //   118: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   121: aload_0
    //   122: invokevirtual 277	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   125: invokevirtual 280	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   128: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   131: invokestatic 57	bdfi:a	(Landroid/media/MediaPlayer;)V
    //   134: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   137: invokevirtual 80	android/media/MediaPlayer:prepare	()V
    //   140: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   143: new 297	bdfk
    //   146: dup
    //   147: invokespecial 298	bdfk:<init>	()V
    //   150: invokevirtual 133	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   153: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   156: invokevirtual 136	android/media/MediaPlayer:start	()V
    //   159: getstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
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
    //   190: putstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
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
    //   256: putstatic 106	bdfi:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
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
      if (bhtb.b()) {
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
        aubw.a().a(1, jdField_a_of_type_Auca);
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
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new bdfm());
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfi
 * JD-Core Version:    0.7.0.1
 */