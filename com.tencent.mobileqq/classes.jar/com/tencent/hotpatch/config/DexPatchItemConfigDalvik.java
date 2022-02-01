package com.tencent.hotpatch.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class DexPatchItemConfigDalvik
  extends AbscractPatchItemConfig
{
  private ArrayList<String> d = new ArrayList();
  
  public DexPatchItemConfigDalvik(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a = paramJSONObject.optString("patchName", null);
    this.b = paramJSONObject.optString("patchUrl", null);
    int i = 0;
    this.c = paramJSONObject.optInt("patchSize", 0);
    paramJSONObject = paramJSONObject.optString("classIdList", "").split(";");
    if ((paramJSONObject != null) && (paramJSONObject.length > 0))
    {
      int j = paramJSONObject.length;
      while (i < j)
      {
        CharSequence localCharSequence = paramJSONObject[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          this.d.add(localCharSequence);
        }
        i += 1;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.d.size() <= 0)
    {
      QLog.d("PatchLogTag", 1, "DexPatchItemConfigDalvik isValidConfig classIdList is empty");
      return false;
    }
    return super.a(paramString);
  }
  
  public String b()
  {
    String str1 = super.b();
    try
    {
      Object localObject = new JSONObject(str1);
      ((JSONObject)localObject).put("patchName", this.a);
      ((JSONObject)localObject).put("patchUrl", this.b);
      ((JSONObject)localObject).put("patchSize", this.c);
      StringBuilder localStringBuilder = new StringBuilder("");
      if ((this.d != null) && (this.d.size() > 0))
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          if (!TextUtils.isEmpty(str2))
          {
            localStringBuilder.append(str2);
            localStringBuilder.append(";");
          }
        }
      }
      ((JSONObject)localObject).put("classIdList", localStringBuilder.toString());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "DexPatchItemConfigDalvik writeToJsonString", localJSONException);
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hotpatch.config.DexPatchItemConfigDalvik
 * JD-Core Version:    0.7.0.1
 */