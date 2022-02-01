package com.tencent.kingkong;

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
  
  private static ArrayList<Patch> a()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = MainConfig.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PatchInfo)((Iterator)localObject1).next();
      if (((PatchInfo)localObject2).g.equals("READY"))
      {
        localObject2 = Patch.b(b, (PatchInfo)localObject2);
        if (localObject2 != null) {
          localArrayList1.add(localObject2);
        }
      }
    }
    localObject1 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      localObject2 = localArrayList1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Patch localPatch = (Patch)((Iterator)localObject2).next();
        if (!localArrayList2.contains(localPatch))
        {
          Object localObject3 = localPatch.a.k;
          String str = localPatch.a.jdField_a_of_type_JavaLangString;
          if (((String)localObject3).equals(""))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("Patch is ready -->");
            ((StringBuilder)localObject3).append(str);
            Common.Log.a("KingKongPatchManager", ((StringBuilder)localObject3).toString());
            localArrayList2.add(localPatch);
            ((ArrayList)localObject1).add(str);
          }
          else if (((ArrayList)localObject1).contains(localObject3))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Patch is ready -->");
            localStringBuilder.append(str);
            localStringBuilder.append(", previous patch is ");
            localStringBuilder.append((String)localObject3);
            Common.Log.a("KingKongPatchManager", localStringBuilder.toString());
            localArrayList2.add(localPatch);
            ((ArrayList)localObject1).add(str);
          }
        }
      }
      if (localArrayList2.size() == localArrayList1.size()) {
        return localArrayList2;
      }
      i += 1;
    }
    return localArrayList2;
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
      Object localObject2 = (Patch)((Iterator)localObject1).next();
      Object localObject3 = ((Patch)localObject2).a;
      String str = ((PatchInfo)localObject3).k;
      localObject3 = ((PatchInfo)localObject3).jdField_a_of_type_JavaLangString;
      if ((!str.equals("")) && ((!localHashMap.containsKey(str)) || (((Integer)localHashMap.get(str)).intValue() != 0)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Previouse patch ");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" of ");
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).append(" failed");
        Common.Log.a("KingKongPatchManager", ((StringBuilder)localObject2).toString());
      }
      else
      {
        int i = ((Patch)localObject2).a(jdField_a_of_type_AndroidContentContext);
        localHashMap.put(localObject3, Integer.valueOf(i));
        Common.a(i, ((Patch)localObject2).c, ((Patch)localObject2).e, ((Patch)localObject2).d, "");
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
      boolean bool = ((File)localObject).exists();
      if (!bool)
      {
        bool = ((File)localObject).mkdirs();
        if (bool)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Create patch download folder : ");
          ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(" OK");
          Common.Log.a("KingKongPatchManager", ((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Create patch download folder : ");
          ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(" failed");
          Common.Log.a("KingKongPatchManager", ((StringBuilder)localObject).toString());
          return false;
        }
      }
      localObject = new File(b);
      if (!((File)localObject).exists())
      {
        bool = ((File)localObject).mkdirs();
        if (bool)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Create patch folder : ");
          ((StringBuilder)localObject).append(b);
          ((StringBuilder)localObject).append(" OK");
          Common.Log.a("KingKongPatchManager", ((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Create patch folder : ");
          ((StringBuilder)localObject).append(b);
          ((StringBuilder)localObject).append(" failed");
          Common.Log.a("KingKongPatchManager", ((StringBuilder)localObject).toString());
          return false;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(c);
      ((StringBuilder)localObject).append("KingkongPatch.apk");
      localObject = new File(((StringBuilder)localObject).toString());
      bool = ((File)localObject).exists();
      if ((bool) && (!((File)localObject).delete()))
      {
        Common.Log.a("KingKongPatchManager", "Delete asset file failed");
        return false;
      }
      if (!((File)localObject).exists())
      {
        if (!Utils.a(jdField_a_of_type_AndroidContentContext, "KingkongPatch.apk", ((File)localObject).getAbsolutePath()))
        {
          Common.Log.a("KingKongPatchManager", "Copy KingkongPatch.apk from asset failed");
          return false;
        }
        Common.Log.a("KingKongPatchManager", "Copy KingkongPatch.apk from asset OK");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(c);
      ((StringBuilder)localObject).append("KingkongPatch.apk");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append(c);
      localStringBuilder.append("libkkfixerdriver.so");
      if (!Utils.a(localStringBuilder.toString(), (String)localObject, "libkkfixerdriver.so", false)) {
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(c);
      ((StringBuilder)localObject).append("KingkongPatch.apk");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append(c);
      localStringBuilder.append("libPatchDispatcher.so");
      if (!Utils.a(localStringBuilder.toString(), (String)localObject, "libPatchDispatcher.so", false)) {
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(c);
      ((StringBuilder)localObject).append("KingkongPatch.apk");
      localObject = new File(((StringBuilder)localObject).toString());
      if ((((File)localObject).exists()) && (!((File)localObject).delete()))
      {
        Common.Log.a("KingKongPatchManager", "Delete asset file failed");
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
    if (paramContext == null) {
      return true;
    }
    try
    {
      jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
      jdField_a_of_type_JavaLangString = Common.a();
      b = Common.b();
      Common.a(true);
      boolean bool = a();
      if (!bool) {
        return false;
      }
      Common.a(true);
      bool = b();
      return bool;
    }
    finally {}
  }
  
  private static boolean b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(b);
    ((StringBuilder)localObject1).append(c);
    ((StringBuilder)localObject1).append("libkkfixerdriver.so");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(b);
    ((StringBuilder)localObject2).append(c);
    ((StringBuilder)localObject2).append("libPatchDispatcher.so");
    localObject2 = ((StringBuilder)localObject2).toString();
    try
    {
      System.load((String)localObject2);
      System.load((String)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Load library ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" OK");
      Common.Log.a("KingKongPatchManager", ((StringBuilder)localObject2).toString());
      return true;
    }
    catch (Throwable localThrowable)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Load library ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" failed : ");
      localStringBuilder.append(localThrowable);
      Common.Log.a("KingKongPatchManager", localStringBuilder.toString());
      return false;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Load library ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" failed : ");
      localStringBuilder.append(localException);
      Common.Log.a("KingKongPatchManager", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.PatchManager
 * JD-Core Version:    0.7.0.1
 */