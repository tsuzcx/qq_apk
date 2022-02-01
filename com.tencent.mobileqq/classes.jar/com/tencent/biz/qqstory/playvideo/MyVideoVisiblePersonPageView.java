package com.tencent.biz.qqstory.playvideo;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListAdapter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyVideoVisiblePersonPageView
  extends RelativeLayout
  implements View.OnClickListener
{
  QQAppInterface a;
  Context b;
  View c;
  TextView d;
  TextView e;
  TextView f;
  View g;
  XListView h;
  QQStoryWatcherListAdapter i;
  String j;
  int k = -1;
  int l = -1;
  Dialog m;
  FriendsManager n;
  QQStoryObserver o = new MyVideoVisiblePersonPageView.4(this);
  protected ChildViewClickListener p = new MyVideoVisiblePersonPageView.5(this);
  GestureDetector q = new GestureDetector(this.b, new MyVideoVisiblePersonPageView.6(this));
  
  public MyVideoVisiblePersonPageView(Dialog paramDialog, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131628211, this, true);
    this.n = ((FriendsManager)PlayModeUtils.b().getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.m = paramDialog;
    this.b = paramContext;
    this.j = paramString;
    this.k = paramInt;
    this.a = PlayModeUtils.b();
    this.a.addObserver(this.o);
    a();
    paramDialog = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().i());
    if ((paramDialog != null) && (paramDialog.isVip))
    {
      h();
      return;
    }
    paramInt = this.k;
    if (paramInt == 1000)
    {
      h();
      return;
    }
    if (paramInt == 0)
    {
      g();
      return;
    }
    if (paramInt == 1)
    {
      f();
      return;
    }
    c();
  }
  
  void a()
  {
    this.h = ((XListView)findViewById(2131437272));
    this.c = findViewById(2131442634);
    this.d = ((TextView)findViewById(2131442718));
    this.e = ((TextView)findViewById(2131444737));
    this.e.setOnClickListener(this);
    this.f = ((TextView)findViewById(2131450229));
    this.g = findViewById(2131445073);
    this.i = new QQStoryWatcherListAdapter(this.b, null);
    this.i.a(2131628210);
    this.i.a(this.p);
    this.h.setAdapter(this.i);
    this.h.setVisibility(0);
    this.h.setOnScrollListener(new MyVideoVisiblePersonPageView.1(this));
    MyVideoVisiblePersonPageView.2 local2 = new MyVideoVisiblePersonPageView.2(this);
    this.h.setOnTouchListener(local2);
    this.c.setOnTouchListener(local2);
    this.g.setOnTouchListener(local2);
  }
  
  void a(List<QQUserUIItem> paramList)
  {
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.g.setVisibility(8);
    this.h.setVisibility(0);
    if ((this.i != null) && (paramList != null))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)localIterator.next();
        Friends localFriends = this.n.m(String.valueOf(localQQUserUIItem.qq));
        if (localFriends != null)
        {
          localQQUserUIItem.mComparePartInt = localFriends.mComparePartInt;
          localQQUserUIItem.mCompareSpell = localFriends.mCompareSpell;
        }
      }
      Collections.sort(paramList, new MyVideoVisiblePersonPageView.3(this));
      this.i.a(paramList);
      this.i.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    this.a.removeObserver(this.o);
  }
  
  void c()
  {
    if (NetworkUtil.isNetSupport(this.b))
    {
      d();
      ((QQStoryHandler)this.a.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).b(this.j);
      return;
    }
    e();
  }
  
  void d()
  {
    this.h.setVisibility(8);
    this.e.setVisibility(8);
    this.g.setVisibility(8);
    this.c.setVisibility(0);
    this.d.setVisibility(0);
  }
  
  void e()
  {
    this.h.setVisibility(8);
    this.d.setVisibility(8);
    this.g.setVisibility(8);
    this.c.setVisibility(0);
    this.e.setVisibility(0);
  }
  
  void f()
  {
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.h.setVisibility(8);
    this.g.setVisibility(0);
    this.f.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130848672), null, null);
    this.f.setText(HardCodeUtil.a(2131904932));
  }
  
  void g()
  {
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.h.setVisibility(8);
    this.g.setVisibility(0);
    this.f.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130848670), null, null);
    this.f.setText(StoryApi.b(2131897954));
  }
  
  public String getTabTitle()
  {
    String str = HardCodeUtil.a(2131904933);
    int i1 = this.k;
    if ((i1 != 1000) && (i1 != 0) && (i1 != 1) && (i1 != 2))
    {
      if (i1 == 3) {
        return HardCodeUtil.a(2131904934);
      }
    }
    else {
      str = HardCodeUtil.a(2131904935);
    }
    return str;
  }
  
  void h()
  {
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.h.setVisibility(8);
    this.g.setVisibility(0);
    this.f.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130848674), null, null);
    this.f.setText(HardCodeUtil.a(2131904936));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131444737) {
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView
 * JD-Core Version:    0.7.0.1
 */