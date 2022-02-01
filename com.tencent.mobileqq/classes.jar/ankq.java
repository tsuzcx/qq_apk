import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ankq
  implements anje
{
  ankq(ankf paramankf, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc onDownLoadFinish:" + paramInt1 + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Ankf.a(this.jdField_a_of_type_JavaLangString, 0, paramInt1 + anzj.a(2131699425));
        return;
      }
      this.jdField_a_of_type_Ankf.a(this.jdField_a_of_type_JavaLangString, 2, paramInt1 + anzj.a(2131699401));
      return;
    }
    this.jdField_a_of_type_Ankf.a(this.jdField_a_of_type_JavaLangString, 2, paramInt1 + anzj.a(2131699419));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankq
 * JD-Core Version:    0.7.0.1
 */