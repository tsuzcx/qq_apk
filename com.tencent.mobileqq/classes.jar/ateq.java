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

public class ateq
{
  public static final HashMap<String, String> b;
  int jdField_a_of_type_Int;
  akqi jdField_a_of_type_Akqi;
  akql jdField_a_of_type_Akql = new ater(this);
  Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public atdp a;
  private ates jdField_a_of_type_Ates;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, aksh> a;
  private Handler b;
  
  static
  {
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("zh", ajjy.a(2131642005));
    jdField_b_of_type_JavaUtilHashMap.put("en", ajjy.a(2131642024));
    jdField_b_of_type_JavaUtilHashMap.put("af", ajjy.a(2131642028));
    jdField_b_of_type_JavaUtilHashMap.put("ar", ajjy.a(2131641981));
    jdField_b_of_type_JavaUtilHashMap.put("eu", ajjy.a(2131642016));
    jdField_b_of_type_JavaUtilHashMap.put("be", ajjy.a(2131641979));
    jdField_b_of_type_JavaUtilHashMap.put("hr", ajjy.a(2131641986));
    jdField_b_of_type_JavaUtilHashMap.put("da", ajjy.a(2131641973));
    jdField_b_of_type_JavaUtilHashMap.put("nl", ajjy.a(2131642009));
    jdField_b_of_type_JavaUtilHashMap.put("fo", ajjy.a(2131641999));
    jdField_b_of_type_JavaUtilHashMap.put("fi", ajjy.a(2131641990));
    jdField_b_of_type_JavaUtilHashMap.put("fr", ajjy.a(2131641983));
    jdField_b_of_type_JavaUtilHashMap.put("gd", ajjy.a(2131642022));
    jdField_b_of_type_JavaUtilHashMap.put("de", ajjy.a(2131641974));
    jdField_b_of_type_JavaUtilHashMap.put("he", ajjy.a(2131642004));
    jdField_b_of_type_JavaUtilHashMap.put("hu", ajjy.a(2131642018));
    jdField_b_of_type_JavaUtilHashMap.put("id", ajjy.a(2131642000));
    jdField_b_of_type_JavaUtilHashMap.put("it", ajjy.a(2131641991));
    jdField_b_of_type_JavaUtilHashMap.put("kr", ajjy.a(2131642014));
    jdField_b_of_type_JavaUtilHashMap.put("lv", ajjy.a(2131641993));
    jdField_b_of_type_JavaUtilHashMap.put("mk", ajjy.a(2131642026));
    jdField_b_of_type_JavaUtilHashMap.put("mt", ajjy.a(2131641995));
    jdField_b_of_type_JavaUtilHashMap.put("no", ajjy.a(2131641982));
    jdField_b_of_type_JavaUtilHashMap.put("pt", ajjy.a(2131642006));
    jdField_b_of_type_JavaUtilHashMap.put("rm", ajjy.a(2131641989));
    jdField_b_of_type_JavaUtilHashMap.put("ro", ajjy.a(2131641987));
    jdField_b_of_type_JavaUtilHashMap.put("sr", ajjy.a(2131642011));
    jdField_b_of_type_JavaUtilHashMap.put("sk", ajjy.a(2131642013));
    jdField_b_of_type_JavaUtilHashMap.put("sb", ajjy.a(2131641972));
    jdField_b_of_type_JavaUtilHashMap.put("es", ajjy.a(2131641985));
    jdField_b_of_type_JavaUtilHashMap.put("sx", ajjy.a(2131641994));
    jdField_b_of_type_JavaUtilHashMap.put("sv", ajjy.a(2131641996));
    jdField_b_of_type_JavaUtilHashMap.put("ts", ajjy.a(2131641978));
    jdField_b_of_type_JavaUtilHashMap.put("tr", ajjy.a(2131642003));
    jdField_b_of_type_JavaUtilHashMap.put("ur", ajjy.a(2131642027));
    jdField_b_of_type_JavaUtilHashMap.put("vi", ajjy.a(2131641976));
    jdField_b_of_type_JavaUtilHashMap.put("ji", ajjy.a(2131641969));
    jdField_b_of_type_JavaUtilHashMap.put("sq", ajjy.a(2131641975));
    jdField_b_of_type_JavaUtilHashMap.put("bg", ajjy.a(2131641984));
    jdField_b_of_type_JavaUtilHashMap.put("ca", ajjy.a(2131641992));
    jdField_b_of_type_JavaUtilHashMap.put("cs", ajjy.a(2131642019));
    jdField_b_of_type_JavaUtilHashMap.put("et", ajjy.a(2131642017));
    jdField_b_of_type_JavaUtilHashMap.put("fa", ajjy.a(2131642015));
    jdField_b_of_type_JavaUtilHashMap.put("ga", ajjy.a(2131642012));
    jdField_b_of_type_JavaUtilHashMap.put("el", ajjy.a(2131642021));
    jdField_b_of_type_JavaUtilHashMap.put("hi", ajjy.a(2131642010));
    jdField_b_of_type_JavaUtilHashMap.put("is", ajjy.a(2131641971));
    jdField_b_of_type_JavaUtilHashMap.put("jp", ajjy.a(2131642025));
    jdField_b_of_type_JavaUtilHashMap.put("lt", ajjy.a(2131642001));
    jdField_b_of_type_JavaUtilHashMap.put("ms", ajjy.a(2131641970));
    jdField_b_of_type_JavaUtilHashMap.put("pl", ajjy.a(2131641980));
    jdField_b_of_type_JavaUtilHashMap.put("ru", ajjy.a(2131641977));
    jdField_b_of_type_JavaUtilHashMap.put("sz", ajjy.a(2131642002));
    jdField_b_of_type_JavaUtilHashMap.put("sl", ajjy.a(2131642008));
    jdField_b_of_type_JavaUtilHashMap.put("th", ajjy.a(2131641998));
    jdField_b_of_type_JavaUtilHashMap.put("tn", ajjy.a(2131642020));
    jdField_b_of_type_JavaUtilHashMap.put("uk", ajjy.a(2131641997));
    jdField_b_of_type_JavaUtilHashMap.put("ve", ajjy.a(2131641988));
    jdField_b_of_type_JavaUtilHashMap.put("xh", ajjy.a(2131642023));
    jdField_b_of_type_JavaUtilHashMap.put("zu", ajjy.a(2131642007));
  }
  
  public ateq(AppInterface paramAppInterface, ates paramates, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Ates = paramates;
    this.jdField_a_of_type_Akqi = new akqi(paramAppInterface);
    this.jdField_a_of_type_Akqi.a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Atdp = ((atdp)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(228));
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private aksh a(String paramString)
  {
    aksh localaksh = null;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "req had been remove, sessionId:" + paramString);
        }
        localaksh = (aksh)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      return localaksh;
    }
  }
  
  /* Error */
  private void a(aksh paramaksh)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 243	ateq:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +62 -> 72
    //   13: aload_1
    //   14: getfield 306	aksh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +52 -> 72
    //   23: aload_0
    //   24: getfield 243	ateq:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   27: aload_1
    //   28: getfield 306	aksh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   60: getfield 306	aksh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   0	87	0	this	ateq
    //   0	87	1	paramaksh	aksh
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
      if (this.jdField_a_of_type_Akqi != null) {
        this.jdField_a_of_type_Akqi.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "stopRecog...");
      }
      return;
    }
  }
  
  /* Error */
  public void a(aksg paramaksg, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 301	aksh
    //   5: dup
    //   6: invokespecial 371	aksh:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_0
    //   12: invokevirtual 373	ateq:a	()Ljava/lang/String;
    //   15: putfield 306	aksh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: aload_3
    //   19: aload_1
    //   20: putfield 376	aksh:jdField_a_of_type_Aksg	Laksg;
    //   23: aload_3
    //   24: ldc_w 377
    //   27: putfield 379	aksh:jdField_b_of_type_Int	I
    //   30: aload_3
    //   31: ldc_w 377
    //   34: putfield 380	aksh:jdField_a_of_type_Int	I
    //   37: aload_3
    //   38: ldc2_w 381
    //   41: putfield 385	aksh:jdField_a_of_type_Long	J
    //   44: aload_3
    //   45: iconst_0
    //   46: putfield 388	aksh:jdField_c_of_type_Int	I
    //   49: aload_3
    //   50: aload_0
    //   51: getfield 230	ateq:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   54: invokevirtual 391	com/tencent/common/app/AppInterface:getAppid	()I
    //   57: invokestatic 393	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: putfield 395	aksh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   63: aload_3
    //   64: aload_0
    //   65: getfield 230	ateq:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   68: invokevirtual 320	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: invokestatic 401	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   74: putfield 403	aksh:jdField_b_of_type_Long	J
    //   77: aload_3
    //   78: invokestatic 335	java/lang/System:currentTimeMillis	()J
    //   81: putfield 405	aksh:jdField_c_of_type_Long	J
    //   84: new 407	atdm
    //   87: dup
    //   88: invokespecial 408	atdm:<init>	()V
    //   91: astore 4
    //   93: aload_2
    //   94: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +9 -> 106
    //   100: aload 4
    //   102: aload_2
    //   103: putfield 409	atdm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_3
    //   107: aload 4
    //   109: putfield 412	aksh:jdField_a_of_type_Atdm	Latdm;
    //   112: aload_0
    //   113: aload_3
    //   114: invokespecial 414	ateq:a	(Laksh;)V
    //   117: aload_3
    //   118: getfield 306	aksh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 258	ateq:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   126: new 416	com/tencent/mobileqq/ocr/OcrControl$2
    //   129: dup
    //   130: aload_0
    //   131: aload_2
    //   132: invokespecial 419	com/tencent/mobileqq/ocr/OcrControl$2:<init>	(Lateq;Ljava/lang/String;)V
    //   135: ldc2_w 420
    //   138: invokevirtual 425	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   141: pop
    //   142: aload_0
    //   143: getfield 239	ateq:jdField_a_of_type_Akqi	Lakqi;
    //   146: aload_3
    //   147: aload_0
    //   148: getfield 228	ateq:jdField_a_of_type_Akql	Lakql;
    //   151: invokevirtual 428	akqi:a	(Laksh;Lakql;)Z
    //   154: ifeq +42 -> 196
    //   157: aload_0
    //   158: getfield 258	ateq:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   161: new 430	com/tencent/mobileqq/ocr/OcrControl$3
    //   164: dup
    //   165: aload_0
    //   166: aload_2
    //   167: aload_1
    //   168: invokespecial 433	com/tencent/mobileqq/ocr/OcrControl$3:<init>	(Lateq;Ljava/lang/String;Laksg;)V
    //   171: ldc2_w 434
    //   174: invokevirtual 425	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   177: pop
    //   178: new 437	com/tencent/mobileqq/ocr/OcrControl$4
    //   181: dup
    //   182: aload_0
    //   183: aload_1
    //   184: invokespecial 440	com/tencent/mobileqq/ocr/OcrControl$4:<init>	(Lateq;Laksg;)V
    //   187: iconst_5
    //   188: aconst_null
    //   189: iconst_0
    //   190: invokestatic 445	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   193: aload_0
    //   194: monitorexit
    //   195: return
    //   196: aload_0
    //   197: getfield 232	ateq:jdField_a_of_type_Ates	Lates;
    //   200: iconst_3
    //   201: aconst_null
    //   202: aload_1
    //   203: getfield 448	aksg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   0	220	0	this	ateq
    //   0	220	1	paramaksg	aksg
    //   0	220	2	paramString	String
    //   9	138	3	localaksh	aksh
    //   91	17	4	localatdm	atdm
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
    if (this.jdField_a_of_type_Akqi != null) {
      this.jdField_a_of_type_Akqi.a();
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
 * Qualified Name:     ateq
 * JD-Core Version:    0.7.0.1
 */