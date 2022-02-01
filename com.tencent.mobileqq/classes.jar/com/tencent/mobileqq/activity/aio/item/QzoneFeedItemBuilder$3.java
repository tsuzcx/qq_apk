package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQzoneReq;
import java.util.HashMap;
import mqq.app.NewIntent;

class QzoneFeedItemBuilder$3
  implements View.OnClickListener
{
  boolean a = this.c;
  int b = this.d;
  
  QzoneFeedItemBuilder$3(QzoneFeedItemBuilder paramQzoneFeedItemBuilder, boolean paramBoolean, int paramInt1, QzoneFeedItemBuilder.Holder paramHolder, String paramString, int paramInt2, MessageForQzoneFeed paramMessageForQzoneFeed) {}
  
  public void onClick(View paramView)
  {
    this.a ^= true;
    if (this.a)
    {
      this.b += 1;
      this.e.D.setText(QzoneFeedItemBuilder.a(this.b));
    }
    else
    {
      this.b -= 1;
      this.e.D.setText(QzoneFeedItemBuilder.a(this.b));
    }
    Object localObject1 = this.e.E;
    int j;
    if (this.a) {
      j = 2130849416;
    } else {
      j = 2130849415;
    }
    ((ImageView)localObject1).setImageResource(j);
    localObject1 = ((IQzoneReq)QRoute.api(IQzoneReq.class)).getLikeIntent(this.i.a.getApplication(), null, this.i.a.getLongAccountUin(), this.f, this.a, this.g);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("like_key", this.a);
    ((NewIntent)localObject1).putExtras((Bundle)localObject2);
    this.i.a.startServlet((NewIntent)localObject1);
    localObject1 = this.h;
    ((MessageForQzoneFeed)localObject1).ulikeNum = this.b;
    if (((MessageForQzoneFeed)localObject1).mapExt == null) {
      this.h.mapExt = new HashMap();
    }
    localObject2 = this.h.mapExt;
    if (this.a) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ((HashMap)localObject2).put("isliked", localObject1);
    this.i.a.getMessageFacade().a(this.h, false);
    localObject1 = this.i.a.getMessageFacade();
    localObject2 = this.h;
    ((QQMessageFacade)localObject1).a((MessageRecord)localObject2, ((MessageForQzoneFeed)localObject2).selfuin);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QzoneFeedItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */