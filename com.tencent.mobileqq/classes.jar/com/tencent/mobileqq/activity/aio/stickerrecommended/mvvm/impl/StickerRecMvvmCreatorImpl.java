package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.impl;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecMvvmCreator;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecViewBinder;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecViewModel;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewBinder;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewModel;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewModelFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;

public class StickerRecMvvmCreatorImpl
  implements IStickerRecMvvmCreator
{
  public IStickerRecViewBinder createViewBinder(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, BaseAIOContext paramBaseAIOContext, IStickerRecViewModel paramIStickerRecViewModel)
  {
    return new StickerRecViewBinder(paramAppInterface, paramQBaseActivity, paramBaseAIOContext, paramIStickerRecViewModel);
  }
  
  public IStickerRecViewModel createViewModel(ViewModelStoreOwner paramViewModelStoreOwner)
  {
    return (IStickerRecViewModel)ViewModelProviderHelper.a(paramViewModelStoreOwner, new StickerRecViewModelFactory()).get(StickerRecViewModel.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.impl.StickerRecMvvmCreatorImpl
 * JD-Core Version:    0.7.0.1
 */