import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class amfe
  implements alqd
{
  amfe(amez paramamez, int paramInt, int[] paramArrayOfInt, List paramList, AppInterface paramAppInterface, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, alqc paramalqc)
  {
    amez.a(this.jdField_a_of_type_Amez).remove(this.jdField_a_of_type_Int);
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc onCheckFinish success:" + paramBoolean);
    if (paramBoolean)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        paramalqc = alpu.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
        if (paramalqc != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramalqc);
        }
        i += 1;
      }
      alpw.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "", new amff(this), this.jdField_a_of_type_JavaUtilList, false, null);
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramalqc = alpu.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramalqc != null)
      {
        amez localamez = this.jdField_a_of_type_Amez;
        int k = paramalqc.b;
        if (paramalqc.a())
        {
          j = 0;
          label167:
          paramalqc = amez.a(localamez, 8, String.valueOf(k), j);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramalqc);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label167;
        paramalqc = amez.a(this.jdField_a_of_type_Amez, 8, String.valueOf(this.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramalqc);
      }
    }
    this.jdField_a_of_type_Amez.a(this.jdField_a_of_type_JavaLangString, amtj.a(2131699649), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfe
 * JD-Core Version:    0.7.0.1
 */