package com.tencent.biz.qqstory.takevideo.permission;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PermissionListAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener, PermissionPart.PartCallback
{
  private int jdField_a_of_type_Int;
  private List<PermissionPart> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public PermissionListAdapter(@NonNull List<PermissionPart> paramList)
  {
    if (paramList.isEmpty()) {
      SLog.d("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    a();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((PermissionPart)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private PermissionListAdapter.PartInfo a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      PermissionPart localPermissionPart = (PermissionPart)localIterator.next();
      j = localPermissionPart.a() + i;
      if (paramInt <= j - 1) {
        return new PermissionListAdapter.PartInfo(localPermissionPart, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((PermissionPart)localIterator.next()).a() + i) {}
    this.jdField_a_of_type_Int = i;
  }
  
  @Nullable
  public PermissionPart a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      PermissionPart localPermissionPart = (PermissionPart)localIterator.next();
      if (localPermissionPart.a) {
        return localPermissionPart;
      }
    }
    return null;
  }
  
  public void a(PermissionPart paramPermissionPart)
  {
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    PermissionListAdapter.PartInfo localPartInfo = a(paramInt);
    return localPartInfo.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionPermissionPart.a(localPartInfo.jdField_a_of_type_Int);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PermissionListAdapter.PartInfo localPartInfo = a(paramInt);
    PermissionPart localPermissionPart = localPartInfo.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionPermissionPart;
    int i = localPartInfo.jdField_a_of_type_Int;
    if (paramView == null) {
      paramView = localPermissionPart.a(i, paramViewGroup);
    }
    for (;;)
    {
      localPermissionPart.a(i, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = a(paramInt);
    PermissionPart localPermissionPart1 = ((PermissionListAdapter.PartInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionPermissionPart;
    localPermissionPart1.a(((PermissionListAdapter.PartInfo)localObject).jdField_a_of_type_Int);
    if ((localPermissionPart1 instanceof EmptyPart)) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localPermissionPart1.b(true);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PermissionPart localPermissionPart2 = (PermissionPart)((Iterator)localObject).next();
        if (localPermissionPart2 != localPermissionPart1)
        {
          localPermissionPart2.b(false);
          localPermissionPart2.a(false);
        }
      }
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.permission.PermissionListAdapter
 * JD-Core Version:    0.7.0.1
 */