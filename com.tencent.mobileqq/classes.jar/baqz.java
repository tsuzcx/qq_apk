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

public class baqz
  implements bdlq
{
  int jdField_a_of_type_Int = 0;
  public baps a;
  public baqw a;
  public bdlo a;
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
  
  public baqz(baqy parambaqy)
  {
    this.jdField_c_of_type_Int = 5;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(long paramLong, baps parambaps)
  {
    int i;
    if ((QLog.isColorLevel()) && (parambaps != null))
    {
      i = parambaps.g;
      if (parambaps.jdField_a_of_type_Int != 1) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      basj.a(i, bool, parambaps.jdField_f_of_type_Int, parambaps.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_Baqw.jdField_f_of_type_Long = System.currentTimeMillis();
    if (baqx.a().a() != 0)
    {
      if ((this.jdField_a_of_type_Baqy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramLong != 0L))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new OldHttpEngine.OldHttpCommunicatorListner.1(this, parambaps), paramLong);
        return;
      }
      if ((QLog.isColorLevel()) && (parambaps != null))
      {
        i = parambaps.g;
        if (parambaps.jdField_a_of_type_Int != 1) {
          break label227;
        }
      }
      label227:
      for (bool = true;; bool = false)
      {
        basj.a(i, bool, parambaps.jdField_f_of_type_Int, parambaps.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
        this.jdField_a_of_type_Baqy.c(this.jdField_a_of_type_Baps);
        return;
      }
    }
    if (this.jdField_a_of_type_Baqy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      ThreadManager.getTimer().schedule(new OldHttpEngine.OldHttpCommunicatorListner.2(this, parambaps), paramLong);
      return;
    }
    if ((QLog.isColorLevel()) && (parambaps != null))
    {
      i = parambaps.g;
      if (parambaps.jdField_a_of_type_Int != 1) {
        break label320;
      }
    }
    label320:
    for (bool = true;; bool = false)
    {
      basj.a(i, bool, parambaps.jdField_f_of_type_Int, parambaps.e, "scheduleRetry", "mWorking is false");
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
  }
  
  private boolean a(bdlo parambdlo)
  {
    return false;
  }
  
  private void c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    baps localbaps = this.jdField_a_of_type_Baps;
    baqw localbaqw = this.jdField_a_of_type_Baqw;
    OutputStream localOutputStream;
    RandomAccessFile localRandomAccessFile;
    if (localbaps != null)
    {
      localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
      localRandomAccessFile = this.jdField_a_of_type_JavaIoRandomAccessFile;
      if ((localbaps.jdField_c_of_type_JavaLangString == null) || (localOutputStream == null)) {}
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
        if (localbaqw != null)
        {
          if ((localbaps.jdField_f_of_type_JavaLangString != null) && (localbaqw.jdField_a_of_type_Int != 3)) {
            baqy.a(this.jdField_a_of_type_Baqy).remove(localbaps.jdField_f_of_type_JavaLangString);
          }
          if (localbaps.jdField_a_of_type_Bapx != null)
          {
            if (QLog.isColorLevel())
            {
              int i = localbaps.g;
              if (localbaps.jdField_a_of_type_Int != 1) {
                break label246;
              }
              basj.a(i, bool, localbaps.jdField_f_of_type_Int, localbaps.e, "onOutEngine", "result:" + localbaqw.jdField_a_of_type_Int + " errCode:" + localbaqw.jdField_b_of_type_Int + " desc:" + localbaqw.jdField_a_of_type_JavaLangString);
            }
            if ((localbaqw.jdField_b_of_type_Int == 9367) && (QLog.isColorLevel())) {
              break label251;
            }
            localbaps.jdField_a_of_type_Bapx.onResp(localbaqw);
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
          azmp.a("Http_Download_Queen_Full", this.jdField_a_of_type_Baqy.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a());
        }
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = baqy.a(this.jdField_a_of_type_Baps, paramString1, paramString2);
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    baps localbaps = this.jdField_a_of_type_Baps;
    if (localbaps != null) {
      localbaps.jdField_a_of_type_JavaLangObject = null;
    }
    this.jdField_a_of_type_Baps = null;
    this.jdField_a_of_type_Baqw = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
  }
  
  void a(baqv parambaqv)
  {
    try
    {
      if ((parambaqv.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaIoOutputStream != null)) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {}
    }
    catch (IOException parambaqv)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaIoRandomAccessFile.close();
          return;
        }
        catch (IOException parambaqv)
        {
          parambaqv.printStackTrace();
        }
        parambaqv = parambaqv;
        parambaqv.printStackTrace();
      }
    }
  }
  
  void a(bdlo parambdlo)
  {
    baqw localbaqw = this.jdField_a_of_type_Baqw;
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localbaqw == null)) {
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = localbaqw.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap2.containsKey("firstserverip")) {
      localHashMap1.put("firstserverip", localHashMap2.get("firstserverip"));
    }
    if (localHashMap2.containsKey("serverip")) {
      localHashMap1.put("serverip", localHashMap2.get("serverip"));
    }
    if (localHashMap2.containsKey("param_url")) {
      localHashMap1.put("param_url", localHashMap2.get("param_url"));
    }
    if (parambdlo.jdField_b_of_type_JavaUtilHashMap.containsKey(bdlo.jdField_f_of_type_JavaLangString)) {
      localHashMap1.put("netresp_param_reason", parambdlo.jdField_b_of_type_JavaUtilHashMap.get(bdlo.jdField_f_of_type_JavaLangString));
    }
    localbaqw.jdField_a_of_type_JavaUtilHashMap.clear();
    localbaqw.jdField_a_of_type_JavaUtilHashMap.putAll(localHashMap1);
    localbaqw.jdField_a_of_type_JavaUtilHashMap.putAll(parambdlo.jdField_b_of_type_JavaUtilHashMap);
    localbaqw.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", parambdlo.jdField_d_of_type_JavaLangString);
    localbaqw.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", parambdlo.jdField_c_of_type_JavaLangString);
    localbaqw.jdField_c_of_type_Int = parambdlo.c();
  }
  
  public void a(bdlo parambdlo1, bdlo parambdlo2)
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
        } while (this.jdField_a_of_type_Baps == null);
        Object localObject1;
        int i;
        for (;;)
        {
          for (;;)
          {
            try
            {
              if ((parambdlo2.c() != 206) && (parambdlo2.c() != 200)) {
                break;
              }
              parambdlo1 = parambdlo2.a();
              localObject2 = this.jdField_a_of_type_Baps.jdField_a_of_type_Bapu;
              localObject1 = parambdlo1;
              if (localObject2 == null) {}
            }
            catch (IOException parambdlo1)
            {
              parambdlo1.printStackTrace();
              this.jdField_a_of_type_Boolean = true;
              a(parambdlo1, this.jdField_a_of_type_Baqw);
              throw new RuntimeException("io exceptionmsg:" + parambdlo1.getMessage());
            }
            try
            {
              localObject1 = this.jdField_a_of_type_Baps.jdField_a_of_type_Bapu.a(parambdlo1);
              if (localObject1 == null) {
                break;
              }
              i = localObject1.length;
              if (i <= 0) {
                break;
              }
              parambdlo1 = (bdlo)localObject1;
              if (localObject1.length <= 0) {
                break label598;
              }
              parambdlo1 = (bdlo)localObject1;
              if (this.jdField_a_of_type_Baps.jdField_a_of_type_Bapt == null) {
                break label598;
              }
              l1 = System.nanoTime();
              i = 1;
              parambdlo1 = null;
            }
            catch (Throwable parambdlo1)
            {
              parambdlo1 = Log.getStackTraceString(parambdlo1);
              throw new RuntimeException("FlowDecoderExp:" + parambdlo1.substring(0, Math.min(100, parambdlo1.length())));
            }
          }
          try
          {
            localObject2 = Cipher.getInstance("AES/ECB/NoPadding");
            ((Cipher)localObject2).init(2, new SecretKeySpec(this.jdField_a_of_type_Baps.jdField_a_of_type_Bapt.jdField_a_of_type_ArrayOfByte, "AES"));
            if (localObject1.length % 16 != 0) {
              break label309;
            }
            localObject2 = ((Cipher)localObject2).doFinal((byte[])localObject1);
            localObject1 = localObject2;
          }
          catch (NoSuchAlgorithmException parambdlo1)
          {
            int j;
            byte[] arrayOfByte;
            parambdlo1 = Log.getStackTraceString(parambdlo1);
            i = 0;
            continue;
            if (!QLog.isColorLevel()) {
              break label470;
            }
            QLog.e("Q.richmedia.OldHttpEngine", 2, "padding erro,recLen =" + localObject1.length + " writeLen=" + this.jdField_a_of_type_Baqw.jdField_c_of_type_Long + " totalLen=" + parambdlo2.a());
            parambdlo1 = "padding erro,recLen =" + localObject1.length + " writeLen=" + this.jdField_a_of_type_Baqw.jdField_c_of_type_Long + " totalLen=" + parambdlo2.a();
            i = 0;
            continue;
          }
          catch (NoSuchPaddingException parambdlo1)
          {
            parambdlo1 = Log.getStackTraceString(parambdlo1);
            i = 0;
            continue;
          }
          catch (InvalidKeyException parambdlo1)
          {
            parambdlo1 = Log.getStackTraceString(parambdlo1);
            i = 0;
            continue;
          }
          catch (IllegalBlockSizeException parambdlo1)
          {
            parambdlo1 = Log.getStackTraceString(parambdlo1);
            i = 0;
            continue;
          }
          catch (BadPaddingException parambdlo1)
          {
            parambdlo1 = Log.getStackTraceString(parambdlo1);
            i = 0;
            continue;
            long l2 = System.nanoTime();
            parambdlo1 = this.jdField_a_of_type_Baqw;
            parambdlo1.j = (l2 - l1 + parambdlo1.j);
            parambdlo1 = (bdlo)localObject1;
          }
          if (i != 0) {
            break label571;
          }
          throw new RuntimeException("DecryptError:" + parambdlo1);
          if ((parambdlo2.a() <= 0L) || (localObject1.length + this.jdField_a_of_type_Baqw.jdField_c_of_type_Long != parambdlo2.a())) {
            break label406;
          }
          j = localObject1.length % 16;
          arrayOfByte = new byte[localObject1.length - j];
          System.arraycopy(localObject1, 0, arrayOfByte, 0, localObject1.length - j);
          Object localObject2 = ((Cipher)localObject2).doFinal(arrayOfByte);
          System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
        }
        this.jdField_b_of_type_Int += parambdlo1.length;
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break;
        }
        this.jdField_a_of_type_JavaIoOutputStream.write(parambdlo1);
        this.jdField_a_of_type_JavaIoOutputStream.flush();
        this.jdField_a_of_type_Baqw.jdField_a_of_type_Long = parambdlo2.a();
        this.jdField_a_of_type_Baqw.jdField_b_of_type_Long = parambdlo2.jdField_b_of_type_Long;
        parambdlo2 = this.jdField_a_of_type_Baqw;
        l1 = parambdlo2.jdField_c_of_type_Long;
        parambdlo2.jdField_c_of_type_Long = (parambdlo1.length + l1);
      } while (this.jdField_a_of_type_Baps.jdField_a_of_type_Bapx == null);
      this.jdField_a_of_type_Baps.jdField_a_of_type_Bapx.onUpdateProgeress(this.jdField_a_of_type_Baps, this.jdField_a_of_type_Baqw.jdField_c_of_type_Long + this.jdField_a_of_type_Baps.jdField_a_of_type_Long, this.jdField_a_of_type_Baqw.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
        break;
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile.length() == 0L) {
        this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(parambdlo2.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_JavaIoRandomAccessFile.write(parambdlo1);
      this.jdField_a_of_type_Baqw.jdField_a_of_type_Long = parambdlo2.a();
      this.jdField_a_of_type_Baqw.jdField_b_of_type_Long = parambdlo2.jdField_b_of_type_Long;
      parambdlo2 = this.jdField_a_of_type_Baqw;
      long l1 = parambdlo2.jdField_c_of_type_Long;
      parambdlo2.jdField_c_of_type_Long = (parambdlo1.length + l1);
    } while (this.jdField_a_of_type_Baps.jdField_a_of_type_Bapx == null);
    label406:
    label571:
    this.jdField_a_of_type_Baps.jdField_a_of_type_Bapx.onUpdateProgeress(this.jdField_a_of_type_Baps, this.jdField_a_of_type_Baqw.jdField_c_of_type_Long + this.jdField_a_of_type_Baps.jdField_a_of_type_Long, this.jdField_a_of_type_Baqw.jdField_a_of_type_Long);
    return;
    this.jdField_a_of_type_Baqw.jdField_a_of_type_Long = parambdlo2.a();
    this.jdField_a_of_type_Baqw.jdField_b_of_type_Long = parambdlo2.jdField_b_of_type_Long;
    this.jdField_a_of_type_Baqw.jdField_a_of_type_ArrayOfByte = parambdlo2.a();
  }
  
  void a(IOException paramIOException, baqw parambaqw)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      return;
      parambaqw = paramIOException.getMessage();
      this.jdField_a_of_type_Baqw.a(1, 9301, parambaqw + MsfSdkUtils.getStackTraceString(paramIOException), null);
      try
      {
        paramIOException = Environment.getExternalStorageState();
        if (parambaqw.contains("EACCES"))
        {
          this.jdField_a_of_type_Baqw.jdField_b_of_type_Int = 9039;
          return;
        }
      }
      catch (Exception paramIOException)
      {
        paramIOException.printStackTrace();
        return;
      }
      if ((parambaqw.contains("ENOSPC")) || (parambaqw.contains("space")))
      {
        long l = bdal.b();
        if (this.jdField_a_of_type_Baps != null)
        {
          paramIOException = this.jdField_a_of_type_Baps.jdField_c_of_type_JavaLangString;
          parambaqw = new File(paramIOException).getParentFile();
          QLog.e("Q.richmedia.OldHttpEngine", 1, "no space error, outPath:" + paramIOException + ",fileCount:" + parambaqw.listFiles().length + ",url:" + this.jdField_a_of_type_Baps.jdField_a_of_type_JavaLangString + ",availableSpace:" + l);
        }
        this.jdField_a_of_type_Baqw.jdField_b_of_type_Int = 9040;
        return;
      }
      if (parambaqw.contains("Read-only"))
      {
        this.jdField_a_of_type_Baqw.jdField_b_of_type_Int = 9039;
        return;
      }
    } while ("mounted".equals(paramIOException));
    this.jdField_a_of_type_Baqw.jdField_b_of_type_Int = 9039;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Baqw != null) && (this.jdField_a_of_type_Bdlo != null))
    {
      this.jdField_a_of_type_Baqw.g = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Bdlo.jdField_d_of_type_Long);
      paramString = this.jdField_a_of_type_Baqw;
      paramString.e += 1;
    }
  }
  
  public boolean a(bdlo parambdlo1, bdlo parambdlo2, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return true;
    }
    if (paramInt == 5)
    {
      a(parambdlo2);
      if (!this.jdField_a_of_type_Baps.a()) {
        break label777;
      }
      if ((a(parambdlo2)) && (this.jdField_a_of_type_Baqw.jdField_c_of_type_Long != this.jdField_a_of_type_Baqw.jdField_b_of_type_Long) && ((this.jdField_a_of_type_Baps.jdField_a_of_type_Bapu == null) || (!this.jdField_a_of_type_Baps.jdField_a_of_type_Bapu.a()))) {
        break label427;
      }
      this.jdField_a_of_type_Baqw.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Baqw.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Baqw.jdField_a_of_type_JavaLangString = "";
      int i = 0;
      paramInt = i;
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        paramInt = i;
        if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Baps.jdField_c_of_type_JavaLangString)) {
          paramInt = 1;
        }
      }
      if (this.jdField_a_of_type_Baps.jdField_c_of_type_JavaLangString == null) {}
    }
    try
    {
      if ((this.jdField_a_of_type_Baps.j) && (paramInt == 0) && (bdcs.a(this.jdField_a_of_type_Baps.jdField_c_of_type_JavaLangString))) {
        bdcs.d(this.jdField_a_of_type_Baps.jdField_c_of_type_JavaLangString);
      }
    }
    catch (Exception parambdlo2)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break label216;
        }
        this.jdField_a_of_type_JavaIoOutputStream.close();
        label216:
        if (!this.jdField_a_of_type_Baps.i) {
          break label240;
        }
      }
      catch (IOException parambdlo2)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_JavaIoRandomAccessFile != null) {
              this.jdField_a_of_type_JavaIoRandomAccessFile.close();
            }
            label240:
            if (this.jdField_a_of_type_Baps.j) {
              break;
            }
            if (parambdlo1.e != 0L) {
              this.jdField_a_of_type_Baqw.h = parambdlo1.e;
            }
            this.jdField_a_of_type_Baqw.i = parambdlo1.h;
            if (parambdlo1.jdField_f_of_type_Long != 0L) {
              this.jdField_a_of_type_Baqw.j = parambdlo1.jdField_f_of_type_Long;
            }
            c();
            return true;
            parambdlo2 = parambdlo2;
            parambdlo2.printStackTrace();
          }
          parambdlo2 = parambdlo2;
          parambdlo2.printStackTrace();
        }
        catch (IOException parambdlo2)
        {
          for (;;)
          {
            parambdlo2.printStackTrace();
            continue;
            if ((paramInt == 0) && (!bdcs.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Baps.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString != null)) {
              if (bdcs.d(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Baps.jdField_c_of_type_JavaLangString))
              {
                new File(this.jdField_a_of_type_JavaLangString).delete();
              }
              else
              {
                this.jdField_a_of_type_Baqw.a(1, 9301, "rename file failed", null);
                new File(this.jdField_a_of_type_JavaLangString).delete();
              }
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_Baps.jdField_c_of_type_JavaLangString != null) {}
    label427:
    label620:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Baps.jdField_a_of_type_Bapu == null)
        {
          if (QLog.isColorLevel())
          {
            paramInt = this.jdField_a_of_type_Baps.g;
            if (this.jdField_a_of_type_Baps.jdField_a_of_type_Int != 1) {
              break label620;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            basj.a(paramInt, bool, this.jdField_a_of_type_Baps.jdField_f_of_type_Int, this.jdField_a_of_type_Baps.e, "check", "writtenSize:" + this.jdField_a_of_type_Baqw.jdField_c_of_type_Long + " totalBlockLen:" + this.jdField_a_of_type_Baqw.jdField_b_of_type_Long);
            this.jdField_a_of_type_Baqw.a(1, -9527, null, null);
            parambdlo2 = bamw.a("Q", -9533L);
            this.jdField_a_of_type_Baqw.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", parambdlo2);
            this.jdField_a_of_type_Baqw.jdField_a_of_type_JavaLangString = ("recvSize:" + this.jdField_a_of_type_Baqw.jdField_c_of_type_Long + " totalBlockLen:" + this.jdField_a_of_type_Baqw.jdField_b_of_type_Long);
            break;
          }
        }
        this.jdField_a_of_type_Baqw.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Baqw.jdField_b_of_type_Int = 9058;
        this.jdField_a_of_type_Baqw.jdField_a_of_type_JavaLangString = "error data len ! ";
        QLog.d("T.Q.richmedia." + basj.b(this.jdField_a_of_type_Baps.g) + "." + basj.c(this.jdField_a_of_type_Baps.jdField_f_of_type_Int), 1, "id:" + String.valueOf(parambdlo1.jdField_a_of_type_JavaLangString) + "reqUrl:" + this.jdField_a_of_type_Baps.jdField_a_of_type_JavaLangString + ",reqHeader:" + parambdlo1.jdField_c_of_type_JavaLangString + "responseHeader:" + parambdlo2.jdField_d_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Baqw.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Baqw.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Baqw.jdField_a_of_type_JavaLangString = "";
    } while (((this.jdField_a_of_type_Baqw.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_Baqw.jdField_a_of_type_ArrayOfByte.length == this.jdField_a_of_type_Baqw.jdField_b_of_type_Long)) && ((this.jdField_a_of_type_Baqw.jdField_a_of_type_ArrayOfByte != null) || (this.jdField_a_of_type_Baqw.jdField_b_of_type_Long == 0L)));
    label777:
    this.jdField_a_of_type_Baqw.a(1, -9527, null, null);
    parambdlo2 = bamw.a("Q", -9533L);
    this.jdField_a_of_type_Baqw.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", parambdlo2);
    parambdlo2 = this.jdField_a_of_type_Baqw;
    StringBuilder localStringBuilder = new StringBuilder().append("recvSize:");
    if (this.jdField_a_of_type_Baqw.jdField_a_of_type_ArrayOfByte != null) {}
    for (paramInt = this.jdField_a_of_type_Baqw.jdField_a_of_type_ArrayOfByte.length;; paramInt = 0)
    {
      parambdlo2.jdField_a_of_type_JavaLangString = (paramInt + " totalBlockLen:" + this.jdField_a_of_type_Baqw.jdField_b_of_type_Long);
      break;
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_Int = baqx.a().a();
    Object localObject = this.jdField_a_of_type_Baps;
    baqw localbaqw = this.jdField_a_of_type_Baqw;
    if ((localObject == null) || (localbaqw == null))
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    label367:
    int i;
    if (((baps)localObject).jdField_c_of_type_JavaLangString != null)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaLangString = a(((baps)localObject).jdField_c_of_type_JavaLangString, ((baps)localObject).jdField_a_of_type_JavaLangString);
          localbaqw.jdField_a_of_type_Baqv.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localFile = new File(this.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            break label367;
          }
          l = localFile.length();
          if ((l <= 0L) || (((baps)localObject).jdField_a_of_type_Bapw == null)) {
            continue;
          }
          localbaqw.jdField_c_of_type_Long = l;
          ((baps)localObject).jdField_a_of_type_Bapw.a((baqv)localObject, localbaqw);
          if (!((baps)localObject).i) {
            continue;
          }
          this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localFile, "rw");
          this.jdField_a_of_type_JavaIoRandomAccessFile.seek(((baps)localObject).jdField_a_of_type_Long);
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
          if (!((baps)localObject).i) {
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
          localObject = new URL(((baps)localObject).jdField_a_of_type_JavaLangString).getHost();
          localbaqw.jdField_a_of_type_JavaUtilHashMap.put("firstserverip", localObject);
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
        i = ((baps)localObject).g;
        if (((baps)localObject).jdField_a_of_type_Int != 1) {
          break label485;
        }
      }
    }
    label485:
    for (boolean bool = true;; bool = false)
    {
      basj.a(i, bool, ((baps)localObject).jdField_f_of_type_Int, ((baps)localObject).e, "createtmp", this.jdField_a_of_type_JavaLangString);
      bdcs.a(this.jdField_a_of_type_JavaLangString);
      if (((baps)localObject).i)
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localIOException, "rw");
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(localIOException);
      break;
      if (((baps)localObject).jdField_a_of_type_JavaIoOutputStream == null) {
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = ((baps)localObject).jdField_a_of_type_JavaIoOutputStream;
      break;
    }
  }
  
  public void b(bdlo parambdlo1, bdlo parambdlo2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    baps localbaps;
    baqw localbaqw;
    do
    {
      return;
      localbaps = this.jdField_a_of_type_Baps;
      localbaqw = this.jdField_a_of_type_Baqw;
    } while ((localbaps == null) || (localbaqw == null));
    a(parambdlo2);
    long l1 = System.currentTimeMillis() - localbaqw.jdField_f_of_type_Long;
    localbaqw.jdField_d_of_type_Long += l1;
    if ((localbaps.jdField_a_of_type_JavaUtilList != null) && (localbaps.jdField_a_of_type_JavaUtilList.size() >= 1)) {
      ((basp)localbaps.jdField_a_of_type_JavaUtilList.get(0)).a();
    }
    long l2 = baqx.a().a();
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
      if ((localbaqw.jdField_b_of_type_Int == 9056) && (l1 < 2000L))
      {
        i = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = (i - 1);
        if (i > 0)
        {
          if ((localbaqw.jdField_b_of_type_Int == 9056) || (localbaqw.jdField_b_of_type_Int == 9051)) {
            this.e += 1;
          }
          if (this.jdField_a_of_type_Boolean) {
            break label890;
          }
          localbaqw.jdField_b_of_type_Int = parambdlo2.jdField_f_of_type_Int;
          localbaqw.jdField_a_of_type_JavaLangString = parambdlo2.jdField_b_of_type_JavaLangString;
          localbaqw.jdField_a_of_type_Int = 1;
          if (j != 0) {
            break label867;
          }
          localbaqw.jdField_b_of_type_Int = 9004;
          localbaqw.jdField_a_of_type_JavaLangString = "no network";
          localbaqw.jdField_a_of_type_Int = 1;
          if ((l2 == this.jdField_d_of_type_Int) || (l2 == 0L) || (this.jdField_d_of_type_Int == 0L)) {
            break label895;
          }
          i = 1;
          if ((!localbaps.k) || (i == 0) || (!basb.a(parambdlo2.jdField_f_of_type_Int))) {
            break label900;
          }
          i = 1;
          if (i != 0)
          {
            localbaqw.jdField_b_of_type_Int = 9364;
            localbaqw.jdField_a_of_type_JavaLangString = "netchg";
            if (QLog.isColorLevel())
            {
              k = localbaps.g;
              if (localbaps.jdField_a_of_type_Int != 1) {
                break label905;
              }
              bool1 = true;
              basj.a(k, bool1, localbaps.jdField_f_of_type_Int, localbaps.e, "netChg", "originNet:" + this.jdField_d_of_type_Int + " cur:" + l2);
            }
          }
          if (this.jdField_b_of_type_Int <= 0) {
            break label911;
          }
          bool1 = true;
          label409:
          if ((this.jdField_a_of_type_Boolean) || (i != 0) || ((!parambdlo2.d()) && (!baqy.a(this.jdField_a_of_type_Baqy, parambdlo2, localbaps))) || (((localbaqw.jdField_d_of_type_Long >= localbaps.jdField_c_of_type_Long - 5000L) || (this.jdField_a_of_type_Int > localbaps.jdField_c_of_type_Int)) && ((!bool1) || (localbaqw.jdField_d_of_type_Long >= localbaps.jdField_c_of_type_Long * 3L / 2L - 5000L)))) {
            break label1301;
          }
          if (QLog.isColorLevel())
          {
            k = localbaps.g;
            if (localbaps.jdField_a_of_type_Int != 1) {
              break label917;
            }
            bool2 = true;
            label526:
            int m = localbaps.jdField_f_of_type_Int;
            String str = localbaps.e;
            StringBuilder localStringBuilder = new StringBuilder().append("tryTime:");
            if (this.jdField_a_of_type_Baqw == null) {
              break label923;
            }
            i = this.jdField_a_of_type_Baqw.jdField_d_of_type_Int;
            label570:
            localStringBuilder = localStringBuilder.append(i).append(" consumeTime:");
            if (this.jdField_a_of_type_Baqw == null) {
              break label928;
            }
            l1 = this.jdField_a_of_type_Baqw.jdField_d_of_type_Long;
            label600:
            basj.a(k, bool2, m, str, "retry", l1 + " isLastGetData:" + bool1);
          }
          k = 1;
          i = k;
          if (localbaqw.jdField_c_of_type_Long > 0L)
          {
            if (!localbaps.c()) {
              break label939;
            }
            if (localbaps.jdField_a_of_type_Bapw == null) {
              break label934;
            }
            localbaps.jdField_a_of_type_Bapw.a(localbaps, localbaqw);
            this.jdField_a_of_type_JavaIoOutputStream = localbaps.jdField_a_of_type_JavaIoOutputStream;
            i = k;
          }
          label693:
          k = i;
          if (localbaps.m)
          {
            k = i;
            if (parambdlo2.c() >= 400)
            {
              k = i;
              if (parambdlo2.c() < 500)
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
          bdcs.d(this.jdField_a_of_type_JavaLangString);
          k = i;
        }
        catch (Exception parambdlo2)
        {
          for (;;)
          {
            k = i;
          }
        }
        if (this.e >= localbaps.jdField_d_of_type_Int) {
          localbaps.jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
        }
        if (k == 0)
        {
          if (QLog.isColorLevel())
          {
            i = localbaps.g;
            if (localbaps.jdField_a_of_type_Int != 1) {
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
              basj.a(i, bool1, localbaps.jdField_f_of_type_Int, localbaps.e, "retry", "breakDownAllowRetry is false ");
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
              if (localbaps.jdField_a_of_type_Bapy == null) {
                break label246;
              }
              localbaps.jdField_a_of_type_Bapy.a(localbaqw);
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
              if (!localbaps.b()) {
                break label693;
              }
              if (localbaps.jdField_a_of_type_Bapw != null)
              {
                localbaps.jdField_a_of_type_Bapw.a(localbaps, localbaqw);
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
                localbaqw.jdField_c_of_type_Long = 0L;
                i = 1;
              }
              catch (IOException localIOException)
              {
                a(localIOException, localbaqw);
                i = k;
              }
            }
            break label693;
          }
        }
        if (localbaps.jdField_a_of_type_Bapu != null) {
          localbaps.jdField_a_of_type_Bapu.a();
        }
        if (localbaps.jdField_a_of_type_Boolean)
        {
          if (localbaps.jdField_b_of_type_Boolean)
          {
            bavf.a().a(bavf.a(localbaps.jdField_a_of_type_JavaLangString), bavf.a(parambdlo1.a()), 1002);
            localbaps.jdField_b_of_type_Boolean = false;
          }
          localbaps.jdField_a_of_type_Boolean = false;
        }
        if ((localbaps.jdField_a_of_type_JavaUtilList != null) && (localbaps.jdField_a_of_type_JavaUtilList.size() >= 1) && (j != 0))
        {
          parambdlo1 = (basp)localbaps.jdField_a_of_type_JavaUtilList.remove(0);
          localbaps.jdField_a_of_type_JavaUtilList.add(parambdlo1);
          parambdlo1 = (basp)localbaps.jdField_a_of_type_JavaUtilList.get(0);
          if (localbaps.jdField_a_of_type_JavaLangString != null)
          {
            parambdlo1 = parambdlo1.a(localbaps.jdField_a_of_type_JavaLangString);
            localbaps.jdField_a_of_type_JavaLangString = basj.a(localbaps.jdField_a_of_type_JavaLangString, parambdlo1);
          }
        }
        if ((localbaqw.jdField_b_of_type_Int == 9050) && (localbaps.jdField_a_of_type_Bash != null)) {
          localbaps.jdField_a_of_type_Bash.a(this.jdField_a_of_type_Int);
        }
        if ((localbaqw.jdField_b_of_type_Int == 9056) && (l2 != 0L)) {
          l1 = 0L;
        }
        for (;;)
        {
          a(l1, localbaps);
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
      catch (Exception parambdlo2)
      {
        break label749;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqz
 * JD-Core Version:    0.7.0.1
 */