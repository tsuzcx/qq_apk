import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OcrControl.1;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class aytd
{
  public static final HashMap<String, String> b;
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  apiu jdField_a_of_type_Apiu;
  apix jdField_a_of_type_Apix = new ayte(this);
  public ayrg a;
  private aytf jdField_a_of_type_Aytf;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, apkn> a;
  private Handler b;
  
  static
  {
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("zh", anvx.a(2131707245));
    jdField_b_of_type_JavaUtilHashMap.put("en", anvx.a(2131707264));
    jdField_b_of_type_JavaUtilHashMap.put("af", anvx.a(2131707268));
    jdField_b_of_type_JavaUtilHashMap.put("ar", anvx.a(2131707221));
    jdField_b_of_type_JavaUtilHashMap.put("eu", anvx.a(2131707256));
    jdField_b_of_type_JavaUtilHashMap.put("be", anvx.a(2131707219));
    jdField_b_of_type_JavaUtilHashMap.put("hr", anvx.a(2131707226));
    jdField_b_of_type_JavaUtilHashMap.put("da", anvx.a(2131707213));
    jdField_b_of_type_JavaUtilHashMap.put("nl", anvx.a(2131707249));
    jdField_b_of_type_JavaUtilHashMap.put("fo", anvx.a(2131707239));
    jdField_b_of_type_JavaUtilHashMap.put("fi", anvx.a(2131707230));
    jdField_b_of_type_JavaUtilHashMap.put("fr", anvx.a(2131707223));
    jdField_b_of_type_JavaUtilHashMap.put("gd", anvx.a(2131707262));
    jdField_b_of_type_JavaUtilHashMap.put("de", anvx.a(2131707214));
    jdField_b_of_type_JavaUtilHashMap.put("he", anvx.a(2131707244));
    jdField_b_of_type_JavaUtilHashMap.put("hu", anvx.a(2131707258));
    jdField_b_of_type_JavaUtilHashMap.put("id", anvx.a(2131707240));
    jdField_b_of_type_JavaUtilHashMap.put("it", anvx.a(2131707231));
    jdField_b_of_type_JavaUtilHashMap.put("kr", anvx.a(2131707254));
    jdField_b_of_type_JavaUtilHashMap.put("lv", anvx.a(2131707233));
    jdField_b_of_type_JavaUtilHashMap.put("mk", anvx.a(2131707266));
    jdField_b_of_type_JavaUtilHashMap.put("mt", anvx.a(2131707235));
    jdField_b_of_type_JavaUtilHashMap.put("no", anvx.a(2131707222));
    jdField_b_of_type_JavaUtilHashMap.put("pt", anvx.a(2131707246));
    jdField_b_of_type_JavaUtilHashMap.put("rm", anvx.a(2131707229));
    jdField_b_of_type_JavaUtilHashMap.put("ro", anvx.a(2131707227));
    jdField_b_of_type_JavaUtilHashMap.put("sr", anvx.a(2131707251));
    jdField_b_of_type_JavaUtilHashMap.put("sk", anvx.a(2131707253));
    jdField_b_of_type_JavaUtilHashMap.put("sb", anvx.a(2131707212));
    jdField_b_of_type_JavaUtilHashMap.put("es", anvx.a(2131707225));
    jdField_b_of_type_JavaUtilHashMap.put("sx", anvx.a(2131707234));
    jdField_b_of_type_JavaUtilHashMap.put("sv", anvx.a(2131707236));
    jdField_b_of_type_JavaUtilHashMap.put("ts", anvx.a(2131707218));
    jdField_b_of_type_JavaUtilHashMap.put("tr", anvx.a(2131707243));
    jdField_b_of_type_JavaUtilHashMap.put("ur", anvx.a(2131707267));
    jdField_b_of_type_JavaUtilHashMap.put("vi", anvx.a(2131707216));
    jdField_b_of_type_JavaUtilHashMap.put("ji", anvx.a(2131707209));
    jdField_b_of_type_JavaUtilHashMap.put("sq", anvx.a(2131707215));
    jdField_b_of_type_JavaUtilHashMap.put("bg", anvx.a(2131707224));
    jdField_b_of_type_JavaUtilHashMap.put("ca", anvx.a(2131707232));
    jdField_b_of_type_JavaUtilHashMap.put("cs", anvx.a(2131707259));
    jdField_b_of_type_JavaUtilHashMap.put("et", anvx.a(2131707257));
    jdField_b_of_type_JavaUtilHashMap.put("fa", anvx.a(2131707255));
    jdField_b_of_type_JavaUtilHashMap.put("ga", anvx.a(2131707252));
    jdField_b_of_type_JavaUtilHashMap.put("el", anvx.a(2131707261));
    jdField_b_of_type_JavaUtilHashMap.put("hi", anvx.a(2131707250));
    jdField_b_of_type_JavaUtilHashMap.put("is", anvx.a(2131707211));
    jdField_b_of_type_JavaUtilHashMap.put("jp", anvx.a(2131707265));
    jdField_b_of_type_JavaUtilHashMap.put("lt", anvx.a(2131707241));
    jdField_b_of_type_JavaUtilHashMap.put("ms", anvx.a(2131707210));
    jdField_b_of_type_JavaUtilHashMap.put("pl", anvx.a(2131707220));
    jdField_b_of_type_JavaUtilHashMap.put("ru", anvx.a(2131707217));
    jdField_b_of_type_JavaUtilHashMap.put("sz", anvx.a(2131707242));
    jdField_b_of_type_JavaUtilHashMap.put("sl", anvx.a(2131707248));
    jdField_b_of_type_JavaUtilHashMap.put("th", anvx.a(2131707238));
    jdField_b_of_type_JavaUtilHashMap.put("tn", anvx.a(2131707260));
    jdField_b_of_type_JavaUtilHashMap.put("uk", anvx.a(2131707237));
    jdField_b_of_type_JavaUtilHashMap.put("ve", anvx.a(2131707228));
    jdField_b_of_type_JavaUtilHashMap.put("xh", anvx.a(2131707263));
    jdField_b_of_type_JavaUtilHashMap.put("zu", anvx.a(2131707247));
  }
  
  public aytd(AppInterface paramAppInterface, aytf paramaytf, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Aytf = paramaytf;
    this.jdField_a_of_type_Apiu = new apiu(paramAppInterface);
    this.jdField_a_of_type_Apiu.a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Ayrg = ((ayrg)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.OCR_MANAGER));
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private apkn a(String paramString)
  {
    apkn localapkn = null;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "req had been remove, sessionId:" + paramString);
        }
        localapkn = (apkn)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      return localapkn;
    }
  }
  
  /* Error */
  private void a(apkn paramapkn)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 243	aytd:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +62 -> 72
    //   13: aload_1
    //   14: getfield 311	apkn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +52 -> 72
    //   23: aload_0
    //   24: getfield 243	aytd:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   27: aload_1
    //   28: getfield 311	apkn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: aload_1
    //   32: invokevirtual 39	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +33 -> 72
    //   42: ldc_w 283
    //   45: iconst_2
    //   46: new 285	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 313
    //   56: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: getfield 311	apkn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   63: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 300	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   0	87	0	this	aytd
    //   0	87	1	paramapkn	apkn
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
      if (this.jdField_a_of_type_Apiu != null) {
        this.jdField_a_of_type_Apiu.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "stopRecog...");
      }
      return;
    }
  }
  
  /* Error */
  public void a(apkm paramapkm, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 306	apkn
    //   5: dup
    //   6: invokespecial 376	apkn:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_0
    //   12: invokevirtual 378	aytd:a	()Ljava/lang/String;
    //   15: putfield 311	apkn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: aload_3
    //   19: aload_1
    //   20: putfield 381	apkn:jdField_a_of_type_Apkm	Lapkm;
    //   23: aload_3
    //   24: ldc_w 382
    //   27: putfield 384	apkn:jdField_b_of_type_Int	I
    //   30: aload_3
    //   31: ldc_w 382
    //   34: putfield 385	apkn:jdField_a_of_type_Int	I
    //   37: aload_3
    //   38: ldc2_w 386
    //   41: putfield 390	apkn:jdField_a_of_type_Long	J
    //   44: aload_3
    //   45: iconst_0
    //   46: putfield 393	apkn:jdField_c_of_type_Int	I
    //   49: aload_3
    //   50: aload_0
    //   51: getfield 230	aytd:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   54: invokevirtual 396	com/tencent/common/app/AppInterface:getAppid	()I
    //   57: invokestatic 398	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: putfield 400	apkn:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   63: aload_3
    //   64: aload_0
    //   65: getfield 230	aytd:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   68: invokevirtual 325	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: invokestatic 406	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   74: putfield 408	apkn:jdField_b_of_type_Long	J
    //   77: aload_3
    //   78: invokestatic 340	java/lang/System:currentTimeMillis	()J
    //   81: putfield 410	apkn:jdField_c_of_type_Long	J
    //   84: new 412	ayrd
    //   87: dup
    //   88: invokespecial 413	ayrd:<init>	()V
    //   91: astore 4
    //   93: aload_2
    //   94: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +9 -> 106
    //   100: aload 4
    //   102: aload_2
    //   103: putfield 414	ayrd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_3
    //   107: aload 4
    //   109: putfield 417	apkn:jdField_a_of_type_Ayrd	Layrd;
    //   112: aload_0
    //   113: aload_3
    //   114: invokespecial 419	aytd:a	(Lapkn;)V
    //   117: aload_3
    //   118: getfield 311	apkn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 263	aytd:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   126: new 421	com/tencent/mobileqq/ocr/OcrControl$2
    //   129: dup
    //   130: aload_0
    //   131: aload_2
    //   132: invokespecial 424	com/tencent/mobileqq/ocr/OcrControl$2:<init>	(Laytd;Ljava/lang/String;)V
    //   135: ldc2_w 425
    //   138: invokevirtual 430	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   141: pop
    //   142: aload_0
    //   143: getfield 239	aytd:jdField_a_of_type_Apiu	Lapiu;
    //   146: aload_3
    //   147: aload_0
    //   148: getfield 228	aytd:jdField_a_of_type_Apix	Lapix;
    //   151: invokevirtual 433	apiu:a	(Lapkn;Lapix;)Z
    //   154: ifeq +42 -> 196
    //   157: aload_0
    //   158: getfield 263	aytd:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   161: new 435	com/tencent/mobileqq/ocr/OcrControl$3
    //   164: dup
    //   165: aload_0
    //   166: aload_2
    //   167: aload_1
    //   168: invokespecial 438	com/tencent/mobileqq/ocr/OcrControl$3:<init>	(Laytd;Ljava/lang/String;Lapkm;)V
    //   171: ldc2_w 439
    //   174: invokevirtual 430	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   177: pop
    //   178: new 442	com/tencent/mobileqq/ocr/OcrControl$4
    //   181: dup
    //   182: aload_0
    //   183: aload_1
    //   184: invokespecial 445	com/tencent/mobileqq/ocr/OcrControl$4:<init>	(Laytd;Lapkm;)V
    //   187: iconst_5
    //   188: aconst_null
    //   189: iconst_0
    //   190: invokestatic 450	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   193: aload_0
    //   194: monitorexit
    //   195: return
    //   196: aload_0
    //   197: getfield 232	aytd:jdField_a_of_type_Aytf	Laytf;
    //   200: iconst_3
    //   201: aconst_null
    //   202: aload_1
    //   203: getfield 453	apkm:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   206: lconst_0
    //   207: invokeinterface 458 6 0
    //   212: goto -34 -> 178
    //   215: astore_1
    //   216: aload_0
    //   217: monitorexit
    //   218: aload_1
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	aytd
    //   0	220	1	paramapkm	apkm
    //   0	220	2	paramString	String
    //   9	138	3	localapkn	apkn
    //   91	17	4	localayrd	ayrd
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
    if (this.jdField_a_of_type_Apiu != null) {
      this.jdField_a_of_type_Apiu.a();
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
 * Qualified Name:     aytd
 * JD-Core Version:    0.7.0.1
 */