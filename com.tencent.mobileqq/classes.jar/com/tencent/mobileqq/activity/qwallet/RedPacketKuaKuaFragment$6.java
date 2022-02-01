package com.tencent.mobileqq.activity.qwallet;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.EditText;

class RedPacketKuaKuaFragment$6
  implements Runnable
{
  RedPacketKuaKuaFragment$6(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
  public void run()
  {
    if ((!this.this$0.b()) && (!TextUtils.isEmpty(this.this$0.a.getText().toString()))) {
      RedPacketKuaKuaFragment.a(this.this$0).sendEmptyMessage(10000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment.6
 * JD-Core Version:    0.7.0.1
 */