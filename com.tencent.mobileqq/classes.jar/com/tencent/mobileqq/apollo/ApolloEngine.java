package com.tencent.mobileqq.apollo;

import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class ApolloEngine
{
  private static CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public long a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    ApolloSoLoader.a("classLoad");
  }
  
  public ApolloEngine()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static void a(ICmShowLibLoadCallback paramICmShowLibLoadCallback)
  {
    if ((paramICmShowLibLoadCallback != null) && (!jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramICmShowLibLoadCallback))) {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramICmShowLibLoadCallback);
    }
  }
  
  public static boolean a()
  {
    if (!ApolloSoLoader.a())
    {
      ApolloSoLoader.a("other");
      ApolloGameStateMachine.a().a(5, "not load lib");
      return false;
    }
    return true;
  }
  
  public static void b(ICmShowLibLoadCallback paramICmShowLibLoadCallback)
  {
    if ((paramICmShowLibLoadCallback != null) && (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramICmShowLibLoadCallback))) {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramICmShowLibLoadCallback);
    }
  }
  
  private native void nativeAudioCallBack(long paramLong);
  
  private native long nativeCreateDirector(long paramLong, int paramInt1, int paramInt2, float paramFloat);
  
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
  
  private native void nativeLoadScriptFile(long paramLong, String paramString);
  
  private native void nativeLoadScriptString(long paramLong, String paramString, int paramInt);
  
  private native void nativeLocationCallBack(long paramLong, int paramInt, String paramString1, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7);
  
  private native int nativeOrganHittest(long paramLong, float paramFloat1, float paramFloat2, String paramString);
  
  private native void nativeScriptCreate(long paramLong, String paramString, int paramInt);
  
  private native void nativeSelectPhotoCallBack(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  private native void nativeSetDirectorHidden(long paramLong, int paramInt);
  
  private native void nativeSetDirectorRenderSize(long paramLong, float paramFloat1, float paramFloat2);
  
  private native void nativeSetDirectorScreenScale(long paramLong, float paramFloat);
  
  private native void nativeSetNeedRender(long paramLong, int paramInt);
  
  private native void nativeSetNodeHidden(long paramLong, String paramString, int paramInt);
  
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
  
  public long a(long paramLong, int paramInt1, int paramInt2, float paramFloat)
  {
    QLog.d("ApolloManager.Engine", 1, "[createDirector],mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", isEngineReady:" + a());
    if (a())
    {
      this.jdField_a_of_type_Long = nativeCreateDirector(paramLong, paramInt1, paramInt2, paramFloat);
      if (this.jdField_a_of_type_Long > 0L) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
    }
    return this.jdField_a_of_type_Long;
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
  
  public String a(float paramFloat1, float paramFloat2)
  {
    if (a("[hittestForName]")) {
      return nativeHitestForName(this.jdField_a_of_type_Long, paramFloat1, paramFloat2);
    }
    return null;
  }
  
  public void a()
  {
    if (a("[disposeDirector]"))
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      nativeDiposeDirector(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Long = -1L;
    }
  }
  
  public void a(double paramDouble)
  {
    a(String.format("BK.Render.clear(0,0,0,0);BK.Render.treeRender( BK.Director.root,%f);BK.Render.commit();", new Object[] { Double.valueOf(paramDouble) }));
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
    nativeSetNeedRender(this.jdField_a_of_type_Long, paramInt);
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
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager.Engine", 2, "[imageselector selectPhoto], errInfo->initErr, mIsLoadSuccess:" + a() + ",mIsInit:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    nativeSelectPhotoCallBack(paramLong, paramInt1, paramInt2, paramInt3, paramArrayOfByte);
  }
  
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
      new StringBuilder(paramString.length() + 100).append("try{").append(paramString).append("}catch(err){BK.Script.log(0, 0, err);}");
      l = this.jdField_a_of_type_Long;
      if (!QLog.isColorLevel()) {
        break label80;
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
      label80:
      QLog.e("ApolloManager.Engine", 1, paramString, new Object[0]);
    }
    nativeLoadScriptString(l, paramString, i);
    return;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    nativeSetSkey(paramArrayOfByte);
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
  
  public void b(long paramLong, String paramString)
  {
    nativeEditorOnClickCallBack(paramLong, paramString);
  }
  
  public void b(String paramString)
  {
    int j;
    int i;
    if (a("[createScript]"))
    {
      j = -1;
      i = j;
    }
    try
    {
      if (ApolloConfigUtils.b != null) {
        i = ApolloConfigUtils.b.optInt("engineSwitch");
      }
      nativeScriptCreate(this.jdField_a_of_type_Long, paramString, i);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloManager.Engine", 2, localOutOfMemoryError.getMessage());
          i = j;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    nativeSetSt(paramArrayOfByte);
  }
  
  public native void bkDirectorChangeScreenMode(int paramInt);
  
  public native void nativeNotifyScreenModeChange(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloEngine
 * JD-Core Version:    0.7.0.1
 */