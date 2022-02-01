package com.tencent.biz.pubaccount.ecshopassit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;

class BusinessBrowser$BusinessBrowserFragment$4
  extends BroadcastReceiver
{
  BusinessBrowser$BusinessBrowserFragment$4(BusinessBrowser.BusinessBrowserFragment paramBusinessBrowserFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("action_decode_finish".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("uin");
      paramIntent = (Bitmap)paramIntent.getParcelableExtra("bitmap");
      if ((this.a.f != null) && (this.a.f.equals(paramContext)) && (paramIntent != null)) {
        this.a.c.setImageBitmap(paramIntent);
      }
    }
    else if (("action_follow_status_finish".equals(paramContext)) && (String.valueOf(paramIntent.getStringExtra("uin")).equals(this.a.f)))
    {
      this.a.h = paramIntent.getBooleanExtra("isFollow", false);
      if (this.a.a != null)
      {
        if (this.a.h)
        {
          this.a.a.setText(HardCodeUtil.a(2131899497));
          this.a.a.setEnabled(false);
          this.a.a.setBackgroundResource(0);
          return;
        }
        this.a.a.setText(HardCodeUtil.a(2131899712));
        this.a.a.setEnabled(true);
        this.a.a.setBackgroundResource(2130848977);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment.4
 * JD-Core Version:    0.7.0.1
 */