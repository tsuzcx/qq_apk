import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class ankm
  implements amve
{
  ankm(ankf paramankf, int[] paramArrayOfInt, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, List<amvb> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramString1 = amva.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramString1 != null)
      {
        paramList = this.jdField_a_of_type_Ankf;
        int k = paramString1.b;
        if (paramString1.a())
        {
          j = 0;
          label79:
          paramString1 = ankf.a(paramList, 8, String.valueOf(k), j);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramString1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label79;
        paramString1 = ankf.a(this.jdField_a_of_type_Ankf, 8, String.valueOf(this.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramString1);
      }
    }
    this.jdField_a_of_type_Ankf.a(this.jdField_a_of_type_JavaLangString, anzj.a(2131699426), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankm
 * JD-Core Version:    0.7.0.1
 */