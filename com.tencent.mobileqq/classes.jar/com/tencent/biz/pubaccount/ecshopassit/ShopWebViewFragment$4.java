package com.tencent.biz.pubaccount.ecshopassit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

class ShopWebViewFragment$4
  extends BroadcastReceiver
{
  ShopWebViewFragment$4(ShopWebViewFragment paramShopWebViewFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getAction();
    Object localObject = paramIntent.getStringExtra("uin");
    Bitmap localBitmap = (Bitmap)paramIntent.getParcelableExtra("bitmap");
    if ("action_decode_finish".equals(paramContext))
    {
      if ((this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool != null) && (!TextUtils.isEmpty((CharSequence)localObject)) && (localBitmap != null)) {
        this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a((String)localObject, localBitmap);
      }
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopFolderAdapter != null) {
        this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopFolderAdapter.a((String)localObject);
      }
    }
    else if ("action_on_shop_msg_receive".equals(paramContext))
    {
      this.a.jdField_a_of_type_JavaUtilList = paramIntent.getParcelableArrayListExtra("datas");
      paramContext = this.a.getQBaseActivity();
      if ((paramContext instanceof EcshopWebActivity)) {
        ((EcshopWebActivity)paramContext).jdField_a_of_type_JavaUtilList = this.a.jdField_a_of_type_JavaUtilList;
      }
      paramContext = paramIntent.getStringExtra("uin");
      paramIntent = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (paramIntent.hasNext())
      {
        localObject = (RecentShopParcel)paramIntent.next();
        if ((!TextUtils.isEmpty(((RecentShopParcel)localObject).a)) && (((RecentShopParcel)localObject).a.equals(paramContext))) {
          ((RecentShopParcel)localObject).b += 1;
        }
      }
      if ((this.a.b == 1) && (this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopFolderAdapter != null)) {
        this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopFolderAdapter.a(this.a.jdField_a_of_type_JavaUtilList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment.4
 * JD-Core Version:    0.7.0.1
 */