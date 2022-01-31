package com.tencent.biz.qqstory.troop.memories;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import bdbk;
import bdgz;
import bdhj;
import bibi;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import uwa;
import uwm;
import vls;
import xpv;
import xpw;
import xpx;
import xpy;
import xpz;
import xqa;
import xqb;
import xqd;
import xqe;
import xqg;
import xqi;
import xqk;

public class TroopStoryMemoriesListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131719229, 2131691562 };
  private static final int[] b = { 2131165650, 2131165566 };
  private static final int[] c = { 2131375676, 2131370198 };
  public final float a;
  public Context a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArrayList<TroopStoryItemInfo> a;
  public xqa a;
  xqd jdField_a_of_type_Xqd;
  public boolean a;
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561597, paramViewGroup, false);
      paramViewGroup.setTag(new xqk(this, paramViewGroup));
      return paramViewGroup;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561593, paramViewGroup, false);
      paramViewGroup.setTag(new xpy(this, paramViewGroup));
      return paramViewGroup;
    case 3: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561595, paramViewGroup, false);
      paramViewGroup.setTag(new xqb(this, paramViewGroup));
      return paramViewGroup;
    case 4: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561594, paramViewGroup, false);
      paramViewGroup.setTag(new xpz(this, paramViewGroup));
      return paramViewGroup;
    case 2: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561596, paramViewGroup, false);
      paramViewGroup = new xqi(this, localView);
      localView = this.jdField_a_of_type_Xqd.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    case 5: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561596, paramViewGroup, false);
      paramViewGroup = new xqg(this, localView);
      localView = this.jdField_a_of_type_Xqd.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561596, paramViewGroup, false);
    paramViewGroup = new xqe(this, localView);
    localView = this.jdField_a_of_type_Xqd.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
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
      ((xqk)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 1: 
      ((xpy)paramView.getTag()).a(localTroopStoryItemInfo, paramInt);
      return;
    case 3: 
      ((xqb)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 4: 
      ((xpz)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 5: 
      localObject = (xqg)paramView.getTag();
      ((xqg)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new xpv(this, paramInt));
      this.jdField_a_of_type_Xqd.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (bibi)localObject, this);
      return;
    case 6: 
      localObject = (xqe)paramView.getTag();
      ((xqe)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new xpw(this, paramInt));
      this.jdField_a_of_type_Xqd.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (bibi)localObject, this);
      return;
    }
    Object localObject = (xqi)paramView.getTag();
    ((xqi)localObject).a(localTroopStoryItemInfo, paramInt);
    paramView.setOnLongClickListener(new xpx(this, paramInt));
    this.jdField_a_of_type_Xqd.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (bibi)localObject, this);
  }
  
  private void a(TroopStoryItemInfo paramTroopStoryItemInfo, URLImageView paramURLImageView, TextView paramTextView)
  {
    Object localObject1 = bdhj.b();
    if (paramTroopStoryItemInfo.unionIdRole == 2)
    {
      localObject2 = ((uwm)uwa.a(2)).b(paramTroopStoryItemInfo.unionId);
      if ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()))
      {
        paramURLImageView.setImageDrawable((Drawable)localObject1);
        paramTextView.setText(vls.a((QQUserUIItem)localObject2));
        vls.a(paramTextView);
        return;
      }
      if (!((QQUserUIItem)localObject2).isFriend())
      {
        vls.a(paramURLImageView, ((QQUserUIItem)localObject2).headUrl, true, (int)bdgz.a(this.jdField_a_of_type_AndroidContentContext, 35.0F));
        paramTextView.setText(vls.a((QQUserUIItem)localObject2));
        vls.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramTextView, ((QQUserUIItem)localObject2).symbolUrl, 13.0F, 2.0F);
        return;
      }
    }
    Object localObject2 = paramTroopStoryItemInfo.uin;
    localObject2 = bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject2, 3, (Drawable)localObject1, (Drawable)localObject1);
    if (localObject2 == null) {}
    for (;;)
    {
      paramURLImageView.setImageDrawable((Drawable)localObject1);
      paramTextView.setText(paramTroopStoryItemInfo.nickName);
      vls.a(paramTextView);
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
      } while (this.jdField_a_of_type_Xqa == null);
      localTroopStoryItemInfo = (TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    }
    this.jdField_a_of_type_Xqa.a(paramView, i, localTroopStoryItemInfo, 2);
    return;
    this.jdField_a_of_type_Xqa.a(paramView, localTroopStoryItemInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter
 * JD-Core Version:    0.7.0.1
 */