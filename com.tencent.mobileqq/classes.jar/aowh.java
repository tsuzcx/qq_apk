import android.support.v4.util.ArrayMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aowh
{
  private int jdField_a_of_type_Int;
  private ArrayMap<String, ArrayList<aowi>> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(5);
  private int b = 1;
  private int c = 1;
  private int d = 1;
  private int e = 1;
  private int f = 1;
  
  public static aowh a()
  {
    return (aowh)aoks.a().a(432);
  }
  
  public static aowh a(aoko paramaoko)
  {
    int i = 0;
    aowh localaowh = new aowh();
    if (paramaoko != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfBean", 2, "parse taskid->" + paramaoko.jdField_a_of_type_Int + " content->" + paramaoko.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        paramaoko = new JSONObject(paramaoko.jdField_a_of_type_JavaLangString);
        int j = paramaoko.optInt("switch", 0);
        int k = paramaoko.optInt("ftsEnableMsgSwitch", 1);
        int m = paramaoko.optInt("showMessageResult", 1);
        int n = paramaoko.optInt("ftsEnableSwitch", 1);
        int i1 = paramaoko.optInt("ftsEnableTroopSwitch", 1);
        int i2 = paramaoko.optInt("ftsEnableFtsFilter", 1);
        localaowh.a(j);
        localaowh.b(k);
        localaowh.c(m);
        localaowh.c = n;
        localaowh.e = i1;
        localaowh.f = i2;
        paramaoko = paramaoko.optJSONArray("templateinfo");
        if (paramaoko != null)
        {
          localArrayList1 = new ArrayList(10);
          localArrayList2 = new ArrayList(10);
          j = paramaoko.length();
          if (i >= j) {
            break label375;
          }
          JSONObject localJSONObject = paramaoko.optJSONObject(i);
          if (localJSONObject == null) {
            break label396;
          }
          aowi localaowi = new aowi();
          localaowi.jdField_a_of_type_Int = localJSONObject.optInt("templateid");
          localaowi.jdField_a_of_type_JavaLangString = localJSONObject.optString("templatetype");
          localaowi.c = localJSONObject.optString("templatever");
          localaowi.b = localJSONObject.optString("templatename");
          localaowi.d = localJSONObject.optString("templateview");
          if ("ark".equals(localaowi.jdField_a_of_type_JavaLangString)) {
            localArrayList1.add(localaowi);
          } else if ("native".equals(localaowi.jdField_a_of_type_JavaLangString)) {
            localArrayList2.add(localaowi);
          }
        }
      }
      catch (Exception paramaoko)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchRichConfBean", 2, "parse error->" + paramaoko.toString());
        }
      }
      return localaowh;
      label375:
      localaowh.a("ark", localArrayList1);
      localaowh.a("native", localArrayList2);
      return localaowh;
      label396:
      i += 1;
    }
  }
  
  public ArrayList<aowi> a(String paramString)
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
  
  void a(String paramString, ArrayList<aowi> paramArrayList)
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
 * Qualified Name:     aowh
 * JD-Core Version:    0.7.0.1
 */