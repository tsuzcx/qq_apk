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
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yol;
import yom;

public class ShowExternalTroopListAdapter
  extends FacePreloadBaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  protected View.OnClickListener a;
  public ShowExternalTroopListAdapter.OnTroopListClickListener a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopManager a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new yol(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected String a;
  protected List a;
  protected boolean a;
  protected List b;
  protected boolean b;
  List c;
  
  public ShowExternalTroopListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ShowExternalTroopListAdapter.OnTroopListClickListener paramOnTroopListClickListener, XListView paramXListView, boolean paramBoolean, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new yom(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter$OnTroopListClickListener = paramOnTroopListClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(51));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public void Z_()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    super.Z_();
  }
  
  public void a(List paramList)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramList != null)
    {
      this.c = paramList;
      notifyDataSetChanged();
    }
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
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969895, null);
    }
    ShowExternalTroopListAdapter.TroopListItem localTroopListItem = (ShowExternalTroopListAdapter.TroopListItem)getItem(paramInt);
    if (localTroopListItem == null) {
      return null;
    }
    View localView;
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
    paramViewGroup = localTroopListItem.a;
    GroupViewAdapter.a(localView, this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
    paramView.e.setVisibility(8);
    paramView.jdField_a_of_type_JavaLangString = localTroopListItem.a.troopUin;
    paramView.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramViewGroup.troopUin));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    if (this.c != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (!this.c.isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter
 * JD-Core Version:    0.7.0.1
 */