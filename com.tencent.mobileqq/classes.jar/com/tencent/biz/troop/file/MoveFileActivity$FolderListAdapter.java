package com.tencent.biz.troop.file;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

class MoveFileActivity$FolderListAdapter
  extends BaseAdapter
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  private int b = 0;
  
  private MoveFileActivity$FolderListAdapter(MoveFileActivity paramMoveFileActivity) {}
  
  public int getCount()
  {
    return MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).size();
  }
  
  public Object getItem(int paramInt)
  {
    return MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getLayoutInflater().inflate(2131560653, MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity), false);
      paramView = new MoveFileActivity.ViewHolder(null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367056));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367055));
      paramView.b = ((TextView)localView.findViewById(2131364599));
      localView.setTag(paramView);
    }
    paramView = (MoveFileActivity.ViewHolder)localView.getTag();
    TroopFileInfo localTroopFileInfo = (TroopFileInfo)MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).get(paramInt);
    if (localTroopFileInfo != null)
    {
      if (MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity, paramInt))
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopFileInfo.c);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843883);
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131706932));
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843885);
      }
      if (paramInt == MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity)) {
        paramView.b.setVisibility(0);
      } else {
        paramView.b.setVisibility(4);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt3;
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      QLog.e("IphoneTitleBarActivity", 4, "onScrollStateChanged=SCROLL_STATE_IDLE");
      if (this.jdField_a_of_type_Int == this.b - 2)
      {
        if (MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity))
        {
          this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a(true);
          return;
        }
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a(false);
        paramAbsListView = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app;
        MoveFileActivity localMoveFileActivity = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity;
        if (TroopFileUtils.a(paramAbsListView, localMoveFileActivity, localMoveFileActivity.a) != 0) {
          this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.FolderListAdapter
 * JD-Core Version:    0.7.0.1
 */