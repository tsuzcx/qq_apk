import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class arpx
  extends arpw
  implements arpn
{
  public static String a;
  long jdField_a_of_type_Long = 0L;
  private arpo jdField_a_of_type_Arpo;
  private arqa jdField_a_of_type_Arqa;
  private Object d = new Object();
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloaderGen<FileAssistant>";
  }
  
  public arpx(long paramLong)
  {
    super(paramLong);
  }
  
  private arqa a()
  {
    synchronized (this.d)
    {
      arqa localarqa = this.jdField_a_of_type_Arqa;
      return localarqa;
    }
  }
  
  private void a()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] killWoker. ");
    arqa localarqa = a();
    if (localarqa != null)
    {
      localarqa.a();
      a(null);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] killWoker. not worker");
  }
  
  private void a(arqa paramarqa)
  {
    synchronized (this.d)
    {
      this.jdField_a_of_type_Arqa = paramarqa;
      return;
    }
  }
  
  private boolean a(long paramLong)
  {
    arqa localarqa = a();
    if (localarqa != null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] runWorker. before worker be stoped");
      localarqa.a();
    }
    localarqa = new arqa(this.jdField_c_of_type_Long, aqwa.a().a(), this.jdField_c_of_type_JavaLangString, this.b, this.g, new arpy(this));
    a(localarqa);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] runWorker. start ,mTempStrFilePath=" + this.f);
    return localarqa.a(this.f, paramLong);
  }
  
  private void b()
  {
    String str = arpl.a(1);
    QQAppInterface localQQAppInterface = aqwa.a().a();
    if (localQQAppInterface != null)
    {
      arni.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      arni.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      azmy.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 9");
  }
  
  public int a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QQAppInterface localQQAppInterface = aqwa.a().a();
    if (localQQAppInterface != null) {
      azmy.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Start_download_2-3_3-1");
    }
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. not inited");
      b();
      if (this.jdField_a_of_type_Arpo != null) {
        this.jdField_a_of_type_Arpo.a(1, arpl.a(1), null);
      }
      return -1;
    }
    String str;
    if (!bdee.d(BaseApplication.getContext()))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. but net is broken. failed drictly");
      a();
      c(5);
      str = arpl.a(2);
      if (localQQAppInterface != null)
      {
        arni.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 2, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
        arni.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 2, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
        azmy.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Arpo != null) {
          this.jdField_a_of_type_Arpo.a(2, "net broken", null);
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
    long l2 = arni.a(this.f);
    if (l2 > this.b)
    {
      a(0);
      long l1 = 0L;
      if (bdag.a()) {
        l1 = bdag.a() * 1024L;
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
      str = arpl.a(9);
      arni.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 9, str, 0L, l2, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      arni.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 9, str, 0L, l2, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      azmy.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Arpo != null) {
        this.jdField_a_of_type_Arpo.a(9, "no space", null);
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
          if ((i != 0) && (this.jdField_a_of_type_Arpo != null)) {
            this.jdField_a_of_type_Arpo.a(h(), null);
          }
          return 0;
        }
      }
      finally {}
      i = 0;
    }
  }
  
  public int a(arpo paramarpo)
  {
    this.jdField_a_of_type_Arpo = paramarpo;
    return 0;
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    super.a(paramString, paramBundle);
    paramBundle = arpd.a().a(paramString);
    if (paramBundle != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] >>>init. HAPPY.have a BreakpointTransInfo,tempPath:" + paramBundle.b);
      if (arni.b(paramBundle.b)) {
        this.f = paramBundle.b;
      }
    }
    for (;;)
    {
      return 0;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] >>>init. no exsit");
      continue;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] >>>init. NO HAPPY. Not BreakpointTransInfo,add it:");
      arpd.a().a(paramString, null, this.b, this.f, this.e);
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
      if (this.jdField_a_of_type_Arpo != null) {
        this.jdField_a_of_type_Arpo.a(1, arpl.a(1), null);
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
        if (this.jdField_a_of_type_Arpo == null) {
          continue;
        }
        this.jdField_a_of_type_Arpo.c(h(), null);
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
      if (this.jdField_a_of_type_Arpo != null) {
        this.jdField_a_of_type_Arpo.a(1, arpl.a(1), null);
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
    } while (this.jdField_a_of_type_Arpo == null);
    this.jdField_a_of_type_Arpo.d(h(), null);
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
    arqa localarqa = a();
    if (localarqa != null) {
      localarqa.b();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arpx
 * JD-Core Version:    0.7.0.1
 */