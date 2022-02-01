package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.IFetchDataListener;
import com.tencent.mobileqq.widget.QQToast;

class WSVerticalItemBottomOperationController$1
  implements IFetchDataListener<Integer>
{
  WSVerticalItemBottomOperationController$1(WSVerticalItemBottomOperationController paramWSVerticalItemBottomOperationController, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString)
  {
    if (!this.a)
    {
      paramString = WSVerticalItemBottomOperationController.c(this.b).getResources().getString(1929838607);
      QQToast.makeText(WSVerticalItemBottomOperationController.d(this.b), 1, paramString, 0).show();
    }
  }
  
  public void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 1)
    {
      paramInteger = WSVerticalItemBottomOperationController.a(this.b).getResources().getString(1929838608);
      QQToast.makeText(WSVerticalItemBottomOperationController.b(this.b), 2, paramInteger, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomOperationController.1
 * JD-Core Version:    0.7.0.1
 */