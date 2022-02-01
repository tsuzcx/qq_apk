package com.tencent.biz.publicAccountImageCollection;

import android.os.Handler;
import android.text.TextUtils;
import aody;
import com.tencent.mobileqq.app.QQAppInterface;

class PublicAccountImageCollectionMainActivity$16
  implements Runnable
{
  PublicAccountImageCollectionMainActivity$16(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.this$0.a)) {}
    aody localaody;
    do
    {
      return;
      localaody = (aody)this.this$0.app.getManager(56);
    } while (localaody == null);
    PublicAccountImageCollectionMainActivity.c(this.this$0, localaody.a(Long.valueOf(this.this$0.a)));
    PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.16.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.16
 * JD-Core Version:    0.7.0.1
 */