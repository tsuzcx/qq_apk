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

public class aytc
  implements bbmw
{
  int jdField_a_of_type_Int = 0;
  public ayrx a;
  public aysz a;
  public bbmu a;
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
  
  public aytc(aytb paramaytb)
  {
    this.jdField_c_of_type_Int = 5;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(long paramLong, ayrx paramayrx)
  {
    int i;
    if ((QLog.isColorLevel()) && (paramayrx != null))
    {
      i = paramayrx.g;
      if (paramayrx.jdField_a_of_type_Int != 1) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      ayuk.a(i, bool, paramayrx.jdField_f_of_type_Int, paramayrx.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_Aysz.jdField_f_of_type_Long = System.currentTimeMillis();
    if (ayta.a().a() != 0)
    {
      if ((this.jdField_a_of_type_Aytb.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramLong != 0L))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new OldHttpEngine.OldHttpCommunicatorListner.1(this, paramayrx), paramLong);
        return;
      }
      if ((QLog.isColorLevel()) && (paramayrx != null))
      {
        i = paramayrx.g;
        if (paramayrx.jdField_a_of_type_Int != 1) {
          break label227;
        }
      }
      label227:
      for (bool = true;; bool = false)
      {
        ayuk.a(i, bool, paramayrx.jdField_f_of_type_Int, paramayrx.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
        this.jdField_a_of_type_Aytb.c(this.jdField_a_of_type_Ayrx);
        return;
      }
    }
    if (this.jdField_a_of_type_Aytb.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      ThreadManager.getTimer().schedule(new OldHttpEngine.OldHttpCommunicatorListner.2(this, paramayrx), paramLong);
      return;
    }
    if ((QLog.isColorLevel()) && (paramayrx != null))
    {
      i = paramayrx.g;
      if (paramayrx.jdField_a_of_type_Int != 1) {
        break label320;
      }
    }
    label320:
    for (bool = true;; bool = false)
    {
      ayuk.a(i, bool, paramayrx.jdField_f_of_type_Int, paramayrx.e, "scheduleRetry", "mWorking is false");
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
  }
  
  private boolean a(bbmu parambbmu)
  {
    return false;
  }
  
  private void c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    ayrx localayrx = this.jdField_a_of_type_Ayrx;
    aysz localaysz = this.jdField_a_of_type_Aysz;
    OutputStream localOutputStream;
    RandomAccessFile localRandomAccessFile;
    if (localayrx != null)
    {
      localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
      localRandomAccessFile = this.jdField_a_of_type_JavaIoRandomAccessFile;
      if ((localayrx.jdField_c_of_type_JavaLangString == null) || (localOutputStream == null)) {}
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
        if (localaysz != null)
        {
          if ((localayrx.jdField_f_of_type_JavaLangString != null) && (localaysz.jdField_a_of_type_Int != 3)) {
            aytb.a(this.jdField_a_of_type_Aytb).remove(localayrx.jdField_f_of_type_JavaLangString);
          }
          if (localayrx.jdField_a_of_type_Aysc != null)
          {
            if (QLog.isColorLevel())
            {
              int i = localayrx.g;
              if (localayrx.jdField_a_of_type_Int != 1) {
                break label246;
              }
              ayuk.a(i, bool, localayrx.jdField_f_of_type_Int, localayrx.e, "onOutEngine", "result:" + localaysz.jdField_a_of_type_Int + " errCode:" + localaysz.jdField_b_of_type_Int + " desc:" + localaysz.jdField_a_of_type_JavaLangString);
            }
            if ((localaysz.jdField_b_of_type_Int == 9367) && (QLog.isColorLevel())) {
              break label251;
            }
            localayrx.jdField_a_of_type_Aysc.onResp(localaysz);
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
          axrd.a("Http_Download_Queen_Full", this.jdField_a_of_type_Aytb.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a());
        }
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = aytb.a(this.jdField_a_of_type_Ayrx, paramString1, paramString2);
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    ayrx localayrx = this.jdField_a_of_type_Ayrx;
    if (localayrx != null) {
      localayrx.jdField_a_of_type_JavaLangObject = null;
    }
    this.jdField_a_of_type_Ayrx = null;
    this.jdField_a_of_type_Aysz = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
  }
  
  void a(aysy paramaysy)
  {
    try
    {
      if ((paramaysy.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaIoOutputStream != null)) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {}
    }
    catch (IOException paramaysy)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaIoRandomAccessFile.close();
          return;
        }
        catch (IOException paramaysy)
        {
          paramaysy.printStackTrace();
        }
        paramaysy = paramaysy;
        paramaysy.printStackTrace();
      }
    }
  }
  
  void a(bbmu parambbmu)
  {
    aysz localaysz = this.jdField_a_of_type_Aysz;
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localaysz == null)) {
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = localaysz.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap2.containsKey("firstserverip")) {
      localHashMap1.put("firstserverip", localHashMap2.get("firstserverip"));
    }
    if (localHashMap2.containsKey("serverip")) {
      localHashMap1.put("serverip", localHashMap2.get("serverip"));
    }
    if (localHashMap2.containsKey("param_url")) {
      localHashMap1.put("param_url", localHashMap2.get("param_url"));
    }
    if (parambbmu.jdField_b_of_type_JavaUtilHashMap.containsKey(bbmu.jdField_f_of_type_JavaLangString)) {
      localHashMap1.put("netresp_param_reason", parambbmu.jdField_b_of_type_JavaUtilHashMap.get(bbmu.jdField_f_of_type_JavaLangString));
    }
    localaysz.jdField_a_of_type_JavaUtilHashMap.clear();
    localaysz.jdField_a_of_type_JavaUtilHashMap.putAll(localHashMap1);
    localaysz.jdField_a_of_type_JavaUtilHashMap.putAll(parambbmu.jdField_b_of_type_JavaUtilHashMap);
    localaysz.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", parambbmu.jdField_d_of_type_JavaLangString);
    localaysz.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", parambbmu.jdField_c_of_type_JavaLangString);
    localaysz.jdField_c_of_type_Int = parambbmu.c();
  }
  
  public void a(bbmu parambbmu1, bbmu parambbmu2)
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
        } while (this.jdField_a_of_type_Ayrx == null);
        Object localObject1;
        int i;
        for (;;)
        {
          for (;;)
          {
            try
            {
              if ((parambbmu2.c() != 206) && (parambbmu2.c() != 200)) {
                break;
              }
              parambbmu1 = parambbmu2.a();
              localObject2 = this.jdField_a_of_type_Ayrx.jdField_a_of_type_Ayrz;
              localObject1 = parambbmu1;
              if (localObject2 == null) {}
            }
            catch (IOException parambbmu1)
            {
              parambbmu1.printStackTrace();
              this.jdField_a_of_type_Boolean = true;
              a(parambbmu1, this.jdField_a_of_type_Aysz);
              throw new RuntimeException("io exceptionmsg:" + parambbmu1.getMessage());
            }
            try
            {
              localObject1 = this.jdField_a_of_type_Ayrx.jdField_a_of_type_Ayrz.a(parambbmu1);
              if (localObject1 == null) {
                break;
              }
              i = localObject1.length;
              if (i <= 0) {
                break;
              }
              parambbmu1 = (bbmu)localObject1;
              if (localObject1.length <= 0) {
                break label598;
              }
              parambbmu1 = (bbmu)localObject1;
              if (this.jdField_a_of_type_Ayrx.jdField_a_of_type_Ayry == null) {
                break label598;
              }
              l1 = System.nanoTime();
              i = 1;
              parambbmu1 = null;
            }
            catch (Throwable parambbmu1)
            {
              parambbmu1 = Log.getStackTraceString(parambbmu1);
              throw new RuntimeException("FlowDecoderExp:" + parambbmu1.substring(0, Math.min(100, parambbmu1.length())));
            }
          }
          try
          {
            localObject2 = Cipher.getInstance("AES/ECB/NoPadding");
            ((Cipher)localObject2).init(2, new SecretKeySpec(this.jdField_a_of_type_Ayrx.jdField_a_of_type_Ayry.jdField_a_of_type_ArrayOfByte, "AES"));
            if (localObject1.length % 16 != 0) {
              break label309;
            }
            localObject2 = ((Cipher)localObject2).doFinal((byte[])localObject1);
            localObject1 = localObject2;
          }
          catch (NoSuchAlgorithmException parambbmu1)
          {
            int j;
            byte[] arrayOfByte;
            parambbmu1 = Log.getStackTraceString(parambbmu1);
            i = 0;
            continue;
            if (!QLog.isColorLevel()) {
              break label470;
            }
            QLog.e("Q.richmedia.OldHttpEngine", 2, "padding erro,recLen =" + localObject1.length + " writeLen=" + this.jdField_a_of_type_Aysz.jdField_c_of_type_Long + " totalLen=" + parambbmu2.a());
            parambbmu1 = "padding erro,recLen =" + localObject1.length + " writeLen=" + this.jdField_a_of_type_Aysz.jdField_c_of_type_Long + " totalLen=" + parambbmu2.a();
            i = 0;
            continue;
          }
          catch (NoSuchPaddingException parambbmu1)
          {
            parambbmu1 = Log.getStackTraceString(parambbmu1);
            i = 0;
            continue;
          }
          catch (InvalidKeyException parambbmu1)
          {
            parambbmu1 = Log.getStackTraceString(parambbmu1);
            i = 0;
            continue;
          }
          catch (IllegalBlockSizeException parambbmu1)
          {
            parambbmu1 = Log.getStackTraceString(parambbmu1);
            i = 0;
            continue;
          }
          catch (BadPaddingException parambbmu1)
          {
            parambbmu1 = Log.getStackTraceString(parambbmu1);
            i = 0;
            continue;
            long l2 = System.nanoTime();
            parambbmu1 = this.jdField_a_of_type_Aysz;
            parambbmu1.j = (l2 - l1 + parambbmu1.j);
            parambbmu1 = (bbmu)localObject1;
          }
          if (i != 0) {
            break label571;
          }
          throw new RuntimeException("DecryptError:" + parambbmu1);
          if ((parambbmu2.a() <= 0L) || (localObject1.length + this.jdField_a_of_type_Aysz.jdField_c_of_type_Long != parambbmu2.a())) {
            break label406;
          }
          j = localObject1.length % 16;
          arrayOfByte = new byte[localObject1.length - j];
          System.arraycopy(localObject1, 0, arrayOfByte, 0, localObject1.length - j);
          Object localObject2 = ((Cipher)localObject2).doFinal(arrayOfByte);
          System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
        }
        this.jdField_b_of_type_Int += parambbmu1.length;
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break;
        }
        this.jdField_a_of_type_JavaIoOutputStream.write(parambbmu1);
        this.jdField_a_of_type_JavaIoOutputStream.flush();
        this.jdField_a_of_type_Aysz.jdField_a_of_type_Long = parambbmu2.a();
        this.jdField_a_of_type_Aysz.jdField_b_of_type_Long = parambbmu2.jdField_b_of_type_Long;
        parambbmu2 = this.jdField_a_of_type_Aysz;
        l1 = parambbmu2.jdField_c_of_type_Long;
        parambbmu2.jdField_c_of_type_Long = (parambbmu1.length + l1);
      } while (this.jdField_a_of_type_Ayrx.jdField_a_of_type_Aysc == null);
      this.jdField_a_of_type_Ayrx.jdField_a_of_type_Aysc.onUpdateProgeress(this.jdField_a_of_type_Ayrx, this.jdField_a_of_type_Aysz.jdField_c_of_type_Long + this.jdField_a_of_type_Ayrx.jdField_a_of_type_Long, this.jdField_a_of_type_Aysz.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
        break;
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile.length() == 0L) {
        this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(parambbmu2.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_JavaIoRandomAccessFile.write(parambbmu1);
      this.jdField_a_of_type_Aysz.jdField_a_of_type_Long = parambbmu2.a();
      this.jdField_a_of_type_Aysz.jdField_b_of_type_Long = parambbmu2.jdField_b_of_type_Long;
      parambbmu2 = this.jdField_a_of_type_Aysz;
      long l1 = parambbmu2.jdField_c_of_type_Long;
      parambbmu2.jdField_c_of_type_Long = (parambbmu1.length + l1);
    } while (this.jdField_a_of_type_Ayrx.jdField_a_of_type_Aysc == null);
    label406:
    label571:
    this.jdField_a_of_type_Ayrx.jdField_a_of_type_Aysc.onUpdateProgeress(this.jdField_a_of_type_Ayrx, this.jdField_a_of_type_Aysz.jdField_c_of_type_Long + this.jdField_a_of_type_Ayrx.jdField_a_of_type_Long, this.jdField_a_of_type_Aysz.jdField_a_of_type_Long);
    return;
    this.jdField_a_of_type_Aysz.jdField_a_of_type_Long = parambbmu2.a();
    this.jdField_a_of_type_Aysz.jdField_b_of_type_Long = parambbmu2.jdField_b_of_type_Long;
    this.jdField_a_of_type_Aysz.jdField_a_of_type_ArrayOfByte = parambbmu2.a();
  }
  
  void a(IOException paramIOException, aysz paramaysz)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      return;
      paramaysz = paramIOException.getMessage();
      this.jdField_a_of_type_Aysz.a(1, 9301, paramaysz + MsfSdkUtils.getStackTraceString(paramIOException), null);
      try
      {
        paramIOException = Environment.getExternalStorageState();
        if (paramaysz.contains("EACCES"))
        {
          this.jdField_a_of_type_Aysz.jdField_b_of_type_Int = 9039;
          return;
        }
      }
      catch (Exception paramIOException)
      {
        paramIOException.printStackTrace();
        return;
      }
      if ((paramaysz.contains("ENOSPC")) || (paramaysz.contains("space")))
      {
        long l = bbbr.b();
        if (this.jdField_a_of_type_Ayrx != null)
        {
          paramIOException = this.jdField_a_of_type_Ayrx.jdField_c_of_type_JavaLangString;
          paramaysz = new File(paramIOException).getParentFile();
          QLog.e("Q.richmedia.OldHttpEngine", 1, "no space error, outPath:" + paramIOException + ",fileCount:" + paramaysz.listFiles().length + ",url:" + this.jdField_a_of_type_Ayrx.jdField_a_of_type_JavaLangString + ",availableSpace:" + l);
        }
        this.jdField_a_of_type_Aysz.jdField_b_of_type_Int = 9040;
        return;
      }
      if (paramaysz.contains("Read-only"))
      {
        this.jdField_a_of_type_Aysz.jdField_b_of_type_Int = 9039;
        return;
      }
    } while ("mounted".equals(paramIOException));
    this.jdField_a_of_type_Aysz.jdField_b_of_type_Int = 9039;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Aysz != null) && (this.jdField_a_of_type_Bbmu != null))
    {
      this.jdField_a_of_type_Aysz.g = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Bbmu.jdField_d_of_type_Long);
      paramString = this.jdField_a_of_type_Aysz;
      paramString.e += 1;
    }
  }
  
  public boolean a(bbmu parambbmu1, bbmu parambbmu2, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return true;
    }
    if (paramInt == 5)
    {
      a(parambbmu2);
      if (!this.jdField_a_of_type_Ayrx.a()) {
        break label777;
      }
      if ((a(parambbmu2)) && (this.jdField_a_of_type_Aysz.jdField_c_of_type_Long != this.jdField_a_of_type_Aysz.jdField_b_of_type_Long) && ((this.jdField_a_of_type_Ayrx.jdField_a_of_type_Ayrz == null) || (!this.jdField_a_of_type_Ayrx.jdField_a_of_type_Ayrz.a()))) {
        break label427;
      }
      this.jdField_a_of_type_Aysz.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Aysz.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Aysz.jdField_a_of_type_JavaLangString = "";
      int i = 0;
      paramInt = i;
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        paramInt = i;
        if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Ayrx.jdField_c_of_type_JavaLangString)) {
          paramInt = 1;
        }
      }
      if (this.jdField_a_of_type_Ayrx.jdField_c_of_type_JavaLangString == null) {}
    }
    try
    {
      if ((this.jdField_a_of_type_Ayrx.j) && (paramInt == 0) && (bbdx.a(this.jdField_a_of_type_Ayrx.jdField_c_of_type_JavaLangString))) {
        bbdx.d(this.jdField_a_of_type_Ayrx.jdField_c_of_type_JavaLangString);
      }
    }
    catch (Exception parambbmu2)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break label216;
        }
        this.jdField_a_of_type_JavaIoOutputStream.close();
        label216:
        if (!this.jdField_a_of_type_Ayrx.i) {
          break label240;
        }
      }
      catch (IOException parambbmu2)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_JavaIoRandomAccessFile != null) {
              this.jdField_a_of_type_JavaIoRandomAccessFile.close();
            }
            label240:
            if (this.jdField_a_of_type_Ayrx.j) {
              break;
            }
            if (parambbmu1.e != 0L) {
              this.jdField_a_of_type_Aysz.h = parambbmu1.e;
            }
            this.jdField_a_of_type_Aysz.i = parambbmu1.h;
            if (parambbmu1.jdField_f_of_type_Long != 0L) {
              this.jdField_a_of_type_Aysz.j = parambbmu1.jdField_f_of_type_Long;
            }
            c();
            return true;
            parambbmu2 = parambbmu2;
            parambbmu2.printStackTrace();
          }
          parambbmu2 = parambbmu2;
          parambbmu2.printStackTrace();
        }
        catch (IOException parambbmu2)
        {
          for (;;)
          {
            parambbmu2.printStackTrace();
            continue;
            if ((paramInt == 0) && (!bbdx.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ayrx.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString != null)) {
              if (bbdx.d(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ayrx.jdField_c_of_type_JavaLangString))
              {
                new File(this.jdField_a_of_type_JavaLangString).delete();
              }
              else
              {
                this.jdField_a_of_type_Aysz.a(1, 9301, "rename file failed", null);
                new File(this.jdField_a_of_type_JavaLangString).delete();
              }
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_Ayrx.jdField_c_of_type_JavaLangString != null) {}
    label427:
    label620:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Ayrx.jdField_a_of_type_Ayrz == null)
        {
          if (QLog.isColorLevel())
          {
            paramInt = this.jdField_a_of_type_Ayrx.g;
            if (this.jdField_a_of_type_Ayrx.jdField_a_of_type_Int != 1) {
              break label620;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ayuk.a(paramInt, bool, this.jdField_a_of_type_Ayrx.jdField_f_of_type_Int, this.jdField_a_of_type_Ayrx.e, "check", "writtenSize:" + this.jdField_a_of_type_Aysz.jdField_c_of_type_Long + " totalBlockLen:" + this.jdField_a_of_type_Aysz.jdField_b_of_type_Long);
            this.jdField_a_of_type_Aysz.a(1, -9527, null, null);
            parambbmu2 = aypb.a("Q", -9533L);
            this.jdField_a_of_type_Aysz.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", parambbmu2);
            this.jdField_a_of_type_Aysz.jdField_a_of_type_JavaLangString = ("recvSize:" + this.jdField_a_of_type_Aysz.jdField_c_of_type_Long + " totalBlockLen:" + this.jdField_a_of_type_Aysz.jdField_b_of_type_Long);
            break;
          }
        }
        this.jdField_a_of_type_Aysz.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Aysz.jdField_b_of_type_Int = 9058;
        this.jdField_a_of_type_Aysz.jdField_a_of_type_JavaLangString = "error data len ! ";
        QLog.d("T.Q.richmedia." + ayuk.b(this.jdField_a_of_type_Ayrx.g) + "." + ayuk.c(this.jdField_a_of_type_Ayrx.jdField_f_of_type_Int), 1, "id:" + String.valueOf(parambbmu1.jdField_a_of_type_JavaLangString) + "reqUrl:" + this.jdField_a_of_type_Ayrx.jdField_a_of_type_JavaLangString + ",reqHeader:" + parambbmu1.jdField_c_of_type_JavaLangString + "responseHeader:" + parambbmu2.jdField_d_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Aysz.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Aysz.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Aysz.jdField_a_of_type_JavaLangString = "";
    } while (((this.jdField_a_of_type_Aysz.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_Aysz.jdField_a_of_type_ArrayOfByte.length == this.jdField_a_of_type_Aysz.jdField_b_of_type_Long)) && ((this.jdField_a_of_type_Aysz.jdField_a_of_type_ArrayOfByte != null) || (this.jdField_a_of_type_Aysz.jdField_b_of_type_Long == 0L)));
    label777:
    this.jdField_a_of_type_Aysz.a(1, -9527, null, null);
    parambbmu2 = aypb.a("Q", -9533L);
    this.jdField_a_of_type_Aysz.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", parambbmu2);
    parambbmu2 = this.jdField_a_of_type_Aysz;
    StringBuilder localStringBuilder = new StringBuilder().append("recvSize:");
    if (this.jdField_a_of_type_Aysz.jdField_a_of_type_ArrayOfByte != null) {}
    for (paramInt = this.jdField_a_of_type_Aysz.jdField_a_of_type_ArrayOfByte.length;; paramInt = 0)
    {
      parambbmu2.jdField_a_of_type_JavaLangString = (paramInt + " totalBlockLen:" + this.jdField_a_of_type_Aysz.jdField_b_of_type_Long);
      break;
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_Int = ayta.a().a();
    Object localObject = this.jdField_a_of_type_Ayrx;
    aysz localaysz = this.jdField_a_of_type_Aysz;
    if ((localObject == null) || (localaysz == null))
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    label367:
    int i;
    if (((ayrx)localObject).jdField_c_of_type_JavaLangString != null)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaLangString = a(((ayrx)localObject).jdField_c_of_type_JavaLangString, ((ayrx)localObject).jdField_a_of_type_JavaLangString);
          localaysz.jdField_a_of_type_Aysy.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localFile = new File(this.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            break label367;
          }
          l = localFile.length();
          if ((l <= 0L) || (((ayrx)localObject).jdField_a_of_type_Aysb == null)) {
            continue;
          }
          localaysz.jdField_c_of_type_Long = l;
          ((ayrx)localObject).jdField_a_of_type_Aysb.a((aysy)localObject, localaysz);
          if (!((ayrx)localObject).i) {
            continue;
          }
          this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localFile, "rw");
          this.jdField_a_of_type_JavaIoRandomAccessFile.seek(((ayrx)localObject).jdField_a_of_type_Long);
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
          if (!((ayrx)localObject).i) {
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
          localObject = new URL(((ayrx)localObject).jdField_a_of_type_JavaLangString).getHost();
          localaysz.jdField_a_of_type_JavaUtilHashMap.put("firstserverip", localObject);
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
        i = ((ayrx)localObject).g;
        if (((ayrx)localObject).jdField_a_of_type_Int != 1) {
          break label485;
        }
      }
    }
    label485:
    for (boolean bool = true;; bool = false)
    {
      ayuk.a(i, bool, ((ayrx)localObject).jdField_f_of_type_Int, ((ayrx)localObject).e, "createtmp", this.jdField_a_of_type_JavaLangString);
      bbdx.a(this.jdField_a_of_type_JavaLangString);
      if (((ayrx)localObject).i)
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localIOException, "rw");
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(localIOException);
      break;
      if (((ayrx)localObject).jdField_a_of_type_JavaIoOutputStream == null) {
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = ((ayrx)localObject).jdField_a_of_type_JavaIoOutputStream;
      break;
    }
  }
  
  public void b(bbmu parambbmu1, bbmu parambbmu2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    ayrx localayrx;
    aysz localaysz;
    do
    {
      return;
      localayrx = this.jdField_a_of_type_Ayrx;
      localaysz = this.jdField_a_of_type_Aysz;
    } while ((localayrx == null) || (localaysz == null));
    a(parambbmu2);
    long l1 = System.currentTimeMillis() - localaysz.jdField_f_of_type_Long;
    localaysz.jdField_d_of_type_Long += l1;
    if ((localayrx.jdField_a_of_type_JavaUtilList != null) && (localayrx.jdField_a_of_type_JavaUtilList.size() >= 1)) {
      ((ayuq)localayrx.jdField_a_of_type_JavaUtilList.get(0)).a();
    }
    if ((ayta.a().a() != 0) && (!this.jdField_a_of_type_Boolean) && (localayrx.jdField_a_of_type_Aysd != null)) {
      localayrx.jdField_a_of_type_Aysd.a(localaysz);
    }
    long l2 = ayta.a().a();
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
      if ((localaysz.jdField_b_of_type_Int == 9056) && (l1 < 2000L))
      {
        i = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = (i - 1);
        if (i > 0)
        {
          if ((localaysz.jdField_b_of_type_Int == 9056) || (localaysz.jdField_b_of_type_Int == 9051)) {
            this.e += 1;
          }
          if (this.jdField_a_of_type_Boolean) {
            break label903;
          }
          localaysz.jdField_b_of_type_Int = parambbmu2.jdField_f_of_type_Int;
          localaysz.jdField_a_of_type_JavaLangString = parambbmu2.jdField_b_of_type_JavaLangString;
          localaysz.jdField_a_of_type_Int = 1;
          if (j == 0)
          {
            localaysz.jdField_b_of_type_Int = 9004;
            localaysz.jdField_a_of_type_JavaLangString = "no network";
            localaysz.jdField_a_of_type_Int = 1;
          }
          if ((l2 == this.jdField_d_of_type_Int) || (l2 == 0L) || (this.jdField_d_of_type_Int == 0L)) {
            break label908;
          }
          i = 1;
          if ((!localayrx.k) || (i == 0) || (!ayuc.a(parambbmu2.jdField_f_of_type_Int))) {
            break label913;
          }
          i = 1;
          if (i != 0)
          {
            localaysz.jdField_b_of_type_Int = 9364;
            localaysz.jdField_a_of_type_JavaLangString = "netchg";
            if (QLog.isColorLevel())
            {
              k = localayrx.g;
              if (localayrx.jdField_a_of_type_Int != 1) {
                break label918;
              }
              bool1 = true;
              ayuk.a(k, bool1, localayrx.jdField_f_of_type_Int, localayrx.e, "netChg", "originNet:" + this.jdField_d_of_type_Int + " cur:" + l2);
            }
          }
          if (this.jdField_b_of_type_Int <= 0) {
            break label924;
          }
          bool1 = true;
          label445:
          if ((this.jdField_a_of_type_Boolean) || (i != 0) || ((!parambbmu2.d()) && (!aytb.a(this.jdField_a_of_type_Aytb, parambbmu2, localayrx))) || (((localaysz.jdField_d_of_type_Long >= localayrx.jdField_c_of_type_Long - 5000L) || (this.jdField_a_of_type_Int > localayrx.jdField_c_of_type_Int)) && ((!bool1) || (localaysz.jdField_d_of_type_Long >= localayrx.jdField_c_of_type_Long * 3L / 2L - 5000L)))) {
            break label1314;
          }
          if (QLog.isColorLevel())
          {
            k = localayrx.g;
            if (localayrx.jdField_a_of_type_Int != 1) {
              break label930;
            }
            bool2 = true;
            label562:
            int m = localayrx.jdField_f_of_type_Int;
            String str = localayrx.e;
            StringBuilder localStringBuilder = new StringBuilder().append("tryTime:");
            if (this.jdField_a_of_type_Aysz == null) {
              break label936;
            }
            i = this.jdField_a_of_type_Aysz.jdField_d_of_type_Int;
            label606:
            localStringBuilder = localStringBuilder.append(i).append(" consumeTime:");
            if (this.jdField_a_of_type_Aysz == null) {
              break label941;
            }
            l1 = this.jdField_a_of_type_Aysz.jdField_d_of_type_Long;
            label636:
            ayuk.a(k, bool2, m, str, "retry", l1 + " isLastGetData:" + bool1);
          }
          k = 1;
          i = k;
          if (localaysz.jdField_c_of_type_Long > 0L)
          {
            if (!localayrx.c()) {
              break label952;
            }
            if (localayrx.jdField_a_of_type_Aysb == null) {
              break label947;
            }
            localayrx.jdField_a_of_type_Aysb.a(localayrx, localaysz);
            this.jdField_a_of_type_JavaIoOutputStream = localayrx.jdField_a_of_type_JavaIoOutputStream;
            i = k;
          }
          label729:
          k = i;
          if (localayrx.m)
          {
            k = i;
            if (parambbmu2.c() >= 400)
            {
              k = i;
              if (parambbmu2.c() < 500)
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
          bbdx.d(this.jdField_a_of_type_JavaLangString);
          k = i;
        }
        catch (Exception parambbmu2)
        {
          for (;;)
          {
            k = i;
          }
        }
        if (this.e >= localayrx.jdField_d_of_type_Int) {
          localayrx.jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
        }
        if (k == 0)
        {
          if (QLog.isColorLevel())
          {
            i = localayrx.g;
            if (localayrx.jdField_a_of_type_Int != 1) {
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
              ayuk.a(i, bool1, localayrx.jdField_f_of_type_Int, localayrx.e, "retry", "breakDownAllowRetry is false ");
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
              if (!localayrx.b()) {
                break label729;
              }
              if (localayrx.jdField_a_of_type_Aysb != null)
              {
                localayrx.jdField_a_of_type_Aysb.a(localayrx, localaysz);
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
                localaysz.jdField_c_of_type_Long = 0L;
                i = 1;
              }
              catch (IOException localIOException)
              {
                a(localIOException, localaysz);
                i = k;
              }
            }
            break label729;
          }
        }
        if (localayrx.jdField_a_of_type_Ayrz != null) {
          localayrx.jdField_a_of_type_Ayrz.a();
        }
        if (localayrx.jdField_a_of_type_Boolean)
        {
          if (localayrx.jdField_b_of_type_Boolean)
          {
            ayxg.a().a(ayxg.a(localayrx.jdField_a_of_type_JavaLangString), ayxg.a(parambbmu1.a()), 1002);
            localayrx.jdField_b_of_type_Boolean = false;
          }
          localayrx.jdField_a_of_type_Boolean = false;
        }
        if ((localayrx.jdField_a_of_type_JavaUtilList != null) && (localayrx.jdField_a_of_type_JavaUtilList.size() >= 1) && (j != 0))
        {
          parambbmu1 = (ayuq)localayrx.jdField_a_of_type_JavaUtilList.remove(0);
          localayrx.jdField_a_of_type_JavaUtilList.add(parambbmu1);
          parambbmu1 = (ayuq)localayrx.jdField_a_of_type_JavaUtilList.get(0);
          if (localayrx.jdField_a_of_type_JavaLangString != null)
          {
            parambbmu1 = parambbmu1.a(localayrx.jdField_a_of_type_JavaLangString);
            localayrx.jdField_a_of_type_JavaLangString = ayuk.a(localayrx.jdField_a_of_type_JavaLangString, parambbmu1);
          }
        }
        if ((localaysz.jdField_b_of_type_Int == 9050) && (localayrx.jdField_a_of_type_Ayui != null)) {
          localayrx.jdField_a_of_type_Ayui.a(this.jdField_a_of_type_Int);
        }
        if ((localaysz.jdField_b_of_type_Int == 9056) && (l2 != 0L)) {
          l1 = 0L;
        }
        for (;;)
        {
          a(l1, localayrx);
          return;
          if (l2 != 0L) {
            l1 = 3000L;
          } else {
            l1 = 6000L;
          }
        }
        label1314:
        c();
        return;
      }
      catch (Exception parambbmu2)
      {
        break label785;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aytc
 * JD-Core Version:    0.7.0.1
 */