package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;

class SearchContactsFragment$5
  implements ViewFactory.GuideView.OnItemClickListener
{
  SearchContactsFragment$5(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("guide view | onItemClick type is:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" keyWords is:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SearchContactsFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    ((SearchContactsFragment)localObject).jdField_a_of_type_Boolean = true;
    ((SearchContactsFragment)localObject).jdField_a_of_type_Int = paramInt;
    if (paramInt == 80000001) {
      SearchUtils.a("add_page", "search", "clk_search_grp", ((SearchContactsFragment)localObject).d + 1, 0, new String[] { "", "", paramString, "" });
    }
    this.a.a(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment.5
 * JD-Core Version:    0.7.0.1
 */