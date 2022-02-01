import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arcd
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g = anvx.a(2131706963);
  private static final String h = anvx.a(2131706960);
  private static final String i = anvx.a(2131706957);
  private static final String j = anvx.a(2131706961);
  private static final String k = anvx.a(2131706974);
  private static final String l = anvx.a(2131706966);
  private static final String m = anvx.a(2131706958);
  private static final String n = anvx.a(2131706962);
  public int a;
  public final arce a;
  public boolean a;
  public final arce b;
  public final arce c;
  public final arce d;
  public final arce e;
  public final arce f;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131706975);
    jdField_b_of_type_JavaLangString = anvx.a(2131706969);
    jdField_c_of_type_JavaLangString = anvx.a(2131706956);
    jdField_d_of_type_JavaLangString = anvx.a(2131706959);
    jdField_e_of_type_JavaLangString = anvx.a(2131706964);
    jdField_f_of_type_JavaLangString = anvx.a(2131706971);
  }
  
  public arcd()
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Arce = new arce(jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_Arce = new arce(jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_f_of_type_JavaLangString);
    this.jdField_c_of_type_Arce = new arce(g, "", h);
    this.jdField_d_of_type_Arce = new arce(i, "", j);
    this.jdField_e_of_type_Arce = new arce(k, "", l);
    this.jdField_f_of_type_Arce = new arce(m, "", n);
  }
  
  public static arcd a(aqxa[] paramArrayOfaqxa)
  {
    arcd localarcd = new arcd();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      int i2 = paramArrayOfaqxa.length;
      int i1 = 0;
      if (i1 < i2)
      {
        Object localObject = paramArrayOfaqxa[i1];
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject = ((aqxa)localObject).jdField_a_of_type_JavaLangString;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            localarcd.jdField_a_of_type_Boolean = localJSONObject.optBoolean("newFriendContactsBannerEnable", false);
            localarcd.jdField_a_of_type_Int = localJSONObject.optInt("totalCount", 0);
            a(localarcd.jdField_a_of_type_Arce, localJSONObject.optJSONObject("unauthorized"), jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localarcd.jdField_b_of_type_Arce, localJSONObject.optJSONObject("unbound"), jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localarcd.jdField_c_of_type_Arce, localJSONObject.optJSONObject("contactsListUnauthorized"), g, "", h);
            a(localarcd.jdField_d_of_type_Arce, localJSONObject.optJSONObject("contactsListUnbinding"), i, "", j);
            a(localarcd.jdField_e_of_type_Arce, localJSONObject.optJSONObject("contactsListInactive"), k, "", l);
            a(localarcd.jdField_f_of_type_Arce, localJSONObject.optJSONObject("contactsListUnmatched"), m, "", n);
            if (QLog.isColorLevel()) {
              QLog.i("NewFriendContactGuideConfBean", 2, "parse: " + (String)localObject);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localThrowable.printStackTrace();
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendContactGuideConfBean", 2, "parse: " + localarcd);
    }
    return localarcd;
  }
  
  private static void a(arce paramarce, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (paramarce == null) {
      return;
    }
    if (paramJSONObject != null)
    {
      paramarce.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", paramString1);
      paramarce.jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", paramString2);
      paramarce.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonTitle", paramString3);
      return;
    }
    paramarce.jdField_a_of_type_JavaLangString = paramString1;
    paramarce.jdField_b_of_type_JavaLangString = paramString2;
    paramarce.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public String toString()
  {
    return "NewFriendContactGuideConfBean(" + this.jdField_a_of_type_Boolean + ", " + this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_Arce + ", " + this.jdField_b_of_type_Arce + ", " + this.jdField_c_of_type_Arce + ", " + this.jdField_d_of_type_Arce + ", " + this.jdField_e_of_type_Arce + ", " + this.jdField_f_of_type_Arce + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcd
 * JD-Core Version:    0.7.0.1
 */