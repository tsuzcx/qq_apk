import com.tencent.qphone.base.util.QLog;
import java.io.File;

class amyx
  implements amxk
{
  amyx(amyl paramamyl, int paramInt, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc onDownLoadFinish:" + this.jdField_a_of_type_Int + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Amyl.a(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_Int + anni.a(2131699299));
        return;
      }
      this.jdField_a_of_type_Amyl.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int + anni.a(2131699298));
      return;
    }
    this.jdField_a_of_type_Amyl.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int + anni.a(2131699320));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyx
 * JD-Core Version:    0.7.0.1
 */