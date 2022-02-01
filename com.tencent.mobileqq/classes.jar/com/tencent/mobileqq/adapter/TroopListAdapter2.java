package com.tencent.mobileqq.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.adapter.contact.CommonlyUsedTroopCompator;
import com.tencent.mobileqq.troop.adapter.contact.TroopCompator;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItem;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItemWithMask;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.showexternal.api.ITroopShowExternalHandler;
import com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TroopListAdapter2
  extends FacePreloadBaseAdapter
  implements CompoundButton.OnCheckedChangeListener
{
  protected View.OnClickListener A = new TroopListAdapter2.5(this);
  Context a;
  TroopListAdapter2.OnTroopListClickListener b;
  protected TroopMngObserver c;
  protected TroopShowExternalObserver d;
  QQAppInterface e;
  SlideDetectListView f;
  int g = 0;
  public int h;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  protected LayoutInflater o;
  protected List<TroopListItem> p = new ArrayList();
  protected List<Entity> q = new ArrayList();
  protected boolean r = false;
  protected TroopManager s;
  protected HashMap<String, Switch> t;
  ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack u;
  protected boolean v = false;
  public boolean w = true;
  protected DiscussionManager x;
  protected boolean y = true;
  protected View.OnClickListener z = new TroopListAdapter2.4(this);
  
  public TroopListAdapter2(Context paramContext, QQAppInterface paramQQAppInterface, TroopListAdapter2.OnTroopListClickListener paramOnTroopListClickListener, XListView paramXListView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack paramIShowExternalTroopDataChangedCallBack)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.e = paramQQAppInterface;
    this.b = paramOnTroopListClickListener;
    this.a = paramContext;
    this.g = paramInt;
    this.f = ((SlideDetectListView)paramXListView);
    this.o = LayoutInflater.from(paramContext);
    this.r = paramBoolean1;
    this.y = paramBoolean2;
    this.u = paramIShowExternalTroopDataChangedCallBack;
    this.s = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.x = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    if ((this.r) && ((this.a instanceof TroopActivity)))
    {
      this.t = new HashMap();
      this.d = new TroopListAdapter2.1(this, (TroopActivity)this.a);
      this.c = new TroopListAdapter2.2(this);
    }
  }
  
  private List<TroopListItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.r)
    {
      localObject1 = this.t;
      if (localObject1 != null) {
        ((HashMap)localObject1).clear();
      }
    }
    Object localObject1 = (TroopManager)this.e.getManager(QQManagerFactory.TROOP_MANAGER);
    this.q = ((TroopManager)localObject1).g();
    if (this.q == null)
    {
      this.q = new ArrayList();
      return localArrayList;
    }
    Object localObject5 = new ArrayList();
    Object localObject2 = ((TroopManager)localObject1).d();
    if (localObject2 != null)
    {
      Collections.sort((List)localObject2, new CommonlyUsedTroopCompator());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject5).add(((TroopManager)localObject1).f(((CommonlyUsedTroop)((Iterator)localObject2).next()).troopUin));
      }
      this.l = ((List)localObject5).size();
    }
    Object localObject4 = new ArrayList();
    Object localObject3 = new ArrayList();
    localObject2 = new ArrayList();
    Object localObject6 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject7 = this.q.iterator();
    while (((Iterator)localObject7).hasNext())
    {
      localObject8 = (TroopInfo)((Iterator)localObject7).next();
      int i = b(this.e.getTroopMask(((TroopInfo)localObject8).troopuin));
      if (((TroopInfo)localObject8).isQidianPrivateTroop())
      {
        ((List)localObject1).add(new TroopListItemWithMask(i, (Entity)localObject8));
      }
      else
      {
        if ((((TroopInfo)localObject8).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject4).add(new TroopListItemWithMask(i, (Entity)localObject8));
        } else if ((((TroopInfo)localObject8).dwCmdUinUinFlag & 1L) == 1L) {
          ((List)localObject3).add(new TroopListItemWithMask(i, (Entity)localObject8));
        } else {
          ((List)localObject2).add(new TroopListItemWithMask(i, (Entity)localObject8));
        }
        if (!((TroopInfo)localObject8).hasSetTroopName()) {
          ((List)localObject6).add(new TroopListItemWithMask(i, (Entity)localObject8));
        }
      }
    }
    localObject7 = this.e.getProxyManager().g();
    Object localObject8 = ((DiscussionManager)this.e.getManager(QQManagerFactory.DISCUSSION_MANAGER)).b();
    if (this.y)
    {
      localObject8 = ((List)localObject8).iterator();
      while (((Iterator)localObject8).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject8).next();
        RecentUser localRecentUser = ((RecentUserProxy)localObject7).b(localDiscussionInfo.uin, 3000);
        localDiscussionInfo.lastMsgTime = localRecentUser.lastmsgtime;
        if (localRecentUser.showUpTime != 0L) {
          ((List)localObject5).add(localDiscussionInfo);
        }
        if (this.e.getCurrentUin().equals(localDiscussionInfo.ownerUin)) {
          ((List)localObject4).add(new TroopListItemWithMask(1, localDiscussionInfo));
        } else {
          ((List)localObject2).add(new TroopListItemWithMask(1, localDiscussionInfo));
        }
        if (!localDiscussionInfo.hasRenamed()) {
          ((List)localObject6).add(new TroopListItemWithMask(1, localDiscussionInfo));
        }
      }
    }
    if (this.g == 2)
    {
      ((List)localObject5).clear();
      ((List)localObject2).clear();
      ((List)localObject6).clear();
      ((List)localObject1).clear();
    }
    this.l = ((List)localObject5).size();
    this.h = ((List)localObject4).size();
    this.k = ((List)localObject2).size();
    this.m = ((List)localObject6).size();
    localObject7 = new TroopCompator();
    Collections.sort((List)localObject4, (Comparator)localObject7);
    Collections.sort((List)localObject3, (Comparator)localObject7);
    Collections.sort((List)localObject2, (Comparator)localObject7);
    Collections.sort((List)localObject6, (Comparator)localObject7);
    Collections.sort((List)localObject1, (Comparator)localObject7);
    if (this.l > 0)
    {
      localArrayList.add(new TroopListItem(0, null));
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject7 = (Entity)((Iterator)localObject5).next();
        if ((localObject7 instanceof TroopInfo))
        {
          localArrayList.add(new TroopListItem(1, (Entity)localObject7));
        }
        else if ((localObject7 instanceof DiscussionInfo))
        {
          localObject7 = (DiscussionInfo)localObject7;
          localArrayList.add(new TroopListItem(1, (DiscussionInfo)localObject7, this.x.c(((DiscussionInfo)localObject7).uin)));
        }
      }
    }
    if (this.m > 0)
    {
      localArrayList.add(new TroopListItem(8, null));
      localObject5 = ((List)localObject6).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (TroopListItemWithMask)((Iterator)localObject5).next();
        if ((((TroopListItemWithMask)localObject6).b instanceof TroopInfo))
        {
          localArrayList.add(new TroopListItem(9, ((TroopListItemWithMask)localObject6).b));
        }
        else if ((((TroopListItemWithMask)localObject6).b instanceof DiscussionInfo))
        {
          localObject6 = (DiscussionInfo)((TroopListItemWithMask)localObject6).b;
          localArrayList.add(new TroopListItem(9, (DiscussionInfo)localObject6, this.x.c(((DiscussionInfo)localObject6).uin)));
        }
      }
    }
    if (this.h > 0)
    {
      localArrayList.add(new TroopListItem(4, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (TroopListItemWithMask)((Iterator)localObject4).next();
        if ((((TroopListItemWithMask)localObject5).b instanceof TroopInfo))
        {
          localArrayList.add(new TroopListItem(5, ((TroopListItemWithMask)localObject5).b));
        }
        else if ((((TroopListItemWithMask)localObject5).b instanceof DiscussionInfo))
        {
          localObject5 = (DiscussionInfo)((TroopListItemWithMask)localObject5).b;
          localArrayList.add(new TroopListItem(5, (DiscussionInfo)localObject5, this.x.c(((DiscussionInfo)localObject5).uin)));
        }
      }
    }
    this.j = ((List)localObject3).size();
    if (this.j > 0)
    {
      localArrayList.add(new TroopListItem(6, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList.add(new TroopListItem(7, ((TroopListItemWithMask)((Iterator)localObject3).next()).b));
      }
    }
    if (this.k > 0)
    {
      localArrayList.add(new TroopListItem(2, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TroopListItemWithMask)((Iterator)localObject2).next();
        if ((((TroopListItemWithMask)localObject3).b instanceof TroopInfo))
        {
          localArrayList.add(new TroopListItem(3, ((TroopListItemWithMask)localObject3).b));
        }
        else if ((((TroopListItemWithMask)localObject3).b instanceof DiscussionInfo))
        {
          localObject3 = (DiscussionInfo)((TroopListItemWithMask)localObject3).b;
          localArrayList.add(new TroopListItem(3, (DiscussionInfo)localObject3, this.x.c(((DiscussionInfo)localObject3).uin)));
        }
      }
    }
    this.n = ((List)localObject1).size();
    if (this.n > 0)
    {
      localArrayList.add(new TroopListItem(10, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(new TroopListItem(11, ((TroopListItemWithMask)((Iterator)localObject1).next()).b));
      }
    }
    return localArrayList;
  }
  
  private void a(TroopListItem paramTroopListItem, String paramString, boolean paramBoolean)
  {
    ((ITroopShowExternalHandler)this.e.getBusinessHandler(BusinessHandlerFactory.TROOP_SHOW_EXTERNAL_HANDLER)).a(paramString, paramTroopListItem.b.troopuin, paramBoolean, false);
    if (paramBoolean) {
      ReportController.b(this.e, "P_CliOper", "Grp_join", "", "join_page", "set_open", 0, 0, paramTroopListItem.b.troopuin, "", "", "");
    } else {
      ReportController.b(this.e, "P_CliOper", "Grp_join", "", "join_page", "set_close", 0, 0, paramTroopListItem.b.troopuin, "", "", "");
    }
    paramString = this.u;
    if (paramString != null) {
      paramString.a(paramTroopListItem.b.troopuin, paramBoolean);
    }
  }
  
  public static int b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return 1;
          }
          return 2;
        }
        return 4;
      }
      return 3;
    }
    return 1;
  }
  
  public TroopInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.p.size())) {
      return ((TroopListItem)this.p.get(paramInt)).b;
    }
    return null;
  }
  
  public int getCount()
  {
    return this.p.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.p.get(paramInt);
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.v = true;
    Object localObject4 = (TroopListItem)getItem(paramInt);
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (paramView == null)
    {
      localObject2 = this.o.inflate(2131625927, paramViewGroup, false);
      localObject3 = new TroopListAdapter2.TroopListViewItemTag((View)localObject2);
      ((View)localObject2).setTag(localObject3);
      ((Button)((View)localObject2).findViewById(2131447918)).setOnClickListener(this.z);
      ((View)localObject2).setOnClickListener(this.A);
      localObject1 = localObject2;
      paramView = (View)localObject3;
      if (this.r)
      {
        ((TroopListAdapter2.TroopListViewItemTag)localObject3).i.setOnCheckedChangeListener(this);
        localObject1 = localObject2;
        paramView = (View)localObject3;
      }
    }
    else
    {
      localObject2 = (TroopListAdapter2.TroopListViewItemTag)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    paramView.h = ((TroopListItem)localObject4);
    if ((this.r) && (paramView.h.a != 0) && (paramView.h.a != 4) && (paramView.h.a != 6) && (paramView.h.a != 8) && (paramView.h.a != 2))
    {
      paramView.i.setVisibility(0);
      paramView.i.setTag(paramView.h);
      if (this.s == null) {
        this.s = ((TroopManager)this.e.getManager(QQManagerFactory.TROOP_MANAGER));
      }
      if ((this.s != null) && (paramView.h.b != null) && (this.s.q(((TroopListItem)localObject4).b.troopuin))) {
        paramView.i.setChecked(true);
      } else {
        paramView.i.setChecked(false);
      }
      if ((this.t != null) && (((TroopListItem)localObject4).b != null)) {
        this.t.put(((TroopListItem)localObject4).b.troopuin, paramView.i);
      }
    }
    if (((TroopListItem)localObject4).a == 0)
    {
      paramView.j.setVisibility(8);
      paramView.e.setVisibility(0);
      paramView.k.setText(HardCodeUtil.a(2131912739));
      paramView.l.setText(String.valueOf(this.l));
    }
    else if (((TroopListItem)localObject4).a == 2)
    {
      paramView.j.setVisibility(8);
      paramView.e.setVisibility(0);
      paramView.k.setText(HardCodeUtil.a(2131913069));
      paramView.l.setText(String.valueOf(this.k));
    }
    else if (((TroopListItem)localObject4).a == 4)
    {
      paramView.j.setVisibility(8);
      paramView.e.setVisibility(0);
      paramView.k.setText(HardCodeUtil.a(2131913073));
      paramView.l.setText(String.valueOf(this.h));
    }
    else if (((TroopListItem)localObject4).a == 6)
    {
      paramView.j.setVisibility(8);
      paramView.e.setVisibility(0);
      paramView.k.setText(HardCodeUtil.a(2131913076));
      paramView.l.setText(String.valueOf(this.j));
    }
    else if (((TroopListItem)localObject4).a == 8)
    {
      paramView.j.setVisibility(8);
      paramView.e.setVisibility(0);
      paramView.k.setText(HardCodeUtil.a(2131913074));
      paramView.l.setText(String.valueOf(this.m));
    }
    else if (((TroopListItem)localObject4).a == 10)
    {
      paramView.j.setVisibility(8);
      paramView.e.setVisibility(0);
      paramView.k.setText(HardCodeUtil.a(2131900734));
      paramView.l.setText(String.valueOf(this.n));
    }
    else if (((TroopListItem)localObject4).b != null)
    {
      paramView.j.setVisibility(0);
      paramView.e.setVisibility(8);
      localObject3 = ((TroopListItem)localObject4).b;
      paramView.y = ((TroopInfo)localObject3).troopuin;
      if (this.e.getTroopMask(((TroopInfo)localObject3).troopuin) != 3)
      {
        paramView.a.setVisibility(4);
      }
      else
      {
        paramView.a.setVisibility(0);
        paramView.a.setImageResource(2130852643);
      }
      localObject4 = paramView.c;
      if (!TextUtils.isEmpty(((TroopInfo)localObject3).getTroopDisplayName())) {
        localObject2 = ((TroopInfo)localObject3).getTroopDisplayName();
      } else {
        localObject2 = ((TroopInfo)localObject3).troopuin;
      }
      ((TextView)localObject4).setText((CharSequence)localObject2);
      paramView.A.setImageBitmap(a(4, ((TroopInfo)localObject3).troopuin));
      if ((!((TroopInfo)localObject3).hasSetTroopName()) && (((TroopInfo)localObject3).wMemberNumClient > 0))
      {
        paramView.d.setVisibility(0);
        paramView.d.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject3).wMemberNumClient) }));
      }
      else
      {
        paramView.d.setVisibility(8);
      }
      if ((((TroopInfo)localObject3).dwGroupFlagExt & 0x800) != 0L)
      {
        if (((TroopInfo)localObject3).dwAuthGroupType == 2L)
        {
          paramView.g.setVisibility(0);
          paramView.g.setBackgroundResource(2130844940);
        }
        else if (((TroopInfo)localObject3).dwAuthGroupType == 1L)
        {
          paramView.g.setVisibility(0);
          paramView.g.setBackgroundResource(2130844940);
        }
        else
        {
          paramView.g.setVisibility(8);
        }
      }
      else {
        paramView.g.setVisibility(8);
      }
      if (((TroopInfo)localObject3).troopCreditLevel == 2L)
      {
        paramView.b.setVisibility(0);
        paramView.a.setVisibility(0);
        paramView.a.setImageResource(2130852646);
      }
      else if (((TroopInfo)localObject3).troopCreditLevel == 1L)
      {
        paramView.b.setVisibility(0);
        paramView.a.setVisibility(0);
        paramView.a.setImageResource(2130852644);
      }
      else
      {
        paramView.b.setVisibility(4);
      }
    }
    else if (((TroopListItem)localObject4).c != null)
    {
      paramView.j.setVisibility(0);
      paramView.e.setVisibility(8);
      localObject2 = ((TroopListItem)localObject4).c;
      paramView.y = ((DiscussionInfo)localObject2).uin;
      paramView.a.setVisibility(4);
      paramView.c.setText(ContactUtils.a(this.a, (DiscussionInfo)localObject2));
      if (!((DiscussionInfo)localObject2).hasRenamed())
      {
        paramView.d.setVisibility(0);
        paramView.d.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopListItem)localObject4).d) }));
      }
      paramView.A.setImageBitmap(a(101, ((DiscussionInfo)localObject2).uin));
    }
    this.v = false;
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public void notifyDataSetChanged()
  {
    ThreadManager.post(new TroopListAdapter2.3(this), 8, null, true);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.v)
    {
      Object localObject = paramCompoundButton.getTag();
      if ((localObject instanceof TroopListItem))
      {
        localObject = (TroopListItem)localObject;
        if (((TroopListItem)localObject).b != null)
        {
          if (this.s == null) {
            this.s = ((TroopManager)this.e.getManager(QQManagerFactory.TROOP_MANAGER));
          }
          String str1 = ((TroopListItem)localObject).b.troopcode;
          String str2 = ((TroopListItem)localObject).b.troopuin;
          TroopManager localTroopManager = this.s;
          if (TextUtils.isEmpty(str1)) {
            ThreadManager.post(new TroopListAdapter2.6(this, localTroopManager, str2, (TroopListItem)localObject, paramBoolean), 8, null, true);
          } else {
            a((TroopListItem)localObject, str1, paramBoolean);
          }
        }
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2
 * JD-Core Version:    0.7.0.1
 */