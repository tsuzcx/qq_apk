package com.tencent.biz.qqstory.shareGroup.infocard;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.HotSortVideoManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler;
import com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetVideoByHotSortEvent;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler.GetShareGroupInfoEvent;
import com.tencent.biz.qqstory.network.handler.GetUserGroupUnionIDHandler;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqLoadMoreVideoList;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.shareGroup.addvideo.AddVideoController;
import com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDataPuller;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter.PublishVideoItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.TranslucentTitleBarHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QQStoryShareGroupProfileActivity
  extends QQStoryBaseActivity
{
  int A = 0;
  boolean B = false;
  boolean C = false;
  boolean D = false;
  boolean E = false;
  boolean F = false;
  boolean G = false;
  StoryShare H;
  private boolean I = false;
  LoadMoreLayout a;
  RelativeLayout b;
  TextView c;
  ShareGroupsListView d;
  ShareGroupsListAdapter e;
  View f;
  ImageView g;
  TextView h;
  ImageButton i;
  TextView j;
  ImmersiveTitleBar2 k;
  ImageView l;
  TextView m;
  QQStoryShareGroupHelper n;
  TranslucentTitleBarHelper o;
  ShareGroupDataPuller p;
  GetHotSortVideoHandler q;
  boolean r = false;
  String s;
  String t;
  ShareGroupItem u;
  String v;
  int w;
  int x;
  int y;
  String z;
  
  private List<VideoCollectionItem> a(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localVideoCollectionItem1 = (VideoCollectionItem)paramList.next();
      if (localVideoCollectionItem1.collectionCount > 0)
      {
        localVideoCollectionItem2 = new VideoCollectionItem();
        localVideoCollectionItem2.copy(localVideoCollectionItem1);
        localArrayList.add(localVideoCollectionItem2);
      }
    }
    if (!paramBoolean) {
      return localArrayList;
    }
    if (localArrayList.size() < 2) {
      return localArrayList;
    }
    paramList = (VideoCollectionItem)localArrayList.get(0);
    VideoCollectionItem localVideoCollectionItem1 = (VideoCollectionItem)localArrayList.get(1);
    VideoCollectionItem localVideoCollectionItem2 = VideoCollectionItem.getCurrentYearFakeItem(this.t);
    VideoCollectionItem localVideoCollectionItem3 = VideoCollectionItem.getTodayFakeItem(this.t);
    if (paramList.collectionType != 0)
    {
      localArrayList.add(0, localVideoCollectionItem2);
      if (!DateUtils.g(paramList.collectionTime))
      {
        localArrayList.add(1, localVideoCollectionItem3);
        return localArrayList;
      }
      paramList.collectionVideoUIItemList.add(0, new MemoriesInnerListAdapter.PublishVideoItem());
      return localArrayList;
    }
    if (DateUtils.f(paramList.collectionTime))
    {
      if (DateUtils.g(localVideoCollectionItem1.collectionTime))
      {
        localVideoCollectionItem1.collectionVideoUIItemList.add(0, new MemoriesInnerListAdapter.PublishVideoItem());
        return localArrayList;
      }
      localArrayList.add(1, localVideoCollectionItem3);
      return localArrayList;
    }
    localArrayList.add(0, localVideoCollectionItem2);
    localArrayList.add(1, localVideoCollectionItem3);
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    if (this.I)
    {
      this.d.setSelection(paramInt);
      return;
    }
    if ((paramInt < this.d.getFirstVisiblePosition()) || (paramInt > this.d.getLastVisiblePosition()))
    {
      this.d.setSelection(paramInt);
      this.I = true;
    }
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    paramContext.startActivity(b(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3));
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    int i2;
    if (this.y == 1) {
      i2 = 3;
    } else if (this.u.isPublic()) {
      i2 = 2;
    } else {
      i2 = 1;
    }
    int i3;
    if (this.y == 1) {
      i3 = 2;
    } else {
      i3 = 1;
    }
    int i4 = paramIntent.getIntExtra("totalPublishVideoCount", 1);
    boolean bool1 = paramIntent.getBooleanExtra("isLocalPublish", false);
    boolean bool2 = paramIntent.getBooleanExtra("isTakePhoto", false);
    int i1;
    if (paramIntent.getBooleanExtra("isAddFromExist", false)) {
      i1 = 5;
    } else if (bool1)
    {
      if (bool2) {
        i1 = 2;
      } else {
        i1 = 1;
      }
    }
    else if (bool2) {
      i1 = 4;
    } else {
      i1 = 3;
    }
    StoryReportor.a("share_story", "clk_add_suc", i2, i3, new String[] { paramString, String.valueOf(i4), String.valueOf(i1) });
    if ((this.w == 8) && (this.A == 0))
    {
      paramIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      paramIntent.putExtra("uin", this.v);
      paramIntent.putExtra("uintype", 1);
      paramIntent.putExtra("uinname", this.u.name);
      paramIntent.addFlags(71303168);
      super.startActivity(paramIntent);
      return;
    }
    if ((this.w != 9) && (this.A != 9))
    {
      paramIntent = StoryTransitionActivity.b(this);
      paramIntent.addFlags(71303168);
      super.startActivity(paramIntent);
      return;
    }
    paramIntent = new Intent(this, TroopStoryMainActivity.class);
    paramIntent.addFlags(71303168);
    startActivity(paramIntent);
  }
  
  private void a(DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    List localList = a(paramGetCollectionListEvent.e, paramGetCollectionListEvent.c);
    if (paramGetCollectionListEvent.c)
    {
      if ((paramGetCollectionListEvent.g.isSuccess()) && (paramGetCollectionListEvent.h))
      {
        this.d.f.a(localList, paramGetCollectionListEvent.a);
        if (!paramGetCollectionListEvent.b) {
          this.r = true;
        }
        this.d.setLoadMoreState(true, paramGetCollectionListEvent.a);
      }
      this.d.a(paramGetCollectionListEvent.g.isSuccess(), paramGetCollectionListEvent.a);
      if (!paramGetCollectionListEvent.b)
      {
        if (this.d.f.isEmpty())
        {
          this.f.setVisibility(0);
          this.d.setEnabled(false);
        }
        else
        {
          this.f.setVisibility(8);
          this.d.setEnabled(true);
        }
        this.a.setState(0);
        return;
      }
      if (!this.d.f.isEmpty()) {
        this.a.setState(0);
      }
    }
    else
    {
      if ((paramGetCollectionListEvent.g.isSuccess()) && (paramGetCollectionListEvent.h)) {
        this.d.f.c(localList, paramGetCollectionListEvent.a);
      }
      this.d.setLoadMoreState(paramGetCollectionListEvent.g.isSuccess(), paramGetCollectionListEvent.a);
    }
  }
  
  private void a(GetHotSortVideoHandler.GetVideoByHotSortEvent paramGetVideoByHotSortEvent)
  {
    if (!paramGetVideoByHotSortEvent.d) {
      if ((paramGetVideoByHotSortEvent.a != null) && (paramGetVideoByHotSortEvent.a.size() > 0))
      {
        if (paramGetVideoByHotSortEvent.c) {
          this.d.f.f(paramGetVideoByHotSortEvent.a, paramGetVideoByHotSortEvent.b);
        } else {
          this.d.f.e(paramGetVideoByHotSortEvent.a, paramGetVideoByHotSortEvent.b);
        }
      }
      else if (!paramGetVideoByHotSortEvent.c)
      {
        this.f.setVisibility(0);
        this.d.setEnabled(false);
        this.d.f.b();
      }
    }
    this.a.setState(0);
    this.d.setLoadMoreState(true, paramGetVideoByHotSortEvent.b);
    this.d.a(paramGetVideoByHotSortEvent.g.isSuccess(), paramGetVideoByHotSortEvent.b);
  }
  
  private void a(GetShareGroupInfoHandler.GetShareGroupInfoEvent paramGetShareGroupInfoEvent)
  {
    QQToast.makeText(this, 1, HardCodeUtil.a(2131908657), 1).show();
  }
  
  private void a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null) {
      return;
    }
    this.u = paramShareGroupItem;
    this.a.setState(0);
    if ((!paramShareGroupItem.isInvalid()) && (paramShareGroupItem.type != 2))
    {
      int i1;
      if ((paramShareGroupItem.type == 2) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (!this.E)
      {
        boolean bool;
        if ((paramShareGroupItem.type == 2) && (paramShareGroupItem.isPublic())) {
          bool = true;
        } else {
          bool = false;
        }
        this.G = bool;
      }
      if (i1 != 0)
      {
        this.d.setVisibility(8);
        this.f.setVisibility(8);
        this.l.setVisibility(8);
        this.c.setText(QQStoryConstant.a);
        this.o.a(true, false);
        this.i.setVisibility(8);
      }
      else
      {
        this.d.setVisibility(0);
        this.i.setVisibility(0);
        this.o.a(false, false);
        if (!this.E)
        {
          this.E = true;
          b(true);
        }
        b(paramShareGroupItem);
      }
      if (!this.F)
      {
        this.F = true;
        i1 = paramShareGroupItem.getReportGroupProp();
        int i2 = StoryApi.d(2131492921);
        paramShareGroupItem = paramShareGroupItem.getReportUserType();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.w);
        ((StringBuilder)localObject).append("");
        StoryReportor.a("share_story", "exp_data", i1, i2, new String[] { paramShareGroupItem, ((StringBuilder)localObject).toString() });
      }
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.h.setText(2131897975);
    this.f.setVisibility(0);
    this.c.setText(paramShareGroupItem.name);
    this.o.a(true, false);
  }
  
  private void a(String paramString, int paramInt)
  {
    int i1;
    if (this.y == 1) {
      i1 = 3;
    } else if (this.u.isPublic()) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    int i2;
    if (this.y == 1) {
      i2 = 2;
    } else {
      i2 = 1;
    }
    StoryReportor.a("share_story", "clk_add_entry", i1, i2, new String[] { paramString });
    AddVideoController localAddVideoController = new AddVideoController(this.app);
    if ("2".equals(paramString)) {
      i1 = 2;
    } else if ("5".equals(paramString)) {
      i1 = 5;
    } else {
      i1 = 0;
    }
    localAddVideoController.a(this, this.u.type, this.t, this.u.name, this.u.groupUin, paramInt, i1);
  }
  
  public static Intent b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    paramContext = new Intent(paramContext, QQStoryShareGroupProfileActivity.class);
    paramContext.putExtra("extra_share_group_id", paramString1);
    paramContext.putExtra("extra_share_group_type", paramInt1);
    paramContext.putExtra("extra_share_group_from", paramInt2);
    paramContext.putExtra("extra_share_group_play_from", paramInt3);
    paramContext.putExtra("extra_user_group_uin", paramString2);
    return paramContext;
  }
  
  private void b(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem != null)
    {
      this.u = paramShareGroupItem;
      this.c.setText(paramShareGroupItem.name);
      if ((paramShareGroupItem.videoCount != 0) && (this.w != 8)) {
        this.l.setVisibility(0);
      } else {
        this.l.setVisibility(8);
      }
      this.e.a(paramShareGroupItem);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ShareGroupItem localShareGroupItem = ((ShareGroupManager)SuperManager.a(7)).a(this.t);
    if ((localShareGroupItem != null) && (!paramBoolean)) {
      a(localShareGroupItem);
    }
    if (this.y == 1)
    {
      new GetShareGroupInfoHandler(this.t, this.s).a();
      return;
    }
    localShareGroupItem = new ShareGroupItem();
    localShareGroupItem.type = 2;
    a(localShareGroupItem);
  }
  
  private void d()
  {
    View localView = LayoutInflater.from(this).inflate(2131628149, null, false);
    super.setContentViewNoTitle(localView);
    this.o.a(localView);
    this.o.a(false, false);
    this.b = ((RelativeLayout)super.findViewById(2131447534));
    this.c = ((TextView)super.findViewById(2131436227));
    this.j = ((TextView)super.findViewById(2131436180));
    this.l = ((ImageView)super.findViewById(2131436194));
    this.m = ((TextView)super.findViewById(2131436211));
    this.k = ((ImmersiveTitleBar2)super.findViewById(2131447582));
    this.a = ((LoadMoreLayout)super.findViewById(2131436945));
    this.f = super.findViewById(2131432530);
    this.f.setVisibility(8);
    this.f.setBackgroundResource(2130839572);
    this.g = ((ImageView)super.findViewById(2131432506));
    this.h = ((TextView)super.findViewById(2131432517));
    this.d = ((ShareGroupsListView)super.findViewById(2131445824));
    this.d.setContentBackground(2130839572);
    this.i = ((ImageButton)super.findViewById(2131442746));
    this.a.setState(1);
    this.n.a(this, this.d.getRootView());
    e();
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.p == null) {
      this.p = new ShareGroupDataPuller(this.t, this.y, this.s);
    }
    this.p.b();
    if (this.d.f.isEmpty()) {
      this.a.setState(1);
    }
    if (paramBoolean)
    {
      this.p.e();
      return;
    }
    this.p.f();
  }
  
  private void e()
  {
    this.e = ((ShareGroupsListAdapter)StoryApi.a(ShareGroupsListAdapter.class, new Object[] { this, Boolean.valueOf(this.G) }));
    this.d.setListAdapter(this.e);
    QQStoryShareGroupProfileActivity.UIEventListenerImpl localUIEventListenerImpl = new QQStoryShareGroupProfileActivity.UIEventListenerImpl(this);
    this.d.setUIEventListener(localUIEventListenerImpl);
    this.d.setOnScrollChangeListener(localUIEventListenerImpl);
    this.d.setOnScrollListener(localUIEventListenerImpl);
    this.d.setLoadMoreState(true, true);
    this.j.setOnClickListener(localUIEventListenerImpl);
    this.l.setOnClickListener(localUIEventListenerImpl);
    this.i.setOnClickListener(localUIEventListenerImpl);
  }
  
  private boolean f()
  {
    return this.y == 1;
  }
  
  private void g()
  {
    ActionSheet localActionSheet = ActionSheet.create(this);
    if (this.y == 1) {
      localActionSheet.addButton(HardCodeUtil.a(2131908631), 5);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new QQStoryShareGroupProfileActivity.2(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  @NonNull
  public String a()
  {
    return String.valueOf(hashCode());
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.d.f.e().iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      if (paramString.equals(((VideoCollectionItem)localIterator.next()).feedId))
      {
        a(i1);
        return;
      }
      i1 += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.d.f.i.size() > 0)
      {
        this.d.f.e(this.d.f.i, false);
      }
      else
      {
        List localList = ((HotSortVideoManager)SuperManager.a(25)).a(this.t);
        this.d.f.e(localList, false);
      }
    }
    if (this.q == null) {
      this.q = new GetHotSortVideoHandler(this.t);
    }
    if (this.d.f.isEmpty()) {
      this.a.setState(1);
    }
    this.q.a();
  }
  
  public boolean a(VideoCollectionItem paramVideoCollectionItem)
  {
    if (paramVideoCollectionItem.collectionCount <= paramVideoCollectionItem.collectionVideoUIItemList.size()) {
      return false;
    }
    qqstory_service.ReqLoadMoreVideoList localReqLoadMoreVideoList = new qqstory_service.ReqLoadMoreVideoList();
    localReqLoadMoreVideoList.feed_id.set(ByteStringMicro.copyFromUtf8(paramVideoCollectionItem.feedId));
    Object localObject = localReqLoadMoreVideoList.from;
    int i2 = this.y;
    int i1 = 2;
    if (i2 != 2) {
      i1 = 1;
    }
    ((PBUInt32Field)localObject).set(i1);
    localReqLoadMoreVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramVideoCollectionItem.nextCookie));
    localReqLoadMoreVideoList.video_count.set(10);
    localObject = new Bundle();
    ((Bundle)localObject).putString("extra_feedid", paramVideoCollectionItem.feedId);
    ProtoUtils.a(this.app, new QQStoryShareGroupProfileActivity.3(this), localReqLoadMoreVideoList.toByteArray(), StoryApi.a("StoryGroupSvc.datacard_load_more_video"), (Bundle)localObject);
    return true;
  }
  
  public int b()
  {
    int i1 = this.x;
    if (i1 > 0) {
      return i1;
    }
    if (this.y == 1) {
      return 88;
    }
    return 87;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.G)
    {
      localShareGroupsListView = this.d;
      localShareGroupsListView.setPadding(localShareGroupsListView.getListPaddingLeft(), this.d.getListPaddingTop(), this.d.getListPaddingRight(), UIUtils.a(this, 76.0F));
      a(paramBoolean);
      return;
    }
    ShareGroupsListView localShareGroupsListView = this.d;
    localShareGroupsListView.setPadding(localShareGroupsListView.getListPaddingLeft(), this.d.getListPaddingTop(), this.d.getListPaddingRight(), UIUtils.a(this, 89.0F));
    d(paramBoolean);
  }
  
  public void c()
  {
    if (this.q == null) {
      this.q = new GetHotSortVideoHandler(this.t);
    }
    this.q.b();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 != 1003)
      {
        if (paramInt1 != 1004)
        {
          StoryShare localStoryShare = this.H;
          if (localStoryShare != null) {
            localStoryShare.a(paramInt1, paramInt2, paramIntent);
          }
        }
        else
        {
          a(paramIntent, "5");
        }
      }
      else {
        a(paramIntent, "2");
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.o = new TranslucentTitleBarHelper(this, 20);
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.t = paramBundle.getStringExtra("extra_share_group_id");
    this.y = paramBundle.getIntExtra("extra_share_group_type", 1);
    this.v = paramBundle.getStringExtra("extra_user_group_uin");
    this.w = paramBundle.getIntExtra("extra_share_group_from", 0);
    this.z = paramBundle.getStringExtra("extra_share_from_user_uid");
    this.x = paramBundle.getIntExtra("extra_share_group_play_from", 0);
    this.A = paramBundle.getIntExtra("extra_last_open_from", 0);
    this.s = String.valueOf(System.currentTimeMillis());
    this.n = ((QQStoryShareGroupHelper)StoryApi.a(QQStoryShareGroupHelper.class, new Object[0]));
    d();
    if ((this.y == 1) && (TextUtils.isEmpty(this.t)))
    {
      if (TextUtils.isEmpty(this.v))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "extra_user_group_uin must not be empty!");
        }
        super.finish();
        return false;
      }
      new GetUserGroupUnionIDHandler(this.v).a();
    }
    else
    {
      if (TextUtils.isEmpty(this.t))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "extra_share_group_id must not be empty!");
        }
        super.finish();
        return false;
      }
      c(f() ^ true);
    }
    if (this.w == 5) {
      new Handler(Looper.getMainLooper()).postDelayed(new QQStoryShareGroupProfileActivity.1(this), 200L);
    }
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.C)
    {
      this.C = false;
      c(true);
    }
    if (this.B)
    {
      this.B = false;
      b(false);
      return;
    }
    if (this.D) {
      this.d.f.notifyDataSetChanged();
    }
  }
  
  protected boolean isWrapContent()
  {
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreateSubscribers(@NonNull Map<Subscriber, String> paramMap)
  {
    super.onCreateSubscribers(paramMap);
    paramMap.put(new QQStoryShareGroupProfileActivity.GetCollectListEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.GetSimpleInfoListEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.GetGroupInfoEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.UpdateUserInfoEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.GetUserGroupUnionIDEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.DeleteStoryVideoEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.VideoSortEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.GetVideoByHotSortEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.ReportVideoReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.StoryVideoPublishStatusReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.WatchVideoReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.FeedInfoUpdateReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.PlayVideoChangeReceiver(this), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity
 * JD-Core Version:    0.7.0.1
 */