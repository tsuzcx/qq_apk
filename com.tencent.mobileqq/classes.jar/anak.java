import android.support.v4.util.ArrayMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class anak
{
  private int jdField_a_of_type_Int;
  private ArrayMap<String, ArrayList<anal>> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(5);
  
  public static anak a()
  {
    return (anak)ampm.a().a(432);
  }
  
  public static anak a(ampi paramampi)
  {
    int i = 0;
    anak localanak = new anak();
    if (paramampi != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfBean", 2, "parse taskid->" + paramampi.jdField_a_of_type_Int + " content->" + paramampi.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        paramampi = new JSONObject(paramampi.jdField_a_of_type_JavaLangString);
        localanak.a(paramampi.optInt("switch", 0));
        paramampi = paramampi.optJSONArray("templateinfo");
        if (paramampi != null)
        {
          localArrayList1 = new ArrayList(10);
          localArrayList2 = new ArrayList(10);
          int j = paramampi.length();
          if (i >= j) {
            break label292;
          }
          JSONObject localJSONObject = paramampi.optJSONObject(i);
          if (localJSONObject == null) {
            break label310;
          }
          anal localanal = new anal();
          localanal.jdField_a_of_type_Int = localJSONObject.optInt("templateid");
          localanal.jdField_a_of_type_JavaLangString = localJSONObject.optString("templatetype");
          localanal.c = localJSONObject.optString("templatever");
          localanal.b = localJSONObject.optString("templatename");
          localanal.d = localJSONObject.optString("templateview");
          if ("ark".equals(localanal.jdField_a_of_type_JavaLangString)) {
            localArrayList1.add(localanal);
          } else if ("native".equals(localanal.jdField_a_of_type_JavaLangString)) {
            localArrayList2.add(localanal);
          }
        }
      }
      catch (Exception paramampi)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchRichConfBean", 2, "parse error->" + paramampi.toString());
        }
      }
      return localanak;
      label292:
      localanak.a("ark", localArrayList1);
      localanak.a("native", localArrayList2);
      return localanak;
      label310:
      i += 1;
    }
  }
  
  public ArrayList<anal> a(String paramString)
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
  
  void a(String paramString, ArrayList<anal> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilArrayMap != null) && (paramString != null)) {
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(paramString, paramArrayList);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
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
 * Qualified Name:     anak
 * JD-Core Version:    0.7.0.1
 */