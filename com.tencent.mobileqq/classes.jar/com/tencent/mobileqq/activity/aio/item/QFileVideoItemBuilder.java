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
    if (FileUtils.fileExistsAndNotEmpty(str))
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
    } else {
      localRelativeLayout.setBackgroundDrawable(a());
    }
    Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
    ((TextView)localObject).setText(HardCodeUtil.a(2131715161));
    ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.b(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130850097, 0, 0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new RelativeLayout.LayoutParams(paramFileHolder.e, paramFileHolder.f);
    ((RelativeLayout)paramFileHolder.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
    localObject = FileUtils.getFileSize(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a());
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(), (String)localObject, paramFileHolder, localRelativeLayout, true);
    paramFileHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
  }
  
  private void a(QFileVideoItemBuilder.FileHolder paramFileHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    b(paramFileHolder);
    Object localObject = FileUtils.getFileSize(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a());
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(), (String)localObject, paramFileHolder, (RelativeLayout)paramFileHolder.jdField_a_of_type_AndroidViewView, false);
    paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    if (paramFileHolder.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramFileHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramFileHolder.jdField_a_of_type_AndroidViewView).removeView(paramFileHolder.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = a(paramFileHolder);
    paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130844387);
    paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    b(paramFileHolder, paramBaseChatItemLayout);
  }
  
  private void a(QFileVideoItemBuilder.FileHolder paramFileHolder, String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
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
    ((RelativeLayout)localObject1).setId(2131364487);
    ((RelativeLayout)localObject1).setBackgroundResource(2130839098);
    paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131372696);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131372696);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131372696);
      if (paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
      }
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    }
    paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    int i = QFileUtils.a(paramFileHolder.e, paramFileHolder.f);
    paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setId(2131364487);
    paramViewGroup.setTextSize(2, 12.0F);
    paramViewGroup.setTextColor(-1);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.b(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131364490);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = AIOUtils.b(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.rightMargin = AIOUtils.b(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.bottomMargin = AIOUtils.b(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131364487);
    }
    else
    {
      localLayoutParams.addRule(12);
    }
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject1 = QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, i, paramFileHolder.e, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
    if (i != 1)
    {
      if (i == 2)
      {
        ((TextView)localObject2).setLines(1);
        ((TextView)localObject2).setMaxLines(1);
        paramViewGroup.setGravity(5);
      }
    }
    else
    {
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      paramViewGroup.setGravity(3);
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
    paramViewGroup.setText(paramString2);
    if (paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null)
    {
      paramViewGroup = paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramString2);
      paramViewGroup.setContentDescription(((StringBuilder)localObject1).toString());
    }
    if (paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null)
    {
      paramFileHolder = paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(paramString1);
      paramViewGroup.append(" ");
      paramViewGroup.append(paramString2);
      paramFileHolder.setContentDescription(paramViewGroup.toString());
    }
  }
  
  private void b(QFileVideoItemBuilder.FileHolder paramFileHolder)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a();
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b();
    if (i <= 0) {
      i = 640;
    }
    if (j <= 0) {
      j = 480;
    }
    Object localObject = ShortVideoUtils.adjustSize(i, j);
    i = localObject[0];
    j = localObject[1];
    localObject = paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
    if (localObject == null)
    {
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
    {
      ((ViewGroup.LayoutParams)localObject).width = i;
      ((ViewGroup.LayoutParams)localObject).height = j;
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
    if (localObject == null)
    {
      localObject = new LinearLayout.LayoutParams(i, j);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
    {
      ((ViewGroup.LayoutParams)localObject).width = i;
      ((ViewGroup.LayoutParams)localObject).height = j;
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    paramFileHolder.e = i;
    paramFileHolder.f = j;
  }
  
  private void b(QFileVideoItemBuilder.FileHolder paramFileHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.c();
    if (i == 1)
    {
      if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b()))
      {
        b(paramFileHolder);
        a(paramFileHolder);
      }
    }
    else
    {
      StringBuilder localStringBuilder;
      if (i == 3)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.e();
        if (i < 100)
        {
          paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          paramBaseChatItemLayout = paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
          localStringBuilder.append(paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          paramBaseChatItemLayout.setAnimProgress(i, localStringBuilder.toString());
          return;
        }
        paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
        paramBaseChatItemLayout = paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
        localStringBuilder.append(paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramBaseChatItemLayout.setAnimProgress(i, localStringBuilder.toString());
        return;
      }
      if ((i != 2) && (i != 4))
      {
        paramBaseChatItemLayout = paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
        localStringBuilder.append(paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        if (paramBaseChatItemLayout.a(localStringBuilder.toString()))
        {
          paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
          paramBaseChatItemLayout = paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
          localStringBuilder.append(paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          paramBaseChatItemLayout.setAnimProgress(100, localStringBuilder.toString());
          return;
        }
        paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
        return;
      }
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      paramBaseChatItemLayout = HardCodeUtil.a(2131715144);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130850096);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
    }
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
    if ((paramViewHolder instanceof QFileVideoItemBuilder.FileHolder))
    {
      localObject1 = (QFileVideoItemBuilder.FileHolder)paramViewHolder;
      paramViewHolder = paramView;
      paramView = (View)localObject1;
    }
    else
    {
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
    Object localObject1 = paramViewHolder;
    if (paramViewHolder == null)
    {
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131372696);
      paramViewHolder.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewHolder.setRadius(15.0F);
      paramViewHolder.d(true);
      paramViewHolder.setSharpCornerCor(BubbleImageView.a);
      ((RelativeLayout)localObject1).addView(paramViewHolder);
      localObject2 = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
      ((MessageProgressView)localObject2).setId(2131364567);
      ((MessageProgressView)localObject2).setRadius(15.0F, true);
      ((MessageProgressView)localObject2).setShowCorner(true);
      ((MessageProgressView)localObject2).setSharpCornerCor(BubbleImageView.a);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      paramViewHolder.setOnClickListener(this);
      super.a(paramViewHolder, paramOnLongClickAndTouchListener);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramViewHolder;
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = ((MessageProgressView)localObject2);
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
    paramOnLongClickAndTouchListener = paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramViewHolder.frienduin);
    ((StringBuilder)localObject2).append(paramViewHolder.uniseq);
    paramOnLongClickAndTouchListener.a(((StringBuilder)localObject2).toString());
    paramView.jdField_a_of_type_AndroidViewView = ((View)localObject1);
    a(paramView, paramBaseChatItemLayout);
    return localObject1;
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
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692399);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692396);
  }
  
  protected List<Integer> b(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(3);
  }
  
  protected void c(View paramView)
  {
    if ((paramView.getId() != 2131372696) && (paramView.getId() != 2131364567)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(3, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QFileVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */