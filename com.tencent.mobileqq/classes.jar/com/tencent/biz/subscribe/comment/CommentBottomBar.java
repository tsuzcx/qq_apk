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
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private CommentPresenter h;
  private CertifiedAccountMeta.StFeed i;
  private CertifiedAccountMeta.StComment j;
  private CertifiedAccountMeta.StReply k;
  private boolean l = true;
  private View.OnClickListener m;
  private boolean n;
  private boolean o;
  
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
    j();
    k();
  }
  
  private String a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser != null)
      {
        paramStReply = String.format(getContext().getString(2131889232), new Object[] { paramStReply.postUser.nick.get() });
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
      paramStReply = String.format(getContext().getString(2131889232), new Object[] { paramStComment.postUser.nick.get() });
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
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    ((ImageView)localObject).setBackgroundResource(2130839189);
    if (paramBoolean) {
      localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    } else {
      localObject = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    }
    ((ScaleAnimation)localObject).setDuration(1000L);
    ((ScaleAnimation)localObject).setFillAfter(true);
    ((ScaleAnimation)localObject).setRepeatCount(0);
    ((ScaleAnimation)localObject).setAnimationListener(new CommentBottomBar.6(this, paramBoolean));
    this.b.startAnimation((Animation)localObject);
  }
  
  private void c(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    this.o = bool;
    ImageView localImageView = this.c;
    if (paramInt == 0) {
      paramInt = 2130839180;
    } else {
      paramInt = 2130839181;
    }
    localImageView.setBackgroundResource(paramInt);
  }
  
  private void j()
  {
    setClickable(true);
    int i1 = 0;
    setOrientation(0);
    setBackgroundColor(-1);
    setGravity(16);
    LayoutInflater.from(getContext()).inflate(2131624395, this);
    this.c = ((ImageView)findViewById(2131436501));
    this.e = ((TextView)findViewById(2131448254));
    this.b = ((ImageView)findViewById(2131436572));
    this.d = ((ImageView)findViewById(2131436329));
    this.f = ((TextView)findViewById(2131436328));
    this.g = ((TextView)findViewById(2131436503));
    this.n = ((String)VSConfigManager.a().a("is_open_sharing", "1")).equals("1");
    ImageView localImageView = this.b;
    if (!this.n) {
      i1 = 8;
    }
    localImageView.setVisibility(i1);
  }
  
  private void k()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    this.c.setOnClickListener(new CommentBottomBar.1(this));
    this.d.setOnClickListener(new CommentBottomBar.2(this));
    this.b.setOnClickListener(new CommentBottomBar.3(this));
    this.e.setOnClickListener(new CommentBottomBar.4(this));
  }
  
  private void l()
  {
    this.j = null;
    this.k = null;
    a(getContext().getString(2131899728));
  }
  
  private void m()
  {
    this.b.setBackgroundResource(2130849413);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.8F, 1.0F, 0.8F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(600L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setRepeatCount(5);
    localScaleAnimation.setAnimationListener(new CommentBottomBar.7(this));
    this.b.startAnimation(localScaleAnimation);
  }
  
  public void a()
  {
    CommentPresenter localCommentPresenter = this.h;
    if (localCommentPresenter != null) {
      localCommentPresenter.q();
    }
  }
  
  @SuppressLint({"DefaultLocale", "SetTextI18n"})
  public void a(int paramInt)
  {
    TextView localTextView = this.f;
    if (localTextView == null) {
      return;
    }
    if (paramInt > 0)
    {
      localTextView.setText(Formatter.a(paramInt));
      this.f.setVisibility(0);
      return;
    }
    localTextView.setText("");
    this.f.setVisibility(8);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    CommentPresenter localCommentPresenter = this.h;
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
    this.h = new CommentPresenter(paramActivity, false, paramStFeed, paramGetFeedResponseListener, paramExtraTypeInfo);
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.e;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
  }
  
  public void b()
  {
    Object localObject = this.i;
    if (localObject == null) {
      return;
    }
    if (!this.l)
    {
      QQToast.makeText(getContext(), HardCodeUtil.a(2131900364), 0).show();
      return;
    }
    this.l = false;
    localObject = new DoLikeRequest((CertifiedAccountMeta.StFeed)localObject);
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new CommentBottomBar.5(this));
  }
  
  @SuppressLint({"DefaultLocale", "SetTextI18n"})
  public void b(int paramInt)
  {
    TextView localTextView = this.g;
    if (localTextView == null) {
      return;
    }
    if (paramInt > 0)
    {
      localTextView.setText(Formatter.a(paramInt));
      this.g.setVisibility(0);
      return;
    }
    localTextView.setText("");
    this.g.setVisibility(8);
  }
  
  public boolean c()
  {
    return this.o;
  }
  
  public void d()
  {
    CommentPresenter localCommentPresenter = this.h;
    if (localCommentPresenter != null) {
      localCommentPresenter.h();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public boolean e()
  {
    CommentPresenter localCommentPresenter = this.h;
    if (localCommentPresenter != null) {
      return localCommentPresenter.n();
    }
    return false;
  }
  
  public void f()
  {
    this.b.clearAnimation();
    this.b.setBackgroundResource(2130839189);
  }
  
  public void g()
  {
    a(false);
  }
  
  public CommentPresenter getCommentPresenter()
  {
    return this.h;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(PraisedUpdateEvents.class);
    localArrayList.add(CommentReplyEvent.class);
    return localArrayList;
  }
  
  public boolean h()
  {
    CommentPresenter localCommentPresenter = this.h;
    return (localCommentPresenter != null) && (localCommentPresenter.o());
  }
  
  public boolean i()
  {
    CommentPresenter localCommentPresenter = this.h;
    return (localCommentPresenter != null) && (localCommentPresenter.p());
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    Object localObject = this.i;
    if ((localObject != null) && ((paramSimpleBaseEvent instanceof PraisedUpdateEvents)))
    {
      localObject = ((CertifiedAccountMeta.StFeed)localObject).id.get();
      PraisedUpdateEvents localPraisedUpdateEvents = (PraisedUpdateEvents)paramSimpleBaseEvent;
      if (((String)localObject).equals(localPraisedUpdateEvents.mTargetFeedId))
      {
        if (this.c == null) {
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
    this.i = paramStFeed;
    c(paramStFeed.likeInfo.status.get());
    a(paramStFeed.commentCount.get());
    b(paramStFeed.likeInfo.count.get());
    if (this.b != null)
    {
      if ((this.n) && (SubscribeUtils.a(paramStFeed.status.get())))
      {
        this.b.setVisibility(0);
        return;
      }
      this.b.setVisibility(8);
    }
  }
  
  public void setShareClickListener(View.OnClickListener paramOnClickListener)
  {
    this.m = paramOnClickListener;
  }
  
  public void setTargetCommentAndReply(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    this.j = paramStComment;
    this.k = paramStReply;
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