import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class argu
{
  public String a;
  public boolean a;
  public String b = "https://qun.qq.com/qqweb/m/qun/qun_robot/auto-approval.html?_wv=1027&gc=$GCODE$&page=groupSetting";
  
  public argu()
  {
    this.jdField_a_of_type_JavaLangString = "https://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=$GCODE$&role=$ROLE$&actionIcon=1&from=troop_profile";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static argu a(aqxa[] paramArrayOfaqxa)
  {
    argu localargu = new argu();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      int j = paramArrayOfaqxa.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfaqxa[i];
        if ((localObject == null) || (((aqxa)localObject).jdField_a_of_type_JavaLangString == null))
        {
          i += 1;
        }
        else
        {
          localObject = ((aqxa)localObject).jdField_a_of_type_JavaLangString;
          for (;;)
          {
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject);
              if (localJSONObject.has("announcementUrl")) {
                localargu.jdField_a_of_type_JavaLangString = localJSONObject.optString("announcementUrl");
              }
              if (localJSONObject.has("autoApprovalUrl")) {
                localargu.b = localJSONObject.optString("autoApprovalUrl");
              }
              if (!localJSONObject.has("frequencyLimitVisible")) {
                continue;
              }
              if (localJSONObject.getInt("frequencyLimitVisible") != 1) {
                continue;
              }
              bool = true;
              localargu.jdField_a_of_type_Boolean = bool;
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
            localargu.jdField_a_of_type_Boolean = false;
          }
        }
      }
    }
    if (TextUtils.isEmpty(localargu.jdField_a_of_type_JavaLangString)) {
      localargu.jdField_a_of_type_JavaLangString = "https://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=$GCODE$&role=$ROLE$&actionIcon=1&from=troop_profile";
    }
    if (TextUtils.isEmpty(localargu.b)) {
      localargu.b = "https://qun.qq.com/qqweb/m/qun/qun_robot/auto-approval.html?_wv=1027&gc=$GCODE$&page=groupSetting";
    }
    return localargu;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("TroopUrlConfBean [announcement: ").append(this.jdField_a_of_type_JavaLangString).append(", autoApproval: ").append(this.b).append(", freqLimitVisible: ").append(this.jdField_a_of_type_Boolean).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argu
 * JD-Core Version:    0.7.0.1
 */