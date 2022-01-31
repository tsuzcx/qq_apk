package com.tencent.kingkong;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import zyw;
import zza;
import zzg;
import zzh;
import zzj;

public class PatchManager
{
  private static Context jdField_a_of_type_AndroidContentContext;
  private static String jdField_a_of_type_JavaLangString = "";
  private static String b = "";
  private static String c = "/";
  
  private static ArrayList<zzg> a()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = zza.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (zzh)((Iterator)localObject1).next();
      if (((zzh)localObject2).g.equals("READY"))
      {
        localObject2 = zzg.b(b, (zzh)localObject2);
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
          zzg localzzg = (zzg)((Iterator)localObject2).next();
          if (!localArrayList2.contains(localzzg))
          {
            String str1 = localzzg.a.k;
            String str2 = localzzg.a.jdField_a_of_type_JavaLangString;
            if (str1.equals(""))
            {
              zyw.a("KingKongPatchManager", "Patch is ready -->" + str2);
              localArrayList2.add(localzzg);
              ((ArrayList)localObject1).add(str2);
            }
            else if (((ArrayList)localObject1).contains(str1))
            {
              zyw.a("KingKongPatchManager", "Patch is ready -->" + str2 + ", previous patch is " + str1);
              localArrayList2.add(localzzg);
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
      zzg localzzg = (zzg)((Iterator)localObject1).next();
      Object localObject2 = localzzg.a;
      String str = ((zzh)localObject2).k;
      localObject2 = ((zzh)localObject2).jdField_a_of_type_JavaLangString;
      if ((!str.equals("")) && ((!localHashMap.containsKey(str)) || (((Integer)localHashMap.get(str)).intValue() != 0)))
      {
        zyw.a("KingKongPatchManager", "Previouse patch " + str + " of " + (String)localObject2 + " failed");
      }
      else
      {
        int i = localzzg.a(jdField_a_of_type_AndroidContentContext);
        localHashMap.put(localObject2, Integer.valueOf(i));
        Common.a(i, localzzg.c, localzzg.e, localzzg.d, "");
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
          zyw.a("KingKongPatchManager", "Create patch download folder : " + jdField_a_of_type_JavaLangString + " OK");
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
          zyw.a("KingKongPatchManager", "Create patch folder : " + b + " OK");
        }
        localObject = new File(jdField_a_of_type_JavaLangString + c + "KingkongPatch.apk");
        if ((!((File)localObject).exists()) || (((File)localObject).delete())) {
          break label245;
        }
        zyw.a("KingKongPatchManager", "Delete asset file failed");
        return false;
      }
      zyw.a("KingKongPatchManager", "Create patch download folder : " + jdField_a_of_type_JavaLangString + " failed");
      return false;
      label212:
      zyw.a("KingKongPatchManager", "Create patch folder : " + b + " failed");
      return false;
      label245:
      if (!((File)localObject).exists())
      {
        if (!zzj.a(jdField_a_of_type_AndroidContentContext, "KingkongPatch.apk", ((File)localObject).getAbsolutePath()))
        {
          zyw.a("KingKongPatchManager", "Copy KingkongPatch.apk from asset failed");
          return false;
        }
        zyw.a("KingKongPatchManager", "Copy KingkongPatch.apk from asset OK");
      }
      localObject = jdField_a_of_type_JavaLangString + c + "KingkongPatch.apk";
      if (!zzj.a(b + c + "libkkfixerdriver.so", (String)localObject, "libkkfixerdriver.so", false)) {
        return false;
      }
      localObject = jdField_a_of_type_JavaLangString + c + "KingkongPatch.apk";
      if (!zzj.a(b + c + "libPatchDispatcher.so", (String)localObject, "libPatchDispatcher.so", false)) {
        return false;
      }
      localObject = new File(jdField_a_of_type_JavaLangString + c + "KingkongPatch.apk");
      if ((((File)localObject).exists()) && (!((File)localObject).delete()))
      {
        zyw.a("KingKongPatchManager", "Delete asset file failed");
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
      zyw.a("KingKongPatchManager", "Load library " + str1 + " OK");
      return true;
    }
    catch (Exception localException)
    {
      zyw.a("KingKongPatchManager", "Load library " + str1 + " failed : " + localException);
      return false;
    }
    catch (Throwable localThrowable)
    {
      zyw.a("KingKongPatchManager", "Load library " + str1 + " failed : " + localThrowable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.kingkong.PatchManager
 * JD-Core Version:    0.7.0.1
 */