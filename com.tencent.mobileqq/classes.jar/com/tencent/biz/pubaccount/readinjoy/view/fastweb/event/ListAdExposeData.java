package com.tencent.biz.pubaccount.readinjoy.view.fastweb.event;

import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class ListAdExposeData
  implements Comparable<ListAdExposeData>
{
  public float a;
  public int a;
  public long a;
  public AdvertisementInfo a;
  public long b = 0L;
  
  public ListAdExposeData()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
  }
  
  public int a(ListAdExposeData paramListAdExposeData)
  {
    if (this.jdField_a_of_type_Int < paramListAdExposeData.jdField_a_of_type_Int) {
      return -1;
    }
    if (this.jdField_a_of_type_Int > paramListAdExposeData.jdField_a_of_type_Int) {
      return 1;
    }
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((!(paramObject instanceof ListAdExposeData)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (((ListAdExposeData)paramObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {
      return false;
    }
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == ((ListAdExposeData)paramObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo) && (this.jdField_a_of_type_Int == ((ListAdExposeData)paramObject).jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    int i = 17;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.hashCode() + 527;
    }
    return i * 31 + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ListAdExposeData
 * JD-Core Version:    0.7.0.1
 */