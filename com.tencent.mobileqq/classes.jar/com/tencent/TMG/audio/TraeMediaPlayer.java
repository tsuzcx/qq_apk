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
    if ((this.mMediaPlay != null) && (this._ringMode)) {
      if (this._streamType == 2) {
        return;
      }
    }
    for (;;)
    {
      int j;
      int n;
      try
      {
        localAudioManager = (AudioManager)this._context.getSystemService("audio");
        m = localAudioManager.getStreamVolume(this._streamType);
        j = localAudioManager.getStreamMaxVolume(this._streamType);
        i = localAudioManager.getStreamVolume(2);
        k = localAudioManager.getStreamMaxVolume(2);
        double d1 = i;
        Double.isNaN(d1);
        double d2 = k;
        Double.isNaN(d2);
        d1 = d1 * 1.0D / d2;
        d2 = j;
        Double.isNaN(d2);
        n = (int)(d1 * d2);
        if (!QLog.isColorLevel()) {
          break label245;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TraeMediaPlay volumeDo currV:");
        localStringBuilder.append(m);
        localStringBuilder.append(" maxV:");
        localStringBuilder.append(j);
        localStringBuilder.append(" currRV:");
        localStringBuilder.append(i);
        localStringBuilder.append(" maxRV:");
        localStringBuilder.append(k);
        localStringBuilder.append(" setV:");
        localStringBuilder.append(n);
        QLog.e("TRAE", 0, localStringBuilder.toString());
      }
      catch (Exception localException)
      {
        AudioManager localAudioManager;
        int m;
        return;
      }
      localAudioManager.setStreamVolume(this._streamType, i, 0);
      this._prevVolume = m;
      return;
      label245:
      int k = n + 1;
      int i = k;
      if (k >= j) {
        i = j;
      }
    }
  }
  
  private void volumeUndo()
  {
    if ((this.mMediaPlay != null) && (this._ringMode) && (this._streamType != 2)) {
      if (this._prevVolume == -1) {
        return;
      }
    }
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TraeMediaPlay volumeUndo _prevVolume:");
        localStringBuilder.append(this._prevVolume);
        QLog.e("TRAE", 0, localStringBuilder.toString());
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
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append(" cb:");
    paramMediaPlayer.append(this.mCallback);
    paramMediaPlayer.append(" loopCount:");
    paramMediaPlayer.append(this._loopCount);
    paramMediaPlayer.append(" _loop:");
    paramMediaPlayer.append(this._loop);
    AudioDeviceInterface.LogTraceEntry(paramMediaPlayer.toString());
    if (this._loop)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 0, "loop play,continue...");
      }
      return;
    }
    try
    {
      if (this._loopCount <= 0)
      {
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
      }
      else
      {
        this.mMediaPlay.start();
        this._loopCount -= 1;
      }
      label168:
      AudioDeviceInterface.LogTraceExit();
    }
    catch (Exception paramMediaPlayer)
    {
      break label168;
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append(" cb:");
    paramMediaPlayer.append(this.mCallback);
    paramMediaPlayer.append(" arg1:");
    paramMediaPlayer.append(paramInt1);
    paramMediaPlayer.append(" arg2:");
    paramMediaPlayer.append(paramInt2);
    AudioDeviceInterface.LogTraceEntry(paramMediaPlayer.toString());
    try
    {
      this.mMediaPlay.release();
      label64:
      this.mMediaPlay = null;
      paramMediaPlayer = this.mCallback;
      if (paramMediaPlayer != null) {
        paramMediaPlayer.onCompletion();
      }
      AudioDeviceInterface.LogTraceExit();
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      break label64;
    }
  }
  
  /* Error */
  public boolean playRing(int paramInt1, int paramInt2, android.net.Uri paramUri, java.lang.String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    // Byte code:
    //   0: invokestatic 101	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   3: ifeq +196 -> 199
    //   6: new 103	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   13: astore 12
    //   15: aload 12
    //   17: ldc 211
    //   19: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 12
    //   25: iload_1
    //   26: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 12
    //   32: ldc 213
    //   34: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 12
    //   40: iload_2
    //   41: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 12
    //   47: ldc 215
    //   49: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 12
    //   55: aload_3
    //   56: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 12
    //   62: ldc 217
    //   64: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 12
    //   70: aload 4
    //   72: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 12
    //   78: ldc 219
    //   80: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: iload 5
    //   86: ifeq +10 -> 96
    //   89: ldc 221
    //   91: astore 11
    //   93: goto +7 -> 100
    //   96: ldc 223
    //   98: astore 11
    //   100: aload 12
    //   102: aload 11
    //   104: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 12
    //   110: ldc 225
    //   112: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 12
    //   118: iload 6
    //   120: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 12
    //   126: ldc 227
    //   128: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: iload 7
    //   134: ifeq +10 -> 144
    //   137: ldc 221
    //   139: astore 11
    //   141: goto +7 -> 148
    //   144: ldc 223
    //   146: astore 11
    //   148: aload 12
    //   150: aload 11
    //   152: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 12
    //   158: ldc 229
    //   160: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 12
    //   166: iload 8
    //   168: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 12
    //   174: ldc 231
    //   176: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 12
    //   182: iload 9
    //   184: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: ldc 123
    //   190: iconst_0
    //   191: aload 12
    //   193: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 131	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: iload 5
    //   201: ifne +98 -> 299
    //   204: iload 6
    //   206: ifgt +93 -> 299
    //   209: invokestatic 101	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   212: ifeq +85 -> 297
    //   215: new 103	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   222: astore 4
    //   224: aload 4
    //   226: ldc 233
    //   228: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 4
    //   234: iload_1
    //   235: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 4
    //   241: ldc 219
    //   243: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: iload 5
    //   249: ifeq +9 -> 258
    //   252: ldc 221
    //   254: astore_3
    //   255: goto +6 -> 261
    //   258: ldc 223
    //   260: astore_3
    //   261: aload 4
    //   263: aload_3
    //   264: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 4
    //   270: ldc 225
    //   272: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload 4
    //   278: iload 6
    //   280: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: ldc 123
    //   286: iconst_0
    //   287: aload 4
    //   289: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 131	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: iconst_0
    //   296: ireturn
    //   297: iconst_0
    //   298: ireturn
    //   299: aload_0
    //   300: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   303: astore 11
    //   305: aload 11
    //   307: ifnull +42 -> 349
    //   310: aload_0
    //   311: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   314: invokevirtual 174	android/media/MediaPlayer:isPlaying	()Z
    //   317: istore 10
    //   319: iload 10
    //   321: ifeq +5 -> 326
    //   324: iconst_0
    //   325: ireturn
    //   326: aload_0
    //   327: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   330: invokevirtual 183	android/media/MediaPlayer:release	()V
    //   333: aload_0
    //   334: aconst_null
    //   335: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   338: goto +11 -> 349
    //   341: astore_3
    //   342: aload_0
    //   343: aconst_null
    //   344: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   347: aload_3
    //   348: athrow
    //   349: aload_0
    //   350: getfield 56	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   353: ifnull +20 -> 373
    //   356: aload_0
    //   357: getfield 56	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   360: invokevirtual 238	java/util/Timer:cancel	()V
    //   363: aload_0
    //   364: aconst_null
    //   365: putfield 56	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   368: aload_0
    //   369: aconst_null
    //   370: putfield 58	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   373: aload_0
    //   374: getfield 62	com/tencent/TMG/audio/TraeMediaPlayer:_context	Landroid/content/Context;
    //   377: ldc 74
    //   379: invokevirtual 80	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   382: checkcast 82	android/media/AudioManager
    //   385: astore 11
    //   387: aload_0
    //   388: new 240	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   391: dup
    //   392: invokespecial 241	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   395: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   398: aload_0
    //   399: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   402: ifnonnull +17 -> 419
    //   405: aload_0
    //   406: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   409: invokevirtual 183	android/media/MediaPlayer:release	()V
    //   412: aload_0
    //   413: aconst_null
    //   414: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   417: iconst_0
    //   418: ireturn
    //   419: aload_0
    //   420: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   423: aload_0
    //   424: invokevirtual 245	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   427: aload_0
    //   428: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   431: aload_0
    //   432: invokevirtual 249	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   435: iload_1
    //   436: ifeq +172 -> 608
    //   439: iload_1
    //   440: iconst_1
    //   441: if_icmpeq +110 -> 551
    //   444: iload_1
    //   445: iconst_2
    //   446: if_icmpeq +55 -> 501
    //   449: invokestatic 101	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   452: ifeq +34 -> 486
    //   455: new 103	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   462: astore_3
    //   463: aload_3
    //   464: ldc 251
    //   466: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload_3
    //   471: iload_1
    //   472: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: ldc 123
    //   478: iconst_0
    //   479: aload_3
    //   480: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 131	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: aload_0
    //   487: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   490: invokevirtual 183	android/media/MediaPlayer:release	()V
    //   493: aload_0
    //   494: aconst_null
    //   495: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   498: goto +239 -> 737
    //   501: invokestatic 101	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   504: ifeq +35 -> 539
    //   507: new 103	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   514: astore_3
    //   515: aload_3
    //   516: ldc 253
    //   518: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload_3
    //   523: aload 4
    //   525: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: ldc 123
    //   531: iconst_0
    //   532: aload_3
    //   533: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 131	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: aload_0
    //   540: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   543: aload 4
    //   545: invokevirtual 256	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   548: goto +189 -> 737
    //   551: invokestatic 101	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   554: ifeq +39 -> 593
    //   557: new 103	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   564: astore 4
    //   566: aload 4
    //   568: ldc_w 258
    //   571: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload 4
    //   577: aload_3
    //   578: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: ldc 123
    //   584: iconst_0
    //   585: aload 4
    //   587: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 131	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: aload_0
    //   594: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   597: aload_0
    //   598: getfield 62	com/tencent/TMG/audio/TraeMediaPlayer:_context	Landroid/content/Context;
    //   601: aload_3
    //   602: invokevirtual 261	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   605: goto +132 -> 737
    //   608: invokestatic 101	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   611: ifeq +35 -> 646
    //   614: new 103	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   621: astore_3
    //   622: aload_3
    //   623: ldc_w 263
    //   626: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload_3
    //   631: iload_2
    //   632: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: ldc 123
    //   638: iconst_0
    //   639: aload_3
    //   640: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 131	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   646: aload_0
    //   647: getfield 62	com/tencent/TMG/audio/TraeMediaPlayer:_context	Landroid/content/Context;
    //   650: invokevirtual 267	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   653: iload_2
    //   654: invokevirtual 273	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   657: astore_3
    //   658: aload_3
    //   659: ifnonnull +55 -> 714
    //   662: invokestatic 101	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   665: ifeq +35 -> 700
    //   668: new 103	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   675: astore_3
    //   676: aload_3
    //   677: ldc_w 275
    //   680: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload_3
    //   685: iload_2
    //   686: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   689: pop
    //   690: ldc 123
    //   692: iconst_0
    //   693: aload_3
    //   694: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokestatic 131	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   700: aload_0
    //   701: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   704: invokevirtual 183	android/media/MediaPlayer:release	()V
    //   707: aload_0
    //   708: aconst_null
    //   709: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   712: iconst_0
    //   713: ireturn
    //   714: aload_0
    //   715: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   718: aload_3
    //   719: invokevirtual 281	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   722: aload_3
    //   723: invokevirtual 285	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   726: aload_3
    //   727: invokevirtual 288	android/content/res/AssetFileDescriptor:getLength	()J
    //   730: invokevirtual 291	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   733: aload_3
    //   734: invokevirtual 294	android/content/res/AssetFileDescriptor:close	()V
    //   737: aload_0
    //   738: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   741: ifnonnull +5 -> 746
    //   744: iconst_0
    //   745: ireturn
    //   746: aload_0
    //   747: iload 7
    //   749: putfield 54	com/tencent/TMG/audio/TraeMediaPlayer:_ringMode	Z
    //   752: aload_0
    //   753: getfield 54	com/tencent/TMG/audio/TraeMediaPlayer:_ringMode	Z
    //   756: ifeq +13 -> 769
    //   759: aload_0
    //   760: iconst_2
    //   761: putfield 44	com/tencent/TMG/audio/TraeMediaPlayer:_streamType	I
    //   764: iconst_1
    //   765: istore_1
    //   766: goto +21 -> 787
    //   769: aload_0
    //   770: iconst_0
    //   771: putfield 44	com/tencent/TMG/audio/TraeMediaPlayer:_streamType	I
    //   774: getstatic 299	android/os/Build$VERSION:SDK_INT	I
    //   777: bipush 11
    //   779: if_icmplt +616 -> 1395
    //   782: iconst_3
    //   783: istore_1
    //   784: goto +3 -> 787
    //   787: aload_0
    //   788: iload 8
    //   790: putfield 46	com/tencent/TMG/audio/TraeMediaPlayer:_hasCall	Z
    //   793: aload_0
    //   794: getfield 46	com/tencent/TMG/audio/TraeMediaPlayer:_hasCall	Z
    //   797: ifeq +9 -> 806
    //   800: aload_0
    //   801: iload 9
    //   803: putfield 44	com/tencent/TMG/audio/TraeMediaPlayer:_streamType	I
    //   806: aload_0
    //   807: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   810: aload_0
    //   811: getfield 44	com/tencent/TMG/audio/TraeMediaPlayer:_streamType	I
    //   814: invokevirtual 303	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   817: aload_0
    //   818: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   821: invokevirtual 306	android/media/MediaPlayer:prepare	()V
    //   824: aload_0
    //   825: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   828: iload 5
    //   830: invokevirtual 310	android/media/MediaPlayer:setLooping	(Z)V
    //   833: aload_0
    //   834: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   837: invokevirtual 190	android/media/MediaPlayer:start	()V
    //   840: aload_0
    //   841: iload 5
    //   843: putfield 48	com/tencent/TMG/audio/TraeMediaPlayer:_loop	Z
    //   846: aload_0
    //   847: getfield 48	com/tencent/TMG/audio/TraeMediaPlayer:_loop	Z
    //   850: iconst_1
    //   851: if_icmpne +16 -> 867
    //   854: aload_0
    //   855: iconst_1
    //   856: putfield 52	com/tencent/TMG/audio/TraeMediaPlayer:_loopCount	I
    //   859: aload_0
    //   860: iconst_m1
    //   861: putfield 50	com/tencent/TMG/audio/TraeMediaPlayer:_durationMS	I
    //   864: goto +25 -> 889
    //   867: aload_0
    //   868: iload 6
    //   870: putfield 52	com/tencent/TMG/audio/TraeMediaPlayer:_loopCount	I
    //   873: aload_0
    //   874: aload_0
    //   875: getfield 52	com/tencent/TMG/audio/TraeMediaPlayer:_loopCount	I
    //   878: aload_0
    //   879: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   882: invokevirtual 312	android/media/MediaPlayer:getDuration	()I
    //   885: imul
    //   886: putfield 50	com/tencent/TMG/audio/TraeMediaPlayer:_durationMS	I
    //   889: aload_0
    //   890: aload_0
    //   891: getfield 52	com/tencent/TMG/audio/TraeMediaPlayer:_loopCount	I
    //   894: iconst_1
    //   895: isub
    //   896: putfield 52	com/tencent/TMG/audio/TraeMediaPlayer:_loopCount	I
    //   899: aload_0
    //   900: getfield 46	com/tencent/TMG/audio/TraeMediaPlayer:_hasCall	Z
    //   903: ifne +9 -> 912
    //   906: aload 11
    //   908: iload_1
    //   909: invokevirtual 315	android/media/AudioManager:setMode	(I)V
    //   912: aload_0
    //   913: getfield 50	com/tencent/TMG/audio/TraeMediaPlayer:_durationMS	I
    //   916: ifle +46 -> 962
    //   919: aload_0
    //   920: new 235	java/util/Timer
    //   923: dup
    //   924: invokespecial 316	java/util/Timer:<init>	()V
    //   927: putfield 56	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   930: aload_0
    //   931: new 318	com/tencent/TMG/audio/TraeMediaPlayer$1
    //   934: dup
    //   935: aload_0
    //   936: invokespecial 321	com/tencent/TMG/audio/TraeMediaPlayer$1:<init>	(Lcom/tencent/TMG/audio/TraeMediaPlayer;)V
    //   939: putfield 58	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   942: aload_0
    //   943: getfield 56	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   946: aload_0
    //   947: getfield 58	com/tencent/TMG/audio/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   950: aload_0
    //   951: getfield 50	com/tencent/TMG/audio/TraeMediaPlayer:_durationMS	I
    //   954: sipush 1000
    //   957: iadd
    //   958: i2l
    //   959: invokevirtual 325	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   962: invokestatic 101	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   965: ifeq +55 -> 1020
    //   968: new 103	java/lang/StringBuilder
    //   971: dup
    //   972: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   975: astore_3
    //   976: aload_3
    //   977: ldc_w 327
    //   980: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: pop
    //   984: aload_3
    //   985: aload_0
    //   986: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   989: invokevirtual 312	android/media/MediaPlayer:getDuration	()I
    //   992: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload_3
    //   997: ldc 219
    //   999: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: aload_3
    //   1004: iload 5
    //   1006: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1009: pop
    //   1010: ldc 123
    //   1012: iconst_0
    //   1013: aload_3
    //   1014: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1017: invokestatic 131	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1020: iconst_1
    //   1021: ireturn
    //   1022: astore_3
    //   1023: goto +83 -> 1106
    //   1026: astore_3
    //   1027: goto +146 -> 1173
    //   1030: astore_3
    //   1031: goto +209 -> 1240
    //   1034: astore_3
    //   1035: goto +273 -> 1308
    //   1038: astore_3
    //   1039: invokestatic 101	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1042: ifeq +330 -> 1372
    //   1045: new 103	java/lang/StringBuilder
    //   1048: dup
    //   1049: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1052: astore 4
    //   1054: aload 4
    //   1056: ldc_w 329
    //   1059: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: pop
    //   1063: aload 4
    //   1065: aload_3
    //   1066: invokevirtual 332	java/lang/SecurityException:getLocalizedMessage	()Ljava/lang/String;
    //   1069: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: pop
    //   1073: aload 4
    //   1075: ldc_w 334
    //   1078: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: pop
    //   1082: aload 4
    //   1084: aload_3
    //   1085: invokevirtual 337	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   1088: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: ldc 123
    //   1094: iconst_0
    //   1095: aload 4
    //   1097: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1100: invokestatic 167	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1103: goto +269 -> 1372
    //   1106: invokestatic 101	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1109: ifeq +263 -> 1372
    //   1112: new 103	java/lang/StringBuilder
    //   1115: dup
    //   1116: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1119: astore 4
    //   1121: aload 4
    //   1123: ldc_w 339
    //   1126: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: pop
    //   1130: aload 4
    //   1132: aload_3
    //   1133: invokevirtual 340	java/lang/IllegalArgumentException:getLocalizedMessage	()Ljava/lang/String;
    //   1136: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: pop
    //   1140: aload 4
    //   1142: ldc_w 334
    //   1145: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: pop
    //   1149: aload 4
    //   1151: aload_3
    //   1152: invokevirtual 341	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   1155: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: pop
    //   1159: ldc 123
    //   1161: iconst_0
    //   1162: aload 4
    //   1164: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1167: invokestatic 167	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1170: goto +202 -> 1372
    //   1173: invokestatic 101	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1176: ifeq +196 -> 1372
    //   1179: new 103	java/lang/StringBuilder
    //   1182: dup
    //   1183: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1186: astore 4
    //   1188: aload 4
    //   1190: ldc_w 343
    //   1193: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: pop
    //   1197: aload 4
    //   1199: aload_3
    //   1200: invokevirtual 344	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   1203: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: pop
    //   1207: aload 4
    //   1209: ldc_w 334
    //   1212: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: pop
    //   1216: aload 4
    //   1218: aload_3
    //   1219: invokevirtual 345	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1222: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: pop
    //   1226: ldc 123
    //   1228: iconst_0
    //   1229: aload 4
    //   1231: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1234: invokestatic 167	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1237: goto +135 -> 1372
    //   1240: invokestatic 101	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1243: ifeq +129 -> 1372
    //   1246: new 103	java/lang/StringBuilder
    //   1249: dup
    //   1250: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1253: astore 4
    //   1255: aload 4
    //   1257: ldc_w 347
    //   1260: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: pop
    //   1264: aload 4
    //   1266: aload_3
    //   1267: invokevirtual 348	java/lang/IllegalStateException:getLocalizedMessage	()Ljava/lang/String;
    //   1270: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: pop
    //   1274: aload 4
    //   1276: ldc_w 334
    //   1279: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: pop
    //   1283: aload 4
    //   1285: aload_3
    //   1286: invokevirtual 349	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   1289: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: pop
    //   1293: ldc 123
    //   1295: iconst_0
    //   1296: aload 4
    //   1298: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1301: invokestatic 167	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1304: goto +68 -> 1372
    //   1307: astore_3
    //   1308: invokestatic 101	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1311: ifeq +61 -> 1372
    //   1314: new 103	java/lang/StringBuilder
    //   1317: dup
    //   1318: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1321: astore 4
    //   1323: aload 4
    //   1325: ldc_w 351
    //   1328: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: pop
    //   1332: aload 4
    //   1334: aload_3
    //   1335: invokevirtual 352	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   1338: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: pop
    //   1342: aload 4
    //   1344: ldc_w 334
    //   1347: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: pop
    //   1351: aload 4
    //   1353: aload_3
    //   1354: invokevirtual 353	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1357: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: pop
    //   1361: ldc 123
    //   1363: iconst_0
    //   1364: aload 4
    //   1366: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1369: invokestatic 167	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1372: aload_0
    //   1373: getfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1376: invokevirtual 183	android/media/MediaPlayer:release	()V
    //   1379: aload_0
    //   1380: aconst_null
    //   1381: putfield 42	com/tencent/TMG/audio/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1384: iconst_0
    //   1385: ireturn
    //   1386: astore 11
    //   1388: goto -1055 -> 333
    //   1391: astore_3
    //   1392: goto -13 -> 1379
    //   1395: iconst_0
    //   1396: istore_1
    //   1397: goto -610 -> 787
    //   1400: astore_3
    //   1401: goto -93 -> 1308
    //   1404: astore_3
    //   1405: goto -299 -> 1106
    //   1408: astore_3
    //   1409: goto -236 -> 1173
    //   1412: astore_3
    //   1413: goto -173 -> 1240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1416	0	this	TraeMediaPlayer
    //   0	1416	1	paramInt1	int
    //   0	1416	2	paramInt2	int
    //   0	1416	3	paramUri	android.net.Uri
    //   0	1416	4	paramString	java.lang.String
    //   0	1416	5	paramBoolean1	boolean
    //   0	1416	6	paramInt3	int
    //   0	1416	7	paramBoolean2	boolean
    //   0	1416	8	paramBoolean3	boolean
    //   0	1416	9	paramInt4	int
    //   317	3	10	bool	boolean
    //   91	816	11	localObject	Object
    //   1386	1	11	localException	Exception
    //   13	179	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   326	333	341	finally
    //   310	319	1022	java/lang/IllegalArgumentException
    //   333	338	1022	java/lang/IllegalArgumentException
    //   342	349	1022	java/lang/IllegalArgumentException
    //   349	373	1022	java/lang/IllegalArgumentException
    //   373	417	1022	java/lang/IllegalArgumentException
    //   419	435	1022	java/lang/IllegalArgumentException
    //   449	486	1022	java/lang/IllegalArgumentException
    //   486	498	1022	java/lang/IllegalArgumentException
    //   501	539	1022	java/lang/IllegalArgumentException
    //   539	548	1022	java/lang/IllegalArgumentException
    //   551	593	1022	java/lang/IllegalArgumentException
    //   593	605	1022	java/lang/IllegalArgumentException
    //   608	646	1022	java/lang/IllegalArgumentException
    //   646	658	1022	java/lang/IllegalArgumentException
    //   662	700	1022	java/lang/IllegalArgumentException
    //   700	712	1022	java/lang/IllegalArgumentException
    //   714	737	1022	java/lang/IllegalArgumentException
    //   737	744	1022	java/lang/IllegalArgumentException
    //   746	764	1022	java/lang/IllegalArgumentException
    //   769	782	1022	java/lang/IllegalArgumentException
    //   787	806	1022	java/lang/IllegalArgumentException
    //   806	864	1022	java/lang/IllegalArgumentException
    //   867	889	1022	java/lang/IllegalArgumentException
    //   889	912	1022	java/lang/IllegalArgumentException
    //   912	962	1022	java/lang/IllegalArgumentException
    //   962	1020	1022	java/lang/IllegalArgumentException
    //   310	319	1026	java/io/IOException
    //   333	338	1026	java/io/IOException
    //   342	349	1026	java/io/IOException
    //   349	373	1026	java/io/IOException
    //   373	417	1026	java/io/IOException
    //   419	435	1026	java/io/IOException
    //   449	486	1026	java/io/IOException
    //   486	498	1026	java/io/IOException
    //   501	539	1026	java/io/IOException
    //   539	548	1026	java/io/IOException
    //   551	593	1026	java/io/IOException
    //   593	605	1026	java/io/IOException
    //   608	646	1026	java/io/IOException
    //   646	658	1026	java/io/IOException
    //   662	700	1026	java/io/IOException
    //   700	712	1026	java/io/IOException
    //   714	737	1026	java/io/IOException
    //   737	744	1026	java/io/IOException
    //   746	764	1026	java/io/IOException
    //   769	782	1026	java/io/IOException
    //   787	806	1026	java/io/IOException
    //   806	864	1026	java/io/IOException
    //   867	889	1026	java/io/IOException
    //   889	912	1026	java/io/IOException
    //   912	962	1026	java/io/IOException
    //   962	1020	1026	java/io/IOException
    //   310	319	1030	java/lang/IllegalStateException
    //   333	338	1030	java/lang/IllegalStateException
    //   342	349	1030	java/lang/IllegalStateException
    //   349	373	1030	java/lang/IllegalStateException
    //   373	417	1030	java/lang/IllegalStateException
    //   419	435	1030	java/lang/IllegalStateException
    //   449	486	1030	java/lang/IllegalStateException
    //   486	498	1030	java/lang/IllegalStateException
    //   501	539	1030	java/lang/IllegalStateException
    //   539	548	1030	java/lang/IllegalStateException
    //   551	593	1030	java/lang/IllegalStateException
    //   593	605	1030	java/lang/IllegalStateException
    //   608	646	1030	java/lang/IllegalStateException
    //   646	658	1030	java/lang/IllegalStateException
    //   662	700	1030	java/lang/IllegalStateException
    //   700	712	1030	java/lang/IllegalStateException
    //   714	737	1030	java/lang/IllegalStateException
    //   737	744	1030	java/lang/IllegalStateException
    //   746	764	1030	java/lang/IllegalStateException
    //   769	782	1030	java/lang/IllegalStateException
    //   787	806	1030	java/lang/IllegalStateException
    //   806	864	1030	java/lang/IllegalStateException
    //   867	889	1030	java/lang/IllegalStateException
    //   889	912	1030	java/lang/IllegalStateException
    //   912	962	1030	java/lang/IllegalStateException
    //   962	1020	1030	java/lang/IllegalStateException
    //   299	305	1034	java/lang/Exception
    //   310	319	1034	java/lang/Exception
    //   333	338	1034	java/lang/Exception
    //   342	349	1034	java/lang/Exception
    //   349	373	1034	java/lang/Exception
    //   373	417	1034	java/lang/Exception
    //   419	435	1034	java/lang/Exception
    //   449	486	1034	java/lang/Exception
    //   486	498	1034	java/lang/Exception
    //   501	539	1034	java/lang/Exception
    //   539	548	1034	java/lang/Exception
    //   551	593	1034	java/lang/Exception
    //   593	605	1034	java/lang/Exception
    //   608	646	1034	java/lang/Exception
    //   646	658	1034	java/lang/Exception
    //   662	700	1034	java/lang/Exception
    //   700	712	1034	java/lang/Exception
    //   714	737	1034	java/lang/Exception
    //   737	744	1034	java/lang/Exception
    //   746	764	1034	java/lang/Exception
    //   769	782	1034	java/lang/Exception
    //   787	806	1034	java/lang/Exception
    //   806	864	1034	java/lang/Exception
    //   867	889	1034	java/lang/Exception
    //   889	912	1034	java/lang/Exception
    //   912	962	1034	java/lang/Exception
    //   962	1020	1034	java/lang/Exception
    //   299	305	1038	java/lang/SecurityException
    //   310	319	1038	java/lang/SecurityException
    //   333	338	1038	java/lang/SecurityException
    //   342	349	1038	java/lang/SecurityException
    //   349	373	1038	java/lang/SecurityException
    //   373	417	1038	java/lang/SecurityException
    //   419	435	1038	java/lang/SecurityException
    //   449	486	1038	java/lang/SecurityException
    //   486	498	1038	java/lang/SecurityException
    //   501	539	1038	java/lang/SecurityException
    //   539	548	1038	java/lang/SecurityException
    //   551	593	1038	java/lang/SecurityException
    //   593	605	1038	java/lang/SecurityException
    //   608	646	1038	java/lang/SecurityException
    //   646	658	1038	java/lang/SecurityException
    //   662	700	1038	java/lang/SecurityException
    //   700	712	1038	java/lang/SecurityException
    //   714	737	1038	java/lang/SecurityException
    //   737	744	1038	java/lang/SecurityException
    //   746	764	1038	java/lang/SecurityException
    //   769	782	1038	java/lang/SecurityException
    //   787	806	1038	java/lang/SecurityException
    //   806	864	1038	java/lang/SecurityException
    //   867	889	1038	java/lang/SecurityException
    //   889	912	1038	java/lang/SecurityException
    //   912	962	1038	java/lang/SecurityException
    //   962	1020	1038	java/lang/SecurityException
    //   1073	1103	1307	java/lang/Exception
    //   1106	1170	1307	java/lang/Exception
    //   1173	1237	1307	java/lang/Exception
    //   1240	1304	1307	java/lang/Exception
    //   326	333	1386	java/lang/Exception
    //   1372	1379	1391	java/lang/Exception
    //   1039	1073	1400	java/lang/Exception
    //   299	305	1404	java/lang/IllegalArgumentException
    //   299	305	1408	java/io/IOException
    //   299	305	1412	java/lang/IllegalStateException
  }
  
  public void stopRing()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 0, "TraeMediaPlay stopRing ");
    }
    MediaPlayer localMediaPlayer = this.mMediaPlay;
    if (localMediaPlayer == null) {
      return;
    }
    if (localMediaPlayer.isPlaying()) {
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
      label77:
      break label77;
    }
    this.mMediaPlay = null;
    this._durationMS = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeMediaPlayer
 * JD-Core Version:    0.7.0.1
 */