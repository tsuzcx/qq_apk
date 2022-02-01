import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OcrControl.1;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class ayzm
{
  public static final HashMap<String, String> b;
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  apmf jdField_a_of_type_Apmf;
  apmi jdField_a_of_type_Apmi = new ayzn(this);
  public ayxt a;
  private ayzo jdField_a_of_type_Ayzo;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, apny> a;
  private Handler b;
  
  static
  {
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("zh", anzj.a(2131706669));
    jdField_b_of_type_JavaUtilHashMap.put("en", anzj.a(2131706688));
    jdField_b_of_type_JavaUtilHashMap.put("af", anzj.a(2131706692));
    jdField_b_of_type_JavaUtilHashMap.put("ar", anzj.a(2131706645));
    jdField_b_of_type_JavaUtilHashMap.put("eu", anzj.a(2131706680));
    jdField_b_of_type_JavaUtilHashMap.put("be", anzj.a(2131706643));
    jdField_b_of_type_JavaUtilHashMap.put("hr", anzj.a(2131706650));
    jdField_b_of_type_JavaUtilHashMap.put("da", anzj.a(2131706637));
    jdField_b_of_type_JavaUtilHashMap.put("nl", anzj.a(2131706673));
    jdField_b_of_type_JavaUtilHashMap.put("fo", anzj.a(2131706663));
    jdField_b_of_type_JavaUtilHashMap.put("fi", anzj.a(2131706654));
    jdField_b_of_type_JavaUtilHashMap.put("fr", anzj.a(2131706647));
    jdField_b_of_type_JavaUtilHashMap.put("gd", anzj.a(2131706686));
    jdField_b_of_type_JavaUtilHashMap.put("de", anzj.a(2131706638));
    jdField_b_of_type_JavaUtilHashMap.put("he", anzj.a(2131706668));
    jdField_b_of_type_JavaUtilHashMap.put("hu", anzj.a(2131706682));
    jdField_b_of_type_JavaUtilHashMap.put("id", anzj.a(2131706664));
    jdField_b_of_type_JavaUtilHashMap.put("it", anzj.a(2131706655));
    jdField_b_of_type_JavaUtilHashMap.put("kr", anzj.a(2131706678));
    jdField_b_of_type_JavaUtilHashMap.put("lv", anzj.a(2131706657));
    jdField_b_of_type_JavaUtilHashMap.put("mk", anzj.a(2131706690));
    jdField_b_of_type_JavaUtilHashMap.put("mt", anzj.a(2131706659));
    jdField_b_of_type_JavaUtilHashMap.put("no", anzj.a(2131706646));
    jdField_b_of_type_JavaUtilHashMap.put("pt", anzj.a(2131706670));
    jdField_b_of_type_JavaUtilHashMap.put("rm", anzj.a(2131706653));
    jdField_b_of_type_JavaUtilHashMap.put("ro", anzj.a(2131706651));
    jdField_b_of_type_JavaUtilHashMap.put("sr", anzj.a(2131706675));
    jdField_b_of_type_JavaUtilHashMap.put("sk", anzj.a(2131706677));
    jdField_b_of_type_JavaUtilHashMap.put("sb", anzj.a(2131706636));
    jdField_b_of_type_JavaUtilHashMap.put("es", anzj.a(2131706649));
    jdField_b_of_type_JavaUtilHashMap.put("sx", anzj.a(2131706658));
    jdField_b_of_type_JavaUtilHashMap.put("sv", anzj.a(2131706660));
    jdField_b_of_type_JavaUtilHashMap.put("ts", anzj.a(2131706642));
    jdField_b_of_type_JavaUtilHashMap.put("tr", anzj.a(2131706667));
    jdField_b_of_type_JavaUtilHashMap.put("ur", anzj.a(2131706691));
    jdField_b_of_type_JavaUtilHashMap.put("vi", anzj.a(2131706640));
    jdField_b_of_type_JavaUtilHashMap.put("ji", anzj.a(2131706633));
    jdField_b_of_type_JavaUtilHashMap.put("sq", anzj.a(2131706639));
    jdField_b_of_type_JavaUtilHashMap.put("bg", anzj.a(2131706648));
    jdField_b_of_type_JavaUtilHashMap.put("ca", anzj.a(2131706656));
    jdField_b_of_type_JavaUtilHashMap.put("cs", anzj.a(2131706683));
    jdField_b_of_type_JavaUtilHashMap.put("et", anzj.a(2131706681));
    jdField_b_of_type_JavaUtilHashMap.put("fa", anzj.a(2131706679));
    jdField_b_of_type_JavaUtilHashMap.put("ga", anzj.a(2131706676));
    jdField_b_of_type_JavaUtilHashMap.put("el", anzj.a(2131706685));
    jdField_b_of_type_JavaUtilHashMap.put("hi", anzj.a(2131706674));
    jdField_b_of_type_JavaUtilHashMap.put("is", anzj.a(2131706635));
    jdField_b_of_type_JavaUtilHashMap.put("jp", anzj.a(2131706689));
    jdField_b_of_type_JavaUtilHashMap.put("lt", anzj.a(2131706665));
    jdField_b_of_type_JavaUtilHashMap.put("ms", anzj.a(2131706634));
    jdField_b_of_type_JavaUtilHashMap.put("pl", anzj.a(2131706644));
    jdField_b_of_type_JavaUtilHashMap.put("ru", anzj.a(2131706641));
    jdField_b_of_type_JavaUtilHashMap.put("sz", anzj.a(2131706666));
    jdField_b_of_type_JavaUtilHashMap.put("sl", anzj.a(2131706672));
    jdField_b_of_type_JavaUtilHashMap.put("th", anzj.a(2131706662));
    jdField_b_of_type_JavaUtilHashMap.put("tn", anzj.a(2131706684));
    jdField_b_of_type_JavaUtilHashMap.put("uk", anzj.a(2131706661));
    jdField_b_of_type_JavaUtilHashMap.put("ve", anzj.a(2131706652));
    jdField_b_of_type_JavaUtilHashMap.put("xh", anzj.a(2131706687));
    jdField_b_of_type_JavaUtilHashMap.put("zu", anzj.a(2131706671));
  }
  
  public ayzm(AppInterface paramAppInterface, ayzo paramayzo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Ayzo = paramayzo;
    this.jdField_a_of_type_Apmf = new apmf(paramAppInterface);
    this.jdField_a_of_type_Apmf.a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Ayxt = ((ayxt)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(228));
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private apny a(String paramString)
  {
    apny localapny = null;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "req had been remove, sessionId:" + paramString);
        }
        localapny = (apny)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      return localapny;
    }
  }
  
  /* Error */
  private void a(apny paramapny)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 243	ayzm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +62 -> 72
    //   13: aload_1
    //   14: getfield 306	apny:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +52 -> 72
    //   23: aload_0
    //   24: getfield 243	ayzm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   27: aload_1
    //   28: getfield 306	apny:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: aload_1
    //   32: invokevirtual 39	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +33 -> 72
    //   42: ldc_w 278
    //   45: iconst_2
    //   46: new 280	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 308
    //   56: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: getfield 306	apny:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   63: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_2
    //   73: monitorexit
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: aload_2
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	ayzm
    //   0	87	1	paramapny	apny
    //   6	73	2	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   13	72	77	finally
    //   72	74	77	finally
    //   78	80	77	finally
    //   2	9	82	finally
    //   80	82	82	finally
  }
  
  private void a(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.post(paramRunnable);
      }
      return;
    }
  }
  
  public String a()
  {
    return String.format("%s_%s_%05d", new Object[] { this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)) });
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      if (this.jdField_a_of_type_Apmf != null) {
        this.jdField_a_of_type_Apmf.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "stopRecog...");
      }
      return;
    }
  }
  
  /* Error */
  public void a(apnx paramapnx, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 301	apny
    //   5: dup
    //   6: invokespecial 371	apny:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_0
    //   12: invokevirtual 373	ayzm:a	()Ljava/lang/String;
    //   15: putfield 306	apny:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: aload_3
    //   19: aload_1
    //   20: putfield 376	apny:jdField_a_of_type_Apnx	Lapnx;
    //   23: aload_3
    //   24: ldc_w 377
    //   27: putfield 379	apny:jdField_b_of_type_Int	I
    //   30: aload_3
    //   31: ldc_w 377
    //   34: putfield 380	apny:jdField_a_of_type_Int	I
    //   37: aload_3
    //   38: ldc2_w 381
    //   41: putfield 385	apny:jdField_a_of_type_Long	J
    //   44: aload_3
    //   45: iconst_0
    //   46: putfield 388	apny:jdField_c_of_type_Int	I
    //   49: aload_3
    //   50: aload_0
    //   51: getfield 230	ayzm:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   54: invokevirtual 391	com/tencent/common/app/AppInterface:getAppid	()I
    //   57: invokestatic 393	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: putfield 395	apny:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   63: aload_3
    //   64: aload_0
    //   65: getfield 230	ayzm:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   68: invokevirtual 320	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: invokestatic 401	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   74: putfield 403	apny:jdField_b_of_type_Long	J
    //   77: aload_3
    //   78: invokestatic 335	java/lang/System:currentTimeMillis	()J
    //   81: putfield 405	apny:jdField_c_of_type_Long	J
    //   84: new 407	ayxq
    //   87: dup
    //   88: invokespecial 408	ayxq:<init>	()V
    //   91: astore 4
    //   93: aload_2
    //   94: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +9 -> 106
    //   100: aload 4
    //   102: aload_2
    //   103: putfield 409	ayxq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_3
    //   107: aload 4
    //   109: putfield 412	apny:jdField_a_of_type_Ayxq	Layxq;
    //   112: aload_0
    //   113: aload_3
    //   114: invokespecial 414	ayzm:a	(Lapny;)V
    //   117: aload_3
    //   118: getfield 306	apny:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 258	ayzm:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   126: new 416	com/tencent/mobileqq/ocr/OcrControl$2
    //   129: dup
    //   130: aload_0
    //   131: aload_2
    //   132: invokespecial 419	com/tencent/mobileqq/ocr/OcrControl$2:<init>	(Layzm;Ljava/lang/String;)V
    //   135: ldc2_w 420
    //   138: invokevirtual 425	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   141: pop
    //   142: aload_0
    //   143: getfield 239	ayzm:jdField_a_of_type_Apmf	Lapmf;
    //   146: aload_3
    //   147: aload_0
    //   148: getfield 228	ayzm:jdField_a_of_type_Apmi	Lapmi;
    //   151: invokevirtual 428	apmf:a	(Lapny;Lapmi;)Z
    //   154: ifeq +42 -> 196
    //   157: aload_0
    //   158: getfield 258	ayzm:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   161: new 430	com/tencent/mobileqq/ocr/OcrControl$3
    //   164: dup
    //   165: aload_0
    //   166: aload_2
    //   167: aload_1
    //   168: invokespecial 433	com/tencent/mobileqq/ocr/OcrControl$3:<init>	(Layzm;Ljava/lang/String;Lapnx;)V
    //   171: ldc2_w 434
    //   174: invokevirtual 425	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   177: pop
    //   178: new 437	com/tencent/mobileqq/ocr/OcrControl$4
    //   181: dup
    //   182: aload_0
    //   183: aload_1
    //   184: invokespecial 440	com/tencent/mobileqq/ocr/OcrControl$4:<init>	(Layzm;Lapnx;)V
    //   187: iconst_5
    //   188: aconst_null
    //   189: iconst_0
    //   190: invokestatic 445	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   193: aload_0
    //   194: monitorexit
    //   195: return
    //   196: aload_0
    //   197: getfield 232	ayzm:jdField_a_of_type_Ayzo	Layzo;
    //   200: iconst_3
    //   201: aconst_null
    //   202: aload_1
    //   203: getfield 448	apnx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   206: lconst_0
    //   207: invokeinterface 453 6 0
    //   212: goto -34 -> 178
    //   215: astore_1
    //   216: aload_0
    //   217: monitorexit
    //   218: aload_1
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	ayzm
    //   0	220	1	paramapnx	apnx
    //   0	220	2	paramString	String
    //   9	138	3	localapny	apny
    //   91	17	4	localayxq	ayxq
    // Exception table:
    //   from	to	target	type
    //   2	106	215	finally
    //   106	178	215	finally
    //   178	193	215	finally
    //   196	212	215	finally
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, null);
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "recogPic picPath:" + paramString1 + ",needCompress:" + paramBoolean);
    }
    a(new OcrControl.1(this, paramString1, paramBoolean, paramString2));
  }
  
  public void b()
  {
    try
    {
      QLog.i("Q.ocr.control", 1, "startUploadThread.");
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("ocr_upload_thread" + System.currentTimeMillis(), 0);
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      QLog.i("Q.ocr.control", 1, "stopUploadThread.");
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      this.jdField_b_of_type_AndroidOsHandler = null;
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
        this.jdField_a_of_type_AndroidOsHandlerThread.interrupt();
      }
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      return;
    }
    finally {}
  }
  
  public void d()
  {
    b();
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "Ocr control start");
    }
  }
  
  public void e()
  {
    c();
    if (this.jdField_a_of_type_Apmf != null) {
      this.jdField_a_of_type_Apmf.a();
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "Ocr control stop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzm
 * JD-Core Version:    0.7.0.1
 */