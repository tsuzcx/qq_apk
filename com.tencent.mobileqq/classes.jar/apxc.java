import com.tencent.mobileqq.ark.ArkAppCenter;

class apxc
  implements apxl
{
  apxc(apwz paramapwz, apxj paramapxj, apxl paramapxl) {}
  
  public void a(boolean paramBoolean)
  {
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, local not exists, full update, success=%s, name=%s", new Object[] { Boolean.toString(paramBoolean), this.jdField_a_of_type_Apxj.a }));
    if (paramBoolean) {}
    this.jdField_a_of_type_Apxl.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxc
 * JD-Core Version:    0.7.0.1
 */