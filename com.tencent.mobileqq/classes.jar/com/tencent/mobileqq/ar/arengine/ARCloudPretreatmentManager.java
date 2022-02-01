package com.tencent.mobileqq.ar.arengine;

import android.graphics.YuvImage;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.ar.FaceScanModelsLoader;
import com.tencent.mobileqq.ar.arcloud.ARCloudImageProc;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

public class ARCloudPretreatmentManager
{
  public static int a = 0;
  public static int b = -1;
  private byte[] c = null;
  private int d = 0;
  private String e = "";
  
  /* Error */
  private void a(String paramString1, String paramString2, byte[] paramArrayOfByte, YuvImage paramYuvImage)
  {
    // Byte code:
    //   0: new 35	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: new 40	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   17: astore 6
    //   19: aload 6
    //   21: aload_1
    //   22: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 6
    //   28: aload_2
    //   29: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: new 35	java/io/File
    //   36: dup
    //   37: aload 6
    //   39: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_1
    //   46: aload 5
    //   48: invokevirtual 53	java/io/File:exists	()Z
    //   51: ifne +9 -> 60
    //   54: aload 5
    //   56: invokevirtual 56	java/io/File:mkdirs	()Z
    //   59: pop
    //   60: aload_1
    //   61: invokevirtual 53	java/io/File:exists	()Z
    //   64: ifne +16 -> 80
    //   67: aload_1
    //   68: invokevirtual 59	java/io/File:createNewFile	()Z
    //   71: pop
    //   72: goto +8 -> 80
    //   75: astore_2
    //   76: aload_2
    //   77: invokevirtual 62	java/io/IOException:printStackTrace	()V
    //   80: new 64	java/io/FileOutputStream
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 67	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   88: astore_2
    //   89: aload_3
    //   90: ifnull +13 -> 103
    //   93: aload_2
    //   94: astore_1
    //   95: aload_2
    //   96: aload_3
    //   97: invokevirtual 71	java/io/FileOutputStream:write	([B)V
    //   100: goto +38 -> 138
    //   103: aload 4
    //   105: ifnull +33 -> 138
    //   108: aload_2
    //   109: astore_1
    //   110: aload 4
    //   112: new 73	android/graphics/Rect
    //   115: dup
    //   116: iconst_0
    //   117: iconst_0
    //   118: aload 4
    //   120: invokevirtual 79	android/graphics/YuvImage:getWidth	()I
    //   123: aload 4
    //   125: invokevirtual 82	android/graphics/YuvImage:getHeight	()I
    //   128: invokespecial 85	android/graphics/Rect:<init>	(IIII)V
    //   131: bipush 50
    //   133: aload_2
    //   134: invokevirtual 89	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   137: pop
    //   138: aload_2
    //   139: astore_1
    //   140: aload_2
    //   141: invokevirtual 92	java/io/FileOutputStream:flush	()V
    //   144: aload_2
    //   145: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   148: return
    //   149: astore_1
    //   150: aconst_null
    //   151: astore_2
    //   152: goto +50 -> 202
    //   155: astore_3
    //   156: aconst_null
    //   157: astore_2
    //   158: aload_2
    //   159: astore_1
    //   160: aload_3
    //   161: invokevirtual 62	java/io/IOException:printStackTrace	()V
    //   164: aload_2
    //   165: ifnull +31 -> 196
    //   168: aload_2
    //   169: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   172: return
    //   173: astore_3
    //   174: aconst_null
    //   175: astore_2
    //   176: aload_2
    //   177: astore_1
    //   178: aload_3
    //   179: invokevirtual 96	java/io/FileNotFoundException:printStackTrace	()V
    //   182: aload_2
    //   183: ifnull +13 -> 196
    //   186: aload_2
    //   187: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   190: return
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 62	java/io/IOException:printStackTrace	()V
    //   196: return
    //   197: astore_3
    //   198: aload_1
    //   199: astore_2
    //   200: aload_3
    //   201: astore_1
    //   202: aload_2
    //   203: ifnull +15 -> 218
    //   206: aload_2
    //   207: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   210: goto +8 -> 218
    //   213: astore_2
    //   214: aload_2
    //   215: invokevirtual 62	java/io/IOException:printStackTrace	()V
    //   218: aload_1
    //   219: athrow
    //   220: astore_3
    //   221: goto -63 -> 158
    //   224: astore_3
    //   225: goto -49 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	ARCloudPretreatmentManager
    //   0	228	1	paramString1	String
    //   0	228	2	paramString2	String
    //   0	228	3	paramArrayOfByte	byte[]
    //   0	228	4	paramYuvImage	YuvImage
    //   8	47	5	localFile	File
    //   17	21	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   67	72	75	java/io/IOException
    //   80	89	149	finally
    //   80	89	155	java/io/IOException
    //   80	89	173	java/io/FileNotFoundException
    //   144	148	191	java/io/IOException
    //   168	172	191	java/io/IOException
    //   186	190	191	java/io/IOException
    //   95	100	197	finally
    //   110	138	197	finally
    //   140	144	197	finally
    //   160	164	197	finally
    //   178	182	197	finally
    //   206	210	213	java/io/IOException
    //   95	100	220	java/io/IOException
    //   110	138	220	java/io/IOException
    //   140	144	220	java/io/IOException
    //   95	100	224	java/io/FileNotFoundException
    //   110	138	224	java/io/FileNotFoundException
    //   140	144	224	java/io/FileNotFoundException
  }
  
  private String c()
  {
    String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilteredImg");
    localStringBuilder.append(str);
    localStringBuilder.append(".jpg");
    return localStringBuilder.toString();
  }
  
  private void d()
  {
    QLog.i("AREngine_ARCloudPretreatmentManagert", 1, "delete backup file.");
    File[] arrayOfFile = new File(this.e).listFiles();
    if (arrayOfFile != null)
    {
      int i = 0;
      while (i < arrayOfFile.length)
      {
        File localFile = arrayOfFile[i];
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ArConfigUtils.a());
    localStringBuilder.append("ar_cloud_img/");
    this.e = localStringBuilder.toString();
    ARCloudImageProc.nativeInit();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ARCloudPretreatmentManager mImgDir = ");
      localStringBuilder.append(this.e);
      QLog.i("AREngine_ARCloudPretreatmentManagert", 2, localStringBuilder.toString());
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ARRecognition paramARRecognition, ARCloudPretreatmentManager.ARCloudPretreatmentCallback paramARCloudPretreatmentCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[ScanStarFace]pretreatFaceRecogInfo,  FaceScanModelsLoader.hasFaceModelInit =  ");
      ((StringBuilder)localObject).append(FaceScanModelsLoader.b);
      QLog.d("AREngine_ARCloudPretreatmentManagert", 2, ((StringBuilder)localObject).toString());
    }
    if (FaceScanModelsLoader.c)
    {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "pretreatFaceRecogInfo,return for releasing");
      return;
    }
    if (!FaceScanModelsLoader.b)
    {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "pretreatFaceRecogInfo,return1 FaceModel not init!");
      return;
    }
    Object localObject = new ARCloudRecogReqFaceInfo();
    ((ARCloudRecogReqFaceInfo)localObject).a = ((int)paramARRecognition.e);
    FaceCluster localFaceCluster = FaceCluster.getInstance();
    long l1 = SystemClock.uptimeMillis();
    if (!FaceScanModelsLoader.b)
    {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "pretreatFaceRecogInfo,return2 FaceModel not init!");
      return;
    }
    paramARRecognition = localFaceCluster.trackFace(paramArrayOfByte, paramInt1, paramInt2, 0, false);
    if (ARLocalFaceRecog.g != null)
    {
      if (ARLocalFaceRecog.g.hasMessages(4))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[DEBUG_SCAN_yt_face] pretreatFaceRecogInfo, remove pending task");
        }
        ARLocalFaceRecog.g.removeMessages(4);
      }
      paramArrayOfByte = Message.obtain(ARLocalFaceRecog.g, new ARCloudPretreatmentManager.1(this, paramARRecognition, localFaceCluster, paramArrayOfByte, paramInt1, paramInt2));
      paramArrayOfByte.what = 4;
      if (ARLocalFaceRecog.g != null) {
        ARLocalFaceRecog.g.sendMessage(paramArrayOfByte);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "pretreatFaceRecogInfo ,handler is null");
    }
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("[ScanStarFace][TimeCost]pretreatFaceRecogInfo  cost = ");
      paramArrayOfByte.append(l2 - l1);
      paramArrayOfByte.append(", faceStatus = ");
      paramArrayOfByte.append(Arrays.toString(paramARRecognition));
      QLog.d("AREngine_ARCloudPretreatmentManagert", 2, paramArrayOfByte.toString());
    }
    if ((paramARRecognition != null) && (paramARRecognition.length > 0))
    {
      ((ARCloudRecogReqFaceInfo)localObject).b = paramARRecognition;
      ReportController.b(null, "dc00898", "", "", "0X800834C", "0X800834C", 0, 0, "", "", "", "");
    }
    paramARCloudPretreatmentCallback.a((ARCloudRecogReqFaceInfo)localObject);
  }
  
  public void a(byte[] paramArrayOfByte, ARRecognition paramARRecognition, ARCloudPretreatmentManager.ARCloudPretreatmentCallback paramARCloudPretreatmentCallback)
  {
    paramArrayOfByte = new ARCloudReqMarkerInfo();
    paramArrayOfByte.a = ((int)paramARRecognition.e);
    paramARCloudPretreatmentCallback.a(paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte, ArrayList<ARRecognition> paramArrayList, ARCloudPretreatmentManager.ARCloudPretreatmentCallback paramARCloudPretreatmentCallback, int paramInt1, int paramInt2, int paramInt3)
  {
    long l3 = System.currentTimeMillis();
    boolean bool = QLog.isColorLevel();
    Object localObject = "AREngine_ARCloudPretreatmentManagert";
    if (bool) {
      QLog.i("AREngine_ARCloudPretreatmentManagert", 2, "[DEBUG_SCAN_yt_face] Preprocess start");
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 480;
      int j;
      if (paramInt1 > paramInt2)
      {
        j = (paramInt1 * 480 / paramInt2 + 3) / 4 * 4;
      }
      else
      {
        i = (paramInt2 * 480 / paramInt1 + 3) / 4 * 4;
        j = 480;
      }
      int k;
      if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.g)) {
        k = 270;
      } else {
        k = 90;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pretreatAllType  degree = ");
        localStringBuilder.append(k);
        QLog.i("AREngine_ARCloudPretreatmentManagert", 2, localStringBuilder.toString());
      }
      double d1 = i * j;
      Double.isNaN(d1);
      int m = (int)(d1 * 1.5D);
      if ((this.c == null) || (this.d != m))
      {
        this.c = new byte[m];
        this.d = m;
      }
      if (ARCloudImageProc.nativeScaleAndRotate(this.c, j, i, k, paramArrayOfByte, paramInt1, paramInt2) == 0)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("Preprocess failed. ScaleAndRotate failed. scaledWidth = ");
        paramArrayOfByte.append(j);
        paramArrayOfByte.append(", scaledHeight = ");
        paramArrayOfByte.append(i);
        paramArrayOfByte.append(", degree = ");
        paramArrayOfByte.append(k);
        paramArrayOfByte.append(", srcWidth = ");
        paramArrayOfByte.append(paramInt1);
        paramArrayOfByte.append(", srcHeight = ");
        paramArrayOfByte.append(paramInt2);
        QLog.i("AREngine_ARCloudPretreatmentManagert", 1, paramArrayOfByte.toString());
        paramARCloudPretreatmentCallback.a(b, null, -1L);
        return;
      }
      paramArrayList = paramArrayList.iterator();
      long l1 = -1L;
      paramArrayOfByte = (byte[])localObject;
      while (paramArrayList.hasNext())
      {
        localObject = (ARRecognition)paramArrayList.next();
        long l4 = 1 << (int)((ARRecognition)localObject).a;
        if (l4 == 1L) {
          a(this.c, (ARRecognition)localObject, paramARCloudPretreatmentCallback);
        }
        for (;;)
        {
          l2 = l1;
          break label563;
          if (l4 != 2L) {
            break;
          }
          b(this.c, (ARRecognition)localObject, paramARCloudPretreatmentCallback);
        }
        if (l4 == 4L)
        {
          l1 = System.currentTimeMillis();
          a(this.c, i, j, (ARRecognition)localObject, paramARCloudPretreatmentCallback);
          l2 = System.currentTimeMillis() - l1;
        }
        else if (l4 == 64L)
        {
          d(this.c, (ARRecognition)localObject, paramARCloudPretreatmentCallback);
          l2 = l1;
        }
        else if (l4 == 128L)
        {
          c(this.c, (ARRecognition)localObject, paramARCloudPretreatmentCallback);
          l2 = l1;
        }
        else
        {
          l2 = l1;
          if (l4 == 2048L)
          {
            e(this.c, (ARRecognition)localObject, paramARCloudPretreatmentCallback);
            l2 = l1;
          }
        }
        label563:
        l1 = l2;
      }
      localObject = new YuvImage(this.c, paramInt3, i, j, null);
      paramArrayList = c();
      paramArrayList = new ARCloudPretreatmentManager.ImgInfo(this.e, paramArrayList, this.c);
      a(paramArrayList.a, paramArrayList.b, null, (YuvImage)localObject);
      long l2 = System.currentTimeMillis() - l3;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[DEBUG_SCAN_yt_face] Preprocess end. save img: ");
      ((StringBuilder)localObject).append(paramArrayList.a);
      ((StringBuilder)localObject).append(paramArrayList.b);
      ((StringBuilder)localObject).append(",preProcessCost = ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(",pretreatFaceRecogCost = ");
      ((StringBuilder)localObject).append(l1);
      QLog.i(paramArrayOfByte, 1, ((StringBuilder)localObject).toString());
      paramArrayOfByte = new ARCloudReqFileInfo();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramArrayList.a);
      ((StringBuilder)localObject).append(paramArrayList.b);
      paramArrayOfByte.a = ((StringBuilder)localObject).toString();
      paramArrayOfByte.b = 0;
      localObject = ARFaceDataCollector.b();
      ((ARFaceDataCollector)localObject).d = l1;
      ((ARFaceDataCollector)localObject).c = l2;
      l1 = paramArrayList.d.length / 8192;
      paramARCloudPretreatmentCallback.a(a, paramArrayOfByte, l1);
    }
  }
  
  public void b()
  {
    d();
    ARCloudImageProc.nativeUninit();
  }
  
  public void b(byte[] paramArrayOfByte, ARRecognition paramARRecognition, ARCloudPretreatmentManager.ARCloudPretreatmentCallback paramARCloudPretreatmentCallback)
  {
    paramArrayOfByte = new ARCloudRecogReqObjectClassifyInfo();
    paramArrayOfByte.a = ((int)paramARRecognition.e);
    paramARCloudPretreatmentCallback.a(paramArrayOfByte);
  }
  
  public void c(byte[] paramArrayOfByte, ARRecognition paramARRecognition, ARCloudPretreatmentManager.ARCloudPretreatmentCallback paramARCloudPretreatmentCallback)
  {
    paramArrayOfByte = new ARCloudRecogReqObjectClassifyInfo();
    paramArrayOfByte.a = ((int)paramARRecognition.e);
    paramARCloudPretreatmentCallback.b(paramArrayOfByte);
  }
  
  public void d(byte[] paramArrayOfByte, ARRecognition paramARRecognition, ARCloudPretreatmentManager.ARCloudPretreatmentCallback paramARCloudPretreatmentCallback)
  {
    paramArrayOfByte = new ARCloudRecogReqPreOcrInfo();
    paramArrayOfByte.a = ((int)paramARRecognition.e);
    paramARCloudPretreatmentCallback.a(paramArrayOfByte);
  }
  
  public void e(byte[] paramArrayOfByte, ARRecognition paramARRecognition, ARCloudPretreatmentManager.ARCloudPretreatmentCallback paramARCloudPretreatmentCallback)
  {
    paramArrayOfByte = new ARCloudRecogReqSceneRecogInfo();
    paramArrayOfByte.a = ((int)paramARRecognition.e);
    paramARCloudPretreatmentCallback.a(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager
 * JD-Core Version:    0.7.0.1
 */