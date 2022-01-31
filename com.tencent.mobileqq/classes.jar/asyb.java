import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class asyb
{
  public int a;
  public long a;
  public String a;
  public ArrayList<asyc> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public asyb()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 999;
  }
  
  public static asyb a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return null;
    }
    localasyb = new asyb();
    try
    {
      localasyb.jdField_a_of_type_Long = paramJSONObject.optLong("type");
      localasyb.jdField_a_of_type_JavaLangString = paramJSONObject.optString("cluster");
      localasyb.jdField_b_of_type_JavaLangString = paramJSONObject.optString("ruleUrl");
      if (paramJSONObject.has("disableLocalResource")) {
        if (paramJSONObject.optInt("disableLocalResource") != 1) {
          break label145;
        }
      }
      label145:
      for (boolean bool = true;; bool = false)
      {
        localasyb.jdField_b_of_type_Boolean = bool;
        if (!paramJSONObject.has("typeItem")) {
          break;
        }
        paramJSONObject = paramJSONObject.optJSONArray("typeItem");
        localasyb.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < paramJSONObject.length())
        {
          asyc localasyc = asyc.a(paramJSONObject.getJSONObject(i));
          if (localasyc != null)
          {
            localasyb.jdField_a_of_type_JavaUtilArrayList.add(localasyc);
            localasyc.jdField_a_of_type_Asyb = localasyb;
          }
          i += 1;
        }
      }
      return localasyb;
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
          asyc localasyc = (asyc)localIterator.next();
          if ((localasyc == null) || (!localasyc.jdField_a_of_type_Boolean) || (localasyc.jdField_b_of_type_Long > paramLong)) {
            break label97;
          }
          l1 = localasyc.jdField_b_of_type_Long;
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
  
  public asyc a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        asyc localasyc = (asyc)localIterator.next();
        if ((localasyc != null) && (localasyc.jdField_b_of_type_Long == paramLong)) {
          return localasyc;
        }
      }
    }
    return null;
  }
  
  public String a(long paramLong)
  {
    asyc localasyc = a(paramLong);
    if (localasyc != null) {
      return localasyc.jdField_b_of_type_JavaLangString;
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
        asyc localasyc = (asyc)localIterator.next();
        if ((localasyc != null) && (localasyc.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    asyc localasyc = a(paramLong);
    if (localasyc != null) {
      return localasyc.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asyb
 * JD-Core Version:    0.7.0.1
 */