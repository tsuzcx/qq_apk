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

public class arrd
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private SparseArray<arre> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private String jdField_a_of_type_JavaLangString = "";
  private List<arrf> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private Map<String, arre> jdField_b_of_type_JavaUtilMap = new HashMap();
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  private Map<String, String> jdField_c_of_type_JavaUtilMap = new HashMap();
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "";
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "";
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString = "";
  
  public static arrd a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    Object localObject1 = paramArrayOfaraj[0].jdField_a_of_type_JavaLangString;
    paramArrayOfaraj = new arrd();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocTipsConfigBean", 2, "updateConfig json parse faild");
      }
      return paramArrayOfaraj;
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
      paramArrayOfaraj.jdField_a_of_type_Int = localJSONObject2.optInt("maxCount");
      paramArrayOfaraj.jdField_b_of_type_Int = localJSONObject2.optInt("insertDur");
      localObject2 = localJSONObject2.optJSONObject("fileType");
      localObject3 = new StringBuilder();
      localObject4 = ((JSONObject)localObject2).keys();
      localObject5 = new StringBuilder();
      while (((Iterator)localObject4).hasNext())
      {
        str1 = (String)((Iterator)localObject4).next();
        ((StringBuilder)localObject3).append(str1).append("|");
        String str2 = ((JSONObject)localObject2).getString(str1);
        paramArrayOfaraj.jdField_a_of_type_JavaUtilMap.put("fileType_" + str1, str2);
        ((StringBuilder)localObject5).append(str2).append("|");
        arre localarre = new arre();
        localarre.jdField_b_of_type_ArrayOfJavaLangString = a(str2);
        paramArrayOfaraj.jdField_b_of_type_JavaUtilMap.put(str1, localarre);
        continue;
        return paramArrayOfaraj;
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
      paramArrayOfaraj.jdField_c_of_type_JavaLangString = ((StringBuilder)localObject3).toString();
      paramArrayOfaraj.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject5).toString();
      localObject2 = localJSONObject2.optJSONObject("Similarity");
      paramArrayOfaraj.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("durTime");
      paramArrayOfaraj.jdField_d_of_type_Int = ((JSONObject)localObject2).optInt("maxQuery");
      paramArrayOfaraj.jdField_a_of_type_Double = ((JSONObject)localObject2).getDouble("Percentage");
      paramArrayOfaraj.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("Tips");
      paramArrayOfaraj.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("Link");
      localJSONObject2 = localJSONObject2.optJSONObject("KeyWords");
      localObject2 = paramArrayOfaraj.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = localJSONObject2.optJSONObject((String)localObject3);
        localObject5 = (arre)paramArrayOfaraj.jdField_b_of_type_JavaUtilMap.get(localObject3);
        str1 = ((JSONObject)localObject4).optString("key");
        ((arre)localObject5).jdField_a_of_type_ArrayOfJavaLangString = a(str1);
        if (paramArrayOfaraj.jdField_e_of_type_Int == 1) {
          ((arre)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject4).optString("Tips1");
        }
        for (((arre)localObject5).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).optString("Link1");; ((arre)localObject5).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).optString("Link0"))
        {
          paramArrayOfaraj.jdField_b_of_type_JavaUtilMap.put(localObject3, localObject5);
          paramArrayOfaraj.jdField_c_of_type_JavaUtilMap.put("key_str_key_words" + (String)localObject3, str1);
          paramArrayOfaraj.jdField_c_of_type_JavaUtilMap.put("key_str_key_tips" + (String)localObject3, ((arre)localObject5).jdField_a_of_type_JavaLangString);
          paramArrayOfaraj.jdField_c_of_type_JavaUtilMap.put("key_str_key_link" + (String)localObject3, ((arre)localObject5).jdField_b_of_type_JavaLangString);
          break;
          ((arre)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject4).optString("Tips0");
        }
      }
      localJSONObject1 = localException.optJSONObject("Text");
    } while (localJSONObject1 == null);
    paramArrayOfaraj.jdField_e_of_type_JavaLangString = localJSONObject1.toString();
    if (localJSONObject1.optInt("textSwitch", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfaraj.jdField_a_of_type_Boolean = bool;
      a(localJSONObject1, paramArrayOfaraj);
      break;
    }
  }
  
  private static void a(JSONObject paramJSONObject, arrd paramarrd)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("template_list");
    int i = 0;
    if (i < localJSONArray.length())
    {
      int k = localJSONArray.getJSONObject(i).optInt("template_type", -1);
      arre localarre = new arre();
      paramarrd.jdField_f_of_type_Int = paramJSONObject.optInt("containKeyword");
      if (paramarrd.jdField_f_of_type_Int == 1) {
        localarre.jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips1");
      }
      for (localarre.jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link1");; localarre.jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link0"))
      {
        int j = k;
        if (k == -1) {
          j = i;
        }
        paramarrd.jdField_a_of_type_AndroidUtilSparseArray.put(j, localarre);
        i += 1;
        break;
        localarre.jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips0");
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
  
  public SparseArray<arre> a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<arrf> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public Map<String, arre> a()
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
              arrf localarrf = new arrf();
              localarrf.jdField_a_of_type_JavaLangString = localJSONObject.optString("template_name");
              localarrf.jdField_a_of_type_Int = localJSONObject.optInt("template_id", -1);
              if (localarrf.jdField_a_of_type_Int == -1) {
                QLog.d("TencentDocTipsConfigBean", 2, "template has no id");
              }
              localarrf.jdField_b_of_type_Int = k;
              this.jdField_a_of_type_JavaUtilList.add(localarrf);
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
 * Qualified Name:     arrd
 * JD-Core Version:    0.7.0.1
 */