import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class bbez
  implements beuq
{
  bbez(bbew parambbew, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, bcwn parambcwn) {}
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "onResp url: " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl + " resultcode: " + parambevm.c);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = this.jdField_a_of_type_Bbew.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    parambevm = this.jdField_a_of_type_Bbew.a.iterator();
    while (parambevm.hasNext())
    {
      Object localObject = (bbfs)parambevm.next();
      if (((bbfs)localObject).a != null)
      {
        localObject = ((bbfs)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
          if (localPtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
            localPtvTemplateInfo.usable = this.jdField_a_of_type_Bbew.a(localPtvTemplateInfo);
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {}
    try
    {
      nof.a(new File(bbew.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5), bbew.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5));
      if (this.jdField_a_of_type_Bcwn != null) {
        this.jdField_a_of_type_Bcwn.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable);
      }
      return;
    }
    catch (IOException parambevm)
    {
      for (;;)
      {
        parambevm.printStackTrace();
      }
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bcwn != null) {
      this.jdField_a_of_type_Bcwn.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(100L * paramLong1 / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbez
 * JD-Core Version:    0.7.0.1
 */