package com.tencent.mobileqq.ark.dict;

import android.text.TextUtils;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AIDictConfig
  extends DictConfig
  implements IQStorageSafable<String>
{
  protected String a;
  
  public AIDictConfig()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private static DictInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    DictInfo localDictInfo = new DictInfo();
    localDictInfo.jdField_a_of_type_Int = paramJSONObject.optInt("type", -1);
    localDictInfo.d = paramJSONObject.optString("md5", null);
    localDictInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("url", null);
    localDictInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name", null);
    localDictInfo.c = paramJSONObject.optString("identifier", null);
    if (!localDictInfo.a())
    {
      QLog.i("AIDictConfig", 1, "getDictInfoFromJSON, invalid dict info");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("onParse getDictInfoFromJSON  info.type=");
    localStringBuilder.append(localDictInfo.jdField_a_of_type_Int);
    localStringBuilder.append(", info.md5=");
    localStringBuilder.append(localDictInfo.d);
    localStringBuilder.append(", info.url=");
    localStringBuilder.append(localDictInfo.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",  info.name =");
    localStringBuilder.append(localDictInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",  info.identifier =");
    localStringBuilder.append(localDictInfo.c);
    QLog.i("AIDictConfig", 1, localStringBuilder.toString());
    paramJSONObject = paramJSONObject.optJSONObject("diff");
    if (paramJSONObject != null)
    {
      localDictInfo.e = paramJSONObject.optString("url");
      localDictInfo.f = paramJSONObject.optString("diff-md5");
      localDictInfo.g = paramJSONObject.optString("source-md5");
      if (!localDictInfo.b()) {
        localDictInfo.a();
      }
      paramJSONObject = new StringBuilder("onParse getDictInfoFromJSON info.diffURL=");
      paramJSONObject.append(localDictInfo.e);
      paramJSONObject.append(", info.diffMD5=");
      paramJSONObject.append(localDictInfo.f);
      paramJSONObject.append(", info.diffSourceMD5=");
      paramJSONObject.append(localDictInfo.g);
      QLog.i("AIDictConfig", 1, paramJSONObject.toString());
    }
    return localDictInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("AIDictConfig", 1, "onParse,fileOrRes is null");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    for (;;)
    {
      int i;
      int j;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        this.c = ((JSONObject)localObject1).optString("environment");
        this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("timestamp");
        this.d = ((JSONObject)localObject1).optString("ark_dict_init");
        this.e = ((JSONObject)localObject1).optString("netType", "");
        paramString = ((JSONObject)localObject1).optJSONArray("conditional_dict_list");
        if (paramString != null)
        {
          i = 0;
          if (i < paramString.length())
          {
            Object localObject2 = paramString.optJSONObject(i);
            if (localObject2 == null) {
              break label548;
            }
            Object localObject3 = ((JSONObject)localObject2).optJSONObject("condition");
            Object localObject4 = ((JSONObject)localObject2).optJSONObject("dict");
            if ((localObject3 == null) || (localObject4 == null)) {
              break label548;
            }
            localObject2 = new ConditionalDict();
            Object localObject5 = new ConditionalDict.Condition();
            ((ConditionalDict.Condition)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("date", "");
            ((ConditionalDict)localObject2).jdField_a_of_type_ComTencentMobileqqArkDictConditionalDict$Condition = ((ConditionalDict.Condition)localObject5);
            localObject3 = new DictConfig();
            ((DictConfig)localObject3).c = ((JSONObject)localObject4).optString("environment");
            ((DictConfig)localObject3).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).optString("timestamp");
            ((DictConfig)localObject3).d = ((JSONObject)localObject4).optString("ark_dict_init");
            ((DictConfig)localObject3).e = ((JSONObject)localObject4).optString("netType", "");
            Object localObject6 = new StringBuilder("onParse conditional_dict_list tDict.environment=");
            ((StringBuilder)localObject6).append(((DictConfig)localObject3).c);
            ((StringBuilder)localObject6).append(", tDict.mTimestamp =");
            ((StringBuilder)localObject6).append(((DictConfig)localObject3).jdField_b_of_type_JavaLangString);
            ((StringBuilder)localObject6).append(", tDict.mArkDictInit =");
            ((StringBuilder)localObject6).append(((DictConfig)localObject3).d);
            ((StringBuilder)localObject6).append(", tDict.mNetType =");
            ((StringBuilder)localObject6).append(((DictConfig)localObject3).e);
            ((StringBuilder)localObject6).append(", tCondition.mData =");
            ((StringBuilder)localObject6).append(((ConditionalDict.Condition)localObject5).jdField_a_of_type_JavaLangString);
            QLog.i("AIDictConfig", 1, ((StringBuilder)localObject6).toString());
            localObject4 = ((JSONObject)localObject4).optJSONArray("word_dict_list");
            if (localObject4 != null)
            {
              localObject5 = new ArrayList();
              j = 0;
              if (j < ((JSONArray)localObject4).length())
              {
                localObject6 = ((JSONArray)localObject4).optJSONObject(j);
                if (localObject6 == null) {
                  break label551;
                }
                ((ArrayList)localObject5).add(a((JSONObject)localObject6));
                break label551;
              }
              ((DictConfig)localObject3).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject5);
            }
            ((ConditionalDict)localObject2).jdField_a_of_type_ComTencentMobileqqArkDictDictConfig = ((DictConfig)localObject3);
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
            break label558;
          }
        }
        paramString = ((JSONObject)localObject1).optJSONArray("word_dict_list");
        if (paramString != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          i = 0;
          if (i < paramString.length())
          {
            localObject1 = paramString.optJSONObject(i);
            if (localObject1 == null) {
              break label565;
            }
            localObject1 = a((JSONObject)localObject1);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            break label565;
          }
        }
        QLog.d("AIDictConfig", 1, new Object[] { "mWordDictList list size =", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) });
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("AIDictConfig", 1, "onParse error e = ", paramString);
        return;
      }
      label548:
      break label558;
      label551:
      j += 1;
      continue;
      label558:
      i += 1;
      continue;
      label565:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.AIDictConfig
 * JD-Core Version:    0.7.0.1
 */