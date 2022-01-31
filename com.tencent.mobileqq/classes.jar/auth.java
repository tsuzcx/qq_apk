import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class auth
{
  public int a;
  public long a;
  public String a;
  public ArrayList<auti> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public auth()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 999;
  }
  
  public static auth a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return null;
    }
    localauth = new auth();
    try
    {
      localauth.jdField_a_of_type_Long = paramJSONObject.optLong("type");
      localauth.jdField_a_of_type_JavaLangString = paramJSONObject.optString("cluster");
      localauth.jdField_b_of_type_JavaLangString = paramJSONObject.optString("ruleUrl");
      if (paramJSONObject.has("disableLocalResource")) {
        if (paramJSONObject.optInt("disableLocalResource") != 1) {
          break label145;
        }
      }
      label145:
      for (boolean bool = true;; bool = false)
      {
        localauth.jdField_b_of_type_Boolean = bool;
        if (!paramJSONObject.has("typeItem")) {
          break;
        }
        paramJSONObject = paramJSONObject.optJSONArray("typeItem");
        localauth.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < paramJSONObject.length())
        {
          auti localauti = auti.a(paramJSONObject.getJSONObject(i));
          if (localauti != null)
          {
            localauth.jdField_a_of_type_JavaUtilArrayList.add(localauti);
            localauti.jdField_a_of_type_Auth = localauth;
          }
          i += 1;
        }
      }
      return localauth;
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
          auti localauti = (auti)localIterator.next();
          if ((localauti == null) || (!localauti.jdField_a_of_type_Boolean) || (localauti.jdField_b_of_type_Long > paramLong)) {
            break label97;
          }
          l1 = localauti.jdField_b_of_type_Long;
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
  
  public auti a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        auti localauti = (auti)localIterator.next();
        if ((localauti != null) && (localauti.jdField_b_of_type_Long == paramLong)) {
          return localauti;
        }
      }
    }
    return null;
  }
  
  public String a(long paramLong)
  {
    auti localauti = a(paramLong);
    if (localauti != null) {
      return localauti.jdField_b_of_type_JavaLangString;
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
        auti localauti = (auti)localIterator.next();
        if ((localauti != null) && (localauti.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    auti localauti = a(paramLong);
    if (localauti != null) {
      return localauti.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auth
 * JD-Core Version:    0.7.0.1
 */