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
      if ((this.a.g != null) && (!TextUtils.isEmpty((CharSequence)localObject)) && (localBitmap != null)) {
        this.a.g.a((String)localObject, localBitmap);
      }
      if (this.a.k != null) {
        this.a.k.a((String)localObject);
      }
    }
    else if ("action_on_shop_msg_receive".equals(paramContext))
    {
      this.a.f = paramIntent.getParcelableArrayListExtra("datas");
      paramContext = this.a.getQBaseActivity();
      if ((paramContext instanceof EcshopWebActivity)) {
        ((EcshopWebActivity)paramContext).b = this.a.f;
      }
      paramContext = paramIntent.getStringExtra("uin");
      paramIntent = this.a.f.iterator();
      while (paramIntent.hasNext())
      {
        localObject = (RecentShopParcel)paramIntent.next();
        if ((!TextUtils.isEmpty(((RecentShopParcel)localObject).a)) && (((RecentShopParcel)localObject).a.equals(paramContext))) {
          ((RecentShopParcel)localObject).g += 1;
        }
      }
      if ((this.a.l == 1) && (this.a.k != null)) {
        this.a.k.a(this.a.f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment.4
 * JD-Core Version:    0.7.0.1
 */