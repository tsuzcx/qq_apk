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
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler;
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
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.ImageItem;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.VideoItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class AutoVideoItemBuilder
  extends BaseBubbleBuilder
{
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static final Drawable b;
  private static final int c = ViewUtils.b(180.0F);
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AutoVideoItemBuilder.1(this);
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-1);
    b = new ColorDrawable(-1);
    b.setBounds(0, 0, ViewUtils.a(), c);
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
    }
    while (paramString.equals((String)paramURLImageView.getTag())) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mFailedDrawable = paramDrawable;
    localURLDrawableOptions.mGifRoundCorner = ViewUtils.b(2.0F);
    localURLDrawableOptions.mUseSharpPImage = true;
    localURLDrawableOptions.mExtraInfo = paramString;
    localURLDrawableOptions.mPlayGifImage = true;
    paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    paramURLImageView.setTag(paramString);
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    paramQQCustomMenu.a(2131365636, paramContext.getString(2131690860), 2130839054);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)paramOnLongClickAndTouchListener.getTag();
    localAutoVideoMsgViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setHeadIconVisible(false);
    if ((localAutoVideoMsgViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a != null) && (localAutoVideoMsgViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.getVisibility() == 0)) {}
    for (paramInt2 = ViewUtils.b(33.0F);; paramInt2 = 0)
    {
      paramView = (ViewGroup.MarginLayoutParams)AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).getLayoutParams();
      if (paramView.leftMargin != paramInt2)
      {
        paramView.leftMargin = paramInt2;
        AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).setLayoutParams(paramView);
      }
      StructMsgSubImageVideo.VideoItem localVideoItem;
      try
      {
        paramView = (StructMsgSubImageVideo)((MessageForStructing)paramChatMessage).structingMsg;
        if (paramView != null)
        {
          localVideoItem = paramView.getVideoItem();
          if (localVideoItem == null)
          {
            paramViewGroup = paramView.getImageItem();
            paramView = paramViewGroup;
            if (paramViewGroup != null) {
              break label188;
            }
          }
        }
        else
        {
          SubscribePlayerManager.a().b(localAutoVideoMsgViewHolder, paramInt1);
          paramOnLongClickAndTouchListener.setVisibility(8);
          return paramOnLongClickAndTouchListener;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          Log.w("AutoVideoItemBuilder", "getView: ", paramView);
          paramView = null;
        }
        paramView = null;
        label188:
        paramOnLongClickAndTouchListener.setVisibility(0);
        if (localVideoItem == null) {
          break label364;
        }
      }
      localAutoVideoMsgViewHolder.e = localVideoItem.width;
      localAutoVideoMsgViewHolder.f = localVideoItem.height;
      localAutoVideoMsgViewHolder.b = localVideoItem.videoUrl;
      if (localAutoVideoMsgViewHolder.f != 0) {}
      for (paramInt2 = c * localAutoVideoMsgViewHolder.e / localAutoVideoMsgViewHolder.f;; paramInt2 = 0)
      {
        paramView = (RelativeLayout.LayoutParams)localAutoVideoMsgViewHolder.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        paramView.width = paramInt2;
        localAutoVideoMsgViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramView);
        AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).setVisibility(8);
        localAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).setText(localVideoItem.title);
        AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder, localVideoItem.schema);
        a(localAutoVideoMsgViewHolder.jdField_a_of_type_ComTencentImageURLImageView, localVideoItem.coverUrl, b);
        SubscribePlayerManager.a().a(localAutoVideoMsgViewHolder, paramInt1);
        EcshopAdHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramOnLongClickAndTouchListener);
        return paramOnLongClickAndTouchListener;
        label364:
        localAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).setText(paramView.title);
        AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder, paramView.schema);
        if (TextUtils.isEmpty(paramView.imageUrl)) {
          AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).setVisibility(8);
        }
        for (;;)
        {
          SubscribePlayerManager.a().b(localAutoVideoMsgViewHolder, paramInt1);
          break;
          AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).setVisibility(0);
          a(AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder), paramView.imageUrl, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
    }
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramBaseChatItemLayout = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131364634);
      paramChatMessage.setClickable(true);
      paramView = new RelativeLayout.LayoutParams(-1, -2);
      int i = paramBaseChatItemLayout.getDimensionPixelSize(2131299067);
      paramView.setMargins(i, 0, i, 0);
      paramView.addRule(1, 2131368603);
      paramView.addRule(1, 2131364660);
      paramChatMessage.setLayoutParams(paramView);
      Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject2).setId(2131364666);
      paramChatMessage.addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -2));
      i = ViewUtils.b(2.0F);
      paramView = new RoundRectUrlImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setScaleType(ImageView.ScaleType.MATRIX);
      paramView.setId(2131364667);
      paramView.setAllRadius(i);
      Object localObject1 = new RelativeLayout.LayoutParams(AIOUtils.a(133.0F, paramBaseChatItemLayout), AIOUtils.a(74.5F, paramBaseChatItemLayout));
      ((RelativeLayout.LayoutParams)localObject1).setMargins(AIOUtils.a(9.0F, paramBaseChatItemLayout), 0, 0, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setTextColor(-16777216);
      ((TextView)localObject1).setTextSize(16.0F);
      ((TextView)localObject1).setText(HardCodeUtil.a(2131700938));
      ((TextView)localObject1).setId(2131364668);
      ((TextView)localObject1).setMinLines(1);
      ((TextView)localObject1).setMaxLines(3);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(0, paramView.getId());
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RoundRectRelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-1, c);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131364666);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(0, AIOUtils.a(10.0F, paramBaseChatItemLayout), 0, 0);
      ((RoundRectRelativeLayout)localObject2).setBgColor(-16777216);
      ((RoundRectRelativeLayout)localObject2).setAllRadius(i);
      paramChatMessage.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      ((URLImageView)localObject3).setId(2131364679);
      ((URLImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject4 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject4).addRule(14);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setBackgroundResource(2130838078);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setTextSize(12.0F);
      ((TextView)localObject4).setText("13:25");
      ((TextView)localObject4).setGravity(17);
      Object localObject5 = new RelativeLayout.LayoutParams(AIOUtils.a(43.0F, paramBaseChatItemLayout), AIOUtils.a(21.0F, paramBaseChatItemLayout));
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout.LayoutParams)localObject5).addRule(11);
      i = AIOUtils.a(5.0F, paramBaseChatItemLayout);
      ((RelativeLayout.LayoutParams)localObject5).setMargins(0, 0, i, i);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject5).setBackgroundResource(2130838077);
      ((ImageView)localObject5).setImageResource(2130848066);
      i = AIOUtils.a(17.0F, paramBaseChatItemLayout);
      ((ImageView)localObject5).setPadding(i, i, i, i);
      ((ImageView)localObject5).setScaleType(ImageView.ScaleType.FIT_CENTER);
      i = AIOUtils.a(50.0F, paramBaseChatItemLayout);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(i, i);
      paramBaseChatItemLayout.addRule(13);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject5, paramBaseChatItemLayout);
      paramChatMessage.setTag(paramViewHolder);
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewHolder = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)paramViewHolder;
      AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(paramViewHolder, paramChatMessage);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
      paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject3);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(paramViewHolder, paramView);
      AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(paramViewHolder, (TextView)localObject1);
    }
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new AutoVideoItemBuilder.AutoVideoMsgViewHolder();
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    }
    for (;;)
    {
      localStringBuilder.append("视频按钮");
      return localStringBuilder.toString();
      localStringBuilder.append("发来");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    super.a(paramInt, paramContext, paramChatMessage);
    if (paramInt == 2131371997) {
      super.a(paramInt, paramContext, paramChatMessage);
    }
    while (paramInt != 2131365636) {
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramChatMessage = paramContext.getResources();
    paramViewHolder.a.setBackgroundResource(2130838076);
    paramInt1 = AIOUtils.a(10.0F, paramChatMessage);
    paramInt2 = AIOUtils.a(14.0F, paramChatMessage);
    paramViewHolder.a.setPadding(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    a(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AutoVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */