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
    if (!this.jdField_a_of_type_Boolean)
    {
      paramString = WSVerticalItemBottomOperationController.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomOperationController).getResources().getString(1929707525);
      QQToast.a(WSVerticalItemBottomOperationController.d(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomOperationController), 1, paramString, 0).a();
    }
  }
  
  public void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 1)
    {
      paramInteger = WSVerticalItemBottomOperationController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomOperationController).getResources().getString(1929707526);
      QQToast.a(WSVerticalItemBottomOperationController.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemBottomOperationController), 2, paramInteger, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomOperationController.1
 * JD-Core Version:    0.7.0.1
 */