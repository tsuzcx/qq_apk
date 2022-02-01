package com.tencent.mobileqq.activity.shopping;

import com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter;
import com.tencent.biz.subscribe.part.block.MultiViewBlock.onLoadDataDelegate;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;

class ShoppingFragment$3
  implements MultiViewBlock.onLoadDataDelegate<RelativeFeedsAdapter>
{
  ShoppingFragment$3(ShoppingFragment paramShoppingFragment) {}
  
  public void a(LoadInfo paramLoadInfo, RelativeFeedsAdapter paramRelativeFeedsAdapter)
  {
    if (paramLoadInfo.e())
    {
      ShoppingFragment.a(this.a, paramRelativeFeedsAdapter);
      return;
    }
    if ((paramLoadInfo.d()) || (paramLoadInfo.c())) {
      ShoppingFragment.b(this.a, paramRelativeFeedsAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shopping.ShoppingFragment.3
 * JD-Core Version:    0.7.0.1
 */