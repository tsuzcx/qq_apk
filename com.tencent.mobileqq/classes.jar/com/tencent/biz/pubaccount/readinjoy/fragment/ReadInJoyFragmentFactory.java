package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import mqq.util.WeakReference;

public class ReadInJoyFragmentFactory
{
  static ReadInJoyFragmentFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyFragmentFactory;
  String jdField_a_of_type_JavaLangString = "ReadInJoyFragmentFactory";
  WeakReference jdField_a_of_type_MqqUtilWeakReference = null;
  
  public static ReadInJoyBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return ReadInJoyRecommendFeedsFragment.a();
    case 1: 
      ReadInJoyVideoChannelFragment localReadInJoyVideoChannelFragment = new ReadInJoyVideoChannelFragment();
      localReadInJoyVideoChannelFragment.a(2);
      return localReadInJoyVideoChannelFragment;
    case 2: 
      return ReadInJoyFollowFragment.a();
    }
    return new ReadInJoySelfFragment();
  }
  
  public static ReadInJoyFragmentFactory a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyFragmentFactory == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyFragmentFactory = new ReadInJoyFragmentFactory();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyFragmentFactory;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      this.jdField_a_of_type_MqqUtilWeakReference.clear();
      this.jdField_a_of_type_MqqUtilWeakReference = null;
    }
  }
  
  public void a(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramReadInJoyNewFeedsActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentFactory
 * JD-Core Version:    0.7.0.1
 */