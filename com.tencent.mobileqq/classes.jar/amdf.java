import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amdf
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g = ajjy.a(2131641703);
  private static final String h = ajjy.a(2131641700);
  private static final String i = ajjy.a(2131641697);
  private static final String j = ajjy.a(2131641701);
  private static final String k = ajjy.a(2131641714);
  private static final String l = ajjy.a(2131641706);
  private static final String m = ajjy.a(2131641698);
  private static final String n = ajjy.a(2131641702);
  public int a;
  public final amdg a;
  public boolean a;
  public final amdg b;
  public final amdg c;
  public final amdg d;
  public final amdg e;
  public final amdg f;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajjy.a(2131641715);
    jdField_b_of_type_JavaLangString = ajjy.a(2131641709);
    jdField_c_of_type_JavaLangString = ajjy.a(2131641696);
    jdField_d_of_type_JavaLangString = ajjy.a(2131641699);
    jdField_e_of_type_JavaLangString = ajjy.a(2131641704);
    jdField_f_of_type_JavaLangString = ajjy.a(2131641711);
  }
  
  public amdf()
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Amdg = new amdg(jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_Amdg = new amdg(jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_f_of_type_JavaLangString);
    this.jdField_c_of_type_Amdg = new amdg(g, "", h);
    this.jdField_d_of_type_Amdg = new amdg(i, "", j);
    this.jdField_e_of_type_Amdg = new amdg(k, "", l);
    this.jdField_f_of_type_Amdg = new amdg(m, "", n);
  }
  
  public static amdf a(alzs[] paramArrayOfalzs)
  {
    amdf localamdf = new amdf();
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      int i2 = paramArrayOfalzs.length;
      int i1 = 0;
      if (i1 < i2)
      {
        Object localObject = paramArrayOfalzs[i1];
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject = ((alzs)localObject).jdField_a_of_type_JavaLangString;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            localamdf.jdField_a_of_type_Boolean = localJSONObject.optBoolean("newFriendContactsBannerEnable", false);
            localamdf.jdField_a_of_type_Int = localJSONObject.optInt("totalCount", 0);
            a(localamdf.jdField_a_of_type_Amdg, localJSONObject.optJSONObject("unauthorized"), jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localamdf.jdField_b_of_type_Amdg, localJSONObject.optJSONObject("unbound"), jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localamdf.jdField_c_of_type_Amdg, localJSONObject.optJSONObject("contactsListUnauthorized"), g, "", h);
            a(localamdf.jdField_d_of_type_Amdg, localJSONObject.optJSONObject("contactsListUnbinding"), i, "", j);
            a(localamdf.jdField_e_of_type_Amdg, localJSONObject.optJSONObject("contactsListInactive"), k, "", l);
            a(localamdf.jdField_f_of_type_Amdg, localJSONObject.optJSONObject("contactsListUnmatched"), m, "", n);
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
      QLog.i("NewFriendContactGuideConfBean", 2, "parse: " + localamdf);
    }
    return localamdf;
  }
  
  private static void a(amdg paramamdg, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (paramamdg == null) {
      return;
    }
    if (paramJSONObject != null)
    {
      paramamdg.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", paramString1);
      paramamdg.jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", paramString2);
      paramamdg.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonTitle", paramString3);
      return;
    }
    paramamdg.jdField_a_of_type_JavaLangString = paramString1;
    paramamdg.jdField_b_of_type_JavaLangString = paramString2;
    paramamdg.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public String toString()
  {
    return "NewFriendContactGuideConfBean(" + this.jdField_a_of_type_Boolean + ", " + this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_Amdg + ", " + this.jdField_b_of_type_Amdg + ", " + this.jdField_c_of_type_Amdg + ", " + this.jdField_d_of_type_Amdg + ", " + this.jdField_e_of_type_Amdg + ", " + this.jdField_f_of_type_Amdg + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdf
 * JD-Core Version:    0.7.0.1
 */