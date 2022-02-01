package com.tencent.TMG.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class TraeAudioManager$TraeAudioManagerLooper
  extends Thread
{
  public static final int MESSAGE_AUTO_DEVICELIST_PLUGIN_UPDATE = 32786;
  public static final int MESSAGE_AUTO_DEVICELIST_PLUGOUT_UPDATE = 32787;
  public static final int MESSAGE_AUTO_DEVICELIST_UPDATE = 32785;
  public static final int MESSAGE_BEGIN = 32768;
  public static final int MESSAGE_CONNECTDEVICE = 32775;
  public static final int MESSAGE_CONNECT_HIGHEST_PRIORITY_DEVICE = 32789;
  public static final int MESSAGE_DISABLE = 32773;
  public static final int MESSAGE_EARACTION = 32776;
  public static final int MESSAGE_ENABLE = 32772;
  public static final int MESSAGE_GETCONNECTEDDEVICE = 32778;
  public static final int MESSAGE_GETCONNECTINGDEVICE = 32779;
  public static final int MESSAGE_GETDEVICELIST = 32774;
  public static final int MESSAGE_GETSTREAMTYPE = 32784;
  public static final int MESSAGE_ISDEVICECHANGABLED = 32777;
  public static final int MESSAGE_RECOVER_AUDIO_FOCUS = 32791;
  public static final int MESSAGE_REQUEST_RELEASE_AUDIO_FOCUS = 32790;
  public static final int MESSAGE_STARTRING = 32782;
  public static final int MESSAGE_STOPRING = 32783;
  public static final int MESSAGE_VOICECALLPOSTPROCESS = 32781;
  public static final int MESSAGE_VOICECALLPREPROCESS = 32780;
  public static final int MESSAGE_VOICECALL_AUIDOPARAM_CHANGED = 32788;
  boolean _enabled = false;
  int _focusSteamType = 0;
  String _lastCfg = "";
  TraeAudioManager _parent = null;
  int _preRingMode = 0;
  int _preServiceMode = 0;
  String _ringOperation = "";
  TraeMediaPlayer _ringPlayer = null;
  long _ringSessionID = -1L;
  String _ringUserdata = "";
  final boolean[] _started = { false };
  String _voiceCallOperation = "";
  long _voiceCallSessionID = -1L;
  AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = null;
  Handler mMsgHandler = null;
  
  public TraeAudioManager$TraeAudioManagerLooper(TraeAudioManager arg1, TraeAudioManager paramTraeAudioManager2)
  {
    this._parent = paramTraeAudioManager2;
    long l = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 0, "TraeAudioManagerLooper start...");
    }
    start();
    synchronized (this._started)
    {
      int i = this._started[0];
      if (i != 0) {}
    }
    try
    {
      this._started.wait(3000L);
      label155:
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("  start used:");
        ???.append(SystemClock.elapsedRealtime() - l);
        ???.append("ms");
        QLog.e("TRAE", 0, ???.toString());
      }
      return;
      paramTraeAudioManager2 = finally;
      throw paramTraeAudioManager2;
    }
    catch (InterruptedException paramTraeAudioManager2)
    {
      break label155;
    }
  }
  
  int InternalGetStreamType(HashMap<String, Object> paramHashMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" activeMode:");
    ((StringBuilder)localObject).append(this.this$0._activeMode);
    ((StringBuilder)localObject).append(" _preRingMode:");
    ((StringBuilder)localObject).append(this._preRingMode);
    AudioDeviceInterface.LogTraceEntry(((StringBuilder)localObject).toString());
    if (this.this$0._am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, " InternalStopRing am==null!!");
      }
      return -1;
    }
    int i;
    if (this.this$0._activeMode == 2) {
      i = this._ringPlayer.getStreamType();
    } else {
      i = this.this$0._streamType;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("EXTRA_DATA_STREAMTYPE", i);
    this.this$0.sendResBroadcast((Intent)localObject, paramHashMap, 0);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  int InternalNotifyStreamTypeUpdate(int paramInt)
  {
    if (this.this$0._context == null) {
      return -1;
    }
    new Handler(Looper.getMainLooper()).post(new TraeAudioManager.TraeAudioManagerLooper.4(this, paramInt));
    return 0;
  }
  
  int InternalSessionGetDeviceList(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    Object localObject = this.this$0._deviceConfigManager.getSnapParams();
    ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
    localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
    localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)localObject);
    localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", this.this$0._deviceConfigManager.getBluetoothName());
    this.this$0.sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int InternalStartRing(HashMap<String, Object> paramHashMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" activeMode:");
    ((StringBuilder)localObject).append(this.this$0._activeMode);
    AudioDeviceInterface.LogTraceEntry(((StringBuilder)localObject).toString());
    if (this.this$0._am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, " InternalStartRing am==null!!");
      }
      return -1;
    }
    if (this.this$0._activeMode == 2) {
      interruptRing();
    }
    try
    {
      this._ringSessionID = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
      this._ringOperation = ((String)paramHashMap.get("PARAM_OPERATION"));
      this._ringUserdata = ((String)paramHashMap.get("PARAM_RING_USERDATA_STRING"));
      int i = ((Integer)paramHashMap.get("PARAM_RING_DATASOURCE")).intValue();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("  dataSource:");
        ((StringBuilder)localObject).append(i);
        QLog.w("TRAE", 0, ((StringBuilder)localObject).toString());
      }
      int j = ((Integer)paramHashMap.get("PARAM_RING_RSID")).intValue();
      localObject = (Uri)paramHashMap.get("PARAM_RING_URI");
      String str = (String)paramHashMap.get("PARAM_RING_FILEPATH");
      boolean bool2 = ((Boolean)paramHashMap.get("PARAM_RING_LOOP")).booleanValue();
      int k = ((Integer)paramHashMap.get("PARAM_RING_LOOPCOUNT")).intValue();
      boolean bool3 = ((Boolean)paramHashMap.get("PARAM_RING_MODE")).booleanValue();
      if (this.this$0._activeMode != 1) {
        this.this$0._activeMode = 2;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
      this.this$0.sendResBroadcast(localIntent, paramHashMap, 0);
      this._preRingMode = this.this$0._am.getMode();
      paramHashMap = this._ringPlayer;
      boolean bool1;
      if (this.this$0._activeMode == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramHashMap.playRing(i, j, (Uri)localObject, str, bool2, k, bool3, bool1, this.this$0._streamType);
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append(" _ringUserdata:");
        paramHashMap.append(this._ringUserdata);
        paramHashMap.append(" DurationMS:");
        paramHashMap.append(this._ringPlayer.getDuration());
        QLog.w("TRAE", 0, paramHashMap.toString());
      }
      if (!this._ringPlayer.hasCall()) {
        requestAudioFocus(this._ringPlayer.getStreamType());
      }
      InternalNotifyStreamTypeUpdate(this._ringPlayer.getStreamType());
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    catch (Exception paramHashMap)
    {
      label482:
      break label482;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 0, " startRing err params");
    }
    return -1;
  }
  
  int InternalStopRing(HashMap<String, Object> paramHashMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" activeMode:");
    ((StringBuilder)localObject).append(this.this$0._activeMode);
    ((StringBuilder)localObject).append(" _preRingMode:");
    ((StringBuilder)localObject).append(this._preRingMode);
    AudioDeviceInterface.LogTraceEntry(((StringBuilder)localObject).toString());
    if (this.this$0._am != null)
    {
      localObject = this._ringPlayer;
      if (localObject != null)
      {
        ((TraeMediaPlayer)localObject).stopRing();
        if ((!this._ringPlayer.hasCall()) && (this.this$0._activeMode == 2))
        {
          abandonAudioFocus();
          this.this$0._activeMode = 0;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
        this.this$0.sendResBroadcast((Intent)localObject, paramHashMap, 0);
        AudioDeviceInterface.LogTraceExit();
        return 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 0, " InternalStopRing am==null!!");
    }
    return -1;
  }
  
  int InternalVoicecallPostprocess(HashMap<String, Object> paramHashMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" activeMode:");
    ((StringBuilder)localObject).append(this.this$0._activeMode);
    AudioDeviceInterface.LogTraceEntry(((StringBuilder)localObject).toString());
    if (this.this$0._am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, " InternalVoicecallPostprocess am==null!!");
      }
      return -1;
    }
    if (this.this$0._activeMode != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, " not ACTIVE_VOICECALL!!");
      }
      localObject = new Intent();
      this.this$0.sendResBroadcast((Intent)localObject, paramHashMap, 3);
      return -1;
    }
    this.this$0._activeMode = 0;
    abandonAudioFocus();
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  int InternalVoicecallPreprocess(HashMap<String, Object> paramHashMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" activeMode:");
    ((StringBuilder)localObject).append(this.this$0._activeMode);
    AudioDeviceInterface.LogTraceEntry(((StringBuilder)localObject).toString());
    if (paramHashMap == null) {
      return -1;
    }
    if (this.this$0._am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, " InternalVoicecallPreprocess am==null!!");
      }
      return -1;
    }
    if (this.this$0._activeMode == 1)
    {
      localObject = new Intent();
      this.this$0.sendResBroadcast((Intent)localObject, paramHashMap, 2);
      return -1;
    }
    this._voiceCallSessionID = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
    this._voiceCallOperation = ((String)paramHashMap.get("PARAM_OPERATION"));
    localObject = this.this$0;
    ((TraeAudioManager)localObject)._activeMode = 1;
    ((TraeAudioManager)localObject)._prevMode = ((TraeAudioManager)localObject)._am.getMode();
    localObject = (Integer)paramHashMap.get("PARAM_MODEPOLICY");
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, " params.get(PARAM_MODEPOLICY)==null!!");
      }
      this.this$0._modePolicy = -1;
    }
    else
    {
      this.this$0._modePolicy = ((Integer)localObject).intValue();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("  _modePolicy:");
      ((StringBuilder)localObject).append(this.this$0._modePolicy);
      QLog.e("TRAE", 0, ((StringBuilder)localObject).toString());
    }
    localObject = (Integer)paramHashMap.get("PARAM_STREAMTYPE");
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, " params.get(PARAM_STREAMTYPE)==null!!");
      }
      this.this$0._streamType = 0;
    }
    else
    {
      this.this$0._streamType = ((Integer)localObject).intValue();
    }
    if ((TraeAudioManager.isCloseSystemAPM(this.this$0._modePolicy)) && (this.this$0._activeMode != 2) && (this.this$0._deviceConfigManager != null))
    {
      if (this.this$0._deviceConfigManager.getConnectedDevice().equals("DEVICE_SPEAKERPHONE"))
      {
        this.this$0.InternalSetMode(0);
        requestAudioFocus(3);
      }
      else
      {
        this.this$0.InternalSetMode(3);
        requestAudioFocus(0);
      }
    }
    else
    {
      localObject = this.this$0;
      ((TraeAudioManager)localObject).InternalSetMode(TraeAudioManager.getCallAudioMode(((TraeAudioManager)localObject)._modePolicy));
      requestAudioFocus(this.this$0._streamType);
    }
    localObject = new Intent();
    this.this$0.sendResBroadcast((Intent)localObject, paramHashMap, 0);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  void _init()
  {
    AudioDeviceInterface.LogTraceEntry("");
    try
    {
      this.this$0._audioSessionHost = new TraeAudioSessionHost();
      this.this$0._deviceConfigManager = new TraeAudioManager.DeviceConfigManager(this.this$0);
      TraeAudioManager._gHostProcessId = Process.myPid();
      this.this$0._am = ((AudioManager)this.this$0._context.getSystemService("audio"));
      this.this$0._bluetoothCheck = this.this$0.CreateBluetoothCheck(this.this$0._context, this.this$0._deviceConfigManager);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
      this.this$0._bluetoothCheck.addAction(localIntentFilter);
      localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      this.this$0._context.registerReceiver(this._parent, localIntentFilter);
    }
    catch (Exception localException)
    {
      label153:
      break label153;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "======7");
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  void _post_stopService()
  {
    try
    {
      if (this.this$0._bluetoothCheck != null) {
        this.this$0._bluetoothCheck.release();
      }
      this.this$0._bluetoothCheck = null;
      if (this.this$0._context != null)
      {
        this.this$0._context.unregisterReceiver(this._parent);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        this.this$0._context.registerReceiver(this._parent, localIntentFilter);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  void _prev_startService()
  {
    try
    {
      this.this$0._am = ((AudioManager)this.this$0._context.getSystemService("audio"));
      if (this.this$0._bluetoothCheck == null) {
        this.this$0._bluetoothCheck = this.this$0.CreateBluetoothCheck(this.this$0._context, this.this$0._deviceConfigManager);
      }
      this.this$0._context.unregisterReceiver(this._parent);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
      this.this$0._bluetoothCheck.addAction(localIntentFilter);
      localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      this.this$0._context.registerReceiver(this._parent, localIntentFilter);
      return;
    }
    catch (Exception localException) {}
  }
  
  void _uninit()
  {
    AudioDeviceInterface.LogTraceEntry("");
    try
    {
      stopService();
      if (this.this$0._bluetoothCheck != null) {
        this.this$0._bluetoothCheck.release();
      }
      this.this$0._bluetoothCheck = null;
      if (this.this$0._context != null)
      {
        this.this$0._context.unregisterReceiver(this._parent);
        this.this$0._context = null;
      }
      if (this.this$0._deviceConfigManager != null) {
        this.this$0._deviceConfigManager.clearConfig();
      }
      this.this$0._deviceConfigManager = null;
      label97:
      AudioDeviceInterface.LogTraceExit();
    }
    catch (Exception localException)
    {
      break label97;
    }
  }
  
  @TargetApi(8)
  void abandonAudioFocus()
  {
    if (Build.VERSION.SDK_INT <= 8) {
      return;
    }
    if ((this.this$0._am != null) && (this.mAudioFocusChangeListener != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("-------abandonAudioFocus _focusSteamType:");
        localStringBuilder.append(this._focusSteamType);
        QLog.w("TRAE", 0, localStringBuilder.toString());
      }
      this.this$0._am.abandonAudioFocus(this.mAudioFocusChangeListener);
      this.mAudioFocusChangeListener = null;
    }
  }
  
  int interruptRing()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" activeMode:");
    ((StringBuilder)localObject).append(this.this$0._activeMode);
    ((StringBuilder)localObject).append(" _preRingMode:");
    ((StringBuilder)localObject).append(this._preRingMode);
    AudioDeviceInterface.LogTraceEntry(((StringBuilder)localObject).toString());
    if (this.this$0._am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, " interruptRing am==null!!");
      }
      return -1;
    }
    if (this.this$0._activeMode != 2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, " not ACTIVE_RING!!");
      }
      return -1;
    }
    this._ringPlayer.stopRing();
    abandonAudioFocus();
    this.this$0._activeMode = 0;
    localObject = new HashMap();
    ((HashMap)localObject).put("PARAM_SESSIONID", Long.valueOf(this._ringSessionID));
    ((HashMap)localObject).put("PARAM_OPERATION", this._ringOperation);
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
    this.this$0.sendResBroadcast(localIntent, (HashMap)localObject, 4);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  int interruptVoicecallPostprocess()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" activeMode:");
    ((StringBuilder)localObject).append(this.this$0._activeMode);
    AudioDeviceInterface.LogTraceEntry(((StringBuilder)localObject).toString());
    if (this.this$0._am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, " am==null!!");
      }
      return -1;
    }
    if (this.this$0._activeMode != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, " not ACTIVE_RING!!");
      }
      return -1;
    }
    localObject = this.this$0;
    ((TraeAudioManager)localObject)._activeMode = 0;
    if (((TraeAudioManager)localObject)._prevMode != -1)
    {
      localObject = this.this$0;
      ((TraeAudioManager)localObject).InternalSetMode(((TraeAudioManager)localObject)._prevMode);
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("PARAM_SESSIONID", Long.valueOf(this._voiceCallSessionID));
    ((HashMap)localObject).put("PARAM_OPERATION", this._voiceCallOperation);
    Intent localIntent = new Intent();
    this.this$0.sendResBroadcast(localIntent, (HashMap)localObject, 6);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  boolean isNeedForceVolumeType()
  {
    if (Build.MANUFACTURER.equals("Xiaomi"))
    {
      if (Build.MODEL.equals("MI 5")) {
        return true;
      }
      if (Build.MODEL.equals("MI 5s")) {
        return true;
      }
      if (Build.MODEL.equals("MI 5s Plus")) {
        return true;
      }
    }
    return false;
  }
  
  void notifyRingCompletion()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this._ringSessionID));
    localHashMap.put("PARAM_OPERATION", "NOTIFY_RING_COMPLETION");
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
    this.this$0.sendResBroadcast(localIntent, localHashMap, 0);
  }
  
  int notifyServiceState(boolean paramBoolean)
  {
    if (this.this$0._context == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_SERVICE_STATE");
    localIntent.putExtra("NOTIFY_SERVICE_STATE_DATE", paramBoolean);
    if (this.this$0._context != null) {
      this.this$0._context.sendBroadcast(localIntent);
    }
    return 0;
  }
  
  public void quit()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.mMsgHandler == null) {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.mMsgHandler.getLooper().quit();
    synchronized (this._started)
    {
      int i = this._started[0];
      if (i != 1) {}
    }
    try
    {
      this._started.wait(10000L);
      label58:
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("  quit used:");
        ((StringBuilder)???).append(SystemClock.elapsedRealtime() - l);
        ((StringBuilder)???).append("ms");
        QLog.e("TRAE", 0, ((StringBuilder)???).toString());
      }
      this.mMsgHandler = null;
      AudioDeviceInterface.LogTraceExit();
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label58;
    }
  }
  
  @TargetApi(8)
  void requestAudioFocus(int paramInt)
  {
    if (Build.VERSION.SDK_INT <= 8) {
      return;
    }
    if (this.mAudioFocusChangeListener == null)
    {
      this.mAudioFocusChangeListener = new TraeAudioManager.TraeAudioManagerLooper.3(this);
      if (this.this$0._am != null) {
        try
        {
          int i = this.this$0._am.requestAudioFocus(this.mAudioFocusChangeListener, paramInt, 1);
          StringBuilder localStringBuilder;
          if ((i != 1) && (QLog.isColorLevel()))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("request audio focus fail. ");
            localStringBuilder.append(i);
            localStringBuilder.append(" mode:");
            localStringBuilder.append(this.this$0._am.getMode());
            QLog.e("TRAE", 0, localStringBuilder.toString());
          }
          this._focusSteamType = paramInt;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("-------requestAudioFocus _focusSteamType:");
            localStringBuilder.append(this._focusSteamType);
            QLog.w("TRAE", 0, localStringBuilder.toString());
            return;
          }
        }
        catch (SecurityException localSecurityException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 0, "request audio focus exception. ", localSecurityException);
          }
        }
      }
    }
  }
  
  public void run()
  {
    AudioDeviceInterface.LogTraceEntry("");
    Looper.prepare();
    this.mMsgHandler = new TraeAudioManager.TraeAudioManagerLooper.2(this);
    _init();
    synchronized (this._started)
    {
      this._started[0] = true;
      this._started.notifyAll();
      Looper.loop();
      _uninit();
      synchronized (this._started)
      {
        this._started[0] = false;
        this._started.notifyAll();
        AudioDeviceInterface.LogTraceExit();
        return;
      }
    }
  }
  
  public int sendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    Object localObject = this.mMsgHandler;
    int i = -1;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" fail mMsgHandler==null _enabled:");
      if (this._enabled) {
        paramHashMap = "Y";
      } else {
        paramHashMap = "N";
      }
      ((StringBuilder)localObject).append(paramHashMap);
      ((StringBuilder)localObject).append(" activeMode:");
      ((StringBuilder)localObject).append(this.this$0._activeMode);
      ((StringBuilder)localObject).append(" msg:");
      ((StringBuilder)localObject).append(paramInt);
      AudioDeviceInterface.LogTraceEntry(((StringBuilder)localObject).toString());
      return -1;
    }
    paramHashMap = Message.obtain((Handler)localObject, paramInt, paramHashMap);
    paramInt = i;
    if (this.mMsgHandler.sendMessage(paramHashMap)) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  void startService(HashMap<String, Object> paramHashMap)
  {
    String str = (String)paramHashMap.get("EXTRA_DATA_DEVICECONFIG");
    paramHashMap = new StringBuilder();
    paramHashMap.append("startService cfg:");
    paramHashMap.append(str);
    Log.w("TRAE", paramHashMap.toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" _enabled:");
    if (this._enabled) {
      paramHashMap = "Y";
    } else {
      paramHashMap = "N";
    }
    localStringBuilder.append(paramHashMap);
    localStringBuilder.append(" activeMode:");
    localStringBuilder.append(this.this$0._activeMode);
    localStringBuilder.append(" cfg:");
    localStringBuilder.append(str);
    AudioDeviceInterface.LogTraceEntry(localStringBuilder.toString());
    if (this.this$0._context == null) {
      return;
    }
    paramHashMap = new StringBuilder();
    paramHashMap.append("   startService:");
    paramHashMap.append(str);
    QLog.w("TRAE", 0, paramHashMap.toString());
    if (((this._enabled) && (this._lastCfg.equals(str))) || (this.this$0._activeMode != 0)) {
      return;
    }
    if (this._enabled) {
      stopService();
    }
    _prev_startService();
    paramHashMap = (AudioManager)this.this$0._context.getSystemService("audio");
    this.this$0._deviceConfigManager.clearConfig();
    this.this$0._deviceConfigManager.init(str);
    this._lastCfg = str;
    if (this.this$0._am != null) {
      this._preServiceMode = this.this$0._am.getMode();
    }
    this._enabled = true;
    if (this._ringPlayer == null) {
      this._ringPlayer = new TraeMediaPlayer(this.this$0._context, new TraeAudioManager.TraeAudioManagerLooper.1(this));
    }
    notifyServiceState(this._enabled);
    this.this$0.updateDeviceStatus();
    AudioDeviceInterface.LogTraceExit();
  }
  
  void stopService()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" _enabled:");
    if (this._enabled) {
      localObject = "Y";
    } else {
      localObject = "N";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" activeMode:");
    localStringBuilder.append(this.this$0._activeMode);
    AudioDeviceInterface.LogTraceEntry(localStringBuilder.toString());
    if (!this._enabled) {
      return;
    }
    if (this.this$0._activeMode == 1) {
      interruptVoicecallPostprocess();
    } else if (this.this$0._activeMode == 2) {
      interruptRing();
    }
    if (this.this$0._switchThread != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("_switchThread:");
        ((StringBuilder)localObject).append(this.this$0._switchThread.getDeviceName());
        QLog.w("TRAE", 0, ((StringBuilder)localObject).toString());
      }
      this.this$0._switchThread.quit();
      this.this$0._switchThread = null;
    }
    Object localObject = this._ringPlayer;
    if (localObject != null) {
      ((TraeMediaPlayer)localObject).stopRing();
    }
    this._ringPlayer = null;
    this._enabled = false;
    notifyServiceState(this._enabled);
    if ((this.this$0._am != null) && (this.this$0._context != null)) {}
    try
    {
      this.this$0.InternalSetMode(0);
      if (isNeedForceVolumeType())
      {
        QLog.w("TRAE", 0, "NeedForceVolumeType: AudioManager.STREAM_MUSIC");
        TraeAudioManager.forceVolumeControlStream(this.this$0._am, 3);
      }
      label271:
      _post_stopService();
      AudioDeviceInterface.LogTraceExit();
      return;
    }
    catch (Exception localException)
    {
      break label271;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.TraeAudioManagerLooper
 * JD-Core Version:    0.7.0.1
 */