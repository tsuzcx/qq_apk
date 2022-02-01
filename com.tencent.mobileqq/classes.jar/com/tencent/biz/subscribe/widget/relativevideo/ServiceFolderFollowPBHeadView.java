package com.tencent.biz.subscribe.widget.relativevideo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import java.util.List;

public class ServiceFolderFollowPBHeadView
  extends RelativeFeedBaseHeaderView
{
  private static String c = "ServiceFolderFollowPBHeadView";
  private RecyclerView d;
  private LinearLayout e;
  private TextView f;
  private TextView g;
  private ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter h;
  private LinearLayoutManager i;
  private boolean j = false;
  private String k;
  private RelativeLayout l;
  private ImageView m;
  private ViewPager n;
  
  public ServiceFolderFollowPBHeadView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter localServiceAccountFoldAdapter = this.h;
    if (localServiceAccountFoldAdapter != null) {
      localServiceAccountFoldAdapter.b();
    }
  }
  
  public void a(int paramInt)
  {
    this.f.post(new ServiceFolderFollowPBHeadView.2(this, paramInt));
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.j = SubscribeUtils.a();
    this.d = ((RecyclerView)paramView.findViewById(2131445667));
    this.e = ((LinearLayout)paramView.findViewById(2131445664));
    this.f = ((TextView)paramView.findViewById(2131445665));
    this.g = ((TextView)paramView.findViewById(2131445660));
    this.h = new ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter(getContext(), this.d);
    this.h.a(this.j);
    this.d.setAdapter(this.h);
    this.h.a();
    this.i = new LinearLayoutManager(getContext());
    this.i.setOrientation(0);
    this.d.setLayoutManager(this.i);
    this.l = ((RelativeLayout)paramView.findViewById(2131432573));
    this.m = ((ImageView)paramView.findViewById(2131432572));
    paramContext = URLDrawable.getDrawable("https://sola.gtimg.cn/aoi/sola/20201119210154_6KQkLOzrpX.png", null);
    this.m.setImageDrawable(paramContext);
    if ((this.e.getBackground() != null) && ((this.e.getBackground() instanceof GradientDrawable))) {
      ((GradientDrawable)this.e.getBackground()).setColor(Color.parseColor("#00cafc"));
    }
    this.e.setOnClickListener(new ServiceFolderFollowPBHeadView.1(this));
    if (this.j) {
      this.g.setTextColor(-10132123);
    }
  }
  
  protected void a(Object paramObject) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.g.setText(paramString);
      }
      this.l.setVisibility(0);
      this.g.setVisibility(0);
      return;
    }
    this.l.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  public int getLayoutId()
  {
    return 2131625665;
  }
  
  public void setData(Object paramObject)
  {
    paramObject = (List)paramObject;
    ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter localServiceAccountFoldAdapter = this.h;
    if (localServiceAccountFoldAdapter != null) {
      localServiceAccountFoldAdapter.a(paramObject);
    }
  }
  
  public void setDragHost(DragFrameLayout paramDragFrameLayout)
  {
    ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter localServiceAccountFoldAdapter = this.h;
    if (localServiceAccountFoldAdapter != null) {
      localServiceAccountFoldAdapter.a(paramDragFrameLayout);
    }
  }
  
  public void setJumpWebMessageListUrl(String paramString)
  {
    this.k = paramString;
  }
  
  public void setTopBannerVisibility(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.d.getVisibility() == 8)
      {
        this.d.setVisibility(0);
        VSReporter.a("auth_follow", "service_exp", 0, 0, new String[0]);
      }
    }
    else if (this.d.getVisibility() == 0) {
      this.d.setVisibility(8);
    }
  }
  
  public void setmFolderViewPager(ViewPager paramViewPager)
  {
    this.n = paramViewPager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView
 * JD-Core Version:    0.7.0.1
 */