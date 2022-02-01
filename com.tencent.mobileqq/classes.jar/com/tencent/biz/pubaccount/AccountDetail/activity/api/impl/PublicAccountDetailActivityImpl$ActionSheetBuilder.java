package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.qroute.QRoute;
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
    a(2131695257, 5);
  }
  
  public void b()
  {
    a(2131695242, 5);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl.needShowUnFollowBtnInActionSheet()) {
      a(2131695268, 3);
    }
  }
  
  public void d()
  {
    if (PublicAccountDetailActivityImpl.access$900(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl.uin))
    {
      a(2131695181, 5);
      return;
    }
    a(2131695254, 5);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl.needShowUnFollowBtnInActionSheet()) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getMessageSetting(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl.accountDetail) != null)) {
      a(2131695253, 5);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690800);
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2131690800));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.ActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */