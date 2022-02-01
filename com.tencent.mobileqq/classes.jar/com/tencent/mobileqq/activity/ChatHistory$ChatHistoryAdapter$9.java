package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.TicketManager;

class ChatHistory$ChatHistoryAdapter$9
  implements View.OnClickListener
{
  ChatHistory$ChatHistoryAdapter$9(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt, ImageViewParameter paramImageViewParameter, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((this.a == -3000) && ((this.b.b.istroop == 1001) || (this.b.b.istroop == 10002)))
    {
      localObject = PkgTools.decodeCgi(this.c);
      localObject = JumpParser.a(this.d.f.app, this.d.f, (String)localObject);
      if (localObject != null) {
        ((JumpAction)localObject).a();
      }
    }
    else
    {
      int i = this.a;
      if ((i != -3000) && (i != -3004) && (i != -30002) && (i != -30003))
      {
        if (i == -3005)
        {
          ChatActivityUtils.a(this.d.f, this.d.f.app, this.b.b.action, this.b.b.shareAppID, this.b.b.msgtype);
        }
        else if (i == -3001)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("schemaurl", this.c);
          String str = this.d.f.app.getCurrentAccountUin();
          ((Bundle)localObject).putString("uin", str);
          ((Bundle)localObject).putString("vkey", ((TicketManager)this.d.f.app.getManager(2)).getSkey(str));
          OpenAppClient.a(this.d.f, (Bundle)localObject);
        }
        else if (((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(this.b.b))
        {
          AIOEmotionFragment.a(paramView.getContext(), this.b.b, this.d.f.K, AnimationUtils.a(paramView));
        }
        else
        {
          i = this.a;
          if ((i == -30002) || (i == -30003)) {
            this.b.b.isInMixedMsg = true;
          }
          PicItemBuilder.a(this.d.f.app, paramView.getContext(), paramView, this.b.b, this.d.f.K, false, true, true, null);
        }
      }
      else {
        ChatActivityUtils.a(this.d.f, this.d.f.app, this.b.b.action, this.b.b.shareAppID, this.b.b.msgtype);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.9
 * JD-Core Version:    0.7.0.1
 */