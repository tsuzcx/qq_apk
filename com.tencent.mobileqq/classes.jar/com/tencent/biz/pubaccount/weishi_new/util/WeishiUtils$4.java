package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import java.net.URL;
import java.util.List;
import sff;
import sfg;
import tlv;
import tlz;

public final class WeishiUtils$4
  implements Runnable
{
  public WeishiUtils$4(List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject = tlv.a((stSimpleMetaFeed)this.jdField_a_of_type_JavaUtilList.get(i), this.jdField_a_of_type_Boolean);
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = tlv.a((String)localObject);
        sfg localsfg = new sfg();
        localsfg.a = ((URL)localObject);
        localsfg.b = true;
        sff.a().a(localsfg, new tlz(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.4
 * JD-Core Version:    0.7.0.1
 */