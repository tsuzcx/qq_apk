import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class axan
{
  public int a;
  public long a;
  public String a;
  public ArrayList<axao> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public axan()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 999;
  }
  
  public static axan a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return null;
    }
    localaxan = new axan();
    try
    {
      localaxan.jdField_a_of_type_Long = paramJSONObject.optLong("type");
      localaxan.jdField_a_of_type_JavaLangString = paramJSONObject.optString("cluster");
      localaxan.jdField_b_of_type_JavaLangString = paramJSONObject.optString("ruleUrl");
      if (paramJSONObject.has("disableLocalResource")) {
        if (paramJSONObject.optInt("disableLocalResource") != 1) {
          break label145;
        }
      }
      label145:
      for (boolean bool = true;; bool = false)
      {
        localaxan.jdField_b_of_type_Boolean = bool;
        if (!paramJSONObject.has("typeItem")) {
          break;
        }
        paramJSONObject = paramJSONObject.optJSONArray("typeItem");
        localaxan.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < paramJSONObject.length())
        {
          axao localaxao = axao.a(paramJSONObject.getJSONObject(i));
          if (localaxao != null)
          {
            localaxan.jdField_a_of_type_JavaUtilArrayList.add(localaxao);
            localaxao.jdField_a_of_type_Axan = localaxan;
          }
          i += 1;
        }
      }
      return localaxan;
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
          axao localaxao = (axao)localIterator.next();
          if ((localaxao == null) || (!localaxao.jdField_a_of_type_Boolean) || (localaxao.jdField_b_of_type_Long > paramLong)) {
            break label97;
          }
          l1 = localaxao.jdField_b_of_type_Long;
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
  
  public axao a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        axao localaxao = (axao)localIterator.next();
        if ((localaxao != null) && (localaxao.jdField_b_of_type_Long == paramLong)) {
          return localaxao;
        }
      }
    }
    return null;
  }
  
  public String a(long paramLong)
  {
    axao localaxao = a(paramLong);
    if (localaxao != null) {
      return localaxao.jdField_b_of_type_JavaLangString;
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
        axao localaxao = (axao)localIterator.next();
        if ((localaxao != null) && (localaxao.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    axao localaxao = a(paramLong);
    if (localaxao != null) {
      return localaxao.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axan
 * JD-Core Version:    0.7.0.1
 */