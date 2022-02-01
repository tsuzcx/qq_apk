package com.tencent.kingkong;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;

public abstract class Patch
{
  public static String a;
  public PatchInfo a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = File.separator;
  }
  
  public Patch()
  {
    this.jdField_a_of_type_ComTencentKingkongPatchInfo = null;
  }
  
  public static ArrayList<String> a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString2.equals("Native"))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(".cfg");
      localArrayList.add(paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append("lib");
      paramString2.append(paramString1);
      paramString2.append(".so");
      localArrayList.add(paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(".subpatch");
      localArrayList.add(paramString2.toString());
      return localArrayList;
    }
    if (paramString2.equals("DVM"))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(".cfg");
      localArrayList.add(paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(".jar");
      localArrayList.add(paramString2.toString());
      return localArrayList;
    }
    return null;
  }
  
  public static Patch b(String paramString, PatchInfo paramPatchInfo)
  {
    String str = paramPatchInfo.f;
    if (str.equals("Native"))
    {
      paramString = NativePatch.a(paramString, paramPatchInfo);
      if (paramString == null) {
        return null;
      }
      if ((paramString.c.equals(paramPatchInfo.jdField_a_of_type_JavaLangString)) && (paramString.d.equals(paramPatchInfo.b)) && (paramString.e.equals(paramPatchInfo.f)) && (paramString.e.equals("Native")))
      {
        paramString.jdField_a_of_type_ComTencentKingkongPatchInfo = paramPatchInfo;
        return paramString;
      }
      paramPatchInfo = new StringBuilder();
      paramPatchInfo.append("Patch name, version or type mismatch : ");
      paramPatchInfo.append(paramString.c);
      paramPatchInfo.append(", ");
      paramPatchInfo.append(paramString.d);
      paramPatchInfo.append(", ");
      paramPatchInfo.append(paramString.e);
      Common.Log.a("KingKongPatchInfo", paramPatchInfo.toString());
      return null;
    }
    paramString = new StringBuilder();
    paramString.append("Unsupported patch type : ");
    paramString.append(str);
    Common.Log.a("KingKongPatchInfo", paramString.toString());
    return null;
  }
  
  public static ArrayList<String> b(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString2.equals("Native"))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(".cfg");
      localArrayList.add(paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append("lib");
      paramString2.append(paramString1);
      paramString2.append(".so");
      localArrayList.add(paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(".subpatch");
      localArrayList.add(paramString2.toString());
      return localArrayList;
    }
    if (paramString2.equals("DVM"))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(".cfg");
      localArrayList.add(paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(".jar");
      localArrayList.add(paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(".dex");
      localArrayList.add(paramString2.toString());
    }
    return localArrayList;
  }
  
  public abstract int a(Context paramContext);
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(this.c);
    localStringBuilder.append(".cfg");
    return localStringBuilder.toString();
  }
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.Patch
 * JD-Core Version:    0.7.0.1
 */