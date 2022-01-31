package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import tby;
import tfw;
import tlo;

public class WSRecommendFragment$InternetDynamicBroadCastReceiver
  extends BroadcastReceiver
{
  public WSRecommendFragment$InternetDynamicBroadCastReceiver(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (!"weishi_public_account_ding_state_change".equals(paramContext)) {
        break label70;
      }
      i = paramIntent.getIntExtra("position", -1);
      j = paramIntent.getIntExtra("is_ding", -1);
      if ((i != -1) && (j != -1) && (WSRecommendFragment.a(this.a) != null)) {
        WSRecommendFragment.a(this.a).a(i, j);
      }
    }
    label70:
    while (!"weishi_public_account_follow_state_change".equals(paramContext))
    {
      int i;
      int j;
      return;
    }
    tfw.a.poster.followStatus = paramIntent.getIntExtra("followStatus", 2);
    tlo.d("VerticalVideoLayerTopPresenter", "WSGridCardPresenter.clickFeed.poster.followStatus:" + tfw.a.poster.followStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment.InternetDynamicBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */