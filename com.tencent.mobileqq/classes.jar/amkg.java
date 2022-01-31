import android.support.v4.util.ArrayMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class amkg
{
  private int jdField_a_of_type_Int;
  private ArrayMap<String, ArrayList<amkh>> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(5);
  
  public static amkg a()
  {
    return (amkg)alzw.a().a(432);
  }
  
  public static amkg a(alzs paramalzs)
  {
    int i = 0;
    amkg localamkg = new amkg();
    if (paramalzs != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfBean", 2, "parse taskid->" + paramalzs.jdField_a_of_type_Int + " content->" + paramalzs.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        paramalzs = new JSONObject(paramalzs.jdField_a_of_type_JavaLangString);
        localamkg.a(paramalzs.optInt("switch", 0));
        paramalzs = paramalzs.optJSONArray("templateinfo");
        if (paramalzs != null)
        {
          localArrayList1 = new ArrayList(10);
          localArrayList2 = new ArrayList(10);
          int j = paramalzs.length();
          if (i >= j) {
            break label292;
          }
          JSONObject localJSONObject = paramalzs.optJSONObject(i);
          if (localJSONObject == null) {
            break label310;
          }
          amkh localamkh = new amkh();
          localamkh.jdField_a_of_type_Int = localJSONObject.optInt("templateid");
          localamkh.jdField_a_of_type_JavaLangString = localJSONObject.optString("templatetype");
          localamkh.c = localJSONObject.optString("templatever");
          localamkh.b = localJSONObject.optString("templatename");
          localamkh.d = localJSONObject.optString("templateview");
          if ("ark".equals(localamkh.jdField_a_of_type_JavaLangString)) {
            localArrayList1.add(localamkh);
          } else if ("native".equals(localamkh.jdField_a_of_type_JavaLangString)) {
            localArrayList2.add(localamkh);
          }
        }
      }
      catch (Exception paramalzs)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchRichConfBean", 2, "parse error->" + paramalzs.toString());
        }
      }
      return localamkg;
      label292:
      localamkg.a("ark", localArrayList1);
      localamkg.a("native", localArrayList2);
      return localamkg;
      label310:
      i += 1;
    }
  }
  
  public ArrayList<amkh> a(String paramString)
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
  
  void a(String paramString, ArrayList<amkh> paramArrayList)
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
 * Qualified Name:     amkg
 * JD-Core Version:    0.7.0.1
 */