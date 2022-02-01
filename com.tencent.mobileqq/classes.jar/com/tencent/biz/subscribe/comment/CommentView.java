package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;

public class CommentView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  RelativeLayout a;
  RoundCornerImageView b;
  TextView c;
  AsyncRichTextView d;
  ReplyContainer e;
  View f;
  ImageView g;
  TextView h;
  View i;
  CommentView.MoreCommentHolder j;
  private int k;
  private OnCommentElementClickListener l;
  private CertifiedAccountMeta.StComment m;
  private Drawable n;
  private int o;
  private Drawable p;
  private boolean q = false;
  
  public CommentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131624405, this, true);
    this.a = ((RelativeLayout)localView.findViewById(2131431066));
    this.b = ((RoundCornerImageView)localView.findViewById(2131428988));
    this.b.setCorner(ImmersiveUtils.dpToPx(18.0F));
    this.c = ((TextView)localView.findViewById(2131440558));
    this.d = ((AsyncRichTextView)localView.findViewById(2131440538));
    this.e = ((ReplyContainer)localView.findViewById(2131444635));
    this.f = localView.findViewById(2131437183);
    this.g = ((ImageView)localView.findViewById(2131437182));
    this.h = ((TextView)localView.findViewById(2131437184));
    this.i = localView.findViewById(2131432003);
    this.j = new CommentView.MoreCommentHolder();
    this.j.a = ((LinearLayout)localView.findViewById(2131445902));
    this.j.b = ((TextView)localView.findViewById(2131431073));
    this.j.c = ((TextView)localView.findViewById(2131438877));
    this.j.f = ((LinearLayout)localView.findViewById(2131429936));
    this.j.d = ((TextView)localView.findViewById(2131429991));
    this.j.e = ((ImageView)localView.findViewById(2131432023));
  }
  
  private void a(CertifiedAccountMeta.StComment paramStComment, boolean paramBoolean)
  {
    Object localObject = this.j;
    if ((localObject != null) && (((CommentView.MoreCommentHolder)localObject).f != null)) {
      if ((paramBoolean) && (paramStComment != null) && (paramStComment.vecReply.size() > 0))
      {
        localObject = DateUtils.a(paramStComment.createTime.get() * 1000L);
        this.j.f.setVisibility(0);
        this.j.e.setVisibility(0);
        this.j.b.setText((CharSequence)localObject);
        if (paramStComment.vecReply.size() > 0)
        {
          localObject = this.j.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramStComment.replyCount);
          localStringBuilder.append(HardCodeUtil.a(2131900407));
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
      }
      else
      {
        this.j.f.setVisibility(8);
        this.j.e.setVisibility(8);
      }
    }
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.d.setOnLongClickListener(this);
    this.a.setOnLongClickListener(this);
  }
  
  public ReplyView a(String paramString)
  {
    return this.e.a(paramString);
  }
  
  public LinearLayout getReplyContainer()
  {
    return this.e;
  }
  
  public void onClick(View paramView)
  {
    OnCommentElementClickListener localOnCommentElementClickListener;
    CertifiedAccountMeta.StComment localStComment;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131440558: 
      localOnCommentElementClickListener = this.l;
      if (localOnCommentElementClickListener != null)
      {
        localStComment = this.m;
        if (localStComment != null) {
          localOnCommentElementClickListener.a(paramView, 2, this.k, localStComment.postUser);
        }
      }
      break;
    case 2131431066: 
    case 2131440538: 
      localOnCommentElementClickListener = this.l;
      if (localOnCommentElementClickListener != null) {
        localOnCommentElementClickListener.a(paramView, 4, this.k, this.m);
      }
      break;
    case 2131428988: 
      localOnCommentElementClickListener = this.l;
      if (localOnCommentElementClickListener != null)
      {
        localStComment = this.m;
        if (localStComment != null) {
          localOnCommentElementClickListener.a(paramView, 1, this.k, localStComment.postUser);
        }
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 != 2131431066) && (i1 != 2131440538)) {
      return false;
    }
    OnCommentElementClickListener localOnCommentElementClickListener = this.l;
    if (localOnCommentElementClickListener != null) {
      localOnCommentElementClickListener.b(paramView, 5, this.k, this.m);
    }
    return true;
  }
  
  public void setData(CertifiedAccountMeta.StComment paramStComment, int paramInt, String paramString)
  {
    this.m = paramStComment;
    if (paramStComment == null) {
      return;
    }
    CertifiedAccountMeta.StUser localStUser = paramStComment.postUser;
    int i1 = 0;
    if (localStUser != null)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStComment.postUser.id.get())) && (StringUtil.isEmpty(paramStComment.postUser.icon.get())))
      {
        if (this.p == null) {
          this.p = new BitmapDrawable(ImageUtil.c(LocalHeadFetchUtils.a(LocalHeadFetchUtils.a(null, 1, paramStComment.postUser.id.get(), 0)).a, 50, 50));
        }
        UIUtils.a(this.b, "", UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 18.0F), this.p, null);
      }
      else
      {
        UIUtils.a(this.b, paramStComment.postUser.icon.get(), UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 18.0F), ImageUtil.j(), null);
      }
      this.c.setText(paramStComment.postUser.nick.get());
      if (paramStComment.postUser.id.get().equals(paramString))
      {
        if (this.n == null)
        {
          this.n = getResources().getDrawable(2130853569);
          this.n.setBounds(0, 0, ImmersiveUtils.dpToPx(21.0F), ImmersiveUtils.dpToPx(12.0F));
        }
        this.c.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(2.0F));
        this.c.setCompoundDrawables(null, null, this.n, null);
      }
      else
      {
        this.c.setCompoundDrawables(null, null, null, null);
      }
    }
    this.d.setText(paramStComment.content.get());
    this.j.b.setText(DateUtils.a(paramStComment.createTime.get() * 1000L));
    a(paramStComment, false);
    if (this.m.vecReply.size() == 0) {
      this.e.setVisibility(8);
    } else if (this.m.vecReply.size() > 0)
    {
      if (paramInt == 0)
      {
        this.e.a(this.m, paramInt, paramString);
        this.e.setVisibility(8);
        a(paramStComment, true);
      }
      else
      {
        this.e.a(this.m, paramInt, paramString);
        this.e.setVisibility(0);
      }
    }
    else {
      this.e.setVisibility(8);
    }
    this.q = false;
    paramStComment = this.f;
    if (CommentUIConfig.a()) {
      paramInt = i1;
    } else {
      paramInt = 8;
    }
    paramStComment.setVisibility(paramInt);
  }
  
  public void setDisplayNum(int paramInt)
  {
    this.o = paramInt;
    this.e.setDisplayNum(paramInt);
  }
  
  public void setOnCommentElementClickListener(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.l = paramOnCommentElementClickListener;
    this.e.setOnCommentElementClickListener(paramOnCommentElementClickListener);
    paramOnCommentElementClickListener = this.j;
    if ((paramOnCommentElementClickListener != null) && (paramOnCommentElementClickListener.f != null)) {
      this.j.f.setOnClickListener(new CommentView.1(this));
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.k = paramInt;
    this.e.setPosition(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentView
 * JD-Core Version:    0.7.0.1
 */