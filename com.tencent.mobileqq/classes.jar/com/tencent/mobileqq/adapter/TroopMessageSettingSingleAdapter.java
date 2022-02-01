package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class TroopMessageSettingSingleAdapter
  extends BaseAdapter
{
  private Context a;
  private QQAppInterface b;
  private List<Long> c = new ArrayList();
  private TroopManager d;
  
  public TroopMessageSettingSingleAdapter(Context paramContext, QQAppInterface paramQQAppInterface, List<Long> paramList)
  {
    this.a = paramContext;
    this.b = paramQQAppInterface;
    this.c = paramList;
    this.d = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER));
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
  
  public void a(List<Long> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.c;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    String str = String.valueOf(this.c.get(paramInt));
    return this.d.g(str);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopInfo localTroopInfo = this.d.g(String.valueOf(this.c.get(paramInt)));
    TroopMessageSettingSingleAdapter.ViewHolder localViewHolder;
    if (paramView != null)
    {
      localViewHolder = (TroopMessageSettingSingleAdapter.ViewHolder)paramView.getTag();
    }
    else
    {
      paramView = LayoutInflater.from(this.a).inflate(2131629281, null);
      localViewHolder = new TroopMessageSettingSingleAdapter.ViewHolder(this);
      localViewHolder.a = ((ImageView)paramView.findViewById(2131434407));
      localViewHolder.b = ((TextView)paramView.findViewById(2131434457));
      localViewHolder.c = ((TextView)paramView.findViewById(2131434424));
      localViewHolder.d = ((ImageView)paramView.findViewById(2131444691));
      paramView.setTag(localViewHolder);
    }
    Object localObject = this.b.getTroopFaceDrawable(localTroopInfo.troopuin);
    if (localObject == null)
    {
      localObject = ImageUtil.g();
      localViewHolder.a.setImageBitmap((Bitmap)localObject);
    }
    else
    {
      localViewHolder.a.setImageDrawable((Drawable)localObject);
    }
    localViewHolder.b.setText(localTroopInfo.getTroopDisplayName());
    localViewHolder.c.setVisibility(0);
    a(paramView, paramInt, getCount());
    paramView.setBackgroundResource(2130839622);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopMessageSettingSingleAdapter
 * JD-Core Version:    0.7.0.1
 */