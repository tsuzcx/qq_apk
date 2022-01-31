import com.tencent.mobileqq.ark.ArkAppCenter;
import java.io.File;
import java.util.Locale;

class anmo
  implements anmy
{
  anmo(anmm paramanmm, anna paramanna, anmw paramanmw, String paramString1, anmy paramanmy, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_Anna.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_Anna)
    {
      anna localanna2 = this.jdField_a_of_type_Anna;
      int i = localanna2.jdField_a_of_type_Int - 1;
      localanna2.jdField_a_of_type_Int = i;
      if (i > 0)
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format(Locale.CHINA, "updateWordDict, one task complete, name=%s, success=%s, left=%d", new Object[] { this.jdField_a_of_type_Anmw.jdField_a_of_type_JavaLangString, Boolean.toString(paramBoolean), Integer.valueOf(i) }));
        return;
      }
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateWordDict, all complete, success=%s", new Object[] { Boolean.toString(this.jdField_a_of_type_Anna.jdField_a_of_type_Boolean) }));
      if (!this.jdField_a_of_type_Anna.jdField_a_of_type_Boolean)
      {
        bdhb.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Anmy.a(false);
        return;
      }
    }
    if (!anmm.a(anmj.a(this.b), new File(this.jdField_a_of_type_JavaLangString).getParent()))
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, renameDictDirAfterUpdateSuccess fail");
      this.jdField_a_of_type_Anmy.a(false);
      return;
    }
    this.jdField_a_of_type_Anmy.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmo
 * JD-Core Version:    0.7.0.1
 */