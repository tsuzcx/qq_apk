import com.tencent.mobileqq.ark.ArkAppCenter;

class aqap
  implements aqat
{
  aqap(aqai paramaqai, aqas paramaqas, String paramString, aqau paramaqau) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_Aqas.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqas.b }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqau.a(false);
      return;
      if (!aqai.b(paramArrayOfByte, this.jdField_a_of_type_Aqas.d))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_Aqas.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqas.b, this.jdField_a_of_type_Aqas.d }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqas.jdField_a_of_type_JavaLangString });
        if (aqai.a(paramArrayOfByte, str)) {
          break;
        }
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.jdField_a_of_type_Aqas.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqas.b, str }));
      }
    }
    this.jdField_a_of_type_Aqau.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqap
 * JD-Core Version:    0.7.0.1
 */