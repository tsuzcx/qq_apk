package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup;
import java.util.List;

public class ReadInJoyProteusFamilyViewController
  extends ReadInJoyBaseViewController
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private boolean jdField_a_of_type_Boolean = false;
  private View b;
  
  public ReadInJoyProteusFamilyViewController(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.b = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374174);
    }
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyProteusFamilyListViewGroup(this, 0, 0, 0, null, 2131560400);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = ((ReadInJoyProteusFamilyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    i();
  }
  
  public void a(boolean paramBoolean, List<BaseArticleInfo> paramList)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a();
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.b != null) {
      this.b.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null)
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup);
        }
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, localLayoutParams);
      }
      ((ReadInJoyProteusFamilyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(true, paramList);
    }
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyProteusFamilyViewController
 * JD-Core Version:    0.7.0.1
 */