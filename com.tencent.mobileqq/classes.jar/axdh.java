import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class axdh
  implements aysc
{
  public axdh(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, axdj paramaxdj) {}
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "onResp url: " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl + " resultcode: " + paramaysz.c);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.businessID == 1)
    {
      paramaysz = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.e.iterator();
      while (paramaysz.hasNext())
      {
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramaysz.next();
        if (localPtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
          localPtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(localPtvTemplateInfo);
        }
      }
    }
    paramaysz = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramaysz.hasNext())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramaysz.next();
      if (localPtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
        localPtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(localPtvTemplateInfo);
      }
    }
    paramaysz = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.b.iterator();
    while (paramaysz.hasNext())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramaysz.next();
      if (localPtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
        localPtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(localPtvTemplateInfo);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {}
    try
    {
      nav.a(new File(PtvTemplateManager.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name), PtvTemplateManager.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Axdj != null) {
        this.jdField_a_of_type_Axdj.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable);
      }
      return;
    }
    catch (IOException paramaysz)
    {
      for (;;)
      {
        paramaysz.printStackTrace();
      }
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Axdj != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.totalLen = paramLong2;
      this.jdField_a_of_type_Axdj.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(100L * paramLong1 / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axdh
 * JD-Core Version:    0.7.0.1
 */