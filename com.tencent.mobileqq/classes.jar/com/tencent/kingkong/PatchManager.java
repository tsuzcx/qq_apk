package com.tencent.kingkong;

import abui;
import abum;
import abus;
import abut;
import abuv;
import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PatchManager
{
  private static Context jdField_a_of_type_AndroidContentContext;
  private static String jdField_a_of_type_JavaLangString = "";
  private static String b = "";
  private static String c = "/";
  
  private static ArrayList<abus> a()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = abum.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (abut)((Iterator)localObject1).next();
      if (((abut)localObject2).g.equals("READY"))
      {
        localObject2 = abus.b(b, (abut)localObject2);
        if (localObject2 != null) {
          localArrayList1.add(localObject2);
        }
      }
    }
    localObject1 = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < localArrayList1.size())
      {
        localObject2 = localArrayList1.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          abus localabus = (abus)((Iterator)localObject2).next();
          if (!localArrayList2.contains(localabus))
          {
            String str1 = localabus.a.k;
            String str2 = localabus.a.jdField_a_of_type_JavaLangString;
            if (str1.equals(""))
            {
              abui.a("KingKongPatchManager", "Patch is ready -->" + str2);
              localArrayList2.add(localabus);
              ((ArrayList)localObject1).add(str2);
            }
            else if (((ArrayList)localObject1).contains(str1))
            {
              abui.a("KingKongPatchManager", "Patch is ready -->" + str2 + ", previous patch is " + str1);
              localArrayList2.add(localabus);
              ((ArrayList)localObject1).add(str2);
            }
          }
        }
        if (localArrayList2.size() != localArrayList1.size()) {}
      }
      else
      {
        return localArrayList2;
      }
      i += 1;
    }
  }
  
  public static void a()
  {
    Common.a(true);
    Object localObject1 = a();
    Common.a(true);
    HashMap localHashMap = new HashMap();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      abus localabus = (abus)((Iterator)localObject1).next();
      Object localObject2 = localabus.a;
      String str = ((abut)localObject2).k;
      localObject2 = ((abut)localObject2).jdField_a_of_type_JavaLangString;
      if ((!str.equals("")) && ((!localHashMap.containsKey(str)) || (((Integer)localHashMap.get(str)).intValue() != 0)))
      {
        abui.a("KingKongPatchManager", "Previouse patch " + str + " of " + (String)localObject2 + " failed");
      }
      else
      {
        int i = localabus.a(jdField_a_of_type_AndroidContentContext);
        localHashMap.put(localObject2, Integer.valueOf(i));
        Common.a(i, localabus.c, localabus.e, localabus.d, "");
      }
    }
  }
  
  public static boolean a()
  {
    if (Common.a() == 1) {
      return true;
    }
    try
    {
      Object localObject = new File(jdField_a_of_type_JavaLangString);
      if (!((File)localObject).exists())
      {
        if (((File)localObject).mkdirs()) {
          abui.a("KingKongPatchManager", "Create patch download folder : " + jdField_a_of_type_JavaLangString + " OK");
        }
      }
      else
      {
        localObject = new File(b);
        if (!((File)localObject).exists())
        {
          if (!((File)localObject).mkdirs()) {
            break label212;
          }
          abui.a("KingKongPatchManager", "Create patch folder : " + b + " OK");
        }
        localObject = new File(jdField_a_of_type_JavaLangString + c + "KingkongPatch.apk");
        if ((!((File)localObject).exists()) || (((File)localObject).delete())) {
          break label245;
        }
        abui.a("KingKongPatchManager", "Delete asset file failed");
        return false;
      }
      abui.a("KingKongPatchManager", "Create patch download folder : " + jdField_a_of_type_JavaLangString + " failed");
      return false;
      label212:
      abui.a("KingKongPatchManager", "Create patch folder : " + b + " failed");
      return false;
      label245:
      if (!((File)localObject).exists())
      {
        if (!abuv.a(jdField_a_of_type_AndroidContentContext, "KingkongPatch.apk", ((File)localObject).getAbsolutePath()))
        {
          abui.a("KingKongPatchManager", "Copy KingkongPatch.apk from asset failed");
          return false;
        }
        abui.a("KingKongPatchManager", "Copy KingkongPatch.apk from asset OK");
      }
      localObject = jdField_a_of_type_JavaLangString + c + "KingkongPatch.apk";
      if (!abuv.a(b + c + "libkkfixerdriver.so", (String)localObject, "libkkfixerdriver.so", false)) {
        return false;
      }
      localObject = jdField_a_of_type_JavaLangString + c + "KingkongPatch.apk";
      if (!abuv.a(b + c + "libPatchDispatcher.so", (String)localObject, "libPatchDispatcher.so", false)) {
        return false;
      }
      localObject = new File(jdField_a_of_type_JavaLangString + c + "KingkongPatch.apk");
      if ((((File)localObject).exists()) && (!((File)localObject).delete()))
      {
        abui.a("KingKongPatchManager", "Delete asset file failed");
        return false;
      }
      Common.a(1);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = true;
    if (paramContext == null) {}
    for (;;)
    {
      return bool1;
      try
      {
        jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
        jdField_a_of_type_JavaLangString = Common.a();
        b = Common.b();
        Common.a(true);
        if (!a())
        {
          bool1 = false;
          continue;
        }
        Common.a(true);
        boolean bool2 = b();
        if (bool2) {
          continue;
        }
        bool1 = false;
      }
      finally {}
    }
  }
  
  private static boolean b()
  {
    String str1 = b + c + "libkkfixerdriver.so";
    String str2 = b + c + "libPatchDispatcher.so";
    try
    {
      System.load(str2);
      System.load(str1);
      abui.a("KingKongPatchManager", "Load library " + str1 + " OK");
      return true;
    }
    catch (Exception localException)
    {
      abui.a("KingKongPatchManager", "Load library " + str1 + " failed : " + localException);
      return false;
    }
    catch (Throwable localThrowable)
    {
      abui.a("KingKongPatchManager", "Load library " + str1 + " failed : " + localThrowable);
    }
    return false;
  }
  
  public static native int nativeCalcGotHookPoint(String paramString);
  
  public static native int nativeCalcJumperPoint(String paramString);
  
  public static native int nativeCalcParameter(int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  public static native boolean nativeDoPatch(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, int paramInt4, int paramInt5);
  
  public static native byte[] nativeGetFingerprint(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public static native boolean nativeHoldLibStrongRef(String paramString);
  
  public static native boolean nativeVerifyPatchParams(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.kingkong.PatchManager
 * JD-Core Version:    0.7.0.1
 */