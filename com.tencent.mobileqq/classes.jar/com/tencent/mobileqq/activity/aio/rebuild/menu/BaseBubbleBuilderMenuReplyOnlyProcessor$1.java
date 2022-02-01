package com.tencent.mobileqq.activity.aio.rebuild.menu;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.api.ITroopInfoService.GetTroopCodeCallback;

class BaseBubbleBuilderMenuReplyOnlyProcessor$1
  implements ITroopInfoService.GetTroopCodeCallback
{
  BaseBubbleBuilderMenuReplyOnlyProcessor$1(BaseBubbleBuilderMenuReplyOnlyProcessor paramBaseBubbleBuilderMenuReplyOnlyProcessor, Intent paramIntent, Context paramContext) {}
  
  public void onResult(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      this.a.putExtra("troop_uin", (String)paramObject);
      this.a.putExtra("cSpecialFlag", 0);
      this.b.startActivity(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuReplyOnlyProcessor.1
 * JD-Core Version:    0.7.0.1
 */