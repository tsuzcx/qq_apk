import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.Iterator;
import java.util.List;

class brhp
  implements beuq
{
  brhp(brhn parambrhn, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, brhk parambrhk) {}
  
  public void onResp(bevm arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl + " resultcode: " + ???.c);
    }
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = this.jdField_a_of_type_Brhn.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    synchronized (this.jdField_a_of_type_Brhn.jdField_a_of_type_JavaLangObject)
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
      do
      {
        Iterator localIterator = this.jdField_a_of_type_Brhn.jdField_a_of_type_JavaUtilList.iterator();
        Object localObject2;
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (bpnv)localIterator.next();
          } while (((bpnv)localObject2).jdField_a_of_type_JavaUtilList == null);
          localObject2 = ((bpnv)localObject2).jdField_a_of_type_JavaUtilList.iterator();
        }
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject2).next();
      } while (!localPtvTemplateInfo.name.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name));
      localPtvTemplateInfo.usable = this.jdField_a_of_type_Brhn.a(localPtvTemplateInfo);
    }
    if (this.jdField_a_of_type_Brhk != null) {
      this.jdField_a_of_type_Brhk.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable);
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.totalLen = paramLong2;
    if (this.jdField_a_of_type_Brhk != null) {
      this.jdField_a_of_type_Brhk.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(100L * paramLong1 / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brhp
 * JD-Core Version:    0.7.0.1
 */