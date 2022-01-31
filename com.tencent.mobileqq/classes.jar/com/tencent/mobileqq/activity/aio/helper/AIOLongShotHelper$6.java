package com.tencent.mobileqq.activity.aio.helper;

import aekt;
import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;

class AIOLongShotHelper$6
  implements Runnable
{
  AIOLongShotHelper$6(AIOLongShotHelper paramAIOLongShotHelper) {}
  
  public void run()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    int i = aekt.a(248.0F, AIOLongShotHelper.a(this.this$0).a.getResources());
    int j = (int)(i * 420.0F / 472.0F);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = j;
    URLDrawable.getDrawable("http://hbd.url.cn/myapp/qq_desk/mobileQQ_screenshoot/mobileQQ_screenshoot.gif", localURLDrawableOptions).downloadImediatly();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper.6
 * JD-Core Version:    0.7.0.1
 */