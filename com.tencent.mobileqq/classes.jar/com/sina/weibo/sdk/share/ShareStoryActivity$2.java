package com.sina.weibo.sdk.share;

import android.text.TextUtils;
import android.widget.FrameLayout;

final class ShareStoryActivity$2
  implements b
{
  ShareStoryActivity$2(ShareStoryActivity paramShareStoryActivity) {}
  
  public final void a(c paramc)
  {
    ShareStoryActivity.a(this.C).setVisibility(4);
    if (paramc == null)
    {
      ShareStoryActivity.b(this.C, "Trans result is null.");
      return;
    }
    if (paramc.F)
    {
      ShareStoryActivity.a(this.C, paramc.H);
      return;
    }
    if (TextUtils.isEmpty(paramc.errorMessage))
    {
      ShareStoryActivity.b(this.C, "Trans story fail.");
      return;
    }
    ShareStoryActivity.b(this.C, paramc.errorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.share.ShareStoryActivity.2
 * JD-Core Version:    0.7.0.1
 */