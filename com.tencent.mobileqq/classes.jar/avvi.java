import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OCRManager.1;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class avvi
  implements Manager
{
  avvk jdField_a_of_type_Avvk = new avvj(this);
  awgf jdField_a_of_type_Awgf;
  public QQAppInterface a;
  public OcrConfig a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public avvi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Avvk);
    this.jdField_a_of_type_Awgf = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    ThreadManager.post(new OCRManager.1(this), 5, null, false);
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getCurrentAccountUin() + "_" + SystemClock.uptimeMillis();
  }
  
  public static String a(String paramString)
  {
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "ocr", 4).getString("ocr_aio_text", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr", 2, "getAIOText " + paramString);
    }
    return paramString;
  }
  
  public static void a(String paramString, OcrConfig paramOcrConfig)
  {
    boolean bool2 = true;
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "ocr", 4).edit();
    if (paramOcrConfig == null)
    {
      paramString.putBoolean("is_aio_support", false);
      paramString.putBoolean("is_chat_file_support", false);
      paramString.putBoolean("is_qzone_support", false);
      paramString.putBoolean("is_scan_support", false);
      paramString.putBoolean("question_result_enter", false);
      paramString.putBoolean("question_scan_enter", false);
      paramString.putString("ocr_aio_text", "");
      paramString.commit();
      return;
    }
    if (paramOcrConfig.aioOcrOpen == 1)
    {
      bool1 = true;
      label127:
      paramString.putBoolean("is_aio_support", bool1);
      if (paramOcrConfig.chatFileOcrOpen != 1) {
        break label268;
      }
      bool1 = true;
      label147:
      paramString.putBoolean("is_chat_file_support", bool1);
      if (paramOcrConfig.qzoneOcrOpen != 1) {
        break label273;
      }
      bool1 = true;
      label167:
      paramString.putBoolean("is_qzone_support", bool1);
      if (paramOcrConfig.scanOcrOpen != 1) {
        break label278;
      }
      bool1 = true;
      label187:
      paramString.putBoolean("is_scan_support", bool1);
      if (!TextUtils.isEmpty(paramOcrConfig.iconText)) {
        paramString.putString("ocr_aio_text", paramOcrConfig.aioText);
      }
      if (paramOcrConfig.questionResultOpen != 1) {
        break label283;
      }
      bool1 = true;
      label230:
      paramString.putBoolean("question_result_enter", bool1);
      if (paramOcrConfig.questionScanOpen != 1) {
        break label288;
      }
    }
    label268:
    label273:
    label278:
    label283:
    label288:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramString.putBoolean("question_scan_enter", bool1);
      break;
      bool1 = false;
      break label127;
      bool1 = false;
      break label147;
      bool1 = false;
      break label167;
      bool1 = false;
      break label187;
      bool1 = false;
      break label230;
    }
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString, 2);
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    boolean bool3 = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "ocr", 4);
    boolean bool1;
    if (paramInt == 1) {
      bool1 = localSharedPreferences.getBoolean("is_aio_support", false);
    }
    for (;;)
    {
      boolean bool2;
      if (avxv.a().jdField_a_of_type_Int == 1)
      {
        bool2 = true;
        label68:
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr", 2, "isSupportOcr, uin:" + paramString + "form:" + paramInt + ",isSupport:" + bool1 + ",dpcSwitch:" + bool2 + ",sdcard:" + avxe.a);
        }
        if ((!bool1) || (!bool2) || (!avxe.a)) {
          break label218;
        }
      }
      label218:
      for (bool1 = bool3;; bool1 = false)
      {
        return bool1;
        if (paramInt == 2)
        {
          bool1 = localSharedPreferences.getBoolean("is_qzone_support", false);
          break;
        }
        if (paramInt == 0)
        {
          bool1 = localSharedPreferences.getBoolean("is_scan_support", false);
          break;
        }
        if (paramInt != 7) {
          break label223;
        }
        bool1 = localSharedPreferences.getBoolean("is_chat_file_support", false);
        break;
        bool2 = false;
        break label68;
      }
      label223:
      bool1 = false;
    }
  }
  
  public int a()
  {
    OcrConfig localOcrConfig = a(true);
    if (localOcrConfig == null) {}
    for (int i = 0;; i = localOcrConfig.version)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.manager", 2, "getConfigVersion:" + i);
      }
      return i;
    }
  }
  
  public avwu a(List<OCRTextSearchInfo.SougouSearchInfo> paramList)
  {
    avwu localavwu = new avwu();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localavwu.jdField_a_of_type_JavaUtilList = new ArrayList();
      avws localavws = new avws();
      localavws.jdField_a_of_type_Int = 2049;
      localavws.jdField_a_of_type_JavaLangString = alud.a(2131708209);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo)paramList.next();
        avwt localavwt = new avwt();
        localavwt.jdField_a_of_type_JavaLangObject = localSougouSearchInfo;
        localavws.jdField_a_of_type_JavaUtilList.add(localavwt);
      }
      localavwu.jdField_a_of_type_JavaUtilList.add(localavws);
    }
    return localavwu;
  }
  
  public OcrConfig a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig == null) && (paramBoolean))
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.manager", 2, "getOCRConfig:" + this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig = OcrConfig.readFromFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.manager", 2, "loadConfigFromFile,mOcrConfig =   " + this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig);
        }
      }
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (!bdin.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      ((avvg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(113)).notifyUI(3, false, new Object[] { Integer.valueOf(-2), paramString1, null });
    }
    while ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    String str = paramString2;
    if (paramString2.length() > 300) {
      str = paramString2.substring(0, 300);
    }
    ((avvg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(113)).a(paramString1, str, paramLong);
  }
  
  /* Error */
  public void a(boolean paramBoolean, OcrConfig paramOcrConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +39 -> 44
    //   8: ldc 225
    //   10: iconst_2
    //   11: new 59	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 339
    //   21: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_1
    //   25: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: ldc_w 341
    //   31: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: iload_1
    //   45: ifeq +31 -> 76
    //   48: aload_0
    //   49: getfield 26	avvi:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   52: astore_3
    //   53: aload_3
    //   54: monitorenter
    //   55: aload_0
    //   56: aload_2
    //   57: putfield 284	avvi:jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig	Lcom/tencent/mobileqq/ocr/data/OcrConfig;
    //   60: aload_0
    //   61: getfield 28	avvi:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   64: invokevirtual 64	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   67: aload_0
    //   68: getfield 284	avvi:jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig	Lcom/tencent/mobileqq/ocr/data/OcrConfig;
    //   71: invokestatic 299	avvi:a	(Ljava/lang/String;Lcom/tencent/mobileqq/ocr/data/OcrConfig;)V
    //   74: aload_3
    //   75: monitorexit
    //   76: new 343	com/tencent/mobileqq/ocr/OCRManager$3
    //   79: dup
    //   80: aload_0
    //   81: iload_1
    //   82: invokespecial 346	com/tencent/mobileqq/ocr/OCRManager$3:<init>	(Lavvi;Z)V
    //   85: bipush 8
    //   87: aconst_null
    //   88: iconst_0
    //   89: invokestatic 54	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: astore_2
    //   96: aload_3
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    //   100: astore_2
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_2
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	avvi
    //   0	105	1	paramBoolean	boolean
    //   0	105	2	paramOcrConfig	OcrConfig
    // Exception table:
    //   from	to	target	type
    //   55	76	95	finally
    //   96	98	95	finally
    //   2	44	100	finally
    //   48	55	100	finally
    //   76	92	100	finally
    //   98	100	100	finally
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Avvk);
    this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avvi
 * JD-Core Version:    0.7.0.1
 */