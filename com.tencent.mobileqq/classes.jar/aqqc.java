import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqqc
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g = anni.a(2131706274);
  private static final String h = anni.a(2131706271);
  private static final String i = anni.a(2131706268);
  private static final String j = anni.a(2131706272);
  private static final String k = anni.a(2131706285);
  private static final String l = anni.a(2131706277);
  private static final String m = anni.a(2131706269);
  private static final String n = anni.a(2131706273);
  public int a;
  public final aqqd a;
  public boolean a;
  public final aqqd b;
  public final aqqd c;
  public final aqqd d;
  public final aqqd e;
  public final aqqd f;
  
  static
  {
    jdField_a_of_type_JavaLangString = anni.a(2131706286);
    jdField_b_of_type_JavaLangString = anni.a(2131706280);
    jdField_c_of_type_JavaLangString = anni.a(2131706267);
    jdField_d_of_type_JavaLangString = anni.a(2131706270);
    jdField_e_of_type_JavaLangString = anni.a(2131706275);
    jdField_f_of_type_JavaLangString = anni.a(2131706282);
  }
  
  public aqqc()
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Aqqd = new aqqd(jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_Aqqd = new aqqd(jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_f_of_type_JavaLangString);
    this.jdField_c_of_type_Aqqd = new aqqd(g, "", h);
    this.jdField_d_of_type_Aqqd = new aqqd(i, "", j);
    this.jdField_e_of_type_Aqqd = new aqqd(k, "", l);
    this.jdField_f_of_type_Aqqd = new aqqd(m, "", n);
  }
  
  public static aqqc a(aqlg[] paramArrayOfaqlg)
  {
    aqqc localaqqc = new aqqc();
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      int i2 = paramArrayOfaqlg.length;
      int i1 = 0;
      if (i1 < i2)
      {
        Object localObject = paramArrayOfaqlg[i1];
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject = ((aqlg)localObject).jdField_a_of_type_JavaLangString;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            localaqqc.jdField_a_of_type_Boolean = localJSONObject.optBoolean("newFriendContactsBannerEnable", false);
            localaqqc.jdField_a_of_type_Int = localJSONObject.optInt("totalCount", 0);
            a(localaqqc.jdField_a_of_type_Aqqd, localJSONObject.optJSONObject("unauthorized"), jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localaqqc.jdField_b_of_type_Aqqd, localJSONObject.optJSONObject("unbound"), jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localaqqc.jdField_c_of_type_Aqqd, localJSONObject.optJSONObject("contactsListUnauthorized"), g, "", h);
            a(localaqqc.jdField_d_of_type_Aqqd, localJSONObject.optJSONObject("contactsListUnbinding"), i, "", j);
            a(localaqqc.jdField_e_of_type_Aqqd, localJSONObject.optJSONObject("contactsListInactive"), k, "", l);
            a(localaqqc.jdField_f_of_type_Aqqd, localJSONObject.optJSONObject("contactsListUnmatched"), m, "", n);
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
      QLog.i("NewFriendContactGuideConfBean", 2, "parse: " + localaqqc);
    }
    return localaqqc;
  }
  
  private static void a(aqqd paramaqqd, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (paramaqqd == null) {
      return;
    }
    if (paramJSONObject != null)
    {
      paramaqqd.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", paramString1);
      paramaqqd.jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", paramString2);
      paramaqqd.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonTitle", paramString3);
      return;
    }
    paramaqqd.jdField_a_of_type_JavaLangString = paramString1;
    paramaqqd.jdField_b_of_type_JavaLangString = paramString2;
    paramaqqd.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public String toString()
  {
    return "NewFriendContactGuideConfBean(" + this.jdField_a_of_type_Boolean + ", " + this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_Aqqd + ", " + this.jdField_b_of_type_Aqqd + ", " + this.jdField_c_of_type_Aqqd + ", " + this.jdField_d_of_type_Aqqd + ", " + this.jdField_e_of_type_Aqqd + ", " + this.jdField_f_of_type_Aqqd + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqqc
 * JD-Core Version:    0.7.0.1
 */