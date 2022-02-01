package com.sina.weibo.sdk.share;

import android.text.TextUtils;
import android.widget.FrameLayout;

final class ShareTransActivity$2
  implements b
{
  ShareTransActivity$2(ShareTransActivity paramShareTransActivity) {}
  
  public final void a(c paramc)
  {
    ShareTransActivity.b(this.E).setVisibility(4);
    if (paramc == null)
    {
      ShareTransActivity.a(this.E, "Trans result is null.");
      return;
    }
    if (paramc.F)
    {
      ShareTransActivity.a(this.E, paramc.G);
      return;
    }
    if (TextUtils.isEmpty(paramc.errorMessage))
    {
      ShareTransActivity.a(this.E, "Trans resource fail.");
      return;
    }
    ShareTransActivity.a(this.E, paramc.errorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.share.ShareTransActivity.2
 * JD-Core Version:    0.7.0.1
 */