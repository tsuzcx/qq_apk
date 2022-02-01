import com.tencent.mobileqq.ark.ArkAppCenter;

class aouc
  implements aoug
{
  aouc(aotv paramaotv, aouf paramaouf, String paramString, aouh paramaouh) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_Aouf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aouf.b }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Aouh.a(false);
      return;
      if (!aotv.b(paramArrayOfByte, this.jdField_a_of_type_Aouf.d))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_Aouf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aouf.b, this.jdField_a_of_type_Aouf.d }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aouf.jdField_a_of_type_JavaLangString });
        if (aotv.a(paramArrayOfByte, str)) {
          break;
        }
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.jdField_a_of_type_Aouf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aouf.b, str }));
      }
    }
    this.jdField_a_of_type_Aouh.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aouc
 * JD-Core Version:    0.7.0.1
 */