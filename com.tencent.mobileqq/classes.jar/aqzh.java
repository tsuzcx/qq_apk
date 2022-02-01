import android.support.v4.util.ArrayMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqzh
{
  private int jdField_a_of_type_Int;
  private ArrayMap<String, ArrayList<aqzi>> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(5);
  private int b = 1;
  private int c = 1;
  private int d = 1;
  private int e = 1;
  private int f = 1;
  
  public static aqzh a()
  {
    return (aqzh)aqlk.a().a(432);
  }
  
  public static aqzh a(aqlg paramaqlg)
  {
    int i = 0;
    aqzh localaqzh = new aqzh();
    if (paramaqlg != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfBean", 2, "parse taskid->" + paramaqlg.jdField_a_of_type_Int + " content->" + paramaqlg.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        paramaqlg = new JSONObject(paramaqlg.jdField_a_of_type_JavaLangString);
        int j = paramaqlg.optInt("switch", 0);
        int k = paramaqlg.optInt("ftsEnableMsgSwitch", 1);
        int m = paramaqlg.optInt("showMessageResult", 1);
        int n = paramaqlg.optInt("ftsEnableSwitch", 1);
        int i1 = paramaqlg.optInt("ftsEnableTroopSwitch", 1);
        int i2 = paramaqlg.optInt("ftsEnableFtsFilter", 1);
        localaqzh.a(j);
        localaqzh.b(k);
        localaqzh.c(m);
        localaqzh.c = n;
        localaqzh.e = i1;
        localaqzh.f = i2;
        paramaqlg = paramaqlg.optJSONArray("templateinfo");
        if (paramaqlg != null)
        {
          localArrayList1 = new ArrayList(10);
          localArrayList2 = new ArrayList(10);
          j = paramaqlg.length();
          if (i >= j) {
            break label375;
          }
          JSONObject localJSONObject = paramaqlg.optJSONObject(i);
          if (localJSONObject == null) {
            break label396;
          }
          aqzi localaqzi = new aqzi();
          localaqzi.jdField_a_of_type_Int = localJSONObject.optInt("templateid");
          localaqzi.jdField_a_of_type_JavaLangString = localJSONObject.optString("templatetype");
          localaqzi.c = localJSONObject.optString("templatever");
          localaqzi.b = localJSONObject.optString("templatename");
          localaqzi.d = localJSONObject.optString("templateview");
          if ("ark".equals(localaqzi.jdField_a_of_type_JavaLangString)) {
            localArrayList1.add(localaqzi);
          } else if ("native".equals(localaqzi.jdField_a_of_type_JavaLangString)) {
            localArrayList2.add(localaqzi);
          }
        }
      }
      catch (Exception paramaqlg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchRichConfBean", 2, "parse error->" + paramaqlg.toString());
        }
      }
      return localaqzh;
      label375:
      localaqzh.a("ark", localArrayList1);
      localaqzh.a("native", localArrayList2);
      return localaqzh;
      label396:
      i += 1;
    }
  }
  
  public ArrayList<aqzi> a(String paramString)
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
  
  void a(String paramString, ArrayList<aqzi> paramArrayList)
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
 * Qualified Name:     aqzh
 * JD-Core Version:    0.7.0.1
 */