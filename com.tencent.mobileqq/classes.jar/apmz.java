import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.DocsExportFileModel.1.1;
import com.tencent.mobileqq.filemanager.fileviewer.model.DocsExportFileModel.1.2;
import com.tencent.mobileqq.filemanager.fileviewer.model.DocsExportFileModel.1.3;
import mqq.os.MqqHandler;

public class apmz
  extends ayej
{
  apmz(apmy paramapmy) {}
  
  public void a(int paramInt)
  {
    if ((this.a.jdField_a_of_type_Apnf != null) && (paramInt <= 100)) {
      apmy.a(this.a).post(new DocsExportFileModel.1.3(this, paramInt));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    apmy.a(this.a, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a.b = System.currentTimeMillis();
    apmy.a(this.a).removeMessages(8001);
    apmy.a(this.a).removeMessages(8002);
    apmy.a(this.a).post(new DocsExportFileModel.1.1(this));
    ((ayel)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(142)).a(paramString1, paramString2, paramString3, paramString4);
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
        ayhm.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A4B3");
      }
      if (apmy.a(this.a) != null)
      {
        apmy.a(this.a).strFilePath = paramString1;
        apmy.a(this.a).fileSize = apug.a(paramString1);
        paramString1 = ayek.a(apmy.a(this.a).nFileType);
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if ((localQQAppInterface != null) && (paramString2 != null)) {
          axqy.b(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 1, l3 - l4 + "", l1 - l2 + "", paramString1, paramString2);
        }
      }
      if (this.a.jdField_a_of_type_Apnf != null)
      {
        apmy.a(this.a).removeMessages(8001);
        apmy.a(this.a).removeMessages(8002);
        apmy.a(this.a).post(new DocsExportFileModel.1.2(this));
      }
      return;
    }
    paramString1 = ajya.a(2131703406);
    apmy.a(this.a, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmz
 * JD-Core Version:    0.7.0.1
 */