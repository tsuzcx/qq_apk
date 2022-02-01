package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutHandler;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListenerController;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.recent.OnlineStatusExposureHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.OnlineStatusCircleView;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class OnlineStatusChatLayoutHandler
  extends ChatLayoutHandler
{
  private final HashMap<Long, SoftReference<BaseChatItemLayout>> a = new HashMap();
  private final OnlineStatusObserver g = new OnlineStatusChatLayoutHandler.1(this);
  
  public OnlineStatusChatLayoutHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener, paramOnLongClickListener, paramIChatLayoutListenerController);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, ChatMessage paramChatMessage, Drawable paramDrawable)
  {
    if (paramBaseChatItemLayout.af != null)
    {
      paramBaseChatItemLayout.af.setImageDrawable(paramDrawable);
      return;
    }
    paramBaseChatItemLayout.af = new OnlineStatusCircleView(this.d, 12);
    paramBaseChatItemLayout.af.setImageDrawable(paramDrawable);
    paramBaseChatItemLayout.af.setScaleType(ImageView.ScaleType.FIT_XY);
    if (QQTheme.isNowThemeIsNight()) {
      paramBaseChatItemLayout.af.setBackgroundColor(Color.parseColor("#000000"));
    } else {
      paramBaseChatItemLayout.af.setBackgroundColor(Color.parseColor("#EBEDF5"));
    }
    paramDrawable = new RelativeLayout.LayoutParams(ScreenUtil.dip2px(14.0F), ScreenUtil.dip2px(14.0F));
    paramDrawable.addRule(8, 2131430587);
    paramDrawable.addRule(7, 2131430587);
    paramBaseChatItemLayout.af.setFocusable(false);
    paramBaseChatItemLayout.af.setOnClickListener(new OnlineStatusChatLayoutHandler.2(this, paramChatMessage));
    paramBaseChatItemLayout.addView(paramBaseChatItemLayout.af, paramDrawable);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, Bundle paramBundle)
  {
    if ((this.c.a == 0) && (paramChatMessage.isSend()) && (!paramBundle.getBoolean("inInMiniAIO")) && ((paramBaseChatItemLayout.ac == null) || (paramBaseChatItemLayout.ac.getVisibility() != 0)) && (OnlineStatusExposureHelper.a()) && (!SimpleUIUtil.e()) && (OnlineStatusExposureHelper.b()) && ((AIOLongShotHelper.f() == null) || (!AIOLongShotHelper.f().c())) && (!OnlineStatusExposureHelper.b(this.b, paramChatMessage.selfuin)) && ((!OnlineStatusExposureHelper.e(this.b, paramChatMessage.selfuin)) || (OnlineStatusExposureHelper.d(this.b, paramChatMessage.frienduin))))
    {
      a(paramBaseChatItemLayout, paramChatMessage, OnlineStatusExposureHelper.c(this.b, paramChatMessage.selfuin));
      paramBaseChatItemLayout.af.setVisibility(0);
      this.a.put(Long.valueOf(paramChatMessage.getId()), new SoftReference(paramBaseChatItemLayout));
      return;
    }
    if (paramBaseChatItemLayout.af != null) {
      paramBaseChatItemLayout.af.setVisibility(8);
    }
  }
  
  private void c()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      BaseChatItemLayout localBaseChatItemLayout = (BaseChatItemLayout)((SoftReference)localIterator.next()).get();
      if ((localBaseChatItemLayout != null) && (localBaseChatItemLayout.af != null)) {
        if (OnlineStatusExposureHelper.b(this.b, this.b.getCurrentUin()))
        {
          localBaseChatItemLayout.af.setVisibility(8);
        }
        else
        {
          localBaseChatItemLayout.af.setVisibility(0);
          localBaseChatItemLayout.af.setImageDrawable(OnlineStatusExposureHelper.c(this.b, this.b.getCurrentUin()));
        }
      }
    }
  }
  
  public void a()
  {
    this.b.addObserver(this.g);
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    a(paramChatMessage, paramBaseChatItemLayout, paramBundle);
  }
  
  public void b()
  {
    this.b.removeObserver(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.OnlineStatusChatLayoutHandler
 * JD-Core Version:    0.7.0.1
 */