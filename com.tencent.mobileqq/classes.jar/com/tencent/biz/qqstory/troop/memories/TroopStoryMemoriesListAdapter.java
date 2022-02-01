package com.tencent.biz.qqstory.troop.memories;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import aoot;
import bhmg;
import bhmq;
import blpw;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import wth;
import wtt;
import xiz;
import znb;
import znc;
import znd;
import zne;
import znf;
import zng;
import znh;
import znj;
import znk;
import znm;
import zno;
import znq;

public class TroopStoryMemoriesListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131717453, 2131691323 };
  private static final int[] b = { 2131165688, 2131165603 };
  private static final int[] c = { 2131376534, 2131370743 };
  public final float a;
  public Context a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArrayList<TroopStoryItemInfo> a;
  public zng a;
  znj jdField_a_of_type_Znj;
  public boolean a;
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561873, paramViewGroup, false);
      paramViewGroup.setTag(new znq(this, paramViewGroup));
      return paramViewGroup;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561869, paramViewGroup, false);
      paramViewGroup.setTag(new zne(this, paramViewGroup));
      return paramViewGroup;
    case 3: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561871, paramViewGroup, false);
      paramViewGroup.setTag(new znh(this, paramViewGroup));
      return paramViewGroup;
    case 4: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561870, paramViewGroup, false);
      paramViewGroup.setTag(new znf(this, paramViewGroup));
      return paramViewGroup;
    case 2: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561872, paramViewGroup, false);
      paramViewGroup = new zno(this, localView);
      localView = this.jdField_a_of_type_Znj.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    case 5: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561872, paramViewGroup, false);
      paramViewGroup = new znm(this, localView);
      localView = this.jdField_a_of_type_Znj.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561872, paramViewGroup, false);
    paramViewGroup = new znk(this, localView);
    localView = this.jdField_a_of_type_Znj.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
    localView.setTag(paramViewGroup);
    return localView;
  }
  
  private void a(int paramInt, View paramView)
  {
    int i = getItemViewType(paramInt);
    TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    switch (i)
    {
    default: 
      return;
    case 0: 
      ((znq)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 1: 
      ((zne)paramView.getTag()).a(localTroopStoryItemInfo, paramInt);
      return;
    case 3: 
      ((znh)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 4: 
      ((znf)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 5: 
      localObject = (znm)paramView.getTag();
      ((znm)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new znb(this, paramInt));
      this.jdField_a_of_type_Znj.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (blpw)localObject, this);
      return;
    case 6: 
      localObject = (znk)paramView.getTag();
      ((znk)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new znc(this, paramInt));
      this.jdField_a_of_type_Znj.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (blpw)localObject, this);
      return;
    }
    Object localObject = (zno)paramView.getTag();
    ((zno)localObject).a(localTroopStoryItemInfo, paramInt);
    paramView.setOnLongClickListener(new znd(this, paramInt));
    this.jdField_a_of_type_Znj.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (blpw)localObject, this);
  }
  
  private void a(TroopStoryItemInfo paramTroopStoryItemInfo, URLImageView paramURLImageView, TextView paramTextView)
  {
    Object localObject1 = bhmq.b();
    if (paramTroopStoryItemInfo.unionIdRole == 2)
    {
      localObject2 = ((wtt)wth.a(2)).b(paramTroopStoryItemInfo.unionId);
      if ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()))
      {
        paramURLImageView.setImageDrawable((Drawable)localObject1);
        paramTextView.setText(xiz.a((QQUserUIItem)localObject2));
        xiz.a(paramTextView);
        return;
      }
      if (!((QQUserUIItem)localObject2).isFriend())
      {
        xiz.a(paramURLImageView, ((QQUserUIItem)localObject2).headUrl, true, (int)bhmg.a(this.jdField_a_of_type_AndroidContentContext, 35.0F));
        paramTextView.setText(xiz.a((QQUserUIItem)localObject2));
        xiz.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramTextView, ((QQUserUIItem)localObject2).symbolUrl, 13.0F, 2.0F);
        return;
      }
    }
    Object localObject2 = paramTroopStoryItemInfo.uin;
    localObject2 = aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject2, 3, (Drawable)localObject1, (Drawable)localObject1);
    if (localObject2 == null) {}
    for (;;)
    {
      paramURLImageView.setImageDrawable((Drawable)localObject1);
      paramTextView.setText(paramTroopStoryItemInfo.nickName);
      xiz.a(paramTextView);
      return;
      localObject1 = localObject2;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).itemType;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = a(paramInt, paramViewGroup);
    }
    for (;;)
    {
      a(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      i = Integer.parseInt(String.valueOf(paramView.getTag(-1)));
      if (i == -1)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopStoryMemoriesListAdapter", 2, localException, new Object[0]);
        }
        int i = -1;
        continue;
        if (this.jdField_a_of_type_Zng != null)
        {
          TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          switch (paramView.getId())
          {
          default: 
            break;
          case 2131370743: 
            this.jdField_a_of_type_Zng.a(paramView, i, localTroopStoryItemInfo, 2);
            break;
          case 2131376534: 
            this.jdField_a_of_type_Zng.a(paramView, localTroopStoryItemInfo, 2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter
 * JD-Core Version:    0.7.0.1
 */