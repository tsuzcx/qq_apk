package com.tencent.biz.pubaccount.readinjoy.biu;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ReadInJoyDeliverBiuActivity$12
  implements Runnable
{
  public void run()
  {
    Object localObject = this.this$0.app.getCurrentAccountUin();
    localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + (String)localObject, 4);
    if (localObject != null)
    {
      ((SharedPreferences)localObject).edit().putString("readinjoy_deliver_biu_guide_time", this.a);
      ((SharedPreferences)localObject).edit().commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity.12
 * JD-Core Version:    0.7.0.1
 */