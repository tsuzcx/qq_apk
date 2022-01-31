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

public class aubo
{
  public static final HashMap<String, String> b;
  int jdField_a_of_type_Int;
  alet jdField_a_of_type_Alet;
  alew jdField_a_of_type_Alew = new aubp(this);
  Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public atzv a;
  private aubq jdField_a_of_type_Aubq;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, algs> a;
  private Handler b;
  
  static
  {
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("zh", ajya.a(2131707801));
    jdField_b_of_type_JavaUtilHashMap.put("en", ajya.a(2131707820));
    jdField_b_of_type_JavaUtilHashMap.put("af", ajya.a(2131707824));
    jdField_b_of_type_JavaUtilHashMap.put("ar", ajya.a(2131707777));
    jdField_b_of_type_JavaUtilHashMap.put("eu", ajya.a(2131707812));
    jdField_b_of_type_JavaUtilHashMap.put("be", ajya.a(2131707775));
    jdField_b_of_type_JavaUtilHashMap.put("hr", ajya.a(2131707782));
    jdField_b_of_type_JavaUtilHashMap.put("da", ajya.a(2131707769));
    jdField_b_of_type_JavaUtilHashMap.put("nl", ajya.a(2131707805));
    jdField_b_of_type_JavaUtilHashMap.put("fo", ajya.a(2131707795));
    jdField_b_of_type_JavaUtilHashMap.put("fi", ajya.a(2131707786));
    jdField_b_of_type_JavaUtilHashMap.put("fr", ajya.a(2131707779));
    jdField_b_of_type_JavaUtilHashMap.put("gd", ajya.a(2131707818));
    jdField_b_of_type_JavaUtilHashMap.put("de", ajya.a(2131707770));
    jdField_b_of_type_JavaUtilHashMap.put("he", ajya.a(2131707800));
    jdField_b_of_type_JavaUtilHashMap.put("hu", ajya.a(2131707814));
    jdField_b_of_type_JavaUtilHashMap.put("id", ajya.a(2131707796));
    jdField_b_of_type_JavaUtilHashMap.put("it", ajya.a(2131707787));
    jdField_b_of_type_JavaUtilHashMap.put("kr", ajya.a(2131707810));
    jdField_b_of_type_JavaUtilHashMap.put("lv", ajya.a(2131707789));
    jdField_b_of_type_JavaUtilHashMap.put("mk", ajya.a(2131707822));
    jdField_b_of_type_JavaUtilHashMap.put("mt", ajya.a(2131707791));
    jdField_b_of_type_JavaUtilHashMap.put("no", ajya.a(2131707778));
    jdField_b_of_type_JavaUtilHashMap.put("pt", ajya.a(2131707802));
    jdField_b_of_type_JavaUtilHashMap.put("rm", ajya.a(2131707785));
    jdField_b_of_type_JavaUtilHashMap.put("ro", ajya.a(2131707783));
    jdField_b_of_type_JavaUtilHashMap.put("sr", ajya.a(2131707807));
    jdField_b_of_type_JavaUtilHashMap.put("sk", ajya.a(2131707809));
    jdField_b_of_type_JavaUtilHashMap.put("sb", ajya.a(2131707768));
    jdField_b_of_type_JavaUtilHashMap.put("es", ajya.a(2131707781));
    jdField_b_of_type_JavaUtilHashMap.put("sx", ajya.a(2131707790));
    jdField_b_of_type_JavaUtilHashMap.put("sv", ajya.a(2131707792));
    jdField_b_of_type_JavaUtilHashMap.put("ts", ajya.a(2131707774));
    jdField_b_of_type_JavaUtilHashMap.put("tr", ajya.a(2131707799));
    jdField_b_of_type_JavaUtilHashMap.put("ur", ajya.a(2131707823));
    jdField_b_of_type_JavaUtilHashMap.put("vi", ajya.a(2131707772));
    jdField_b_of_type_JavaUtilHashMap.put("ji", ajya.a(2131707765));
    jdField_b_of_type_JavaUtilHashMap.put("sq", ajya.a(2131707771));
    jdField_b_of_type_JavaUtilHashMap.put("bg", ajya.a(2131707780));
    jdField_b_of_type_JavaUtilHashMap.put("ca", ajya.a(2131707788));
    jdField_b_of_type_JavaUtilHashMap.put("cs", ajya.a(2131707815));
    jdField_b_of_type_JavaUtilHashMap.put("et", ajya.a(2131707813));
    jdField_b_of_type_JavaUtilHashMap.put("fa", ajya.a(2131707811));
    jdField_b_of_type_JavaUtilHashMap.put("ga", ajya.a(2131707808));
    jdField_b_of_type_JavaUtilHashMap.put("el", ajya.a(2131707817));
    jdField_b_of_type_JavaUtilHashMap.put("hi", ajya.a(2131707806));
    jdField_b_of_type_JavaUtilHashMap.put("is", ajya.a(2131707767));
    jdField_b_of_type_JavaUtilHashMap.put("jp", ajya.a(2131707821));
    jdField_b_of_type_JavaUtilHashMap.put("lt", ajya.a(2131707797));
    jdField_b_of_type_JavaUtilHashMap.put("ms", ajya.a(2131707766));
    jdField_b_of_type_JavaUtilHashMap.put("pl", ajya.a(2131707776));
    jdField_b_of_type_JavaUtilHashMap.put("ru", ajya.a(2131707773));
    jdField_b_of_type_JavaUtilHashMap.put("sz", ajya.a(2131707798));
    jdField_b_of_type_JavaUtilHashMap.put("sl", ajya.a(2131707804));
    jdField_b_of_type_JavaUtilHashMap.put("th", ajya.a(2131707794));
    jdField_b_of_type_JavaUtilHashMap.put("tn", ajya.a(2131707816));
    jdField_b_of_type_JavaUtilHashMap.put("uk", ajya.a(2131707793));
    jdField_b_of_type_JavaUtilHashMap.put("ve", ajya.a(2131707784));
    jdField_b_of_type_JavaUtilHashMap.put("xh", ajya.a(2131707819));
    jdField_b_of_type_JavaUtilHashMap.put("zu", ajya.a(2131707803));
  }
  
  public aubo(AppInterface paramAppInterface, aubq paramaubq, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Aubq = paramaubq;
    this.jdField_a_of_type_Alet = new alet(paramAppInterface);
    this.jdField_a_of_type_Alet.a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Atzv = ((atzv)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(228));
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private algs a(String paramString)
  {
    algs localalgs = null;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "req had been remove, sessionId:" + paramString);
        }
        localalgs = (algs)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      return localalgs;
    }
  }
  
  /* Error */
  private void a(algs paramalgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 243	aubo:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +62 -> 72
    //   13: aload_1
    //   14: getfield 306	algs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +52 -> 72
    //   23: aload_0
    //   24: getfield 243	aubo:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   27: aload_1
    //   28: getfield 306	algs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   60: getfield 306	algs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   0	87	0	this	aubo
    //   0	87	1	paramalgs	algs
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
      if (this.jdField_a_of_type_Alet != null) {
        this.jdField_a_of_type_Alet.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "stopRecog...");
      }
      return;
    }
  }
  
  /* Error */
  public void a(algr paramalgr, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 301	algs
    //   5: dup
    //   6: invokespecial 371	algs:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_0
    //   12: invokevirtual 373	aubo:a	()Ljava/lang/String;
    //   15: putfield 306	algs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: aload_3
    //   19: aload_1
    //   20: putfield 376	algs:jdField_a_of_type_Algr	Lalgr;
    //   23: aload_3
    //   24: ldc_w 377
    //   27: putfield 379	algs:jdField_b_of_type_Int	I
    //   30: aload_3
    //   31: ldc_w 377
    //   34: putfield 380	algs:jdField_a_of_type_Int	I
    //   37: aload_3
    //   38: ldc2_w 381
    //   41: putfield 385	algs:jdField_a_of_type_Long	J
    //   44: aload_3
    //   45: iconst_0
    //   46: putfield 388	algs:jdField_c_of_type_Int	I
    //   49: aload_3
    //   50: aload_0
    //   51: getfield 230	aubo:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   54: invokevirtual 391	com/tencent/common/app/AppInterface:getAppid	()I
    //   57: invokestatic 393	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: putfield 395	algs:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   63: aload_3
    //   64: aload_0
    //   65: getfield 230	aubo:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   68: invokevirtual 320	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: invokestatic 401	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   74: putfield 403	algs:jdField_b_of_type_Long	J
    //   77: aload_3
    //   78: invokestatic 335	java/lang/System:currentTimeMillis	()J
    //   81: putfield 405	algs:jdField_c_of_type_Long	J
    //   84: new 407	atzs
    //   87: dup
    //   88: invokespecial 408	atzs:<init>	()V
    //   91: astore 4
    //   93: aload_2
    //   94: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +9 -> 106
    //   100: aload 4
    //   102: aload_2
    //   103: putfield 409	atzs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_3
    //   107: aload 4
    //   109: putfield 412	algs:jdField_a_of_type_Atzs	Latzs;
    //   112: aload_0
    //   113: aload_3
    //   114: invokespecial 414	aubo:a	(Lalgs;)V
    //   117: aload_3
    //   118: getfield 306	algs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 258	aubo:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   126: new 416	com/tencent/mobileqq/ocr/OcrControl$2
    //   129: dup
    //   130: aload_0
    //   131: aload_2
    //   132: invokespecial 419	com/tencent/mobileqq/ocr/OcrControl$2:<init>	(Laubo;Ljava/lang/String;)V
    //   135: ldc2_w 420
    //   138: invokevirtual 425	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   141: pop
    //   142: aload_0
    //   143: getfield 239	aubo:jdField_a_of_type_Alet	Lalet;
    //   146: aload_3
    //   147: aload_0
    //   148: getfield 228	aubo:jdField_a_of_type_Alew	Lalew;
    //   151: invokevirtual 428	alet:a	(Lalgs;Lalew;)Z
    //   154: ifeq +42 -> 196
    //   157: aload_0
    //   158: getfield 258	aubo:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   161: new 430	com/tencent/mobileqq/ocr/OcrControl$3
    //   164: dup
    //   165: aload_0
    //   166: aload_2
    //   167: aload_1
    //   168: invokespecial 433	com/tencent/mobileqq/ocr/OcrControl$3:<init>	(Laubo;Ljava/lang/String;Lalgr;)V
    //   171: ldc2_w 434
    //   174: invokevirtual 425	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   177: pop
    //   178: new 437	com/tencent/mobileqq/ocr/OcrControl$4
    //   181: dup
    //   182: aload_0
    //   183: aload_1
    //   184: invokespecial 440	com/tencent/mobileqq/ocr/OcrControl$4:<init>	(Laubo;Lalgr;)V
    //   187: iconst_5
    //   188: aconst_null
    //   189: iconst_0
    //   190: invokestatic 445	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   193: aload_0
    //   194: monitorexit
    //   195: return
    //   196: aload_0
    //   197: getfield 232	aubo:jdField_a_of_type_Aubq	Laubq;
    //   200: iconst_3
    //   201: aconst_null
    //   202: aload_1
    //   203: getfield 448	algr:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   0	220	0	this	aubo
    //   0	220	1	paramalgr	algr
    //   0	220	2	paramString	String
    //   9	138	3	localalgs	algs
    //   91	17	4	localatzs	atzs
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
    if (this.jdField_a_of_type_Alet != null) {
      this.jdField_a_of_type_Alet.a();
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
 * Qualified Name:     aubo
 * JD-Core Version:    0.7.0.1
 */