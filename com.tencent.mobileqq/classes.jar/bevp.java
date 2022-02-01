import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.1;
import com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.2;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class bevp
  implements bhvc
{
  int jdField_a_of_type_Int = 0;
  public beum a;
  public bevm a;
  public bhva a;
  public OutputStream a;
  public RandomAccessFile a;
  String jdField_a_of_type_JavaLangString = null;
  public AtomicBoolean a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  int d;
  int e;
  
  public bevp(bevo parambevo)
  {
    this.jdField_c_of_type_Int = 5;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private long a(bevm parambevm, long paramLong)
  {
    if ((parambevm.jdField_b_of_type_Int == 9056) && (paramLong != 0L)) {
      return 0L;
    }
    if (paramLong != 0L) {
      return 3000L;
    }
    return 6000L;
  }
  
  private void a(long paramLong, beum parambeum)
  {
    int i;
    if ((QLog.isColorLevel()) && (parambeum != null))
    {
      i = parambeum.jdField_f_of_type_Int;
      if (parambeum.jdField_a_of_type_Int != 1) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      bews.a(i, bool, parambeum.jdField_e_of_type_Int, parambeum.jdField_e_of_type_JavaLangString, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_Bevm.jdField_e_of_type_Long = System.currentTimeMillis();
    if (bevn.a().a() != 0)
    {
      if ((this.jdField_a_of_type_Bevo.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramLong != 0L))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new OldHttpEngine.OldHttpCommunicatorListner.1(this, parambeum), paramLong);
        return;
      }
      if ((QLog.isColorLevel()) && (parambeum != null))
      {
        i = parambeum.jdField_f_of_type_Int;
        if (parambeum.jdField_a_of_type_Int != 1) {
          break label228;
        }
      }
      label228:
      for (bool = true;; bool = false)
      {
        bews.a(i, bool, parambeum.jdField_e_of_type_Int, parambeum.jdField_e_of_type_JavaLangString, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
        this.jdField_a_of_type_Bevo.a(this.jdField_a_of_type_Beum, false);
        return;
      }
    }
    if (this.jdField_a_of_type_Bevo.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      ThreadManager.getTimer().schedule(new OldHttpEngine.OldHttpCommunicatorListner.2(this, parambeum), paramLong);
      return;
    }
    if ((QLog.isColorLevel()) && (parambeum != null))
    {
      i = parambeum.jdField_f_of_type_Int;
      if (parambeum.jdField_a_of_type_Int != 1) {
        break label321;
      }
    }
    label321:
    for (bool = true;; bool = false)
    {
      bews.a(i, bool, parambeum.jdField_e_of_type_Int, parambeum.jdField_e_of_type_JavaLangString, "scheduleRetry", "mWorking is false");
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
  }
  
  private void a(beum parambeum)
  {
    int i;
    if ((QLog.isColorLevel()) && (parambeum != null))
    {
      i = parambeum.jdField_f_of_type_Int;
      if (parambeum.jdField_a_of_type_Int != 1) {
        break label94;
      }
    }
    label94:
    for (boolean bool = true;; bool = false)
    {
      bews.a(i, bool, parambeum.jdField_e_of_type_Int, parambeum.jdField_e_of_type_JavaLangString, "retrySync", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      this.jdField_a_of_type_Bevm.jdField_e_of_type_Long = System.currentTimeMillis();
      if (bevn.a().a() == 0) {
        break;
      }
      this.jdField_a_of_type_Bevo.a(this.jdField_a_of_type_Beum, true);
      return;
    }
    this.jdField_a_of_type_Bhva.a(9004, -1, "nonetwork");
    d();
  }
  
  private boolean a(bevm parambevm, beum parambeum)
  {
    if (parambevm.jdField_c_of_type_Long > 0L)
    {
      if (!parambeum.c()) {
        break label46;
      }
      if (parambeum.jdField_a_of_type_Beup == null) {
        break label44;
      }
      parambeum.jdField_a_of_type_Beup.a(parambeum, parambevm);
      this.jdField_a_of_type_JavaIoOutputStream = parambeum.jdField_a_of_type_JavaIoOutputStream;
    }
    label44:
    label46:
    while (!parambeum.b())
    {
      return true;
      return false;
    }
    if (parambeum.jdField_a_of_type_Beup != null)
    {
      parambeum.jdField_a_of_type_Beup.a(parambeum, parambevm);
      return true;
    }
    if (this.jdField_a_of_type_JavaIoOutputStream != null) {
      try
      {
        this.jdField_a_of_type_JavaIoOutputStream.close();
        this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
        parambevm.jdField_c_of_type_Long = 0L;
        return true;
      }
      catch (IOException parambeum)
      {
        a(parambeum, parambevm);
      }
    }
    return false;
  }
  
  private boolean a(bhva parambhva, beum parambeum, bevm parambevm)
  {
    return (!this.jdField_a_of_type_Boolean) && (parambhva.c()) && (parambevm.jdField_d_of_type_Long < parambeum.jdField_c_of_type_Long - 5000L) && (this.jdField_a_of_type_Int <= parambeum.jdField_b_of_type_Int);
  }
  
  private void d()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    beum localbeum = this.jdField_a_of_type_Beum;
    bevm localbevm = this.jdField_a_of_type_Bevm;
    OutputStream localOutputStream;
    RandomAccessFile localRandomAccessFile;
    if (localbeum != null)
    {
      localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
      localRandomAccessFile = this.jdField_a_of_type_JavaIoRandomAccessFile;
      if ((localbeum.jdField_c_of_type_JavaLangString == null) || (localOutputStream == null)) {}
    }
    try
    {
      localOutputStream.close();
      if (localRandomAccessFile == null) {}
    }
    catch (IOException localIOException2)
    {
      try
      {
        localRandomAccessFile.close();
        if (localbevm != null)
        {
          if ((localbeum.jdField_f_of_type_JavaLangString != null) && (localbevm.jdField_a_of_type_Int != 3)) {
            bevo.a(this.jdField_a_of_type_Bevo).remove(localbeum.jdField_f_of_type_JavaLangString);
          }
          new bfch(localbeum, localbevm).a();
          if (localbeum.jdField_a_of_type_Beuq != null)
          {
            if (QLog.isColorLevel())
            {
              int i = localbeum.jdField_f_of_type_Int;
              if (localbeum.jdField_a_of_type_Int != 1) {
                break label260;
              }
              bews.a(i, bool, localbeum.jdField_e_of_type_Int, localbeum.jdField_e_of_type_JavaLangString, "onOutEngine", "result:" + localbevm.jdField_a_of_type_Int + " errCode:" + localbevm.jdField_b_of_type_Int + " desc:" + localbevm.jdField_a_of_type_JavaLangString);
            }
            if ((localbevm.jdField_b_of_type_Int == 9367) && (QLog.isColorLevel())) {
              break label265;
            }
            localbeum.jdField_a_of_type_Beuq.onResp(localbevm);
          }
        }
        a();
        return;
        localIOException2 = localIOException2;
        localIOException2.printStackTrace();
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          localIOException1.printStackTrace();
          continue;
          label260:
          bool = false;
          continue;
          label265:
          bdlr.a("Http_Download_Queen_Full", this.jdField_a_of_type_Bevo.jdField_a_of_type_Bhuw.a());
        }
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = bevo.a(this.jdField_a_of_type_Beum, paramString1, paramString2);
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    beum localbeum = this.jdField_a_of_type_Beum;
    if (localbeum != null) {
      localbeum.jdField_a_of_type_JavaLangObject = null;
    }
    this.jdField_a_of_type_Beum = null;
    this.jdField_a_of_type_Bevm = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
  }
  
  void a(beum parambeum, boolean paramBoolean1, bevm parambevm, bhva parambhva1, bhva parambhva2, boolean paramBoolean2, long paramLong)
  {
    boolean bool;
    int i;
    label66:
    long l;
    if (QLog.isColorLevel())
    {
      int j = parambeum.jdField_f_of_type_Int;
      if (parambeum.jdField_a_of_type_Int == 1)
      {
        bool = true;
        int k = parambeum.jdField_e_of_type_Int;
        parambhva1 = parambeum.jdField_e_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("tryTime:");
        if (this.jdField_a_of_type_Bevm == null) {
          break label220;
        }
        i = this.jdField_a_of_type_Bevm.jdField_d_of_type_Int;
        localStringBuilder = localStringBuilder.append(i).append(" consumeTime:");
        if (this.jdField_a_of_type_Bevm == null) {
          break label226;
        }
        l = this.jdField_a_of_type_Bevm.jdField_d_of_type_Long;
        label97:
        bews.a(j, bool, k, parambhva1, "retry", l + " isLastGetData:" + paramBoolean1);
      }
    }
    else
    {
      paramBoolean1 = a(parambevm, parambeum);
      if (this.jdField_e_of_type_Int >= parambeum.jdField_c_of_type_Int) {
        parambeum.jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
      if (paramBoolean1) {
        break label237;
      }
      if (QLog.isColorLevel())
      {
        i = parambeum.jdField_f_of_type_Int;
        if (parambeum.jdField_a_of_type_Int != 1) {
          break label232;
        }
      }
    }
    label220:
    label226:
    label232:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      bews.a(i, paramBoolean1, parambeum.jdField_e_of_type_Int, parambeum.jdField_e_of_type_JavaLangString, "retry", "breakDownAllowRetry is false ");
      d();
      return;
      bool = false;
      break;
      i = 0;
      break label66;
      l = 0L;
      break label97;
    }
    label237:
    if (parambeum.jdField_a_of_type_Beun != null) {
      parambeum.jdField_a_of_type_Beun.a();
    }
    if ((parambeum.jdField_a_of_type_Boolean) && (parambeum.jdField_b_of_type_Boolean)) {
      InnerDns.getInstance().reportBadIp(InnerDns.getHostFromUrl(parambeum.jdField_a_of_type_JavaLangString), InnerDns.getHostFromUrl(parambhva2.a()), 1002);
    }
    if ((parambeum.jdField_a_of_type_JavaUtilList != null) && (parambeum.jdField_a_of_type_JavaUtilList.size() >= 1) && (paramBoolean2))
    {
      parambhva1 = (bewy)parambeum.jdField_a_of_type_JavaUtilList.remove(0);
      parambeum.jdField_a_of_type_JavaUtilList.add(parambhva1);
      parambhva1 = (bewy)parambeum.jdField_a_of_type_JavaUtilList.get(0);
      if (parambeum.jdField_a_of_type_JavaLangString != null)
      {
        parambhva1 = parambhva1.a(parambeum.jdField_a_of_type_JavaLangString);
        parambeum.jdField_a_of_type_JavaLangString = bews.a(parambeum.jdField_a_of_type_JavaLangString, parambhva1);
      }
    }
    if ((parambevm.jdField_b_of_type_Int == 9050) && (parambeum.jdField_a_of_type_Bewq != null)) {
      parambeum.jdField_a_of_type_Bewq.a(this.jdField_a_of_type_Int);
    }
    paramLong = a(parambevm, paramLong);
    if (this.jdField_a_of_type_Bhva.l)
    {
      a(parambeum);
      return;
    }
    a(paramLong, parambeum);
  }
  
  void a(bevl parambevl)
  {
    try
    {
      if ((parambevl.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaIoOutputStream != null)) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {}
    }
    catch (IOException parambevl)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaIoRandomAccessFile.close();
          return;
        }
        catch (IOException parambevl)
        {
          parambevl.printStackTrace();
        }
        parambevl = parambevl;
        parambevl.printStackTrace();
      }
    }
  }
  
  public void a(bevm parambevm, long paramLong, boolean paramBoolean)
  {
    if ((parambevm.jdField_b_of_type_Int == 9056) && (paramLong < 2000L))
    {
      int i = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = (i - 1);
      if (i <= 0) {}
    }
    for (;;)
    {
      if ((parambevm.jdField_b_of_type_Int == 9056) || (parambevm.jdField_b_of_type_Int == 9051)) {
        this.jdField_e_of_type_Int += 1;
      }
      return;
      if (paramBoolean) {
        this.jdField_a_of_type_Int += 1;
      }
    }
  }
  
  void a(bhva parambhva)
  {
    bevm localbevm = this.jdField_a_of_type_Bevm;
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localbevm == null)) {
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = localbevm.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap2.containsKey("firstserverip")) {
      localHashMap1.put("firstserverip", localHashMap2.get("firstserverip"));
    }
    if (localHashMap2.containsKey("serverip")) {
      localHashMap1.put("serverip", localHashMap2.get("serverip"));
    }
    if (localHashMap2.containsKey("param_url")) {
      localHashMap1.put("param_url", localHashMap2.get("param_url"));
    }
    if (parambhva.jdField_b_of_type_JavaUtilHashMap.containsKey(bhva.jdField_f_of_type_JavaLangString)) {
      localHashMap1.put("netresp_param_reason", parambhva.jdField_b_of_type_JavaUtilHashMap.get(bhva.jdField_f_of_type_JavaLangString));
    }
    localbevm.jdField_a_of_type_JavaUtilHashMap.clear();
    localbevm.jdField_a_of_type_JavaUtilHashMap.putAll(localHashMap1);
    localbevm.jdField_a_of_type_JavaUtilHashMap.putAll(parambhva.jdField_b_of_type_JavaUtilHashMap);
    localbevm.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", parambhva.jdField_d_of_type_JavaLangString);
    localbevm.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", parambhva.jdField_c_of_type_JavaLangString);
    localbevm.jdField_c_of_type_Int = parambhva.c();
  }
  
  public void a(bhva parambhva1, bhva parambhva2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    label310:
    do
    {
      for (;;)
      {
        return;
        this.jdField_a_of_type_Int = 0;
        if (this.jdField_a_of_type_Beum != null) {
          try
          {
            if ((parambhva2.c() == 206) || (parambhva2.c() == 200))
            {
              arrayOfByte = parambhva2.a();
              beun localbeun = this.jdField_a_of_type_Beum.jdField_a_of_type_Beun;
              parambhva1 = arrayOfByte;
              if (localbeun == null) {}
            }
          }
          catch (IOException parambhva1)
          {
            try
            {
              byte[] arrayOfByte;
              parambhva1 = this.jdField_a_of_type_Beum.jdField_a_of_type_Beun.a(arrayOfByte);
              if (parambhva1 == null) {
                continue;
              }
              int i = parambhva1.length;
              if (i <= 0) {
                continue;
              }
              this.jdField_b_of_type_Int += parambhva1.length;
              if (this.jdField_a_of_type_JavaIoOutputStream == null) {
                break label310;
              }
              this.jdField_a_of_type_JavaIoOutputStream.write(parambhva1);
              this.jdField_a_of_type_JavaIoOutputStream.flush();
              this.jdField_a_of_type_Bevm.jdField_a_of_type_Long = parambhva2.a();
              this.jdField_a_of_type_Bevm.jdField_b_of_type_Long = parambhva2.jdField_b_of_type_Long;
              parambhva2 = this.jdField_a_of_type_Bevm;
              parambhva2.jdField_c_of_type_Long += parambhva1.length;
              if (this.jdField_a_of_type_Beum.jdField_a_of_type_Beuq == null) {
                continue;
              }
              this.jdField_a_of_type_Beum.jdField_a_of_type_Beuq.onUpdateProgeress(this.jdField_a_of_type_Beum, this.jdField_a_of_type_Bevm.jdField_c_of_type_Long + this.jdField_a_of_type_Beum.jdField_a_of_type_Long, this.jdField_a_of_type_Bevm.jdField_a_of_type_Long);
              return;
            }
            catch (Throwable parambhva1)
            {
              parambhva1 = Log.getStackTraceString(parambhva1);
              throw new RuntimeException("FlowDecoderExp:" + parambhva1.substring(0, Math.min(100, parambhva1.length())));
            }
            parambhva1 = parambhva1;
            parambhva1.printStackTrace();
            this.jdField_a_of_type_Boolean = true;
            a(parambhva1, this.jdField_a_of_type_Bevm);
            throw new RuntimeException("io exceptionmsg:" + parambhva1.getMessage());
          }
        }
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
        break;
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile.length() == 0L) {
        this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(parambhva2.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_JavaIoRandomAccessFile.write(parambhva1);
      this.jdField_a_of_type_Bevm.jdField_a_of_type_Long = parambhva2.a();
      this.jdField_a_of_type_Bevm.jdField_b_of_type_Long = parambhva2.jdField_b_of_type_Long;
      parambhva2 = this.jdField_a_of_type_Bevm;
      parambhva2.jdField_c_of_type_Long += parambhva1.length;
    } while (this.jdField_a_of_type_Beum.jdField_a_of_type_Beuq == null);
    this.jdField_a_of_type_Beum.jdField_a_of_type_Beuq.onUpdateProgeress(this.jdField_a_of_type_Beum, this.jdField_a_of_type_Bevm.jdField_c_of_type_Long + this.jdField_a_of_type_Beum.jdField_a_of_type_Long, this.jdField_a_of_type_Bevm.jdField_a_of_type_Long);
    return;
    this.jdField_a_of_type_Bevm.jdField_a_of_type_Long = parambhva2.a();
    this.jdField_a_of_type_Bevm.jdField_b_of_type_Long = parambhva2.jdField_b_of_type_Long;
    this.jdField_a_of_type_Bevm.jdField_a_of_type_ArrayOfByte = parambhva2.a();
  }
  
  void a(IOException paramIOException, bevm parambevm)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      return;
      parambevm = paramIOException.getMessage();
      this.jdField_a_of_type_Bevm.a(1, 9301, parambevm + MsfSdkUtils.getStackTraceString(paramIOException), null);
      try
      {
        paramIOException = Environment.getExternalStorageState();
        if (parambevm.contains("EACCES"))
        {
          this.jdField_a_of_type_Bevm.jdField_b_of_type_Int = 9039;
          return;
        }
      }
      catch (Exception paramIOException)
      {
        paramIOException.printStackTrace();
        return;
      }
      if ((parambevm.contains("ENOSPC")) || (parambevm.contains("space")))
      {
        long l = bhjx.b();
        if (this.jdField_a_of_type_Beum != null)
        {
          paramIOException = this.jdField_a_of_type_Beum.jdField_c_of_type_JavaLangString;
          parambevm = new File(paramIOException).getParentFile();
          QLog.e("Q.richmedia.OldHttpEngine", 1, "no space error, outPath:" + paramIOException + ",fileCount:" + parambevm.listFiles().length + ",url:" + this.jdField_a_of_type_Beum.jdField_a_of_type_JavaLangString + ",availableSpace:" + l);
        }
        this.jdField_a_of_type_Bevm.jdField_b_of_type_Int = 9040;
        return;
      }
      if (parambevm.contains("Read-only"))
      {
        this.jdField_a_of_type_Bevm.jdField_b_of_type_Int = 9039;
        return;
      }
    } while ("mounted".equals(paramIOException));
    this.jdField_a_of_type_Bevm.jdField_b_of_type_Int = 9039;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Bevm != null) && (this.jdField_a_of_type_Bhva != null))
    {
      this.jdField_a_of_type_Bevm.jdField_f_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Bhva.jdField_c_of_type_Long);
      paramString = this.jdField_a_of_type_Bevm;
      paramString.jdField_e_of_type_Int += 1;
    }
  }
  
  public boolean a(bhva parambhva1, bhva parambhva2, int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    while (paramInt != 5) {
      return true;
    }
    a(parambhva2);
    if (this.jdField_a_of_type_Beum.a()) {
      c();
    }
    for (;;)
    {
      if (parambhva1.jdField_d_of_type_Long != 0L) {
        this.jdField_a_of_type_Bevm.g = parambhva1.jdField_d_of_type_Long;
      }
      this.jdField_a_of_type_Bevm.h = parambhva1.jdField_f_of_type_Long;
      d();
      return true;
      this.jdField_a_of_type_Bevm.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Bevm.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Bevm.jdField_a_of_type_JavaLangString = "";
      if (((this.jdField_a_of_type_Bevm.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_Bevm.jdField_a_of_type_ArrayOfByte.length != this.jdField_a_of_type_Bevm.jdField_b_of_type_Long)) || ((this.jdField_a_of_type_Bevm.jdField_a_of_type_ArrayOfByte == null) && (this.jdField_a_of_type_Bevm.jdField_b_of_type_Long != 0L)))
      {
        this.jdField_a_of_type_Bevm.a(1, -9527, null, null);
        parambhva2 = berp.a("Q", -9533L);
        this.jdField_a_of_type_Bevm.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", parambhva2);
        parambhva2 = this.jdField_a_of_type_Bevm;
        StringBuilder localStringBuilder = new StringBuilder().append("recvSize:");
        paramInt = i;
        if (this.jdField_a_of_type_Bevm.jdField_a_of_type_ArrayOfByte != null) {
          paramInt = this.jdField_a_of_type_Bevm.jdField_a_of_type_ArrayOfByte.length;
        }
        parambhva2.jdField_a_of_type_JavaLangString = (paramInt + " totalBlockLen:" + this.jdField_a_of_type_Bevm.jdField_b_of_type_Long);
      }
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_Int = bevn.a().a();
    Object localObject = this.jdField_a_of_type_Beum;
    bevm localbevm = this.jdField_a_of_type_Bevm;
    if ((localObject == null) || (localbevm == null))
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    label368:
    int i;
    if (((beum)localObject).jdField_c_of_type_JavaLangString != null)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaLangString = a(((beum)localObject).jdField_c_of_type_JavaLangString, ((beum)localObject).jdField_a_of_type_JavaLangString);
          localbevm.jdField_a_of_type_Bevl.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localFile = new File(this.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            break label368;
          }
          l = localFile.length();
          if ((l <= 0L) || (((beum)localObject).jdField_a_of_type_Beup == null)) {
            continue;
          }
          localbevm.jdField_c_of_type_Long = l;
          ((beum)localObject).jdField_a_of_type_Beup.a((bevl)localObject, localbevm);
          if (!((beum)localObject).j) {
            continue;
          }
          this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localFile, "rw");
          this.jdField_a_of_type_JavaIoRandomAccessFile.seek(((beum)localObject).jdField_a_of_type_Long);
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.OldHttpEngine", 2, "append.oring Len:" + l);
          }
        }
        catch (IOException localIOException)
        {
          File localFile;
          long l;
          localIOException.printStackTrace();
          this.jdField_b_of_type_Boolean = true;
          a(localIOException, localException);
          continue;
          if (!((beum)localObject).j) {
            continue;
          }
          this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localIOException, "rw");
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.richmedia.OldHttpEngine", 2, "oring Len:" + l + " trunk");
          continue;
          this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(localIOException);
          continue;
        }
        try
        {
          localObject = new URL(((beum)localObject).jdField_a_of_type_JavaLangString).getHost();
          localbevm.jdField_a_of_type_JavaUtilHashMap.put("firstserverip", localObject);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(localFile, true);
      }
      if (QLog.isColorLevel())
      {
        i = ((beum)localObject).jdField_f_of_type_Int;
        if (((beum)localObject).jdField_a_of_type_Int != 1) {
          break label486;
        }
      }
    }
    label486:
    for (boolean bool = true;; bool = false)
    {
      bews.a(i, bool, ((beum)localObject).jdField_e_of_type_Int, ((beum)localObject).jdField_e_of_type_JavaLangString, "createtmp", this.jdField_a_of_type_JavaLangString);
      bhmi.a(this.jdField_a_of_type_JavaLangString);
      if (((beum)localObject).j)
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localIOException, "rw");
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(localIOException);
      break;
      if (((beum)localObject).jdField_a_of_type_JavaIoOutputStream == null) {
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = ((beum)localObject).jdField_a_of_type_JavaIoOutputStream;
      break;
    }
  }
  
  public void b(bhva parambhva1, bhva parambhva2)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    beum localbeum;
    bevm localbevm;
    do
    {
      return;
      localbeum = this.jdField_a_of_type_Beum;
      localbevm = this.jdField_a_of_type_Bevm;
    } while ((localbeum == null) || (localbevm == null));
    a(parambhva2);
    long l1 = System.currentTimeMillis() - localbevm.jdField_e_of_type_Long;
    localbevm.jdField_d_of_type_Long += l1;
    if ((localbeum.jdField_a_of_type_JavaUtilList != null) && (localbeum.jdField_a_of_type_JavaUtilList.size() >= 1)) {
      ((bewy)localbeum.jdField_a_of_type_JavaUtilList.get(0)).a();
    }
    long l2 = bevn.a().a();
    boolean bool1;
    if (l2 != 0L)
    {
      bool1 = true;
      a(localbevm, l1, bool1);
      if (!this.jdField_a_of_type_Boolean)
      {
        localbevm.jdField_b_of_type_Int = parambhva2.jdField_f_of_type_Int;
        localbevm.jdField_a_of_type_JavaLangString = parambhva2.jdField_b_of_type_JavaLangString;
        localbevm.jdField_a_of_type_Int = 1;
        if (bool1) {
          break label231;
        }
        localbevm.jdField_b_of_type_Int = 9004;
        localbevm.jdField_a_of_type_JavaLangString = "no network";
        localbevm.jdField_a_of_type_Int = 1;
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int > 0) {
        bool2 = true;
      }
      if (!a(parambhva2, localbeum, localbevm)) {
        break label254;
      }
      a(localbeum, bool2, localbevm, parambhva2, parambhva1, bool1, l2);
      return;
      bool1 = false;
      break;
      label231:
      if (localbeum.jdField_a_of_type_Beur != null) {
        localbeum.jdField_a_of_type_Beur.c(localbevm);
      }
    }
    label254:
    d();
  }
  
  public void c()
  {
    int j = 0;
    this.jdField_a_of_type_Bevm.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bevm.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bevm.jdField_a_of_type_JavaLangString = "";
    int i = j;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      i = j;
      if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Beum.jdField_c_of_type_JavaLangString)) {
        i = 1;
      }
    }
    if (this.jdField_a_of_type_Beum.jdField_c_of_type_JavaLangString != null) {}
    try
    {
      if ((this.jdField_a_of_type_Beum.k) && (i == 0) && (bhmi.a(this.jdField_a_of_type_Beum.jdField_c_of_type_JavaLangString))) {
        bhmi.d(this.jdField_a_of_type_Beum.jdField_c_of_type_JavaLangString);
      }
    }
    catch (Exception localIOException1)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break label130;
        }
        this.jdField_a_of_type_JavaIoOutputStream.close();
        label130:
        if (!this.jdField_a_of_type_Beum.j) {
          break label154;
        }
      }
      catch (IOException localIOException1)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_JavaIoRandomAccessFile != null) {
              this.jdField_a_of_type_JavaIoRandomAccessFile.close();
            }
            label154:
            if (this.jdField_a_of_type_Beum.k) {
              break;
            }
            return;
            localException = localException;
            localException.printStackTrace();
          }
          localIOException1 = localIOException1;
          localIOException1.printStackTrace();
        }
        catch (IOException localIOException2)
        {
          do
          {
            for (;;)
            {
              localIOException2.printStackTrace();
            }
          } while ((i != 0) || (bhmi.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Beum.jdField_c_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangString == null));
          if (!bhmi.d(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Beum.jdField_c_of_type_JavaLangString)) {
            break label250;
          }
          new File(this.jdField_a_of_type_JavaLangString).delete();
          return;
          label250:
          this.jdField_a_of_type_Bevm.a(1, 9301, "rename file failed", null);
          new File(this.jdField_a_of_type_JavaLangString).delete();
        }
      }
    }
    if (this.jdField_a_of_type_Beum.jdField_c_of_type_JavaLangString != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevp
 * JD-Core Version:    0.7.0.1
 */