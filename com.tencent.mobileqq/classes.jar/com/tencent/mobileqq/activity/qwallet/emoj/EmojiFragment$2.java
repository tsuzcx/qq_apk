package com.tencent.mobileqq.activity.qwallet.emoj;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qwallet.plugin.IQWalletPicHelper;

class EmojiFragment$2
  implements Runnable
{
  EmojiFragment$2(EmojiFragment paramEmojiFragment, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    ((IQWalletPicHelper)QRoute.api(IQWalletPicHelper.class)).decodeDrawable(this.val$imgItemDrawable2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiFragment.2
 * JD-Core Version:    0.7.0.1
 */