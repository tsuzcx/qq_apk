import com.tencent.mobileqq.ark.ArkAppCenter;

class aotz
  implements aouh
{
  aotz(aotv paramaotv, aouf paramaouf, aouh paramaouh, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.jdField_a_of_type_Aouf.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Aouh.a(true);
      return;
    }
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.jdField_a_of_type_Aouf.jdField_a_of_type_JavaLangString }));
    aotv.a(this.jdField_a_of_type_Aotv, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aouf, new aoua(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aotz
 * JD-Core Version:    0.7.0.1
 */