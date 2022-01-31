import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoki
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g = alpo.a(2131707871);
  private static final String h = alpo.a(2131707868);
  private static final String i = alpo.a(2131707865);
  private static final String j = alpo.a(2131707869);
  private static final String k = alpo.a(2131707882);
  private static final String l = alpo.a(2131707874);
  private static final String m = alpo.a(2131707866);
  private static final String n = alpo.a(2131707870);
  public int a;
  public final aokj a;
  public boolean a;
  public final aokj b;
  public final aokj c;
  public final aokj d;
  public final aokj e;
  public final aokj f;
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131707883);
    jdField_b_of_type_JavaLangString = alpo.a(2131707877);
    jdField_c_of_type_JavaLangString = alpo.a(2131707864);
    jdField_d_of_type_JavaLangString = alpo.a(2131707867);
    jdField_e_of_type_JavaLangString = alpo.a(2131707872);
    jdField_f_of_type_JavaLangString = alpo.a(2131707879);
  }
  
  public aoki()
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Aokj = new aokj(jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_Aokj = new aokj(jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_f_of_type_JavaLangString);
    this.jdField_c_of_type_Aokj = new aokj(g, "", h);
    this.jdField_d_of_type_Aokj = new aokj(i, "", j);
    this.jdField_e_of_type_Aokj = new aokj(k, "", l);
    this.jdField_f_of_type_Aokj = new aokj(m, "", n);
  }
  
  public static aoki a(aogf[] paramArrayOfaogf)
  {
    aoki localaoki = new aoki();
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      int i2 = paramArrayOfaogf.length;
      int i1 = 0;
      if (i1 < i2)
      {
        Object localObject = paramArrayOfaogf[i1];
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject = ((aogf)localObject).jdField_a_of_type_JavaLangString;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            localaoki.jdField_a_of_type_Boolean = localJSONObject.optBoolean("newFriendContactsBannerEnable", false);
            localaoki.jdField_a_of_type_Int = localJSONObject.optInt("totalCount", 0);
            a(localaoki.jdField_a_of_type_Aokj, localJSONObject.optJSONObject("unauthorized"), jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localaoki.jdField_b_of_type_Aokj, localJSONObject.optJSONObject("unbound"), jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localaoki.jdField_c_of_type_Aokj, localJSONObject.optJSONObject("contactsListUnauthorized"), g, "", h);
            a(localaoki.jdField_d_of_type_Aokj, localJSONObject.optJSONObject("contactsListUnbinding"), i, "", j);
            a(localaoki.jdField_e_of_type_Aokj, localJSONObject.optJSONObject("contactsListInactive"), k, "", l);
            a(localaoki.jdField_f_of_type_Aokj, localJSONObject.optJSONObject("contactsListUnmatched"), m, "", n);
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
      QLog.i("NewFriendContactGuideConfBean", 2, "parse: " + localaoki);
    }
    return localaoki;
  }
  
  private static void a(aokj paramaokj, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (paramaokj == null) {
      return;
    }
    if (paramJSONObject != null)
    {
      paramaokj.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", paramString1);
      paramaokj.jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", paramString2);
      paramaokj.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonTitle", paramString3);
      return;
    }
    paramaokj.jdField_a_of_type_JavaLangString = paramString1;
    paramaokj.jdField_b_of_type_JavaLangString = paramString2;
    paramaokj.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public String toString()
  {
    return "NewFriendContactGuideConfBean(" + this.jdField_a_of_type_Boolean + ", " + this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_Aokj + ", " + this.jdField_b_of_type_Aokj + ", " + this.jdField_c_of_type_Aokj + ", " + this.jdField_d_of_type_Aokj + ", " + this.jdField_e_of_type_Aokj + ", " + this.jdField_f_of_type_Aokj + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoki
 * JD-Core Version:    0.7.0.1
 */