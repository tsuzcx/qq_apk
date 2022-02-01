package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import java.util.List;

final class WeishiUtils$7
  implements Runnable
{
  WeishiUtils$7(List paramList, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      String str = WeishiUtils.a((stSimpleMetaFeed)this.jdField_a_of_type_JavaUtilList.get(i), this.jdField_a_of_type_Boolean);
      if (TextUtils.isEmpty(str)) {}
      for (;;)
      {
        i += 1;
        break;
        WeishiUtils.a(str, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.7
 * JD-Core Version:    0.7.0.1
 */