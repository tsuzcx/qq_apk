package com.tencent.mobileqq.apollo;

import albu;
import alef;
import alfz;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloEngine
{
  private static int jdField_a_of_type_Int;
  private static BufferedReader jdField_a_of_type_JavaIoBufferedReader;
  private static CopyOnWriteArrayList<Object> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private static boolean jdField_a_of_type_Boolean;
  public long a;
  private ApolloTicker jdField_a_of_type_ComTencentMobileqqApolloApolloTicker;
  private ConcurrentHashMap<Integer, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile boolean b;
  private volatile boolean c;
  
  static
  {
    alfz.a("classLoad");
  }
  
  public ApolloEngine()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    if (jdField_a_of_type_Boolean)
    {
      if (jdField_a_of_type_Int > 0) {
        nativeSetPipeLog(0);
      }
      jdField_a_of_type_Int = 0;
    }
    QLog.i("ApolloManager.Engine", 1, "setPipeLog pipeLogDisable:" + paramBoolean);
  }
  
  public static boolean a()
  {
    if (!alfz.a())
    {
      alfz.a("other");
      ApolloGameStateMachine.a().a(5, "not load lib");
      return false;
    }
    return true;
  }
  
  private void b()
  {
    new File(alef.a, "slave");
    String str1 = alef.c + "/def/role/0/script/slave/";
    String str2 = alef.c + "/";
    nativeSetFileHomeDir(alef.av, alef.g, alef.a, alef.a, alef.a + "/extension/", str1, str2);
  }
  
  private void c()
  {
    if ((jdField_a_of_type_Int > 0) && (jdField_a_of_type_JavaIoBufferedReader == null)) {
      ThreadManagerV2.newFreeThread(new ApolloEngine.1(this), "Apollo_GL_Log", 1).start();
    }
  }
  
  private native void nativeAudioCallBack(long paramLong);
  
  private native long nativeCreateDirector(long paramLong, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4);
  
  private native void nativeCreateGLContext(long paramLong1, int paramInt1, int paramInt2, float paramFloat, long paramLong2);
  
  private native void nativeDiposeDirector(long paramLong);
  
  private native void nativeDrawFrame(long paramLong, double paramDouble, int paramInt);
  
  private native void nativeEditorOnClickCallBack(long paramLong, String paramString);
  
  private native void nativeEditorTextChangeCallBack(long paramLong, String paramString);
  
  private native RectF nativeGetDressRect(long paramLong, String paramString);
  
  private native long nativeGetLuaState(long paramLong);
  
  private native RectF nativeGetManRect(long paramLong);
  
  private native int nativeGetRoleNum(long paramLong);
  
  private native String nativeHitestForName(long paramLong, float paramFloat1, float paramFloat2);
  
  private native int nativeHittest(long paramLong, float paramFloat1, float paramFloat2);
  
  private native void nativeHttpCallBack(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  private native void nativeHttpDownloadProgressChange(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeHttpResponseCallback(long paramLong, int paramInt, String[] paramArrayOfString, byte[] paramArrayOfByte);
  
  private native void nativeHttpUploadProgressChange(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeLoadScriptFile(long paramLong, String paramString);
  
  private native void nativeLoadScriptString(long paramLong, String paramString, int paramInt);
  
  private native void nativeLocationCallBack(long paramLong, int paramInt, String paramString1, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7);
  
  private native int nativeOrganHittest(long paramLong, float paramFloat1, float paramFloat2, String paramString);
  
  private native String nativeRenderNodeGetExtendString(long paramLong);
  
  private native void nativeScriptCreate(long paramLong, String paramString, int paramInt);
  
  private native void nativeSelectPhotoCallBack(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  private native void nativeSetDirectorHidden(long paramLong, int paramInt);
  
  private native void nativeSetDirectorRenderSize(long paramLong, float paramFloat1, float paramFloat2);
  
  private native void nativeSetDirectorScreenScale(long paramLong, float paramFloat);
  
  private native void nativeSetFileHomeDir(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
  
  private native void nativeSetNeedRender(long paramLong, int paramInt);
  
  private native void nativeSetNodeHidden(long paramLong, String paramString, int paramInt);
  
  private static native int nativeSetPipeLog(int paramInt);
  
  private static native void nativeSetQLogLevel(int paramInt);
  
  private native void nativeSetSkey(byte[] paramArrayOfByte);
  
  private native void nativeSetSt(byte[] paramArrayOfByte);
  
  private native void nativeUpdateMouseButton(long paramLong, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
  
  private native void nativeWebSocketSetSocket(long paramLong, int paramInt);
  
  private native void nativeWebSocketSetState(long paramLong, int paramInt);
  
  public long a()
  {
    if (a("[getLuaState]")) {
      return nativeGetLuaState(this.jdField_a_of_type_Long);
    }
    return -1L;
  }
  
  public long a(long paramLong, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4)
  {
    QLog.d("ApolloManager.Engine", 1, "[createDirector] tid: " + Thread.currentThread().getId() + ", mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", isEngineReady:" + a() + ",glVersion:" + paramInt4);
    if (a())
    {
      new File(alef.i).mkdirs();
      if (paramInt4 != 3) {
        break label220;
      }
      paramInt4 = 1;
      this.jdField_a_of_type_Long = nativeCreateDirector(paramLong, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4);
      if (this.jdField_a_of_type_Long > 0L)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.b = true;
      }
      if (BaseApplicationImpl.sProcessId == 1)
      {
        if (jdField_a_of_type_Boolean) {
          break label226;
        }
        jdField_a_of_type_Int = nativeSetPipeLog(1);
        c();
        b();
        label163:
        QLog.i("ApolloManager.Engine", 1, "sPipeLogFd:" + jdField_a_of_type_Int + " sPipeLogDisable:" + jdField_a_of_type_Boolean);
      }
      if (!QLog.isColorLevel()) {
        break label244;
      }
    }
    label220:
    label226:
    label244:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      nativeSetQLogLevel(paramInt1);
      return this.jdField_a_of_type_Long;
      paramInt4 = 0;
      break;
      if (jdField_a_of_type_Int > 0) {
        nativeSetPipeLog(0);
      }
      jdField_a_of_type_Int = 0;
      break label163;
    }
  }
  
  public RectF a()
  {
    if (a("[getManRect]")) {
      return nativeGetManRect(this.jdField_a_of_type_Long);
    }
    return null;
  }
  
  public RectF a(String paramString)
  {
    if (a("[getDressRect]")) {
      return nativeGetDressRect(this.jdField_a_of_type_Long, paramString);
    }
    return null;
  }
  
  public ApolloTicker a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker = new ApolloTicker();
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloTicker;
  }
  
  public void a()
  {
    if (a("[disposeDirector]"))
    {
      QLog.d("ApolloManager.Engine", 1, "[disposeDirector] tid: " + Thread.currentThread().getId() + ", mDirector: " + this.jdField_a_of_type_Long);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      nativeDiposeDirector(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Long = -1L;
    }
  }
  
  public void a(double paramDouble)
  {
    a(String.format(albu.b(), new Object[] { Double.valueOf(paramDouble) }));
  }
  
  public void a(double paramDouble, int paramInt)
  {
    if (a("[drawFrame]")) {
      nativeDrawFrame(this.jdField_a_of_type_Long, paramDouble, paramInt);
    }
  }
  
  public void a(float paramFloat)
  {
    if (a("[setDirectorScreenScale]")) {
      nativeSetDirectorScreenScale(this.jdField_a_of_type_Long, paramFloat);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (a("[setDirectorRenderSize]")) {
      nativeSetDirectorRenderSize(this.jdField_a_of_type_Long, paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), Boolean.TRUE);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager.Engine", 2, new Object[] { "setScriptLoaded scriptId:", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (a("[updateMouseButton]")) {
      nativeUpdateMouseButton(this.jdField_a_of_type_Long, paramInt1, paramInt2, paramFloat1, paramFloat2);
    }
  }
  
  public void a(long paramLong)
  {
    nativeAudioCallBack(paramLong);
  }
  
  public void a(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, String paramString1, int paramInt, String paramString2)
  {
    nativeLocationCallBack(paramLong, paramInt, paramString2, paramString1, paramDouble2, paramDouble3, paramDouble1, paramDouble5, 0.0D, paramDouble4, paramDouble6);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager.Engine", 2, "[webSocketSetState], errInfo->initErr, mIsLoadSuccess:" + a() + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return;
    }
    nativeWebSocketSetState(paramLong, paramInt);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager.Engine", 2, "[nativeUploadProgressChange], errInfo->initErr, mIsLoadSuccess:" + a() + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return;
    }
    nativeHttpUploadProgressChange(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager.Engine", 2, "createGLContext");
    }
    if (a("createGLContext")) {
      nativeCreateGLContext(paramLong, paramInt1, paramInt2, paramFloat, this.jdField_a_of_type_Long);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager.Engine", 2, "[imageselector selectPhoto], errInfo->initErr, mIsLoadSuccess:" + a() + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    nativeSelectPhotoCallBack(paramLong, paramInt1, paramInt2, paramInt3, paramArrayOfByte);
  }
  
  @Deprecated
  public void a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager.Engine", 2, "[httpCallBack], errInfo->initErr, mIsLoadSuccess:" + a() + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return;
    }
    nativeHttpCallBack(paramLong, paramInt, paramArrayOfByte);
  }
  
  public void a(long paramLong, int paramInt, String[] paramArrayOfString, byte[] paramArrayOfByte)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager.Engine", 2, "[httpResponseCallback], errInfo->initErr, mIsLoadSuccess:" + a() + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return;
    }
    nativeHttpResponseCallback(paramLong, paramInt, paramArrayOfString, paramArrayOfByte);
  }
  
  public void a(long paramLong, String paramString)
  {
    nativeEditorTextChangeCallBack(paramLong, paramString);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a("[execScriptString]")) {
      return;
    }
    try
    {
      new StringBuilder(paramString.length() + 100).append("try{").append(paramString).append("}catch(err){BK.Script.log(0, 0, err.message);}");
      l = this.jdField_a_of_type_Long;
      if (!QLog.isColorLevel()) {
        break label83;
      }
      i = 1;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        long l;
        QLog.e("ApolloManager.Engine", 1, paramString, new Object[0]);
        return;
        int i = 0;
      }
    }
    catch (Throwable paramString)
    {
      label83:
      QLog.e("ApolloManager.Engine", 1, paramString, new Object[0]);
    }
    nativeLoadScriptString(l, paramString, i);
    return;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (a("[setNodeHidden]")) {
      nativeSetNodeHidden(this.jdField_a_of_type_Long, paramString, paramInt);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    nativeSetSkey(paramArrayOfByte);
  }
  
  public boolean a(int paramInt)
  {
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_Long < 0L))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder(paramString);
        paramString.append(" error mIsInit: ").append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()).append(", mDirector: ").append(this.jdField_a_of_type_Long);
        QLog.d("ApolloManager.Engine", 2, paramString.toString());
      }
      return false;
    }
    return true;
  }
  
  public void b(long paramLong, int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager.Engine", 2, "[webSocketSetSSLState], errInfo->initErr, mIsLoadSuccess:" + a() + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return;
    }
    nativeWebSocketSetSocket(paramLong, paramInt);
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager.Engine", 2, "[nativeDownloadProgressChange], errInfo->initErr, mIsLoadSuccess:" + a() + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return;
    }
    nativeHttpDownloadProgressChange(paramLong, paramInt1, paramInt2);
  }
  
  public void b(long paramLong, String paramString)
  {
    nativeEditorOnClickCallBack(paramLong, paramString);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    nativeSetSt(paramArrayOfByte);
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public native void bkDirectorChangeScreenMode(int paramInt);
  
  public native void nativeNotifyScreenModeChange(long paramLong, int paramInt);
  
  public String toString()
  {
    return "ApolloEngine{mIsInit=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean + ", mDirector=" + this.jdField_a_of_type_Long + ", mHadInitDirector=" + this.b + ", mViewInited=" + this.c + ", hashCode=" + hashCode() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloEngine
 * JD-Core Version:    0.7.0.1
 */