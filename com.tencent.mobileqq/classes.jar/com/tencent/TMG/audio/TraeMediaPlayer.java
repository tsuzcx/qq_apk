package com.tencent.TMG.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.TMG.utils.QLog;
import java.util.Timer;
import java.util.TimerTask;

public class TraeMediaPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  public static final int TRAE_MEDIAPLAER_DATASOURCE_FILEPATH = 2;
  public static final int TRAE_MEDIAPLAER_DATASOURCE_RSID = 0;
  public static final int TRAE_MEDIAPLAER_DATASOURCE_URI = 1;
  public static final int TRAE_MEDIAPLAER_STOP = 100;
  private Context _context;
  private int _durationMS = -1;
  private boolean _hasCall = false;
  private boolean _loop = false;
  int _loopCount = 0;
  private int _prevVolume = -1;
  boolean _ringMode = false;
  private int _streamType = 0;
  private Timer _watchTimer = null;
  private TimerTask _watchTimertask = null;
  private TraeMediaPlayer.OnCompletionListener mCallback;
  private MediaPlayer mMediaPlay = null;
  
  public TraeMediaPlayer(Context paramContext, TraeMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this._context = paramContext;
    this.mCallback = paramOnCompletionListener;
  }
  
  private void volumeDo()
  {
    if ((this.mMediaPlay == null) || (!this._ringMode) || (this._streamType == 2)) {
      return;
    }
    for (;;)
    {
      int i;
      int n;
      try
      {
        localAudioManager = (AudioManager)this._context.getSystemService("audio");
        j = localAudioManager.getStreamVolume(this._streamType);
        i = localAudioManager.getStreamMaxVolume(this._streamType);
        int k = localAudioManager.getStreamVolume(2);
        int m = localAudioManager.getStreamMaxVolume(2);
        n = (int)(k * 1.0D / m * i);
        if (!QLog.isColorLevel()) {
          break label186;
        }
        QLog.e("TRAE", 0, "TraeMediaPlay volumeDo currV:" + j + " maxV:" + i + " currRV:" + k + " maxRV:" + m + " setV:" + n);
      }
      catch (Exception localException)
      {
        AudioManager localAudioManager;
        int j;
        return;
      }
      localAudioManager.setStreamVolume(this._streamType, i, 0);
      this._prevVolume = j;
      return;
      label186:
      while (n + 1 < i)
      {
        i = n + 1;
        break;
      }
    }
  }
  
  private void volumeUndo()
  {
    if ((this.mMediaPlay == null) || (!this._ringMode) || (this._streamType == 2) || (this._prevVolume == -1)) {
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "TraeMediaPlay volumeUndo _prevVolume:" + this._prevVolume);
      }
      ((AudioManager)this._context.getSystemService("audio")).setStreamVolume(this._streamType, this._prevVolume, 0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public int getDuration()
  {
    return this._durationMS;
  }
  
  public int getStreamType()
  {
    return this._streamType;
  }
  
  public boolean hasCall()
  {
    return this._hasCall;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " loopCount:" + this._loopCount + " _loop:" + this._loop);
    if (this._loop)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 0, "loop play,continue...");
      }
      return;
    }
    for (;;)
    {
      try
      {
        if (this._loopCount > 0) {
          continue;
        }
        volumeUndo();
        if (this.mMediaPlay.isPlaying()) {
          this.mMediaPlay.stop();
        }
        this.mMediaPlay.reset();
        this.mMediaPlay.release();
        this.mMediaPlay = null;
        if (this.mCallback != null) {
          this.mCallback.onCompletion();
        }
        AudioDeviceInterface.LogTraceExit();
      }
      catch (Exception paramMediaPlayer)
      {
        continue;
      }
      return;
      this.mMediaPlay.start();
      this._loopCount -= 1;
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " arg1:" + paramInt1 + " arg2:" + paramInt2);
    try
    {
      this.mMediaPlay.release();
      label50:
      this.mMediaPlay = null;
      if (this.mCallback != null) {
        this.mCallback.onCompletion();
      }
      AudioDeviceInterface.LogTraceExit();
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      break label50;
    }
  }
  
  /* Error */
  public boolean playRing(int paramInt1, int paramInt2, android.net.Uri paramUri, java.lang.String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    // Byte code:
    //   0: invokestatic 95	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   3: ifeq +132 -> 135
    //   6: new 99	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   13: ldc 205
    //   15: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload_1
    //   19: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc 207
    //   24: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_2
    //   28: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc 209
    //   33: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_3
    //   37: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: ldc 211
    //   42: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload 4
    //   47: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 213
    //   52: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: astore 12
    //   57: iload 5
    //   59: ifeq +150 -> 209
    //   62: ldc 215
    //   64: astore 11
    //   66: aload 12
    //   68: aload 11
    //   70: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 217
    //   75: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload 6
    //   80: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: ldc 219
    //   85: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: astore 12
    //   90: iload 7
    //   92: ifeq +124 -> 216
    //   95: ldc 215
    //   97: astore 11
    //   99: ldc 97
    //   101: iconst_0
    //   102: aload 12
    //   104: aload 11
    //   106: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 221
    //   111: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: iload 8
    //   116: invokevirtual 150	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   119: ldc 223
    //   121: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: iload 9
    //   126: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 125	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: iload 5
    //   137: ifne +92 -> 229
    //   140: iload 6
    //   142: ifgt +87 -> 229
    //   145: invokestatic 95	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   148: ifeq +59 -> 207
    //   151: new 99	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   158: ldc 225
    //   160: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload_1
    //   164: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc 213
    //   169: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: astore 4
    //   174: iload 5
    //   176: ifeq +47 -> 223
    //   179: ldc 215
    //   181: astore_3
    //   182: ldc 97
    //   184: iconst_0
    //   185: aload 4
    //   187: aload_3
    //   188: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc 217
    //   193: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload 6
    //   198: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 125	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: iconst_0
    //   208: ireturn
    //   209: ldc 227
    //   211: astore 11
    //   213: goto -147 -> 66
    //   216: ldc 227
    //   218: astore 11
    //   220: goto -121 -> 99
    //   223: ldc 227
    //   225: astore_3
    //   226: goto -44 -> 182
    //   229: aload_0
    //   230: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   233: ifnull +31 -> 264
    //   236: aload_0
    //   237: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   240: invokevirtual 168	android/media/MediaPlayer:isPlaying	()Z
    //   243: istore 10
    //   245: iload 10
    //   247: ifeq +5 -> 252
    //   250: iconst_0
    //   251: ireturn
    //   252: aload_0
    //   253: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   256: invokevirtual 177	android/media/MediaPlayer:release	()V
    //   259: aload_0
    //   260: aconst_null
    //   261: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   264: aload_0
    //   265: getfield 56	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   268: ifnull +20 -> 288
    //   271: aload_0
    //   272: getfield 56	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   275: invokevirtual 232	java/util/Timer:cancel	()V
    //   278: aload_0
    //   279: aconst_null
    //   280: putfield 56	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   283: aload_0
    //   284: aconst_null
    //   285: putfield 58	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   288: aload_0
    //   289: getfield 62	com/tencent/TMG/audio/TraeMediaPlayer:_context	Landroid/content/Context;
    //   292: ldc 74
    //   294: invokevirtual 80	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   297: checkcast 82	android/media/AudioManager
    //   300: astore 11
    //   302: aload_0
    //   303: new 165	android/media/MediaPlayer
    //   306: dup
    //   307: invokespecial 233	android/media/MediaPlayer:<init>	()V
    //   310: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   313: aload_0
    //   314: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   317: ifnonnull +196 -> 513
    //   320: aload_0
    //   321: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   324: invokevirtual 177	android/media/MediaPlayer:release	()V
    //   327: aload_0
    //   328: aconst_null
    //   329: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   332: iconst_0
    //   333: ireturn
    //   334: astore 11
    //   336: aload_0
    //   337: aconst_null
    //   338: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   341: goto -77 -> 264
    //   344: astore_3
    //   345: invokestatic 95	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   348: ifeq +43 -> 391
    //   351: ldc 97
    //   353: iconst_0
    //   354: new 99	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   361: ldc 235
    //   363: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_3
    //   367: invokevirtual 238	java/lang/IllegalStateException:getLocalizedMessage	()Ljava/lang/String;
    //   370: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc 240
    //   375: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_3
    //   379: invokevirtual 243	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   382: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: aload_0
    //   392: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   395: invokevirtual 177	android/media/MediaPlayer:release	()V
    //   398: aload_0
    //   399: aconst_null
    //   400: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   403: iconst_0
    //   404: ireturn
    //   405: astore_3
    //   406: aload_0
    //   407: aconst_null
    //   408: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   411: aload_3
    //   412: athrow
    //   413: astore_3
    //   414: invokestatic 95	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   417: ifeq -26 -> 391
    //   420: ldc 97
    //   422: iconst_0
    //   423: new 99	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   430: ldc 245
    //   432: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_3
    //   436: invokevirtual 246	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   439: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc 240
    //   444: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload_3
    //   448: invokevirtual 247	java/io/IOException:getMessage	()Ljava/lang/String;
    //   451: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: goto -69 -> 391
    //   463: astore_3
    //   464: invokestatic 95	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   467: ifeq -76 -> 391
    //   470: ldc 97
    //   472: iconst_0
    //   473: new 99	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   480: ldc 249
    //   482: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload_3
    //   486: invokevirtual 250	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   489: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: ldc 240
    //   494: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload_3
    //   498: invokevirtual 251	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   501: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   510: goto -119 -> 391
    //   513: aload_0
    //   514: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   517: aload_0
    //   518: invokevirtual 255	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   521: aload_0
    //   522: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   525: aload_0
    //   526: invokevirtual 259	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   529: iload_1
    //   530: tableswitch	default:+663 -> 1193, 0:+79->609, 1:+250->780, 2:+348->878
    //   557: nop
    //   558: swap
    //   559: ifeq +29 -> 588
    //   562: ldc 97
    //   564: iconst_0
    //   565: new 99	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   572: ldc_w 261
    //   575: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: iload_1
    //   579: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   582: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokestatic 125	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   588: aload_0
    //   589: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   592: invokevirtual 177	android/media/MediaPlayer:release	()V
    //   595: aload_0
    //   596: aconst_null
    //   597: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   600: aload_0
    //   601: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   604: ifnonnull +319 -> 923
    //   607: iconst_0
    //   608: ireturn
    //   609: invokestatic 95	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   612: ifeq +29 -> 641
    //   615: ldc 97
    //   617: iconst_0
    //   618: new 99	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   625: ldc_w 263
    //   628: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: iload_2
    //   632: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   635: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 125	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   641: aload_0
    //   642: getfield 62	com/tencent/TMG/audio/TraeMediaPlayer:_context	Landroid/content/Context;
    //   645: invokevirtual 267	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   648: iload_2
    //   649: invokevirtual 273	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   652: astore_3
    //   653: aload_3
    //   654: ifnonnull +49 -> 703
    //   657: invokestatic 95	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   660: ifeq +29 -> 689
    //   663: ldc 97
    //   665: iconst_0
    //   666: new 99	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   673: ldc_w 275
    //   676: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: iload_2
    //   680: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   683: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: invokestatic 125	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   689: aload_0
    //   690: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   693: invokevirtual 177	android/media/MediaPlayer:release	()V
    //   696: aload_0
    //   697: aconst_null
    //   698: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   701: iconst_0
    //   702: ireturn
    //   703: aload_0
    //   704: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   707: aload_3
    //   708: invokevirtual 281	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   711: aload_3
    //   712: invokevirtual 285	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   715: aload_3
    //   716: invokevirtual 288	android/content/res/AssetFileDescriptor:getLength	()J
    //   719: invokevirtual 292	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   722: aload_3
    //   723: invokevirtual 295	android/content/res/AssetFileDescriptor:close	()V
    //   726: goto -126 -> 600
    //   729: astore_3
    //   730: invokestatic 95	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   733: ifeq -342 -> 391
    //   736: ldc 97
    //   738: iconst_0
    //   739: new 99	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   746: ldc_w 297
    //   749: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: aload_3
    //   753: invokevirtual 298	java/lang/IllegalArgumentException:getLocalizedMessage	()Ljava/lang/String;
    //   756: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: ldc 240
    //   761: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload_3
    //   765: invokevirtual 299	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   768: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: goto -386 -> 391
    //   780: invokestatic 95	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   783: ifeq +29 -> 812
    //   786: ldc 97
    //   788: iconst_0
    //   789: new 99	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   796: ldc_w 301
    //   799: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload_3
    //   803: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   806: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokestatic 125	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   812: aload_0
    //   813: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   816: aload_0
    //   817: getfield 62	com/tencent/TMG/audio/TraeMediaPlayer:_context	Landroid/content/Context;
    //   820: aload_3
    //   821: invokevirtual 304	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   824: goto -224 -> 600
    //   827: astore_3
    //   828: invokestatic 95	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   831: ifeq -440 -> 391
    //   834: ldc 97
    //   836: iconst_0
    //   837: new 99	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   844: ldc_w 306
    //   847: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: aload_3
    //   851: invokevirtual 307	java/lang/SecurityException:getLocalizedMessage	()Ljava/lang/String;
    //   854: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: ldc 240
    //   859: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload_3
    //   863: invokevirtual 308	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   866: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   872: invokestatic 161	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   875: goto -484 -> 391
    //   878: invokestatic 95	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   881: ifeq +30 -> 911
    //   884: ldc 97
    //   886: iconst_0
    //   887: new 99	java/lang/StringBuilder
    //   890: dup
    //   891: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   894: ldc_w 310
    //   897: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: aload 4
    //   902: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: invokestatic 125	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   911: aload_0
    //   912: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   915: aload 4
    //   917: invokevirtual 312	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   920: goto -320 -> 600
    //   923: aload_0
    //   924: iload 7
    //   926: putfield 54	com/tencent/TMG/audio/TraeMediaPlayer:_ringMode	Z
    //   929: iconst_0
    //   930: istore_1
    //   931: aload_0
    //   932: getfield 54	com/tencent/TMG/audio/TraeMediaPlayer:_ringMode	Z
    //   935: ifeq +211 -> 1146
    //   938: aload_0
    //   939: iconst_2
    //   940: putfield 44	com/tencent/TMG/audio/TraeMediaPlayer:_streamType	I
    //   943: iconst_1
    //   944: istore_1
    //   945: aload_0
    //   946: iload 8
    //   948: putfield 46	com/tencent/TMG/audio/TraeMediaPlayer:_hasCall	Z
    //   951: aload_0
    //   952: getfield 46	com/tencent/TMG/audio/TraeMediaPlayer:_hasCall	Z
    //   955: ifeq +9 -> 964
    //   958: aload_0
    //   959: iload 9
    //   961: putfield 44	com/tencent/TMG/audio/TraeMediaPlayer:_streamType	I
    //   964: aload_0
    //   965: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   968: aload_0
    //   969: getfield 44	com/tencent/TMG/audio/TraeMediaPlayer:_streamType	I
    //   972: invokevirtual 316	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   975: aload_0
    //   976: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   979: invokevirtual 319	android/media/MediaPlayer:prepare	()V
    //   982: aload_0
    //   983: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   986: iload 5
    //   988: invokevirtual 323	android/media/MediaPlayer:setLooping	(Z)V
    //   991: aload_0
    //   992: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   995: invokevirtual 187	android/media/MediaPlayer:start	()V
    //   998: aload_0
    //   999: iload 5
    //   1001: putfield 48	com/tencent/TMG/audio/TraeMediaPlayer:_loop	Z
    //   1004: aload_0
    //   1005: getfield 48	com/tencent/TMG/audio/TraeMediaPlayer:_loop	Z
    //   1008: iconst_1
    //   1009: if_icmpne +155 -> 1164
    //   1012: aload_0
    //   1013: iconst_1
    //   1014: putfield 52	com/tencent/TMG/audio/TraeMediaPlayer:_loopCount	I
    //   1017: aload_0
    //   1018: iconst_m1
    //   1019: putfield 50	com/tencent/TMG/audio/TraeMediaPlayer:_durationMS	I
    //   1022: aload_0
    //   1023: aload_0
    //   1024: getfield 52	com/tencent/TMG/audio/TraeMediaPlayer:_loopCount	I
    //   1027: iconst_1
    //   1028: isub
    //   1029: putfield 52	com/tencent/TMG/audio/TraeMediaPlayer:_loopCount	I
    //   1032: aload_0
    //   1033: getfield 46	com/tencent/TMG/audio/TraeMediaPlayer:_hasCall	Z
    //   1036: ifne +9 -> 1045
    //   1039: aload 11
    //   1041: iload_1
    //   1042: invokevirtual 326	android/media/AudioManager:setMode	(I)V
    //   1045: aload_0
    //   1046: getfield 50	com/tencent/TMG/audio/TraeMediaPlayer:_durationMS	I
    //   1049: ifle +46 -> 1095
    //   1052: aload_0
    //   1053: new 229	java/util/Timer
    //   1056: dup
    //   1057: invokespecial 327	java/util/Timer:<init>	()V
    //   1060: putfield 56	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   1063: aload_0
    //   1064: new 329	com/tencent/TMG/audio/TraeMediaPlayer$1
    //   1067: dup
    //   1068: aload_0
    //   1069: invokespecial 332	com/tencent/TMG/audio/TraeMediaPlayer$1:<init>	(Lcom/tencent/TMG/audio/TraeMediaPlayer;)V
    //   1072: putfield 58	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   1075: aload_0
    //   1076: getfield 56	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   1079: aload_0
    //   1080: getfield 58	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   1083: aload_0
    //   1084: getfield 50	com/tencent/TMG/audio/TraeMediaPlayer:_durationMS	I
    //   1087: sipush 1000
    //   1090: iadd
    //   1091: i2l
    //   1092: invokevirtual 336	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   1095: invokestatic 95	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1098: ifeq +98 -> 1196
    //   1101: ldc 97
    //   1103: iconst_0
    //   1104: new 99	java/lang/StringBuilder
    //   1107: dup
    //   1108: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1111: ldc_w 338
    //   1114: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: aload_0
    //   1118: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1121: invokevirtual 340	android/media/MediaPlayer:getDuration	()I
    //   1124: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1127: ldc 213
    //   1129: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: iload 5
    //   1134: invokevirtual 150	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1137: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1140: invokestatic 125	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1143: goto +53 -> 1196
    //   1146: aload_0
    //   1147: iconst_0
    //   1148: putfield 44	com/tencent/TMG/audio/TraeMediaPlayer:_streamType	I
    //   1151: getstatic 345	android/os/Build$VERSION:SDK_INT	I
    //   1154: bipush 11
    //   1156: if_icmplt -211 -> 945
    //   1159: iconst_3
    //   1160: istore_1
    //   1161: goto -216 -> 945
    //   1164: aload_0
    //   1165: iload 6
    //   1167: putfield 52	com/tencent/TMG/audio/TraeMediaPlayer:_loopCount	I
    //   1170: aload_0
    //   1171: aload_0
    //   1172: getfield 52	com/tencent/TMG/audio/TraeMediaPlayer:_loopCount	I
    //   1175: aload_0
    //   1176: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1179: invokevirtual 340	android/media/MediaPlayer:getDuration	()I
    //   1182: imul
    //   1183: putfield 50	com/tencent/TMG/audio/TraeMediaPlayer:_durationMS	I
    //   1186: goto -164 -> 1022
    //   1189: astore_3
    //   1190: goto -792 -> 398
    //   1193: goto -637 -> 556
    //   1196: iconst_1
    //   1197: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1198	0	this	TraeMediaPlayer
    //   0	1198	1	paramInt1	int
    //   0	1198	2	paramInt2	int
    //   0	1198	3	paramUri	android.net.Uri
    //   0	1198	4	paramString	java.lang.String
    //   0	1198	5	paramBoolean1	boolean
    //   0	1198	6	paramInt3	int
    //   0	1198	7	paramBoolean2	boolean
    //   0	1198	8	paramBoolean3	boolean
    //   0	1198	9	paramInt4	int
    //   243	3	10	bool	boolean
    //   64	237	11	localObject	Object
    //   334	706	11	localException	Exception
    //   55	48	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   252	259	334	java/lang/Exception
    //   229	245	344	java/lang/IllegalStateException
    //   259	264	344	java/lang/IllegalStateException
    //   264	288	344	java/lang/IllegalStateException
    //   288	332	344	java/lang/IllegalStateException
    //   336	341	344	java/lang/IllegalStateException
    //   406	413	344	java/lang/IllegalStateException
    //   513	529	344	java/lang/IllegalStateException
    //   556	588	344	java/lang/IllegalStateException
    //   588	600	344	java/lang/IllegalStateException
    //   600	607	344	java/lang/IllegalStateException
    //   609	641	344	java/lang/IllegalStateException
    //   641	653	344	java/lang/IllegalStateException
    //   657	689	344	java/lang/IllegalStateException
    //   689	701	344	java/lang/IllegalStateException
    //   703	726	344	java/lang/IllegalStateException
    //   780	812	344	java/lang/IllegalStateException
    //   812	824	344	java/lang/IllegalStateException
    //   878	911	344	java/lang/IllegalStateException
    //   911	920	344	java/lang/IllegalStateException
    //   923	929	344	java/lang/IllegalStateException
    //   931	943	344	java/lang/IllegalStateException
    //   945	964	344	java/lang/IllegalStateException
    //   964	1022	344	java/lang/IllegalStateException
    //   1022	1045	344	java/lang/IllegalStateException
    //   1045	1095	344	java/lang/IllegalStateException
    //   1095	1143	344	java/lang/IllegalStateException
    //   1146	1151	344	java/lang/IllegalStateException
    //   1151	1159	344	java/lang/IllegalStateException
    //   1164	1186	344	java/lang/IllegalStateException
    //   252	259	405	finally
    //   229	245	413	java/io/IOException
    //   259	264	413	java/io/IOException
    //   264	288	413	java/io/IOException
    //   288	332	413	java/io/IOException
    //   336	341	413	java/io/IOException
    //   406	413	413	java/io/IOException
    //   513	529	413	java/io/IOException
    //   556	588	413	java/io/IOException
    //   588	600	413	java/io/IOException
    //   600	607	413	java/io/IOException
    //   609	641	413	java/io/IOException
    //   641	653	413	java/io/IOException
    //   657	689	413	java/io/IOException
    //   689	701	413	java/io/IOException
    //   703	726	413	java/io/IOException
    //   780	812	413	java/io/IOException
    //   812	824	413	java/io/IOException
    //   878	911	413	java/io/IOException
    //   911	920	413	java/io/IOException
    //   923	929	413	java/io/IOException
    //   931	943	413	java/io/IOException
    //   945	964	413	java/io/IOException
    //   964	1022	413	java/io/IOException
    //   1022	1045	413	java/io/IOException
    //   1045	1095	413	java/io/IOException
    //   1095	1143	413	java/io/IOException
    //   1146	1151	413	java/io/IOException
    //   1151	1159	413	java/io/IOException
    //   1164	1186	413	java/io/IOException
    //   229	245	463	java/lang/Exception
    //   259	264	463	java/lang/Exception
    //   264	288	463	java/lang/Exception
    //   288	332	463	java/lang/Exception
    //   336	341	463	java/lang/Exception
    //   345	391	463	java/lang/Exception
    //   406	413	463	java/lang/Exception
    //   414	460	463	java/lang/Exception
    //   513	529	463	java/lang/Exception
    //   556	588	463	java/lang/Exception
    //   588	600	463	java/lang/Exception
    //   600	607	463	java/lang/Exception
    //   609	641	463	java/lang/Exception
    //   641	653	463	java/lang/Exception
    //   657	689	463	java/lang/Exception
    //   689	701	463	java/lang/Exception
    //   703	726	463	java/lang/Exception
    //   730	777	463	java/lang/Exception
    //   780	812	463	java/lang/Exception
    //   812	824	463	java/lang/Exception
    //   828	875	463	java/lang/Exception
    //   878	911	463	java/lang/Exception
    //   911	920	463	java/lang/Exception
    //   923	929	463	java/lang/Exception
    //   931	943	463	java/lang/Exception
    //   945	964	463	java/lang/Exception
    //   964	1022	463	java/lang/Exception
    //   1022	1045	463	java/lang/Exception
    //   1045	1095	463	java/lang/Exception
    //   1095	1143	463	java/lang/Exception
    //   1146	1151	463	java/lang/Exception
    //   1151	1159	463	java/lang/Exception
    //   1164	1186	463	java/lang/Exception
    //   229	245	729	java/lang/IllegalArgumentException
    //   259	264	729	java/lang/IllegalArgumentException
    //   264	288	729	java/lang/IllegalArgumentException
    //   288	332	729	java/lang/IllegalArgumentException
    //   336	341	729	java/lang/IllegalArgumentException
    //   406	413	729	java/lang/IllegalArgumentException
    //   513	529	729	java/lang/IllegalArgumentException
    //   556	588	729	java/lang/IllegalArgumentException
    //   588	600	729	java/lang/IllegalArgumentException
    //   600	607	729	java/lang/IllegalArgumentException
    //   609	641	729	java/lang/IllegalArgumentException
    //   641	653	729	java/lang/IllegalArgumentException
    //   657	689	729	java/lang/IllegalArgumentException
    //   689	701	729	java/lang/IllegalArgumentException
    //   703	726	729	java/lang/IllegalArgumentException
    //   780	812	729	java/lang/IllegalArgumentException
    //   812	824	729	java/lang/IllegalArgumentException
    //   878	911	729	java/lang/IllegalArgumentException
    //   911	920	729	java/lang/IllegalArgumentException
    //   923	929	729	java/lang/IllegalArgumentException
    //   931	943	729	java/lang/IllegalArgumentException
    //   945	964	729	java/lang/IllegalArgumentException
    //   964	1022	729	java/lang/IllegalArgumentException
    //   1022	1045	729	java/lang/IllegalArgumentException
    //   1045	1095	729	java/lang/IllegalArgumentException
    //   1095	1143	729	java/lang/IllegalArgumentException
    //   1146	1151	729	java/lang/IllegalArgumentException
    //   1151	1159	729	java/lang/IllegalArgumentException
    //   1164	1186	729	java/lang/IllegalArgumentException
    //   229	245	827	java/lang/SecurityException
    //   259	264	827	java/lang/SecurityException
    //   264	288	827	java/lang/SecurityException
    //   288	332	827	java/lang/SecurityException
    //   336	341	827	java/lang/SecurityException
    //   406	413	827	java/lang/SecurityException
    //   513	529	827	java/lang/SecurityException
    //   556	588	827	java/lang/SecurityException
    //   588	600	827	java/lang/SecurityException
    //   600	607	827	java/lang/SecurityException
    //   609	641	827	java/lang/SecurityException
    //   641	653	827	java/lang/SecurityException
    //   657	689	827	java/lang/SecurityException
    //   689	701	827	java/lang/SecurityException
    //   703	726	827	java/lang/SecurityException
    //   780	812	827	java/lang/SecurityException
    //   812	824	827	java/lang/SecurityException
    //   878	911	827	java/lang/SecurityException
    //   911	920	827	java/lang/SecurityException
    //   923	929	827	java/lang/SecurityException
    //   931	943	827	java/lang/SecurityException
    //   945	964	827	java/lang/SecurityException
    //   964	1022	827	java/lang/SecurityException
    //   1022	1045	827	java/lang/SecurityException
    //   1045	1095	827	java/lang/SecurityException
    //   1095	1143	827	java/lang/SecurityException
    //   1146	1151	827	java/lang/SecurityException
    //   1151	1159	827	java/lang/SecurityException
    //   1164	1186	827	java/lang/SecurityException
    //   391	398	1189	java/lang/Exception
  }
  
  public void stopRing()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 0, "TraeMediaPlay stopRing ");
    }
    if (this.mMediaPlay == null) {
      return;
    }
    if (this.mMediaPlay.isPlaying()) {
      this.mMediaPlay.stop();
    }
    this.mMediaPlay.reset();
    try
    {
      if (this._watchTimer != null)
      {
        this._watchTimer.cancel();
        this._watchTimer = null;
        this._watchTimertask = null;
      }
      this.mMediaPlay.release();
    }
    catch (Exception localException)
    {
      label78:
      break label78;
    }
    this.mMediaPlay = null;
    this._durationMS = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeMediaPlayer
 * JD-Core Version:    0.7.0.1
 */