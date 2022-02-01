package com.tencent.mobileqq.activity.contact.addcontact;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.HotRecommendGroupListAdapter.OnItemClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class SearchContactsFragment$4
  implements HotRecommendGroupListAdapter.OnItemClickListener
{
  SearchContactsFragment$4(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void a(String paramString)
  {
    SearchContactsFragment localSearchContactsFragment = this.a;
    localSearchContactsFragment.jdField_a_of_type_Boolean = true;
    localSearchContactsFragment.jdField_a_of_type_Int = 80000001;
    if (!TextUtils.isEmpty(paramString))
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "add_page", "", "search_grp", "clk_label", 0, 0, "", "", paramString, "");
      localSearchContactsFragment = this.a;
      localSearchContactsFragment.d = false;
      localSearchContactsFragment.a(paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment.4
 * JD-Core Version:    0.7.0.1
 */