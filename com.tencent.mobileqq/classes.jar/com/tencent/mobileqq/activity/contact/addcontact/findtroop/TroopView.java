package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator.ScrollViewListener;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.activity.contacts.pullrefresh.OnRefreshListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler;
import com.tencent.mobileqq.troop.recommend.api.TroopRecommendObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AbsSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import tencent.im.oidb.cmd0xded.oidb_0xded.ClassifyInfo;
import tencent.im.oidb.cmd0xded.oidb_0xded.Node;

public class TroopView
  extends ContactBaseView
{
  private TroopRecommendObserver A = new TroopView.12(this);
  TroopView.onNavStickyListener a;
  Button b;
  EditText c;
  TextView d;
  List<AddContactFindTroopClassifyInfo> e = new ArrayList();
  AddContactTroopClassifyAdapter.onItemClickListener f = new TroopView.1(this);
  Rect g = new Rect();
  SimpleCheckableSlidingIndicator.ScrollViewListener h = new TroopView.2(this);
  private TroopView.UIHandler i;
  private boolean j;
  private ProgressBar k;
  private CommonRefreshLayout l;
  private ContactRefreshHeader m;
  private HeaderScrollView n;
  private RecyclerView o;
  private AddContactTroopClassifyAdapter p = new AddContactTroopClassifyAdapter(this.E.b(), this.e, this.f);
  private SimpleCheckableSlidingIndicator q;
  private FrameLayout r;
  private ContactsViewPager s;
  private ContactsViewPagerAdapter t;
  private int u;
  private int v = -1;
  private ContactsBaseFragment.RefreshDataListener w = new TroopView.3(this);
  private AbsSlidingIndicator.OnTabListener x = new TroopView.4(this);
  private OnRefreshListener y = new TroopView.5(this);
  private TopGestureLayout z;
  
  public TroopView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onSelectedNewClassifyPostion. position:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("addContacts.TroopView", 2, ((StringBuilder)localObject1).toString());
    }
    this.n.setCurrentScrollableContainer(this.t.a(paramInt, true));
    this.t.b(paramInt, this.v);
    this.p.a(paramInt);
    this.o.smoothScrollToPosition(paramInt);
    this.u = paramInt;
    Object localObject1 = (AddContactFindTroopClassifyInfo)this.e.get(paramInt);
    if (((AddContactFindTroopClassifyInfo)localObject1).h != null)
    {
      int i2 = ((AddContactFindTroopClassifyInfo)localObject1).h.size();
      if (i2 > 0)
      {
        Object localObject2 = new String[i2];
        Object localObject3 = new int[i2];
        int i1 = 0;
        while (i1 < i2)
        {
          localObject2[i1] = ((AddContactFindTroopClassifyInfo.TagInfo)((AddContactFindTroopClassifyInfo)localObject1).h.get(i1)).a;
          localObject3[i1] = i1;
          i1 += 1;
        }
        this.q.setTabData((String[])localObject2, (int[])localObject3);
        this.r.setVisibility(0);
        getViewTreeObserver().addOnGlobalLayoutListener(new TroopView.6(this));
        this.q.setCurrentPosition(((AddContactFindTroopClassifyInfo)localObject1).g, false);
        i1 = this.s.getCurrentItem();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onSelectedNewClassifyPostion. position:");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(" currentClassifyPos:");
          ((StringBuilder)localObject2).append(i1);
          QLog.i("addContacts.TroopView", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = this.t.a(i1, false);
        if (localObject2 != null)
        {
          localObject3 = (AddContactViewPagerTroopFragment)localObject2;
          AddContactFindTroopClassifyInfo localAddContactFindTroopClassifyInfo = (AddContactFindTroopClassifyInfo)this.e.get(i1);
          localObject2 = localAddContactFindTroopClassifyInfo.d;
          if (((AddContactFindTroopClassifyInfo)localObject1).g >= 0)
          {
            localObject2 = ((AddContactFindTroopClassifyInfo.TagInfo)localAddContactFindTroopClassifyInfo.h.get(((AddContactFindTroopClassifyInfo)localObject1).g)).b;
            localObject1 = ((AddContactFindTroopClassifyInfo.TagInfo)localAddContactFindTroopClassifyInfo.h.get(((AddContactFindTroopClassifyInfo)localObject1).g)).a;
          }
          else
          {
            localObject1 = "";
          }
          ((AddContactViewPagerTroopFragment)localObject3).a((String)localObject2, (String)localObject1);
        }
      }
      else
      {
        this.r.setVisibility(8);
      }
    }
    else
    {
      this.r.setVisibility(8);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (((AppActivity)this.F).isResume()) {
      QQToast.makeText(this.F, paramInt1, getResources().getString(paramInt2), 0).show(((BaseActivity)this.F).getTitleBarHeight());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    k();
    if (!paramBoolean) {
      a(1, 2131916799);
    }
  }
  
  private static ArrayList<AddContactFindTroopClassifyInfo> b(ArrayList<oidb_0xded.ClassifyInfo> paramArrayList)
  {
    localArrayList = new ArrayList();
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      try
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          Object localObject = (oidb_0xded.ClassifyInfo)paramArrayList.next();
          AddContactFindTroopClassifyInfo localAddContactFindTroopClassifyInfo = new AddContactFindTroopClassifyInfo();
          localAddContactFindTroopClassifyInfo.a = ((oidb_0xded.Node)((oidb_0xded.ClassifyInfo)localObject).node.get()).item.get().toStringUtf8();
          localAddContactFindTroopClassifyInfo.d = ((oidb_0xded.Node)((oidb_0xded.ClassifyInfo)localObject).node.get()).keyword.get().toStringUtf8();
          localAddContactFindTroopClassifyInfo.f = ((oidb_0xded.Node)((oidb_0xded.ClassifyInfo)localObject).node.get()).type.get();
          localAddContactFindTroopClassifyInfo.b = ((oidb_0xded.ClassifyInfo)localObject).icon_url.get().toStringUtf8();
          localAddContactFindTroopClassifyInfo.c = ((oidb_0xded.ClassifyInfo)localObject).icon_hover_url.get().toStringUtf8();
          localAddContactFindTroopClassifyInfo.e = ((oidb_0xded.ClassifyInfo)localObject).color.get().toStringUtf8();
          localObject = ((oidb_0xded.ClassifyInfo)localObject).second_class.get();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localAddContactFindTroopClassifyInfo.h = new ArrayList();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              oidb_0xded.Node localNode = (oidb_0xded.Node)((Iterator)localObject).next();
              AddContactFindTroopClassifyInfo.TagInfo localTagInfo = new AddContactFindTroopClassifyInfo.TagInfo();
              localTagInfo.a = localNode.item.get().toStringUtf8();
              localTagInfo.b = localNode.keyword.get().toStringUtf8();
              localAddContactFindTroopClassifyInfo.h.add(localTagInfo);
            }
          }
          localArrayList.add(localAddContactFindTroopClassifyInfo);
        }
        return localArrayList;
      }
      catch (Exception paramArrayList)
      {
        QLog.d("addContacts.TroopView", 1, "handle_oidb_0xded_1_response exception", paramArrayList);
      }
    }
  }
  
  private void e()
  {
    this.q.getHitRect(this.g);
    String[] arrayOfString = this.q.getTextList();
    int[] arrayOfInt = this.q.getTabViewIds();
    int i1 = this.s.getCurrentItem();
    AddContactFindTroopClassifyInfo localAddContactFindTroopClassifyInfo = (AddContactFindTroopClassifyInfo)this.e.get(i1);
    i1 = 0;
    while (i1 < arrayOfString.length)
    {
      StringBuilder localStringBuilder;
      if (this.q.findViewById(arrayOfInt[i1]).getLocalVisibleRect(this.g))
      {
        ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_exp", 0, 0, arrayOfString[i1], localAddContactFindTroopClassifyInfo.a, "", "");
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkAndReportHotTagExpose,visible:");
          localStringBuilder.append(arrayOfString[i1]);
          localStringBuilder.append(",");
          localStringBuilder.append(localAddContactFindTroopClassifyInfo.a);
          QLog.i("addContacts.TroopView", 2, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAndReportHotTagExpose,not visible:");
        localStringBuilder.append(arrayOfString[i1]);
        QLog.i("addContacts.TroopView", 2, localStringBuilder.toString());
      }
      i1 += 1;
    }
  }
  
  private void f()
  {
    long l1 = System.currentTimeMillis();
    this.E.b().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l1).commit();
  }
  
  private void g()
  {
    this.q = ((SimpleCheckableSlidingIndicator)findViewById(2131446094));
    int i1 = Color.parseColor("#F5F6FA");
    int i2 = getResources().getColor(2131167993);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      i1 = Color.parseColor("#282828");
      i2 = getResources().getColor(2131168212);
    }
    this.q.setIndicatorColor(i1);
    this.q.setCheckedTextColor(i2);
    this.r = ((FrameLayout)findViewById(2131435688));
    this.r.setVisibility(8);
    this.n = ((HeaderScrollView)findViewById(2131431264));
    this.b = ((Button)findViewById(2131429816));
    this.b.setVisibility(8);
    this.d = ((TextView)findViewById(2131448724));
    this.c = ((EditText)findViewById(2131432634));
    this.c.setFocusableInTouchMode(false);
    this.c.setCursorVisible(false);
    this.o = ((RecyclerView)findViewById(2131444522));
    Object localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.o.setLayoutManager((RecyclerView.LayoutManager)localObject);
    i1 = AIOUtils.b(6.0F, getResources());
    i2 = AIOUtils.b(16.0F, getResources());
    this.o.addItemDecoration(new AddContactTroopClassifyAdapter.SpacesItemDecoration(i1, i2));
    if (!StudyModeManager.h()) {
      this.o.setAdapter(this.p);
    }
    this.s = ((ContactsViewPager)findViewById(2131431267));
    localObject = new ArrayList();
    this.t = new AddContactFindTroopViewPagerAdapter(((BaseActivity)this.E.b()).getSupportFragmentManager(), this.E.a(), (BaseActivity)this.E.b(), (ArrayList)localObject);
    this.t.a(this.w);
    this.s.setAdapter(this.t);
    this.s.setOffscreenPageLimit(6);
    this.s.setOnPageChangeListener(new TroopView.7(this));
    this.q.setOnTabListener(this.x);
    this.q.setOnRepeatClickListener(new TroopView.8(this));
    this.q.setScrollViewListener(this.h);
    this.l = ((CommonRefreshLayout)findViewById(2131446666));
    this.l.setRefreshCompleteDelayDuration(0);
    this.m = ((ContactRefreshHeader)this.l.findViewById(2131446664));
    this.m.setRefreshHeaderUpdateListener(new TroopView.9(this));
    this.l.setOnRefreshListener(this.y);
    this.n.setTopOffset(AIOUtils.b(5.0F, getResources()));
    this.n.setOnScrollListener(new TroopView.10(this));
    this.c.setOnClickListener(new TroopView.11(this));
    this.d.setText(2131906725);
    this.z = getGestureLayout();
  }
  
  private TopGestureLayout getGestureLayout()
  {
    ViewGroup localViewGroup2 = (ViewGroup)this.E.b().getWindow().getDecorView();
    View localView = localViewGroup2.getChildAt(0);
    ViewGroup localViewGroup1 = localViewGroup2;
    if (localView != null)
    {
      localViewGroup1 = localViewGroup2;
      if ((localView instanceof ViewGroup)) {
        localViewGroup1 = (ViewGroup)localView;
      }
    }
    if ((localViewGroup1 instanceof TopGestureLayout)) {
      return (TopGestureLayout)localViewGroup1;
    }
    return null;
  }
  
  private long getLastRefreshTime()
  {
    return this.E.b().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private void getTroopClassifyDataFromServer()
  {
    j();
    Object localObject;
    if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      localObject = (ITroopRecommendHandler)this.G.getBusinessHandler(BusinessHandlerFactory.TROOP_RECOMMEND_HANDLER);
      if (localObject != null) {
        ((ITroopRecommendHandler)localObject).b();
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("addContacts.TroopView", 2, "initData falied. network unavailable");
      }
      localObject = this.i.obtainMessage(1);
      this.i.sendMessageDelayed((Message)localObject, 1000L);
    }
  }
  
  private void j()
  {
    this.k.setVisibility(0);
  }
  
  private void k()
  {
    this.k.setVisibility(8);
  }
  
  public void a()
  {
    super.a();
    super.setContentView(2131625885);
    this.k = ((ProgressBar)findViewById(2131437654));
    this.i = new TroopView.UIHandler(this);
    this.G.addObserver(this.A);
    getTroopClassifyDataFromServer();
    g();
  }
  
  public void b()
  {
    super.b();
    TopGestureLayout localTopGestureLayout = this.z;
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(false);
    }
    SearchUtils.a("add_page", "search_grp", "exp", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void c()
  {
    super.c();
    TopGestureLayout localTopGestureLayout = this.z;
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "onDestroy");
    }
    this.G.removeObserver(this.A);
    ContactsViewPagerAdapter localContactsViewPagerAdapter = this.t;
    if (localContactsViewPagerAdapter != null) {
      localContactsViewPagerAdapter.b();
    }
  }
  
  public void i()
  {
    super.i();
  }
  
  public void setNavStickyListener(TroopView.onNavStickyListener paramonNavStickyListener)
  {
    this.a = paramonNavStickyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView
 * JD-Core Version:    0.7.0.1
 */