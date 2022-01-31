import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class axjw
  implements bapx
{
  axjw(axjt paramaxjt, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, ayyn paramayyn) {}
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "onResp url: " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl + " resultcode: " + parambaqw.c);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = this.jdField_a_of_type_Axjt.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    parambaqw = this.jdField_a_of_type_Axjt.a.iterator();
    while (parambaqw.hasNext())
    {
      Object localObject = (axkp)parambaqw.next();
      if (((axkp)localObject).a != null)
      {
        localObject = ((axkp)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
          if (localPtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
            localPtvTemplateInfo.usable = this.jdField_a_of_type_Axjt.a(localPtvTemplateInfo);
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {}
    try
    {
      ndr.a(new File(axjt.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5), axjt.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5));
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
    if (this.jdField_a_of_type_Ayyn != null) {
      this.jdField_a_of_type_Ayyn.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(100L * paramLong1 / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axjw
 * JD-Core Version:    0.7.0.1
 */