package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.FollowingMember;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;

public class FollowingSearchResultModel
  implements ISearchResultModel
{
  private FollowingMember jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFollowingMember;
  private String jdField_a_of_type_JavaLangString;
  
  public FollowingSearchResultModel(FollowingMember paramFollowingMember)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFollowingMember = paramFollowingMember;
  }
  
  public int a()
  {
    return 0;
  }
  
  public FollowingMember a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFollowingMember;
  }
  
  public CharSequence a()
  {
    return SearchUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFollowingMember.a(), this.jdField_a_of_type_JavaLangString, 6, true);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(View paramView) {}
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFollowingMember.a().contains(paramString);
  }
  
  public int b()
  {
    return 0;
  }
  
  public CharSequence b()
  {
    return "";
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFollowingMember.a().toString();
  }
  
  public int c()
  {
    return 0;
  }
  
  public CharSequence c()
  {
    return HardCodeUtil.a(2131704695);
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.FollowingSearchResultModel
 * JD-Core Version:    0.7.0.1
 */