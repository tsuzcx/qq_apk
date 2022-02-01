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

public class axmu
{
  public static final HashMap<String, String> b;
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  aofs jdField_a_of_type_Aofs;
  aofv jdField_a_of_type_Aofv = new axmv(this);
  public axlb a;
  private axmw jdField_a_of_type_Axmw;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap<String, aohl> a;
  private Handler b;
  
  static
  {
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("zh", amtj.a(2131706899));
    jdField_b_of_type_JavaUtilHashMap.put("en", amtj.a(2131706918));
    jdField_b_of_type_JavaUtilHashMap.put("af", amtj.a(2131706922));
    jdField_b_of_type_JavaUtilHashMap.put("ar", amtj.a(2131706875));
    jdField_b_of_type_JavaUtilHashMap.put("eu", amtj.a(2131706910));
    jdField_b_of_type_JavaUtilHashMap.put("be", amtj.a(2131706873));
    jdField_b_of_type_JavaUtilHashMap.put("hr", amtj.a(2131706880));
    jdField_b_of_type_JavaUtilHashMap.put("da", amtj.a(2131706867));
    jdField_b_of_type_JavaUtilHashMap.put("nl", amtj.a(2131706903));
    jdField_b_of_type_JavaUtilHashMap.put("fo", amtj.a(2131706893));
    jdField_b_of_type_JavaUtilHashMap.put("fi", amtj.a(2131706884));
    jdField_b_of_type_JavaUtilHashMap.put("fr", amtj.a(2131706877));
    jdField_b_of_type_JavaUtilHashMap.put("gd", amtj.a(2131706916));
    jdField_b_of_type_JavaUtilHashMap.put("de", amtj.a(2131706868));
    jdField_b_of_type_JavaUtilHashMap.put("he", amtj.a(2131706898));
    jdField_b_of_type_JavaUtilHashMap.put("hu", amtj.a(2131706912));
    jdField_b_of_type_JavaUtilHashMap.put("id", amtj.a(2131706894));
    jdField_b_of_type_JavaUtilHashMap.put("it", amtj.a(2131706885));
    jdField_b_of_type_JavaUtilHashMap.put("kr", amtj.a(2131706908));
    jdField_b_of_type_JavaUtilHashMap.put("lv", amtj.a(2131706887));
    jdField_b_of_type_JavaUtilHashMap.put("mk", amtj.a(2131706920));
    jdField_b_of_type_JavaUtilHashMap.put("mt", amtj.a(2131706889));
    jdField_b_of_type_JavaUtilHashMap.put("no", amtj.a(2131706876));
    jdField_b_of_type_JavaUtilHashMap.put("pt", amtj.a(2131706900));
    jdField_b_of_type_JavaUtilHashMap.put("rm", amtj.a(2131706883));
    jdField_b_of_type_JavaUtilHashMap.put("ro", amtj.a(2131706881));
    jdField_b_of_type_JavaUtilHashMap.put("sr", amtj.a(2131706905));
    jdField_b_of_type_JavaUtilHashMap.put("sk", amtj.a(2131706907));
    jdField_b_of_type_JavaUtilHashMap.put("sb", amtj.a(2131706866));
    jdField_b_of_type_JavaUtilHashMap.put("es", amtj.a(2131706879));
    jdField_b_of_type_JavaUtilHashMap.put("sx", amtj.a(2131706888));
    jdField_b_of_type_JavaUtilHashMap.put("sv", amtj.a(2131706890));
    jdField_b_of_type_JavaUtilHashMap.put("ts", amtj.a(2131706872));
    jdField_b_of_type_JavaUtilHashMap.put("tr", amtj.a(2131706897));
    jdField_b_of_type_JavaUtilHashMap.put("ur", amtj.a(2131706921));
    jdField_b_of_type_JavaUtilHashMap.put("vi", amtj.a(2131706870));
    jdField_b_of_type_JavaUtilHashMap.put("ji", amtj.a(2131706863));
    jdField_b_of_type_JavaUtilHashMap.put("sq", amtj.a(2131706869));
    jdField_b_of_type_JavaUtilHashMap.put("bg", amtj.a(2131706878));
    jdField_b_of_type_JavaUtilHashMap.put("ca", amtj.a(2131706886));
    jdField_b_of_type_JavaUtilHashMap.put("cs", amtj.a(2131706913));
    jdField_b_of_type_JavaUtilHashMap.put("et", amtj.a(2131706911));
    jdField_b_of_type_JavaUtilHashMap.put("fa", amtj.a(2131706909));
    jdField_b_of_type_JavaUtilHashMap.put("ga", amtj.a(2131706906));
    jdField_b_of_type_JavaUtilHashMap.put("el", amtj.a(2131706915));
    jdField_b_of_type_JavaUtilHashMap.put("hi", amtj.a(2131706904));
    jdField_b_of_type_JavaUtilHashMap.put("is", amtj.a(2131706865));
    jdField_b_of_type_JavaUtilHashMap.put("jp", amtj.a(2131706919));
    jdField_b_of_type_JavaUtilHashMap.put("lt", amtj.a(2131706895));
    jdField_b_of_type_JavaUtilHashMap.put("ms", amtj.a(2131706864));
    jdField_b_of_type_JavaUtilHashMap.put("pl", amtj.a(2131706874));
    jdField_b_of_type_JavaUtilHashMap.put("ru", amtj.a(2131706871));
    jdField_b_of_type_JavaUtilHashMap.put("sz", amtj.a(2131706896));
    jdField_b_of_type_JavaUtilHashMap.put("sl", amtj.a(2131706902));
    jdField_b_of_type_JavaUtilHashMap.put("th", amtj.a(2131706892));
    jdField_b_of_type_JavaUtilHashMap.put("tn", amtj.a(2131706914));
    jdField_b_of_type_JavaUtilHashMap.put("uk", amtj.a(2131706891));
    jdField_b_of_type_JavaUtilHashMap.put("ve", amtj.a(2131706882));
    jdField_b_of_type_JavaUtilHashMap.put("xh", amtj.a(2131706917));
    jdField_b_of_type_JavaUtilHashMap.put("zu", amtj.a(2131706901));
  }
  
  public axmu(AppInterface paramAppInterface, axmw paramaxmw, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Axmw = paramaxmw;
    this.jdField_a_of_type_Aofs = new aofs(paramAppInterface);
    this.jdField_a_of_type_Aofs.a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Axlb = ((axlb)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(228));
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private aohl a(String paramString)
  {
    aohl localaohl = null;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "req had been remove, sessionId:" + paramString);
        }
        localaohl = (aohl)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      return localaohl;
    }
  }
  
  /* Error */
  private void a(aohl paramaohl)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 243	axmu:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +62 -> 72
    //   13: aload_1
    //   14: getfield 306	aohl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +52 -> 72
    //   23: aload_0
    //   24: getfield 243	axmu:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   27: aload_1
    //   28: getfield 306	aohl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   60: getfield 306	aohl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   0	87	0	this	axmu
    //   0	87	1	paramaohl	aohl
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
      if (this.jdField_a_of_type_Aofs != null) {
        this.jdField_a_of_type_Aofs.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "stopRecog...");
      }
      return;
    }
  }
  
  /* Error */
  public void a(aohk paramaohk, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 301	aohl
    //   5: dup
    //   6: invokespecial 371	aohl:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_0
    //   12: invokevirtual 373	axmu:a	()Ljava/lang/String;
    //   15: putfield 306	aohl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: aload_3
    //   19: aload_1
    //   20: putfield 376	aohl:jdField_a_of_type_Aohk	Laohk;
    //   23: aload_3
    //   24: ldc_w 377
    //   27: putfield 379	aohl:jdField_b_of_type_Int	I
    //   30: aload_3
    //   31: ldc_w 377
    //   34: putfield 380	aohl:jdField_a_of_type_Int	I
    //   37: aload_3
    //   38: ldc2_w 381
    //   41: putfield 385	aohl:jdField_a_of_type_Long	J
    //   44: aload_3
    //   45: iconst_0
    //   46: putfield 388	aohl:jdField_c_of_type_Int	I
    //   49: aload_3
    //   50: aload_0
    //   51: getfield 230	axmu:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   54: invokevirtual 391	com/tencent/common/app/AppInterface:getAppid	()I
    //   57: invokestatic 393	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: putfield 395	aohl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   63: aload_3
    //   64: aload_0
    //   65: getfield 230	axmu:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   68: invokevirtual 320	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: invokestatic 401	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   74: putfield 403	aohl:jdField_b_of_type_Long	J
    //   77: aload_3
    //   78: invokestatic 335	java/lang/System:currentTimeMillis	()J
    //   81: putfield 405	aohl:jdField_c_of_type_Long	J
    //   84: new 407	axky
    //   87: dup
    //   88: invokespecial 408	axky:<init>	()V
    //   91: astore 4
    //   93: aload_2
    //   94: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +9 -> 106
    //   100: aload 4
    //   102: aload_2
    //   103: putfield 409	axky:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_3
    //   107: aload 4
    //   109: putfield 412	aohl:jdField_a_of_type_Axky	Laxky;
    //   112: aload_0
    //   113: aload_3
    //   114: invokespecial 414	axmu:a	(Laohl;)V
    //   117: aload_3
    //   118: getfield 306	aohl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 258	axmu:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   126: new 416	com/tencent/mobileqq/ocr/OcrControl$2
    //   129: dup
    //   130: aload_0
    //   131: aload_2
    //   132: invokespecial 419	com/tencent/mobileqq/ocr/OcrControl$2:<init>	(Laxmu;Ljava/lang/String;)V
    //   135: ldc2_w 420
    //   138: invokevirtual 425	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   141: pop
    //   142: aload_0
    //   143: getfield 239	axmu:jdField_a_of_type_Aofs	Laofs;
    //   146: aload_3
    //   147: aload_0
    //   148: getfield 228	axmu:jdField_a_of_type_Aofv	Laofv;
    //   151: invokevirtual 428	aofs:a	(Laohl;Laofv;)Z
    //   154: ifeq +42 -> 196
    //   157: aload_0
    //   158: getfield 258	axmu:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   161: new 430	com/tencent/mobileqq/ocr/OcrControl$3
    //   164: dup
    //   165: aload_0
    //   166: aload_2
    //   167: aload_1
    //   168: invokespecial 433	com/tencent/mobileqq/ocr/OcrControl$3:<init>	(Laxmu;Ljava/lang/String;Laohk;)V
    //   171: ldc2_w 434
    //   174: invokevirtual 425	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   177: pop
    //   178: new 437	com/tencent/mobileqq/ocr/OcrControl$4
    //   181: dup
    //   182: aload_0
    //   183: aload_1
    //   184: invokespecial 440	com/tencent/mobileqq/ocr/OcrControl$4:<init>	(Laxmu;Laohk;)V
    //   187: iconst_5
    //   188: aconst_null
    //   189: iconst_0
    //   190: invokestatic 445	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   193: aload_0
    //   194: monitorexit
    //   195: return
    //   196: aload_0
    //   197: getfield 232	axmu:jdField_a_of_type_Axmw	Laxmw;
    //   200: iconst_3
    //   201: aconst_null
    //   202: aload_1
    //   203: getfield 448	aohk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   0	220	0	this	axmu
    //   0	220	1	paramaohk	aohk
    //   0	220	2	paramString	String
    //   9	138	3	localaohl	aohl
    //   91	17	4	localaxky	axky
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
    if (this.jdField_a_of_type_Aofs != null) {
      this.jdField_a_of_type_Aofs.a();
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
 * Qualified Name:     axmu
 * JD-Core Version:    0.7.0.1
 */