package com.tencent.TMG.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
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
import android.text.TextUtils;
import android.util.Log;
import com.tencent.TMG.utils.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

@SuppressLint({"NewApi"})
public class TraeAudioManager
  extends BroadcastReceiver
{
  public static final String ACTION_TRAEAUDIOMANAGER_NOTIFY = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY";
  public static final String ACTION_TRAEAUDIOMANAGER_REQUEST = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST";
  public static final String ACTION_TRAEAUDIOMANAGER_RES = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES";
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP = 128;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 256;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 512;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO = 16;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 64;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 32;
  static final int AUDIO_DEVICE_OUT_EARPIECE = 1;
  static final int AUDIO_DEVICE_OUT_SPEAKER = 2;
  static final int AUDIO_DEVICE_OUT_WIRED_HEADPHONE = 8;
  static final int AUDIO_DEVICE_OUT_WIRED_HEADSET = 4;
  public static final int AUDIO_MANAGER_ACTIVE_NONE = 0;
  public static final int AUDIO_MANAGER_ACTIVE_RING = 2;
  public static final int AUDIO_MANAGER_ACTIVE_VOICECALL = 1;
  static final String AUDIO_PARAMETER_STREAM_ROUTING = "routing";
  public static final String CONNECTDEVICE_DEVICENAME = "CONNECTDEVICE_DEVICENAME";
  public static final String CONNECTDEVICE_RESULT_DEVICENAME = "CONNECTDEVICE_RESULT_DEVICENAME";
  public static final String DEVICE_BLUETOOTHHEADSET = "DEVICE_BLUETOOTHHEADSET";
  public static final String DEVICE_EARPHONE = "DEVICE_EARPHONE";
  public static final String DEVICE_NONE = "DEVICE_NONE";
  public static final String DEVICE_SPEAKERPHONE = "DEVICE_SPEAKERPHONE";
  public static final int DEVICE_STATUS_CONNECTED = 2;
  public static final int DEVICE_STATUS_CONNECTING = 1;
  public static final int DEVICE_STATUS_DISCONNECTED = 0;
  public static final int DEVICE_STATUS_DISCONNECTING = 3;
  public static final int DEVICE_STATUS_ERROR = -1;
  public static final int DEVICE_STATUS_UNCHANGEABLE = 4;
  public static final String DEVICE_WIREDHEADSET = "DEVICE_WIREDHEADSET";
  public static final int EARACTION_AWAY = 0;
  public static final int EARACTION_CLOSE = 1;
  public static final String EXTRA_DATA_AVAILABLEDEVICE_LIST = "EXTRA_DATA_AVAILABLEDEVICE_LIST";
  public static final String EXTRA_DATA_CONNECTEDDEVICE = "EXTRA_DATA_CONNECTEDDEVICE";
  public static final String EXTRA_DATA_DEVICECONFIG = "EXTRA_DATA_DEVICECONFIG";
  public static final String EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME = "EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME";
  public static final String EXTRA_DATA_PREV_CONNECTEDDEVICE = "EXTRA_DATA_PREV_CONNECTEDDEVICE";
  public static final String EXTRA_DATA_ROUTESWITCHEND_DEV = "EXTRA_DATA_ROUTESWITCHEND_DEV";
  public static final String EXTRA_DATA_ROUTESWITCHEND_TIME = "EXTRA_DATA_ROUTESWITCHEND_TIME";
  public static final String EXTRA_DATA_ROUTESWITCHSTART_FROM = "EXTRA_DATA_ROUTESWITCHSTART_FROM";
  public static final String EXTRA_DATA_ROUTESWITCHSTART_TO = "EXTRA_DATA_ROUTESWITCHSTART_TO";
  public static final String EXTRA_DATA_STREAMTYPE = "EXTRA_DATA_STREAMTYPE";
  public static final String EXTRA_EARACTION = "EXTRA_EARACTION";
  public static final int FORCE_ANALOG_DOCK = 8;
  public static final int FORCE_BT_A2DP = 4;
  public static final int FORCE_BT_CAR_DOCK = 6;
  public static final int FORCE_BT_DESK_DOCK = 7;
  public static final int FORCE_BT_SCO = 3;
  public static final int FORCE_DEFAULT = 0;
  public static final int FORCE_DIGITAL_DOCK = 9;
  public static final int FORCE_HEADPHONES = 2;
  public static final int FORCE_NONE = 0;
  public static final int FORCE_NO_BT_A2DP = 10;
  public static final int FORCE_SPEAKER = 1;
  public static final int FORCE_WIRED_ACCESSORY = 5;
  public static final int FOR_COMMUNICATION = 0;
  public static final int FOR_DOCK = 3;
  public static final int FOR_MEDIA = 1;
  public static final int FOR_RECORD = 2;
  public static final String GETCONNECTEDDEVICE_RESULT_LIST = "GETCONNECTEDDEVICE_REULT_LIST";
  public static final String GETCONNECTINGDEVICE_RESULT_LIST = "GETCONNECTINGDEVICE_REULT_LIST";
  public static final String ISDEVICECHANGABLED_RESULT_ISCHANGABLED = "ISDEVICECHANGABLED_REULT_ISCHANGABLED";
  public static boolean IsEarPhoneSupported = false;
  public static boolean IsMusicScene = false;
  public static boolean IsUpdateSceneFlag = false;
  public static final int MODE_MUSIC_PLAYBACK = 2;
  public static final int MODE_MUSIC_PLAY_RECORD = 1;
  public static final int MODE_MUSIC_PLAY_RECORD_HIGH_QUALITY = 3;
  public static final int MODE_MUSIC_PLAY_RECORD_LOW_QUALITY = 5;
  public static final int MODE_VOICE_CHAT = 0;
  public static final int MODE_VOICE_PLAYBACK = 4;
  public static final String MUSIC_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_WIREDHEADSET;DEVICE_BLUETOOTHHEADSET;";
  public static final String NOTIFY_DEVICECHANGABLE_UPDATE = "NOTIFY_DEVICECHANGABLE_UPDATE";
  public static final String NOTIFY_DEVICECHANGABLE_UPDATE_DATE = "NOTIFY_DEVICECHANGABLE_UPDATE_DATE";
  public static final String NOTIFY_DEVICELIST_UPDATE = "NOTIFY_DEVICELISTUPDATE";
  public static final String NOTIFY_RING_COMPLETION = "NOTIFY_RING_COMPLETION";
  public static final String NOTIFY_ROUTESWITCHEND = "NOTIFY_ROUTESWITCHEND";
  public static final String NOTIFY_ROUTESWITCHSTART = "NOTIFY_ROUTESWITCHSTART";
  public static final String NOTIFY_SERVICE_STATE = "NOTIFY_SERVICE_STATE";
  public static final String NOTIFY_SERVICE_STATE_DATE = "NOTIFY_SERVICE_STATE_DATE";
  public static final String NOTIFY_STREAMTYPE_UPDATE = "NOTIFY_STREAMTYPE_UPDATE";
  private static final int NUM_FORCE_CONFIG = 11;
  private static final int NUM_FORCE_USE = 4;
  public static final String OPERATION_CONNECTDEVICE = "OPERATION_CONNECTDEVICE";
  public static final String OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE = "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE";
  public static final String OPERATION_EARACTION = "OPERATION_EARACTION";
  public static final String OPERATION_GETCONNECTEDDEVICE = "OPERATION_GETCONNECTEDDEVICE";
  public static final String OPERATION_GETCONNECTINGDEVICE = "OPERATION_GETCONNECTINGDEVICE";
  public static final String OPERATION_GETDEVICELIST = "OPERATION_GETDEVICELIST";
  public static final String OPERATION_GETSTREAMTYPE = "OPERATION_GETSTREAMTYPE";
  public static final String OPERATION_ISDEVICECHANGABLED = "OPERATION_ISDEVICECHANGABLED";
  public static final String OPERATION_RECOVER_AUDIO_FOCUS = "OPERATION_RECOVER_AUDIO_FOCUS";
  public static final String OPERATION_REGISTERAUDIOSESSION = "OPERATION_REGISTERAUDIOSESSION";
  public static final String OPERATION_REQUEST_RELEASE_AUDIO_FOCUS = "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS";
  public static final String OPERATION_STARTRING = "OPERATION_STARTRING";
  public static final String OPERATION_STARTSERVICE = "OPERATION_STARTSERVICE";
  public static final String OPERATION_STOPRING = "OPERATION_STOPRING";
  public static final String OPERATION_STOPSERVICE = "OPERATION_STOPSERVICE";
  public static final String OPERATION_VOICECALL_AUDIOPARAM_CHANGED = "OPERATION_VOICECALL_AUDIOPARAM_CHANGED";
  public static final String OPERATION_VOICECALL_POSTPROCESS = "OPERATION_VOICECALL_POSTROCESS";
  public static final String OPERATION_VOICECALL_PREPROCESS = "OPERATION_VOICECALL_PREPROCESS";
  public static final String PARAM_DEVICE = "PARAM_DEVICE";
  public static final String PARAM_ERROR = "PARAM_ERROR";
  public static final String PARAM_ISHOSTSIDE = "PARAM_ISHOSTSIDE";
  public static final String PARAM_MODEPOLICY = "PARAM_MODEPOLICY";
  public static final String PARAM_OPERATION = "PARAM_OPERATION";
  public static final String PARAM_RES_ERRCODE = "PARAM_RES_ERRCODE";
  public static final String PARAM_RING_DATASOURCE = "PARAM_RING_DATASOURCE";
  public static final String PARAM_RING_FILEPATH = "PARAM_RING_FILEPATH";
  public static final String PARAM_RING_LOOP = "PARAM_RING_LOOP";
  public static final String PARAM_RING_LOOPCOUNT = "PARAM_RING_LOOPCOUNT";
  public static final String PARAM_RING_MODE = "PARAM_RING_MODE";
  public static final String PARAM_RING_RSID = "PARAM_RING_RSID";
  public static final String PARAM_RING_URI = "PARAM_RING_URI";
  public static final String PARAM_RING_USERDATA_STRING = "PARAM_RING_USERDATA_STRING";
  public static final String PARAM_SESSIONID = "PARAM_SESSIONID";
  public static final String PARAM_STATUS = "PARAM_STATUS";
  public static final String PARAM_STREAMTYPE = "PARAM_STREAMTYPE";
  public static final String REGISTERAUDIOSESSION_ISREGISTER = "REGISTERAUDIOSESSION_ISREGISTER";
  public static final int RES_ERRCODE_DEVICE_BTCONNCECTED_TIMEOUT = 10;
  public static final int RES_ERRCODE_DEVICE_NOT_VISIABLE = 8;
  public static final int RES_ERRCODE_DEVICE_UNCHANGEABLE = 9;
  public static final int RES_ERRCODE_DEVICE_UNKOWN = 7;
  public static final int RES_ERRCODE_NONE = 0;
  public static final int RES_ERRCODE_RING_NOT_EXIST = 5;
  public static final int RES_ERRCODE_SERVICE_OFF = 1;
  public static final int RES_ERRCODE_STOPRING_INTERRUPT = 4;
  public static final int RES_ERRCODE_VOICECALLPOST_INTERRUPT = 6;
  public static final int RES_ERRCODE_VOICECALL_EXIST = 2;
  public static final int RES_ERRCODE_VOICECALL_NOT_EXIST = 3;
  public static final String VIDEO_CONFIG = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  public static final String VOICECALL_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  static int _gHostProcessId = -1;
  static TraeAudioManager _ginstance;
  static ReentrantLock _glock;
  static final String[] forceName = { "FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK" };
  boolean IsBluetoothA2dpExisted = true;
  int _activeMode = 0;
  AudioManager _am = null;
  TraeAudioSessionHost _audioSessionHost = null;
  BluetoohHeadsetCheckInterface _bluetoothCheck = null;
  Context _context = null;
  DeviceConfigManager _deviceConfigManager = null;
  ReentrantLock _lock = new ReentrantLock();
  int _modePolicy = -1;
  int _prevMode = 0;
  int _streamType = 0;
  switchThread _switchThread = null;
  TraeAudioManagerLooper mTraeAudioManagerLooper = null;
  String sessionConnectedDev = "DEVICE_NONE";
  
  static
  {
    IsEarPhoneSupported = false;
    IsUpdateSceneFlag = false;
    _glock = new ReentrantLock();
    _ginstance = null;
  }
  
  TraeAudioManager(Context paramContext)
  {
    AudioDeviceInterface.LogTraceEntry(" context:" + paramContext);
    if (paramContext == null) {
      return;
    }
    this._context = paramContext;
    this.mTraeAudioManagerLooper = new TraeAudioManagerLooper(this);
    if (this.mTraeAudioManagerLooper != null) {}
    AudioDeviceInterface.LogTraceExit();
  }
  
  static boolean IsEabiLowVersion()
  {
    String str2 = Build.CPU_ABI;
    String str1 = "unknown";
    if (Build.VERSION.SDK_INT >= 8) {}
    try
    {
      str1 = (String)Build.class.getDeclaredField("CPU_ABI2").get(null);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "IsEabiVersion CPU_ABI:" + str2 + " CPU_ABI2:" + str1);
      }
      if ((IsEabiLowVersionByAbi(str2)) && (IsEabiLowVersionByAbi(str1))) {
        return true;
      }
    }
    catch (Exception localException)
    {
      return IsEabiLowVersionByAbi(str2);
    }
    return false;
  }
  
  public static boolean IsEabiLowVersionByAbi(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return true;
      if (paramString.contains("x86")) {
        return false;
      }
      if (paramString.contains("mips")) {
        return false;
      }
    } while ((paramString.equalsIgnoreCase("armeabi")) || (!paramString.equalsIgnoreCase("armeabi-v7a")));
    return false;
  }
  
  public static int SetSpeakerForTest(Context paramContext, boolean paramBoolean)
  {
    int j = -1;
    _glock.lock();
    int i;
    if (_ginstance != null) {
      i = _ginstance.InternalSetSpeaker(paramContext, paramBoolean);
    }
    for (;;)
    {
      _glock.unlock();
      return i;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.w("TRAE", 0, "TraeAudioManager|static SetSpeakerForTest|null == _ginstance");
        i = j;
      }
    }
  }
  
  public static boolean checkDevName(String paramString)
  {
    if (paramString == null) {}
    while ((!"DEVICE_SPEAKERPHONE".equals(paramString)) && (!"DEVICE_EARPHONE".equals(paramString)) && (!"DEVICE_WIREDHEADSET".equals(paramString)) && (!"DEVICE_BLUETOOTHHEADSET".equals(paramString))) {
      return false;
    }
    return true;
  }
  
  static int connectDevice(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    if (paramString2 == null) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("CONNECTDEVICE_DEVICENAME", paramString2);
    localHashMap.put("PARAM_DEVICE", paramString2);
    return sendMessage(32775, localHashMap);
  }
  
  static int connectHighestPriorityDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32789, localHashMap);
  }
  
  static int earAction(String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_EARACTION", Integer.valueOf(paramInt));
    return sendMessage(32776, localHashMap);
  }
  
  static void forceVolumeControlStream(AudioManager paramAudioManager, int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    Class[] arrayOfClass = new Class[arrayOfObject.length];
    arrayOfClass[0] = Integer.TYPE;
    paramAudioManager = invokeMethod(paramAudioManager, "forceVolumeControlStream", arrayOfObject, arrayOfClass);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "forceVolumeControlStream  streamType:" + paramInt + " res:" + paramAudioManager);
    }
  }
  
  static int getAudioSource(int paramInt)
  {
    if (IsMusicScene) {}
    do
    {
      return 0;
      if (!IsEabiLowVersion()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 0, "[Config] armeabi low Version, getAudioSource _audioSourcePolicy:" + paramInt + " source:" + 0);
    return 0;
    int i = Build.VERSION.SDK_INT;
    if (paramInt >= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + paramInt);
      }
      return paramInt;
    }
    if (i >= 11) {}
    for (i = 7;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + i);
      }
      return i;
    }
  }
  
  static int getAudioStreamType(int paramInt)
  {
    int i = 3;
    if (IsMusicScene) {
      j = i;
    }
    do
    {
      return j;
      if (!IsEabiLowVersion()) {
        break;
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 0, "[Config] armeabi low Version, getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:" + 3);
    return 3;
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0) {
      i = paramInt;
    }
    for (;;)
    {
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("TRAE", 0, "[Config] getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:" + i);
      return i;
      if (j >= 9) {
        i = 0;
      }
    }
  }
  
  static int getCallAudioMode(int paramInt)
  {
    if (IsMusicScene) {}
    do
    {
      return 0;
      if (!IsEabiLowVersion()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 0, "[Config] armeabi low Version, getCallAudioMode modePolicy:" + paramInt + " mode:" + 0);
    return 0;
    int i = Build.VERSION.SDK_INT;
    if (paramInt >= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "[Config] getCallAudioMode modePolicy:" + paramInt + " mode:" + paramInt);
      }
      return paramInt;
    }
    if (i >= 11) {}
    for (i = 3;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "[Config] getCallAudioMode _modePolicy:" + paramInt + " mode:" + i + "facturer:" + Build.MANUFACTURER + " model:" + Build.MODEL);
      }
      return i;
    }
  }
  
  static int getConnectedDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32778, localHashMap);
  }
  
  static int getConnectingDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32779, localHashMap);
  }
  
  static int getDeviceList(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32774, localHashMap);
  }
  
  static String getForceConfigName(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < forceName.length)) {
      return forceName[paramInt];
    }
    return "unknow";
  }
  
  static int getForceUse(int paramInt)
  {
    Object localObject = new Object[1];
    localObject[0] = Integer.valueOf(paramInt);
    Class[] arrayOfClass = new Class[localObject.length];
    arrayOfClass[0] = Integer.TYPE;
    localObject = invokeStaticMethod("android.media.AudioSystem", "getForceUse", (Object[])localObject, arrayOfClass);
    if (localObject != null) {}
    for (localObject = (Integer)localObject;; localObject = Integer.valueOf(0))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "getForceUse  usage:" + paramInt + " config:" + localObject + " ->" + getForceConfigName(((Integer)localObject).intValue()));
      }
      return ((Integer)localObject).intValue();
    }
  }
  
  static int getStreamType(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32784, localHashMap);
  }
  
  public static int init(Context paramContext)
  {
    Log.w("TRAE", "TraeAudioManager init _ginstance:" + _ginstance);
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
    _glock.lock();
    if (_ginstance == null) {
      _ginstance = new TraeAudioManager(paramContext);
    }
    _glock.unlock();
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Object localObject = null;
    try
    {
      paramObject = paramObject.getClass().getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
      return paramObject;
    }
    catch (Exception paramString)
    {
      do
      {
        paramObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 0, "invokeMethod Exception:" + paramString.getMessage());
    }
    return null;
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Object localObject = null;
    try
    {
      paramArrayOfObject = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass).invoke(null, paramArrayOfObject);
      return paramArrayOfObject;
    }
    catch (ClassNotFoundException paramString2)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 0, "ClassNotFound:" + paramString1);
      return null;
    }
    catch (NoSuchMethodException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 0, "NoSuchMethod:" + paramString2);
      return null;
    }
    catch (IllegalArgumentException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 0, "IllegalArgument:" + paramString2);
      return null;
    }
    catch (IllegalAccessException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 0, "IllegalAccess:" + paramString2);
      return null;
    }
    catch (InvocationTargetException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 0, "InvocationTarget:" + paramString2);
      return null;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 0, "invokeStaticMethod Exception:" + paramString1.getMessage());
    }
    return null;
  }
  
  static boolean isCloseSystemAPM(int paramInt)
  {
    if (paramInt != -1) {}
    do
    {
      do
      {
        return false;
        if (!Build.MANUFACTURER.equals("Xiaomi")) {
          break;
        }
        if (Build.MODEL.equals("MI 2")) {
          return true;
        }
        if (Build.MODEL.equals("MI 2A")) {
          return true;
        }
        if (Build.MODEL.equals("MI 2S")) {
          return true;
        }
      } while (!Build.MODEL.equals("MI 2SC"));
      return true;
    } while ((!Build.MANUFACTURER.equals("samsung")) || (!Build.MODEL.equals("SCH-I959")));
    return true;
  }
  
  static int isDeviceChangabled(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32777, localHashMap);
  }
  
  public static boolean isHandfree(String paramString)
  {
    if (!checkDevName(paramString)) {}
    while (!"DEVICE_SPEAKERPHONE".equals(paramString)) {
      return false;
    }
    return true;
  }
  
  static int recoverAudioFocus(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32791, localHashMap);
  }
  
  public static int registerAudioSession(TraeAudioSession paramTraeAudioSession, boolean paramBoolean, long paramLong, Context paramContext)
  {
    int i = -1;
    _glock.lock();
    if (_ginstance != null)
    {
      if (!paramBoolean) {
        break label44;
      }
      _ginstance._audioSessionHost.add(paramTraeAudioSession, paramLong, paramContext);
    }
    for (;;)
    {
      i = 0;
      _glock.unlock();
      return i;
      label44:
      _ginstance._audioSessionHost.remove(paramLong);
    }
  }
  
  static int requestReleaseAudioFocus(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32790, localHashMap);
  }
  
  public static int sendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    int i = -1;
    _glock.lock();
    if (_ginstance != null) {
      i = _ginstance.internalSendMessage(paramInt, paramHashMap);
    }
    _glock.unlock();
    return i;
  }
  
  static void setForceUse(int paramInt1, int paramInt2)
  {
    Object localObject = new Object[2];
    localObject[0] = Integer.valueOf(paramInt1);
    localObject[1] = Integer.valueOf(paramInt2);
    Class[] arrayOfClass = new Class[localObject.length];
    arrayOfClass[0] = Integer.TYPE;
    arrayOfClass[1] = Integer.TYPE;
    localObject = invokeStaticMethod("android.media.AudioSystem", "setForceUse", (Object[])localObject, arrayOfClass);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "setForceUse  usage:" + paramInt1 + " config:" + paramInt2 + " ->" + getForceConfigName(paramInt2) + " res:" + localObject);
    }
  }
  
  static void setParameters(String paramString)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString;
    Class[] arrayOfClass = new Class[arrayOfObject.length];
    arrayOfClass[0] = String.class;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "setParameters  :" + paramString);
    }
    invokeStaticMethod("android.media.AudioSystem", "setParameters", arrayOfObject, arrayOfClass);
  }
  
  static void setPhoneState(int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    Class[] arrayOfClass = new Class[arrayOfObject.length];
    arrayOfClass[0] = Integer.TYPE;
    invokeStaticMethod("android.media.AudioSystem", "setPhoneState", arrayOfObject, arrayOfClass);
  }
  
  static int startRing(String paramString1, long paramLong, boolean paramBoolean1, int paramInt1, int paramInt2, Uri paramUri, String paramString2, boolean paramBoolean2, int paramInt3, String paramString3, boolean paramBoolean3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean1));
    localHashMap.put("PARAM_RING_DATASOURCE", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_RING_RSID", Integer.valueOf(paramInt2));
    localHashMap.put("PARAM_RING_URI", paramUri);
    localHashMap.put("PARAM_RING_FILEPATH", paramString2);
    localHashMap.put("PARAM_RING_LOOP", Boolean.valueOf(paramBoolean2));
    localHashMap.put("PARAM_RING_LOOPCOUNT", Integer.valueOf(paramInt3));
    localHashMap.put("PARAM_RING_MODE", Boolean.valueOf(paramBoolean3));
    localHashMap.put("PARAM_RING_USERDATA_STRING", paramString3);
    return sendMessage(32782, localHashMap);
  }
  
  static int startService(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    if (paramString2.length() <= 0) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_DATA_DEVICECONFIG", paramString2);
    return sendMessage(32772, localHashMap);
  }
  
  static int stopRing(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32783, localHashMap);
  }
  
  static int stopService(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32773, localHashMap);
  }
  
  public static void uninit()
  {
    Log.w("TRAE", "TraeAudioManager uninit _ginstance:" + _ginstance);
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
    _glock.lock();
    if (_ginstance != null)
    {
      _ginstance.release();
      _ginstance = null;
    }
    _glock.unlock();
    AudioDeviceInterface.LogTraceExit();
  }
  
  static int voiceCallAudioParamChanged(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    return sendMessage(32788, localHashMap);
  }
  
  static int voicecallPostprocess(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32781, localHashMap);
  }
  
  static int voicecallPreprocess(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    return sendMessage(32780, localHashMap);
  }
  
  public BluetoohHeadsetCheckInterface CreateBluetoothCheck(Context paramContext, DeviceConfigManager paramDeviceConfigManager)
  {
    Object localObject1;
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject1 = new BluetoohHeadsetCheck();
      localObject2 = localObject1;
      if (!((BluetoohHeadsetCheckInterface)localObject1).init(paramContext, paramDeviceConfigManager)) {
        localObject2 = new BluetoohHeadsetCheckFake();
      }
      if (QLog.isColorLevel())
      {
        paramDeviceConfigManager = new StringBuilder().append("CreateBluetoothCheck:").append(((BluetoohHeadsetCheckInterface)localObject2).interfaceDesc()).append(" skip android4.3:");
        if (Build.VERSION.SDK_INT != 18) {
          break label135;
        }
      }
    }
    label135:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TRAE", 0, paramContext);
      return localObject2;
      if (Build.VERSION.SDK_INT != 18)
      {
        localObject1 = new BluetoohHeadsetCheckFor2x();
        break;
      }
      localObject1 = new BluetoohHeadsetCheckFake();
      break;
    }
  }
  
  int InternalConnectDevice(String paramString, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    AudioDeviceInterface.LogTraceEntry(" devName:" + paramString);
    if (paramString == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return -1;
            if ((!IsMusicScene) || (!paramString.equals("DEVICE_EARPHONE"))) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("TRAE", 0, "MusicScene, Connect device:" + paramString + " failed");
          return -1;
          if ((IsEarPhoneSupported) || (!paramString.equals("DEVICE_EARPHONE"))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("TRAE", 0, "IsEarPhoneSupported = false, Connect device:" + paramString + " failed");
        return -1;
        if ((!paramBoolean) && (!this._deviceConfigManager.getConnectedDevice().equals("DEVICE_NONE")) && (paramString.equals(this._deviceConfigManager.getConnectedDevice()))) {
          return 0;
        }
        if ((checkDevName(paramString) == true) && (this._deviceConfigManager.getVisible(paramString) == true)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TRAE", 0, " checkDevName fail");
      return -1;
      if (InternalIsDeviceChangeable() == true) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 0, " InternalIsDeviceChangeable fail");
    return -1;
    if (this._switchThread != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "_switchThread:" + this._switchThread.getDeviceName());
      }
      this._switchThread.quit();
      this._switchThread = null;
    }
    if (paramString.equals("DEVICE_EARPHONE")) {
      this._switchThread = new earphoneSwitchThread();
    }
    for (;;)
    {
      if (this._switchThread != null)
      {
        this._switchThread.setDeviceConnectParam(paramHashMap);
        this._switchThread.start();
      }
      AudioDeviceInterface.LogTraceExit();
      return 0;
      if (paramString.equals("DEVICE_SPEAKERPHONE")) {
        this._switchThread = new speakerSwitchThread();
      } else if (paramString.equals("DEVICE_WIREDHEADSET")) {
        this._switchThread = new headsetSwitchThread();
      } else if (paramString.equals("DEVICE_BLUETOOTHHEADSET")) {
        this._switchThread = new bluetoothHeadsetSwitchThread();
      }
    }
  }
  
  boolean InternalIsDeviceChangeable()
  {
    String str = this._deviceConfigManager.getConnectingDevice();
    return (str == null) || (str.equals("DEVICE_NONE")) || (str.equals(""));
  }
  
  int InternalNotifyDeviceChangableUpdate()
  {
    if (this._context == null) {
      return -1;
    }
    final boolean bool = InternalIsDeviceChangeable();
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        Intent localIntent = new Intent();
        localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICECHANGABLE_UPDATE");
        localIntent.putExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", bool);
        if (TraeAudioManager.this._context != null) {
          TraeAudioManager.this._context.sendBroadcast(localIntent);
        }
      }
    });
    return 0;
  }
  
  int InternalNotifyDeviceListUpdate()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this._context == null) {
      return -1;
    }
    Object localObject = this._deviceConfigManager.getSnapParams();
    final ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    final String str1 = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    final String str2 = this._deviceConfigManager.getBluetoothName();
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        Intent localIntent = new Intent();
        localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICELISTUPDATE");
        localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
        localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str1);
        localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", this.val$prevCon);
        localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", str2);
        if (TraeAudioManager.this._context != null) {
          TraeAudioManager.this._context.sendBroadcast(localIntent);
        }
      }
    });
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  int InternalSessionConnectDevice(HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramHashMap == null) || (this._context == null)) {
      return -1;
    }
    if (IsMusicScene)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "MusicScene: InternalSessionConnectDevice failed");
      }
      return -1;
    }
    String str = (String)paramHashMap.get("PARAM_DEVICE");
    Log.w("TRAE", "ConnectDevice: " + str);
    if ((!IsEarPhoneSupported) && (str.equals("DEVICE_EARPHONE")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "InternalSessionConnectDevice IsEarPhoneSupported = false, Connect device:" + str + " failed");
      }
      return -1;
    }
    boolean bool = InternalIsDeviceChangeable();
    int i;
    if (checkDevName(str) != true) {
      i = 7;
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("sessonID:").append((Long)paramHashMap.get("PARAM_SESSIONID")).append(" devName:").append(str).append(" bChangabled:");
        if (!bool) {
          break label313;
        }
      }
      label313:
      for (Object localObject = "Y";; localObject = "N")
      {
        QLog.w("TRAE", 0, (String)localObject + " err:" + i);
        if (i == 0) {
          break label321;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        sendResBroadcast((Intent)localObject, paramHashMap, i);
        return -1;
        if (!this._deviceConfigManager.getVisible(str))
        {
          i = 8;
          break;
        }
        if (bool) {
          break label419;
        }
        i = 9;
        break;
      }
      label321:
      if (str.equals(this._deviceConfigManager.getConnectedDevice()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, " --has connected!");
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        sendResBroadcast((Intent)localObject, paramHashMap, i);
        return 0;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, " --connecting...");
      }
      InternalConnectDevice(str, paramHashMap, false);
      AudioDeviceInterface.LogTraceExit();
      return 0;
      label419:
      i = 0;
    }
  }
  
  int InternalSessionEarAction(HashMap<String, Object> paramHashMap)
  {
    return 0;
  }
  
  int InternalSessionGetConnectedDevice(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTEDDEVICE_REULT_LIST", this._deviceConfigManager.getConnectedDevice());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int InternalSessionGetConnectingDevice(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTINGDEVICE_REULT_LIST", this._deviceConfigManager.getConnectingDevice());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int InternalSessionIsDeviceChangabled(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", InternalIsDeviceChangeable());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  void InternalSetMode(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "SetMode entry:" + paramInt);
    }
    if (this._am == null) {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "setMode:" + paramInt + " fail am=null");
      }
    }
    do
    {
      return;
      this._am.setMode(paramInt);
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder().append("setMode:").append(paramInt);
    if (this._am.getMode() != paramInt) {}
    for (String str = "fail";; str = "success")
    {
      QLog.w("TRAE", 0, str);
      return;
    }
  }
  
  int InternalSetSpeaker(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "Could not InternalSetSpeaker - no context");
      }
    }
    AudioManager localAudioManager;
    do
    {
      return -1;
      localAudioManager = (AudioManager)paramContext.getSystemService("audio");
      if (localAudioManager != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 0, "Could not InternalSetSpeaker - no audio manager");
    return -1;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("InternalSetSpeaker entry:speaker:");
      if (!localAudioManager.isSpeakerphoneOn()) {
        break label154;
      }
      paramContext = "Y";
      localStringBuilder = localStringBuilder.append(paramContext).append("-->:");
      if (!paramBoolean) {
        break label161;
      }
    }
    label154:
    label161:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TRAE", 0, paramContext);
      if ((!isCloseSystemAPM(this._modePolicy)) || (this._activeMode == 2)) {
        break label168;
      }
      return InternalSetSpeakerSpe(localAudioManager, paramBoolean);
      paramContext = "N";
      break;
    }
    label168:
    if (localAudioManager.isSpeakerphoneOn() != paramBoolean) {
      localAudioManager.setSpeakerphoneOn(paramBoolean);
    }
    if (localAudioManager.isSpeakerphoneOn() == paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "InternalSetSpeaker exit:" + paramBoolean + " res:" + i + " mode:" + localAudioManager.getMode());
      }
      return i;
    }
  }
  
  int InternalSetSpeakerSpe(AudioManager paramAudioManager, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "InternalSetSpeakerSpe fac:" + Build.MANUFACTURER + " model:" + Build.MODEL + " st:" + this._streamType + " media_force_use:" + getForceUse(1));
    }
    if (paramBoolean)
    {
      InternalSetMode(0);
      paramAudioManager.setSpeakerphoneOn(true);
      setForceUse(1, 1);
      if (paramAudioManager.isSpeakerphoneOn() != paramBoolean) {
        break label178;
      }
    }
    label178:
    for (int i = 0;; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "InternalSetSpeakerSpe exit:" + paramBoolean + " res:" + i + " mode:" + paramAudioManager.getMode());
      }
      return i;
      InternalSetMode(3);
      paramAudioManager.setSpeakerphoneOn(false);
      setForceUse(1, 0);
      break;
    }
  }
  
  void _updateEarphoneVisable()
  {
    if (this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET"))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, " detected headset plugin,so disable earphone");
      }
      this._deviceConfigManager.setVisible("DEVICE_EARPHONE", false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, " detected headset plugout,so enable earphone");
    }
    this._deviceConfigManager.setVisible("DEVICE_EARPHONE", true);
  }
  
  void checkAutoDeviceListUpdate()
  {
    if (this._deviceConfigManager.getVisiableUpdateFlag() == true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "checkAutoDeviceListUpdate got update!");
      }
      _updateEarphoneVisable();
      this._deviceConfigManager.resetVisiableUpdateFlag();
      internalSendMessage(32785, new HashMap());
    }
  }
  
  void checkDevicePlug(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (this._deviceConfigManager.getVisiableUpdateFlag() == true) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("checkDevicePlug got update dev:").append(paramString);
        if (!paramBoolean) {
          break label117;
        }
      }
    }
    label117:
    for (Object localObject = " piugin";; localObject = " plugout")
    {
      QLog.w("TRAE", 0, (String)localObject + " connectedDev:" + this._deviceConfigManager.getConnectedDevice());
      _updateEarphoneVisable();
      this._deviceConfigManager.resetVisiableUpdateFlag();
      if (!paramBoolean) {
        break;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_DEVICE", paramString);
      internalSendMessage(32786, (HashMap)localObject);
      return;
    }
    localObject = this._deviceConfigManager.getConnectedDevice();
    if ((((String)localObject).equals(paramString)) || (((String)localObject).equals("DEVICE_NONE")))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_DEVICE", paramString);
      internalSendMessage(32787, (HashMap)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, " ---No switch,plugout:" + paramString + " connectedDev:" + (String)localObject);
    }
    internalSendMessage(32785, new HashMap());
  }
  
  int internalSendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    int i = -1;
    if (this.mTraeAudioManagerLooper != null) {
      i = this.mTraeAudioManagerLooper.sendMessage(paramInt, paramHashMap);
    }
    return i;
  }
  
  void onHeadsetPlug(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("name");
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = "unkonw";
    }
    localObject = "" + " [" + paramContext + "] ";
    int i = paramIntent.getIntExtra("state", -1);
    paramContext = (Context)localObject;
    if (i != -1)
    {
      localObject = new StringBuilder().append((String)localObject);
      if (i == 0)
      {
        paramContext = "unplugged";
        paramContext = paramContext;
      }
    }
    else
    {
      localObject = paramContext + " mic:";
      int j = paramIntent.getIntExtra("microphone", -1);
      paramContext = (Context)localObject;
      if (j != -1)
      {
        paramIntent = new StringBuilder().append((String)localObject);
        if (j != 1) {
          break label256;
        }
        paramContext = "Y";
        label168:
        paramContext = paramContext;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "onHeadsetPlug:: " + paramContext);
      }
      paramContext = this._deviceConfigManager;
      if (1 != i) {
        break label263;
      }
    }
    label256:
    label263:
    for (boolean bool = true;; bool = false)
    {
      paramContext.setVisible("DEVICE_WIREDHEADSET", bool);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "onHeadsetPlug exit");
      }
      return;
      paramContext = "plugged";
      break;
      paramContext = "unkown";
      break label168;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 0, "onReceive intent or context is null!");
      }
    }
    for (;;)
    {
      return;
      try
      {
        String str2 = paramIntent.getAction();
        String str1 = paramIntent.getStringExtra("PARAM_OPERATION");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "TraeAudioManager|onReceive::Action:" + paramIntent.getAction());
        }
        if (this._deviceConfigManager == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TRAE", 0, "_deviceConfigManager null!");
          }
        }
        else
        {
          boolean bool1 = this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET");
          boolean bool2 = this._deviceConfigManager.getVisible("DEVICE_BLUETOOTHHEADSET");
          if ("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction()))
          {
            onHeadsetPlug(paramContext, paramIntent);
            if ((!bool1) && (this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET") == true)) {
              checkDevicePlug("DEVICE_WIREDHEADSET", true);
            }
            if ((bool1 == true) && (!this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET"))) {
              checkDevicePlug("DEVICE_WIREDHEADSET", false);
            }
          }
          else if (!"android.media.AUDIO_BECOMING_NOISY".equals(paramIntent.getAction()))
          {
            if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST".equals(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.w("TRAE", 0, "   OPERATION:" + str1);
              }
              if ("OPERATION_STARTSERVICE".equals(str1))
              {
                startService(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("EXTRA_DATA_DEVICECONFIG"));
                return;
              }
              if ("OPERATION_STOPSERVICE".equals(str1))
              {
                stopService(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETDEVICELIST".equals(str1))
              {
                getDeviceList(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETSTREAMTYPE".equals(str1))
              {
                getStreamType(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_CONNECTDEVICE".equals(str1))
              {
                connectDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME"));
                return;
              }
              if ("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE".equals(str1))
              {
                connectHighestPriorityDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_EARACTION".equals(str1))
              {
                earAction(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getIntExtra("EXTRA_EARACTION", -1));
                return;
              }
              if ("OPERATION_ISDEVICECHANGABLED".equals(str1))
              {
                isDeviceChangabled(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETCONNECTEDDEVICE".equals(str1))
              {
                getConnectedDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETCONNECTINGDEVICE".equals(str1))
              {
                getConnectingDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              int i;
              int j;
              if ("OPERATION_VOICECALL_PREPROCESS".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
                j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
                voicecallPreprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
                return;
              }
              if ("OPERATION_VOICECALL_POSTROCESS".equals(str1))
              {
                voicecallPostprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_VOICECALL_AUDIOPARAM_CHANGED".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
                j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
                voiceCallAudioParamChanged(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
                return;
              }
              if ("OPERATION_STARTRING".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_RING_DATASOURCE", -1);
                j = paramIntent.getIntExtra("PARAM_RING_RSID", -1);
                paramContext = (Uri)paramIntent.getParcelableExtra("PARAM_RING_URI");
                str2 = paramIntent.getStringExtra("PARAM_RING_FILEPATH");
                bool1 = paramIntent.getBooleanExtra("PARAM_RING_LOOP", false);
                String str3 = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
                int k = paramIntent.getIntExtra("PARAM_RING_LOOPCOUNT", 1);
                bool2 = paramIntent.getBooleanExtra("PARAM_RING_MODE", false);
                startRing(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j, paramContext, str2, bool1, k, str3, bool2);
                return;
              }
              if ("OPERATION_STOPRING".equals(str1)) {
                stopRing(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
              }
            }
            else if (this._deviceConfigManager != null)
            {
              if (this._bluetoothCheck != null) {
                this._bluetoothCheck.onReceive(paramContext, paramIntent, this._deviceConfigManager);
              }
              if ((!bool2) && (this._deviceConfigManager.getVisible("DEVICE_BLUETOOTHHEADSET") == true)) {
                checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
              }
              if ((bool2 == true) && (!this._deviceConfigManager.getVisible("DEVICE_BLUETOOTHHEADSET")))
              {
                checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
                return;
              }
            }
          }
        }
      }
      catch (Exception paramContext) {}
    }
  }
  
  void printDevices()
  {
    AudioDeviceInterface.LogTraceEntry("");
    int j = this._deviceConfigManager.getDeviceNumber();
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "   ConnectedDevice:" + this._deviceConfigManager.getConnectedDevice());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "   ConnectingDevice:" + this._deviceConfigManager.getConnectingDevice());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "   prevConnectedDevice:" + this._deviceConfigManager.getPrevConnectedDevice());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "   AHPDevice:" + this._deviceConfigManager.getAvailabledHighestPriorityDevice());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "   deviceNamber:" + j);
    }
    int i = 0;
    while (i < j)
    {
      localObject = this._deviceConfigManager.getDeviceName(i);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "      " + i + " devName:" + (String)localObject + " Visible:" + this._deviceConfigManager.getVisible((String)localObject) + " Priority:" + this._deviceConfigManager.getPriority((String)localObject));
      }
      i += 1;
    }
    Object localObject = (String[])this._deviceConfigManager.getAvailableDeviceList().toArray(new String[0]);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "   AvailableNamber:" + localObject.length);
    }
    i = 0;
    while (i < localObject.length)
    {
      String str = localObject[i];
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "      " + i + " devName:" + str + " Visible:" + this._deviceConfigManager.getVisible(str) + " Priority:" + this._deviceConfigManager.getPriority(str));
      }
      i += 1;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void release()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.mTraeAudioManagerLooper != null)
    {
      this.mTraeAudioManagerLooper.quit();
      this.mTraeAudioManagerLooper = null;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  int sendResBroadcast(final Intent paramIntent, final HashMap<String, Object> paramHashMap, final int paramInt)
  {
    if (this._context == null) {
      return -1;
    }
    final Long localLong = (Long)paramHashMap.get("PARAM_SESSIONID");
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, " sessonID:" + localLong + " " + (String)paramHashMap.get("PARAM_OPERATION"));
    }
    if ((localLong == null) || (localLong.longValue() == -9223372036854775808L))
    {
      InternalNotifyDeviceListUpdate();
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, "sendResBroadcast sid null,don't send res");
      }
      return -1;
    }
    localLong = (Long)paramHashMap.get("PARAM_SESSIONID");
    paramHashMap = (String)paramHashMap.get("PARAM_OPERATION");
    if ("OPERATION_VOICECALL_PREPROCESS".equals(paramHashMap))
    {
      paramIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
      paramIntent.putExtra("PARAM_SESSIONID", localLong);
      paramIntent.putExtra("PARAM_OPERATION", paramHashMap);
      paramIntent.putExtra("PARAM_RES_ERRCODE", paramInt);
      if (this._audioSessionHost != null) {
        this._audioSessionHost.sendToAudioSessionMessage(paramIntent);
      }
    }
    for (;;)
    {
      return 0;
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          paramIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
          paramIntent.putExtra("PARAM_SESSIONID", localLong);
          paramIntent.putExtra("PARAM_OPERATION", paramHashMap);
          paramIntent.putExtra("PARAM_RES_ERRCODE", paramInt);
          if (TraeAudioManager.this._context != null) {
            TraeAudioManager.this._context.sendBroadcast(paramIntent);
          }
        }
      });
    }
  }
  
  void updateDeviceStatus()
  {
    int j = this._deviceConfigManager.getDeviceNumber();
    int i = 0;
    if (i < j)
    {
      String str = this._deviceConfigManager.getDeviceName(i);
      boolean bool;
      if (str != null) {
        if (str.equals("DEVICE_BLUETOOTHHEADSET")) {
          if (this._bluetoothCheck == null) {
            bool = this._deviceConfigManager.setVisible(str, false);
          }
        }
      }
      for (;;)
      {
        if ((bool == true) && (QLog.isColorLevel())) {
          QLog.w("TRAE", 0, "pollUpdateDevice dev:" + str + " Visible:" + this._deviceConfigManager.getVisible(str));
        }
        i += 1;
        break;
        bool = this._deviceConfigManager.setVisible(str, this._bluetoothCheck.isConnected());
        continue;
        if (str.equals("DEVICE_WIREDHEADSET"))
        {
          bool = this._deviceConfigManager.setVisible(str, this._am.isWiredHeadsetOn());
        }
        else
        {
          if (str.equals("DEVICE_SPEAKERPHONE")) {
            this._deviceConfigManager.setVisible(str, true);
          }
          bool = false;
        }
      }
    }
    checkAutoDeviceListUpdate();
  }
  
  @TargetApi(11)
  class BluetoohHeadsetCheck
    extends TraeAudioManager.BluetoohHeadsetCheckInterface
    implements BluetoothProfile.ServiceListener
  {
    BluetoothAdapter _adapter = null;
    Context _ctx = null;
    TraeAudioManager.DeviceConfigManager _devCfg = null;
    BluetoothProfile _profile = null;
    private final ReentrantLock _profileLock = new ReentrantLock();
    
    BluetoohHeadsetCheck()
    {
      super();
    }
    
    void _addAction(IntentFilter paramIntentFilter)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, " " + interfaceDesc() + " _addAction");
      }
      paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
      paramIntentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
      paramIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
    }
    
    void _onReceive(Context paramContext, Intent paramIntent)
    {
      int i;
      int j;
      if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
        j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
        paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + getBTAdapterConnectionState(i));
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "    EXTRA_PREVIOUS_CONNECTION_STATE " + getBTAdapterConnectionState(j));
        }
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("    EXTRA_DEVICE ").append(paramIntent).append(" ");
          if (paramIntent != null)
          {
            paramContext = paramIntent.getName();
            QLog.w("TRAE", 0, paramContext);
          }
        }
        else
        {
          if (i != 2) {
            break label252;
          }
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "   dev:" + paramIntent.getName() + " connected,start sco...");
          }
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          localObject = this._devCfg;
          if (paramIntent == null) {
            break label246;
          }
          paramContext = paramIntent.getName();
          label233:
          ((TraeAudioManager.DeviceConfigManager)localObject).setBluetoothName(paramContext);
        }
      }
      label246:
      label252:
      do
      {
        do
        {
          do
          {
            return;
            paramContext = " ";
            break;
            paramContext = "unkown";
            break label233;
          } while (i != 0);
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          return;
          if (!"android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(paramIntent.getAction())) {
            break label410;
          }
          i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
          j = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
          paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:" + paramContext);
          }
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "   EXTRA_SCO_AUDIO_STATE " + getSCOAudioStateExtraString(i));
          }
        } while (!QLog.isColorLevel());
        QLog.w("TRAE", 0, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + getSCOAudioStateExtraString(j));
        return;
      } while (!"android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()));
      label410:
      paramContext = BluetoothAdapter.getDefaultAdapter();
      switch (paramContext.getProfileConnectionState(2))
      {
      case 1: 
      default: 
        QLog.w("TRAE", 0, "BluetoothA2dp" + paramContext.getProfileConnectionState(2));
        return;
      case 2: 
        QLog.w("TRAE", 0, "BluetoothA2dp STATE_CONNECTED");
        TraeAudioManager.this.IsBluetoothA2dpExisted = true;
        return;
      }
      QLog.w("TRAE", 0, "BluetoothA2dp STATE_DISCONNECTED");
      TraeAudioManager.this.IsBluetoothA2dpExisted = false;
    }
    
    @TargetApi(11)
    public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
    {
      AudioDeviceInterface.LogTraceEntry("");
      if ((paramContext == null) || (paramDeviceConfigManager == null)) {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, " err ctx==null||_devCfg==null");
        }
      }
      do
      {
        return false;
        this._ctx = paramContext;
        this._devCfg = paramDeviceConfigManager;
        this._adapter = BluetoothAdapter.getDefaultAdapter();
        if (this._adapter != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TRAE", 0, " err getDefaultAdapter fail!");
      return false;
      this._profileLock.lock();
      try
      {
        if ((this._adapter.isEnabled()) && (this._profile == null) && (!this._adapter.getProfileProxy(this._ctx, this, 1)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 0, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
          }
          return false;
        }
        this._profileLock.unlock();
        AudioDeviceInterface.LogTraceExit();
        return true;
      }
      finally
      {
        this._profileLock.unlock();
      }
    }
    
    public String interfaceDesc()
    {
      return "BluetoohHeadsetCheck";
    }
    
    public boolean isConnected()
    {
      boolean bool2 = false;
      this._profileLock.lock();
      boolean bool1 = bool2;
      try
      {
        if (this._profile != null)
        {
          List localList = this._profile.getConnectedDevices();
          if (localList == null) {
            return false;
          }
          int i = localList.size();
          bool1 = bool2;
          if (i > 0) {
            bool1 = true;
          }
        }
        return bool1;
      }
      finally
      {
        this._profileLock.unlock();
      }
    }
    
    @TargetApi(11)
    public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
    {
      AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile + " profile:" + paramInt + " proxy:" + paramBluetoothProfile);
      if (paramInt == 1) {
        this._profileLock.lock();
      }
      for (;;)
      {
        int i;
        try
        {
          if ((this._profile != null) && (this._profile != paramBluetoothProfile))
          {
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 0, "BluetoohHeadsetCheck: HEADSET Connected proxy:" + paramBluetoothProfile + " _profile:" + this._profile);
            }
            this._adapter.closeProfileProxy(1, this._profile);
            this._profile = null;
          }
          this._profile = paramBluetoothProfile;
          if (this._profile == null) {
            break label464;
          }
          paramBluetoothProfile = this._profile.getConnectedDevices();
          if ((paramBluetoothProfile != null) && (this._profile != null))
          {
            if (!QLog.isColorLevel()) {
              break label469;
            }
            QLog.w("TRAE", 0, "TRAEBluetoohProxy: HEADSET Connected devs:" + paramBluetoothProfile.size() + " _profile:" + this._profile);
            break label469;
            if (i < paramBluetoothProfile.size())
            {
              BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramBluetoothProfile.get(i);
              try
              {
                if (this._profile == null) {
                  break label459;
                }
                paramInt = this._profile.getConnectionState(localBluetoothDevice);
                if (paramInt == 2) {
                  this._devCfg.setBluetoothName(localBluetoothDevice.getName());
                }
                if (QLog.isColorLevel()) {
                  QLog.w("TRAE", 0, "   " + i + " " + localBluetoothDevice.getName() + " ConnectionState:" + paramInt);
                }
                i += 1;
              }
              catch (Exception localException)
              {
                paramInt = 0;
                continue;
              }
            }
          }
          this._profileLock.unlock();
          if (this._devCfg != null)
          {
            if (TraeAudioManager.this._deviceConfigManager == null) {
              break label454;
            }
            paramBluetoothProfile = TraeAudioManager.this._deviceConfigManager.getBluetoothName();
            if (TextUtils.isEmpty(paramBluetoothProfile)) {
              this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
            }
          }
          else
          {
            AudioDeviceInterface.LogTraceExit();
            return;
          }
        }
        finally
        {
          this._profileLock.unlock();
        }
        if (isConnected())
        {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          TraeAudioManager.this.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
        }
        else
        {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          continue;
          label454:
          paramBluetoothProfile = null;
          continue;
          label459:
          paramInt = 0;
          continue;
          label464:
          paramBluetoothProfile = null;
          continue;
          label469:
          i = 0;
        }
      }
    }
    
    @TargetApi(11)
    public void onServiceDisconnected(int paramInt)
    {
      AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile + " profile:" + paramInt);
      if (paramInt == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "TRAEBluetoohProxy: HEADSET Disconnected");
        }
        if (isConnected()) {
          TraeAudioManager.this.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
        }
        this._profileLock.lock();
      }
      try
      {
        if (this._profile != null)
        {
          this._adapter.closeProfileProxy(1, this._profile);
          this._profile = null;
        }
        this._profileLock.unlock();
        AudioDeviceInterface.LogTraceExit();
        return;
      }
      finally
      {
        this._profileLock.unlock();
      }
    }
    
    public void release()
    {
      AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile);
      this._profileLock.lock();
      try
      {
        if (this._adapter != null)
        {
          if (this._profile != null) {
            this._adapter.closeProfileProxy(1, this._profile);
          }
          this._profile = null;
        }
        this._profileLock.unlock();
        AudioDeviceInterface.LogTraceExit();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, " closeProfileProxy:e:" + localException.getMessage());
          }
          this._profileLock.unlock();
        }
      }
      finally
      {
        this._profileLock.unlock();
      }
    }
  }
  
  class BluetoohHeadsetCheckFake
    extends TraeAudioManager.BluetoohHeadsetCheckInterface
  {
    BluetoohHeadsetCheckFake()
    {
      super();
    }
    
    void _addAction(IntentFilter paramIntentFilter) {}
    
    void _onReceive(Context paramContext, Intent paramIntent) {}
    
    public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
    {
      return true;
    }
    
    public String interfaceDesc()
    {
      return "BluetoohHeadsetCheckFake";
    }
    
    public boolean isConnected()
    {
      return false;
    }
    
    public void release() {}
  }
  
  class BluetoohHeadsetCheckFor2x
    extends TraeAudioManager.BluetoohHeadsetCheckInterface
  {
    public static final String ACTION_BLUETOOTHHEADSET_AUDIO_STATE_CHANGED = "android.bluetooth.headset.action.AUDIO_STATE_CHANGED";
    public static final String ACTION_BLUETOOTHHEADSET_STATE_CHANGED = "android.bluetooth.headset.action.STATE_CHANGED";
    public static final int AUDIO_STATE_CONNECTED = 1;
    public static final int AUDIO_STATE_DISCONNECTED = 0;
    static final int STATE_CONNECTED = 2;
    static final int STATE_DISCONNECTED = 0;
    Class<?> BluetoothHeadsetClass = null;
    Object BluetoothHeadsetObj = null;
    Class<?> ListenerClass = null;
    Context _ctx = null;
    TraeAudioManager.DeviceConfigManager _devCfg = null;
    Method getCurrentHeadsetMethod = null;
    
    BluetoohHeadsetCheckFor2x()
    {
      super();
    }
    
    void _addAction(IntentFilter paramIntentFilter)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, " " + interfaceDesc() + " _addAction");
      }
      paramIntentFilter.addAction("android.bluetooth.headset.action.AUDIO_STATE_CHANGED");
      paramIntentFilter.addAction("android.bluetooth.headset.action.STATE_CHANGED");
    }
    
    void _onReceive(Context paramContext, Intent paramIntent)
    {
      int i;
      int j;
      int k;
      if ("android.bluetooth.headset.action.AUDIO_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
        j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
        k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "++ AUDIO_STATE_CHANGED|  STATE " + i);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "       PREVIOUS_STATE " + j);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "       AUDIO_STATE " + k);
        }
        if (k != 2) {}
      }
      do
      {
        do
        {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          do
          {
            return;
          } while (k != 0);
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          return;
        } while (!"android.bluetooth.headset.action.STATE_CHANGED".equals(paramIntent.getAction()));
        i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
        j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
        k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "++ STATE_CHANGED|  STATE " + i);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "       PREVIOUS_STATE " + j);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "       AUDIO_STATE " + k);
        }
        if (k == 2)
        {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          return;
        }
      } while (k != 0);
      this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
    }
    
    public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
    {
      AudioDeviceInterface.LogTraceEntry("");
      this._ctx = paramContext;
      this._devCfg = paramDeviceConfigManager;
      if ((this._ctx == null) || (this._devCfg == null)) {}
      for (;;)
      {
        return false;
        try
        {
          this.BluetoothHeadsetClass = Class.forName("android.bluetooth.BluetoothHeadset");
          if (this.BluetoothHeadsetClass == null) {
            continue;
          }
        }
        catch (Exception paramDeviceConfigManager)
        {
          try
          {
            this.ListenerClass = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
            if (this.ListenerClass != null) {}
          }
          catch (Exception paramDeviceConfigManager)
          {
            try
            {
              this.getCurrentHeadsetMethod = this.BluetoothHeadsetClass.getDeclaredMethod("getCurrentHeadset", new Class[0]);
              if (this.getCurrentHeadsetMethod == null) {
                continue;
              }
            }
            catch (NoSuchMethodException paramDeviceConfigManager)
            {
              try
              {
                do
                {
                  for (;;)
                  {
                    this.BluetoothHeadsetObj = this.BluetoothHeadsetClass.getConstructor(new Class[] { Context.class, this.ListenerClass }).newInstance(new Object[] { paramContext, null });
                    if (this.BluetoothHeadsetObj == null) {
                      break;
                    }
                    this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", isConnected());
                    if (!isConnected()) {
                      break label344;
                    }
                    this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
                    TraeAudioManager.this.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
                    AudioDeviceInterface.LogTraceExit();
                    return true;
                    paramDeviceConfigManager = paramDeviceConfigManager;
                    if (QLog.isColorLevel())
                    {
                      QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset class not found");
                      continue;
                      paramDeviceConfigManager = paramDeviceConfigManager;
                      if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset.ServiceListener class not found:" + paramDeviceConfigManager);
                      }
                    }
                  }
                  paramDeviceConfigManager = paramDeviceConfigManager;
                } while (!QLog.isColorLevel());
                QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
              }
              catch (IllegalArgumentException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException");
                  }
                }
              }
              catch (InstantiationException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor InstantiationException");
                  }
                }
              }
              catch (IllegalAccessException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException");
                  }
                }
              }
              catch (InvocationTargetException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException");
                  }
                }
              }
              catch (NoSuchMethodException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel())
                  {
                    QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
                    continue;
                    label344:
                    this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public String interfaceDesc()
    {
      return "BluetoohHeadsetCheckFor2x";
    }
    
    public boolean isConnected()
    {
      String str4 = null;
      if ((this.getCurrentHeadsetMethod == null) || (this.getCurrentHeadsetMethod == null)) {
        return false;
      }
      try
      {
        Object localObject = this.getCurrentHeadsetMethod.invoke(this.BluetoothHeadsetObj, new Object[0]);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("BTLooperThread BluetoothHeadset method getCurrentHeadset res:");
          if (localObject != null)
          {
            str4 = " Y";
            QLog.w("TRAE", 0, str4);
          }
        }
        else
        {
          if (localObject == null) {
            break label152;
          }
          return true;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          String str1 = str4;
          if (QLog.isColorLevel())
          {
            QLog.w("TRAE", 0, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException");
            str1 = str4;
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          String str2 = str4;
          if (QLog.isColorLevel())
          {
            QLog.w("TRAE", 0, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException");
            str2 = str4;
          }
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        for (;;)
        {
          String str3 = str4;
          if (QLog.isColorLevel())
          {
            QLog.w("TRAE", 0, "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException");
            str3 = str4;
            continue;
            str4 = "N";
          }
        }
      }
      label152:
      return false;
    }
    
    public void release()
    {
      AudioDeviceInterface.LogTraceEntry("");
      if (this.BluetoothHeadsetObj == null) {}
      for (;;)
      {
        return;
        try
        {
          localMethod = this.BluetoothHeadsetClass.getDeclaredMethod("close", new Class[0]);
          if (localMethod == null) {
            continue;
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          try
          {
            Method localMethod;
            localMethod.invoke(this.BluetoothHeadsetObj, new Object[0]);
            label44:
            this.BluetoothHeadsetClass = null;
            this.ListenerClass = null;
            this.BluetoothHeadsetObj = null;
            this.getCurrentHeadsetMethod = null;
            AudioDeviceInterface.LogTraceExit();
            return;
            localNoSuchMethodException = localNoSuchMethodException;
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 0, "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
            }
            Object localObject = null;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            break label44;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            break label44;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            break label44;
          }
        }
      }
    }
  }
  
  abstract class BluetoohHeadsetCheckInterface
  {
    BluetoohHeadsetCheckInterface() {}
    
    abstract void _addAction(IntentFilter paramIntentFilter);
    
    abstract void _onReceive(Context paramContext, Intent paramIntent);
    
    public void addAction(IntentFilter paramIntentFilter)
    {
      paramIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      paramIntentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
      paramIntentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
      _addAction(paramIntentFilter);
    }
    
    String getBTActionStateChangedExtraString(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "STATE_OFF";
        continue;
        str = "STATE_TURNING_ON";
        continue;
        str = "STATE_ON";
        continue;
        str = "STATE_TURNING_OFF";
      }
    }
    
    String getBTAdapterConnectionState(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "STATE_DISCONNECTED";
        continue;
        str = "STATE_CONNECTING";
        continue;
        str = "STATE_CONNECTED";
        continue;
        str = "STATE_DISCONNECTING";
      }
    }
    
    String getBTHeadsetAudioState(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      case 11: 
      default: 
        str = "unknow:" + paramInt;
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "STATE_AUDIO_CONNECTED";
        continue;
        str = "STATE_AUDIO_DISCONNECTED";
      }
    }
    
    String getBTHeadsetConnectionState(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "STATE_DISCONNECTED";
        continue;
        str = "STATE_CONNECTING";
        continue;
        str = "STATE_CONNECTED";
        continue;
        str = "STATE_DISCONNECTING";
      }
    }
    
    String getSCOAudioStateExtraString(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "SCO_AUDIO_STATE_DISCONNECTED";
        continue;
        str = "SCO_AUDIO_STATE_CONNECTED";
        continue;
        str = "SCO_AUDIO_STATE_CONNECTING";
        continue;
        str = "SCO_AUDIO_STATE_ERROR";
      }
    }
    
    public abstract boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager);
    
    public abstract String interfaceDesc();
    
    public abstract boolean isConnected();
    
    public void onReceive(Context paramContext, Intent paramIntent, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
    {
      if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
        j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "BT ACTION_STATE_CHANGED|   EXTRA_STATE " + getBTActionStateChangedExtraString(i));
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "BT ACTION_STATE_CHANGED|   EXTRA_PREVIOUS_STATE " + getBTActionStateChangedExtraString(j));
        }
        if (i == 10) {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "    BT off");
          }
        }
      }
      while ((("android.bluetooth.device.action.ACL_CONNECTED".equals(paramIntent.getAction())) && (Build.VERSION.SDK_INT < 11)) || (("android.bluetooth.device.action.ACL_DISCONNECTED".equals(paramIntent.getAction())) && (Build.VERSION.SDK_INT < 11)))
      {
        int i;
        int j;
        paramDeviceConfigManager.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        do
        {
          return;
        } while ((i != 12) || (!QLog.isColorLevel()));
        QLog.w("TRAE", 0, "BT OFF-->ON,Visiable it...");
        return;
      }
      _onReceive(paramContext, paramIntent);
    }
    
    public abstract void release();
  }
  
  class DeviceConfigManager
  {
    String _bluetoothDevName = "unknow";
    String connectedDevice = "DEVICE_NONE";
    String connectingDevice = "DEVICE_NONE";
    HashMap<String, DeviceConfig> deviceConfigs = new HashMap();
    ReentrantLock mLock = new ReentrantLock();
    String prevConnectedDevice = "DEVICE_NONE";
    boolean visiableUpdate = false;
    
    public DeviceConfigManager() {}
    
    boolean _addConfig(String paramString, int paramInt)
    {
      AudioDeviceInterface.LogTraceEntry(" devName:" + paramString + " priority:" + paramInt);
      DeviceConfig localDeviceConfig = new DeviceConfig();
      if (localDeviceConfig.init(paramString, paramInt)) {
        if (this.deviceConfigs.containsKey(paramString)) {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 0, "err dev exist!");
          }
        }
      }
      while (!QLog.isColorLevel())
      {
        return false;
        this.deviceConfigs.put(paramString, localDeviceConfig);
        this.visiableUpdate = true;
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, " n" + getDeviceNumber() + " 0:" + getDeviceName(0));
        }
        AudioDeviceInterface.LogTraceExit();
        return true;
      }
      QLog.e("TRAE", 0, " err dev init!");
      return false;
    }
    
    ArrayList<String> _getAvailableDeviceList()
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.deviceConfigs.entrySet().iterator();
      while (localIterator.hasNext())
      {
        DeviceConfig localDeviceConfig = (DeviceConfig)((Map.Entry)localIterator.next()).getValue();
        if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
          localArrayList.add(localDeviceConfig.getDeviceName());
        }
      }
      return localArrayList;
    }
    
    String _getConnectedDevice()
    {
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(this.connectedDevice);
      if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
        return this.connectedDevice;
      }
      return "DEVICE_NONE";
    }
    
    String _getPrevConnectedDevice()
    {
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(this.prevConnectedDevice);
      if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
        return this.prevConnectedDevice;
      }
      return "DEVICE_NONE";
    }
    
    public void clearConfig()
    {
      this.mLock.lock();
      this.deviceConfigs.clear();
      this.prevConnectedDevice = "DEVICE_NONE";
      this.connectedDevice = "DEVICE_NONE";
      this.connectingDevice = "DEVICE_NONE";
      this.mLock.unlock();
    }
    
    public ArrayList<String> getAvailableDeviceList()
    {
      new ArrayList();
      this.mLock.lock();
      ArrayList localArrayList = _getAvailableDeviceList();
      this.mLock.unlock();
      return localArrayList;
    }
    
    public String getAvailabledHighestPriorityDevice()
    {
      Object localObject1 = null;
      this.mLock.lock();
      Iterator localIterator = this.deviceConfigs.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        ((Map.Entry)localObject2).getKey();
        ((Map.Entry)localObject2).getValue();
        DeviceConfig localDeviceConfig = (DeviceConfig)((Map.Entry)localObject2).getValue();
        if ((localDeviceConfig != null) && (localDeviceConfig.getVisible()))
        {
          if (localObject1 == null) {
            localObject2 = localDeviceConfig;
          }
          for (;;)
          {
            localObject1 = localObject2;
            break;
            localObject2 = localDeviceConfig;
            if (localDeviceConfig.getPriority() < localObject1.getPriority()) {
              localObject2 = localObject1;
            }
          }
        }
      }
      this.mLock.unlock();
      if (localObject1 != null) {
        return localObject1.getDeviceName();
      }
      return "DEVICE_SPEAKERPHONE";
    }
    
    public String getAvailabledHighestPriorityDevice(String paramString)
    {
      Object localObject1 = null;
      this.mLock.lock();
      Iterator localIterator = this.deviceConfigs.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        ((Map.Entry)localObject2).getKey();
        ((Map.Entry)localObject2).getValue();
        DeviceConfig localDeviceConfig = (DeviceConfig)((Map.Entry)localObject2).getValue();
        if ((localDeviceConfig != null) && (localDeviceConfig.getVisible()) && (!localDeviceConfig.getDeviceName().equals(paramString)))
        {
          if (localObject1 == null) {
            localObject2 = localDeviceConfig;
          }
          for (;;)
          {
            localObject1 = localObject2;
            break;
            localObject2 = localDeviceConfig;
            if (localDeviceConfig.getPriority() < localObject1.getPriority()) {
              localObject2 = localObject1;
            }
          }
        }
      }
      this.mLock.unlock();
      if (localObject1 != null) {
        return localObject1.getDeviceName();
      }
      return "DEVICE_SPEAKERPHONE";
    }
    
    public String getBluetoothName()
    {
      return this._bluetoothDevName;
    }
    
    public String getConnectedDevice()
    {
      this.mLock.lock();
      String str = _getConnectedDevice();
      this.mLock.unlock();
      return str;
    }
    
    public String getConnectingDevice()
    {
      this.mLock.lock();
      Object localObject = (DeviceConfig)this.deviceConfigs.get(this.connectingDevice);
      if ((localObject != null) && (((DeviceConfig)localObject).getVisible())) {}
      for (localObject = this.connectingDevice;; localObject = null)
      {
        this.mLock.unlock();
        return localObject;
      }
    }
    
    public String getDeviceName(int paramInt)
    {
      this.mLock.lock();
      Object localObject = this.deviceConfigs.entrySet().iterator();
      int i = 0;
      Map.Entry localEntry;
      if (((Iterator)localObject).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject).next();
        if (i != paramInt) {}
      }
      for (localObject = (DeviceConfig)localEntry.getValue();; localObject = null)
      {
        if (localObject != null) {}
        for (localObject = ((DeviceConfig)localObject).getDeviceName();; localObject = "DEVICE_NONE")
        {
          this.mLock.unlock();
          return localObject;
          i += 1;
          break;
        }
      }
    }
    
    public int getDeviceNumber()
    {
      this.mLock.lock();
      int i = this.deviceConfigs.size();
      this.mLock.unlock();
      return i;
    }
    
    public String getPrevConnectedDevice()
    {
      this.mLock.lock();
      String str = _getPrevConnectedDevice();
      this.mLock.unlock();
      return str;
    }
    
    public int getPriority(String paramString)
    {
      this.mLock.lock();
      paramString = (DeviceConfig)this.deviceConfigs.get(paramString);
      if (paramString != null) {}
      for (int i = paramString.getPriority();; i = -1)
      {
        this.mLock.unlock();
        return i;
      }
    }
    
    public HashMap<String, Object> getSnapParams()
    {
      HashMap localHashMap = new HashMap();
      this.mLock.lock();
      localHashMap.put("EXTRA_DATA_AVAILABLEDEVICE_LIST", _getAvailableDeviceList());
      localHashMap.put("EXTRA_DATA_CONNECTEDDEVICE", _getConnectedDevice());
      localHashMap.put("EXTRA_DATA_PREV_CONNECTEDDEVICE", _getPrevConnectedDevice());
      this.mLock.unlock();
      return localHashMap;
    }
    
    public boolean getVisiableUpdateFlag()
    {
      this.mLock.lock();
      boolean bool = this.visiableUpdate;
      this.mLock.unlock();
      return bool;
    }
    
    public boolean getVisible(String paramString)
    {
      this.mLock.lock();
      paramString = (DeviceConfig)this.deviceConfigs.get(paramString);
      if (paramString != null) {}
      for (boolean bool = paramString.getVisible();; bool = false)
      {
        this.mLock.unlock();
        return bool;
      }
    }
    
    public boolean init(String paramString)
    {
      AudioDeviceInterface.LogTraceEntry(" strConfigs:" + paramString);
      if ((paramString == null) || (paramString.length() <= 0)) {}
      do
      {
        String str;
        do
        {
          return false;
          str = paramString.replace("\n", "").replace("\r", "");
        } while ((str == null) || (str.length() <= 0));
        paramString = str;
        if (str.indexOf(";") < 0) {
          paramString = str + ";";
        }
        paramString = paramString.split(";");
      } while ((paramString == null) || (1 > paramString.length));
      this.mLock.lock();
      int i = 0;
      while (i < paramString.length)
      {
        _addConfig(paramString[i], i);
        i += 1;
      }
      this.mLock.unlock();
      TraeAudioManager.this.printDevices();
      return true;
    }
    
    public boolean isConnected(String paramString)
    {
      this.mLock.lock();
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(paramString);
      if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {}
      for (boolean bool = this.connectedDevice.equals(paramString);; bool = false)
      {
        this.mLock.unlock();
        return bool;
      }
    }
    
    public void resetVisiableUpdateFlag()
    {
      this.mLock.lock();
      this.visiableUpdate = false;
      this.mLock.unlock();
    }
    
    public void setBluetoothName(String paramString)
    {
      if (paramString == null)
      {
        this._bluetoothDevName = "unknow";
        return;
      }
      if (paramString.isEmpty())
      {
        this._bluetoothDevName = "unknow";
        return;
      }
      this._bluetoothDevName = paramString;
    }
    
    public boolean setConnected(String paramString)
    {
      this.mLock.lock();
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(paramString);
      if ((localDeviceConfig != null) && (localDeviceConfig.getVisible()))
      {
        if ((this.connectedDevice != null) && (!this.connectedDevice.equals(paramString))) {
          this.prevConnectedDevice = this.connectedDevice;
        }
        this.connectedDevice = paramString;
        this.connectingDevice = "";
      }
      for (boolean bool = true;; bool = false)
      {
        this.mLock.unlock();
        return bool;
      }
    }
    
    public boolean setConnecting(String paramString)
    {
      this.mLock.lock();
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(paramString);
      if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
        this.connectingDevice = paramString;
      }
      for (boolean bool = true;; bool = false)
      {
        this.mLock.unlock();
        return bool;
      }
    }
    
    public boolean setVisible(String paramString, boolean paramBoolean)
    {
      this.mLock.lock();
      Object localObject = (DeviceConfig)this.deviceConfigs.get(paramString);
      if ((localObject != null) && (((DeviceConfig)localObject).getVisible() != paramBoolean))
      {
        ((DeviceConfig)localObject).setVisible(paramBoolean);
        this.visiableUpdate = true;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append(" ++setVisible:").append(paramString);
          if (!paramBoolean) {
            break label98;
          }
          paramString = " Y";
          QLog.w("TRAE", 0, paramString);
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.mLock.unlock();
        return paramBoolean;
        label98:
        paramString = " N";
        break;
      }
    }
    
    public class DeviceConfig
    {
      String deviceName = "DEVICE_NONE";
      int priority = 0;
      boolean visible = false;
      
      public DeviceConfig() {}
      
      public String getDeviceName()
      {
        return this.deviceName;
      }
      
      public int getPriority()
      {
        return this.priority;
      }
      
      public boolean getVisible()
      {
        return this.visible;
      }
      
      public boolean init(String paramString, int paramInt)
      {
        if ((paramString == null) || (paramString.length() <= 0)) {}
        while (TraeAudioManager.checkDevName(paramString) != true) {
          return false;
        }
        this.deviceName = paramString;
        this.priority = paramInt;
        return true;
      }
      
      public void setVisible(boolean paramBoolean)
      {
        this.visible = paramBoolean;
      }
    }
  }
  
  public class Parameters
  {
    public static final String BLUETOOTHPOLICY = "com.tencent.sharp.TraeAudioManager.Parameters.BLUETOOTHPOLICY";
    public static final String CONTEXT = "com.tencent.sharp.TraeAudioManager.Parameters.CONTEXT";
    public static final String DEVICECONFIG = "com.tencent.sharp.TraeAudioManager.Parameters.DEVICECONFIG";
    public static final String MODEPOLICY = "com.tencent.sharp.TraeAudioManager.Parameters.MODEPOLICY";
    
    public Parameters() {}
  }
  
  class TraeAudioManagerLooper
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
    boolean _enabled;
    int _focusSteamType;
    String _lastCfg;
    TraeAudioManager _parent;
    int _preRingMode;
    int _preServiceMode;
    String _ringOperation;
    TraeMediaPlayer _ringPlayer;
    long _ringSessionID;
    String _ringUserdata;
    final boolean[] _started;
    String _voiceCallOperation;
    long _voiceCallSessionID;
    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener;
    Handler mMsgHandler;
    
    /* Error */
    public TraeAudioManagerLooper(TraeAudioManager paramTraeAudioManager)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 88	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:this$0	Lcom/tencent/TMG/audio/TraeAudioManager;
      //   5: aload_0
      //   6: invokespecial 91	java/lang/Thread:<init>	()V
      //   9: aload_0
      //   10: aconst_null
      //   11: putfield 93	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:mMsgHandler	Landroid/os/Handler;
      //   14: aload_0
      //   15: aconst_null
      //   16: putfield 95	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_ringPlayer	Lcom/tencent/TMG/audio/TraeMediaPlayer;
      //   19: aload_0
      //   20: ldc2_w 96
      //   23: putfield 99	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_ringSessionID	J
      //   26: aload_0
      //   27: ldc 101
      //   29: putfield 103	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_ringOperation	Ljava/lang/String;
      //   32: aload_0
      //   33: ldc 101
      //   35: putfield 105	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_ringUserdata	Ljava/lang/String;
      //   38: aload_0
      //   39: iconst_1
      //   40: newarray boolean
      //   42: dup
      //   43: iconst_0
      //   44: iconst_0
      //   45: bastore
      //   46: putfield 107	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   49: aload_0
      //   50: iconst_0
      //   51: putfield 109	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_enabled	Z
      //   54: aload_0
      //   55: aconst_null
      //   56: putfield 111	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_parent	Lcom/tencent/TMG/audio/TraeAudioManager;
      //   59: aload_0
      //   60: ldc 101
      //   62: putfield 113	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_lastCfg	Ljava/lang/String;
      //   65: aload_0
      //   66: iconst_0
      //   67: putfield 115	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_preServiceMode	I
      //   70: aload_0
      //   71: iconst_0
      //   72: putfield 117	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_preRingMode	I
      //   75: aload_0
      //   76: ldc2_w 96
      //   79: putfield 119	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_voiceCallSessionID	J
      //   82: aload_0
      //   83: ldc 101
      //   85: putfield 121	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_voiceCallOperation	Ljava/lang/String;
      //   88: aload_0
      //   89: aconst_null
      //   90: putfield 123	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:mAudioFocusChangeListener	Landroid/media/AudioManager$OnAudioFocusChangeListener;
      //   93: aload_0
      //   94: iconst_0
      //   95: putfield 125	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_focusSteamType	I
      //   98: aload_0
      //   99: aload_2
      //   100: putfield 111	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_parent	Lcom/tencent/TMG/audio/TraeAudioManager;
      //   103: invokestatic 131	android/os/SystemClock:elapsedRealtime	()J
      //   106: lstore_3
      //   107: invokestatic 137	com/tencent/TMG/utils/QLog:isColorLevel	()Z
      //   110: ifeq +11 -> 121
      //   113: ldc 139
      //   115: iconst_0
      //   116: ldc 141
      //   118: invokestatic 145	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   121: aload_0
      //   122: invokevirtual 148	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:start	()V
      //   125: aload_0
      //   126: getfield 107	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   129: astore_1
      //   130: aload_1
      //   131: monitorenter
      //   132: aload_0
      //   133: getfield 107	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   136: iconst_0
      //   137: baload
      //   138: istore 5
      //   140: iload 5
      //   142: ifne +13 -> 155
      //   145: aload_0
      //   146: getfield 107	com/tencent/TMG/audio/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   149: ldc2_w 149
      //   152: invokevirtual 156	java/lang/Object:wait	(J)V
      //   155: aload_1
      //   156: monitorexit
      //   157: invokestatic 137	com/tencent/TMG/utils/QLog:isColorLevel	()Z
      //   160: ifeq +37 -> 197
      //   163: ldc 139
      //   165: iconst_0
      //   166: new 158	java/lang/StringBuilder
      //   169: dup
      //   170: invokespecial 159	java/lang/StringBuilder:<init>	()V
      //   173: ldc 161
      //   175: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: invokestatic 131	android/os/SystemClock:elapsedRealtime	()J
      //   181: lload_3
      //   182: lsub
      //   183: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   186: ldc 170
      //   188: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   191: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   194: invokestatic 145	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   197: return
      //   198: astore_2
      //   199: aload_1
      //   200: monitorexit
      //   201: aload_2
      //   202: athrow
      //   203: astore_2
      //   204: goto -49 -> 155
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	207	0	this	TraeAudioManagerLooper
      //   0	207	1	this$1	TraeAudioManager
      //   0	207	2	paramTraeAudioManager	TraeAudioManager
      //   106	76	3	l	long
      //   138	3	5	i	int
      // Exception table:
      //   from	to	target	type
      //   132	140	198	finally
      //   145	155	198	finally
      //   155	157	198	finally
      //   199	201	198	finally
      //   145	155	203	java/lang/InterruptedException
    }
    
    int InternalGetStreamType(HashMap<String, Object> paramHashMap)
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this._preRingMode);
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, " InternalStopRing am==null!!");
        }
        return -1;
      }
      if (TraeAudioManager.this._activeMode == 2) {}
      for (int i = this._ringPlayer.getStreamType();; i = TraeAudioManager.this._streamType)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("EXTRA_DATA_STREAMTYPE", i);
        TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
        AudioDeviceInterface.LogTraceExit();
        return 0;
      }
    }
    
    int InternalNotifyStreamTypeUpdate(final int paramInt)
    {
      if (TraeAudioManager.this._context == null) {
        return -1;
      }
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          Intent localIntent = new Intent();
          localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
          localIntent.putExtra("PARAM_OPERATION", "NOTIFY_STREAMTYPE_UPDATE");
          localIntent.putExtra("EXTRA_DATA_STREAMTYPE", paramInt);
          if (TraeAudioManager.this._context != null) {
            TraeAudioManager.this._context.sendBroadcast(localIntent);
          }
        }
      });
      return 0;
    }
    
    int InternalSessionGetDeviceList(HashMap<String, Object> paramHashMap)
    {
      Intent localIntent = new Intent();
      Object localObject = TraeAudioManager.this._deviceConfigManager.getSnapParams();
      ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
      String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
      localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
      localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
      localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
      localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)localObject);
      localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", TraeAudioManager.this._deviceConfigManager.getBluetoothName());
      TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
      return 0;
    }
    
    int InternalStartRing(HashMap<String, Object> paramHashMap)
    {
      boolean bool1 = true;
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, " InternalStartRing am==null!!");
        }
        return -1;
      }
      if (TraeAudioManager.this._activeMode == 2) {
        interruptRing();
      }
      for (;;)
      {
        try
        {
          this._ringSessionID = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
          this._ringOperation = ((String)paramHashMap.get("PARAM_OPERATION"));
          this._ringUserdata = ((String)paramHashMap.get("PARAM_RING_USERDATA_STRING"));
          int i = ((Integer)paramHashMap.get("PARAM_RING_DATASOURCE")).intValue();
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "  dataSource:" + i);
          }
          int j = ((Integer)paramHashMap.get("PARAM_RING_RSID")).intValue();
          Uri localUri = (Uri)paramHashMap.get("PARAM_RING_URI");
          String str = (String)paramHashMap.get("PARAM_RING_FILEPATH");
          boolean bool2 = ((Boolean)paramHashMap.get("PARAM_RING_LOOP")).booleanValue();
          int k = ((Integer)paramHashMap.get("PARAM_RING_LOOPCOUNT")).intValue();
          boolean bool3 = ((Boolean)paramHashMap.get("PARAM_RING_MODE")).booleanValue();
          if (TraeAudioManager.this._activeMode != 1) {
            TraeAudioManager.this._activeMode = 2;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
          TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
          this._preRingMode = TraeAudioManager.this._am.getMode();
          paramHashMap = this._ringPlayer;
          if (TraeAudioManager.this._activeMode == 1)
          {
            paramHashMap.playRing(i, j, localUri, str, bool2, k, bool3, bool1, TraeAudioManager.this._streamType);
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 0, " _ringUserdata:" + this._ringUserdata + " DurationMS:" + this._ringPlayer.getDuration());
            }
            if (!this._ringPlayer.hasCall()) {
              requestAudioFocus(this._ringPlayer.getStreamType());
            }
            InternalNotifyStreamTypeUpdate(this._ringPlayer.getStreamType());
            AudioDeviceInterface.LogTraceExit();
            return 0;
          }
        }
        catch (Exception paramHashMap)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 0, " startRing err params");
          }
          return -1;
        }
        bool1 = false;
      }
    }
    
    int InternalStopRing(HashMap<String, Object> paramHashMap)
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this._preRingMode);
      if ((TraeAudioManager.this._am == null) || (this._ringPlayer == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, " InternalStopRing am==null!!");
        }
        return -1;
      }
      this._ringPlayer.stopRing();
      if ((!this._ringPlayer.hasCall()) && (TraeAudioManager.this._activeMode == 2))
      {
        abandonAudioFocus();
        TraeAudioManager.this._activeMode = 0;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
      TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    
    int InternalVoicecallPostprocess(HashMap<String, Object> paramHashMap)
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, " InternalVoicecallPostprocess am==null!!");
        }
        return -1;
      }
      if (TraeAudioManager.this._activeMode != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, " not ACTIVE_VOICECALL!!");
        }
        Intent localIntent = new Intent();
        TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 3);
        return -1;
      }
      TraeAudioManager.this._activeMode = 0;
      abandonAudioFocus();
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    
    int InternalVoicecallPreprocess(HashMap<String, Object> paramHashMap)
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (paramHashMap == null) {
        return -1;
      }
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, " InternalVoicecallPreprocess am==null!!");
        }
        return -1;
      }
      if (TraeAudioManager.this._activeMode == 1)
      {
        localObject = new Intent();
        TraeAudioManager.this.sendResBroadcast((Intent)localObject, paramHashMap, 2);
        return -1;
      }
      this._voiceCallSessionID = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
      this._voiceCallOperation = ((String)paramHashMap.get("PARAM_OPERATION"));
      TraeAudioManager.this._activeMode = 1;
      TraeAudioManager.this._prevMode = TraeAudioManager.this._am.getMode();
      Object localObject = (Integer)paramHashMap.get("PARAM_MODEPOLICY");
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, " params.get(PARAM_MODEPOLICY)==null!!");
        }
        TraeAudioManager.this._modePolicy = -1;
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, "  _modePolicy:" + TraeAudioManager.this._modePolicy);
        }
        localObject = (Integer)paramHashMap.get("PARAM_STREAMTYPE");
        if (localObject != null) {
          break label367;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, " params.get(PARAM_STREAMTYPE)==null!!");
        }
        TraeAudioManager.this._streamType = 0;
        label263:
        if ((!TraeAudioManager.isCloseSystemAPM(TraeAudioManager.this._modePolicy)) || (TraeAudioManager.this._activeMode == 2) || (TraeAudioManager.this._deviceConfigManager == null)) {
          break label397;
        }
        if (!TraeAudioManager.this._deviceConfigManager.getConnectedDevice().equals("DEVICE_SPEAKERPHONE")) {
          break label381;
        }
        TraeAudioManager.this.InternalSetMode(0);
        requestAudioFocus(3);
      }
      for (;;)
      {
        localObject = new Intent();
        TraeAudioManager.this.sendResBroadcast((Intent)localObject, paramHashMap, 0);
        AudioDeviceInterface.LogTraceExit();
        return 0;
        TraeAudioManager.this._modePolicy = ((Integer)localObject).intValue();
        break;
        label367:
        TraeAudioManager.this._streamType = ((Integer)localObject).intValue();
        break label263;
        label381:
        TraeAudioManager.this.InternalSetMode(3);
        requestAudioFocus(0);
        continue;
        label397:
        TraeAudioManager.this.InternalSetMode(TraeAudioManager.getCallAudioMode(TraeAudioManager.this._modePolicy));
        requestAudioFocus(TraeAudioManager.this._streamType);
      }
    }
    
    void _init()
    {
      AudioDeviceInterface.LogTraceEntry("");
      try
      {
        TraeAudioManager.this._audioSessionHost = new TraeAudioSessionHost();
        TraeAudioManager.this._deviceConfigManager = new TraeAudioManager.DeviceConfigManager(TraeAudioManager.this);
        TraeAudioManager._gHostProcessId = Process.myPid();
        TraeAudioManager.this._am = ((AudioManager)TraeAudioManager.this._context.getSystemService("audio"));
        TraeAudioManager.this._bluetoothCheck = TraeAudioManager.this.CreateBluetoothCheck(TraeAudioManager.this._context, TraeAudioManager.this._deviceConfigManager);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
        localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        TraeAudioManager.this._bluetoothCheck.addAction(localIntentFilter);
        localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        TraeAudioManager.this._context.registerReceiver(this._parent, localIntentFilter);
        AudioDeviceInterface.LogTraceExit();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "======7");
          }
        }
      }
    }
    
    void _post_stopService()
    {
      try
      {
        if (TraeAudioManager.this._bluetoothCheck != null) {
          TraeAudioManager.this._bluetoothCheck.release();
        }
        TraeAudioManager.this._bluetoothCheck = null;
        if (TraeAudioManager.this._context != null)
        {
          TraeAudioManager.this._context.unregisterReceiver(this._parent);
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
          TraeAudioManager.this._context.registerReceiver(this._parent, localIntentFilter);
        }
        return;
      }
      catch (Exception localException) {}
    }
    
    void _prev_startService()
    {
      try
      {
        TraeAudioManager.this._am = ((AudioManager)TraeAudioManager.this._context.getSystemService("audio"));
        if (TraeAudioManager.this._bluetoothCheck == null) {
          TraeAudioManager.this._bluetoothCheck = TraeAudioManager.this.CreateBluetoothCheck(TraeAudioManager.this._context, TraeAudioManager.this._deviceConfigManager);
        }
        TraeAudioManager.this._context.unregisterReceiver(this._parent);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
        localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        TraeAudioManager.this._bluetoothCheck.addAction(localIntentFilter);
        localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        TraeAudioManager.this._context.registerReceiver(this._parent, localIntentFilter);
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
        if (TraeAudioManager.this._bluetoothCheck != null) {
          TraeAudioManager.this._bluetoothCheck.release();
        }
        TraeAudioManager.this._bluetoothCheck = null;
        if (TraeAudioManager.this._context != null)
        {
          TraeAudioManager.this._context.unregisterReceiver(this._parent);
          TraeAudioManager.this._context = null;
        }
        if (TraeAudioManager.this._deviceConfigManager != null) {
          TraeAudioManager.this._deviceConfigManager.clearConfig();
        }
        TraeAudioManager.this._deviceConfigManager = null;
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
      if (Build.VERSION.SDK_INT <= 8) {}
      while ((TraeAudioManager.this._am == null) || (this.mAudioFocusChangeListener == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "-------abandonAudioFocus _focusSteamType:" + this._focusSteamType);
      }
      TraeAudioManager.this._am.abandonAudioFocus(this.mAudioFocusChangeListener);
      this.mAudioFocusChangeListener = null;
    }
    
    int interruptRing()
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this._preRingMode);
      if (TraeAudioManager.this._am == null) {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, " interruptRing am==null!!");
        }
      }
      do
      {
        return -1;
        if (TraeAudioManager.this._activeMode == 2) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TRAE", 0, " not ACTIVE_RING!!");
      return -1;
      this._ringPlayer.stopRing();
      abandonAudioFocus();
      TraeAudioManager.this._activeMode = 0;
      HashMap localHashMap = new HashMap();
      localHashMap.put("PARAM_SESSIONID", Long.valueOf(this._ringSessionID));
      localHashMap.put("PARAM_OPERATION", this._ringOperation);
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
      TraeAudioManager.this.sendResBroadcast(localIntent, localHashMap, 4);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    
    int interruptVoicecallPostprocess()
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (TraeAudioManager.this._am == null) {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, " am==null!!");
        }
      }
      do
      {
        return -1;
        if (TraeAudioManager.this._activeMode == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TRAE", 0, " not ACTIVE_RING!!");
      return -1;
      TraeAudioManager.this._activeMode = 0;
      if (TraeAudioManager.this._prevMode != -1) {
        TraeAudioManager.this.InternalSetMode(TraeAudioManager.this._prevMode);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("PARAM_SESSIONID", Long.valueOf(this._voiceCallSessionID));
      localHashMap.put("PARAM_OPERATION", this._voiceCallOperation);
      Intent localIntent = new Intent();
      TraeAudioManager.this.sendResBroadcast(localIntent, localHashMap, 6);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    
    boolean isNeedForceVolumeType()
    {
      if (Build.MANUFACTURER.equals("Xiaomi"))
      {
        if (Build.MODEL.equals("MI 5")) {}
        while ((Build.MODEL.equals("MI 5s")) || (Build.MODEL.equals("MI 5s Plus"))) {
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
      TraeAudioManager.this.sendResBroadcast(localIntent, localHashMap, 0);
    }
    
    int notifyServiceState(boolean paramBoolean)
    {
      if (TraeAudioManager.this._context == null) {
        return -1;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
      localIntent.putExtra("PARAM_OPERATION", "NOTIFY_SERVICE_STATE");
      localIntent.putExtra("NOTIFY_SERVICE_STATE_DATE", paramBoolean);
      if (TraeAudioManager.this._context != null) {
        TraeAudioManager.this._context.sendBroadcast(localIntent);
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
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, "  quit used:" + (SystemClock.elapsedRealtime() - l) + "ms");
        }
        this.mMsgHandler = null;
        AudioDeviceInterface.LogTraceExit();
        return;
        localObject = finally;
        throw localObject;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label58;
      }
    }
    
    @TargetApi(8)
    void requestAudioFocus(int paramInt)
    {
      if (Build.VERSION.SDK_INT <= 8) {}
      do
      {
        for (;;)
        {
          return;
          if (this.mAudioFocusChangeListener == null)
          {
            this.mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
            {
              @TargetApi(8)
              public void onAudioFocusChange(int paramAnonymousInt)
              {
                if (QLog.isColorLevel()) {
                  QLog.w("TRAE", 0, "focusChange:" + paramAnonymousInt + " _focusSteamType:" + TraeAudioManager.TraeAudioManagerLooper.this._focusSteamType + " currMode:" + TraeAudioManager.this._am.getMode() + " _activeMode:" + TraeAudioManager.this._activeMode);
                }
                if (paramAnonymousInt == -1) {}
                while ((paramAnonymousInt == -2) || (paramAnonymousInt == -3) || (paramAnonymousInt != 1)) {
                  return;
                }
              }
            };
            if (TraeAudioManager.this._am == null) {
              break;
            }
            try
            {
              int i = TraeAudioManager.this._am.requestAudioFocus(this.mAudioFocusChangeListener, paramInt, 1);
              if ((i != 1) && (QLog.isColorLevel())) {
                QLog.e("TRAE", 0, "request audio focus fail. " + i + " mode:" + TraeAudioManager.this._am.getMode());
              }
              this._focusSteamType = paramInt;
              if (QLog.isColorLevel())
              {
                QLog.w("TRAE", 0, "-------requestAudioFocus _focusSteamType:" + this._focusSteamType);
                return;
              }
            }
            catch (SecurityException localSecurityException) {}
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("TRAE", 0, "request audio focus exception. ", localSecurityException);
    }
    
    public void run()
    {
      AudioDeviceInterface.LogTraceEntry("");
      Looper.prepare();
      this.mMsgHandler = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          Object localObject;
          label98:
          do
          {
            do
            {
              try
              {
                HashMap localHashMap = (HashMap)paramAnonymousMessage.obj;
                if (QLog.isColorLevel())
                {
                  StringBuilder localStringBuilder = new StringBuilder().append("TraeAudioManagerLooper msg:").append(paramAnonymousMessage.what).append(" _enabled:");
                  if (TraeAudioManager.TraeAudioManagerLooper.this._enabled)
                  {
                    str = "Y";
                    QLog.w("TRAE", 0, str);
                  }
                }
                else
                {
                  if (paramAnonymousMessage.what != 32772) {
                    break label98;
                  }
                  TraeAudioManager.TraeAudioManagerLooper.this.startService(localHashMap);
                  return;
                }
              }
              catch (Exception localException)
              {
                do
                {
                  for (;;)
                  {
                    localObject = null;
                    continue;
                    String str = "N";
                  }
                  if (!TraeAudioManager.TraeAudioManagerLooper.this._enabled)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.w("TRAE", 0, "******* disabled ,skip msg******");
                    }
                    paramAnonymousMessage = new Intent();
                    TraeAudioManager.this.sendResBroadcast(paramAnonymousMessage, (HashMap)localObject, 1);
                    return;
                  }
                  switch (paramAnonymousMessage.what)
                  {
                  default: 
                    return;
                  case 32773: 
                    TraeAudioManager.TraeAudioManagerLooper.this.stopService();
                    return;
                  case 32774: 
                    TraeAudioManager.TraeAudioManagerLooper.this.InternalSessionGetDeviceList((HashMap)localObject);
                    return;
                  case 32777: 
                    TraeAudioManager.this.InternalSessionIsDeviceChangabled((HashMap)localObject);
                    return;
                  case 32778: 
                    TraeAudioManager.this.InternalSessionGetConnectedDevice((HashMap)localObject);
                    return;
                  case 32779: 
                    TraeAudioManager.this.InternalSessionGetConnectingDevice((HashMap)localObject);
                    return;
                  case 32780: 
                    TraeAudioManager.TraeAudioManagerLooper.this.InternalVoicecallPreprocess((HashMap)localObject);
                    return;
                  case 32781: 
                    TraeAudioManager.TraeAudioManagerLooper.this.InternalVoicecallPostprocess((HashMap)localObject);
                    return;
                  case 32788: 
                    paramAnonymousMessage = (Integer)((HashMap)localObject).get("PARAM_STREAMTYPE");
                    if (paramAnonymousMessage != null) {
                      break label347;
                    }
                  }
                } while (!QLog.isColorLevel());
                QLog.e("TRAE", 0, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
                return;
                TraeAudioManager.this._streamType = paramAnonymousMessage.intValue();
                TraeAudioManager.TraeAudioManagerLooper.this.InternalNotifyStreamTypeUpdate(paramAnonymousMessage.intValue());
                return;
                TraeAudioManager.TraeAudioManagerLooper.this.InternalStartRing((HashMap)localObject);
                return;
                TraeAudioManager.TraeAudioManagerLooper.this.InternalStopRing((HashMap)localObject);
                return;
                TraeAudioManager.TraeAudioManagerLooper.this.abandonAudioFocus();
                return;
                TraeAudioManager.TraeAudioManagerLooper.this.requestAudioFocus(TraeAudioManager.this._streamType);
                return;
                TraeAudioManager.TraeAudioManagerLooper.this.InternalGetStreamType((HashMap)localObject);
                return;
                TraeAudioManager.this.InternalSessionConnectDevice((HashMap)localObject);
                return;
                TraeAudioManager.this.InternalSessionEarAction((HashMap)localObject);
                return;
                paramAnonymousMessage = TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice();
                localObject = TraeAudioManager.this._deviceConfigManager.getConnectedDevice();
                if (QLog.isColorLevel()) {
                  QLog.w("TRAE", 0, "MESSAGE_AUTO_DEVICELIST_UPDATE  connectedDev:" + (String)localObject + " highestDev" + paramAnonymousMessage);
                }
                if (TraeAudioManager.IsUpdateSceneFlag)
                {
                  if ((TraeAudioManager.IsMusicScene) && (!TraeAudioManager.this.IsBluetoothA2dpExisted))
                  {
                    TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice("DEVICE_BLUETOOTHHEADSET"), null, true);
                    return;
                  }
                  TraeAudioManager.this.InternalConnectDevice(paramAnonymousMessage, null, true);
                  return;
                }
              }
              if (!paramAnonymousMessage.equals(localObject))
              {
                TraeAudioManager.this.InternalConnectDevice(paramAnonymousMessage, null, false);
                return;
              }
              TraeAudioManager.this.InternalNotifyDeviceListUpdate();
              return;
              paramAnonymousMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
            } while (TraeAudioManager.this.InternalConnectDevice(paramAnonymousMessage, null, false) == 0);
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 0, " plugin dev:" + paramAnonymousMessage + " sessionConnectedDev:" + TraeAudioManager.this.sessionConnectedDev + " connected fail,auto switch!");
            }
            TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice(), null, false);
            return;
          } while (TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this.sessionConnectedDev, null, false) == 0);
          label347:
          paramAnonymousMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, " plugout dev:" + paramAnonymousMessage + " sessionConnectedDev:" + TraeAudioManager.this.sessionConnectedDev + " connected fail,auto switch!");
          }
          TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice(), null, false);
        }
      };
      _init();
      synchronized (this._started)
      {
        this._started[0] = true;
        this._started.notifyAll();
        Looper.loop();
        _uninit();
      }
      synchronized (this._started)
      {
        this._started[0] = false;
        this._started.notifyAll();
        AudioDeviceInterface.LogTraceExit();
        return;
        localObject1 = finally;
        throw localObject1;
      }
    }
    
    public int sendMessage(int paramInt, HashMap<String, Object> paramHashMap)
    {
      if (this.mMsgHandler == null)
      {
        StringBuilder localStringBuilder = new StringBuilder().append(" fail mMsgHandler==null _enabled:");
        if (this._enabled) {}
        for (paramHashMap = "Y";; paramHashMap = "N")
        {
          AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + TraeAudioManager.this._activeMode + " msg:" + paramInt);
          return -1;
        }
      }
      paramHashMap = Message.obtain(this.mMsgHandler, paramInt, paramHashMap);
      if (this.mMsgHandler.sendMessage(paramHashMap)) {}
      for (paramInt = 0;; paramInt = -1) {
        return paramInt;
      }
    }
    
    void startService(HashMap<String, Object> paramHashMap)
    {
      String str = (String)paramHashMap.get("EXTRA_DATA_DEVICECONFIG");
      Log.w("TRAE", "startService cfg:" + str);
      StringBuilder localStringBuilder = new StringBuilder().append(" _enabled:");
      if (this._enabled)
      {
        paramHashMap = "Y";
        AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + TraeAudioManager.this._activeMode + " cfg:" + str);
        if (TraeAudioManager.this._context != null) {
          break label116;
        }
      }
      label116:
      do
      {
        return;
        paramHashMap = "N";
        break;
        QLog.w("TRAE", 0, "   startService:" + str);
      } while (((this._enabled) && (this._lastCfg.equals(str))) || (TraeAudioManager.this._activeMode != 0));
      if (this._enabled) {
        stopService();
      }
      _prev_startService();
      paramHashMap = (AudioManager)TraeAudioManager.this._context.getSystemService("audio");
      TraeAudioManager.this._deviceConfigManager.clearConfig();
      TraeAudioManager.this._deviceConfigManager.init(str);
      this._lastCfg = str;
      if (TraeAudioManager.this._am != null) {
        this._preServiceMode = TraeAudioManager.this._am.getMode();
      }
      this._enabled = true;
      if (this._ringPlayer == null) {
        this._ringPlayer = new TraeMediaPlayer(TraeAudioManager.this._context, new TraeMediaPlayer.OnCompletionListener()
        {
          public void onCompletion()
          {
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 0, "_ringPlayer onCompletion _activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + TraeAudioManager.TraeAudioManagerLooper.this._preRingMode);
            }
            HashMap localHashMap = new HashMap();
            localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(true));
            TraeAudioManager.TraeAudioManagerLooper.this.sendMessage(32783, localHashMap);
            TraeAudioManager.TraeAudioManagerLooper.this.notifyRingCompletion();
          }
        });
      }
      notifyServiceState(this._enabled);
      TraeAudioManager.this.updateDeviceStatus();
      AudioDeviceInterface.LogTraceExit();
    }
    
    void stopService()
    {
      StringBuilder localStringBuilder = new StringBuilder().append(" _enabled:");
      if (this._enabled) {}
      for (String str = "Y";; str = "N")
      {
        AudioDeviceInterface.LogTraceEntry(str + " activeMode:" + TraeAudioManager.this._activeMode);
        if (this._enabled) {
          break;
        }
        return;
      }
      if (TraeAudioManager.this._activeMode == 1) {
        interruptVoicecallPostprocess();
      }
      for (;;)
      {
        if (TraeAudioManager.this._switchThread != null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "_switchThread:" + TraeAudioManager.this._switchThread.getDeviceName());
          }
          TraeAudioManager.this._switchThread.quit();
          TraeAudioManager.this._switchThread = null;
        }
        if (this._ringPlayer != null) {
          this._ringPlayer.stopRing();
        }
        this._ringPlayer = null;
        this._enabled = false;
        notifyServiceState(this._enabled);
        if ((TraeAudioManager.this._am != null) && (TraeAudioManager.this._context != null)) {}
        try
        {
          TraeAudioManager.this.InternalSetMode(0);
          if (isNeedForceVolumeType())
          {
            QLog.w("TRAE", 0, "NeedForceVolumeType: AudioManager.STREAM_MUSIC");
            TraeAudioManager.forceVolumeControlStream(TraeAudioManager.this._am, 3);
          }
          label239:
          _post_stopService();
          AudioDeviceInterface.LogTraceExit();
          return;
          if (TraeAudioManager.this._activeMode != 2) {
            continue;
          }
          interruptRing();
        }
        catch (Exception localException)
        {
          break label239;
        }
      }
    }
  }
  
  class bluetoothHeadsetSwitchThread
    extends TraeAudioManager.switchThread
  {
    bluetoothHeadsetSwitchThread()
    {
      super();
    }
    
    @TargetApi(8)
    public void _quit()
    {
      if (TraeAudioManager.this._am == null) {
        return;
      }
      _stopBluetoothSco();
    }
    
    public void _run()
    {
      if ((TraeAudioManager.IsMusicScene) || (!TraeAudioManager.IsUpdateSceneFlag))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "connect bluetoothHeadset: do nothing, IsMusicScene:" + TraeAudioManager.IsMusicScene + " ,IsUpdateSceneFlag:" + TraeAudioManager.IsUpdateSceneFlag);
        }
        updateStatus();
      }
      for (;;)
      {
        return;
        try
        {
          Thread.sleep(1000L);
          label67:
          _startBluetoothSco();
          int i = 0;
          for (;;)
          {
            int j;
            StringBuilder localStringBuilder;
            if (this._running == true)
            {
              j = i + 1;
              if (i < 10) {
                if (QLog.isColorLevel())
                {
                  localStringBuilder = new StringBuilder().append("bluetoothHeadsetSwitchThread i:").append(j).append(" sco:");
                  if (!TraeAudioManager.this._am.isBluetoothScoOn()) {
                    break label243;
                  }
                }
              }
            }
            label243:
            for (String str = "Y";; str = "N")
            {
              QLog.w("TRAE", 0, str + " :" + TraeAudioManager.this._deviceConfigManager.getBluetoothName());
              if (!TraeAudioManager.this._am.isBluetoothScoOn()) {
                break label249;
              }
              updateStatus();
              if (TraeAudioManager.this._am.isBluetoothScoOn()) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.e("TRAE", 0, "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
              }
              TraeAudioManager.this._deviceConfigManager.setVisible(getDeviceName(), false);
              processDeviceConnectRes(10);
              TraeAudioManager.this.checkAutoDeviceListUpdate();
              return;
            }
            try
            {
              label249:
              Thread.sleep(1000L);
              i = j;
            }
            catch (InterruptedException localInterruptedException1)
            {
              i = j;
            }
          }
        }
        catch (InterruptedException localInterruptedException2)
        {
          break label67;
        }
      }
    }
    
    @TargetApi(8)
    void _startBluetoothSco()
    {
      TraeAudioManager.this._am.setBluetoothScoOn(true);
      if (Build.VERSION.SDK_INT > 8) {
        TraeAudioManager.this._am.startBluetoothSco();
      }
    }
    
    @TargetApi(8)
    void _stopBluetoothSco()
    {
      if (Build.VERSION.SDK_INT > 8) {
        TraeAudioManager.this._am.stopBluetoothSco();
      }
      TraeAudioManager.this._am.setBluetoothScoOn(false);
    }
    
    public String getDeviceName()
    {
      return "DEVICE_BLUETOOTHHEADSET";
    }
  }
  
  class earphoneSwitchThread
    extends TraeAudioManager.switchThread
  {
    earphoneSwitchThread()
    {
      super();
    }
    
    public void _quit() {}
    
    public void _run()
    {
      if (TraeAudioManager.IsUpdateSceneFlag) {
        TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, false);
      }
      updateStatus();
      if (!TraeAudioManager.IsUpdateSceneFlag) {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "connect earphone: do nothing");
        }
      }
      for (;;)
      {
        return;
        while (this._running == true)
        {
          if (TraeAudioManager.this._am.isSpeakerphoneOn()) {
            TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, false);
          }
          long l;
          if (i < 5) {
            l = 1000L;
          }
          try
          {
            for (;;)
            {
              Thread.sleep(l);
              label97:
              i += 1;
              break;
              l = 4000L;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            break label97;
          }
          int i = 0;
        }
      }
    }
    
    public String getDeviceName()
    {
      return "DEVICE_EARPHONE";
    }
  }
  
  class headsetSwitchThread
    extends TraeAudioManager.switchThread
  {
    headsetSwitchThread()
    {
      super();
    }
    
    public void _quit() {}
    
    public void _run()
    {
      if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag))
      {
        TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, false);
        TraeAudioManager.this._am.setWiredHeadsetOn(true);
      }
      updateStatus();
      if ((TraeAudioManager.IsMusicScene) || (!TraeAudioManager.IsUpdateSceneFlag)) {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "connect headset: do nothing");
        }
      }
      for (;;)
      {
        return;
        while (this._running == true)
        {
          if (TraeAudioManager.this._am.isSpeakerphoneOn()) {
            TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, false);
          }
          long l;
          if (i < 5) {
            l = 1000L;
          }
          try
          {
            for (;;)
            {
              Thread.sleep(l);
              label120:
              i += 1;
              break;
              l = 4000L;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            break label120;
          }
          int i = 0;
        }
      }
    }
    
    public String getDeviceName()
    {
      return "DEVICE_WIREDHEADSET";
    }
  }
  
  class speakerSwitchThread
    extends TraeAudioManager.switchThread
  {
    speakerSwitchThread()
    {
      super();
    }
    
    public void _quit() {}
    
    public void _run()
    {
      int j = 0;
      if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag)) {
        TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, true);
      }
      updateStatus();
      if ((TraeAudioManager.IsMusicScene) || (!TraeAudioManager.IsUpdateSceneFlag))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "connect speakerPhone: do nothing");
        }
        return;
      }
      int i = j;
      if (QLog.isColorLevel())
      {
        QLog.w("TRAE", 0, " _run:" + getDeviceName() + " _running:" + this._running);
        i = j;
      }
      while (this._running == true)
      {
        if (TraeAudioManager.this._am.isSpeakerphoneOn() != true) {
          TraeAudioManager.this.InternalSetSpeaker(TraeAudioManager.this._context, true);
        }
        long l;
        if (i < 5) {
          l = 1000L;
        }
        try
        {
          for (;;)
          {
            Thread.sleep(l);
            label162:
            i += 1;
            break;
            l = 4000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          break label162;
        }
      }
    }
    
    public String getDeviceName()
    {
      return "DEVICE_SPEAKERPHONE";
    }
  }
  
  abstract class switchThread
    extends Thread
  {
    boolean[] _exited = { false };
    HashMap<String, Object> _params = null;
    boolean _running = true;
    long _usingtime = 0L;
    
    switchThread()
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, " ++switchThread:" + getDeviceName());
      }
    }
    
    public abstract void _quit();
    
    public abstract void _run();
    
    public abstract String getDeviceName();
    
    void processDeviceConnectRes(int paramInt)
    {
      TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
      AudioDeviceInterface.LogTraceEntry(getDeviceName() + " err:" + paramInt);
      if (this._params == null) {
        TraeAudioManager.this.InternalNotifyDeviceListUpdate();
      }
      do
      {
        return;
        TraeAudioManager.this.sessionConnectedDev = TraeAudioManager.this._deviceConfigManager.getConnectedDevice();
        localObject = (Long)this._params.get("PARAM_SESSIONID");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, " sessonID:" + localObject);
        }
        if ((localObject != null) && (((Long)localObject).longValue() != -9223372036854775808L)) {
          break;
        }
        TraeAudioManager.this.InternalNotifyDeviceListUpdate();
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 0, "processDeviceConnectRes sid null,don't send res");
      return;
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)this._params.get("PARAM_DEVICE"));
      if (TraeAudioManager.this.sendResBroadcast((Intent)localObject, this._params, paramInt) == 0) {
        TraeAudioManager.this.InternalNotifyDeviceListUpdate();
      }
      AudioDeviceInterface.LogTraceExit();
    }
    
    public void quit()
    {
      AudioDeviceInterface.LogTraceEntry(getDeviceName());
      this._running = false;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, " quit:" + getDeviceName() + " _running:" + this._running);
      }
      interrupt();
      _quit();
      synchronized (this._exited)
      {
        int i = this._exited[0];
        if (i != 0) {}
      }
      try
      {
        this._exited.wait(10000L);
        label94:
        AudioDeviceInterface.LogTraceExit();
        return;
        localObject = finally;
        throw localObject;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label94;
      }
    }
    
    public void run()
    {
      AudioDeviceInterface.LogTraceEntry(getDeviceName());
      TraeAudioManager.this._deviceConfigManager.setConnecting(getDeviceName());
      TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
      _run();
      synchronized (this._exited)
      {
        this._exited[0] = true;
        this._exited.notifyAll();
        AudioDeviceInterface.LogTraceExit();
        return;
      }
    }
    
    public void setDeviceConnectParam(HashMap<String, Object> paramHashMap)
    {
      this._params = paramHashMap;
    }
    
    void updateStatus()
    {
      TraeAudioManager.this._deviceConfigManager.setConnected(getDeviceName());
      processDeviceConnectRes(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager
 * JD-Core Version:    0.7.0.1
 */