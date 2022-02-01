package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.troop.TroopFileProxyActivity;

class TroopFileItemBuilder$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    MessageForTroopFile localMessageForTroopFile = this.a.a(paramView);
    Activity localActivity = (Activity)paramView.getContext();
    Intent localIntent = new Intent();
    if (localIntent == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localIntent.putExtra(TroopFileProxyActivity.a, localMessageForTroopFile.frienduin);
      TroopFileProxyActivity.a(localActivity, localIntent, this.a.a.getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */