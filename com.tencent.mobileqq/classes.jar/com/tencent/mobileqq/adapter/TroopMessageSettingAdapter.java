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
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
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
  private SparseArray<List<TroopInfo>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IRoamSettingService jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiIRoamSettingService;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<Entity> jdField_a_of_type_JavaUtilList;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private int b;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = UUID.randomUUID().toString();
  }
  
  public TroopMessageSettingAdapter(Context paramContext, QQAppInterface paramQQAppInterface, List<Entity> paramList, Map<String, Integer> paramMap)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296780);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296777);
    this.c = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296776);
    this.d = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296777);
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(3));
    this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiIRoamSettingService = ((IRoamSettingService)paramQQAppInterface.getRuntimeService(IRoamSettingService.class, ""));
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setItemBackground() childPos = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", listSize = ");
      localStringBuilder.append(paramInt2);
      QLog.i("TroopMessageSettingAdapter", 2, localStringBuilder.toString());
    }
    if (paramInt2 <= 1)
    {
      paramView.setBackgroundResource(2130839433);
      return;
    }
    if (paramInt1 == 0)
    {
      paramView.setBackgroundResource(2130839449);
      return;
    }
    if (paramInt1 == paramInt2 - 1)
    {
      paramView.setBackgroundResource(2130839440);
      return;
    }
    paramView.setBackgroundResource(2130839443);
  }
  
  private void a(List<Entity> paramList)
  {
    int i = 0;
    Object localObject2;
    while (i < paramList.size())
    {
      if (paramList.get(i) != null)
      {
        localObject1 = (TroopInfo)paramList.get(i);
        if (localObject1 == null) {
          break;
        }
        localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(((TroopInfo)localObject1).troopuin);
        if (localObject2 != null)
        {
          int j = ((Integer)localObject2).intValue();
          if (this.jdField_a_of_type_AndroidUtilSparseArray.get(j) == null) {
            this.jdField_a_of_type_AndroidUtilSparseArray.put(j, new ArrayList());
          }
          ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).add(localObject1);
        }
      }
      i += 1;
    }
    paramList = new TroopMessageSettingAdapter.TroopCompator();
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      i = ((Integer)((Iterator)localObject1).next()).intValue();
      if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) != null)
      {
        localObject2 = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        Collections.sort((List)localObject2, paramList);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject2);
      }
    }
    paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
      {
        localObject1 = new TroopInfo();
        ((TroopInfo)localObject1).troopuin = jdField_a_of_type_JavaLangString;
        ((TroopInfo)localObject1).troopname = this.jdField_a_of_type_AndroidContentContext.getString(2131719864);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, new ArrayList());
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(i)).add(localObject1);
      }
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
  
  public void a(Map<String, Integer> paramMap)
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
    if (TextUtils.isEmpty(localTroopInfo.getTroopDisplayName())) {
      paramViewGroup = localTroopInfo.troopuin;
    } else {
      paramViewGroup = localTroopInfo.getTroopDisplayName();
    }
    Object localObject;
    if (i == 1)
    {
      if (paramView != null)
      {
        localObject = (TroopMessageSettingAdapter.ChildType1ViewHolder)paramView.getTag();
      }
      else
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562837, null);
        localObject = new TroopMessageSettingAdapter.ChildType1ViewHolder(this);
        ((TroopMessageSettingAdapter.ChildType1ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367877));
        paramView.setTag(localObject);
      }
      ((TroopMessageSettingAdapter.ChildType1ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
    }
    else
    {
      if (paramView != null)
      {
        localObject = (TroopMessageSettingAdapter.ChildType0ViewHolder)paramView.getTag();
      }
      else
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562836, null);
        localObject = new TroopMessageSettingAdapter.ChildType0ViewHolder(this);
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367828));
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367877));
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367844));
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376458));
        paramView.setTag(localObject);
      }
      FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localTroopInfo.troopuin);
      ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
      ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
      ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      a(paramView, paramInt2, getChildrenCount(paramInt1));
      paramViewGroup = (Boolean)this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiIRoamSettingService.getMapRequest().get(localTroopInfo.troopuin);
      if ((paramViewGroup != null) && (paramViewGroup.booleanValue())) {
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    paramView.setFocusable(true);
    return paramView;
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
    int i;
    if (paramView != null) {
      i = ((Integer)paramView.getTag()).intValue();
    } else {
      i = -1;
    }
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
      int j = a(paramInt).intValue();
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j == 4) {
              i = 2131562944;
            }
          }
          else {
            i = 2131562943;
          }
        }
        else {
          i = 2131562942;
        }
      }
      else {
        i = 2131562941;
      }
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(i, null);
    }
    localView.setFocusable(true);
    localView.setTag(a(paramInt));
    return localView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopMessageSettingAdapter
 * JD-Core Version:    0.7.0.1
 */