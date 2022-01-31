import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.json.JSONArray;
import org.json.JSONObject;

public class aoyo
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private SparseArray<aoyp> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private String jdField_a_of_type_JavaLangString = "";
  private List<aoyq> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private Map<String, aoyp> jdField_b_of_type_JavaUtilMap = new HashMap();
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  private Map<String, String> jdField_c_of_type_JavaUtilMap = new HashMap();
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "";
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "";
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString = "";
  
  public static aoyo a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    Object localObject1 = paramArrayOfaoko[0].jdField_a_of_type_JavaLangString;
    paramArrayOfaoko = new aoyo();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocTipsConfigBean", 2, "updateConfig json parse faild");
      }
      return paramArrayOfaoko;
    }
    JSONObject localJSONObject2;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    String str1;
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      localJSONObject2 = ((JSONObject)localObject1).optJSONObject("File");
      paramArrayOfaoko.jdField_a_of_type_Int = localJSONObject2.optInt("maxCount");
      paramArrayOfaoko.jdField_b_of_type_Int = localJSONObject2.optInt("insertDur");
      localObject2 = localJSONObject2.optJSONObject("fileType");
      localObject3 = new StringBuilder();
      localObject4 = ((JSONObject)localObject2).keys();
      localObject5 = new StringBuilder();
      while (((Iterator)localObject4).hasNext())
      {
        str1 = (String)((Iterator)localObject4).next();
        ((StringBuilder)localObject3).append(str1).append("|");
        String str2 = ((JSONObject)localObject2).getString(str1);
        paramArrayOfaoko.jdField_a_of_type_JavaUtilMap.put("fileType_" + str1, str2);
        ((StringBuilder)localObject5).append(str2).append("|");
        aoyp localaoyp = new aoyp();
        localaoyp.jdField_b_of_type_ArrayOfJavaLangString = a(str2);
        paramArrayOfaoko.jdField_b_of_type_JavaUtilMap.put(str1, localaoyp);
        continue;
        return paramArrayOfaoko;
      }
    }
    catch (Exception localException)
    {
      QLog.e("TencentDocTipsConfigBean", 2, localException.toString());
      localException.printStackTrace();
    }
    JSONObject localJSONObject1;
    do
    {
      if (((StringBuilder)localObject5).length() > 0) {
        ((StringBuilder)localObject5).deleteCharAt(((StringBuilder)localObject5).length() - 1);
      }
      if (((StringBuilder)localObject3).length() > 0) {
        ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
      }
      paramArrayOfaoko.jdField_c_of_type_JavaLangString = ((StringBuilder)localObject3).toString();
      paramArrayOfaoko.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject5).toString();
      localObject2 = localJSONObject2.optJSONObject("Similarity");
      paramArrayOfaoko.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("durTime");
      paramArrayOfaoko.jdField_d_of_type_Int = ((JSONObject)localObject2).optInt("maxQuery");
      paramArrayOfaoko.jdField_a_of_type_Double = ((JSONObject)localObject2).getDouble("Percentage");
      paramArrayOfaoko.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("Tips");
      paramArrayOfaoko.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("Link");
      localJSONObject2 = localJSONObject2.optJSONObject("KeyWords");
      localObject2 = paramArrayOfaoko.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = localJSONObject2.optJSONObject((String)localObject3);
        localObject5 = (aoyp)paramArrayOfaoko.jdField_b_of_type_JavaUtilMap.get(localObject3);
        str1 = ((JSONObject)localObject4).optString("key");
        ((aoyp)localObject5).jdField_a_of_type_ArrayOfJavaLangString = a(str1);
        if (paramArrayOfaoko.jdField_e_of_type_Int == 1) {
          ((aoyp)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject4).optString("Tips1");
        }
        for (((aoyp)localObject5).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).optString("Link1");; ((aoyp)localObject5).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).optString("Link0"))
        {
          paramArrayOfaoko.jdField_b_of_type_JavaUtilMap.put(localObject3, localObject5);
          paramArrayOfaoko.jdField_c_of_type_JavaUtilMap.put("key_str_key_words" + (String)localObject3, str1);
          paramArrayOfaoko.jdField_c_of_type_JavaUtilMap.put("key_str_key_tips" + (String)localObject3, ((aoyp)localObject5).jdField_a_of_type_JavaLangString);
          paramArrayOfaoko.jdField_c_of_type_JavaUtilMap.put("key_str_key_link" + (String)localObject3, ((aoyp)localObject5).jdField_b_of_type_JavaLangString);
          break;
          ((aoyp)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject4).optString("Tips0");
        }
      }
      localJSONObject1 = localException.optJSONObject("Text");
    } while (localJSONObject1 == null);
    paramArrayOfaoko.jdField_e_of_type_JavaLangString = localJSONObject1.toString();
    if (localJSONObject1.optInt("textSwitch", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfaoko.jdField_a_of_type_Boolean = bool;
      a(localJSONObject1, paramArrayOfaoko);
      break;
    }
  }
  
  private static void a(JSONObject paramJSONObject, aoyo paramaoyo)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("template_list");
    int i = 0;
    if (i < localJSONArray.length())
    {
      int k = localJSONArray.getJSONObject(i).optInt("template_type", -1);
      aoyp localaoyp = new aoyp();
      paramaoyo.jdField_f_of_type_Int = paramJSONObject.optInt("containKeyword");
      if (paramaoyo.jdField_f_of_type_Int == 1) {
        localaoyp.jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips1");
      }
      for (localaoyp.jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link1");; localaoyp.jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link0"))
      {
        int j = k;
        if (k == -1) {
          j = i;
        }
        paramaoyo.jdField_a_of_type_AndroidUtilSparseArray.put(j, localaoyp);
        i += 1;
        break;
        localaoyp.jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips0");
      }
    }
  }
  
  private static String[] a(String paramString)
  {
    int i = 0;
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "|");
    if (!localStringTokenizer.hasMoreTokens())
    {
      if (QLog.isColorLevel()) {
        QLog.i("TencentDocTipsConfigBean", 1, "split String faild :" + paramString);
      }
      return new String[0];
    }
    paramString = new String[localStringTokenizer.countTokens()];
    while (localStringTokenizer.hasMoreTokens())
    {
      paramString[i] = localStringTokenizer.nextToken();
      i += 1;
    }
    return paramString;
  }
  
  public double a()
  {
    return this.jdField_a_of_type_Double;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public SparseArray<aoyp> a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<aoyq> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public Map<String, aoyp> a()
  {
    return this.jdField_b_of_type_JavaUtilMap;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      localObject = "";
      this.jdField_f_of_type_JavaLangString = ((String)localObject);
      if (paramJSONObject != null) {
        break label33;
      }
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      return;
      localObject = paramJSONObject.toString();
      break;
      try
      {
        label33:
        localObject = paramJSONObject.optJSONArray("template_list");
        if (paramJSONObject.optInt("retcode", -1) != 0)
        {
          this.jdField_a_of_type_Boolean = false;
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("TencentDocTipsConfigBean", 2, paramJSONObject.toString());
        return;
      }
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          paramJSONObject = ((JSONArray)localObject).getJSONObject(i);
          int k = paramJSONObject.optInt("template_type", -1);
          if (paramJSONObject.optJSONArray("infos") != null)
          {
            paramJSONObject = paramJSONObject.optJSONArray("infos");
            int j = 0;
            while (j < paramJSONObject.length())
            {
              JSONObject localJSONObject = paramJSONObject.getJSONObject(j);
              aoyq localaoyq = new aoyq();
              localaoyq.jdField_a_of_type_JavaLangString = localJSONObject.optString("template_name");
              localaoyq.jdField_a_of_type_Int = localJSONObject.optInt("template_id", -1);
              if (localaoyq.jdField_a_of_type_Int == -1) {
                QLog.d("TencentDocTipsConfigBean", 2, "template has no id");
              }
              localaoyq.jdField_b_of_type_Int = k;
              this.jdField_a_of_type_JavaUtilList.add(localaoyq);
              j += 1;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public String d()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoyo
 * JD-Core Version:    0.7.0.1
 */