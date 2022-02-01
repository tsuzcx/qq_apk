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
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
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
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, localException.getMessage());
      }
    }
    this._tempBufPlay = new byte[1920];
    this._tempBufRec = new byte[1920];
    this._traeAudioCodecList = new TraeAudioCodecList();
    int i = Build.VERSION.SDK_INT;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioDeviceInterface apiLevel:");
      localStringBuilder.append(i);
      QLog.w("TRAE", 0, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" SDK_INT:");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.w("TRAE", 0, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("manufacture:");
      localStringBuilder.append(Build.MANUFACTURER);
      QLog.w("TRAE", 0, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MODEL:");
      localStringBuilder.append(Build.MODEL);
      QLog.w("TRAE", 0, localStringBuilder.toString());
    }
  }
  
  private int CloseMp3File(int paramInt)
  {
    Object localObject = this._traeAudioCodecList;
    long l = paramInt;
    localObject = ((TraeAudioCodecList)localObject).find(l);
    if (localObject != null)
    {
      ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder.release();
      ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder = null;
      this._traeAudioCodecList.remove(l);
      return 0;
    }
    return -1;
  }
  
  private int GetPlayoutVolume()
  {
    if (this._audioManager == null)
    {
      localObject = this._context;
      if (localObject != null) {
        this._audioManager = ((AudioManager)((Context)localObject).getSystemService("audio"));
      }
    }
    int i = -1;
    Object localObject = this._audioManager;
    if (localObject != null) {
      i = ((AudioManager)localObject).getStreamVolume(0);
    }
    return i;
  }
  
  private int InitPlayback(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("InitPlayback entry: sampleRate ");
      localStringBuilder1.append(paramInt1);
      QLog.w("TRAE", 0, localStringBuilder1.toString());
    }
    Object localObject1;
    if ((!this._isPlaying) && (this._audioTrack == null) && (paramInt2 <= 2))
    {
      if (this._audioManager == null) {
        try
        {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, localException1.getMessage());
          }
          return -1;
        }
      }
      if (paramInt2 == 2) {
        this._channelOutType = 12;
      } else {
        this._channelOutType = 4;
      }
      this._playSamplerate = paramInt1;
      int n = AudioTrack.getMinBufferSize(paramInt1, this._channelOutType, 2);
      if (this._channelOutType == 12) {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "InitPlayback, _channelOutType stero");
        } else if ((this._channelOutType == 4) && (QLog.isColorLevel())) {
          QLog.w("TRAE", 0, "InitPlayback, _channelOutType Mono");
        }
      }
      int i = paramInt1 * 20 * 1 * 2 / 1000;
      int j = i;
      if (this._channelOutType == 12) {
        j = i * 2;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("InitPlayback: minPlayBufSize:");
        ((StringBuilder)localObject1).append(n);
        ((StringBuilder)localObject1).append(" 20msFz:");
        ((StringBuilder)localObject1).append(j);
        QLog.w("TRAE", 0, ((StringBuilder)localObject1).toString());
      }
      this._bufferedPlaySamples = 0;
      localObject1 = this._audioTrack;
      int i1 = 0;
      if (localObject1 != null)
      {
        ((AudioTrack)localObject1).release();
        this._audioTrack = null;
      }
      localObject1 = new int[4];
      Object tmp323_321 = localObject1;
      tmp323_321[0] = 0;
      Object tmp327_323 = tmp323_321;
      tmp327_323[1] = 0;
      Object tmp331_327 = tmp327_323;
      tmp331_327[2] = 3;
      Object tmp335_331 = tmp331_327;
      tmp335_331[3] = 1;
      tmp335_331;
      this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
      StringBuilder localStringBuilder2;
      if (this._audioRouteChanged)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("_audioRouteChanged:");
          localStringBuilder2.append(this._audioRouteChanged);
          localStringBuilder2.append(" _streamType:");
          localStringBuilder2.append(this._streamType);
          QLog.w("TRAE", 0, localStringBuilder2.toString());
        }
        if ((this._audioManager.getMode() == 0) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
          this._streamType = 3;
        } else {
          this._streamType = 0;
        }
        this._audioRouteChanged = false;
      }
      localObject1[0] = this._streamType;
      i = n;
      int k = 0;
      Object localObject2;
      while ((k < localObject1.length) && (this._audioTrack == null))
      {
        this._streamType = localObject1[k];
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("InitPlayback: min play buf size is ");
          localStringBuilder2.append(n);
          localStringBuilder2.append(" hw_sr:");
          localStringBuilder2.append(AudioTrack.getNativeOutputSampleRate(this._streamType));
          QLog.w("TRAE", 0, localStringBuilder2.toString());
        }
        int m = 1;
        while (m <= 2)
        {
          i = n * m;
          if ((i >= j * 4) || (m >= 2)) {
            try
            {
              this.nPlayLengthMs = (i * 500 / (paramInt1 * paramInt2));
              this._audioTrack = new ReportAudioTrack(this._streamType, this._playSamplerate, this._channelOutType, 2, i, 1);
              if (this._audioTrack.getState() != 1)
              {
                if (QLog.isColorLevel())
                {
                  localStringBuilder2 = new StringBuilder();
                  localStringBuilder2.append("InitPlayback: play not initialized playBufSize:");
                  localStringBuilder2.append(i);
                  localStringBuilder2.append(" sr:");
                  localStringBuilder2.append(this._playSamplerate);
                  QLog.w("TRAE", 0, localStringBuilder2.toString());
                }
                this._audioTrack.release();
                i1 = 0;
                this._audioTrack = null;
              }
              else
              {
                i1 = 0;
              }
            }
            catch (Exception localException2)
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder3 = new StringBuilder();
                localStringBuilder3.append(localException2.getMessage());
                localStringBuilder3.append(" _audioTrack:");
                localStringBuilder3.append(this._audioTrack);
                QLog.w("TRAE", 0, localStringBuilder3.toString());
              }
              localObject2 = this._audioTrack;
              if (localObject2 != null) {
                ((AudioTrack)localObject2).release();
              }
              i1 = 0;
              this._audioTrack = null;
            }
          }
          m += 1;
        }
        k += 1;
      }
      if (this._audioTrack == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "InitPlayback fail!!!");
        }
        return -1;
      }
      localObject1 = this._as;
      if (localObject1 != null)
      {
        localObject2 = this._audioManager;
        if (localObject2 != null) {
          ((TraeAudioSession)localObject1).voiceCallAudioParamChanged(((AudioManager)localObject2).getMode(), this._streamType);
        }
      }
      this._playPosition = this._audioTrack.getPlaybackHeadPosition();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("InitPlayback exit: streamType:");
        ((StringBuilder)localObject1).append(this._streamType);
        ((StringBuilder)localObject1).append(" samplerate:");
        ((StringBuilder)localObject1).append(this._playSamplerate);
        ((StringBuilder)localObject1).append(" _playPosition:");
        ((StringBuilder)localObject1).append(this._playPosition);
        ((StringBuilder)localObject1).append(" playBufSize:");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" nPlayLengthMs:");
        ((StringBuilder)localObject1).append(this.nPlayLengthMs);
        QLog.w("TRAE", 0, ((StringBuilder)localObject1).toString());
      }
      localObject1 = this._audioManager;
      if (this._connectedDev.equals("DEVICE_BLUETOOTHHEADSET")) {
        paramInt1 = 6;
      } else {
        paramInt1 = this._audioTrack.getStreamType();
      }
      TraeAudioManager.forceVolumeControlStream((AudioManager)localObject1, paramInt1);
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("InitPlayback _isPlaying:");
      ((StringBuilder)localObject1).append(this._isPlaying);
      QLog.e("TRAE", 0, ((StringBuilder)localObject1).toString());
    }
    return -1;
  }
  
  private int InitRecording(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("InitRecording entry:");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.w("TRAE", 0, ((StringBuilder)localObject).toString());
    }
    if ((!this._isRecording) && (this._audioRecord == null) && (paramInt2 <= 2))
    {
      int m;
      if (paramInt2 == 2) {
        m = 12;
      } else {
        m = 16;
      }
      int i1 = AudioRecord.getMinBufferSize(paramInt1, m, 2);
      int i = paramInt1 * 20 * paramInt2 * 2 / 1000;
      boolean bool = QLog.isColorLevel();
      String str = " sr:";
      if (bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("InitRecording: min rec buf size is ");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" sr:");
        ((StringBuilder)localObject).append(getLowlatencySamplerate());
        ((StringBuilder)localObject).append(" fp");
        ((StringBuilder)localObject).append(getLowlatencyFramesPerBuffer());
        ((StringBuilder)localObject).append(" 20msFZ:");
        ((StringBuilder)localObject).append(i);
        QLog.w("TRAE", 0, ((StringBuilder)localObject).toString());
      }
      this._bufferedRecSamples = (paramInt1 * 5 / 200);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("  rough rec delay set to ");
        ((StringBuilder)localObject).append(this._bufferedRecSamples);
        QLog.w("TRAE", 0, ((StringBuilder)localObject).toString());
      }
      localObject = this._audioRecord;
      if (localObject != null)
      {
        ((AudioRecord)localObject).release();
        this._audioRecord = null;
      }
      localObject = new int[4];
      Object tmp292_290 = localObject;
      tmp292_290[0] = 0;
      Object tmp296_292 = tmp292_290;
      tmp296_292[1] = 1;
      Object tmp300_296 = tmp296_292;
      tmp300_296[2] = 5;
      Object tmp304_300 = tmp300_296;
      tmp304_300[3] = 0;
      tmp304_300;
      localObject[0] = TraeAudioManager.getAudioSource(this._audioSourcePolicy);
      int j = i1;
      int k = 0;
      while ((k < localObject.length) && (this._audioRecord == null))
      {
        this._audioSource = localObject[k];
        int n = 1;
        while (n <= 2)
        {
          j = i1 * n;
          if ((j >= i * 4) || (n >= 2))
          {
            try
            {
              this.nRecordLengthMs = (j * 500 / (paramInt1 * paramInt2));
              int i2 = this._audioSource;
              try
              {
                this._audioRecord = new AudioRecord(i2, paramInt1, m, 2, j);
                if (this._audioRecord.getState() != 1)
                {
                  if (QLog.isColorLevel())
                  {
                    StringBuilder localStringBuilder1 = new StringBuilder();
                    localStringBuilder1.append("InitRecording:  rec not initialized,try agine,  minbufsize:");
                    localStringBuilder1.append(j);
                    localStringBuilder1.append(str);
                    localStringBuilder1.append(paramInt1);
                    localStringBuilder1.append(" as:");
                    localStringBuilder1.append(this._audioSource);
                    QLog.w("TRAE", 0, localStringBuilder1.toString());
                  }
                  this._audioRecord.release();
                  this._audioRecord = null;
                  break label616;
                }
              }
              catch (Exception localException1) {}
              if (!QLog.isColorLevel()) {
                break label595;
              }
            }
            catch (Exception localException2) {}
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(localException2.getMessage());
            localStringBuilder2.append(" _audioRecord:");
            localStringBuilder2.append(this._audioRecord);
            QLog.w("TRAE", 0, localStringBuilder2.toString());
            label595:
            AudioRecord localAudioRecord = this._audioRecord;
            if (localAudioRecord != null) {
              localAudioRecord.release();
            }
            this._audioRecord = null;
          }
          label616:
          n += 1;
        }
        k += 1;
      }
      if (this._audioRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "InitRecording fail!!!");
        }
        return -1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" [Config] InitRecording: audioSession:");
        ((StringBuilder)localObject).append(this._sessionId);
        ((StringBuilder)localObject).append(" audioSource:");
        ((StringBuilder)localObject).append(this._audioSource);
        ((StringBuilder)localObject).append(" rec sample rate set to ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" recBufSize:");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" nRecordLengthMs:");
        ((StringBuilder)localObject).append(this.nRecordLengthMs);
        QLog.w("TRAE", 0, ((StringBuilder)localObject).toString());
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "InitRecording exit");
      }
      return this._bufferedRecSamples;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("InitRecording _isRecording:");
      ((StringBuilder)localObject).append(this._isRecording);
      QLog.e("TRAE", 0, ((StringBuilder)localObject).toString());
    }
    return -1;
  }
  
  private int InitSetting(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this._audioSourcePolicy = paramInt1;
    this._audioStreamTypePolicy = paramInt2;
    this._modePolicy = paramInt3;
    this._deviceStat = paramInt4;
    this._sceneMode = paramInt5;
    paramInt1 = this._deviceStat;
    if ((paramInt1 != 1) && (paramInt1 != 5) && (paramInt1 != 2) && (paramInt1 != 3)) {
      TraeAudioManager.IsMusicScene = false;
    } else {
      TraeAudioManager.IsMusicScene = true;
    }
    paramInt1 = this._sceneMode;
    if ((paramInt1 != 0) && (paramInt1 != 4)) {
      TraeAudioManager.IsEarPhoneSupported = false;
    } else {
      TraeAudioManager.IsEarPhoneSupported = true;
    }
    TraeAudioManager.IsUpdateSceneFlag = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("InitSetting: _audioSourcePolicy:");
      localStringBuilder.append(this._audioSourcePolicy);
      localStringBuilder.append(" _audioStreamTypePolicy:");
      localStringBuilder.append(this._audioStreamTypePolicy);
      localStringBuilder.append(" _modePolicy:");
      localStringBuilder.append(this._modePolicy);
      localStringBuilder.append(" DeviceStat:");
      localStringBuilder.append(paramInt4);
      QLog.w("TRAE", 0, localStringBuilder.toString());
    }
    return 0;
  }
  
  public static final void LogTraceEntry(String paramString)
  {
    if (!_logEnable) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getTraceInfo());
    localStringBuilder.append(" entry:");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, paramString);
    }
  }
  
  public static final void LogTraceExit()
  {
    if (!_logEnable) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getTraceInfo());
    ((StringBuilder)localObject).append(" exit");
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, (String)localObject);
    }
  }
  
  private int OpenMp3File(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = this._traeAudioCodecList;
    long l = paramInt1;
    if (((TraeAudioCodecList)localObject).find(l) == null)
    {
      localObject = this._traeAudioCodecList.add(l);
      ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder.setIOPath(paramString);
      ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder.setIndex(paramInt1);
      paramInt1 = ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder.prepare(paramInt2);
      if (paramInt1 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "openFile mp3 Failed!!!");
        }
        ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder.release();
        ((TraeAudioCodecList.CodecInfo)localObject).audioDecoder = null;
        this._traeAudioCodecList.remove(l);
        return paramInt1;
      }
      return 0;
    }
    return -1;
  }
  
  /* Error */
  private int OpenslesNeedResetAudioTrack(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	com/tencent/TMG/audio/AudioDeviceInterface:_modePolicy	I
    //   4: invokestatic 504	com/tencent/TMG/audio/TraeAudioManager:isCloseSystemAPM	(I)Z
    //   7: ifne +5 -> 12
    //   10: iconst_m1
    //   11: ireturn
    //   12: aload_0
    //   13: getfield 159	com/tencent/TMG/audio/AudioDeviceInterface:_audioRouteChanged	Z
    //   16: ifne +7 -> 23
    //   19: iload_1
    //   20: ifeq +133 -> 153
    //   23: aload_0
    //   24: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   27: ifnonnull +27 -> 54
    //   30: aload_0
    //   31: getfield 108	com/tencent/TMG/audio/AudioDeviceInterface:_context	Landroid/content/Context;
    //   34: ifnull +20 -> 54
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 108	com/tencent/TMG/audio/AudioDeviceInterface:_context	Landroid/content/Context;
    //   42: ldc_w 289
    //   45: invokevirtual 295	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   48: checkcast 297	android/media/AudioManager
    //   51: putfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   54: aload_0
    //   55: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   58: ifnonnull +5 -> 63
    //   61: iconst_0
    //   62: ireturn
    //   63: aload_0
    //   64: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   67: invokevirtual 334	android/media/AudioManager:getMode	()I
    //   70: ifne +24 -> 94
    //   73: aload_0
    //   74: getfield 157	com/tencent/TMG/audio/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   77: ldc_w 336
    //   80: invokevirtual 342	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifeq +11 -> 94
    //   86: aload_0
    //   87: iconst_3
    //   88: putfield 114	com/tencent/TMG/audio/AudioDeviceInterface:_audioStreamTypePolicy	I
    //   91: goto +8 -> 99
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 114	com/tencent/TMG/audio/AudioDeviceInterface:_audioStreamTypePolicy	I
    //   99: aload_0
    //   100: iconst_0
    //   101: putfield 159	com/tencent/TMG/audio/AudioDeviceInterface:_audioRouteChanged	Z
    //   104: goto +49 -> 153
    //   107: astore_2
    //   108: goto +50 -> 158
    //   111: astore_2
    //   112: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   115: ifeq +38 -> 153
    //   118: new 237	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   125: astore_3
    //   126: aload_3
    //   127: ldc_w 506
    //   130: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_3
    //   135: aload_2
    //   136: invokevirtual 219	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   139: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: ldc 215
    //   145: iconst_0
    //   146: aload_3
    //   147: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_0
    //   154: getfield 114	com/tencent/TMG/audio/AudioDeviceInterface:_audioStreamTypePolicy	I
    //   157: ireturn
    //   158: aload_2
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	AudioDeviceInterface
    //   0	160	1	paramBoolean	boolean
    //   107	1	2	localObject	Object
    //   111	48	2	localException	Exception
    //   125	22	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	10	107	finally
    //   12	19	107	finally
    //   23	54	107	finally
    //   54	61	107	finally
    //   63	91	107	finally
    //   94	99	107	finally
    //   99	104	107	finally
    //   112	153	107	finally
    //   0	10	111	java/lang/Exception
    //   12	19	111	java/lang/Exception
    //   23	54	111	java/lang/Exception
    //   54	61	111	java/lang/Exception
    //   63	91	111	java/lang/Exception
    //   94	99	111	java/lang/Exception
    //   99	104	111	java/lang/Exception
  }
  
  /* Error */
  private int PlayAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 131	com/tencent/TMG/audio/AudioDeviceInterface:_isPlaying	Z
    //   4: istore 7
    //   6: aload_0
    //   7: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   10: ifnonnull +8 -> 18
    //   13: iconst_1
    //   14: istore_2
    //   15: goto +5 -> 20
    //   18: iconst_0
    //   19: istore_2
    //   20: iload 7
    //   22: iconst_1
    //   23: ixor
    //   24: iload_2
    //   25: ior
    //   26: ifeq +69 -> 95
    //   29: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   32: ifeq +61 -> 93
    //   35: new 237	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   42: astore 10
    //   44: aload 10
    //   46: ldc_w 513
    //   49: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 10
    //   55: aload_0
    //   56: getfield 131	com/tencent/TMG/audio/AudioDeviceInterface:_isPlaying	Z
    //   59: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 10
    //   65: ldc_w 515
    //   68: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 10
    //   74: aload_0
    //   75: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   78: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 215
    //   84: iconst_0
    //   85: aload 10
    //   87: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: iconst_m1
    //   94: ireturn
    //   95: aload_0
    //   96: getfield 121	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   99: invokevirtual 518	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   102: aload_0
    //   103: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   106: astore 10
    //   108: aload 10
    //   110: ifnonnull +13 -> 123
    //   113: aload_0
    //   114: getfield 121	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   117: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   120: bipush 254
    //   122: ireturn
    //   123: aload_0
    //   124: getfield 125	com/tencent/TMG/audio/AudioDeviceInterface:_doPlayInit	Z
    //   127: istore 7
    //   129: iload 7
    //   131: iconst_1
    //   132: if_icmpne +64 -> 196
    //   135: bipush 237
    //   137: invokestatic 526	android/os/Process:setThreadPriority	(I)V
    //   140: goto +51 -> 191
    //   143: astore 10
    //   145: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   148: ifeq +43 -> 191
    //   151: new 237	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   158: astore 11
    //   160: aload 11
    //   162: ldc_w 528
    //   165: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 11
    //   171: aload 10
    //   173: invokevirtual 219	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   176: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: ldc 215
    //   182: iconst_0
    //   183: aload 11
    //   185: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 223	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_0
    //   192: iconst_0
    //   193: putfield 125	com/tencent/TMG/audio/AudioDeviceInterface:_doPlayInit	Z
    //   196: getstatic 530	com/tencent/TMG/audio/AudioDeviceInterface:_dumpEnable	Z
    //   199: ifeq +37 -> 236
    //   202: aload_0
    //   203: getfield 145	com/tencent/TMG/audio/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   206: astore 10
    //   208: aload 10
    //   210: ifnull +26 -> 236
    //   213: aload_0
    //   214: getfield 145	com/tencent/TMG/audio/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   217: aload_0
    //   218: getfield 225	com/tencent/TMG/audio/AudioDeviceInterface:_tempBufPlay	[B
    //   221: iconst_0
    //   222: iconst_0
    //   223: invokevirtual 536	java/io/FileOutputStream:write	([BII)V
    //   226: goto +10 -> 236
    //   229: astore 10
    //   231: aload 10
    //   233: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   236: aload_0
    //   237: getfield 159	com/tencent/TMG/audio/AudioDeviceInterface:_audioRouteChanged	Z
    //   240: ifne +8 -> 248
    //   243: iconst_0
    //   244: istore_2
    //   245: goto +101 -> 346
    //   248: aload_0
    //   249: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   252: ifnonnull +27 -> 279
    //   255: aload_0
    //   256: getfield 108	com/tencent/TMG/audio/AudioDeviceInterface:_context	Landroid/content/Context;
    //   259: ifnull +20 -> 279
    //   262: aload_0
    //   263: aload_0
    //   264: getfield 108	com/tencent/TMG/audio/AudioDeviceInterface:_context	Landroid/content/Context;
    //   267: ldc_w 289
    //   270: invokevirtual 295	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   273: checkcast 297	android/media/AudioManager
    //   276: putfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   279: aload_0
    //   280: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   283: ifnull +34 -> 317
    //   286: aload_0
    //   287: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   290: invokevirtual 334	android/media/AudioManager:getMode	()I
    //   293: ifne +24 -> 317
    //   296: aload_0
    //   297: getfield 157	com/tencent/TMG/audio/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   300: ldc_w 336
    //   303: invokevirtual 342	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   306: ifeq +11 -> 317
    //   309: aload_0
    //   310: iconst_3
    //   311: putfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   314: goto +8 -> 322
    //   317: aload_0
    //   318: iconst_0
    //   319: putfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   322: aload_0
    //   323: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   326: aload_0
    //   327: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   330: invokevirtual 391	android/media/AudioTrack:getStreamType	()I
    //   333: if_icmpne +1205 -> 1538
    //   336: iconst_0
    //   337: istore_2
    //   338: goto +3 -> 341
    //   341: aload_0
    //   342: iconst_0
    //   343: putfield 159	com/tencent/TMG/audio/AudioDeviceInterface:_audioRouteChanged	Z
    //   346: aload_0
    //   347: getfield 183	com/tencent/TMG/audio/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   350: aload_0
    //   351: getfield 225	com/tencent/TMG/audio/AudioDeviceInterface:_tempBufPlay	[B
    //   354: invokevirtual 543	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   357: pop
    //   358: iload_2
    //   359: ifeq +836 -> 1195
    //   362: aload_0
    //   363: getfield 183	com/tencent/TMG/audio/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   366: invokevirtual 547	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   369: pop
    //   370: invokestatic 553	android/os/SystemClock:elapsedRealtime	()J
    //   373: lstore 8
    //   375: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   378: ifeq +64 -> 442
    //   381: new 237	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   388: astore 10
    //   390: aload 10
    //   392: ldc_w 555
    //   395: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 10
    //   401: aload_0
    //   402: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   405: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 10
    //   411: ldc_w 557
    //   414: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 10
    //   420: aload_0
    //   421: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   424: invokevirtual 391	android/media/AudioTrack:getStreamType	()I
    //   427: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: ldc 215
    //   433: iconst_0
    //   434: aload 10
    //   436: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 223	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: aload_0
    //   443: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   446: invokevirtual 560	android/media/AudioTrack:getPlayState	()I
    //   449: istore_2
    //   450: iload_2
    //   451: iconst_3
    //   452: if_icmpne +158 -> 610
    //   455: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   458: ifeq +12 -> 470
    //   461: ldc 215
    //   463: iconst_0
    //   464: ldc_w 562
    //   467: invokestatic 223	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: aload_0
    //   471: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   474: invokevirtual 565	android/media/AudioTrack:stop	()V
    //   477: aload_0
    //   478: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   481: invokevirtual 568	android/media/AudioTrack:flush	()V
    //   484: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   487: ifeq +45 -> 532
    //   490: new 237	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   497: astore 10
    //   499: aload 10
    //   501: ldc_w 570
    //   504: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 10
    //   510: aload_0
    //   511: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   514: invokevirtual 560	android/media/AudioTrack:getPlayState	()I
    //   517: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: ldc 215
    //   523: iconst_0
    //   524: aload 10
    //   526: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 223	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: aload_0
    //   533: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   536: invokevirtual 319	android/media/AudioTrack:release	()V
    //   539: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   542: ifeq +45 -> 587
    //   545: new 237	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   552: astore 10
    //   554: aload 10
    //   556: ldc_w 572
    //   559: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload 10
    //   565: aload_0
    //   566: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   569: invokevirtual 560	android/media/AudioTrack:getPlayState	()I
    //   572: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: ldc 215
    //   578: iconst_0
    //   579: aload 10
    //   581: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokestatic 223	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   587: aload_0
    //   588: aconst_null
    //   589: putfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   592: goto +18 -> 610
    //   595: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   598: ifeq +12 -> 610
    //   601: ldc 215
    //   603: iconst_0
    //   604: ldc_w 574
    //   607: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: aload_0
    //   611: getfield 96	com/tencent/TMG/audio/AudioDeviceInterface:_playSamplerate	I
    //   614: aload_0
    //   615: getfield 98	com/tencent/TMG/audio/AudioDeviceInterface:_channelOutType	I
    //   618: iconst_2
    //   619: invokestatic 310	android/media/AudioTrack:getMinBufferSize	(III)I
    //   622: istore 5
    //   624: iconst_4
    //   625: newarray int
    //   627: astore 10
    //   629: aload 10
    //   631: iconst_0
    //   632: iconst_0
    //   633: iastore
    //   634: aload 10
    //   636: iconst_1
    //   637: iconst_0
    //   638: iastore
    //   639: aload 10
    //   641: iconst_2
    //   642: iconst_3
    //   643: iastore
    //   644: aload 10
    //   646: iconst_3
    //   647: iconst_1
    //   648: iastore
    //   649: aload 10
    //   651: iconst_0
    //   652: aload_0
    //   653: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   656: iastore
    //   657: aload_0
    //   658: getfield 96	com/tencent/TMG/audio/AudioDeviceInterface:_playSamplerate	I
    //   661: bipush 20
    //   663: imul
    //   664: iconst_1
    //   665: imul
    //   666: iconst_2
    //   667: imul
    //   668: sipush 1000
    //   671: idiv
    //   672: istore_3
    //   673: iload_3
    //   674: istore_2
    //   675: aload_0
    //   676: getfield 98	com/tencent/TMG/audio/AudioDeviceInterface:_channelOutType	I
    //   679: bipush 12
    //   681: if_icmpne +862 -> 1543
    //   684: iload_3
    //   685: iconst_2
    //   686: imul
    //   687: istore_2
    //   688: goto +855 -> 1543
    //   691: iload_3
    //   692: aload 10
    //   694: arraylength
    //   695: if_icmpge +356 -> 1051
    //   698: aload_0
    //   699: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   702: ifnonnull +349 -> 1051
    //   705: aload_0
    //   706: aload 10
    //   708: iload_3
    //   709: iaload
    //   710: putfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   713: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   716: ifeq +62 -> 778
    //   719: new 237	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   726: astore 11
    //   728: aload 11
    //   730: ldc_w 344
    //   733: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload 11
    //   739: iload 5
    //   741: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: aload 11
    //   747: ldc_w 346
    //   750: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload 11
    //   756: aload_0
    //   757: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   760: invokestatic 349	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   763: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: ldc 215
    //   769: iconst_0
    //   770: aload 11
    //   772: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: invokestatic 223	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   778: iconst_1
    //   779: istore 4
    //   781: iload 4
    //   783: iconst_2
    //   784: if_icmpgt +776 -> 1560
    //   787: iload 5
    //   789: iload 4
    //   791: imul
    //   792: istore 6
    //   794: iload 6
    //   796: iload_2
    //   797: iconst_4
    //   798: imul
    //   799: if_icmpge +12 -> 811
    //   802: iload 4
    //   804: iconst_2
    //   805: if_icmpge +6 -> 811
    //   808: goto +743 -> 1551
    //   811: aload_0
    //   812: new 351	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportAudioTrack
    //   815: dup
    //   816: aload_0
    //   817: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   820: aload_0
    //   821: getfield 96	com/tencent/TMG/audio/AudioDeviceInterface:_playSamplerate	I
    //   824: aload_0
    //   825: getfield 98	com/tencent/TMG/audio/AudioDeviceInterface:_channelOutType	I
    //   828: iconst_2
    //   829: iload 6
    //   831: iconst_1
    //   832: invokespecial 354	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportAudioTrack:<init>	(IIIIII)V
    //   835: putfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   838: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   841: ifeq +42 -> 883
    //   844: new 237	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   851: astore 11
    //   853: aload 11
    //   855: ldc_w 363
    //   858: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: pop
    //   862: aload 11
    //   864: aload_0
    //   865: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   868: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   871: pop
    //   872: ldc 215
    //   874: iconst_0
    //   875: aload 11
    //   877: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: invokestatic 223	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   883: aload_0
    //   884: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   887: invokevirtual 357	android/media/AudioTrack:getState	()I
    //   890: iconst_1
    //   891: if_icmpeq +657 -> 1548
    //   894: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   897: ifeq +59 -> 956
    //   900: new 237	java/lang/StringBuilder
    //   903: dup
    //   904: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   907: astore 11
    //   909: aload 11
    //   911: ldc_w 359
    //   914: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: pop
    //   918: aload 11
    //   920: iload 6
    //   922: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   925: pop
    //   926: aload 11
    //   928: ldc_w 361
    //   931: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: aload 11
    //   937: aload_0
    //   938: getfield 96	com/tencent/TMG/audio/AudioDeviceInterface:_playSamplerate	I
    //   941: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   944: pop
    //   945: ldc 215
    //   947: iconst_0
    //   948: aload 11
    //   950: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   953: invokestatic 223	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   956: aload_0
    //   957: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   960: invokevirtual 319	android/media/AudioTrack:release	()V
    //   963: aload_0
    //   964: aconst_null
    //   965: putfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   968: goto +583 -> 1551
    //   971: astore 11
    //   973: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   976: ifeq +53 -> 1029
    //   979: new 237	java/lang/StringBuilder
    //   982: dup
    //   983: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   986: astore 12
    //   988: aload 12
    //   990: aload 11
    //   992: invokevirtual 219	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   995: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: pop
    //   999: aload 12
    //   1001: ldc_w 363
    //   1004: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: pop
    //   1008: aload 12
    //   1010: aload_0
    //   1011: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1014: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1017: pop
    //   1018: ldc 215
    //   1020: iconst_0
    //   1021: aload 12
    //   1023: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1026: invokestatic 223	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1029: aload_0
    //   1030: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1033: ifnull +10 -> 1043
    //   1036: aload_0
    //   1037: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1040: invokevirtual 319	android/media/AudioTrack:release	()V
    //   1043: aload_0
    //   1044: aconst_null
    //   1045: putfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1048: goto +503 -> 1551
    //   1051: aload_0
    //   1052: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1055: astore 10
    //   1057: aload 10
    //   1059: ifnull +68 -> 1127
    //   1062: aload_0
    //   1063: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1066: invokevirtual 577	android/media/AudioTrack:play	()V
    //   1069: aload_0
    //   1070: getfield 153	com/tencent/TMG/audio/AudioDeviceInterface:_as	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   1073: aload_0
    //   1074: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1077: invokevirtual 334	android/media/AudioManager:getMode	()I
    //   1080: aload_0
    //   1081: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   1084: invokevirtual 373	com/tencent/TMG/audio/TraeAudioSession:voiceCallAudioParamChanged	(II)I
    //   1087: pop
    //   1088: aload_0
    //   1089: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1092: astore 10
    //   1094: aload_0
    //   1095: getfield 157	com/tencent/TMG/audio/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   1098: ldc_w 388
    //   1101: invokevirtual 342	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1104: ifeq +9 -> 1113
    //   1107: bipush 6
    //   1109: istore_2
    //   1110: goto +11 -> 1121
    //   1113: aload_0
    //   1114: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1117: invokevirtual 391	android/media/AudioTrack:getStreamType	()I
    //   1120: istore_2
    //   1121: aload 10
    //   1123: iload_2
    //   1124: invokestatic 395	com/tencent/TMG/audio/TraeAudioManager:forceVolumeControlStream	(Landroid/media/AudioManager;I)V
    //   1127: iload_1
    //   1128: istore_2
    //   1129: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1132: ifeq +371 -> 1503
    //   1135: new 237	java/lang/StringBuilder
    //   1138: dup
    //   1139: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   1142: astore 10
    //   1144: aload 10
    //   1146: ldc_w 579
    //   1149: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: pop
    //   1153: aload 10
    //   1155: invokestatic 553	android/os/SystemClock:elapsedRealtime	()J
    //   1158: lload 8
    //   1160: lsub
    //   1161: invokevirtual 582	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1164: pop
    //   1165: aload 10
    //   1167: ldc_w 584
    //   1170: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: pop
    //   1174: ldc 215
    //   1176: iconst_0
    //   1177: aload 10
    //   1179: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1182: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1185: iload_1
    //   1186: istore_2
    //   1187: goto +316 -> 1503
    //   1190: astore 10
    //   1192: goto +261 -> 1453
    //   1195: aload_0
    //   1196: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1199: aload_0
    //   1200: getfield 225	com/tencent/TMG/audio/AudioDeviceInterface:_tempBufPlay	[B
    //   1203: iconst_0
    //   1204: iload_1
    //   1205: invokevirtual 587	android/media/AudioTrack:write	([BII)I
    //   1208: istore_2
    //   1209: aload_0
    //   1210: getfield 183	com/tencent/TMG/audio/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   1213: invokevirtual 547	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1216: pop
    //   1217: iload_2
    //   1218: ifge +79 -> 1297
    //   1221: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1224: ifeq +64 -> 1288
    //   1227: new 237	java/lang/StringBuilder
    //   1230: dup
    //   1231: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   1234: astore 10
    //   1236: aload 10
    //   1238: ldc_w 589
    //   1241: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: pop
    //   1245: aload 10
    //   1247: iload_2
    //   1248: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1251: pop
    //   1252: aload 10
    //   1254: ldc_w 591
    //   1257: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: pop
    //   1261: aload 10
    //   1263: iload_1
    //   1264: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1267: pop
    //   1268: aload 10
    //   1270: ldc_w 593
    //   1273: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: pop
    //   1277: ldc 215
    //   1279: iconst_0
    //   1280: aload 10
    //   1282: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1285: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1288: aload_0
    //   1289: getfield 121	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1292: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1295: iconst_m1
    //   1296: ireturn
    //   1297: iload_2
    //   1298: iload_1
    //   1299: if_icmpeq +70 -> 1369
    //   1302: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1305: ifeq +64 -> 1369
    //   1308: new 237	java/lang/StringBuilder
    //   1311: dup
    //   1312: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   1315: astore 10
    //   1317: aload 10
    //   1319: ldc_w 595
    //   1322: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: pop
    //   1326: aload 10
    //   1328: iload_2
    //   1329: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1332: pop
    //   1333: aload 10
    //   1335: ldc_w 591
    //   1338: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: pop
    //   1342: aload 10
    //   1344: iload_1
    //   1345: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: aload 10
    //   1351: ldc_w 593
    //   1354: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: pop
    //   1358: ldc 215
    //   1360: iconst_0
    //   1361: aload 10
    //   1363: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1366: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1369: aload_0
    //   1370: aload_0
    //   1371: getfield 135	com/tencent/TMG/audio/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1374: iload_2
    //   1375: iconst_1
    //   1376: ishr
    //   1377: iadd
    //   1378: putfield 135	com/tencent/TMG/audio/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1381: aload_0
    //   1382: getfield 90	com/tencent/TMG/audio/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1385: invokevirtual 376	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   1388: istore_1
    //   1389: iload_1
    //   1390: aload_0
    //   1391: getfield 137	com/tencent/TMG/audio/AudioDeviceInterface:_playPosition	I
    //   1394: if_icmpge +8 -> 1402
    //   1397: aload_0
    //   1398: iconst_0
    //   1399: putfield 137	com/tencent/TMG/audio/AudioDeviceInterface:_playPosition	I
    //   1402: aload_0
    //   1403: aload_0
    //   1404: getfield 135	com/tencent/TMG/audio/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1407: iload_1
    //   1408: aload_0
    //   1409: getfield 137	com/tencent/TMG/audio/AudioDeviceInterface:_playPosition	I
    //   1412: isub
    //   1413: isub
    //   1414: putfield 135	com/tencent/TMG/audio/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1417: aload_0
    //   1418: iload_1
    //   1419: putfield 137	com/tencent/TMG/audio/AudioDeviceInterface:_playPosition	I
    //   1422: aload_0
    //   1423: getfield 129	com/tencent/TMG/audio/AudioDeviceInterface:_isRecording	Z
    //   1426: ifne +8 -> 1434
    //   1429: aload_0
    //   1430: getfield 135	com/tencent/TMG/audio/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1433: istore_1
    //   1434: goto +69 -> 1503
    //   1437: astore 10
    //   1439: iload_2
    //   1440: istore_1
    //   1441: goto +12 -> 1453
    //   1444: astore 10
    //   1446: goto +66 -> 1512
    //   1449: astore 10
    //   1451: iconst_0
    //   1452: istore_1
    //   1453: iload_1
    //   1454: istore_2
    //   1455: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1458: ifeq +45 -> 1503
    //   1461: new 237	java/lang/StringBuilder
    //   1464: dup
    //   1465: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   1468: astore 11
    //   1470: aload 11
    //   1472: ldc_w 506
    //   1475: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: pop
    //   1479: aload 11
    //   1481: aload 10
    //   1483: invokevirtual 219	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1486: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: pop
    //   1490: ldc 215
    //   1492: iconst_0
    //   1493: aload 11
    //   1495: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1498: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1501: iload_1
    //   1502: istore_2
    //   1503: aload_0
    //   1504: getfield 121	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1507: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1510: iload_2
    //   1511: ireturn
    //   1512: aload_0
    //   1513: getfield 121	com/tencent/TMG/audio/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1516: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1519: goto +6 -> 1525
    //   1522: aload 10
    //   1524: athrow
    //   1525: goto -3 -> 1522
    //   1528: astore 10
    //   1530: goto -935 -> 595
    //   1533: astore 10
    //   1535: goto -408 -> 1127
    //   1538: iconst_1
    //   1539: istore_2
    //   1540: goto -1199 -> 341
    //   1543: iconst_0
    //   1544: istore_3
    //   1545: goto -854 -> 691
    //   1548: goto +12 -> 1560
    //   1551: iload 4
    //   1553: iconst_1
    //   1554: iadd
    //   1555: istore 4
    //   1557: goto -776 -> 781
    //   1560: iload_3
    //   1561: iconst_1
    //   1562: iadd
    //   1563: istore_3
    //   1564: goto -873 -> 691
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1567	0	this	AudioDeviceInterface
    //   0	1567	1	paramInt	int
    //   14	1526	2	i	int
    //   672	892	3	j	int
    //   779	777	4	k	int
    //   622	170	5	m	int
    //   792	129	6	n	int
    //   4	129	7	bool	boolean
    //   373	786	8	l	long
    //   42	67	10	localObject1	Object
    //   143	29	10	localException1	Exception
    //   206	3	10	localFileOutputStream	FileOutputStream
    //   229	3	10	localIOException	java.io.IOException
    //   388	790	10	localObject2	Object
    //   1190	1	10	localException2	Exception
    //   1234	128	10	localStringBuilder1	StringBuilder
    //   1437	1	10	localException3	Exception
    //   1444	1	10	localObject3	Object
    //   1449	74	10	localException4	Exception
    //   1528	1	10	localIllegalStateException	IllegalStateException
    //   1533	1	10	localException5	Exception
    //   158	791	11	localStringBuilder2	StringBuilder
    //   971	20	11	localException6	Exception
    //   1468	26	11	localStringBuilder3	StringBuilder
    //   986	36	12	localStringBuilder4	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   135	140	143	java/lang/Exception
    //   213	226	229	java/io/IOException
    //   811	838	971	java/lang/Exception
    //   362	442	1190	java/lang/Exception
    //   442	450	1190	java/lang/Exception
    //   455	470	1190	java/lang/Exception
    //   470	532	1190	java/lang/Exception
    //   532	587	1190	java/lang/Exception
    //   587	592	1190	java/lang/Exception
    //   595	610	1190	java/lang/Exception
    //   610	629	1190	java/lang/Exception
    //   649	673	1190	java/lang/Exception
    //   675	684	1190	java/lang/Exception
    //   691	778	1190	java/lang/Exception
    //   838	883	1190	java/lang/Exception
    //   883	956	1190	java/lang/Exception
    //   956	968	1190	java/lang/Exception
    //   973	1029	1190	java/lang/Exception
    //   1029	1043	1190	java/lang/Exception
    //   1043	1048	1190	java/lang/Exception
    //   1051	1057	1190	java/lang/Exception
    //   1129	1185	1190	java/lang/Exception
    //   1209	1217	1437	java/lang/Exception
    //   1221	1288	1437	java/lang/Exception
    //   1302	1369	1437	java/lang/Exception
    //   1369	1402	1437	java/lang/Exception
    //   1402	1434	1437	java/lang/Exception
    //   102	108	1444	finally
    //   123	129	1444	finally
    //   135	140	1444	finally
    //   145	191	1444	finally
    //   191	196	1444	finally
    //   196	208	1444	finally
    //   213	226	1444	finally
    //   231	236	1444	finally
    //   236	243	1444	finally
    //   248	279	1444	finally
    //   279	314	1444	finally
    //   317	322	1444	finally
    //   322	336	1444	finally
    //   341	346	1444	finally
    //   346	358	1444	finally
    //   362	442	1444	finally
    //   442	450	1444	finally
    //   455	470	1444	finally
    //   470	532	1444	finally
    //   532	587	1444	finally
    //   587	592	1444	finally
    //   595	610	1444	finally
    //   610	629	1444	finally
    //   649	673	1444	finally
    //   675	684	1444	finally
    //   691	778	1444	finally
    //   811	838	1444	finally
    //   838	883	1444	finally
    //   883	956	1444	finally
    //   956	968	1444	finally
    //   973	1029	1444	finally
    //   1029	1043	1444	finally
    //   1043	1048	1444	finally
    //   1051	1057	1444	finally
    //   1062	1107	1444	finally
    //   1113	1121	1444	finally
    //   1121	1127	1444	finally
    //   1129	1185	1444	finally
    //   1195	1209	1444	finally
    //   1209	1217	1444	finally
    //   1221	1288	1444	finally
    //   1302	1369	1444	finally
    //   1369	1402	1444	finally
    //   1402	1434	1444	finally
    //   1455	1501	1444	finally
    //   102	108	1449	java/lang/Exception
    //   123	129	1449	java/lang/Exception
    //   145	191	1449	java/lang/Exception
    //   191	196	1449	java/lang/Exception
    //   196	208	1449	java/lang/Exception
    //   213	226	1449	java/lang/Exception
    //   231	236	1449	java/lang/Exception
    //   236	243	1449	java/lang/Exception
    //   248	279	1449	java/lang/Exception
    //   279	314	1449	java/lang/Exception
    //   317	322	1449	java/lang/Exception
    //   322	336	1449	java/lang/Exception
    //   341	346	1449	java/lang/Exception
    //   346	358	1449	java/lang/Exception
    //   1195	1209	1449	java/lang/Exception
    //   455	470	1528	java/lang/IllegalStateException
    //   470	532	1528	java/lang/IllegalStateException
    //   532	587	1528	java/lang/IllegalStateException
    //   587	592	1528	java/lang/IllegalStateException
    //   1062	1107	1533	java/lang/Exception
    //   1113	1121	1533	java/lang/Exception
    //   1121	1127	1533	java/lang/Exception
  }
  
  private int ReadMp3File(int paramInt)
  {
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null)
    {
      ByteBuffer localByteBuffer = getDecBuffer(paramInt);
      if (localByteBuffer == null) {
        return -1;
      }
      localByteBuffer.rewind();
      paramInt = localCodecInfo.audioDecoder.getFrameSize();
      int i = localCodecInfo.audioDecoder.ReadOneFrame(localCodecInfo._tempBufdec, paramInt);
      localByteBuffer.put(localCodecInfo._tempBufdec, 0, paramInt);
      return i;
    }
    return -1;
  }
  
  /* Error */
  private int RecordAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 129	com/tencent/TMG/audio/AudioDeviceInterface:_isRecording	Z
    //   4: ifne +50 -> 54
    //   7: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   10: ifeq +42 -> 52
    //   13: new 237	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   20: astore 5
    //   22: aload 5
    //   24: ldc_w 616
    //   27: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 5
    //   33: aload_0
    //   34: getfield 129	com/tencent/TMG/audio/AudioDeviceInterface:_isRecording	Z
    //   37: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 215
    //   43: iconst_0
    //   44: aload 5
    //   46: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: iconst_m1
    //   53: ireturn
    //   54: aload_0
    //   55: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   58: invokevirtual 518	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   61: aload_0
    //   62: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   65: astore 5
    //   67: aload 5
    //   69: ifnonnull +13 -> 82
    //   72: aload_0
    //   73: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   76: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   79: bipush 254
    //   81: ireturn
    //   82: aload_0
    //   83: getfield 127	com/tencent/TMG/audio/AudioDeviceInterface:_doRecInit	Z
    //   86: istore 4
    //   88: iload 4
    //   90: iconst_1
    //   91: if_icmpne +64 -> 155
    //   94: bipush 237
    //   96: invokestatic 526	android/os/Process:setThreadPriority	(I)V
    //   99: goto +51 -> 150
    //   102: astore 5
    //   104: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   107: ifeq +43 -> 150
    //   110: new 237	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   117: astore 6
    //   119: aload 6
    //   121: ldc_w 618
    //   124: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 6
    //   130: aload 5
    //   132: invokevirtual 219	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: ldc 215
    //   141: iconst_0
    //   142: aload 6
    //   144: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 223	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: iconst_0
    //   152: putfield 127	com/tencent/TMG/audio/AudioDeviceInterface:_doRecInit	Z
    //   155: aload_0
    //   156: getfield 185	com/tencent/TMG/audio/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   159: invokevirtual 547	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   162: pop
    //   163: aload_0
    //   164: getfield 92	com/tencent/TMG/audio/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   167: aload_0
    //   168: getfield 227	com/tencent/TMG/audio/AudioDeviceInterface:_tempBufRec	[B
    //   171: iconst_0
    //   172: iload_1
    //   173: invokevirtual 621	android/media/AudioRecord:read	([BII)I
    //   176: istore_3
    //   177: iload_3
    //   178: ifge +79 -> 257
    //   181: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   184: ifeq +64 -> 248
    //   187: new 237	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   194: astore 5
    //   196: aload 5
    //   198: ldc_w 623
    //   201: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 5
    //   207: iload_3
    //   208: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 5
    //   214: ldc_w 591
    //   217: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 5
    //   223: iload_1
    //   224: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 5
    //   230: ldc_w 593
    //   233: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: ldc 215
    //   239: iconst_0
    //   240: aload 5
    //   242: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: aload_0
    //   249: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   252: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   255: iconst_m1
    //   256: ireturn
    //   257: aload_0
    //   258: getfield 185	com/tencent/TMG/audio/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   261: aload_0
    //   262: getfield 227	com/tencent/TMG/audio/AudioDeviceInterface:_tempBufRec	[B
    //   265: iconst_0
    //   266: iload_3
    //   267: invokevirtual 613	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   270: pop
    //   271: getstatic 530	com/tencent/TMG/audio/AudioDeviceInterface:_dumpEnable	Z
    //   274: ifeq +37 -> 311
    //   277: aload_0
    //   278: getfield 143	com/tencent/TMG/audio/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   281: astore 5
    //   283: aload 5
    //   285: ifnull +26 -> 311
    //   288: aload_0
    //   289: getfield 143	com/tencent/TMG/audio/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   292: aload_0
    //   293: getfield 227	com/tencent/TMG/audio/AudioDeviceInterface:_tempBufRec	[B
    //   296: iconst_0
    //   297: iload_3
    //   298: invokevirtual 536	java/io/FileOutputStream:write	([BII)V
    //   301: goto +10 -> 311
    //   304: astore 5
    //   306: aload 5
    //   308: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   311: iload_3
    //   312: istore_2
    //   313: iload_3
    //   314: iload_1
    //   315: if_icmpeq +139 -> 454
    //   318: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   321: ifeq -73 -> 248
    //   324: new 237	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   331: astore 5
    //   333: aload 5
    //   335: ldc_w 625
    //   338: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload 5
    //   344: iload_3
    //   345: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload 5
    //   351: ldc_w 591
    //   354: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 5
    //   360: iload_1
    //   361: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload 5
    //   367: ldc_w 593
    //   370: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: ldc 215
    //   376: iconst_0
    //   377: aload 5
    //   379: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: goto -137 -> 248
    //   388: astore 5
    //   390: iload_3
    //   391: istore_1
    //   392: goto +12 -> 404
    //   395: astore 5
    //   397: goto +66 -> 463
    //   400: astore 5
    //   402: iconst_0
    //   403: istore_1
    //   404: iload_1
    //   405: istore_2
    //   406: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   409: ifeq +45 -> 454
    //   412: new 237	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   419: astore 6
    //   421: aload 6
    //   423: ldc_w 627
    //   426: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload 6
    //   432: aload 5
    //   434: invokevirtual 219	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   437: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: ldc 215
    //   443: iconst_0
    //   444: aload 6
    //   446: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   452: iload_1
    //   453: istore_2
    //   454: aload_0
    //   455: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   458: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   461: iload_2
    //   462: ireturn
    //   463: aload_0
    //   464: getfield 123	com/tencent/TMG/audio/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   467: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   470: goto +6 -> 476
    //   473: aload 5
    //   475: athrow
    //   476: goto -3 -> 473
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	AudioDeviceInterface
    //   0	479	1	paramInt	int
    //   312	150	2	i	int
    //   176	215	3	j	int
    //   86	6	4	bool	boolean
    //   20	48	5	localObject1	Object
    //   102	29	5	localException1	Exception
    //   194	90	5	localObject2	Object
    //   304	3	5	localIOException	java.io.IOException
    //   331	47	5	localStringBuilder1	StringBuilder
    //   388	1	5	localException2	Exception
    //   395	1	5	localObject3	Object
    //   400	74	5	localException3	Exception
    //   117	328	6	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   94	99	102	java/lang/Exception
    //   288	301	304	java/io/IOException
    //   181	248	388	java/lang/Exception
    //   257	283	388	java/lang/Exception
    //   288	301	388	java/lang/Exception
    //   306	311	388	java/lang/Exception
    //   318	385	388	java/lang/Exception
    //   61	67	395	finally
    //   82	88	395	finally
    //   94	99	395	finally
    //   104	150	395	finally
    //   150	155	395	finally
    //   155	177	395	finally
    //   181	248	395	finally
    //   257	283	395	finally
    //   288	301	395	finally
    //   306	311	395	finally
    //   318	385	395	finally
    //   406	452	395	finally
    //   61	67	400	java/lang/Exception
    //   82	88	400	java/lang/Exception
    //   104	150	400	java/lang/Exception
    //   150	155	400	java/lang/Exception
    //   155	177	400	java/lang/Exception
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
    if (this._audioManager == null)
    {
      localObject = this._context;
      if (localObject != null) {
        this._audioManager = ((AudioManager)((Context)localObject).getSystemService("audio"));
      }
    }
    int i = -1;
    Object localObject = this._audioManager;
    if (localObject != null)
    {
      ((AudioManager)localObject).setStreamVolume(0, paramInt, 0);
      i = 0;
    }
    return i;
  }
  
  private int StartPlayback()
  {
    boolean bool = this._isPlaying;
    int i = -1;
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "StartPlayback _isPlaying");
      }
      return -1;
    }
    Object localObject = this._audioTrack;
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StartPlayback _audioTrack:");
        ((StringBuilder)localObject).append(this._audioTrack);
        QLog.e("TRAE", 0, ((StringBuilder)localObject).toString());
      }
      return -1;
    }
    try
    {
      ((AudioTrack)localObject).play();
      if (_dumpEnable)
      {
        localObject = this._audioManager;
        if (localObject != null) {
          i = ((AudioManager)localObject).getMode();
        }
        this._play_dump = new File(getDumpFilePath("jniplay.pcm", i));
        try
        {
          this._play_out = new FileOutputStream(this._play_dump);
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
        }
      }
      this._isPlaying = true;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "StartPlayback ok");
      }
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "StartPlayback fail");
      }
      localIllegalStateException.printStackTrace();
    }
    return -1;
  }
  
  private int StartRecording()
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "StartRecording entry");
    }
    boolean bool = this._isRecording;
    int i = -1;
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StartRecording _isRecording:");
        ((StringBuilder)localObject).append(this._isRecording);
        QLog.e("TRAE", 0, ((StringBuilder)localObject).toString());
      }
      return -1;
    }
    Object localObject = this._audioRecord;
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StartRecording _audioRecord:");
        ((StringBuilder)localObject).append(this._audioRecord);
        QLog.e("TRAE", 0, ((StringBuilder)localObject).toString());
      }
      return -1;
    }
    try
    {
      ((AudioRecord)localObject).startRecording();
      if (_dumpEnable)
      {
        localObject = this._audioManager;
        if (localObject != null) {
          i = ((AudioManager)localObject).getMode();
        }
        this._rec_dump = new File(getDumpFilePath("jnirecord.pcm", i));
        try
        {
          this._rec_out = new FileOutputStream(this._rec_dump);
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
        }
      }
      this._isRecording = true;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "StartRecording ok");
      }
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "StartRecording fail");
      }
      localIllegalStateException.printStackTrace();
    }
    return -1;
  }
  
  private int StopPlayback()
  {
    StringBuilder localStringBuilder1;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("StopPlayback entry _isPlaying:");
      localStringBuilder1.append(this._isPlaying);
      QLog.w("TRAE", 0, localStringBuilder1.toString());
    }
    if (this._audioTrack == null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("StopPlayback _isPlaying:");
        localStringBuilder1.append(this._isPlaying);
        localStringBuilder1.append(" ");
        localStringBuilder1.append(this._audioTrack);
        QLog.e("TRAE", 0, localStringBuilder1.toString());
      }
      return -1;
    }
    this._playLock.lock();
    try
    {
      int i = this._audioTrack.getPlayState();
      if (i == 3) {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "StopPlayback stoping...");
          }
          this._audioTrack.stop();
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("StopPlayback flushing... state:");
            localStringBuilder1.append(this._audioTrack.getPlayState());
            QLog.w("TRAE", 0, localStringBuilder1.toString());
          }
          this._audioTrack.flush();
        }
        catch (IllegalStateException localIllegalStateException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 0, "StopPlayback err");
          }
          localIllegalStateException.printStackTrace();
          return -1;
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("StopPlayback releaseing... state:");
        localStringBuilder2.append(this._audioTrack.getPlayState());
        QLog.w("TRAE", 0, localStringBuilder2.toString());
      }
      this._audioTrack.release();
      this._audioTrack = null;
      this._isPlaying = false;
      this._playLock.unlock();
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "StopPlayback exit ok");
      }
      return 0;
    }
    finally
    {
      this._playLock.unlock();
    }
  }
  
  private int StopRecording()
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "StopRecording entry");
    }
    StringBuilder localStringBuilder1;
    if (this._audioRecord == null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("UnintRecord:");
        localStringBuilder1.append(this._audioRecord);
        QLog.e("TRAE", 0, localStringBuilder1.toString());
      }
      return -1;
    }
    this._recLock.lock();
    try
    {
      int i = this._audioRecord.getRecordingState();
      if (i == 3) {
        try
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("StopRecording stop... state:");
            localStringBuilder1.append(this._audioRecord.getRecordingState());
            QLog.w("TRAE", 0, localStringBuilder1.toString());
          }
          this._audioRecord.stop();
        }
        catch (IllegalStateException localIllegalStateException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 0, "StopRecording  err");
          }
          localIllegalStateException.printStackTrace();
          return -1;
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("StopRecording releaseing... state:");
        localStringBuilder2.append(this._audioRecord.getRecordingState());
        QLog.w("TRAE", 0, localStringBuilder2.toString());
      }
      this._audioRecord.release();
      this._audioRecord = null;
      this._isRecording = false;
      this._recLock.unlock();
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "StopRecording exit ok");
      }
      return 0;
    }
    finally
    {
      this._recLock.unlock();
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDecBuffer failed!! index:");
      localStringBuilder.append(paramInt);
      QLog.w("TRAE", 0, localStringBuilder.toString());
      return null;
    case 10: 
      return this._decBuffer10;
    case 9: 
      return this._decBuffer9;
    case 8: 
      return this._decBuffer8;
    case 7: 
      return this._decBuffer7;
    case 6: 
      return this._decBuffer6;
    case 5: 
      return this._decBuffer5;
    case 4: 
      return this._decBuffer4;
    case 3: 
      return this._decBuffer3;
    case 2: 
      return this._decBuffer2;
    case 1: 
      return this._decBuffer1;
    }
    return this._decBuffer0;
  }
  
  private String getDumpFilePath(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("manufacture:");
      localStringBuilder.append(Build.MANUFACTURER);
      QLog.w("TRAE", 0, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MODEL:");
      localStringBuilder.append(Build.MODEL);
      QLog.w("TRAE", 0, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/MF-");
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("-M-");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("-as-");
    localStringBuilder.append(TraeAudioManager.getAudioSource(this._audioSourcePolicy));
    localStringBuilder.append("-st-");
    localStringBuilder.append(this._streamType);
    localStringBuilder.append("-m-");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dump:");
      localStringBuilder.append(paramString);
      QLog.w("TRAE", 0, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dump replace:");
      localStringBuilder.append(paramString.replace(" ", "_"));
      QLog.w("TRAE", 0, localStringBuilder.toString());
    }
    return paramString.replace(" ", "_");
  }
  
  private int getLowlatencyFramesPerBuffer()
  {
    Object localObject;
    if ((this._context != null) && (Build.VERSION.SDK_INT >= 9))
    {
      boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LOW_LATENCY:");
        if (bool == true) {
          localObject = "Y";
        } else {
          localObject = "N";
        }
        localStringBuilder.append((String)localObject);
        QLog.w("TRAE", 0, localStringBuilder.toString());
      }
      if ((Build.VERSION.SDK_INT < 17) && (QLog.isColorLevel())) {
        QLog.e("TRAE", 0, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
      }
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getLowlatencySamplerate err, _context:");
      ((StringBuilder)localObject).append(this._context);
      ((StringBuilder)localObject).append(" api:");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      QLog.e("TRAE", 0, ((StringBuilder)localObject).toString());
    }
    return 0;
  }
  
  private int getLowlatencySamplerate()
  {
    Object localObject;
    if ((this._context != null) && (Build.VERSION.SDK_INT >= 9))
    {
      boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LOW_LATENCY:");
        if (bool == true) {
          localObject = "Y";
        } else {
          localObject = "N";
        }
        localStringBuilder.append((String)localObject);
        QLog.w("TRAE", 0, localStringBuilder.toString());
      }
      if (Build.VERSION.SDK_INT < 17)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
        }
        return 0;
      }
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "getLowlatencySamplerate not support right now!");
      }
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getLowlatencySamplerate err, _context:");
      ((StringBuilder)localObject).append(this._context);
      ((StringBuilder)localObject).append(" api:");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      QLog.e("TRAE", 0, ((StringBuilder)localObject).toString());
    }
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
    localStringBuffer.append("");
    localStringBuffer.append(arrayOfStackTraceElement[2].getClassName());
    localStringBuffer.append(".");
    localStringBuffer.append(arrayOfStackTraceElement[2].getMethodName());
    localStringBuffer.append(": ");
    localStringBuffer.append(arrayOfStackTraceElement[2].getLineNumber());
    return localStringBuffer.toString();
  }
  
  private void initTRAEAudioManager()
  {
    Context localContext = this._context;
    if (localContext != null)
    {
      TraeAudioManager.init(localContext);
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onOutputChanage:");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("TRAE", 0, ((StringBuilder)localObject).toString());
    }
    setAudioRouteSwitchState(paramString);
    if (!TraeAudioManager.isCloseSystemAPM(this._modePolicy)) {
      return;
    }
    int i = this._deviceStat;
    if ((i != 1) && (i != 5) && (i != 2))
    {
      if (i == 3) {
        return;
      }
      this._connectedDev = paramString;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" onOutputChanage:");
        localStringBuilder.append(paramString);
        if (this._audioManager == null)
        {
          localObject = " am==null";
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" mode:");
          ((StringBuilder)localObject).append(this._audioManager.getMode());
          localObject = ((StringBuilder)localObject).toString();
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" st:");
        localStringBuilder.append(this._streamType);
        if (this._audioTrack == null)
        {
          localObject = "_audioTrack==null";
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" at.st:");
          ((StringBuilder)localObject).append(this._audioTrack.getStreamType());
          localObject = ((StringBuilder)localObject).toString();
        }
        localStringBuilder.append((String)localObject);
        QLog.w("TRAE", 0, localStringBuilder.toString());
      }
      try
      {
        if (this._audioManager == null) {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" curr mode:");
          ((StringBuilder)localObject).append(paramString);
          if (this._audioManager == null)
          {
            paramString = "am==null";
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append(" mode:");
            paramString.append(this._audioManager.getMode());
            paramString = paramString.toString();
          }
          ((StringBuilder)localObject).append(paramString);
          QLog.w("TRAE", 0, ((StringBuilder)localObject).toString());
        }
        if ((this._audioManager != null) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
          this._audioManager.setMode(0);
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, paramString.getMessage());
        }
      }
      this._audioRouteChanged = true;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initTRAEAudioManager , TraeAudioSession startService: ");
      ((StringBuilder)localObject).append(this._asAudioManager);
      ((StringBuilder)localObject).append(" deviceConfig:");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("TRAE", 0, ((StringBuilder)localObject).toString());
    }
    Object localObject = this._asAudioManager;
    if (localObject != null) {
      return ((TraeAudioSession)localObject).startService(paramString);
    }
    return -1;
  }
  
  private int stopService()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initTRAEAudioManager , TraeAudioSession stopService: ");
      ((StringBuilder)localObject).append(this._asAudioManager);
      QLog.w("TRAE", 0, ((StringBuilder)localObject).toString());
    }
    Object localObject = this._asAudioManager;
    if (localObject != null) {
      return ((TraeAudioSession)localObject).stopService();
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
      TraeAudioSession localTraeAudioSession = this._asAudioManager;
      if (localTraeAudioSession != null)
      {
        localTraeAudioSession.release();
        this._asAudioManager = null;
      }
      TraeAudioManager.uninit();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "uninitTRAEAudioManager , context null");
    }
  }
  
  public int call_postprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    TraeAudioSession localTraeAudioSession = this._as;
    if (localTraeAudioSession != null)
    {
      localTraeAudioSession.voiceCallPostprocess();
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
    TraeAudioSession localTraeAudioSession = this._as;
    if (localTraeAudioSession != null)
    {
      localTraeAudioSession.release();
      this._as = null;
    }
    TraeAudioManager.IsUpdateSceneFlag = false;
    LogTraceExit();
    return 0;
  }
  
  /* Error */
  public int call_preprocess()
  {
    // Byte code:
    //   0: ldc_w 806
    //   3: invokestatic 892	com/tencent/TMG/audio/AudioDeviceInterface:LogTraceEntry	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 173	com/tencent/TMG/audio/AudioDeviceInterface:switchState	I
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 114	com/tencent/TMG/audio/AudioDeviceInterface:_audioStreamTypePolicy	I
    //   16: invokestatic 324	com/tencent/TMG/audio/TraeAudioManager:getAudioStreamType	(I)I
    //   19: putfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   22: aload_0
    //   23: getfield 153	com/tencent/TMG/audio/AudioDeviceInterface:_as	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   26: ifnonnull +26 -> 52
    //   29: aload_0
    //   30: new 370	com/tencent/TMG/audio/TraeAudioSession
    //   33: dup
    //   34: aload_0
    //   35: getfield 108	com/tencent/TMG/audio/AudioDeviceInterface:_context	Landroid/content/Context;
    //   38: new 903	com/tencent/TMG/audio/AudioDeviceInterface$1
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 904	com/tencent/TMG/audio/AudioDeviceInterface$1:<init>	(Lcom/tencent/TMG/audio/AudioDeviceInterface;)V
    //   46: invokespecial 843	com/tencent/TMG/audio/TraeAudioSession:<init>	(Landroid/content/Context;Lcom/tencent/TMG/audio/TraeAudioSession$ITraeAudioCallback;)V
    //   49: putfield 153	com/tencent/TMG/audio/AudioDeviceInterface:_as	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 169	com/tencent/TMG/audio/AudioDeviceInterface:_preDone	Z
    //   57: aload_0
    //   58: getfield 153	com/tencent/TMG/audio/AudioDeviceInterface:_as	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   61: ifnull +300 -> 361
    //   64: aload_0
    //   65: getfield 161	com/tencent/TMG/audio/AudioDeviceInterface:_prelock	Ljava/util/concurrent/locks/ReentrantLock;
    //   68: invokevirtual 518	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   71: aload_0
    //   72: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   75: ifnonnull +20 -> 95
    //   78: aload_0
    //   79: aload_0
    //   80: getfield 108	com/tencent/TMG/audio/AudioDeviceInterface:_context	Landroid/content/Context;
    //   83: ldc_w 289
    //   86: invokevirtual 295	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   89: checkcast 297	android/media/AudioManager
    //   92: putfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   95: aload_0
    //   96: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   99: astore_2
    //   100: aload_2
    //   101: ifnull +121 -> 222
    //   104: aload_0
    //   105: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   108: invokevirtual 334	android/media/AudioManager:getMode	()I
    //   111: iconst_2
    //   112: if_icmpne +77 -> 189
    //   115: iconst_5
    //   116: istore_1
    //   117: iload_1
    //   118: ifle +71 -> 189
    //   121: aload_0
    //   122: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   125: invokevirtual 334	android/media/AudioManager:getMode	()I
    //   128: iconst_2
    //   129: if_icmpne +60 -> 189
    //   132: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   135: ifeq +41 -> 176
    //   138: new 237	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   145: astore_2
    //   146: aload_2
    //   147: ldc_w 906
    //   150: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_2
    //   155: aload_0
    //   156: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   159: invokevirtual 334	android/media/AudioManager:getMode	()I
    //   162: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: ldc 215
    //   168: iconst_0
    //   169: aload_2
    //   170: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: ldc2_w 907
    //   179: invokestatic 913	java/lang/Thread:sleep	(J)V
    //   182: iload_1
    //   183: iconst_1
    //   184: isub
    //   185: istore_1
    //   186: goto -69 -> 117
    //   189: aload_0
    //   190: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   193: invokevirtual 916	android/media/AudioManager:isMicrophoneMute	()Z
    //   196: ifeq +26 -> 222
    //   199: aload_0
    //   200: getfield 116	com/tencent/TMG/audio/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   203: iconst_0
    //   204: invokevirtual 920	android/media/AudioManager:setMicrophoneMute	(Z)V
    //   207: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   210: ifeq +12 -> 222
    //   213: ldc 215
    //   215: iconst_0
    //   216: ldc_w 922
    //   219: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_0
    //   223: getfield 153	com/tencent/TMG/audio/AudioDeviceInterface:_as	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   226: aload_0
    //   227: getfield 110	com/tencent/TMG/audio/AudioDeviceInterface:_modePolicy	I
    //   230: aload_0
    //   231: getfield 94	com/tencent/TMG/audio/AudioDeviceInterface:_streamType	I
    //   234: invokevirtual 925	com/tencent/TMG/audio/TraeAudioSession:voiceCallPreprocess	(II)I
    //   237: pop
    //   238: aload_0
    //   239: getfield 153	com/tencent/TMG/audio/AudioDeviceInterface:_as	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   242: invokevirtual 928	com/tencent/TMG/audio/TraeAudioSession:connectHighestPriorityDevice	()I
    //   245: pop
    //   246: bipush 7
    //   248: istore_1
    //   249: iload_1
    //   250: ifle +68 -> 318
    //   253: aload_0
    //   254: getfield 169	com/tencent/TMG/audio/AudioDeviceInterface:_preDone	Z
    //   257: ifne +61 -> 318
    //   260: aload_0
    //   261: getfield 167	com/tencent/TMG/audio/AudioDeviceInterface:_precon	Ljava/util/concurrent/locks/Condition;
    //   264: lconst_1
    //   265: getstatic 934	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   268: invokeinterface 940 4 0
    //   273: pop
    //   274: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   277: ifeq +97 -> 374
    //   280: new 237	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   287: astore_2
    //   288: aload_2
    //   289: ldc_w 942
    //   292: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_2
    //   297: aload_0
    //   298: getfield 153	com/tencent/TMG/audio/AudioDeviceInterface:_as	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   301: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: ldc 215
    //   307: iconst_0
    //   308: aload_2
    //   309: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: goto +59 -> 374
    //   318: invokestatic 213	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   321: ifeq +12 -> 333
    //   324: ldc 215
    //   326: iconst_0
    //   327: ldc_w 944
    //   330: invokestatic 400	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload_0
    //   334: getfield 153	com/tencent/TMG/audio/AudioDeviceInterface:_as	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   337: invokevirtual 947	com/tencent/TMG/audio/TraeAudioSession:getConnectedDevice	()I
    //   340: pop
    //   341: goto +13 -> 354
    //   344: astore_2
    //   345: aload_0
    //   346: getfield 161	com/tencent/TMG/audio/AudioDeviceInterface:_prelock	Ljava/util/concurrent/locks/ReentrantLock;
    //   349: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   352: aload_2
    //   353: athrow
    //   354: aload_0
    //   355: getfield 161	com/tencent/TMG/audio/AudioDeviceInterface:_prelock	Ljava/util/concurrent/locks/ReentrantLock;
    //   358: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   361: invokestatic 897	com/tencent/TMG/audio/AudioDeviceInterface:LogTraceExit	()V
    //   364: iconst_0
    //   365: ireturn
    //   366: astore_2
    //   367: goto -13 -> 354
    //   370: astore_2
    //   371: goto -38 -> 333
    //   374: iload_1
    //   375: iconst_1
    //   376: isub
    //   377: istore_1
    //   378: goto -129 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	AudioDeviceInterface
    //   116	262	1	i	int
    //   99	210	2	localObject1	Object
    //   344	9	2	localObject2	Object
    //   366	1	2	localInterruptedException1	InterruptedException
    //   370	1	2	localInterruptedException2	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   71	95	344	finally
    //   95	100	344	finally
    //   104	115	344	finally
    //   121	176	344	finally
    //   176	182	344	finally
    //   189	222	344	finally
    //   222	246	344	finally
    //   253	315	344	finally
    //   318	333	344	finally
    //   333	341	344	finally
    //   71	95	366	java/lang/InterruptedException
    //   95	100	366	java/lang/InterruptedException
    //   104	115	366	java/lang/InterruptedException
    //   121	176	366	java/lang/InterruptedException
    //   176	182	366	java/lang/InterruptedException
    //   189	222	366	java/lang/InterruptedException
    //   222	246	366	java/lang/InterruptedException
    //   333	341	366	java/lang/InterruptedException
    //   253	315	370	java/lang/InterruptedException
    //   318	333	370	java/lang/InterruptedException
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
      Object localObject = this._audioManager;
      if (localObject != null)
      {
        if (this._audioManager.getMode() == 2)
        {
          int i = 5;
          while ((i > 0) && (this._audioManager.getMode() == 2))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("media call_preprocess_media waiting...  mode:");
              ((StringBuilder)localObject).append(this._audioManager.getMode());
              QLog.e("TRAE", 0, ((StringBuilder)localObject).toString());
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
      label248:
      LogTraceExit();
    }
    catch (InterruptedException localInterruptedException)
    {
      break label248;
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
    if (paramInt == 0) {
      this.usingJava = false;
    } else {
      this.usingJava = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setJavaInterface flg:");
      localStringBuilder.append(paramInt);
      QLog.w("TRAE", 0, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.AudioDeviceInterface
 * JD-Core Version:    0.7.0.1
 */