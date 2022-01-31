import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class asbv
{
  public int a;
  public long a;
  public String a;
  public ArrayList<asbw> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public asbv()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 999;
  }
  
  public static asbv a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return null;
    }
    localasbv = new asbv();
    try
    {
      localasbv.jdField_a_of_type_Long = paramJSONObject.optLong("type");
      localasbv.jdField_a_of_type_JavaLangString = paramJSONObject.optString("cluster");
      localasbv.jdField_b_of_type_JavaLangString = paramJSONObject.optString("ruleUrl");
      if (paramJSONObject.has("disableLocalResource")) {
        if (paramJSONObject.optInt("disableLocalResource") != 1) {
          break label145;
        }
      }
      label145:
      for (boolean bool = true;; bool = false)
      {
        localasbv.jdField_b_of_type_Boolean = bool;
        if (!paramJSONObject.has("typeItem")) {
          break;
        }
        paramJSONObject = paramJSONObject.optJSONArray("typeItem");
        localasbv.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < paramJSONObject.length())
        {
          asbw localasbw = asbw.a(paramJSONObject.getJSONObject(i));
          if (localasbw != null)
          {
            localasbv.jdField_a_of_type_JavaUtilArrayList.add(localasbw);
            localasbw.jdField_a_of_type_Asbv = localasbv;
          }
          i += 1;
        }
      }
      return localasbv;
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
          asbw localasbw = (asbw)localIterator.next();
          if ((localasbw == null) || (!localasbw.jdField_a_of_type_Boolean) || (localasbw.jdField_b_of_type_Long > paramLong)) {
            break label97;
          }
          l1 = localasbw.jdField_b_of_type_Long;
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
  
  public asbw a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        asbw localasbw = (asbw)localIterator.next();
        if ((localasbw != null) && (localasbw.jdField_b_of_type_Long == paramLong)) {
          return localasbw;
        }
      }
    }
    return null;
  }
  
  public String a(long paramLong)
  {
    asbw localasbw = a(paramLong);
    if (localasbw != null) {
      return localasbw.jdField_b_of_type_JavaLangString;
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
        asbw localasbw = (asbw)localIterator.next();
        if ((localasbw != null) && (localasbw.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    asbw localasbw = a(paramLong);
    if (localasbw != null) {
      return localasbw.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asbv
 * JD-Core Version:    0.7.0.1
 */