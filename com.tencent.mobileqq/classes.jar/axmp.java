import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class axmp
{
  public int a;
  public long a;
  public String a;
  public ArrayList<axmr> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public axmp()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 999;
  }
  
  public static axmp a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return null;
    }
    localaxmp = new axmp();
    try
    {
      localaxmp.jdField_a_of_type_Long = paramJSONObject.optLong("type");
      localaxmp.jdField_a_of_type_JavaLangString = paramJSONObject.optString("cluster");
      localaxmp.jdField_b_of_type_JavaLangString = paramJSONObject.optString("ruleUrl");
      if (paramJSONObject.has("disableLocalResource")) {
        if (paramJSONObject.optInt("disableLocalResource") != 1) {
          break label145;
        }
      }
      label145:
      for (boolean bool = true;; bool = false)
      {
        localaxmp.jdField_b_of_type_Boolean = bool;
        if (!paramJSONObject.has("typeItem")) {
          break;
        }
        paramJSONObject = paramJSONObject.optJSONArray("typeItem");
        localaxmp.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < paramJSONObject.length())
        {
          axmr localaxmr = axmr.a(paramJSONObject.getJSONObject(i));
          if (localaxmr != null)
          {
            localaxmp.jdField_a_of_type_JavaUtilArrayList.add(localaxmr);
            localaxmr.jdField_a_of_type_Axmp = localaxmp;
          }
          i += 1;
        }
      }
      return localaxmp;
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
          axmr localaxmr = (axmr)localIterator.next();
          if ((localaxmr == null) || (!localaxmr.jdField_a_of_type_Boolean) || (localaxmr.jdField_b_of_type_Long > paramLong)) {
            break label97;
          }
          l1 = localaxmr.jdField_b_of_type_Long;
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
  
  public axmr a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        axmr localaxmr = (axmr)localIterator.next();
        if ((localaxmr != null) && (localaxmr.jdField_b_of_type_Long == paramLong)) {
          return localaxmr;
        }
      }
    }
    return null;
  }
  
  public String a(long paramLong)
  {
    axmr localaxmr = a(paramLong);
    if (localaxmr != null) {
      return localaxmr.jdField_b_of_type_JavaLangString;
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
        axmr localaxmr = (axmr)localIterator.next();
        if ((localaxmr != null) && (localaxmr.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    axmr localaxmr = a(paramLong);
    if (localaxmr != null) {
      return localaxmr.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axmp
 * JD-Core Version:    0.7.0.1
 */