import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class apza
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g = amtj.a(2131706611);
  private static final String h = amtj.a(2131706608);
  private static final String i = amtj.a(2131706605);
  private static final String j = amtj.a(2131706609);
  private static final String k = amtj.a(2131706622);
  private static final String l = amtj.a(2131706614);
  private static final String m = amtj.a(2131706606);
  private static final String n = amtj.a(2131706610);
  public int a;
  public final apzb a;
  public boolean a;
  public final apzb b;
  public final apzb c;
  public final apzb d;
  public final apzb e;
  public final apzb f;
  
  static
  {
    jdField_a_of_type_JavaLangString = amtj.a(2131706623);
    jdField_b_of_type_JavaLangString = amtj.a(2131706617);
    jdField_c_of_type_JavaLangString = amtj.a(2131706604);
    jdField_d_of_type_JavaLangString = amtj.a(2131706607);
    jdField_e_of_type_JavaLangString = amtj.a(2131706612);
    jdField_f_of_type_JavaLangString = amtj.a(2131706619);
  }
  
  public apza()
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Apzb = new apzb(jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_Apzb = new apzb(jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_f_of_type_JavaLangString);
    this.jdField_c_of_type_Apzb = new apzb(g, "", h);
    this.jdField_d_of_type_Apzb = new apzb(i, "", j);
    this.jdField_e_of_type_Apzb = new apzb(k, "", l);
    this.jdField_f_of_type_Apzb = new apzb(m, "", n);
  }
  
  public static apza a(aptx[] paramArrayOfaptx)
  {
    apza localapza = new apza();
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      int i2 = paramArrayOfaptx.length;
      int i1 = 0;
      if (i1 < i2)
      {
        Object localObject = paramArrayOfaptx[i1];
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject = ((aptx)localObject).jdField_a_of_type_JavaLangString;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            localapza.jdField_a_of_type_Boolean = localJSONObject.optBoolean("newFriendContactsBannerEnable", false);
            localapza.jdField_a_of_type_Int = localJSONObject.optInt("totalCount", 0);
            a(localapza.jdField_a_of_type_Apzb, localJSONObject.optJSONObject("unauthorized"), jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localapza.jdField_b_of_type_Apzb, localJSONObject.optJSONObject("unbound"), jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localapza.jdField_c_of_type_Apzb, localJSONObject.optJSONObject("contactsListUnauthorized"), g, "", h);
            a(localapza.jdField_d_of_type_Apzb, localJSONObject.optJSONObject("contactsListUnbinding"), i, "", j);
            a(localapza.jdField_e_of_type_Apzb, localJSONObject.optJSONObject("contactsListInactive"), k, "", l);
            a(localapza.jdField_f_of_type_Apzb, localJSONObject.optJSONObject("contactsListUnmatched"), m, "", n);
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
      QLog.i("NewFriendContactGuideConfBean", 2, "parse: " + localapza);
    }
    return localapza;
  }
  
  private static void a(apzb paramapzb, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (paramapzb == null) {
      return;
    }
    if (paramJSONObject != null)
    {
      paramapzb.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", paramString1);
      paramapzb.jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", paramString2);
      paramapzb.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonTitle", paramString3);
      return;
    }
    paramapzb.jdField_a_of_type_JavaLangString = paramString1;
    paramapzb.jdField_b_of_type_JavaLangString = paramString2;
    paramapzb.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public String toString()
  {
    return "NewFriendContactGuideConfBean(" + this.jdField_a_of_type_Boolean + ", " + this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_Apzb + ", " + this.jdField_b_of_type_Apzb + ", " + this.jdField_c_of_type_Apzb + ", " + this.jdField_d_of_type_Apzb + ", " + this.jdField_e_of_type_Apzb + ", " + this.jdField_f_of_type_Apzb + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apza
 * JD-Core Version:    0.7.0.1
 */