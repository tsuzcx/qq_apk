package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;

class PublicAccountDetailActivityImpl$ActionSheetBuilder
{
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  
  public PublicAccountDetailActivityImpl$ActionSheetBuilder(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl, ActionSheet paramActionSheet)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramActionSheet;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(paramInt1, paramInt2);
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt1));
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new PublicAccountDetailActivityImpl.ActionSheetBuilder.1(this));
  }
  
  public ActionSheet a()
  {
    g();
    return this.jdField_a_of_type_ComTencentWidgetActionSheet;
  }
  
  public void a()
  {
    a(2131695253, 5);
  }
  
  public void b()
  {
    a(2131695238, 5);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailActivityImpl.needShowUnFollowBtnInActionSheet()) {
      a(2131695271, 3);
    }
  }
  
  public void d()
  {
    PublicAccountDetailActivityImpl localPublicAccountDetailActivityImpl = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailActivityImpl;
    if (PublicAccountDetailActivityImpl.access$900(localPublicAccountDetailActivityImpl, localPublicAccountDetailActivityImpl.uin))
    {
      a(2131695172, 5);
      return;
    }
    a(2131695250, 5);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailActivityImpl.needShowUnFollowBtnInActionSheet()) && (PublicAccountUtilImpl.getMessageSetting(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailActivityImpl.accountDetail) != null)) {
      a(2131695249, 5);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690728);
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2131690728));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.ActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */