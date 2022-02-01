import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class angm
  implements ampe
{
  angm(angh paramangh, int paramInt, int[] paramArrayOfInt, List paramList, AppInterface paramAppInterface, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, ampd paramampd)
  {
    angh.a(this.jdField_a_of_type_Angh).remove(this.jdField_a_of_type_Int);
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc onCheckFinish success:" + paramBoolean);
    if (paramBoolean)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        paramampd = amov.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
        if (paramampd != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramampd);
        }
        i += 1;
      }
      amox.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "", new angn(this), this.jdField_a_of_type_JavaUtilList, false, null);
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramampd = amov.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramampd != null)
      {
        angh localangh = this.jdField_a_of_type_Angh;
        int k = paramampd.b;
        if (paramampd.a())
        {
          j = 0;
          label167:
          paramampd = angh.a(localangh, 8, String.valueOf(k), j);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramampd);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label167;
        paramampd = angh.a(this.jdField_a_of_type_Angh, 8, String.valueOf(this.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramampd);
      }
    }
    this.jdField_a_of_type_Angh.a(this.jdField_a_of_type_JavaLangString, anvx.a(2131700000), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angm
 * JD-Core Version:    0.7.0.1
 */