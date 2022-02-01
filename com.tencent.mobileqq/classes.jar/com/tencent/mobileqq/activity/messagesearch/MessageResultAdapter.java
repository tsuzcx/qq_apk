package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;

public class MessageResultAdapter
  extends BaseMessageResultAdapter
{
  public MessageResultAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramMqqWeakReferenceHandler, paramSessionInfo, paramQQAppInterface);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageItem localMessageItem = (MessageItem)getItem(paramInt);
    View localView;
    BaseMessageResultAdapter.MessageHolder localMessageHolder;
    if (paramView == null)
    {
      localView = View.inflate(this.e, 2131625303, null);
      localMessageHolder = new BaseMessageResultAdapter.MessageHolder();
      localMessageHolder.b = ((ColorNickTextView)localView.findViewById(2131447063));
      localMessageHolder.c = ((TextView)localView.findViewById(2131447065));
      localMessageHolder.a = ((ImageView)localView.findViewById(2131435219));
      localMessageHolder.d = ((TextView)localView.findViewById(2131436844));
      localView.setTag(localMessageHolder);
    }
    else
    {
      localMessageHolder = (BaseMessageResultAdapter.MessageHolder)paramView.getTag();
      localView = paramView;
    }
    MessageRecord localMessageRecord = localMessageItem.b;
    paramView = ColorNickManager.a(localMessageRecord.msg, localMessageRecord, 32, 3);
    localMessageHolder.c.setText(paramView);
    Object localObject1 = localMessageRecord.senderuin;
    paramView = (View)localObject1;
    if (this.g.a != 1)
    {
      paramView = (View)localObject1;
      if (this.g.a != 3000) {
        if (localMessageRecord.isSend()) {
          paramView = this.h.getCurrentAccountUin();
        } else {
          paramView = this.g.b;
        }
      }
    }
    Object localObject2;
    if (AnonymousChatHelper.c(localMessageRecord))
    {
      paramView = AnonymousChatHelper.g(localMessageRecord);
      localObject1 = localMessageHolder.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.e.getResources().getString(2131895011));
      ((StringBuilder)localObject2).append(paramView.c);
      ((ColorNickTextView)localObject1).setText(((StringBuilder)localObject2).toString());
      localMessageHolder.a.setBackgroundDrawable(URLDrawable.getDrawable(AnonymousChatHelper.a(paramView.d)));
    }
    else
    {
      localObject1 = TroopBusinessUtil.a(localMessageRecord);
      if (localObject1 != null)
      {
        paramView = ((TroopBusinessUtil.TroopBusinessMessage)localObject1).d;
        localObject2 = this.e.getResources().getDrawable(2130841060);
        localObject1 = URLDrawable.getDrawable(((TroopBusinessUtil.TroopBusinessMessage)localObject1).b, (Drawable)localObject2, (Drawable)localObject2);
        ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.b(100, 100, 6));
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.b);
        localMessageHolder.a.setBackgroundDrawable((Drawable)localObject1);
      }
      else
      {
        localObject1 = ContactUtils.a(this.h, this.g, localMessageRecord.isSend(), localMessageRecord.senderuin);
        localMessageHolder.a.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.h, 1, paramView));
        paramView = (View)localObject1;
      }
      paramView = new ColorNickText(paramView, 32).b();
      localMessageHolder.b.setText(paramView);
      ColorNickManager.a(this.h, localMessageHolder.b, paramView);
    }
    localMessageHolder.d.setText(localMessageItem.a(localMessageRecord.time));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */