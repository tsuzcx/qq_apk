package com.tencent.TMG.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.TMG.utils.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class AudioDeviceInterface
{
  private static boolean _dumpEnable = false;
  private static boolean _logEnable = true;
  private TraeAudioSession _as = null;
  private TraeAudioSession _asAudioManager = null;
  private AudioManager _audioManager = null;
  private AudioRecord _audioRecord = null;
  private boolean _audioRouteChanged = false;
  private int _audioSource = 0;
  private int _audioSourcePolicy = -1;
  private int _audioStreamTypePolicy = -1;
  private AudioTrack _audioTrack = null;
  private int _bufferedPlaySamples = 0;
  private int _bufferedRecSamples = 0;
  private int _channelOutType = 4;
  private String _connectedDev = "DEVICE_NONE";
  private Context _context = null;
  private ByteBuffer _decBuffer0;
  private ByteBuffer _decBuffer1;
  private ByteBuffer _decBuffer10;
  private ByteBuffer _decBuffer2;
  private ByteBuffer _decBuffer3;
  private ByteBuffer _decBuffer4;
  private ByteBuffer _decBuffer5;
  private ByteBuffer _decBuffer6;
  private ByteBuffer _decBuffer7;
  private ByteBuffer _decBuffer8;
  private ByteBuffer _decBuffer9;
  private int _deviceStat = 0;
  private boolean _doPlayInit = true;
  private boolean _doRecInit = true;
  private boolean _isPlaying = false;
  private boolean _isRecording = false;
  private int _modePolicy = -1;
  private ByteBuffer _playBuffer;
  private final ReentrantLock _playLock = new ReentrantLock();
  private int _playPosition = 0;
  private int _playSamplerate = 8000;
  private File _play_dump = null;
  private FileOutputStream _play_out = null;
  private boolean _preDone = false;
  private Condition _precon = this._prelock.newCondition();
  private ReentrantLock _prelock = new ReentrantLock();
  private ByteBuffer _recBuffer;
  private final ReentrantLock _recLock = new ReentrantLock();
  private File _rec_dump = null;
  private FileOutputStream _rec_out = null;
  private int _sceneMode = 0;
  private int _sessionId = 0;
  private int _streamType = 0;
  private byte[] _tempBufPlay;
  private byte[] _tempBufRec;
  private TraeAudioCodecList _traeAudioCodecList = null;
  private int nPlayLengthMs = 0;
  private int nRecordLengthMs = 0;
  private int switchState = 0;
  private boolean usingJava = true;
  
  public AudioDeviceInterface()
  {
    try
    {
      this._playBuffer = ByteBuffer.allocateDirect(1920);
      this._recBuffer = ByteBuffer.allocateDirect(1920);
      this._decBuffer0 = ByteBuffer.allocateDirect(3840);
      this._decBuffer1 = ByteBuffer.allocateDirect(3840);
      this._decBuffer2 = ByteBuffer.allocateDirect(3840);
      this._decBuffer3 = ByteBuffer.allocateDirect(3840);
      this._decBuffer4 = ByteBuffer.allocateDirect(3840);
      this._decBuffer5 = ByteBuffer.allocateDirect(3840);
      this._decBuffer6 = ByteBuffer.allocateDirect(3840);
      this._decBuffer7 = ByteBuffer.allocateDirect(3840);
      this._decBuffer8 = ByteBuffer.allocateDirect(3840);
      this._decBuffer9 = ByteBuffer.allocateDirect(3840);
      this._decBuffer10 = ByteBuffer.allocateDirect(3840);
      this._tempBufPlay = new byte[1920];
      this._tempBufRec = new byte[1920];
      this._traeAudioCodecList = new TraeAudioCodecList();
      int i = Build.VERSION.SDK_INT;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "AudioDeviceInterface apiLevel:" + i);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, " SDK_INT:" + Build.VERSION.SDK_INT);
      }
      if ((i > 0) || (QLog.isColorLevel())) {
        QLog.w("TRAE", 0, "manufacture:" + Build.MANUFACTURER);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "MODEL:" + Build.MODEL);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, localException.getMessage());
        }
      }
    }
  }
  
  private int CloseMp3File(int paramInt)
  {
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null)
    {
      localCodecInfo.audioDecoder.release();
      localCodecInfo.audioDecoder = null;
      this._traeAudioCodecList.remove(paramInt);
      return 0;
    }
    return -1;
  }
  
  private int GetPlayoutVolume()
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null) {
      i = this._audioManager.getStreamVolume(0);
    }
    return i;
  }
  
  private int InitPlayback(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "InitPlayback entry: sampleRate " + paramInt1);
    }
    if ((this._isPlaying) || (this._audioTrack != null) || (paramInt2 > 2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "InitPlayback _isPlaying:" + this._isPlaying);
      }
      return -1;
    }
    if (this._audioManager == null) {}
    label574:
    for (;;)
    {
      int k;
      int i;
      try
      {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        if (paramInt2 == 2)
        {
          this._channelOutType = 12;
          this._playSamplerate = paramInt1;
          int n = AudioTrack.getMinBufferSize(paramInt1, this._channelOutType, 2);
          if (this._channelOutType == 12)
          {
            if (!QLog.isColorLevel()) {
              break label456;
            }
            QLog.w("TRAE", 0, "InitPlayback, _channelOutType stero");
          }
          int j = paramInt1 * 20 * 1 * 2 / 1000;
          if (this._channelOutType != 12) {
            break label953;
          }
          j *= 2;
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "InitPlayback: minPlayBufSize:" + n + " 20msFz:" + j);
          }
          this._bufferedPlaySamples = 0;
          if (this._audioTrack != null)
          {
            this._audioTrack.release();
            this._audioTrack = null;
          }
          int[] arrayOfInt = new int[4];
          tmp267_265 = arrayOfInt;
          tmp267_265[0] = 0;
          tmp271_267 = tmp267_265;
          tmp271_267[1] = 0;
          tmp275_271 = tmp271_267;
          tmp275_271[2] = 3;
          tmp279_275 = tmp275_271;
          tmp279_275[3] = 1;
          tmp279_275;
          this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
          if (this._audioRouteChanged) {
            break label482;
          }
          arrayOfInt[0] = this._streamType;
          k = 0;
          i = n;
          if ((k >= arrayOfInt.length) || (this._audioTrack != null)) {
            break label760;
          }
          this._streamType = arrayOfInt[k];
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "InitPlayback: min play buf size is " + n + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
          }
          int m = 1;
          if (m > 2) {
            break label751;
          }
          i = n * m;
          if ((i >= j * 4) || (m >= 2)) {
            break label574;
          }
          m += 1;
          continue;
        }
        this._channelOutType = 4;
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, localException1.getMessage());
        }
        return -1;
      }
      continue;
      label456:
      if ((this._channelOutType == 4) && (QLog.isColorLevel()))
      {
        QLog.w("TRAE", 0, "InitPlayback, _channelOutType Mono");
        continue;
        label482:
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "_audioRouteChanged:" + this._audioRouteChanged + " _streamType:" + this._streamType);
        }
        if ((this._audioManager.getMode() == 0) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {}
        for (this._streamType = 3;; this._streamType = 0)
        {
          this._audioRouteChanged = false;
          break;
        }
        try
        {
          this.nPlayLengthMs = (i * 500 / (paramInt1 * paramInt2));
          this._audioTrack = new AudioTrack(this._streamType, this._playSamplerate, this._channelOutType, 2, i, 1);
          if (this._audioTrack.getState() == 1) {
            break label751;
          }
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "InitPlayback: play not initialized playBufSize:" + i + " sr:" + this._playSamplerate);
          }
          this._audioTrack.release();
          this._audioTrack = null;
        }
        catch (Exception localException2)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, localException2.getMessage() + " _audioTrack:" + this._audioTrack);
          }
          if (this._audioTrack != null) {
            this._audioTrack.release();
          }
          this._audioTrack = null;
        }
        continue;
        label751:
        k += 1;
        continue;
        label760:
        if (this._audioTrack == null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "InitPlayback fail!!!");
          }
          return -1;
        }
        if ((this._as != null) && (this._audioManager != null)) {
          this._as.voiceCallAudioParamChanged(this._audioManager.getMode(), this._streamType);
        }
        this._playPosition = this._audioTrack.getPlaybackHeadPosition();
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "InitPlayback exit: streamType:" + this._streamType + " samplerate:" + this._playSamplerate + " _playPosition:" + this._playPosition + " playBufSize:" + i + " nPlayLengthMs:" + this.nPlayLengthMs);
        }
        AudioManager localAudioManager = this._audioManager;
        if (this._connectedDev.equals("DEVICE_BLUETOOTHHEADSET")) {}
        for (paramInt1 = 6;; paramInt1 = this._audioTrack.getStreamType())
        {
          TraeAudioManager.forceVolumeControlStream(localAudioManager, paramInt1);
          return 0;
        }
      }
    }
  }
  
  private int InitRecording(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "InitRecording entry:" + paramInt1);
    }
    if ((this._isRecording) || (this._audioRecord != null) || (paramInt2 > 2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "InitRecording _isRecording:" + this._isRecording);
      }
      return -1;
    }
    int j = 16;
    if (paramInt2 == 2) {
      j = 12;
    }
    int n = AudioRecord.getMinBufferSize(paramInt1, j, 2);
    int i1 = paramInt1 * 20 * paramInt2 * 2 / 1000;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "InitRecording: min rec buf size is " + n + " sr:" + getLowlatencySamplerate() + " fp" + getLowlatencyFramesPerBuffer() + " 20msFZ:" + i1);
    }
    this._bufferedRecSamples = (paramInt1 * 5 / 200);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "  rough rec delay set to " + this._bufferedRecSamples);
    }
    if (this._audioRecord != null)
    {
      this._audioRecord.release();
      this._audioRecord = null;
    }
    int[] arrayOfInt = new int[4];
    int[] tmp266_264 = arrayOfInt;
    tmp266_264[0] = 0;
    int[] tmp270_266 = tmp266_264;
    tmp270_266[1] = 1;
    int[] tmp274_270 = tmp270_266;
    tmp274_270[2] = 5;
    int[] tmp278_274 = tmp274_270;
    tmp278_274[3] = 0;
    tmp278_274;
    arrayOfInt[0] = TraeAudioManager.getAudioSource(this._audioSourcePolicy);
    int k = 0;
    int i = n;
    while ((k < arrayOfInt.length) && (this._audioRecord == null))
    {
      this._audioSource = arrayOfInt[k];
      int m = 1;
      if (m <= 2)
      {
        i = n * m;
        if ((i < i1 * 4) && (m < 2)) {}
        for (;;)
        {
          m += 1;
          break;
          try
          {
            this.nRecordLengthMs = (i * 500 / (paramInt1 * paramInt2));
            this._audioRecord = new AudioRecord(this._audioSource, paramInt1, j, 2, i);
            if (this._audioRecord.getState() == 1) {
              break label543;
            }
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 0, "InitRecording:  rec not initialized,try agine,  minbufsize:" + i + " sr:" + paramInt1 + " as:" + this._audioSource);
            }
            this._audioRecord.release();
            this._audioRecord = null;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 0, localException.getMessage() + " _audioRecord:" + this._audioRecord);
            }
            if (this._audioRecord != null) {
              this._audioRecord.release();
            }
            this._audioRecord = null;
          }
        }
      }
      label543:
      k += 1;
    }
    if (this._audioRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "InitRecording fail!!!");
      }
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, " [Config] InitRecording: audioSession:" + this._sessionId + " audioSource:" + this._audioSource + " rec sample rate set to " + paramInt1 + " recBufSize:" + i + " nRecordLengthMs:" + this.nRecordLengthMs);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "InitRecording exit");
    }
    return this._bufferedRecSamples;
  }
  
  private int InitSetting(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this._audioSourcePolicy = paramInt1;
    this._audioStreamTypePolicy = paramInt2;
    this._modePolicy = paramInt3;
    this._deviceStat = paramInt4;
    this._sceneMode = paramInt5;
    if ((this._deviceStat == 1) || (this._deviceStat == 5) || (this._deviceStat == 2) || (this._deviceStat == 3))
    {
      TraeAudioManager.IsMusicScene = true;
      if ((this._sceneMode != 0) && (this._sceneMode != 4)) {
        break label167;
      }
    }
    label167:
    for (TraeAudioManager.IsEarPhoneSupported = true;; TraeAudioManager.IsEarPhoneSupported = false)
    {
      TraeAudioManager.IsUpdateSceneFlag = true;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy + " DeviceStat:" + paramInt4);
      }
      return 0;
      TraeAudioManager.IsMusicScene = false;
      break;
    }
  }
  
  public static final void LogTraceEntry(String paramString)
  {
    if (!_logEnable) {}
    do
    {
      return;
      paramString = getTraceInfo() + " entry:" + paramString;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 0, paramString);
  }
  
  public static final void LogTraceExit()
  {
    if (!_logEnable) {}
    String str;
    do
    {
      return;
      str = getTraceInfo() + " exit";
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 0, str);
  }
  
  private int OpenMp3File(String paramString, int paramInt1, int paramInt2)
  {
    if (this._traeAudioCodecList.find(paramInt1) == null)
    {
      TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.add(paramInt1);
      localCodecInfo.audioDecoder.setIOPath(paramString);
      localCodecInfo.audioDecoder.setIndex(paramInt1);
      paramInt2 = localCodecInfo.audioDecoder.prepare(paramInt2);
      if (paramInt2 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "openFile mp3 Failed!!!");
        }
        localCodecInfo.audioDecoder.release();
        localCodecInfo.audioDecoder = null;
        this._traeAudioCodecList.remove(paramInt1);
        return paramInt2;
      }
      return 0;
    }
    return -1;
  }
  
  private int OpenslesNeedResetAudioTrack(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (!TraeAudioManager.isCloseSystemAPM(this._modePolicy)) {
          return -1;
        }
        if ((this._audioRouteChanged) || (paramBoolean))
        {
          if ((this._audioManager == null) && (this._context != null)) {
            this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
          }
          if (this._audioManager == null) {
            return 0;
          }
          if ((this._audioManager.getMode() != 0) || (!this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
            continue;
          }
          this._audioStreamTypePolicy = 3;
          this._audioRouteChanged = false;
        }
      }
      catch (Exception localException)
      {
        localException = localException;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TRAE", 0, "PlayAudio Exception: " + localException.getMessage());
        continue;
      }
      finally {}
      return this._audioStreamTypePolicy;
      this._audioStreamTypePolicy = 0;
    }
  }
  
  /* Error */
  private int PlayAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 133	com/tencent/TMG/audio/AudioDeviceInterface:_isPlaying	Z
    //   4: ifne +70 -> 74
    //   7: iconst_1
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   13: ifnonnull +66 -> 79
    //   16: iconst_1
    //   17: istore_3
    //   18: iload_2
    //   19: iload_3
    //   20: ior
    //   21: ifeq +63 -> 84
    //   24: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   27: ifeq +45 -> 72
    //   30: ldc 229
    //   32: iconst_0
    //   33: new 231	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 511
    //   43: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 133	com/tencent/TMG/audio/AudioDeviceInterface:_isPlaying	Z
    //   50: invokevirtual 311	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc_w 513
    //   56: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   63: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: iconst_m1
    //   73: ireturn
    //   74: iconst_0
    //   75: istore_2
    //   76: goto -67 -> 9
    //   79: iconst_0
    //   80: istore_3
    //   81: goto -63 -> 18
    //   84: aload_0
    //   85: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   88: invokevirtual 516	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   91: aload_0
    //   92: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   95: astore 10
    //   97: aload 10
    //   99: ifnonnull +13 -> 112
    //   102: aload_0
    //   103: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   106: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   109: bipush 254
    //   111: ireturn
    //   112: aload_0
    //   113: getfield 127	com/tencent/TMG/audio/AudioDeviceInterface:_doPlayInit	Z
    //   116: istore 7
    //   118: iload 7
    //   120: iconst_1
    //   121: if_icmpne +13 -> 134
    //   124: bipush 237
    //   126: invokestatic 524	android/os/Process:setThreadPriority	(I)V
    //   129: aload_0
    //   130: iconst_0
    //   131: putfield 127	com/tencent/TMG/audio/AudioDeviceInterface:_doPlayInit	Z
    //   134: getstatic 82	com/tencent/TMG/audio/AudioDeviceInterface:_dumpEnable	Z
    //   137: ifeq +27 -> 164
    //   140: aload_0
    //   141: getfield 147	com/tencent/TMG/audio/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   144: astore 10
    //   146: aload 10
    //   148: ifnull +16 -> 164
    //   151: aload_0
    //   152: getfield 147	com/tencent/TMG/audio/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   155: aload_0
    //   156: getfield 211	com/tencent/TMG/audio/AudioDeviceInterface:_tempBufPlay	[B
    //   159: iconst_0
    //   160: iconst_0
    //   161: invokevirtual 530	java/io/FileOutputStream:write	([BII)V
    //   164: aload_0
    //   165: getfield 161	com/tencent/TMG/audio/AudioDeviceInterface:_audioRouteChanged	Z
    //   168: ifne +515 -> 683
    //   171: iconst_0
    //   172: istore_2
    //   173: aload_0
    //   174: getfield 185	com/tencent/TMG/audio/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   177: aload_0
    //   178: getfield 211	com/tencent/TMG/audio/AudioDeviceInterface:_tempBufPlay	[B
    //   181: invokevirtual 534	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   184: pop
    //   185: iload_2
    //   186: ifeq +958 -> 1144
    //   189: aload_0
    //   190: getfield 185	com/tencent/TMG/audio/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   193: invokevirtual 538	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   196: pop
    //   197: invokestatic 544	android/os/SystemClock:elapsedRealtime	()J
    //   200: lstore 8
    //   202: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   205: ifeq +48 -> 253
    //   208: ldc 229
    //   210: iconst_0
    //   211: new 231	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 546
    //   221: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_0
    //   225: getfield 96	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   228: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: ldc_w 548
    //   234: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_0
    //   238: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   241: invokevirtual 400	android/media/AudioTrack:getStreamType	()I
    //   244: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_0
    //   254: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   257: invokevirtual 551	android/media/AudioTrack:getPlayState	()I
    //   260: istore_2
    //   261: iload_2
    //   262: iconst_3
    //   263: if_icmpne +120 -> 383
    //   266: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   269: ifeq +12 -> 281
    //   272: ldc 229
    //   274: iconst_0
    //   275: ldc_w 553
    //   278: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_0
    //   282: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   285: invokevirtual 556	android/media/AudioTrack:stop	()V
    //   288: aload_0
    //   289: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   292: invokevirtual 559	android/media/AudioTrack:flush	()V
    //   295: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   298: ifeq +35 -> 333
    //   301: ldc 229
    //   303: iconst_0
    //   304: new 231	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 561
    //   314: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_0
    //   318: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   321: invokevirtual 551	android/media/AudioTrack:getPlayState	()I
    //   324: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload_0
    //   334: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   337: invokevirtual 327	android/media/AudioTrack:release	()V
    //   340: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   343: ifeq +35 -> 378
    //   346: ldc 229
    //   348: iconst_0
    //   349: new 231	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 563
    //   359: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_0
    //   363: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   366: invokevirtual 551	android/media/AudioTrack:getPlayState	()I
    //   369: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload_0
    //   379: aconst_null
    //   380: putfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   383: aload_0
    //   384: getfield 98	com/tencent/TMG/audio/AudioDeviceInterface:_playSamplerate	I
    //   387: aload_0
    //   388: getfield 100	com/tencent/TMG/audio/AudioDeviceInterface:_channelOutType	I
    //   391: iconst_2
    //   392: invokestatic 320	android/media/AudioTrack:getMinBufferSize	(III)I
    //   395: istore 5
    //   397: iconst_4
    //   398: newarray int
    //   400: astore 10
    //   402: aload 10
    //   404: dup
    //   405: iconst_0
    //   406: iconst_0
    //   407: iastore
    //   408: dup
    //   409: iconst_1
    //   410: iconst_0
    //   411: iastore
    //   412: dup
    //   413: iconst_2
    //   414: iconst_3
    //   415: iastore
    //   416: dup
    //   417: iconst_3
    //   418: iconst_1
    //   419: iastore
    //   420: pop
    //   421: aload 10
    //   423: iconst_0
    //   424: aload_0
    //   425: getfield 96	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   428: iastore
    //   429: aload_0
    //   430: getfield 98	com/tencent/TMG/audio/AudioDeviceInterface:_playSamplerate	I
    //   433: bipush 20
    //   435: imul
    //   436: iconst_1
    //   437: imul
    //   438: iconst_2
    //   439: imul
    //   440: sipush 1000
    //   443: idiv
    //   444: istore_2
    //   445: aload_0
    //   446: getfield 100	com/tencent/TMG/audio/AudioDeviceInterface:_channelOutType	I
    //   449: bipush 12
    //   451: if_icmpne +912 -> 1363
    //   454: iload_2
    //   455: iconst_2
    //   456: imul
    //   457: istore_2
    //   458: goto +905 -> 1363
    //   461: iload_3
    //   462: aload 10
    //   464: arraylength
    //   465: if_icmpge +547 -> 1012
    //   468: aload_0
    //   469: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   472: ifnonnull +540 -> 1012
    //   475: aload_0
    //   476: aload 10
    //   478: iload_3
    //   479: iaload
    //   480: putfield 96	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   483: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   486: ifeq +46 -> 532
    //   489: ldc 229
    //   491: iconst_0
    //   492: new 231	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   499: ldc_w 334
    //   502: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: iload 5
    //   507: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: ldc_w 336
    //   513: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_0
    //   517: getfield 96	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   520: invokestatic 339	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   523: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   526: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: iconst_1
    //   533: istore 4
    //   535: iload 4
    //   537: iconst_2
    //   538: if_icmpgt +830 -> 1368
    //   541: iload 5
    //   543: iload 4
    //   545: imul
    //   546: istore 6
    //   548: iload 6
    //   550: iload_2
    //   551: iconst_4
    //   552: imul
    //   553: if_icmpge +258 -> 811
    //   556: iload 4
    //   558: iconst_2
    //   559: if_icmpge +252 -> 811
    //   562: iload 4
    //   564: iconst_1
    //   565: iadd
    //   566: istore 4
    //   568: goto -33 -> 535
    //   571: astore 10
    //   573: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   576: ifeq -447 -> 129
    //   579: ldc 229
    //   581: iconst_0
    //   582: new 231	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 565
    //   592: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload 10
    //   597: invokevirtual 266	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   600: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: goto -480 -> 129
    //   612: astore 10
    //   614: iconst_0
    //   615: istore_1
    //   616: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   619: ifeq +33 -> 652
    //   622: ldc 229
    //   624: iconst_0
    //   625: new 231	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 504
    //   635: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload 10
    //   640: invokevirtual 266	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   643: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   652: aload_0
    //   653: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   656: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   659: iload_1
    //   660: ireturn
    //   661: astore 10
    //   663: aload 10
    //   665: invokevirtual 568	java/io/IOException:printStackTrace	()V
    //   668: goto -504 -> 164
    //   671: astore 10
    //   673: aload_0
    //   674: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   677: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   680: aload 10
    //   682: athrow
    //   683: aload_0
    //   684: getfield 118	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   687: ifnonnull +27 -> 714
    //   690: aload_0
    //   691: getfield 110	com/tencent/TMG/audio/AudioDeviceInterface:_context	Landroid/content/Context;
    //   694: ifnull +20 -> 714
    //   697: aload_0
    //   698: aload_0
    //   699: getfield 110	com/tencent/TMG/audio/AudioDeviceInterface:_context	Landroid/content/Context;
    //   702: ldc_w 291
    //   705: invokevirtual 297	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   708: checkcast 299	android/media/AudioManager
    //   711: putfield 118	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   714: aload_0
    //   715: getfield 118	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   718: ifnull +55 -> 773
    //   721: aload_0
    //   722: getfield 118	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   725: invokevirtual 348	android/media/AudioManager:getMode	()I
    //   728: ifne +45 -> 773
    //   731: aload_0
    //   732: getfield 159	com/tencent/TMG/audio/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   735: ldc_w 350
    //   738: invokevirtual 356	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   741: ifeq +32 -> 773
    //   744: aload_0
    //   745: iconst_3
    //   746: putfield 96	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   749: aload_0
    //   750: getfield 96	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   753: aload_0
    //   754: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   757: invokevirtual 400	android/media/AudioTrack:getStreamType	()I
    //   760: if_icmpne +21 -> 781
    //   763: iconst_0
    //   764: istore_2
    //   765: aload_0
    //   766: iconst_0
    //   767: putfield 161	com/tencent/TMG/audio/AudioDeviceInterface:_audioRouteChanged	Z
    //   770: goto -597 -> 173
    //   773: aload_0
    //   774: iconst_0
    //   775: putfield 96	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   778: goto -29 -> 749
    //   781: iconst_1
    //   782: istore_2
    //   783: goto -18 -> 765
    //   786: astore 10
    //   788: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   791: ifeq -408 -> 383
    //   794: ldc 229
    //   796: iconst_0
    //   797: ldc_w 570
    //   800: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   803: goto -420 -> 383
    //   806: astore 10
    //   808: goto -192 -> 616
    //   811: aload_0
    //   812: new 316	android/media/AudioTrack
    //   815: dup
    //   816: aload_0
    //   817: getfield 96	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   820: aload_0
    //   821: getfield 98	com/tencent/TMG/audio/AudioDeviceInterface:_playSamplerate	I
    //   824: aload_0
    //   825: getfield 100	com/tencent/TMG/audio/AudioDeviceInterface:_channelOutType	I
    //   828: iconst_2
    //   829: iload 6
    //   831: iconst_1
    //   832: invokespecial 359	android/media/AudioTrack:<init>	(IIIIII)V
    //   835: putfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   838: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   841: ifeq +32 -> 873
    //   844: ldc 229
    //   846: iconst_0
    //   847: new 231	java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   854: ldc_w 368
    //   857: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: aload_0
    //   861: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   864: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   867: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: aload_0
    //   874: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   877: invokevirtual 362	android/media/AudioTrack:getState	()I
    //   880: iconst_1
    //   881: if_icmpeq +487 -> 1368
    //   884: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   887: ifeq +43 -> 930
    //   890: ldc 229
    //   892: iconst_0
    //   893: new 231	java/lang/StringBuilder
    //   896: dup
    //   897: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   900: ldc_w 364
    //   903: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: iload 6
    //   908: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   911: ldc_w 366
    //   914: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: aload_0
    //   918: getfield 98	com/tencent/TMG/audio/AudioDeviceInterface:_playSamplerate	I
    //   921: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   924: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: aload_0
    //   931: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   934: invokevirtual 327	android/media/AudioTrack:release	()V
    //   937: aload_0
    //   938: aconst_null
    //   939: putfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   942: goto -380 -> 562
    //   945: astore 11
    //   947: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   950: ifeq +40 -> 990
    //   953: ldc 229
    //   955: iconst_0
    //   956: new 231	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   963: aload 11
    //   965: invokevirtual 266	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   968: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: ldc_w 368
    //   974: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: aload_0
    //   978: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   981: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   984: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   990: aload_0
    //   991: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   994: ifnull +10 -> 1004
    //   997: aload_0
    //   998: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1001: invokevirtual 327	android/media/AudioTrack:release	()V
    //   1004: aload_0
    //   1005: aconst_null
    //   1006: putfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1009: goto -447 -> 562
    //   1012: aload_0
    //   1013: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1016: astore 10
    //   1018: aload 10
    //   1020: ifnull +57 -> 1077
    //   1023: aload_0
    //   1024: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1027: invokevirtual 573	android/media/AudioTrack:play	()V
    //   1030: aload_0
    //   1031: getfield 155	com/tencent/TMG/audio/AudioDeviceInterface:_as	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   1034: aload_0
    //   1035: getfield 118	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1038: invokevirtual 348	android/media/AudioManager:getMode	()I
    //   1041: aload_0
    //   1042: getfield 96	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   1045: invokevirtual 378	com/tencent/TMG/audio/TraeAudioSession:voiceCallAudioParamChanged	(II)I
    //   1048: pop
    //   1049: aload_0
    //   1050: getfield 118	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1053: astore 10
    //   1055: aload_0
    //   1056: getfield 159	com/tencent/TMG/audio/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   1059: ldc_w 393
    //   1062: invokevirtual 356	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1065: ifeq +68 -> 1133
    //   1068: bipush 6
    //   1070: istore_2
    //   1071: aload 10
    //   1073: iload_2
    //   1074: invokestatic 397	com/tencent/TMG/audio/TraeAudioManager:forceVolumeControlStream	(Landroid/media/AudioManager;I)V
    //   1077: iload_1
    //   1078: istore_2
    //   1079: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1082: ifeq +42 -> 1124
    //   1085: ldc 229
    //   1087: iconst_0
    //   1088: new 231	java/lang/StringBuilder
    //   1091: dup
    //   1092: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1095: ldc_w 575
    //   1098: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: invokestatic 544	android/os/SystemClock:elapsedRealtime	()J
    //   1104: lload 8
    //   1106: lsub
    //   1107: invokevirtual 578	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1110: ldc_w 580
    //   1113: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1122: iload_1
    //   1123: istore_2
    //   1124: aload_0
    //   1125: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1128: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1131: iload_2
    //   1132: ireturn
    //   1133: aload_0
    //   1134: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1137: invokevirtual 400	android/media/AudioTrack:getStreamType	()I
    //   1140: istore_2
    //   1141: goto -70 -> 1071
    //   1144: aload_0
    //   1145: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1148: aload_0
    //   1149: getfield 211	com/tencent/TMG/audio/AudioDeviceInterface:_tempBufPlay	[B
    //   1152: iconst_0
    //   1153: iload_1
    //   1154: invokevirtual 583	android/media/AudioTrack:write	([BII)I
    //   1157: istore_2
    //   1158: aload_0
    //   1159: getfield 185	com/tencent/TMG/audio/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   1162: invokevirtual 538	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1165: pop
    //   1166: iload_2
    //   1167: ifge +60 -> 1227
    //   1170: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1173: ifeq +45 -> 1218
    //   1176: ldc 229
    //   1178: iconst_0
    //   1179: new 231	java/lang/StringBuilder
    //   1182: dup
    //   1183: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1186: ldc_w 585
    //   1189: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: iload_2
    //   1193: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1196: ldc_w 587
    //   1199: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: iload_1
    //   1203: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1206: ldc_w 589
    //   1209: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1215: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1218: aload_0
    //   1219: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1222: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1225: iconst_m1
    //   1226: ireturn
    //   1227: iload_2
    //   1228: iload_1
    //   1229: if_icmpeq +51 -> 1280
    //   1232: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1235: ifeq +45 -> 1280
    //   1238: ldc 229
    //   1240: iconst_0
    //   1241: new 231	java/lang/StringBuilder
    //   1244: dup
    //   1245: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   1248: ldc_w 591
    //   1251: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: iload_2
    //   1255: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1258: ldc_w 587
    //   1261: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: iload_1
    //   1265: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1268: ldc_w 589
    //   1271: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1277: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1280: aload_0
    //   1281: aload_0
    //   1282: getfield 137	com/tencent/TMG/audio/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1285: iload_2
    //   1286: iconst_1
    //   1287: ishr
    //   1288: iadd
    //   1289: putfield 137	com/tencent/TMG/audio/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1292: aload_0
    //   1293: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1296: invokevirtual 381	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   1299: istore_1
    //   1300: iload_1
    //   1301: aload_0
    //   1302: getfield 139	com/tencent/TMG/audio/AudioDeviceInterface:_playPosition	I
    //   1305: if_icmpge +8 -> 1313
    //   1308: aload_0
    //   1309: iconst_0
    //   1310: putfield 139	com/tencent/TMG/audio/AudioDeviceInterface:_playPosition	I
    //   1313: aload_0
    //   1314: aload_0
    //   1315: getfield 137	com/tencent/TMG/audio/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1318: iload_1
    //   1319: aload_0
    //   1320: getfield 139	com/tencent/TMG/audio/AudioDeviceInterface:_playPosition	I
    //   1323: isub
    //   1324: isub
    //   1325: putfield 137	com/tencent/TMG/audio/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1328: aload_0
    //   1329: iload_1
    //   1330: putfield 139	com/tencent/TMG/audio/AudioDeviceInterface:_playPosition	I
    //   1333: aload_0
    //   1334: getfield 131	com/tencent/TMG/audio/AudioDeviceInterface:_isRecording	Z
    //   1337: ifne +23 -> 1360
    //   1340: aload_0
    //   1341: getfield 137	com/tencent/TMG/audio/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1344: istore_1
    //   1345: goto -221 -> 1124
    //   1348: astore 10
    //   1350: iload_2
    //   1351: istore_1
    //   1352: goto -736 -> 616
    //   1355: astore 10
    //   1357: goto -280 -> 1077
    //   1360: goto -236 -> 1124
    //   1363: iconst_0
    //   1364: istore_3
    //   1365: goto -904 -> 461
    //   1368: iload_3
    //   1369: iconst_1
    //   1370: iadd
    //   1371: istore_3
    //   1372: goto -911 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1375	0	this	AudioDeviceInterface
    //   0	1375	1	paramInt	int
    //   8	1343	2	i	int
    //   17	1355	3	j	int
    //   533	34	4	k	int
    //   395	151	5	m	int
    //   546	361	6	n	int
    //   116	6	7	bool	boolean
    //   200	905	8	l	long
    //   95	382	10	localObject1	Object
    //   571	25	10	localException1	Exception
    //   612	27	10	localException2	Exception
    //   661	3	10	localIOException	java.io.IOException
    //   671	10	10	localObject2	Object
    //   786	1	10	localIllegalStateException	java.lang.IllegalStateException
    //   806	1	10	localException3	Exception
    //   1016	56	10	localObject3	Object
    //   1348	1	10	localException4	Exception
    //   1355	1	10	localException5	Exception
    //   945	19	11	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   124	129	571	java/lang/Exception
    //   91	97	612	java/lang/Exception
    //   112	118	612	java/lang/Exception
    //   129	134	612	java/lang/Exception
    //   134	146	612	java/lang/Exception
    //   151	164	612	java/lang/Exception
    //   164	171	612	java/lang/Exception
    //   173	185	612	java/lang/Exception
    //   573	609	612	java/lang/Exception
    //   663	668	612	java/lang/Exception
    //   683	714	612	java/lang/Exception
    //   714	749	612	java/lang/Exception
    //   749	763	612	java/lang/Exception
    //   765	770	612	java/lang/Exception
    //   773	778	612	java/lang/Exception
    //   1144	1158	612	java/lang/Exception
    //   151	164	661	java/io/IOException
    //   91	97	671	finally
    //   112	118	671	finally
    //   124	129	671	finally
    //   129	134	671	finally
    //   134	146	671	finally
    //   151	164	671	finally
    //   164	171	671	finally
    //   173	185	671	finally
    //   189	253	671	finally
    //   253	261	671	finally
    //   266	281	671	finally
    //   281	333	671	finally
    //   333	378	671	finally
    //   378	383	671	finally
    //   383	454	671	finally
    //   461	532	671	finally
    //   573	609	671	finally
    //   616	652	671	finally
    //   663	668	671	finally
    //   683	714	671	finally
    //   714	749	671	finally
    //   749	763	671	finally
    //   765	770	671	finally
    //   773	778	671	finally
    //   788	803	671	finally
    //   811	838	671	finally
    //   838	873	671	finally
    //   873	930	671	finally
    //   930	942	671	finally
    //   947	990	671	finally
    //   990	1004	671	finally
    //   1004	1009	671	finally
    //   1012	1018	671	finally
    //   1023	1068	671	finally
    //   1071	1077	671	finally
    //   1079	1122	671	finally
    //   1133	1141	671	finally
    //   1144	1158	671	finally
    //   1158	1166	671	finally
    //   1170	1218	671	finally
    //   1232	1280	671	finally
    //   1280	1313	671	finally
    //   1313	1345	671	finally
    //   266	281	786	java/lang/IllegalStateException
    //   281	333	786	java/lang/IllegalStateException
    //   333	378	786	java/lang/IllegalStateException
    //   378	383	786	java/lang/IllegalStateException
    //   189	253	806	java/lang/Exception
    //   253	261	806	java/lang/Exception
    //   266	281	806	java/lang/Exception
    //   281	333	806	java/lang/Exception
    //   333	378	806	java/lang/Exception
    //   378	383	806	java/lang/Exception
    //   383	454	806	java/lang/Exception
    //   461	532	806	java/lang/Exception
    //   788	803	806	java/lang/Exception
    //   838	873	806	java/lang/Exception
    //   873	930	806	java/lang/Exception
    //   930	942	806	java/lang/Exception
    //   947	990	806	java/lang/Exception
    //   990	1004	806	java/lang/Exception
    //   1004	1009	806	java/lang/Exception
    //   1012	1018	806	java/lang/Exception
    //   1079	1122	806	java/lang/Exception
    //   811	838	945	java/lang/Exception
    //   1158	1166	1348	java/lang/Exception
    //   1170	1218	1348	java/lang/Exception
    //   1232	1280	1348	java/lang/Exception
    //   1280	1313	1348	java/lang/Exception
    //   1313	1345	1348	java/lang/Exception
    //   1023	1068	1355	java/lang/Exception
    //   1071	1077	1355	java/lang/Exception
    //   1133	1141	1355	java/lang/Exception
  }
  
  private int ReadMp3File(int paramInt)
  {
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    ByteBuffer localByteBuffer;
    if (localCodecInfo != null)
    {
      localByteBuffer = getDecBuffer(paramInt);
      if (localByteBuffer != null) {}
    }
    else
    {
      return -1;
    }
    localByteBuffer.rewind();
    paramInt = localCodecInfo.audioDecoder.getFrameSize();
    int i = localCodecInfo.audioDecoder.ReadOneFrame(localCodecInfo._tempBufdec, paramInt);
    localByteBuffer.put(localCodecInfo._tempBufdec, 0, paramInt);
    return i;
  }
  
  /* Error */
  private int RecordAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 131	com/tencent/TMG/audio/AudioDeviceInterface:_isRecording	Z
    //   4: ifne +40 -> 44
    //   7: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   10: ifeq +32 -> 42
    //   13: ldc 229
    //   15: iconst_0
    //   16: new 231	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 612
    //   26: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 131	com/tencent/TMG/audio/AudioDeviceInterface:_isRecording	Z
    //   33: invokevirtual 311	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: iconst_m1
    //   43: ireturn
    //   44: aload_0
    //   45: getfield 125	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   48: invokevirtual 516	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   51: aload_0
    //   52: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   55: astore 4
    //   57: aload 4
    //   59: ifnonnull +13 -> 72
    //   62: aload_0
    //   63: getfield 125	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   66: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   69: bipush 254
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 129	com/tencent/TMG/audio/AudioDeviceInterface:_doRecInit	Z
    //   76: istore_3
    //   77: iload_3
    //   78: iconst_1
    //   79: if_icmpne +13 -> 92
    //   82: bipush 237
    //   84: invokestatic 524	android/os/Process:setThreadPriority	(I)V
    //   87: aload_0
    //   88: iconst_0
    //   89: putfield 129	com/tencent/TMG/audio/AudioDeviceInterface:_doRecInit	Z
    //   92: aload_0
    //   93: getfield 187	com/tencent/TMG/audio/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   96: invokevirtual 538	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   99: pop
    //   100: aload_0
    //   101: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   104: aload_0
    //   105: getfield 213	com/tencent/TMG/audio/AudioDeviceInterface:_tempBufRec	[B
    //   108: iconst_0
    //   109: iload_1
    //   110: invokevirtual 615	android/media/AudioRecord:read	([BII)I
    //   113: istore_2
    //   114: iload_2
    //   115: ifge +150 -> 265
    //   118: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   121: ifeq +45 -> 166
    //   124: ldc 229
    //   126: iconst_0
    //   127: new 231	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 617
    //   137: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload_2
    //   141: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: ldc_w 587
    //   147: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_1
    //   151: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: ldc_w 589
    //   157: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_0
    //   167: getfield 125	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   170: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   173: iconst_m1
    //   174: ireturn
    //   175: astore 4
    //   177: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   180: ifeq -93 -> 87
    //   183: ldc 229
    //   185: iconst_0
    //   186: new 231	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 619
    //   196: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload 4
    //   201: invokevirtual 266	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   204: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: goto -126 -> 87
    //   216: astore 4
    //   218: iconst_0
    //   219: istore_2
    //   220: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   223: ifeq +33 -> 256
    //   226: ldc 229
    //   228: iconst_0
    //   229: new 231	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 621
    //   239: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 4
    //   244: invokevirtual 266	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   247: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: aload_0
    //   257: getfield 125	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   260: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   263: iload_2
    //   264: ireturn
    //   265: aload_0
    //   266: getfield 187	com/tencent/TMG/audio/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   269: aload_0
    //   270: getfield 213	com/tencent/TMG/audio/AudioDeviceInterface:_tempBufRec	[B
    //   273: iconst_0
    //   274: iload_2
    //   275: invokevirtual 609	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   278: pop
    //   279: getstatic 82	com/tencent/TMG/audio/AudioDeviceInterface:_dumpEnable	Z
    //   282: ifeq +27 -> 309
    //   285: aload_0
    //   286: getfield 145	com/tencent/TMG/audio/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   289: astore 4
    //   291: aload 4
    //   293: ifnull +16 -> 309
    //   296: aload_0
    //   297: getfield 145	com/tencent/TMG/audio/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   300: aload_0
    //   301: getfield 213	com/tencent/TMG/audio/AudioDeviceInterface:_tempBufRec	[B
    //   304: iconst_0
    //   305: iload_2
    //   306: invokevirtual 530	java/io/FileOutputStream:write	([BII)V
    //   309: iload_2
    //   310: iload_1
    //   311: if_icmpeq +75 -> 386
    //   314: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   317: ifeq +45 -> 362
    //   320: ldc 229
    //   322: iconst_0
    //   323: new 231	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   330: ldc_w 623
    //   333: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: iload_2
    //   337: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: ldc_w 587
    //   343: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload_1
    //   347: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: ldc_w 589
    //   353: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload_0
    //   363: getfield 125	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   366: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   369: iconst_m1
    //   370: ireturn
    //   371: astore 4
    //   373: aload 4
    //   375: invokevirtual 568	java/io/IOException:printStackTrace	()V
    //   378: goto -69 -> 309
    //   381: astore 4
    //   383: goto -163 -> 220
    //   386: aload_0
    //   387: getfield 125	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   390: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   393: iload_2
    //   394: ireturn
    //   395: astore 4
    //   397: aload_0
    //   398: getfield 125	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   401: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   404: aload 4
    //   406: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	AudioDeviceInterface
    //   0	407	1	paramInt	int
    //   113	281	2	i	int
    //   76	4	3	bool	boolean
    //   55	3	4	localAudioRecord	AudioRecord
    //   175	25	4	localException1	Exception
    //   216	27	4	localException2	Exception
    //   289	3	4	localFileOutputStream	FileOutputStream
    //   371	3	4	localIOException	java.io.IOException
    //   381	1	4	localException3	Exception
    //   395	10	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   82	87	175	java/lang/Exception
    //   51	57	216	java/lang/Exception
    //   72	77	216	java/lang/Exception
    //   87	92	216	java/lang/Exception
    //   92	114	216	java/lang/Exception
    //   177	213	216	java/lang/Exception
    //   296	309	371	java/io/IOException
    //   118	166	381	java/lang/Exception
    //   265	291	381	java/lang/Exception
    //   296	309	381	java/lang/Exception
    //   314	362	381	java/lang/Exception
    //   373	378	381	java/lang/Exception
    //   51	57	395	finally
    //   72	77	395	finally
    //   82	87	395	finally
    //   87	92	395	finally
    //   92	114	395	finally
    //   118	166	395	finally
    //   177	213	395	finally
    //   220	256	395	finally
    //   265	291	395	finally
    //   296	309	395	finally
    //   314	362	395	finally
    //   373	378	395	finally
  }
  
  private int SeekMp3To(int paramInt1, int paramInt2)
  {
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt1);
    if (localCodecInfo != null) {
      return localCodecInfo.audioDecoder.SeekTo(paramInt2);
    }
    return 0;
  }
  
  private int SetPlayoutVolume(int paramInt)
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null)
    {
      this._audioManager.setStreamVolume(0, paramInt, 0);
      i = 0;
    }
    return i;
  }
  
  /* Error */
  private int StartPlayback()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 133	com/tencent/TMG/audio/AudioDeviceInterface:_isPlaying	Z
    //   6: ifeq +20 -> 26
    //   9: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 229
    //   17: iconst_0
    //   18: ldc_w 637
    //   21: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   30: ifnonnull +40 -> 70
    //   33: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   36: ifeq -12 -> 24
    //   39: ldc 229
    //   41: iconst_0
    //   42: new 231	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 639
    //   52: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   59: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: iconst_m1
    //   69: ireturn
    //   70: aload_0
    //   71: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   74: invokevirtual 573	android/media/AudioTrack:play	()V
    //   77: getstatic 82	com/tencent/TMG/audio/AudioDeviceInterface:_dumpEnable	Z
    //   80: ifeq +52 -> 132
    //   83: aload_0
    //   84: getfield 118	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   87: ifnull +11 -> 98
    //   90: aload_0
    //   91: getfield 118	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   94: invokevirtual 348	android/media/AudioManager:getMode	()I
    //   97: istore_1
    //   98: aload_0
    //   99: new 641	java/io/File
    //   102: dup
    //   103: aload_0
    //   104: ldc_w 643
    //   107: iload_1
    //   108: invokespecial 647	com/tencent/TMG/audio/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   111: invokespecial 649	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: putfield 143	com/tencent/TMG/audio/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   117: aload_0
    //   118: new 526	java/io/FileOutputStream
    //   121: dup
    //   122: aload_0
    //   123: getfield 143	com/tencent/TMG/audio/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   126: invokespecial 652	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   129: putfield 147	com/tencent/TMG/audio/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   132: aload_0
    //   133: iconst_1
    //   134: putfield 133	com/tencent/TMG/audio/AudioDeviceInterface:_isPlaying	Z
    //   137: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   140: ifeq +12 -> 152
    //   143: ldc 229
    //   145: iconst_0
    //   146: ldc_w 654
    //   149: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_2
    //   155: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   158: ifeq +12 -> 170
    //   161: ldc 229
    //   163: iconst_0
    //   164: ldc_w 656
    //   167: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_2
    //   171: invokevirtual 657	java/lang/IllegalStateException:printStackTrace	()V
    //   174: iconst_m1
    //   175: ireturn
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 658	java/io/FileNotFoundException:printStackTrace	()V
    //   181: goto -49 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	AudioDeviceInterface
    //   1	107	1	i	int
    //   154	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   176	2	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   70	77	154	java/lang/IllegalStateException
    //   117	132	176	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StartRecording()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 229
    //   10: iconst_0
    //   11: ldc_w 661
    //   14: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 131	com/tencent/TMG/audio/AudioDeviceInterface:_isRecording	Z
    //   21: ifeq +40 -> 61
    //   24: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   27: ifeq +32 -> 59
    //   30: ldc 229
    //   32: iconst_0
    //   33: new 231	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 663
    //   43: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 131	com/tencent/TMG/audio/AudioDeviceInterface:_isRecording	Z
    //   50: invokevirtual 311	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iconst_m1
    //   60: ireturn
    //   61: aload_0
    //   62: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   65: ifnonnull +40 -> 105
    //   68: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   71: ifeq -12 -> 59
    //   74: ldc 229
    //   76: iconst_0
    //   77: new 231	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 665
    //   87: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   94: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iconst_m1
    //   104: ireturn
    //   105: aload_0
    //   106: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   109: invokevirtual 668	android/media/AudioRecord:startRecording	()V
    //   112: getstatic 82	com/tencent/TMG/audio/AudioDeviceInterface:_dumpEnable	Z
    //   115: ifeq +52 -> 167
    //   118: aload_0
    //   119: getfield 118	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   122: ifnull +11 -> 133
    //   125: aload_0
    //   126: getfield 118	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   129: invokevirtual 348	android/media/AudioManager:getMode	()I
    //   132: istore_1
    //   133: aload_0
    //   134: new 641	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: ldc_w 670
    //   142: iload_1
    //   143: invokespecial 647	com/tencent/TMG/audio/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   146: invokespecial 649	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: putfield 141	com/tencent/TMG/audio/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   152: aload_0
    //   153: new 526	java/io/FileOutputStream
    //   156: dup
    //   157: aload_0
    //   158: getfield 141	com/tencent/TMG/audio/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   161: invokespecial 652	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: putfield 145	com/tencent/TMG/audio/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   167: aload_0
    //   168: iconst_1
    //   169: putfield 131	com/tencent/TMG/audio/AudioDeviceInterface:_isRecording	Z
    //   172: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   175: ifeq +12 -> 187
    //   178: ldc 229
    //   180: iconst_0
    //   181: ldc_w 672
    //   184: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_2
    //   190: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   193: ifeq +12 -> 205
    //   196: ldc 229
    //   198: iconst_0
    //   199: ldc_w 674
    //   202: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_2
    //   206: invokevirtual 657	java/lang/IllegalStateException:printStackTrace	()V
    //   209: iconst_m1
    //   210: ireturn
    //   211: astore_2
    //   212: aload_2
    //   213: invokevirtual 658	java/io/FileNotFoundException:printStackTrace	()V
    //   216: goto -49 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	AudioDeviceInterface
    //   1	142	1	i	int
    //   189	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   211	2	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   105	112	189	java/lang/IllegalStateException
    //   152	167	211	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StopPlayback()
  {
    // Byte code:
    //   0: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   3: ifeq +32 -> 35
    //   6: ldc 229
    //   8: iconst_0
    //   9: new 231	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 677
    //   19: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 133	com/tencent/TMG/audio/AudioDeviceInterface:_isPlaying	Z
    //   26: invokevirtual 311	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   39: ifnonnull +53 -> 92
    //   42: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   45: ifeq +45 -> 90
    //   48: ldc 229
    //   50: iconst_0
    //   51: new 231	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 679
    //   61: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: getfield 133	com/tencent/TMG/audio/AudioDeviceInterface:_isPlaying	Z
    //   68: invokevirtual 311	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   71: ldc_w 513
    //   74: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   81: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_m1
    //   91: ireturn
    //   92: aload_0
    //   93: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   96: invokevirtual 516	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   99: aload_0
    //   100: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   103: invokevirtual 551	android/media/AudioTrack:getPlayState	()I
    //   106: istore_1
    //   107: iload_1
    //   108: iconst_3
    //   109: if_icmpne +70 -> 179
    //   112: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   115: ifeq +12 -> 127
    //   118: ldc 229
    //   120: iconst_0
    //   121: ldc_w 553
    //   124: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload_0
    //   128: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   131: invokevirtual 556	android/media/AudioTrack:stop	()V
    //   134: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   137: ifeq +35 -> 172
    //   140: ldc 229
    //   142: iconst_0
    //   143: new 231	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 561
    //   153: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   160: invokevirtual 551	android/media/AudioTrack:getPlayState	()I
    //   163: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   176: invokevirtual 559	android/media/AudioTrack:flush	()V
    //   179: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   182: ifeq +35 -> 217
    //   185: ldc 229
    //   187: iconst_0
    //   188: new 231	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 563
    //   198: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   205: invokevirtual 551	android/media/AudioTrack:getPlayState	()I
    //   208: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_0
    //   218: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   221: invokevirtual 327	android/media/AudioTrack:release	()V
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   229: aload_0
    //   230: iconst_0
    //   231: putfield 133	com/tencent/TMG/audio/AudioDeviceInterface:_isPlaying	Z
    //   234: aload_0
    //   235: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   238: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   241: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   244: ifeq +12 -> 256
    //   247: ldc 229
    //   249: iconst_0
    //   250: ldc_w 681
    //   253: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: iconst_0
    //   257: ireturn
    //   258: astore_2
    //   259: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   262: ifeq +12 -> 274
    //   265: ldc 229
    //   267: iconst_0
    //   268: ldc_w 570
    //   271: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_2
    //   275: invokevirtual 657	java/lang/IllegalStateException:printStackTrace	()V
    //   278: aload_0
    //   279: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   282: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   285: iconst_m1
    //   286: ireturn
    //   287: astore_2
    //   288: aload_0
    //   289: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   292: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   295: aload_2
    //   296: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	AudioDeviceInterface
    //   106	4	1	i	int
    //   258	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   287	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   112	127	258	java/lang/IllegalStateException
    //   127	134	258	java/lang/IllegalStateException
    //   99	107	287	finally
    //   112	127	287	finally
    //   127	134	287	finally
    //   134	172	287	finally
    //   172	179	287	finally
    //   179	217	287	finally
    //   217	234	287	finally
    //   259	274	287	finally
    //   274	278	287	finally
  }
  
  /* Error */
  private int StopRecording()
  {
    // Byte code:
    //   0: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 229
    //   8: iconst_0
    //   9: ldc_w 684
    //   12: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   19: ifnonnull +40 -> 59
    //   22: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   25: ifeq +32 -> 57
    //   28: ldc 229
    //   30: iconst_0
    //   31: new 231	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 686
    //   41: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   48: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iconst_m1
    //   58: ireturn
    //   59: aload_0
    //   60: getfield 125	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   63: invokevirtual 516	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   66: aload_0
    //   67: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   70: invokevirtual 689	android/media/AudioRecord:getRecordingState	()I
    //   73: istore_1
    //   74: iload_1
    //   75: iconst_3
    //   76: if_icmpne +48 -> 124
    //   79: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   82: ifeq +35 -> 117
    //   85: ldc 229
    //   87: iconst_0
    //   88: new 231	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 691
    //   98: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   105: invokevirtual 689	android/media/AudioRecord:getRecordingState	()I
    //   108: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_0
    //   118: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   121: invokevirtual 692	android/media/AudioRecord:stop	()V
    //   124: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   127: ifeq +35 -> 162
    //   130: ldc 229
    //   132: iconst_0
    //   133: new 231	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 694
    //   143: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   150: invokevirtual 689	android/media/AudioRecord:getRecordingState	()I
    //   153: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   166: invokevirtual 423	android/media/AudioRecord:release	()V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 131	com/tencent/TMG/audio/AudioDeviceInterface:_isRecording	Z
    //   179: aload_0
    //   180: getfield 125	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   183: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   186: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   189: ifeq +12 -> 201
    //   192: ldc 229
    //   194: iconst_0
    //   195: ldc_w 696
    //   198: invokestatic 249	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_2
    //   204: invokestatic 227	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   207: ifeq +12 -> 219
    //   210: ldc 229
    //   212: iconst_0
    //   213: ldc_w 698
    //   216: invokestatic 314	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_2
    //   220: invokevirtual 657	java/lang/IllegalStateException:printStackTrace	()V
    //   223: aload_0
    //   224: getfield 125	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   227: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   230: iconst_m1
    //   231: ireturn
    //   232: astore_2
    //   233: aload_0
    //   234: getfield 125	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   237: invokevirtual 519	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   240: aload_2
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	AudioDeviceInterface
    //   73	4	1	i	int
    //   203	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   232	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   79	117	203	java/lang/IllegalStateException
    //   117	124	203	java/lang/IllegalStateException
    //   66	74	232	finally
    //   79	117	232	finally
    //   117	124	232	finally
    //   124	162	232	finally
    //   162	179	232	finally
    //   204	219	232	finally
    //   219	223	232	finally
  }
  
  private int getAndroidSdkVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  @TargetApi(16)
  private int getAudioSessionId(AudioRecord paramAudioRecord)
  {
    return 0;
  }
  
  private ByteBuffer getDecBuffer(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.w("TRAE", 0, "getDecBuffer failed!! index:" + paramInt);
      return null;
    case 0: 
      return this._decBuffer0;
    case 1: 
      return this._decBuffer1;
    case 2: 
      return this._decBuffer2;
    case 3: 
      return this._decBuffer3;
    case 4: 
      return this._decBuffer4;
    case 5: 
      return this._decBuffer5;
    case 6: 
      return this._decBuffer6;
    case 7: 
      return this._decBuffer7;
    case 8: 
      return this._decBuffer8;
    case 9: 
      return this._decBuffer9;
    }
    return this._decBuffer10;
  }
  
  private String getDumpFilePath(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "manufacture:" + Build.MANUFACTURER);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "MODEL:" + Build.MODEL);
    }
    paramString = Environment.getExternalStorageDirectory().getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-as-" + TraeAudioManager.getAudioSource(this._audioSourcePolicy) + "-st-" + this._streamType + "-m-" + paramInt + "-" + paramString;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "dump:" + paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "dump replace:" + paramString.replace(" ", "_"));
    }
    return paramString.replace(" ", "_");
  }
  
  private int getLowlatencyFramesPerBuffer()
  {
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
      return 0;
    }
    boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("LOW_LATENCY:");
      if (bool != true) {
        break label146;
      }
    }
    label146:
    for (String str = "Y";; str = "N")
    {
      QLog.w("TRAE", 0, str);
      if ((Build.VERSION.SDK_INT >= 17) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("TRAE", 0, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
      return 0;
    }
  }
  
  private int getLowlatencySamplerate()
  {
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9)) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
    }
    label146:
    label153:
    do
    {
      return 0;
      boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("LOW_LATENCY:");
        if (bool != true) {
          break label146;
        }
      }
      for (String str = "Y";; str = "N")
      {
        QLog.w("TRAE", 0, str);
        if (Build.VERSION.SDK_INT >= 17) {
          break label153;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("TRAE", 0, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
        return 0;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 0, "getLowlatencySamplerate not support right now!");
    return 0;
  }
  
  private int getMp3Channels(int paramInt)
  {
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null) {
      return localCodecInfo.audioDecoder.getChannels();
    }
    return -1;
  }
  
  private long getMp3FileTotalMs(int paramInt)
  {
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null) {
      return localCodecInfo.audioDecoder.getFileTotalMs();
    }
    return -1L;
  }
  
  private int getMp3SampleRate(int paramInt)
  {
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null) {
      return localCodecInfo.audioDecoder.getSampleRate();
    }
    return -1;
  }
  
  private int getPlayRecordSysBufferMs()
  {
    return (this.nRecordLengthMs + this.nPlayLengthMs) * 2;
  }
  
  public static String getTraceInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int i = arrayOfStackTraceElement.length;
    localStringBuffer.append("").append(arrayOfStackTraceElement[2].getClassName()).append(".").append(arrayOfStackTraceElement[2].getMethodName()).append(": ").append(arrayOfStackTraceElement[2].getLineNumber());
    return localStringBuffer.toString();
  }
  
  private void initTRAEAudioManager()
  {
    if (this._context != null)
    {
      TraeAudioManager.init(this._context);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "initTRAEAudioManager , TraeAudioSession create");
      }
      if (this._asAudioManager == null) {
        this._asAudioManager = new TraeAudioSession(this._context, new AudioDeviceInterface.3(this));
      }
    }
  }
  
  private void onOutputChanage(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, " onOutputChanage:" + paramString);
    }
    setAudioRouteSwitchState(paramString);
    if (!TraeAudioManager.isCloseSystemAPM(this._modePolicy)) {}
    while ((this._deviceStat == 1) || (this._deviceStat == 5) || (this._deviceStat == 2) || (this._deviceStat == 3)) {
      return;
    }
    this._connectedDev = paramString;
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(" onOutputChanage:").append(paramString);
      if (this._audioManager != null) {
        break label271;
      }
      localObject = " am==null";
      localStringBuilder = localStringBuilder.append((String)localObject).append(" st:").append(this._streamType);
      if (this._audioTrack != null) {
        break label301;
      }
      localObject = "_audioTrack==null";
      label150:
      QLog.w("TRAE", 0, (String)localObject);
    }
    for (;;)
    {
      try
      {
        if (this._audioManager == null) {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append(" curr mode:").append(paramString);
          if (this._audioManager != null) {
            continue;
          }
          paramString = "am==null";
          QLog.w("TRAE", 0, paramString);
        }
        if ((this._audioManager != null) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
          this._audioManager.setMode(0);
        }
      }
      catch (Exception paramString)
      {
        label271:
        label301:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TRAE", 0, paramString.getMessage());
        continue;
      }
      this._audioRouteChanged = true;
      return;
      localObject = " mode:" + this._audioManager.getMode();
      break;
      localObject = " at.st:" + this._audioTrack.getStreamType();
      break label150;
      paramString = " mode:" + this._audioManager.getMode();
    }
  }
  
  private void setAudioRouteSwitchState(String paramString)
  {
    if (paramString.equals("DEVICE_EARPHONE"))
    {
      this.switchState = 1;
      return;
    }
    if (paramString.equals("DEVICE_SPEAKERPHONE"))
    {
      this.switchState = 2;
      return;
    }
    if (paramString.equals("DEVICE_WIREDHEADSET"))
    {
      this.switchState = 3;
      return;
    }
    if (paramString.equals("DEVICE_BLUETOOTHHEADSET"))
    {
      this.switchState = 4;
      return;
    }
    this.switchState = 0;
  }
  
  private int startService(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "initTRAEAudioManager , TraeAudioSession startService: " + this._asAudioManager + " deviceConfig:" + paramString);
    }
    if (this._asAudioManager != null) {
      return this._asAudioManager.startService(paramString);
    }
    return -1;
  }
  
  private int stopService()
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "initTRAEAudioManager , TraeAudioSession stopService: " + this._asAudioManager);
    }
    if (this._asAudioManager != null) {
      return this._asAudioManager.stopService();
    }
    return -1;
  }
  
  private void uninitTRAEAudioManager()
  {
    if (this._context != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "uninitTRAEAudioManager , stopService");
      }
      if (this._asAudioManager != null)
      {
        this._asAudioManager.release();
        this._asAudioManager = null;
      }
      TraeAudioManager.uninit();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TRAE", 0, "uninitTRAEAudioManager , context null");
  }
  
  public int call_postprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    if (this._as != null)
    {
      this._as.voiceCallPostprocess();
      this._as.release();
      this._as = null;
    }
    TraeAudioManager.IsUpdateSceneFlag = false;
    LogTraceExit();
    return 0;
  }
  
  public int call_postprocess_media()
  {
    LogTraceEntry("");
    this.switchState = 0;
    if (this._as != null)
    {
      this._as.release();
      this._as = null;
    }
    TraeAudioManager.IsUpdateSceneFlag = false;
    LogTraceExit();
    return 0;
  }
  
  public int call_preprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
    if (this._as == null) {
      this._as = new TraeAudioSession(this._context, new AudioDeviceInterface.1(this));
    }
    this._preDone = false;
    if (this._as != null) {
      this._prelock.lock();
    }
    int i;
    int j;
    label370:
    for (;;)
    {
      try
      {
        if (this._audioManager == null) {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        if (this._audioManager != null)
        {
          if (this._audioManager.getMode() == 2)
          {
            i = 5;
            if ((i > 0) && (this._audioManager.getMode() == 2))
            {
              if (QLog.isColorLevel()) {
                QLog.e("TRAE", 0, "call_preprocess waiting...  mode:" + this._audioManager.getMode());
              }
              Thread.sleep(500L);
              i -= 1;
              continue;
            }
          }
          if (this._audioManager.isMicrophoneMute())
          {
            this._audioManager.setMicrophoneMute(false);
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 0, "media call_preprocess setMicrophoneMute false");
            }
          }
        }
        this._as.voiceCallPreprocess(this._modePolicy, this._streamType);
        this._as.connectHighestPriorityDevice();
        i = 7;
        j = i - 1;
        if (i <= 0) {}
      }
      catch (InterruptedException localInterruptedException1)
      {
        this._prelock.unlock();
        continue;
      }
      finally
      {
        this._prelock.unlock();
      }
      try
      {
        if (!this._preDone)
        {
          this._precon.await(1L, TimeUnit.SECONDS);
          if (!QLog.isColorLevel()) {
            break label370;
          }
          QLog.e("TRAE", 0, "call_preprocess waiting...  as:" + this._as);
          i = j;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, "call_preprocess done!");
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        continue;
        i = j;
      }
      this._as.getConnectedDevice();
      this._prelock.unlock();
      LogTraceExit();
      return 0;
    }
  }
  
  public int call_preprocess_media()
  {
    LogTraceEntry("");
    this.switchState = 0;
    if (this._as == null) {
      this._as = new TraeAudioSession(this._context, new AudioDeviceInterface.2(this));
    }
    if (this._as != null) {}
    try
    {
      if (this._audioManager == null) {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
      }
      if (this._audioManager != null)
      {
        if (this._audioManager.getMode() == 2)
        {
          int i = 5;
          while ((i > 0) && (this._audioManager.getMode() == 2))
          {
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 0, "media call_preprocess_media waiting...  mode:" + this._audioManager.getMode());
            }
            Thread.sleep(500L);
            i -= 1;
          }
        }
        if (this._audioManager.getMode() != 0) {
          this._audioManager.setMode(0);
        }
        if (this._audioManager.isMicrophoneMute())
        {
          this._audioManager.setMicrophoneMute(false);
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 0, "media call_preprocess_media setMicrophoneMute false");
          }
        }
      }
      this._as.connectHighestPriorityDevice();
      this._as.getConnectedDevice();
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "call_preprocess_media done!");
      }
      label240:
      LogTraceExit();
    }
    catch (InterruptedException localInterruptedException)
    {
      break label240;
    }
    return 0;
  }
  
  public int getAudioRouteSwitchState()
  {
    return this.switchState;
  }
  
  public void setContext(Context paramContext)
  {
    this._context = paramContext;
  }
  
  public void setJavaInterface(int paramInt)
  {
    if (paramInt == 0) {}
    for (this.usingJava = false;; this.usingJava = true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "setJavaInterface flg:" + paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.audio.AudioDeviceInterface
 * JD-Core Version:    0.7.0.1
 */