import com.tencent.mobileqq.ark.ArkAppCenter;

class anih
  implements anip
{
  anih(anid paramanid, anin paramanin, anip paramanip, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.jdField_a_of_type_Anin.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Anip.a(true);
      return;
    }
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.jdField_a_of_type_Anin.jdField_a_of_type_JavaLangString }));
    anid.a(this.jdField_a_of_type_Anid, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anin, new anii(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anih
 * JD-Core Version:    0.7.0.1
 */