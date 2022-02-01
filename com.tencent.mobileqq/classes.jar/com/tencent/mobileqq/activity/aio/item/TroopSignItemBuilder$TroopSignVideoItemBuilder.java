package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.troop.widget.TroopSignVideoView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;

public class TroopSignItemBuilder$TroopSignVideoItemBuilder
  extends TroopSignItemBuilder
{
  protected static long C;
  protected static HashMap<ChatMessage, TroopSignItemBuilder.TroopSignVideoItemBuilder.IOnOfflineResCallback> D = new HashMap(5);
  protected TroopChatPie E;
  
  public TroopSignItemBuilder$TroopSignVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, TroopChatPie paramTroopChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.E = paramTroopChatPie;
  }
  
  public static void h()
  {
    if (System.currentTimeMillis() - C < 600000L) {
      return;
    }
    C = System.currentTimeMillis();
    HtmlOffline.b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = HtmlOffline.d("2833");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkOffline version = ");
      localStringBuilder.append(str);
      QLog.d("TroopSignItemBuilder", 2, localStringBuilder.toString());
    }
    HtmlOffline.a("2833", localQQAppInterface, new TroopSignItemBuilder.TroopSignVideoItemBuilder.5(), true, 0, true);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder localSignVideoItemHolder = (TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder)paramViewHolder;
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.e).inflate(2131629610, paramBaseChatItemLayout, false);
      localSignVideoItemHolder.a = ((RelativeLayout)paramViewHolder);
      localSignVideoItemHolder.v = ((TroopSignVideoView)localSignVideoItemHolder.a.findViewById(2131431458));
      localSignVideoItemHolder.b = ((TextView)localSignVideoItemHolder.a.findViewById(2131446627));
      localSignVideoItemHolder.c = ((ImageView)localSignVideoItemHolder.a.findViewById(2131437945));
      localSignVideoItemHolder.d = ((TextView)localSignVideoItemHolder.a.findViewById(2131437947));
      localSignVideoItemHolder.e = localSignVideoItemHolder.a.findViewById(2131437946);
      localSignVideoItemHolder.f = ((TextView)localSignVideoItemHolder.a.findViewById(2131437949));
      localSignVideoItemHolder.g = ((TextView)localSignVideoItemHolder.a.findViewById(2131437944));
      localSignVideoItemHolder.s = localSignVideoItemHolder.a.findViewById(2131437948);
      localSignVideoItemHolder.w = localSignVideoItemHolder.a.findViewById(2131437622);
      localSignVideoItemHolder.x = localSignVideoItemHolder.a.findViewById(2131437654);
      localSignVideoItemHolder.v.setFocusable(false);
      localSignVideoItemHolder.v.setFocusableInTouchMode(false);
      localSignVideoItemHolder.v.setClickable(false);
      localSignVideoItemHolder.v.setFps(30);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView = this.E;
      if (paramView != null) {
        paramView.a(new TroopSignItemBuilder.TroopSignVideoItemBuilder.1(this, localSignVideoItemHolder, paramBaseChatItemLayout));
      }
      localSignVideoItemHolder.v.setOnPlayedListener(new TroopSignItemBuilder.TroopSignVideoItemBuilder.2(this, localSignVideoItemHolder));
    }
    boolean bool = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
    if (!bool)
    {
      localSignVideoItemHolder.b.setText(localMessageForTroopSign.msgContent);
      localSignVideoItemHolder.v.setShowCover(true);
    }
    else
    {
      localSignVideoItemHolder.b.setText("");
      localSignVideoItemHolder.v.setShowCover(false);
    }
    paramView = localMessageForTroopSign.dynamicSource;
    if (!paramView.equals(localSignVideoItemHolder.v.getTag()))
    {
      localSignVideoItemHolder.w.setVisibility(0);
      localSignVideoItemHolder.v.setTag(paramView);
      localSignVideoItemHolder.v.a();
      paramOnLongClickAndTouchListener = new StringBuilder();
      paramOnLongClickAndTouchListener.append(OfflineEnvHelper.b("2833"));
      paramOnLongClickAndTouchListener.append("2833");
      paramOnLongClickAndTouchListener.append("/troop_sign/");
      paramOnLongClickAndTouchListener.append(paramView);
      paramOnLongClickAndTouchListener.append(".mp4");
      paramOnLongClickAndTouchListener = paramOnLongClickAndTouchListener.toString();
      if (new File(paramOnLongClickAndTouchListener).exists())
      {
        paramChatMessage = this.E;
        if ((paramChatMessage != null) && (paramChatMessage.ck)) {
          localSignVideoItemHolder.v.setFilePath(paramOnLongClickAndTouchListener);
        } else {
          localSignVideoItemHolder.v.a(paramOnLongClickAndTouchListener);
        }
        localSignVideoItemHolder.x.setVisibility(8);
      }
      else
      {
        if (!D.containsKey(paramChatMessage))
        {
          D.put(paramChatMessage, new TroopSignItemBuilder.TroopSignVideoItemBuilder.3(this, paramOnLongClickAndTouchListener, localSignVideoItemHolder));
          h();
        }
        localSignVideoItemHolder.x.setVisibility(0);
      }
      a(localSignVideoItemHolder.w, "2833", paramView, bool);
    }
    else
    {
      paramChatMessage = this.E;
      if ((paramChatMessage != null) && (!paramChatMessage.ck)) {
        h.postDelayed(new TroopSignItemBuilder.TroopSignVideoItemBuilder.4(this, localSignVideoItemHolder), 200L);
      } else {
        a(localSignVideoItemHolder.w, "2833", paramView, bool);
      }
    }
    a(localSignVideoItemHolder, localMessageForTroopSign);
    if ((AppSetting.e) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle)))
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("");
      paramChatMessage.append(localMessageForTroopSign.msgTitle);
      paramViewHolder.setContentDescription(paramChatMessage.toString());
    }
    a(localSignVideoItemHolder, paramBaseChatItemLayout);
    paramChatMessage = (FrameLayout.LayoutParams)localSignVideoItemHolder.u.getLayoutParams();
    if (localMessageForTroopSign.isSend()) {
      paramChatMessage.leftMargin = (BaseChatItemLayout.getBubblePaddingAlignError() + DisplayUtil.a(this.e, 10.0F));
    } else {
      paramChatMessage.leftMargin = DisplayUtil.a(this.e, 10.0F);
    }
    localSignVideoItemHolder.u.setLayoutParams(paramChatMessage);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder();
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean) {}
  
  protected void a(View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(OfflineEnvHelper.b(paramString1));
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("/troop_sign/");
    ((StringBuilder)localObject).append(paramString2);
    if (paramBoolean) {
      paramString1 = "_no_summary";
    } else {
      paramString1 = "";
    }
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(".png");
    paramString1 = new File(((StringBuilder)localObject).toString());
    if (paramString1.exists())
    {
      paramString2 = URLDrawable.URLDrawableOptions.obtain();
      localObject = new ColorDrawable(0);
      paramString2.mFailedDrawable = ((Drawable)localObject);
      paramString2.mLoadingDrawable = ((Drawable)localObject);
      try
      {
        paramView.setBackgroundDrawable(URLDrawable.getDrawable(paramString1.toURL(), paramString2));
        return;
      }
      catch (MalformedURLException paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    paramString1 = URLDrawable.URLDrawableOptions.obtain();
    paramString2 = new ColorDrawable(0);
    paramString1.mFailedDrawable = paramString2;
    paramString1.mLoadingDrawable = paramString2;
    paramString1 = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/troop_sign_loading.png", paramString1);
    paramString1.setTag(URLDrawableDecodeHandler.b(287, 287, DisplayUtil.a(this.e, 5.0F)));
    paramString1.setDecodeHandler(URLDrawableDecodeHandler.j);
    paramView.setBackgroundDrawable(paramString1);
  }
  
  public void b()
  {
    D.clear();
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */