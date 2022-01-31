package com.tencent.mobileqq.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LebaUtil
{
  public static int a(int paramInt)
  {
    return paramInt / 100;
  }
  
  public static Bitmap a(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    if ((i > 150) && (j > 150))
    {
      int k = i / 150;
      j /= 150;
      if (k <= j) {
        break label92;
      }
      i = j;
    }
    label92:
    for (;;)
    {
      localOptions.inSampleSize = i;
      localOptions.inJustDecodeBounds = false;
      return BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
    }
  }
  
  public static File a(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.startsWith("http://"))
      {
        paramString1 = paramString2;
        if (paramString2.length() > 7) {
          paramString1 = paramString2.substring(7);
        }
      }
      paramString1 = StringUtil.e(paramString1);
    }
    return paramContext.getFileStreamPath(paramString1);
  }
  
  public static void a(List paramList1, List paramList2)
  {
    Collections.sort(paramList2, new LebaUtil.LebaItemComparator());
    paramList2 = paramList2.iterator();
    int i = 0;
    int j = -1;
    if (paramList2.hasNext())
    {
      LebaViewItem localLebaViewItem1 = (LebaViewItem)paramList2.next();
      LebaViewItem localLebaViewItem2;
      if (a(localLebaViewItem1.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.sPriority) != j)
      {
        localLebaViewItem2 = new LebaViewItem();
        if (paramList1.size() > 0) {
          if (i < 2)
          {
            ((LebaViewItem)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;
            label101:
            localLebaViewItem2.jdField_a_of_type_JavaLangString = "empty_normal";
            label108:
            paramList1.add(localLebaViewItem2);
            j = a(localLebaViewItem1.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.sPriority);
            localLebaViewItem1.jdField_a_of_type_Int = 1;
            i = 1;
          }
        }
      }
      for (;;)
      {
        paramList1.add(localLebaViewItem1);
        break;
        ((LebaViewItem)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2;
        break label101;
        localLebaViewItem2.jdField_a_of_type_JavaLangString = "empty_normal";
        break label108;
        i += 1;
        localLebaViewItem1.jdField_a_of_type_Int = 3;
      }
    }
    if (paramList1.size() > 0)
    {
      if (i < 2) {
        ((LebaViewItem)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    ((LebaViewItem)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  public static boolean a(LebaViewItem paramLebaViewItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.cDataType == 1)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName)) {
        if ((!"qzone_feedlist".equals(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName)) && (!"nearby_friends".equals(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName)))
        {
          bool1 = bool2;
          if (!"com.tx.xingqubuluo.android".equals(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LebaUtil
 * JD-Core Version:    0.7.0.1
 */