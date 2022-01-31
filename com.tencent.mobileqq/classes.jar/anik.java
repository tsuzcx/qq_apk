import com.tencent.mobileqq.ark.ArkAppCenter;

class anik
  implements anio
{
  anik(anid paramanid, anin paramanin, String paramString, anip paramanip) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_Anin.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anin.b }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Anip.a(false);
      return;
      if (!anid.b(paramArrayOfByte, this.jdField_a_of_type_Anin.d))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_Anin.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anin.b, this.jdField_a_of_type_Anin.d }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anin.jdField_a_of_type_JavaLangString });
        if (anid.a(paramArrayOfByte, str)) {
          break;
        }
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.jdField_a_of_type_Anin.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anin.b, str }));
      }
    }
    this.jdField_a_of_type_Anip.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anik
 * JD-Core Version:    0.7.0.1
 */