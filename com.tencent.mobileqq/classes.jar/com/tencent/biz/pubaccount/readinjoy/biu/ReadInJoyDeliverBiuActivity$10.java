package com.tencent.biz.pubaccount.readinjoy.biu;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ReadInJoyDeliverBiuActivity$10
  implements Runnable
{
  ReadInJoyDeliverBiuActivity$10(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void run()
  {
    Object localObject = this.this$0.app.getCurrentAccountUin();
    localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + (String)localObject, 4);
    if (localObject != null)
    {
      int i = ((SharedPreferences)localObject).getInt("readinjoy_deliver_biu_numbers", 0);
      if (i <= 6)
      {
        ((SharedPreferences)localObject).edit().putInt("readinjoy_deliver_biu_numbers", i + 1);
        ((SharedPreferences)localObject).edit().commit();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity.10
 * JD-Core Version:    0.7.0.1
 */