import android.support.v4.util.ArrayMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aory
{
  private int jdField_a_of_type_Int;
  private ArrayMap<String, ArrayList<aorz>> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(5);
  private int b = 1;
  private int c = 1;
  private int d = 1;
  private int e = 1;
  private int f = 1;
  
  public static aory a()
  {
    return (aory)aogj.a().a(432);
  }
  
  public static aory a(aogf paramaogf)
  {
    int i = 0;
    aory localaory = new aory();
    if (paramaogf != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfBean", 2, "parse taskid->" + paramaogf.jdField_a_of_type_Int + " content->" + paramaogf.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        paramaogf = new JSONObject(paramaogf.jdField_a_of_type_JavaLangString);
        int j = paramaogf.optInt("switch", 0);
        int k = paramaogf.optInt("ftsEnableMsgSwitch", 1);
        int m = paramaogf.optInt("showMessageResult", 1);
        int n = paramaogf.optInt("ftsEnableSwitch", 1);
        int i1 = paramaogf.optInt("ftsEnableTroopSwitch", 1);
        int i2 = paramaogf.optInt("ftsEnableFtsFilter", 1);
        localaory.a(j);
        localaory.b(k);
        localaory.c(m);
        localaory.c = n;
        localaory.e = i1;
        localaory.f = i2;
        paramaogf = paramaogf.optJSONArray("templateinfo");
        if (paramaogf != null)
        {
          localArrayList1 = new ArrayList(10);
          localArrayList2 = new ArrayList(10);
          j = paramaogf.length();
          if (i >= j) {
            break label375;
          }
          JSONObject localJSONObject = paramaogf.optJSONObject(i);
          if (localJSONObject == null) {
            break label396;
          }
          aorz localaorz = new aorz();
          localaorz.jdField_a_of_type_Int = localJSONObject.optInt("templateid");
          localaorz.jdField_a_of_type_JavaLangString = localJSONObject.optString("templatetype");
          localaorz.c = localJSONObject.optString("templatever");
          localaorz.b = localJSONObject.optString("templatename");
          localaorz.d = localJSONObject.optString("templateview");
          if ("ark".equals(localaorz.jdField_a_of_type_JavaLangString)) {
            localArrayList1.add(localaorz);
          } else if ("native".equals(localaorz.jdField_a_of_type_JavaLangString)) {
            localArrayList2.add(localaorz);
          }
        }
      }
      catch (Exception paramaogf)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchRichConfBean", 2, "parse error->" + paramaogf.toString());
        }
      }
      return localaory;
      label375:
      localaory.a("ark", localArrayList1);
      localaory.a("native", localArrayList2);
      return localaory;
      label396:
      i += 1;
    }
  }
  
  public ArrayList<aorz> a(String paramString)
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
  
  void a(String paramString, ArrayList<aorz> paramArrayList)
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
 * Qualified Name:     aory
 * JD-Core Version:    0.7.0.1
 */