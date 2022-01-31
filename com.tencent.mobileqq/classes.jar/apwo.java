import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class apwo
  implements apwp
{
  apwo(apwn paramapwn) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.a.b(paramInt);
    if (apwn.a(this.a) != null)
    {
      if (paramInt <= 100) {
        break label45;
      }
      apwn.a(this.a).b(this.a.h(), paramBundle);
    }
    label45:
    while (paramInt - this.a.g() <= 0) {
      return;
    }
    this.a.a(paramInt);
    apwn.a(this.a).b(paramInt, paramBundle);
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    this.a.c(5);
    QQAppInterface localQQAppInterface = apdc.a().a();
    if (localQQAppInterface != null)
    {
      long l1 = -1L;
      long l2 = -1L;
      apwt localapwt = apwt.a(paramBundle);
      if (localapwt != null)
      {
        l1 = localapwt.jdField_a_of_type_Long;
        l2 = localapwt.b;
      }
      apug.a(localQQAppInterface, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownload", this.a.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString, l1, l2, this.a.b, this.a.jdField_c_of_type_JavaLangString, "", 0, paramString, null);
      apug.a(localQQAppInterface, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownloadDetail", this.a.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString, l1, l2, this.a.b, this.a.jdField_c_of_type_JavaLangString, "", 0, paramString, null);
      axrm.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-0");
    }
    for (;;)
    {
      if (apwn.a(this.a) != null) {
        apwn.a(this.a).a(paramInt, paramString, paramBundle);
      }
      return;
      QLog.w(apwn.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report failed - 6");
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (apwn.a(this.a) != null) {
      apwn.a(this.a).a(this.a.h(), null);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    QLog.i(apwn.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "] >>>>>>Download SUCCESS. sdk download path=" + paramString);
    this.a.c(4);
    if (paramString == null)
    {
      QLog.e(apwn.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. download success, but filepath = null");
      a(40, apwj.a(40), paramBundle);
    }
    label783:
    label821:
    for (;;)
    {
      return;
      if (bbdx.a(this.a.e)) {
        this.a.e = apug.b(this.a.e);
      }
      QLog.i(apwn.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. try to rename file to path:" + this.a.e);
      Object localObject;
      if (!bbdx.b(new File(paramString), new File(this.a.e)))
      {
        QLog.e(apwn.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].rename failed. temppath=" + paramString + " save path=" + this.a.e);
        localObject = apvd.c(paramString);
        if (!apug.b().equalsIgnoreCase((String)localObject))
        {
          String str = (String)localObject + this.a.d;
          localObject = str;
          if (bbdx.a(str)) {
            localObject = apug.b(str);
          }
          QLog.i(apwn.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename failed, try to save file to path: " + (String)localObject);
          if (!bbdx.b(new File(paramString), new File((String)localObject)))
          {
            QLog.e(apwn.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename failed, try failed save path: " + (String)localObject);
            a(7, apwj.a(7), paramBundle);
            return;
          }
          this.a.e = ((String)localObject);
        }
      }
      else
      {
        QLog.i(apwn.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename file success. path:" + this.a.e);
        paramString = apdc.a().a();
        if (paramString == null) {
          break label783;
        }
        long l1 = -1L;
        long l2 = -1L;
        localObject = apwt.a(paramBundle);
        if (localObject == null) {
          break label743;
        }
        l1 = ((apwt)localObject).jdField_a_of_type_Long;
        l2 = ((apwt)localObject).b;
        apug.a(paramString, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownload", System.currentTimeMillis() - this.a.jdField_a_of_type_Long, "", "", "", "", l1, l2, this.a.b, 0, null);
        apug.a(paramString, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownloadDetail", System.currentTimeMillis() - this.a.jdField_a_of_type_Long, "", "", "", "", l1, l2, this.a.b, 0, null);
        axrm.a(paramString.getApplication().getApplicationContext(), paramString.getCurrentAccountUin(), "Complete_download_2_0");
      }
      for (;;)
      {
        if (apwn.a(this.a) == null) {
          break label821;
        }
        apwn.a(this.a).a(this.a.e, this.a.b, paramBundle);
        return;
        QLog.e(apwn.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename failed 2, try failed save path: " + paramString);
        a(7, apwj.a(7), paramBundle);
        return;
        label743:
        QLog.w(apwn.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report may failed - 0");
        break;
        QLog.i(apwn.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report failed - 7");
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    this.a.c(3);
    if (apwn.a(this.a) != null) {
      apwn.a(this.a).c(this.a.h(), null);
    }
  }
  
  public void c(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apwo
 * JD-Core Version:    0.7.0.1
 */