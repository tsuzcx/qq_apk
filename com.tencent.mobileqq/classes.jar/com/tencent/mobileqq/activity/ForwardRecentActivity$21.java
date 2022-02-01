package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar.ISelectedAndSearchBarCallback;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ForwardRecentActivity$21
  implements SelectedAndSearchBar.ISelectedAndSearchBarCallback
{
  ForwardRecentActivity$21(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void a(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.a.mSearchResultLayout.setVisibility(8);
    } else {
      this.a.mSearchResultLayout.setVisibility(0);
    }
    if (ForwardRecentActivity.access$2600(this.a) != null) {
      ForwardRecentActivity.access$2600(this.a).a(paramEditable);
    }
  }
  
  public void a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {
      return;
    }
    ForwardRecentActivity.access$800(this.a, paramResultRecord.uin, paramResultRecord.getUinType());
    int j = ForwardRecentActivity.access$200(this.a).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = ForwardRecentActivity.access$200(this.a).getChildAt(i);
      if ((localObject instanceof ForwardRecentItemView))
      {
        localObject = (ForwardRecentItemView)localObject;
        if ((((ForwardRecentItemView)localObject).k.uinType == paramResultRecord.uinType) && (((ForwardRecentItemView)localObject).k.uin.equals(paramResultRecord.uin))) {
          ((ForwardRecentItemView)localObject).a(false);
        }
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (ForwardRecentActivity.access$2600(this.a) == null))
    {
      Object localObject = this.a;
      ForwardRecentActivity.access$2602((ForwardRecentActivity)localObject, ContactSearchFragment.a(7, 2097177, null, null, ForwardRecentActivity.access$2700((ForwardRecentActivity)localObject)));
      localObject = new ArrayList();
      Iterator localIterator = ForwardRecentActivity.access$600(this.a).values().iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(((ResultRecord)localIterator.next()).uin);
      }
      ForwardRecentActivity.access$2600(this.a).a((List)localObject, (List)localObject);
      localObject = this.a.getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131444724, ForwardRecentActivity.access$2600(this.a));
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.21
 * JD-Core Version:    0.7.0.1
 */