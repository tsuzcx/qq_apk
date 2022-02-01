package com.tencent.ad.tangram.views.button;

import android.widget.TextView;

class a$1
  implements Runnable
{
  a$1(a parama, a.a parama1) {}
  
  public void run()
  {
    TextView localTextView = a.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("版本 ");
    localStringBuilder.append(this.val$params.version);
    localTextView.setText(localStringBuilder.toString());
    a.access$000(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.a.1
 * JD-Core Version:    0.7.0.1
 */