import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class angl
  implements anfj
{
  angl(angh paramangh, String paramString1, File paramFile, JSONArray paramJSONArray, int[] paramArrayOfInt, String paramString2) {}
  
  public void onDownloadFinish(boolean paramBoolean, int paramInt)
  {
    QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:" + paramBoolean);
    Object localObject = this.jdField_a_of_type_Angh;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_JavaIoFile.exists()) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = angh.a((angh)localObject, 6, str, paramInt);
      this.jdField_a_of_type_OrgJsonJSONArray.put(localObject);
      if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0)) {
        break;
      }
      this.jdField_a_of_type_Angh.a(this.b, anvx.a(2131700004), this.jdField_a_of_type_OrgJsonJSONArray);
      return;
    }
    angh.a(this.jdField_a_of_type_Angh, this.jdField_a_of_type_ArrayOfInt, this.b, this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angl
 * JD-Core Version:    0.7.0.1
 */