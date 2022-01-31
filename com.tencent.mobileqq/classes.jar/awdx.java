import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class awdx
  implements axrt
{
  public awdx(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, awdz paramawdz) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "onResp url: " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl + " resultcode: " + paramaxsq.c);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.businessID == 1)
    {
      paramaxsq = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.e.iterator();
      while (paramaxsq.hasNext())
      {
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramaxsq.next();
        if (localPtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
          localPtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(localPtvTemplateInfo);
        }
      }
    }
    paramaxsq = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramaxsq.hasNext())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramaxsq.next();
      if (localPtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
        localPtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(localPtvTemplateInfo);
      }
    }
    paramaxsq = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.b.iterator();
    while (paramaxsq.hasNext())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramaxsq.next();
      if (localPtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
        localPtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(localPtvTemplateInfo);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {}
    try
    {
      mpx.a(new File(PtvTemplateManager.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name), PtvTemplateManager.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Awdz != null) {
        this.jdField_a_of_type_Awdz.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable);
      }
      return;
    }
    catch (IOException paramaxsq)
    {
      for (;;)
      {
        paramaxsq.printStackTrace();
      }
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Awdz != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.totalLen = paramLong2;
      this.jdField_a_of_type_Awdz.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(100L * paramLong1 / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awdx
 * JD-Core Version:    0.7.0.1
 */