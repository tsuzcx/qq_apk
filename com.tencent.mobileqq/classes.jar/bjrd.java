import android.text.TextUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.util.QQDeviceInfo;
import cooperation.wadl.ipc.WadlParams;
import org.json.JSONException;
import org.json.JSONObject;

public class bjrd
{
  public static String a;
  private static int b;
  private static String j;
  private static String k;
  public int a;
  public long a;
  public WadlParams a;
  public long b;
  public String b;
  public String c = "";
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  static
  {
    try
    {
      j = DeviceInfoUtil.getAndroidID();
      jdField_b_of_type_Int = DeviceInfoUtil.getCarrier();
      jdField_a_of_type_JavaLangString = QQDeviceInfo.getIMEI("b84cf5");
      k = DeviceInfoUtil.getIMSI();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static bjrd a()
  {
    bjrd localbjrd = new bjrd();
    try
    {
      localbjrd.jdField_b_of_type_Long = (DeviceInfoUtil.getSystemAvaialbeMemory() / 1048576L);
      localbjrd.i = String.valueOf(DeviceInfoUtil.getSDCardMemory()[1]);
      localbjrd.jdField_b_of_type_JavaLangString = "";
      localbjrd.jdField_a_of_type_Int = 0;
      return localbjrd;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localbjrd;
  }
  
  public String a()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(j))
        {
          String str1 = j;
          localJSONObject.put("androidId", str1);
          if (!TextUtils.isEmpty(k))
          {
            str1 = k;
            localJSONObject.put("imsi", str1);
            localJSONObject.put("mobileCarriers", jdField_b_of_type_Int);
            localJSONObject.put("leftMemorySize", this.jdField_b_of_type_Long);
            localJSONObject.put("pageUrl", this.e);
            return localJSONObject.toString();
          }
          str1 = "";
          continue;
        }
        String str2 = "";
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjrd
 * JD-Core Version:    0.7.0.1
 */