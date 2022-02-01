package com.tencent.gamecenter.wadl.biz.jsplugin;

import android.widget.Toast;
import com.tencent.open.adapter.CommonDataAdapter;

class WadlWebViewJsPlugin$2
  implements Runnable
{
  WadlWebViewJsPlugin$2(WadlWebViewJsPlugin paramWadlWebViewJsPlugin, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a == null)
    {
      this.this$0.a = Toast.makeText(CommonDataAdapter.a().a(), this.a, 0);
      this.this$0.a.show();
      return;
    }
    this.this$0.a.setText(this.a);
    this.this$0.a.setDuration(0);
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.jsplugin.WadlWebViewJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */