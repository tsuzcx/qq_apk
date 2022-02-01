import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class axtg
{
  public int a;
  public long a;
  public String a;
  public ArrayList<axti> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public axtg()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 999;
  }
  
  public static axtg a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return null;
    }
    localaxtg = new axtg();
    try
    {
      localaxtg.jdField_a_of_type_Long = paramJSONObject.optLong("type");
      localaxtg.jdField_a_of_type_JavaLangString = paramJSONObject.optString("cluster");
      localaxtg.jdField_b_of_type_JavaLangString = paramJSONObject.optString("ruleUrl");
      if (paramJSONObject.has("disableLocalResource")) {
        if (paramJSONObject.optInt("disableLocalResource") != 1) {
          break label145;
        }
      }
      label145:
      for (boolean bool = true;; bool = false)
      {
        localaxtg.jdField_b_of_type_Boolean = bool;
        if (!paramJSONObject.has("typeItem")) {
          break;
        }
        paramJSONObject = paramJSONObject.optJSONArray("typeItem");
        localaxtg.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < paramJSONObject.length())
        {
          axti localaxti = axti.a(paramJSONObject.getJSONObject(i));
          if (localaxti != null)
          {
            localaxtg.jdField_a_of_type_JavaUtilArrayList.add(localaxti);
            localaxti.jdField_a_of_type_Axtg = localaxtg;
          }
          i += 1;
        }
      }
      return localaxtg;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("MutualMarkConfigIRType", 1, "parse error->" + paramJSONObject.toString());
      return null;
    }
  }
  
  public long a(long paramLong)
  {
    long l2 = -1L;
    long l1 = l2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      l1 = l2;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        l1 = -1L;
        if (localIterator.hasNext())
        {
          axti localaxti = (axti)localIterator.next();
          if ((localaxti == null) || (!localaxti.jdField_a_of_type_Boolean) || (localaxti.jdField_b_of_type_Long > paramLong)) {
            break label97;
          }
          l1 = localaxti.jdField_b_of_type_Long;
        }
      }
    }
    label97:
    for (;;)
    {
      break;
      return l1;
    }
  }
  
  public axti a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        axti localaxti = (axti)localIterator.next();
        if ((localaxti != null) && (localaxti.jdField_b_of_type_Long == paramLong)) {
          return localaxti;
        }
      }
    }
    return null;
  }
  
  public String a(long paramLong)
  {
    axti localaxti = a(paramLong);
    if (localaxti != null) {
      return localaxti.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        axti localaxti = (axti)localIterator.next();
        if ((localaxti != null) && (localaxti.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    axti localaxti = a(paramLong);
    if (localaxti != null) {
      return localaxti.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtg
 * JD-Core Version:    0.7.0.1
 */