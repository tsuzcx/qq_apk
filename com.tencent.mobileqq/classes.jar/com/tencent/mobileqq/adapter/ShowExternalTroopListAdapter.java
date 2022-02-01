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
  Context jdField_a_of_type_AndroidContentContext;
  protected View.OnClickListener a;
  ShowExternalTroopListAdapter.OnTroopListClickListener jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter$OnTroopListClickListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopManager a;
  TroopAvatarObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver = new ShowExternalTroopListAdapter.1(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected String a;
  protected List<ShowExternalTroopListAdapter.TroopListItem> a;
  protected boolean a;
  protected List<Entity> b;
  protected boolean b;
  List<ShowExternalTroop> c;
  
  public ShowExternalTroopListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ShowExternalTroopListAdapter.OnTroopListClickListener paramOnTroopListClickListener, XListView paramXListView, boolean paramBoolean, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ShowExternalTroopListAdapter.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter$OnTroopListClickListener = paramOnTroopListClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver);
  }
  
  public void a(List<ShowExternalTroop> paramList)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramList != null)
    {
      this.c = paramList;
      notifyDataSetChanged();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver);
    super.c();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    View localView;
    for (paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560642, null);; paramView = localView)
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
        localView = GroupViewAdapter.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, 5, false, 1);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      paramView = (NearbyTroops.CustomViewHolder)localView.getTag();
      paramView.jdField_c_of_type_Int = 4;
      ShowExternalTroop localShowExternalTroop = localTroopListItem.a;
      GroupViewAdapter.a(localView, this.jdField_a_of_type_AndroidContentContext, localShowExternalTroop);
      paramView.e.setVisibility(8);
      paramView.jdField_a_of_type_JavaLangString = localTroopListItem.a.troopUin;
      paramView.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, localShowExternalTroop.troopUin));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    if (this.c != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((this.c.isEmpty() ^ true))
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          ShowExternalTroop localShowExternalTroop = (ShowExternalTroop)localIterator.next();
          this.jdField_a_of_type_JavaUtilList.add(new ShowExternalTroopListAdapter.TroopListItem(1, localShowExternalTroop));
        }
      }
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter
 * JD-Core Version:    0.7.0.1
 */