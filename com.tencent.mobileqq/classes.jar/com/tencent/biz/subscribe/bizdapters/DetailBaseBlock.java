package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.SubscribeConstants;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.comment.CommentPresenter;
import com.tencent.biz.subscribe.comment.CommentPresenter.CommentWindowListener;
import com.tencent.biz.subscribe.comment.OnCommentInputShowListener;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.part.extendsblock.SingleViewBlock;
import com.tencent.biz.subscribe.utils.GestureToLaunchPageHelper;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.HashMap;

public abstract class DetailBaseBlock
  extends SingleViewBlock
  implements CommentPresenter.CommentWindowListener, OnCommentInputShowListener
{
  protected static final String a = "DetailBaseBlock";
  private static long g;
  protected CommentBottomBar b;
  protected CertifiedAccountMeta.StFeed c;
  protected ExtraTypeInfo d;
  protected GestureToLaunchPageHelper e;
  protected PopupWindow f;
  private StatusView k;
  private CertifiedAccountMeta.StShare l;
  private String m;
  private CertifiedAccountMeta.StShare n;
  private SystemBarCompact o;
  private PopViewAnimationDrawableHelper p;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private View t;
  private boolean u;
  
  public DetailBaseBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private String a(ExtraTypeInfo paramExtraTypeInfo)
  {
    if (paramExtraTypeInfo != null)
    {
      int i = paramExtraTypeInfo.pageType;
      if (i != 7000)
      {
        if (i == 7002) {
          return "certified_account_personal_preload_loading";
        }
      }
      else {
        return "certified_account_preload_video";
      }
    }
    return "certified_account_preload_pic";
  }
  
  private boolean a(long paramLong, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramLong != 0L) {
      return true;
    }
    if (paramStFeed != null)
    {
      if (this.i) {
        return true;
      }
      if (SubscribeUtils.a(paramStFeed.status.get())) {
        return false;
      }
      return SubscribeUtils.a(paramStFeed.poster.attr.get()) ^ true;
    }
    return true;
  }
  
  public static boolean j()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - g <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "click too fast");
      }
      g = l1;
      return true;
    }
    g = l1;
    return false;
  }
  
  private void r()
  {
    this.b = new CommentBottomBar(A().getBaseActivity());
    Object localObject = new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(50.0F));
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    f();
    if ((A() instanceof SubscribeBaseFragment)) {
      this.b.setShareClickListener(new DetailBaseBlock.1(this));
    }
    localObject = new ViewStub(A().getBaseActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    localLayoutParams.setMargins(0, -ImmersiveUtils.dpToPx(50.0F), 0, 0);
    ((ViewStub)localObject).setLayoutParams(localLayoutParams);
    ((ViewStub)localObject).setFitsSystemWindows(true);
    if (this.b.getCommentPresenter() != null) {
      this.b.getCommentPresenter().b((ViewStub)localObject);
    }
    a((View)localObject);
    a(this.b);
    J().setPadding(0, 0, 0, ImmersiveUtils.dpToPx(50.0F));
  }
  
  protected void a(long paramLong, String paramString)
  {
    if ((h() != null) && (h().getVisibility() == 0)) {
      h().setVisibility(8);
    }
    if (this.k != null)
    {
      String str;
      if ((paramString == null) || (paramString.trim().length() != 0))
      {
        str = paramString;
        if (!VSNetworkHelper.isProtocolCache(paramString)) {}
      }
      else
      {
        str = null;
      }
      this.k.a(str);
    }
    paramString = this.b;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.c = paramStFeed;
    Object localObject = this.b;
    if (localObject != null) {
      ((CommentBottomBar)localObject).setCurrentFeed(paramStFeed);
    }
    b("share_key_subscribe_feeds_update", new BlockMerger.ShareData(paramStFeed));
    if ((A() instanceof SubscribeBaseFragment)) {
      ((SubscribeBaseFragment)A()).b(paramStFeed);
    }
    localObject = this.e;
    if (localObject != null) {
      ((GestureToLaunchPageHelper)localObject).a(paramStFeed.poster);
    }
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean) {}
  
  public void a(DialogInterface paramDialogInterface) {}
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.c = new CertifiedAccountMeta.StFeed();
      try
      {
        this.c = ((CertifiedAccountMeta.StFeed)this.c.mergeFrom(paramBundle.getByteArray("bundle_key_subscribe_feed_bytes_array")));
        this.d = ((ExtraTypeInfo)paramBundle.getSerializable("bundle_key_feed_extra_type_info"));
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
      b("share_key_subscribe_feeds_update", new BlockMerger.ShareData(this.c));
    }
    if (!this.q)
    {
      this.k = I().getStatusView();
      paramBundle = new StringBuilder();
      paramBundle.append(SubscribeUtils.b());
      paramBundle.append(File.separator);
      paramBundle.append(a(K()));
      paramBundle.append(".png");
      paramBundle = paramBundle.toString();
      this.k.b(paramBundle);
      QLog.d(a, 1, "showLoadingView!");
    }
    r();
    this.e = new GestureToLaunchPageHelper(G());
  }
  
  protected void a(View paramView)
  {
    b(paramView);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.t = paramView;
    this.u = paramBoolean;
  }
  
  public void a(SystemBarCompact paramSystemBarCompact)
  {
    this.o = paramSystemBarCompact;
  }
  
  public ShareInfoBean b(int paramInt)
  {
    ShareInfoBean localShareInfoBean = new ShareInfoBean();
    localShareInfoBean.b = this.c;
    localShareInfoBean.c = this.m;
    localShareInfoBean.d = this.n;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    localShareInfoBean.f = bool;
    localShareInfoBean.a = paramInt;
    return localShareInfoBean;
  }
  
  protected void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    Object localObject = this.k;
    if (localObject != null) {
      ((StatusView)localObject).b();
    }
    if ((h() != null) && (h().getVisibility() == 0)) {
      h().setVisibility(8);
    }
    if ((h() != null) && (this.c != null))
    {
      localObject = h();
      int i;
      if (paramStFeed.status.get() == 3) {
        i = 0;
      } else {
        i = 8;
      }
      ((View)localObject).setVisibility(i);
    }
    paramStFeed = this.b;
    if ((paramStFeed != null) && (paramStFeed.getVisibility() == 8)) {
      this.b.setVisibility(0);
    }
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    QLog.d(a, 2, "is not own startCount");
    if ((!SubscribeUtils.a(paramStFeed.poster.attr.get())) && (G() != null))
    {
      TimeAndCountHelper.a().a(G(), "subscribe_freshman_interaction_guide", 5000, new DetailBaseBlock.5(this, paramStFeed));
      G().runOnUiThread(new DetailBaseBlock.6(this));
      TimeAndCountHelper.a().a(G(), "subscribe_freshman_share_guide", 10000, new DetailBaseBlock.7(this));
    }
  }
  
  public GestureToLaunchPageHelper d()
  {
    return this.e;
  }
  
  protected void e()
  {
    this.q = true;
  }
  
  protected void f()
  {
    CommentBottomBar localCommentBottomBar = this.b;
    if (localCommentBottomBar == null) {
      return;
    }
    localCommentBottomBar.a(A().getBaseActivity(), this.c, new DetailBaseBlock.2(this), this.d);
    if (this.b.getCommentPresenter() != null)
    {
      this.b.getCommentPresenter().a(this);
      this.b.getCommentPresenter().a(this);
    }
  }
  
  protected void g()
  {
    StatusView localStatusView = this.k;
    if (localStatusView != null) {
      localStatusView.c();
    }
  }
  
  protected View h()
  {
    return null;
  }
  
  public boolean i()
  {
    CommentBottomBar localCommentBottomBar = this.b;
    if ((localCommentBottomBar != null) && (localCommentBottomBar.e())) {
      return true;
    }
    return super.i();
  }
  
  public CertifiedAccountMeta.StFeed k()
  {
    return this.c;
  }
  
  public void l()
  {
    AnimationDrawableFactory.a().a((String)SubscribeConstants.f.get("follow_guide_pics"), 4000, new DetailBaseBlock.3(this), true);
  }
  
  public void m()
  {
    AnimationDrawableFactory.a().a((String)SubscribeConstants.f.get("praise_guide_pics"), 4000, new DetailBaseBlock.4(this), true);
  }
  
  public void n()
  {
    PopViewAnimationDrawableHelper localPopViewAnimationDrawableHelper = this.p;
    if (localPopViewAnimationDrawableHelper != null) {
      localPopViewAnimationDrawableHelper.b();
    }
  }
  
  public void o() {}
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    paramRecyclerView = this.b;
    if (paramRecyclerView != null) {
      paramRecyclerView.d();
    }
  }
  
  public void p()
  {
    if (this.r) {
      m();
    }
    if (this.s) {
      l();
    }
  }
  
  public void q()
  {
    if (this.r) {
      m();
    }
    if (this.s) {
      l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.DetailBaseBlock
 * JD-Core Version:    0.7.0.1
 */