import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ankr
  implements anje
{
  ankr(ankf paramankf, int paramInt, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc onDownLoadFinish:" + this.jdField_a_of_type_Int + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Ankf.a(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_Int + anzj.a(2131699406));
        return;
      }
      this.jdField_a_of_type_Ankf.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int + anzj.a(2131699405));
      return;
    }
    this.jdField_a_of_type_Ankf.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int + anzj.a(2131699427));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankr
 * JD-Core Version:    0.7.0.1
 */