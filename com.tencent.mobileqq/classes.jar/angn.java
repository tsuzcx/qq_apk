import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class angn
  implements amoz
{
  angn(angm paramangm) {}
  
  public void a(boolean paramBoolean, String paramString1, List<amow> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    int i = 0;
    if (i < this.a.jdField_a_of_type_ArrayOfInt.length)
    {
      paramString1 = amov.a().a(8, this.a.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramString1 != null)
      {
        paramList = this.a.jdField_a_of_type_Angh;
        int k = paramString1.b;
        if (paramString1.a())
        {
          j = 0;
          label88:
          paramString1 = angh.a(paramList, 8, String.valueOf(k), j);
          this.a.jdField_a_of_type_OrgJsonJSONArray.put(paramString1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label88;
        paramString1 = angh.a(this.a.jdField_a_of_type_Angh, 8, String.valueOf(this.a.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.a.jdField_a_of_type_OrgJsonJSONArray.put(paramString1);
      }
    }
    this.a.jdField_a_of_type_Angh.a(this.a.jdField_a_of_type_JavaLangString, anvx.a(2131700001), this.a.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angn
 * JD-Core Version:    0.7.0.1
 */