import android.support.v4.util.ArrayMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class anar
{
  private int jdField_a_of_type_Int;
  private ArrayMap<String, ArrayList<anas>> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(5);
  
  public static anar a()
  {
    return (anar)ampl.a().a(432);
  }
  
  public static anar a(amph paramamph)
  {
    int i = 0;
    anar localanar = new anar();
    if (paramamph != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfBean", 2, "parse taskid->" + paramamph.jdField_a_of_type_Int + " content->" + paramamph.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        paramamph = new JSONObject(paramamph.jdField_a_of_type_JavaLangString);
        localanar.a(paramamph.optInt("switch", 0));
        paramamph = paramamph.optJSONArray("templateinfo");
        if (paramamph != null)
        {
          localArrayList1 = new ArrayList(10);
          localArrayList2 = new ArrayList(10);
          int j = paramamph.length();
          if (i >= j) {
            break label292;
          }
          JSONObject localJSONObject = paramamph.optJSONObject(i);
          if (localJSONObject == null) {
            break label310;
          }
          anas localanas = new anas();
          localanas.jdField_a_of_type_Int = localJSONObject.optInt("templateid");
          localanas.jdField_a_of_type_JavaLangString = localJSONObject.optString("templatetype");
          localanas.c = localJSONObject.optString("templatever");
          localanas.b = localJSONObject.optString("templatename");
          localanas.d = localJSONObject.optString("templateview");
          if ("ark".equals(localanas.jdField_a_of_type_JavaLangString)) {
            localArrayList1.add(localanas);
          } else if ("native".equals(localanas.jdField_a_of_type_JavaLangString)) {
            localArrayList2.add(localanas);
          }
        }
      }
      catch (Exception paramamph)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchRichConfBean", 2, "parse error->" + paramamph.toString());
        }
      }
      return localanar;
      label292:
      localanar.a("ark", localArrayList1);
      localanar.a("native", localArrayList2);
      return localanar;
      label310:
      i += 1;
    }
  }
  
  public ArrayList<anas> a(String paramString)
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
  
  void a(String paramString, ArrayList<anas> paramArrayList)
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
 * Qualified Name:     anar
 * JD-Core Version:    0.7.0.1
 */