package com.tencent.biz.pubaccount.readinjoy.activity;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyArticleDetailActivity$4
  implements TroopMemberApiClient.Callback
{
  ReadInJoyArticleDetailActivity$4(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public void callback(Bundle paramBundle)
  {
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      ReadInJoyArticleDetailActivity.a(this.a, paramBundle.getByteArray("decryptResult"));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetail", 2, "请求返回时间" + System.currentTimeMillis());
      }
      if (ReadInJoyArticleDetailActivity.a(this.a) == null) {
        this.a.jdField_a_of_type_JavaLangString = null;
      }
      this.a.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity.4
 * JD-Core Version:    0.7.0.1
 */