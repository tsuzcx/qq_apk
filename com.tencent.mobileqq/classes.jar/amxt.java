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
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceActInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARFacePreviewResample;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.3;
import com.tencent.mobileqq.armap.ARMapTracer;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class amxt
{
  public static Handler a;
  public static boolean a;
  public int a;
  long jdField_a_of_type_Long;
  public amxf a;
  amxv jdField_a_of_type_Amxv;
  public Context a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new amxu(this);
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public FaceCluster a;
  ARScanStarFaceConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo;
  private ARFacePreviewResample jdField_a_of_type_ComTencentMobileqqArArengineARFacePreviewResample;
  public Object a;
  public List<amxw> a;
  public int b;
  long jdField_b_of_type_Long;
  Handler jdField_b_of_type_AndroidOsHandler;
  HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  public List<amxw> b;
  volatile boolean jdField_b_of_type_Boolean;
  public int c;
  public long c;
  public volatile boolean c;
  int d;
  public volatile boolean d;
  final int e;
  public volatile boolean e;
  public int f;
  volatile boolean f;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public amxt()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_Long = -1L;
    this.jdField_e_of_type_Int = 10;
    this.jdField_f_of_type_Int = 10;
    this.jdField_c_of_type_Int = 90;
    if (azcw.d(azcw.g)) {
      this.jdField_c_of_type_Int = 270;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "ARLocalFaceRecog  rotateDegree = " + this.jdField_c_of_type_Int);
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (Build.MODEL.equals("vivo X6Plus A")) {
      bool = true;
    }
    if (ARMapTracer.a() == 3) {
      return true;
    }
    return bool;
  }
  
  public int a(float[][] paramArrayOfFloat, float[] paramArrayOfFloat1)
  {
    int k = paramArrayOfFloat.length;
    float[] arrayOfFloat = new float[k];
    int i = 0;
    if (i < k)
    {
      if (paramArrayOfFloat[i] != null) {
        arrayOfFloat[i] = this.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuSimilarity(paramArrayOfFloat[i], paramArrayOfFloat1);
      }
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "findFaceIndexByFaceFeature2 faceFeature is null,i = " + i);
        }
      }
    }
    float f1 = arrayOfFloat[0];
    i = 0;
    int j = -1;
    while (i < k)
    {
      float f2 = f1;
      if (arrayOfFloat[i] >= f1)
      {
        f2 = arrayOfFloat[i];
        j = i;
      }
      i += 1;
      f1 = f2;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "findFaceIndexByFaceFeature targetFaceFeature = " + Arrays.toString(paramArrayOfFloat1));
      QLog.d("AREngine_ARLocalFaceRecog", 2, "findFaceIndexByFaceFeature newFaceFeature = " + Arrays.toString(paramArrayOfFloat[0]));
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "findFaceIndexByFaceFeature2 index = " + j + ",finalSimilarity = " + f1);
    }
    if ((!Float.isNaN(f1)) || (f1 < 0.5D)) {
      j = -1;
    }
    return j;
  }
  
  ARScanStarFaceActInfo a(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject3;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject2 = localObject3;
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo != null)
      {
        localObject2 = localObject3;
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a != null)
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a.length > 0)
          {
            int j = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a.length;
            i = 0;
            localObject2 = localObject1;
            if (i < j)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a[i];
              if ((localObject2 == null) || (!paramString.equals(((ARScanStarFaceActInfo)localObject2).jdField_b_of_type_JavaLangString))) {
                break label119;
              }
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    label119:
    for (;;)
    {
      i += 1;
      break;
      return localObject2;
    }
  }
  
  public void a()
  {
    boolean bool = amtb.a();
    if (bool)
    {
      amtd.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster = FaceCluster.getInstance();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]notifyResourceDownloadFinish ,isResourceReady = " + bool + ",FaceScanModelsLoader.hasFaceModelInit = " + amtd.jdField_b_of_type_Boolean);
      }
      return;
      amtd.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (!amtd.jdField_b_of_type_Boolean)) {}
    do
    {
      for (;;)
      {
        return;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          int i = this.jdField_a_of_type_JavaUtilList.size();
          if ((QLog.isColorLevel()) && (jdField_a_of_type_Boolean)) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "onPreviewFrame totalFaceSize = " + i);
          }
          if (i == 0)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("AREngine_ARLocalFaceRecog", 2, "ARFaceTest onPreviewFrame totalFaceSize is 0,frameIdx = " + paramLong + ",isPreparingData = " + this.jdField_d_of_type_Boolean);
          }
        }
      }
      if ((QLog.isColorLevel()) && (jdField_a_of_type_Boolean)) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, " Try to track Face, isTracking = " + this.jdField_f_of_type_Boolean + ",frameIndex = " + paramLong);
      }
    } while (this.jdField_f_of_type_Boolean);
    if ((QLog.isColorLevel()) && (jdField_a_of_type_Boolean)) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "ARFaceTest Send track Face msg frameIdx = " + paramLong);
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
  
  public void a(ARFacePreviewResample paramARFacePreviewResample)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARFacePreviewResample = paramARFacePreviewResample;
  }
  
  public void a(List<amxw> paramList, amxf paramamxf)
  {
    Object localObject2 = null;
    int i = 0;
    int n = 0;
    int j = 0;
    if (paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length > 2) {
      if (paramamxf.jdField_a_of_type_JavaUtilArrayList == null) {
        break label1386;
      }
    }
    label306:
    label1383:
    label1386:
    for (int k = paramamxf.jdField_a_of_type_JavaUtilArrayList.size();; k = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "filterCloudFaceResult starCount = " + k);
      }
      Object localObject3;
      Object localObject1;
      int m;
      if (k > 0)
      {
        if (k == 1)
        {
          localObject3 = new amxw();
          n = ((amxg)paramamxf.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int;
          ((amxw)localObject3).jdField_a_of_type_Boolean = true;
          ((amxw)localObject3).jdField_b_of_type_Int = 0;
          ((amxw)localObject3).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[n];
          i = 0;
          while (i < k)
          {
            localObject1 = (amxg)paramamxf.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (((amxg)localObject1).jdField_a_of_type_Int == n)
            {
              ((amxw)localObject3).jdField_a_of_type_Int = 2;
              ((amxw)localObject3).jdField_a_of_type_JavaLangString = ((amxg)localObject1).jdField_a_of_type_JavaLangString;
              ((amxw)localObject3).jdField_b_of_type_JavaLangString = ((amxg)localObject1).jdField_b_of_type_JavaLangString;
              ((amxw)localObject3).c = String.valueOf(((amxg)localObject1).jdField_a_of_type_Long);
              ((amxw)localObject3).d = ((amxg)localObject1).c;
              ((amxw)localObject3).e = ((amxg)localObject1).d;
              ((amxw)localObject3).f = ((amxg)localObject1).e;
              ((amxw)localObject3).jdField_a_of_type_Float = ((amxg)localObject1).jdField_a_of_type_Float;
            }
            i += 1;
          }
          m = 0;
          i = j;
          if (i < paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length)
          {
            j = m;
            localObject1 = localObject2;
            if (i != n)
            {
              if (localObject2 != null) {
                break label306;
              }
              localObject1 = paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
              j = i;
            }
            for (;;)
            {
              i += 1;
              m = j;
              localObject2 = localObject1;
              break;
              j = m;
              localObject1 = localObject2;
              if (paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].width * paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].height > ((FaceStatus)localObject2).width * ((FaceStatus)localObject2).height)
              {
                localObject1 = paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
                j = i;
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "filterCloudFaceResult starCount = " + k + ",bigFaceID = " + m);
          }
          paramamxf = new amxw();
          paramamxf.jdField_a_of_type_Int = 1;
          paramamxf.jdField_a_of_type_JavaLangString = "";
          paramamxf.jdField_a_of_type_Boolean = true;
          paramamxf.jdField_a_of_type_ComTencentYTFaceModelFaceStatus = ((FaceStatus)localObject2);
          paramamxf.jdField_b_of_type_Int = 1;
          paramList.add(localObject3);
          paramList.add(paramamxf);
          return;
        }
        if (k == 2)
        {
          localObject1 = new amxw();
          ((amxw)localObject1).jdField_a_of_type_Boolean = true;
          ((amxw)localObject1).jdField_b_of_type_Int = 0;
          ((amxw)localObject1).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[0];
          localObject2 = new amxw();
          ((amxw)localObject2).jdField_a_of_type_Boolean = true;
          ((amxw)localObject2).jdField_b_of_type_Int = 1;
          ((amxw)localObject2).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[1];
          while (i < k)
          {
            localObject3 = (amxg)paramamxf.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (((amxg)localObject3).jdField_a_of_type_Int == 0)
            {
              ((amxw)localObject1).jdField_a_of_type_Int = 2;
              ((amxw)localObject1).jdField_a_of_type_JavaLangString = ((amxg)localObject3).jdField_a_of_type_JavaLangString;
              ((amxw)localObject1).jdField_b_of_type_JavaLangString = ((amxg)localObject3).jdField_b_of_type_JavaLangString;
              ((amxw)localObject1).c = String.valueOf(((amxg)localObject3).jdField_a_of_type_Long);
              ((amxw)localObject1).d = ((amxg)localObject3).c;
              ((amxw)localObject1).e = ((amxg)localObject3).d;
              ((amxw)localObject1).f = ((amxg)localObject3).e;
              ((amxw)localObject1).jdField_a_of_type_Float = ((amxg)localObject3).jdField_a_of_type_Float;
            }
            if (((amxg)localObject3).jdField_a_of_type_Int == 1)
            {
              ((amxw)localObject2).jdField_a_of_type_Int = 2;
              ((amxw)localObject2).jdField_a_of_type_JavaLangString = ((amxg)localObject3).jdField_a_of_type_JavaLangString;
              ((amxw)localObject2).jdField_b_of_type_JavaLangString = ((amxg)localObject3).jdField_b_of_type_JavaLangString;
              ((amxw)localObject2).c = String.valueOf(((amxg)localObject3).jdField_a_of_type_Long);
              ((amxw)localObject2).d = ((amxg)localObject3).c;
              ((amxw)localObject2).e = ((amxg)localObject3).d;
              ((amxw)localObject2).f = ((amxg)localObject3).e;
              ((amxw)localObject2).jdField_a_of_type_Float = ((amxg)localObject3).jdField_a_of_type_Float;
            }
            i += 1;
          }
          paramList.add(localObject1);
          paramList.add(localObject2);
          return;
        }
        localObject2 = paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[0];
        m = 0;
        i = 0;
        while (i < paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length)
        {
          localObject1 = localObject2;
          if (paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].width * paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].height > ((FaceStatus)localObject2).width * ((FaceStatus)localObject2).height)
          {
            localObject1 = paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
            m = i;
          }
          i += 1;
          localObject2 = localObject1;
        }
        j = -2;
        localObject1 = null;
        i = 0;
        if (i < paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length)
        {
          if (i == m) {
            break label1383;
          }
          if (localObject1 == null)
          {
            localObject1 = paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
            j = i;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].width * paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].height > ((FaceStatus)localObject1).width * ((FaceStatus)localObject1).height)
        {
          localObject1 = paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
          j = i;
          continue;
          localObject3 = new amxw();
          ((amxw)localObject3).jdField_a_of_type_Boolean = true;
          ((amxw)localObject3).jdField_b_of_type_Int = 0;
          ((amxw)localObject3).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = ((FaceStatus)localObject2);
          localObject2 = new amxw();
          ((amxw)localObject2).jdField_a_of_type_Boolean = true;
          ((amxw)localObject2).jdField_b_of_type_Int = 1;
          ((amxw)localObject2).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = ((FaceStatus)localObject1);
          i = n;
          while (i < k)
          {
            localObject1 = (amxg)paramamxf.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (((amxg)localObject1).jdField_a_of_type_Int == m)
            {
              ((amxw)localObject3).jdField_a_of_type_Int = 2;
              ((amxw)localObject3).jdField_a_of_type_JavaLangString = ((amxg)localObject1).jdField_a_of_type_JavaLangString;
              ((amxw)localObject3).jdField_b_of_type_JavaLangString = ((amxg)localObject1).jdField_b_of_type_JavaLangString;
              ((amxw)localObject3).c = String.valueOf(((amxg)localObject1).jdField_a_of_type_Long);
              ((amxw)localObject3).d = ((amxg)localObject1).c;
              ((amxw)localObject3).e = ((amxg)localObject1).d;
              ((amxw)localObject3).f = ((amxg)localObject1).e;
              ((amxw)localObject3).jdField_a_of_type_Float = ((amxg)localObject1).jdField_a_of_type_Float;
            }
            if (((amxg)localObject1).jdField_a_of_type_Int == j)
            {
              ((amxw)localObject2).jdField_a_of_type_Int = 2;
              ((amxw)localObject2).jdField_a_of_type_JavaLangString = ((amxg)localObject1).jdField_a_of_type_JavaLangString;
              ((amxw)localObject2).jdField_b_of_type_JavaLangString = ((amxg)localObject1).jdField_b_of_type_JavaLangString;
              ((amxw)localObject2).c = String.valueOf(((amxg)localObject1).jdField_a_of_type_Long);
              ((amxw)localObject2).d = ((amxg)localObject1).c;
              ((amxw)localObject2).e = ((amxg)localObject1).d;
              ((amxw)localObject2).f = ((amxg)localObject1).e;
              ((amxw)localObject2).jdField_a_of_type_Float = ((amxg)localObject1).jdField_a_of_type_Float;
            }
            i += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "filterCloudFaceResult starCount = " + k + ",bigFaceID = " + m + ",secondBigFaceID = " + j);
          }
          paramList.add(localObject3);
          paramList.add(localObject2);
          return;
          paramamxf = a(paramamxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus);
          localObject1 = new amxw();
          ((amxw)localObject1).jdField_a_of_type_Int = 1;
          ((amxw)localObject1).jdField_a_of_type_JavaLangString = "";
          ((amxw)localObject1).jdField_a_of_type_Boolean = true;
          ((amxw)localObject1).jdField_b_of_type_Int = 0;
          if (paramamxf != null) {
            ((amxw)localObject1).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = paramamxf[0];
          }
          localObject2 = new amxw();
          ((amxw)localObject2).jdField_a_of_type_Int = 1;
          ((amxw)localObject2).jdField_a_of_type_JavaLangString = "";
          ((amxw)localObject2).jdField_a_of_type_Boolean = true;
          ((amxw)localObject2).jdField_b_of_type_Int = 1;
          if (paramamxf != null) {
            ((amxw)localObject2).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = paramamxf[1];
          }
          paramList.add(localObject1);
          paramList.add(localObject2);
          return;
        }
      }
    }
  }
  
  public boolean a(amxf paramamxf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face][ScanStarFace]addFaceCloudRecogResult start,faceResult = " + paramamxf);
    }
    this.jdField_d_of_type_Boolean = true;
    long l = System.currentTimeMillis();
    jdField_a_of_type_AndroidOsHandler.post(new ARLocalFaceRecog.3(this, paramamxf, l));
    return true;
  }
  
  public boolean a(amxw paramamxw, float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2)
  {
    boolean bool = true;
    if (!paramamxw.jdField_a_of_type_Boolean)
    {
      long l1 = SystemClock.uptimeMillis();
      int i = a(paramArrayOfFloat1, paramamxw.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "recoverSingleFace findFaceIndexByFaceFeature[TimeCost] = " + (l2 - l1));
      }
      if ((i >= 0) && (i < paramArrayOfFloat1.length))
      {
        paramamxw.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = paramArrayOfFloat2[i];
        paramamxw.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "recoverSingleFace  result = " + bool + ",faceInfo = " + paramamxw);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, amxv paramamxv)
  {
    long l = System.currentTimeMillis();
    if (FaceCluster.useAssetSo) {}
    label221:
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_Amxv = paramamxv;
      l = System.currentTimeMillis() - l;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face] [ScanStarFace]init result = " + true + ",previewWidth = " + paramInt1 + ",previewHeight = " + paramInt2 + ",useAssetSo = " + FaceCluster.useAssetSo + ",localFaceRecogerInitCost = " + l);
      }
      amzf.a().g(l, true);
      amxq.a(l);
      this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo = paramARScanStarFaceConfigInfo;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      return true;
      boolean bool = amtb.a();
      if (bool)
      {
        amtd.a(paramContext);
        this.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster = FaceCluster.getInstance();
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label221;
        }
        QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]init ,isResourceReady = " + bool + ",FaceScanModelsLoader.hasFaceModelInit = " + amtd.jdField_b_of_type_Boolean);
        break;
        amtd.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  boolean a(String paramString)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (!TextUtils.isEmpty(paramString))
    {
      bool2 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo != null)
      {
        bool2 = bool3;
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a != null)
        {
          bool2 = bool3;
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a.length > 0)
          {
            int j = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a.length;
            int i = 0;
            for (;;)
            {
              bool2 = bool1;
              if (i >= j) {
                break;
              }
              ARScanStarFaceActInfo localARScanStarFaceActInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a[i];
              long l = NetConnInfoCenter.getServerTimeMillis();
              bool2 = bool1;
              if (localARScanStarFaceActInfo != null)
              {
                bool2 = bool1;
                if (paramString.equals(localARScanStarFaceActInfo.jdField_b_of_type_JavaLangString))
                {
                  bool2 = bool1;
                  if (l > localARScanStarFaceActInfo.jdField_a_of_type_Long)
                  {
                    bool2 = bool1;
                    if (l < localARScanStarFaceActInfo.jdField_b_of_type_Long) {
                      bool2 = true;
                    }
                  }
                }
              }
              i += 1;
              bool1 = bool2;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]hasStarActivity result = " + bool2 + "starUin = " + paramString);
    }
    return bool2;
  }
  
  public boolean a(List<amxw> paramList)
  {
    paramList = paramList.iterator();
    boolean bool = true;
    if (paramList.hasNext())
    {
      amxw localamxw = (amxw)paramList.next();
      if ((bool) && (localamxw.jdField_a_of_type_Boolean)) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  boolean a(List<amxw> paramList, FaceStatus paramFaceStatus)
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
        if (paramList.hasNext())
        {
          amxw localamxw = (amxw)paramList.next();
          if (!localamxw.jdField_a_of_type_Boolean) {
            break label313;
          }
          int i = Math.abs(localamxw.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x + localamxw.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.width / 2 - (paramFaceStatus.x + paramFaceStatus.width / 2));
          int j = Math.abs(localamxw.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y + localamxw.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.height / 2 - (paramFaceStatus.y + paramFaceStatus.height / 2));
          int k = Math.min(localamxw.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.width / 2, paramFaceStatus.width / 2);
          int m = Math.min(localamxw.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.height / 2, paramFaceStatus.height / 2);
          if ((i < k) && (j < m))
          {
            bool1 = true;
            label191:
            bool2 = bool1;
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, " shouldFilterTmpFace,distanceX = " + i + ",distanceY = " + j + ",w = " + k + ",h = " + m);
            }
          }
        }
      }
    }
    label313:
    for (bool2 = bool1;; bool2 = bool1)
    {
      bool1 = bool2;
      break;
      bool1 = false;
      break label191;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, " shouldFilterTmpFace,result = " + bool1);
      }
      return bool1;
    }
  }
  
  FaceStatus[] a(FaceStatus[] paramArrayOfFaceStatus)
  {
    int j = 0;
    if ((paramArrayOfFaceStatus != null) && (paramArrayOfFaceStatus.length > 0))
    {
      FaceStatus[] arrayOfFaceStatus = paramArrayOfFaceStatus;
      if (paramArrayOfFaceStatus.length > 2)
      {
        arrayOfFaceStatus = new FaceStatus[2];
        arrayOfFaceStatus[0] = paramArrayOfFaceStatus[0];
        int i = 0;
        int k = 0;
        while (i < paramArrayOfFaceStatus.length)
        {
          if (paramArrayOfFaceStatus[i].width * paramArrayOfFaceStatus[i].height > arrayOfFaceStatus[0].width * arrayOfFaceStatus[0].height)
          {
            arrayOfFaceStatus[0] = paramArrayOfFaceStatus[i];
            k = i;
          }
          i += 1;
        }
        int m = -2;
        i = j;
        if (i < paramArrayOfFaceStatus.length)
        {
          j = m;
          if (i != k)
          {
            if (arrayOfFaceStatus[1] != null) {
              break label139;
            }
            arrayOfFaceStatus[1] = paramArrayOfFaceStatus[i];
            j = i;
          }
          for (;;)
          {
            i += 1;
            m = j;
            break;
            label139:
            j = m;
            if (paramArrayOfFaceStatus[i].width * paramArrayOfFaceStatus[i].height > arrayOfFaceStatus[1].width * arrayOfFaceStatus[1].height)
            {
              arrayOfFaceStatus[1] = paramArrayOfFaceStatus[i];
              j = i;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "filterLocalDetectFace  bigFaceID = " + k + ",secondBigFaceID = " + m + ",faceCount = " + paramArrayOfFaceStatus.length);
        }
      }
      return arrayOfFaceStatus;
    }
    return null;
  }
  
  public void b()
  {
    QLog.d("AREngine_ARLocalFaceRecog", 1, "[ScanStarFace] uninit");
    if (jdField_a_of_type_AndroidOsHandler != null) {
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    QLog.d("AREngine_ARLocalFaceRecog", 1, "[ScanStarFace] uninit finish");
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace] start ,mIsStarted = " + this.jdField_b_of_type_Boolean);
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
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace] pause ,mIsPause = " + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_Boolean = true;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_f_of_type_Int = 10;
        jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (this.jdField_a_of_type_Long <= 0L) {
          continue;
        }
        amxq.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, this.jdField_d_of_type_Int);
        this.jdField_a_of_type_Long = 0L;
        this.jdField_d_of_type_Int = 0;
        return;
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace] resume ,mIsPause = " + this.jdField_c_of_type_Boolean);
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
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace] stop,mIsStarted = " + this.jdField_b_of_type_Boolean);
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxt
 * JD-Core Version:    0.7.0.1
 */