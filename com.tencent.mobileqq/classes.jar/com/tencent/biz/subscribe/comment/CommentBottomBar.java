package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import aaaf;
import aadu;
import aadv;
import aadw;
import aadx;
import aady;
import aadz;
import aaea;
import aaet;
import aafc;
import aafw;
import aavz;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anni;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.CommentReplyEvent;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import zwp;
import zwr;

public class CommentBottomBar
  extends LinearLayout
  implements zwr
{
  public static final String a;
  private CertifiedAccountMeta.StComment jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private CertifiedAccountMeta.StReply jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
  private aaet jdField_a_of_type_Aaet;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean = true;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = CommentBottomBar.class.getSimpleName();
  }
  
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
    f();
    g();
  }
  
  private String a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser == null) {
        break label162;
      }
      paramStReply = String.format(getContext().getString(2131692041), new Object[] { paramStReply.postUser.nick.get() });
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
      paramStReply = String.format(getContext().getString(2131692041), new Object[] { paramStComment.postUser.nick.get() });
      paramStComment = paramStReply;
    } while (paramStReply.length() <= 10);
    paramStComment = paramStReply.substring(0, 10);
    return paramStComment + "...";
    label162:
    return null;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839051);
    if (paramBoolean) {}
    for (ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);; localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F))
    {
      localScaleAnimation.setDuration(1000L);
      localScaleAnimation.setFillAfter(true);
      localScaleAnimation.setRepeatCount(0);
      localScaleAnimation.setAnimationListener(new aadz(this, paramBoolean));
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localScaleAnimation);
      return;
    }
  }
  
  private void c(int paramInt)
  {
    boolean bool = true;
    ImageView localImageView;
    if (paramInt == 1)
    {
      this.jdField_c_of_type_Boolean = bool;
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (paramInt != 0) {
        break label35;
      }
    }
    label35:
    for (paramInt = 2130839042;; paramInt = 2130839043)
    {
      localImageView.setBackgroundResource(paramInt);
      return;
      bool = false;
      break;
    }
  }
  
  private void f()
  {
    setClickable(true);
    setOrientation(0);
    setBackgroundColor(-1);
    setGravity(16);
    LayoutInflater.from(getContext()).inflate(2131558806, this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369228));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379504));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369286));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369090));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369089));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369230));
    this.jdField_b_of_type_Boolean = ((String)aavz.a().a("is_open_sharing", "1")).equals("1");
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  private void g()
  {
    zwp.a().a(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new aadu(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new aadv(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aadw(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aadx(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment = null;
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply = null;
    a(getContext().getString(2131700299));
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130847508);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.8F, 1.0F, 0.8F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(600L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setRepeatCount(5);
    localScaleAnimation.setAnimationListener(new aaea(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localScaleAnimation);
  }
  
  public aaet a()
  {
    return this.jdField_a_of_type_Aaet;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aaet != null) {
      this.jdField_a_of_type_Aaet.h();
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(aafw.a(paramInt));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_Aaet != null) {
      this.jdField_a_of_type_Aaet.a(paramStFeed);
    }
  }
  
  public void a(Activity paramActivity, CertifiedAccountMeta.StFeed paramStFeed, aafc paramaafc)
  {
    a(paramActivity, paramStFeed, paramaafc, null);
  }
  
  public void a(Activity paramActivity, CertifiedAccountMeta.StFeed paramStFeed, aafc paramaafc, ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_Aaet = new aaet(paramActivity, false, paramStFeed, paramaafc, paramExtraTypeInfo);
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
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(getContext(), anni.a(2131700978), 0).a();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    DoLikeRequest localDoLikeRequest = new DoLikeRequest(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    VSNetworkHelper.a().a(localDoLikeRequest, new aady(this));
  }
  
  @SuppressLint({"DefaultLocale", "SetTextI18n"})
  public void b(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (paramInt > 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(aafw.a(paramInt));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aaet != null) {
      return this.jdField_a_of_type_Aaet.b();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aaet != null) {
      this.jdField_a_of_type_Aaet.f();
    }
    zwp.a().b(this);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Aaet != null) && (this.jdField_a_of_type_Aaet.c());
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839051);
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Aaet != null) && (this.jdField_a_of_type_Aaet.d());
  }
  
  public void e()
  {
    a(false);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(PraisedUpdateEvents.class);
    localArrayList.add(CommentReplyEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && ((paramSimpleBaseEvent instanceof PraisedUpdateEvents)) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get().equals(((PraisedUpdateEvents)paramSimpleBaseEvent).mTargetFeedId))) {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        paramSimpleBaseEvent = (PraisedUpdateEvents)paramSimpleBaseEvent;
        c(paramSimpleBaseEvent.mPraisedStatus);
        b(paramSimpleBaseEvent.mPraisedNum);
      }
    }
    while (!(paramSimpleBaseEvent instanceof CommentReplyEvent)) {
      return;
    }
    paramSimpleBaseEvent = (CommentReplyEvent)paramSimpleBaseEvent;
    setTargetCommentAndReply(paramSimpleBaseEvent.mStComment, paramSimpleBaseEvent.mStReply);
  }
  
  public void setCurrentFeed(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    c(paramStFeed.likeInfo.status.get());
    a(paramStFeed.commentCount.get());
    b(paramStFeed.likeInfo.count.get());
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if ((this.jdField_b_of_type_Boolean) && (aaaf.a(paramStFeed.status.get()))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBottomBar
 * JD-Core Version:    0.7.0.1
 */