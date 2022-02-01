package com.tencent.liteav.trtc.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.g.a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class TRTCRoomInfo
{
  public static final int NETWORK_STATUS_OFFLINE = 1;
  public static final int NETWORK_STATUS_ONLINE = 3;
  public static final int NETWORK_STATUS_RECONNECTING = 2;
  public static final int STATE_AUDIO = 8;
  public static final int STATE_BIG_VIDEO = 1;
  public static final int STATE_MUTE_AUDIO = 64;
  public static final int STATE_MUTE_MAIN_VIDEO = 16;
  public static final int STATE_MUTE_SUB_VIDEO = 32;
  public static final int STATE_SMALL_VIDEO = 2;
  public static final int STATE_SUB_VIDEO = 4;
  private static final String TAG = "TRTCRoomInfo";
  private static final String TOKEN = "TRTC.0x0.Token";
  private static final String TRTC_INFO = "TRTC.Info";
  public g.a bigEncSize = new g.a();
  public TRTCCloud.TRTCViewMargin debugMargin = new TRTCCloud.TRTCViewMargin(0.0F, 0.0F, 0.1F, 0.0F);
  public JSONArray decProperties = null;
  public boolean enableCustomPreprocessor = false;
  public boolean enableRestartDecoder = false;
  public long enterTime;
  private int exitRoomCode = 0;
  private boolean hasExitedRoom = false;
  public int localBufferType;
  public TRTCCloudListener.TRTCVideoRenderListener localListener;
  public int localPixelFormat;
  public int localRenderRotation = 0;
  public TXCloudVideoView localView = null;
  private boolean micHasStartd = false;
  public boolean muteLocalAudio = false;
  public boolean muteLocalVideo = false;
  public TRTCRoomInfo.TRTCRemoteMuteState muteRemoteAudio = TRTCRoomInfo.TRTCRemoteMuteState.UNSET;
  public TRTCRoomInfo.TRTCRemoteMuteState muteRemoteVideo = TRTCRoomInfo.TRTCRemoteMuteState.UNSET;
  public int networkStatus = 1;
  public String privateMapKey;
  private HashMap<Long, Integer> recvFirstIFrameCntList = new HashMap();
  public long roomId;
  public int sdkAppId;
  public g.a smallEncSize = new g.a();
  public String strRoomId;
  public String tinyId;
  public byte[] token = null;
  public String userId = "";
  private HashMap<String, TRTCRoomInfo.UserInfo> userList = new HashMap();
  public String userSig;
  
  private String byteArrayToHexStr(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    char[] arrayOfChar1 = "0123456789ABCDEF".toCharArray();
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      arrayOfChar2[k] = arrayOfChar1[(j >>> 4)];
      arrayOfChar2[(k + 1)] = arrayOfChar1[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  public static boolean hasAudio(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  public static boolean hasMainVideo(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean hasSmallVideo(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean hasSubVideo(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  private byte[] hexStrToByteArray(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int j = paramString.length();
    int i = 0;
    if (j == 0) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    while (i < arrayOfByte.length)
    {
      j = i * 2;
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(j, j + 2), 16));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static boolean isMuteAudio(int paramInt)
  {
    return (paramInt & 0x40) != 0;
  }
  
  public static boolean isMuteMainVideo(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  public static boolean isMuteSubVideo(int paramInt)
  {
    return (paramInt & 0x20) != 0;
  }
  
  public void addUserInfo(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    try
    {
      this.userList.put(paramString, paramUserInfo);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void clear()
  {
    try
    {
      this.roomId = 0L;
      this.userId = "";
      this.enterTime = 0L;
      this.tinyId = "";
      this.muteLocalVideo = false;
      this.muteLocalAudio = false;
      this.muteRemoteVideo = TRTCRoomInfo.TRTCRemoteMuteState.UNSET;
      this.muteRemoteAudio = TRTCRoomInfo.TRTCRemoteMuteState.UNSET;
      this.userList.clear();
      this.recvFirstIFrameCntList.clear();
      this.networkStatus = 1;
      this.decProperties = null;
      this.enableRestartDecoder = false;
      this.enableCustomPreprocessor = false;
      this.localListener = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clearUserList()
  {
    try
    {
      this.userList.clear();
      this.recvFirstIFrameCntList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void forEachUser(TRTCRoomInfo.UserAction paramUserAction)
  {
    Object localObject = new HashMap(this.userList.size());
    try
    {
      ((HashMap)localObject).putAll(this.userList);
      localObject = ((HashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if ((paramUserAction != null) && (localEntry.getValue() != null)) {
          paramUserAction.accept((String)localEntry.getKey(), (TRTCRoomInfo.UserInfo)localEntry.getValue());
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramUserAction;
    }
  }
  
  public long getRoomElapsed()
  {
    return System.currentTimeMillis() - this.enterTime;
  }
  
  public int getRoomExitCode()
  {
    try
    {
      int i = this.exitRoomCode;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getRoomId()
  {
    return this.roomId;
  }
  
  public String getStrRoomId()
  {
    if (TextUtils.isEmpty(this.strRoomId)) {
      return String.valueOf(this.roomId);
    }
    return this.strRoomId;
  }
  
  public String getTinyId()
  {
    return this.tinyId;
  }
  
  public byte[] getToken(Context paramContext)
  {
    try
    {
      if (this.token == null) {
        this.token = hexStrToByteArray(paramContext.getSharedPreferences("TRTC.Info", 0).getString("TRTC.0x0.Token", ""));
      }
    }
    catch (Exception paramContext)
    {
      TXCLog.e("TRTCRoomInfo", "get token failed.", paramContext);
    }
    return this.token;
  }
  
  public TRTCRoomInfo.UserInfo getUser(String paramString)
  {
    try
    {
      paramString = (TRTCRoomInfo.UserInfo)this.userList.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public String getUserIdByTinyId(long paramLong)
  {
    try
    {
      Object localObject1 = this.userList.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        TRTCRoomInfo.UserInfo localUserInfo = (TRTCRoomInfo.UserInfo)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if ((localUserInfo != null) && (localUserInfo.tinyID == paramLong))
        {
          localObject1 = localUserInfo.userID;
          return localObject1;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean hasRecvFirstIFrame(long paramLong)
  {
    try
    {
      Integer localInteger = (Integer)this.recvFirstIFrameCntList.get(Long.valueOf(paramLong));
      if (localInteger != null)
      {
        int i = localInteger.intValue();
        if (i > 0)
        {
          bool = true;
          break label42;
        }
      }
      boolean bool = false;
      label42:
      return bool;
    }
    finally {}
  }
  
  public void init(long paramLong, String paramString)
  {
    this.roomId = paramLong;
    this.userId = paramString;
  }
  
  public boolean isMicStard()
  {
    try
    {
      boolean bool = this.micHasStartd;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isRoomExit()
  {
    try
    {
      boolean bool = this.hasExitedRoom;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void micStart(boolean paramBoolean)
  {
    this.micHasStartd = paramBoolean;
  }
  
  public int recvFirstIFrame(long paramLong)
  {
    try
    {
      Integer localInteger = (Integer)this.recvFirstIFrameCntList.get(Long.valueOf(paramLong));
      HashMap localHashMap = this.recvFirstIFrameCntList;
      int j = 1;
      int i;
      if (localInteger == null) {
        i = 1;
      } else {
        i = localInteger.intValue() + 1;
      }
      localHashMap.put(Long.valueOf(paramLong), Integer.valueOf(i));
      if (localInteger == null)
      {
        i = j;
      }
      else
      {
        i = localInteger.intValue();
        i = 1 + i;
      }
      return i;
    }
    finally {}
  }
  
  public void removeRenderInfo(String paramString)
  {
    try
    {
      TRTCRoomInfo.UserInfo localUserInfo = (TRTCRoomInfo.UserInfo)this.userList.get(paramString);
      this.recvFirstIFrameCntList.remove(Long.valueOf(localUserInfo.tinyID));
      this.userList.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setRoomExit(boolean paramBoolean, int paramInt)
  {
    try
    {
      this.hasExitedRoom = paramBoolean;
      this.exitRoomCode = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setRoomId(int paramInt)
  {
    this.roomId = paramInt;
  }
  
  public void setTinyId(String paramString)
  {
    this.tinyId = paramString;
  }
  
  public void setToken(Context paramContext, byte[] paramArrayOfByte)
  {
    this.token = paramArrayOfByte;
    try
    {
      paramContext = paramContext.getSharedPreferences("TRTC.Info", 0).edit();
      if (this.token != null) {
        paramContext.putString("TRTC.0x0.Token", byteArrayToHexStr(this.token));
      } else {
        paramContext.clear();
      }
      paramContext.commit();
      return;
    }
    catch (Exception paramContext)
    {
      TXCLog.e("TRTCRoomInfo", "set token failed.", paramContext);
    }
  }
  
  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCRoomInfo
 * JD-Core Version:    0.7.0.1
 */