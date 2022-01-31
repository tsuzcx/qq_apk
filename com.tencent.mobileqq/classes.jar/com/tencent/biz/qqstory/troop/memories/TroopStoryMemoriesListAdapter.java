package com.tencent.biz.qqstory.troop.memories;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import azwp;
import bacc;
import bacm;
import bent;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import sqg;
import sqs;
import tfy;
import vkb;
import vkc;
import vkd;
import vke;
import vkf;
import vkg;
import vkh;
import vkj;
import vkk;
import vkm;
import vko;
import vkq;

public class TroopStoryMemoriesListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131652908, 2131625931 };
  private static final int[] b = { 2131100029, 2131099945 };
  private static final int[] c = { 2131309395, 2131304236 };
  public final float a;
  public Context a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArrayList<TroopStoryItemInfo> a;
  public vkg a;
  vkj jdField_a_of_type_Vkj;
  public boolean a;
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495799, paramViewGroup, false);
      paramViewGroup.setTag(new vkq(this, paramViewGroup));
      return paramViewGroup;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495795, paramViewGroup, false);
      paramViewGroup.setTag(new vke(this, paramViewGroup));
      return paramViewGroup;
    case 3: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495797, paramViewGroup, false);
      paramViewGroup.setTag(new vkh(this, paramViewGroup));
      return paramViewGroup;
    case 4: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495796, paramViewGroup, false);
      paramViewGroup.setTag(new vkf(this, paramViewGroup));
      return paramViewGroup;
    case 2: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495798, paramViewGroup, false);
      paramViewGroup = new vko(this, localView);
      localView = this.jdField_a_of_type_Vkj.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    case 5: 
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495798, paramViewGroup, false);
      paramViewGroup = new vkm(this, localView);
      localView = this.jdField_a_of_type_Vkj.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
      localView.setTag(paramViewGroup);
      return localView;
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495798, paramViewGroup, false);
    paramViewGroup = new vkk(this, localView);
    localView = this.jdField_a_of_type_Vkj.a(this.jdField_a_of_type_AndroidContentContext, localView, paramViewGroup, -1);
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
      ((vkq)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 1: 
      ((vke)paramView.getTag()).a(localTroopStoryItemInfo, paramInt);
      return;
    case 3: 
      ((vkh)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 4: 
      ((vkf)paramView.getTag()).a(localTroopStoryItemInfo);
      return;
    case 5: 
      localObject = (vkm)paramView.getTag();
      ((vkm)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new vkb(this, paramInt));
      this.jdField_a_of_type_Vkj.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (bent)localObject, this);
      return;
    case 6: 
      localObject = (vkk)paramView.getTag();
      ((vkk)localObject).a(localTroopStoryItemInfo, paramInt);
      paramView.setOnLongClickListener(new vkc(this, paramInt));
      this.jdField_a_of_type_Vkj.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (bent)localObject, this);
      return;
    }
    Object localObject = (vko)paramView.getTag();
    ((vko)localObject).a(localTroopStoryItemInfo, paramInt);
    paramView.setOnLongClickListener(new vkd(this, paramInt));
    this.jdField_a_of_type_Vkj.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), (bent)localObject, this);
  }
  
  private void a(TroopStoryItemInfo paramTroopStoryItemInfo, URLImageView paramURLImageView, TextView paramTextView)
  {
    Object localObject1 = bacm.b();
    if (paramTroopStoryItemInfo.unionIdRole == 2)
    {
      localObject2 = ((sqs)sqg.a(2)).b(paramTroopStoryItemInfo.unionId);
      if ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()))
      {
        paramURLImageView.setImageDrawable((Drawable)localObject1);
        paramTextView.setText(tfy.a((QQUserUIItem)localObject2));
        tfy.a(paramTextView);
        return;
      }
      if (!((QQUserUIItem)localObject2).isFriend())
      {
        tfy.a(paramURLImageView, ((QQUserUIItem)localObject2).headUrl, true, (int)bacc.a(this.jdField_a_of_type_AndroidContentContext, 35.0F));
        paramTextView.setText(tfy.a((QQUserUIItem)localObject2));
        tfy.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramTextView, ((QQUserUIItem)localObject2).symbolUrl, 13.0F, 2.0F);
        return;
      }
    }
    Object localObject2 = paramTroopStoryItemInfo.uin;
    localObject2 = azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject2, 3, (Drawable)localObject1, (Drawable)localObject1);
    if (localObject2 == null) {}
    for (;;)
    {
      paramURLImageView.setImageDrawable((Drawable)localObject1);
      paramTextView.setText(paramTroopStoryItemInfo.nickName);
      tfy.a(paramTextView);
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
      } while (this.jdField_a_of_type_Vkg == null);
      localTroopStoryItemInfo = (TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    }
    this.jdField_a_of_type_Vkg.a(paramView, i, localTroopStoryItemInfo, 2);
    return;
    this.jdField_a_of_type_Vkg.a(paramView, localTroopStoryItemInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter
 * JD-Core Version:    0.7.0.1
 */