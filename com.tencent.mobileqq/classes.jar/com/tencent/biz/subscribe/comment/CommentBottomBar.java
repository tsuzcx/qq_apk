package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import ajjy;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bbmy;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import vvz;
import vyz;
import vza;
import vzb;
import vzc;
import vzd;
import vzz;
import wah;
import wbb;
import wcj;
import wcl;
import wwt;

public class CommentBottomBar
  extends LinearLayout
  implements wcl
{
  private CertifiedAccountMeta.StComment jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private CertifiedAccountMeta.StReply jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private vzz jdField_a_of_type_Vzz;
  private boolean jdField_a_of_type_Boolean = true;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView c;
  
  public CommentBottomBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommentBottomBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommentBottomBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
    e();
  }
  
  private String a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser == null) {
        break label162;
      }
      paramStReply = String.format(getContext().getString(2131626777), new Object[] { paramStReply.postUser.nick.get() });
      paramStComment = paramStReply;
      if (paramStReply.length() > 10)
      {
        paramStComment = paramStReply.substring(0, 10);
        paramStComment = paramStComment + "...";
      }
    }
    do
    {
      return paramStComment;
      if ((paramStComment == null) || (paramStComment.postUser == null)) {
        break;
      }
      paramStReply = String.format(getContext().getString(2131626777), new Object[] { paramStComment.postUser.nick.get() });
      paramStComment = paramStReply;
    } while (paramStReply.length() <= 10);
    paramStComment = paramStReply.substring(0, 10);
    return paramStComment + "...";
    label162:
    return null;
  }
  
  private void b(int paramInt)
  {
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramInt == 0) {}
    for (paramInt = 2130838696;; paramInt = 2130838697)
    {
      localImageView.setBackgroundResource(paramInt);
      return;
    }
  }
  
  private void d()
  {
    setOrientation(0);
    setBackgroundColor(-1);
    setGravity(16);
    LayoutInflater.from(getContext()).inflate(2131493149, this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131303010));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312220));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131303050));
    this.c = ((ImageView)findViewById(2131302916));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302915));
    this.jdField_b_of_type_Boolean = ((String)wwt.a().a("is_open_sharing", "0")).equals("1");
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  private void e()
  {
    wcj.a().a(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new vyz(this));
    this.c.setOnClickListener(new vza(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new vzb(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new vzc(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment = null;
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply = null;
    a(getContext().getString(2131635699));
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(PraisedUpdateEvents.class);
    return localArrayList;
  }
  
  public vzz a()
  {
    return this.jdField_a_of_type_Vzz;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Vzz != null) {
      this.jdField_a_of_type_Vzz.h();
    }
  }
  
  @SuppressLint({"DefaultLocale", "SetTextI18n"})
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (paramInt > 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(wbb.a(paramInt));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_Vzz != null) {
      this.jdField_a_of_type_Vzz.a(paramStFeed);
    }
  }
  
  public void a(Activity paramActivity, CertifiedAccountMeta.StFeed paramStFeed, wah paramwah)
  {
    this.jdField_a_of_type_Vzz = new vzz(paramActivity, false, paramStFeed, paramwah);
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && ((paramSimpleBaseEvent instanceof PraisedUpdateEvents)) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get().equals(((PraisedUpdateEvents)paramSimpleBaseEvent).mTargetFeedId)) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
      b(((PraisedUpdateEvents)paramSimpleBaseEvent).mPraisedStatus);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Vzz != null) {
      return this.jdField_a_of_type_Vzz.b();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      bbmy.a(getContext(), ajjy.a(2131636379), 0).a();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    DoLikeRequest localDoLikeRequest = new DoLikeRequest(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    VSNetworkHelper.a().a(localDoLikeRequest, new vzd(this));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Vzz != null) {
      this.jdField_a_of_type_Vzz.f();
    }
    wcj.a().b(this);
  }
  
  public void setCurrentFeed(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    b(paramStFeed.likeInfo.status.get());
    a(paramStFeed.commentCount.get());
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if ((this.jdField_b_of_type_Boolean) && (vvz.a(paramStFeed.status.get()))) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void setShareClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setTargetCommentAndReply(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment = paramStComment;
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply = paramStReply;
    paramStComment = a(paramStComment, paramStReply);
    if (!TextUtils.isEmpty(paramStComment)) {
      a(paramStComment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBottomBar
 * JD-Core Version:    0.7.0.1
 */