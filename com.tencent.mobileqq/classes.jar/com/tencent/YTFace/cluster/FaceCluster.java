package com.tencent.YTFace.cluster;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.YTFace.model.FaceTarget;
import com.tencent.aelight.camera.download.old.api.AEOldResInfo;
import com.tencent.aelight.camera.download.old.api.IAEOldResUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.FaceScanNativeSoLoader;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FaceCluster
{
  public static final int ERROR_INIT_TRACK_ERROR = -1001;
  public static final int ERROR_MODEL_NOT_EXIST = -1000;
  public static final int FACE_DETECT_FORMAT_BITMAP = 1;
  public static final int FACE_DETECT_FORMAT_PIC = 2;
  private static final String TAG = "FaceCluster";
  private static FaceCluster instance;
  private static boolean loadSoSuccess = false;
  private static boolean soLoaded = false;
  public static boolean useAssetSo = false;
  private long nativeFeaturePtr;
  private long nativeTrackPtr;
  
  private FaceCluster()
  {
    try
    {
      String str1 = FaceScanNativeSoLoader.a("YTFaceExtFeature");
      String str2 = FaceScanNativeSoLoader.a("YTFaceClusterJNI_V852");
      BaseApplicationImpl.sApplication.getSharedPreferences("QQCrashReportManager", 4).edit().putString("facefeature_ext_so_md5", str1).commit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FaceCluster faceFeatureExtSoMD5 = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" faceJniSoMD5 =  ");
      localStringBuilder.append(str2);
      QLog.d("FaceCluster", 1, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.d("FaceCluster", 1, "FaceCluster exception", localException);
    }
  }
  
  public static FaceCluster getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new FaceCluster();
      }
      if (!loadSoSuccess) {
        loadNativeLibrary();
      }
      FaceCluster localFaceCluster = instance;
      return localFaceCluster;
    }
    finally {}
  }
  
  public static boolean loadNativeLibrary()
  {
    for (;;)
    {
      try
      {
        bool = FaceScanNativeSoLoader.a();
        if (!bool) {
          return false;
        }
        if (soLoaded)
        {
          bool = loadSoSuccess;
          return bool;
        }
        soLoaded = true;
        try
        {
          int i = FaceScanNativeSoLoader.b(FaceScanNativeSoLoader.c());
          int j = FaceScanNativeSoLoader.b(FaceScanNativeSoLoader.d());
          System.loadLibrary("YTCommon");
          int k = FaceScanNativeSoLoader.c("YTFaceCluster");
          int m = FaceScanNativeSoLoader.b(FaceScanNativeSoLoader.e());
          int n = FaceScanNativeSoLoader.c("YTFaceExtFeature");
          int i1 = FaceScanNativeSoLoader.c("YTFaceClusterJNI_V852");
          if ((j != 0) || (k != 0) || (n != 0) || (m != 0) || (i1 != 0) || (i != 0)) {
            break label272;
          }
          bool = true;
          loadSoSuccess = bool;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[loadNativeLibrary], ,ytCppShared = ");
          localStringBuilder.append(i);
          localStringBuilder.append(",ytOpencvTinyWorld = ");
          localStringBuilder.append(j);
          localStringBuilder.append(",ytCluster = ");
          localStringBuilder.append(k);
          localStringBuilder.append(",ytTrackPro = ");
          localStringBuilder.append(m);
          localStringBuilder.append(",ytFeature = ");
          localStringBuilder.append(n);
          localStringBuilder.append(",ytJni = ");
          localStringBuilder.append(i1);
          QLog.e("FaceCluster", 1, localStringBuilder.toString());
        }
        catch (Throwable localThrowable)
        {
          QLog.e("FaceCluster", 1, "[loadNativeLibrary]:load face so failed!", localThrowable);
          loadSoSuccess = false;
        }
        bool = loadSoSuccess;
        return bool;
      }
      finally {}
      label272:
      boolean bool = false;
    }
  }
  
  public static final void printQLog(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public native float[] calcuFaceFeature(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3);
  
  public native float calcuSimilarity(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  public boolean checkFaceTrackModelExistOrNot()
  {
    Object localObject = ((IAEOldResUtil)QRoute.api(IAEOldResUtil.class)).getFinalUnzippedPackageDir(AEOldResInfo.b);
    boolean bool1;
    if (!FileUtil.b((String)localObject))
    {
      boolean bool2 = false;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkFaceTrackModelExistOrNot false,path = ");
        localStringBuilder.append((String)localObject);
        QLog.d("FaceCluster", 2, localStringBuilder.toString());
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkFaceTrackModelExistOrNot result = ");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("FaceCluster", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public native int[] clusterFaces(float[][] paramArrayOfFloat);
  
  public FaceStatus[] detectFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public native int faceDetect(Object paramObject, int paramInt, FaceTarget paramFaceTarget);
  
  public int faceTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceTarget paramFaceTarget, boolean paramBoolean)
  {
    return -1;
  }
  
  public native float[] getFaceFeature(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat, boolean paramBoolean);
  
  public native float[] getFaceFeature2(Object paramObject, int paramInt, float[] paramArrayOfFloat);
  
  public int init(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("init start,face_feature_model_path = ");
      paramString1.append(paramString3);
      QLog.d("FaceCluster", 2, paramString1.toString());
    }
    if (TextUtils.isEmpty(paramString3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceCluster", 2, "init return1");
      }
      return -1000;
    }
    paramString1 = new File(paramString3);
    if ((checkFaceTrackModelExistOrNot()) && (paramString1.exists())) {
      try
      {
        int i = initTrackPro(((IAEOldResUtil)QRoute.api(IAEOldResUtil.class)).getFinalUnzippedPackageDir(AEOldResInfo.b));
        paramString1 = new StringBuilder();
        paramString1.append("init initTrackPro ret = ");
        paramString1.append(i);
        QLog.d("FaceCluster", 1, paramString1.toString());
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FaceCluster", 2, "init return3");
          }
          return i;
        }
        i = initFaceExtFeature(paramString3);
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("init finish result = ");
          paramString1.append(i);
          QLog.d("FaceCluster", 2, paramString1.toString());
        }
        return i;
      }
      catch (UnsatisfiedLinkError paramString1)
      {
        paramString1.printStackTrace();
        QLog.e("FaceCluster", 1, "UnsatisfiedLinkError", paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("FaceCluster", 2, "init return4");
        }
        return -1001;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.e("FaceCluster", 1, "Exception", paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("FaceCluster", 2, "init return4");
        }
        return -1001;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceCluster", 2, "init return2");
    }
    return -1000;
  }
  
  @Deprecated
  public native int initFaceExtFeature(String paramString);
  
  public native int initTrackPro(String paramString);
  
  public boolean isLoadSoSuccess()
  {
    return loadSoSuccess;
  }
  
  public native void release();
  
  public void releaseFaceStatusArray(FaceStatus[] paramArrayOfFaceStatus) {}
  
  public native FaceStatus[] trackFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public int trackSingleFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceStatus paramFaceStatus, boolean paramBoolean)
  {
    return -1;
  }
  
  public int trackSingleFace2(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceStatus paramFaceStatus, int paramInt3)
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.YTFace.cluster.FaceCluster
 * JD-Core Version:    0.7.0.1
 */