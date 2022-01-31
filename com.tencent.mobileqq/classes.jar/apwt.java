import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class apwt
  extends apws
  implements apwj
{
  public static String a;
  long jdField_a_of_type_Long = 0L;
  private apwk jdField_a_of_type_Apwk;
  private apww jdField_a_of_type_Apww;
  private Object d = new Object();
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloaderGen<FileAssistant>";
  }
  
  public apwt(long paramLong)
  {
    super(paramLong);
  }
  
  private apww a()
  {
    synchronized (this.d)
    {
      apww localapww = this.jdField_a_of_type_Apww;
      return localapww;
    }
  }
  
  private void a()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] killWoker. ");
    apww localapww = a();
    if (localapww != null)
    {
      localapww.a();
      a(null);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] killWoker. not worker");
  }
  
  private void a(apww paramapww)
  {
    synchronized (this.d)
    {
      this.jdField_a_of_type_Apww = paramapww;
      return;
    }
  }
  
  private boolean a(long paramLong)
  {
    apww localapww = a();
    if (localapww != null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] runWorker. before worker be stoped");
      localapww.a();
    }
    localapww = new apww(this.jdField_c_of_type_Long, apcy.a().a(), this.jdField_c_of_type_JavaLangString, this.b, this.g, new apwu(this));
    a(localapww);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] runWorker. start ,mTempStrFilePath=" + this.f);
    return localapww.a(this.f, paramLong);
  }
  
  private void b()
  {
    String str = apwh.a(1);
    QQAppInterface localQQAppInterface = apcy.a().a();
    if (localQQAppInterface != null)
    {
      apue.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      apue.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      axrk.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 9");
  }
  
  public int a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QQAppInterface localQQAppInterface = apcy.a().a();
    if (localQQAppInterface != null) {
      axrk.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Start_download_2-3_3-1");
    }
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. not inited");
      b();
      if (this.jdField_a_of_type_Apwk != null) {
        this.jdField_a_of_type_Apwk.a(1, apwh.a(1), null);
      }
      return -1;
    }
    String str;
    if (!bbev.d(BaseApplication.getContext()))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. but net is broken. failed drictly");
      a();
      c(5);
      str = apwh.a(2);
      if (localQQAppInterface != null)
      {
        apue.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 2, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
        apue.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 2, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
        axrk.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Apwk != null) {
          this.jdField_a_of_type_Apwk.a(2, "net broken", null);
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
    long l2 = apue.a(this.f);
    if (l2 > this.b)
    {
      a(0);
      long l1 = 0L;
      if (bbay.a()) {
        l1 = bbay.a() * 1024L;
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
      str = apwh.a(9);
      apue.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 9, str, 0L, l2, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      apue.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 9, str, 0L, l2, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      axrk.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Apwk != null) {
        this.jdField_a_of_type_Apwk.a(9, "no space", null);
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
          if ((i != 0) && (this.jdField_a_of_type_Apwk != null)) {
            this.jdField_a_of_type_Apwk.a(h(), null);
          }
          return 0;
        }
      }
      finally {}
      i = 0;
    }
  }
  
  public int a(apwk paramapwk)
  {
    this.jdField_a_of_type_Apwk = paramapwk;
    return 0;
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    super.a(paramString, paramBundle);
    paramBundle = apvz.a().a(paramString);
    if (paramBundle != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] >>>init. HAPPY.have a BreakpointTransInfo,tempPath:" + paramBundle.b);
      if (apue.b(paramBundle.b)) {
        this.f = paramBundle.b;
      }
    }
    for (;;)
    {
      return 0;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] >>>init. no exsit");
      continue;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] >>>init. NO HAPPY. Not BreakpointTransInfo,add it:");
      apvz.a().a(paramString, null, this.b, this.f, this.e);
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
      if (this.jdField_a_of_type_Apwk != null) {
        this.jdField_a_of_type_Apwk.a(1, apwh.a(1), null);
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
        if (this.jdField_a_of_type_Apwk == null) {
          continue;
        }
        this.jdField_a_of_type_Apwk.c(h(), null);
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
      if (this.jdField_a_of_type_Apwk != null) {
        this.jdField_a_of_type_Apwk.a(1, apwh.a(1), null);
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
    } while (this.jdField_a_of_type_Apwk == null);
    this.jdField_a_of_type_Apwk.d(h(), null);
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
    apww localapww = a();
    if (localapww != null) {
      localapww.b();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apwt
 * JD-Core Version:    0.7.0.1
 */