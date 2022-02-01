import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arfk
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g = anzj.a(2131706381);
  private static final String h = anzj.a(2131706378);
  private static final String i = anzj.a(2131706375);
  private static final String j = anzj.a(2131706379);
  private static final String k = anzj.a(2131706392);
  private static final String l = anzj.a(2131706384);
  private static final String m = anzj.a(2131706376);
  private static final String n = anzj.a(2131706380);
  public int a;
  public final arfl a;
  public boolean a;
  public final arfl b;
  public final arfl c;
  public final arfl d;
  public final arfl e;
  public final arfl f;
  
  static
  {
    jdField_a_of_type_JavaLangString = anzj.a(2131706393);
    jdField_b_of_type_JavaLangString = anzj.a(2131706387);
    jdField_c_of_type_JavaLangString = anzj.a(2131706374);
    jdField_d_of_type_JavaLangString = anzj.a(2131706377);
    jdField_e_of_type_JavaLangString = anzj.a(2131706382);
    jdField_f_of_type_JavaLangString = anzj.a(2131706389);
  }
  
  public arfk()
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Arfl = new arfl(jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_Arfl = new arfl(jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_f_of_type_JavaLangString);
    this.jdField_c_of_type_Arfl = new arfl(g, "", h);
    this.jdField_d_of_type_Arfl = new arfl(i, "", j);
    this.jdField_e_of_type_Arfl = new arfl(k, "", l);
    this.jdField_f_of_type_Arfl = new arfl(m, "", n);
  }
  
  public static arfk a(araj[] paramArrayOfaraj)
  {
    arfk localarfk = new arfk();
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      int i2 = paramArrayOfaraj.length;
      int i1 = 0;
      if (i1 < i2)
      {
        Object localObject = paramArrayOfaraj[i1];
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject = ((araj)localObject).jdField_a_of_type_JavaLangString;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            localarfk.jdField_a_of_type_Boolean = localJSONObject.optBoolean("newFriendContactsBannerEnable", false);
            localarfk.jdField_a_of_type_Int = localJSONObject.optInt("totalCount", 0);
            a(localarfk.jdField_a_of_type_Arfl, localJSONObject.optJSONObject("unauthorized"), jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localarfk.jdField_b_of_type_Arfl, localJSONObject.optJSONObject("unbound"), jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localarfk.jdField_c_of_type_Arfl, localJSONObject.optJSONObject("contactsListUnauthorized"), g, "", h);
            a(localarfk.jdField_d_of_type_Arfl, localJSONObject.optJSONObject("contactsListUnbinding"), i, "", j);
            a(localarfk.jdField_e_of_type_Arfl, localJSONObject.optJSONObject("contactsListInactive"), k, "", l);
            a(localarfk.jdField_f_of_type_Arfl, localJSONObject.optJSONObject("contactsListUnmatched"), m, "", n);
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
      QLog.i("NewFriendContactGuideConfBean", 2, "parse: " + localarfk);
    }
    return localarfk;
  }
  
  private static void a(arfl paramarfl, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (paramarfl == null) {
      return;
    }
    if (paramJSONObject != null)
    {
      paramarfl.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", paramString1);
      paramarfl.jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", paramString2);
      paramarfl.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonTitle", paramString3);
      return;
    }
    paramarfl.jdField_a_of_type_JavaLangString = paramString1;
    paramarfl.jdField_b_of_type_JavaLangString = paramString2;
    paramarfl.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public String toString()
  {
    return "NewFriendContactGuideConfBean(" + this.jdField_a_of_type_Boolean + ", " + this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_Arfl + ", " + this.jdField_b_of_type_Arfl + ", " + this.jdField_c_of_type_Arfl + ", " + this.jdField_d_of_type_Arfl + ", " + this.jdField_e_of_type_Arfl + ", " + this.jdField_f_of_type_Arfl + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfk
 * JD-Core Version:    0.7.0.1
 */