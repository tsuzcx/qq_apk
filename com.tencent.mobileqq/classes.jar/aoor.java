import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoor
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g = alud.a(2131707883);
  private static final String h = alud.a(2131707880);
  private static final String i = alud.a(2131707877);
  private static final String j = alud.a(2131707881);
  private static final String k = alud.a(2131707894);
  private static final String l = alud.a(2131707886);
  private static final String m = alud.a(2131707878);
  private static final String n = alud.a(2131707882);
  public int a;
  public final aoos a;
  public boolean a;
  public final aoos b;
  public final aoos c;
  public final aoos d;
  public final aoos e;
  public final aoos f;
  
  static
  {
    jdField_a_of_type_JavaLangString = alud.a(2131707895);
    jdField_b_of_type_JavaLangString = alud.a(2131707889);
    jdField_c_of_type_JavaLangString = alud.a(2131707876);
    jdField_d_of_type_JavaLangString = alud.a(2131707879);
    jdField_e_of_type_JavaLangString = alud.a(2131707884);
    jdField_f_of_type_JavaLangString = alud.a(2131707891);
  }
  
  public aoor()
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Aoos = new aoos(jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_Aoos = new aoos(jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_f_of_type_JavaLangString);
    this.jdField_c_of_type_Aoos = new aoos(g, "", h);
    this.jdField_d_of_type_Aoos = new aoos(i, "", j);
    this.jdField_e_of_type_Aoos = new aoos(k, "", l);
    this.jdField_f_of_type_Aoos = new aoos(m, "", n);
  }
  
  public static aoor a(aoko[] paramArrayOfaoko)
  {
    aoor localaoor = new aoor();
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      int i2 = paramArrayOfaoko.length;
      int i1 = 0;
      if (i1 < i2)
      {
        Object localObject = paramArrayOfaoko[i1];
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject = ((aoko)localObject).jdField_a_of_type_JavaLangString;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            localaoor.jdField_a_of_type_Boolean = localJSONObject.optBoolean("newFriendContactsBannerEnable", false);
            localaoor.jdField_a_of_type_Int = localJSONObject.optInt("totalCount", 0);
            a(localaoor.jdField_a_of_type_Aoos, localJSONObject.optJSONObject("unauthorized"), jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localaoor.jdField_b_of_type_Aoos, localJSONObject.optJSONObject("unbound"), jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localaoor.jdField_c_of_type_Aoos, localJSONObject.optJSONObject("contactsListUnauthorized"), g, "", h);
            a(localaoor.jdField_d_of_type_Aoos, localJSONObject.optJSONObject("contactsListUnbinding"), i, "", j);
            a(localaoor.jdField_e_of_type_Aoos, localJSONObject.optJSONObject("contactsListInactive"), k, "", l);
            a(localaoor.jdField_f_of_type_Aoos, localJSONObject.optJSONObject("contactsListUnmatched"), m, "", n);
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
      QLog.i("NewFriendContactGuideConfBean", 2, "parse: " + localaoor);
    }
    return localaoor;
  }
  
  private static void a(aoos paramaoos, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (paramaoos == null) {
      return;
    }
    if (paramJSONObject != null)
    {
      paramaoos.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", paramString1);
      paramaoos.jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", paramString2);
      paramaoos.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonTitle", paramString3);
      return;
    }
    paramaoos.jdField_a_of_type_JavaLangString = paramString1;
    paramaoos.jdField_b_of_type_JavaLangString = paramString2;
    paramaoos.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public String toString()
  {
    return "NewFriendContactGuideConfBean(" + this.jdField_a_of_type_Boolean + ", " + this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_Aoos + ", " + this.jdField_b_of_type_Aoos + ", " + this.jdField_c_of_type_Aoos + ", " + this.jdField_d_of_type_Aoos + ", " + this.jdField_e_of_type_Aoos + ", " + this.jdField_f_of_type_Aoos + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoor
 * JD-Core Version:    0.7.0.1
 */