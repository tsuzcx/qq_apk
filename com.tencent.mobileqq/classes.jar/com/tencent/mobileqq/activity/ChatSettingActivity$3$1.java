package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import java.util.List;

class ChatSettingActivity$3$1
  implements Runnable
{
  ChatSettingActivity$3$1(ChatSettingActivity.3 param3, List paramList) {}
  
  public void run()
  {
    NowSummaryCard.MiniCard localMiniCard = (NowSummaryCard.MiniCard)this.a.get(0);
    Drawable localDrawable = this.b.a.getResources().getDrawable(2130847053);
    ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(ChatSettingActivity.b(this.b.a), localMiniCard.logo.get(), localDrawable, localDrawable, null, true);
    ChatSettingActivity.a(this.b.a, localMiniCard.nick.get());
    ChatSettingActivity.d(this.b.a).setText(ChatSettingActivity.c(this.b.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.3.1
 * JD-Core Version:    0.7.0.1
 */