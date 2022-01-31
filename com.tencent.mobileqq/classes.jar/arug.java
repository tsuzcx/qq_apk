import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class arug
  extends aruf
  implements artw
{
  public static String a;
  long jdField_a_of_type_Long = 0L;
  private artx jdField_a_of_type_Artx;
  private aruj jdField_a_of_type_Aruj;
  private Object d = new Object();
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloaderGen<FileAssistant>";
  }
  
  public arug(long paramLong)
  {
    super(paramLong);
  }
  
  private aruj a()
  {
    synchronized (this.d)
    {
      aruj localaruj = this.jdField_a_of_type_Aruj;
      return localaruj;
    }
  }
  
  private void a()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] killWoker. ");
    aruj localaruj = a();
    if (localaruj != null)
    {
      localaruj.a();
      a(null);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] killWoker. not worker");
  }
  
  private void a(aruj paramaruj)
  {
    synchronized (this.d)
    {
      this.jdField_a_of_type_Aruj = paramaruj;
      return;
    }
  }
  
  private boolean a(long paramLong)
  {
    aruj localaruj = a();
    if (localaruj != null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] runWorker. before worker be stoped");
      localaruj.a();
    }
    localaruj = new aruj(this.jdField_c_of_type_Long, araj.a().a(), this.jdField_c_of_type_JavaLangString, this.b, this.g, new aruh(this));
    a(localaruj);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] runWorker. start ,mTempStrFilePath=" + this.f);
    return localaruj.a(this.f, paramLong);
  }
  
  private void b()
  {
    String str = artu.a(1);
    QQAppInterface localQQAppInterface = araj.a().a();
    if (localQQAppInterface != null)
    {
      arrr.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      arrr.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      azrh.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 9");
  }
  
  public int a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QQAppInterface localQQAppInterface = araj.a().a();
    if (localQQAppInterface != null) {
      azrh.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Start_download_2-3_3-1");
    }
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. not inited");
      b();
      if (this.jdField_a_of_type_Artx != null) {
        this.jdField_a_of_type_Artx.a(1, artu.a(1), null);
      }
      return -1;
    }
    String str;
    if (!bdin.d(BaseApplication.getContext()))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. but net is broken. failed drictly");
      a();
      c(5);
      str = artu.a(2);
      if (localQQAppInterface != null)
      {
        arrr.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 2, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
        arrr.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 2, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
        azrh.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Artx != null) {
          this.jdField_a_of_type_Artx.a(2, "net broken", null);
        }
        return -2;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 11");
      }
    }
    int i = e();
    if (2 == i)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. is runing");
      return 0;
    }
    if ((1 != i) && (6 != i) && (8 != i))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. before status is error:" + i);
      return -1;
    }
    long l2 = arrr.a(this.f);
    if (l2 > this.b)
    {
      a(0);
      long l1 = 0L;
      if (bdep.a()) {
        l1 = bdep.a() * 1024L;
      }
      if (l1 >= this.b - l2) {
        break label777;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. sd card space is no enough:[" + this.b + " " + l2 + " " + l1 + "]");
      a();
      c(5);
      if (localQQAppInterface == null) {
        break label740;
      }
      str = artu.a(9);
      arrr.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 9, str, 0L, l2, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      arrr.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 9, str, 0L, l2, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      azrh.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Artx != null) {
        this.jdField_a_of_type_Artx.a(9, "no space", null);
      }
      return -2;
      a((int)(l2 / this.b));
      break;
      label740:
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 5");
    }
    for (;;)
    {
      try
      {
        label777:
        a(l2);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. ST:" + i + " PGR:" + h());
        if (1 == i)
        {
          i = 1;
          c(2);
          if ((i != 0) && (this.jdField_a_of_type_Artx != null)) {
            this.jdField_a_of_type_Artx.a(h(), null);
          }
          return 0;
        }
      }
      finally {}
      i = 0;
    }
  }
  
  public int a(artx paramartx)
  {
    this.jdField_a_of_type_Artx = paramartx;
    return 0;
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    super.a(paramString, paramBundle);
    paramBundle = artm.a().a(paramString);
    if (paramBundle != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] >>>init. HAPPY.have a BreakpointTransInfo,tempPath:" + paramBundle.b);
      if (arrr.b(paramBundle.b)) {
        this.f = paramBundle.b;
      }
    }
    for (;;)
    {
      return 0;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] >>>init. no exsit");
      continue;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] >>>init. NO HAPPY. Not BreakpointTransInfo,add it:");
      artm.a().a(paramString, null, this.b, this.f, this.e);
    }
  }
  
  public int b()
  {
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] stop. not inited");
      return -1;
    }
    try
    {
      a();
      int i = e();
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] stop. ST:" + i + " PGR:" + h());
      b(0);
      c(7);
      return 0;
    }
    finally {}
  }
  
  public int c()
  {
    int i = 0;
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] pause. not inited");
      b();
      if (this.jdField_a_of_type_Artx != null) {
        this.jdField_a_of_type_Artx.a(1, artu.a(1), null);
      }
      i = -1;
    }
    for (;;)
    {
      return i;
      int j = e();
      if ((3 == j) || (7 == j))
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] pause. had be paused");
        return 0;
      }
      try
      {
        a();
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] pause. ST:" + j + " PGR:" + h());
        c(3);
        if (this.jdField_a_of_type_Artx == null) {
          continue;
        }
        this.jdField_a_of_type_Artx.c(h(), null);
        return 0;
      }
      finally {}
    }
  }
  
  public int d()
  {
    int i = 0;
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] resume. not inited");
      b();
      if (this.jdField_a_of_type_Artx != null) {
        this.jdField_a_of_type_Artx.a(1, artu.a(1), null);
      }
      i = -1;
    }
    do
    {
      return i;
      int j = e();
      if ((6 == j) || (2 == j) || (4 == j))
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] resume. had be resumed");
        return 0;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] resume. ST:" + j + " PGR:" + h());
      c(6);
    } while (this.jdField_a_of_type_Artx == null);
    this.jdField_a_of_type_Artx.d(h(), null);
    return 0;
  }
  
  public int e()
  {
    return super.e();
  }
  
  public int f()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] resume. ST:" + e() + " PGR:" + h());
    c(8);
    aruj localaruj = a();
    if (localaruj != null) {
      localaruj.b();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arug
 * JD-Core Version:    0.7.0.1
 */