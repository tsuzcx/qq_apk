import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class apwu
  implements apwv
{
  apwu(apwt paramapwt) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.a.b(paramInt);
    if ((apwt.a(this.a) != null) && (paramInt - this.a.g() > 0))
    {
      this.a.a(paramInt);
      apwt.a(this.a).b(paramInt, paramBundle);
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    apwt.a(this.a);
    this.a.c(5);
    if (apwt.a(this.a) != null) {
      apwt.a(this.a).a(paramInt, paramString, paramBundle);
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    apwt.a(this.a);
    this.a.c(4);
    if (bbdj.a(this.a.e)) {
      this.a.e = apue.b(this.a.e);
    }
    QLog.i(apwt.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. >>>Download SUCCESS.  save file to: =" + this.a.e);
    int i = 1;
    long l2;
    long l1;
    if (paramBundle != null)
    {
      l2 = paramBundle.getLong("EXT_TRANS_SIZE ");
      l1 = paramBundle.getLong("EXT_TTRANS_SIZE ");
      i = paramBundle.getInt("EXT_AUTOTRY_COUNT");
    }
    for (;;)
    {
      if (!bbdj.b(new File(this.a.f), new File(this.a.e)))
      {
        QLog.e(apwt.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].rename failed.temppath=" + this.a.f + " path=" + this.a.e);
        this.a.c(5);
        paramString = apwh.a(7);
        QQAppInterface localQQAppInterface = apcy.a().a();
        if (localQQAppInterface != null)
        {
          apue.a(localQQAppInterface, this.a.jdField_c_of_type_Long, "actFileUfGenDownload", this.a.jdField_a_of_type_Long, "", "", "", "", 7, paramString, l1, l2, this.a.b, this.a.jdField_c_of_type_JavaLangString, "", 0, paramString, null);
          apue.a(localQQAppInterface, this.a.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.a.jdField_a_of_type_Long, "", "", "", "", 7, paramString, l1, l2, this.a.b, this.a.jdField_c_of_type_JavaLangString, "", 0, paramString, null);
          axrk.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
          if (apwt.a(this.a) != null) {
            apwt.a(this.a).a(7, paramString, paramBundle);
          }
        }
      }
      for (;;)
      {
        return;
        QLog.w(apwt.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report failed - 5");
        break;
        apvz.a().a(this.a.jdField_c_of_type_JavaLangString);
        paramString = apcy.a().a();
        if (paramString != null)
        {
          apue.a(paramString, this.a.jdField_c_of_type_Long, "actFileUfGenDownload", System.currentTimeMillis() - this.a.jdField_a_of_type_Long, "", "", "", "", l1, l2, this.a.b, i, null);
          apue.a(paramString, this.a.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", System.currentTimeMillis() - this.a.jdField_a_of_type_Long, "", "", "", "", l1, l2, this.a.b, i, null);
          axrk.a(paramString.getApplication().getApplicationContext(), paramString.getCurrentAccountUin(), "Complete_download_2_1");
        }
        while (apwt.a(this.a) != null)
        {
          l1 = paramLong;
          if (this.a.b > 0L)
          {
            l1 = paramLong;
            if (paramLong <= 0L) {
              l1 = this.a.b;
            }
          }
          apwt.a(this.a).a(this.a.e, l1, paramBundle);
          return;
          QLog.i(apwt.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report failed - 0");
        }
      }
      l1 = paramLong;
      l2 = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apwu
 * JD-Core Version:    0.7.0.1
 */