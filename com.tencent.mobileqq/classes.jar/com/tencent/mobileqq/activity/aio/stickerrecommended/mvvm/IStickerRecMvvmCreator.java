package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IStickerRecMvvmCreator
  extends QRouteApi
{
  public abstract IStickerRecViewBinder createViewBinder(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, BaseAIOContext paramBaseAIOContext, IStickerRecViewModel paramIStickerRecViewModel);
  
  public abstract IStickerRecViewModel createViewModel(ViewModelStoreOwner paramViewModelStoreOwner);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecMvvmCreator
 * JD-Core Version:    0.7.0.1
 */