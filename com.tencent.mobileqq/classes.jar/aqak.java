import com.tencent.mobileqq.ark.ArkAppCenter;
import java.io.File;
import java.util.Locale;

class aqak
  implements aqau
{
  aqak(aqai paramaqai, aqaw paramaqaw, aqas paramaqas, String paramString1, aqau paramaqau, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_Aqaw.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_Aqaw)
    {
      aqaw localaqaw2 = this.jdField_a_of_type_Aqaw;
      int i = localaqaw2.jdField_a_of_type_Int - 1;
      localaqaw2.jdField_a_of_type_Int = i;
      if (i > 0)
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format(Locale.CHINA, "updateWordDict, one task complete, name=%s, success=%s, left=%d", new Object[] { this.jdField_a_of_type_Aqas.jdField_a_of_type_JavaLangString, Boolean.toString(paramBoolean), Integer.valueOf(i) }));
        return;
      }
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateWordDict, all complete, success=%s", new Object[] { Boolean.toString(this.jdField_a_of_type_Aqaw.jdField_a_of_type_Boolean) }));
      if (!this.jdField_a_of_type_Aqaw.jdField_a_of_type_Boolean)
      {
        bhmi.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Aqau.a(false);
        return;
      }
    }
    if (!aqai.a(aqaf.a(this.b), new File(this.jdField_a_of_type_JavaLangString).getParent()))
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, renameDictDirAfterUpdateSuccess fail");
      this.jdField_a_of_type_Aqau.a(false);
      return;
    }
    this.jdField_a_of_type_Aqau.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqak
 * JD-Core Version:    0.7.0.1
 */