package com.tencent.biz.pubaccount.util;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;

class ReadInjoyWebShareHelper$ItemClickProcessor$1
  implements TroopMemberApiClient.Callback
{
  ReadInjoyWebShareHelper$ItemClickProcessor$1(ReadInjoyWebShareHelper.ItemClickProcessor paramItemClickProcessor, ActionItem paramActionItem) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("isSuccess");
    ReadInjoyWebShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$ItemClickProcessor.a, this.jdField_a_of_type_ComTencentBizPubaccountUtilActionItem.a, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.ItemClickProcessor.1
 * JD-Core Version:    0.7.0.1
 */