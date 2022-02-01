package com.tencent.biz.qqstory.troop.memories;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import bhdz;
import bheg;
import blfl;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import wjs;
import wke;
import wzk;
import zcq;
import zcr;
import zcs;
import zct;
import zcu;
import zcv;
import zcw;
import zcy;
import zcz;
import zdb;
import zdd;
import zdf;

public class TroopStoryMemoriesListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131718056, 2131691448 };
  private static final int[] b = { 2131165705, 2131165617 };
  private static final int[] c = { 2131376555, 2131370896 };
  public final float a;
  public Context a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArrayList<TroopStoryItemInfo> a;
  public zcv a;
  zcy jdField_a_of_type_Zcy;
  public boolean a;
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561818, paramViewGroup, false);
      paramViewGroup.setTag(new zdf(this, paramViewGroup));
      return paramViewGroup;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561814, paramViewGroup, false);
      paramViewGroup.setTag(new zct(this, paramViewGroup));
      return paramViewGroup;
    case 3: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561816, paramViewGroup, false);
      paramViewGroup.setTag(new zcw(this, paramViewGroup));
      return paramViewGroup;
    case 4: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561815, paramViewGroup, false);
      paramViewGroup.setTag(new zcu(this, paramViewGroup));
      return paramViewGroup;
    case 2: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561817, paramViewGroup, false);
      paramViewGroup = new zdd(this, localView);
      localView = this.jdField_a_of_type_Zcy.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    case 5: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561817, paramViewGroup, false);
      paramViewGroup = new zdb(this, localView);
      localView = this.jdField_a_of_type_Zcy.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561817, paramViewGroup, false);
    paramViewGroup = new zcz(this, localView);
    localView = this.jdField_a_of_type_Zcy.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
    localView.setTag(paramViewGroup);
    return localView;
  }
  
  private void a(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    int i = getItemViewType(paramInt);
    TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    switch (i)
    {
    default: 
      return;
    case 0: 
      ((zdf)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 1: 
      ((zct)paramView.getTag()).a(localTroopStoryItemInfo, paramInt);
      return;
    case 3: 
      ((zcw)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 4: 
      ((zcu)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 5: 
      localObject = (zdb)paramView.getTag();
      ((zdb)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new zcq(this, paramInt));
      this.jdField_a_of_type_Zcy.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (blfl)localObject, this);
      return;
    case 6: 
      localObject = (zcz)paramView.getTag();
      ((zcz)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new zcr(this, paramInt));
      this.jdField_a_of_type_Zcy.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (blfl)localObject, this);
      return;
    }
    Object localObject = (zdd)paramView.getTag();
    ((zdd)localObject).a(localTroopStoryItemInfo, paramInt);
    paramView.setOnLongClickListener(new zcs(this, paramInt));
    this.jdField_a_of_type_Zcy.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (blfl)localObject, this);
  }
  
  private void a(TroopStoryItemInfo paramTroopStoryItemInfo, URLImageView paramURLImageView, TextView paramTextView)
  {
    Object localObject1 = bheg.b();
    if (paramTroopStoryItemInfo.unionIdRole == 2)
    {
      localObject2 = ((wke)wjs.a(2)).b(paramTroopStoryItemInfo.unionId);
      if ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()))
      {
        paramURLImageView.setImageDrawable((Drawable)localObject1);
        paramTextView.setText(wzk.a((QQUserUIItem)localObject2));
        wzk.a(paramTextView);
        return;
      }
      if (!((QQUserUIItem)localObject2).isFriend())
      {
        wzk.a(paramURLImageView, ((QQUserUIItem)localObject2).headUrl, true, (int)bhdz.a(this.jdField_a_of_type_AndroidContentContext, 35.0F));
        paramTextView.setText(wzk.a((QQUserUIItem)localObject2));
        wzk.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramTextView, ((QQUserUIItem)localObject2).symbolUrl, 13.0F, 2.0F);
        return;
      }
    }
    Object localObject2 = paramTroopStoryItemInfo.uin;
    localObject2 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject2, 3, (Drawable)localObject1, (Drawable)localObject1);
    if (localObject2 == null) {}
    for (;;)
    {
      paramURLImageView.setImageDrawable((Drawable)localObject1);
      paramTextView.setText(paramTroopStoryItemInfo.nickName);
      wzk.a(paramTextView);
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
        if (this.jdField_a_of_type_Zcv != null)
        {
          TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          switch (paramView.getId())
          {
          default: 
            break;
          case 2131370896: 
            this.jdField_a_of_type_Zcv.a(paramView, i, localTroopStoryItemInfo, 2);
            break;
          case 2131376555: 
            this.jdField_a_of_type_Zcv.a(paramView, localTroopStoryItemInfo, 2);
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