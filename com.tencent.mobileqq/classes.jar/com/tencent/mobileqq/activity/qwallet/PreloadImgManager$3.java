package com.tencent.mobileqq.activity.qwallet;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

class PreloadImgManager$3
  implements Runnable
{
  PreloadImgManager$3(PreloadImgManager paramPreloadImgManager, Set paramSet, String paramString1, String paramString2, AppInterface paramAppInterface, List paramList, String paramString3, Map paramMap, Bundle paramBundle) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = MD5.toMD5(str1);
        Object localObject2 = new File(this.jdField_a_of_type_JavaLangString, str2);
        Object localObject1 = localObject2;
        if (!((File)localObject2).exists()) {
          localObject1 = new File(this.b, str2);
        }
        if (((File)localObject1).exists())
        {
          localObject2 = this.this$0;
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
          if (PreloadImgManager.a((PreloadImgManager)localObject2, MobileQQ.getContext(), ((File)localObject1).getPath(), str1) != null) {}
        }
        else
        {
          this.jdField_a_of_type_JavaUtilList.add(str1);
          localObject1 = new File(this.c, str2);
          this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
          this.jdField_a_of_type_AndroidOsBundle.putString(str1, ((File)localObject1).getPath());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.3
 * JD-Core Version:    0.7.0.1
 */