package com.tencent.hotpatch.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class DexPatchConfigDalvik
  extends BasePatchConfig
{
  public ArrayList a = new ArrayList();
  public int c;
  public final String e = "dex";
  
  public DexPatchConfigDalvik(String paramString)
  {
    a(paramString);
  }
  
  public String a()
  {
    String str1 = super.a();
    try
    {
      JSONObject localJSONObject = new JSONObject(str1);
      localJSONObject.put("patchType", "dex");
      localJSONObject.put("patchName", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("patchUrl", this.d);
      localJSONObject.put("patchSize", this.b);
      localJSONObject.put("classIdSize", this.jdField_c_of_type_Int);
      StringBuilder localStringBuilder = new StringBuilder("");
      if ((this.a != null) && (this.a.size() > 0))
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          if (!TextUtils.isEmpty(str3)) {
            localStringBuilder.append(str3).append(";");
          }
        }
      }
      localJSONException.put("classIdList", localStringBuilder.toString());
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "DexPatchConfigDalvik writeToJsonString", localJSONException);
      return str1;
    }
    String str2 = localJSONException.toString();
    return str2;
  }
  
  public void a(String paramString)
  {
    int i = 0;
    super.a(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_c_of_type_JavaLangString = paramString.optString("patchName", null);
      this.d = paramString.optString("patchUrl", null);
      this.b = paramString.optInt("patchSize", 0);
      this.jdField_c_of_type_Int = paramString.optInt("classIdSize", 0);
      paramString = paramString.optString("classIdList", "").split(";");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        while (i < j)
        {
          CharSequence localCharSequence = paramString[i];
          if (!TextUtils.isEmpty(localCharSequence)) {
            this.a.add(localCharSequence);
          }
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.d("PatchLogTag", 1, "DexPatchConfigDalvik readFromJsonString", paramString);
    }
  }
  
  public boolean a(Context paramContext, boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_Int <= 0) || (this.a.size() != this.jdField_c_of_type_Int))
    {
      QLog.d("PatchLogTag", 1, "DexPatchConfigDalvik isValidConfig classIdSize is invalid or not match");
      return false;
    }
    return super.a(paramContext, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.config.DexPatchConfigDalvik
 * JD-Core Version:    0.7.0.1
 */