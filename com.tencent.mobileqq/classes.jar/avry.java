import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class avry
  implements aysc
{
  avry(avrv paramavrv, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, axdj paramaxdj) {}
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "onResp url: " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl + " resultcode: " + paramaysz.c);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = this.jdField_a_of_type_Avrv.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    paramaysz = this.jdField_a_of_type_Avrv.a.iterator();
    while (paramaysz.hasNext())
    {
      Object localObject = (avsr)paramaysz.next();
      if (((avsr)localObject).a != null)
      {
        localObject = ((avsr)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
          if (localPtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
            localPtvTemplateInfo.usable = this.jdField_a_of_type_Avrv.a(localPtvTemplateInfo);
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {}
    try
    {
      nav.a(new File(avrv.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5), avrv.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5));
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
    if (this.jdField_a_of_type_Axdj != null) {
      this.jdField_a_of_type_Axdj.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(100L * paramLong1 / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avry
 * JD-Core Version:    0.7.0.1
 */