import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class asxz
{
  public int a;
  public long a;
  public String a;
  public ArrayList<asya> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public asxz()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 999;
  }
  
  public static asxz a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return null;
    }
    localasxz = new asxz();
    try
    {
      localasxz.jdField_a_of_type_Long = paramJSONObject.optLong("type");
      localasxz.jdField_a_of_type_JavaLangString = paramJSONObject.optString("cluster");
      localasxz.jdField_b_of_type_JavaLangString = paramJSONObject.optString("ruleUrl");
      if (paramJSONObject.has("disableLocalResource")) {
        if (paramJSONObject.optInt("disableLocalResource") != 1) {
          break label145;
        }
      }
      label145:
      for (boolean bool = true;; bool = false)
      {
        localasxz.jdField_b_of_type_Boolean = bool;
        if (!paramJSONObject.has("typeItem")) {
          break;
        }
        paramJSONObject = paramJSONObject.optJSONArray("typeItem");
        localasxz.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < paramJSONObject.length())
        {
          asya localasya = asya.a(paramJSONObject.getJSONObject(i));
          if (localasya != null)
          {
            localasxz.jdField_a_of_type_JavaUtilArrayList.add(localasya);
            localasya.jdField_a_of_type_Asxz = localasxz;
          }
          i += 1;
        }
      }
      return localasxz;
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
          asya localasya = (asya)localIterator.next();
          if ((localasya == null) || (!localasya.jdField_a_of_type_Boolean) || (localasya.jdField_b_of_type_Long > paramLong)) {
            break label97;
          }
          l1 = localasya.jdField_b_of_type_Long;
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
  
  public asya a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        asya localasya = (asya)localIterator.next();
        if ((localasya != null) && (localasya.jdField_b_of_type_Long == paramLong)) {
          return localasya;
        }
      }
    }
    return null;
  }
  
  public String a(long paramLong)
  {
    asya localasya = a(paramLong);
    if (localasya != null) {
      return localasya.jdField_b_of_type_JavaLangString;
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
        asya localasya = (asya)localIterator.next();
        if ((localasya != null) && (localasya.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    asya localasya = a(paramLong);
    if (localasya != null) {
      return localasya.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxz
 * JD-Core Version:    0.7.0.1
 */