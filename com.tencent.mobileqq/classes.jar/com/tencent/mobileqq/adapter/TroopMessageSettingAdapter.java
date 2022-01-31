package com.tencent.mobileqq.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TroopMessageSettingAdapter
  extends BaseExpandableListAdapter
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RoamSettingController jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private int b;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = UUID.randomUUID().toString();
  }
  
  public TroopMessageSettingAdapter(Context paramContext, QQAppInterface paramQQAppInterface, List paramList, Map paramMap)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559335);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559331);
    this.c = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559333);
    this.d = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559331);
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(3));
    this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController = ((RoamSettingController)paramQQAppInterface.getManager(30));
    paramContext = paramList;
    if (paramList == null) {
      paramContext = new ArrayList();
    }
    paramQQAppInterface = paramMap;
    if (paramMap == null) {
      paramQQAppInterface = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilList = paramContext;
    this.jdField_a_of_type_JavaUtilMap = paramQQAppInterface;
    a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMessageSettingAdapter", 2, "setItemBackground() childPos = " + paramInt1 + ", listSize = " + paramInt2);
    }
    if (paramInt2 <= 1)
    {
      paramView.setBackgroundResource(2130838623);
      return;
    }
    if (paramInt1 == 0)
    {
      paramView.setBackgroundResource(2130838635);
      return;
    }
    if (paramInt1 == paramInt2 - 1)
    {
      paramView.setBackgroundResource(2130838630);
      return;
    }
    paramView.setBackgroundResource(2130838633);
  }
  
  private void a(List paramList)
  {
    int i = 0;
    TroopInfo localTroopInfo;
    if (i < paramList.size())
    {
      if (paramList.get(i) == null) {
        break label172;
      }
      localTroopInfo = (TroopInfo)paramList.get(i);
      if (localTroopInfo != null) {}
    }
    else
    {
      paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramList.hasNext())
      {
        i = ((Integer)paramList.next()).intValue();
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
        {
          localTroopInfo = new TroopInfo();
          localTroopInfo.troopuin = jdField_a_of_type_JavaLangString;
          localTroopInfo.troopname = this.jdField_a_of_type_AndroidContentContext.getString(2131435827);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(i, new ArrayList());
          ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(i)).add(localTroopInfo);
        }
      }
    }
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localTroopInfo.troopuin);
    if (localInteger == null) {}
    for (;;)
    {
      label172:
      i += 1;
      break;
      int j = localInteger.intValue();
      if (this.jdField_a_of_type_AndroidUtilSparseArray.get(j) == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(j, new ArrayList());
      }
      ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).add(localTroopInfo);
    }
  }
  
  public TroopInfo a(int paramInt1, int paramInt2)
  {
    return (TroopInfo)((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(a(paramInt1).intValue())).get(paramInt2);
  }
  
  public Integer a(int paramInt)
  {
    return (Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(Map paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  @TargetApi(8)
  public int getChildType(int paramInt1, int paramInt2)
  {
    TroopInfo localTroopInfo = a(paramInt1, paramInt2);
    if ((localTroopInfo != null) && (jdField_a_of_type_JavaLangString.equals(localTroopInfo.troopuin))) {
      return 1;
    }
    return 0;
  }
  
  public int getChildTypeCount()
  {
    return 2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    TroopInfo localTroopInfo = a(paramInt1, paramInt2);
    int i = getChildType(paramInt1, paramInt2);
    Object localObject;
    if (TextUtils.isEmpty(localTroopInfo.getTroopName()))
    {
      paramViewGroup = localTroopInfo.troopuin;
      if (i != 1) {
        break label135;
      }
      if (paramView == null) {
        break label84;
      }
      localObject = (TroopMessageSettingAdapter.ChildType1ViewHolder)paramView.getTag();
      label55:
      ((TroopMessageSettingAdapter.ChildType1ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
    }
    for (;;)
    {
      paramView.setFocusable(true);
      return paramView;
      paramViewGroup = localTroopInfo.getTroopName();
      break;
      label84:
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130971574, null);
      localObject = new TroopMessageSettingAdapter.ChildType1ViewHolder(this);
      ((TroopMessageSettingAdapter.ChildType1ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368580));
      paramView.setTag(localObject);
      break label55;
      label135:
      if (paramView != null) {
        localObject = (TroopMessageSettingAdapter.ChildType0ViewHolder)paramView.getTag();
      }
      for (;;)
      {
        FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localTroopInfo.troopuin);
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        a(paramView, paramInt2, getChildrenCount(paramInt1));
        paramViewGroup = (Boolean)this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.get(localTroopInfo.troopuin);
        if ((paramViewGroup == null) || (!paramViewGroup.booleanValue())) {
          break label351;
        }
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        break;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130971573, null);
        localObject = new TroopMessageSettingAdapter.ChildType0ViewHolder(this);
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368579));
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368580));
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375089));
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375088));
        paramView.setTag(localObject);
      }
      label351:
      ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(a(paramInt).intValue());
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public int getGroupType(int paramInt)
  {
    return paramInt;
  }
  
  public int getGroupTypeCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (int i = ((Integer)paramView.getTag()).intValue();; i = -1)
    {
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (i != -1)
        {
          localView = paramView;
          if (i == a(paramInt).intValue()) {}
        }
      }
      else
      {
        i = 0;
        switch (a(paramInt).intValue())
        {
        }
      }
      for (;;)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(i, null);
        localView.setFocusable(true);
        localView.setTag(a(paramInt));
        return localView;
        i = 2130971652;
        continue;
        i = 2130971655;
        continue;
        i = 2130971653;
        continue;
        i = 2130971654;
      }
    }
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    a(this.jdField_a_of_type_JavaUtilList);
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopMessageSettingAdapter
 * JD-Core Version:    0.7.0.1
 */