package com.tencent.biz.pubaccount.ecshopassit;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Set;

class EcShopAssistantManager$2
  implements Runnable
{
  EcShopAssistantManager$2(EcShopAssistantManager paramEcShopAssistantManager) {}
  
  public void run()
  {
    synchronized (this.this$0.f)
    {
      Object[] arrayOfObject = this.this$0.g.toArray();
      if (this.this$0.c != null) {
        SharedPreferencesHandler.a(this.this$0.c.getApp().getSharedPreferences(this.this$0.c.getAccount(), 0).edit(), "ec_shop_assist_new_unread_list", arrayOfObject).commit();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.2
 * JD-Core Version:    0.7.0.1
 */