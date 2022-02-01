package com.tencent.TMG.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import com.tencent.TMG.utils.QLog;

public class TraeAudioSession
  extends BroadcastReceiver
{
  static int s_nSessionIdAllocator = 0;
  final String TRAE_ACTION_PHONE_STATE = "android.intent.action.PHONE_STATE";
  private boolean _canSwtich2Earphone = true;
  private String _connectedDev = "DEVICE_NONE";
  private TraeAudioSession.ITraeAudioCallback mCallback;
  private Context mContext;
  private boolean mIsHostside = false;
  private long mSessionId = -9223372036854775808L;
  
  public TraeAudioSession(Context paramContext, TraeAudioSession.ITraeAudioCallback paramITraeAudioCallback)
  {
    boolean bool;
    Object localObject;
    if (Process.myPid() == TraeAudioManager._gHostProcessId)
    {
      bool = true;
      this.mIsHostside = bool;
      this.mSessionId = requestSessionId();
      this.mCallback = paramITraeAudioCallback;
      this.mContext = paramContext;
      if ((paramContext == null) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("AudioSession | Invalid parameters: ctx = ");
        if (paramContext != null) {
          break label210;
        }
        localObject = "null";
        label98:
        localObject = localStringBuilder.append((String)localObject).append("; cb = ");
        if (paramITraeAudioCallback != null) {
          break label217;
        }
      }
    }
    label210:
    label217:
    for (paramITraeAudioCallback = "null";; paramITraeAudioCallback = "{object}")
    {
      QLog.w("TRAE", 0, paramITraeAudioCallback);
      paramITraeAudioCallback = new IntentFilter();
      paramITraeAudioCallback.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
      paramITraeAudioCallback.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
      if (paramContext != null) {}
      try
      {
        paramContext = paramContext.registerReceiver(this, paramITraeAudioCallback);
        if (paramContext != null) {}
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 0, "registerReceiver Exception: " + paramContext.getMessage());
          }
        }
      }
      registerAudioSession(this, true);
      Log.w("TRAE", "TraeAudioSession create, mSessionId: " + this.mSessionId);
      return;
      bool = false;
      break;
      localObject = "{object}";
      break label98;
    }
  }
  
  public static void ExConnectDevice(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", -9223372036854775808L);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
    localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
    paramContext.sendBroadcast(localIntent);
  }
  
  private int registerAudioSession(TraeAudioSession paramTraeAudioSession, boolean paramBoolean)
  {
    if (this.mContext == null) {
      return -1;
    }
    return TraeAudioManager.registerAudioSession(paramTraeAudioSession, paramBoolean, this.mSessionId, this.mContext);
  }
  
  public static long requestSessionId()
  {
    long l = Process.myPid();
    int i = s_nSessionIdAllocator + 1;
    s_nSessionIdAllocator = i;
    return (l << 32) + i;
  }
  
  public int EarAction(int paramInt)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.earAction("OPERATION_EARACTION", this.mSessionId, this.mIsHostside, paramInt);
    }
    if ((this.mContext == null) || ((paramInt != 0) && (paramInt != 1))) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_EARACTION");
    localIntent.putExtra("EXTRA_EARACTION", paramInt);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int connectDevice(String paramString)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.connectDevice("OPERATION_CONNECTDEVICE", this.mSessionId, this.mIsHostside, paramString);
    }
    if ((this.mContext == null) || (paramString == null) || (paramString.length() <= 0)) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
    localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int connectHighestPriorityDevice()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.connectHighestPriorityDevice("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int getConnectedDevice()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.getConnectedDevice("OPERATION_GETCONNECTEDDEVICE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTEDDEVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int getConnectingDevice()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.getConnectingDevice("OPERATION_GETCONNECTINGDEVICE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTINGDEVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int getDeviceList()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.getDeviceList("OPERATION_GETDEVICELIST", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETDEVICELIST");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int getStreamType()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.getStreamType("OPERATION_GETSTREAMTYPE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETSTREAMTYPE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int isDeviceChangabled()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.isDeviceChangabled("OPERATION_ISDEVICECHANGABLED", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_ISDEVICECHANGABLED");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    if (paramIntent == null) {}
    try
    {
      if (!QLog.isColorLevel()) {
        break label1705;
      }
      QLog.w("TRAE", 0, "[ERROR] intent = null!!");
      return;
    }
    catch (Exception paramContext)
    {
      if (!QLog.isColorLevel()) {
        break label1705;
      }
    }
    long l = paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L);
    paramContext = paramIntent.getStringExtra("PARAM_OPERATION");
    int j = paramIntent.getIntExtra("PARAM_RES_ERRCODE", 0);
    Object localObject;
    label225:
    String str1;
    String str2;
    String str3;
    int i;
    if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY".equals(paramIntent.getAction()))
    {
      if ("NOTIFY_SERVICE_STATE".equals(paramContext))
      {
        bool1 = paramIntent.getBooleanExtra("NOTIFY_SERVICE_STATE_DATE", false);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("AudioSession|[onServiceStateUpdate]");
          if (!bool1) {
            break label225;
          }
        }
        for (paramContext = "on";; paramContext = "off")
        {
          QLog.w("TRAE", 0, paramContext);
          if (this.mCallback == null) {
            break;
          }
          this.mCallback.onServiceStateUpdate(bool1);
          return;
          QLog.e("TRAE", 0, "AudioSession| nSessinId = " + this.mSessionId + " onReceive::intent:" + paramIntent.toString() + " intent.getAction():" + paramIntent.getAction() + " Exception:" + paramContext.getMessage());
          return;
        }
      }
      if ("NOTIFY_DEVICELISTUPDATE".equals(paramContext))
      {
        localObject = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
        str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
        str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
        str3 = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
        paramContext = "\n";
        i = 0;
        if (i < localObject.length)
        {
          paramContext = paramContext + "AudioSession|    " + i + " " + localObject[i] + "\n";
          if (localObject[i].equals("DEVICE_WIREDHEADSET")) {
            break label1706;
          }
          if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
            break label1709;
          }
          break label1706;
        }
        paramContext = paramContext + "\n";
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "AudioSession|[onDeviceListUpdate]  connected:" + str1 + " prevConnected:" + str2 + " bt:" + str3 + " Num:" + localObject.length + paramContext);
        }
        this._canSwtich2Earphone = bool1;
        this._connectedDev = str1;
        if (this.mCallback != null) {
          this.mCallback.onDeviceListUpdate((String[])localObject, str1, str2, str3);
        }
      }
      else if ("NOTIFY_DEVICECHANGABLE_UPDATE".equals(paramContext))
      {
        bool1 = paramIntent.getBooleanExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", true);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "AudioSession|[onDeviceChangabledUpdate]" + bool1);
        }
        if (this.mCallback != null) {
          this.mCallback.onDeviceChangabledUpdate(bool1);
        }
      }
      else if ("NOTIFY_STREAMTYPE_UPDATE".equals(paramContext))
      {
        i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "AudioSession|[onStreamTypeUpdate] err:" + j + " st:" + i);
        }
        if (this.mCallback != null) {
          this.mCallback.onStreamTypeUpdate(i);
        }
      }
      else if ("NOTIFY_ROUTESWITCHSTART".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_FROM");
        localObject = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_TO");
        if ((this.mCallback != null) && (paramContext != null) && (localObject != null)) {
          this.mCallback.onAudioRouteSwitchStart(paramContext, (String)localObject);
        }
      }
      else if ("NOTIFY_ROUTESWITCHEND".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHEND_DEV");
        l = paramIntent.getLongExtra("EXTRA_DATA_ROUTESWITCHEND_TIME", -1L);
        if ((this.mCallback != null) && (paramContext != null) && (l != -1L)) {
          this.mCallback.onAudioRouteSwitchEnd(paramContext, l);
        }
      }
    }
    else if (("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES".equals(paramIntent.getAction())) && (this.mSessionId == l))
    {
      if ("OPERATION_GETDEVICELIST".equals(paramContext))
      {
        localObject = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
        str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
        str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
        str3 = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
        paramContext = "\n";
        i = 0;
        bool1 = bool2;
        label841:
        if (i < localObject.length)
        {
          paramContext = paramContext + "AudioSession|    " + i + " " + localObject[i] + "\n";
          if (localObject[i].equals("DEVICE_WIREDHEADSET")) {
            break label1716;
          }
          if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
            break label1719;
          }
          break label1716;
        }
        paramContext = paramContext + "\n";
        this._canSwtich2Earphone = bool1;
        this._connectedDev = str1;
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "AudioSession|[onGetDeviceListRes] err:" + j + " connected:" + str1 + " prevConnected:" + str2 + " bt:" + str3 + " Num:" + localObject.length + paramContext);
        }
        if (this.mCallback != null) {
          this.mCallback.onGetDeviceListRes(j, (String[])localObject, str1, str2, str3);
        }
      }
      else if ("OPERATION_CONNECTDEVICE".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("CONNECTDEVICE_RESULT_DEVICENAME");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "AudioSession|[onConnectDeviceRes] err:" + j + " dev:" + paramContext);
        }
        if (this.mCallback != null)
        {
          localObject = this.mCallback;
          if (j != 0) {
            break label1726;
          }
          bool1 = bool3;
          label1145:
          ((TraeAudioSession.ITraeAudioCallback)localObject).onConnectDeviceRes(j, paramContext, bool1);
        }
      }
      else if ("OPERATION_EARACTION".equals(paramContext))
      {
        i = paramIntent.getIntExtra("EXTRA_EARACTION", -1);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "AudioSession|[onConnectDeviceRes] err:" + j + " earAction:" + i);
        }
        if (this.mCallback == null) {}
      }
      else if ("OPERATION_ISDEVICECHANGABLED".equals(paramContext))
      {
        bool1 = paramIntent.getBooleanExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", false);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("AudioSession|[onIsDeviceChangabledRes] err:").append(j).append(" Changabled:");
          if (!bool1) {
            break label1732;
          }
        }
      }
    }
    label1705:
    label1706:
    label1709:
    label1716:
    label1719:
    label1726:
    label1732:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TRAE", 0, paramContext);
      if (this.mCallback != null)
      {
        this.mCallback.onIsDeviceChangabledRes(j, bool1);
        return;
        if ("OPERATION_GETCONNECTEDDEVICE".equals(paramContext))
        {
          paramContext = paramIntent.getStringExtra("GETCONNECTEDDEVICE_REULT_LIST");
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "AudioSession|[onGetConnectedDeviceRes] err:" + j + " dev:" + paramContext);
          }
          if (this.mCallback != null) {
            this.mCallback.onGetConnectedDeviceRes(j, paramContext);
          }
        }
        else if ("OPERATION_GETCONNECTINGDEVICE".equals(paramContext))
        {
          paramContext = paramIntent.getStringExtra("GETCONNECTINGDEVICE_REULT_LIST");
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "AudioSession|[onGetConnectingDeviceRes] err:" + j + " dev:" + paramContext);
          }
          if (this.mCallback != null) {
            this.mCallback.onGetConnectingDeviceRes(j, paramContext);
          }
        }
        else if ("OPERATION_GETSTREAMTYPE".equals(paramContext))
        {
          i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "AudioSession|[onGetStreamTypeRes] err:" + j + " st:" + i);
          }
          if (this.mCallback != null) {
            this.mCallback.onGetStreamTypeRes(j, i);
          }
        }
        else if ("NOTIFY_RING_COMPLETION".equals(paramContext))
        {
          paramContext = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "AudioSession|[onRingCompletion] err:" + j + " userData:" + paramContext);
          }
          if (this.mCallback != null) {
            this.mCallback.onRingCompletion(j, paramContext);
          }
        }
        else if ("OPERATION_VOICECALL_PREPROCESS".equals(paramContext))
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "AudioSession|[onVoicecallPreprocess] err:" + j);
          }
          if (this.mCallback != null) {
            this.mCallback.onVoicecallPreprocessRes(j);
          }
        }
      }
      return;
      bool1 = false;
      i += 1;
      break;
      bool1 = false;
      i += 1;
      break label841;
      bool1 = false;
      break label1145;
    }
  }
  
  public void onReceiveCallback(Intent paramIntent)
  {
    if (paramIntent == null) {}
    try
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.w("TRAE", 0, "[ERROR] intent = null!!");
      return;
    }
    catch (Exception localException)
    {
      long l;
      String str;
      int i;
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("TRAE", 0, "AudioSession| nSessinId = " + this.mSessionId + " onReceive::intent:" + paramIntent.toString() + " intent.getAction():" + paramIntent.getAction() + " Exception:" + localException.getMessage());
    }
    l = paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L);
    str = paramIntent.getStringExtra("PARAM_OPERATION");
    i = paramIntent.getIntExtra("PARAM_RES_ERRCODE", 0);
    if (("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES".equals(paramIntent.getAction())) && (this.mSessionId == l) && ("OPERATION_VOICECALL_PREPROCESS".equals(str)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "AudioSession|[onReceiveCallback onVoicecallPreprocess] err:" + i);
      }
      if (this.mCallback != null)
      {
        this.mCallback.onVoicecallPreprocessRes(i);
        return;
      }
    }
  }
  
  public int recoverAudioFocus()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.recoverAudioFocus("OPERATION_RECOVER_AUDIO_FOCUS", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_RECOVER_AUDIO_FOCUS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void release()
  {
    if (this.mContext != null) {}
    try
    {
      this.mContext.unregisterReceiver(this);
      label15:
      registerAudioSession(this, false);
      this.mContext = null;
      this.mCallback = null;
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }
  
  public int requestReleaseAudioFocus()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.requestReleaseAudioFocus("OPERATION_REQUEST_RELEASE_AUDIO_FOCUS", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void setCallback(TraeAudioSession.ITraeAudioCallback paramITraeAudioCallback)
  {
    this.mCallback = paramITraeAudioCallback;
  }
  
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString, boolean paramBoolean)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.startRing("OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString, paramBoolean, 1, "normal-ring", false);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean);
    localIntent.putExtra("PARAM_RING_MODE", false);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", "normal-ring");
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean, int paramInt3, String paramString2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.startRing("OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString1, paramBoolean, paramInt3, paramString2, false);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", false);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean1, int paramInt3, String paramString2, boolean paramBoolean2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.startRing("OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString1, paramBoolean1, paramInt3, paramString2, paramBoolean2);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean1);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", paramBoolean2);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int startService(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 0) {}
    }
    else
    {
      str = "internal_disable_dev_switch";
    }
    if (this.mIsHostside) {
      return TraeAudioManager.startService("OPERATION_STARTSERVICE", this.mSessionId, this.mIsHostside, str);
    }
    if (this.mContext == null) {
      return -1;
    }
    paramString = new Intent();
    paramString.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    paramString.putExtra("PARAM_SESSIONID", this.mSessionId);
    paramString.putExtra("PARAM_OPERATION", "OPERATION_STARTSERVICE");
    paramString.putExtra("EXTRA_DATA_DEVICECONFIG", str);
    this.mContext.sendBroadcast(paramString);
    return 0;
  }
  
  public int stopRing()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.stopRing("OPERATION_STOPRING", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPRING");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int stopService()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.stopService("OPERATION_STOPSERVICE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPSERVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int voiceCallAudioParamChanged(int paramInt1, int paramInt2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.voiceCallAudioParamChanged("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST", this.mSessionId, this.mIsHostside, paramInt1, paramInt2);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_AUDIOPARAM_CHANGED");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int voiceCallPostprocess()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.voicecallPostprocess("OPERATION_VOICECALL_POSTROCESS", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_POSTROCESS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int voiceCallPreprocess(int paramInt1, int paramInt2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.voicecallPreprocess("OPERATION_VOICECALL_PREPROCESS", this.mSessionId, this.mIsHostside, paramInt1, paramInt2);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_PREPROCESS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioSession
 * JD-Core Version:    0.7.0.1
 */