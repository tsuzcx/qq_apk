import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.identification.IdentificationActivityHelper.1;
import com.tencent.mobileqq.identification.IdentificationActivityHelper.2;
import com.tencent.mobileqq.identification.IdentificationActivityHelper.3;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ytcommon.util.YTCommonInterface;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class astc
  implements Handler.Callback, EIPCResultCallback
{
  public static boolean a;
  public int a;
  private astd jdField_a_of_type_Astd;
  private QQIdentiferActivity jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity;
  private String jdField_a_of_type_JavaLangString;
  public AtomicBoolean a;
  public MqqHandler a;
  
  @RequiresApi(api=18)
  public astc(QQIdentiferActivity paramQQIdentiferActivity, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity = paramQQIdentiferActivity;
    this.jdField_a_of_type_Astd = astd.a(paramInt, paramQQIdentiferActivity.getIntent(), paramQQIdentiferActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static int a()
  {
    return bdiv.c();
  }
  
  /* Error */
  private static HashMap<String, Integer> a(File paramFile)
  {
    // Byte code:
    //   0: new 77	java/util/HashMap
    //   3: dup
    //   4: invokespecial 78	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: new 80	java/io/BufferedReader
    //   11: dup
    //   12: new 82	java/io/FileReader
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 85	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   20: invokespecial 88	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual 92	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull +53 -> 85
    //   35: aload_1
    //   36: astore_0
    //   37: aload_2
    //   38: ldc 94
    //   40: invokevirtual 100	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   65: invokestatic 106	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   68: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: invokevirtual 114	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_1
    //   76: astore_0
    //   77: aload_1
    //   78: invokevirtual 92	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   81: astore_2
    //   82: goto -51 -> 31
    //   85: aload_1
    //   86: ifnull +7 -> 93
    //   89: aload_1
    //   90: invokevirtual 117	java/io/BufferedReader:close	()V
    //   93: aload_3
    //   94: areturn
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   100: aload_3
    //   101: areturn
    //   102: astore_2
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: astore_0
    //   107: aload_2
    //   108: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   111: aload_1
    //   112: astore_0
    //   113: ldc 123
    //   115: iconst_1
    //   116: new 125	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   123: ldc 128
    //   125: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_2
    //   129: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_1
    //   139: ifnull -46 -> 93
    //   142: aload_1
    //   143: invokevirtual 117	java/io/BufferedReader:close	()V
    //   146: aload_3
    //   147: areturn
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   153: aload_3
    //   154: areturn
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_0
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 117	java/io/BufferedReader:close	()V
    //   166: aload_1
    //   167: athrow
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 120	java/io/IOException:printStackTrace	()V
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
  
  private void a(Runnable paramRunnable)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
  
  public static boolean a()
  {
    String str = bdiv.b();
    QLog.d("qq_Identification.Helper", 1, "preResDownload resPath = " + str);
    if ((!TextUtils.isEmpty(str)) && (!c()) && (b())) {
      return false;
    }
    bdiv.c("");
    bdiv.b(0);
    bdiv.c(0);
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_res_download", null, null);
    return true;
  }
  
  public static int b()
  {
    return 32;
  }
  
  private static boolean b()
  {
    int i = a();
    int j = b();
    QLog.d("qq_Identification.Helper", 1, new Object[] { "current download bits is : ", Integer.valueOf(i), " app setting so bits is : ", Integer.valueOf(j) });
    return i == j;
  }
  
  private static boolean c()
  {
    int j = bdiv.b();
    Object localObject1 = ShortVideoResourceManager.a();
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new ArrayList();
      ShortVideoResourceManager.a((String)localObject1, (List)localObject2);
      if (((List)localObject2).size() > 0)
      {
        localObject1 = ((List)localObject2).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ShortVideoResourceManager.SVConfigItem)((Iterator)localObject1).next();
        } while (!((ShortVideoResourceManager.SVConfigItem)localObject2).name.startsWith("new_qq_android_native_short_new_other_"));
      }
    }
    for (int i = ((ShortVideoResourceManager.SVConfigItem)localObject2).versionCode;; i = -1)
    {
      QLog.d("qq_Identification.Helper", 1, new Object[] { "newVersion is ", Integer.valueOf(i), " localVersion is ", Integer.valueOf(j) });
      return j != i;
    }
  }
  
  public String a()
  {
    return bdiv.b();
  }
  
  public void a()
  {
    String str = a();
    QLog.d("qq_Identification.Helper", 1, String.valueOf(str));
    if (TextUtils.isEmpty(str))
    {
      QLog.d("qq_Identification.Helper", 1, "no res,need download ");
      a(this);
      return;
    }
    if (!a(str))
    {
      QLog.d("qq_Identification.Helper", 1, new Object[] { "check so files error, path is ", str });
      bdiv.c("");
      bdiv.b(0);
      bdiv.c(0);
      a(this);
      return;
    }
    if (c())
    {
      QLog.d("qq_Identification.Helper", 1, "need update local res");
      bdiv.c("");
      bdiv.b(0);
      bdiv.c(0);
      a(this);
      return;
    }
    if (!b())
    {
      QLog.d("qq_Identification.Helper", 1, "so bits not match, need update local res");
      bdiv.c("");
      bdiv.b(0);
      bdiv.c(0);
      a(this);
      return;
    }
    QLog.d("qq_Identification.Helper", 1, new Object[] { "preCheck is pass, so version is ", Integer.valueOf(bdiv.b()), " current bits is : ", Integer.valueOf(b()) });
    this.jdField_a_of_type_JavaLangString = str;
    b();
  }
  
  public void a(EIPCResultCallback paramEIPCResultCallback)
  {
    QLog.d("qq_Identification.Helper", 1, "start dowloadRes");
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
  
  public void b()
  {
    QLog.d("qq_Identification.Helper", 1, new Object[] { "start init youtu sdk, mIsLoadSo is ", Boolean.valueOf(jdField_a_of_type_Boolean) });
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = this.jdField_a_of_type_Astd.a(this.jdField_a_of_type_JavaLangString + "identification/so/");
    }
    int i;
    if (jdField_a_of_type_Boolean)
    {
      i = YTCommonInterface.initAuth(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity, "youtusdk_mqq.licence", 0);
      QLog.d("qq_Identification.Helper", 1, new Object[] { "yt init result is : ", Integer.valueOf(i), " licence name is : ", "youtusdk_mqq.licence" });
      if (i == 0) {}
    }
    for (;;)
    {
      QLog.d("qq_Identification.Helper", 1, "initYoutuSdk result: " + i);
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(2);
      localMessage.arg1 = i;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
      i = this.jdField_a_of_type_Astd.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity, this.jdField_a_of_type_JavaLangString);
      QLog.d("qq_Identification.Helper", 1, new Object[] { "initFaceResMode result is ", Integer.valueOf(i) });
      continue;
      i = 2;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Astd.a();
  }
  
  @TargetApi(18)
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
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
        bool1 = a(this.jdField_a_of_type_JavaLangString);
        QLog.d("qq_Identification.Helper", 1, new Object[] { "checkResValid : ", Boolean.valueOf(bool1) });
        if (!bool1)
        {
          a(new IdentificationActivityHelper.1(this));
          return false;
        }
        b();
        return false;
      }
      a(new IdentificationActivityHelper.2(this));
      return false;
    }
    if (paramMessage.arg1 == 0)
    {
      bool1 = true;
      QLog.d("qq_Identification.Helper", 1, new Object[] { "initResultNotify : ", Boolean.valueOf(bool1) });
      if (paramMessage.arg1 == 0)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_Astd.a(true, this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferActivity);
      }
      if (paramMessage.arg1 != 0) {
        break label238;
      }
    }
    label238:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a(new IdentificationActivityHelper.3(this, bool1));
      return false;
      bool1 = false;
      break;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astc
 * JD-Core Version:    0.7.0.1
 */