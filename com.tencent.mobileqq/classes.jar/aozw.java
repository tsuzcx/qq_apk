import android.graphics.YuvImage;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.arcloud.ARCloudImageProc;
import com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

public class aozw
{
  public static int a;
  public static int b = -1;
  private String jdField_a_of_type_JavaLangString = "";
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int c;
  
  private String a()
  {
    String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
    return "FilteredImg" + str + ".jpg";
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, byte[] paramArrayOfByte, YuvImage paramYuvImage)
  {
    // Byte code:
    //   0: new 66	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: new 66	java/io/File
    //   13: dup
    //   14: new 47	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   21: aload_1
    //   22: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload 5
    //   38: invokevirtual 71	java/io/File:exists	()Z
    //   41: ifne +9 -> 50
    //   44: aload 5
    //   46: invokevirtual 74	java/io/File:mkdirs	()Z
    //   49: pop
    //   50: aload_1
    //   51: invokevirtual 71	java/io/File:exists	()Z
    //   54: ifne +8 -> 62
    //   57: aload_1
    //   58: invokevirtual 77	java/io/File:createNewFile	()Z
    //   61: pop
    //   62: new 79	java/io/FileOutputStream
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 82	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   70: astore_2
    //   71: aload_3
    //   72: ifnull +33 -> 105
    //   75: aload_2
    //   76: astore_1
    //   77: aload_2
    //   78: aload_3
    //   79: invokevirtual 86	java/io/FileOutputStream:write	([B)V
    //   82: aload_2
    //   83: astore_1
    //   84: aload_2
    //   85: invokevirtual 89	java/io/FileOutputStream:flush	()V
    //   88: aload_2
    //   89: ifnull +7 -> 96
    //   92: aload_2
    //   93: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   96: return
    //   97: astore_2
    //   98: aload_2
    //   99: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   102: goto -40 -> 62
    //   105: aload 4
    //   107: ifnull -25 -> 82
    //   110: aload_2
    //   111: astore_1
    //   112: aload 4
    //   114: new 97	android/graphics/Rect
    //   117: dup
    //   118: iconst_0
    //   119: iconst_0
    //   120: aload 4
    //   122: invokevirtual 103	android/graphics/YuvImage:getWidth	()I
    //   125: aload 4
    //   127: invokevirtual 106	android/graphics/YuvImage:getHeight	()I
    //   130: invokespecial 109	android/graphics/Rect:<init>	(IIII)V
    //   133: bipush 50
    //   135: aload_2
    //   136: invokevirtual 113	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   139: pop
    //   140: goto -58 -> 82
    //   143: astore_3
    //   144: aload_2
    //   145: astore_1
    //   146: aload_3
    //   147: invokevirtual 114	java/io/FileNotFoundException:printStackTrace	()V
    //   150: aload_2
    //   151: ifnull -55 -> 96
    //   154: aload_2
    //   155: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   158: return
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   164: return
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   170: return
    //   171: astore_3
    //   172: aconst_null
    //   173: astore_2
    //   174: aload_2
    //   175: astore_1
    //   176: aload_3
    //   177: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   180: aload_2
    //   181: ifnull -85 -> 96
    //   184: aload_2
    //   185: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   188: return
    //   189: astore_1
    //   190: aload_1
    //   191: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   194: return
    //   195: astore_2
    //   196: aconst_null
    //   197: astore_1
    //   198: aload_1
    //   199: ifnull +7 -> 206
    //   202: aload_1
    //   203: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   206: aload_2
    //   207: athrow
    //   208: astore_1
    //   209: aload_1
    //   210: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   213: goto -7 -> 206
    //   216: astore_2
    //   217: goto -19 -> 198
    //   220: astore_3
    //   221: goto -47 -> 174
    //   224: astore_3
    //   225: aconst_null
    //   226: astore_2
    //   227: goto -83 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	aozw
    //   0	230	1	paramString1	String
    //   0	230	2	paramString2	String
    //   0	230	3	paramArrayOfByte	byte[]
    //   0	230	4	paramYuvImage	YuvImage
    //   8	37	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   57	62	97	java/io/IOException
    //   77	82	143	java/io/FileNotFoundException
    //   84	88	143	java/io/FileNotFoundException
    //   112	140	143	java/io/FileNotFoundException
    //   154	158	159	java/io/IOException
    //   92	96	165	java/io/IOException
    //   62	71	171	java/io/IOException
    //   184	188	189	java/io/IOException
    //   62	71	195	finally
    //   202	206	208	java/io/IOException
    //   77	82	216	finally
    //   84	88	216	finally
    //   112	140	216	finally
    //   146	150	216	finally
    //   176	180	216	finally
    //   77	82	220	java/io/IOException
    //   84	88	220	java/io/IOException
    //   112	140	220	java/io/IOException
    //   62	71	224	java/io/FileNotFoundException
  }
  
  private void c()
  {
    QLog.i("AREngine_ARCloudPretreatmentManagert", 1, "delete backup file.");
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    if (localObject1 != null)
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int i = 0;
        while (i < localObject1.length)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.exists()) {
            localObject2.delete();
          }
          i += 1;
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = (aovr.a() + "ar_cloud_img/");
    ARCloudImageProc.nativeInit();
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_ARCloudPretreatmentManagert", 2, "ARCloudPretreatmentManager mImgDir = " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ARRecognition paramARRecognition, aozx paramaozx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[ScanStarFace]pretreatFaceRecogInfo,  FaceScanModelsLoader.hasFaceModelInit =  " + aowj.b);
    }
    if (aowj.c)
    {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "pretreatFaceRecogInfo,return for releasing");
      return;
    }
    if (!aowj.b)
    {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "pretreatFaceRecogInfo,return1 FaceModel not init!");
      return;
    }
    aozz localaozz = new aozz();
    localaozz.jdField_a_of_type_Int = ((int)paramARRecognition.b);
    FaceCluster localFaceCluster = FaceCluster.getInstance();
    long l1 = SystemClock.uptimeMillis();
    if (!aowj.b)
    {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "pretreatFaceRecogInfo,return2 FaceModel not init!");
      return;
    }
    paramARRecognition = localFaceCluster.detectFace(paramArrayOfByte, paramInt1, paramInt2, 0);
    if (apat.a != null)
    {
      if (apat.a.hasMessages(4))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[DEBUG_SCAN_yt_face] pretreatFaceRecogInfo, remove pending task");
        }
        apat.a.removeMessages(4);
      }
      paramArrayOfByte = Message.obtain(apat.a, new ARCloudPretreatmentManager.1(this, paramARRecognition, localFaceCluster, paramArrayOfByte, paramInt1, paramInt2));
      paramArrayOfByte.what = 4;
      if (apat.a != null) {
        apat.a.sendMessage(paramArrayOfByte);
      }
    }
    for (;;)
    {
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[ScanStarFace][TimeCost]pretreatFaceRecogInfo  cost = " + (l2 - l1) + ", faceStatus = " + Arrays.toString(paramARRecognition));
      }
      if ((paramARRecognition != null) && (paramARRecognition.length > 0))
      {
        localaozz.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus = paramARRecognition;
        bcst.b(null, "dc00898", "", "", "0X800834C", "0X800834C", 0, 0, "", "", "", "");
      }
      paramaozx.a(localaozz);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "pretreatFaceRecogInfo ,handler is null");
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, ARRecognition paramARRecognition, aozx paramaozx)
  {
    paramArrayOfByte = new apaj();
    paramArrayOfByte.jdField_a_of_type_Int = ((int)paramARRecognition.b);
    paramaozx.a(paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte, ArrayList<ARRecognition> paramArrayList, aozx paramaozx, int paramInt1, int paramInt2, int paramInt3)
  {
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_ARCloudPretreatmentManagert", 2, "[DEBUG_SCAN_yt_face] Preprocess start");
    }
    int j;
    int i;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (paramInt1 <= paramInt2) {
        break label260;
      }
      j = 480;
      i = (paramInt1 * 480 / paramInt2 + 3) / 4 * 4;
    }
    for (;;)
    {
      int k = 90;
      if (bcif.d(bcif.g)) {
        k = 270;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARCloudPretreatmentManagert", 2, "pretreatAllType  degree = " + k);
      }
      int m = (int)(j * i * 1.5D);
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.c != m))
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[m];
        this.c = m;
      }
      if (ARCloudImageProc.nativeScaleAndRotate(this.jdField_a_of_type_ArrayOfByte, i, j, k, paramArrayOfByte, paramInt1, paramInt2) != 0) {
        break;
      }
      QLog.i("AREngine_ARCloudPretreatmentManagert", 1, "Preprocess failed. ScaleAndRotate failed. scaledWidth = " + i + ", scaledHeight = " + j + ", degree = " + k + ", srcWidth = " + paramInt1 + ", srcHeight = " + paramInt2);
      paramaozx.a(b, null, -1L);
      return;
      label260:
      i = 480;
      j = (paramInt2 * 480 / paramInt1 + 3) / 4 * 4;
    }
    paramArrayOfByte = paramArrayList.iterator();
    long l1 = -1L;
    if (paramArrayOfByte.hasNext())
    {
      paramArrayList = (ARRecognition)paramArrayOfByte.next();
      long l3 = 1 << (int)paramArrayList.a;
      if (l3 == 1L) {
        a(this.jdField_a_of_type_ArrayOfByte, paramArrayList, paramaozx);
      }
      for (;;)
      {
        break;
        if (l3 == 2L)
        {
          b(this.jdField_a_of_type_ArrayOfByte, paramArrayList, paramaozx);
        }
        else if (l3 == 4L)
        {
          l1 = System.currentTimeMillis();
          a(this.jdField_a_of_type_ArrayOfByte, j, i, paramArrayList, paramaozx);
          l1 = System.currentTimeMillis() - l1;
        }
        else if (l3 == 64L)
        {
          d(this.jdField_a_of_type_ArrayOfByte, paramArrayList, paramaozx);
        }
        else if (l3 == 128L)
        {
          c(this.jdField_a_of_type_ArrayOfByte, paramArrayList, paramaozx);
        }
        else if (l3 == 2048L)
        {
          e(this.jdField_a_of_type_ArrayOfByte, paramArrayList, paramaozx);
        }
      }
    }
    paramArrayList = new YuvImage(this.jdField_a_of_type_ArrayOfByte, paramInt3, j, i, null);
    paramArrayOfByte = a();
    paramArrayOfByte = new aozy(this.jdField_a_of_type_JavaLangString, paramArrayOfByte, this.jdField_a_of_type_ArrayOfByte);
    a(paramArrayOfByte.jdField_a_of_type_JavaLangString, paramArrayOfByte.b, null, paramArrayList);
    l2 = System.currentTimeMillis() - l2;
    QLog.i("AREngine_ARCloudPretreatmentManagert", 1, "[DEBUG_SCAN_yt_face] Preprocess end. save img: " + paramArrayOfByte.jdField_a_of_type_JavaLangString + paramArrayOfByte.b + ",preProcessCost = " + l2 + ",pretreatFaceRecogCost = " + l1);
    paramArrayList = new apah();
    paramArrayList.jdField_a_of_type_JavaLangString = (paramArrayOfByte.jdField_a_of_type_JavaLangString + paramArrayOfByte.b);
    paramArrayList.jdField_a_of_type_Int = 0;
    apaq localapaq = apaq.a();
    localapaq.c = l1;
    localapaq.b = l2;
    l1 = paramArrayOfByte.jdField_a_of_type_ArrayOfByte.length / 8192;
    paramaozx.a(jdField_a_of_type_Int, paramArrayList, l1);
  }
  
  public void b()
  {
    c();
    ARCloudImageProc.nativeUninit();
  }
  
  public void b(byte[] paramArrayOfByte, ARRecognition paramARRecognition, aozx paramaozx)
  {
    paramArrayOfByte = new apaa();
    paramArrayOfByte.jdField_a_of_type_Int = ((int)paramARRecognition.b);
    paramaozx.a(paramArrayOfByte);
  }
  
  public void c(byte[] paramArrayOfByte, ARRecognition paramARRecognition, aozx paramaozx)
  {
    paramArrayOfByte = new apaa();
    paramArrayOfByte.jdField_a_of_type_Int = ((int)paramARRecognition.b);
    paramaozx.b(paramArrayOfByte);
  }
  
  public void d(byte[] paramArrayOfByte, ARRecognition paramARRecognition, aozx paramaozx)
  {
    paramArrayOfByte = new apab();
    paramArrayOfByte.jdField_a_of_type_Int = ((int)paramARRecognition.b);
    paramaozx.a(paramArrayOfByte);
  }
  
  public void e(byte[] paramArrayOfByte, ARRecognition paramARRecognition, aozx paramaozx)
  {
    paramArrayOfByte = new apac();
    paramArrayOfByte.jdField_a_of_type_Int = ((int)paramARRecognition.b);
    paramaozx.a(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aozw
 * JD-Core Version:    0.7.0.1
 */