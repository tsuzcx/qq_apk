import com.tencent.qphone.base.util.QLog;
import java.io.File;

class amfc
  implements ameb
{
  amfc(amez paramamez, File paramFile, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Amez.a(this.jdField_a_of_type_JavaLangString, 0, amtj.a(2131699635));
        return;
      }
      this.jdField_a_of_type_Amez.a(this.jdField_a_of_type_JavaLangString, 2, amtj.a(2131699664));
      return;
    }
    this.jdField_a_of_type_Amez.a(this.jdField_a_of_type_JavaLangString, 2, amtj.a(2131699646));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfc
 * JD-Core Version:    0.7.0.1
 */