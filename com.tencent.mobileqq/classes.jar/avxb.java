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

public class avxb
{
  public static final HashMap<String, String> b;
  int jdField_a_of_type_Int;
  amzy jdField_a_of_type_Amzy;
  anab jdField_a_of_type_Anab = new avxc(this);
  Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public avvi a;
  private avxd jdField_a_of_type_Avxd;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, anbr> a;
  private Handler b;
  
  static
  {
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("zh", alud.a(2131708185));
    jdField_b_of_type_JavaUtilHashMap.put("en", alud.a(2131708204));
    jdField_b_of_type_JavaUtilHashMap.put("af", alud.a(2131708208));
    jdField_b_of_type_JavaUtilHashMap.put("ar", alud.a(2131708161));
    jdField_b_of_type_JavaUtilHashMap.put("eu", alud.a(2131708196));
    jdField_b_of_type_JavaUtilHashMap.put("be", alud.a(2131708159));
    jdField_b_of_type_JavaUtilHashMap.put("hr", alud.a(2131708166));
    jdField_b_of_type_JavaUtilHashMap.put("da", alud.a(2131708153));
    jdField_b_of_type_JavaUtilHashMap.put("nl", alud.a(2131708189));
    jdField_b_of_type_JavaUtilHashMap.put("fo", alud.a(2131708179));
    jdField_b_of_type_JavaUtilHashMap.put("fi", alud.a(2131708170));
    jdField_b_of_type_JavaUtilHashMap.put("fr", alud.a(2131708163));
    jdField_b_of_type_JavaUtilHashMap.put("gd", alud.a(2131708202));
    jdField_b_of_type_JavaUtilHashMap.put("de", alud.a(2131708154));
    jdField_b_of_type_JavaUtilHashMap.put("he", alud.a(2131708184));
    jdField_b_of_type_JavaUtilHashMap.put("hu", alud.a(2131708198));
    jdField_b_of_type_JavaUtilHashMap.put("id", alud.a(2131708180));
    jdField_b_of_type_JavaUtilHashMap.put("it", alud.a(2131708171));
    jdField_b_of_type_JavaUtilHashMap.put("kr", alud.a(2131708194));
    jdField_b_of_type_JavaUtilHashMap.put("lv", alud.a(2131708173));
    jdField_b_of_type_JavaUtilHashMap.put("mk", alud.a(2131708206));
    jdField_b_of_type_JavaUtilHashMap.put("mt", alud.a(2131708175));
    jdField_b_of_type_JavaUtilHashMap.put("no", alud.a(2131708162));
    jdField_b_of_type_JavaUtilHashMap.put("pt", alud.a(2131708186));
    jdField_b_of_type_JavaUtilHashMap.put("rm", alud.a(2131708169));
    jdField_b_of_type_JavaUtilHashMap.put("ro", alud.a(2131708167));
    jdField_b_of_type_JavaUtilHashMap.put("sr", alud.a(2131708191));
    jdField_b_of_type_JavaUtilHashMap.put("sk", alud.a(2131708193));
    jdField_b_of_type_JavaUtilHashMap.put("sb", alud.a(2131708152));
    jdField_b_of_type_JavaUtilHashMap.put("es", alud.a(2131708165));
    jdField_b_of_type_JavaUtilHashMap.put("sx", alud.a(2131708174));
    jdField_b_of_type_JavaUtilHashMap.put("sv", alud.a(2131708176));
    jdField_b_of_type_JavaUtilHashMap.put("ts", alud.a(2131708158));
    jdField_b_of_type_JavaUtilHashMap.put("tr", alud.a(2131708183));
    jdField_b_of_type_JavaUtilHashMap.put("ur", alud.a(2131708207));
    jdField_b_of_type_JavaUtilHashMap.put("vi", alud.a(2131708156));
    jdField_b_of_type_JavaUtilHashMap.put("ji", alud.a(2131708149));
    jdField_b_of_type_JavaUtilHashMap.put("sq", alud.a(2131708155));
    jdField_b_of_type_JavaUtilHashMap.put("bg", alud.a(2131708164));
    jdField_b_of_type_JavaUtilHashMap.put("ca", alud.a(2131708172));
    jdField_b_of_type_JavaUtilHashMap.put("cs", alud.a(2131708199));
    jdField_b_of_type_JavaUtilHashMap.put("et", alud.a(2131708197));
    jdField_b_of_type_JavaUtilHashMap.put("fa", alud.a(2131708195));
    jdField_b_of_type_JavaUtilHashMap.put("ga", alud.a(2131708192));
    jdField_b_of_type_JavaUtilHashMap.put("el", alud.a(2131708201));
    jdField_b_of_type_JavaUtilHashMap.put("hi", alud.a(2131708190));
    jdField_b_of_type_JavaUtilHashMap.put("is", alud.a(2131708151));
    jdField_b_of_type_JavaUtilHashMap.put("jp", alud.a(2131708205));
    jdField_b_of_type_JavaUtilHashMap.put("lt", alud.a(2131708181));
    jdField_b_of_type_JavaUtilHashMap.put("ms", alud.a(2131708150));
    jdField_b_of_type_JavaUtilHashMap.put("pl", alud.a(2131708160));
    jdField_b_of_type_JavaUtilHashMap.put("ru", alud.a(2131708157));
    jdField_b_of_type_JavaUtilHashMap.put("sz", alud.a(2131708182));
    jdField_b_of_type_JavaUtilHashMap.put("sl", alud.a(2131708188));
    jdField_b_of_type_JavaUtilHashMap.put("th", alud.a(2131708178));
    jdField_b_of_type_JavaUtilHashMap.put("tn", alud.a(2131708200));
    jdField_b_of_type_JavaUtilHashMap.put("uk", alud.a(2131708177));
    jdField_b_of_type_JavaUtilHashMap.put("ve", alud.a(2131708168));
    jdField_b_of_type_JavaUtilHashMap.put("xh", alud.a(2131708203));
    jdField_b_of_type_JavaUtilHashMap.put("zu", alud.a(2131708187));
  }
  
  public avxb(AppInterface paramAppInterface, avxd paramavxd, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Avxd = paramavxd;
    this.jdField_a_of_type_Amzy = new amzy(paramAppInterface);
    this.jdField_a_of_type_Amzy.a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Avvi = ((avvi)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(228));
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private anbr a(String paramString)
  {
    anbr localanbr = null;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "req had been remove, sessionId:" + paramString);
        }
        localanbr = (anbr)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      return localanbr;
    }
  }
  
  /* Error */
  private void a(anbr paramanbr)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 243	avxb:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +62 -> 72
    //   13: aload_1
    //   14: getfield 306	anbr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +52 -> 72
    //   23: aload_0
    //   24: getfield 243	avxb:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   27: aload_1
    //   28: getfield 306	anbr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   60: getfield 306	anbr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   0	87	0	this	avxb
    //   0	87	1	paramanbr	anbr
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
      if (this.jdField_a_of_type_Amzy != null) {
        this.jdField_a_of_type_Amzy.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "stopRecog...");
      }
      return;
    }
  }
  
  /* Error */
  public void a(anbq paramanbq, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 301	anbr
    //   5: dup
    //   6: invokespecial 371	anbr:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_0
    //   12: invokevirtual 373	avxb:a	()Ljava/lang/String;
    //   15: putfield 306	anbr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: aload_3
    //   19: aload_1
    //   20: putfield 376	anbr:jdField_a_of_type_Anbq	Lanbq;
    //   23: aload_3
    //   24: ldc_w 377
    //   27: putfield 379	anbr:jdField_b_of_type_Int	I
    //   30: aload_3
    //   31: ldc_w 377
    //   34: putfield 380	anbr:jdField_a_of_type_Int	I
    //   37: aload_3
    //   38: ldc2_w 381
    //   41: putfield 385	anbr:jdField_a_of_type_Long	J
    //   44: aload_3
    //   45: iconst_0
    //   46: putfield 388	anbr:jdField_c_of_type_Int	I
    //   49: aload_3
    //   50: aload_0
    //   51: getfield 230	avxb:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   54: invokevirtual 391	com/tencent/common/app/AppInterface:getAppid	()I
    //   57: invokestatic 393	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: putfield 395	anbr:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   63: aload_3
    //   64: aload_0
    //   65: getfield 230	avxb:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   68: invokevirtual 320	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: invokestatic 401	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   74: putfield 403	anbr:jdField_b_of_type_Long	J
    //   77: aload_3
    //   78: invokestatic 335	java/lang/System:currentTimeMillis	()J
    //   81: putfield 405	anbr:jdField_c_of_type_Long	J
    //   84: new 407	avvf
    //   87: dup
    //   88: invokespecial 408	avvf:<init>	()V
    //   91: astore 4
    //   93: aload_2
    //   94: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +9 -> 106
    //   100: aload 4
    //   102: aload_2
    //   103: putfield 409	avvf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_3
    //   107: aload 4
    //   109: putfield 412	anbr:jdField_a_of_type_Avvf	Lavvf;
    //   112: aload_0
    //   113: aload_3
    //   114: invokespecial 414	avxb:a	(Lanbr;)V
    //   117: aload_3
    //   118: getfield 306	anbr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 258	avxb:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   126: new 416	com/tencent/mobileqq/ocr/OcrControl$2
    //   129: dup
    //   130: aload_0
    //   131: aload_2
    //   132: invokespecial 419	com/tencent/mobileqq/ocr/OcrControl$2:<init>	(Lavxb;Ljava/lang/String;)V
    //   135: ldc2_w 420
    //   138: invokevirtual 425	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   141: pop
    //   142: aload_0
    //   143: getfield 239	avxb:jdField_a_of_type_Amzy	Lamzy;
    //   146: aload_3
    //   147: aload_0
    //   148: getfield 228	avxb:jdField_a_of_type_Anab	Lanab;
    //   151: invokevirtual 428	amzy:a	(Lanbr;Lanab;)Z
    //   154: ifeq +42 -> 196
    //   157: aload_0
    //   158: getfield 258	avxb:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   161: new 430	com/tencent/mobileqq/ocr/OcrControl$3
    //   164: dup
    //   165: aload_0
    //   166: aload_2
    //   167: aload_1
    //   168: invokespecial 433	com/tencent/mobileqq/ocr/OcrControl$3:<init>	(Lavxb;Ljava/lang/String;Lanbq;)V
    //   171: ldc2_w 434
    //   174: invokevirtual 425	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   177: pop
    //   178: new 437	com/tencent/mobileqq/ocr/OcrControl$4
    //   181: dup
    //   182: aload_0
    //   183: aload_1
    //   184: invokespecial 440	com/tencent/mobileqq/ocr/OcrControl$4:<init>	(Lavxb;Lanbq;)V
    //   187: iconst_5
    //   188: aconst_null
    //   189: iconst_0
    //   190: invokestatic 445	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   193: aload_0
    //   194: monitorexit
    //   195: return
    //   196: aload_0
    //   197: getfield 232	avxb:jdField_a_of_type_Avxd	Lavxd;
    //   200: iconst_3
    //   201: aconst_null
    //   202: aload_1
    //   203: getfield 448	anbq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   0	220	0	this	avxb
    //   0	220	1	paramanbq	anbq
    //   0	220	2	paramString	String
    //   9	138	3	localanbr	anbr
    //   91	17	4	localavvf	avvf
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
    if (this.jdField_a_of_type_Amzy != null) {
      this.jdField_a_of_type_Amzy.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avxb
 * JD-Core Version:    0.7.0.1
 */