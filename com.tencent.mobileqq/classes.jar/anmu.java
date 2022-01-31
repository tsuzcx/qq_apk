import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.open.base.BspatchUtil;
import java.io.File;

class anmu
  implements anmx
{
  anmu(anmm paramanmm, anmw paramanmw1, String paramString1, anmw paramanmw2, String paramString2, anmy paramanmy) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_Anmw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anmw.jdField_b_of_type_JavaLangString }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Anmy.a(false);
      return;
      if (!anmm.b(paramArrayOfByte, this.jdField_a_of_type_Anmw.f))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, md5 mismatch, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_Anmw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anmw.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Anmw.f }));
      }
      else
      {
        String str1 = anmm.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Anmw.jdField_a_of_type_JavaLangString);
        if (!new File(str1).isFile())
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, src path not exist, name=%s, path=s", new Object[] { this.jdField_a_of_type_Anmw.jdField_a_of_type_JavaLangString, str1 }));
        }
        else
        {
          String str2 = String.format("%s/diff-%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Anmw.d });
          if (!anmm.a(paramArrayOfByte, str2))
          {
            ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, write diff to file fail, name=%s, path=%s", new Object[] { this.jdField_a_of_type_Anmw.jdField_a_of_type_JavaLangString, str2 }));
          }
          else
          {
            if (BspatchUtil.a(str1, str2, String.format("%s/%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Anmw.jdField_a_of_type_JavaLangString }))) {
              break;
            }
            ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, patch fail, name=%s, diff-md5=%s", new Object[] { this.jdField_a_of_type_Anmw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anmw.f }));
          }
        }
      }
    }
    this.jdField_a_of_type_Anmy.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmu
 * JD-Core Version:    0.7.0.1
 */