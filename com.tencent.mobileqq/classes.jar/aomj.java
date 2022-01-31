import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aomj
  extends aomv
  implements aokj<String>
{
  protected String a;
  public ArrayList<aomt> a;
  
  public aomj()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private static anmw a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    anmw localanmw = new anmw();
    localanmw.jdField_a_of_type_Int = paramJSONObject.optInt("type", -1);
    localanmw.d = paramJSONObject.optString("md5", null);
    localanmw.jdField_b_of_type_JavaLangString = paramJSONObject.optString("url", null);
    localanmw.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name", null);
    localanmw.c = paramJSONObject.optString("identifier", null);
    if (!localanmw.a())
    {
      QLog.i("AIDictConfig", 1, "getDictInfoFromJSON, invalid dict info");
      return null;
    }
    QLog.i("AIDictConfig", 1, "onParse getDictInfoFromJSON  info.type=" + localanmw.jdField_a_of_type_Int + ", info.md5=" + localanmw.d + ", info.url=" + localanmw.jdField_b_of_type_JavaLangString + ",  info.name =" + localanmw.jdField_a_of_type_JavaLangString + ",  info.identifier =" + localanmw.c);
    paramJSONObject = paramJSONObject.optJSONObject("diff");
    if (paramJSONObject != null)
    {
      localanmw.e = paramJSONObject.optString("url");
      localanmw.f = paramJSONObject.optString("diff-md5");
      localanmw.g = paramJSONObject.optString("source-md5");
      if (!localanmw.b()) {
        localanmw.a();
      }
      QLog.i("AIDictConfig", 1, "onParse getDictInfoFromJSON info.diffURL=" + localanmw.e + ", info.diffMD5=" + localanmw.f + ", info.diffSourceMD5=" + localanmw.g);
    }
    return localanmw;
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
      localObject2 = new aomt();
      localObject5 = new aoms();
      ((aoms)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("date", "");
      ((aomt)localObject2).jdField_a_of_type_Aoms = ((aoms)localObject5);
      localObject3 = new aomv();
      ((aomv)localObject3).c = ((JSONObject)localObject4).optString("environment");
      ((aomv)localObject3).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).optString("timestamp");
      ((aomv)localObject3).d = ((JSONObject)localObject4).optString("ark_dict_init");
      ((aomv)localObject3).e = ((JSONObject)localObject4).optString("netType", "");
      QLog.i("AIDictConfig", 1, "onParse conditional_dict_list tDict.environment=" + ((aomv)localObject3).c + ", tDict.mTimestamp =" + ((aomv)localObject3).jdField_b_of_type_JavaLangString + ", tDict.mArkDictInit =" + ((aomv)localObject3).d + ", tDict.mNetType =" + ((aomv)localObject3).e + ", tCondition.mData =" + ((aoms)localObject5).jdField_a_of_type_JavaLangString);
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
    ((aomv)localObject3).jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject5);
    label400:
    ((aomt)localObject2).jdField_a_of_type_Aomv = ((aomv)localObject3);
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
 * Qualified Name:     aomj
 * JD-Core Version:    0.7.0.1
 */