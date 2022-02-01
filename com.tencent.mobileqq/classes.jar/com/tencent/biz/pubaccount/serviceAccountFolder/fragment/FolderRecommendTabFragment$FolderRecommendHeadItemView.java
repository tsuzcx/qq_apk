package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedBaseHeaderView;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.widget.CirclePageIndicator;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.List;
import mqq.os.MqqHandler;

public class FolderRecommendTabFragment$FolderRecommendHeadItemView
  extends RelativeFeedBaseHeaderView
{
  private QQViewPager c;
  private CirclePageIndicator d;
  private FolderRecommendTabFragment.BannerPagerAdapter e;
  private RelativeLayout f;
  private ImageView g;
  private RecyclerView h;
  private ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter i;
  private LinearLayoutManager j;
  
  public FolderRecommendTabFragment$FolderRecommendHeadItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter localServiceAccountFoldAdapter = this.i;
    if (localServiceAccountFoldAdapter != null) {
      localServiceAccountFoldAdapter.b();
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.c = ((QQViewPager)paramView.findViewById(2131444421));
    this.c.requestParentDisallowInterecptTouchEvent(true);
    this.h = ((RecyclerView)paramView.findViewById(2131445667));
    this.i = new ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter(getContext(), this.h);
    this.i.a(SubscribeUtils.a());
    this.h.setAdapter(this.i);
    this.j = new LinearLayoutManager(getContext());
    this.j.setOrientation(0);
    this.h.setLayoutManager(this.j);
    this.i.a(FolderRecommendTabFragment.e());
    this.e = new FolderRecommendTabFragment.BannerPagerAdapter(null);
    this.c.setAdapter(this.e);
    this.d = ((CirclePageIndicator)paramView.findViewById(2131444422));
    this.d.setViewPager(this.c, 0);
    this.d.setBackgroundColor(0);
    this.d.setCirclePadding(AIOUtils.b(6.0F, paramContext.getResources()));
    this.d.setOnPageChangeListener(new FolderRecommendTabFragment.FolderRecommendHeadItemView.2(this));
    this.f = ((RelativeLayout)paramView.findViewById(2131432573));
    this.g = ((ImageView)paramView.findViewById(2131432572));
    paramContext = URLDrawable.getDrawable("https://sola.gtimg.cn/aoi/sola/20201119210154_6KQkLOzrpX.png", null);
    this.g.setImageDrawable(paramContext);
  }
  
  public void a(Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new FolderRecommendTabFragment.FolderRecommendHeadItemView.1(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((FolderRecommendTabFragment.k != null) && (FolderRecommendTabFragment.j != null))
    {
      if (FolderRecommendTabFragment.l == null) {
        return;
      }
      if (paramBoolean)
      {
        FolderRecommendTabFragment.m = paramString2;
        FolderRecommendTabFragment.k.setText(paramString1);
        FolderRecommendTabFragment.j.setVisibility(0);
        FolderRecommendTabFragment.l.setVisibility(0);
        MobileReportManager.getInstance().reportActionLive("", "25", "qq_live", "find_page", "bottom_button", 101, 1, System.currentTimeMillis(), "");
        return;
      }
      FolderRecommendTabFragment.j.setVisibility(8);
      FolderRecommendTabFragment.l.setVisibility(8);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.f.setVisibility(0);
    } else {
      this.f.setVisibility(8);
    }
    if (FolderRecommendTabFragment.i != null) {
      FolderRecommendTabFragment.i.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2131625662;
  }
  
  public void setAdapterData(Object paramObject)
  {
    paramObject = (List)paramObject;
    ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter localServiceAccountFoldAdapter = this.i;
    if (localServiceAccountFoldAdapter != null) {
      localServiceAccountFoldAdapter.a(paramObject);
    }
  }
  
  public void setData(Object paramObject)
  {
    super.setData(paramObject);
  }
  
  public void setTopBannerVisibility(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.h.getVisibility() == 8)
      {
        this.h.setVisibility(0);
        VSReporter.a("auth_follow", "service_exp", 0, 0, new String[0]);
      }
    }
    else if (this.h.getVisibility() == 0) {
      this.h.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView
 * JD-Core Version:    0.7.0.1
 */