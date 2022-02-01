package com.tencent.mobileqq.apollo.lightGame;

import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;

class CmGameTempSessionHandler$1
  implements Runnable
{
  CmGameTempSessionHandler$1(CmGameTempSessionHandler paramCmGameTempSessionHandler) {}
  
  public void run()
  {
    String str = CmGameTempSessionHandler.a(this.this$0).getCurrentAccountUin();
    if (TextUtils.isEmpty((CharSequence)this.this$0.a.get(str))) {
      this.this$0.a.put(str, CmGameTempSessionHandler.a(this.this$0).getCurrentNickname());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler.1
 * JD-Core Version:    0.7.0.1
 */