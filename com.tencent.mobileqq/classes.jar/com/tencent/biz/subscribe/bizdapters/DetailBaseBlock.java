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
  private static long jdField_a_of_type_Long = 0L;
  protected static final String a = "DetailBaseBlock";
  protected CertifiedAccountMeta.StFeed a;
  private CertifiedAccountMeta.StShare jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
  private View jdField_a_of_type_AndroidViewView;
  protected PopupWindow a;
  private PopViewAnimationDrawableHelper jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper;
  protected ExtraTypeInfo a;
  protected CommentBottomBar a;
  protected GestureToLaunchPageHelper a;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private CertifiedAccountMeta.StShare jdField_b_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
  private String jdField_b_of_type_JavaLangString;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f;
  
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
      if (this.jdField_b_of_type_Boolean) {
        return true;
      }
      if (SubscribeUtils.a(paramStFeed.status.get())) {
        return false;
      }
      return SubscribeUtils.a(paramStFeed.poster.attr.get()) ^ true;
    }
    return true;
  }
  
  public static boolean c()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "click too fast");
      }
      jdField_a_of_type_Long = l;
      return true;
    }
    jdField_a_of_type_Long = l;
    return false;
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar = new CommentBottomBar(a().getBaseActivity());
    Object localObject = new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(50.0F));
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
    c();
    if ((a() instanceof SubscribeBaseFragment)) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setShareClickListener(new DetailBaseBlock.1(this));
    }
    localObject = new ViewStub(a().getBaseActivity());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    localLayoutParams.setMargins(0, -ImmersiveUtils.dpToPx(50.0F), 0, 0);
    ((ViewStub)localObject).setLayoutParams(localLayoutParams);
    ((ViewStub)localObject).setFitsSystemWindows(true);
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a() != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().b((ViewStub)localObject);
    }
    a((View)localObject);
    a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
    a().setPadding(0, 0, 0, ImmersiveUtils.dpToPx(50.0F));
  }
  
  public CertifiedAccountMeta.StFeed a()
  {
    return this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  }
  
  protected View a()
  {
    return null;
  }
  
  public ShareInfoBean a(int paramInt)
  {
    ShareInfoBean localShareInfoBean = new ShareInfoBean();
    localShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    localShareInfoBean.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare = this.jdField_b_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    localShareInfoBean.jdField_a_of_type_Boolean = bool;
    localShareInfoBean.jdField_a_of_type_Int = paramInt;
    return localShareInfoBean;
  }
  
  public GestureToLaunchPageHelper a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeUtilsGestureToLaunchPageHelper;
  }
  
  protected void a(long paramLong, String paramString)
  {
    if ((a() != null) && (a().getVisibility() == 0)) {
      a().setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null)
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
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a(str);
    }
    paramString = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
    if (localObject != null) {
      ((CommentBottomBar)localObject).setCurrentFeed(paramStFeed);
    }
    b("share_key_subscribe_feeds_update", new BlockMerger.ShareData(paramStFeed));
    if ((a() instanceof SubscribeBaseFragment)) {
      ((SubscribeBaseFragment)a()).b(paramStFeed);
    }
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeUtilsGestureToLaunchPageHelper;
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
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = new CertifiedAccountMeta.StFeed();
      try
      {
        this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.mergeFrom(paramBundle.getByteArray("bundle_key_subscribe_feed_bytes_array")));
        this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)paramBundle.getSerializable("bundle_key_feed_extra_type_info"));
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
      b("share_key_subscribe_feeds_update", new BlockMerger.ShareData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed));
    }
    if (!this.c)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = a().a();
      paramBundle = new StringBuilder();
      paramBundle.append(SubscribeUtils.a());
      paramBundle.append(File.separator);
      paramBundle.append(a(a()));
      paramBundle.append(".png");
      paramBundle = paramBundle.toString();
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.b(paramBundle);
      QLog.d(jdField_a_of_type_JavaLangString, 1, "showLoadingView!");
    }
    k();
    this.jdField_a_of_type_ComTencentBizSubscribeUtilsGestureToLaunchPageHelper = new GestureToLaunchPageHelper(a());
  }
  
  protected void a(View paramView)
  {
    b(paramView);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.f = paramBoolean;
  }
  
  public void a(SystemBarCompact paramSystemBarCompact)
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = paramSystemBarCompact;
  }
  
  protected void b()
  {
    this.c = true;
  }
  
  protected void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
    if (localObject != null) {
      ((StatusView)localObject).c();
    }
    if ((a() != null) && (a().getVisibility() == 0)) {
      a().setVisibility(8);
    }
    if ((a() != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
    {
      localObject = a();
      int i;
      if (paramStFeed.status.get() == 3) {
        i = 0;
      } else {
        i = 8;
      }
      ((View)localObject).setVisibility(i);
    }
    paramStFeed = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
    if ((paramStFeed != null) && (paramStFeed.getVisibility() == 8)) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.setVisibility(0);
    }
  }
  
  public boolean b()
  {
    CommentBottomBar localCommentBottomBar = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
    if ((localCommentBottomBar != null) && (localCommentBottomBar.b())) {
      return true;
    }
    return super.b();
  }
  
  protected void c()
  {
    CommentBottomBar localCommentBottomBar = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
    if (localCommentBottomBar == null) {
      return;
    }
    localCommentBottomBar.a(a().getBaseActivity(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new DetailBaseBlock.2(this), this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a() != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().a(this);
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a().a(this);
    }
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "is not own startCount");
    if ((!SubscribeUtils.a(paramStFeed.poster.attr.get())) && (a() != null))
    {
      TimeAndCountHelper.a().a(a(), "subscribe_freshman_interaction_guide", 5000, new DetailBaseBlock.5(this, paramStFeed));
      a().runOnUiThread(new DetailBaseBlock.6(this));
      TimeAndCountHelper.a().a(a(), "subscribe_freshman_share_guide", 10000, new DetailBaseBlock.7(this));
    }
  }
  
  protected void d()
  {
    StatusView localStatusView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
    if (localStatusView != null) {
      localStatusView.d();
    }
  }
  
  public void e()
  {
    AnimationDrawableFactory.a().a((String)SubscribeConstants.b.get("follow_guide_pics"), 4000, new DetailBaseBlock.3(this), true);
  }
  
  public void f()
  {
    AnimationDrawableFactory.a().a((String)SubscribeConstants.b.get("praise_guide_pics"), 4000, new DetailBaseBlock.4(this), true);
  }
  
  public void g()
  {
    PopViewAnimationDrawableHelper localPopViewAnimationDrawableHelper = this.jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper;
    if (localPopViewAnimationDrawableHelper != null) {
      localPopViewAnimationDrawableHelper.b();
    }
  }
  
  public void h() {}
  
  public void i()
  {
    if (this.d) {
      f();
    }
    if (this.e) {
      e();
    }
  }
  
  public void j()
  {
    if (this.d) {
      f();
    }
    if (this.e) {
      e();
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    paramRecyclerView = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar;
    if (paramRecyclerView != null) {
      paramRecyclerView.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.DetailBaseBlock
 * JD-Core Version:    0.7.0.1
 */