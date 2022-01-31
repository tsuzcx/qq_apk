package com.tencent.biz.pubaccount.ecshopassit;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import baih;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Set;
import nfp;

public class EcShopAssistantManager$2
  implements Runnable
{
  public EcShopAssistantManager$2(nfp paramnfp) {}
  
  public void run()
  {
    synchronized (this.this$0.b)
    {
      Object[] arrayOfObject = this.this$0.jdField_a_of_type_JavaUtilSet.toArray();
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        baih.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit(), "ec_shop_assist_new_unread_list", arrayOfObject).commit();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.2
 * JD-Core Version:    0.7.0.1
 */