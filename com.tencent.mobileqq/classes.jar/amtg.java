import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amtg
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g = ajya.a(2131707499);
  private static final String h = ajya.a(2131707496);
  private static final String i = ajya.a(2131707493);
  private static final String j = ajya.a(2131707497);
  private static final String k = ajya.a(2131707510);
  private static final String l = ajya.a(2131707502);
  private static final String m = ajya.a(2131707494);
  private static final String n = ajya.a(2131707498);
  public int a;
  public final amth a;
  public boolean a;
  public final amth b;
  public final amth c;
  public final amth d;
  public final amth e;
  public final amth f;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131707511);
    jdField_b_of_type_JavaLangString = ajya.a(2131707505);
    jdField_c_of_type_JavaLangString = ajya.a(2131707492);
    jdField_d_of_type_JavaLangString = ajya.a(2131707495);
    jdField_e_of_type_JavaLangString = ajya.a(2131707500);
    jdField_f_of_type_JavaLangString = ajya.a(2131707507);
  }
  
  public amtg()
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Amth = new amth(jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_Amth = new amth(jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_f_of_type_JavaLangString);
    this.jdField_c_of_type_Amth = new amth(g, "", h);
    this.jdField_d_of_type_Amth = new amth(i, "", j);
    this.jdField_e_of_type_Amth = new amth(k, "", l);
    this.jdField_f_of_type_Amth = new amth(m, "", n);
  }
  
  public static amtg a(amph[] paramArrayOfamph)
  {
    amtg localamtg = new amtg();
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      int i2 = paramArrayOfamph.length;
      int i1 = 0;
      if (i1 < i2)
      {
        Object localObject = paramArrayOfamph[i1];
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject = ((amph)localObject).jdField_a_of_type_JavaLangString;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            localamtg.jdField_a_of_type_Boolean = localJSONObject.optBoolean("newFriendContactsBannerEnable", false);
            localamtg.jdField_a_of_type_Int = localJSONObject.optInt("totalCount", 0);
            a(localamtg.jdField_a_of_type_Amth, localJSONObject.optJSONObject("unauthorized"), jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localamtg.jdField_b_of_type_Amth, localJSONObject.optJSONObject("unbound"), jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localamtg.jdField_c_of_type_Amth, localJSONObject.optJSONObject("contactsListUnauthorized"), g, "", h);
            a(localamtg.jdField_d_of_type_Amth, localJSONObject.optJSONObject("contactsListUnbinding"), i, "", j);
            a(localamtg.jdField_e_of_type_Amth, localJSONObject.optJSONObject("contactsListInactive"), k, "", l);
            a(localamtg.jdField_f_of_type_Amth, localJSONObject.optJSONObject("contactsListUnmatched"), m, "", n);
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
      QLog.i("NewFriendContactGuideConfBean", 2, "parse: " + localamtg);
    }
    return localamtg;
  }
  
  private static void a(amth paramamth, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (paramamth == null) {
      return;
    }
    if (paramJSONObject != null)
    {
      paramamth.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", paramString1);
      paramamth.jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", paramString2);
      paramamth.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonTitle", paramString3);
      return;
    }
    paramamth.jdField_a_of_type_JavaLangString = paramString1;
    paramamth.jdField_b_of_type_JavaLangString = paramString2;
    paramamth.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public String toString()
  {
    return "NewFriendContactGuideConfBean(" + this.jdField_a_of_type_Boolean + ", " + this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_Amth + ", " + this.jdField_b_of_type_Amth + ", " + this.jdField_c_of_type_Amth + ", " + this.jdField_d_of_type_Amth + ", " + this.jdField_e_of_type_Amth + ", " + this.jdField_f_of_type_Amth + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amtg
 * JD-Core Version:    0.7.0.1
 */