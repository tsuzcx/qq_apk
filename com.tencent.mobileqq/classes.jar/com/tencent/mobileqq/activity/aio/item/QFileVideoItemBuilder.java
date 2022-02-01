package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.filemanager.bubble.QFileBubbleModel;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.BubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.io.File;
import java.util.List;

public class QFileVideoItemBuilder
  extends QFileItemBuilder
{
  private Drawable a;
  
  public QFileVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(QFileVideoItemBuilder.FileHolder paramFileHolder)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b();
    if (FileUtils.b(str))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a();
      int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b();
      if ((i == 0) || (j == 0)) {
        a(paramFileHolder, str);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramFileHolder.e;
      localURLDrawableOptions.mRequestHeight = paramFileHolder.f;
      localURLDrawableOptions.mLoadingDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramFileHolder.e, paramFileHolder.f);
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.getFailedDrawable();
      localURLDrawableOptions.mGifRoundCorner = 12.0F;
      localURLDrawableOptions.mPlayGifImage = false;
      paramFileHolder = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
      paramFileHolder.setAutoDownload(true);
      return paramFileHolder;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a();
    return a();
  }
  
  private void a(QFileVideoItemBuilder.FileHolder paramFileHolder)
  {
    if (paramFileHolder.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    if (Build.VERSION.SDK_INT >= 16) {
      localRelativeLayout.setBackground(a());
    }
    for (;;)
    {
      Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(HardCodeUtil.a(2131715238));
      ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130850170, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramFileHolder.e, paramFileHolder.f);
      ((RelativeLayout)paramFileHolder.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a());
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(), (String)localObject, paramFileHolder, localRelativeLayout, true);
      paramFileHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(QFileVideoItemBuilder.FileHolder paramFileHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    b(paramFileHolder);
    Object localObject = FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a());
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(), (String)localObject, paramFileHolder, (RelativeLayout)paramFileHolder.jdField_a_of_type_AndroidViewView, false);
    paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    if (paramFileHolder.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramFileHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramFileHolder.jdField_a_of_type_AndroidViewView).removeView(paramFileHolder.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = a(paramFileHolder);
    paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130844481);
    paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    b(paramFileHolder, paramBaseChatItemLayout);
  }
  
  private void a(QFileVideoItemBuilder.FileHolder paramFileHolder, String paramString)
  {
    if (!FileUtils.b(paramString)) {
      return;
    }
    paramString = FileManagerUtil.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramFileHolder.e = i;
      paramFileHolder.f = j;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(i, j);
    }
    b(paramFileHolder);
  }
  
  private void a(String paramString1, String paramString2, QFileVideoItemBuilder.FileHolder paramFileHolder, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramFileHolder.jdField_a_of_type_AndroidViewView).removeView(paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131364600);
    ((RelativeLayout)localObject1).setBackgroundResource(2130839244);
    paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, AIOUtils.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131373117);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131373117);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131373117);
      if (paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = QFileUtils.a(paramFileHolder.e, paramFileHolder.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131364600);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject2).setId(2131364603);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setSingleLine();
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label599;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131364600);
        label417:
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject1 = QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, i, paramFileHolder.e, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.setText(paramString2);
      if (paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) {
        paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramString1 + " " + paramString2);
      }
      if (paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramString1 + " " + paramString2);
      }
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
      break;
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      break;
      label599:
      localLayoutParams.addRule(12);
      break label417;
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      paramViewGroup.setGravity(3);
      continue;
      ((TextView)localObject2).setLines(1);
      ((TextView)localObject2).setMaxLines(1);
      paramViewGroup.setGravity(5);
    }
  }
  
  private void b(QFileVideoItemBuilder.FileHolder paramFileHolder)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a();
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b();
    label24:
    Object localObject;
    if (i > 0)
    {
      if (j <= 0) {
        break label127;
      }
      localObject = ShortVideoUtils.adjustSize(i, j);
      i = localObject[0];
      j = localObject[1];
      localObject = paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label134;
      }
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      label75:
      localObject = paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (localObject != null) {
        break label176;
      }
      localObject = new LinearLayout.LayoutParams(i, j);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramFileHolder.e = i;
      paramFileHolder.f = j;
      return;
      i = 640;
      break;
      label127:
      j = 480;
      break label24;
      label134:
      if ((((ViewGroup.LayoutParams)localObject).width == i) && (((ViewGroup.LayoutParams)localObject).height == j)) {
        break label75;
      }
      ((ViewGroup.LayoutParams)localObject).width = i;
      ((ViewGroup.LayoutParams)localObject).height = j;
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label75;
      label176:
      if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
      {
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = j;
        paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void b(QFileVideoItemBuilder.FileHolder paramFileHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.c();
    if (i == 1)
    {
      if (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b()))
      {
        b(paramFileHolder);
        a(paramFileHolder);
      }
      return;
    }
    if (i == 3)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.e();
      if (i < 100)
      {
        paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    if ((i == 2) || (i == 4))
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      paramBaseChatItemLayout = HardCodeUtil.a(2131715221);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130850169);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      return;
    }
    if (paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
  }
  
  public Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      float f = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new AIOFilePicMask(Color.argb(255, 242, 242, 242), 255, 0.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  protected View a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject;
    if ((paramViewHolder instanceof QFileVideoItemBuilder.FileHolder))
    {
      localObject = (QFileVideoItemBuilder.FileHolder)paramViewHolder;
      paramViewHolder = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = paramViewHolder;
      if (paramViewHolder == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder.setId(2131373117);
        paramViewHolder.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramViewHolder.setRadius(15.0F);
        paramViewHolder.d(true);
        paramViewHolder.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramViewHolder);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131364680);
        localMessageProgressView.setRadius(15.0F, true);
        localMessageProgressView.setShowCorner(true);
        localMessageProgressView.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramViewHolder.setOnClickListener(this);
        super.a(paramViewHolder, paramOnLongClickAndTouchListener);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramViewHolder;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a();
      boolean bool = paramViewHolder.isSend();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSend(bool);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, paramOnLongClickAndTouchListener);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramViewHolder.frienduin + paramViewHolder.uniseq);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramView, paramBaseChatItemLayout);
      return localObject;
      paramView = new QFileVideoItemBuilder.FileHolder(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramViewHolder.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramViewHolder.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramViewHolder.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramViewHolder.jdField_b_of_type_Int;
      paramView.c = paramViewHolder.c;
      paramView.d = paramViewHolder.d;
      paramView.jdField_a_of_type_JavaLangString = paramViewHolder.jdField_a_of_type_JavaLangString;
      paramViewHolder = null;
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (paramView != null)
    {
      paramView = AIOUtils.a(paramView);
      if ((paramView != null) && (QFileVideoItemBuilder.FileHolder.class.isInstance(paramView)))
      {
        paramView = (QFileVideoItemBuilder.FileHolder)paramView;
        if (paramView != null) {
          return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
        }
      }
    }
    return null;
  }
  
  protected List<Integer> a(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(3);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(paramInt);
  }
  
  protected BaseBubbleBuilder.ViewHolder b()
  {
    return new QFileVideoItemBuilder.FileHolder(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692462);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692459);
  }
  
  protected List<Integer> b(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(3);
  }
  
  protected void c(View paramView)
  {
    if ((paramView.getId() != 2131373117) && (paramView.getId() != 2131364680)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(3, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QFileVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */