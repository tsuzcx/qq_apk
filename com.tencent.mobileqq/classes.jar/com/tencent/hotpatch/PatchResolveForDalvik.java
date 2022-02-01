package com.tencent.hotpatch;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.DexReleasor;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.hotpatch.config.DexPatchItemConfigDalvik;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.app.SystemClassLoaderInjector;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PatchResolveForDalvik
{
  public static int a = 0;
  private static boolean a = false;
  
  public static int a(List<String> paramList, int paramInt)
  {
    if ((paramList != null) && (paramList.size() == paramInt))
    {
      if (paramInt <= 0) {
        return 1;
      }
      String[] arrayOfString = new String[paramInt];
      int[] arrayOfInt = new int[paramInt];
      int i = 0;
      if (i < paramInt)
      {
        Object localObject = (String)paramList.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (;;)
        {
          for (;;)
          {
            return i * 10 + 1;
            localObject = ((String)localObject).split("-");
            if ((localObject != null) && (localObject.length == 2)) {
              try
              {
                int j = Integer.parseInt(localObject[0]);
                int k = Integer.parseInt(localObject[1]);
                if ((j > 0) && (j <= DexReleasor.sExtraDexes.length + 1) && (k >= 0))
                {
                  if (j == 1)
                  {
                    localObject = "Lcom/tencent/common/app/BaseApplicationImpl;";
                  }
                  else
                  {
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("L");
                    ((StringBuilder)localObject).append(InjectUtils.getStartupClassName(j - 2));
                    ((StringBuilder)localObject).append(";");
                    localObject = ((StringBuilder)localObject).toString();
                  }
                  arrayOfString[i] = localObject;
                  arrayOfInt[i] = k;
                  i += 1;
                }
              }
              catch (Exception paramList)
              {
                paramList.printStackTrace();
              }
            }
          }
        }
      }
      return nativeResolvePatchClass(arrayOfString, arrayOfInt, paramInt);
    }
    return 1;
  }
  
  public static void a(Context paramContext, PatchConfig paramPatchConfig)
  {
    if (!jdField_a_of_type_Boolean) {
      if ((!Build.CPU_ABI.toLowerCase(Locale.US).contains("x86")) && (!SoLoadUtil.b())) {
        jdField_a_of_type_Boolean = SoLoadUtilNew.loadSoByName(paramContext, "qq_patch");
      } else {
        jdField_a_of_type_Boolean = SoLoadUtil.a(paramContext, "qq_patch", 0, false, false);
      }
    }
    Object localObject;
    StringBuilder localStringBuilder;
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Int = 609;
      localObject = SystemClassLoaderInjector.a(BaseApplicationImpl.sApplication, 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("PatchResolveForDalvik tryResolvePatchClass unload as resolve lib load failed unloadResult=");
      localStringBuilder.append((String)localObject);
      QLog.d("PatchLogTag", 1, localStringBuilder.toString());
      if ("Success".equals(localObject))
      {
        DexPatchInstaller.jdField_a_of_type_Int = 0;
        DexPatchInstaller.jdField_a_of_type_JavaLangString = "";
      }
    }
    else
    {
      localObject = ((DexPatchItemConfigDalvik)paramPatchConfig.a()).a();
      int i = a((List)localObject, ((ArrayList)localObject).size());
      jdField_a_of_type_Int = i % 10 + 600;
      if (jdField_a_of_type_Int != 600)
      {
        localObject = SystemClassLoaderInjector.a(BaseApplicationImpl.sApplication, 0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("PatchResolveForDalvik tryResolvePatchClass unload as resolve patch class failed unloadResult=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", resolveResult=");
        localStringBuilder.append(i);
        QLog.d("PatchLogTag", 1, localStringBuilder.toString());
        if ("Success".equals(localObject))
        {
          DexPatchInstaller.jdField_a_of_type_Int = 0;
          DexPatchInstaller.jdField_a_of_type_JavaLangString = "";
        }
      }
      else
      {
        QLog.d("PatchLogTag", 1, "PatchResolveForDalvik tryResolvePatchClass success");
      }
    }
    PatchReporter.reportPatchEvent(paramContext, "", "actPatchResolve", jdField_a_of_type_Int, paramPatchConfig.b());
  }
  
  public static native int nativeResolvePatchClass(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hotpatch.PatchResolveForDalvik
 * JD-Core Version:    0.7.0.1
 */