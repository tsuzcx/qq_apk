package com.tencent.kingkong;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class NativePatch
  extends Patch
{
  private static String f = File.separator;
  private int jdField_a_of_type_Int = 0;
  private NativeSubPatch jdField_a_of_type_ComTencentKingkongNativeSubPatch = null;
  private ArrayList<NativeSubPatch> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int = 0;
  private ArrayList<NativePatch.FingerprintDef> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int = 0;
  private ArrayList<NativePatch.HookPointDef> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<NativePatch.ParameterDef> d;
  
  public NativePatch(String paramString1, String paramString2)
  {
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
  }
  
  private int a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject1 = (NativeSubPatch)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      int j;
      if ((((NativeSubPatch)localObject1).jdField_b_of_type_JavaUtilArrayList.size() == this.jdField_a_of_type_Int) && (((NativeSubPatch)localObject1).jdField_c_of_type_JavaUtilArrayList.size() == this.jdField_b_of_type_Int) && (((NativeSubPatch)localObject1).jdField_d_of_type_JavaUtilArrayList.size() == this.jdField_a_of_type_Int)) {
        j = 0;
      }
      while (j < this.jdField_a_of_type_Int)
      {
        Object localObject3 = (NativePatch.FingerprintDef)this.jdField_b_of_type_JavaUtilArrayList.get(j);
        String str = ((NativePatch.FingerprintDef)localObject3).jdField_a_of_type_JavaLangString;
        Object localObject2 = ((NativePatch.FingerprintDef)localObject3).jdField_b_of_type_JavaLangString;
        int k = ((NativePatch.FingerprintDef)localObject3).jdField_a_of_type_Int;
        int m = ((Integer)((NativeSubPatch)localObject1).jdField_d_of_type_JavaUtilArrayList.get(j)).intValue();
        localObject3 = (String)((NativeSubPatch)localObject1).jdField_b_of_type_JavaUtilArrayList.get(j);
        if ((m != -1) && (!"null".equals(localObject3)))
        {
          str = a(str, (String)localObject2, m, k);
          if ((str == null) || (!str.equals(localObject3))) {
            break;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Matches fingerprint ");
          ((StringBuilder)localObject2).append(str);
          Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject2).toString());
          if (j == this.jdField_a_of_type_Int - 1)
          {
            Common.Log.a("KingKongNativePatch", "Well done, all fingerprints matched!");
            return i;
          }
        }
        else
        {
          Common.Log.a("KingKongNativePatch", "Skip null fingerprint ");
          if (j == this.jdField_a_of_type_Int - 1)
          {
            Common.Log.a("KingKongNativePatch", "Well done, all fingerprints matched!");
            return i;
          }
        }
        j += 1;
        continue;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Skip fingerprint/hookpoint count mismatch subpatch ");
        ((StringBuilder)localObject1).append(i);
        Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject1).toString());
      }
      i += 1;
    }
    Common.Log.a("KingKongNativePatch", "Unable to get valid subpatch by offset!");
    return -1;
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 1) {
      return 2;
    }
    return 1;
  }
  
  public static Patch a(String paramString, PatchInfo paramPatchInfo)
  {
    paramString = new NativePatch(paramString, paramPatchInfo.jdField_a_of_type_JavaLangString);
    if ((paramString.a(paramString.a())) && (paramString.b())) {
      return paramString;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramString1 = PatchManager.nativeGetFingerprint(paramString1, paramString2, paramInt1, paramInt2);
    if ((paramString1 != null) && (paramString1.length != 0)) {
      return Utils.a(paramString1);
    }
    return "";
  }
  
  private ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((NativePatch.FingerprintDef)this.jdField_b_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
      i += 1;
    }
    return localArrayList;
  }
  
  private boolean a(String paramString)
  {
    paramString = Utils.a(paramString);
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_c_of_type_JavaLangString = paramString.getString("name");
        this.jdField_d_of_type_JavaLangString = paramString.getString("ver");
        this.e = paramString.getString("type");
        localObject1 = paramString.getJSONObject("basic_group");
        this.jdField_a_of_type_Int = ((JSONObject)localObject1).getInt("fingerprint_count");
        this.jdField_c_of_type_Int = ((JSONObject)localObject1).getInt("param_count");
        this.jdField_b_of_type_Int = ((JSONObject)localObject1).getInt("hookpoint_count");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("--> Fingerprint count : ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
        Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("--> Parameter count : ");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Int);
        Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("--> HookPoint count : ");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
        Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject1).toString());
        i = 0;
        if (i >= this.jdField_b_of_type_Int) {
          break label615;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("hookpoint_definition_");
        i += 1;
        ((StringBuilder)localObject1).append(String.valueOf(i));
        Object localObject2 = paramString.getJSONObject(((StringBuilder)localObject1).toString());
        localObject1 = new NativePatch.HookPointDef(this);
        if (((NativePatch.HookPointDef)localObject1).a((JSONObject)localObject2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("--> HookPoint : ");
          ((StringBuilder)localObject2).append(localObject1);
          Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject2).toString());
          this.jdField_c_of_type_JavaUtilArrayList.add(localObject1);
          continue;
          if (i >= this.jdField_a_of_type_Int) {
            break label622;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("fingerprint_definition_");
          i += 1;
          ((StringBuilder)localObject1).append(String.valueOf(i));
          localObject2 = paramString.getJSONObject(((StringBuilder)localObject1).toString());
          localObject1 = new NativePatch.FingerprintDef(this);
          if (!((NativePatch.FingerprintDef)localObject1).a((JSONObject)localObject2)) {
            break label620;
          }
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("--> Fingerprint ");
          ((StringBuilder)localObject2).append(localObject1);
          Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject2).toString());
          continue;
          if (i < this.jdField_c_of_type_Int)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("parameter_definition_");
            int j = i + 1;
            ((StringBuilder)localObject1).append(String.valueOf(j));
            localObject2 = paramString.getJSONObject(((StringBuilder)localObject1).toString());
            localObject1 = new NativePatch.ParameterDef(this);
            if (((NativePatch.ParameterDef)localObject1).a((JSONObject)localObject2))
            {
              if (((NativePatch.ParameterDef)localObject1).jdField_a_of_type_Int != i)
              {
                Common.Log.a("KingKongNativePatch", "Parameter index error!");
                return false;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("--> Parameter definition : ");
              ((StringBuilder)localObject2).append(localObject1);
              Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject2).toString());
              this.jdField_d_of_type_JavaUtilArrayList.add(localObject1);
              i = j;
              continue;
            }
            return false;
          }
          return true;
        }
      }
      catch (JSONException paramString)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Parse sub patches failed : ");
        ((StringBuilder)localObject1).append(paramString);
        Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject1).toString());
        return false;
      }
      return false;
      label615:
      int i = 0;
      continue;
      label620:
      return false;
      label622:
      i = 0;
    }
  }
  
  private int[] a()
  {
    Object localObject1 = Common.a(this.jdField_c_of_type_JavaLangString);
    if (localObject1 == null)
    {
      Common.Log.a("KingKongNativePatch", "No GOT Hookpoint found");
      return null;
    }
    int i = localObject1.length;
    int j = this.jdField_b_of_type_Int;
    if (i != j)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Got Hookpoint length mismatch ");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(localObject1.length);
      Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject2).toString());
      return null;
    }
    Object localObject2 = new int[j];
    i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      localObject2[i] = PatchManager.nativeCalcParameter(2, ((NativePatch.HookPointDef)this.jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString, "", localObject1[i]);
      if (localObject2[i] == -1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Calculate GOT Hookpoint failed ");
        ((StringBuilder)localObject1).append(i);
        Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject1).toString());
        return null;
      }
      i += 1;
    }
    return localObject2;
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(f);
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(".subpatch");
    return localStringBuilder.toString();
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_JavaUtilArrayList = NativeSubPatch.a(b());
    return this.jdField_a_of_type_JavaUtilArrayList != null;
  }
  
  private int[] b()
  {
    Object localObject1 = Common.b(this.jdField_c_of_type_JavaLangString);
    if (localObject1 == null)
    {
      Common.Log.a("KingKongNativePatch", "No Jumper point found");
      return null;
    }
    int i = localObject1.length;
    int j = this.jdField_b_of_type_Int;
    if (i != j)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Jumper point length mismatch ");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(localObject1.length);
      Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject2).toString());
      return null;
    }
    Object localObject2 = new int[j];
    i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      localObject2[i] = PatchManager.nativeCalcParameter(2, ((NativePatch.HookPointDef)this.jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString, "", localObject1[i]);
      if (localObject2[i] == -1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Calculate Jumper point failed ");
        ((StringBuilder)localObject1).append(i);
        Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject1).toString());
        return null;
      }
      i += 1;
    }
    return localObject2;
  }
  
  public int a(Context paramContext)
  {
    paramContext = new StringBuilder();
    paramContext.append("---> Patching ");
    paramContext.append(this.jdField_c_of_type_JavaLangString);
    paramContext.append("  <-------");
    Common.Log.a("KingKongNativePatch", paramContext.toString());
    int i = Common.a(this.jdField_c_of_type_JavaLangString, a());
    if ((i != -1) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      paramContext = (NativeSubPatch)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((paramContext.jdField_c_of_type_JavaUtilArrayList.size() == this.jdField_b_of_type_Int) && (this.jdField_c_of_type_JavaUtilArrayList.size() == this.jdField_b_of_type_Int))
      {
        int[] arrayOfInt1 = a();
        int[] arrayOfInt2 = b();
        if ((arrayOfInt1 != null) && (arrayOfInt2 != null))
        {
          int j = paramContext.jdField_a_of_type_Int;
          i = 0;
          while (i < this.jdField_b_of_type_Int)
          {
            Object localObject2 = (NativePatch.HookPointDef)this.jdField_c_of_type_JavaUtilArrayList.get(i);
            Object localObject3 = paramContext.jdField_a_of_type_JavaUtilArrayList;
            int n = ((Integer)paramContext.jdField_c_of_type_JavaUtilArrayList.get(i)).intValue();
            int k = arrayOfInt2[i];
            int m = arrayOfInt1[i];
            int i1 = ((NativePatch.HookPointDef)localObject2).jdField_a_of_type_Int;
            Object localObject1 = ((NativePatch.HookPointDef)localObject2).jdField_a_of_type_JavaLangString;
            localObject2 = ((NativePatch.HookPointDef)localObject2).jdField_b_of_type_JavaLangString;
            if (n == -1)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Skip empty hook point ");
              ((StringBuilder)localObject1).append(i);
              Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject1).toString());
            }
            else
            {
              n = PatchManager.nativeCalcParameter(a(i1), (String)localObject1, (String)localObject2, n);
              if (n == -1)
              {
                Common.Log.a("KingKongNativePatch", "Calculate hookPoint failed");
                return 7;
              }
              localObject3 = a(this.jdField_d_of_type_JavaUtilArrayList, (ArrayList)localObject3);
              if (localObject3 == null) {
                return 6;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("lib");
              localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
              localStringBuilder.append(".so");
              if (!PatchManager.nativeDoPatch(Common.b(localStringBuilder.toString()), (String)localObject1, (String)localObject2, n, k, m, (int[])localObject3, this.jdField_c_of_type_Int, j)) {
                break label397;
              }
            }
            i += 1;
            continue;
            label397:
            Common.Log.a("KingKongNativePatch", "Native do patch failed");
            return 10;
          }
          Common.Log.a("KingKongNativePatch", "---> Do patch OK <----");
          return 0;
        }
        Common.Log.a("KingKongNativePatch", "Unable to get GOT HookPoint or Jumper point");
        return 8;
      }
      Common.Log.a("KingKongNativePatch", "SubPatch Hookpoint count mismatch ");
      return 11;
    }
    paramContext = new StringBuilder();
    paramContext.append("Unable to find valid subpatch index ");
    paramContext.append(i);
    Common.Log.a("KingKongNativePatch", paramContext.toString());
    return 12;
  }
  
  public boolean a()
  {
    int j = a();
    if (j == -1) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Valid subpatch index : ");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" : ");
    ((StringBuilder)localObject).append(j);
    Common.Log.a("KingKongNativePatch", ((StringBuilder)localObject).toString());
    int i = this.jdField_b_of_type_Int;
    localObject = new int[i];
    int[] arrayOfInt = new int[i];
    i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      String str = ((NativePatch.HookPointDef)this.jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
      int k = PatchManager.nativeCalcJumperPoint(str);
      int m = PatchManager.nativeCalcGotHookPoint(str);
      if ((k != -1) && (m != -1))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Patch params ");
        localStringBuilder.append(i);
        localStringBuilder.append(", ");
        localStringBuilder.append(str);
        localStringBuilder.append(", ");
        localStringBuilder.append(k);
        localStringBuilder.append(", ");
        localStringBuilder.append(m);
        Common.Log.a("KingKongNativePatch", localStringBuilder.toString());
        localObject[i] = k;
        arrayOfInt[i] = m;
        i += 1;
      }
      else
      {
        Common.Log.a("KingKongNativePatch", "Calculate jumper/got point failed");
        return false;
      }
    }
    Common.a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int, (int[])localObject, arrayOfInt);
    Common.a(this.jdField_c_of_type_JavaLangString, j, a());
    return true;
  }
  
  public int[] a(ArrayList<NativePatch.ParameterDef> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    int[] arrayOfInt = new int[paramArrayList.size()];
    int i = 0;
    while (i < paramArrayList.size())
    {
      NativePatch.ParameterDef localParameterDef = (NativePatch.ParameterDef)paramArrayList.get(i);
      int j = ((Integer)paramArrayList1.get(i)).intValue();
      arrayOfInt[i] = PatchManager.nativeCalcParameter(localParameterDef.jdField_b_of_type_Int, localParameterDef.jdField_a_of_type_JavaLangString, localParameterDef.jdField_b_of_type_JavaLangString, j);
      if (arrayOfInt[i] == -1)
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("Calculate parameter failed ");
        paramArrayList.append(i);
        Common.Log.a("KingKongNativePatch", paramArrayList.toString());
        return null;
      }
      i += 1;
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.NativePatch
 * JD-Core Version:    0.7.0.1
 */