import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileIPv6Detecter.1;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class atkz
{
  private String jdField_a_of_type_JavaLangString = "";
  private Map<String, atla> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  
  private atla a(atlc paramatlc)
  {
    if ((paramatlc == null) || (paramatlc.jdField_a_of_type_JavaLangString == null)) {
      return null;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramatlc = (atla)this.jdField_a_of_type_JavaUtilMap.get(paramatlc.jdField_a_of_type_JavaLangString);
      return paramatlc;
    }
  }
  
  private void a(atlc paramatlc, atla paramatla)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramatlc.jdField_a_of_type_JavaLangString, paramatla);
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
      switch (aufd.a())
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
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_JavaLangString, "actFAIPConnect", true, 0L, 0L, localHashMap, null);
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
  
  private boolean a(atlc paramatlc, atld paramatld)
  {
    if ((paramatlc == null) || (TextUtils.isEmpty(paramatlc.jdField_a_of_type_JavaLangString)) || (paramatld == null) || (TextUtils.isEmpty(paramatld.jdField_a_of_type_JavaLangString))) {
      QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] delectDomainConn err. param=null");
    }
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
      QLog.i("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] start delectIP [" + paramatlc.jdField_a_of_type_JavaLangString + ":" + paramatlc.jdField_a_of_type_Int + "] ipInfo[" + paramatld.jdField_a_of_type_JavaLangString + ":" + paramatld.jdField_a_of_type_Int + "]");
      c();
    } while (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null);
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new FileIPv6Detecter.1(this, paramatld, l, paramatlc));
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
    //   3: getfield 166	atkz:jdField_a_of_type_JavaUtilConcurrentExecutor	Ljava/util/concurrent/Executor;
    //   6: ifnonnull +38 -> 44
    //   9: ldc 102
    //   11: iconst_1
    //   12: ldc 185
    //   14: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: new 187	com/tencent/mobileqq/app/ThreadPoolParams
    //   20: dup
    //   21: invokespecial 188	com/tencent/mobileqq/app/ThreadPoolParams:<init>	()V
    //   24: astore_1
    //   25: aload_1
    //   26: iconst_5
    //   27: putfield 191	com/tencent/mobileqq/app/ThreadPoolParams:priority	I
    //   30: aload_1
    //   31: ldc 193
    //   33: putfield 196	com/tencent/mobileqq/app/ThreadPoolParams:poolThreadName	Ljava/lang/String;
    //   36: aload_0
    //   37: aload_1
    //   38: invokestatic 202	com/tencent/mobileqq/app/ThreadManager:newFreeThreadPool	(Lcom/tencent/mobileqq/app/ThreadPoolParams;)Ljava/util/concurrent/Executor;
    //   41: putfield 166	atkz:jdField_a_of_type_JavaUtilConcurrentExecutor	Ljava/util/concurrent/Executor;
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: ldc 102
    //   50: iconst_1
    //   51: new 104	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   58: ldc 204
    //   60: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 205	java/lang/Exception:toString	()Ljava/lang/String;
    //   67: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: goto -32 -> 44
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	atkz
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
  
  public void a(QQAppInterface paramQQAppInterface, atlc paramatlc, atld paramatld)
  {
    if ((paramatlc == null) || (TextUtils.isEmpty(paramatlc.jdField_a_of_type_JavaLangString)) || (paramatld == null) || (TextUtils.isEmpty(paramatld.jdField_a_of_type_JavaLangString))) {
      QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] detectV6Domain err. param=null");
    }
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentUin();
    }
    long l = System.currentTimeMillis();
    paramQQAppInterface = a(paramatlc);
    if (paramQQAppInterface != null)
    {
      if ((paramQQAppInterface.jdField_a_of_type_Boolean) || (paramQQAppInterface.b)) {}
      while (l - paramQQAppInterface.jdField_a_of_type_Long <= 600000L) {
        return;
      }
    }
    if (a(paramatlc, paramatld))
    {
      paramQQAppInterface = new atla(this);
      paramQQAppInterface.b = true;
      paramQQAppInterface.jdField_a_of_type_Atld = paramatld;
      paramQQAppInterface.jdField_a_of_type_Long = l;
      a(paramatlc, paramQQAppInterface);
      return;
    }
    QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] delectIP err");
  }
  
  public boolean a(atlc paramatlc)
  {
    paramatlc = a(paramatlc);
    if (paramatlc != null) {
      return paramatlc.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkz
 * JD-Core Version:    0.7.0.1
 */