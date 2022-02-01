package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.filemanager.bubble.QFileBubbleModel;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper.AIOImgInfo;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;
import java.util.List;

public class QFileImageItemBuilder
  extends QFileItemBuilder
{
  private Drawable a;
  private float jdField_b_of_type_Float = 0.5625F;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  private int d = BaseChatItemLayout.f;
  
  public QFileImageItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = ((int)(BaseChatItemLayout.f * this.jdField_b_of_type_Float));
  }
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      float f = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new AIOFilePicMask(Color.argb(255, 242, 242, 242), 255, f * 14.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      localBitmap = null;
      if (!(URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable)) {
        break label59;
      }
      localBitmap = ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawableWithMargin(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap, paramInt1, paramInt2, -921103);
      return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      label59:
      if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      }
    }
  }
  
  private Drawable a(QFileImageItemBuilder.FileHolder paramFileHolder)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b();
    if (FileUtils.b((String)localObject))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a();
      int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b();
      if ((i == 0) || (j == 0)) {
        a(paramFileHolder, (String)localObject);
      }
      Drawable localDrawable1 = a(paramFileHolder.e, paramFileHolder.f);
      Drawable localDrawable2 = a(paramFileHolder.e, paramFileHolder.f);
      localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
      paramFileHolder = localDrawable1;
      if (localObject != null) {
        paramFileHolder = URLDrawableHelper.getDrawable((URL)localObject, 0, 0, localDrawable1, localDrawable2, true, 0.0F);
      }
      return paramFileHolder;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.f();
    if (i == 1)
    {
      a(paramFileHolder, i);
      return a();
    }
    if (i == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a();
      return a(paramFileHolder.e, paramFileHolder.f);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a();
    paramFileHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
    return a();
  }
  
  private void a(QFileImageItemBuilder.FileHolder paramFileHolder)
  {
    FrameLayout localFrameLayout = paramFileHolder.jdField_a_of_type_AndroidWidgetFrameLayout;
    localFrameLayout.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131369219);
      localTextView.setText(2131693293);
      localTextView.setCompoundDrawablePadding(AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130850170, 0, 0);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramFileHolder.e, paramFileHolder.f));
      return;
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(QFileImageItemBuilder.FileHolder paramFileHolder, int paramInt)
  {
    FrameLayout localFrameLayout;
    if (paramInt == 1)
    {
      localFrameLayout = paramFileHolder.jdField_a_of_type_AndroidWidgetFrameLayout;
      localFrameLayout.setVisibility(0);
      if (Build.VERSION.SDK_INT < 16) {
        break label158;
      }
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131369219);
      localTextView.setText(2131692464);
      localTextView.setTextSize(12.0F);
      localTextView.setTextColor(Color.parseColor("#B0B3BF"));
      localTextView.setCompoundDrawablePadding(AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844939);
      localDrawable.setBounds(0, 0, AIOUtils.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawables(null, localDrawable, null, null);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramFileHolder.e, paramFileHolder.f));
      return;
      label158:
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(QFileImageItemBuilder.FileHolder paramFileHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramFileHolder.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      paramFileHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    b(paramFileHolder);
    paramFileHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
    Object localObject = a(paramFileHolder);
    paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    localObject = FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a());
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(), (String)localObject, paramFileHolder);
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
    b(paramFileHolder, paramBaseChatItemLayout);
  }
  
  private void a(QFileImageItemBuilder.FileHolder paramFileHolder, String paramString)
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
  
  private void a(QFileImageItemBuilder.FileHolder paramFileHolder, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramFileHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
      {
        localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
        localPicProgressView.setRadius(this.jdField_a_of_type_Float * 15.0F, false);
        localPicProgressView.setSharpCornerCor(BubbleImageView.a);
        localPicProgressView.setShowCorner(false);
        localPicProgressView.setProgressBackgroudColor(2130706432);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(6, 2131373117);
        localLayoutParams.addRule(8, 2131373117);
        localLayoutParams.addRule(5, 2131373117);
        localLayoutParams.addRule(7, 2131373117);
        ((RelativeLayout)paramFileHolder.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
        localPicProgressView.setProgress(0);
        paramFileHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        paramFileHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramFileHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
      }
    }
    while (paramFileHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
      for (;;)
      {
        PicProgressView localPicProgressView;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramFileHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.e());
      }
    }
    paramFileHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    if (!paramFileHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramFileHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      ((RelativeLayout)paramFileHolder.jdField_a_of_type_AndroidViewView).removeView(paramFileHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      return;
    }
    paramFileHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
  }
  
  private void a(String paramString1, String paramString2, QFileImageItemBuilder.FileHolder paramFileHolder)
  {
    if (paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramFileHolder.jdField_a_of_type_AndroidViewView).removeView(paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131366943);
    localRelativeLayout.setBackgroundResource(2130839244);
    paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, AIOUtils.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131373117);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131373117);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131373117);
    ((RelativeLayout)paramFileHolder.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = QFileUtils.a(paramFileHolder.e, paramFileHolder.f);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131364600);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131364603);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.rightMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.bottomMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131364600);
      localRelativeLayout.addView((View)localObject2, localLayoutParams);
      paramString1 = QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, i, paramFileHolder.e, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
      switch (i)
      {
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText(paramString1);
      ((TextView)localObject1).setText(paramString2);
      return;
      localLayoutParams.addRule(12);
      break;
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject1).setGravity(3);
      continue;
      ((TextView)localObject2).setLines(1);
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject1).setGravity(5);
    }
  }
  
  private void b(QFileImageItemBuilder.FileHolder paramFileHolder)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b();
    localObject = FilePicURLDrawlableHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(), (String)localObject);
    int i = ((FilePicURLDrawlableHelper.AIOImgInfo)localObject).jdField_a_of_type_Int;
    int j = ((FilePicURLDrawlableHelper.AIOImgInfo)localObject).jdField_b_of_type_Int;
    if ((i > 0) && (j > 0))
    {
      paramFileHolder.e = i;
      paramFileHolder.f = j;
      localObject = paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label120;
      }
      localObject = new RelativeLayout.LayoutParams(paramFileHolder.e, paramFileHolder.f);
      paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label120:
    while ((((ViewGroup.LayoutParams)localObject).width == paramFileHolder.e) && (((ViewGroup.LayoutParams)localObject).height == paramFileHolder.f))
    {
      return;
      paramFileHolder.e = this.jdField_c_of_type_Int;
      paramFileHolder.f = this.d;
      break;
    }
    ((ViewGroup.LayoutParams)localObject).width = paramFileHolder.e;
    ((ViewGroup.LayoutParams)localObject).height = paramFileHolder.f;
    paramFileHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(QFileImageItemBuilder.FileHolder paramFileHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.c();
    if (i == 1)
    {
      if (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b()))
      {
        b(paramFileHolder);
        a(paramFileHolder);
        paramFileHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
        if (paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
          ((RelativeLayout)paramFileHolder.jdField_a_of_type_AndroidViewView).removeView(paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
      }
      return;
    }
    if (i == 3)
    {
      a(paramFileHolder, true);
      paramFileHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if ((i == 2) || (i == 4))
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      a(paramFileHolder, false);
      return;
    }
    a(paramFileHolder, false);
  }
  
  protected View a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject1;
    if ((paramViewHolder instanceof QFileImageItemBuilder.FileHolder))
    {
      localObject1 = (QFileImageItemBuilder.FileHolder)paramViewHolder;
      paramViewHolder = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = paramViewHolder;
      if (paramViewHolder == null)
      {
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        int i = Build.VERSION.SDK_INT;
        if ((i == 19) || (i == 18)) {
          paramViewHolder.e = true;
        }
        paramViewHolder.setId(2131373117);
        paramViewHolder.setAdjustViewBounds(true);
        paramViewHolder.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramViewHolder.setRadius(15.0F);
        paramViewHolder.d(false);
        paramViewHolder.setShowEdge(true);
        ((RelativeLayout)localObject1).addView(paramViewHolder, new RelativeLayout.LayoutParams(-2, -2));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramViewHolder;
        paramViewHolder = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
        Object localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setId(2131369219);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setTextColor(Color.rgb(178, 182, 195));
        Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramViewHolder.setVisibility(8);
        ((RelativeLayout)localObject1).addView(paramViewHolder, new RelativeLayout.LayoutParams(-1, -1));
        paramView.jdField_a_of_type_AndroidWidgetFrameLayout = paramViewHolder;
        paramViewHolder = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder.setOrientation(1);
        paramViewHolder.setGravity(1);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        ((RelativeLayout)localObject1).addView(paramViewHolder, (ViewGroup.LayoutParams)localObject2);
        paramView.jdField_c_of_type_AndroidViewView = paramViewHolder;
        localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject2).setImageResource(2130839545);
        paramViewHolder.addView((View)localObject2, new LinearLayout.LayoutParams(AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setText(2131692466);
        ((TextView)localObject2).setTextSize(12.0F);
        ((TextView)localObject2).setTextColor(Color.parseColor("#B0B3BF"));
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setOnClickListener(this);
        super.a((View)localObject1, paramOnLongClickAndTouchListener);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      a(paramView, paramBaseChatItemLayout);
      return localObject1;
      paramView = new QFileImageItemBuilder.FileHolder(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramViewHolder.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramViewHolder.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramViewHolder.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramViewHolder.jdField_b_of_type_Int;
      paramView.jdField_c_of_type_Int = paramViewHolder.jdField_c_of_type_Int;
      paramView.d = paramViewHolder.d;
      paramView.jdField_a_of_type_JavaLangString = paramViewHolder.jdField_a_of_type_JavaLangString;
      paramViewHolder = null;
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (QFileImageItemBuilder.FileHolder.class.isInstance(paramView))) {
        return ((QFileImageItemBuilder.FileHolder)paramView).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  protected List<Integer> a(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(2);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(paramInt);
  }
  
  protected BaseBubbleBuilder.ViewHolder b()
  {
    return new QFileImageItemBuilder.FileHolder(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692461);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692458);
  }
  
  protected List<Integer> b(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(2);
  }
  
  protected void c(View paramView)
  {
    if (paramView.getId() == 2131364634)
    {
      paramView = AIOUtils.a(paramView);
      if (paramView == null) {
        QLog.w("QFileImageItemBuilder", 1, "holder tag is null");
      }
    }
    else
    {
      return;
    }
    if (!QFileImageItemBuilder.FileHolder.class.isInstance(paramView))
    {
      QLog.w("QFileImageItemBuilder", 1, "holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (QFileImageItemBuilder.FileHolder)paramView;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(2, paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QFileImageItemBuilder
 * JD-Core Version:    0.7.0.1
 */