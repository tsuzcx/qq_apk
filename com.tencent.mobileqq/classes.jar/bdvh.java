import android.text.TextUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bdvh
{
  public int a;
  public ArrayList<Integer> a;
  public int b = 0;
  
  public bdvh()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static bdvh a(aptx[] paramArrayOfaptx)
  {
    bdvh localbdvh = new bdvh();
    int i = 0;
    if (i < paramArrayOfaptx.length)
    {
      Object localObject = paramArrayOfaptx[i].a;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localObject = new JSONObject((String)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("TroopAssociationsEntryConfig", 2, "jsonObj:" + ((JSONObject)localObject).toString());
          }
          localbdvh.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("switchOn", 0);
          localbdvh.b = ((JSONObject)localObject).optInt("troopMemberCount_ahn", 0);
          localObject = ((JSONObject)localObject).optJSONArray("troopType_ahn");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            int j = 0;
            while (j < ((JSONArray)localObject).length())
            {
              if ((((JSONArray)localObject).get(j) instanceof Integer)) {
                localbdvh.jdField_a_of_type_JavaUtilArrayList.add((Integer)((JSONArray)localObject).get(j));
              }
              j += 1;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopAssociationsEntryConfig", 2, "config:" + localbdvh.toString());
    }
    return localbdvh;
  }
  
  public boolean a(TroopInfoData paramTroopInfoData)
  {
    if (this.jdField_a_of_type_Int == 0) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Int == 2) {
        return true;
      }
    } while ((this.jdField_a_of_type_Int != 1) || (paramTroopInfoData == null) || (TextUtils.isEmpty(paramTroopInfoData.troopUin)) || (paramTroopInfoData.troopMemberMaxNum > this.b) || (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf((int)paramTroopInfoData.dwGroupClassExt))));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSwitchOn:").append(this.jdField_a_of_type_Int).append("\r\n");
    localStringBuilder.append("mTroopMemberCount:").append(this.b).append("\r\n");
    localStringBuilder.append("mGrayTroopType:").append(this.jdField_a_of_type_JavaUtilArrayList.toString()).append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvh
 * JD-Core Version:    0.7.0.1
 */