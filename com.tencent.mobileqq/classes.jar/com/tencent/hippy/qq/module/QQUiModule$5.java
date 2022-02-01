package com.tencent.hippy.qq.module;

import android.content.Intent;
import android.support.v4.app.Fragment;
import awar;
import com.tencent.mtt.hippy.modules.Promise;

class QQUiModule$5
  implements awar
{
  QQUiModule$5(QQUiModule paramQQUiModule) {}
  
  public void onSharMsgcallback(String paramString1, String paramString2)
  {
    if ((QQUiModule.access$100(this.this$0) != null) && (QQUiModule.access$100(this.this$0).getCallId().equals(paramString1))) {
      QQUiModule.access$100(this.this$0).resolve(paramString2);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    Fragment localFragment = this.this$0.getFragment();
    if (localFragment != null) {
      localFragment.startActivityForResult(paramIntent, paramByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQUiModule.5
 * JD-Core Version:    0.7.0.1
 */