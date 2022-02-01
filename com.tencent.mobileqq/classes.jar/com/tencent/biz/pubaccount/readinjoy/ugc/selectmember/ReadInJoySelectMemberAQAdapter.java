package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.widget.CheckBox;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ExpandableListView;
import java.util.List;

public class ReadInJoySelectMemberAQAdapter
  extends SelectMemberBuddyListAdapter
{
  private SelectMemberLimit a;
  
  public ReadInJoySelectMemberAQAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean, SelectMemberLimit paramSelectMemberLimit)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView, paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit = paramSelectMemberLimit;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.b()))
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718365, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.c()) });
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718359), 0).a();
  }
  
  protected void a(SelectMemberBuddyListAdapter.SelectBuddyChildTag paramSelectBuddyChildTag, Friends paramFriends)
  {
    if ((paramFriends == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a() == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a().isEmpty())) {
      return;
    }
    paramSelectBuddyChildTag.a.setBackgroundResource(2130849797);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a().contains(paramFriends.uin))
    {
      paramSelectBuddyChildTag.a.setEnabled(false);
      return;
    }
    paramSelectBuddyChildTag.a.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQAdapter
 * JD-Core Version:    0.7.0.1
 */