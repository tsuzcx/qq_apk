package com.tencent.kingkong;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeSubPatch
{
  public int a;
  public String a;
  public ArrayList<Integer> a;
  public ArrayList<String> b = new ArrayList();
  public ArrayList<Integer> c = new ArrayList();
  public ArrayList<Integer> d = new ArrayList();
  
  public NativeSubPatch()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 1;
  }
  
  public static ArrayList<NativeSubPatch> a(String paramString)
  {
    Object localObject1 = new ArrayList();
    try
    {
      paramString = new JSONArray(Utils.a(paramString));
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Parsing sub patch ");
        ((StringBuilder)localObject2).append(i);
        Common.Log.b("KingKongSubPatch", ((StringBuilder)localObject2).toString());
        localObject2 = new NativeSubPatch();
        if (((NativeSubPatch)localObject2).a(paramString.getJSONObject(i)))
        {
          ((NativeSubPatch)localObject2).a();
          ((ArrayList)localObject1).add(localObject2);
          i += 1;
        }
        else
        {
          Common.Log.a("KingKongSubPatch", "Parse sub patch failed, give up");
          return null;
        }
      }
      return localObject1;
    }
    catch (Exception paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Parse SubPatch List exception : ");
      ((StringBuilder)localObject1).append(paramString);
      Common.Log.a("KingKongSubPatch", ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  public void a()
  {
    int k = 0;
    int i = 0;
    StringBuilder localStringBuilder;
    while (i < this.c.size())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("--> HookPoints : ");
      localStringBuilder.append(this.c.get(i));
      Common.Log.b("KingKongSubPatch", localStringBuilder.toString());
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("--> Parameters : ");
      localStringBuilder.append(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).toString());
      Common.Log.b("KingKongSubPatch", localStringBuilder.toString());
      i += 1;
    }
    while (j < this.b.size())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("--> FingerPrint : ");
      localStringBuilder.append((String)this.b.get(j));
      localStringBuilder.append(", ");
      localStringBuilder.append(this.d.get(j));
      Common.Log.b("KingKongSubPatch", localStringBuilder.toString());
      j += 1;
    }
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    int i;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("patch_file").trim();
        localObject = paramJSONObject.getJSONArray("parameters");
        localJSONArray1 = paramJSONObject.getJSONArray("fingerprints");
        localJSONArray2 = paramJSONObject.getJSONArray("hook_point");
        localJSONArray3 = paramJSONObject.getJSONArray("fingerprints_value");
        int m = ((JSONArray)localObject).length();
        k = localJSONArray1.length();
        int n = localJSONArray3.length();
        j = localJSONArray2.length();
        i = 0;
        if (i < m)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(((JSONArray)localObject).getInt(i)));
          i += 1;
          continue;
        }
        if (n == k) {
          break;
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("Fingerprint value count mismatch ");
        paramJSONObject.append(n);
        paramJSONObject.append(", ");
        paramJSONObject.append(k);
        Common.Log.a("KingKongSubPatch", paramJSONObject.toString());
        return false;
      }
      catch (JSONException paramJSONObject)
      {
        JSONArray localJSONArray1;
        JSONArray localJSONArray2;
        JSONArray localJSONArray3;
        int k;
        int j;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Parse SubPatch error : ");
        ((StringBuilder)localObject).append(paramJSONObject);
        Common.Log.a("KingKongSubPatch", ((StringBuilder)localObject).toString());
        return false;
      }
      catch (Exception paramJSONObject)
      {
        return false;
      }
      if (i >= k) {
        break label292;
      }
      this.b.add(localJSONArray1.getString(i).trim());
      this.d.add(Integer.valueOf(localJSONArray3.getInt(i)));
      i += 1;
    }
    for (;;)
    {
      if (i < j)
      {
        this.c.add(Integer.valueOf(localJSONArray2.getInt(i)));
        i += 1;
      }
      else
      {
        this.jdField_a_of_type_Int = paramJSONObject.optInt("isThumb2", 1);
        return true;
        i = 0;
        break;
        label292:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.NativeSubPatch
 * JD-Core Version:    0.7.0.1
 */