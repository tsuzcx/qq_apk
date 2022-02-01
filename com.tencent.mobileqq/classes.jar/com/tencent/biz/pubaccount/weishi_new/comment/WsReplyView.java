package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.richtext.WSRichTextParserImpl.WSUser;
import com.tencent.biz.pubaccount.weishi_new.util.WSClickableSpanTouchListener;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.comment.CommentUIConfig;
import com.tencent.biz.subscribe.comment.DateUtils;
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

public class WsReplyView
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final String h = "com.tencent.biz.pubaccount.weishi_new.comment.WsReplyView";
  private static final String i = HardCodeUtil.a(2131910888);
  RoundCornerImageView a;
  TextView b;
  FeedRichTextView c;
  TextView d;
  ImageView e;
  TextView f;
  LinearLayout g;
  private int j;
  private OnCommentElementClickListener k;
  private TextView l;
  private TextView m;
  private stSimpleMetaComment n;
  private stSimpleMetaReply o;
  private WSOnGetReportInfo p;
  private int q;
  private Drawable r;
  private boolean s = false;
  private BitmapDrawable t;
  
  public WsReplyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WsReplyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WsReplyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131626038, this, true);
    this.a = ((RoundCornerImageView)localView.findViewById(2131436271));
    this.a.setCorner(ImmersiveUtils.dpToPx(10.0F));
    this.b = ((TextView)localView.findViewById(2131444654));
    this.c = ((FeedRichTextView)localView.findViewById(2131444652));
    this.d = ((TextView)localView.findViewById(2131444653));
    this.g = ((LinearLayout)localView.findViewById(2131444645));
    this.e = ((ImageView)localView.findViewById(2131444644));
    this.f = ((TextView)localView.findViewById(2131444646));
    this.l = ((TextView)localView.findViewById(2131444656));
    this.m = ((TextView)localView.findViewById(2131444655));
    setPadding(0, 0, 0, Utils.dp2px(5.0D));
    this.c.setOnTouchListener(new WSClickableSpanTouchListener());
    this.c.setRichTextDisplayType(1);
  }
  
  private void a(ArrayList<WSRichTextParserImpl.WSUser> paramArrayList)
  {
    if (this.n != null)
    {
      if (this.o == null) {
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
      WSCommentBeaconReport.a(this.p.a(), this.p.b(), this.n.id, this.o.id, localStringBuilder1.toString(), localStringBuilder2.toString(), this.q, this.p.c(), this.p.d());
    }
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.g.setOnClickListener(this);
    setOnClickListener(this);
    this.c.setOnElementClickListener(new WsReplyView.1(this));
    this.c.setOnParseListener(new WsReplyView.2(this));
  }
  
  public void onClick(View paramView)
  {
    OnCommentElementClickListener localOnCommentElementClickListener;
    Object localObject;
    stSimpleMetaReply localstSimpleMetaReply;
    switch (paramView.getId())
    {
    default: 
      if (!(paramView instanceof WsReplyView)) {
        if (paramView.getId() != 2131429990) {
          return;
        }
      }
      break;
    case 2131444654: 
      localOnCommentElementClickListener = this.k;
      if (localOnCommentElementClickListener != null)
      {
        localObject = this.o;
        if (localObject != null)
        {
          localOnCommentElementClickListener.a(paramView, 2, this.j, ((stSimpleMetaReply)localObject).poster);
          return;
        }
      }
      break;
    case 2131444652: 
      localOnCommentElementClickListener = this.k;
      if (localOnCommentElementClickListener != null)
      {
        localObject = this.n;
        localstSimpleMetaReply = this.o;
        localOnCommentElementClickListener.a(paramView, 7, this.j, new Object[] { localObject, localstSimpleMetaReply });
        return;
      }
      break;
    case 2131436271: 
      localOnCommentElementClickListener = this.k;
      if (localOnCommentElementClickListener != null)
      {
        localObject = this.n;
        localstSimpleMetaReply = this.o;
        localOnCommentElementClickListener.a(paramView, 77, this.j, new Object[] { localObject, localstSimpleMetaReply });
        return;
        localOnCommentElementClickListener = this.k;
        if (localOnCommentElementClickListener != null)
        {
          localObject = this.n;
          localstSimpleMetaReply = this.o;
          localOnCommentElementClickListener.a(paramView, 7, this.j, new Object[] { localObject, localstSimpleMetaReply });
        }
      }
      break;
    }
  }
  
  public void setData(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, String paramString)
  {
    this.n = paramstSimpleMetaComment;
    this.o = paramstSimpleMetaReply;
    if (paramstSimpleMetaComment != null)
    {
      if (paramstSimpleMetaReply == null) {
        return;
      }
      stSimpleMetaPerson localstSimpleMetaPerson = paramstSimpleMetaReply.poster;
      int i1 = 8;
      if (localstSimpleMetaPerson != null)
      {
        if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramstSimpleMetaReply.poster.id)) && (StringUtil.isEmpty(paramstSimpleMetaReply.poster.avatar)))
        {
          if (this.t == null) {
            this.t = new BitmapDrawable(ImageUtil.c(LocalHeadFetchUtils.a(LocalHeadFetchUtils.a(null, 1, paramstSimpleMetaReply.poster.id, 0)).a, 50, 50));
          }
          UIUtils.a(this.a, "", UIUtils.a(getContext(), 20.0F), UIUtils.a(getContext(), 20.0F), UIUtils.a(getContext(), 10.0F), this.t, null);
        }
        else
        {
          UIUtils.a(this.a, paramstSimpleMetaReply.poster.avatar, UIUtils.a(getContext(), 20.0F), UIUtils.a(getContext(), 20.0F), UIUtils.a(getContext(), 10.0F), ImageUtil.j(), null);
        }
        this.b.setText(paramstSimpleMetaReply.poster.nick);
        if (paramstSimpleMetaReply.poster.id.equals(paramString))
        {
          if (this.r == null)
          {
            this.r = getResources().getDrawable(1929641995);
            this.r.setBounds(0, ImmersiveUtils.dpToPx(1.0F), ImmersiveUtils.dpToPx(24.0F), ImmersiveUtils.dpToPx(13.0F));
          }
          this.b.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(6.0F));
          this.b.setCompoundDrawables(null, null, this.r, null);
        }
        else
        {
          this.b.setCompoundDrawables(null, null, null, null);
        }
        if (paramstSimpleMetaReply.receiver != null)
        {
          paramString = paramstSimpleMetaReply.receiver.nick;
          if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramstSimpleMetaComment.poster.id, paramstSimpleMetaReply.receiver.id)))
          {
            this.m.setVisibility(0);
            this.m.setText(paramString);
            this.l.setVisibility(0);
          }
          else
          {
            this.l.setVisibility(8);
            this.m.setVisibility(8);
          }
        }
      }
      this.c.setText(paramstSimpleMetaReply.wording);
      this.d.setText(DateUtils.a(paramstSimpleMetaReply.createtime * 1000L));
      this.s = false;
      paramstSimpleMetaComment = this.g;
      if (!CommentUIConfig.a()) {
        i1 = 0;
      }
      paramstSimpleMetaComment.setVisibility(i1);
    }
  }
  
  public void setOnCommentElementClickListener(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.k = paramOnCommentElementClickListener;
  }
  
  public void setPosition(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setReportParams(WSOnGetReportInfo paramWSOnGetReportInfo, int paramInt)
  {
    this.p = paramWSOnGetReportInfo;
    this.q = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsReplyView
 * JD-Core Version:    0.7.0.1
 */