import android.text.TextUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bfck
{
  public int a;
  public ArrayList<Integer> a;
  public int b = 0;
  
  public bfck()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static bfck a(aqxa[] paramArrayOfaqxa)
  {
    bfck localbfck = new bfck();
    int i = 0;
    if (i < paramArrayOfaqxa.length)
    {
      Object localObject = paramArrayOfaqxa[i].a;
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
          localbfck.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("switchOn", 0);
          localbfck.b = ((JSONObject)localObject).optInt("troopMemberCount_ahn", 0);
          localObject = ((JSONObject)localObject).optJSONArray("troopType_ahn");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            int j = 0;
            while (j < ((JSONArray)localObject).length())
            {
              if ((((JSONArray)localObject).get(j) instanceof Integer)) {
                localbfck.jdField_a_of_type_JavaUtilArrayList.add((Integer)((JSONArray)localObject).get(j));
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
      QLog.i("TroopAssociationsEntryConfig", 2, "config:" + localbfck.toString());
    }
    return localbfck;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfck
 * JD-Core Version:    0.7.0.1
 */