import android.support.v4.util.ArrayMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aroy
{
  private int jdField_a_of_type_Int;
  private ArrayMap<String, ArrayList<aroz>> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(5);
  private int b = 1;
  private int c = 1;
  private int d = 1;
  private int e = 1;
  private int f = 1;
  
  public static aroy a()
  {
    return (aroy)aran.a().a(432);
  }
  
  public static aroy a(araj paramaraj)
  {
    int i = 0;
    aroy localaroy = new aroy();
    if (paramaraj != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfBean", 2, "parse taskid->" + paramaraj.jdField_a_of_type_Int + " content->" + paramaraj.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        paramaraj = new JSONObject(paramaraj.jdField_a_of_type_JavaLangString);
        int j = paramaraj.optInt("switch", 0);
        int k = paramaraj.optInt("ftsEnableMsgSwitch", 1);
        int m = paramaraj.optInt("showMessageResult", 1);
        int n = paramaraj.optInt("ftsEnableSwitch", 1);
        int i1 = paramaraj.optInt("ftsEnableTroopSwitch", 1);
        int i2 = paramaraj.optInt("ftsEnableFtsFilter", 1);
        localaroy.a(j);
        localaroy.b(k);
        localaroy.c(m);
        localaroy.c = n;
        localaroy.e = i1;
        localaroy.f = i2;
        paramaraj = paramaraj.optJSONArray("templateinfo");
        if (paramaraj != null)
        {
          localArrayList1 = new ArrayList(10);
          localArrayList2 = new ArrayList(10);
          j = paramaraj.length();
          if (i >= j) {
            break label375;
          }
          JSONObject localJSONObject = paramaraj.optJSONObject(i);
          if (localJSONObject == null) {
            break label396;
          }
          aroz localaroz = new aroz();
          localaroz.jdField_a_of_type_Int = localJSONObject.optInt("templateid");
          localaroz.jdField_a_of_type_JavaLangString = localJSONObject.optString("templatetype");
          localaroz.c = localJSONObject.optString("templatever");
          localaroz.b = localJSONObject.optString("templatename");
          localaroz.d = localJSONObject.optString("templateview");
          if ("ark".equals(localaroz.jdField_a_of_type_JavaLangString)) {
            localArrayList1.add(localaroz);
          } else if ("native".equals(localaroz.jdField_a_of_type_JavaLangString)) {
            localArrayList2.add(localaroz);
          }
        }
      }
      catch (Exception paramaraj)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchRichConfBean", 2, "parse error->" + paramaraj.toString());
        }
      }
      return localaroy;
      label375:
      localaroy.a("ark", localArrayList1);
      localaroy.a("native", localArrayList2);
      return localaroy;
      label396:
      i += 1;
    }
  }
  
  public ArrayList<aroz> a(String paramString)
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
  
  void a(String paramString, ArrayList<aroz> paramArrayList)
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
 * Qualified Name:     aroy
 * JD-Core Version:    0.7.0.1
 */