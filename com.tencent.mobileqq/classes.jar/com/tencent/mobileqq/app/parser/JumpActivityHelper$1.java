package com.tencent.mobileqq.app.parser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;

final class JumpActivityHelper$1
  implements Runnable
{
  JumpActivityHelper$1(JumpActivity paramJumpActivity, Intent paramIntent, Bundle paramBundle) {}
  
  public void run()
  {
    JumpActivityHelper.e(this.a);
    String str = this.b.getType();
    Uri localUri = this.b.getData();
    Intent localIntent = new Intent();
    int i;
    if ((str != null) && (str.startsWith("image")))
    {
      i = 1;
    }
    else
    {
      this.c.putBoolean("not_forward", true);
      i = 0;
    }
    this.c.putParcelable("android.intent.extra.STREAM", localUri);
    localIntent.putExtras(this.c);
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_type", i);
    localIntent.putExtra("forward_from_jump", true);
    localIntent.setData(localUri);
    localIntent.putExtra("sendMultiple", false);
    RouteUtils.a(this.a, localIntent, "/base/forwardRecent");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpActivityHelper.1
 * JD-Core Version:    0.7.0.1
 */