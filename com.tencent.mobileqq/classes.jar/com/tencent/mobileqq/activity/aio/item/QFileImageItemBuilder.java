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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
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
  private int A = BaseChatItemLayout.f;
  private Drawable B;
  private Drawable C;
  private float y = 0.5625F;
  private int z = (int)(BaseChatItemLayout.f * this.y);
  
  public QFileImageItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    if (this.C == null)
    {
      Bitmap localBitmap = null;
      if ((URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable)) {
        localBitmap = ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      } else if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      }
      this.C = new BitmapDrawableWithMargin(this.e.getResources(), localBitmap, paramInt1, paramInt2, -921103);
    }
    return this.C;
  }
  
  private void a(QFileImageItemBuilder.FileHolder paramFileHolder)
  {
    FrameLayout localFrameLayout = paramFileHolder.d;
    localFrameLayout.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground(i());
    } else {
      localFrameLayout.setBackgroundDrawable(i());
    }
    TextView localTextView = (TextView)localFrameLayout.findViewById(2131435900);
    localTextView.setText(2131890795);
    localTextView.setCompoundDrawablePadding(AIOUtils.b(7.0F, this.e.getResources()));
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130851866, 0, 0);
    localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramFileHolder.f, paramFileHolder.g));
  }
  
  private void a(QFileImageItemBuilder.FileHolder paramFileHolder, int paramInt)
  {
    if (paramInt == 1)
    {
      FrameLayout localFrameLayout = paramFileHolder.d;
      localFrameLayout.setVisibility(0);
      if (Build.VERSION.SDK_INT >= 16) {
        localFrameLayout.setBackground(i());
      } else {
        localFrameLayout.setBackgroundDrawable(i());
      }
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131435900);
      localTextView.setText(2131889389);
      localTextView.setTextSize(12.0F);
      localTextView.setTextColor(Color.parseColor("#B0B3BF"));
      localTextView.setCompoundDrawablePadding(AIOUtils.b(4.0F, this.e.getResources()));
      Drawable localDrawable = this.e.getResources().getDrawable(2130846249);
      localDrawable.setBounds(0, 0, AIOUtils.b(28.0F, this.e.getResources()), AIOUtils.b(28.0F, this.e.getResources()));
      localTextView.setCompoundDrawables(null, localDrawable, null, null);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramFileHolder.f, paramFileHolder.g));
    }
  }
  
  private void a(QFileImageItemBuilder.FileHolder paramFileHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramFileHolder.d != null) {
      paramFileHolder.d.setVisibility(8);
    }
    c(paramFileHolder);
    paramFileHolder.s.setVisibility(8);
    Object localObject = b(paramFileHolder);
    paramFileHolder.a.setImageDrawable((Drawable)localObject);
    localObject = FileUtils.getFileSize(this.a.g());
    a(this.a.f(), (String)localObject, paramFileHolder);
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
    b(paramFileHolder, paramBaseChatItemLayout);
  }
  
  private void a(QFileImageItemBuilder.FileHolder paramFileHolder, String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return;
    }
    paramString = FileManagerUtil.w(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramFileHolder.f = i;
      paramFileHolder.g = j;
      this.a.a(i, j);
    }
    c(paramFileHolder);
  }
  
  private void a(QFileImageItemBuilder.FileHolder paramFileHolder, boolean paramBoolean)
  {
    PicProgressView localPicProgressView;
    Object localObject;
    if (paramBoolean)
    {
      if (paramFileHolder.b == null)
      {
        localPicProgressView = new PicProgressView(this.e);
        float f2 = this.k;
        float f1;
        if (QQTheme.isNowSimpleUI()) {
          f1 = 8.0F;
        } else {
          f1 = 15.0F;
        }
        localPicProgressView.setRadius(f2 * f1, false);
        localPicProgressView.setSharpCornerCor(BubbleImageView.d);
        localPicProgressView.setShowCorner(false);
        localPicProgressView.setProgressBackgroudColor(2130706432);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131440242);
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131440242);
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131440242);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131440242);
        ((RelativeLayout)paramFileHolder.h).addView(localPicProgressView, (ViewGroup.LayoutParams)localObject);
        localPicProgressView.setProgress(0);
        paramFileHolder.b = localPicProgressView;
        localPicProgressView = paramFileHolder.b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramFileHolder.q.frienduin);
        ((StringBuilder)localObject).append(paramFileHolder.q.uniseq);
        localPicProgressView.setProgressKey(((StringBuilder)localObject).toString());
      }
      else
      {
        paramFileHolder.b.setProgress(this.a.k());
      }
      paramFileHolder.b.setVisibility(0);
      return;
    }
    if (paramFileHolder.b != null)
    {
      localPicProgressView = paramFileHolder.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFileHolder.q.frienduin);
      ((StringBuilder)localObject).append(paramFileHolder.q.uniseq);
      localPicProgressView.b(((StringBuilder)localObject).toString());
      localPicProgressView = paramFileHolder.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFileHolder.q.frienduin);
      ((StringBuilder)localObject).append(paramFileHolder.q.uniseq);
      if (!localPicProgressView.c(((StringBuilder)localObject).toString()))
      {
        ((RelativeLayout)paramFileHolder.h).removeView(paramFileHolder.b);
        paramFileHolder.b = null;
        return;
      }
      paramFileHolder.b.setProgress(100);
    }
  }
  
  private void a(String paramString1, String paramString2, QFileImageItemBuilder.FileHolder paramFileHolder)
  {
    if (paramFileHolder.c != null)
    {
      paramFileHolder.c.removeAllViews();
      ((RelativeLayout)paramFileHolder.h).removeView(paramFileHolder.c);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.e);
    localRelativeLayout.setId(2131433127);
    localRelativeLayout.setBackgroundResource(SimpleModeHelper.c());
    paramFileHolder.c = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(55.0F, this.e.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131440242);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131440242);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131440242);
    ((RelativeLayout)paramFileHolder.h).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = QFileUtils.a(paramFileHolder.f, paramFileHolder.g);
    localObject1 = new TextView(this.e);
    ((TextView)localObject1).setId(2131430544);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(7.0F, this.e.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(7.0F, this.e.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.b(7.0F, this.e.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
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
    localRelativeLayout.addView((View)localObject2, localLayoutParams);
    paramString1 = QFileUtils.a(this.e, i, paramFileHolder.f, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
    if (i != 1)
    {
      if (i == 2)
      {
        ((TextView)localObject2).setLines(1);
        ((TextView)localObject2).setMaxLines(1);
        ((TextView)localObject1).setGravity(5);
      }
    }
    else
    {
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject1).setGravity(3);
    }
    ((TextView)localObject2).setText(paramString1);
    ((TextView)localObject1).setText(paramString2);
  }
  
  private Drawable b(QFileImageItemBuilder.FileHolder paramFileHolder)
  {
    Object localObject = this.a.h();
    if (FileUtils.fileExistsAndNotEmpty((String)localObject))
    {
      i = this.a.d();
      int j = this.a.e();
      if ((i == 0) || (j == 0)) {
        a(paramFileHolder, (String)localObject);
      }
      Drawable localDrawable = a(paramFileHolder.f, paramFileHolder.g);
      paramFileHolder = a(paramFileHolder.f, paramFileHolder.g);
      localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
      if (localObject != null) {
        return URLDrawableHelper.getDrawable((URL)localObject, 0, 0, localDrawable, paramFileHolder, true, 0.0F);
      }
      return localDrawable;
    }
    int i = this.a.q();
    if (i == 1)
    {
      a(paramFileHolder, i);
      return i();
    }
    if (i == 2)
    {
      this.a.l();
      return a(paramFileHolder.f, paramFileHolder.g);
    }
    this.a.l();
    paramFileHolder.s.setVisibility(0);
    return i();
  }
  
  private void b(QFileImageItemBuilder.FileHolder paramFileHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.a.i();
    if (i == 1)
    {
      if (!FileUtils.fileExistsAndNotEmpty(this.a.h()))
      {
        c(paramFileHolder);
        a(paramFileHolder);
        paramFileHolder.s.setVisibility(8);
        if (paramFileHolder.c != null)
        {
          paramFileHolder.c.removeAllViews();
          ((RelativeLayout)paramFileHolder.h).removeView(paramFileHolder.c);
        }
      }
    }
    else
    {
      if (i == 3)
      {
        a(paramFileHolder, true);
        paramFileHolder.s.setVisibility(8);
        return;
      }
      if ((i != 2) && (i != 4))
      {
        a(paramFileHolder, false);
        return;
      }
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      a(paramFileHolder, false);
    }
  }
  
  private void c(QFileImageItemBuilder.FileHolder paramFileHolder)
  {
    Object localObject = this.a.h();
    localObject = FilePicURLDrawlableHelper.a(this.a.d(), this.a.e(), (String)localObject);
    int i = ((FilePicURLDrawlableHelper.AIOImgInfo)localObject).a;
    int j = ((FilePicURLDrawlableHelper.AIOImgInfo)localObject).b;
    if ((i > 0) && (j > 0))
    {
      paramFileHolder.f = i;
      paramFileHolder.g = j;
    }
    else
    {
      paramFileHolder.f = this.z;
      paramFileHolder.g = this.A;
    }
    localObject = paramFileHolder.a.getLayoutParams();
    if (localObject == null)
    {
      localObject = new RelativeLayout.LayoutParams(paramFileHolder.f, paramFileHolder.g);
      paramFileHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if ((((ViewGroup.LayoutParams)localObject).width != paramFileHolder.f) || (((ViewGroup.LayoutParams)localObject).height != paramFileHolder.g))
    {
      ((ViewGroup.LayoutParams)localObject).width = paramFileHolder.f;
      ((ViewGroup.LayoutParams)localObject).height = paramFileHolder.g;
      paramFileHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private Drawable i()
  {
    if (this.B == null)
    {
      float f1 = this.k;
      float f2 = URLDrawableHelper.getRoundCorner();
      this.B = new AIOFilePicMask(Color.argb(255, 242, 242, 242), 255, f1 * (f2 + 2.0F));
    }
    return this.B;
  }
  
  protected View a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if ((paramViewHolder instanceof QFileImageItemBuilder.FileHolder))
    {
      localObject1 = (QFileImageItemBuilder.FileHolder)paramViewHolder;
      paramViewHolder = paramView;
      paramView = (View)localObject1;
    }
    else
    {
      paramView = new QFileImageItemBuilder.FileHolder(this);
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
      paramViewHolder = new BubbleImageView(this.e);
      int i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        paramViewHolder.w = true;
      }
      paramViewHolder.setId(2131440242);
      paramViewHolder.setAdjustViewBounds(true);
      paramViewHolder.setScaleType(ImageView.ScaleType.CENTER_CROP);
      float f;
      if (QQTheme.isNowSimpleUI()) {
        f = 8.0F;
      } else {
        f = 15.0F;
      }
      paramViewHolder.setRadius(f);
      paramViewHolder.c(false);
      paramViewHolder.setShowEdge(true);
      ((RelativeLayout)localObject1).addView(paramViewHolder, new RelativeLayout.LayoutParams(-2, -2));
      paramView.a = paramViewHolder;
      paramViewHolder = new FrameLayout(this.e);
      Object localObject2 = new TextView(this.e);
      ((TextView)localObject2).setId(2131435900);
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.rgb(178, 182, 195));
      Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject3).gravity = 17;
      paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      paramViewHolder.setVisibility(8);
      ((RelativeLayout)localObject1).addView(paramViewHolder, new RelativeLayout.LayoutParams(-1, -1));
      paramView.d = paramViewHolder;
      paramViewHolder = new LinearLayout(this.e);
      paramViewHolder.setOrientation(1);
      paramViewHolder.setGravity(1);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      ((RelativeLayout)localObject1).addView(paramViewHolder, (ViewGroup.LayoutParams)localObject2);
      paramView.s = paramViewHolder;
      localObject2 = new ImageView(this.e);
      ((ImageView)localObject2).setImageResource(2130839585);
      paramViewHolder.addView((View)localObject2, new LinearLayout.LayoutParams(AIOUtils.b(20.0F, this.e.getResources()), AIOUtils.b(20.0F, this.e.getResources())));
      localObject2 = new TextView(this.e);
      ((TextView)localObject2).setText(2131889390);
      ((TextView)localObject2).setTextSize(12.0F);
      ((TextView)localObject2).setTextColor(Color.parseColor("#B0B3BF"));
      localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(8.0F, this.e.getResources());
      paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      ((View)localObject1).setOnClickListener(this);
      super.a((View)localObject1, paramOnLongClickAndTouchListener);
    }
    paramView.j.setMiniAioShieldItemTouchListener(this);
    paramView.h = ((View)localObject1);
    a(paramView, paramBaseChatItemLayout);
    return localObject1;
  }
  
  protected List<Integer> a(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return this.a.b(2);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.a.a(paramInt);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.b(paramChatMessage.issend)) {
      return this.e.getString(2131889386);
    }
    return this.e.getString(2131889383);
  }
  
  protected List<Integer> b(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return this.a.c(2);
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (QFileImageItemBuilder.FileHolder.class.isInstance(paramView))) {
        return ((QFileImageItemBuilder.FileHolder)paramView).a;
      }
    }
    return null;
  }
  
  protected void e(View paramView)
  {
    if (paramView.getId() == 2131430578)
    {
      paramView = AIOUtils.b(paramView);
      if (paramView == null)
      {
        QLog.w("QFileImageItemBuilder", 1, "holder tag is null");
        return;
      }
      if (!QFileImageItemBuilder.FileHolder.class.isInstance(paramView))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("holder tag class[");
        localStringBuilder.append(paramView.getClass().getName());
        localStringBuilder.append("] is not Holder");
        QLog.w("QFileImageItemBuilder", 1, localStringBuilder.toString());
        return;
      }
      paramView = (QFileImageItemBuilder.FileHolder)paramView;
      this.a.a(2, paramView.a);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder h()
  {
    return new QFileImageItemBuilder.FileHolder(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QFileImageItemBuilder
 * JD-Core Version:    0.7.0.1
 */