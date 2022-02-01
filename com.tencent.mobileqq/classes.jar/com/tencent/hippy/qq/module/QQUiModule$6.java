package com.tencent.hippy.qq.module;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.jsp.ShareMsgImpl.ShareMsgImplListener;
import com.tencent.mtt.hippy.modules.Promise;

class QQUiModule$6
  implements ShareMsgImpl.ShareMsgImplListener
{
  QQUiModule$6(QQUiModule paramQQUiModule) {}
  
  public void onSharMsgcallback(String paramString1, String paramString2)
  {
    if ((QQUiModule.access$500(this.this$0) != null) && (QQUiModule.access$500(this.this$0).getCallId().equals(paramString1))) {
      QQUiModule.access$500(this.this$0).resolve(paramString2);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    QBaseFragment localQBaseFragment = this.this$0.getFragment();
    if (localQBaseFragment != null) {
      localQBaseFragment.startActivityForResult(paramIntent, paramByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQUiModule.6
 * JD-Core Version:    0.7.0.1
 */