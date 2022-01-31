package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import java.util.List;

public class GroupEditeDragSortAdapter
  extends DragSortAdapter
{
  public GroupEditeDragSortAdapter(Context paramContext, List paramList)
  {
    super(paramContext, paramList);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130970372, null);
    }
    paramViewGroup.setVisibility(0);
    paramViewGroup.findViewById(2131362746).setVisibility(8);
    paramView = (TextView)paramViewGroup.findViewById(2131370200);
    Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramView.setText(localGroups.group_name);
    ViewCompat.setImportantForAccessibility(paramViewGroup.findViewById(2131370198), 1);
    paramViewGroup.setContentDescription(localGroups.group_name + "分组");
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.GroupEditeDragSortAdapter
 * JD-Core Version:    0.7.0.1
 */