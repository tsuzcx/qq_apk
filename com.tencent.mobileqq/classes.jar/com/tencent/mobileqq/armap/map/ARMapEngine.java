package com.tencent.mobileqq.armap.map;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ARGLSurfaceView.SurfaceStateListener;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ARMapCityData;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.config.BaseCheckHandler.ItemConfig;
import com.tencent.mobileqq.armap.config.POIModelConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class ARMapEngine
  implements ARGLSurfaceView.SurfaceStateListener
{
  private static final int DEFAULT_GAP_TIME = 160;
  public static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
  private static final String TAG = "ARMapEngine";
  ArMapInterface mApp;
  EGL10 mEGL;
  EGLConfig mEGLConfig;
  EGLDisplay mEGLDisplay;
  Object mEglContextLock = new Object();
  public long mGameplayHandler;
  List mItemConfigList;
  public MapEngineCallback mMapEngineCallback;
  EGLContext mRenderContext;
  ARMapEngine.TextureCreator mTextureCreator;
  
  public ARMapEngine(ARMapActivity paramARMapActivity, ArMapInterface paramArMapInterface, Handler paramHandler, List paramList)
  {
    this.mMapEngineCallback = new MapEngineCallback(paramARMapActivity, paramArMapInterface, paramHandler);
    initConfig(paramList, paramARMapActivity);
    this.mApp = paramArMapInterface;
  }
  
  public static native void MapNativeSetCityVerions(long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt);
  
  public static native int getRedPackageBeginTime();
  
  public static native void guideToPOI(float paramFloat);
  
  public static native void initBackEGLContext();
  
  private void initConfig(List paramList, ARMapActivity paramARMapActivity)
  {
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    paramARMapActivity = null;
    String str2 = null;
    String str1 = null;
    int j = -1;
    int i = -1;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      BaseCheckHandler.ItemConfig localItemConfig = (BaseCheckHandler.ItemConfig)localIterator.next();
      switch (localItemConfig.jdField_b_of_type_Int)
      {
      }
      for (;;)
      {
        break;
        str7 = localItemConfig.jdField_c_of_type_JavaLangString;
        continue;
        str6 = localItemConfig.jdField_c_of_type_JavaLangString + "/skin_day/";
        j = ((Integer)localItemConfig.jdField_a_of_type_JavaLangObject).intValue();
        continue;
        str5 = localItemConfig.jdField_c_of_type_JavaLangString + "/skin_night/";
        i = ((Integer)localItemConfig.jdField_a_of_type_JavaLangObject).intValue();
        continue;
        str4 = localItemConfig.jdField_c_of_type_JavaLangString;
        continue;
        str3 = localItemConfig.jdField_c_of_type_JavaLangString;
        continue;
        paramARMapActivity = localItemConfig.jdField_c_of_type_JavaLangString;
        continue;
        str2 = localItemConfig.jdField_c_of_type_JavaLangString;
        continue;
        str1 = localItemConfig.jdField_c_of_type_JavaLangString;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.armap", 2, "initConfig|mapConfigDir:" + str7 + "\nmapDaySkinDir:" + str6 + "\nmapNightSkinDir:" + str5 + "\nskySkinDir:" + str4 + "\ntreeSkinDir:" + str3 + "\nshaderDir:" + paramARMapActivity + "\ncommonDir:" + str2 + "\nmapDayStyle:" + j + ",mapNightStyle:" + i + "\nopenBoxResDir:" + str1);
    }
    this.mMapEngineCallback.initMapEngine(str7, str6, str5, str4, str3, str2, str1, j, i);
    this.mItemConfigList = paramList;
  }
  
  public static native boolean loadARMapRes();
  
  private native boolean nativeLoadMapResourece(long paramLong);
  
  public static native void nativeOnShowRedPackRainPoi();
  
  public static native void nativeRequestLbsPOIListByPid(String paramString);
  
  public static native void nativeRequestPOIList();
  
  public static native void nativeSetMapRotateMode(long paramLong, int paramInt);
  
  public static native void nativeShowFullScreenAnimation();
  
  public static native void nativeUnpackedOne(long paramLong, String paramString);
  
  private void preLoadPOIModel(List paramList)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseCheckHandler.ItemConfig localItemConfig = (BaseCheckHandler.ItemConfig)paramList.next();
        if ((localItemConfig.jdField_b_of_type_Int == 7) && (!localHashMap.containsKey(localItemConfig.jdField_a_of_type_JavaLangString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARMapEngine", 2, "preLoadPOIModel  itemConfig = " + localItemConfig);
          }
          if (localItemConfig.jdField_c_of_type_Int == 1) {
            localArrayList.add(new POIModelConfig(localItemConfig.jdField_a_of_type_JavaLangString, localItemConfig.jdField_b_of_type_JavaLangString, localItemConfig.jdField_c_of_type_JavaLangString));
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapEngine", 2, "preLoadPOIModel  size = " + localArrayList.size());
    }
    if (localArrayList.size() > 0) {
      preLoadPoiModel(localArrayList.toArray());
    }
  }
  
  public static native void removePOITask(long paramLong);
  
  public static native void rotateToLngLat(double paramDouble1, double paramDouble2);
  
  public static native void setDefaultLocation(double paramDouble1, double paramDouble2);
  
  public static native void updateSinglePOITaskStatus(long paramLong1, long paramLong2, int paramInt);
  
  public static native void updateTestSetting(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
  
  public void fixCityDataUpdate()
  {
    new ARMapCityData(this.mApp).a(new ARMapEngine.1(this));
  }
  
  public native void loadPoiLogoRes(String paramString1, long paramLong, String paramString2, String paramString3);
  
  public native void loadPoiModel(long paramLong, Object paramObject);
  
  public void onDestroy()
  {
    synchronized (this.mEglContextLock)
    {
      this.mGameplayHandler = 0L;
      if (this.mTextureCreator != null) {
        this.mTextureCreator.stopRun();
      }
      this.mMapEngineCallback.onDestory();
      return;
    }
  }
  
  public void onEGLConfigCreated(EGL10 arg1, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext, long paramLong)
  {
    this.mEGL = ???;
    this.mEGLDisplay = paramEGLDisplay;
    this.mEGLConfig = paramEGLConfig;
    this.mRenderContext = paramEGLContext;
    this.mTextureCreator = new ARMapEngine.TextureCreator(this, false);
    ThreadManager.postImmediately(this.mTextureCreator, null, false);
    synchronized (this.mEglContextLock)
    {
      if (this.mGameplayHandler == 0L)
      {
        this.mGameplayHandler = paramLong;
        this.mMapEngineCallback.initMapEngineByOldData();
      }
      return;
    }
  }
  
  public void onEGLContextDestroyed(EGL10 arg1, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    synchronized (this.mEglContextLock)
    {
      this.mGameplayHandler = 0L;
      return;
    }
  }
  
  public void onInit(long paramLong)
  {
    this.mGameplayHandler = paramLong;
    preLoadPOIModel(this.mItemConfigList);
    this.mItemConfigList = null;
  }
  
  public void onPause()
  {
    if (this.mTextureCreator != null) {
      this.mTextureCreator.pauseRun();
    }
  }
  
  public void onResume()
  {
    if (this.mTextureCreator != null) {
      this.mTextureCreator.resumeRun();
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    fixCityDataUpdate();
  }
  
  public native void preLoadPoiModel(Object[] paramArrayOfObject);
  
  public native void updateLocationNative(double paramDouble1, double paramDouble2, String paramString1, double paramDouble3, int paramInt1, String paramString2, int paramInt2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.ARMapEngine
 * JD-Core Version:    0.7.0.1
 */