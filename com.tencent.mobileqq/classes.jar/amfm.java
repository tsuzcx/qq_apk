import java.io.File;

class amfm
  implements amdy
{
  amfm(amez paramamez, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Amez.a(this.jdField_a_of_type_JavaLangString, 0, paramInt2 + amtj.a(2131699658));
        return;
      }
      this.jdField_a_of_type_Amez.a(this.jdField_a_of_type_JavaLangString, 2, paramInt2 + amtj.a(2131699634));
      return;
    }
    this.jdField_a_of_type_Amez.a(this.jdField_a_of_type_JavaLangString, 2, paramInt2 + amtj.a(2131699655));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfm
 * JD-Core Version:    0.7.0.1
 */