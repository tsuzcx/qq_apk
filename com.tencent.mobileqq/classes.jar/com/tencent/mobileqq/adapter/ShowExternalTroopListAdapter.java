package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.GroupViewAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowExternalTroopListAdapter
  extends FacePreloadBaseAdapter
{
  Context a;
  ShowExternalTroopListAdapter.OnTroopListClickListener b;
  QQAppInterface c;
  XListView d;
  protected List<ShowExternalTroopListAdapter.TroopListItem> e = new ArrayList();
  protected List<Entity> f = new ArrayList();
  protected boolean g = false;
  List<ShowExternalTroop> h;
  protected TroopManager j;
  protected String k = null;
  protected boolean l = false;
  TroopAvatarObserver m = new ShowExternalTroopListAdapter.1(this);
  protected View.OnClickListener n = new ShowExternalTroopListAdapter.2(this);
  
  public ShowExternalTroopListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ShowExternalTroopListAdapter.OnTroopListClickListener paramOnTroopListClickListener, XListView paramXListView, boolean paramBoolean, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.c = paramQQAppInterface;
    this.b = paramOnTroopListClickListener;
    this.a = paramContext;
    this.d = paramXListView;
    this.g = paramBoolean;
    this.k = paramString;
    this.j = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    paramQQAppInterface.addObserver(this.m);
  }
  
  public void a(List<ShowExternalTroop> paramList)
  {
    this.l = true;
    if (paramList != null)
    {
      this.h = paramList;
      notifyDataSetChanged();
    }
  }
  
  public void c()
  {
    this.c.removeObserver(this.m);
    super.c();
  }
  
  public int getCount()
  {
    return this.e.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.e.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((!this.g) && (!this.l) && (this.e.size() == 0)) {}
    View localView;
    for (paramView = LayoutInflater.from(this.a).inflate(2131626687, null);; paramView = localView)
    {
      localView = paramView;
      break;
      ShowExternalTroopListAdapter.TroopListItem localTroopListItem = (ShowExternalTroopListAdapter.TroopListItem)getItem(paramInt);
      if (localTroopListItem == null)
      {
        localTroopListItem = null;
        localView = paramView;
        paramView = localTroopListItem;
        break;
      }
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localView = GroupViewAdapter.a(this.a, paramViewGroup, 5, false, 1);
        localView.setOnClickListener(this.n);
      }
      paramView = (NearbyTroops.CustomViewHolder)localView.getTag();
      paramView.z = 4;
      ShowExternalTroop localShowExternalTroop = localTroopListItem.b;
      GroupViewAdapter.a(localView, this.a, localShowExternalTroop);
      paramView.s.setVisibility(8);
      paramView.y = localTroopListItem.b.troopUin;
      paramView.A.setImageBitmap(a(4, localShowExternalTroop.troopUin));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    if (this.h != null)
    {
      this.e.clear();
      if ((this.h.isEmpty() ^ true))
      {
        Iterator localIterator = this.h.iterator();
        while (localIterator.hasNext())
        {
          ShowExternalTroop localShowExternalTroop = (ShowExternalTroop)localIterator.next();
          this.e.add(new ShowExternalTroopListAdapter.TroopListItem(1, localShowExternalTroop));
        }
      }
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter
 * JD-Core Version:    0.7.0.1
 */