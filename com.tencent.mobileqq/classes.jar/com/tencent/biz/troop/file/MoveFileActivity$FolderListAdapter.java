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
  private int b = 0;
  private int c = 0;
  
  private MoveFileActivity$FolderListAdapter(MoveFileActivity paramMoveFileActivity) {}
  
  public int getCount()
  {
    return MoveFileActivity.b(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return MoveFileActivity.b(this.a).get(paramInt);
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
      localView = this.a.getLayoutInflater().inflate(2131626698, MoveFileActivity.c(this.a), false);
      paramView = new MoveFileActivity.ViewHolder(null);
      paramView.a = ((TextView)localView.findViewById(2131433505));
      paramView.b = ((ImageView)localView.findViewById(2131433504));
      paramView.c = ((TextView)localView.findViewById(2131430669));
      localView.setTag(paramView);
    }
    paramView = (MoveFileActivity.ViewHolder)localView.getTag();
    TroopFileInfo localTroopFileInfo = (TroopFileInfo)MoveFileActivity.b(this.a).get(paramInt);
    if (localTroopFileInfo != null)
    {
      if (MoveFileActivity.a(this.a, paramInt))
      {
        paramView.a.setText(localTroopFileInfo.d);
        paramView.b.setImageResource(2130844838);
      }
      else
      {
        paramView.a.setText(HardCodeUtil.a(2131904775));
        paramView.b.setImageResource(2130844840);
      }
      if (paramInt == MoveFileActivity.d(this.a)) {
        paramView.c.setVisibility(0);
      } else {
        paramView.c.setVisibility(4);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt3;
    this.b = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      QLog.e("IphoneTitleBarActivity", 4, "onScrollStateChanged=SCROLL_STATE_IDLE");
      if (this.b == this.c - 2)
      {
        if (MoveFileActivity.e(this.a))
        {
          this.a.a(true);
          return;
        }
        this.a.a(false);
        paramAbsListView = this.a.app;
        MoveFileActivity localMoveFileActivity = this.a;
        if (TroopFileUtils.a(paramAbsListView, localMoveFileActivity, localMoveFileActivity.a) != 0) {
          this.a.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.FolderListAdapter
 * JD-Core Version:    0.7.0.1
 */