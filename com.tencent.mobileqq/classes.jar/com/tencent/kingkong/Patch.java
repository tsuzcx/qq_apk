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
      localArrayList.add(paramString1 + ".cfg");
      localArrayList.add("lib" + paramString1 + ".so");
      localArrayList.add(paramString1 + ".subpatch");
      return localArrayList;
    }
    if (paramString2.equals("DVM"))
    {
      localArrayList.add(paramString1 + ".cfg");
      localArrayList.add(paramString1 + ".jar");
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
    }
    else
    {
      Common.Log.a("KingKongPatchInfo", "Unsupported patch type : " + str);
      return null;
    }
    if ((!paramString.c.equals(paramPatchInfo.jdField_a_of_type_JavaLangString)) || (!paramString.d.equals(paramPatchInfo.b)) || (!paramString.e.equals(paramPatchInfo.f)) || (!paramString.e.equals("Native")))
    {
      Common.Log.a("KingKongPatchInfo", "Patch name, version or type mismatch : " + paramString.c + ", " + paramString.d + ", " + paramString.e);
      return null;
    }
    paramString.jdField_a_of_type_ComTencentKingkongPatchInfo = paramPatchInfo;
    return paramString;
  }
  
  public static ArrayList<String> b(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString2.equals("Native"))
    {
      localArrayList.add(paramString1 + ".cfg");
      localArrayList.add("lib" + paramString1 + ".so");
      localArrayList.add(paramString1 + ".subpatch");
    }
    while (!paramString2.equals("DVM")) {
      return localArrayList;
    }
    localArrayList.add(paramString1 + ".cfg");
    localArrayList.add(paramString1 + ".jar");
    localArrayList.add(paramString1 + ".dex");
    return localArrayList;
  }
  
  public abstract int a(Context paramContext);
  
  public String a()
  {
    return this.b + jdField_a_of_type_JavaLangString + this.c + ".cfg";
  }
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.kingkong.Patch
 * JD-Core Version:    0.7.0.1
 */