package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.ar.FaceScanModelsLoader;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceActInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.armap.ARMapTracer;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ARLocalFaceRecog
{
  public static Handler a;
  public static boolean a = true;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ARLocalFaceRecog.1(this);
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  FaceCluster jdField_a_of_type_ComTencentYTFaceClusterFaceCluster;
  ARScanStarFaceConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo;
  ARCloudRecogRspFaceResult jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult;
  private ARFacePreviewResample jdField_a_of_type_ComTencentMobileqqArArengineARFacePreviewResample;
  ARLocalFaceRecog.ARLocalFaceRecogCallback jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$ARLocalFaceRecogCallback;
  Object jdField_a_of_type_JavaLangObject = new Object();
  List<ARLocalFaceRecog.FaceInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  Handler jdField_b_of_type_AndroidOsHandler;
  HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  List<ARLocalFaceRecog.FaceInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  volatile boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 90;
  long jdField_c_of_type_Long = -1L;
  volatile boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  volatile boolean jdField_d_of_type_Boolean;
  final int jdField_e_of_type_Int = 10;
  volatile boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int = 10;
  volatile boolean jdField_f_of_type_Boolean = false;
  
  ARLocalFaceRecog()
  {
    if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.g)) {
      this.jdField_c_of_type_Int = 270;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ARLocalFaceRecog  rotateDegree = ");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean a()
  {
    boolean bool = Build.MODEL.equals("vivo X6Plus A");
    if (ARMapTracer.a() == 3) {
      bool = true;
    }
    return bool;
  }
  
  int a(float[][] paramArrayOfFloat, float[] paramArrayOfFloat1)
  {
    int k = paramArrayOfFloat.length;
    Object localObject = new float[k];
    int i = 0;
    while (i < k)
    {
      if (paramArrayOfFloat[i] != null)
      {
        localObject[i] = this.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuSimilarity(paramArrayOfFloat[i], paramArrayOfFloat1);
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("findFaceIndexByFaceFeature2 faceFeature is null,i = ");
        localStringBuilder.append(i);
        QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
      }
      i += 1;
    }
    float f1 = localObject[0];
    i = 0;
    int j = -1;
    while (i < k)
    {
      float f2 = f1;
      if (localObject[i] >= f1)
      {
        f2 = localObject[i];
        j = i;
      }
      i += 1;
      f1 = f2;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findFaceIndexByFaceFeature targetFaceFeature = ");
      ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfFloat1));
      QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject).toString());
      paramArrayOfFloat1 = new StringBuilder();
      paramArrayOfFloat1.append("findFaceIndexByFaceFeature newFaceFeature = ");
      paramArrayOfFloat1.append(Arrays.toString(paramArrayOfFloat[0]));
      QLog.d("AREngine_ARLocalFaceRecog", 2, paramArrayOfFloat1.toString());
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfFloat = new StringBuilder();
      paramArrayOfFloat.append("findFaceIndexByFaceFeature2 index = ");
      paramArrayOfFloat.append(j);
      paramArrayOfFloat.append(",finalSimilarity = ");
      paramArrayOfFloat.append(f1);
      QLog.d("AREngine_ARLocalFaceRecog", 2, paramArrayOfFloat.toString());
    }
    Float.isNaN(f1);
    if (f1 < 0.5D) {
      return -1;
    }
    return j;
  }
  
  ARScanStarFaceActInfo a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    ARScanStarFaceActInfo localARScanStarFaceActInfo = null;
    Object localObject1 = null;
    Object localObject2 = localARScanStarFaceActInfo;
    if (!bool)
    {
      ARScanStarFaceConfigInfo localARScanStarFaceConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo;
      localObject2 = localARScanStarFaceActInfo;
      if (localARScanStarFaceConfigInfo != null)
      {
        localObject2 = localARScanStarFaceActInfo;
        if (localARScanStarFaceConfigInfo.a != null)
        {
          localObject2 = localARScanStarFaceActInfo;
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a.length > 0)
          {
            int j = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a.length;
            int i = 0;
            for (;;)
            {
              localObject2 = localObject1;
              if (i >= j) {
                break;
              }
              localARScanStarFaceActInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a[i];
              localObject2 = localObject1;
              if (localARScanStarFaceActInfo != null)
              {
                localObject2 = localObject1;
                if (paramString.equals(localARScanStarFaceActInfo.jdField_b_of_type_JavaLangString)) {
                  localObject2 = localARScanStarFaceActInfo;
                }
              }
              i += 1;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    return localObject2;
  }
  
  public void a()
  {
    boolean bool = FaceScanDownloadManager.a();
    if (bool)
    {
      FaceScanModelsLoader.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster = FaceCluster.getInstance();
    }
    else
    {
      FaceScanModelsLoader.jdField_b_of_type_Boolean = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ScanStarFace]notifyResourceDownloadFinish ,isResourceReady = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(",FaceScanModelsLoader.hasFaceModelInit = ");
      localStringBuilder.append(FaceScanModelsLoader.jdField_b_of_type_Boolean);
      QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      if (!FaceScanModelsLoader.jdField_b_of_type_Boolean) {
        return;
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        int i = this.jdField_a_of_type_JavaUtilList.size();
        if ((QLog.isColorLevel()) && (jdField_a_of_type_Boolean))
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("onPreviewFrame totalFaceSize = ");
          ((StringBuilder)???).append(i);
          QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
        }
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("ARFaceTest onPreviewFrame totalFaceSize is 0,frameIdx = ");
            paramArrayOfByte.append(paramLong);
            paramArrayOfByte.append(",isPreparingData = ");
            paramArrayOfByte.append(this.jdField_d_of_type_Boolean);
            QLog.d("AREngine_ARLocalFaceRecog", 2, paramArrayOfByte.toString());
          }
        }
        else
        {
          if ((QLog.isColorLevel()) && (jdField_a_of_type_Boolean))
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append(" Try to track Face, isTracking = ");
            ((StringBuilder)???).append(this.jdField_f_of_type_Boolean);
            ((StringBuilder)???).append(",frameIndex = ");
            ((StringBuilder)???).append(paramLong);
            QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
          }
          if (!this.jdField_f_of_type_Boolean)
          {
            if ((QLog.isColorLevel()) && (jdField_a_of_type_Boolean))
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("ARFaceTest Send track Face msg frameIdx = ");
              ((StringBuilder)???).append(paramLong);
              QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
            }
            if (jdField_a_of_type_AndroidOsHandler.hasMessages(3)) {
              jdField_a_of_type_AndroidOsHandler.removeMessages(3);
            }
            this.jdField_a_of_type_ComTencentMobileqqArArengineARFacePreviewResample.a(paramArrayOfByte);
            paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArArengineARFacePreviewResample.a();
            this.jdField_b_of_type_Long = paramLong;
            ??? = Message.obtain();
            ((Message)???).what = 3;
            ((Message)???).obj = paramArrayOfByte;
            jdField_a_of_type_AndroidOsHandler.sendMessage((Message)???);
          }
        }
        return;
      }
    }
  }
  
  public void a(ARFacePreviewResample paramARFacePreviewResample)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARFacePreviewResample = paramARFacePreviewResample;
  }
  
  void a(List<ARLocalFaceRecog.FaceInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      paramList.clear();
    }
  }
  
  void a(List<ARLocalFaceRecog.FaceInfo> paramList, ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    if (paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length > 2)
    {
      int j;
      if (paramARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList != null) {
        j = paramARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList.size();
      } else {
        j = 0;
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("filterCloudFaceResult starCount = ");
        ((StringBuilder)localObject1).append(j);
        QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = "";
      if (j > 0)
      {
        Object localObject3 = null;
        localObject1 = null;
        int n;
        int i;
        int k;
        int m;
        if (j == 1)
        {
          ARLocalFaceRecog.FaceInfo localFaceInfo = new ARLocalFaceRecog.FaceInfo();
          n = ((ARCloudRecogRspFaceResult.StarInfo)paramARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int;
          localFaceInfo.jdField_a_of_type_Boolean = true;
          localFaceInfo.jdField_b_of_type_Int = 0;
          localFaceInfo.jdField_a_of_type_ComTencentYTFaceModelFaceStatus = paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[n];
          i = 0;
          while (i < j)
          {
            localObject3 = (ARCloudRecogRspFaceResult.StarInfo)paramARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_a_of_type_Int == n)
            {
              localFaceInfo.jdField_a_of_type_Int = 2;
              localFaceInfo.jdField_a_of_type_JavaLangString = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_a_of_type_JavaLangString;
              localFaceInfo.jdField_b_of_type_JavaLangString = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_b_of_type_JavaLangString;
              localFaceInfo.c = String.valueOf(((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_a_of_type_Long);
              localFaceInfo.d = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).c;
              localFaceInfo.e = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).d;
              localFaceInfo.f = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).e;
              localFaceInfo.jdField_a_of_type_Float = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_a_of_type_Float;
            }
            i += 1;
          }
          k = 0;
          i = 0;
          while (i < paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length)
          {
            m = k;
            localObject3 = localObject1;
            if (i != n)
            {
              if (localObject1 == null) {}
              for (localObject1 = paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];; localObject1 = paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i])
              {
                m = i;
                localObject3 = localObject1;
                break;
                m = k;
                localObject3 = localObject1;
                if (paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].width * paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].height <= ((FaceStatus)localObject1).width * ((FaceStatus)localObject1).height) {
                  break;
                }
              }
            }
            i += 1;
            k = m;
            localObject1 = localObject3;
          }
          if (QLog.isColorLevel())
          {
            paramARCloudRecogRspFaceResult = new StringBuilder();
            paramARCloudRecogRspFaceResult.append("filterCloudFaceResult starCount = ");
            paramARCloudRecogRspFaceResult.append(j);
            paramARCloudRecogRspFaceResult.append(",bigFaceID = ");
            paramARCloudRecogRspFaceResult.append(k);
            QLog.d("AREngine_ARLocalFaceRecog", 2, paramARCloudRecogRspFaceResult.toString());
          }
          paramARCloudRecogRspFaceResult = new ARLocalFaceRecog.FaceInfo();
          paramARCloudRecogRspFaceResult.jdField_a_of_type_Int = 1;
          paramARCloudRecogRspFaceResult.jdField_a_of_type_JavaLangString = ((String)localObject2);
          paramARCloudRecogRspFaceResult.jdField_a_of_type_Boolean = true;
          paramARCloudRecogRspFaceResult.jdField_a_of_type_ComTencentYTFaceModelFaceStatus = ((FaceStatus)localObject1);
          paramARCloudRecogRspFaceResult.jdField_b_of_type_Int = 1;
          paramList.add(localFaceInfo);
          paramList.add(paramARCloudRecogRspFaceResult);
        }
        else if (j == 2)
        {
          localObject1 = new ARLocalFaceRecog.FaceInfo();
          ((ARLocalFaceRecog.FaceInfo)localObject1).jdField_a_of_type_Boolean = true;
          ((ARLocalFaceRecog.FaceInfo)localObject1).jdField_b_of_type_Int = 0;
          ((ARLocalFaceRecog.FaceInfo)localObject1).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[0];
          localObject2 = new ARLocalFaceRecog.FaceInfo();
          ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_Boolean = true;
          ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_b_of_type_Int = 1;
          ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[1];
          i = 0;
          while (i < j)
          {
            localObject3 = (ARCloudRecogRspFaceResult.StarInfo)paramARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_a_of_type_Int == 0)
            {
              ((ARLocalFaceRecog.FaceInfo)localObject1).jdField_a_of_type_Int = 2;
              ((ARLocalFaceRecog.FaceInfo)localObject1).jdField_a_of_type_JavaLangString = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_a_of_type_JavaLangString;
              ((ARLocalFaceRecog.FaceInfo)localObject1).jdField_b_of_type_JavaLangString = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_b_of_type_JavaLangString;
              ((ARLocalFaceRecog.FaceInfo)localObject1).c = String.valueOf(((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_a_of_type_Long);
              ((ARLocalFaceRecog.FaceInfo)localObject1).d = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).c;
              ((ARLocalFaceRecog.FaceInfo)localObject1).e = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).d;
              ((ARLocalFaceRecog.FaceInfo)localObject1).f = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).e;
              ((ARLocalFaceRecog.FaceInfo)localObject1).jdField_a_of_type_Float = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_a_of_type_Float;
            }
            if (((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_a_of_type_Int == 1)
            {
              ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_Int = 2;
              ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_JavaLangString = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_a_of_type_JavaLangString;
              ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_b_of_type_JavaLangString = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_b_of_type_JavaLangString;
              ((ARLocalFaceRecog.FaceInfo)localObject2).c = String.valueOf(((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_a_of_type_Long);
              ((ARLocalFaceRecog.FaceInfo)localObject2).d = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).c;
              ((ARLocalFaceRecog.FaceInfo)localObject2).e = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).d;
              ((ARLocalFaceRecog.FaceInfo)localObject2).f = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).e;
              ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_Float = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).jdField_a_of_type_Float;
            }
            i += 1;
          }
          paramList.add(localObject1);
          paramList.add(localObject2);
        }
        else
        {
          localObject2 = paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[0];
          i = 0;
          k = 0;
          while (i < paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length)
          {
            localObject1 = localObject2;
            if (paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].width * paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].height > ((FaceStatus)localObject2).width * ((FaceStatus)localObject2).height)
            {
              localObject1 = paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
              k = i;
            }
            i += 1;
            localObject2 = localObject1;
          }
          i = 0;
          m = -2;
          localObject1 = localObject3;
          while (i < paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length)
          {
            localObject3 = localObject1;
            n = m;
            if (i != k)
            {
              if (localObject1 == null) {}
              for (localObject1 = paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];; localObject1 = paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i])
              {
                n = i;
                localObject3 = localObject1;
                break;
                localObject3 = localObject1;
                n = m;
                if (paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].width * paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].height <= ((FaceStatus)localObject1).width * ((FaceStatus)localObject1).height) {
                  break;
                }
              }
            }
            i += 1;
            localObject1 = localObject3;
            m = n;
          }
          localObject3 = new ARLocalFaceRecog.FaceInfo();
          ((ARLocalFaceRecog.FaceInfo)localObject3).jdField_a_of_type_Boolean = true;
          ((ARLocalFaceRecog.FaceInfo)localObject3).jdField_b_of_type_Int = 0;
          ((ARLocalFaceRecog.FaceInfo)localObject3).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = ((FaceStatus)localObject2);
          localObject2 = new ARLocalFaceRecog.FaceInfo();
          ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_Boolean = true;
          ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_b_of_type_Int = 1;
          ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = ((FaceStatus)localObject1);
          i = 0;
          while (i < j)
          {
            localObject1 = (ARCloudRecogRspFaceResult.StarInfo)paramARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (((ARCloudRecogRspFaceResult.StarInfo)localObject1).jdField_a_of_type_Int == k)
            {
              ((ARLocalFaceRecog.FaceInfo)localObject3).jdField_a_of_type_Int = 2;
              ((ARLocalFaceRecog.FaceInfo)localObject3).jdField_a_of_type_JavaLangString = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).jdField_a_of_type_JavaLangString;
              ((ARLocalFaceRecog.FaceInfo)localObject3).jdField_b_of_type_JavaLangString = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).jdField_b_of_type_JavaLangString;
              ((ARLocalFaceRecog.FaceInfo)localObject3).c = String.valueOf(((ARCloudRecogRspFaceResult.StarInfo)localObject1).jdField_a_of_type_Long);
              ((ARLocalFaceRecog.FaceInfo)localObject3).d = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).c;
              ((ARLocalFaceRecog.FaceInfo)localObject3).e = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).d;
              ((ARLocalFaceRecog.FaceInfo)localObject3).f = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).e;
              ((ARLocalFaceRecog.FaceInfo)localObject3).jdField_a_of_type_Float = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).jdField_a_of_type_Float;
            }
            if (((ARCloudRecogRspFaceResult.StarInfo)localObject1).jdField_a_of_type_Int == m)
            {
              ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_Int = 2;
              ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_JavaLangString = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).jdField_a_of_type_JavaLangString;
              ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_b_of_type_JavaLangString = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).jdField_b_of_type_JavaLangString;
              ((ARLocalFaceRecog.FaceInfo)localObject2).c = String.valueOf(((ARCloudRecogRspFaceResult.StarInfo)localObject1).jdField_a_of_type_Long);
              ((ARLocalFaceRecog.FaceInfo)localObject2).d = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).c;
              ((ARLocalFaceRecog.FaceInfo)localObject2).e = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).d;
              ((ARLocalFaceRecog.FaceInfo)localObject2).f = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).e;
              ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_Float = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).jdField_a_of_type_Float;
            }
            i += 1;
          }
          if (QLog.isColorLevel())
          {
            paramARCloudRecogRspFaceResult = new StringBuilder();
            paramARCloudRecogRspFaceResult.append("filterCloudFaceResult starCount = ");
            paramARCloudRecogRspFaceResult.append(j);
            paramARCloudRecogRspFaceResult.append(",bigFaceID = ");
            paramARCloudRecogRspFaceResult.append(k);
            paramARCloudRecogRspFaceResult.append(",secondBigFaceID = ");
            paramARCloudRecogRspFaceResult.append(m);
            QLog.d("AREngine_ARLocalFaceRecog", 2, paramARCloudRecogRspFaceResult.toString());
          }
          paramList.add(localObject3);
          paramList.add(localObject2);
        }
      }
      else
      {
        paramARCloudRecogRspFaceResult = a(paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus);
        localObject1 = new ARLocalFaceRecog.FaceInfo();
        ((ARLocalFaceRecog.FaceInfo)localObject1).jdField_a_of_type_Int = 1;
        ((ARLocalFaceRecog.FaceInfo)localObject1).jdField_a_of_type_JavaLangString = "";
        ((ARLocalFaceRecog.FaceInfo)localObject1).jdField_a_of_type_Boolean = true;
        ((ARLocalFaceRecog.FaceInfo)localObject1).jdField_b_of_type_Int = 0;
        if (paramARCloudRecogRspFaceResult != null) {
          ((ARLocalFaceRecog.FaceInfo)localObject1).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = paramARCloudRecogRspFaceResult[0];
        }
        localObject2 = new ARLocalFaceRecog.FaceInfo();
        ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_Int = 1;
        ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_JavaLangString = "";
        ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_Boolean = true;
        ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_b_of_type_Int = 1;
        if (paramARCloudRecogRspFaceResult != null) {
          ((ARLocalFaceRecog.FaceInfo)localObject2).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = paramARCloudRecogRspFaceResult[1];
        }
        paramList.add(localObject1);
        paramList.add(localObject2);
        return;
      }
    }
  }
  
  void a(FaceStatus[] paramArrayOfFaceStatus1, FaceStatus[] paramArrayOfFaceStatus2)
  {
    if (paramArrayOfFaceStatus2 == null) {
      return;
    }
    int k = paramArrayOfFaceStatus2.length;
    int i = 0;
    while (i < k)
    {
      FaceStatus localFaceStatus = paramArrayOfFaceStatus2[i];
      if (paramArrayOfFaceStatus1 != null)
      {
        int m = paramArrayOfFaceStatus1.length;
        int j = 0;
        while ((j < m) && (localFaceStatus != paramArrayOfFaceStatus1[j])) {
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, ARLocalFaceRecog.ARLocalFaceRecogCallback paramARLocalFaceRecogCallback)
  {
    long l = System.currentTimeMillis();
    if (!FaceCluster.useAssetSo)
    {
      boolean bool = FaceScanDownloadManager.a();
      if (bool)
      {
        FaceScanModelsLoader.a(paramContext);
        this.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster = FaceCluster.getInstance();
      }
      else
      {
        FaceScanModelsLoader.jdField_b_of_type_Boolean = false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[ScanStarFace]init ,isResourceReady = ");
        localStringBuilder.append(bool);
        localStringBuilder.append(",FaceScanModelsLoader.hasFaceModelInit = ");
        localStringBuilder.append(FaceScanModelsLoader.jdField_b_of_type_Boolean);
        QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$ARLocalFaceRecogCallback = paramARLocalFaceRecogCallback;
    l = System.currentTimeMillis() - l;
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("[DEBUG_SCAN_yt_face] [ScanStarFace]init result = ");
      paramContext.append(true);
      paramContext.append(",previewWidth = ");
      paramContext.append(paramInt1);
      paramContext.append(",previewHeight = ");
      paramContext.append(paramInt2);
      paramContext.append(",useAssetSo = ");
      paramContext.append(FaceCluster.useAssetSo);
      paramContext.append(",localFaceRecogerInitCost = ");
      paramContext.append(l);
      QLog.d("AREngine_ARLocalFaceRecog", 2, paramContext.toString());
    }
    ARReport.a().g(l, true);
    ARFaceDataCollector.a(l);
    this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo = paramARScanStarFaceConfigInfo;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    return true;
  }
  
  public boolean a(ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[DEBUG_SCAN_yt_face][ScanStarFace]addFaceCloudRecogResult start,faceResult = ");
      localStringBuilder.append(paramARCloudRecogRspFaceResult);
      QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
    }
    this.jdField_d_of_type_Boolean = true;
    long l = System.currentTimeMillis();
    jdField_a_of_type_AndroidOsHandler.post(new ARLocalFaceRecog.3(this, paramARCloudRecogRspFaceResult, l));
    return true;
  }
  
  boolean a(ARLocalFaceRecog.FaceInfo paramFaceInfo, float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2)
  {
    boolean bool2 = paramFaceInfo.jdField_a_of_type_Boolean;
    boolean bool1 = true;
    if (!bool2)
    {
      long l1 = SystemClock.uptimeMillis();
      int i = a(paramArrayOfFloat1, paramFaceInfo.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("recoverSingleFace findFaceIndexByFaceFeature[TimeCost] = ");
        localStringBuilder.append(l2 - l1);
        QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
      }
      if ((i >= 0) && (i < paramArrayOfFloat1.length))
      {
        paramFaceInfo.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = paramArrayOfFloat2[i];
        paramFaceInfo.jdField_a_of_type_Boolean = true;
        break label118;
      }
    }
    bool1 = false;
    label118:
    if (QLog.isColorLevel())
    {
      paramArrayOfFloat1 = new StringBuilder();
      paramArrayOfFloat1.append("recoverSingleFace  result = ");
      paramArrayOfFloat1.append(bool1);
      paramArrayOfFloat1.append(",faceInfo = ");
      paramArrayOfFloat1.append(paramFaceInfo);
      QLog.d("AREngine_ARLocalFaceRecog", 2, paramArrayOfFloat1.toString());
    }
    return bool1;
  }
  
  boolean a(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    Object localObject;
    if (!bool3)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo;
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((ARScanStarFaceConfigInfo)localObject).a != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a.length > 0)
          {
            int j = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a.length;
            for (bool1 = false; i < j; bool1 = bool2)
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a[i];
              long l = NetConnInfoCenter.getServerTimeMillis();
              bool2 = bool1;
              if (localObject != null)
              {
                bool2 = bool1;
                if (paramString.equals(((ARScanStarFaceActInfo)localObject).jdField_b_of_type_JavaLangString))
                {
                  bool2 = bool1;
                  if (l > ((ARScanStarFaceActInfo)localObject).jdField_a_of_type_Long)
                  {
                    bool2 = bool1;
                    if (l < ((ARScanStarFaceActInfo)localObject).jdField_b_of_type_Long) {
                      bool2 = true;
                    }
                  }
                }
              }
              i += 1;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[ScanStarFace]hasStarActivity result = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("starUin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  boolean a(List<ARLocalFaceRecog.FaceInfo> paramList)
  {
    paramList = paramList.iterator();
    for (boolean bool = true;; bool = false)
    {
      if (!paramList.hasNext()) {
        return bool;
      }
      ARLocalFaceRecog.FaceInfo localFaceInfo = (ARLocalFaceRecog.FaceInfo)paramList.next();
      if ((bool) && (localFaceInfo.jdField_a_of_type_Boolean)) {
        break;
      }
    }
    return bool;
  }
  
  boolean a(List<ARLocalFaceRecog.FaceInfo> paramList, FaceStatus paramFaceStatus)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList != null)
    {
      bool1 = bool2;
      if (paramList.size() > 0)
      {
        paramList = paramList.iterator();
        bool1 = false;
        while (paramList.hasNext())
        {
          Object localObject = (ARLocalFaceRecog.FaceInfo)paramList.next();
          if (((ARLocalFaceRecog.FaceInfo)localObject).jdField_a_of_type_Boolean)
          {
            int i = Math.abs(((ARLocalFaceRecog.FaceInfo)localObject).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x + ((ARLocalFaceRecog.FaceInfo)localObject).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.width / 2 - (paramFaceStatus.x + paramFaceStatus.width / 2));
            int j = Math.abs(((ARLocalFaceRecog.FaceInfo)localObject).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y + ((ARLocalFaceRecog.FaceInfo)localObject).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.height / 2 - (paramFaceStatus.y + paramFaceStatus.height / 2));
            int k = Math.min(((ARLocalFaceRecog.FaceInfo)localObject).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.width / 2, paramFaceStatus.width / 2);
            int m = Math.min(((ARLocalFaceRecog.FaceInfo)localObject).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.height / 2, paramFaceStatus.height / 2);
            if ((i < k) && (j < m)) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(" shouldFilterTmpFace,distanceX = ");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(",distanceY = ");
              ((StringBuilder)localObject).append(j);
              ((StringBuilder)localObject).append(",w = ");
              ((StringBuilder)localObject).append(k);
              ((StringBuilder)localObject).append(",h = ");
              ((StringBuilder)localObject).append(m);
              QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append(" shouldFilterTmpFace,result = ");
      paramList.append(bool1);
      QLog.d("AREngine_ARLocalFaceRecog", 2, paramList.toString());
    }
    return bool1;
  }
  
  FaceStatus[] a(FaceStatus[] paramArrayOfFaceStatus)
  {
    FaceStatus[] arrayOfFaceStatus;
    if ((paramArrayOfFaceStatus != null) && (paramArrayOfFaceStatus.length > 0))
    {
      arrayOfFaceStatus = paramArrayOfFaceStatus;
      if (paramArrayOfFaceStatus.length > 2)
      {
        arrayOfFaceStatus = new FaceStatus[2];
        int m = 0;
        arrayOfFaceStatus[0] = paramArrayOfFaceStatus[0];
        int i = 0;
        int j = 0;
        while (i < paramArrayOfFaceStatus.length)
        {
          if (paramArrayOfFaceStatus[i].width * paramArrayOfFaceStatus[i].height > arrayOfFaceStatus[0].width * arrayOfFaceStatus[0].height)
          {
            arrayOfFaceStatus[0] = paramArrayOfFaceStatus[i];
            j = i;
          }
          i += 1;
        }
        int k = -2;
        i = m;
        while (i < paramArrayOfFaceStatus.length)
        {
          m = k;
          if (i != j)
          {
            if (arrayOfFaceStatus[1] == null)
            {
              arrayOfFaceStatus[1] = paramArrayOfFaceStatus[i];
            }
            else
            {
              m = k;
              if (paramArrayOfFaceStatus[i].width * paramArrayOfFaceStatus[i].height <= arrayOfFaceStatus[1].width * arrayOfFaceStatus[1].height) {
                break label175;
              }
              arrayOfFaceStatus[1] = paramArrayOfFaceStatus[i];
            }
            m = i;
          }
          label175:
          i += 1;
          k = m;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("filterLocalDetectFace  bigFaceID = ");
          localStringBuilder.append(j);
          localStringBuilder.append(",secondBigFaceID = ");
          localStringBuilder.append(k);
          localStringBuilder.append(",faceCount = ");
          localStringBuilder.append(paramArrayOfFaceStatus.length);
          QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
        }
        return arrayOfFaceStatus;
      }
    }
    else
    {
      arrayOfFaceStatus = null;
    }
    return arrayOfFaceStatus;
  }
  
  public void b()
  {
    QLog.d("AREngine_ARLocalFaceRecog", 1, "[ScanStarFace] uninit");
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    FaceScanModelsLoader.a();
    QLog.d("AREngine_ARLocalFaceRecog", 1, "[ScanStarFace] uninit finish");
  }
  
  void b(List<ARLocalFaceRecog.FaceInfo> paramList, ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    paramARCloudRecogRspFaceResult = paramARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus;
    int j = paramARCloudRecogRspFaceResult.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramARCloudRecogRspFaceResult[i];
      Iterator localIterator = paramList.iterator();
      while ((localIterator.hasNext()) && (((ARLocalFaceRecog.FaceInfo)localIterator.next()).jdField_a_of_type_ComTencentYTFaceModelFaceStatus != localObject)) {}
      i += 1;
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ScanStarFace] start ,mIsStarted = ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("ARLocalFaceRecog");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    }
    if (this.jdField_b_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("ARLocalFaceRecog_exFeature");
      this.jdField_b_of_type_AndroidOsHandlerThread.start();
      this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    return true;
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[ScanStarFace] pause ,mIsPause = ");
      ((StringBuilder)???).append(this.jdField_c_of_type_Boolean);
      QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
    }
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      a(this.jdField_a_of_type_JavaUtilList);
      a(this.jdField_b_of_type_JavaUtilList);
      this.jdField_f_of_type_Int = 10;
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_Long > 0L)
      {
        ARFaceDataCollector.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, this.jdField_d_of_type_Int);
        this.jdField_a_of_type_Long = 0L;
        this.jdField_d_of_type_Int = 0;
      }
      return;
    }
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ScanStarFace] resume ,mIsPause = ");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
    }
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_d_of_type_Int = 0;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[ScanStarFace] stop,mIsStarted = ");
      ((StringBuilder)???).append(this.jdField_b_of_type_Boolean);
      QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      a(this.jdField_a_of_type_JavaUtilList);
      a(this.jdField_b_of_type_JavaUtilList);
      this.jdField_f_of_type_Int = 10;
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      jdField_a_of_type_AndroidOsHandler = null;
      this.jdField_b_of_type_AndroidOsHandlerThread.quit();
      this.jdField_b_of_type_AndroidOsHandlerThread = null;
      this.jdField_b_of_type_AndroidOsHandler = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog
 * JD-Core Version:    0.7.0.1
 */