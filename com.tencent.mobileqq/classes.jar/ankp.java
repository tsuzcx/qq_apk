import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class ankp
  implements amve
{
  ankp(ankf paramankf, String paramString, File paramFile, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, List<amvb> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    paramString1 = ankf.a(this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_Ankf.a(paramString1, 0, this.jdField_a_of_type_Int + anzj.a(2131699410));
        return;
      }
      this.jdField_a_of_type_Ankf.a(paramString1, 2, this.jdField_a_of_type_Int + anzj.a(2131699409));
      return;
    }
    this.jdField_a_of_type_Ankf.a(paramString1, 2, this.jdField_a_of_type_Int + anzj.a(2131699404));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankp
 * JD-Core Version:    0.7.0.1
 */