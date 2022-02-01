package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import UserGrowth.stFriendFeed;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.WSTipsInfoDialog;
import com.tencent.biz.pubaccount.weishi_new.follow.WSFriendItemDataUtil;
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.VerticalPageLauncher;
import com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedHolder;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSFriendFeedDataManager;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;

public class WSFollowFriendCollectionHolder
  extends BaseViewHolder<stFeed>
  implements View.OnClickListener
{
  private RecyclerView a;
  private LinearLayout b;
  private LinearLayoutManager c;
  private WSFollowAdapter d;
  private WSFollowFriendFeedAdapter e;
  private stFeed f;
  
  private WSFollowFriendCollectionHolder(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    super(paramViewGroup, 2131626458);
    this.d = paramWSFollowAdapter;
    d();
  }
  
  public static WSFollowFriendCollectionHolder a(ViewGroup paramViewGroup, WSFollowAdapter paramWSFollowAdapter)
  {
    return new WSFollowFriendCollectionHolder(paramViewGroup, paramWSFollowAdapter);
  }
  
  private void d()
  {
    this.b = ((LinearLayout)getView(2131434378));
    this.a = ((RecyclerView)getView(2131444434));
    TextView localTextView1 = (TextView)getView(2131450294);
    TextView localTextView2 = (TextView)getView(2131450295);
    ImageView localImageView = (ImageView)getView(2131450267);
    localTextView1.setVisibility(0);
    localImageView.setVisibility(0);
    localTextView1.setOnClickListener(this);
    localImageView.setOnClickListener(this);
    localTextView2.setText(2131918110);
    this.c = new LinearLayoutManager(getContext(), 0, false);
    this.a.setLayoutManager(this.c);
    this.a.setHasFixedSize(true);
    this.e = new WSFollowFriendFeedAdapter(getContext(), this.d);
    this.a.setAdapter(this.e);
    this.a.addItemDecoration(new WSItemDecoration());
    this.e.setOnItemClickListener(new WSFollowFriendCollectionHolder.1(this));
  }
  
  public RecyclerView a()
  {
    return this.a;
  }
  
  public void a(stFeed paramstFeed)
  {
    if (paramstFeed == null)
    {
      this.b.setVisibility(8);
      return;
    }
    this.f = paramstFeed;
    this.b.setVisibility(0);
    paramstFeed = paramstFeed.friendFeed;
    List localList = WSFriendItemDataUtil.a(paramstFeed);
    this.e.fillList(localList);
    if (paramstFeed != null) {
      WSFriendFeedDataManager.a().a(paramstFeed.attachInfo);
    }
  }
  
  public void b()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    int j = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
    int k = this.c.findLastVisibleItemPosition();
    int i = j;
    while (i <= k - j)
    {
      localObject = this.a.findViewHolderForAdapterPosition(i);
      if ((localObject instanceof BaseViewHolder)) {
        this.e.a((BaseViewHolder)localObject);
      }
      i += 1;
    }
  }
  
  public void c()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (this.d == null) {
        return;
      }
      int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
      int j = this.c.findLastVisibleItemPosition();
      if (i >= 0)
      {
        if (j >= this.d.getDataList().size()) {
          return;
        }
        while (i <= j)
        {
          localObject = this.a.findViewHolderForAdapterPosition(i);
          if ((localObject instanceof WSFollowFriendFeedHolder)) {
            ((WSFollowFriendFeedHolder)localObject).b();
          }
          i += 1;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131450267)
    {
      if (i != 2131450294) {
        return;
      }
      WSLauncher.VerticalPageLauncher.a(new WSVerticalPageOpenParams(getContext(), "friend_feed", "friend"));
      WSFollowBeaconReport.b();
      return;
    }
    paramView = new WSTipsInfoDialog(getContext());
    stFeed localstFeed = this.f;
    if ((localstFeed != null) && (localstFeed.friendFeed != null) && (!TextUtils.isEmpty(this.f.friendFeed.dialogTips))) {
      paramView.a(this.f.friendFeed.dialogTips);
    }
    paramView.show();
    WSFollowBeaconReport.a();
    WSFollowBeaconReport.d();
  }
  
  public void onViewDetachedFromWindow()
  {
    super.onViewDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFriendCollectionHolder
 * JD-Core Version:    0.7.0.1
 */