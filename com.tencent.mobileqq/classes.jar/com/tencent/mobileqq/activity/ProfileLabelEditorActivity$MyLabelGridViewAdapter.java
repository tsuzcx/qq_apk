package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel.LabelStatusManager;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ProfileLabelEditorActivity$MyLabelGridViewAdapter
  extends BaseAdapter
{
  List<ProfileLabelInfo> a;
  private View.OnClickListener c = new ProfileLabelEditorActivity.MyLabelGridViewAdapter.1(this);
  
  public ProfileLabelEditorActivity$MyLabelGridViewAdapter(List<ProfileLabelInfo> paramList)
  {
    Object localObject;
    this.a = localObject;
  }
  
  private void a(ProfileLabelInfo paramProfileLabelInfo)
  {
    Iterator localIterator = this.b.k.a().keySet().iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)localIterator.next();
      if (localProfileLabelInfo.labelId.equals(paramProfileLabelInfo.labelId)) {
        localObject = localProfileLabelInfo;
      }
    }
    if ((localObject != null) && (this.b.k.a(localObject)))
    {
      this.b.k.c(localObject, this.b.k.b(localObject));
      return;
    }
    a(paramProfileLabelInfo.labelId);
  }
  
  private void a(Long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.m.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((ProfileLabelTypeInfo)localIterator.next()).labels);
    }
    paramLong = this.b.b(paramLong, localArrayList);
    if (paramLong != null) {
      paramLong.toggleStatus();
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.b.getLayoutInflater().inflate(2131629370, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(this.b.g * 32.0F)));
      paramView = new ProfileLabelEditorActivity.Holder();
      paramView.a = ((TextView)localView.findViewById(2131446781));
      localView.setTag(paramView);
    }
    else
    {
      ProfileLabelEditorActivity.Holder localHolder = (ProfileLabelEditorActivity.Holder)paramView.getTag();
      localView = paramView;
      paramView = localHolder;
    }
    paramView.b = paramInt;
    int i = paramInt % ProfileLabelEditorActivity.a.length;
    localView.setBackgroundResource(ProfileLabelEditorActivity.a[i][0]);
    localView.setOnClickListener(this.c);
    i = ProfileLabelEditorActivity.a[i][1];
    paramView.a.setTextColor(i);
    paramView.a.setText(((ProfileLabelInfo)this.a.get(paramInt)).labelName);
    paramView.a.setContentDescription(((ProfileLabelInfo)this.a.get(paramInt)).labelName);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity.MyLabelGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */