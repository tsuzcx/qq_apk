import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class auoy
{
  public int a;
  public long a;
  public String a;
  public ArrayList<auoz> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public auoy()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 999;
  }
  
  public static auoy a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return null;
    }
    localauoy = new auoy();
    try
    {
      localauoy.jdField_a_of_type_Long = paramJSONObject.optLong("type");
      localauoy.jdField_a_of_type_JavaLangString = paramJSONObject.optString("cluster");
      localauoy.jdField_b_of_type_JavaLangString = paramJSONObject.optString("ruleUrl");
      if (paramJSONObject.has("disableLocalResource")) {
        if (paramJSONObject.optInt("disableLocalResource") != 1) {
          break label145;
        }
      }
      label145:
      for (boolean bool = true;; bool = false)
      {
        localauoy.jdField_b_of_type_Boolean = bool;
        if (!paramJSONObject.has("typeItem")) {
          break;
        }
        paramJSONObject = paramJSONObject.optJSONArray("typeItem");
        localauoy.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < paramJSONObject.length())
        {
          auoz localauoz = auoz.a(paramJSONObject.getJSONObject(i));
          if (localauoz != null)
          {
            localauoy.jdField_a_of_type_JavaUtilArrayList.add(localauoz);
            localauoz.jdField_a_of_type_Auoy = localauoy;
          }
          i += 1;
        }
      }
      return localauoy;
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
          auoz localauoz = (auoz)localIterator.next();
          if ((localauoz == null) || (!localauoz.jdField_a_of_type_Boolean) || (localauoz.jdField_b_of_type_Long > paramLong)) {
            break label97;
          }
          l1 = localauoz.jdField_b_of_type_Long;
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
  
  public auoz a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        auoz localauoz = (auoz)localIterator.next();
        if ((localauoz != null) && (localauoz.jdField_b_of_type_Long == paramLong)) {
          return localauoz;
        }
      }
    }
    return null;
  }
  
  public String a(long paramLong)
  {
    auoz localauoz = a(paramLong);
    if (localauoz != null) {
      return localauoz.jdField_b_of_type_JavaLangString;
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
        auoz localauoz = (auoz)localIterator.next();
        if ((localauoz != null) && (localauoz.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    auoz localauoz = a(paramLong);
    if (localauoz != null) {
      return localauoz.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auoy
 * JD-Core Version:    0.7.0.1
 */