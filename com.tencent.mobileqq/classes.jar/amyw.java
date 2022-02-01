import com.tencent.qphone.base.util.QLog;
import java.io.File;

class amyw
  implements amxk
{
  amyw(amyl paramamyl, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc onDownLoadFinish:" + paramInt1 + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Amyl.a(this.jdField_a_of_type_JavaLangString, 0, paramInt1 + anni.a(2131699318));
        return;
      }
      this.jdField_a_of_type_Amyl.a(this.jdField_a_of_type_JavaLangString, 2, paramInt1 + anni.a(2131699294));
      return;
    }
    this.jdField_a_of_type_Amyl.a(this.jdField_a_of_type_JavaLangString, 2, paramInt1 + anni.a(2131699312));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyw
 * JD-Core Version:    0.7.0.1
 */