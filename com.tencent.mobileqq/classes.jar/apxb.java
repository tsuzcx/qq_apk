import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.Locale;

class apxb
  implements apxl
{
  apxb(apwz paramapwz, apxn paramapxn, apxj paramapxj, String paramString1, apxl paramapxl, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_Apxn.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_Apxn)
    {
      apxn localapxn2 = this.jdField_a_of_type_Apxn;
      int i = localapxn2.jdField_a_of_type_Int - 1;
      localapxn2.jdField_a_of_type_Int = i;
      if (i > 0)
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format(Locale.CHINA, "updateWordDict, one task complete, name=%s, success=%s, left=%d", new Object[] { this.jdField_a_of_type_Apxj.jdField_a_of_type_JavaLangString, Boolean.toString(paramBoolean), Integer.valueOf(i) }));
        return;
      }
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateWordDict, all complete, success=%s", new Object[] { Boolean.toString(this.jdField_a_of_type_Apxn.jdField_a_of_type_Boolean) }));
      if (!this.jdField_a_of_type_Apxn.jdField_a_of_type_Boolean)
      {
        FileUtils.deleteDirectory(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Apxl.a(false);
        return;
      }
    }
    if (!apwz.a(apww.a(this.b), new File(this.jdField_a_of_type_JavaLangString).getParent()))
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, renameDictDirAfterUpdateSuccess fail");
      this.jdField_a_of_type_Apxl.a(false);
      return;
    }
    this.jdField_a_of_type_Apxl.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxb
 * JD-Core Version:    0.7.0.1
 */