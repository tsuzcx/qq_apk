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
    MoveFileActivity.ViewHolder localViewHolder;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getLayoutInflater().inflate(2131560765, MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity), false);
      localViewHolder = new MoveFileActivity.ViewHolder(null);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367273));
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367272));
      localViewHolder.b = ((TextView)paramView.findViewById(2131364712));
      paramView.setTag(localViewHolder);
    }
    for (;;)
    {
      localViewHolder = (MoveFileActivity.ViewHolder)paramView.getTag();
      TroopFileInfo localTroopFileInfo = (TroopFileInfo)MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).get(paramInt);
      if (localTroopFileInfo != null)
      {
        if (!MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity, paramInt)) {
          break label183;
        }
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopFileInfo.c);
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843963);
        if (paramInt != MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity)) {
          break label209;
        }
        localViewHolder.b.setVisibility(0);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label183:
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131706910));
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843965);
        break;
        label209:
        localViewHolder.b.setVisibility(4);
      }
    }
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
        if (!MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity)) {
          break label44;
        }
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a(true);
      }
    }
    label44:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a(false);
    } while (TroopFileUtils.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity, this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a) == 0);
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.FolderListAdapter
 * JD-Core Version:    0.7.0.1
 */