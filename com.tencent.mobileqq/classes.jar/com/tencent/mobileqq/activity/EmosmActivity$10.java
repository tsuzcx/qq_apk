package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.model.QueryCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EmosmActivity$10
  implements QueryCallback<List<EmoticonPackage>>
{
  EmosmActivity$10(EmosmActivity paramEmosmActivity) {}
  
  public void a(List<EmoticonPackage> paramList)
  {
    this.a.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a();
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      EmoticonPackage localEmoticonPackage;
      if (this.a.b == 1)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)paramList.next();
          if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
            this.a.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
      if (this.a.b == 2)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)paramList.next();
          if ((3 == localEmoticonPackage.jobType) || (5 == localEmoticonPackage.jobType)) {
            this.a.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
    }
    if (this.a.b == 1)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.findHeaderViewPosition(this.a.jdField_a_of_type_AndroidViewView) == -1) {
        this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView(this.a.jdField_a_of_type_AndroidViewView);
      }
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.a.d();
      if (this.a.b != 2) {
        break label344;
      }
      this.a.setTitle(2131691996);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
      }
      return;
      if (this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.removeHeaderView(this.a.jdField_a_of_type_AndroidViewView);
      break;
      label344:
      this.a.setTitle(2131692210);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.10
 * JD-Core Version:    0.7.0.1
 */