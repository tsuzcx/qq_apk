import com.tencent.mobileqq.ark.ArkAppCenter;

class anmt
  implements anmx
{
  anmt(anmm paramanmm, anmw paramanmw, String paramString, anmy paramanmy) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_Anmw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anmw.b }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Anmy.a(false);
      return;
      if (!anmm.b(paramArrayOfByte, this.jdField_a_of_type_Anmw.d))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_Anmw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anmw.b, this.jdField_a_of_type_Anmw.d }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anmw.jdField_a_of_type_JavaLangString });
        if (anmm.a(paramArrayOfByte, str)) {
          break;
        }
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.jdField_a_of_type_Anmw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anmw.b, str }));
      }
    }
    this.jdField_a_of_type_Anmy.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmt
 * JD-Core Version:    0.7.0.1
 */