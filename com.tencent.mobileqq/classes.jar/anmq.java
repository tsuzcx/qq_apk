import com.tencent.mobileqq.ark.ArkAppCenter;

class anmq
  implements anmy
{
  anmq(anmm paramanmm, anmw paramanmw, anmy paramanmy, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.jdField_a_of_type_Anmw.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Anmy.a(true);
      return;
    }
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.jdField_a_of_type_Anmw.jdField_a_of_type_JavaLangString }));
    anmm.a(this.jdField_a_of_type_Anmm, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anmw, new anmr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmq
 * JD-Core Version:    0.7.0.1
 */