package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import bhmi;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.Map;

class LightVideoItemBuilder$3
  implements Runnable
{
  public void run()
  {
    if (!TextUtils.isEmpty(this.a))
    {
      if (LightVideoItemBuilder.a().size() == 0) {
        RMVideoStateMgr.c(this.a);
      }
      bhmi.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */