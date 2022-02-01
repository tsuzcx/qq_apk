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
  public static final String a = UUID.randomUUID().toString();
  private Context b;
  private QQAppInterface c;
  private List<Entity> d;
  private Map<String, Integer> e;
  private SparseArray<List<TroopInfo>> f = new SparseArray();
  private ArrayList<Integer> g = new ArrayList();
  private IRoamSettingService h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public TroopMessageSettingAdapter(Context paramContext, QQAppInterface paramQQAppInterface, List<Entity> paramList, Map<String, Integer> paramMap)
  {
    this.b = paramContext;
    this.c = paramQQAppInterface;
    this.i = this.b.getResources().getDimensionPixelSize(2131297111);
    this.j = this.b.getResources().getDimensionPixelSize(2131297108);
    this.k = this.b.getResources().getDimensionPixelSize(2131297107);
    this.l = this.b.getResources().getDimensionPixelSize(2131297108);
    this.g.add(Integer.valueOf(1));
    this.g.add(Integer.valueOf(4));
    this.g.add(Integer.valueOf(2));
    this.g.add(Integer.valueOf(3));
    this.h = ((IRoamSettingService)paramQQAppInterface.getRuntimeService(IRoamSettingService.class, ""));
    paramContext = paramList;
    if (paramList == null) {
      paramContext = new ArrayList();
    }
    paramQQAppInterface = paramMap;
    if (paramMap == null) {
      paramQQAppInterface = new HashMap();
    }
    this.d = paramContext;
    this.e = paramQQAppInterface;
    a(this.d);
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
      paramView.setBackgroundResource(2130839622);
      return;
    }
    if (paramInt1 == 0)
    {
      paramView.setBackgroundResource(2130839638);
      return;
    }
    if (paramInt1 == paramInt2 - 1)
    {
      paramView.setBackgroundResource(2130839629);
      return;
    }
    paramView.setBackgroundResource(2130839632);
  }
  
  private void a(List<Entity> paramList)
  {
    int m = 0;
    Object localObject2;
    while (m < paramList.size())
    {
      if (paramList.get(m) != null)
      {
        localObject1 = (TroopInfo)paramList.get(m);
        if (localObject1 == null) {
          break;
        }
        localObject2 = (Integer)this.e.get(((TroopInfo)localObject1).troopuin);
        if (localObject2 != null)
        {
          int n = ((Integer)localObject2).intValue();
          if (this.f.get(n) == null) {
            this.f.put(n, new ArrayList());
          }
          ((List)this.f.get(n)).add(localObject1);
        }
      }
      m += 1;
    }
    paramList = new TroopMessageSettingAdapter.TroopCompator();
    Object localObject1 = this.g.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      m = ((Integer)((Iterator)localObject1).next()).intValue();
      if (this.f.get(m) != null)
      {
        localObject2 = (List)this.f.get(m);
        Collections.sort((List)localObject2, paramList);
        this.f.put(m, localObject2);
      }
    }
    paramList = this.g.iterator();
    while (paramList.hasNext())
    {
      m = ((Integer)paramList.next()).intValue();
      if (this.f.get(m) == null)
      {
        localObject1 = new TroopInfo();
        ((TroopInfo)localObject1).troopuin = a;
        ((TroopInfo)localObject1).troopname = this.b.getString(2131917469);
        this.f.put(m, new ArrayList());
        ((List)this.f.get(m)).add(localObject1);
      }
    }
  }
  
  public TroopInfo a(int paramInt1, int paramInt2)
  {
    return (TroopInfo)((List)this.f.get(a(paramInt1).intValue())).get(paramInt2);
  }
  
  public Integer a(int paramInt)
  {
    return (Integer)this.g.get(paramInt);
  }
  
  public void a(Map<String, Integer> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.e = paramMap;
    a(this.d);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  @TargetApi(8)
  public int getChildType(int paramInt1, int paramInt2)
  {
    TroopInfo localTroopInfo = a(paramInt1, paramInt2);
    if ((localTroopInfo != null) && (a.equals(localTroopInfo.troopuin))) {
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
    int m = getChildType(paramInt1, paramInt2);
    if (TextUtils.isEmpty(localTroopInfo.getTroopDisplayName())) {
      paramViewGroup = localTroopInfo.troopuin;
    } else {
      paramViewGroup = localTroopInfo.getTroopDisplayName();
    }
    Object localObject;
    if (m == 1)
    {
      if (paramView != null)
      {
        localObject = (TroopMessageSettingAdapter.ChildType1ViewHolder)paramView.getTag();
      }
      else
      {
        paramView = LayoutInflater.from(this.b).inflate(2131629282, null);
        localObject = new TroopMessageSettingAdapter.ChildType1ViewHolder(this);
        ((TroopMessageSettingAdapter.ChildType1ViewHolder)localObject).a = ((TextView)paramView.findViewById(2131434457));
        paramView.setTag(localObject);
      }
      ((TroopMessageSettingAdapter.ChildType1ViewHolder)localObject).a.setText(paramViewGroup);
    }
    else
    {
      if (paramView != null)
      {
        localObject = (TroopMessageSettingAdapter.ChildType0ViewHolder)paramView.getTag();
      }
      else
      {
        paramView = LayoutInflater.from(this.b).inflate(2131629281, null);
        localObject = new TroopMessageSettingAdapter.ChildType0ViewHolder(this);
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).a = ((ImageView)paramView.findViewById(2131434407));
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).b = ((TextView)paramView.findViewById(2131434457));
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).c = ((TextView)paramView.findViewById(2131434424));
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).d = ((ImageView)paramView.findViewById(2131444691));
        paramView.setTag(localObject);
      }
      FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.c, 4, localTroopInfo.troopuin);
      ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).a.setImageDrawable(localFaceDrawable);
      ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).b.setText(paramViewGroup);
      ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).c.setVisibility(0);
      a(paramView, paramInt2, getChildrenCount(paramInt1));
      paramViewGroup = (Boolean)this.h.getMapRequest().get(localTroopInfo.troopuin);
      if ((paramViewGroup != null) && (paramViewGroup.booleanValue())) {
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).d.setVisibility(0);
      } else {
        ((TroopMessageSettingAdapter.ChildType0ViewHolder)localObject).d.setVisibility(8);
      }
    }
    paramView.setFocusable(true);
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    List localList = (List)this.f.get(a(paramInt).intValue());
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getGroupCount()
  {
    return this.g.size();
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
    return this.g.size();
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    int m;
    if (paramView != null) {
      m = ((Integer)paramView.getTag()).intValue();
    } else {
      m = -1;
    }
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (m != -1)
      {
        localView = paramView;
        if (m == a(paramInt).intValue()) {}
      }
    }
    else
    {
      m = 0;
      int n = a(paramInt).intValue();
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n == 4) {
              m = 2131629552;
            }
          }
          else {
            m = 2131629551;
          }
        }
        else {
          m = 2131629550;
        }
      }
      else {
        m = 2131629549;
      }
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(m, null);
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
    this.f.clear();
    a(this.d);
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopMessageSettingAdapter
 * JD-Core Version:    0.7.0.1
 */