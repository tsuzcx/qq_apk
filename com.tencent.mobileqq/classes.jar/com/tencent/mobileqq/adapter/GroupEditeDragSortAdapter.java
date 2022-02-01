package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.util.List;

public class GroupEditeDragSortAdapter<T>
  extends DragSortAdapter<T>
  implements View.OnClickListener
{
  private DragSortListView f;
  
  public GroupEditeDragSortAdapter(Context paramContext, List<T> paramList, DragSortListView paramDragSortListView)
  {
    super(paramContext, paramList);
    this.f = paramDragSortListView;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null) {
      localView = View.inflate(this.b, 2131627958, null);
    } else {
      localView = paramView;
    }
    localView.setVisibility(0);
    localView.findViewById(2131445741).setVisibility(8);
    Object localObject = (TextView)localView.findViewById(2131434428);
    Groups localGroups = (Groups)this.a.get(paramInt);
    ((TextView)localObject).setText(localGroups.group_name);
    ViewCompat.setImportantForAccessibility(localView.findViewById(2131434432), 1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localGroups.group_name);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131903327));
    localView.setContentDescription(((StringBuilder)localObject).toString());
    if ((VersionUtils.m()) && (AppSetting.e)) {
      localView.setOnClickListener(this);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    if (AppSetting.e) {
      this.f.i();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.GroupEditeDragSortAdapter
 * JD-Core Version:    0.7.0.1
 */