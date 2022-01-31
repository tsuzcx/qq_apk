import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aoia
  extends aoim
  implements aoga<String>
{
  protected String a;
  public ArrayList<aoik> a;
  
  public aoia()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private static anin a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    anin localanin = new anin();
    localanin.jdField_a_of_type_Int = paramJSONObject.optInt("type", -1);
    localanin.d = paramJSONObject.optString("md5", null);
    localanin.jdField_b_of_type_JavaLangString = paramJSONObject.optString("url", null);
    localanin.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name", null);
    localanin.c = paramJSONObject.optString("identifier", null);
    if (!localanin.a())
    {
      QLog.i("AIDictConfig", 1, "getDictInfoFromJSON, invalid dict info");
      return null;
    }
    QLog.i("AIDictConfig", 1, "onParse getDictInfoFromJSON  info.type=" + localanin.jdField_a_of_type_Int + ", info.md5=" + localanin.d + ", info.url=" + localanin.jdField_b_of_type_JavaLangString + ",  info.name =" + localanin.jdField_a_of_type_JavaLangString + ",  info.identifier =" + localanin.c);
    paramJSONObject = paramJSONObject.optJSONObject("diff");
    if (paramJSONObject != null)
    {
      localanin.e = paramJSONObject.optString("url");
      localanin.f = paramJSONObject.optString("diff-md5");
      localanin.g = paramJSONObject.optString("source-md5");
      if (!localanin.b()) {
        localanin.a();
      }
      QLog.i("AIDictConfig", 1, "onParse getDictInfoFromJSON info.diffURL=" + localanin.e + ", info.diffMD5=" + localanin.f + ", info.diffSourceMD5=" + localanin.g);
    }
    return localanin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    int k = 0;
    if (TextUtils.isEmpty(paramString))
    {
      ArkAppCenter.c("AIDictConfig", "onParse,fileOrRes is null");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject5;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      this.c = paramString.optString("environment");
      this.jdField_b_of_type_JavaLangString = paramString.optString("timestamp");
      this.d = paramString.optString("ark_dict_init");
      this.e = paramString.optString("netType", "");
      localObject1 = paramString.optJSONArray("conditional_dict_list");
      if (localObject1 == null) {
        break label420;
      }
      i = 0;
      if (i >= ((JSONArray)localObject1).length()) {
        break label420;
      }
      localObject2 = ((JSONArray)localObject1).optJSONObject(i);
      if (localObject2 == null) {
        break label517;
      }
      localObject3 = ((JSONObject)localObject2).optJSONObject("condition");
      Object localObject4 = ((JSONObject)localObject2).optJSONObject("dict");
      if ((localObject3 == null) || (localObject4 == null)) {
        break label517;
      }
      localObject2 = new aoik();
      localObject5 = new aoij();
      ((aoij)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("date", "");
      ((aoik)localObject2).jdField_a_of_type_Aoij = ((aoij)localObject5);
      localObject3 = new aoim();
      ((aoim)localObject3).c = ((JSONObject)localObject4).optString("environment");
      ((aoim)localObject3).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).optString("timestamp");
      ((aoim)localObject3).d = ((JSONObject)localObject4).optString("ark_dict_init");
      ((aoim)localObject3).e = ((JSONObject)localObject4).optString("netType", "");
      QLog.i("AIDictConfig", 1, "onParse conditional_dict_list tDict.environment=" + ((aoim)localObject3).c + ", tDict.mTimestamp =" + ((aoim)localObject3).jdField_b_of_type_JavaLangString + ", tDict.mArkDictInit =" + ((aoim)localObject3).d + ", tDict.mNetType =" + ((aoim)localObject3).e + ", tCondition.mData =" + ((aoij)localObject5).jdField_a_of_type_JavaLangString);
      localObject4 = ((JSONObject)localObject4).optJSONArray("word_dict_list");
      if (localObject4 == null) {
        break label400;
      }
      localObject5 = new ArrayList();
      j = 0;
      label343:
      if (j < ((JSONArray)localObject4).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject4).optJSONObject(j);
        if (localJSONObject == null) {
          break label524;
        }
        ((ArrayList)localObject5).add(a(localJSONObject));
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("AIDictConfig", 1, "onParse error e = ", paramString);
      return;
    }
    ((aoim)localObject3).jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject5);
    label400:
    ((aoik)localObject2).jdField_a_of_type_Aoim = ((aoim)localObject3);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
    break label517;
    label420:
    paramString = paramString.optJSONArray("word_dict_list");
    if (paramString != null)
    {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      i = k;
    }
    for (;;)
    {
      if (i < paramString.length())
      {
        localObject1 = paramString.optJSONObject(i);
        if (localObject1 != null)
        {
          localObject1 = a((JSONObject)localObject1);
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject1);
        }
      }
      else
      {
        QLog.d("AIDictConfig", 1, new Object[] { "mWordDictList list size =", Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) });
        return;
        label517:
        i += 1;
        break;
        label524:
        j += 1;
        break label343;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoia
 * JD-Core Version:    0.7.0.1
 */