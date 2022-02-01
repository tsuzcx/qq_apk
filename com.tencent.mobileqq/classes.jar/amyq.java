import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class amyq
  implements amjp
{
  amyq(amyl paramamyl, int paramInt, int[] paramArrayOfInt, List paramList, AppInterface paramAppInterface, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, amjo paramamjo)
  {
    amyl.a(this.jdField_a_of_type_Amyl).remove(this.jdField_a_of_type_Int);
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc onCheckFinish success:" + paramBoolean);
    if (paramBoolean)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        paramamjo = amjg.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
        if (paramamjo != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramamjo);
        }
        i += 1;
      }
      amji.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "", new amyr(this), this.jdField_a_of_type_JavaUtilList, false, null);
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramamjo = amjg.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramamjo != null)
      {
        amyl localamyl = this.jdField_a_of_type_Amyl;
        int k = paramamjo.b;
        if (paramamjo.a())
        {
          j = 0;
          label167:
          paramamjo = amyl.a(localamyl, 8, String.valueOf(k), j);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramamjo);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label167;
        paramamjo = amyl.a(this.jdField_a_of_type_Amyl, 8, String.valueOf(this.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramamjo);
      }
    }
    this.jdField_a_of_type_Amyl.a(this.jdField_a_of_type_JavaLangString, anni.a(2131699307), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyq
 * JD-Core Version:    0.7.0.1
 */