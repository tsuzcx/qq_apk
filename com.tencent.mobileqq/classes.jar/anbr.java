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

public class anbr
{
  private int jdField_a_of_type_Int;
  private SparseArray<anbs> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private String jdField_a_of_type_JavaLangString = "";
  private List<anbt> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private Map<String, anbs> jdField_b_of_type_JavaUtilMap = new HashMap();
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  private Map<String, String> jdField_c_of_type_JavaUtilMap = new HashMap();
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "";
  
  public static anbr a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    Object localObject1 = paramArrayOfamph[0].jdField_a_of_type_JavaLangString;
    paramArrayOfamph = new anbr();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocDataLineTipsConfigBean", 2, "updateConfig json parse faild");
      }
      return paramArrayOfamph;
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
      paramArrayOfamph.jdField_a_of_type_Int = localJSONObject2.optInt("maxCount");
      paramArrayOfamph.jdField_b_of_type_Int = localJSONObject2.optInt("insertDur");
      localObject2 = localJSONObject2.optJSONObject("fileType");
      localObject3 = new StringBuilder();
      localObject4 = ((JSONObject)localObject2).keys();
      localObject5 = new StringBuilder();
      while (((Iterator)localObject4).hasNext())
      {
        str1 = (String)((Iterator)localObject4).next();
        ((StringBuilder)localObject3).append(str1).append("|");
        String str2 = ((JSONObject)localObject2).getString(str1);
        paramArrayOfamph.jdField_a_of_type_JavaUtilMap.put("fileType_" + str1, str2);
        ((StringBuilder)localObject5).append(str2).append("|");
        anbs localanbs = new anbs();
        localanbs.jdField_b_of_type_ArrayOfJavaLangString = a(str2);
        paramArrayOfamph.jdField_b_of_type_JavaUtilMap.put(str1, localanbs);
        continue;
        return paramArrayOfamph;
      }
    }
    catch (Exception localException)
    {
      QLog.e("TencentDocDataLineTipsConfigBean", 2, localException.toString());
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
      paramArrayOfamph.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject3).toString();
      paramArrayOfamph.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject5).toString();
      localJSONObject2 = localJSONObject2.optJSONObject("KeyWords");
      localObject2 = paramArrayOfamph.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = localJSONObject2.optJSONObject((String)localObject3);
        localObject5 = (anbs)paramArrayOfamph.jdField_b_of_type_JavaUtilMap.get(localObject3);
        str1 = ((JSONObject)localObject4).optString("key");
        ((anbs)localObject5).jdField_a_of_type_ArrayOfJavaLangString = a(str1);
        if (paramArrayOfamph.jdField_c_of_type_Int == 1) {
          ((anbs)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject4).optString("Tips1");
        }
        for (((anbs)localObject5).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).optString("Link1");; ((anbs)localObject5).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).optString("Link0"))
        {
          paramArrayOfamph.jdField_b_of_type_JavaUtilMap.put(localObject3, localObject5);
          paramArrayOfamph.jdField_c_of_type_JavaUtilMap.put("key_str_key_words" + (String)localObject3, str1);
          paramArrayOfamph.jdField_c_of_type_JavaUtilMap.put("key_str_key_tips" + (String)localObject3, ((anbs)localObject5).jdField_a_of_type_JavaLangString);
          paramArrayOfamph.jdField_c_of_type_JavaUtilMap.put("key_str_key_link" + (String)localObject3, ((anbs)localObject5).jdField_b_of_type_JavaLangString);
          break;
          ((anbs)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject4).optString("Tips0");
        }
      }
      localJSONObject1 = localException.optJSONObject("Text");
    } while (localJSONObject1 == null);
    paramArrayOfamph.jdField_c_of_type_JavaLangString = localJSONObject1.toString();
    if (localJSONObject1.optInt("textSwitch", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfamph.jdField_a_of_type_Boolean = bool;
      a(localJSONObject1, paramArrayOfamph);
      break;
    }
  }
  
  private static void a(JSONObject paramJSONObject, anbr paramanbr)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("template_list");
    int i = 0;
    if (i < localJSONArray.length())
    {
      int k = localJSONArray.getJSONObject(i).optInt("template_type", -1);
      anbs localanbs = new anbs();
      paramanbr.jdField_d_of_type_Int = paramJSONObject.optInt("containKeyword");
      if (paramanbr.jdField_d_of_type_Int == 1) {
        localanbs.jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips1");
      }
      for (localanbs.jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link1");; localanbs.jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link0"))
      {
        int j = k;
        if (k == -1) {
          j = i;
        }
        paramanbr.jdField_a_of_type_AndroidUtilSparseArray.put(j, localanbs);
        i += 1;
        break;
        localanbs.jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips0");
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
        QLog.i("TencentDocDataLineTipsConfigBean", 1, "split String faild :" + paramString);
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
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List<anbt> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public Map<String, anbs> a()
  {
    return this.jdField_b_of_type_JavaUtilMap;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      localObject = "";
      this.jdField_d_of_type_JavaLangString = ((String)localObject);
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
        QLog.e("TencentDocDataLineTipsConfigBean", 2, paramJSONObject.toString());
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
              anbt localanbt = new anbt();
              localanbt.jdField_a_of_type_JavaLangString = localJSONObject.optString("template_name");
              localanbt.jdField_a_of_type_Int = localJSONObject.optInt("template_id", -1);
              if (localanbt.jdField_a_of_type_Int == -1) {
                QLog.d("TencentDocDataLineTipsConfigBean", 2, "template has no id");
              }
              localanbt.jdField_b_of_type_Int = k;
              this.jdField_a_of_type_JavaUtilList.add(localanbt);
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
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anbr
 * JD-Core Version:    0.7.0.1
 */