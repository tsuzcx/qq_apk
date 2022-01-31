import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public class bgwq
  extends bgwo
{
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("name", "pay");
      localJSONObject1.put("identifier", this.i);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("code", this.jdField_c_of_type_Int);
      localJSONObject2.put("message", this.a);
      ((JSONObject)localObject).put("action", localJSONObject1);
      ((JSONObject)localObject).put("params", localJSONObject2);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putString("_mqqpay_payresp_paychanneltype", this.jdField_c_of_type_JavaLangString);
    paramBundle.putString("_mqqpay_payresp_transactionid", this.d);
    paramBundle.putString("_mqqpay_payresp_paytime", this.e);
    paramBundle.putString("_mqqpay_payresp_totalfee", this.f);
    paramBundle.putString("_mqqpay_payresp_callbackurl", this.g);
    paramBundle.putString("_mqqpay_payresp_spdata", this.h);
    paramBundle.putString("_mqqpay_payapi_serialnumber", this.i);
    paramBundle.putString("_mqqpay_payapi_openid", this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwq
 * JD-Core Version:    0.7.0.1
 */