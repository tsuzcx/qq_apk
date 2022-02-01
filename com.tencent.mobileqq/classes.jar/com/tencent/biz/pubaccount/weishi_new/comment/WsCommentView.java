package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.richtext.WSRichTextParserImpl.WSUser;
import com.tencent.biz.pubaccount.weishi_new.util.WSClickableSpanTouchListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.comment.DateUtils;
import com.tencent.biz.subscribe.comment.Formatter;
import com.tencent.biz.subscribe.comment.LocalHeadFetchUtils;
import com.tencent.biz.subscribe.comment.OnCommentElementClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class WsCommentView
  extends RelativeLayout
  implements View.OnClickListener
{
  RelativeLayout a;
  RoundCornerImageView b;
  TextView c;
  FeedRichTextView d;
  WsReplyContainer e;
  View f;
  ImageView g;
  TextView h;
  View i;
  WsCommentView.MoreCommentHolder j;
  private int k;
  private OnCommentElementClickListener l;
  private stSimpleMetaComment m;
  private Drawable n;
  private int o;
  private WSOnGetReportInfo p;
  private Drawable q;
  private boolean r = false;
  
  public WsCommentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WsCommentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WsCommentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131626032, this, true);
    this.a = ((RelativeLayout)localView.findViewById(2131431066));
    this.b = ((RoundCornerImageView)localView.findViewById(2131428988));
    this.b.setCorner(ImmersiveUtils.dpToPx(18.0F));
    this.c = ((TextView)localView.findViewById(2131440558));
    this.d = ((FeedRichTextView)localView.findViewById(2131440538));
    this.e = ((WsReplyContainer)localView.findViewById(2131444635));
    this.f = localView.findViewById(2131437183);
    this.g = ((ImageView)localView.findViewById(2131437182));
    this.h = ((TextView)localView.findViewById(2131437184));
    this.i = localView.findViewById(2131432003);
    this.d.setOnTouchListener(new WSClickableSpanTouchListener());
    this.d.setRichTextDisplayType(1);
    this.j = new WsCommentView.MoreCommentHolder();
    this.j.a = ((LinearLayout)localView.findViewById(2131445902));
    this.j.b = ((TextView)localView.findViewById(2131431073));
    this.j.c = ((TextView)localView.findViewById(2131438877));
    this.j.f = ((LinearLayout)localView.findViewById(2131429936));
    this.j.d = ((TextView)localView.findViewById(2131429991));
    this.j.e = ((ImageView)localView.findViewById(2131432023));
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, boolean paramBoolean)
  {
    Object localObject = this.j;
    if ((localObject != null) && (((WsCommentView.MoreCommentHolder)localObject).f != null)) {
      if ((paramBoolean) && (paramstSimpleMetaComment != null) && (paramstSimpleMetaComment.replyList.size() > 0))
      {
        localObject = DateUtils.a(paramstSimpleMetaComment.createtime * 1000L);
        this.j.f.setVisibility(0);
        this.j.e.setVisibility(0);
        this.j.b.setText((CharSequence)localObject);
        if (paramstSimpleMetaComment.replyList.size() > 0)
        {
          localObject = this.j.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramstSimpleMetaComment.replyNum);
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
  
  private void a(ArrayList<WSRichTextParserImpl.WSUser> paramArrayList)
  {
    if (this.m != null)
    {
      if (paramArrayList == null) {
        return;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        localStringBuilder1.append(((WSRichTextParserImpl.WSUser)paramArrayList.get(i1)).a);
        localStringBuilder2.append(((WSRichTextParserImpl.WSUser)paramArrayList.get(i1)).c);
        if (i1 != paramArrayList.size() - 1)
        {
          localStringBuilder1.append(",");
          localStringBuilder2.append(",");
        }
        i1 += 1;
      }
      paramArrayList = this.p;
      if (paramArrayList == null) {
        return;
      }
      WSCommentBeaconReport.a(paramArrayList.a(), this.p.b(), this.m.id, "", localStringBuilder1.toString(), localStringBuilder2.toString(), this.k, this.p.c(), this.p.d());
    }
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.d.setOnElementClickListener(new WsCommentView.2(this));
    this.d.setOnParseListener(new WsCommentView.3(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.g.setImageResource(2130853555);
      this.h.setTextColor(getResources().getColor(2131166959));
      return;
    }
    this.g.setImageResource(2130853513);
    this.h.setTextColor(getResources().getColor(2131165564));
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    stSimpleMetaComment localstSimpleMetaComment;
    switch (paramView.getId())
    {
    default: 
    case 2131440558: 
      localObject = this.l;
      if (localObject != null)
      {
        localstSimpleMetaComment = this.m;
        if (localstSimpleMetaComment != null)
        {
          ((OnCommentElementClickListener)localObject).a(paramView, 2, this.k, localstSimpleMetaComment.poster);
          return;
        }
      }
      break;
    case 2131437183: 
      if (this.l != null)
      {
        this.r = true;
        boolean bool;
        if (this.m.isDing == 1) {
          bool = true;
        } else {
          bool = false;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("点赞前 isDing：");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(",mComment.isDing:");
        ((StringBuilder)localObject).append(this.m.isDing);
        WSLog.c("comment", ((StringBuilder)localObject).toString());
        a(bool);
        if (!bool)
        {
          WSLog.c("comment", "执行点赞 ...............");
          localObject = this.m;
          ((stSimpleMetaComment)localObject).dingNum += 1L;
          this.h.setText(Formatter.a(this.m.dingNum));
        }
        else if (this.m.dingNum > 1L)
        {
          WSLog.c("comment", "执行点赞-1 ...............");
          localObject = this.m;
          ((stSimpleMetaComment)localObject).dingNum -= 1L;
          this.h.setText(Formatter.a(this.m.dingNum));
        }
        else
        {
          localObject = this.m;
          ((stSimpleMetaComment)localObject).dingNum -= 1L;
          WSLog.c("comment", "执行取消点赞 ...............");
          this.h.setText("");
        }
        localObject = this.m;
        ((stSimpleMetaComment)localObject).isDing = ((((stSimpleMetaComment)localObject).isDing + 1) % 2);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("点赞后 mComment.isDing：");
        ((StringBuilder)localObject).append(this.m.isDing);
        ((StringBuilder)localObject).append(",clickPosition:");
        ((StringBuilder)localObject).append(this.k);
        WSLog.c("comment", ((StringBuilder)localObject).toString());
        this.l.a(paramView, 6, this.k, this.m);
        return;
      }
      WSLog.c("comment", "mOnCommentElementClickListener is null ...............");
      return;
    case 2131431066: 
    case 2131440538: 
      localObject = this.l;
      if (localObject != null)
      {
        ((OnCommentElementClickListener)localObject).a(paramView, 4, this.k, this.m);
        return;
      }
      break;
    case 2131428988: 
      localObject = this.l;
      if (localObject != null)
      {
        localstSimpleMetaComment = this.m;
        if (localstSimpleMetaComment != null) {
          ((OnCommentElementClickListener)localObject).a(paramView, 1, this.k, localstSimpleMetaComment.poster);
        }
      }
      break;
    }
  }
  
  public void setData(stSimpleMetaComment paramstSimpleMetaComment, int paramInt, String paramString)
  {
    this.m = paramstSimpleMetaComment;
    if (paramstSimpleMetaComment == null) {
      return;
    }
    stSimpleMetaPerson localstSimpleMetaPerson = paramstSimpleMetaComment.poster;
    boolean bool = true;
    if (localstSimpleMetaPerson != null)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramstSimpleMetaComment.poster.id)) && (StringUtil.isEmpty(paramstSimpleMetaComment.poster.avatar)))
      {
        if (this.q == null) {
          this.q = new BitmapDrawable(ImageUtil.c(LocalHeadFetchUtils.a(LocalHeadFetchUtils.a(null, 1, paramstSimpleMetaComment.poster.id, 0)).a, 50, 50));
        }
        UIUtils.a(this.b, "", UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 18.0F), this.q, null);
      }
      else
      {
        UIUtils.a(this.b, paramstSimpleMetaComment.poster.avatar, UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 18.0F), ImageUtil.j(), null);
      }
      this.c.setText(paramstSimpleMetaComment.poster.nick);
      if (paramstSimpleMetaComment.poster.id.equals(paramString))
      {
        if (this.n == null)
        {
          this.n = getResources().getDrawable(1929641995);
          this.n.setBounds(0, ImmersiveUtils.dpToPx(1.0F), ImmersiveUtils.dpToPx(24.0F), ImmersiveUtils.dpToPx(13.0F));
        }
        this.c.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(6.0F));
        this.c.setCompoundDrawables(null, null, this.n, null);
      }
      else
      {
        this.c.setCompoundDrawables(null, null, null, null);
      }
    }
    this.d.setText(paramstSimpleMetaComment.wording);
    this.j.b.setText(DateUtils.a(paramstSimpleMetaComment.createtime * 1000L));
    a(paramstSimpleMetaComment, false);
    if (this.m.replyList.size() == 0) {
      this.e.setVisibility(8);
    } else if (this.m.replyList.size() > 0)
    {
      if (paramInt == 0)
      {
        this.e.a(this.m, paramInt, paramString, this.p);
        this.e.setVisibility(8);
        a(paramstSimpleMetaComment, true);
      }
      else
      {
        this.e.a(this.m, paramInt, paramString, this.p);
        this.e.setVisibility(0);
      }
    }
    else {
      this.e.setVisibility(8);
    }
    if (this.m.isDing != 0) {
      bool = false;
    }
    a(bool);
    if (paramstSimpleMetaComment.dingNum > 0L) {
      this.h.setText(Formatter.a(paramstSimpleMetaComment.dingNum));
    } else {
      this.h.setText("");
    }
    this.r = false;
    this.f.setVisibility(0);
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
      this.j.f.setOnClickListener(new WsCommentView.1(this));
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.k = paramInt;
    this.e.setPosition(paramInt);
  }
  
  public void setReportParams(WSOnGetReportInfo paramWSOnGetReportInfo)
  {
    this.p = paramWSOnGetReportInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentView
 * JD-Core Version:    0.7.0.1
 */