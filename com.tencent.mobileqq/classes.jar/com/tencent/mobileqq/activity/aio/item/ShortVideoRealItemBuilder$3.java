package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import bace;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.Map;

class ShortVideoRealItemBuilder$3
  implements Runnable
{
  ShortVideoRealItemBuilder$3(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a))
    {
      if (ShortVideoRealItemBuilder.a().size() == 0) {
        RMVideoStateMgr.c(this.a);
      }
      bace.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */