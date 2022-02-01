package com.tencent.av.wtogether.view;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class GroupFileSearchDialog$2
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  int b = 0;
  
  GroupFileSearchDialog$2(GroupFileSearchDialog paramGroupFileSearchDialog) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt3;
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    for (;;)
    {
      try
      {
        int i = this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileSearchDialog.jdField_a_of_type_Int;
        if (i > 0) {
          return;
        }
        if ((paramInt != 0) || (this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileSearchDialog.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Int != this.b - 2)) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileSearchDialog.f)
        {
          this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileSearchDialog.c(true);
          continue;
        }
        this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileSearchDialog.c(false);
      }
      finally {}
      this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileSearchDialog.a(this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileSearchDialog.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileSearchDialog.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileSearchDialog.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvWtogetherViewGroupFileSearchDialog.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.2
 * JD-Core Version:    0.7.0.1
 */