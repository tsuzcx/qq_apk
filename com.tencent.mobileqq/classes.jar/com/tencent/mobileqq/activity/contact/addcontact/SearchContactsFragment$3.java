package com.tencent.mobileqq.activity.contact.addcontact;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchHistoryListAdapter.OnItemClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class SearchContactsFragment$3
  implements GroupSearchHistoryListAdapter.OnItemClickListener
{
  SearchContactsFragment$3(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void a(String paramString)
  {
    SearchContactsFragment localSearchContactsFragment = this.a;
    localSearchContactsFragment.a = true;
    localSearchContactsFragment.b = 80000001;
    if (!TextUtils.isEmpty(paramString))
    {
      ReportController.b(this.a.r, "dc00899", "add_page", "", "search_grp", "clk_history", 0, 0, "", "", paramString, "");
      this.a.a(paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment.3
 * JD-Core Version:    0.7.0.1
 */