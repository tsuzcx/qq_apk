import com.tencent.mobileqq.ark.ArkAppCenter;

class apxg
  implements apxk
{
  apxg(apwz paramapwz, apxj paramapxj, String paramString, apxl paramapxl) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_Apxj.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apxj.b }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Apxl.a(false);
      return;
      if (!apwz.b(paramArrayOfByte, this.jdField_a_of_type_Apxj.d))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_Apxj.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apxj.b, this.jdField_a_of_type_Apxj.d }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apxj.jdField_a_of_type_JavaLangString });
        if (apwz.a(paramArrayOfByte, str)) {
          break;
        }
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.jdField_a_of_type_Apxj.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apxj.b, str }));
      }
    }
    this.jdField_a_of_type_Apxl.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxg
 * JD-Core Version:    0.7.0.1
 */