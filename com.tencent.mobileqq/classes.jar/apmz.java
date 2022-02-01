import com.tencent.mobileqq.ark.ArkAppCenter;

class apmz
  implements apnd
{
  apmz(apms paramapms, apnc paramapnc, String paramString, apne paramapne) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_Apnc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apnc.b }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Apne.a(false);
      return;
      if (!apms.b(paramArrayOfByte, this.jdField_a_of_type_Apnc.d))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_Apnc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apnc.b, this.jdField_a_of_type_Apnc.d }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apnc.jdField_a_of_type_JavaLangString });
        if (apms.a(paramArrayOfByte, str)) {
          break;
        }
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.jdField_a_of_type_Apnc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apnc.b, str }));
      }
    }
    this.jdField_a_of_type_Apne.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmz
 * JD-Core Version:    0.7.0.1
 */