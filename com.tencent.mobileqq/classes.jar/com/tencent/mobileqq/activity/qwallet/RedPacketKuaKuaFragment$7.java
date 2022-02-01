package com.tencent.mobileqq.activity.qwallet;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.EditText;

class RedPacketKuaKuaFragment$7
  implements Runnable
{
  RedPacketKuaKuaFragment$7(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
  public void run()
  {
    if ((!this.this$0.b()) && (!TextUtils.isEmpty(RedPacketKuaKuaFragment.a(this.this$0).getText().toString()))) {
      RedPacketKuaKuaFragment.a(this.this$0).sendEmptyMessage(10000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment.7
 * JD-Core Version:    0.7.0.1
 */