package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForScribble;

public class MiniChatTextItemBuilder
  extends TextItemBuilder
{
  public MiniChatTextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramContext = (TextItemBuilder.Holder)paramViewHolder;
    if (paramContext.v != null) {
      if ((!(paramChatMessage instanceof MessageForPoke)) && (!(paramChatMessage instanceof MessageForPokeEmo)))
      {
        if ((paramChatMessage instanceof MessageForScribble)) {
          paramContext.v.setText(HardCodeUtil.a(2131904717));
        } else {
          paramContext.v.setText(HardCodeUtil.a(2131904719));
        }
      }
      else if (TextUtils.isEmpty(paramChatMessage.msg))
      {
        if (((paramChatMessage instanceof MessageForPokeEmo)) && (((MessageForPokeEmo)paramChatMessage).pokeemoId == 13)) {
          paramContext.v.setText(HardCodeUtil.a(2131902134));
        } else {
          paramContext.v.setText(HardCodeUtil.a(2131904718));
        }
      }
      else {
        paramContext.v.setText(paramChatMessage.msg);
      }
    }
    if (paramContext.x != null) {
      paramContext.x.setVisibility(8);
    }
    if (paramContext.y != null) {
      paramContext.y.setVisibility(8);
    }
  }
  
  protected void c(View paramView)
  {
    super.c(paramView);
  }
  
  protected boolean h()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */