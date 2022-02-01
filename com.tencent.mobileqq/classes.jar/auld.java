import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class auld
  extends aulk
  implements aulb
{
  public static String a;
  long jdField_a_of_type_Long = 0L;
  private aulc jdField_a_of_type_Aulc;
  private boolean jdField_a_of_type_Boolean;
  private Object d = new Object();
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloaderAppBaby<FileAssistant>";
  }
  
  public auld(long paramLong)
  {
    super(paramLong);
  }
  
  private void a()
  {
    String str = aukz.a(1);
    QQAppInterface localQQAppInterface = auht.a().a();
    if (localQQAppInterface != null)
    {
      auea.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfAppBabySdkDownload", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      auea.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfAppBabySdkDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      bdlq.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-0");
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 9");
  }
  
  private void a(boolean paramBoolean)
  {
    synchronized (this.d)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  private boolean b()
  {
    synchronized (this.d)
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
  }
  
  private int i()
  {
    int i = aulg.a().a(this.jdField_c_of_type_Long, this.jdField_c_of_type_JavaLangString, this.b, new aule(this));
    if (i == 0) {
      a(true);
    }
    return i;
  }
  
  public int a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QQAppInterface localQQAppInterface = auht.a().a();
    if (localQQAppInterface != null) {
      bdlq.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Start_download_2-3_3-0");
    }
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. not inited");
      a();
      if (this.jdField_a_of_type_Aulc != null) {
        this.jdField_a_of_type_Aulc.a(1, aukz.a(1), null);
      }
      i = -1;
      return i;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      c(5);
      str = aukz.a(2);
      if (localQQAppInterface != null)
      {
        auea.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfAppBabySdkDownload", this.jdField_a_of_type_Long, "", "", "", "", 2, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
        auea.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfAppBabySdkDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 2, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
        bdlq.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-0");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Aulc != null) {
          this.jdField_a_of_type_Aulc.a(2, str, null);
        }
        return -1;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 8");
      }
    }
    int i = e();
    if (2 == i)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. is runing");
      return 0;
    }
    if ((1 != i) && (6 != i))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. before status is error:" + i);
      return -1;
    }
    a(0);
    if (1 == i)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start download. AddDownloadToAppBabySdk");
      i();
    }
    int j;
    for (;;)
    {
      j = aulg.a().a(this.jdField_c_of_type_JavaLangString);
      if (j != 0) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. ST:" + i + " PGR:" + h());
      c(2);
      return j;
      if ((6 == i) && (!aulg.a().a(this.jdField_c_of_type_JavaLangString)))
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] resume download and start it. sdk is not this download, AddDownloadToAppBabySdk");
        i();
      }
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start failed. ST:" + i + " PGR:" + h());
    c(5);
    String str = aukz.a(5);
    if (localQQAppInterface != null)
    {
      auea.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfAppBabySdkDownload", this.jdField_a_of_type_Long, "", "", "", "", 5, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      auea.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfAppBabySdkDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 5, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      bdlq.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-0");
    }
    for (;;)
    {
      i = j;
      if (this.jdField_a_of_type_Aulc == null) {
        break;
      }
      this.jdField_a_of_type_Aulc.a(5, null, null);
      return j;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 8");
    }
  }
  
  public int a(aulc paramaulc)
  {
    this.jdField_a_of_type_Aulc = paramaulc;
    return 0;
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    return super.a(paramString, paramBundle);
  }
  
  public int b()
  {
    int i = e();
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] stop. ST:" + i + " PGR:" + h());
    c(7);
    return aulg.a().c(this.jdField_c_of_type_JavaLangString);
  }
  
  public int c()
  {
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] pause. not inited");
      a();
      if (this.jdField_a_of_type_Aulc != null) {
        this.jdField_a_of_type_Aulc.a(1, aukz.a(1), null);
      }
      i = -1;
      return i;
    }
    boolean bool = b();
    int i = e();
    if ((1 == i) || (!bool))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] waiting and pause. ST:" + i + " PGR:" + h() + "(inited)");
      c(3);
      if (this.jdField_a_of_type_Aulc != null) {
        this.jdField_a_of_type_Aulc.c(h(), null);
      }
      return 0;
    }
    if ((3 == i) || (7 == i))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] pause. had be paused");
      return 0;
    }
    int j = aulg.a().b(this.jdField_c_of_type_JavaLangString);
    if (j == 0)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] pause. ST:" + i + " PGR:" + h());
      c(3);
      return j;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] pause failed. ST:" + i + " PGR:" + h());
    c(5);
    String str = aukz.a(15);
    QQAppInterface localQQAppInterface = auht.a().a();
    if (localQQAppInterface != null)
    {
      auea.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfAppBabySdkDownload", this.jdField_a_of_type_Long, "", "", "", "", 15, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      auea.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfAppBabySdkDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 15, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      bdlq.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-0");
    }
    for (;;)
    {
      i = j;
      if (this.jdField_a_of_type_Aulc == null) {
        break;
      }
      this.jdField_a_of_type_Aulc.a(15, null, null);
      return j;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 8");
    }
  }
  
  public int d()
  {
    int i = 0;
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] resume. not inited");
      a();
      if (this.jdField_a_of_type_Aulc != null) {
        this.jdField_a_of_type_Aulc.a(1, aukz.a(1), null);
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
    } while (this.jdField_a_of_type_Aulc == null);
    this.jdField_a_of_type_Aulc.d(h(), null);
    return 0;
  }
  
  public int e()
  {
    return super.e();
  }
  
  public int f()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auld
 * JD-Core Version:    0.7.0.1
 */