package com.tencent.biz.publicAccountImageCollection;

import alzl;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;

class PublicAccountImageCollectionMainActivity$16
  implements Runnable
{
  PublicAccountImageCollectionMainActivity$16(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.this$0.a)) {}
    alzl localalzl;
    do
    {
      return;
      localalzl = (alzl)this.this$0.app.getManager(56);
    } while (localalzl == null);
    PublicAccountImageCollectionMainActivity.c(this.this$0, localalzl.a(Long.valueOf(this.this$0.a)));
    PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.16.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.16
 * JD-Core Version:    0.7.0.1
 */