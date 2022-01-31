import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ayyl
  implements bapx
{
  public ayyl(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, ayyn paramayyn) {}
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "onResp url: " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl + " resultcode: " + parambaqw.c);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.businessID == 1)
    {
      parambaqw = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.e.iterator();
      while (parambaqw.hasNext())
      {
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)parambaqw.next();
        if (localPtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
          localPtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(localPtvTemplateInfo);
        }
      }
    }
    parambaqw = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (parambaqw.hasNext())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)parambaqw.next();
      if (localPtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
        localPtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(localPtvTemplateInfo);
      }
    }
    parambaqw = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.b.iterator();
    while (parambaqw.hasNext())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)parambaqw.next();
      if (localPtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
        localPtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(localPtvTemplateInfo);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {}
    try
    {
      ndr.a(new File(PtvTemplateManager.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name), PtvTemplateManager.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Ayyn != null) {
        this.jdField_a_of_type_Ayyn.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable);
      }
      return;
    }
    catch (IOException parambaqw)
    {
      for (;;)
      {
        parambaqw.printStackTrace();
      }
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Ayyn != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.totalLen = paramLong2;
      this.jdField_a_of_type_Ayyn.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(100L * paramLong1 / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyl
 * JD-Core Version:    0.7.0.1
 */