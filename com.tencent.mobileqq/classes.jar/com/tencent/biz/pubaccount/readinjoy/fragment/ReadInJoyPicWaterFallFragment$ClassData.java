package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView.IClassData;

public class ReadInJoyPicWaterFallFragment$ClassData
  implements ChannelClassificationListView.IClassData
{
  public ChannelCoverInfo a;
  public String a;
  private boolean a;
  public String b;
  
  public ReadInJoyPicWaterFallFragment$ClassData(ChannelCoverInfo paramChannelCoverInfo, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo = paramChannelCoverInfo;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.ClassData
 * JD-Core Version:    0.7.0.1
 */