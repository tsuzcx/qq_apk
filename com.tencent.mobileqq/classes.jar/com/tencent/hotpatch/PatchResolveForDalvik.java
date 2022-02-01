package com.tencent.hotpatch;

import acvb;
import acvd;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anvq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.DexReleasor;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PatchResolveForDalvik
{
  public static int a;
  private static boolean a;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public static int a(List<String> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() != paramInt) || (paramInt <= 0)) {
      return 1;
    }
    String[] arrayOfString = new String[paramInt];
    int[] arrayOfInt = new int[paramInt];
    int i = 0;
    if (i < paramInt)
    {
      Object localObject = (String)paramList.get(i);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return i * 10 + 1;
      }
      localObject = ((String)localObject).split("-");
      if ((localObject == null) || (localObject.length != 2)) {
        return i * 10 + 1;
      }
      int j;
      int k;
      try
      {
        j = Integer.parseInt(localObject[0]);
        k = Integer.parseInt(localObject[1]);
        if ((j <= 0) || (j > DexReleasor.sExtraDexes.length + 1) || (k < 0)) {
          return i * 10 + 1;
        }
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return i * 10 + 1;
      }
      if (j == 1) {}
      for (localObject = "Lcom/tencent/common/app/BaseApplicationImpl;";; localObject = "L" + InjectUtils.getStartupClassName(j - 2) + ";")
      {
        arrayOfString[i] = localObject;
        arrayOfInt[i] = k;
        i += 1;
        break;
      }
    }
    return nativeResolvePatchClass(arrayOfString, arrayOfInt, paramInt);
  }
  
  public static void a(Context paramContext, acvd paramacvd)
  {
    Object localObject;
    if (!jdField_a_of_type_Boolean)
    {
      if ((Build.CPU_ABI.toLowerCase(Locale.US).contains("x86")) || (SoLoadUtil.b())) {
        jdField_a_of_type_Boolean = SoLoadUtil.a(paramContext, "qq_patch", 0, false, false);
      }
    }
    else
    {
      if (jdField_a_of_type_Boolean) {
        break label132;
      }
      jdField_a_of_type_Int = 609;
      localObject = anvq.a(BaseApplicationImpl.sApplication, 0);
      QLog.d("PatchLogTag", 1, "PatchResolveForDalvik tryResolvePatchClass unload as resolve lib load failed unloadResult=" + (String)localObject);
      if ("Success".equals(localObject))
      {
        acut.jdField_a_of_type_Int = 0;
        acut.jdField_a_of_type_JavaLangString = "";
      }
    }
    for (;;)
    {
      PatchReporter.reportPatchEvent(paramContext, "", "actPatchResolve", jdField_a_of_type_Int, paramacvd.b());
      return;
      jdField_a_of_type_Boolean = SoLoadUtilNew.loadSoByName(paramContext, "qq_patch");
      break;
      label132:
      localObject = ((acvb)paramacvd.a()).a();
      int i = a((List)localObject, ((ArrayList)localObject).size());
      jdField_a_of_type_Int = i % 10 + 600;
      if (jdField_a_of_type_Int != 600)
      {
        localObject = anvq.a(BaseApplicationImpl.sApplication, 0);
        QLog.d("PatchLogTag", 1, "PatchResolveForDalvik tryResolvePatchClass unload as resolve patch class failed unloadResult=" + (String)localObject + ", resolveResult=" + i);
        if ("Success".equals(localObject))
        {
          acut.jdField_a_of_type_Int = 0;
          acut.jdField_a_of_type_JavaLangString = "";
        }
      }
      else
      {
        QLog.d("PatchLogTag", 1, "PatchResolveForDalvik tryResolvePatchClass success");
      }
    }
  }
  
  public static native int nativeResolvePatchClass(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.PatchResolveForDalvik
 * JD-Core Version:    0.7.0.1
 */