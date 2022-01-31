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

public class ayta
  implements bbmi
{
  int jdField_a_of_type_Int = 0;
  public ayrv a;
  public aysx a;
  public bbmg a;
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
  
  public ayta(aysz paramaysz)
  {
    this.jdField_c_of_type_Int = 5;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(long paramLong, ayrv paramayrv)
  {
    int i;
    if ((QLog.isColorLevel()) && (paramayrv != null))
    {
      i = paramayrv.g;
      if (paramayrv.jdField_a_of_type_Int != 1) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      ayui.a(i, bool, paramayrv.jdField_f_of_type_Int, paramayrv.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_Aysx.jdField_f_of_type_Long = System.currentTimeMillis();
    if (aysy.a().a() != 0)
    {
      if ((this.jdField_a_of_type_Aysz.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramLong != 0L))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new OldHttpEngine.OldHttpCommunicatorListner.1(this, paramayrv), paramLong);
        return;
      }
      if ((QLog.isColorLevel()) && (paramayrv != null))
      {
        i = paramayrv.g;
        if (paramayrv.jdField_a_of_type_Int != 1) {
          break label227;
        }
      }
      label227:
      for (bool = true;; bool = false)
      {
        ayui.a(i, bool, paramayrv.jdField_f_of_type_Int, paramayrv.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
        this.jdField_a_of_type_Aysz.c(this.jdField_a_of_type_Ayrv);
        return;
      }
    }
    if (this.jdField_a_of_type_Aysz.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      ThreadManager.getTimer().schedule(new OldHttpEngine.OldHttpCommunicatorListner.2(this, paramayrv), paramLong);
      return;
    }
    if ((QLog.isColorLevel()) && (paramayrv != null))
    {
      i = paramayrv.g;
      if (paramayrv.jdField_a_of_type_Int != 1) {
        break label320;
      }
    }
    label320:
    for (bool = true;; bool = false)
    {
      ayui.a(i, bool, paramayrv.jdField_f_of_type_Int, paramayrv.e, "scheduleRetry", "mWorking is false");
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
    }
  }
  
  private boolean a(bbmg parambbmg)
  {
    return false;
  }
  
  private void c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    ayrv localayrv = this.jdField_a_of_type_Ayrv;
    aysx localaysx = this.jdField_a_of_type_Aysx;
    OutputStream localOutputStream;
    RandomAccessFile localRandomAccessFile;
    if (localayrv != null)
    {
      localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
      localRandomAccessFile = this.jdField_a_of_type_JavaIoRandomAccessFile;
      if ((localayrv.jdField_c_of_type_JavaLangString == null) || (localOutputStream == null)) {}
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
        if (localaysx != null)
        {
          if ((localayrv.jdField_f_of_type_JavaLangString != null) && (localaysx.jdField_a_of_type_Int != 3)) {
            aysz.a(this.jdField_a_of_type_Aysz).remove(localayrv.jdField_f_of_type_JavaLangString);
          }
          if (localayrv.jdField_a_of_type_Aysa != null)
          {
            if (QLog.isColorLevel())
            {
              int i = localayrv.g;
              if (localayrv.jdField_a_of_type_Int != 1) {
                break label246;
              }
              ayui.a(i, bool, localayrv.jdField_f_of_type_Int, localayrv.e, "onOutEngine", "result:" + localaysx.jdField_a_of_type_Int + " errCode:" + localaysx.jdField_b_of_type_Int + " desc:" + localaysx.jdField_a_of_type_JavaLangString);
            }
            if ((localaysx.jdField_b_of_type_Int == 9367) && (QLog.isColorLevel())) {
              break label251;
            }
            localayrv.jdField_a_of_type_Aysa.onResp(localaysx);
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
          axrb.a("Http_Download_Queen_Full", this.jdField_a_of_type_Aysz.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a());
        }
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = aysz.a(this.jdField_a_of_type_Ayrv, paramString1, paramString2);
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    ayrv localayrv = this.jdField_a_of_type_Ayrv;
    if (localayrv != null) {
      localayrv.jdField_a_of_type_JavaLangObject = null;
    }
    this.jdField_a_of_type_Ayrv = null;
    this.jdField_a_of_type_Aysx = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
  }
  
  void a(aysw paramaysw)
  {
    try
    {
      if ((paramaysw.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaIoOutputStream != null)) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {}
    }
    catch (IOException paramaysw)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaIoRandomAccessFile.close();
          return;
        }
        catch (IOException paramaysw)
        {
          paramaysw.printStackTrace();
        }
        paramaysw = paramaysw;
        paramaysw.printStackTrace();
      }
    }
  }
  
  void a(bbmg parambbmg)
  {
    aysx localaysx = this.jdField_a_of_type_Aysx;
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localaysx == null)) {
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = localaysx.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap2.containsKey("firstserverip")) {
      localHashMap1.put("firstserverip", localHashMap2.get("firstserverip"));
    }
    if (localHashMap2.containsKey("serverip")) {
      localHashMap1.put("serverip", localHashMap2.get("serverip"));
    }
    if (localHashMap2.containsKey("param_url")) {
      localHashMap1.put("param_url", localHashMap2.get("param_url"));
    }
    if (parambbmg.jdField_b_of_type_JavaUtilHashMap.containsKey(bbmg.jdField_f_of_type_JavaLangString)) {
      localHashMap1.put("netresp_param_reason", parambbmg.jdField_b_of_type_JavaUtilHashMap.get(bbmg.jdField_f_of_type_JavaLangString));
    }
    localaysx.jdField_a_of_type_JavaUtilHashMap.clear();
    localaysx.jdField_a_of_type_JavaUtilHashMap.putAll(localHashMap1);
    localaysx.jdField_a_of_type_JavaUtilHashMap.putAll(parambbmg.jdField_b_of_type_JavaUtilHashMap);
    localaysx.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", parambbmg.jdField_d_of_type_JavaLangString);
    localaysx.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", parambbmg.jdField_c_of_type_JavaLangString);
    localaysx.jdField_c_of_type_Int = parambbmg.c();
  }
  
  public void a(bbmg parambbmg1, bbmg parambbmg2)
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
        } while (this.jdField_a_of_type_Ayrv == null);
        Object localObject1;
        int i;
        for (;;)
        {
          for (;;)
          {
            try
            {
              if ((parambbmg2.c() != 206) && (parambbmg2.c() != 200)) {
                break;
              }
              parambbmg1 = parambbmg2.a();
              localObject2 = this.jdField_a_of_type_Ayrv.jdField_a_of_type_Ayrx;
              localObject1 = parambbmg1;
              if (localObject2 == null) {}
            }
            catch (IOException parambbmg1)
            {
              parambbmg1.printStackTrace();
              this.jdField_a_of_type_Boolean = true;
              a(parambbmg1, this.jdField_a_of_type_Aysx);
              throw new RuntimeException("io exceptionmsg:" + parambbmg1.getMessage());
            }
            try
            {
              localObject1 = this.jdField_a_of_type_Ayrv.jdField_a_of_type_Ayrx.a(parambbmg1);
              if (localObject1 == null) {
                break;
              }
              i = localObject1.length;
              if (i <= 0) {
                break;
              }
              parambbmg1 = (bbmg)localObject1;
              if (localObject1.length <= 0) {
                break label598;
              }
              parambbmg1 = (bbmg)localObject1;
              if (this.jdField_a_of_type_Ayrv.jdField_a_of_type_Ayrw == null) {
                break label598;
              }
              l1 = System.nanoTime();
              i = 1;
              parambbmg1 = null;
            }
            catch (Throwable parambbmg1)
            {
              parambbmg1 = Log.getStackTraceString(parambbmg1);
              throw new RuntimeException("FlowDecoderExp:" + parambbmg1.substring(0, Math.min(100, parambbmg1.length())));
            }
          }
          try
          {
            localObject2 = Cipher.getInstance("AES/ECB/NoPadding");
            ((Cipher)localObject2).init(2, new SecretKeySpec(this.jdField_a_of_type_Ayrv.jdField_a_of_type_Ayrw.jdField_a_of_type_ArrayOfByte, "AES"));
            if (localObject1.length % 16 != 0) {
              break label309;
            }
            localObject2 = ((Cipher)localObject2).doFinal((byte[])localObject1);
            localObject1 = localObject2;
          }
          catch (NoSuchAlgorithmException parambbmg1)
          {
            int j;
            byte[] arrayOfByte;
            parambbmg1 = Log.getStackTraceString(parambbmg1);
            i = 0;
            continue;
            if (!QLog.isColorLevel()) {
              break label470;
            }
            QLog.e("Q.richmedia.OldHttpEngine", 2, "padding erro,recLen =" + localObject1.length + " writeLen=" + this.jdField_a_of_type_Aysx.jdField_c_of_type_Long + " totalLen=" + parambbmg2.a());
            parambbmg1 = "padding erro,recLen =" + localObject1.length + " writeLen=" + this.jdField_a_of_type_Aysx.jdField_c_of_type_Long + " totalLen=" + parambbmg2.a();
            i = 0;
            continue;
          }
          catch (NoSuchPaddingException parambbmg1)
          {
            parambbmg1 = Log.getStackTraceString(parambbmg1);
            i = 0;
            continue;
          }
          catch (InvalidKeyException parambbmg1)
          {
            parambbmg1 = Log.getStackTraceString(parambbmg1);
            i = 0;
            continue;
          }
          catch (IllegalBlockSizeException parambbmg1)
          {
            parambbmg1 = Log.getStackTraceString(parambbmg1);
            i = 0;
            continue;
          }
          catch (BadPaddingException parambbmg1)
          {
            parambbmg1 = Log.getStackTraceString(parambbmg1);
            i = 0;
            continue;
            long l2 = System.nanoTime();
            parambbmg1 = this.jdField_a_of_type_Aysx;
            parambbmg1.j = (l2 - l1 + parambbmg1.j);
            parambbmg1 = (bbmg)localObject1;
          }
          if (i != 0) {
            break label571;
          }
          throw new RuntimeException("DecryptError:" + parambbmg1);
          if ((parambbmg2.a() <= 0L) || (localObject1.length + this.jdField_a_of_type_Aysx.jdField_c_of_type_Long != parambbmg2.a())) {
            break label406;
          }
          j = localObject1.length % 16;
          arrayOfByte = new byte[localObject1.length - j];
          System.arraycopy(localObject1, 0, arrayOfByte, 0, localObject1.length - j);
          Object localObject2 = ((Cipher)localObject2).doFinal(arrayOfByte);
          System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
        }
        this.jdField_b_of_type_Int += parambbmg1.length;
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break;
        }
        this.jdField_a_of_type_JavaIoOutputStream.write(parambbmg1);
        this.jdField_a_of_type_JavaIoOutputStream.flush();
        this.jdField_a_of_type_Aysx.jdField_a_of_type_Long = parambbmg2.a();
        this.jdField_a_of_type_Aysx.jdField_b_of_type_Long = parambbmg2.jdField_b_of_type_Long;
        parambbmg2 = this.jdField_a_of_type_Aysx;
        l1 = parambbmg2.jdField_c_of_type_Long;
        parambbmg2.jdField_c_of_type_Long = (parambbmg1.length + l1);
      } while (this.jdField_a_of_type_Ayrv.jdField_a_of_type_Aysa == null);
      this.jdField_a_of_type_Ayrv.jdField_a_of_type_Aysa.onUpdateProgeress(this.jdField_a_of_type_Ayrv, this.jdField_a_of_type_Aysx.jdField_c_of_type_Long + this.jdField_a_of_type_Ayrv.jdField_a_of_type_Long, this.jdField_a_of_type_Aysx.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
        break;
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile.length() == 0L) {
        this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(parambbmg2.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_JavaIoRandomAccessFile.write(parambbmg1);
      this.jdField_a_of_type_Aysx.jdField_a_of_type_Long = parambbmg2.a();
      this.jdField_a_of_type_Aysx.jdField_b_of_type_Long = parambbmg2.jdField_b_of_type_Long;
      parambbmg2 = this.jdField_a_of_type_Aysx;
      long l1 = parambbmg2.jdField_c_of_type_Long;
      parambbmg2.jdField_c_of_type_Long = (parambbmg1.length + l1);
    } while (this.jdField_a_of_type_Ayrv.jdField_a_of_type_Aysa == null);
    label406:
    label571:
    this.jdField_a_of_type_Ayrv.jdField_a_of_type_Aysa.onUpdateProgeress(this.jdField_a_of_type_Ayrv, this.jdField_a_of_type_Aysx.jdField_c_of_type_Long + this.jdField_a_of_type_Ayrv.jdField_a_of_type_Long, this.jdField_a_of_type_Aysx.jdField_a_of_type_Long);
    return;
    this.jdField_a_of_type_Aysx.jdField_a_of_type_Long = parambbmg2.a();
    this.jdField_a_of_type_Aysx.jdField_b_of_type_Long = parambbmg2.jdField_b_of_type_Long;
    this.jdField_a_of_type_Aysx.jdField_a_of_type_ArrayOfByte = parambbmg2.a();
  }
  
  void a(IOException paramIOException, aysx paramaysx)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      return;
      paramaysx = paramIOException.getMessage();
      this.jdField_a_of_type_Aysx.a(1, 9301, paramaysx + MsfSdkUtils.getStackTraceString(paramIOException), null);
      try
      {
        paramIOException = Environment.getExternalStorageState();
        if (paramaysx.contains("EACCES"))
        {
          this.jdField_a_of_type_Aysx.jdField_b_of_type_Int = 9039;
          return;
        }
      }
      catch (Exception paramIOException)
      {
        paramIOException.printStackTrace();
        return;
      }
      if ((paramaysx.contains("ENOSPC")) || (paramaysx.contains("space")))
      {
        long l = bbbd.b();
        if (this.jdField_a_of_type_Ayrv != null)
        {
          paramIOException = this.jdField_a_of_type_Ayrv.jdField_c_of_type_JavaLangString;
          paramaysx = new File(paramIOException).getParentFile();
          QLog.e("Q.richmedia.OldHttpEngine", 1, "no space error, outPath:" + paramIOException + ",fileCount:" + paramaysx.listFiles().length + ",url:" + this.jdField_a_of_type_Ayrv.jdField_a_of_type_JavaLangString + ",availableSpace:" + l);
        }
        this.jdField_a_of_type_Aysx.jdField_b_of_type_Int = 9040;
        return;
      }
      if (paramaysx.contains("Read-only"))
      {
        this.jdField_a_of_type_Aysx.jdField_b_of_type_Int = 9039;
        return;
      }
    } while ("mounted".equals(paramIOException));
    this.jdField_a_of_type_Aysx.jdField_b_of_type_Int = 9039;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Aysx != null) && (this.jdField_a_of_type_Bbmg != null))
    {
      this.jdField_a_of_type_Aysx.g = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Bbmg.jdField_d_of_type_Long);
      paramString = this.jdField_a_of_type_Aysx;
      paramString.e += 1;
    }
  }
  
  public boolean a(bbmg parambbmg1, bbmg parambbmg2, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return true;
    }
    if (paramInt == 5)
    {
      a(parambbmg2);
      if (!this.jdField_a_of_type_Ayrv.a()) {
        break label777;
      }
      if ((a(parambbmg2)) && (this.jdField_a_of_type_Aysx.jdField_c_of_type_Long != this.jdField_a_of_type_Aysx.jdField_b_of_type_Long) && ((this.jdField_a_of_type_Ayrv.jdField_a_of_type_Ayrx == null) || (!this.jdField_a_of_type_Ayrv.jdField_a_of_type_Ayrx.a()))) {
        break label427;
      }
      this.jdField_a_of_type_Aysx.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Aysx.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Aysx.jdField_a_of_type_JavaLangString = "";
      int i = 0;
      paramInt = i;
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        paramInt = i;
        if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Ayrv.jdField_c_of_type_JavaLangString)) {
          paramInt = 1;
        }
      }
      if (this.jdField_a_of_type_Ayrv.jdField_c_of_type_JavaLangString == null) {}
    }
    try
    {
      if ((this.jdField_a_of_type_Ayrv.j) && (paramInt == 0) && (bbdj.a(this.jdField_a_of_type_Ayrv.jdField_c_of_type_JavaLangString))) {
        bbdj.d(this.jdField_a_of_type_Ayrv.jdField_c_of_type_JavaLangString);
      }
    }
    catch (Exception parambbmg2)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break label216;
        }
        this.jdField_a_of_type_JavaIoOutputStream.close();
        label216:
        if (!this.jdField_a_of_type_Ayrv.i) {
          break label240;
        }
      }
      catch (IOException parambbmg2)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_JavaIoRandomAccessFile != null) {
              this.jdField_a_of_type_JavaIoRandomAccessFile.close();
            }
            label240:
            if (this.jdField_a_of_type_Ayrv.j) {
              break;
            }
            if (parambbmg1.e != 0L) {
              this.jdField_a_of_type_Aysx.h = parambbmg1.e;
            }
            this.jdField_a_of_type_Aysx.i = parambbmg1.h;
            if (parambbmg1.jdField_f_of_type_Long != 0L) {
              this.jdField_a_of_type_Aysx.j = parambbmg1.jdField_f_of_type_Long;
            }
            c();
            return true;
            parambbmg2 = parambbmg2;
            parambbmg2.printStackTrace();
          }
          parambbmg2 = parambbmg2;
          parambbmg2.printStackTrace();
        }
        catch (IOException parambbmg2)
        {
          for (;;)
          {
            parambbmg2.printStackTrace();
            continue;
            if ((paramInt == 0) && (!bbdj.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ayrv.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString != null)) {
              if (bbdj.d(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ayrv.jdField_c_of_type_JavaLangString))
              {
                new File(this.jdField_a_of_type_JavaLangString).delete();
              }
              else
              {
                this.jdField_a_of_type_Aysx.a(1, 9301, "rename file failed", null);
                new File(this.jdField_a_of_type_JavaLangString).delete();
              }
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_Ayrv.jdField_c_of_type_JavaLangString != null) {}
    label427:
    label620:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Ayrv.jdField_a_of_type_Ayrx == null)
        {
          if (QLog.isColorLevel())
          {
            paramInt = this.jdField_a_of_type_Ayrv.g;
            if (this.jdField_a_of_type_Ayrv.jdField_a_of_type_Int != 1) {
              break label620;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ayui.a(paramInt, bool, this.jdField_a_of_type_Ayrv.jdField_f_of_type_Int, this.jdField_a_of_type_Ayrv.e, "check", "writtenSize:" + this.jdField_a_of_type_Aysx.jdField_c_of_type_Long + " totalBlockLen:" + this.jdField_a_of_type_Aysx.jdField_b_of_type_Long);
            this.jdField_a_of_type_Aysx.a(1, -9527, null, null);
            parambbmg2 = ayoz.a("Q", -9533L);
            this.jdField_a_of_type_Aysx.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", parambbmg2);
            this.jdField_a_of_type_Aysx.jdField_a_of_type_JavaLangString = ("recvSize:" + this.jdField_a_of_type_Aysx.jdField_c_of_type_Long + " totalBlockLen:" + this.jdField_a_of_type_Aysx.jdField_b_of_type_Long);
            break;
          }
        }
        this.jdField_a_of_type_Aysx.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Aysx.jdField_b_of_type_Int = 9058;
        this.jdField_a_of_type_Aysx.jdField_a_of_type_JavaLangString = "error data len ! ";
        QLog.d("T.Q.richmedia." + ayui.b(this.jdField_a_of_type_Ayrv.g) + "." + ayui.c(this.jdField_a_of_type_Ayrv.jdField_f_of_type_Int), 1, "id:" + String.valueOf(parambbmg1.jdField_a_of_type_JavaLangString) + "reqUrl:" + this.jdField_a_of_type_Ayrv.jdField_a_of_type_JavaLangString + ",reqHeader:" + parambbmg1.jdField_c_of_type_JavaLangString + "responseHeader:" + parambbmg2.jdField_d_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Aysx.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Aysx.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Aysx.jdField_a_of_type_JavaLangString = "";
    } while (((this.jdField_a_of_type_Aysx.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_Aysx.jdField_a_of_type_ArrayOfByte.length == this.jdField_a_of_type_Aysx.jdField_b_of_type_Long)) && ((this.jdField_a_of_type_Aysx.jdField_a_of_type_ArrayOfByte != null) || (this.jdField_a_of_type_Aysx.jdField_b_of_type_Long == 0L)));
    label777:
    this.jdField_a_of_type_Aysx.a(1, -9527, null, null);
    parambbmg2 = ayoz.a("Q", -9533L);
    this.jdField_a_of_type_Aysx.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", parambbmg2);
    parambbmg2 = this.jdField_a_of_type_Aysx;
    StringBuilder localStringBuilder = new StringBuilder().append("recvSize:");
    if (this.jdField_a_of_type_Aysx.jdField_a_of_type_ArrayOfByte != null) {}
    for (paramInt = this.jdField_a_of_type_Aysx.jdField_a_of_type_ArrayOfByte.length;; paramInt = 0)
    {
      parambbmg2.jdField_a_of_type_JavaLangString = (paramInt + " totalBlockLen:" + this.jdField_a_of_type_Aysx.jdField_b_of_type_Long);
      break;
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_Int = aysy.a().a();
    Object localObject = this.jdField_a_of_type_Ayrv;
    aysx localaysx = this.jdField_a_of_type_Aysx;
    if ((localObject == null) || (localaysx == null))
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    label367:
    int i;
    if (((ayrv)localObject).jdField_c_of_type_JavaLangString != null)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaLangString = a(((ayrv)localObject).jdField_c_of_type_JavaLangString, ((ayrv)localObject).jdField_a_of_type_JavaLangString);
          localaysx.jdField_a_of_type_Aysw.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localFile = new File(this.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            break label367;
          }
          l = localFile.length();
          if ((l <= 0L) || (((ayrv)localObject).jdField_a_of_type_Ayrz == null)) {
            continue;
          }
          localaysx.jdField_c_of_type_Long = l;
          ((ayrv)localObject).jdField_a_of_type_Ayrz.a((aysw)localObject, localaysx);
          if (!((ayrv)localObject).i) {
            continue;
          }
          this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localFile, "rw");
          this.jdField_a_of_type_JavaIoRandomAccessFile.seek(((ayrv)localObject).jdField_a_of_type_Long);
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
          if (!((ayrv)localObject).i) {
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
          localObject = new URL(((ayrv)localObject).jdField_a_of_type_JavaLangString).getHost();
          localaysx.jdField_a_of_type_JavaUtilHashMap.put("firstserverip", localObject);
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
        i = ((ayrv)localObject).g;
        if (((ayrv)localObject).jdField_a_of_type_Int != 1) {
          break label485;
        }
      }
    }
    label485:
    for (boolean bool = true;; bool = false)
    {
      ayui.a(i, bool, ((ayrv)localObject).jdField_f_of_type_Int, ((ayrv)localObject).e, "createtmp", this.jdField_a_of_type_JavaLangString);
      bbdj.a(this.jdField_a_of_type_JavaLangString);
      if (((ayrv)localObject).i)
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localIOException, "rw");
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(localIOException);
      break;
      if (((ayrv)localObject).jdField_a_of_type_JavaIoOutputStream == null) {
        break;
      }
      this.jdField_a_of_type_JavaIoOutputStream = ((ayrv)localObject).jdField_a_of_type_JavaIoOutputStream;
      break;
    }
  }
  
  public void b(bbmg parambbmg1, bbmg parambbmg2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    ayrv localayrv;
    aysx localaysx;
    do
    {
      return;
      localayrv = this.jdField_a_of_type_Ayrv;
      localaysx = this.jdField_a_of_type_Aysx;
    } while ((localayrv == null) || (localaysx == null));
    a(parambbmg2);
    long l1 = System.currentTimeMillis() - localaysx.jdField_f_of_type_Long;
    localaysx.jdField_d_of_type_Long += l1;
    if ((localayrv.jdField_a_of_type_JavaUtilList != null) && (localayrv.jdField_a_of_type_JavaUtilList.size() >= 1)) {
      ((ayuo)localayrv.jdField_a_of_type_JavaUtilList.get(0)).a();
    }
    if ((aysy.a().a() != 0) && (!this.jdField_a_of_type_Boolean) && (localayrv.jdField_a_of_type_Aysb != null)) {
      localayrv.jdField_a_of_type_Aysb.a(localaysx);
    }
    long l2 = aysy.a().a();
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
      if ((localaysx.jdField_b_of_type_Int == 9056) && (l1 < 2000L))
      {
        i = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = (i - 1);
        if (i > 0)
        {
          if ((localaysx.jdField_b_of_type_Int == 9056) || (localaysx.jdField_b_of_type_Int == 9051)) {
            this.e += 1;
          }
          if (this.jdField_a_of_type_Boolean) {
            break label903;
          }
          localaysx.jdField_b_of_type_Int = parambbmg2.jdField_f_of_type_Int;
          localaysx.jdField_a_of_type_JavaLangString = parambbmg2.jdField_b_of_type_JavaLangString;
          localaysx.jdField_a_of_type_Int = 1;
          if (j == 0)
          {
            localaysx.jdField_b_of_type_Int = 9004;
            localaysx.jdField_a_of_type_JavaLangString = "no network";
            localaysx.jdField_a_of_type_Int = 1;
          }
          if ((l2 == this.jdField_d_of_type_Int) || (l2 == 0L) || (this.jdField_d_of_type_Int == 0L)) {
            break label908;
          }
          i = 1;
          if ((!localayrv.k) || (i == 0) || (!ayua.a(parambbmg2.jdField_f_of_type_Int))) {
            break label913;
          }
          i = 1;
          if (i != 0)
          {
            localaysx.jdField_b_of_type_Int = 9364;
            localaysx.jdField_a_of_type_JavaLangString = "netchg";
            if (QLog.isColorLevel())
            {
              k = localayrv.g;
              if (localayrv.jdField_a_of_type_Int != 1) {
                break label918;
              }
              bool1 = true;
              ayui.a(k, bool1, localayrv.jdField_f_of_type_Int, localayrv.e, "netChg", "originNet:" + this.jdField_d_of_type_Int + " cur:" + l2);
            }
          }
          if (this.jdField_b_of_type_Int <= 0) {
            break label924;
          }
          bool1 = true;
          label445:
          if ((this.jdField_a_of_type_Boolean) || (i != 0) || ((!parambbmg2.d()) && (!aysz.a(this.jdField_a_of_type_Aysz, parambbmg2, localayrv))) || (((localaysx.jdField_d_of_type_Long >= localayrv.jdField_c_of_type_Long - 5000L) || (this.jdField_a_of_type_Int > localayrv.jdField_c_of_type_Int)) && ((!bool1) || (localaysx.jdField_d_of_type_Long >= localayrv.jdField_c_of_type_Long * 3L / 2L - 5000L)))) {
            break label1314;
          }
          if (QLog.isColorLevel())
          {
            k = localayrv.g;
            if (localayrv.jdField_a_of_type_Int != 1) {
              break label930;
            }
            bool2 = true;
            label562:
            int m = localayrv.jdField_f_of_type_Int;
            String str = localayrv.e;
            StringBuilder localStringBuilder = new StringBuilder().append("tryTime:");
            if (this.jdField_a_of_type_Aysx == null) {
              break label936;
            }
            i = this.jdField_a_of_type_Aysx.jdField_d_of_type_Int;
            label606:
            localStringBuilder = localStringBuilder.append(i).append(" consumeTime:");
            if (this.jdField_a_of_type_Aysx == null) {
              break label941;
            }
            l1 = this.jdField_a_of_type_Aysx.jdField_d_of_type_Long;
            label636:
            ayui.a(k, bool2, m, str, "retry", l1 + " isLastGetData:" + bool1);
          }
          k = 1;
          i = k;
          if (localaysx.jdField_c_of_type_Long > 0L)
          {
            if (!localayrv.c()) {
              break label952;
            }
            if (localayrv.jdField_a_of_type_Ayrz == null) {
              break label947;
            }
            localayrv.jdField_a_of_type_Ayrz.a(localayrv, localaysx);
            this.jdField_a_of_type_JavaIoOutputStream = localayrv.jdField_a_of_type_JavaIoOutputStream;
            i = k;
          }
          label729:
          k = i;
          if (localayrv.m)
          {
            k = i;
            if (parambbmg2.c() >= 400)
            {
              k = i;
              if (parambbmg2.c() < 500)
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
          bbdj.d(this.jdField_a_of_type_JavaLangString);
          k = i;
        }
        catch (Exception parambbmg2)
        {
          for (;;)
          {
            k = i;
          }
        }
        if (this.e >= localayrv.jdField_d_of_type_Int) {
          localayrv.jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
        }
        if (k == 0)
        {
          if (QLog.isColorLevel())
          {
            i = localayrv.g;
            if (localayrv.jdField_a_of_type_Int != 1) {
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
              ayui.a(i, bool1, localayrv.jdField_f_of_type_Int, localayrv.e, "retry", "breakDownAllowRetry is false ");
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
              if (!localayrv.b()) {
                break label729;
              }
              if (localayrv.jdField_a_of_type_Ayrz != null)
              {
                localayrv.jdField_a_of_type_Ayrz.a(localayrv, localaysx);
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
                localaysx.jdField_c_of_type_Long = 0L;
                i = 1;
              }
              catch (IOException localIOException)
              {
                a(localIOException, localaysx);
                i = k;
              }
            }
            break label729;
          }
        }
        if (localayrv.jdField_a_of_type_Ayrx != null) {
          localayrv.jdField_a_of_type_Ayrx.a();
        }
        if (localayrv.jdField_a_of_type_Boolean)
        {
          if (localayrv.jdField_b_of_type_Boolean)
          {
            ayxe.a().a(ayxe.a(localayrv.jdField_a_of_type_JavaLangString), ayxe.a(parambbmg1.a()), 1002);
            localayrv.jdField_b_of_type_Boolean = false;
          }
          localayrv.jdField_a_of_type_Boolean = false;
        }
        if ((localayrv.jdField_a_of_type_JavaUtilList != null) && (localayrv.jdField_a_of_type_JavaUtilList.size() >= 1) && (j != 0))
        {
          parambbmg1 = (ayuo)localayrv.jdField_a_of_type_JavaUtilList.remove(0);
          localayrv.jdField_a_of_type_JavaUtilList.add(parambbmg1);
          parambbmg1 = (ayuo)localayrv.jdField_a_of_type_JavaUtilList.get(0);
          if (localayrv.jdField_a_of_type_JavaLangString != null)
          {
            parambbmg1 = parambbmg1.a(localayrv.jdField_a_of_type_JavaLangString);
            localayrv.jdField_a_of_type_JavaLangString = ayui.a(localayrv.jdField_a_of_type_JavaLangString, parambbmg1);
          }
        }
        if ((localaysx.jdField_b_of_type_Int == 9050) && (localayrv.jdField_a_of_type_Ayug != null)) {
          localayrv.jdField_a_of_type_Ayug.a(this.jdField_a_of_type_Int);
        }
        if ((localaysx.jdField_b_of_type_Int == 9056) && (l2 != 0L)) {
          l1 = 0L;
        }
        for (;;)
        {
          a(l1, localayrv);
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
      catch (Exception parambbmg2)
      {
        break label785;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayta
 * JD-Core Version:    0.7.0.1
 */