import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqdn
{
  public String a;
  public boolean a;
  public String b = "https://qun.qq.com/qqweb/m/qun/qun_robot/auto-approval.html?_wv=1027&gc=$GCODE$&page=groupSetting";
  
  public aqdn()
  {
    this.jdField_a_of_type_JavaLangString = "https://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=$GCODE$&role=$ROLE$&actionIcon=1&from=troop_profile";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static aqdn a(aptx[] paramArrayOfaptx)
  {
    aqdn localaqdn = new aqdn();
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      int j = paramArrayOfaptx.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfaptx[i];
        if ((localObject == null) || (((aptx)localObject).jdField_a_of_type_JavaLangString == null))
        {
          i += 1;
        }
        else
        {
          localObject = ((aptx)localObject).jdField_a_of_type_JavaLangString;
          for (;;)
          {
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject);
              if (localJSONObject.has("announcementUrl")) {
                localaqdn.jdField_a_of_type_JavaLangString = localJSONObject.optString("announcementUrl");
              }
              if (localJSONObject.has("autoApprovalUrl")) {
                localaqdn.b = localJSONObject.optString("autoApprovalUrl");
              }
              if (!localJSONObject.has("frequencyLimitVisible")) {
                continue;
              }
              if (localJSONObject.getInt("frequencyLimitVisible") != 1) {
                continue;
              }
              bool = true;
              localaqdn.jdField_a_of_type_Boolean = bool;
            }
            catch (JSONException localJSONException)
            {
              boolean bool;
              localJSONException.printStackTrace();
              continue;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("TroopUrlConfBean", 2, "parse: " + (String)localObject);
            break;
            bool = false;
            continue;
            localaqdn.jdField_a_of_type_Boolean = false;
          }
        }
      }
    }
    if (TextUtils.isEmpty(localaqdn.jdField_a_of_type_JavaLangString)) {
      localaqdn.jdField_a_of_type_JavaLangString = "https://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=$GCODE$&role=$ROLE$&actionIcon=1&from=troop_profile";
    }
    if (TextUtils.isEmpty(localaqdn.b)) {
      localaqdn.b = "https://qun.qq.com/qqweb/m/qun/qun_robot/auto-approval.html?_wv=1027&gc=$GCODE$&page=groupSetting";
    }
    return localaqdn;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("TroopUrlConfBean [announcement: ").append(this.jdField_a_of_type_JavaLangString).append(", autoApproval: ").append(this.b).append(", freqLimitVisible: ").append(this.jdField_a_of_type_Boolean).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqdn
 * JD-Core Version:    0.7.0.1
 */