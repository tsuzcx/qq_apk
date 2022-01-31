import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amth
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g = ajyc.a(2131707488);
  private static final String h = ajyc.a(2131707485);
  private static final String i = ajyc.a(2131707482);
  private static final String j = ajyc.a(2131707486);
  private static final String k = ajyc.a(2131707499);
  private static final String l = ajyc.a(2131707491);
  private static final String m = ajyc.a(2131707483);
  private static final String n = ajyc.a(2131707487);
  public int a;
  public final amti a;
  public boolean a;
  public final amti b;
  public final amti c;
  public final amti d;
  public final amti e;
  public final amti f;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajyc.a(2131707500);
    jdField_b_of_type_JavaLangString = ajyc.a(2131707494);
    jdField_c_of_type_JavaLangString = ajyc.a(2131707481);
    jdField_d_of_type_JavaLangString = ajyc.a(2131707484);
    jdField_e_of_type_JavaLangString = ajyc.a(2131707489);
    jdField_f_of_type_JavaLangString = ajyc.a(2131707496);
  }
  
  public amth()
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Amti = new amti(jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_Amti = new amti(jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_f_of_type_JavaLangString);
    this.jdField_c_of_type_Amti = new amti(g, "", h);
    this.jdField_d_of_type_Amti = new amti(i, "", j);
    this.jdField_e_of_type_Amti = new amti(k, "", l);
    this.jdField_f_of_type_Amti = new amti(m, "", n);
  }
  
  public static amth a(ampi[] paramArrayOfampi)
  {
    amth localamth = new amth();
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      int i2 = paramArrayOfampi.length;
      int i1 = 0;
      if (i1 < i2)
      {
        Object localObject = paramArrayOfampi[i1];
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject = ((ampi)localObject).jdField_a_of_type_JavaLangString;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            localamth.jdField_a_of_type_Boolean = localJSONObject.optBoolean("newFriendContactsBannerEnable", false);
            localamth.jdField_a_of_type_Int = localJSONObject.optInt("totalCount", 0);
            a(localamth.jdField_a_of_type_Amti, localJSONObject.optJSONObject("unauthorized"), jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localamth.jdField_b_of_type_Amti, localJSONObject.optJSONObject("unbound"), jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localamth.jdField_c_of_type_Amti, localJSONObject.optJSONObject("contactsListUnauthorized"), g, "", h);
            a(localamth.jdField_d_of_type_Amti, localJSONObject.optJSONObject("contactsListUnbinding"), i, "", j);
            a(localamth.jdField_e_of_type_Amti, localJSONObject.optJSONObject("contactsListInactive"), k, "", l);
            a(localamth.jdField_f_of_type_Amti, localJSONObject.optJSONObject("contactsListUnmatched"), m, "", n);
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
      QLog.i("NewFriendContactGuideConfBean", 2, "parse: " + localamth);
    }
    return localamth;
  }
  
  private static void a(amti paramamti, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (paramamti == null) {
      return;
    }
    if (paramJSONObject != null)
    {
      paramamti.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", paramString1);
      paramamti.jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", paramString2);
      paramamti.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonTitle", paramString3);
      return;
    }
    paramamti.jdField_a_of_type_JavaLangString = paramString1;
    paramamti.jdField_b_of_type_JavaLangString = paramString2;
    paramamti.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public String toString()
  {
    return "NewFriendContactGuideConfBean(" + this.jdField_a_of_type_Boolean + ", " + this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_Amti + ", " + this.jdField_b_of_type_Amti + ", " + this.jdField_c_of_type_Amti + ", " + this.jdField_d_of_type_Amti + ", " + this.jdField_e_of_type_Amti + ", " + this.jdField_f_of_type_Amti + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amth
 * JD-Core Version:    0.7.0.1
 */