import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.DocsExportFileModel.1.1;
import com.tencent.mobileqq.filemanager.fileviewer.model.DocsExportFileModel.1.2;
import com.tencent.mobileqq.filemanager.fileviewer.model.DocsExportFileModel.1.3;
import mqq.os.MqqHandler;

public class arkg
  extends bagp
{
  arkg(arkf paramarkf) {}
  
  public void a(int paramInt)
  {
    if ((this.a.jdField_a_of_type_Arko != null) && (paramInt <= 100)) {
      arkf.a(this.a).post(new DocsExportFileModel.1.3(this, paramInt));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    arkf.a(this.a, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a.b = System.currentTimeMillis();
    arkf.a(this.a).removeMessages(8001);
    arkf.a(this.a).removeMessages(8002);
    arkf.a(this.a).post(new DocsExportFileModel.1.1(this));
    ((bagr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(142)).a(paramString1, paramString2, paramString3, paramString4);
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
        bajr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A4B3");
      }
      if (arkf.a(this.a) != null)
      {
        arkf.a(this.a).strFilePath = paramString1;
        arkf.a(this.a).fileSize = arrr.a(paramString1);
        paramString1 = bagq.a(arkf.a(this.a).nFileType);
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if ((localQQAppInterface != null) && (paramString2 != null)) {
          azqs.b(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 1, l3 - l4 + "", l1 - l2 + "", paramString1, paramString2);
        }
      }
      if (this.a.jdField_a_of_type_Arko != null)
      {
        arkf.a(this.a).removeMessages(8001);
        arkf.a(this.a).removeMessages(8002);
        arkf.a(this.a).post(new DocsExportFileModel.1.2(this));
      }
      return;
    }
    paramString1 = alud.a(2131703790);
    arkf.a(this.a, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arkg
 * JD-Core Version:    0.7.0.1
 */