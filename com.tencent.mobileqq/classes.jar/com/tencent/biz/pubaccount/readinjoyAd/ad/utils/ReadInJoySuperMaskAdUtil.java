package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

public class ReadInJoySuperMaskAdUtil
{
  private static volatile ReadInJoySuperMaskAdUtil jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoySuperMaskAdUtil;
  public static boolean a = false;
  ReadInJoySuperMaskAdUtil.RIJSuperMaskAdEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoySuperMaskAdUtil$RIJSuperMaskAdEventListener = null;
  
  public static ReadInJoySuperMaskAdUtil a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoySuperMaskAdUtil == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoySuperMaskAdUtil == null) {
          jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoySuperMaskAdUtil = new ReadInJoySuperMaskAdUtil();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoySuperMaskAdUtil;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoySuperMaskAdUtil$RIJSuperMaskAdEventListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoySuperMaskAdUtil$RIJSuperMaskAdEventListener = null;
    }
  }
  
  public void a(int paramInt)
  {
    ReadInJoySuperMaskAdUtil.RIJSuperMaskAdEventListener localRIJSuperMaskAdEventListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoySuperMaskAdUtil$RIJSuperMaskAdEventListener;
    if (localRIJSuperMaskAdEventListener != null) {
      localRIJSuperMaskAdEventListener.a(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ReadInJoySuperMaskAdUtil.RIJSuperMaskAdEventListener localRIJSuperMaskAdEventListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoySuperMaskAdUtil$RIJSuperMaskAdEventListener;
    if (localRIJSuperMaskAdEventListener != null) {
      localRIJSuperMaskAdEventListener.a(paramInt, paramBoolean);
    }
  }
  
  public void a(ReadInJoySuperMaskAdUtil.RIJSuperMaskAdEventListener paramRIJSuperMaskAdEventListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsReadInJoySuperMaskAdUtil$RIJSuperMaskAdEventListener = paramRIJSuperMaskAdEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil
 * JD-Core Version:    0.7.0.1
 */