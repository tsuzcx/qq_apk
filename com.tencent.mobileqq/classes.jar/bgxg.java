import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class bgxg
  extends bgxe
{
  public long a;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.e = paramBundle.getString("_mqqpay_payapi_serialnumber");
    this.f = paramBundle.getString("_mqqpay_payapi_callbackscheme");
    this.g = paramBundle.getString("_mqqpay_payapi_pubacc");
    this.h = paramBundle.getString("_mqqpay_payapi_pubacchint");
    this.i = paramBundle.getString("_mqqpay_payapi_tokenid");
    this.j = paramBundle.getString("_mqqpay_payapi_nonce");
    this.jdField_a_of_type_Long = paramBundle.getLong("_mqqpay_payapi_timeStamp");
    this.k = paramBundle.getString("_mqqpay_payapi_bargainorId");
    this.l = paramBundle.getString("_mqqpay_payapi_sigType");
    this.m = paramBundle.getString("_mqqpay_payapi_sig");
    this.n = paramBundle.getString("_mqqpay_payapi_packageName");
  }
  
  public void a(String paramString)
  {
    this.c = "browser";
    this.d = "pay";
    this.jdField_a_of_type_Int = 1;
    try
    {
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = paramString.optJSONObject("action");
      if (localJSONObject != null)
      {
        String str = localJSONObject.optString("name");
        if (str != null)
        {
          if (!str.equals("pay")) {
            return;
          }
          this.e = localJSONObject.optString("identifier");
          localJSONObject = paramString.optJSONObject("application");
          if (localJSONObject != null)
          {
            this.jdField_a_of_type_JavaLangString = localJSONObject.optString("appId");
            this.b = localJSONObject.optString("sdkVersion");
            this.n = localJSONObject.optString("pkgName");
            this.f = localJSONObject.optString("urlScheme");
          }
          paramString = paramString.optJSONObject("params");
          if (paramString != null)
          {
            this.i = paramString.optString("tokenId");
            this.jdField_a_of_type_Long = paramString.optLong("timeStamp");
            this.j = paramString.optString("nonce");
            this.k = paramString.optString("bargainorId");
            this.l = "HMAC-SHA1";
            this.m = paramString.optString("sig");
            return;
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    while ((TextUtils.isEmpty(this.c)) || ((!this.c.equals("native")) && (!this.c.equals("browser"))) || (TextUtils.isEmpty(this.n)) || ((!this.c.equals("browser")) && (TextUtils.isEmpty(this.f))) || (TextUtils.isEmpty(this.i)) || (TextUtils.isEmpty(this.k)) || (TextUtils.isEmpty(this.j)) || (TextUtils.isEmpty(this.m)) || (TextUtils.isEmpty(this.l)) || (this.jdField_a_of_type_Long <= 0L) || (TextUtils.isEmpty(this.e))) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(super.toString());
    localStringBuilder.append("&sn=" + this.e);
    localStringBuilder.append("&cs=" + this.f);
    localStringBuilder.append("&pa=" + this.g);
    localStringBuilder.append("&pah=" + this.h);
    localStringBuilder.append("&ti=" + this.i);
    localStringBuilder.append("&ne=" + this.j);
    localStringBuilder.append("&ts=" + this.jdField_a_of_type_Long);
    localStringBuilder.append("&bi=" + this.k);
    localStringBuilder.append("&st=" + this.l);
    localStringBuilder.append("&sg=" + this.m);
    localStringBuilder.append("&pn=" + this.n);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgxg
 * JD-Core Version:    0.7.0.1
 */