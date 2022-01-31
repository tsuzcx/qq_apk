import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.DocsExportFileModel.1.1;
import com.tencent.mobileqq.filemanager.fileviewer.model.DocsExportFileModel.1.2;
import com.tencent.mobileqq.filemanager.fileviewer.model.DocsExportFileModel.1.3;
import mqq.os.MqqHandler;

public class apmv
  extends ayeh
{
  apmv(apmu paramapmu) {}
  
  public void a(int paramInt)
  {
    if ((this.a.jdField_a_of_type_Apnb != null) && (paramInt <= 100)) {
      apmu.a(this.a).post(new DocsExportFileModel.1.3(this, paramInt));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    apmu.a(this.a, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a.b = System.currentTimeMillis();
    apmu.a(this.a).removeMessages(8001);
    apmu.a(this.a).removeMessages(8002);
    apmu.a(this.a).post(new DocsExportFileModel.1.1(this));
    ((ayej)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(142)).a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.a.b;
    long l3 = this.a.b;
    long l4 = this.a.jdField_a_of_type_Long;
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("isMiniProgram", false))) {
        ayhk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A4B3");
      }
      if (apmu.a(this.a) != null)
      {
        apmu.a(this.a).strFilePath = paramString1;
        apmu.a(this.a).fileSize = apue.a(paramString1);
        paramString1 = ayei.a(apmu.a(this.a).nFileType);
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if ((localQQAppInterface != null) && (paramString2 != null)) {
          axqw.b(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 1, l3 - l4 + "", l1 - l2 + "", paramString1, paramString2);
        }
      }
      if (this.a.jdField_a_of_type_Apnb != null)
      {
        apmu.a(this.a).removeMessages(8001);
        apmu.a(this.a).removeMessages(8002);
        apmu.a(this.a).post(new DocsExportFileModel.1.2(this));
      }
      return;
    }
    paramString1 = ajyc.a(2131703395);
    apmu.a(this.a, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmv
 * JD-Core Version:    0.7.0.1
 */