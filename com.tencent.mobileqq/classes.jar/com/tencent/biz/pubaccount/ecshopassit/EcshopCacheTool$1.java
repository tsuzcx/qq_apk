package com.tencent.biz.pubaccount.ecshopassit;

import android.support.v4.app.FragmentActivity;
import awbw;
import com.tencent.mobileqq.data.Friends;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nun;

public class EcshopCacheTool$1
  implements Runnable
{
  public EcshopCacheTool$1(nun paramnun) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_Awbw.a(Friends.class, " SELECT * FROM Friends ", new String[0]);
    this.this$0.jdField_a_of_type_JavaUtilMap = new HashMap();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Friends localFriends = (Friends)((Iterator)localObject).next();
        this.this$0.jdField_a_of_type_JavaUtilMap.put(localFriends.uin, localFriends);
      }
    }
    if ((this.this$0.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment != null) && (this.this$0.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.a != null)) {
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.getActivity().runOnUiThread(new EcshopCacheTool.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopCacheTool.1
 * JD-Core Version:    0.7.0.1
 */