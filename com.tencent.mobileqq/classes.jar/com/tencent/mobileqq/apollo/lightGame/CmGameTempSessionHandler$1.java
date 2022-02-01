package com.tencent.mobileqq.apollo.lightGame;

import amuf;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;

public class CmGameTempSessionHandler$1
  implements Runnable
{
  public CmGameTempSessionHandler$1(amuf paramamuf) {}
  
  public void run()
  {
    String str = amuf.a(this.this$0).getCurrentAccountUin();
    if (TextUtils.isEmpty((CharSequence)this.this$0.a.get(str))) {
      this.this$0.a.put(str, amuf.a(this.this$0).getCurrentNickname());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler.1
 * JD-Core Version:    0.7.0.1
 */