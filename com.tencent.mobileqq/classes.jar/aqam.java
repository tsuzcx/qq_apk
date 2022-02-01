import com.tencent.mobileqq.ark.ArkAppCenter;

class aqam
  implements aqau
{
  aqam(aqai paramaqai, aqas paramaqas, aqau paramaqau, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.jdField_a_of_type_Aqas.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Aqau.a(true);
      return;
    }
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.jdField_a_of_type_Aqas.jdField_a_of_type_JavaLangString }));
    aqai.a(this.jdField_a_of_type_Aqai, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqas, new aqan(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqam
 * JD-Core Version:    0.7.0.1
 */