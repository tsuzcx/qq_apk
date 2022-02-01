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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.BubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.io.File;
import java.util.List;

public class QFileVideoItemBuilder
  extends QFileItemBuilder
{
  private Drawable y;
  
  public QFileVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(QFileVideoItemBuilder.FileHolder paramFileHolder)
  {
    if (paramFileHolder.h == null) {
      return;
    }
    paramFileHolder.a.setVisibility(4);
    paramFileHolder.b.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.e);
    if (Build.VERSION.SDK_INT >= 16) {
      localRelativeLayout.setBackground(i());
    } else {
      localRelativeLayout.setBackgroundDrawable(i());
    }
    Object localObject = new TextView(this.e);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
    ((TextView)localObject).setText(HardCodeUtil.a(2131912649));
    ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.b(7.0F, this.e.getResources()));
    ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130851866, 0, 0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new RelativeLayout.LayoutParams(paramFileHolder.d, paramFileHolder.e);
    ((RelativeLayout)paramFileHolder.h).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
    localObject = FileUtils.getFileSize(this.a.g());
    a(this.a.f(), (String)localObject, paramFileHolder, localRelativeLayout, true);
    paramFileHolder.f = localRelativeLayout;
  }
  
  private void a(QFileVideoItemBuilder.FileHolder paramFileHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    c(paramFileHolder);
    Object localObject = FileUtils.getFileSize(this.a.g());
    a(this.a.f(), (String)localObject, paramFileHolder, (RelativeLayout)paramFileHolder.h, false);
    paramFileHolder.b.setVisibility(0);
    if (paramFileHolder.f != null)
    {
      paramFileHolder.f.removeAllViews();
      ((RelativeLayout)paramFileHolder.h).removeView(paramFileHolder.f);
    }
    localObject = b(paramFileHolder);
    paramFileHolder.a.setImageResource(2130845704);
    paramFileHolder.a.setImageDrawable((Drawable)localObject);
    b(paramFileHolder, paramBaseChatItemLayout);
  }
  
  private void a(QFileVideoItemBuilder.FileHolder paramFileHolder, String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return;
    }
    paramString = FileManagerUtil.w(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramFileHolder.d = i;
      paramFileHolder.e = j;
      this.a.a(i, j);
    }
    c(paramFileHolder);
  }
  
  private void a(String paramString1, String paramString2, QFileVideoItemBuilder.FileHolder paramFileHolder, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramFileHolder.c != null)
    {
      paramFileHolder.c.removeAllViews();
      ((RelativeLayout)paramFileHolder.h).removeView(paramFileHolder.c);
    }
    boolean bool = QQTheme.isNowSimpleUI();
    Object localObject1 = new RelativeLayout(this.e);
    ((RelativeLayout)localObject1).setId(2131430544);
    ((RelativeLayout)localObject1).setBackgroundResource(SimpleModeHelper.c());
    paramFileHolder.c = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(55.0F, this.e.getResources()));
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131440242);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131440242);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131440242);
      float f;
      if (bool) {
        f = 0.0F;
      } else {
        f = 6.0F;
      }
      i = AIOUtils.b(f, this.e.getResources());
      if (paramFileHolder.a.v)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = i;
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = i;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
      }
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    }
    paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    int i = QFileUtils.a(paramFileHolder.d, paramFileHolder.e);
    paramViewGroup = new TextView(this.e);
    paramViewGroup.setId(2131430544);
    paramViewGroup.setTextSize(2, 12.0F);
    paramViewGroup.setTextColor(-1);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(7.0F, this.e.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(7.0F, this.e.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.b(7.0F, this.e.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.e, null);
    ((TextView)localObject2).setId(2131430547);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = AIOUtils.b(7.0F, this.e.getResources());
    localLayoutParams.rightMargin = AIOUtils.b(7.0F, this.e.getResources());
    localLayoutParams.bottomMargin = AIOUtils.b(7.0F, this.e.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131430544);
    }
    else
    {
      localLayoutParams.addRule(12);
    }
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject1 = QFileUtils.a(this.e, i, paramFileHolder.d, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
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
    if (paramFileHolder.b != null)
    {
      paramViewGroup = paramFileHolder.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramString2);
      paramViewGroup.setContentDescription(((StringBuilder)localObject1).toString());
    }
    if (paramFileHolder.a != null)
    {
      paramFileHolder = paramFileHolder.a;
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(paramString1);
      paramViewGroup.append(" ");
      paramViewGroup.append(paramString2);
      paramFileHolder.setContentDescription(paramViewGroup.toString());
    }
  }
  
  private Drawable b(QFileVideoItemBuilder.FileHolder paramFileHolder)
  {
    String str = this.a.h();
    if (FileUtils.fileExistsAndNotEmpty(str))
    {
      int i = this.a.d();
      int j = this.a.e();
      if ((i == 0) || (j == 0)) {
        a(paramFileHolder, str);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramFileHolder.d;
      localURLDrawableOptions.mRequestHeight = paramFileHolder.e;
      localURLDrawableOptions.mLoadingDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramFileHolder.d, paramFileHolder.e);
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.getFailedDrawable();
      localURLDrawableOptions.mGifRoundCorner = URLDrawableHelper.getRoundCorner();
      localURLDrawableOptions.mPlayGifImage = false;
      paramFileHolder = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
      paramFileHolder.setAutoDownload(true);
      return paramFileHolder;
    }
    this.a.l();
    return i();
  }
  
  private void b(QFileVideoItemBuilder.FileHolder paramFileHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.a.i();
    if (i == 1)
    {
      if (!FileUtils.fileExistsAndNotEmpty(this.a.h()))
      {
        c(paramFileHolder);
        a(paramFileHolder);
      }
    }
    else
    {
      StringBuilder localStringBuilder;
      if (i == 3)
      {
        i = this.a.k();
        if (i < 100)
        {
          paramFileHolder.b.setDrawStatus(1);
          paramBaseChatItemLayout = paramFileHolder.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramFileHolder.q.frienduin);
          localStringBuilder.append(paramFileHolder.q.uniseq);
          paramBaseChatItemLayout.setAnimProgress(i, localStringBuilder.toString());
          return;
        }
        paramFileHolder.b.setDrawStatus(2);
        paramBaseChatItemLayout = paramFileHolder.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFileHolder.q.frienduin);
        localStringBuilder.append(paramFileHolder.q.uniseq);
        paramBaseChatItemLayout.setAnimProgress(i, localStringBuilder.toString());
        return;
      }
      if ((i != 2) && (i != 4))
      {
        paramBaseChatItemLayout = paramFileHolder.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFileHolder.q.frienduin);
        localStringBuilder.append(paramFileHolder.q.uniseq);
        if (paramBaseChatItemLayout.c(localStringBuilder.toString()))
        {
          paramFileHolder.b.setDrawFinishDefault(true);
          paramBaseChatItemLayout = paramFileHolder.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramFileHolder.q.frienduin);
          localStringBuilder.append(paramFileHolder.q.uniseq);
          paramBaseChatItemLayout.setAnimProgress(100, localStringBuilder.toString());
          return;
        }
        paramFileHolder.b.setDrawStatus(2);
        return;
      }
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      paramBaseChatItemLayout = HardCodeUtil.a(2131912632);
      paramFileHolder.b.setImageResource(2130851865);
      paramFileHolder.b.setContentDescription(paramBaseChatItemLayout);
      paramFileHolder.b.setDrawStatus(3);
      paramFileHolder.b.setDrawFinishDefault(true);
    }
  }
  
  private void c(QFileVideoItemBuilder.FileHolder paramFileHolder)
  {
    int i = this.a.d();
    int j = this.a.e();
    if (i <= 0) {
      i = 640;
    }
    if (j <= 0) {
      j = 480;
    }
    Object localObject = ShortVideoUtils.adjustSize(i, j);
    i = localObject[0];
    j = localObject[1];
    localObject = paramFileHolder.a.getLayoutParams();
    if (localObject == null)
    {
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramFileHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
    {
      ((ViewGroup.LayoutParams)localObject).width = i;
      ((ViewGroup.LayoutParams)localObject).height = j;
      paramFileHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = paramFileHolder.b.getLayoutParams();
    if (localObject == null)
    {
      localObject = new LinearLayout.LayoutParams(i, j);
      paramFileHolder.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
    {
      ((ViewGroup.LayoutParams)localObject).width = i;
      ((ViewGroup.LayoutParams)localObject).height = j;
      paramFileHolder.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    paramFileHolder.d = i;
    paramFileHolder.e = j;
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
      paramView.r = paramViewHolder.r;
      paramView.q = paramViewHolder.q;
      paramView.h = paramViewHolder.h;
      paramView.i = paramViewHolder.i;
      paramView.j = paramViewHolder.j;
      paramView.k = paramViewHolder.k;
      paramView.l = paramViewHolder.l;
      paramView.m = paramViewHolder.m;
      paramView.n = paramViewHolder.n;
      paramView.o = paramViewHolder.o;
      paramViewHolder = null;
    }
    Object localObject1 = paramViewHolder;
    if (paramViewHolder == null)
    {
      localObject1 = new RelativeLayout(this.e);
      bool = QQTheme.isNowSimpleUI();
      paramViewHolder = new BubbleVideoView(this.e);
      paramViewHolder.setId(2131440242);
      paramViewHolder.setScaleType(ImageView.ScaleType.CENTER_CROP);
      float f2 = 8.0F;
      float f1;
      if (bool) {
        f1 = 8.0F;
      } else {
        f1 = 15.0F;
      }
      paramViewHolder.setRadius(f1);
      paramViewHolder.c(bool ^ true);
      paramViewHolder.setSharpCornerCor(BubbleImageView.d);
      ((RelativeLayout)localObject1).addView(paramViewHolder);
      localObject2 = new MessageProgressView(this.e);
      ((MessageProgressView)localObject2).setId(2131430626);
      if (bool) {
        f1 = f2;
      } else {
        f1 = 15.0F;
      }
      ((MessageProgressView)localObject2).setRadius(f1, true);
      ((MessageProgressView)localObject2).setShowCorner(bool ^ true);
      ((MessageProgressView)localObject2).setSharpCornerCor(BubbleImageView.d);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      paramViewHolder.setOnClickListener(this);
      super.a(paramViewHolder, paramOnLongClickAndTouchListener);
      paramView.a = paramViewHolder;
      paramView.b = ((MessageProgressView)localObject2);
    }
    paramViewHolder = this.a.v();
    boolean bool = paramViewHolder.isSend();
    paramView.b.setCornerDirection(bool);
    if (paramView.a.v != bool)
    {
      paramView.a.setSend(bool);
      paramView.a.invalidate();
    }
    paramView.b.setOnClickListener(this);
    super.a(paramView.b, paramOnLongClickAndTouchListener);
    paramOnLongClickAndTouchListener = paramView.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramViewHolder.frienduin);
    ((StringBuilder)localObject2).append(paramViewHolder.uniseq);
    paramOnLongClickAndTouchListener.a(((StringBuilder)localObject2).toString());
    paramView.h = ((View)localObject1);
    a(paramView, paramBaseChatItemLayout);
    return localObject1;
  }
  
  protected List<Integer> a(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return this.a.b(3);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.a.a(paramInt);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.b(paramChatMessage.issend)) {
      return this.e.getString(2131889387);
    }
    return this.e.getString(2131889384);
  }
  
  protected List<Integer> b(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return this.a.c(3);
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    if (paramView != null)
    {
      paramView = AIOUtils.b(paramView);
      if ((paramView != null) && (QFileVideoItemBuilder.FileHolder.class.isInstance(paramView)))
      {
        paramView = (QFileVideoItemBuilder.FileHolder)paramView;
        if (paramView != null) {
          return paramView.a;
        }
      }
    }
    return null;
  }
  
  protected void e(View paramView)
  {
    if ((paramView.getId() != 2131440242) && (paramView.getId() != 2131430626)) {
      return;
    }
    this.a.a(3, paramView);
  }
  
  protected BaseBubbleBuilder.ViewHolder h()
  {
    return new QFileVideoItemBuilder.FileHolder(this);
  }
  
  public Drawable i()
  {
    if (this.y == null) {
      this.y = new AIOFilePicMask(Color.argb(255, 242, 242, 242), 255, 0.0F);
    }
    return this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QFileVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */