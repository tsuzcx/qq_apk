import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class awgn
{
  public int a;
  public long a;
  public String a;
  public ArrayList<awgp> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public awgn()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 999;
  }
  
  public static awgn a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return null;
    }
    localawgn = new awgn();
    try
    {
      localawgn.jdField_a_of_type_Long = paramJSONObject.optLong("type");
      localawgn.jdField_a_of_type_JavaLangString = paramJSONObject.optString("cluster");
      localawgn.jdField_b_of_type_JavaLangString = paramJSONObject.optString("ruleUrl");
      if (paramJSONObject.has("disableLocalResource")) {
        if (paramJSONObject.optInt("disableLocalResource") != 1) {
          break label145;
        }
      }
      label145:
      for (boolean bool = true;; bool = false)
      {
        localawgn.jdField_b_of_type_Boolean = bool;
        if (!paramJSONObject.has("typeItem")) {
          break;
        }
        paramJSONObject = paramJSONObject.optJSONArray("typeItem");
        localawgn.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < paramJSONObject.length())
        {
          awgp localawgp = awgp.a(paramJSONObject.getJSONObject(i));
          if (localawgp != null)
          {
            localawgn.jdField_a_of_type_JavaUtilArrayList.add(localawgp);
            localawgp.jdField_a_of_type_Awgn = localawgn;
          }
          i += 1;
        }
      }
      return localawgn;
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
          awgp localawgp = (awgp)localIterator.next();
          if ((localawgp == null) || (!localawgp.jdField_a_of_type_Boolean) || (localawgp.jdField_b_of_type_Long > paramLong)) {
            break label97;
          }
          l1 = localawgp.jdField_b_of_type_Long;
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
  
  public awgp a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        awgp localawgp = (awgp)localIterator.next();
        if ((localawgp != null) && (localawgp.jdField_b_of_type_Long == paramLong)) {
          return localawgp;
        }
      }
    }
    return null;
  }
  
  public String a(long paramLong)
  {
    awgp localawgp = a(paramLong);
    if (localawgp != null) {
      return localawgp.jdField_b_of_type_JavaLangString;
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
        awgp localawgp = (awgp)localIterator.next();
        if ((localawgp != null) && (localawgp.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    awgp localawgp = a(paramLong);
    if (localawgp != null) {
      return localawgp.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgn
 * JD-Core Version:    0.7.0.1
 */