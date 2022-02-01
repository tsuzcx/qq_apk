import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class angj
  implements anfj
{
  angj(angi paramangi) {}
  
  public void onDownloadFinish(boolean paramBoolean, int paramInt)
  {
    QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:" + paramBoolean);
    Object localObject = this.a.jdField_a_of_type_Angh;
    String str = this.a.jdField_a_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_JavaIoFile.exists()) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = angh.a((angh)localObject, 6, str, paramInt);
      this.a.jdField_a_of_type_OrgJsonJSONArray.put(localObject);
      if ((this.a.jdField_a_of_type_ArrayOfInt != null) && (this.a.jdField_a_of_type_ArrayOfInt.length > 0)) {
        break;
      }
      this.a.jdField_a_of_type_Angh.a(this.a.b, anvx.a(2131699989), this.a.jdField_a_of_type_OrgJsonJSONArray);
      return;
    }
    angh.a(this.a.jdField_a_of_type_Angh, this.a.jdField_a_of_type_ArrayOfInt, this.a.b, this.a.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angj
 * JD-Core Version:    0.7.0.1
 */