package com.tencent.biz.publicAccountImageCollection;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class PublicAccountImageCollectionMainActivity$16
  implements Runnable
{
  PublicAccountImageCollectionMainActivity$16(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.this$0.a)) {}
    PublicAccountDataManager localPublicAccountDataManager;
    do
    {
      return;
      localPublicAccountDataManager = (PublicAccountDataManager)this.this$0.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    } while (localPublicAccountDataManager == null);
    PublicAccountImageCollectionMainActivity.c(this.this$0, localPublicAccountDataManager.a(Long.valueOf(this.this$0.a)));
    PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.16.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.16
 * JD-Core Version:    0.7.0.1
 */