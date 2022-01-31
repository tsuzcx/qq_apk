package com.tencent.biz.qqstory.troop.memories;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import bayh;
import bbdv;
import bbef;
import bfwe;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tcz;
import tdl;
import tsr;
import vwu;
import vwv;
import vww;
import vwx;
import vwy;
import vwz;
import vxa;
import vxc;
import vxd;
import vxf;
import vxh;
import vxj;

public class TroopStoryMemoriesListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131718744, 2131691507 };
  private static final int[] b = { 2131165614, 2131165530 };
  private static final int[] c = { 2131375144, 2131369914 };
  public final float a;
  public Context a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArrayList<TroopStoryItemInfo> a;
  public vwz a;
  vxc jdField_a_of_type_Vxc;
  public boolean a;
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561389, paramViewGroup, false);
      paramViewGroup.setTag(new vxj(this, paramViewGroup));
      return paramViewGroup;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561385, paramViewGroup, false);
      paramViewGroup.setTag(new vwx(this, paramViewGroup));
      return paramViewGroup;
    case 3: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561387, paramViewGroup, false);
      paramViewGroup.setTag(new vxa(this, paramViewGroup));
      return paramViewGroup;
    case 4: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561386, paramViewGroup, false);
      paramViewGroup.setTag(new vwy(this, paramViewGroup));
      return paramViewGroup;
    case 2: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561388, paramViewGroup, false);
      paramViewGroup = new vxh(this, localView);
      localView = this.jdField_a_of_type_Vxc.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    case 5: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561388, paramViewGroup, false);
      paramViewGroup = new vxf(this, localView);
      localView = this.jdField_a_of_type_Vxc.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561388, paramViewGroup, false);
    paramViewGroup = new vxd(this, localView);
    localView = this.jdField_a_of_type_Vxc.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
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
      ((vxj)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 1: 
      ((vwx)paramView.getTag()).a(localTroopStoryItemInfo, paramInt);
      return;
    case 3: 
      ((vxa)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 4: 
      ((vwy)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 5: 
      localObject = (vxf)paramView.getTag();
      ((vxf)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new vwu(this, paramInt));
      this.jdField_a_of_type_Vxc.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (bfwe)localObject, this);
      return;
    case 6: 
      localObject = (vxd)paramView.getTag();
      ((vxd)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new vwv(this, paramInt));
      this.jdField_a_of_type_Vxc.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (bfwe)localObject, this);
      return;
    }
    Object localObject = (vxh)paramView.getTag();
    ((vxh)localObject).a(localTroopStoryItemInfo, paramInt);
    paramView.setOnLongClickListener(new vww(this, paramInt));
    this.jdField_a_of_type_Vxc.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (bfwe)localObject, this);
  }
  
  private void a(TroopStoryItemInfo paramTroopStoryItemInfo, URLImageView paramURLImageView, TextView paramTextView)
  {
    Object localObject1 = bbef.b();
    if (paramTroopStoryItemInfo.unionIdRole == 2)
    {
      localObject2 = ((tdl)tcz.a(2)).b(paramTroopStoryItemInfo.unionId);
      if ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()))
      {
        paramURLImageView.setImageDrawable((Drawable)localObject1);
        paramTextView.setText(tsr.a((QQUserUIItem)localObject2));
        tsr.a(paramTextView);
        return;
      }
      if (!((QQUserUIItem)localObject2).isFriend())
      {
        tsr.a(paramURLImageView, ((QQUserUIItem)localObject2).headUrl, true, (int)bbdv.a(this.jdField_a_of_type_AndroidContentContext, 35.0F));
        paramTextView.setText(tsr.a((QQUserUIItem)localObject2));
        tsr.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramTextView, ((QQUserUIItem)localObject2).symbolUrl, 13.0F, 2.0F);
        return;
      }
    }
    Object localObject2 = paramTroopStoryItemInfo.uin;
    localObject2 = bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject2, 3, (Drawable)localObject1, (Drawable)localObject1);
    if (localObject2 == null) {}
    for (;;)
    {
      paramURLImageView.setImageDrawable((Drawable)localObject1);
      paramTextView.setText(paramTroopStoryItemInfo.nickName);
      tsr.a(paramTextView);
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
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramInt, paramViewGroup);
    }
    a(paramInt, localView);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void onClick(View paramView)
  {
    int i;
    TroopStoryItemInfo localTroopStoryItemInfo;
    try
    {
      i = Integer.parseInt(String.valueOf(paramView.getTag(-1)));
      if (i == -1) {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopStoryMemoriesListAdapter", 2, localException, new Object[0]);
          }
          i = -1;
        }
      } while (this.jdField_a_of_type_Vwz == null);
      localTroopStoryItemInfo = (TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    }
    this.jdField_a_of_type_Vwz.a(paramView, i, localTroopStoryItemInfo, 2);
    return;
    this.jdField_a_of_type_Vwz.a(paramView, localTroopStoryItemInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter
 * JD-Core Version:    0.7.0.1
 */