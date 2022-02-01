package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_COMM.COMM.StCommonExt;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.subscribe.SubscribeConstants;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.beans.RecommendInfoItem;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import mqq.app.AppRuntime;

public class FollowedRecommendBannerView
  extends LinearLayout
  implements FollowedRecommendBannerModel.ResultListener
{
  private RecyclerView a;
  private TextView b;
  private ImageView c;
  private FollowedRecommendBannerModel d;
  private RecommendBannerContentAdaper e;
  private String f;
  
  public FollowedRecommendBannerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public FollowedRecommendBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void c()
  {
    StringBuilder localStringBuilder = new StringBuilder(SubscribeConstants.b(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    if (getAttachInfo() != null) {
      try
      {
        localStringBuilder.append(URLEncoder.encode(getAttachInfo().attachInfo.get(), "UTF-8"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    } else {
      QLog.d("FollowedRecommendBanner", 0, "jump more recommend H5 page with no attach info!");
    }
    VSReporter.b(this.f, "auth_person", "reco_more", 0, 0, new String[0]);
    SubscribeLaucher.a(localStringBuilder.toString());
  }
  
  private void d()
  {
    setVisibility(0);
    Object localObject = (View)getParent();
    if (localObject != null) {
      measure(View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    localObject = ValueAnimator.ofInt(new int[] { 0, getMeasuredHeight() });
    ((ValueAnimator)localObject).addUpdateListener(new FollowedRecommendBannerView.RecommendBannerAnimatorListener(this, this, null));
    ((ValueAnimator)localObject).addListener(new FollowedRecommendBannerView.4(this));
    ((ValueAnimator)localObject).start();
    VSReporter.a(this.f, "auth_person", "reco_exp", 0, 0, new String[0]);
  }
  
  private COMM.StCommonExt getAttachInfo()
  {
    FollowedRecommendBannerModel localFollowedRecommendBannerModel = this.d;
    if (localFollowedRecommendBannerModel != null) {
      return localFollowedRecommendBannerModel.a();
    }
    return null;
  }
  
  public void a()
  {
    if (getVisibility() == 8)
    {
      clearAnimation();
      return;
    }
    Object localObject = (View)getParent();
    if (localObject != null) {
      measure(View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    localObject = ValueAnimator.ofInt(new int[] { getMeasuredHeight(), 0 });
    ((ValueAnimator)localObject).addUpdateListener(new FollowedRecommendBannerView.RecommendBannerAnimatorListener(this, this, null));
    ((ValueAnimator)localObject).addListener(new FollowedRecommendBannerView.5(this));
    ((ValueAnimator)localObject).start();
    VSReporter.a(this.f, "auth_person", "reco_pack_up", 0, 0, new String[0]);
  }
  
  protected void a(Context paramContext)
  {
    setOrientation(1);
    inflate(paramContext, 2131624365, this);
    this.a = ((RecyclerView)findViewById(2131429281));
    this.b = ((TextView)findViewById(2131438884));
    this.c = ((ImageView)findViewById(2131436614));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.d = new FollowedRecommendBannerModel();
    this.d.a(this);
    this.a.setLayoutManager(paramContext);
    this.a.addItemDecoration(new RecommendBannerItemDecoration());
    this.a.setItemAnimator(new DefaultItemAnimator());
    this.e = new TopRecommendBannerAdapter(this.a);
    this.e.a(true);
    this.a.setAdapter(this.e);
    this.e.a(new FollowedRecommendBannerView.1(this));
    this.b.setOnClickListener(new FollowedRecommendBannerView.2(this));
    this.c.setOnClickListener(new FollowedRecommendBannerView.3(this));
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
    paramString = this.d;
    if (paramString != null) {
      paramString.a(this.f);
    }
  }
  
  public void a(List<RecommendInfoItem> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      RecommendBannerContentAdaper localRecommendBannerContentAdaper = this.e;
      if (localRecommendBannerContentAdaper != null) {
        localRecommendBannerContentAdaper.a(null, paramList);
      }
      d();
    }
  }
  
  public boolean b()
  {
    return getVisibility() == 0;
  }
  
  protected void onDetachedFromWindow()
  {
    clearAnimation();
    super.onDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView
 * JD-Core Version:    0.7.0.1
 */