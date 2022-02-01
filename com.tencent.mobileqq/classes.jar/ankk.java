import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class ankk
  implements amvj
{
  ankk(ankf paramankf, int paramInt, int[] paramArrayOfInt, List paramList, AppInterface paramAppInterface, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, amvi paramamvi)
  {
    ankf.a(this.jdField_a_of_type_Ankf).remove(this.jdField_a_of_type_Int);
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc onCheckFinish success:" + paramBoolean);
    if (paramBoolean)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        paramamvi = amva.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
        if (paramamvi != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramamvi);
        }
        i += 1;
      }
      amvc.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "", new ankl(this), this.jdField_a_of_type_JavaUtilList, false, null);
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramamvi = amva.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramamvi != null)
      {
        ankf localankf = this.jdField_a_of_type_Ankf;
        int k = paramamvi.b;
        if (paramamvi.a())
        {
          j = 0;
          label167:
          paramamvi = ankf.a(localankf, 8, String.valueOf(k), j);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramamvi);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label167;
        paramamvi = ankf.a(this.jdField_a_of_type_Ankf, 8, String.valueOf(this.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramamvi);
      }
    }
    this.jdField_a_of_type_Ankf.a(this.jdField_a_of_type_JavaLangString, anzj.a(2131699414), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankk
 * JD-Core Version:    0.7.0.1
 */