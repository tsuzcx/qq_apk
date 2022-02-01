import com.tencent.mobileqq.ark.ArkAppCenter;

class apmw
  implements apne
{
  apmw(apms paramapms, apnc paramapnc, apne paramapne, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.jdField_a_of_type_Apnc.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Apne.a(true);
      return;
    }
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.jdField_a_of_type_Apnc.jdField_a_of_type_JavaLangString }));
    apms.a(this.jdField_a_of_type_Apms, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apnc, new apmx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmw
 * JD-Core Version:    0.7.0.1
 */