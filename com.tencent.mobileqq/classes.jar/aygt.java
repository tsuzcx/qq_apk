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

public class aygt
{
  public static final HashMap<String, String> b;
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  aoyp jdField_a_of_type_Aoyp;
  aoys jdField_a_of_type_Aoys = new aygu(this);
  public ayfa a;
  private aygv jdField_a_of_type_Aygv;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, apai> a;
  private Handler b;
  
  static
  {
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("zh", anni.a(2131706562));
    jdField_b_of_type_JavaUtilHashMap.put("en", anni.a(2131706581));
    jdField_b_of_type_JavaUtilHashMap.put("af", anni.a(2131706585));
    jdField_b_of_type_JavaUtilHashMap.put("ar", anni.a(2131706538));
    jdField_b_of_type_JavaUtilHashMap.put("eu", anni.a(2131706573));
    jdField_b_of_type_JavaUtilHashMap.put("be", anni.a(2131706536));
    jdField_b_of_type_JavaUtilHashMap.put("hr", anni.a(2131706543));
    jdField_b_of_type_JavaUtilHashMap.put("da", anni.a(2131706530));
    jdField_b_of_type_JavaUtilHashMap.put("nl", anni.a(2131706566));
    jdField_b_of_type_JavaUtilHashMap.put("fo", anni.a(2131706556));
    jdField_b_of_type_JavaUtilHashMap.put("fi", anni.a(2131706547));
    jdField_b_of_type_JavaUtilHashMap.put("fr", anni.a(2131706540));
    jdField_b_of_type_JavaUtilHashMap.put("gd", anni.a(2131706579));
    jdField_b_of_type_JavaUtilHashMap.put("de", anni.a(2131706531));
    jdField_b_of_type_JavaUtilHashMap.put("he", anni.a(2131706561));
    jdField_b_of_type_JavaUtilHashMap.put("hu", anni.a(2131706575));
    jdField_b_of_type_JavaUtilHashMap.put("id", anni.a(2131706557));
    jdField_b_of_type_JavaUtilHashMap.put("it", anni.a(2131706548));
    jdField_b_of_type_JavaUtilHashMap.put("kr", anni.a(2131706571));
    jdField_b_of_type_JavaUtilHashMap.put("lv", anni.a(2131706550));
    jdField_b_of_type_JavaUtilHashMap.put("mk", anni.a(2131706583));
    jdField_b_of_type_JavaUtilHashMap.put("mt", anni.a(2131706552));
    jdField_b_of_type_JavaUtilHashMap.put("no", anni.a(2131706539));
    jdField_b_of_type_JavaUtilHashMap.put("pt", anni.a(2131706563));
    jdField_b_of_type_JavaUtilHashMap.put("rm", anni.a(2131706546));
    jdField_b_of_type_JavaUtilHashMap.put("ro", anni.a(2131706544));
    jdField_b_of_type_JavaUtilHashMap.put("sr", anni.a(2131706568));
    jdField_b_of_type_JavaUtilHashMap.put("sk", anni.a(2131706570));
    jdField_b_of_type_JavaUtilHashMap.put("sb", anni.a(2131706529));
    jdField_b_of_type_JavaUtilHashMap.put("es", anni.a(2131706542));
    jdField_b_of_type_JavaUtilHashMap.put("sx", anni.a(2131706551));
    jdField_b_of_type_JavaUtilHashMap.put("sv", anni.a(2131706553));
    jdField_b_of_type_JavaUtilHashMap.put("ts", anni.a(2131706535));
    jdField_b_of_type_JavaUtilHashMap.put("tr", anni.a(2131706560));
    jdField_b_of_type_JavaUtilHashMap.put("ur", anni.a(2131706584));
    jdField_b_of_type_JavaUtilHashMap.put("vi", anni.a(2131706533));
    jdField_b_of_type_JavaUtilHashMap.put("ji", anni.a(2131706526));
    jdField_b_of_type_JavaUtilHashMap.put("sq", anni.a(2131706532));
    jdField_b_of_type_JavaUtilHashMap.put("bg", anni.a(2131706541));
    jdField_b_of_type_JavaUtilHashMap.put("ca", anni.a(2131706549));
    jdField_b_of_type_JavaUtilHashMap.put("cs", anni.a(2131706576));
    jdField_b_of_type_JavaUtilHashMap.put("et", anni.a(2131706574));
    jdField_b_of_type_JavaUtilHashMap.put("fa", anni.a(2131706572));
    jdField_b_of_type_JavaUtilHashMap.put("ga", anni.a(2131706569));
    jdField_b_of_type_JavaUtilHashMap.put("el", anni.a(2131706578));
    jdField_b_of_type_JavaUtilHashMap.put("hi", anni.a(2131706567));
    jdField_b_of_type_JavaUtilHashMap.put("is", anni.a(2131706528));
    jdField_b_of_type_JavaUtilHashMap.put("jp", anni.a(2131706582));
    jdField_b_of_type_JavaUtilHashMap.put("lt", anni.a(2131706558));
    jdField_b_of_type_JavaUtilHashMap.put("ms", anni.a(2131706527));
    jdField_b_of_type_JavaUtilHashMap.put("pl", anni.a(2131706537));
    jdField_b_of_type_JavaUtilHashMap.put("ru", anni.a(2131706534));
    jdField_b_of_type_JavaUtilHashMap.put("sz", anni.a(2131706559));
    jdField_b_of_type_JavaUtilHashMap.put("sl", anni.a(2131706565));
    jdField_b_of_type_JavaUtilHashMap.put("th", anni.a(2131706555));
    jdField_b_of_type_JavaUtilHashMap.put("tn", anni.a(2131706577));
    jdField_b_of_type_JavaUtilHashMap.put("uk", anni.a(2131706554));
    jdField_b_of_type_JavaUtilHashMap.put("ve", anni.a(2131706545));
    jdField_b_of_type_JavaUtilHashMap.put("xh", anni.a(2131706580));
    jdField_b_of_type_JavaUtilHashMap.put("zu", anni.a(2131706564));
  }
  
  public aygt(AppInterface paramAppInterface, aygv paramaygv, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Aygv = paramaygv;
    this.jdField_a_of_type_Aoyp = new aoyp(paramAppInterface);
    this.jdField_a_of_type_Aoyp.a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Ayfa = ((ayfa)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(228));
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private apai a(String paramString)
  {
    apai localapai = null;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "req had been remove, sessionId:" + paramString);
        }
        localapai = (apai)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      return localapai;
    }
  }
  
  /* Error */
  private void a(apai paramapai)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 243	aygt:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +62 -> 72
    //   13: aload_1
    //   14: getfield 306	apai:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +52 -> 72
    //   23: aload_0
    //   24: getfield 243	aygt:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   27: aload_1
    //   28: getfield 306	apai:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   60: getfield 306	apai:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   0	87	0	this	aygt
    //   0	87	1	paramapai	apai
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
      if (this.jdField_a_of_type_Aoyp != null) {
        this.jdField_a_of_type_Aoyp.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "stopRecog...");
      }
      return;
    }
  }
  
  /* Error */
  public void a(apah paramapah, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 301	apai
    //   5: dup
    //   6: invokespecial 371	apai:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_0
    //   12: invokevirtual 373	aygt:a	()Ljava/lang/String;
    //   15: putfield 306	apai:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: aload_3
    //   19: aload_1
    //   20: putfield 376	apai:jdField_a_of_type_Apah	Lapah;
    //   23: aload_3
    //   24: ldc_w 377
    //   27: putfield 379	apai:jdField_b_of_type_Int	I
    //   30: aload_3
    //   31: ldc_w 377
    //   34: putfield 380	apai:jdField_a_of_type_Int	I
    //   37: aload_3
    //   38: ldc2_w 381
    //   41: putfield 385	apai:jdField_a_of_type_Long	J
    //   44: aload_3
    //   45: iconst_0
    //   46: putfield 388	apai:jdField_c_of_type_Int	I
    //   49: aload_3
    //   50: aload_0
    //   51: getfield 230	aygt:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   54: invokevirtual 391	com/tencent/common/app/AppInterface:getAppid	()I
    //   57: invokestatic 393	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: putfield 395	apai:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   63: aload_3
    //   64: aload_0
    //   65: getfield 230	aygt:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   68: invokevirtual 320	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: invokestatic 401	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   74: putfield 403	apai:jdField_b_of_type_Long	J
    //   77: aload_3
    //   78: invokestatic 335	java/lang/System:currentTimeMillis	()J
    //   81: putfield 405	apai:jdField_c_of_type_Long	J
    //   84: new 407	ayex
    //   87: dup
    //   88: invokespecial 408	ayex:<init>	()V
    //   91: astore 4
    //   93: aload_2
    //   94: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +9 -> 106
    //   100: aload 4
    //   102: aload_2
    //   103: putfield 409	ayex:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_3
    //   107: aload 4
    //   109: putfield 412	apai:jdField_a_of_type_Ayex	Layex;
    //   112: aload_0
    //   113: aload_3
    //   114: invokespecial 414	aygt:a	(Lapai;)V
    //   117: aload_3
    //   118: getfield 306	apai:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 258	aygt:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   126: new 416	com/tencent/mobileqq/ocr/OcrControl$2
    //   129: dup
    //   130: aload_0
    //   131: aload_2
    //   132: invokespecial 419	com/tencent/mobileqq/ocr/OcrControl$2:<init>	(Laygt;Ljava/lang/String;)V
    //   135: ldc2_w 420
    //   138: invokevirtual 425	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   141: pop
    //   142: aload_0
    //   143: getfield 239	aygt:jdField_a_of_type_Aoyp	Laoyp;
    //   146: aload_3
    //   147: aload_0
    //   148: getfield 228	aygt:jdField_a_of_type_Aoys	Laoys;
    //   151: invokevirtual 428	aoyp:a	(Lapai;Laoys;)Z
    //   154: ifeq +42 -> 196
    //   157: aload_0
    //   158: getfield 258	aygt:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   161: new 430	com/tencent/mobileqq/ocr/OcrControl$3
    //   164: dup
    //   165: aload_0
    //   166: aload_2
    //   167: aload_1
    //   168: invokespecial 433	com/tencent/mobileqq/ocr/OcrControl$3:<init>	(Laygt;Ljava/lang/String;Lapah;)V
    //   171: ldc2_w 434
    //   174: invokevirtual 425	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   177: pop
    //   178: new 437	com/tencent/mobileqq/ocr/OcrControl$4
    //   181: dup
    //   182: aload_0
    //   183: aload_1
    //   184: invokespecial 440	com/tencent/mobileqq/ocr/OcrControl$4:<init>	(Laygt;Lapah;)V
    //   187: iconst_5
    //   188: aconst_null
    //   189: iconst_0
    //   190: invokestatic 445	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   193: aload_0
    //   194: monitorexit
    //   195: return
    //   196: aload_0
    //   197: getfield 232	aygt:jdField_a_of_type_Aygv	Laygv;
    //   200: iconst_3
    //   201: aconst_null
    //   202: aload_1
    //   203: getfield 448	apah:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   0	220	0	this	aygt
    //   0	220	1	paramapah	apah
    //   0	220	2	paramString	String
    //   9	138	3	localapai	apai
    //   91	17	4	localayex	ayex
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
    if (this.jdField_a_of_type_Aoyp != null) {
      this.jdField_a_of_type_Aoyp.a();
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
 * Qualified Name:     aygt
 * JD-Core Version:    0.7.0.1
 */