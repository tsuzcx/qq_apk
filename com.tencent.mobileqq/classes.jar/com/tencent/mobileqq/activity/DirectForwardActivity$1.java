package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import bahm;
import bdgc;
import com.tencent.mobileqq.app.QQAppInterface;

class DirectForwardActivity$1
  implements Runnable
{
  DirectForwardActivity$1(DirectForwardActivity paramDirectForwardActivity, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    String str = ((bahm)this.this$0.app.a(122)).a(this.jdField_a_of_type_JavaLangString, this.b, this.c);
    if (TextUtils.isEmpty(str))
    {
      this.this$0.finish();
      return;
    }
    this.this$0.getIntent().putExtra("uinname", bdgc.a(this.this$0.app, str, this.jdField_a_of_type_Int));
    this.this$0.getIntent().putExtra("uin", str);
    this.this$0.runOnUiThread(new DirectForwardActivity.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DirectForwardActivity.1
 * JD-Core Version:    0.7.0.1
 */