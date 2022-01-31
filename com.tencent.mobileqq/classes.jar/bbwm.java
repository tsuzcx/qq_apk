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

public class bbwm
  implements bbvh, bbwc, bbwd
{
  protected int a;
  protected long a;
  protected final bbvg a;
  protected bbwb a;
  protected bbwe a;
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
  
  protected bbwm(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_c_of_type_Long = paramLong2;
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Bbvg = new bbvg(paramQQAppInterface, paramList, paramString2, this.jdField_b_of_type_Long, paramBoolean, this);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bbvg.a();
    paramString1 = bbvj.a(this.jdField_a_of_type_JavaLangString);
    if (paramString1 != null)
    {
      this.jdField_b_of_type_JavaLangString = paramString1.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Int = paramString1.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramString1.jdField_b_of_type_Int;
    }
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Bbwb = new bbwb(paramQQAppInterface, paramLong1, 1, 0, paramLong2, paramBoolean, paramString4);
    this.jdField_a_of_type_Bbwb.a(this);
  }
  
  public static bbwd a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    String str = "";
    if (paramString1 == null) {
      str = "strSavePath is null";
    }
    while (!TextUtils.isEmpty(str))
    {
      bbvl.a("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "getFileDownloader " + str);
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
    return new bbwm(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean, paramString4);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    bbvl.c("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] reDownload mstrUrl:" + this.jdField_a_of_type_JavaLangString);
    g();
    if (this.jdField_a_of_type_Bbwe != null) {
      this.jdField_a_of_type_Bbwe.d();
    }
    this.jdField_d_of_type_Long = arrr.a(this.jdField_d_of_type_JavaLangString);
    if (!bdin.g(BaseApplication.getContext()))
    {
      a(true, 9004, "no net work", "");
      return;
    }
    d();
  }
  
  public void a() {}
  
  public void a(int paramInt, String paramString1, String paramString2, bdpx parambdpx)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramString1.indexOf("-29602") > 0)
    {
      a(true, -29602, paramString1, paramString2);
      return;
    }
    if ((parambdpx != null) && (parambdpx.a != null))
    {
      parambdpx = parambdpx.a.getHeaderField("User-ReturnCode");
      if ((!TextUtils.isEmpty(parambdpx)) && ((parambdpx.equals("-441")) || (parambdpx.equals("-443")) || (parambdpx.equals("-447")) || (parambdpx.equals("-29224")) || (parambdpx.equals("-31717"))))
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
      if (!bdin.d(BaseApplication.getContext()))
      {
        a(true, 9004, paramString1, paramString2);
        return;
      }
      this.jdField_c_of_type_Boolean = false;
      bbvl.a("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] onErr errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
      if (this.jdField_a_of_type_Bbvg.a(this.jdField_a_of_type_JavaLangString, paramInt, bool))
      {
        a(false, paramInt, paramString1, paramString2);
        return;
      }
      a(true, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public void a(bbwe parambbwe)
  {
    this.jdField_a_of_type_Bbwe = parambbwe;
  }
  
  public void a(bdpx parambdpx) {}
  
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
    int i = bbvl.jdField_a_of_type_Int;
    StringBuilder localStringBuilder = new StringBuilder().append("[").append(this.jdField_b_of_type_Long).append("] onErr errCode:").append(paramInt).append(" bFinished:").append(paramBoolean).append(" errMsg:").append(paramString1).append(" rspHeader:").append(paramString2).append(" cost:");
    if (paramBoolean) {}
    for (Object localObject = Long.valueOf(l - this.jdField_a_of_type_Long);; localObject = "")
    {
      bbvl.a("TroopFileDownloader", i, localObject);
      if (this.jdField_a_of_type_Bbwe != null) {
        this.jdField_a_of_type_Bbwe.a(paramBoolean, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2, new Bundle());
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
            bbvl.c("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] onData getted filesize=" + paramLong);
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
            this.jdField_a_of_type_Bbvg.a(this.jdField_a_of_type_JavaLangString);
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
    } while (((this.e != 0L) && (paramLong - this.e < 1000L)) || (this.jdField_a_of_type_Bbwe == null));
    this.jdField_a_of_type_Bbwe.a(this.jdField_d_of_type_Long, this.jdField_c_of_type_Long);
  }
  
  public boolean a()
  {
    if (!bfiu.a())
    {
      a(true, 9039, "no sdcard", null);
      return true;
    }
    VFSFile localVFSFile = new VFSFile(this.jdField_d_of_type_JavaLangString);
    if (!localVFSFile.exists()) {}
    try
    {
      localVFSFile.createNewFile();
      this.jdField_d_of_type_Long = arrr.a(this.jdField_d_of_type_JavaLangString);
      if (this.jdField_c_of_type_Long == 0L)
      {
        bbvl.b("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] checkexcpover fileSize=0");
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
        bbvl.c("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] checkexcpover tmpfilesize=filesize");
        h();
        return true;
      }
      l1 = this.jdField_c_of_type_Long;
      l2 = this.jdField_d_of_type_Long;
    } while (arqx.a().a() >= l1 - l2);
    a(true, 9040, "no enugh space", null);
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Bbvg.a();
  }
  
  public long b()
  {
    return 100L;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    bbvl.c("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] download");
    ThreadManager.post(new TroopFileDownloader.1(this), 8, null, false);
  }
  
  public void b(bdpx parambdpx)
  {
    parambdpx.a("User-Agent", "TroopFile");
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      parambdpx.a("Cookie", "FTN5K=" + this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bbvl.c("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] onRetry but stoped");
      return;
    }
    int i = 0;
    if (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))
    {
      i = 1;
      bbvl.c("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] onRetry urlChanged");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (i != 0)
    {
      paramString = bbvj.a(this.jdField_a_of_type_JavaLangString);
      if (paramString != null)
      {
        this.jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Int = paramString.jdField_a_of_type_Int;
        this.jdField_b_of_type_Int = paramString.jdField_b_of_type_Int;
      }
      this.jdField_a_of_type_Bbwe.b(this.jdField_a_of_type_JavaLangString);
    }
    i();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bbvg.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    bbvl.c("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] cancelTask");
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
      bbvl.a("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] openOutputStream excp");
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
    this.jdField_a_of_type_Bbwb.a(this.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_Long);
  }
  
  public String e()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected void e()
  {
    this.jdField_a_of_type_Bbwb.a();
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
        bbvl.a("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] closeOutputStream excp");
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
        bbvl.a("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] flushOutputStream excp");
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
    bbvl.c("TroopFileDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_b_of_type_Long + "] onSuc. cost:" + (l - this.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_Bbwe != null) {
      this.jdField_a_of_type_Bbwe.a(this.jdField_d_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwm
 * JD-Core Version:    0.7.0.1
 */