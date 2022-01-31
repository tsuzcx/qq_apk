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

public class bavi
  implements bdpz
{
  int jdField_a_of_type_Int = 0;
  public baub a;
  public bavf a;
  public bdpx a;
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
  
  public bavi(bavh parambavh)
  {
    this.jdField_c_of_type_Int = 5;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(long paramLong, baub parambaub)
  {
    int i;
    if ((QLog.isColorLevel()) && (parambaub != null))
    {
      i = parambaub.g;
      if (parambaub.jdField_a_of_type_Int != 1) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      baws.a(i, bool, parambaub.jdField_f_of_type_Int, parambaub.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_Bavf.jdField_f_of_type_Long = System.currentTimeMillis();
    if (bavg.a().a() != 0)
    {
      if ((this.jdField_a_of_type_Bavh.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramLong != 0L))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new OldHttpEngine.OldHttpCommunicatorListner.1(this, parambaub), paramLong);
        return;
      }
      if ((QLog.isColorLevel()) && (parambaub != null))
      {
        i = parambaub.g;
        if (parambaub.jdField_a_of_type_Int != 1) {
          break label227;
        }
      }
      label227:
      for (bool = true;; bool = false)
      {
        baws.a(i, bool, parambaub.jdField_f_of_type_Int, parambaub.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
        this.jdField_a_of_type_Bavh.c(this.jdField_a_of_type_Baub);
        return;
      }
    }
    if (this.jdField_a_of_type_Bavh.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      ThreadManager.getTimer().schedule(new OldHttpEngine.OldHttpCommunicatorListner.2(this, parambaub), paramLong);
      return;
    }
    if ((QLog.isColorLevel()) && (parambaub != null))
    {
      i = parambaub.g;
      if (parambaub.jdField_a_of_type_Int != 1) {
        break label320;
      }
    }
    label320:
    for (bool = true;; bool = false)
    {
      baws.a(i, bool, parambaub.jdField_f_of_type_Int, parambaub.e, "scheduleRetry", "mWorking is false");
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
  }
  
  private boolean a(bdpx parambdpx)
  {
    return false;
  }
  
  private void c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    baub localbaub = this.jdField_a_of_type_Baub;
    bavf localbavf = this.jdField_a_of_type_Bavf;
    OutputStream localOutputStream;
    RandomAccessFile localRandomAccessFile;
    if (localbaub != null)
    {
      localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
      localRandomAccessFile = this.jdField_a_of_type_JavaIoRandomAccessFile;
      if ((localbaub.jdField_c_of_type_JavaLangString == null) || (localOutputStream == null)) {}
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
        if (localbavf != null)
        {
          if ((localbaub.jdField_f_of_type_JavaLangString != null) && (localbavf.jdField_a_of_type_Int != 3)) {
            bavh.a(this.jdField_a_of_type_Bavh).remove(localbaub.jdField_f_of_type_JavaLangString);
          }
          if (localbaub.jdField_a_of_type_Baug != null)
          {
            if (QLog.isColorLevel())
            {
              int i = localbaub.g;
              if (localbaub.jdField_a_of_type_Int != 1) {
                break label246;
              }
              baws.a(i, bool, localbaub.jdField_f_of_type_Int, localbaub.e, "onOutEngine", "result:" + localbavf.jdField_a_of_type_Int + " errCode:" + localbavf.jdField_b_of_type_Int + " desc:" + localbavf.jdField_a_of_type_JavaLangString);
            }
            if ((localbavf.jdField_b_of_type_Int == 9367) && (QLog.isColorLevel())) {
              break label251;
            }
            localbaub.jdField_a_of_type_Baug.onResp(localbavf);
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
          azqy.a("Http_Download_Queen_Full", this.jdField_a_of_type_Bavh.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a());
        }
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = bavh.a(this.jdField_a_of_type_Baub, paramString1, paramString2);
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    baub localbaub = this.jdField_a_of_type_Baub;
    if (localbaub != null) {
      localbaub.jdField_a_of_type_JavaLangObject = null;
    }
    this.jdField_a_of_type_Baub = null;
    this.jdField_a_of_type_Bavf = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
  }
  
  void a(bave parambave)
  {
    try
    {
      if ((parambave.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaIoOutputStream != null)) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {}
    }
    catch (IOException parambave)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaIoRandomAccessFile.close();
          return;
        }
        catch (IOException parambave)
        {
          parambave.printStackTrace();
        }
        parambave = parambave;
        parambave.printStackTrace();
      }
    }
  }
  
  void a(bdpx parambdpx)
  {
    bavf localbavf = this.jdField_a_of_type_Bavf;
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localbavf == null)) {
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = localbavf.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap2.containsKey("firstserverip")) {
      localHashMap1.put("firstserverip", localHashMap2.get("firstserverip"));
    }
    if (localHashMap2.containsKey("serverip")) {
      localHashMap1.put("serverip", localHashMap2.get("serverip"));
    }
    if (localHashMap2.containsKey("param_url")) {
      localHashMap1.put("param_url", localHashMap2.get("param_url"));
    }
    if (parambdpx.jdField_b_of_type_JavaUtilHashMap.containsKey(bdpx.jdField_f_of_type_JavaLangString)) {
      localHashMap1.put("netresp_param_reason", parambdpx.jdField_b_of_type_JavaUtilHashMap.get(bdpx.jdField_f_of_type_JavaLangString));
    }
    localbavf.jdField_a_of_type_JavaUtilHashMap.clear();
    localbavf.jdField_a_of_type_JavaUtilHashMap.putAll(localHashMap1);
    localbavf.jdField_a_of_type_JavaUtilHashMap.putAll(parambdpx.jdField_b_of_type_JavaUtilHashMap);
    localbavf.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", parambdpx.jdField_d_of_type_JavaLangString);
    localbavf.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", parambdpx.jdField_c_of_type_JavaLangString);
    localbavf.jdField_c_of_type_Int = parambdpx.c();
  }
  
  public void a(bdpx parambdpx1, bdpx parambdpx2)
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
        } while (this.jdField_a_of_type_Baub == null);
        Object localObject1;
        int i;
        for (;;)
        {
          for (;;)
          {
            try
            {
              if ((parambdpx2.c() != 206) && (parambdpx2.c() != 200)) {
                break;
              }
              parambdpx1 = parambdpx2.a();
              localObject2 = this.jdField_a_of_type_Baub.jdField_a_of_type_Baud;
              localObject1 = parambdpx1;
              if (localObject2 == null) {}
            }
            catch (IOException parambdpx1)
            {
              parambdpx1.printStackTrace();
              this.jdField_a_of_type_Boolean = true;
              a(parambdpx1, this.jdField_a_of_type_Bavf);
              throw new RuntimeException("io exceptionmsg:" + parambdpx1.getMessage());
            }
            try
            {
              localObject1 = this.jdField_a_of_type_Baub.jdField_a_of_type_Baud.a(parambdpx1);
              if (localObject1 == null) {
                break;
              }
              i = localObject1.length;
              if (i <= 0) {
                break;
              }
              parambdpx1 = (bdpx)localObject1;
              if (localObject1.length <= 0) {
                break label598;
              }
              parambdpx1 = (bdpx)localObject1;
              if (this.jdField_a_of_type_Baub.jdField_a_of_type_Bauc == null) {
                break label598;
              }
              l1 = System.nanoTime();
              i = 1;
              parambdpx1 = null;
            }
            catch (Throwable parambdpx1)
            {
              parambdpx1 = Log.getStackTraceString(parambdpx1);
              throw new RuntimeException("FlowDecoderExp:" + parambdpx1.substring(0, Math.min(100, parambdpx1.length())));
            }
          }
          try
          {
            localObject2 = Cipher.getInstance("AES/ECB/NoPadding");
            ((Cipher)localObject2).init(2, new SecretKeySpec(this.jdField_a_of_type_Baub.jdField_a_of_type_Bauc.jdField_a_of_type_ArrayOfByte, "AES"));
            if (localObject1.length % 16 != 0) {
              break label309;
            }
            localObject2 = ((Cipher)localObject2).doFinal((byte[])localObject1);
            localObject1 = localObject2;
          }
          catch (NoSuchAlgorithmException parambdpx1)
          {
            int j;
            byte[] arrayOfByte;
            parambdpx1 = Log.getStackTraceString(parambdpx1);
            i = 0;
            continue;
            if (!QLog.isColorLevel()) {
              break label470;
            }
            QLog.e("Q.richmedia.OldHttpEngine", 2, "padding erro,recLen =" + localObject1.length + " writeLen=" + this.jdField_a_of_type_Bavf.jdField_c_of_type_Long + " totalLen=" + parambdpx2.a());
            parambdpx1 = "padding erro,recLen =" + localObject1.length + " writeLen=" + this.jdField_a_of_type_Bavf.jdField_c_of_type_Long + " totalLen=" + parambdpx2.a();
            i = 0;
            continue;
          }
          catch (NoSuchPaddingException parambdpx1)
          {
            parambdpx1 = Log.getStackTraceString(parambdpx1);
            i = 0;
            continue;
          }
          catch (InvalidKeyException parambdpx1)
          {
            parambdpx1 = Log.getStackTraceString(parambdpx1);
            i = 0;
            continue;
          }
          catch (IllegalBlockSizeException parambdpx1)
          {
            parambdpx1 = Log.getStackTraceString(parambdpx1);
            i = 0;
            continue;
          }
          catch (BadPaddingException parambdpx1)
          {
            parambdpx1 = Log.getStackTraceString(parambdpx1);
            i = 0;
            continue;
            long l2 = System.nanoTime();
            parambdpx1 = this.jdField_a_of_type_Bavf;
            parambdpx1.j = (l2 - l1 + parambdpx1.j);
            parambdpx1 = (bdpx)localObject1;
          }
          if (i != 0) {
            break label571;
          }
          throw new RuntimeException("DecryptError:" + parambdpx1);
          if ((parambdpx2.a() <= 0L) || (localObject1.length + this.jdField_a_of_type_Bavf.jdField_c_of_type_Long != parambdpx2.a())) {
            break label406;
          }
          j = localObject1.length % 16;
          arrayOfByte = new byte[localObject1.length - j];
          System.arraycopy(localObject1, 0, arrayOfByte, 0, localObject1.length - j);
          Object localObject2 = ((Cipher)localObject2).doFinal(arrayOfByte);
          System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
        }
        this.jdField_b_of_type_Int += parambdpx1.length;
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break;
        }
        this.jdField_a_of_type_JavaIoOutputStream.write(parambdpx1);
        this.jdField_a_of_type_JavaIoOutputStream.flush();
        this.jdField_a_of_type_Bavf.jdField_a_of_type_Long = parambdpx2.a();
        this.jdField_a_of_type_Bavf.jdField_b_of_type_Long = parambdpx2.jdField_b_of_type_Long;
        parambdpx2 = this.jdField_a_of_type_Bavf;
        l1 = parambdpx2.jdField_c_of_type_Long;
        parambdpx2.jdField_c_of_type_Long = (parambdpx1.length + l1);
      } while (this.jdField_a_of_type_Baub.jdField_a_of_type_Baug == null);
      this.jdField_a_of_type_Baub.jdField_a_of_type_Baug.onUpdateProgeress(this.jdField_a_of_type_Baub, this.jdField_a_of_type_Bavf.jdField_c_of_type_Long + this.jdField_a_of_type_Baub.jdField_a_of_type_Long, this.jdField_a_of_type_Bavf.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
        break;
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile.length() == 0L) {
        this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(parambdpx2.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_JavaIoRandomAccessFile.write(parambdpx1);
      this.jdField_a_of_type_Bavf.jdField_a_of_type_Long = parambdpx2.a();
      this.jdField_a_of_type_Bavf.jdField_b_of_type_Long = parambdpx2.jdField_b_of_type_Long;
      parambdpx2 = this.jdField_a_of_type_Bavf;
      long l1 = parambdpx2.jdField_c_of_type_Long;
      parambdpx2.jdField_c_of_type_Long = (parambdpx1.length + l1);
    } while (this.jdField_a_of_type_Baub.jdField_a_of_type_Baug == null);
    label406:
    label571:
    this.jdField_a_of_type_Baub.jdField_a_of_type_Baug.onUpdateProgeress(this.jdField_a_of_type_Baub, this.jdField_a_of_type_Bavf.jdField_c_of_type_Long + this.jdField_a_of_type_Baub.jdField_a_of_type_Long, this.jdField_a_of_type_Bavf.jdField_a_of_type_Long);
    return;
    this.jdField_a_of_type_Bavf.jdField_a_of_type_Long = parambdpx2.a();
    this.jdField_a_of_type_Bavf.jdField_b_of_type_Long = parambdpx2.jdField_b_of_type_Long;
    this.jdField_a_of_type_Bavf.jdField_a_of_type_ArrayOfByte = parambdpx2.a();
  }
  
  void a(IOException paramIOException, bavf parambavf)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      return;
      parambavf = paramIOException.getMessage();
      this.jdField_a_of_type_Bavf.a(1, 9301, parambavf + MsfSdkUtils.getStackTraceString(paramIOException), null);
      try
      {
        paramIOException = Environment.getExternalStorageState();
        if (parambavf.contains("EACCES"))
        {
          this.jdField_a_of_type_Bavf.jdField_b_of_type_Int = 9039;
          return;
        }
      }
      catch (Exception paramIOException)
      {
        paramIOException.printStackTrace();
        return;
      }
      if ((parambavf.contains("ENOSPC")) || (parambavf.contains("space")))
      {
        long l = bdeu.b();
        if (this.jdField_a_of_type_Baub != null)
        {
          paramIOException = this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString;
          parambavf = new File(paramIOException).getParentFile();
          QLog.e("Q.richmedia.OldHttpEngine", 1, "no space error, outPath:" + paramIOException + ",fileCount:" + parambavf.listFiles().length + ",url:" + this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangString + ",availableSpace:" + l);
        }
        this.jdField_a_of_type_Bavf.jdField_b_of_type_Int = 9040;
        return;
      }
      if (parambavf.contains("Read-only"))
      {
        this.jdField_a_of_type_Bavf.jdField_b_of_type_Int = 9039;
        return;
      }
    } while ("mounted".equals(paramIOException));
    this.jdField_a_of_type_Bavf.jdField_b_of_type_Int = 9039;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Bavf != null) && (this.jdField_a_of_type_Bdpx != null))
    {
      this.jdField_a_of_type_Bavf.g = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Bdpx.jdField_d_of_type_Long);
      paramString = this.jdField_a_of_type_Bavf;
      paramString.e += 1;
    }
  }
  
  public boolean a(bdpx parambdpx1, bdpx parambdpx2, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return true;
    }
    if (paramInt == 5)
    {
      a(parambdpx2);
      if (!this.jdField_a_of_type_Baub.a()) {
        break label777;
      }
      if ((a(parambdpx2)) && (this.jdField_a_of_type_Bavf.jdField_c_of_type_Long != this.jdField_a_of_type_Bavf.jdField_b_of_type_Long) && ((this.jdField_a_of_type_Baub.jdField_a_of_type_Baud == null) || (!this.jdField_a_of_type_Baub.jdField_a_of_type_Baud.a()))) {
        break label427;
      }
      this.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Bavf.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = "";
      int i = 0;
      paramInt = i;
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        paramInt = i;
        if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString)) {
          paramInt = 1;
        }
      }
      if (this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString == null) {}
    }
    try
    {
      if ((this.jdField_a_of_type_Baub.j) && (paramInt == 0) && (bdhb.a(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString))) {
        bdhb.d(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString);
      }
    }
    catch (Exception parambdpx2)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break label216;
        }
        this.jdField_a_of_type_JavaIoOutputStream.close();
        label216:
        if (!this.jdField_a_of_type_Baub.i) {
          break label240;
        }
      }
      catch (IOException parambdpx2)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_JavaIoRandomAccessFile != null) {
              this.jdField_a_of_type_JavaIoRandomAccessFile.close();
            }
            label240:
            if (this.jdField_a_of_type_Baub.j) {
              break;
            }
            if (parambdpx1.e != 0L) {
              this.jdField_a_of_type_Bavf.h = parambdpx1.e;
            }
            this.jdField_a_of_type_Bavf.i = parambdpx1.h;
            if (parambdpx1.jdField_f_of_type_Long != 0L) {
              this.jdField_a_of_type_Bavf.j = parambdpx1.jdField_f_of_type_Long;
            }
            c();
            return true;
            parambdpx2 = parambdpx2;
            parambdpx2.printStackTrace();
          }
          parambdpx2 = parambdpx2;
          parambdpx2.printStackTrace();
        }
        catch (IOException parambdpx2)
        {
          for (;;)
          {
            parambdpx2.printStackTrace();
            continue;
            if ((paramInt == 0) && (!bdhb.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString != null)) {
              if (bdhb.d(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString))
              {
                new File(this.jdField_a_of_type_JavaLangString).delete();
              }
              else
              {
                this.jdField_a_of_type_Bavf.a(1, 9301, "rename file failed", null);
                new File(this.jdField_a_of_type_JavaLangString).delete();
              }
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString != null) {}
    label427:
    label620:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Baub.jdField_a_of_type_Baud == null)
        {
          if (QLog.isColorLevel())
          {
            paramInt = this.jdField_a_of_type_Baub.g;
            if (this.jdField_a_of_type_Baub.jdField_a_of_type_Int != 1) {
              break label620;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            baws.a(paramInt, bool, this.jdField_a_of_type_Baub.jdField_f_of_type_Int, this.jdField_a_of_type_Baub.e, "check", "writtenSize:" + this.jdField_a_of_type_Bavf.jdField_c_of_type_Long + " totalBlockLen:" + this.jdField_a_of_type_Bavf.jdField_b_of_type_Long);
            this.jdField_a_of_type_Bavf.a(1, -9527, null, null);
            parambdpx2 = barf.a("Q", -9533L);
            this.jdField_a_of_type_Bavf.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", parambdpx2);
            this.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = ("recvSize:" + this.jdField_a_of_type_Bavf.jdField_c_of_type_Long + " totalBlockLen:" + this.jdField_a_of_type_Bavf.jdField_b_of_type_Long);
            break;
          }
        }
        this.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Bavf.jdField_b_of_type_Int = 9058;
        this.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = "error data len ! ";
        QLog.d("T.Q.richmedia." + baws.b(this.jdField_a_of_type_Baub.g) + "." + baws.c(this.jdField_a_of_type_Baub.jdField_f_of_type_Int), 1, "id:" + String.valueOf(parambdpx1.jdField_a_of_type_JavaLangString) + "reqUrl:" + this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangString + ",reqHeader:" + parambdpx1.jdField_c_of_type_JavaLangString + "responseHeader:" + parambdpx2.jdField_d_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Bavf.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Bavf.jdField_a_of_type_JavaLangString = "";
    } while (((this.jdField_a_of_type_Bavf.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_Bavf.jdField_a_of_type_ArrayOfByte.length == this.jdField_a_of_type_Bavf.jdField_b_of_type_Long)) && ((this.jdField_a_of_type_Bavf.jdField_a_of_type_ArrayOfByte != null) || (this.jdField_a_of_type_Bavf.jdField_b_of_type_Long == 0L)));
    label777:
    this.jdField_a_of_type_Bavf.a(1, -9527, null, null);
    parambdpx2 = barf.a("Q", -9533L);
    this.jdField_a_of_type_Bavf.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", parambdpx2);
    parambdpx2 = this.jdField_a_of_type_Bavf;
    StringBuilder localStringBuilder = new StringBuilder().append("recvSize:");
    if (this.jdField_a_of_type_Bavf.jdField_a_of_type_ArrayOfByte != null) {}
    for (paramInt = this.jdField_a_of_type_Bavf.jdField_a_of_type_ArrayOfByte.length;; paramInt = 0)
    {
      parambdpx2.jdField_a_of_type_JavaLangString = (paramInt + " totalBlockLen:" + this.jdField_a_of_type_Bavf.jdField_b_of_type_Long);
      break;
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_Int = bavg.a().a();
    Object localObject = this.jdField_a_of_type_Baub;
    bavf localbavf = this.jdField_a_of_type_Bavf;
    if ((localObject == null) || (localbavf == null))
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    label367:
    int i;
    if (((baub)localObject).jdField_c_of_type_JavaLangString != null)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaLangString = a(((baub)localObject).jdField_c_of_type_JavaLangString, ((baub)localObject).jdField_a_of_type_JavaLangString);
          localbavf.jdField_a_of_type_Bave.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localFile = new File(this.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            break label367;
          }
          l = localFile.length();
          if ((l <= 0L) || (((baub)localObject).jdField_a_of_type_Bauf == null)) {
            continue;
          }
          localbavf.jdField_c_of_type_Long = l;
          ((baub)localObject).jdField_a_of_type_Bauf.a((bave)localObject, localbavf);
          if (!((baub)localObject).i) {
            continue;
          }
          this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localFile, "rw");
          this.jdField_a_of_type_JavaIoRandomAccessFile.seek(((baub)localObject).jdField_a_of_type_Long);
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
          if (!((baub)localObject).i) {
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
          localObject = new URL(((baub)localObject).jdField_a_of_type_JavaLangString).getHost();
          localbavf.jdField_a_of_type_JavaUtilHashMap.put("firstserverip", localObject);
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
        i = ((baub)localObject).g;
        if (((baub)localObject).jdField_a_of_type_Int != 1) {
          break label485;
        }
      }
    }
    label485:
    for (boolean bool = true;; bool = false)
    {
      baws.a(i, bool, ((baub)localObject).jdField_f_of_type_Int, ((baub)localObject).e, "createtmp", this.jdField_a_of_type_JavaLangString);
      bdhb.a(this.jdField_a_of_type_JavaLangString);
      if (((baub)localObject).i)
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localIOException, "rw");
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(localIOException);
      break;
      if (((baub)localObject).jdField_a_of_type_JavaIoOutputStream == null) {
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = ((baub)localObject).jdField_a_of_type_JavaIoOutputStream;
      break;
    }
  }
  
  public void b(bdpx parambdpx1, bdpx parambdpx2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    baub localbaub;
    bavf localbavf;
    do
    {
      return;
      localbaub = this.jdField_a_of_type_Baub;
      localbavf = this.jdField_a_of_type_Bavf;
    } while ((localbaub == null) || (localbavf == null));
    a(parambdpx2);
    long l1 = System.currentTimeMillis() - localbavf.jdField_f_of_type_Long;
    localbavf.jdField_d_of_type_Long += l1;
    if ((localbaub.jdField_a_of_type_JavaUtilList != null) && (localbaub.jdField_a_of_type_JavaUtilList.size() >= 1)) {
      ((bawy)localbaub.jdField_a_of_type_JavaUtilList.get(0)).a();
    }
    long l2 = bavg.a().a();
    int j;
    if (l2 != 0L) {
      j = 1;
    }
    for (;;)
    {
      int i;
      label156:
      label246:
      int k;
      label276:
      label300:
      boolean bool1;
      label345:
      boolean bool2;
      if ((localbavf.jdField_b_of_type_Int == 9056) && (l1 < 2000L))
      {
        i = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = (i - 1);
        if (i > 0)
        {
          if ((localbavf.jdField_b_of_type_Int == 9056) || (localbavf.jdField_b_of_type_Int == 9051)) {
            this.e += 1;
          }
          if (this.jdField_a_of_type_Boolean) {
            break label890;
          }
          localbavf.jdField_b_of_type_Int = parambdpx2.jdField_f_of_type_Int;
          localbavf.jdField_a_of_type_JavaLangString = parambdpx2.jdField_b_of_type_JavaLangString;
          localbavf.jdField_a_of_type_Int = 1;
          if (j != 0) {
            break label867;
          }
          localbavf.jdField_b_of_type_Int = 9004;
          localbavf.jdField_a_of_type_JavaLangString = "no network";
          localbavf.jdField_a_of_type_Int = 1;
          if ((l2 == this.jdField_d_of_type_Int) || (l2 == 0L) || (this.jdField_d_of_type_Int == 0L)) {
            break label895;
          }
          i = 1;
          if ((!localbaub.k) || (i == 0) || (!bawk.a(parambdpx2.jdField_f_of_type_Int))) {
            break label900;
          }
          i = 1;
          if (i != 0)
          {
            localbavf.jdField_b_of_type_Int = 9364;
            localbavf.jdField_a_of_type_JavaLangString = "netchg";
            if (QLog.isColorLevel())
            {
              k = localbaub.g;
              if (localbaub.jdField_a_of_type_Int != 1) {
                break label905;
              }
              bool1 = true;
              baws.a(k, bool1, localbaub.jdField_f_of_type_Int, localbaub.e, "netChg", "originNet:" + this.jdField_d_of_type_Int + " cur:" + l2);
            }
          }
          if (this.jdField_b_of_type_Int <= 0) {
            break label911;
          }
          bool1 = true;
          label409:
          if ((this.jdField_a_of_type_Boolean) || (i != 0) || ((!parambdpx2.d()) && (!bavh.a(this.jdField_a_of_type_Bavh, parambdpx2, localbaub))) || (((localbavf.jdField_d_of_type_Long >= localbaub.jdField_c_of_type_Long - 5000L) || (this.jdField_a_of_type_Int > localbaub.jdField_c_of_type_Int)) && ((!bool1) || (localbavf.jdField_d_of_type_Long >= localbaub.jdField_c_of_type_Long * 3L / 2L - 5000L)))) {
            break label1301;
          }
          if (QLog.isColorLevel())
          {
            k = localbaub.g;
            if (localbaub.jdField_a_of_type_Int != 1) {
              break label917;
            }
            bool2 = true;
            label526:
            int m = localbaub.jdField_f_of_type_Int;
            String str = localbaub.e;
            StringBuilder localStringBuilder = new StringBuilder().append("tryTime:");
            if (this.jdField_a_of_type_Bavf == null) {
              break label923;
            }
            i = this.jdField_a_of_type_Bavf.jdField_d_of_type_Int;
            label570:
            localStringBuilder = localStringBuilder.append(i).append(" consumeTime:");
            if (this.jdField_a_of_type_Bavf == null) {
              break label928;
            }
            l1 = this.jdField_a_of_type_Bavf.jdField_d_of_type_Long;
            label600:
            baws.a(k, bool2, m, str, "retry", l1 + " isLastGetData:" + bool1);
          }
          k = 1;
          i = k;
          if (localbavf.jdField_c_of_type_Long > 0L)
          {
            if (!localbaub.c()) {
              break label939;
            }
            if (localbaub.jdField_a_of_type_Bauf == null) {
              break label934;
            }
            localbaub.jdField_a_of_type_Bauf.a(localbaub, localbavf);
            this.jdField_a_of_type_JavaIoOutputStream = localbaub.jdField_a_of_type_JavaIoOutputStream;
            i = k;
          }
          label693:
          k = i;
          if (localbaub.m)
          {
            k = i;
            if (parambdpx2.c() >= 400)
            {
              k = i;
              if (parambdpx2.c() < 500)
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
          label749:
          bdhb.d(this.jdField_a_of_type_JavaLangString);
          k = i;
        }
        catch (Exception parambdpx2)
        {
          for (;;)
          {
            k = i;
          }
        }
        if (this.e >= localbaub.jdField_d_of_type_Int) {
          localbaub.jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
        }
        if (k == 0)
        {
          if (QLog.isColorLevel())
          {
            i = localbaub.g;
            if (localbaub.jdField_a_of_type_Int != 1) {
              break label1040;
            }
          }
          label900:
          label905:
          label911:
          label1040:
          for (bool1 = true;; bool1 = false)
          {
            for (;;)
            {
              baws.a(i, bool1, localbaub.jdField_f_of_type_Int, localbaub.e, "retry", "breakDownAllowRetry is false ");
              c();
              return;
              j = 0;
              break;
              if (j == 0) {
                break label156;
              }
              this.jdField_a_of_type_Int += 1;
              break label156;
              label867:
              if (localbaub.jdField_a_of_type_Bauh == null) {
                break label246;
              }
              localbaub.jdField_a_of_type_Bauh.a(localbavf);
              break label246;
              label890:
              c();
              return;
              label895:
              i = 0;
              break label276;
              i = 0;
              break label300;
              bool1 = false;
              break label345;
              bool1 = false;
              break label409;
              label917:
              bool2 = false;
              break label526;
              label923:
              i = 0;
              break label570;
              label928:
              l1 = 0L;
              break label600;
              label934:
              i = 0;
              break label693;
              label939:
              i = k;
              if (!localbaub.b()) {
                break label693;
              }
              if (localbaub.jdField_a_of_type_Bauf != null)
              {
                localbaub.jdField_a_of_type_Bauf.a(localbaub, localbavf);
                i = k;
                break label693;
              }
              k = 0;
              i = k;
              if (this.jdField_a_of_type_JavaIoOutputStream == null) {
                break label693;
              }
              try
              {
                this.jdField_a_of_type_JavaIoOutputStream.close();
                this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
                localbavf.jdField_c_of_type_Long = 0L;
                i = 1;
              }
              catch (IOException localIOException)
              {
                a(localIOException, localbavf);
                i = k;
              }
            }
            break label693;
          }
        }
        if (localbaub.jdField_a_of_type_Baud != null) {
          localbaub.jdField_a_of_type_Baud.a();
        }
        if (localbaub.jdField_a_of_type_Boolean)
        {
          if (localbaub.jdField_b_of_type_Boolean)
          {
            bazo.a().a(bazo.a(localbaub.jdField_a_of_type_JavaLangString), bazo.a(parambdpx1.a()), 1002);
            localbaub.jdField_b_of_type_Boolean = false;
          }
          localbaub.jdField_a_of_type_Boolean = false;
        }
        if ((localbaub.jdField_a_of_type_JavaUtilList != null) && (localbaub.jdField_a_of_type_JavaUtilList.size() >= 1) && (j != 0))
        {
          parambdpx1 = (bawy)localbaub.jdField_a_of_type_JavaUtilList.remove(0);
          localbaub.jdField_a_of_type_JavaUtilList.add(parambdpx1);
          parambdpx1 = (bawy)localbaub.jdField_a_of_type_JavaUtilList.get(0);
          if (localbaub.jdField_a_of_type_JavaLangString != null)
          {
            parambdpx1 = parambdpx1.a(localbaub.jdField_a_of_type_JavaLangString);
            localbaub.jdField_a_of_type_JavaLangString = baws.a(localbaub.jdField_a_of_type_JavaLangString, parambdpx1);
          }
        }
        if ((localbavf.jdField_b_of_type_Int == 9050) && (localbaub.jdField_a_of_type_Bawq != null)) {
          localbaub.jdField_a_of_type_Bawq.a(this.jdField_a_of_type_Int);
        }
        if ((localbavf.jdField_b_of_type_Int == 9056) && (l2 != 0L)) {
          l1 = 0L;
        }
        for (;;)
        {
          a(l1, localbaub);
          return;
          if (l2 != 0L) {
            l1 = 3000L;
          } else {
            l1 = 6000L;
          }
        }
        label1301:
        c();
        return;
      }
      catch (Exception parambdpx2)
      {
        break label749;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavi
 * JD-Core Version:    0.7.0.1
 */