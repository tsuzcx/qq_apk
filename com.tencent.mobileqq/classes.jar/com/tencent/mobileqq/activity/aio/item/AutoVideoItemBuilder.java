package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.ImageItem;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.VideoItem;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class AutoVideoItemBuilder
  extends BaseBubbleBuilder
{
  private static final int a = ViewUtils.dpToPx(180.0F);
  private static final Drawable w = new ColorDrawable(-1);
  private static final Drawable x = new ColorDrawable(-1);
  private final View.OnClickListener y = new AutoVideoItemBuilder.1(this);
  
  static
  {
    x.setBounds(0, 0, ViewUtils.getScreenWidth(), a);
  }
  
  public AutoVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(URLImageView paramURLImageView, String paramString, Drawable paramDrawable)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramURLImageView.setImageDrawable(paramDrawable);
      paramURLImageView.setTag("");
      return;
    }
    if (paramString.equals((String)paramURLImageView.getTag())) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mFailedDrawable = paramDrawable;
    localURLDrawableOptions.mGifRoundCorner = ViewUtils.dpToPx(2.0F);
    localURLDrawableOptions.mUseSharpPImage = true;
    localURLDrawableOptions.mExtraInfo = paramString;
    localURLDrawableOptions.mPlayGifImage = true;
    paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    paramURLImageView.setTag(paramString);
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    paramQQCustomMenu.a(2131431695, paramContext.getString(2131887718), 2130839061);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)paramOnLongClickAndTouchListener.getTag();
    localAutoVideoMsgViewHolder.j.setHeadIconVisible(false);
    if ((localAutoVideoMsgViewHolder.j.ac != null) && (localAutoVideoMsgViewHolder.j.ac.getVisibility() == 0)) {
      paramInt2 = ViewUtils.dpToPx(33.0F);
    } else {
      paramInt2 = 0;
    }
    paramView = (ViewGroup.MarginLayoutParams)AutoVideoItemBuilder.AutoVideoMsgViewHolder.b(localAutoVideoMsgViewHolder).getLayoutParams();
    if (paramView.leftMargin != paramInt2)
    {
      paramView.leftMargin = paramInt2;
      AutoVideoItemBuilder.AutoVideoMsgViewHolder.b(localAutoVideoMsgViewHolder).setLayoutParams(paramView);
    }
    paramViewGroup = null;
    try
    {
      paramView = (StructMsgSubImageVideo)((MessageForStructing)paramChatMessage).structingMsg;
    }
    catch (Exception paramView)
    {
      Log.w("AutoVideoItemBuilder", "getView: ", paramView);
      paramView = null;
    }
    if (paramView != null)
    {
      StructMsgSubImageVideo.VideoItem localVideoItem = paramView.getVideoItem();
      if (localVideoItem == null)
      {
        paramView = paramView.getImageItem();
        paramViewGroup = paramView;
        if (paramView == null) {}
      }
      else
      {
        paramOnLongClickAndTouchListener.setVisibility(0);
        if (localVideoItem != null)
        {
          localAutoVideoMsgViewHolder.f = localVideoItem.width;
          localAutoVideoMsgViewHolder.g = localVideoItem.height;
          localAutoVideoMsgViewHolder.e = localVideoItem.videoUrl;
          if (localAutoVideoMsgViewHolder.g != 0) {
            paramInt2 = a * localAutoVideoMsgViewHolder.f / localAutoVideoMsgViewHolder.g;
          } else {
            paramInt2 = 0;
          }
          paramView = (RelativeLayout.LayoutParams)localAutoVideoMsgViewHolder.b.getLayoutParams();
          paramView.width = paramInt2;
          localAutoVideoMsgViewHolder.b.setLayoutParams(paramView);
          AutoVideoItemBuilder.AutoVideoMsgViewHolder.c(localAutoVideoMsgViewHolder).setVisibility(8);
          localAutoVideoMsgViewHolder.a.setVisibility(0);
          AutoVideoItemBuilder.AutoVideoMsgViewHolder.d(localAutoVideoMsgViewHolder).setText(localVideoItem.title);
          AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder, localVideoItem.schema);
          a(localAutoVideoMsgViewHolder.b, localVideoItem.coverUrl, x);
          SubscribePlayerManager.a().a(localAutoVideoMsgViewHolder, paramInt1);
        }
        else
        {
          localAutoVideoMsgViewHolder.a.setVisibility(8);
          AutoVideoItemBuilder.AutoVideoMsgViewHolder.d(localAutoVideoMsgViewHolder).setText(paramViewGroup.title);
          AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder, paramViewGroup.schema);
          if (TextUtils.isEmpty(paramViewGroup.imageUrl))
          {
            AutoVideoItemBuilder.AutoVideoMsgViewHolder.c(localAutoVideoMsgViewHolder).setVisibility(8);
          }
          else
          {
            AutoVideoItemBuilder.AutoVideoMsgViewHolder.c(localAutoVideoMsgViewHolder).setVisibility(0);
            a(AutoVideoItemBuilder.AutoVideoMsgViewHolder.c(localAutoVideoMsgViewHolder), paramViewGroup.imageUrl, w);
          }
          SubscribePlayerManager.a().b(localAutoVideoMsgViewHolder, paramInt1);
        }
        ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).bindViewForGdtReport(this.d, paramChatMessage, paramOnLongClickAndTouchListener);
        return paramOnLongClickAndTouchListener;
      }
    }
    SubscribePlayerManager.a().b(localAutoVideoMsgViewHolder, paramInt1);
    paramOnLongClickAndTouchListener.setVisibility(8);
    return paramOnLongClickAndTouchListener;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (paramView == null)
    {
      paramBaseChatItemLayout = this.e.getResources();
      paramChatMessage = new RelativeLayout(this.e);
      paramChatMessage.setId(2131430578);
      paramChatMessage.setClickable(true);
      paramView = new RelativeLayout.LayoutParams(-1, -2);
      int i = paramBaseChatItemLayout.getDimensionPixelSize(2131299800);
      paramView.setMargins(i, 0, i, 0);
      paramView.addRule(1, 2131435219);
      paramView.addRule(1, 2131430605);
      paramChatMessage.setLayoutParams(paramView);
      Object localObject2 = new RelativeLayout(this.e);
      ((RelativeLayout)localObject2).setId(2131430612);
      paramChatMessage.addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -2));
      i = ViewUtils.dpToPx(2.0F);
      paramView = new RoundRectUrlImageView(this.e);
      paramView.setScaleType(ImageView.ScaleType.MATRIX);
      paramView.setId(2131430613);
      paramView.setAllRadius(i);
      Object localObject1 = new RelativeLayout.LayoutParams(AIOUtils.b(133.0F, paramBaseChatItemLayout), AIOUtils.b(74.5F, paramBaseChatItemLayout));
      ((RelativeLayout.LayoutParams)localObject1).setMargins(AIOUtils.b(9.0F, paramBaseChatItemLayout), 0, 0, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(this.e);
      ((TextView)localObject1).setTextColor(-16777216);
      ((TextView)localObject1).setTextSize(16.0F);
      ((TextView)localObject1).setText(HardCodeUtil.a(2131899101));
      ((TextView)localObject1).setId(2131430614);
      ((TextView)localObject1).setMinLines(1);
      ((TextView)localObject1).setMaxLines(3);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(0, paramView.getId());
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RoundRectRelativeLayout(this.e);
      localObject3 = new RelativeLayout.LayoutParams(-1, a);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131430612);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(0, AIOUtils.b(10.0F, paramBaseChatItemLayout), 0, 0);
      ((RoundRectRelativeLayout)localObject2).setBgColor(-16777216);
      ((RoundRectRelativeLayout)localObject2).setAllRadius(i);
      paramChatMessage.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new URLImageView(this.e);
      ((URLImageView)localObject3).setId(2131430625);
      ((URLImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject4 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject4).addRule(14);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.e);
      ((TextView)localObject4).setBackgroundResource(2130837949);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setTextSize(12.0F);
      ((TextView)localObject4).setText("13:25");
      ((TextView)localObject4).setGravity(17);
      Object localObject5 = new RelativeLayout.LayoutParams(AIOUtils.b(43.0F, paramBaseChatItemLayout), AIOUtils.b(21.0F, paramBaseChatItemLayout));
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout.LayoutParams)localObject5).addRule(11);
      i = AIOUtils.b(5.0F, paramBaseChatItemLayout);
      ((RelativeLayout.LayoutParams)localObject5).setMargins(0, 0, i, i);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.e);
      ((ImageView)localObject5).setBackgroundResource(2130837948);
      ((ImageView)localObject5).setImageResource(2130849597);
      i = AIOUtils.b(17.0F, paramBaseChatItemLayout);
      ((ImageView)localObject5).setPadding(i, i, i, i);
      ((ImageView)localObject5).setScaleType(ImageView.ScaleType.FIT_CENTER);
      i = AIOUtils.b(50.0F, paramBaseChatItemLayout);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(i, i);
      paramBaseChatItemLayout.addRule(13);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject5, paramBaseChatItemLayout);
      paramChatMessage.setTag(paramViewHolder);
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnClickListener(this.y);
      paramViewHolder = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)paramViewHolder;
      AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(paramViewHolder, paramChatMessage);
      paramViewHolder.a = ((RelativeLayout)localObject2);
      paramViewHolder.b = ((URLImageView)localObject3);
      paramViewHolder.c = ((ImageView)localObject5);
      paramViewHolder.d = ((TextView)localObject4);
      AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(paramViewHolder, paramView);
      AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(paramViewHolder, (TextView)localObject1);
      return paramChatMessage;
    }
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new AutoVideoItemBuilder.AutoVideoMsgViewHolder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    super.a(paramInt, paramContext, paramChatMessage);
    if (paramInt == 2131439015)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    if (paramInt == 2131431695) {
      ChatActivityFacade.b(this.e, this.d, paramChatMessage);
    }
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramChatMessage = paramContext.getResources();
    paramViewHolder.h.setBackgroundResource(2130837947);
    paramInt1 = AIOUtils.b(10.0F, paramChatMessage);
    paramInt2 = AIOUtils.b(14.0F, paramChatMessage);
    paramViewHolder.h.setPadding(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    super.a(paramView, this.e, 2131439015, null, null);
    super.a(paramView, this.e, 2131428089, null, null);
    a(paramView, this.e);
    return paramView.d();
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (MessageRecordInfo.b(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    } else {
      localStringBuilder.append("发来");
    }
    localStringBuilder.append("视频按钮");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AutoVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */