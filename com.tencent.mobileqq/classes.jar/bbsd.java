import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader.1;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

public class bbsd
  implements bbqy, bbrt, bbru
{
  protected int a;
  protected long a;
  protected final bbqx a;
  protected bbrs a;
  protected bbrv a;
  protected FileOutputStream a;
  protected String a;
  public boolean a;
  protected int b;
  public final long b;
  protected String b;
  protected boolean b;
  protected long c;
  protected String c;
  private boolean c;
  protected long d;
  protected String d;
  protected long e;
  protected long f;
  
  protected bbsd(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_c_of_type_Long = paramLong2;
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Bbqx = new bbqx(paramQQAppInterface, paramList, paramString2, this.jdField_b_of_type_Long, paramBoolean, this);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bbqx.a();
    paramString1 = bbra.a(this.jdField_a_of_type_JavaLangString);
    if (paramString1 != null)
    {
      this.jdField_b_of_type_JavaLangString = paramString1.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Int = paramString1.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramString1.jdField_b_of_type_Int;
    }
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Bbrs = new bbrs(paramQQAppInterface, paramLong1, 1, 0, paramLong2, paramBoolean, paramString4);
    this.jdField_a_of_type_Bbrs.a(this);
  }
  
  public static bbru a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    String str = "";
    if (paramString1 == null) {
      str = "strSavePath is null";
    }
    while (!TextUtils.isEmpty(str))
    {
      bbrc.a("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "getFileDownloader " + str);
      return null;
      if (paramString1.length() == 0) {
        str = "strSavePath is empty";
      } else if (paramList == null) {
        str = "lstUrl is null";
      } else if (paramList.size() == 0) {
        str = "lstUrl is empty";
      } else if (paramString2 == null) {
        str = "urlParams is null";
      } else if (paramString2.length() == 0) {
        str = "urlParams is empty";
      }
    }
    return new bbsd(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean, paramString4);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    bbrc.c("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] reDownload mstrUrl:" + this.jdField_a_of_type_JavaLangString);
    g();
    if (this.jdField_a_of_type_Bbrv != null) {
      this.jdField_a_of_type_Bbrv.d();
    }
    this.jdField_d_of_type_Long = arni.a(this.jdField_d_of_type_JavaLangString);
    if (!bdee.g(BaseApplication.getContext()))
    {
      a(true, 9004, "no net work", "");
      return;
    }
    d();
  }
  
  public void a() {}
  
  public void a(int paramInt, String paramString1, String paramString2, bdlo parambdlo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramString1.indexOf("-29602") > 0)
    {
      a(true, -29602, paramString1, paramString2);
      return;
    }
    if ((parambdlo != null) && (parambdlo.a != null))
    {
      parambdlo = parambdlo.a.getHeaderField("User-ReturnCode");
      if ((!TextUtils.isEmpty(parambdlo)) && ((parambdlo.equals("-441")) || (parambdlo.equals("-443")) || (parambdlo.equals("-447")) || (parambdlo.equals("-29224")) || (parambdlo.equals("-31717"))))
      {
        a(true, -5003, paramString1, paramString2);
        return;
      }
    }
    if ((paramString1.indexOf("-6101") > 0) || (paramString1.indexOf("-7003") > 0) || (paramString1.indexOf("-403") > 0) || (paramString1.indexOf("-9006") > 0) || (paramString1.indexOf("-9004") > 0) || (paramString1.indexOf("-9017") > 0) || (paramString1.indexOf("-29150") > 0) || (paramString1.indexOf("-28137") > 0))
    {
      a(true, 9042, paramString1, paramString2);
      return;
    }
    if (("content zero".equalsIgnoreCase(paramString1)) && (paramString2 != null) && (paramString2.indexOf("-31713") > 0))
    {
      a(true, 9042, paramString1, paramString2);
      return;
    }
    if (paramString1.contains("SSLPeerUnverifiedException"))
    {
      a(true, paramInt, paramString1, paramString2);
      return;
    }
    if ((paramString1.indexOf("-29120") > 0) || (paramString1.indexOf("-502") > 0) || (paramString1.indexOf("HTTP_PROXY_AUTH") > 0) || (paramString1.indexOf("-21122") > 0) || (paramString1.indexOf("-28123") > 0) || (paramString1.indexOf("-25081") > 0) || (paramString1.indexOf("-28126") > 0)) {
      paramInt = 9042;
    }
    for (boolean bool = true;; bool = false)
    {
      if (!bdee.d(BaseApplication.getContext()))
      {
        a(true, 9004, paramString1, paramString2);
        return;
      }
      this.jdField_c_of_type_Boolean = false;
      bbrc.a("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] onErr errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
      if (this.jdField_a_of_type_Bbqx.a(this.jdField_a_of_type_JavaLangString, paramInt, bool))
      {
        a(false, paramInt, paramString1, paramString2);
        return;
      }
      a(true, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public void a(bbrv parambbrv)
  {
    this.jdField_a_of_type_Bbrv = parambbrv;
  }
  
  public void a(bdlo parambdlo) {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(true, 9062, "net redirect", "");
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    long l = 0L;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      f();
      e();
      l = System.currentTimeMillis();
    }
    int i = bbrc.jdField_a_of_type_Int;
    StringBuilder localStringBuilder = new StringBuilder().append("[").append(this.jdField_b_of_type_Long).append("] onErr errCode:").append(paramInt).append(" bFinished:").append(paramBoolean).append(" errMsg:").append(paramString1).append(" rspHeader:").append(paramString2).append(" cost:");
    if (paramBoolean) {}
    for (Object localObject = Long.valueOf(l - this.jdField_a_of_type_Long);; localObject = "")
    {
      bbrc.a("TroopFileDownloader", i, localObject);
      if (this.jdField_a_of_type_Bbrv != null) {
        this.jdField_a_of_type_Bbrv.a(paramBoolean, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2, new Bundle());
      }
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_c_of_type_Long == 0L) && (paramLong != 0L))
          {
            bbrc.c("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] onData getted filesize=" + paramLong);
            this.jdField_c_of_type_Long = paramLong;
          }
        } while ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0));
        try
        {
          this.jdField_a_of_type_JavaIoFileOutputStream.write(paramArrayOfByte);
          paramLong = paramArrayOfByte.length;
          this.jdField_d_of_type_Long += paramLong;
          this.f = (paramLong + this.f);
          if (!this.jdField_c_of_type_Boolean)
          {
            this.jdField_c_of_type_Boolean = true;
            this.jdField_a_of_type_Bbqx.a(this.jdField_a_of_type_JavaLangString);
          }
          if (this.jdField_d_of_type_Long == this.jdField_c_of_type_Long)
          {
            h();
            return;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          if (paramArrayOfByte.getMessage().contains("ENOSPC")) {}
          a(true, 9301, "write exception", paramString);
          return;
        }
        if (this.jdField_d_of_type_Long > this.jdField_c_of_type_Long)
        {
          a(true, -5001, "transfersize > filesize", paramString);
          return;
        }
      } while (!this.jdField_b_of_type_Boolean);
      paramLong = System.currentTimeMillis();
    } while (((this.e != 0L) && (paramLong - this.e < 1000L)) || (this.jdField_a_of_type_Bbrv == null));
    this.jdField_a_of_type_Bbrv.a(this.jdField_d_of_type_Long, this.jdField_c_of_type_Long);
  }
  
  public boolean a()
  {
    if (!bfel.a())
    {
      a(true, 9039, "no sdcard", null);
      return true;
    }
    VFSFile localVFSFile = new VFSFile(this.jdField_d_of_type_JavaLangString);
    if (!localVFSFile.exists()) {}
    try
    {
      localVFSFile.createNewFile();
      this.jdField_d_of_type_Long = arni.a(this.jdField_d_of_type_JavaLangString);
      if (this.jdField_c_of_type_Long == 0L)
      {
        bbrc.b("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] checkexcpover fileSize=0");
        return false;
      }
    }
    catch (IOException localIOException)
    {
      a(true, -5000, "create new file excption", null);
      return true;
    }
    if (this.jdField_d_of_type_Long > this.jdField_c_of_type_Long)
    {
      new VFSFile(this.jdField_d_of_type_JavaLangString).delete();
      this.jdField_d_of_type_Long = 0L;
    }
    long l1;
    long l2;
    do
    {
      return false;
      if (this.jdField_d_of_type_Long == this.jdField_c_of_type_Long)
      {
        bbrc.c("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] checkexcpover tmpfilesize=filesize");
        h();
        return true;
      }
      l1 = this.jdField_c_of_type_Long;
      l2 = this.jdField_d_of_type_Long;
    } while (armo.a().a() >= l1 - l2);
    a(true, 9040, "no enugh space", null);
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Bbqx.a();
  }
  
  public long b()
  {
    return 100L;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    bbrc.c("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] download");
    ThreadManager.post(new TroopFileDownloader.1(this), 8, null, false);
  }
  
  public void b(bdlo parambdlo)
  {
    parambdlo.a("User-Agent", "TroopFile");
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      parambdlo.a("Cookie", "FTN5K=" + this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bbrc.c("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] onRetry but stoped");
      return;
    }
    int i = 0;
    if (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))
    {
      i = 1;
      bbrc.c("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] onRetry urlChanged");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (i != 0)
    {
      paramString = bbra.a(this.jdField_a_of_type_JavaLangString);
      if (paramString != null)
      {
        this.jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Int = paramString.jdField_a_of_type_Int;
        this.jdField_b_of_type_Int = paramString.jdField_b_of_type_Int;
      }
      this.jdField_a_of_type_Bbrv.b(this.jdField_a_of_type_JavaLangString);
    }
    i();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bbqx.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    bbrc.c("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] cancelTask");
    this.jdField_a_of_type_Boolean = true;
    f();
    e();
  }
  
  public boolean c()
  {
    f();
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_d_of_type_JavaLangString, true);
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      bbrc.a("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] openOutputStream excp");
      this.jdField_a_of_type_JavaIoFileOutputStream = null;
      localFileNotFoundException.printStackTrace();
    }
    return false;
  }
  
  public int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void d()
  {
    e();
    this.jdField_a_of_type_Bbrs.a(this.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_Long);
  }
  
  public String e()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected void e()
  {
    this.jdField_a_of_type_Bbrs.a();
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream.close();
      this.jdField_a_of_type_JavaIoFileOutputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        bbrc.a("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] closeOutputStream excp");
        localIOException.printStackTrace();
      }
    }
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream.flush();
      this.f = 0L;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        bbrc.a("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] flushOutputStream excp");
        localIOException.printStackTrace();
      }
    }
  }
  
  protected void h()
  {
    this.jdField_a_of_type_Boolean = true;
    f();
    e();
    long l = System.currentTimeMillis();
    bbrc.c("TroopFileDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] onSuc. cost:" + (l - this.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_Bbrv != null) {
      this.jdField_a_of_type_Bbrv.a(this.jdField_d_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsd
 * JD-Core Version:    0.7.0.1
 */