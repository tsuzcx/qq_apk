package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter.DisplayData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

class ForwardRecentActivity$3
  extends DataSetObserver
{
  ForwardRecentActivity$3(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onChanged()
  {
    super.onChanged();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onChanged() called ");
      ((StringBuilder)localObject1).append(System.identityHashCode(this.a));
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.a.mReq == 2)
    {
      localObject1 = ForwardRecentActivity.access$100(this.a);
      this.a.getIntent().putParcelableArrayListExtra("result_set", (ArrayList)localObject1);
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    if (this.a.mReq == 1)
    {
      localObject1 = ForwardRecentActivity.access$200(this.a).getAdapter();
      int k = ((ListAdapter)localObject1).getCount();
      String str = this.a.getIntent().getStringExtra("key_direct_show_uin");
      Object localObject2 = this.a.getIntent();
      int j = 0;
      int m = ((Intent)localObject2).getIntExtra("key_direct_show_uin_type", 0);
      int i = j;
      if (6000 == m)
      {
        i = j;
        if (TextUtils.equals(AppConstants.DATALINE_PC_UIN, str))
        {
          i = j;
          if (ForwardRecentActivity.access$300(this.a) != null)
          {
            ForwardRecentActivity.access$300(this.a).callOnClick();
            return;
          }
        }
      }
      while (i < k)
      {
        localObject2 = ((ListAdapter)localObject1).getItem(i);
        if ((localObject2 instanceof ForwardRecentListAdapter.DisplayData))
        {
          localObject2 = (ForwardRecentListAdapter.DisplayData)localObject2;
          if ((((ForwardRecentListAdapter.DisplayData)localObject2).d != null) && (TextUtils.equals(((ForwardRecentListAdapter.DisplayData)localObject2).d.uin, str)) && (m == ((ForwardRecentListAdapter.DisplayData)localObject2).d.getType()))
          {
            localObject1 = ((ListAdapter)localObject1).getView(i, null, ForwardRecentActivity.access$200(this.a));
            this.a.onListViewItemClickedInDefaultStatus((View)localObject1);
            return;
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.3
 * JD-Core Version:    0.7.0.1
 */