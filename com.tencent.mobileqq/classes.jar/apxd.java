import com.tencent.mobileqq.ark.ArkAppCenter;

class apxd
  implements apxl
{
  apxd(apwz paramapwz, apxj paramapxj, apxl paramapxl, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.jdField_a_of_type_Apxj.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Apxl.a(true);
      return;
    }
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.jdField_a_of_type_Apxj.jdField_a_of_type_JavaLangString }));
    apwz.a(this.jdField_a_of_type_Apwz, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apxj, new apxe(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxd
 * JD-Core Version:    0.7.0.1
 */