import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileIPv6Detecter.1;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class atuj
{
  private String jdField_a_of_type_JavaLangString = "";
  private Map<String, atuk> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  
  private atuk a(atum paramatum)
  {
    if ((paramatum == null) || (paramatum.jdField_a_of_type_JavaLangString == null)) {
      return null;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramatum = (atuk)this.jdField_a_of_type_JavaUtilMap.get(paramatum.jdField_a_of_type_JavaLangString);
      return paramatum;
    }
  }
  
  private void a(atum paramatum, atuk paramatuk)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramatum.jdField_a_of_type_JavaLangString, paramatuk);
      return;
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    int k = 0;
    int i = 2;
    int j;
    label51:
    HashMap localHashMap;
    if (MsfServiceSdk.get().getConnectedIPFamily() == 2)
    {
      j = 2;
      switch (auoo.a())
      {
      default: 
        i = 0;
      case 3: 
        localHashMap = new HashMap();
        localHashMap.put("param_domain", String.valueOf(paramString1));
        localHashMap.put("param_ipAddr", String.valueOf(paramString2));
        localHashMap.put("param_port", String.valueOf(paramInt));
        if (!paramBoolean) {
          break;
        }
      }
    }
    for (paramInt = k;; paramInt = 1)
    {
      localHashMap.put("param_result", String.valueOf(paramInt));
      localHashMap.put("param_stackType", String.valueOf(i));
      localHashMap.put("param_loginType", String.valueOf(j));
      bdmc.a(BaseApplication.getContext()).a(this.jdField_a_of_type_JavaLangString, "actFAIPConnect", true, 0L, 0L, localHashMap, null);
      QLog.d("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] >> reportDetectConnResult:" + localHashMap.toString());
      return;
      j = 1;
      break;
      i = 1;
      break label51;
      i = 3;
      break label51;
    }
  }
  
  private boolean a(atum paramatum, atun paramatun)
  {
    if ((paramatum == null) || (TextUtils.isEmpty(paramatum.jdField_a_of_type_JavaLangString)) || (paramatun == null) || (TextUtils.isEmpty(paramatun.jdField_a_of_type_JavaLangString))) {
      QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] delectDomainConn err. param=null");
    }
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
      QLog.i("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] start delectIP [" + paramatum.jdField_a_of_type_JavaLangString + ":" + paramatum.jdField_a_of_type_Int + "] ipInfo[" + paramatun.jdField_a_of_type_JavaLangString + ":" + paramatun.jdField_a_of_type_Int + "]");
      c();
    } while (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null);
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new FileIPv6Detecter.1(this, paramatun, l, paramatum));
    return true;
  }
  
  private void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 164	atuj:jdField_a_of_type_JavaUtilConcurrentExecutor	Ljava/util/concurrent/Executor;
    //   6: ifnonnull +38 -> 44
    //   9: ldc 100
    //   11: iconst_1
    //   12: ldc 183
    //   14: invokestatic 159	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: new 185	com/tencent/mobileqq/app/ThreadPoolParams
    //   20: dup
    //   21: invokespecial 186	com/tencent/mobileqq/app/ThreadPoolParams:<init>	()V
    //   24: astore_1
    //   25: aload_1
    //   26: iconst_5
    //   27: putfield 189	com/tencent/mobileqq/app/ThreadPoolParams:priority	I
    //   30: aload_1
    //   31: ldc 191
    //   33: putfield 194	com/tencent/mobileqq/app/ThreadPoolParams:poolThreadName	Ljava/lang/String;
    //   36: aload_0
    //   37: aload_1
    //   38: invokestatic 200	com/tencent/mobileqq/app/ThreadManager:newFreeThreadPool	(Lcom/tencent/mobileqq/app/ThreadPoolParams;)Ljava/util/concurrent/Executor;
    //   41: putfield 164	atuj:jdField_a_of_type_JavaUtilConcurrentExecutor	Ljava/util/concurrent/Executor;
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: ldc 100
    //   50: iconst_1
    //   51: new 102	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   58: ldc 202
    //   60: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 203	java/lang/Exception:toString	()Ljava/lang/String;
    //   67: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 135	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: goto -32 -> 44
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	atuj
    //   24	14	1	localThreadPoolParams	com.tencent.mobileqq.app.ThreadPoolParams
    //   47	17	1	localException	java.lang.Exception
    //   79	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	44	47	java/lang/Exception
    //   2	17	79	finally
    //   17	44	79	finally
    //   48	76	79	finally
  }
  
  public void a()
  {
    b();
  }
  
  public void a(QQAppInterface paramQQAppInterface, atum paramatum, atun paramatun)
  {
    if ((paramatum == null) || (TextUtils.isEmpty(paramatum.jdField_a_of_type_JavaLangString)) || (paramatun == null) || (TextUtils.isEmpty(paramatun.jdField_a_of_type_JavaLangString))) {
      QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] detectV6Domain err. param=null");
    }
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    }
    long l = System.currentTimeMillis();
    paramQQAppInterface = a(paramatum);
    if (paramQQAppInterface != null)
    {
      if ((paramQQAppInterface.jdField_a_of_type_Boolean) || (paramQQAppInterface.b)) {}
      while (l - paramQQAppInterface.jdField_a_of_type_Long <= 600000L) {
        return;
      }
    }
    if (a(paramatum, paramatun))
    {
      paramQQAppInterface = new atuk(this);
      paramQQAppInterface.b = true;
      paramQQAppInterface.jdField_a_of_type_Atun = paramatun;
      paramQQAppInterface.jdField_a_of_type_Long = l;
      a(paramatum, paramQQAppInterface);
      return;
    }
    QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] delectIP err");
  }
  
  public boolean a(atum paramatum)
  {
    paramatum = a(paramatum);
    if (paramatum != null) {
      return paramatum.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atuj
 * JD-Core Version:    0.7.0.1
 */