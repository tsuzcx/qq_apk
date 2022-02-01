package com.tencent.biz.qqstory.takevideo;

import com.tencent.util.InputMethodUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

class EditVideoPoiSearch$2
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  EditVideoPoiSearch$2(EditVideoPoiSearch paramEditVideoPoiSearch) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      InputMethodUtil.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.a().a());
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.a == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.a.size())) {
      return;
    }
    EditVideoPoiSearch.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPoiSearch.2
 * JD-Core Version:    0.7.0.1
 */