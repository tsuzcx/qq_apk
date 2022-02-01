import com.tencent.qphone.base.util.QLog;
import java.io.File;

class amyo
  implements amxn
{
  amyo(amyl paramamyl, File paramFile, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Amyl.a(this.jdField_a_of_type_JavaLangString, 0, anni.a(2131699293));
        return;
      }
      this.jdField_a_of_type_Amyl.a(this.jdField_a_of_type_JavaLangString, 2, anni.a(2131699322));
      return;
    }
    this.jdField_a_of_type_Amyl.a(this.jdField_a_of_type_JavaLangString, 2, anni.a(2131699304));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyo
 * JD-Core Version:    0.7.0.1
 */