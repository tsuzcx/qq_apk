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
  private static final int jdField_a_of_type_Int = ViewUtils.b(180.0F);
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-1);
  private static final Drawable b = new ColorDrawable(-1);
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AutoVideoItemBuilder.1(this);
  
  static
  {
    b.setBounds(0, 0, ViewUtils.a(), jdField_a_of_type_Int);
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
    localURLDrawableOptions.mGifRoundCorner = ViewUtils.b(2.0F);
    localURLDrawableOptions.mUseSharpPImage = true;
    localURLDrawableOptions.mExtraInfo = paramString;
    localURLDrawableOptions.mPlayGifImage = true;
    paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    paramURLImageView.setTag(paramString);
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    paramQQCustomMenu.a(2131365480, paramContext.getString(2131690788), 2130838907);
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
    if ((localAutoVideoMsgViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a != null) && (localAutoVideoMsgViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.getVisibility() == 0)) {
      paramInt2 = ViewUtils.b(33.0F);
    } else {
      paramInt2 = 0;
    }
    paramView = (ViewGroup.MarginLayoutParams)AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).getLayoutParams();
    if (paramView.leftMargin != paramInt2)
    {
      paramView.leftMargin = paramInt2;
      AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).setLayoutParams(paramView);
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
          localAutoVideoMsgViewHolder.e = localVideoItem.width;
          localAutoVideoMsgViewHolder.f = localVideoItem.height;
          localAutoVideoMsgViewHolder.b = localVideoItem.videoUrl;
          if (localAutoVideoMsgViewHolder.f != 0) {
            paramInt2 = jdField_a_of_type_Int * localAutoVideoMsgViewHolder.e / localAutoVideoMsgViewHolder.f;
          } else {
            paramInt2 = 0;
          }
          paramView = (RelativeLayout.LayoutParams)localAutoVideoMsgViewHolder.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
          paramView.width = paramInt2;
          localAutoVideoMsgViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramView);
          AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).setVisibility(8);
          localAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).setText(localVideoItem.title);
          AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder, localVideoItem.schema);
          a(localAutoVideoMsgViewHolder.jdField_a_of_type_ComTencentImageURLImageView, localVideoItem.coverUrl, b);
          SubscribePlayerManager.a().a(localAutoVideoMsgViewHolder, paramInt1);
        }
        else
        {
          localAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).setText(paramViewGroup.title);
          AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder, paramViewGroup.schema);
          if (TextUtils.isEmpty(paramViewGroup.imageUrl))
          {
            AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).setVisibility(8);
          }
          else
          {
            AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder).setVisibility(0);
            a(AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder), paramViewGroup.imageUrl, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          }
          SubscribePlayerManager.a().b(localAutoVideoMsgViewHolder, paramInt1);
        }
        ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).bindViewForGdtReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramOnLongClickAndTouchListener);
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
      paramBaseChatItemLayout = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131364521);
      paramChatMessage.setClickable(true);
      paramView = new RelativeLayout.LayoutParams(-1, -2);
      int i = paramBaseChatItemLayout.getDimensionPixelSize(2131299072);
      paramView.setMargins(i, 0, i, 0);
      paramView.addRule(1, 2131368343);
      paramView.addRule(1, 2131364547);
      paramChatMessage.setLayoutParams(paramView);
      Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject2).setId(2131364553);
      paramChatMessage.addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -2));
      i = ViewUtils.b(2.0F);
      paramView = new RoundRectUrlImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setScaleType(ImageView.ScaleType.MATRIX);
      paramView.setId(2131364554);
      paramView.setAllRadius(i);
      Object localObject1 = new RelativeLayout.LayoutParams(AIOUtils.b(133.0F, paramBaseChatItemLayout), AIOUtils.b(74.5F, paramBaseChatItemLayout));
      ((RelativeLayout.LayoutParams)localObject1).setMargins(AIOUtils.b(9.0F, paramBaseChatItemLayout), 0, 0, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setTextColor(-16777216);
      ((TextView)localObject1).setTextSize(16.0F);
      ((TextView)localObject1).setText(HardCodeUtil.a(2131701081));
      ((TextView)localObject1).setId(2131364555);
      ((TextView)localObject1).setMinLines(1);
      ((TextView)localObject1).setMaxLines(3);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(0, paramView.getId());
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RoundRectRelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-1, jdField_a_of_type_Int);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131364553);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(0, AIOUtils.b(10.0F, paramBaseChatItemLayout), 0, 0);
      ((RoundRectRelativeLayout)localObject2).setBgColor(-16777216);
      ((RoundRectRelativeLayout)localObject2).setAllRadius(i);
      paramChatMessage.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      ((URLImageView)localObject3).setId(2131364566);
      ((URLImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject4 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject4).addRule(14);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setBackgroundResource(2130837925);
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
      localObject5 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject5).setBackgroundResource(2130837924);
      ((ImageView)localObject5).setImageResource(2130847937);
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
      paramChatMessage.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewHolder = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)paramViewHolder;
      AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(paramViewHolder, paramChatMessage);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
      paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject3);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
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
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    } else {
      localStringBuilder.append("发来");
    }
    localStringBuilder.append("视频按钮");
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    super.a(paramInt, paramContext, paramChatMessage);
    if (paramInt == 2131371603)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    if (paramInt == 2131365480) {
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramChatMessage = paramContext.getResources();
    paramViewHolder.a.setBackgroundResource(2130837923);
    paramInt1 = AIOUtils.b(10.0F, paramChatMessage);
    paramInt2 = AIOUtils.b(14.0F, paramChatMessage);
    paramViewHolder.a.setPadding(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    a(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AutoVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */