package com.tencent.mm.hardcoder;

import aabj;
import aabk;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

public class HardCoderJNI
{
  public static final long ACTION_ALLOC_MEMORY = 65536L;
  public static final long ACTION_ANIMATION = 2L;
  public static final long ACTION_DECODE_PIC = 64L;
  public static final long ACTION_DECODE_STREAM = 1024L;
  public static final long ACTION_DECODE_VIDEO = 256L;
  public static final long ACTION_DEXO2OAT = 1L;
  public static final long ACTION_ENCODE_PIC = 128L;
  public static final long ACTION_ENCODE_STREAM = 2048L;
  public static final long ACTION_ENCODE_VIDEO = 512L;
  public static final long ACTION_INIT_LISTVIEW = 16L;
  public static final long ACTION_NET_RX = 131072L;
  public static final long ACTION_NET_TX = 262144L;
  public static final long ACTION_ONCREATE = 4L;
  public static final long ACTION_ONDESTROY = 8L;
  public static final long ACTION_QUERY_SQL = 4096L;
  public static final long ACTION_READ_FILE = 16384L;
  public static final long ACTION_SCROLL_LISTVIEW = 32L;
  public static final long ACTION_WRITE_FILE = 32768L;
  public static final long ACTION_WRITE_SQL = 8192L;
  public static final int CPU_LEVEL_0 = 0;
  public static final int CPU_LEVEL_1 = 1;
  public static final int CPU_LEVEL_2 = 2;
  public static final int CPU_LEVEL_3 = 3;
  public static final boolean DEBUG = false;
  public static final int IO_LEVEL_0 = 0;
  public static final int IO_LEVEL_1 = 1;
  public static final int IO_LEVEL_2 = 2;
  public static final int IO_LEVEL_3 = 3;
  public static final int SCENE_ALBUM_SCROLL = 702;
  public static final int SCENE_BOOT = 101;
  public static final int SCENE_CHAT_SCROLL = 704;
  public static final int SCENE_DECODE_PIC = 601;
  public static final int SCENE_ENCODE_VIDEO = 603;
  public static final int SCENE_ENTER_CHATTING = 301;
  public static final int SCENE_GIF = 602;
  public static final int SCENE_MEDIA_GALLERY_SCROLL = 703;
  public static final int SCENE_OPEN_PANEL = 801;
  public static final int SCENE_QUIT_CHATTING = 302;
  public static final int SCENE_RECEIVE_MSG = 201;
  public static final int SCENE_SCENE_DB = 501;
  public static final int SCENE_SEND_MSG = 202;
  public static final int SCENE_SEND_PIC_MSG = 203;
  public static final int SCENE_SNS_SCROLL = 701;
  public static final int SCENE_UPDATE_CHATROOM = 401;
  private static final String TAG = "HardCoder.JNI";
  private static aabj callback;
  public static boolean checkEnv = true;
  public static boolean hcDebug;
  public static final boolean sHCDEBUG = aabk.a;
  
  static
  {
    hcDebug = sHCDEBUG;
  }
  
  public static native int cancelCpuCoreForThread(int[] paramArrayOfInt, int paramInt, long paramLong);
  
  public static native int cancelCpuHighFreq(int paramInt, long paramLong);
  
  public static native int cancelHighIOFreq(int paramInt, long paramLong);
  
  public static native int cancelUnifyCpuIOThreadCore(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int[] paramArrayOfInt, int paramInt, long paramLong);
  
  public static native int checkPermission(int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  public static native int getTickRate();
  
  public static native int initHardCoder(String paramString1, int paramInt, String paramString2, boolean paramBoolean);
  
  public static native int isRunning();
  
  public static void onData(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HardCoder.JNI", 2, "onData callbackType:" + paramInt1 + " timestamp:" + paramLong + " errCode:" + paramInt2 + " funcid:" + paramInt3 + " dataType:" + paramInt4);
    }
    if (paramInt2 == -20001) {
      aabk.a().a();
    }
    if (callback != null) {}
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte);
      callback.a(paramArrayOfByte);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = "";
      }
    }
  }
  
  public static native int registerANRCallback(int paramInt, long paramLong);
  
  public static int registerANRCallback(aabj paramaabj)
  {
    callback = paramaabj;
    return registerANRCallback(Process.myTid(), SystemClock.elapsedRealtime());
  }
  
  public static native int registerBootPreloadResource(String[] paramArrayOfString, int paramInt, long paramLong);
  
  public static native int requestCpuCoreForThread(int paramInt1, long paramLong1, int[] paramArrayOfInt, int paramInt2, int paramInt3, long paramLong2);
  
  public static native int requestCpuHighFreq(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  public static native int requestHighIOFreq(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  public static native int requestScreenResolution(int paramInt1, String paramString, int paramInt2, long paramLong);
  
  public static native int requestUnifyCpuIOThreadCore(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int[] paramArrayOfInt, int paramInt4, int paramInt5, long paramLong2);
  
  public static native int resetScreenResolution(int paramInt, long paramLong);
  
  public static native void setDebug(boolean paramBoolean);
  
  public static native void setHCEnable(boolean paramBoolean);
  
  public static native void setRetryConnectInterval(int paramInt);
  
  public static int startTraceCpuLoad(int paramInt)
  {
    return startTraceCpuLoad(paramInt, 20);
  }
  
  private static native int startTraceCpuLoad(int paramInt1, int paramInt2);
  
  public static native int stopTraceCpuLoad(int paramInt);
  
  public static native int terminateApp(int paramInt, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderJNI
 * JD-Core Version:    0.7.0.1
 */