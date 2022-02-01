package com.tencent.litetransfersdk;

import android.os.Handler;
import android.os.Looper;
import com.dataline.util.HttpUtil;
import com.dataline.util.HttpUtil.NetworkProxy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class LiteTransferWrapper
{
  static final int Business_ID_C2C = 3;
  static final int Business_ID_DataLine = 38;
  static final int Business_ID_Disc = 106;
  static final int Business_ID_Group = 102;
  public static final String sTagName = "dataline.LiteTTransferWrapper";
  private LiteTransferListenerCallback mListener;
  private long mLiteTransferOperator = 0L;
  private LiteTransferOperatorCallback mOperator;
  
  static
  {
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "xplatform", 0, false);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      localUnsatisfiedLinkError1.printStackTrace();
    }
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "mbedtlsall", 0, false);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      localUnsatisfiedLinkError2.printStackTrace();
    }
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "xphttpclientex", 0, false);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
    {
      localUnsatisfiedLinkError3.printStackTrace();
    }
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "litetransfer", 0, false);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError4)
    {
      localUnsatisfiedLinkError4.printStackTrace();
    }
  }
  
  public LiteTransferWrapper(LiteTransferOperatorCallback paramLiteTransferOperatorCallback, LiteTransferListenerCallback paramLiteTransferListenerCallback)
  {
    this.mOperator = paramLiteTransferOperatorCallback;
    this.mListener = paramLiteTransferListenerCallback;
    this.mLiteTransferOperator = 0L;
  }
  
  public static void OnLog(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte1 = new String(paramArrayOfByte1, "UTF-8");
      paramArrayOfByte2 = new String(paramArrayOfByte2, "UTF-8");
      if ((paramInt != 0) && (paramInt != 1))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(paramArrayOfByte1, 4, paramArrayOfByte2);
        }
      }
      else {
        QLog.d(paramArrayOfByte1, 1, paramArrayOfByte2);
      }
      return;
    }
    catch (UnsupportedEncodingException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.e("dataline.LiteTTransferWrapper", 4, "native log encoding utf8 failed");
      }
    }
  }
  
  public static long getCurrentMillisTime()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
  
  public static int getNetType()
  {
    return NetworkCenter.getInstance().getNetType();
  }
  
  public void CancelAll(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CancelAll ");
      ((StringBuilder)localObject).append(this.mLiteTransferOperator);
      QLog.d("dataline.LiteTTransferWrapper", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mLiteTransferOperator == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.LiteTTransferWrapper", 2, "CancelAll mLiteTransferOperator is 0, maybe not inited, so has nothing to cancel");
      }
      return;
    }
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new LiteTransferWrapper.3(this, paramInt, paramBoolean));
      return;
    }
    long l = this.mLiteTransferOperator;
    if (l != 0L) {
      CancelAllToJNI(l, paramInt, paramBoolean);
    }
  }
  
  public native void CancelAllToJNI(long paramLong, int paramInt, boolean paramBoolean);
  
  public void CancelGroup(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CancelGroup ");
      ((StringBuilder)localObject).append(this.mLiteTransferOperator);
      QLog.d("dataline.LiteTTransferWrapper", 2, ((StringBuilder)localObject).toString());
    }
    checkTransferAlive();
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new LiteTransferWrapper.7(this, paramInt1, paramLong, paramInt2, paramBoolean));
      return;
    }
    long l = this.mLiteTransferOperator;
    if (l != 0L) {
      CancelGroupToJNI(l, paramInt1, paramLong, paramInt2, paramBoolean);
    }
  }
  
  public native void CancelGroupToJNI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, boolean paramBoolean);
  
  public native void DoGetThumbFilePathReplyToJNI(long paramLong, int paramInt, String paramString);
  
  public native void DoPbMsgReplyToJNI(long paramLong, int paramInt, MsgSCBody paramMsgSCBody);
  
  public void OnGetThumbFilePathReply(int paramInt, String paramString)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new LiteTransferWrapper.8(this, paramInt, paramString));
      return;
    }
    long l = this.mLiteTransferOperator;
    if (l != 0L) {
      DoGetThumbFilePathReplyToJNI(l, paramInt, paramString);
    }
  }
  
  public void OnPbMsgReceive(MsgCSBody paramMsgCSBody)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("_PbMsgRecive ");
      ((StringBuilder)localObject).append(this.mLiteTransferOperator);
      QLog.d("dataline.LiteTTransferWrapper", 2, ((StringBuilder)localObject).toString());
    }
    checkTransferAlive();
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new LiteTransferWrapper.10(this, paramMsgCSBody));
      return;
    }
    long l = this.mLiteTransferOperator;
    if (l != 0L) {
      PbMsgReciveToJNI(l, paramMsgCSBody);
    }
  }
  
  public void OnPbMsgReply(int paramInt, MsgSCBody paramMsgSCBody)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new LiteTransferWrapper.9(this, paramInt, paramMsgSCBody));
      return;
    }
    long l = this.mLiteTransferOperator;
    if (l != 0L) {
      DoPbMsgReplyToJNI(l, paramInt, paramMsgSCBody);
    }
  }
  
  public native void PbMsgReciveToJNI(long paramLong, MsgCSBody paramMsgCSBody);
  
  public void RecvGroup(Session[] paramArrayOfSession, NFCInfo[] paramArrayOfNFCInfo, FTNInfo[] paramArrayOfFTNInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RecvGroup ");
      ((StringBuilder)localObject).append(this.mLiteTransferOperator);
      QLog.d("dataline.LiteTTransferWrapper", 2, ((StringBuilder)localObject).toString());
    }
    checkTransferAlive();
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new LiteTransferWrapper.6(this, paramArrayOfSession, paramArrayOfNFCInfo, paramArrayOfFTNInfo, paramBoolean));
      return;
    }
    if (this.mLiteTransferOperator != 0L)
    {
      SetProxyToJni();
      RecvGroupToJNI(this.mLiteTransferOperator, paramArrayOfSession, paramArrayOfNFCInfo, paramArrayOfFTNInfo, paramBoolean);
    }
  }
  
  public native void RecvGroupToJNI(long paramLong, Session[] paramArrayOfSession, NFCInfo[] paramArrayOfNFCInfo, FTNInfo[] paramArrayOfFTNInfo, boolean paramBoolean);
  
  public void SendGroup(ArrayList<Session> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new LiteTransferWrapper.5(this, paramArrayList, paramBoolean1, paramBoolean2));
      return;
    }
    if (this.mLiteTransferOperator != 0L)
    {
      SetProxyToJni();
      SendGroupToJNI(this.mLiteTransferOperator, (Session[])paramArrayList.toArray(new Session[paramArrayList.size()]), paramBoolean1, paramBoolean2);
    }
  }
  
  public native void SendGroupToJNI(long paramLong, Session[] paramArrayOfSession, boolean paramBoolean1, boolean paramBoolean2);
  
  public native void SetBusinessID(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void SetDefaultPath(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SetDefaultPath ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("dataline.LiteTTransferWrapper", 2, ((StringBuilder)localObject).toString());
    }
    checkTransferAlive();
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new LiteTransferWrapper.11(this, paramString));
      return;
    }
    long l = this.mLiteTransferOperator;
    if (l != 0L) {
      SetDefaultPathToJNI(l, paramString);
    }
  }
  
  public native void SetDefaultPathToJNI(long paramLong, String paramString);
  
  public void SetProxyToJni()
  {
    HttpUtil.NetworkProxy localNetworkProxy = HttpUtil.a();
    if (localNetworkProxy != null) {
      try
      {
        setGlobalProxyInfo(1, localNetworkProxy.jdField_a_of_type_JavaLangString, (short)localNetworkProxy.jdField_a_of_type_Int, "", "");
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        localUnsatisfiedLinkError1.printStackTrace();
        return;
      }
    }
    try
    {
      setGlobalProxyInfo(0, "", (short)0, "", "");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      localUnsatisfiedLinkError2.printStackTrace();
    }
  }
  
  public void SetServicePath(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SetServicePath ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("dataline.LiteTTransferWrapper", 2, ((StringBuilder)localObject).toString());
    }
    checkTransferAlive();
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new LiteTransferWrapper.13(this, paramString1, paramString2));
      return;
    }
    long l = this.mLiteTransferOperator;
    if (l != 0L) {
      SetServicePathToJNI(l, paramString1, paramString2);
    }
  }
  
  public native void SetServicePathToJNI(long paramLong, String paramString1, String paramString2);
  
  public void SetTempPath(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SetTempPath ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("dataline.LiteTTransferWrapper", 2, ((StringBuilder)localObject).toString());
    }
    checkTransferAlive();
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new LiteTransferWrapper.14(this, paramString));
      return;
    }
    long l = this.mLiteTransferOperator;
    if (l != 0L) {
      SetTempPathToJNI(l, paramString);
    }
  }
  
  public native void SetTempPathToJNI(long paramLong, String paramString);
  
  public void SetThumbPath(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SetThumbPath ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("dataline.LiteTTransferWrapper", 2, ((StringBuilder)localObject).toString());
    }
    checkTransferAlive();
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new LiteTransferWrapper.12(this, paramString));
      return;
    }
    long l = this.mLiteTransferOperator;
    if (l != 0L) {
      SetThumbPathToJNI(l, paramString);
    }
  }
  
  public native void SetThumbPathToJNI(long paramLong, String paramString);
  
  public void SetThumbTempPath(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SetThumbTempPath ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("dataline.LiteTTransferWrapper", 2, ((StringBuilder)localObject).toString());
    }
    checkTransferAlive();
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new LiteTransferWrapper.15(this, paramString));
      return;
    }
    long l = this.mLiteTransferOperator;
    if (l != 0L) {
      SetThumbTempPathToJNI(l, paramString);
    }
  }
  
  public native void SetThumbTempPathToJNI(long paramLong, String paramString);
  
  public void SyncGroup(Session[] paramArrayOfSession)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new LiteTransferWrapper.4(this, paramArrayOfSession));
      return;
    }
    long l = this.mLiteTransferOperator;
    if (l != 0L) {
      SyncGroupToJNI(l, paramArrayOfSession);
    }
  }
  
  public native void SyncGroupToJNI(long paramLong, Session[] paramArrayOfSession);
  
  public void beginLiteTransfer()
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new LiteTransferWrapper.1(this));
      return;
    }
    localObject = this.mOperator;
    if (localObject != null)
    {
      LiteTransferListenerCallback localLiteTransferListenerCallback = this.mListener;
      if (localLiteTransferListenerCallback != null)
      {
        if (this.mLiteTransferOperator == 0L) {
          try
          {
            this.mLiteTransferOperator = createOperator((LiteTransferOperatorCallback)localObject, localLiteTransferListenerCallback);
            SetBusinessID(38, 3, 106, 102);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("createOperator mLiteTransferOperator:");
            ((StringBuilder)localObject).append(this.mLiteTransferOperator);
            ((StringBuilder)localObject).append(" threadId:");
            ((StringBuilder)localObject).append(Thread.currentThread().getId());
            QLog.i("dataline.LiteTTransferWrapper", 1, ((StringBuilder)localObject).toString());
            checkPathExist();
            SetProxyToJni();
            return;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
          {
            localUnsatisfiedLinkError.printStackTrace();
          }
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "litetransfer callback is null, do nothing");
    }
  }
  
  public void checkPathExist()
  {
    try
    {
      File localFile = new File(FMSettings.a().getDefaultRecvPath());
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      SetDefaultPath(FMSettings.a().getDefaultRecvPath());
      localFile = new File(FMSettings.a().getDefaultThumbPath());
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      SetThumbPath(FMSettings.a().getDefaultThumbPath());
      localFile = new File(FMSettings.a().getDefaultTmpPath());
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      SetTempPath(FMSettings.a().getDefaultTmpPath());
      localFile = new File(FMSettings.a().getDefaultTmpPath());
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      SetThumbTempPath(FMSettings.a().getDefaultTmpPath());
      return;
    }
    catch (Exception localException) {}
  }
  
  public void checkTransferAlive()
  {
    if (this.mLiteTransferOperator == 0L) {
      beginLiteTransfer();
    }
  }
  
  public native long createOperator(LiteTransferOperatorCallback paramLiteTransferOperatorCallback, LiteTransferListenerCallback paramLiteTransferListenerCallback);
  
  public native void destryOperator(long paramLong, boolean paramBoolean);
  
  public void endLiteTransfer(boolean paramBoolean)
  {
    if (this.mLiteTransferOperator == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.LiteTTransferWrapper", 2, "endLiteTransfer mLiteTransferOperator is 0, maybe not inited, so has nothing to cancel");
      }
      return;
    }
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new LiteTransferWrapper.2(this, paramBoolean));
      return;
    }
    try
    {
      if (this.mLiteTransferOperator != 0L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("destryOperator mLiteTransferOperator:");
        ((StringBuilder)localObject).append(this.mLiteTransferOperator);
        ((StringBuilder)localObject).append(" threadId:");
        ((StringBuilder)localObject).append(Thread.currentThread().getId());
        QLog.i("dataline.LiteTTransferWrapper", 1, ((StringBuilder)localObject).toString());
        long l = this.mLiteTransferOperator;
        this.mLiteTransferOperator = 0L;
        destryOperator(l, paramBoolean);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cannot endLiteTransfer, load litetranfer library error?");
        localStringBuilder.append(QLog.getStackTraceString(localUnsatisfiedLinkError));
        QLog.d("dataline.LiteTTransferWrapper", 2, localStringBuilder.toString());
      }
    }
    this.mOperator = null;
    this.mListener = null;
  }
  
  public native int generateGroupID();
  
  public native long generateSessionID(int paramInt);
  
  public native long generateSessionIDByDev(int paramInt1, int paramInt2);
  
  public native long generateTaskID(long paramLong, byte paramByte);
  
  public native long initGlobalFunc();
  
  public native void setGlobalProxyInfo(int paramInt, String paramString1, short paramShort, String paramString2, String paramString3);
  
  public native void setWanIP(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper
 * JD-Core Version:    0.7.0.1
 */