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
  protected String a = "";
  
  private static DictInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    DictInfo localDictInfo = new DictInfo();
    localDictInfo.a = paramJSONObject.optInt("type", -1);
    localDictInfo.e = paramJSONObject.optString("md5", null);
    localDictInfo.c = paramJSONObject.optString("url", null);
    localDictInfo.b = paramJSONObject.optString("name", null);
    localDictInfo.d = paramJSONObject.optString("identifier", null);
    if (!localDictInfo.a())
    {
      QLog.i("AIDictConfig", 1, "getDictInfoFromJSON, invalid dict info");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("onParse getDictInfoFromJSON  info.type=");
    localStringBuilder.append(localDictInfo.a);
    localStringBuilder.append(", info.md5=");
    localStringBuilder.append(localDictInfo.e);
    localStringBuilder.append(", info.url=");
    localStringBuilder.append(localDictInfo.c);
    localStringBuilder.append(",  info.name =");
    localStringBuilder.append(localDictInfo.b);
    localStringBuilder.append(",  info.identifier =");
    localStringBuilder.append(localDictInfo.d);
    QLog.i("AIDictConfig", 1, localStringBuilder.toString());
    paramJSONObject = paramJSONObject.optJSONObject("diff");
    if (paramJSONObject != null)
    {
      localDictInfo.f = paramJSONObject.optString("url");
      localDictInfo.g = paramJSONObject.optString("diff-md5");
      localDictInfo.h = paramJSONObject.optString("source-md5");
      if (!localDictInfo.b()) {
        localDictInfo.c();
      }
      paramJSONObject = new StringBuilder("onParse getDictInfoFromJSON info.diffURL=");
      paramJSONObject.append(localDictInfo.f);
      paramJSONObject.append(", info.diffMD5=");
      paramJSONObject.append(localDictInfo.g);
      paramJSONObject.append(", info.diffSourceMD5=");
      paramJSONObject.append(localDictInfo.h);
      QLog.i("AIDictConfig", 1, paramJSONObject.toString());
    }
    return localDictInfo;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("AIDictConfig", 1, "onParse,fileOrRes is null");
      return;
    }
    this.a = paramString;
    for (;;)
    {
      int i;
      int j;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        this.c = ((JSONObject)localObject1).optString("environment");
        this.b = ((JSONObject)localObject1).optString("timestamp");
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
            ((ConditionalDict.Condition)localObject5).a = ((JSONObject)localObject3).optString("date", "");
            ((ConditionalDict)localObject2).b = ((ConditionalDict.Condition)localObject5);
            localObject3 = new DictConfig();
            ((DictConfig)localObject3).c = ((JSONObject)localObject4).optString("environment");
            ((DictConfig)localObject3).b = ((JSONObject)localObject4).optString("timestamp");
            ((DictConfig)localObject3).d = ((JSONObject)localObject4).optString("ark_dict_init");
            ((DictConfig)localObject3).e = ((JSONObject)localObject4).optString("netType", "");
            Object localObject6 = new StringBuilder("onParse conditional_dict_list tDict.environment=");
            ((StringBuilder)localObject6).append(((DictConfig)localObject3).c);
            ((StringBuilder)localObject6).append(", tDict.mTimestamp =");
            ((StringBuilder)localObject6).append(((DictConfig)localObject3).b);
            ((StringBuilder)localObject6).append(", tDict.mArkDictInit =");
            ((StringBuilder)localObject6).append(((DictConfig)localObject3).d);
            ((StringBuilder)localObject6).append(", tDict.mNetType =");
            ((StringBuilder)localObject6).append(((DictConfig)localObject3).e);
            ((StringBuilder)localObject6).append(", tCondition.mData =");
            ((StringBuilder)localObject6).append(((ConditionalDict.Condition)localObject5).a);
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
              ((DictConfig)localObject3).f = ((ArrayList)localObject5);
            }
            ((ConditionalDict)localObject2).a = ((DictConfig)localObject3);
            this.g.add(localObject2);
            break label558;
          }
        }
        paramString = ((JSONObject)localObject1).optJSONArray("word_dict_list");
        if (paramString != null)
        {
          this.f = new ArrayList();
          i = 0;
          if (i < paramString.length())
          {
            localObject1 = paramString.optJSONObject(i);
            if (localObject1 == null) {
              break label565;
            }
            localObject1 = a((JSONObject)localObject1);
            this.f.add(localObject1);
            break label565;
          }
        }
        QLog.d("AIDictConfig", 1, new Object[] { "mWordDictList list size =", Integer.valueOf(this.f.size()) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.AIDictConfig
 * JD-Core Version:    0.7.0.1
 */