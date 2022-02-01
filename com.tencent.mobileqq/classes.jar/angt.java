import com.tencent.qphone.base.util.QLog;
import java.io.File;

class angt
  implements anfg
{
  angt(angh paramangh, int paramInt, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc onDownLoadFinish:" + this.jdField_a_of_type_Int + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Angh.a(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_Int + anvx.a(2131699992));
        return;
      }
      this.jdField_a_of_type_Angh.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int + anvx.a(2131699991));
      return;
    }
    this.jdField_a_of_type_Angh.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int + anvx.a(2131700013));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angt
 * JD-Core Version:    0.7.0.1
 */