import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class artz
  implements arua
{
  artz(arty paramarty) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.a.b(paramInt);
    if (arty.a(this.a) != null)
    {
      if (paramInt <= 100) {
        break label45;
      }
      arty.a(this.a).b(this.a.h(), paramBundle);
    }
    label45:
    while (paramInt - this.a.g() <= 0) {
      return;
    }
    this.a.a(paramInt);
    arty.a(this.a).b(paramInt, paramBundle);
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    this.a.c(5);
    QQAppInterface localQQAppInterface = araj.a().a();
    if (localQQAppInterface != null)
    {
      long l1 = -1L;
      long l2 = -1L;
      arue localarue = arue.a(paramBundle);
      if (localarue != null)
      {
        l1 = localarue.jdField_a_of_type_Long;
        l2 = localarue.b;
      }
      arrr.a(localQQAppInterface, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownload", this.a.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString, l1, l2, this.a.b, this.a.jdField_c_of_type_JavaLangString, "", 0, paramString, null);
      arrr.a(localQQAppInterface, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownloadDetail", this.a.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString, l1, l2, this.a.b, this.a.jdField_c_of_type_JavaLangString, "", 0, paramString, null);
      azrh.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-0");
    }
    for (;;)
    {
      if (arty.a(this.a) != null) {
        arty.a(this.a).a(paramInt, paramString, paramBundle);
      }
      return;
      QLog.w(arty.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report failed - 6");
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (arty.a(this.a) != null) {
      arty.a(this.a).a(this.a.h(), null);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    QLog.i(arty.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "] >>>>>>Download SUCCESS. sdk download path=" + paramString);
    this.a.c(4);
    if (paramString == null)
    {
      QLog.e(arty.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. download success, but filepath = null");
      a(40, artu.a(40), paramBundle);
    }
    label783:
    label821:
    for (;;)
    {
      return;
      if (bdhb.a(this.a.e)) {
        this.a.e = arrr.b(this.a.e);
      }
      QLog.i(arty.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. try to rename file to path:" + this.a.e);
      Object localObject;
      if (!bdhb.b(new File(paramString), new File(this.a.e)))
      {
        QLog.e(arty.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].rename failed. temppath=" + paramString + " save path=" + this.a.e);
        localObject = arso.c(paramString);
        if (!arrr.b().equalsIgnoreCase((String)localObject))
        {
          String str = (String)localObject + this.a.d;
          localObject = str;
          if (bdhb.a(str)) {
            localObject = arrr.b(str);
          }
          QLog.i(arty.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename failed, try to save file to path: " + (String)localObject);
          if (!bdhb.b(new File(paramString), new File((String)localObject)))
          {
            QLog.e(arty.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename failed, try failed save path: " + (String)localObject);
            a(7, artu.a(7), paramBundle);
            return;
          }
          this.a.e = ((String)localObject);
        }
      }
      else
      {
        QLog.i(arty.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename file success. path:" + this.a.e);
        paramString = araj.a().a();
        if (paramString == null) {
          break label783;
        }
        long l1 = -1L;
        long l2 = -1L;
        localObject = arue.a(paramBundle);
        if (localObject == null) {
          break label743;
        }
        l1 = ((arue)localObject).jdField_a_of_type_Long;
        l2 = ((arue)localObject).b;
        arrr.a(paramString, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownload", System.currentTimeMillis() - this.a.jdField_a_of_type_Long, "", "", "", "", l1, l2, this.a.b, 0, null);
        arrr.a(paramString, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownloadDetail", System.currentTimeMillis() - this.a.jdField_a_of_type_Long, "", "", "", "", l1, l2, this.a.b, 0, null);
        azrh.a(paramString.getApplication().getApplicationContext(), paramString.getCurrentAccountUin(), "Complete_download_2_0");
      }
      for (;;)
      {
        if (arty.a(this.a) == null) {
          break label821;
        }
        arty.a(this.a).a(this.a.e, this.a.b, paramBundle);
        return;
        QLog.e(arty.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename failed 2, try failed save path: " + paramString);
        a(7, artu.a(7), paramBundle);
        return;
        label743:
        QLog.w(arty.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report may failed - 0");
        break;
        QLog.i(arty.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report failed - 7");
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    this.a.c(3);
    if (arty.a(this.a) != null) {
      arty.a(this.a).c(this.a.h(), null);
    }
  }
  
  public void c(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artz
 * JD-Core Version:    0.7.0.1
 */