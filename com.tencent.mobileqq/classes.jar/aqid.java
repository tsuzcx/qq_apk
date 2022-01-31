import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtufacetrack.YoutuFaceTracker.FaceStatus;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class aqid
  implements Handler.Callback, EIPCResultCallback
{
  public static boolean a;
  public static int b;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  public static int f = 4;
  public static int g = 5;
  public int a;
  private aqie jdField_a_of_type_Aqie;
  private QQIdentiferActivity jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity;
  private String jdField_a_of_type_JavaLangString;
  public AtomicBoolean a;
  public MqqHandler a;
  
  @RequiresApi(api=18)
  public aqid(QQIdentiferActivity paramQQIdentiferActivity, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity = paramQQIdentiferActivity;
    this.jdField_a_of_type_Aqie = aqie.a(paramInt, paramQQIdentiferActivity.getIntent(), paramQQIdentiferActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static int a(Rect paramRect, YoutuFaceTracker.FaceStatus[] paramArrayOfFaceStatus)
  {
    if ((paramArrayOfFaceStatus == null) || (paramArrayOfFaceStatus.length <= 0)) {
      return c;
    }
    Object localObject = a(paramArrayOfFaceStatus);
    if ((localObject == null) || (localObject.length <= 0)) {
      return c;
    }
    paramArrayOfFaceStatus = paramArrayOfFaceStatus[0];
    localObject = localObject[0];
    if (paramArrayOfFaceStatus == null) {
      return c;
    }
    boolean bool = paramRect.contains((Rect)localObject);
    int i = ((Rect)localObject).right;
    int j = ((Rect)localObject).left;
    float f1 = (((Rect)localObject).bottom - ((Rect)localObject).top) * (i - j) / ((paramRect.right - paramRect.left) * (paramRect.bottom - paramRect.top));
    if ((f1 < 0.15D) && (f1 > 0.0F)) {
      return d;
    }
    if (f1 > 0.75D) {
      return e;
    }
    if (!bool) {
      return f;
    }
    if ((Math.abs(paramArrayOfFaceStatus.pitch) > 15.0F) || (Math.abs(paramArrayOfFaceStatus.yaw) > 15.0F) || (Math.abs(paramArrayOfFaceStatus.roll) > 15.0F)) {
      return g;
    }
    return b;
  }
  
  /* Error */
  private static HashMap<String, Integer> a(File paramFile)
  {
    // Byte code:
    //   0: new 138	java/util/HashMap
    //   3: dup
    //   4: invokespecial 139	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: new 141	java/io/BufferedReader
    //   11: dup
    //   12: new 143	java/io/FileReader
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 146	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   20: invokespecial 149	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual 153	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull +53 -> 85
    //   35: aload_1
    //   36: astore_0
    //   37: aload_2
    //   38: ldc 155
    //   40: invokevirtual 161	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +30 -> 75
    //   48: aload_1
    //   49: astore_0
    //   50: aload_2
    //   51: arraylength
    //   52: iconst_2
    //   53: if_icmpne +22 -> 75
    //   56: aload_1
    //   57: astore_0
    //   58: aload_3
    //   59: aload_2
    //   60: iconst_0
    //   61: aaload
    //   62: aload_2
    //   63: iconst_1
    //   64: aaload
    //   65: invokestatic 167	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   68: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: invokevirtual 175	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_1
    //   76: astore_0
    //   77: aload_1
    //   78: invokevirtual 153	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   81: astore_2
    //   82: goto -51 -> 31
    //   85: aload_1
    //   86: ifnull +7 -> 93
    //   89: aload_1
    //   90: invokevirtual 178	java/io/BufferedReader:close	()V
    //   93: aload_3
    //   94: areturn
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   100: aload_3
    //   101: areturn
    //   102: astore_2
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: astore_0
    //   107: aload_2
    //   108: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   111: aload_1
    //   112: astore_0
    //   113: ldc 184
    //   115: iconst_1
    //   116: new 186	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   123: ldc 189
    //   125: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_2
    //   129: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_1
    //   139: ifnull -46 -> 93
    //   142: aload_1
    //   143: invokevirtual 178	java/io/BufferedReader:close	()V
    //   146: aload_3
    //   147: areturn
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   153: aload_3
    //   154: areturn
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_0
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 178	java/io/BufferedReader:close	()V
    //   166: aload_1
    //   167: athrow
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   173: goto -7 -> 166
    //   176: astore_1
    //   177: goto -19 -> 158
    //   180: astore_2
    //   181: goto -76 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramFile	File
    //   23	120	1	localBufferedReader	java.io.BufferedReader
    //   155	12	1	localObject1	Object
    //   176	1	1	localObject2	Object
    //   30	52	2	localObject3	Object
    //   102	27	2	localException1	java.lang.Exception
    //   180	1	2	localException2	java.lang.Exception
    //   7	147	3	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   89	93	95	java/io/IOException
    //   8	24	102	java/lang/Exception
    //   142	146	148	java/io/IOException
    //   8	24	155	finally
    //   162	166	168	java/io/IOException
    //   26	31	176	finally
    //   37	44	176	finally
    //   50	56	176	finally
    //   58	75	176	finally
    //   77	82	176	finally
    //   107	111	176	finally
    //   113	138	176	finally
    //   26	31	180	java/lang/Exception
    //   37	44	180	java/lang/Exception
    //   50	56	180	java/lang/Exception
    //   58	75	180	java/lang/Exception
    //   77	82	180	java/lang/Exception
  }
  
  public static boolean a()
  {
    String str = baig.b();
    if (QLog.isColorLevel()) {
      QLog.d("qq_Identification.Helper", 2, "preResDownload resPath = " + str);
    }
    if (!TextUtils.isEmpty(str)) {
      return false;
    }
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_res_download", null, null);
    return true;
  }
  
  public static boolean a(YoutuFaceTracker.FaceStatus paramFaceStatus, Rect paramRect)
  {
    if (paramFaceStatus == null) {
      return false;
    }
    paramFaceStatus = paramFaceStatus.xys;
    float f1 = paramFaceStatus.length / 2;
    int i = 0;
    for (;;)
    {
      if (i >= f1) {
        break label50;
      }
      if (!paramRect.contains((int)paramFaceStatus[i], (int)paramFaceStatus[(i + 1)])) {
        break;
      }
      i += 1;
    }
    label50:
    return true;
  }
  
  public static Rect[] a(YoutuFaceTracker.FaceStatus[] paramArrayOfFaceStatus)
  {
    if ((paramArrayOfFaceStatus != null) && (paramArrayOfFaceStatus.length > 0))
    {
      Rect[] arrayOfRect = new Rect[paramArrayOfFaceStatus.length];
      int i = 0;
      while (i < paramArrayOfFaceStatus.length)
      {
        float f1 = paramArrayOfFaceStatus[i].xys[0];
        float f4 = paramArrayOfFaceStatus[i].xys[0];
        float f3 = paramArrayOfFaceStatus[i].xys[1];
        float f2 = paramArrayOfFaceStatus[i].xys[1];
        int j = 0;
        float f5 = f1;
        f1 = f2;
        if (j < paramArrayOfFaceStatus[i].xys.length)
        {
          if (f5 < paramArrayOfFaceStatus[i].xys[j])
          {
            f2 = f5;
            label107:
            if (f4 <= paramArrayOfFaceStatus[i].xys[j]) {
              break label185;
            }
            label123:
            j += 1;
            if (f3 >= paramArrayOfFaceStatus[i].xys[j]) {
              break label200;
            }
            label144:
            if (f1 <= paramArrayOfFaceStatus[i].xys[j]) {
              break label214;
            }
          }
          for (;;)
          {
            j += 1;
            f5 = f2;
            break;
            f2 = paramArrayOfFaceStatus[i].xys[j];
            break label107;
            label185:
            f4 = paramArrayOfFaceStatus[i].xys[j];
            break label123;
            label200:
            f3 = paramArrayOfFaceStatus[i].xys[j];
            break label144;
            label214:
            f1 = paramArrayOfFaceStatus[i].xys[j];
          }
        }
        arrayOfRect[i] = new Rect((int)f5, (int)f3, (int)f4, (int)f1);
        i += 1;
      }
      return arrayOfRect;
    }
    return null;
  }
  
  public String a()
  {
    return baig.b();
  }
  
  public void a()
  {
    boolean bool = false;
    String str = a();
    if (TextUtils.isEmpty(str))
    {
      QLog.d("qq_Identification.Helper", 1, "no res,need download ");
      a(this);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qq_Identification.Helper", 2, "initRes resPath: " + str + ",isFileValid = " + bool);
      }
      return;
      if (!a(str))
      {
        baig.c("");
        a(this);
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = str;
        b();
        bool = true;
      }
    }
  }
  
  public void a(Camera paramCamera, int paramInt)
  {
    this.jdField_a_of_type_Aqie.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity, paramCamera, paramInt);
  }
  
  public void a(YoutuFaceTracker.FaceStatus paramFaceStatus, int paramInt, byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((this.jdField_a_of_type_Aqie instanceof aqij)) {
      ((aqij)this.jdField_a_of_type_Aqie).a(paramFaceStatus, paramInt, paramArrayOfByte, paramCamera);
    }
  }
  
  public void a(EIPCResultCallback paramEIPCResultCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qq_Identification.Helper", 2, "dowloadRes: ");
    }
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_res_download", null, paramEIPCResultCallback);
  }
  
  public boolean a(String paramString)
  {
    Object localObject1 = new File(paramString + "identification/" + "identification_res_desct.txt");
    if (((File)localObject1).exists())
    {
      Object localObject2 = a((File)localObject1);
      localObject1 = paramString + "identification/so/";
      String str1 = paramString + "identification/ytd/";
      if (((HashMap)localObject2).size() > 6)
      {
        localObject2 = ((HashMap)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramString = (Map.Entry)((Iterator)localObject2).next();
          String str2 = (String)paramString.getKey();
          int i = ((Integer)paramString.getValue()).intValue();
          if (str2.endsWith("so")) {}
          for (paramString = (String)localObject1;; paramString = str1)
          {
            paramString = new File(paramString + str2);
            if (paramString.exists()) {
              break;
            }
            QLog.d("qq_Identification.Helper", 1, "check file valid failed,file not exist,name = " + str2);
            return false;
          }
          if (i != paramString.length())
          {
            QLog.d("qq_Identification.Helper", 1, "check file valid failed,file size is wrong,name = " + str2);
            return false;
          }
        }
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public YoutuFaceTracker.FaceStatus[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.jdField_a_of_type_Aqie.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void b()
  {
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = this.jdField_a_of_type_Aqie.a(this.jdField_a_of_type_JavaLangString + "identification/so/");
    }
    int i;
    if (jdField_a_of_type_Boolean)
    {
      int j = YTCommonExInterface.initAuth(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity, "youtusdk_mqq.licence", 0, true);
      if (j != 0)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("qq_Identification.Helper", 2, "initYoutuSdk initAuth failed error= " + j);
          i = j;
        }
      }
    }
    for (;;)
    {
      QLog.d("qq_Identification.Helper", 1, "initYoutuSdk result: " + i);
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(2);
      localMessage.arg1 = i;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
      i = this.jdField_a_of_type_Aqie.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity, this.jdField_a_of_type_JavaLangString + "identification/ytd/");
      continue;
      i = 2;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Aqie.a();
  }
  
  @TargetApi(18)
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.d("qq_Identification.Helper", 2, "dowloadRes result: " + paramMessage.arg1);
      }
      if (paramMessage.arg1 == 0)
      {
        this.jdField_a_of_type_JavaLangString = a();
        if (!a(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity.a(false);
          return false;
        }
        b();
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity.a(false);
      return false;
    case 0: 
      a();
      return false;
    }
    if (paramMessage.arg1 == 0)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_Aqie.a(true, this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity.a(true);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity.a(false);
    return false;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
    if (paramEIPCResult.isSuccess()) {}
    for (localMessage.arg1 = 0;; localMessage.arg1 = 1)
    {
      localMessage.sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqid
 * JD-Core Version:    0.7.0.1
 */