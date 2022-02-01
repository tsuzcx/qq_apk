import android.text.TextUtils;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;

class bdfs
  implements bdgo
{
  bdfs(bdfq parambdfq, String paramString, bdge parambdge, LoadParam.LoadItem paramLoadItem) {}
  
  public void a(int paramInt, SoConfig.SoInfo paramSoInfo)
  {
    if (!this.jdField_a_of_type_Bdfq.a(paramSoInfo))
    {
      bdfq.a(this.jdField_a_of_type_Bdfq, 2);
      return;
    }
    if ((TextUtils.equals(this.jdField_a_of_type_Bdfq.a.ver, this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Bdge.b()))
    {
      this.jdField_a_of_type_Bdfq.c = "runcrash";
      bdfq.a(this.jdField_a_of_type_Bdfq, 8);
      return;
    }
    bdgf.b(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name);
    bdfq.a(this.jdField_a_of_type_Bdfq, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfs
 * JD-Core Version:    0.7.0.1
 */