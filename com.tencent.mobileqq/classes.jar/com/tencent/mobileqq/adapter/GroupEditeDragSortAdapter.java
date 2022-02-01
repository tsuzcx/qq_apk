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
  private DragSortListView a;
  
  public GroupEditeDragSortAdapter(Context paramContext, List<T> paramList, DragSortListView paramDragSortListView)
  {
    super(paramContext, paramList);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = paramDragSortListView;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null) {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561595, null);
    } else {
      localView = paramView;
    }
    localView.setVisibility(0);
    localView.findViewById(2131377351).setVisibility(8);
    Object localObject = (TextView)localView.findViewById(2131367848);
    Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((TextView)localObject).setText(localGroups.group_name);
    ViewCompat.setImportantForAccessibility(localView.findViewById(2131367852), 1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localGroups.group_name);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131705439));
    localView.setContentDescription(((StringBuilder)localObject).toString());
    if ((VersionUtils.m()) && (AppSetting.d)) {
      localView.setOnClickListener(this);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    if (AppSetting.d) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.GroupEditeDragSortAdapter
 * JD-Core Version:    0.7.0.1
 */