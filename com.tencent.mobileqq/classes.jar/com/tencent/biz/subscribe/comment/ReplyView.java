package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URLEncoder;
import mqq.app.AppRuntime;

public class ReplyView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final String i = "com.tencent.biz.subscribe.comment.ReplyView";
  RoundCornerImageView a;
  TextView b;
  TextView c;
  AsyncRichTextView d;
  TextView e;
  ImageView f;
  TextView g;
  LinearLayout h;
  private final String j = HardCodeUtil.a(2131910888);
  private int k;
  private OnCommentElementClickListener l;
  private CertifiedAccountMeta.StComment m;
  private CertifiedAccountMeta.StReply n;
  private Drawable o;
  private boolean p = false;
  private BitmapDrawable q;
  
  public ReplyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReplyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReplyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private String a(String paramString1, String paramString2)
  {
    try
    {
      String str1 = URLEncoder.encode(paramString2, "UTF-8");
      paramString2 = str1;
    }
    catch (Exception localException)
    {
      String str2 = i;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("build nickname partially failed");
      localStringBuilder2.append(localException);
      QLog.e(str2, 1, localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("<uin:");
    localStringBuilder1.append(paramString1);
    localStringBuilder1.append(",nickname:");
    localStringBuilder1.append(paramString2);
    localStringBuilder1.append(">");
    return localStringBuilder1.toString();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131624406, this, true);
    this.a = ((RoundCornerImageView)localView.findViewById(2131436271));
    this.a.setCorner(ImmersiveUtils.dpToPx(18.0F));
    this.b = ((TextView)localView.findViewById(2131444654));
    this.d = ((AsyncRichTextView)localView.findViewById(2131444652));
    this.d.setNeedParseColor(true);
    this.e = ((TextView)localView.findViewById(2131444653));
    this.c = ((TextView)localView.findViewById(2131429990));
    this.h = ((LinearLayout)localView.findViewById(2131444645));
    this.f = ((ImageView)localView.findViewById(2131444644));
    this.g = ((TextView)localView.findViewById(2131444646));
    setPadding(0, 0, 0, Utils.dp2px(5.0D));
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.h.setOnClickListener(this);
    setOnClickListener(this);
    this.d.setOnLongClickListener(this);
    setOnLongClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    OnCommentElementClickListener localOnCommentElementClickListener;
    Object localObject;
    CertifiedAccountMeta.StReply localStReply;
    switch (paramView.getId())
    {
    default: 
      if (!(paramView instanceof ReplyView)) {
        if (paramView.getId() != 2131429990) {
          break label236;
        }
      }
      break;
    case 2131444654: 
      localOnCommentElementClickListener = this.l;
      if (localOnCommentElementClickListener != null)
      {
        localObject = this.n;
        if (localObject != null) {
          localOnCommentElementClickListener.a(paramView, 2, this.k, ((CertifiedAccountMeta.StReply)localObject).postUser);
        }
      }
      break;
    case 2131444652: 
      localOnCommentElementClickListener = this.l;
      if (localOnCommentElementClickListener != null)
      {
        localObject = this.m;
        localStReply = this.n;
        localOnCommentElementClickListener.a(paramView, 7, this.k, new Object[] { localObject, localStReply });
      }
      break;
    case 2131436271: 
      localOnCommentElementClickListener = this.l;
      if (localOnCommentElementClickListener != null)
      {
        localObject = this.n;
        if (localObject != null)
        {
          localOnCommentElementClickListener.a(paramView, 1, this.k, ((CertifiedAccountMeta.StReply)localObject).postUser);
          break label236;
          localOnCommentElementClickListener = this.l;
          if (localOnCommentElementClickListener != null)
          {
            localObject = this.m;
            localStReply = this.n;
            localOnCommentElementClickListener.a(paramView, 7, this.k, new Object[] { localObject, localStReply });
          }
        }
      }
      break;
    }
    label236:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() != 2131444652) {
      return false;
    }
    OnCommentElementClickListener localOnCommentElementClickListener = this.l;
    if (localOnCommentElementClickListener != null)
    {
      CertifiedAccountMeta.StComment localStComment = this.m;
      CertifiedAccountMeta.StReply localStReply = this.n;
      localOnCommentElementClickListener.b(paramView, 8, this.k, new Object[] { localStComment, localStReply });
    }
    return true;
  }
  
  public void setData(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply, String paramString)
  {
    this.m = paramStComment;
    this.n = paramStReply;
    if (paramStComment != null)
    {
      if (paramStReply == null) {
        return;
      }
      CertifiedAccountMeta.StUser localStUser = paramStReply.postUser;
      int i1 = 0;
      if (localStUser != null)
      {
        if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStReply.postUser.id.get())) && (StringUtil.isEmpty(paramStReply.postUser.icon.get())))
        {
          if (this.q == null) {
            this.q = new BitmapDrawable(ImageUtil.c(LocalHeadFetchUtils.a(LocalHeadFetchUtils.a(null, 1, paramStReply.postUser.id.get(), 0)).a, 50, 50));
          }
          UIUtils.a(this.a, "", UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 18.0F), this.q, null);
        }
        else
        {
          UIUtils.a(this.a, paramStReply.postUser.icon.get(), UIUtils.a(getContext(), 22.0F), UIUtils.a(getContext(), 22.0F), UIUtils.a(getContext(), 11.0F), ImageUtil.j(), null);
        }
        this.b.setText(paramStReply.postUser.nick.get());
        if (paramStReply.postUser.id.get().equals(paramString))
        {
          if (this.o == null)
          {
            this.o = getResources().getDrawable(2130853569);
            this.o.setBounds(0, 0, ImmersiveUtils.dpToPx(21.0F), ImmersiveUtils.dpToPx(12.0F));
          }
          this.b.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(2.0F));
          this.b.setCompoundDrawables(null, null, this.o, null);
        }
        else
        {
          this.b.setCompoundDrawables(null, null, null, null);
        }
      }
      paramString = new StringBuilder();
      if ((paramStComment != null) && (paramStReply.targetUser != null) && (!paramStComment.postUser.id.get().equals(paramStReply.targetUser.id.get())))
      {
        paramString.append("{text:");
        paramString.append(this.j);
        paramString.append(",color:");
        paramString.append(Integer.toHexString(getResources().getColor(2131168235)));
        paramString.append(",useDefaultFont:1,useSuperFont:0}");
        paramString.append(a(paramStReply.targetUser.id.get(), paramStReply.targetUser.nick.get()));
        paramString.append("{text:");
        paramString.append("：");
        paramString.append(",color:");
        paramString.append(Integer.toHexString(getResources().getColor(2131168236)));
        paramString.append(",useDefaultFont:1,useSuperFont:0}");
      }
      paramString.append(paramStReply.content.get());
      this.d.setText(paramString);
      this.e.setText(DateUtils.a(paramStReply.createTime.get() * 1000L));
      this.p = false;
      paramStComment = this.h;
      if (CommentUIConfig.a()) {
        i1 = 8;
      }
      paramStComment.setVisibility(i1);
    }
  }
  
  public void setOnCommentElementClickListener(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.l = paramOnCommentElementClickListener;
  }
  
  public void setPosition(int paramInt)
  {
    this.k = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ReplyView
 * JD-Core Version:    0.7.0.1
 */