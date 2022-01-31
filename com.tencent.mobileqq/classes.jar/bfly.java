import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.AudioDeviceInterface;
import java.util.Timer;
import java.util.TimerTask;

public class bfly
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private bflz jdField_a_of_type_Bflz;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int d = -1;
  
  public bfly(Context paramContext, bflz parambflz)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bflz = parambflz;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Int == 2) || (this.d == -1)) {
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "TraeMediaPlay volumeUndo _prevVolume:" + this.d);
      }
      ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio")).setStreamVolume(this.jdField_b_of_type_Int, this.d, 0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("stopRing, mMediaPlay[");
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("TraeMediaPlay", 1, bool + "], seq[" + paramLong + "]");
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
        this.jdField_a_of_type_JavaUtilTimerTask = null;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    catch (Exception localException)
    {
      label126:
      break label126;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    this.jdField_c_of_type_Int = -1;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  /* Error */
  public boolean a(long paramLong, int paramInt1, int paramInt2, android.net.Uri paramUri, java.lang.String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +133 -> 136
    //   6: ldc 93
    //   8: iconst_1
    //   9: new 55	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   16: ldc 136
    //   18: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_3
    //   22: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: ldc 138
    //   27: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload 4
    //   32: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: ldc 140
    //   37: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 5
    //   42: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   45: ldc 145
    //   47: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload 6
    //   52: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 147
    //   57: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload 7
    //   62: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: ldc 149
    //   67: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload 8
    //   72: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: ldc 151
    //   77: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: iload 9
    //   82: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: ldc 153
    //   87: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload 10
    //   92: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   95: ldc 155
    //   97: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 11
    //   102: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc 157
    //   107: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: getstatic 162	com/tencent/common/config/AppSetting:c	Ljava/lang/String;
    //   113: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 98
    //   118: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: lload_1
    //   122: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   125: ldc 103
    //   127: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: iload 7
    //   138: ifne +10 -> 148
    //   141: iload 8
    //   143: ifgt +5 -> 148
    //   146: iconst_0
    //   147: ireturn
    //   148: aload_0
    //   149: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   152: ifnull +31 -> 183
    //   155: aload_0
    //   156: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   159: invokevirtual 111	android/media/MediaPlayer:isPlaying	()Z
    //   162: istore 12
    //   164: iload 12
    //   166: ifeq +5 -> 171
    //   169: iconst_0
    //   170: ireturn
    //   171: aload_0
    //   172: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   175: invokevirtual 129	android/media/MediaPlayer:release	()V
    //   178: aload_0
    //   179: aconst_null
    //   180: putfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   183: aload_0
    //   184: getfield 119	bfly:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   187: ifnull +20 -> 207
    //   190: aload_0
    //   191: getfield 119	bfly:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   194: invokevirtual 124	java/util/Timer:cancel	()V
    //   197: aload_0
    //   198: aconst_null
    //   199: putfield 119	bfly:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   202: aload_0
    //   203: aconst_null
    //   204: putfield 126	bfly:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   207: aload_0
    //   208: getfield 36	bfly:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   211: ldc 75
    //   213: invokevirtual 81	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   216: checkcast 83	android/media/AudioManager
    //   219: astore 14
    //   221: aload_0
    //   222: new 108	android/media/MediaPlayer
    //   225: dup
    //   226: invokespecial 163	android/media/MediaPlayer:<init>	()V
    //   229: putfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   232: aload_0
    //   233: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   236: ifnonnull +85 -> 321
    //   239: aload_0
    //   240: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   243: invokevirtual 129	android/media/MediaPlayer:release	()V
    //   246: aload_0
    //   247: aconst_null
    //   248: putfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   251: iconst_0
    //   252: ireturn
    //   253: astore 13
    //   255: aload_0
    //   256: aconst_null
    //   257: putfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   260: goto -77 -> 183
    //   263: astore 5
    //   265: ldc 93
    //   267: iconst_1
    //   268: new 55	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   275: ldc 165
    //   277: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: lload_1
    //   281: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   284: ldc 103
    //   286: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: aload 5
    //   294: invokestatic 168	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   297: aload_0
    //   298: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   301: invokevirtual 129	android/media/MediaPlayer:release	()V
    //   304: aload_0
    //   305: aconst_null
    //   306: putfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   309: iconst_0
    //   310: ireturn
    //   311: astore 5
    //   313: aload_0
    //   314: aconst_null
    //   315: putfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   318: aload 5
    //   320: athrow
    //   321: aload_0
    //   322: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   325: aload_0
    //   326: invokevirtual 172	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   329: aload_0
    //   330: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   333: aload_0
    //   334: invokevirtual 176	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   337: iload_3
    //   338: tableswitch	default:+903 -> 1241, 0:+51->389, 1:+516->854, 2:+532->870
    //   365: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   368: invokevirtual 129	android/media/MediaPlayer:release	()V
    //   371: aload_0
    //   372: aconst_null
    //   373: putfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   376: aload_0
    //   377: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   380: astore 5
    //   382: aload 5
    //   384: ifnonnull +498 -> 882
    //   387: iconst_0
    //   388: ireturn
    //   389: aconst_null
    //   390: astore 5
    //   392: aconst_null
    //   393: astore 13
    //   395: aload_0
    //   396: getfield 36	bfly:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   399: invokevirtual 180	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   402: iload 4
    //   404: invokevirtual 186	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   407: astore 6
    //   409: aload_0
    //   410: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   413: aload 6
    //   415: invokevirtual 192	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   418: aload 6
    //   420: invokevirtual 196	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   423: aload 6
    //   425: invokevirtual 199	android/content/res/AssetFileDescriptor:getLength	()J
    //   428: invokevirtual 203	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   431: aload 6
    //   433: ifnull +11 -> 444
    //   436: aload 6
    //   438: invokevirtual 206	android/content/res/AssetFileDescriptor:close	()V
    //   441: goto -65 -> 376
    //   444: ldc 93
    //   446: iconst_1
    //   447: new 55	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   454: ldc 208
    //   456: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: iload 4
    //   461: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   464: ldc 98
    //   466: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: lload_1
    //   470: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   473: ldc 103
    //   475: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   484: aload_0
    //   485: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   488: invokevirtual 129	android/media/MediaPlayer:release	()V
    //   491: aload_0
    //   492: aconst_null
    //   493: putfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   496: aload_0
    //   497: getfield 38	bfly:jdField_a_of_type_Bflz	Lbflz;
    //   500: ifnull +744 -> 1244
    //   503: invokestatic 212	com/tencent/mobileqq/utils/AudioHelper:d	()Z
    //   506: ifeq +38 -> 544
    //   509: invokestatic 218	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   512: invokevirtual 222	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   515: checkcast 224	com/tencent/common/app/AppInterface
    //   518: aload_0
    //   519: invokevirtual 228	java/lang/Object:getClass	()Ljava/lang/Class;
    //   522: invokevirtual 232	com/tencent/common/app/AppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   525: new 234	com/tencent/sharp/jni/TraeMediaPlayer$1
    //   528: dup
    //   529: aload_0
    //   530: lload_1
    //   531: invokespecial 237	com/tencent/sharp/jni/TraeMediaPlayer$1:<init>	(Lbfly;J)V
    //   534: ldc2_w 238
    //   537: invokevirtual 245	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   540: pop
    //   541: goto +703 -> 1244
    //   544: aload_0
    //   545: getfield 38	bfly:jdField_a_of_type_Bflz	Lbflz;
    //   548: lload_1
    //   549: invokeinterface 249 3 0
    //   554: goto +690 -> 1244
    //   557: astore 5
    //   559: aload 13
    //   561: astore 6
    //   563: aload 5
    //   565: astore 13
    //   567: aload 6
    //   569: astore 5
    //   571: ldc 93
    //   573: iconst_1
    //   574: new 55	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   581: ldc 251
    //   583: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload 13
    //   588: invokevirtual 254	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   591: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: aload 13
    //   599: invokestatic 257	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   602: aload 6
    //   604: ifnull +11 -> 615
    //   607: aload 6
    //   609: invokevirtual 206	android/content/res/AssetFileDescriptor:close	()V
    //   612: goto -236 -> 376
    //   615: ldc 93
    //   617: iconst_1
    //   618: new 55	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   625: ldc 208
    //   627: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: iload 4
    //   632: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   635: ldc 98
    //   637: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: lload_1
    //   641: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   644: ldc 103
    //   646: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   655: aload_0
    //   656: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   659: invokevirtual 129	android/media/MediaPlayer:release	()V
    //   662: aload_0
    //   663: aconst_null
    //   664: putfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   667: aload_0
    //   668: getfield 38	bfly:jdField_a_of_type_Bflz	Lbflz;
    //   671: ifnull +575 -> 1246
    //   674: invokestatic 212	com/tencent/mobileqq/utils/AudioHelper:d	()Z
    //   677: ifeq +38 -> 715
    //   680: invokestatic 218	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   683: invokevirtual 222	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   686: checkcast 224	com/tencent/common/app/AppInterface
    //   689: aload_0
    //   690: invokevirtual 228	java/lang/Object:getClass	()Ljava/lang/Class;
    //   693: invokevirtual 232	com/tencent/common/app/AppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   696: new 234	com/tencent/sharp/jni/TraeMediaPlayer$1
    //   699: dup
    //   700: aload_0
    //   701: lload_1
    //   702: invokespecial 237	com/tencent/sharp/jni/TraeMediaPlayer$1:<init>	(Lbfly;J)V
    //   705: ldc2_w 238
    //   708: invokevirtual 245	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   711: pop
    //   712: goto +534 -> 1246
    //   715: aload_0
    //   716: getfield 38	bfly:jdField_a_of_type_Bflz	Lbflz;
    //   719: lload_1
    //   720: invokeinterface 249 3 0
    //   725: goto +521 -> 1246
    //   728: aload 5
    //   730: ifnull +11 -> 741
    //   733: aload 5
    //   735: invokevirtual 206	android/content/res/AssetFileDescriptor:close	()V
    //   738: aload 6
    //   740: athrow
    //   741: ldc 93
    //   743: iconst_1
    //   744: new 55	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   751: ldc 208
    //   753: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: iload 4
    //   758: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   761: ldc 98
    //   763: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: lload_1
    //   767: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   770: ldc 103
    //   772: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   781: aload_0
    //   782: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   785: invokevirtual 129	android/media/MediaPlayer:release	()V
    //   788: aload_0
    //   789: aconst_null
    //   790: putfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   793: aload_0
    //   794: getfield 38	bfly:jdField_a_of_type_Bflz	Lbflz;
    //   797: ifnull +456 -> 1253
    //   800: invokestatic 212	com/tencent/mobileqq/utils/AudioHelper:d	()Z
    //   803: ifeq +38 -> 841
    //   806: invokestatic 218	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   809: invokevirtual 222	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   812: checkcast 224	com/tencent/common/app/AppInterface
    //   815: aload_0
    //   816: invokevirtual 228	java/lang/Object:getClass	()Ljava/lang/Class;
    //   819: invokevirtual 232	com/tencent/common/app/AppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   822: new 234	com/tencent/sharp/jni/TraeMediaPlayer$1
    //   825: dup
    //   826: aload_0
    //   827: lload_1
    //   828: invokespecial 237	com/tencent/sharp/jni/TraeMediaPlayer$1:<init>	(Lbfly;J)V
    //   831: ldc2_w 238
    //   834: invokevirtual 245	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   837: pop
    //   838: goto +415 -> 1253
    //   841: aload_0
    //   842: getfield 38	bfly:jdField_a_of_type_Bflz	Lbflz;
    //   845: lload_1
    //   846: invokeinterface 249 3 0
    //   851: goto +402 -> 1253
    //   854: aload_0
    //   855: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   858: aload_0
    //   859: getfield 36	bfly:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   862: aload 5
    //   864: invokevirtual 260	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   867: goto -491 -> 376
    //   870: aload_0
    //   871: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   874: aload 6
    //   876: invokevirtual 263	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   879: goto -503 -> 376
    //   882: aload_0
    //   883: iload 9
    //   885: putfield 32	bfly:jdField_a_of_type_Boolean	Z
    //   888: iconst_0
    //   889: istore_3
    //   890: aload_0
    //   891: getfield 32	bfly:jdField_a_of_type_Boolean	Z
    //   894: ifeq +242 -> 1136
    //   897: aload_0
    //   898: iconst_2
    //   899: putfield 26	bfly:jdField_b_of_type_Int	I
    //   902: iconst_1
    //   903: istore_3
    //   904: aload_0
    //   905: iload 10
    //   907: putfield 131	bfly:jdField_b_of_type_Boolean	Z
    //   910: aload_0
    //   911: getfield 131	bfly:jdField_b_of_type_Boolean	Z
    //   914: ifeq +9 -> 923
    //   917: aload_0
    //   918: iload 11
    //   920: putfield 26	bfly:jdField_b_of_type_Int	I
    //   923: aload_0
    //   924: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   927: aload_0
    //   928: getfield 26	bfly:jdField_b_of_type_Int	I
    //   931: invokevirtual 267	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   934: aload_0
    //   935: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   938: invokevirtual 270	android/media/MediaPlayer:prepare	()V
    //   941: aload_0
    //   942: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   945: iload 7
    //   947: invokevirtual 274	android/media/MediaPlayer:setLooping	(Z)V
    //   950: aload_0
    //   951: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   954: invokevirtual 277	android/media/MediaPlayer:start	()V
    //   957: aload_0
    //   958: iload 7
    //   960: putfield 279	bfly:jdField_c_of_type_Boolean	Z
    //   963: aload_0
    //   964: getfield 279	bfly:jdField_c_of_type_Boolean	Z
    //   967: iconst_1
    //   968: if_icmpne +225 -> 1193
    //   971: aload_0
    //   972: iconst_1
    //   973: putfield 30	bfly:jdField_a_of_type_Int	I
    //   976: aload_0
    //   977: iconst_m1
    //   978: putfield 28	bfly:jdField_c_of_type_Int	I
    //   981: aload_0
    //   982: aload_0
    //   983: getfield 30	bfly:jdField_a_of_type_Int	I
    //   986: iconst_1
    //   987: isub
    //   988: putfield 30	bfly:jdField_a_of_type_Int	I
    //   991: aload_0
    //   992: getfield 131	bfly:jdField_b_of_type_Boolean	Z
    //   995: ifne +9 -> 1004
    //   998: aload 14
    //   1000: iload_3
    //   1001: invokevirtual 282	android/media/AudioManager:setMode	(I)V
    //   1004: aload_0
    //   1005: getfield 28	bfly:jdField_c_of_type_Int	I
    //   1008: ifle +47 -> 1055
    //   1011: aload_0
    //   1012: new 121	java/util/Timer
    //   1015: dup
    //   1016: invokespecial 283	java/util/Timer:<init>	()V
    //   1019: putfield 119	bfly:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   1022: aload_0
    //   1023: new 285	com/tencent/sharp/jni/TraeMediaPlayer$2
    //   1026: dup
    //   1027: aload_0
    //   1028: lload_1
    //   1029: invokespecial 286	com/tencent/sharp/jni/TraeMediaPlayer$2:<init>	(Lbfly;J)V
    //   1032: putfield 126	bfly:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   1035: aload_0
    //   1036: getfield 119	bfly:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   1039: aload_0
    //   1040: getfield 126	bfly:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   1043: aload_0
    //   1044: getfield 28	bfly:jdField_c_of_type_Int	I
    //   1047: sipush 1000
    //   1050: iadd
    //   1051: i2l
    //   1052: invokevirtual 290	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   1055: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1058: ifeq +197 -> 1255
    //   1061: ldc 93
    //   1063: iconst_1
    //   1064: new 55	java/lang/StringBuilder
    //   1067: dup
    //   1068: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   1071: ldc_w 292
    //   1074: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: aload_0
    //   1078: getfield 30	bfly:jdField_a_of_type_Int	I
    //   1081: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1084: ldc_w 294
    //   1087: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: aload_0
    //   1091: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   1094: invokevirtual 297	android/media/MediaPlayer:getDuration	()I
    //   1097: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1100: ldc_w 299
    //   1103: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: aload_0
    //   1107: getfield 28	bfly:jdField_c_of_type_Int	I
    //   1110: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1113: ldc 98
    //   1115: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: lload_1
    //   1119: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1122: ldc 103
    //   1124: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1130: invokestatic 106	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1133: goto +122 -> 1255
    //   1136: getstatic 304	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1139: ldc_w 306
    //   1142: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1145: ifeq +30 -> 1175
    //   1148: getstatic 315	android/os/Build:MODEL	Ljava/lang/String;
    //   1151: ldc_w 317
    //   1154: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1157: ifeq +18 -> 1175
    //   1160: iload 10
    //   1162: ifne +13 -> 1175
    //   1165: aload_0
    //   1166: iconst_2
    //   1167: putfield 26	bfly:jdField_b_of_type_Int	I
    //   1170: iconst_2
    //   1171: istore_3
    //   1172: goto -268 -> 904
    //   1175: aload_0
    //   1176: iconst_0
    //   1177: putfield 26	bfly:jdField_b_of_type_Int	I
    //   1180: getstatic 322	android/os/Build$VERSION:SDK_INT	I
    //   1183: bipush 11
    //   1185: if_icmplt -281 -> 904
    //   1188: iconst_3
    //   1189: istore_3
    //   1190: goto -286 -> 904
    //   1193: aload_0
    //   1194: iload 8
    //   1196: putfield 30	bfly:jdField_a_of_type_Int	I
    //   1199: aload_0
    //   1200: aload_0
    //   1201: getfield 30	bfly:jdField_a_of_type_Int	I
    //   1204: aload_0
    //   1205: getfield 42	bfly:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   1208: invokevirtual 297	android/media/MediaPlayer:getDuration	()I
    //   1211: imul
    //   1212: putfield 28	bfly:jdField_c_of_type_Int	I
    //   1215: goto -234 -> 981
    //   1218: astore 5
    //   1220: goto -916 -> 304
    //   1223: astore 13
    //   1225: aload 6
    //   1227: astore 5
    //   1229: aload 13
    //   1231: astore 6
    //   1233: goto -505 -> 728
    //   1236: astore 13
    //   1238: goto -671 -> 567
    //   1241: goto -877 -> 364
    //   1244: iconst_0
    //   1245: ireturn
    //   1246: iconst_0
    //   1247: ireturn
    //   1248: astore 6
    //   1250: goto -522 -> 728
    //   1253: iconst_0
    //   1254: ireturn
    //   1255: iconst_1
    //   1256: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1257	0	this	bfly
    //   0	1257	1	paramLong	long
    //   0	1257	3	paramInt1	int
    //   0	1257	4	paramInt2	int
    //   0	1257	5	paramUri	android.net.Uri
    //   0	1257	6	paramString	java.lang.String
    //   0	1257	7	paramBoolean1	boolean
    //   0	1257	8	paramInt3	int
    //   0	1257	9	paramBoolean2	boolean
    //   0	1257	10	paramBoolean3	boolean
    //   0	1257	11	paramInt4	int
    //   162	3	12	bool	boolean
    //   253	1	13	localException	Exception
    //   393	205	13	localUri	android.net.Uri
    //   1223	7	13	localObject	Object
    //   1236	1	13	localThrowable	java.lang.Throwable
    //   219	780	14	localAudioManager	AudioManager
    // Exception table:
    //   from	to	target	type
    //   171	178	253	java/lang/Exception
    //   148	164	263	java/lang/Exception
    //   178	183	263	java/lang/Exception
    //   183	207	263	java/lang/Exception
    //   207	251	263	java/lang/Exception
    //   255	260	263	java/lang/Exception
    //   313	321	263	java/lang/Exception
    //   321	337	263	java/lang/Exception
    //   364	376	263	java/lang/Exception
    //   376	382	263	java/lang/Exception
    //   436	441	263	java/lang/Exception
    //   444	541	263	java/lang/Exception
    //   544	554	263	java/lang/Exception
    //   607	612	263	java/lang/Exception
    //   615	712	263	java/lang/Exception
    //   715	725	263	java/lang/Exception
    //   733	741	263	java/lang/Exception
    //   741	838	263	java/lang/Exception
    //   841	851	263	java/lang/Exception
    //   854	867	263	java/lang/Exception
    //   870	879	263	java/lang/Exception
    //   882	888	263	java/lang/Exception
    //   890	902	263	java/lang/Exception
    //   904	923	263	java/lang/Exception
    //   923	981	263	java/lang/Exception
    //   981	1004	263	java/lang/Exception
    //   1004	1055	263	java/lang/Exception
    //   1055	1133	263	java/lang/Exception
    //   1136	1160	263	java/lang/Exception
    //   1165	1170	263	java/lang/Exception
    //   1175	1180	263	java/lang/Exception
    //   1180	1188	263	java/lang/Exception
    //   1193	1215	263	java/lang/Exception
    //   171	178	311	finally
    //   395	409	557	java/lang/Throwable
    //   297	304	1218	java/lang/Exception
    //   409	431	1223	finally
    //   409	431	1236	java/lang/Throwable
    //   395	409	1248	finally
    //   571	602	1248	finally
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.jdField_a_of_type_Bflz + " loopCount:" + this.jdField_a_of_type_Int + " _loop:" + this.jdField_c_of_type_Boolean);
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, "loop play,continue...");
      }
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Int > 0) {
          continue;
        }
        a();
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        if (this.jdField_a_of_type_Bflz != null) {
          this.jdField_a_of_type_Bflz.a(-1024L);
        }
        AudioDeviceInterface.LogTraceExit();
      }
      catch (Exception paramMediaPlayer)
      {
        continue;
      }
      return;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.jdField_a_of_type_Int -= 1;
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.jdField_a_of_type_Bflz + " arg1:" + paramInt1 + " arg2:" + paramInt2);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      label53:
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      if (this.jdField_a_of_type_Bflz != null) {
        this.jdField_a_of_type_Bflz.a(-1029L);
      }
      AudioDeviceInterface.LogTraceExit();
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfly
 * JD-Core Version:    0.7.0.1
 */