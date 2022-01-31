package com.tencent.biz.pubaccount.weishi_new;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import sji;

public class WSRecommendFragment$InternetDynamicBroadCastReceiver
  extends BroadcastReceiver
{
  public WSRecommendFragment$InternetDynamicBroadCastReceiver(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("position", -1);
      int j = paramIntent.getIntExtra("is_ding", -1);
      if ((i != -1) && (j != -1) && (WSRecommendFragment.a(this.a) != null)) {
        WSRecommendFragment.a(this.a).a(i, j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment.InternetDynamicBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */