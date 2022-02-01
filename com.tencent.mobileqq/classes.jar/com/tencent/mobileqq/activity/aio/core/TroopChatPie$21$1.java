package com.tencent.mobileqq.activity.aio.core;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;

class TroopChatPie$21$1
  implements Runnable
{
  TroopChatPie$21$1(TroopChatPie.21 param21, String paramString) {}
  
  public void run()
  {
    this.b.a.I.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    TextView localTextView = this.b.a.I;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.a.f.getResources().getString(2131886658));
    localStringBuilder.append(this.a);
    localTextView.setText(localStringBuilder.toString());
    this.b.a.q.setOnClickListener(null);
    this.b.a.r.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.21.1
 * JD-Core Version:    0.7.0.1
 */