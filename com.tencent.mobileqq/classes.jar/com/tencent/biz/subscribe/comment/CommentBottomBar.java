package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.CommentReplyEvent;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class CommentBottomBar
  extends LinearLayout
  implements SimpleEventReceiver
{
  public static final String a = "CommentBottomBar";
  private CertifiedAccountMeta.StComment jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private CertifiedAccountMeta.StReply jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CommentPresenter jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter;
  private boolean jdField_a_of_type_Boolean = true;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  
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
      if (paramStReply.postUser != null)
      {
        paramStReply = String.format(getContext().getString(2131692245), new Object[] { paramStReply.postUser.nick.get() });
        paramStComment = paramStReply;
        if (paramStReply.length() > 10)
        {
          paramStComment = paramStReply.substring(0, 10);
          paramStReply = new StringBuilder();
          paramStReply.append(paramStComment);
          paramStReply.append("...");
          paramStComment = paramStReply.toString();
        }
        return paramStComment;
      }
    }
    else if ((paramStComment != null) && (paramStComment.postUser != null))
    {
      paramStReply = String.format(getContext().getString(2131692245), new Object[] { paramStComment.postUser.nick.get() });
      paramStComment = paramStReply;
      if (paramStReply.length() > 10)
      {
        paramStComment = paramStReply.substring(0, 10);
        paramStReply = new StringBuilder();
        paramStReply.append(paramStComment);
        paramStReply.append("...");
        paramStComment = paramStReply.toString();
      }
      return paramStComment;
    }
    return null;
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      return;
    }
    ((ImageView)localObject).setBackgroundResource(2130839035);
    if (paramBoolean) {
      localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    } else {
      localObject = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    }
    ((ScaleAnimation)localObject).setDuration(1000L);
    ((ScaleAnimation)localObject).setFillAfter(true);
    ((ScaleAnimation)localObject).setRepeatCount(0);
    ((ScaleAnimation)localObject).setAnimationListener(new CommentBottomBar.6(this, paramBoolean));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
  }
  
  private void c(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    this.jdField_c_of_type_Boolean = bool;
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramInt == 0) {
      paramInt = 2130839026;
    } else {
      paramInt = 2130839027;
    }
    localImageView.setBackgroundResource(paramInt);
  }
  
  private void f()
  {
    setClickable(true);
    int i = 0;
    setOrientation(0);
    setBackgroundColor(-1);
    setGravity(16);
    LayoutInflater.from(getContext()).inflate(2131558775, this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369445));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379506));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369494));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369328));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369327));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369447));
    this.jdField_b_of_type_Boolean = ((String)VSConfigManager.a().a("is_open_sharing", "1")).equals("1");
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (!this.jdField_b_of_type_Boolean) {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  private void g()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new CommentBottomBar.1(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new CommentBottomBar.2(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new CommentBottomBar.3(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new CommentBottomBar.4(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment = null;
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply = null;
    a(getContext().getString(2131701707));
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130847752);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.8F, 1.0F, 0.8F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(600L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setRepeatCount(5);
    localScaleAnimation.setAnimationListener(new CommentBottomBar.7(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localScaleAnimation);
  }
  
  public CommentPresenter a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter;
  }
  
  public void a()
  {
    CommentPresenter localCommentPresenter = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter;
    if (localCommentPresenter != null) {
      localCommentPresenter.h();
    }
  }
  
  @SuppressLint({"DefaultLocale", "SetTextI18n"})
  public void a(int paramInt)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      return;
    }
    if (paramInt > 0)
    {
      localTextView.setText(Formatter.a(paramInt));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    localTextView.setText("");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    CommentPresenter localCommentPresenter = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter;
    if (localCommentPresenter != null) {
      localCommentPresenter.a(paramStFeed);
    }
  }
  
  public void a(Activity paramActivity, CertifiedAccountMeta.StFeed paramStFeed, CommentPresenter.GetFeedResponseListener paramGetFeedResponseListener)
  {
    a(paramActivity, paramStFeed, paramGetFeedResponseListener, null);
  }
  
  public void a(Activity paramActivity, CertifiedAccountMeta.StFeed paramStFeed, CommentPresenter.GetFeedResponseListener paramGetFeedResponseListener, ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter = new CommentPresenter(paramActivity, false, paramStFeed, paramGetFeedResponseListener, paramExtraTypeInfo);
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    if (localObject == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(getContext(), HardCodeUtil.a(2131702360), 0).a();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    localObject = new DoLikeRequest((CertifiedAccountMeta.StFeed)localObject);
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new CommentBottomBar.5(this));
  }
  
  @SuppressLint({"DefaultLocale", "SetTextI18n"})
  public void b(int paramInt)
  {
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      return;
    }
    if (paramInt > 0)
    {
      localTextView.setText(Formatter.a(paramInt));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    localTextView.setText("");
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean b()
  {
    CommentPresenter localCommentPresenter = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter;
    if (localCommentPresenter != null) {
      return localCommentPresenter.b();
    }
    return false;
  }
  
  public void c()
  {
    CommentPresenter localCommentPresenter = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter;
    if (localCommentPresenter != null) {
      localCommentPresenter.f();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public boolean c()
  {
    CommentPresenter localCommentPresenter = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter;
    return (localCommentPresenter != null) && (localCommentPresenter.c());
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839035);
  }
  
  public boolean d()
  {
    CommentPresenter localCommentPresenter = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter;
    return (localCommentPresenter != null) && (localCommentPresenter.d());
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
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    if ((localObject != null) && ((paramSimpleBaseEvent instanceof PraisedUpdateEvents)))
    {
      localObject = ((CertifiedAccountMeta.StFeed)localObject).id.get();
      PraisedUpdateEvents localPraisedUpdateEvents = (PraisedUpdateEvents)paramSimpleBaseEvent;
      if (((String)localObject).equals(localPraisedUpdateEvents.mTargetFeedId))
      {
        if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
          return;
        }
        c(localPraisedUpdateEvents.mPraisedStatus);
        b(localPraisedUpdateEvents.mPraisedNum);
        return;
      }
    }
    if ((paramSimpleBaseEvent instanceof CommentReplyEvent))
    {
      paramSimpleBaseEvent = (CommentReplyEvent)paramSimpleBaseEvent;
      setTargetCommentAndReply(paramSimpleBaseEvent.mStComment, paramSimpleBaseEvent.mStReply);
    }
  }
  
  public void setCurrentFeed(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    c(paramStFeed.likeInfo.status.get());
    a(paramStFeed.commentCount.get());
    b(paramStFeed.likeInfo.count.get());
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if ((this.jdField_b_of_type_Boolean) && (SubscribeUtils.a(paramStFeed.status.get())))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBottomBar
 * JD-Core Version:    0.7.0.1
 */