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

public class bdww
  implements bguz
{
  int jdField_a_of_type_Int = 0;
  public bdvs a;
  public bdwt a;
  public bgux a;
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
  
  public bdww(bdwv parambdwv)
  {
    this.jdField_c_of_type_Int = 5;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private long a(bdwt parambdwt, long paramLong)
  {
    if ((parambdwt.jdField_b_of_type_Int == 9056) && (paramLong != 0L)) {
      return 0L;
    }
    if (paramLong != 0L) {
      return 3000L;
    }
    return 6000L;
  }
  
  private void a(long paramLong, bdvs parambdvs)
  {
    int i;
    if ((QLog.isColorLevel()) && (parambdvs != null))
    {
      i = parambdvs.jdField_f_of_type_Int;
      if (parambdvs.jdField_a_of_type_Int != 1) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      bdxz.a(i, bool, parambdvs.jdField_e_of_type_Int, parambdvs.jdField_e_of_type_JavaLangString, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_Bdwt.jdField_e_of_type_Long = System.currentTimeMillis();
    if (bdwu.a().a() != 0)
    {
      if ((this.jdField_a_of_type_Bdwv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramLong != 0L))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new OldHttpEngine.OldHttpCommunicatorListner.1(this, parambdvs), paramLong);
        return;
      }
      if ((QLog.isColorLevel()) && (parambdvs != null))
      {
        i = parambdvs.jdField_f_of_type_Int;
        if (parambdvs.jdField_a_of_type_Int != 1) {
          break label228;
        }
      }
      label228:
      for (bool = true;; bool = false)
      {
        bdxz.a(i, bool, parambdvs.jdField_e_of_type_Int, parambdvs.jdField_e_of_type_JavaLangString, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
        this.jdField_a_of_type_Bdwv.a(this.jdField_a_of_type_Bdvs, false);
        return;
      }
    }
    if (this.jdField_a_of_type_Bdwv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      ThreadManager.getTimer().schedule(new OldHttpEngine.OldHttpCommunicatorListner.2(this, parambdvs), paramLong);
      return;
    }
    if ((QLog.isColorLevel()) && (parambdvs != null))
    {
      i = parambdvs.jdField_f_of_type_Int;
      if (parambdvs.jdField_a_of_type_Int != 1) {
        break label321;
      }
    }
    label321:
    for (bool = true;; bool = false)
    {
      bdxz.a(i, bool, parambdvs.jdField_e_of_type_Int, parambdvs.jdField_e_of_type_JavaLangString, "scheduleRetry", "mWorking is false");
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
  }
  
  private void a(bdvs parambdvs)
  {
    int i;
    if ((QLog.isColorLevel()) && (parambdvs != null))
    {
      i = parambdvs.jdField_f_of_type_Int;
      if (parambdvs.jdField_a_of_type_Int != 1) {
        break label94;
      }
    }
    label94:
    for (boolean bool = true;; bool = false)
    {
      bdxz.a(i, bool, parambdvs.jdField_e_of_type_Int, parambdvs.jdField_e_of_type_JavaLangString, "retrySync", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      this.jdField_a_of_type_Bdwt.jdField_e_of_type_Long = System.currentTimeMillis();
      if (bdwu.a().a() == 0) {
        break;
      }
      this.jdField_a_of_type_Bdwv.a(this.jdField_a_of_type_Bdvs, true);
      return;
    }
    this.jdField_a_of_type_Bgux.a(9004, -1, "nonetwork");
    d();
  }
  
  private boolean a(bdwt parambdwt, bdvs parambdvs)
  {
    if (parambdwt.jdField_c_of_type_Long > 0L)
    {
      if (!parambdvs.c()) {
        break label46;
      }
      if (parambdvs.jdField_a_of_type_Bdvv == null) {
        break label44;
      }
      parambdvs.jdField_a_of_type_Bdvv.a(parambdvs, parambdwt);
      this.jdField_a_of_type_JavaIoOutputStream = parambdvs.jdField_a_of_type_JavaIoOutputStream;
    }
    label44:
    label46:
    while (!parambdvs.b())
    {
      return true;
      return false;
    }
    if (parambdvs.jdField_a_of_type_Bdvv != null)
    {
      parambdvs.jdField_a_of_type_Bdvv.a(parambdvs, parambdwt);
      return true;
    }
    if (this.jdField_a_of_type_JavaIoOutputStream != null) {
      try
      {
        this.jdField_a_of_type_JavaIoOutputStream.close();
        this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
        parambdwt.jdField_c_of_type_Long = 0L;
        return true;
      }
      catch (IOException parambdvs)
      {
        a(parambdvs, parambdwt);
      }
    }
    return false;
  }
  
  private boolean a(bgux parambgux, bdvs parambdvs, bdwt parambdwt)
  {
    return (!this.jdField_a_of_type_Boolean) && (parambgux.c()) && (parambdwt.jdField_d_of_type_Long < parambdvs.jdField_c_of_type_Long - 5000L) && (this.jdField_a_of_type_Int <= parambdvs.jdField_b_of_type_Int);
  }
  
  private void d()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    bdvs localbdvs = this.jdField_a_of_type_Bdvs;
    bdwt localbdwt = this.jdField_a_of_type_Bdwt;
    OutputStream localOutputStream;
    RandomAccessFile localRandomAccessFile;
    if (localbdvs != null)
    {
      localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
      localRandomAccessFile = this.jdField_a_of_type_JavaIoRandomAccessFile;
      if ((localbdvs.jdField_c_of_type_JavaLangString == null) || (localOutputStream == null)) {}
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
        if (localbdwt != null)
        {
          if ((localbdvs.jdField_f_of_type_JavaLangString != null) && (localbdwt.jdField_a_of_type_Int != 3)) {
            bdwv.a(this.jdField_a_of_type_Bdwv).remove(localbdvs.jdField_f_of_type_JavaLangString);
          }
          new bedi(localbdvs, localbdwt).a();
          if (localbdvs.jdField_a_of_type_Bdvw != null)
          {
            if (QLog.isColorLevel())
            {
              int i = localbdvs.jdField_f_of_type_Int;
              if (localbdvs.jdField_a_of_type_Int != 1) {
                break label260;
              }
              bdxz.a(i, bool, localbdvs.jdField_e_of_type_Int, localbdvs.jdField_e_of_type_JavaLangString, "onOutEngine", "result:" + localbdwt.jdField_a_of_type_Int + " errCode:" + localbdwt.jdField_b_of_type_Int + " desc:" + localbdwt.jdField_a_of_type_JavaLangString);
            }
            if ((localbdwt.jdField_b_of_type_Int == 9367) && (QLog.isColorLevel())) {
              break label265;
            }
            localbdvs.jdField_a_of_type_Bdvw.onResp(localbdwt);
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
          bcsz.a("Http_Download_Queen_Full", this.jdField_a_of_type_Bdwv.jdField_a_of_type_Bgut.a());
        }
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = bdwv.a(this.jdField_a_of_type_Bdvs, paramString1, paramString2);
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    bdvs localbdvs = this.jdField_a_of_type_Bdvs;
    if (localbdvs != null) {
      localbdvs.jdField_a_of_type_JavaLangObject = null;
    }
    this.jdField_a_of_type_Bdvs = null;
    this.jdField_a_of_type_Bdwt = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
  }
  
  void a(bdvs parambdvs, boolean paramBoolean1, bdwt parambdwt, bgux parambgux1, bgux parambgux2, boolean paramBoolean2, long paramLong)
  {
    boolean bool;
    int i;
    label66:
    long l;
    if (QLog.isColorLevel())
    {
      int j = parambdvs.jdField_f_of_type_Int;
      if (parambdvs.jdField_a_of_type_Int == 1)
      {
        bool = true;
        int k = parambdvs.jdField_e_of_type_Int;
        parambgux1 = parambdvs.jdField_e_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("tryTime:");
        if (this.jdField_a_of_type_Bdwt == null) {
          break label220;
        }
        i = this.jdField_a_of_type_Bdwt.jdField_d_of_type_Int;
        localStringBuilder = localStringBuilder.append(i).append(" consumeTime:");
        if (this.jdField_a_of_type_Bdwt == null) {
          break label226;
        }
        l = this.jdField_a_of_type_Bdwt.jdField_d_of_type_Long;
        label97:
        bdxz.a(j, bool, k, parambgux1, "retry", l + " isLastGetData:" + paramBoolean1);
      }
    }
    else
    {
      paramBoolean1 = a(parambdwt, parambdvs);
      if (this.jdField_e_of_type_Int >= parambdvs.jdField_c_of_type_Int) {
        parambdvs.jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
      if (paramBoolean1) {
        break label237;
      }
      if (QLog.isColorLevel())
      {
        i = parambdvs.jdField_f_of_type_Int;
        if (parambdvs.jdField_a_of_type_Int != 1) {
          break label232;
        }
      }
    }
    label220:
    label226:
    label232:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      bdxz.a(i, paramBoolean1, parambdvs.jdField_e_of_type_Int, parambdvs.jdField_e_of_type_JavaLangString, "retry", "breakDownAllowRetry is false ");
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
    if (parambdvs.jdField_a_of_type_Bdvt != null) {
      parambdvs.jdField_a_of_type_Bdvt.a();
    }
    if ((parambdvs.jdField_a_of_type_Boolean) && (parambdvs.jdField_b_of_type_Boolean)) {
      InnerDns.getInstance().reportBadIp(InnerDns.getHostFromUrl(parambdvs.jdField_a_of_type_JavaLangString), InnerDns.getHostFromUrl(parambgux2.a()), 1002);
    }
    if ((parambdvs.jdField_a_of_type_JavaUtilList != null) && (parambdvs.jdField_a_of_type_JavaUtilList.size() >= 1) && (paramBoolean2))
    {
      parambgux1 = (bdyf)parambdvs.jdField_a_of_type_JavaUtilList.remove(0);
      parambdvs.jdField_a_of_type_JavaUtilList.add(parambgux1);
      parambgux1 = (bdyf)parambdvs.jdField_a_of_type_JavaUtilList.get(0);
      if (parambdvs.jdField_a_of_type_JavaLangString != null)
      {
        parambgux1 = parambgux1.a(parambdvs.jdField_a_of_type_JavaLangString);
        parambdvs.jdField_a_of_type_JavaLangString = bdxz.a(parambdvs.jdField_a_of_type_JavaLangString, parambgux1);
      }
    }
    if ((parambdwt.jdField_b_of_type_Int == 9050) && (parambdvs.jdField_a_of_type_Bdxx != null)) {
      parambdvs.jdField_a_of_type_Bdxx.a(this.jdField_a_of_type_Int);
    }
    paramLong = a(parambdwt, paramLong);
    if (this.jdField_a_of_type_Bgux.l)
    {
      a(parambdvs);
      return;
    }
    a(paramLong, parambdvs);
  }
  
  void a(bdws parambdws)
  {
    try
    {
      if ((parambdws.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaIoOutputStream != null)) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {}
    }
    catch (IOException parambdws)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaIoRandomAccessFile.close();
          return;
        }
        catch (IOException parambdws)
        {
          parambdws.printStackTrace();
        }
        parambdws = parambdws;
        parambdws.printStackTrace();
      }
    }
  }
  
  public void a(bdwt parambdwt, long paramLong, boolean paramBoolean)
  {
    if ((parambdwt.jdField_b_of_type_Int == 9056) && (paramLong < 2000L))
    {
      int i = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = (i - 1);
      if (i <= 0) {}
    }
    for (;;)
    {
      if ((parambdwt.jdField_b_of_type_Int == 9056) || (parambdwt.jdField_b_of_type_Int == 9051)) {
        this.jdField_e_of_type_Int += 1;
      }
      return;
      if (paramBoolean) {
        this.jdField_a_of_type_Int += 1;
      }
    }
  }
  
  void a(bgux parambgux)
  {
    bdwt localbdwt = this.jdField_a_of_type_Bdwt;
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localbdwt == null)) {
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = localbdwt.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap2.containsKey("firstserverip")) {
      localHashMap1.put("firstserverip", localHashMap2.get("firstserverip"));
    }
    if (localHashMap2.containsKey("serverip")) {
      localHashMap1.put("serverip", localHashMap2.get("serverip"));
    }
    if (localHashMap2.containsKey("param_url")) {
      localHashMap1.put("param_url", localHashMap2.get("param_url"));
    }
    if (parambgux.jdField_b_of_type_JavaUtilHashMap.containsKey(bgux.jdField_f_of_type_JavaLangString)) {
      localHashMap1.put("netresp_param_reason", parambgux.jdField_b_of_type_JavaUtilHashMap.get(bgux.jdField_f_of_type_JavaLangString));
    }
    localbdwt.jdField_a_of_type_JavaUtilHashMap.clear();
    localbdwt.jdField_a_of_type_JavaUtilHashMap.putAll(localHashMap1);
    localbdwt.jdField_a_of_type_JavaUtilHashMap.putAll(parambgux.jdField_b_of_type_JavaUtilHashMap);
    localbdwt.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", parambgux.jdField_d_of_type_JavaLangString);
    localbdwt.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", parambgux.jdField_c_of_type_JavaLangString);
    localbdwt.jdField_c_of_type_Int = parambgux.c();
  }
  
  public void a(bgux parambgux1, bgux parambgux2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    label310:
    do
    {
      for (;;)
      {
        return;
        this.jdField_a_of_type_Int = 0;
        if (this.jdField_a_of_type_Bdvs != null) {
          try
          {
            if ((parambgux2.c() == 206) || (parambgux2.c() == 200))
            {
              arrayOfByte = parambgux2.a();
              bdvt localbdvt = this.jdField_a_of_type_Bdvs.jdField_a_of_type_Bdvt;
              parambgux1 = arrayOfByte;
              if (localbdvt == null) {}
            }
          }
          catch (IOException parambgux1)
          {
            try
            {
              byte[] arrayOfByte;
              parambgux1 = this.jdField_a_of_type_Bdvs.jdField_a_of_type_Bdvt.a(arrayOfByte);
              if (parambgux1 == null) {
                continue;
              }
              int i = parambgux1.length;
              if (i <= 0) {
                continue;
              }
              this.jdField_b_of_type_Int += parambgux1.length;
              if (this.jdField_a_of_type_JavaIoOutputStream == null) {
                break label310;
              }
              this.jdField_a_of_type_JavaIoOutputStream.write(parambgux1);
              this.jdField_a_of_type_JavaIoOutputStream.flush();
              this.jdField_a_of_type_Bdwt.jdField_a_of_type_Long = parambgux2.a();
              this.jdField_a_of_type_Bdwt.jdField_b_of_type_Long = parambgux2.jdField_b_of_type_Long;
              parambgux2 = this.jdField_a_of_type_Bdwt;
              parambgux2.jdField_c_of_type_Long += parambgux1.length;
              if (this.jdField_a_of_type_Bdvs.jdField_a_of_type_Bdvw == null) {
                continue;
              }
              this.jdField_a_of_type_Bdvs.jdField_a_of_type_Bdvw.onUpdateProgeress(this.jdField_a_of_type_Bdvs, this.jdField_a_of_type_Bdwt.jdField_c_of_type_Long + this.jdField_a_of_type_Bdvs.jdField_a_of_type_Long, this.jdField_a_of_type_Bdwt.jdField_a_of_type_Long);
              return;
            }
            catch (Throwable parambgux1)
            {
              parambgux1 = Log.getStackTraceString(parambgux1);
              throw new RuntimeException("FlowDecoderExp:" + parambgux1.substring(0, Math.min(100, parambgux1.length())));
            }
            parambgux1 = parambgux1;
            parambgux1.printStackTrace();
            this.jdField_a_of_type_Boolean = true;
            a(parambgux1, this.jdField_a_of_type_Bdwt);
            throw new RuntimeException("io exceptionmsg:" + parambgux1.getMessage());
          }
        }
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
        break;
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile.length() == 0L) {
        this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(parambgux2.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_JavaIoRandomAccessFile.write(parambgux1);
      this.jdField_a_of_type_Bdwt.jdField_a_of_type_Long = parambgux2.a();
      this.jdField_a_of_type_Bdwt.jdField_b_of_type_Long = parambgux2.jdField_b_of_type_Long;
      parambgux2 = this.jdField_a_of_type_Bdwt;
      parambgux2.jdField_c_of_type_Long += parambgux1.length;
    } while (this.jdField_a_of_type_Bdvs.jdField_a_of_type_Bdvw == null);
    this.jdField_a_of_type_Bdvs.jdField_a_of_type_Bdvw.onUpdateProgeress(this.jdField_a_of_type_Bdvs, this.jdField_a_of_type_Bdwt.jdField_c_of_type_Long + this.jdField_a_of_type_Bdvs.jdField_a_of_type_Long, this.jdField_a_of_type_Bdwt.jdField_a_of_type_Long);
    return;
    this.jdField_a_of_type_Bdwt.jdField_a_of_type_Long = parambgux2.a();
    this.jdField_a_of_type_Bdwt.jdField_b_of_type_Long = parambgux2.jdField_b_of_type_Long;
    this.jdField_a_of_type_Bdwt.jdField_a_of_type_ArrayOfByte = parambgux2.a();
  }
  
  void a(IOException paramIOException, bdwt parambdwt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      return;
      parambdwt = paramIOException.getMessage();
      this.jdField_a_of_type_Bdwt.a(1, 9301, parambdwt + MsfSdkUtils.getStackTraceString(paramIOException), null);
      try
      {
        paramIOException = Environment.getExternalStorageState();
        if (parambdwt.contains("EACCES"))
        {
          this.jdField_a_of_type_Bdwt.jdField_b_of_type_Int = 9039;
          return;
        }
      }
      catch (Exception paramIOException)
      {
        paramIOException.printStackTrace();
        return;
      }
      if ((parambdwt.contains("ENOSPC")) || (parambdwt.contains("space")))
      {
        long l = bgjw.b();
        if (this.jdField_a_of_type_Bdvs != null)
        {
          paramIOException = this.jdField_a_of_type_Bdvs.jdField_c_of_type_JavaLangString;
          parambdwt = new File(paramIOException).getParentFile();
          QLog.e("Q.richmedia.OldHttpEngine", 1, "no space error, outPath:" + paramIOException + ",fileCount:" + parambdwt.listFiles().length + ",url:" + this.jdField_a_of_type_Bdvs.jdField_a_of_type_JavaLangString + ",availableSpace:" + l);
        }
        this.jdField_a_of_type_Bdwt.jdField_b_of_type_Int = 9040;
        return;
      }
      if (parambdwt.contains("Read-only"))
      {
        this.jdField_a_of_type_Bdwt.jdField_b_of_type_Int = 9039;
        return;
      }
    } while ("mounted".equals(paramIOException));
    this.jdField_a_of_type_Bdwt.jdField_b_of_type_Int = 9039;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Bdwt != null) && (this.jdField_a_of_type_Bgux != null))
    {
      this.jdField_a_of_type_Bdwt.jdField_f_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Bgux.jdField_c_of_type_Long);
      paramString = this.jdField_a_of_type_Bdwt;
      paramString.jdField_e_of_type_Int += 1;
    }
  }
  
  public boolean a(bgux parambgux1, bgux parambgux2, int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    while (paramInt != 5) {
      return true;
    }
    a(parambgux2);
    if (this.jdField_a_of_type_Bdvs.a()) {
      c();
    }
    for (;;)
    {
      if (parambgux1.jdField_d_of_type_Long != 0L) {
        this.jdField_a_of_type_Bdwt.g = parambgux1.jdField_d_of_type_Long;
      }
      this.jdField_a_of_type_Bdwt.h = parambgux1.jdField_f_of_type_Long;
      d();
      return true;
      this.jdField_a_of_type_Bdwt.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Bdwt.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Bdwt.jdField_a_of_type_JavaLangString = "";
      if (((this.jdField_a_of_type_Bdwt.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_Bdwt.jdField_a_of_type_ArrayOfByte.length != this.jdField_a_of_type_Bdwt.jdField_b_of_type_Long)) || ((this.jdField_a_of_type_Bdwt.jdField_a_of_type_ArrayOfByte == null) && (this.jdField_a_of_type_Bdwt.jdField_b_of_type_Long != 0L)))
      {
        this.jdField_a_of_type_Bdwt.a(1, -9527, null, null);
        parambgux2 = bdsx.a("Q", -9533L);
        this.jdField_a_of_type_Bdwt.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", parambgux2);
        parambgux2 = this.jdField_a_of_type_Bdwt;
        StringBuilder localStringBuilder = new StringBuilder().append("recvSize:");
        paramInt = i;
        if (this.jdField_a_of_type_Bdwt.jdField_a_of_type_ArrayOfByte != null) {
          paramInt = this.jdField_a_of_type_Bdwt.jdField_a_of_type_ArrayOfByte.length;
        }
        parambgux2.jdField_a_of_type_JavaLangString = (paramInt + " totalBlockLen:" + this.jdField_a_of_type_Bdwt.jdField_b_of_type_Long);
      }
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_Int = bdwu.a().a();
    Object localObject = this.jdField_a_of_type_Bdvs;
    bdwt localbdwt = this.jdField_a_of_type_Bdwt;
    if ((localObject == null) || (localbdwt == null))
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    label368:
    int i;
    if (((bdvs)localObject).jdField_c_of_type_JavaLangString != null)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaLangString = a(((bdvs)localObject).jdField_c_of_type_JavaLangString, ((bdvs)localObject).jdField_a_of_type_JavaLangString);
          localbdwt.jdField_a_of_type_Bdws.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localFile = new File(this.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            break label368;
          }
          l = localFile.length();
          if ((l <= 0L) || (((bdvs)localObject).jdField_a_of_type_Bdvv == null)) {
            continue;
          }
          localbdwt.jdField_c_of_type_Long = l;
          ((bdvs)localObject).jdField_a_of_type_Bdvv.a((bdws)localObject, localbdwt);
          if (!((bdvs)localObject).j) {
            continue;
          }
          this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localFile, "rw");
          this.jdField_a_of_type_JavaIoRandomAccessFile.seek(((bdvs)localObject).jdField_a_of_type_Long);
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
          if (!((bdvs)localObject).j) {
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
          localObject = new URL(((bdvs)localObject).jdField_a_of_type_JavaLangString).getHost();
          localbdwt.jdField_a_of_type_JavaUtilHashMap.put("firstserverip", localObject);
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
        i = ((bdvs)localObject).jdField_f_of_type_Int;
        if (((bdvs)localObject).jdField_a_of_type_Int != 1) {
          break label486;
        }
      }
    }
    label486:
    for (boolean bool = true;; bool = false)
    {
      bdxz.a(i, bool, ((bdvs)localObject).jdField_e_of_type_Int, ((bdvs)localObject).jdField_e_of_type_JavaLangString, "createtmp", this.jdField_a_of_type_JavaLangString);
      bgmg.a(this.jdField_a_of_type_JavaLangString);
      if (((bdvs)localObject).j)
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localIOException, "rw");
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(localIOException);
      break;
      if (((bdvs)localObject).jdField_a_of_type_JavaIoOutputStream == null) {
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = ((bdvs)localObject).jdField_a_of_type_JavaIoOutputStream;
      break;
    }
  }
  
  public void b(bgux parambgux1, bgux parambgux2)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    bdvs localbdvs;
    bdwt localbdwt;
    do
    {
      return;
      localbdvs = this.jdField_a_of_type_Bdvs;
      localbdwt = this.jdField_a_of_type_Bdwt;
    } while ((localbdvs == null) || (localbdwt == null));
    a(parambgux2);
    long l1 = System.currentTimeMillis() - localbdwt.jdField_e_of_type_Long;
    localbdwt.jdField_d_of_type_Long += l1;
    if ((localbdvs.jdField_a_of_type_JavaUtilList != null) && (localbdvs.jdField_a_of_type_JavaUtilList.size() >= 1)) {
      ((bdyf)localbdvs.jdField_a_of_type_JavaUtilList.get(0)).a();
    }
    long l2 = bdwu.a().a();
    boolean bool1;
    if (l2 != 0L)
    {
      bool1 = true;
      a(localbdwt, l1, bool1);
      if (!this.jdField_a_of_type_Boolean)
      {
        localbdwt.jdField_b_of_type_Int = parambgux2.jdField_f_of_type_Int;
        localbdwt.jdField_a_of_type_JavaLangString = parambgux2.jdField_b_of_type_JavaLangString;
        localbdwt.jdField_a_of_type_Int = 1;
        if (bool1) {
          break label231;
        }
        localbdwt.jdField_b_of_type_Int = 9004;
        localbdwt.jdField_a_of_type_JavaLangString = "no network";
        localbdwt.jdField_a_of_type_Int = 1;
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int > 0) {
        bool2 = true;
      }
      if (!a(parambgux2, localbdvs, localbdwt)) {
        break label254;
      }
      a(localbdvs, bool2, localbdwt, parambgux2, parambgux1, bool1, l2);
      return;
      bool1 = false;
      break;
      label231:
      if (localbdvs.jdField_a_of_type_Bdvx != null) {
        localbdvs.jdField_a_of_type_Bdvx.c(localbdwt);
      }
    }
    label254:
    d();
  }
  
  public void c()
  {
    int j = 0;
    this.jdField_a_of_type_Bdwt.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bdwt.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bdwt.jdField_a_of_type_JavaLangString = "";
    int i = j;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      i = j;
      if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Bdvs.jdField_c_of_type_JavaLangString)) {
        i = 1;
      }
    }
    if (this.jdField_a_of_type_Bdvs.jdField_c_of_type_JavaLangString != null) {}
    try
    {
      if ((this.jdField_a_of_type_Bdvs.k) && (i == 0) && (bgmg.a(this.jdField_a_of_type_Bdvs.jdField_c_of_type_JavaLangString))) {
        bgmg.d(this.jdField_a_of_type_Bdvs.jdField_c_of_type_JavaLangString);
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
        if (!this.jdField_a_of_type_Bdvs.j) {
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
            if (this.jdField_a_of_type_Bdvs.k) {
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
          } while ((i != 0) || (bgmg.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bdvs.jdField_c_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangString == null));
          if (!bgmg.d(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bdvs.jdField_c_of_type_JavaLangString)) {
            break label250;
          }
          new File(this.jdField_a_of_type_JavaLangString).delete();
          return;
          label250:
          this.jdField_a_of_type_Bdwt.a(1, 9301, "rename file failed", null);
          new File(this.jdField_a_of_type_JavaLangString).delete();
        }
      }
    }
    if (this.jdField_a_of_type_Bdvs.jdField_c_of_type_JavaLangString != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdww
 * JD-Core Version:    0.7.0.1
 */