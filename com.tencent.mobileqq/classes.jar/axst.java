import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.1;
import com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.2;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import mqq.os.MqqHandler;

public class axst
  implements baky
{
  int jdField_a_of_type_Int = 0;
  public axro a;
  public axsq a;
  public bakw a;
  public OutputStream a;
  public RandomAccessFile a;
  String jdField_a_of_type_JavaLangString = null;
  public AtomicBoolean a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  int d;
  int e = 0;
  
  public axst(axss paramaxss)
  {
    this.jdField_c_of_type_Int = 5;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(long paramLong, axro paramaxro)
  {
    int i;
    if ((QLog.isColorLevel()) && (paramaxro != null))
    {
      i = paramaxro.g;
      if (paramaxro.jdField_a_of_type_Int != 1) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      axub.a(i, bool, paramaxro.jdField_f_of_type_Int, paramaxro.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_Axsq.jdField_f_of_type_Long = System.currentTimeMillis();
    if (axsr.a().a() != 0)
    {
      if ((this.jdField_a_of_type_Axss.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramLong != 0L))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new OldHttpEngine.OldHttpCommunicatorListner.1(this, paramaxro), paramLong);
        return;
      }
      if ((QLog.isColorLevel()) && (paramaxro != null))
      {
        i = paramaxro.g;
        if (paramaxro.jdField_a_of_type_Int != 1) {
          break label227;
        }
      }
      label227:
      for (bool = true;; bool = false)
      {
        axub.a(i, bool, paramaxro.jdField_f_of_type_Int, paramaxro.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
        this.jdField_a_of_type_Axss.c(this.jdField_a_of_type_Axro);
        return;
      }
    }
    if (this.jdField_a_of_type_Axss.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      ThreadManager.getTimer().schedule(new OldHttpEngine.OldHttpCommunicatorListner.2(this, paramaxro), paramLong);
      return;
    }
    if ((QLog.isColorLevel()) && (paramaxro != null))
    {
      i = paramaxro.g;
      if (paramaxro.jdField_a_of_type_Int != 1) {
        break label320;
      }
    }
    label320:
    for (bool = true;; bool = false)
    {
      axub.a(i, bool, paramaxro.jdField_f_of_type_Int, paramaxro.e, "scheduleRetry", "mWorking is false");
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
  }
  
  private boolean a(bakw parambakw)
  {
    return false;
  }
  
  private void c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    axro localaxro = this.jdField_a_of_type_Axro;
    axsq localaxsq = this.jdField_a_of_type_Axsq;
    OutputStream localOutputStream;
    RandomAccessFile localRandomAccessFile;
    if (localaxro != null)
    {
      localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
      localRandomAccessFile = this.jdField_a_of_type_JavaIoRandomAccessFile;
      if ((localaxro.jdField_c_of_type_JavaLangString == null) || (localOutputStream == null)) {}
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
        if (localaxsq != null)
        {
          if ((localaxro.jdField_f_of_type_JavaLangString != null) && (localaxsq.jdField_a_of_type_Int != 3)) {
            axss.a(this.jdField_a_of_type_Axss).remove(localaxro.jdField_f_of_type_JavaLangString);
          }
          if (localaxro.jdField_a_of_type_Axrt != null)
          {
            if (QLog.isColorLevel())
            {
              int i = localaxro.g;
              if (localaxro.jdField_a_of_type_Int != 1) {
                break label246;
              }
              axub.a(i, bool, localaxro.jdField_f_of_type_Int, localaxro.e, "onOutEngine", "result:" + localaxsq.jdField_a_of_type_Int + " errCode:" + localaxsq.jdField_b_of_type_Int + " desc:" + localaxsq.jdField_a_of_type_JavaLangString);
            }
            if ((localaxsq.jdField_b_of_type_Int == 9367) && (QLog.isColorLevel())) {
              break label251;
            }
            localaxro.jdField_a_of_type_Axrt.onResp(localaxsq);
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
          label246:
          bool = false;
          continue;
          label251:
          awrc.a("Http_Download_Queen_Full", this.jdField_a_of_type_Axss.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a());
        }
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = axss.a(this.jdField_a_of_type_Axro, paramString1, paramString2);
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    axro localaxro = this.jdField_a_of_type_Axro;
    if (localaxro != null) {
      localaxro.jdField_a_of_type_JavaLangObject = null;
    }
    this.jdField_a_of_type_Axro = null;
    this.jdField_a_of_type_Axsq = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
  }
  
  void a(axsp paramaxsp)
  {
    try
    {
      if ((paramaxsp.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaIoOutputStream != null)) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {}
    }
    catch (IOException paramaxsp)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaIoRandomAccessFile.close();
          return;
        }
        catch (IOException paramaxsp)
        {
          paramaxsp.printStackTrace();
        }
        paramaxsp = paramaxsp;
        paramaxsp.printStackTrace();
      }
    }
  }
  
  void a(bakw parambakw)
  {
    axsq localaxsq = this.jdField_a_of_type_Axsq;
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localaxsq == null)) {
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = localaxsq.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap2.containsKey("firstserverip")) {
      localHashMap1.put("firstserverip", localHashMap2.get("firstserverip"));
    }
    if (localHashMap2.containsKey("serverip")) {
      localHashMap1.put("serverip", localHashMap2.get("serverip"));
    }
    if (localHashMap2.containsKey("param_url")) {
      localHashMap1.put("param_url", localHashMap2.get("param_url"));
    }
    if (parambakw.jdField_b_of_type_JavaUtilHashMap.containsKey(bakw.jdField_f_of_type_JavaLangString)) {
      localHashMap1.put("netresp_param_reason", parambakw.jdField_b_of_type_JavaUtilHashMap.get(bakw.jdField_f_of_type_JavaLangString));
    }
    localaxsq.jdField_a_of_type_JavaUtilHashMap.clear();
    localaxsq.jdField_a_of_type_JavaUtilHashMap.putAll(localHashMap1);
    localaxsq.jdField_a_of_type_JavaUtilHashMap.putAll(parambakw.jdField_b_of_type_JavaUtilHashMap);
    localaxsq.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", parambakw.jdField_d_of_type_JavaLangString);
    localaxsq.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", parambakw.jdField_c_of_type_JavaLangString);
    localaxsq.jdField_c_of_type_Int = parambakw.c();
  }
  
  public void a(bakw parambakw1, bakw parambakw2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    label309:
    label470:
    label598:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Int = 0;
        } while (this.jdField_a_of_type_Axro == null);
        Object localObject1;
        int i;
        for (;;)
        {
          for (;;)
          {
            try
            {
              if ((parambakw2.c() != 206) && (parambakw2.c() != 200)) {
                break;
              }
              parambakw1 = parambakw2.a();
              localObject2 = this.jdField_a_of_type_Axro.jdField_a_of_type_Axrq;
              localObject1 = parambakw1;
              if (localObject2 == null) {}
            }
            catch (IOException parambakw1)
            {
              parambakw1.printStackTrace();
              this.jdField_a_of_type_Boolean = true;
              a(parambakw1, this.jdField_a_of_type_Axsq);
              throw new RuntimeException("io exceptionmsg:" + parambakw1.getMessage());
            }
            try
            {
              localObject1 = this.jdField_a_of_type_Axro.jdField_a_of_type_Axrq.a(parambakw1);
              if (localObject1 == null) {
                break;
              }
              i = localObject1.length;
              if (i <= 0) {
                break;
              }
              parambakw1 = (bakw)localObject1;
              if (localObject1.length <= 0) {
                break label598;
              }
              parambakw1 = (bakw)localObject1;
              if (this.jdField_a_of_type_Axro.jdField_a_of_type_Axrp == null) {
                break label598;
              }
              l1 = System.nanoTime();
              i = 1;
              parambakw1 = null;
            }
            catch (Throwable parambakw1)
            {
              parambakw1 = Log.getStackTraceString(parambakw1);
              throw new RuntimeException("FlowDecoderExp:" + parambakw1.substring(0, Math.min(100, parambakw1.length())));
            }
          }
          try
          {
            localObject2 = Cipher.getInstance("AES/ECB/NoPadding");
            ((Cipher)localObject2).init(2, new SecretKeySpec(this.jdField_a_of_type_Axro.jdField_a_of_type_Axrp.jdField_a_of_type_ArrayOfByte, "AES"));
            if (localObject1.length % 16 != 0) {
              break label309;
            }
            localObject2 = ((Cipher)localObject2).doFinal((byte[])localObject1);
            localObject1 = localObject2;
          }
          catch (NoSuchAlgorithmException parambakw1)
          {
            int j;
            byte[] arrayOfByte;
            parambakw1 = Log.getStackTraceString(parambakw1);
            i = 0;
            continue;
            if (!QLog.isColorLevel()) {
              break label470;
            }
            QLog.e("Q.richmedia.OldHttpEngine", 2, "padding erro,recLen =" + localObject1.length + " writeLen=" + this.jdField_a_of_type_Axsq.jdField_c_of_type_Long + " totalLen=" + parambakw2.a());
            parambakw1 = "padding erro,recLen =" + localObject1.length + " writeLen=" + this.jdField_a_of_type_Axsq.jdField_c_of_type_Long + " totalLen=" + parambakw2.a();
            i = 0;
            continue;
          }
          catch (NoSuchPaddingException parambakw1)
          {
            parambakw1 = Log.getStackTraceString(parambakw1);
            i = 0;
            continue;
          }
          catch (InvalidKeyException parambakw1)
          {
            parambakw1 = Log.getStackTraceString(parambakw1);
            i = 0;
            continue;
          }
          catch (IllegalBlockSizeException parambakw1)
          {
            parambakw1 = Log.getStackTraceString(parambakw1);
            i = 0;
            continue;
          }
          catch (BadPaddingException parambakw1)
          {
            parambakw1 = Log.getStackTraceString(parambakw1);
            i = 0;
            continue;
            long l2 = System.nanoTime();
            parambakw1 = this.jdField_a_of_type_Axsq;
            parambakw1.j = (l2 - l1 + parambakw1.j);
            parambakw1 = (bakw)localObject1;
          }
          if (i != 0) {
            break label571;
          }
          throw new RuntimeException("DecryptError:" + parambakw1);
          if ((parambakw2.a() <= 0L) || (localObject1.length + this.jdField_a_of_type_Axsq.jdField_c_of_type_Long != parambakw2.a())) {
            break label406;
          }
          j = localObject1.length % 16;
          arrayOfByte = new byte[localObject1.length - j];
          System.arraycopy(localObject1, 0, arrayOfByte, 0, localObject1.length - j);
          Object localObject2 = ((Cipher)localObject2).doFinal(arrayOfByte);
          System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
        }
        this.jdField_b_of_type_Int += parambakw1.length;
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break;
        }
        this.jdField_a_of_type_JavaIoOutputStream.write(parambakw1);
        this.jdField_a_of_type_JavaIoOutputStream.flush();
        this.jdField_a_of_type_Axsq.jdField_a_of_type_Long = parambakw2.a();
        this.jdField_a_of_type_Axsq.jdField_b_of_type_Long = parambakw2.jdField_b_of_type_Long;
        parambakw2 = this.jdField_a_of_type_Axsq;
        l1 = parambakw2.jdField_c_of_type_Long;
        parambakw2.jdField_c_of_type_Long = (parambakw1.length + l1);
      } while (this.jdField_a_of_type_Axro.jdField_a_of_type_Axrt == null);
      this.jdField_a_of_type_Axro.jdField_a_of_type_Axrt.onUpdateProgeress(this.jdField_a_of_type_Axro, this.jdField_a_of_type_Axsq.jdField_c_of_type_Long + this.jdField_a_of_type_Axro.jdField_a_of_type_Long, this.jdField_a_of_type_Axsq.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
        break;
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile.length() == 0L) {
        this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(parambakw2.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_JavaIoRandomAccessFile.write(parambakw1);
      this.jdField_a_of_type_Axsq.jdField_a_of_type_Long = parambakw2.a();
      this.jdField_a_of_type_Axsq.jdField_b_of_type_Long = parambakw2.jdField_b_of_type_Long;
      parambakw2 = this.jdField_a_of_type_Axsq;
      long l1 = parambakw2.jdField_c_of_type_Long;
      parambakw2.jdField_c_of_type_Long = (parambakw1.length + l1);
    } while (this.jdField_a_of_type_Axro.jdField_a_of_type_Axrt == null);
    label406:
    label571:
    this.jdField_a_of_type_Axro.jdField_a_of_type_Axrt.onUpdateProgeress(this.jdField_a_of_type_Axro, this.jdField_a_of_type_Axsq.jdField_c_of_type_Long + this.jdField_a_of_type_Axro.jdField_a_of_type_Long, this.jdField_a_of_type_Axsq.jdField_a_of_type_Long);
    return;
    this.jdField_a_of_type_Axsq.jdField_a_of_type_Long = parambakw2.a();
    this.jdField_a_of_type_Axsq.jdField_b_of_type_Long = parambakw2.jdField_b_of_type_Long;
    this.jdField_a_of_type_Axsq.jdField_a_of_type_ArrayOfByte = parambakw2.a();
  }
  
  void a(IOException paramIOException, axsq paramaxsq)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      return;
      paramaxsq = paramIOException.getMessage();
      this.jdField_a_of_type_Axsq.a(1, 9301, paramaxsq + MsfSdkUtils.getStackTraceString(paramIOException), null);
      try
      {
        paramIOException = Environment.getExternalStorageState();
        if (paramaxsq.contains("EACCES"))
        {
          this.jdField_a_of_type_Axsq.jdField_b_of_type_Int = 9039;
          return;
        }
      }
      catch (Exception paramIOException)
      {
        paramIOException.printStackTrace();
        return;
      }
      if ((paramaxsq.contains("ENOSPC")) || (paramaxsq.contains("space")))
      {
        long l = azzz.b();
        if (this.jdField_a_of_type_Axro != null)
        {
          paramIOException = this.jdField_a_of_type_Axro.jdField_c_of_type_JavaLangString;
          paramaxsq = new File(paramIOException).getParentFile();
          QLog.e("Q.richmedia.OldHttpEngine", 1, "no space error, outPath:" + paramIOException + ",fileCount:" + paramaxsq.listFiles().length + ",url:" + this.jdField_a_of_type_Axro.jdField_a_of_type_JavaLangString + ",availableSpace:" + l);
        }
        this.jdField_a_of_type_Axsq.jdField_b_of_type_Int = 9040;
        return;
      }
      if (paramaxsq.contains("Read-only"))
      {
        this.jdField_a_of_type_Axsq.jdField_b_of_type_Int = 9039;
        return;
      }
    } while ("mounted".equals(paramIOException));
    this.jdField_a_of_type_Axsq.jdField_b_of_type_Int = 9039;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Axsq != null) && (this.jdField_a_of_type_Bakw != null))
    {
      this.jdField_a_of_type_Axsq.g = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Bakw.jdField_d_of_type_Long);
      paramString = this.jdField_a_of_type_Axsq;
      paramString.e += 1;
    }
  }
  
  public boolean a(bakw parambakw1, bakw parambakw2, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return true;
    }
    if (paramInt == 5)
    {
      a(parambakw2);
      if (!this.jdField_a_of_type_Axro.a()) {
        break label777;
      }
      if ((a(parambakw2)) && (this.jdField_a_of_type_Axsq.jdField_c_of_type_Long != this.jdField_a_of_type_Axsq.jdField_b_of_type_Long) && ((this.jdField_a_of_type_Axro.jdField_a_of_type_Axrq == null) || (!this.jdField_a_of_type_Axro.jdField_a_of_type_Axrq.a()))) {
        break label427;
      }
      this.jdField_a_of_type_Axsq.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Axsq.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Axsq.jdField_a_of_type_JavaLangString = "";
      int i = 0;
      paramInt = i;
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        paramInt = i;
        if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Axro.jdField_c_of_type_JavaLangString)) {
          paramInt = 1;
        }
      }
      if (this.jdField_a_of_type_Axro.jdField_c_of_type_JavaLangString == null) {}
    }
    try
    {
      if ((this.jdField_a_of_type_Axro.j) && (paramInt == 0) && (bace.a(this.jdField_a_of_type_Axro.jdField_c_of_type_JavaLangString))) {
        bace.d(this.jdField_a_of_type_Axro.jdField_c_of_type_JavaLangString);
      }
    }
    catch (Exception parambakw2)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break label216;
        }
        this.jdField_a_of_type_JavaIoOutputStream.close();
        label216:
        if (!this.jdField_a_of_type_Axro.i) {
          break label240;
        }
      }
      catch (IOException parambakw2)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_JavaIoRandomAccessFile != null) {
              this.jdField_a_of_type_JavaIoRandomAccessFile.close();
            }
            label240:
            if (this.jdField_a_of_type_Axro.j) {
              break;
            }
            if (parambakw1.e != 0L) {
              this.jdField_a_of_type_Axsq.h = parambakw1.e;
            }
            this.jdField_a_of_type_Axsq.i = parambakw1.h;
            if (parambakw1.jdField_f_of_type_Long != 0L) {
              this.jdField_a_of_type_Axsq.j = parambakw1.jdField_f_of_type_Long;
            }
            c();
            return true;
            parambakw2 = parambakw2;
            parambakw2.printStackTrace();
          }
          parambakw2 = parambakw2;
          parambakw2.printStackTrace();
        }
        catch (IOException parambakw2)
        {
          for (;;)
          {
            parambakw2.printStackTrace();
            continue;
            if ((paramInt == 0) && (!bace.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Axro.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString != null)) {
              if (bace.d(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Axro.jdField_c_of_type_JavaLangString))
              {
                new File(this.jdField_a_of_type_JavaLangString).delete();
              }
              else
              {
                this.jdField_a_of_type_Axsq.a(1, 9301, "rename file failed", null);
                new File(this.jdField_a_of_type_JavaLangString).delete();
              }
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_Axro.jdField_c_of_type_JavaLangString != null) {}
    label427:
    label620:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Axro.jdField_a_of_type_Axrq == null)
        {
          if (QLog.isColorLevel())
          {
            paramInt = this.jdField_a_of_type_Axro.g;
            if (this.jdField_a_of_type_Axro.jdField_a_of_type_Int != 1) {
              break label620;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            axub.a(paramInt, bool, this.jdField_a_of_type_Axro.jdField_f_of_type_Int, this.jdField_a_of_type_Axro.e, "check", "writtenSize:" + this.jdField_a_of_type_Axsq.jdField_c_of_type_Long + " totalBlockLen:" + this.jdField_a_of_type_Axsq.jdField_b_of_type_Long);
            this.jdField_a_of_type_Axsq.a(1, -9527, null, null);
            parambakw2 = axou.a("Q", -9533L);
            this.jdField_a_of_type_Axsq.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", parambakw2);
            this.jdField_a_of_type_Axsq.jdField_a_of_type_JavaLangString = ("recvSize:" + this.jdField_a_of_type_Axsq.jdField_c_of_type_Long + " totalBlockLen:" + this.jdField_a_of_type_Axsq.jdField_b_of_type_Long);
            break;
          }
        }
        this.jdField_a_of_type_Axsq.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Axsq.jdField_b_of_type_Int = 9058;
        this.jdField_a_of_type_Axsq.jdField_a_of_type_JavaLangString = "error data len ! ";
        QLog.d("T.Q.richmedia." + axub.b(this.jdField_a_of_type_Axro.g) + "." + axub.c(this.jdField_a_of_type_Axro.jdField_f_of_type_Int), 1, "id:" + String.valueOf(parambakw1.jdField_a_of_type_JavaLangString) + "reqUrl:" + this.jdField_a_of_type_Axro.jdField_a_of_type_JavaLangString + ",reqHeader:" + parambakw1.jdField_c_of_type_JavaLangString + "responseHeader:" + parambakw2.jdField_d_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Axsq.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Axsq.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Axsq.jdField_a_of_type_JavaLangString = "";
    } while (((this.jdField_a_of_type_Axsq.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_Axsq.jdField_a_of_type_ArrayOfByte.length == this.jdField_a_of_type_Axsq.jdField_b_of_type_Long)) && ((this.jdField_a_of_type_Axsq.jdField_a_of_type_ArrayOfByte != null) || (this.jdField_a_of_type_Axsq.jdField_b_of_type_Long == 0L)));
    label777:
    this.jdField_a_of_type_Axsq.a(1, -9527, null, null);
    parambakw2 = axou.a("Q", -9533L);
    this.jdField_a_of_type_Axsq.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", parambakw2);
    parambakw2 = this.jdField_a_of_type_Axsq;
    StringBuilder localStringBuilder = new StringBuilder().append("recvSize:");
    if (this.jdField_a_of_type_Axsq.jdField_a_of_type_ArrayOfByte != null) {}
    for (paramInt = this.jdField_a_of_type_Axsq.jdField_a_of_type_ArrayOfByte.length;; paramInt = 0)
    {
      parambakw2.jdField_a_of_type_JavaLangString = (paramInt + " totalBlockLen:" + this.jdField_a_of_type_Axsq.jdField_b_of_type_Long);
      break;
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_Int = axsr.a().a();
    Object localObject = this.jdField_a_of_type_Axro;
    axsq localaxsq = this.jdField_a_of_type_Axsq;
    if ((localObject == null) || (localaxsq == null))
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    label367:
    int i;
    if (((axro)localObject).jdField_c_of_type_JavaLangString != null)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaLangString = a(((axro)localObject).jdField_c_of_type_JavaLangString, ((axro)localObject).jdField_a_of_type_JavaLangString);
          localaxsq.jdField_a_of_type_Axsp.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localFile = new File(this.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            break label367;
          }
          l = localFile.length();
          if ((l <= 0L) || (((axro)localObject).jdField_a_of_type_Axrs == null)) {
            continue;
          }
          localaxsq.jdField_c_of_type_Long = l;
          ((axro)localObject).jdField_a_of_type_Axrs.a((axsp)localObject, localaxsq);
          if (!((axro)localObject).i) {
            continue;
          }
          this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localFile, "rw");
          this.jdField_a_of_type_JavaIoRandomAccessFile.seek(((axro)localObject).jdField_a_of_type_Long);
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
          if (!((axro)localObject).i) {
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
          localObject = new URL(((axro)localObject).jdField_a_of_type_JavaLangString).getHost();
          localaxsq.jdField_a_of_type_JavaUtilHashMap.put("firstserverip", localObject);
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
        i = ((axro)localObject).g;
        if (((axro)localObject).jdField_a_of_type_Int != 1) {
          break label485;
        }
      }
    }
    label485:
    for (boolean bool = true;; bool = false)
    {
      axub.a(i, bool, ((axro)localObject).jdField_f_of_type_Int, ((axro)localObject).e, "createtmp", this.jdField_a_of_type_JavaLangString);
      bace.a(this.jdField_a_of_type_JavaLangString);
      if (((axro)localObject).i)
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localIOException, "rw");
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(localIOException);
      break;
      if (((axro)localObject).jdField_a_of_type_JavaIoOutputStream == null) {
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = ((axro)localObject).jdField_a_of_type_JavaIoOutputStream;
      break;
    }
  }
  
  public void b(bakw parambakw1, bakw parambakw2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    axro localaxro;
    axsq localaxsq;
    do
    {
      return;
      localaxro = this.jdField_a_of_type_Axro;
      localaxsq = this.jdField_a_of_type_Axsq;
    } while ((localaxro == null) || (localaxsq == null));
    a(parambakw2);
    long l1 = System.currentTimeMillis() - localaxsq.jdField_f_of_type_Long;
    localaxsq.jdField_d_of_type_Long += l1;
    if ((localaxro.jdField_a_of_type_JavaUtilList != null) && (localaxro.jdField_a_of_type_JavaUtilList.size() >= 1)) {
      ((axuh)localaxro.jdField_a_of_type_JavaUtilList.get(0)).a();
    }
    if ((axsr.a().a() != 0) && (!this.jdField_a_of_type_Boolean) && (localaxro.jdField_a_of_type_Axru != null)) {
      localaxro.jdField_a_of_type_Axru.a(localaxsq);
    }
    long l2 = axsr.a().a();
    int j;
    if (l2 != 0L) {
      j = 1;
    }
    for (;;)
    {
      int i;
      label192:
      label336:
      int k;
      label312:
      boolean bool1;
      label381:
      boolean bool2;
      if ((localaxsq.jdField_b_of_type_Int == 9056) && (l1 < 2000L))
      {
        i = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = (i - 1);
        if (i > 0)
        {
          if ((localaxsq.jdField_b_of_type_Int == 9056) || (localaxsq.jdField_b_of_type_Int == 9051)) {
            this.e += 1;
          }
          if (this.jdField_a_of_type_Boolean) {
            break label903;
          }
          localaxsq.jdField_b_of_type_Int = parambakw2.jdField_f_of_type_Int;
          localaxsq.jdField_a_of_type_JavaLangString = parambakw2.jdField_b_of_type_JavaLangString;
          localaxsq.jdField_a_of_type_Int = 1;
          if (j == 0)
          {
            localaxsq.jdField_b_of_type_Int = 9004;
            localaxsq.jdField_a_of_type_JavaLangString = "no network";
            localaxsq.jdField_a_of_type_Int = 1;
          }
          if ((l2 == this.jdField_d_of_type_Int) || (l2 == 0L) || (this.jdField_d_of_type_Int == 0L)) {
            break label908;
          }
          i = 1;
          if ((!localaxro.k) || (i == 0) || (!axtt.a(parambakw2.jdField_f_of_type_Int))) {
            break label913;
          }
          i = 1;
          if (i != 0)
          {
            localaxsq.jdField_b_of_type_Int = 9364;
            localaxsq.jdField_a_of_type_JavaLangString = "netchg";
            if (QLog.isColorLevel())
            {
              k = localaxro.g;
              if (localaxro.jdField_a_of_type_Int != 1) {
                break label918;
              }
              bool1 = true;
              axub.a(k, bool1, localaxro.jdField_f_of_type_Int, localaxro.e, "netChg", "originNet:" + this.jdField_d_of_type_Int + " cur:" + l2);
            }
          }
          if (this.jdField_b_of_type_Int <= 0) {
            break label924;
          }
          bool1 = true;
          label445:
          if ((this.jdField_a_of_type_Boolean) || (i != 0) || ((!parambakw2.d()) && (!axss.a(this.jdField_a_of_type_Axss, parambakw2, localaxro))) || (((localaxsq.jdField_d_of_type_Long >= localaxro.jdField_c_of_type_Long - 5000L) || (this.jdField_a_of_type_Int > localaxro.jdField_c_of_type_Int)) && ((!bool1) || (localaxsq.jdField_d_of_type_Long >= localaxro.jdField_c_of_type_Long * 3L / 2L - 5000L)))) {
            break label1558;
          }
          if (QLog.isColorLevel())
          {
            k = localaxro.g;
            if (localaxro.jdField_a_of_type_Int != 1) {
              break label930;
            }
            bool2 = true;
            label562:
            int m = localaxro.jdField_f_of_type_Int;
            String str = localaxro.e;
            StringBuilder localStringBuilder = new StringBuilder().append("tryTime:");
            if (this.jdField_a_of_type_Axsq == null) {
              break label936;
            }
            i = this.jdField_a_of_type_Axsq.jdField_d_of_type_Int;
            label606:
            localStringBuilder = localStringBuilder.append(i).append(" consumeTime:");
            if (this.jdField_a_of_type_Axsq == null) {
              break label941;
            }
            l1 = this.jdField_a_of_type_Axsq.jdField_d_of_type_Long;
            label636:
            axub.a(k, bool2, m, str, "retry", l1 + " isLastGetData:" + bool1);
          }
          k = 1;
          i = k;
          if (localaxsq.jdField_c_of_type_Long > 0L)
          {
            if (!localaxro.c()) {
              break label952;
            }
            if (localaxro.jdField_a_of_type_Axrs == null) {
              break label947;
            }
            localaxro.jdField_a_of_type_Axrs.a(localaxro, localaxsq);
            this.jdField_a_of_type_JavaIoOutputStream = localaxro.jdField_a_of_type_JavaIoOutputStream;
            i = k;
          }
          label729:
          k = i;
          if (localaxro.m)
          {
            k = i;
            if (parambakw2.c() >= 400)
            {
              k = i;
              if (parambakw2.c() < 500)
              {
                i = 0;
                k = i;
                if (this.jdField_a_of_type_JavaIoOutputStream == null) {}
              }
            }
          }
        }
      }
      try
      {
        this.jdField_a_of_type_JavaIoOutputStream.close();
        try
        {
          label785:
          bace.d(this.jdField_a_of_type_JavaLangString);
          k = i;
        }
        catch (Exception parambakw2)
        {
          for (;;)
          {
            k = i;
          }
        }
        if (this.e >= localaxro.jdField_d_of_type_Int) {
          localaxro.jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
        }
        if (k == 0)
        {
          if (QLog.isColorLevel())
          {
            i = localaxro.g;
            if (localaxro.jdField_a_of_type_Int != 1) {
              break label1053;
            }
          }
          label903:
          label908:
          label913:
          label918:
          label924:
          label1053:
          for (bool1 = true;; bool1 = false)
          {
            for (;;)
            {
              axub.a(i, bool1, localaxro.jdField_f_of_type_Int, localaxro.e, "retry", "breakDownAllowRetry is false ");
              c();
              return;
              j = 0;
              break;
              if (j == 0) {
                break label192;
              }
              this.jdField_a_of_type_Int += 1;
              break label192;
              c();
              return;
              i = 0;
              break label312;
              i = 0;
              break label336;
              bool1 = false;
              break label381;
              bool1 = false;
              break label445;
              label930:
              bool2 = false;
              break label562;
              label936:
              i = 0;
              break label606;
              label941:
              l1 = 0L;
              break label636;
              label947:
              i = 0;
              break label729;
              label952:
              i = k;
              if (!localaxro.b()) {
                break label729;
              }
              if (localaxro.jdField_a_of_type_Axrs != null)
              {
                localaxro.jdField_a_of_type_Axrs.a(localaxro, localaxsq);
                i = k;
                break label729;
              }
              k = 0;
              i = k;
              if (this.jdField_a_of_type_JavaIoOutputStream == null) {
                break label729;
              }
              try
              {
                this.jdField_a_of_type_JavaIoOutputStream.close();
                this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
                localaxsq.jdField_c_of_type_Long = 0L;
                i = 1;
              }
              catch (IOException localIOException)
              {
                a(localIOException, localaxsq);
                i = k;
              }
            }
            break label729;
          }
        }
        if (localaxro.jdField_a_of_type_Axrq != null) {
          localaxro.jdField_a_of_type_Axrq.a();
        }
        if (localaxro.jdField_a_of_type_Boolean)
        {
          if (localaxro.jdField_b_of_type_Boolean)
          {
            axwx.a().a(axwx.a(localaxro.jdField_a_of_type_JavaLangString), axwx.a(parambakw1.a()), 1002);
            localaxro.jdField_b_of_type_Boolean = false;
          }
          localaxro.jdField_a_of_type_Boolean = false;
        }
        if ((localaxro.jdField_a_of_type_JavaUtilList != null) && (localaxro.jdField_a_of_type_JavaUtilList.size() >= 1) && (j != 0))
        {
          parambakw1 = (axuh)localaxro.jdField_a_of_type_JavaUtilList.remove(0);
          localaxro.jdField_a_of_type_JavaUtilList.add(parambakw1);
          parambakw2 = (axuh)localaxro.jdField_a_of_type_JavaUtilList.get(0);
          if (localaxro.jdField_a_of_type_JavaLangString != null)
          {
            parambakw1 = null;
            if (!localaxro.jdField_a_of_type_JavaLangString.startsWith("http://")) {
              break label1417;
            }
            if ((!parambakw2.jdField_a_of_type_Boolean) || (parambakw2.jdField_a_of_type_JavaLangString.startsWith("["))) {
              break label1390;
            }
            parambakw1 = "http://[" + parambakw2.jdField_a_of_type_JavaLangString + "]";
            if (parambakw2.jdField_a_of_type_Int == 80) {
              break label1511;
            }
            parambakw1 = parambakw1 + ":" + parambakw2.jdField_a_of_type_Int + "/";
            label1315:
            localaxro.jdField_a_of_type_JavaLangString = axub.a(localaxro.jdField_a_of_type_JavaLangString, parambakw1);
          }
        }
        if ((localaxsq.jdField_b_of_type_Int == 9050) && (localaxro.jdField_a_of_type_Axtz != null)) {
          localaxro.jdField_a_of_type_Axtz.a(this.jdField_a_of_type_Int);
        }
        if ((localaxsq.jdField_b_of_type_Int == 9056) && (l2 != 0L)) {
          l1 = 0L;
        }
        for (;;)
        {
          a(l1, localaxro);
          return;
          label1390:
          parambakw1 = "http://" + parambakw2.jdField_a_of_type_JavaLangString;
          break;
          label1417:
          if (!localaxro.jdField_a_of_type_JavaLangString.startsWith("https://")) {
            break;
          }
          if ((parambakw2.jdField_a_of_type_Boolean) && (!parambakw2.jdField_a_of_type_JavaLangString.startsWith("[")))
          {
            parambakw1 = "https://[" + parambakw2.jdField_a_of_type_JavaLangString + "]";
            break;
          }
          parambakw1 = "https://" + parambakw2.jdField_a_of_type_JavaLangString;
          break;
          label1511:
          parambakw1 = parambakw1 + "/";
          break label1315;
          if (l2 != 0L) {
            l1 = 3000L;
          } else {
            l1 = 6000L;
          }
        }
        label1558:
        c();
        return;
      }
      catch (Exception parambakw2)
      {
        break label785;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axst
 * JD-Core Version:    0.7.0.1
 */