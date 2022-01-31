package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import nrt;
import ntd;

class ReadInJoyVideoSubChannelActivity$9
  implements Runnable
{
  ReadInJoyVideoSubChannelActivity$9(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity, ChannelInfo paramChannelInfo, boolean paramBoolean) {}
  
  public void run()
  {
    String str1 = "3";
    if ((ReadInJoyVideoSubChannelActivity.b(this.this$0) == 4) || (ReadInJoyVideoSubChannelActivity.b(this.this$0) == 6))
    {
      str1 = "0";
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mIsTopic) {
        break label119;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label113;
      }
    }
    label113:
    for (String str2 = "1";; str2 = "2")
    {
      nrt.a(null, "", "0X80088BC", "0X80088BC", 0, 0, str2, str1, "", ntd.a(ReadInJoyVideoSubChannelActivity.a(this.this$0), null), false);
      return;
      if (ReadInJoyVideoSubChannelActivity.b(this.this$0) == 8)
      {
        str1 = "1";
        break;
      }
      if (ReadInJoyVideoSubChannelActivity.b(this.this$0) != 4) {
        break;
      }
      str1 = "2";
      break;
    }
    label119:
    if (this.jdField_a_of_type_Boolean) {}
    for (str2 = "1";; str2 = "2")
    {
      nrt.a(null, "", "0X8007BFE", "0X8007BFE", 0, 0, str2, str1, "", ntd.a(ReadInJoyVideoSubChannelActivity.a(this.this$0), null), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity.9
 * JD-Core Version:    0.7.0.1
 */