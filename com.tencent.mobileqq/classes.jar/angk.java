import com.tencent.qphone.base.util.QLog;
import java.io.File;

class angk
  implements anfj
{
  angk(angh paramangh, File paramFile, String paramString) {}
  
  public void onDownloadFinish(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Angh.a(this.jdField_a_of_type_JavaLangString, 0, anvx.a(2131699986));
        return;
      }
      this.jdField_a_of_type_Angh.a(this.jdField_a_of_type_JavaLangString, 2, anvx.a(2131700015));
      return;
    }
    this.jdField_a_of_type_Angh.a(this.jdField_a_of_type_JavaLangString, 2, anvx.a(2131699997));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angk
 * JD-Core Version:    0.7.0.1
 */