package com.tencent.biz.pubaccount.readinjoy.share.watchword;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.mobileqq.app.BaseActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"jumpRecommendFeeds", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJWatchWordShareManager$jumpAction$1
  extends Lambda
  implements Function0<Unit>
{
  public static final 1 INSTANCE = new 1();
  
  RIJWatchWordShareManager$jumpAction$1()
  {
    super(0);
  }
  
  public final void invoke()
  {
    Intent localIntent = ReadInJoyActivityHelper.a((Context)BaseActivity.sTopActivity, 18);
    localIntent.putExtra("is_watch_word_share", true);
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      localBaseActivity.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager.jumpAction.1
 * JD-Core Version:    0.7.0.1
 */