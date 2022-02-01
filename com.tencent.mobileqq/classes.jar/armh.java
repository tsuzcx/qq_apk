import android.support.v4.util.ArrayMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class armh
{
  private int jdField_a_of_type_Int;
  private ArrayMap<String, ArrayList<armi>> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(5);
  private int b = 1;
  private int c = 1;
  private int d = 1;
  private int e = 1;
  private int f = 1;
  
  public static armh a()
  {
    return (armh)aqxe.a().a(432);
  }
  
  public static armh a(aqxa paramaqxa)
  {
    int i = 0;
    armh localarmh = new armh();
    if (paramaqxa != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfBean", 2, "parse taskid->" + paramaqxa.jdField_a_of_type_Int + " content->" + paramaqxa.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        paramaqxa = new JSONObject(paramaqxa.jdField_a_of_type_JavaLangString);
        int j = paramaqxa.optInt("switch", 0);
        int k = paramaqxa.optInt("ftsEnableMsgSwitch", 1);
        int m = paramaqxa.optInt("showMessageResult", 1);
        int n = paramaqxa.optInt("ftsEnableSwitch", 1);
        int i1 = paramaqxa.optInt("ftsEnableTroopSwitch", 1);
        int i2 = paramaqxa.optInt("ftsEnableFtsFilter", 1);
        localarmh.a(j);
        localarmh.b(k);
        localarmh.c(m);
        localarmh.c = n;
        localarmh.e = i1;
        localarmh.f = i2;
        paramaqxa = paramaqxa.optJSONArray("templateinfo");
        if (paramaqxa != null)
        {
          localArrayList1 = new ArrayList(10);
          localArrayList2 = new ArrayList(10);
          j = paramaqxa.length();
          if (i >= j) {
            break label375;
          }
          JSONObject localJSONObject = paramaqxa.optJSONObject(i);
          if (localJSONObject == null) {
            break label396;
          }
          armi localarmi = new armi();
          localarmi.jdField_a_of_type_Int = localJSONObject.optInt("templateid");
          localarmi.jdField_a_of_type_JavaLangString = localJSONObject.optString("templatetype");
          localarmi.c = localJSONObject.optString("templatever");
          localarmi.b = localJSONObject.optString("templatename");
          localarmi.d = localJSONObject.optString("templateview");
          if ("ark".equals(localarmi.jdField_a_of_type_JavaLangString)) {
            localArrayList1.add(localarmi);
          } else if ("native".equals(localarmi.jdField_a_of_type_JavaLangString)) {
            localArrayList2.add(localarmi);
          }
        }
      }
      catch (Exception paramaqxa)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchRichConfBean", 2, "parse error->" + paramaqxa.toString());
        }
      }
      return localarmh;
      label375:
      localarmh.a("ark", localArrayList1);
      localarmh.a("native", localArrayList2);
      return localarmh;
      label396:
      i += 1;
    }
  }
  
  public ArrayList<armi> a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap != null) {
      return (ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString);
    }
    return null;
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a(String paramString, ArrayList<armi> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilArrayMap != null) && (paramString != null)) {
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(paramString, paramArrayList);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public boolean b()
  {
    return this.c == 1;
  }
  
  void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean c()
  {
    return this.e == 1;
  }
  
  public boolean d()
  {
    return this.f == 1;
  }
  
  public boolean e()
  {
    return this.d == 1;
  }
  
  public boolean f()
  {
    return this.b == 1;
  }
  
  public String toString()
  {
    int i = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap != null) {}
    for (String str = this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.toString();; str = "null") {
      return String.format("mRichSwitch:%d  templateData:%s", new Object[] { Integer.valueOf(i), str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armh
 * JD-Core Version:    0.7.0.1
 */