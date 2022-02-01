import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.List;

public class bpnv
  implements Cloneable
{
  public int a;
  public String a;
  public List<PtvTemplateManager.PtvTemplateInfo> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public bpnv() {}
  
  public bpnv(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bpnv a()
  {
    bpnv localbpnv = new bpnv();
    localbpnv.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbpnv.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbpnv.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbpnv.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbpnv.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbpnv.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
    localbpnv.jdField_a_of_type_JavaUtilList = new ArrayList();
    localbpnv.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbpnv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpnv
 * JD-Core Version:    0.7.0.1
 */