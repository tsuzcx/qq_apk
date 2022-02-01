package com.tencent.hotpatch.config;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbscractPatchItemConfig
{
  protected int a;
  protected String a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  protected String b;
  private Set<Integer> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private Set<String> c = new HashSet();
  
  public static AbscractPatchItemConfig a(String paramString, JSONObject paramJSONObject)
  {
    if ("dex".equals(paramString))
    {
      if (!a(paramJSONObject)) {
        return null;
      }
      if (PatchCommonUtil.isDalvik()) {
        return new DexPatchItemConfigDalvik(paramJSONObject);
      }
      if (PatchCommonUtil.isArtLM()) {
        return new DexPatchItemConfigArtLM(paramJSONObject);
      }
      if (PatchCommonUtil.isArtGeN()) {
        return new DexPatchItemConfigArtGeN(paramJSONObject);
      }
    }
    else
    {
      if ("Native".equals(paramString)) {
        return new NativePatchItemConfig(paramJSONObject);
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("AbscractPatchItemConfig createPatchItemConfig invalid patchType=");
      paramJSONObject.append(paramString);
      QLog.d("PatchLogTag", 1, paramJSONObject.toString());
    }
    return null;
  }
  
  private static boolean a(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    if (paramJSONObject == null) {
      return false;
    }
    Object localObject = paramJSONObject.optString("systemVersion", "");
    int i;
    int j;
    int k;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      i = 1;
    }
    else
    {
      j = Build.VERSION.SDK_INT;
      localObject = ((String)localObject).split(";");
      if ((localObject != null) && (localObject.length > 0))
      {
        k = localObject.length;
        i = 0;
        for (;;)
        {
          if (i >= k) {
            break label91;
          }
          if (String.valueOf(j).equals(localObject[i])) {
            break;
          }
          i += 1;
        }
      }
      label91:
      i = 0;
    }
    paramJSONObject = paramJSONObject.optString("deviceInfo", "");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      j = 1;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Build.BRAND);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(Build.MODEL);
      localObject = ((StringBuilder)localObject).toString();
      paramJSONObject = paramJSONObject.split(";");
      if ((paramJSONObject != null) && (paramJSONObject.length > 0))
      {
        k = paramJSONObject.length;
        j = 0;
        for (;;)
        {
          if (j >= k) {
            break label203;
          }
          if (((String)localObject).equals(paramJSONObject[j])) {
            break;
          }
          j += 1;
        }
      }
      label203:
      j = 0;
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String a()
  {
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("relaxEnable", this.jdField_a_of_type_Boolean);
      ((JSONObject)localObject1).put("nPatchEnable", this.jdField_b_of_type_Boolean);
      StringBuilder localStringBuilder = new StringBuilder("");
      Object localObject2 = this.jdField_a_of_type_JavaUtilSet;
      Object localObject3;
      if ((localObject2 != null) && (this.jdField_a_of_type_JavaUtilSet.size() > 0))
      {
        localObject2 = this.jdField_a_of_type_JavaUtilSet.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localStringBuilder.append((String)localObject3);
            localStringBuilder.append(";");
          }
        }
      }
      ((JSONObject)localObject1).put("process", localStringBuilder.toString());
      localStringBuilder = new StringBuilder("");
      if ((this.jdField_b_of_type_JavaUtilSet != null) && (this.jdField_b_of_type_JavaUtilSet.size() > 0))
      {
        localObject2 = this.jdField_b_of_type_JavaUtilSet.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Integer)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            localStringBuilder.append(((Integer)localObject3).toString());
            localStringBuilder.append(";");
          }
        }
      }
      ((JSONObject)localObject1).put("systemVersion", localStringBuilder.toString());
      localStringBuilder = new StringBuilder("");
      if ((this.c != null) && (this.c.size() > 0))
      {
        localObject2 = this.c.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localStringBuilder.append((String)localObject3);
            localStringBuilder.append(";");
          }
        }
      }
      ((JSONObject)localObject1).put("deviceInfo", localStringBuilder.toString());
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PatchLogTag", 2, "AbscractPatchItemConfig writeToJsonString", localJSONException);
      }
    }
    return null;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int k = 0;
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("relaxEnable", false);
    this.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("nPatchEnable", false);
    String[] arrayOfString = paramJSONObject.optString("process", "").split(";");
    int j;
    int i;
    String str;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaUtilSet.add(str);
        }
        i += 1;
      }
    }
    arrayOfString = paramJSONObject.optString("systemVersion", "").split(";");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int m = arrayOfString.length;
      i = 0;
      while (i < m)
      {
        str = arrayOfString[i];
        try
        {
          j = Integer.parseInt(str);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label149:
          break label149;
        }
        j = 0;
        if (j > 0) {
          this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(j));
        }
        i += 1;
      }
    }
    else
    {
      paramJSONObject = paramJSONObject.optString("deviceInfo", "").split(";");
      if ((paramJSONObject != null) && (paramJSONObject.length > 0))
      {
        j = paramJSONObject.length;
        i = k;
        while (i < j)
        {
          arrayOfString = paramJSONObject[i];
          if (!TextUtils.isEmpty(arrayOfString)) {
            this.c.add(arrayOfString);
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilSet.size() > 0) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString)))
    {
      QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig process not match");
      return false;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig patchName is null");
      return false;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig patchUrl is null");
      return false;
    }
    if (this.jdField_a_of_type_Int <= 0)
    {
      QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig patchSize is invalid");
      return false;
    }
    if ((this.jdField_b_of_type_JavaUtilSet.size() > 0) && (!this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(Build.VERSION.SDK_INT))))
    {
      QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig system version not match");
      return false;
    }
    if (this.c.size() > 0)
    {
      paramString = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Build.BRAND);
      localStringBuilder.append("-");
      localStringBuilder.append(Build.MODEL);
      if (!paramString.contains(localStringBuilder.toString()))
      {
        QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig device info not match");
        return false;
      }
    }
    QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig return true");
    return true;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hotpatch.config.AbscractPatchItemConfig
 * JD-Core Version:    0.7.0.1
 */